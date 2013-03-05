package com.baidu.browser.core.net;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import com.baidu.browser.core.IElement;
import com.baidu.browser.core.util.BdLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
/* loaded from: classes.dex */
public final class BdNetManager implements IElement {
    public static final int[] ARRAY_PRIORITY = {0, 1, 2, 3};
    public static final int MAX_POOL_SIZE = 6;
    private static BdNetManager sInstance;
    private Activity mActivity;
    private Vector mNetEngineList;
    private BdNetReceiver mNetReceiver;
    private List mTaskList;

    private BdNetManager() {
        int length = ARRAY_PRIORITY.length;
        this.mTaskList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            this.mTaskList.add(new Vector());
        }
        this.mNetEngineList = new Vector();
    }

    public static BdNetManager getInstance() {
        if (sInstance == null) {
            sInstance = new BdNetManager();
        }
        return sInstance;
    }

    private static void destory() {
        sInstance = null;
    }

    public void onInit(Activity activity) {
        this.mActivity = activity;
        this.mNetReceiver = new BdNetReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.mActivity.registerReceiver(this.mNetReceiver, intentFilter);
        this.mNetReceiver.checkApnType(this.mActivity);
    }

    @Override // com.baidu.browser.core.IElement
    public void onInit(Context context) {
    }

    @Override // com.baidu.browser.core.IElement
    public void onSave(Context context) {
    }

    @Override // com.baidu.browser.core.IElement
    public void onLoad(Context context) {
    }

    @Override // com.baidu.browser.core.IElement
    public void onDestroy() {
        releaseAllTask();
        releaseAllNetEngine();
        if (this.mActivity != null && this.mNetReceiver != null) {
            this.mActivity.unregisterReceiver(this.mNetReceiver);
        }
        destory();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addTask(BdNetTask bdNetTask, int i) {
        if (bdNetTask != null) {
            int length = ARRAY_PRIORITY.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (i == ARRAY_PRIORITY[i2]) {
                    ((Vector) this.mTaskList.get(i2)).add(bdNetTask);
                    return;
                }
            }
        }
    }

    BdNetTask peekTask() {
        int size = this.mTaskList.size();
        for (int i = 0; i < size; i++) {
            Vector vector = (Vector) this.mTaskList.get(i);
            if (vector.size() > 0) {
                return (BdNetTask) vector.get(0);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BdNetTask pollTask() {
        int size = this.mTaskList.size();
        for (int i = 0; i < size; i++) {
            Vector vector = (Vector) this.mTaskList.get(i);
            if (vector.size() > 0) {
                return (BdNetTask) vector.remove(0);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BdNetEngine obtainNetEngine() {
        int size = this.mNetEngineList.size();
        for (int i = 0; i < size; i++) {
            BdNetEngine bdNetEngine = (BdNetEngine) this.mNetEngineList.get(i);
            if (!bdNetEngine.isWorking() && !bdNetEngine.isAllocate()) {
                bdNetEngine.allocate();
                return bdNetEngine;
            }
        }
        if (size < 6) {
            BdNetEngine bdNetEngine2 = new BdNetEngine();
            bdNetEngine2.setCmwap(this.mNetReceiver.isCmwap());
            bdNetEngine2.setWapApnUrl(this.mNetReceiver.getWapApnUrl());
            bdNetEngine2.allocate();
            this.mNetEngineList.add(bdNetEngine2);
            return bdNetEngine2;
        }
        return null;
    }

    public void releaseAllTask() {
        this.mTaskList.clear();
    }

    public void releaseAllNetEngine() {
        int size = this.mNetEngineList.size();
        for (int i = 0; i < size; i++) {
            ((BdNetEngine) this.mNetEngineList.get(i)).stopDownload();
        }
        this.mNetEngineList.clear();
    }

    public void printAllNetEngineState() {
        BdNetEngine bdNetEngine;
        int size = this.mNetEngineList.size();
        for (int i = 0; i < size; i++) {
            BdLog.d("NetEngine [" + ((BdNetEngine) this.mNetEngineList.get(i)) + "]  isWorking[" + bdNetEngine.isWorking() + "] isAllocate[" + bdNetEngine.isAllocate() + "]");
        }
    }
}
