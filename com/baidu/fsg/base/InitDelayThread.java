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
/* loaded from: classes3.dex */
public class InitDelayThread extends Thread {
    InitDelayCallback mCallback;
    WeakReference<Context> mContext;

    /* loaded from: classes3.dex */
    public interface InitDelayCallback extends NoProguard {
        void callBack();
    }

    public InitDelayThread(WeakReference<Context> weakReference, InitDelayCallback initDelayCallback) {
        this.mCallback = initDelayCallback;
        this.mContext = weakReference;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        long j;
        super.run();
        if (this.mContext != null && this.mContext.get() != null) {
            String rimAllConfig = BdWalletUtils.getRimAllConfig(this.mContext.get());
            long j2 = 0;
            if (!TextUtils.isEmpty(rimAllConfig)) {
                try {
                    GetFPResponse.RimConfig rimConfig = (GetFPResponse.RimConfig) JsonUtils.fromJson(rimAllConfig, GetFPResponse.RimConfig.class);
                    if (rimConfig != null && rimConfig.common != null) {
                        try {
                            j = Long.parseLong(rimConfig.common.init_delay);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                        j2 = j;
                    }
                    j = 0;
                    j2 = j;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            new Handler(Looper.myLooper()).postDelayed(new b(this), j2);
        }
    }
}
