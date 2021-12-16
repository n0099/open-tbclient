package com.baidu.tbadk.browser;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes11.dex */
public class WebViewBroadcastReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_CLOSE_WEBVIEW = "action_close_webview";
    public static final String BROADCAST_PERMISSION_CLOSE_WEBVIEW = "com.baidu.live.sdk.permission.DETAIL_BROADCAST";
    public static final String INTENT_LOCALE_RECEV_CLOSE = "recClose";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mReceiverTag;
    public WeakReference<Activity> reference;

    public WebViewBroadcastReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private Activity getRef() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            WeakReference<Activity> weakReference = this.reference;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
            Activity ref = getRef();
            if (intent == null || ref == null || !TextUtils.equals(ACTION_CLOSE_WEBVIEW, intent.getAction()) || ref == null) {
                return;
            }
            try {
                ref.finish();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void register(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) || activity == null) {
            return;
        }
        this.reference = new WeakReference<>(activity);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_CLOSE_WEBVIEW);
        try {
            activity.registerReceiver(this, intentFilter, BROADCAST_PERMISSION_CLOSE_WEBVIEW, null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.mReceiverTag = true;
    }

    public void unregister() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Activity ref = getRef();
            if (ref != null && this.mReceiverTag) {
                try {
                    ref.unregisterReceiver(this);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.mReceiverTag = false;
        }
    }
}
