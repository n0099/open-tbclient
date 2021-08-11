package com.baidu.fsg.base;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.fsg.base.restnet.beans.business.core.utils.BdWalletUtils;
import com.baidu.fsg.base.restnet.fp.GetFPResponse;
import com.baidu.fsg.base.utils.JsonUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import org.json.JSONException;
/* loaded from: classes5.dex */
public class InitDelayThread extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public InitDelayCallback mCallback;
    public WeakReference<Context> mContext;

    /* loaded from: classes5.dex */
    public interface InitDelayCallback extends NoProguard {
        void callBack();
    }

    public InitDelayThread(WeakReference<Context> weakReference, InitDelayCallback initDelayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {weakReference, initDelayCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCallback = initDelayCallback;
        this.mContext = weakReference;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.run();
            WeakReference<Context> weakReference = this.mContext;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            String rimAllConfig = BdWalletUtils.getRimAllConfig(this.mContext.get());
            long j2 = 0;
            if (!TextUtils.isEmpty(rimAllConfig)) {
                try {
                    GetFPResponse.RimConfig rimConfig = (GetFPResponse.RimConfig) JsonUtils.fromJson(rimAllConfig, GetFPResponse.RimConfig.class);
                    if (rimConfig != null && rimConfig.f39189common != null) {
                        try {
                            j2 = Long.parseLong(rimConfig.f39189common.init_delay);
                        } catch (NumberFormatException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            new Handler(Looper.myLooper()).postDelayed(new Runnable(this) { // from class: com.baidu.fsg.base.InitDelayThread.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ InitDelayThread f39076a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39076a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    InitDelayCallback initDelayCallback;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (initDelayCallback = this.f39076a.mCallback) == null) {
                        return;
                    }
                    initDelayCallback.callBack();
                }
            }, j2);
        }
    }
}
