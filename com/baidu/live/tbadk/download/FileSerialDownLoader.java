package com.baidu.live.tbadk.download;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.BdFileHelper;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.Md5;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.FileHelper;
import com.baidu.live.tbadk.core.util.NetWork;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class FileSerialDownLoader {
    private static final int CMD_BET_MSG_RESULT = 18;
    private static final int CMD_NET_MSG_GETLENTH = 17;
    public static final int DOWNLOAD_PROCESS_AFTER_DOWNLOAD_OPEARTION_ERROR = 2;
    public static final int DOWNLOAD_PROCESS_CANCEL_STORAGE_OPT = 5;
    public static final int DOWNLOAD_PROCESS_FILE_CHECK_FAILED = 4;
    public static final int DOWNLOAD_PROCESS_FILE_CHECK_FILE_NO_FIND = 6;
    public static final int DOWNLOAD_PROCESS_FILE_COPY_ERROR = 7;
    public static final int DOWNLOAD_PROCESS_FILE_ERROR = 1;
    public static final int DOWNLOAD_PROCESS_NET_ERROR = 3;
    public static final int DOWNLOAD_PROCESS_SUCESS = 0;
    private static FileSerialDownLoader _instance = new FileSerialDownLoader();
    private static DownloadData mRun = null;
    private static List<DownloadData> mTaskList = Collections.synchronizedList(new LinkedList());
    private AsyFileDownLoadTask mTask = null;
    private int max = 20;
    @SuppressLint({"HandlerLeak"})
    private Handler mFileHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.live.tbadk.download.FileSerialDownLoader.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 17) {
                if (message.arg2 > 0 && FileSerialDownLoader.mRun != null) {
                    FileSerialDownLoader.mRun.setLength(message.arg1);
                    FileSerialDownLoader.mRun.setSize(message.arg2);
                    FileSerialDownLoader.mRun.setStatus(1);
                    if (FileSerialDownLoader.mRun.getCallback() != null) {
                        FileSerialDownLoader.mRun.getCallback().onFileUpdateProgress(FileSerialDownLoader.mRun);
                    }
                }
            } else if (message.what == 18) {
                FileSerialDownLoader.this.processDownloadResult(message.arg1, message.obj);
            }
        }
    };

    private FileSerialDownLoader() {
    }

    public static FileSerialDownLoader getInstance() {
        return _instance;
    }

    public void setMax(int i) {
        this.max = i;
    }

    public List<DownloadData> getTaskList() {
        return mTaskList;
    }

    public void startDownloadWithTypeMax(DownloadData downloadData, int i) {
        int i2;
        int type = downloadData.getType();
        int i3 = 0;
        Iterator<DownloadData> it = mTaskList.iterator();
        while (true) {
            i2 = i3;
            if (!it.hasNext()) {
                break;
            }
            i3 = it.next().getType() == type ? i2 + 1 : i2;
        }
        if (i2 >= i) {
            downloadData.setStatus(2);
            downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(a.i.sdk_download_fail_over_max));
            if (downloadData.getCallback() != null) {
                downloadData.getCallback().onFileUpdateProgress(downloadData);
                return;
            }
            return;
        }
        startDownLoadWithoutMax(downloadData);
    }

    public void startDownloadWithTotalMax(DownloadData downloadData) {
        if (mTaskList.size() >= this.max) {
            downloadData.setStatus(2);
            downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(a.i.sdk_download_fail_over_max));
            if (downloadData.getCallback() != null) {
                downloadData.getCallback().onFileUpdateProgress(downloadData);
                return;
            }
            return;
        }
        startDownLoadWithoutMax(downloadData);
    }

    public void startDownLoadWithoutMax(DownloadData downloadData) {
        if (downloadData != null) {
            if (!FileHelper.checkSD()) {
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(a.i.sdk_download_fail_no_sd));
                downloadData.setStatus(2);
            }
            if (downloadData.getStatus() == 2) {
                if (downloadData.getCallback() != null) {
                    downloadData.getCallback().onFileUpdateProgress(downloadData);
                    return;
                }
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < mTaskList.size()) {
                    try {
                        DownloadData downloadData2 = mTaskList.get(i2);
                        if (downloadData2 != null && downloadData2.getUrl() != null && downloadData.getUrl() != null && downloadData2.getUrl().equals(downloadData.getUrl()) && downloadData2.getId() != null && downloadData.getId() != null && downloadData2.getId().equals(downloadData.getId())) {
                            return;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    i = i2 + 1;
                } else {
                    downloadData.setStatus(5);
                    mTaskList.add(downloadData);
                    startQueue();
                    return;
                }
            }
        }
    }

    public void startDownLoadWithInsert(DownloadData downloadData) {
        if (downloadData != null) {
            if (!FileHelper.checkSD()) {
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(a.i.sdk_download_fail_no_sd));
                downloadData.setStatus(2);
            }
            if (downloadData.getStatus() == 2) {
                if (downloadData.getCallback() != null) {
                    downloadData.getCallback().onFileUpdateProgress(downloadData);
                    return;
                }
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < mTaskList.size()) {
                    try {
                        DownloadData downloadData2 = mTaskList.get(i2);
                        if (downloadData2 != null && downloadData2.getUrl() != null && downloadData.getUrl() != null && downloadData2.getUrl().equals(downloadData.getUrl()) && downloadData2.getId() != null && downloadData.getId() != null && downloadData2.getId().equals(downloadData.getId())) {
                            return;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    i = i2 + 1;
                } else {
                    downloadData.setStatus(5);
                    if (mTaskList.isEmpty()) {
                        mTaskList.add(downloadData);
                    } else {
                        mTaskList.add(1, downloadData);
                    }
                    startQueue();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startQueue() {
        if (mRun == null && !mTaskList.isEmpty()) {
            try {
                mRun = mTaskList.get(0);
                if (mRun != null) {
                    this.mTask = new AsyFileDownLoadTask();
                    this.mTask.execute(mRun);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void cancelDownLoadByUrl(String str) {
        cancelDownLoadByUrl(str, false);
    }

    public void cancelDownLoadByUrl(String str, boolean z) {
        if (mRun != null && mRun.getUrl().equals(str)) {
            if (this.mTask != null) {
                if (z) {
                    this.mTask.cancelImmediately();
                    return;
                } else {
                    this.mTask.cancel(true);
                    return;
                }
            }
            return;
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        Iterator<DownloadData> it = mTaskList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DownloadData next = it.next();
            if (next.getUrl().equals(str)) {
                next.setStatus(4);
                if (next.getCallback() != null) {
                    next.getCallback().onFileUpdateProgress(next);
                }
                linkedList.add(next);
            }
        }
        for (DownloadData downloadData : linkedList) {
            mTaskList.remove(downloadData);
        }
    }

    public void cancelDownLoadById(String str, int i) {
        if (mRun != null && mRun.getId().equals(str) && mRun.getType() == i) {
            if (this.mTask != null) {
                this.mTask.cancel(true);
                return;
            }
            return;
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        Iterator<DownloadData> it = mTaskList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DownloadData next = it.next();
            if (next.getId().equals(str) && next.getType() == i) {
                next.setStatus(4);
                next.setStatusMsg(null);
                if (next.getCallback() != null) {
                    next.getCallback().onFileUpdateProgress(next);
                }
                linkedList.add(next);
            }
        }
        for (DownloadData downloadData : linkedList) {
            mTaskList.remove(downloadData);
        }
    }

    public void cancelDownloadByType(int i) {
        cancelDownloadByType(i, true);
    }

    public void cancelDownloadByType(int i, boolean z) {
        LinkedList<DownloadData> linkedList = new LinkedList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= mTaskList.size()) {
                break;
            }
            try {
                DownloadData downloadData = mTaskList.get(i3);
                if (downloadData != null && downloadData.getType() == i) {
                    downloadData.setStatus(z ? 4 : 6);
                    downloadData.setStatusMsg(null);
                    if (downloadData.getCallback() != null) {
                        downloadData.getCallback().onFileUpdateProgress(downloadData);
                    }
                    if (z || !downloadData.isForceDownload()) {
                        linkedList.add(downloadData);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            i2 = i3 + 1;
        }
        for (DownloadData downloadData2 : linkedList) {
            mTaskList.remove(downloadData2);
        }
        if (mRun != null && mRun.getType() == i) {
            if ((!mRun.isForceDownload() || z) && this.mTask != null) {
                this.mTask.cancel(true);
            }
        }
    }

    public void cancleAllDownLoad() {
        if (mRun != null && this.mTask != null) {
            this.mTask.cancel(true);
        }
        mTaskList.clear();
    }

    public List<DownloadData> getDownloadList() {
        return mTaskList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDownloadResult(int i, Object obj) {
        String string;
        if (mRun != null) {
            if (i == 0) {
                mRun.setStatus(0);
                if (mRun.getCallback() != null) {
                    mRun.getCallback().onFileUpdateProgress(mRun);
                }
                if (mRun.getCallback() != null) {
                    mRun.getCallback().onFileDownloadSucceed(mRun);
                }
            } else if (i == 5) {
                mRun.setStatus(6);
                if (mRun.getCallback() != null) {
                    mRun.getCallback().onFileUpdateProgress(mRun);
                }
            } else {
                switch (i) {
                    case 1:
                        string = TbadkCoreApplication.getInst().getApp().getString(a.i.sdk_download_fail);
                        break;
                    case 2:
                        string = TbadkCoreApplication.getInst().getApp().getString(a.i.sdk_download_fail);
                        break;
                    case 3:
                        string = TbadkCoreApplication.getInst().getApp().getString(a.i.sdk_download_error);
                        break;
                    case 4:
                        string = TbadkCoreApplication.getInst().getApp().getString(a.i.sdk_download_fail);
                        break;
                    case 5:
                    default:
                        string = null;
                        break;
                    case 6:
                        string = TbadkCoreApplication.getInst().getApp().getString(a.i.sdk_download_fail);
                        break;
                    case 7:
                        string = TbadkCoreApplication.getInst().getApp().getString(a.i.sdk_download_fail);
                        break;
                }
                mRun.setStatusMsg(string);
                mRun.setErrorCode(i);
                mRun.setNetErrorJson(obj);
                mRun.setStatus(2);
                if (mRun.getCallback() != null) {
                    mRun.getCallback().onFileUpdateProgress(mRun);
                }
                if (mRun.getCallback() != null) {
                    mRun.getCallback().onFileDownloadFailed(mRun, i, string);
                }
            }
            mRun = null;
            if (!mTaskList.isEmpty()) {
                try {
                    mTaskList.remove(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                startQueue();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"DefaultLocale"})
    /* loaded from: classes4.dex */
    public class AsyFileDownLoadTask extends BdAsyncTask<DownloadData, Object, Object> {
        private NetWork mNetWork = new NetWork();

        AsyFileDownLoadTask() {
        }

        public void cancelImmediately() {
            if (this.mNetWork != null) {
                this.mNetWork.cancelNetConnect();
            }
            cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            this.mNetWork.cancelNetConnect();
            if (FileSerialDownLoader.mRun != null) {
                FileSerialDownLoader.mRun.setStatus(4);
                FileSerialDownLoader.mRun.setStatusMsg(null);
                if (FileSerialDownLoader.mRun.getCallback() != null) {
                    FileSerialDownLoader.mRun.getCallback().onFileUpdateProgress(FileSerialDownLoader.mRun);
                }
                if (!FileSerialDownLoader.mTaskList.isEmpty()) {
                    FileSerialDownLoader.mTaskList.remove(0);
                }
                DownloadData unused = FileSerialDownLoader.mRun = null;
                FileSerialDownLoader.this.startQueue();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public Integer doInBackground(final DownloadData... downloadDataArr) {
            JSONObject jSONObject;
            Boolean.valueOf(false);
            if (downloadDataArr[0] != null) {
                if (downloadDataArr[0].getCallback() != null && !downloadDataArr[0].getCallback().onPreDownload(downloadDataArr[0])) {
                    sendResultMsg(5);
                } else {
                    final File file = new File(downloadDataArr[0].getPath());
                    if (file.exists()) {
                        file.delete();
                    }
                    if (!file.exists()) {
                        if (TextUtils.isEmpty(downloadDataArr[0].getUrl())) {
                            try {
                                jSONObject = new JSONObject();
                            } catch (Exception e) {
                                e.printStackTrace();
                                jSONObject = null;
                            }
                            sendResultMsg(2, jSONObject);
                        } else {
                            this.mNetWork.setUrl(downloadDataArr[0].getUrl());
                            this.mNetWork.downloadFile(FileHelper.getCacheFilePath(downloadDataArr[0].getId() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + downloadDataArr[0].getName() + ".tmp"), FileSerialDownLoader.this.mFileHandler, 17, 3, new NetWork.DownloadResultCallback() { // from class: com.baidu.live.tbadk.download.FileSerialDownLoader.AsyFileDownLoadTask.1
                                /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [554=5, 556=4, 557=4, 558=4] */
                                /* JADX DEBUG: Failed to insert an additional move for type inference into block B:55:0x0141 */
                                /* JADX DEBUG: Failed to insert an additional move for type inference into block B:57:0x0143 */
                                /* JADX DEBUG: Failed to insert an additional move for type inference into block B:61:? */
                                /* JADX WARN: Multi-variable type inference failed */
                                /* JADX WARN: Removed duplicated region for block: B:65:0x012d A[EXC_TOP_SPLITTER, SYNTHETIC] */
                                /* JADX WARN: Type inference failed for: r1v12 */
                                /* JADX WARN: Type inference failed for: r1v17 */
                                /* JADX WARN: Type inference failed for: r1v18, types: [java.io.FileInputStream] */
                                /* JADX WARN: Type inference failed for: r1v21 */
                                /* JADX WARN: Type inference failed for: r1v22 */
                                /* JADX WARN: Type inference failed for: r1v23 */
                                /* JADX WARN: Type inference failed for: r1v24 */
                                /* JADX WARN: Type inference failed for: r1v25, types: [java.io.FileInputStream] */
                                /* JADX WARN: Type inference failed for: r1v26, types: [java.io.FileInputStream, java.io.InputStream] */
                                /* JADX WARN: Type inference failed for: r1v31 */
                                /* JADX WARN: Type inference failed for: r1v32 */
                                /* JADX WARN: Type inference failed for: r1v33 */
                                /* JADX WARN: Type inference failed for: r1v34 */
                                /* JADX WARN: Type inference failed for: r1v35 */
                                /* JADX WARN: Type inference failed for: r1v36 */
                                /* JADX WARN: Type inference failed for: r1v37 */
                                @Override // com.baidu.live.tbadk.core.util.NetWork.DownloadResultCallback
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public void onSuccess() {
                                    String str;
                                    Throwable th;
                                    ?? r1;
                                    boolean equalsIgnoreCase;
                                    File GetFileInCache = FileHelper.GetFileInCache(downloadDataArr[0].getId() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + downloadDataArr[0].getName() + ".tmp");
                                    if (GetFileInCache == null) {
                                        AsyFileDownLoadTask.this.sendResultMsg(1);
                                        return;
                                    }
                                    try {
                                        String parent = GetFileInCache.getParent();
                                        String parent2 = file.getParent();
                                        File file2 = new File(parent2);
                                        if (!file2.exists()) {
                                            file2.mkdirs();
                                        }
                                        if (parent.equals(parent2)) {
                                            String name = file.getName();
                                            GetFileInCache.renameTo(new File(parent2, name));
                                            str = name;
                                        } else {
                                            File file3 = file;
                                            BdFileHelper.copyFile(GetFileInCache, file3);
                                            BdFileHelper.deleteQuietly(GetFileInCache);
                                            str = file3;
                                        }
                                        DownloadData downloadData = str;
                                        if (!StringHelper.isEmpty(downloadDataArr[0].getCheck())) {
                                            try {
                                                try {
                                                    r1 = new FileInputStream(downloadDataArr[0].getPath());
                                                    try {
                                                        equalsIgnoreCase = Md5.toMd5((InputStream) r1).equalsIgnoreCase(downloadDataArr[0].getCheck());
                                                        downloadData = r1;
                                                    } catch (FileNotFoundException e2) {
                                                        e = e2;
                                                        BdLog.d(e.getMessage());
                                                        AsyFileDownLoadTask.this.sendResultMsg(6);
                                                        str = r1;
                                                        if (r1 != 0) {
                                                            try {
                                                                r1.close();
                                                                str = r1;
                                                            } catch (IOException e3) {
                                                                BdLog.d(e3.getMessage());
                                                                str = r1;
                                                            }
                                                        }
                                                    }
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    if (str != 0) {
                                                        try {
                                                            str.close();
                                                        } catch (IOException e4) {
                                                            BdLog.d(e4.getMessage());
                                                        }
                                                    }
                                                    throw th;
                                                }
                                            } catch (FileNotFoundException e5) {
                                                e = e5;
                                                r1 = 0;
                                            } catch (Throwable th3) {
                                                th = th3;
                                                str = 0;
                                                if (str != 0) {
                                                }
                                                throw th;
                                            }
                                            if (!equalsIgnoreCase) {
                                                BdFileHelper.deleteQuietly(new File(downloadDataArr[0].getPath()));
                                                AsyFileDownLoadTask.this.sendResultMsg(4);
                                                str = r1;
                                                if (r1 != 0) {
                                                    try {
                                                        r1.close();
                                                        str = r1;
                                                    } catch (IOException e6) {
                                                        BdLog.d(e6.getMessage());
                                                        str = r1;
                                                    }
                                                }
                                            } else if (r1 != 0) {
                                                try {
                                                    r1.close();
                                                    downloadData = r1;
                                                } catch (IOException e7) {
                                                    BdLog.d(e7.getMessage());
                                                    downloadData = r1;
                                                }
                                            }
                                        }
                                        DownloadData downloadData2 = downloadData;
                                        if (downloadDataArr[0].getCallback() != null) {
                                            FileDownloadCallBack callback = downloadDataArr[0].getCallback();
                                            DownloadData downloadData3 = downloadDataArr[0];
                                            boolean onFileDownloaded = callback.onFileDownloaded(downloadData3);
                                            downloadData2 = downloadData3;
                                            if (!onFileDownloaded) {
                                                str = 2;
                                                AsyFileDownLoadTask.this.sendResultMsg(2);
                                            }
                                        }
                                        AsyFileDownLoadTask.this.sendResultMsg(0);
                                        str = downloadData2;
                                    } catch (IOException e8) {
                                        try {
                                            BdFileHelper.deleteQuietly(file);
                                        } catch (Exception e9) {
                                            e9.printStackTrace();
                                        }
                                        AsyFileDownLoadTask.this.sendResultMsg(7);
                                    }
                                }

                                @Override // com.baidu.live.tbadk.core.util.NetWork.DownloadResultCallback
                                public void onFail(int i, String str) {
                                    JSONObject jSONObject2;
                                    Exception e2;
                                    try {
                                        jSONObject2 = new JSONObject();
                                    } catch (Exception e3) {
                                        jSONObject2 = null;
                                        e2 = e3;
                                    }
                                    try {
                                        jSONObject2.put("err_code", i);
                                        jSONObject2.put("exception", str);
                                    } catch (Exception e4) {
                                        e2 = e4;
                                        e2.printStackTrace();
                                        AsyFileDownLoadTask.this.sendResultMsg(3, jSONObject2);
                                    }
                                    AsyFileDownLoadTask.this.sendResultMsg(3, jSONObject2);
                                }
                            });
                        }
                    }
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sendResultMsg(int i) {
            FileSerialDownLoader.this.mFileHandler.sendMessage(Message.obtain(FileSerialDownLoader.this.mFileHandler, 18, i, 0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sendResultMsg(int i, Object obj) {
            Message obtain = Message.obtain(FileSerialDownLoader.this.mFileHandler, 18, i, 0);
            obtain.obj = obj;
            FileSerialDownLoader.this.mFileHandler.sendMessage(obtain);
        }
    }
}
