package com.baidu.ala.alastatuploader;

import com.baidu.ala.alastatuploader.model.AlaStatUploadMessage;
import com.baidu.ala.alastatuploader.model.AlaStatUploadModel;
import com.baidu.ala.alastatuploader.model.AlaStatUploadResponseMessage;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.stats.AlaStatsItem;
import com.baidu.live.adp.lib.stats.IAlaStatUploader;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes11.dex */
public class AlaStatUploaderManager implements IAlaStatUploader {
    private static volatile AlaStatUploaderManager inst = null;
    static int MAX_LENGTH_WAIT_LIST = 200;
    static int MAX_UPLOAD_LENGTH_WAIT_LIST = 10;
    private LinkedList<AlaUploadStatItem> waitList = new LinkedList<>();
    private LinkedList<AlaUploadStatItem> uploadingList = new LinkedList<>();
    private AlaStatUploadModel uploadModel = new AlaStatUploadModel();
    private int failRetryCount = 0;
    private Object lock = new Object();
    private Runnable runnable = new Runnable() { // from class: com.baidu.ala.alastatuploader.AlaStatUploaderManager.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (AlaStatUploaderManager.this.lock) {
                if (AlaStatUploaderManager.this.uploadingList.size() > 0) {
                    LinkedList linkedList = new LinkedList();
                    LinkedList linkedList2 = AlaStatUploaderManager.this.uploadingList;
                    AlaStatUploaderManager.this.uploadingList = linkedList;
                    if (!AlaStatUploaderManager.this.uploadModel.upload(linkedList2)) {
                        AlaStatUploaderManager.this.uploadFail(linkedList2);
                    }
                }
            }
        }
    };
    private HttpMessageListener messageListener = new HttpMessageListener(1021185) { // from class: com.baidu.ala.alastatuploader.AlaStatUploaderManager.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaStatUploadResponseMessage) {
                AlaStatUploadResponseMessage alaStatUploadResponseMessage = (AlaStatUploadResponseMessage) httpResponsedMessage;
                if (alaStatUploadResponseMessage.isSuccess()) {
                    AlaStatUploaderManager.this.failRetryCount = 0;
                } else if (alaStatUploadResponseMessage.getOrginalMessage() instanceof AlaStatUploadMessage) {
                    AlaStatUploadMessage alaStatUploadMessage = (AlaStatUploadMessage) alaStatUploadResponseMessage.getOrginalMessage();
                    if (alaStatUploadMessage.list != null) {
                        synchronized (AlaStatUploaderManager.this.lock) {
                            AlaStatUploaderManager.this.uploadFail(alaStatUploadMessage.list);
                        }
                    }
                }
            }
        }
    };

    public static AlaStatUploaderManager getInstance() {
        if (inst == null) {
            synchronized (AlaStatUploaderManager.class) {
                if (inst == null) {
                    inst = new AlaStatUploaderManager();
                }
            }
        }
        return inst;
    }

    private AlaStatUploaderManager() {
        MessageManager.getInstance().registerListener(this.messageListener);
    }

    @Override // com.baidu.live.adp.lib.stats.IAlaStatUploader
    public void addLog(String str, String str2, long j, String str3, AlaStatsItem alaStatsItem) {
        if (AlaStatSwitchManager.getInstance().isSwithcOpen(str, str2)) {
            if (alaStatsItem != null) {
                alaStatsItem.logID = j;
            }
            AlaUploadStatItem generate = AlaUploadStatItem.generate();
            generate.statsItem = alaStatsItem;
            cacheLog(generate);
        }
    }

    @Override // com.baidu.live.adp.lib.stats.IAlaStatUploader
    public void forceUpload() {
        synchronized (this.lock) {
            if (this.waitList.size() > 0) {
                LinkedList<AlaUploadStatItem> linkedList = new LinkedList<>();
                LinkedList<AlaUploadStatItem> linkedList2 = this.waitList;
                this.waitList = linkedList;
                if (this.uploadingList.size() > 0) {
                    this.uploadingList.addAll(linkedList2);
                } else {
                    this.uploadingList = linkedList2;
                }
            }
        }
        SafeHandler.getInst().post(this.runnable);
    }

    private void cacheLog(AlaUploadStatItem alaUploadStatItem) {
        synchronized (this.lock) {
            this.waitList.add(alaUploadStatItem);
            if (this.waitList.size() > MAX_UPLOAD_LENGTH_WAIT_LIST) {
                LinkedList linkedList = new LinkedList();
                while (linkedList.size() < MAX_UPLOAD_LENGTH_WAIT_LIST) {
                    AlaUploadStatItem removeFirst = this.waitList.removeFirst();
                    if (removeFirst != null) {
                        linkedList.add(removeFirst);
                    }
                }
                this.uploadingList.addAll(linkedList);
            }
            if (this.waitList.size() > MAX_LENGTH_WAIT_LIST) {
                while (this.waitList.size() > MAX_LENGTH_WAIT_LIST * 0.7d) {
                    this.waitList.removeFirst();
                }
            }
        }
        tryUpload();
    }

    private void tryUpload() {
        if (this.uploadingList.size() > 0) {
            SafeHandler.getInst().post(this.runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadFail(List<AlaUploadStatItem> list) {
        this.failRetryCount++;
        if (this.failRetryCount <= 3) {
            this.uploadingList.addAll(0, list);
            SafeHandler.getInst().postDelayed(this.runnable, 30000L);
        }
    }
}
