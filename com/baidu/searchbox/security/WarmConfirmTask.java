package com.baidu.searchbox.security;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.security.action.IWarmConfirmAction;
import com.baidu.searchbox.security.action.WarmConfirmActionComponent;
import java.util.List;
/* loaded from: classes4.dex */
public class WarmConfirmTask implements Runnable {
    public static final String TAG = "WarmConfirmTask";
    public Context mContext;

    public WarmConfirmTask(Context context) {
        this.mContext = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (AppConfig.isDebug()) {
            Log.d(TAG, Thread.currentThread().getName() + ", run() called");
        }
        List<IWarmConfirmAction> warmConfirmActionList = new WarmConfirmActionComponent().getWarmConfirmActionList();
        if (warmConfirmActionList != null) {
            for (int i = 0; i < warmConfirmActionList.size(); i++) {
                warmConfirmActionList.get(i).doAction(this.mContext);
            }
        }
    }
}
