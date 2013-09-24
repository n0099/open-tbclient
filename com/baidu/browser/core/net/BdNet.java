package com.baidu.browser.core.net;

import com.baidu.browser.core.net.BdNetEngine;
import com.baidu.browser.core.util.BdLog;
import java.util.Iterator;
import java.util.Vector;
/* loaded from: classes.dex */
public class BdNet implements BdNetEngine.BdNetEngineListener {
    public static final int CORE_POOL_SIZE = 2;
    private static final boolean DEBUG = false;
    public static final int MAX_POOL_SIZE = 3;
    public static final int PRIORITY_HIGHER = 0;
    public static final int PRIORITY_IDLE = 3;
    public static final int PRIORITY_LOWER = 2;
    public static final int PRIORITY_NORMAL = 1;
    private BdNetListener mListener;
    private int mPriority = 1;
    private int mPoolSize = 2;
    private Vector<BdNetTask> mTaskList = new Vector<>();
    private Vector<BdNetWorker> mWorkerList = new Vector<>();

    /* loaded from: classes.dex */
    public enum HttpMethod {
        METHOD_GET,
        METHOD_POST,
        METHOD_RESUME;

        /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static HttpMethod[] valuesCustom() {
            HttpMethod[] valuesCustom = values();
            int length = valuesCustom.length;
            HttpMethod[] httpMethodArr = new HttpMethod[length];
            System.arraycopy(valuesCustom, 0, httpMethodArr, 0, length);
            return httpMethodArr;
        }
    }

    /* loaded from: classes.dex */
    public enum NetError {
        ERROR_RUN_EXCEPTION,
        ERROR_RUN_STOP,
        ERROR_HTTP,
        ERROR_REDIRECT,
        ERROR_MALFORMEDURL,
        ERROR_CONNECT_TIMEOUT,
        ERROR_IO,
        ERROR_UNKNOWN;

        /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static NetError[] valuesCustom() {
            NetError[] valuesCustom = values();
            int length = valuesCustom.length;
            NetError[] netErrorArr = new NetError[length];
            System.arraycopy(valuesCustom, 0, netErrorArr, 0, length);
            return netErrorArr;
        }
    }

    /* loaded from: classes.dex */
    public enum NetState {
        STATE_CONNECT_START,
        STATE_CONNECT_SETUP,
        STATE_DISCONNECT,
        STATE_UNKNOWN;

        /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static NetState[] valuesCustom() {
            NetState[] valuesCustom = values();
            int length = valuesCustom.length;
            NetState[] netStateArr = new NetState[length];
            System.arraycopy(valuesCustom, 0, netStateArr, 0, length);
            return netStateArr;
        }
    }

    public BdNetTask obtainTask() {
        return BdNetTask.obtain(this);
    }

    public BdNetTask obtainTask(String str) {
        return BdNetTask.obtain(this, str);
    }

