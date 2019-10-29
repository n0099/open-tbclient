package com.baidu.ala.notify;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class AlaLiveUserNotifyManager {
    private static AlaLiveUserNotifyManager mInstance;
    private ArrayList<AlaLiveUserNotifyData> dataList;
    private ArrayList<AlaLiveNotifyListener> listeners;
    private BdUniqueId mCurTag;
    private HttpMessageListener mGetUserNotifyListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_USER_NOTIFY) { // from class: com.baidu.ala.notify.AlaLiveUserNotifyManager.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof AlaLiveGetUserNotifyResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaLiveUserNotifyManager.this.mCurTag) {
                AlaLiveGetUserNotifyResponsedMessage alaLiveGetUserNotifyResponsedMessage = (AlaLiveGetUserNotifyResponsedMessage) httpResponsedMessage;
                if (v.getCount(alaLiveGetUserNotifyResponsedMessage.getDataList()) > 0) {
                    if (AlaLiveUserNotifyManager.this.dataList == null) {
                        AlaLiveUserNotifyManager.this.dataList = new ArrayList();
                    }
                    AlaLiveUserNotifyManager.this.dataList.addAll(alaLiveGetUserNotifyResponsedMessage.getDataList());
                    AlaLiveUserNotifyManager.this.notifyMsg();
                } else if (!v.isEmpty(AlaLiveUserNotifyManager.this.dataList)) {
                    AlaLiveUserNotifyManager.this.notifyMsg();
                }
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface AlaLiveNotifyListener {
        void onCallBack();
    }

    public static AlaLiveUserNotifyManager getInstance() {
        if (mInstance == null) {
            synchronized (AlaLiveUserNotifyManager.class) {
                if (mInstance == null) {
                    mInstance = new AlaLiveUserNotifyManager();
                }
            }
        }
        return mInstance;
    }

    private AlaLiveUserNotifyManager() {
        registerGetUserNotifyTask();
        this.mCurTag = BdUniqueId.gen();
        MessageManager.getInstance().registerListener(this.mGetUserNotifyListener);
    }

    private static void registerGetUserNotifyTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_GET_USER_NOTIFY, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_GET_USER_NOTIFY_URL);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaLiveGetUserNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void sendGetUserNotifyRequest() {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_USER_NOTIFY);
        httpMessage.addParam("num", 10);
        httpMessage.setTag(this.mCurTag);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void addNotifyListener(AlaLiveNotifyListener alaLiveNotifyListener) {
        if (this.listeners == null) {
            this.listeners = new ArrayList<>();
        }
        if (!this.listeners.contains(alaLiveNotifyListener)) {
            this.listeners.add(alaLiveNotifyListener);
        }
    }

    public void removeNotifyListener(AlaLiveNotifyListener alaLiveNotifyListener) {
        if (this.listeners != null) {
            this.listeners.remove(alaLiveNotifyListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyMsg() {
        if (!v.isEmpty(this.listeners)) {
            Iterator<AlaLiveNotifyListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                AlaLiveNotifyListener next = it.next();
                if (next != null) {
                    next.onCallBack();
                }
            }
        }
    }

    public ArrayList<AlaLiveUserNotifyData> getNotifyDataList() {
        ArrayList<AlaLiveUserNotifyData> arrayList = new ArrayList<>(this.dataList);
        this.dataList.clear();
        return arrayList;
    }
}
