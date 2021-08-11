package com.baidu.searchbox.process.ipc.agent.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.TranslucentUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PluginDelegateActivity extends ProcessDelegateBaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String ENABLE_FALLBACK_FINISH_KEY = "fallback_finish_key";
    public static final boolean FALLBACK_FINISH_DEFAULT_VALUE = true;
    public static final String TAG = "PluginDelegateActivity";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mFallbackFinish;
    public int mResumeCount;

    public PluginDelegateActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mResumeCount = 0;
        this.mFallbackFinish = true;
    }

    @Override // com.baidu.searchbox.process.ipc.agent.activity.ProcessDelegateBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            if (Build.VERSION.SDK_INT == 26) {
                TranslucentUtils.convertFromTranslucent(this);
                setRequestedOrientation(this.mDelegation.getScreenOrientation());
                TranslucentUtils.convertToTranslucent(this);
            } else {
                setRequestedOrientation(this.mDelegation.getScreenOrientation());
            }
            if (this.mDelegation.mParams.isEmpty()) {
                return;
            }
            this.mFallbackFinish = this.mDelegation.mParams.getBoolean(ENABLE_FALLBACK_FINISH_KEY, true);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onResume();
            if (this.mFallbackFinish) {
                int i2 = this.mResumeCount + 1;
                this.mResumeCount = i2;
                if (i2 > 1) {
                    this.mDelegation.onSelfFinish();
                    exit(6, "");
                }
            }
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            if (this.mFallbackFinish) {
                this.mDelegation.onSelfFinish();
                exit(5, "by TouchEvent");
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }
}