    public void setEventListener(BdNetListener bdNetListener) {
        this.mListener = bdNetListener;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public void setPriority(int i) {
        if (i >= 0 && i <= 3) {
            this.mPriority = i;
        }
    }

    public void setPoolSize(int i) {
        if (i > 0 && i <= 3) {
            this.mPoolSize = i;
        }
    }

    public BdNetTask peekTask() {
        if (this.mTaskList.size() > 0) {
            return this.mTaskList.get(0);
        }
        return null;
    }

    public BdNetTask pollTask() {
        if (this.mTaskList.size() > 0) {
            return this.mTaskList.remove(0);
        }
        return null;
    }

    public void start(BdNetTask bdNetTask) {
        if (bdNetTask == null) {
            BdLog.w("start NullPointer NetTask");
            return;
        }
        Iterator<BdNetWorker> it = this.mWorkerList.iterator();
        while (it.hasNext()) {
            BdNetWorker next = it.next();
            if (!next.isWorking()) {
                next.start(bdNetTask);
                return;
            }
        }
        if (this.mWorkerList.size() < this.mPoolSize) {
            BdNetWorker bdNetWorker = new BdNetWorker(this);
            this.mWorkerList.add(bdNetWorker);
            bdNetWorker.start(bdNetTask);
            return;
        }
        this.mTaskList.add(bdNetTask);
    }

    private BdNetTask startNext(BdNetEngine bdNetEngine, BdNetTask bdNetTask) {
        BdNetTask pollTask = pollTask();
        BdNetTask pollTask2 = BdNetManager.getInstance().pollTask();
        BdNetWorker worker = bdNetTask.getWorker();
        if (pollTask2 != null) {
            if (pollTask != null) {
                worker.start(pollTask);
            } else {
                worker.stop();
                if (this.mListener != null && isComplete()) {
                    this.mListener.onNetDownloadComplete(this);
                }
            }
            pollTask2.getWorker().setNetEngine(bdNetEngine);
            return pollTask2;
        } else if (pollTask != null) {
            worker.setTask(pollTask);
            worker.setNetEngine(bdNetEngine);
            pollTask.setWorker(worker);
            return pollTask;
        } else {
            worker.stop();
            if (this.mListener != null && isComplete()) {
                this.mListener.onNetDownloadComplete(this);
            }
            return null;
        }
    }

    public void stop() {
        Iterator<BdNetWorker> it = this.mWorkerList.iterator();
        while (it.hasNext()) {
            it.next().stop();
        }
        this.mTaskList.clear();
    }

    private boolean isComplete() {
        int size = this.mWorkerList.size();
        for (int i = 0; i < size; i++) {
            if (this.mWorkerList.get(i).isWorking()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.browser.core.net.BdNetEngine.BdNetEngineListener
    public void onNetDownloadStart(BdNetEngine bdNetEngine, BdNetTask bdNetTask) {
        if (this.mListener != null) {
            this.mListener.onNetTaskStart(this, bdNetTask);
        }
    }

    @Override // com.baidu.browser.core.net.BdNetEngine.BdNetEngineListener
    public void onNetStateChanged(BdNetEngine bdNetEngine, BdNetTask bdNetTask, NetState netState, int i) {
        if (this.mListener != null) {
            this.mListener.onNetStateChanged(this, bdNetTask, netState, i);
        }
    }

    @Override // com.baidu.browser.core.net.BdNetEngine.BdNetEngineListener
    public void onNetUploadData(BdNetEngine bdNetEngine, BdNetTask bdNetTask, int i, int i2) {
        if (this.mListener != null) {
            this.mListener.onNetUploadData(this, bdNetTask, i, i2);
        }
    }

    @Override // com.baidu.browser.core.net.BdNetEngine.BdNetEngineListener
    public void onNetUploadComplete(BdNetEngine bdNetEngine, BdNetTask bdNetTask) {
        if (this.mListener != null) {
            this.mListener.onNetUploadComplete(this, bdNetTask);
        }
    }

    @Override // com.baidu.browser.core.net.BdNetEngine.BdNetEngineListener
    public void onNetResponseCode(BdNetEngine bdNetEngine, BdNetTask bdNetTask, int i) {
        if (this.mListener != null) {
            this.mListener.onNetResponseCode(this, bdNetTask, i);
        }
    }

    @Override // com.baidu.browser.core.net.BdNetEngine.BdNetEngineListener
    public void onNetReceiveHeaders(BdNetEngine bdNetEngine, BdNetTask bdNetTask) {
        if (this.mListener != null) {
            this.mListener.onNetReceiveHeaders(this, bdNetTask);
        }
    }

    @Override // com.baidu.browser.core.net.BdNetEngine.BdNetEngineListener
    public void onNetReceiveData(BdNetEngine bdNetEngine, BdNetTask bdNetTask, byte[] bArr, int i) {
        if (this.mListener != null) {
            this.mListener.onNetReceiveData(this, bdNetTask, bArr, i);
        }
    }

    @Override // com.baidu.browser.core.net.BdNetEngine.BdNetEngineListener
    public boolean onNetRedirect(BdNetEngine bdNetEngine, BdNetTask bdNetTask, int i) {
        if (this.mListener != null) {
            return this.mListener.onNetRedirect(this, bdNetTask, i);
        }
        return true;
    }

    @Override // com.baidu.browser.core.net.BdNetEngine.BdNetEngineListener
    public void onNetDownloadError(BdNetEngine bdNetEngine, BdNetTask bdNetTask, NetError netError, int i) {
        if (this.mListener != null) {
            this.mListener.onNetDownloadError(this, bdNetTask, netError, i);
        }
    }

    @Override // com.baidu.browser.core.net.BdNetEngine.BdNetEngineListener
    public BdNetTask onNetDownloadComplete(BdNetEngine bdNetEngine, BdNetTask bdNetTask, boolean z) {
        if (z && this.mListener != null) {
            this.mListener.onNetTaskComplete(this, bdNetTask);
        }
        BdNetTask startNext = startNext(bdNetEngine, bdNetTask);
        bdNetTask.recycle();
        return startNext;
    }
}
