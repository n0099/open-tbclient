package com.baidu.fsg.base;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.fsg.base.restnet.beans.business.core.utils.BdWalletUtils;
import com.baidu.fsg.base.restnet.fp.GetFPResponse;
import com.baidu.fsg.base.utils.JsonUtils;
import java.lang.ref.WeakReference;
import org.json.JSONException;
/* loaded from: classes2.dex */
public class InitDelayThread extends Thread {
    public InitDelayCallback mCallback;
    public WeakReference<Context> mContext;

    /* loaded from: classes2.dex */
    public interface InitDelayCallback extends NoProguard {
        void callBack();
    }

    public InitDelayThread(WeakReference<Context> weakReference, InitDelayCallback initDelayCallback) {
        this.mCallback = initDelayCallback;
        this.mContext = weakReference;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        WeakReference<Context> weakReference = this.mContext;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        String rimAllConfig = BdWalletUtils.getRimAllConfig(this.mContext.get());
        long j = 0;
        if (!TextUtils.isEmpty(rimAllConfig)) {
            try {
                GetFPResponse.RimConfig rimConfig = (GetFPResponse.RimConfig) JsonUtils.fromJson(rimAllConfig, GetFPResponse.RimConfig.class);
                if (rimConfig != null && rimConfig.f5177common != null) {
                    try {
                        j = Long.parseLong(rimConfig.f5177common.init_delay);
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        new Handler(Looper.myLooper()).postDelayed(new b(this), j);
    }
}
