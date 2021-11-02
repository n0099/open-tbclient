package com.baidu.mobads.container;

import android.content.Context;
import android.os.Build;
import android.webkit.WebView;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class XSafeWebView extends WebView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RemoteXAdLogger mAdLogger;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XSafeWebView(Context context, RemoteXAdLogger remoteXAdLogger) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, remoteXAdLogger};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        getSettings().setAllowContentAccess(false);
        getSettings().setSavePassword(false);
        getSettings().setAllowFileAccess(false);
        this.mAdLogger = remoteXAdLogger;
        removeJavascriptInterfaceForSafe();
    }

    private void removeJavascriptInterfaceForSafe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            try {
                if (Build.VERSION.SDK_INT < 11 || Build.VERSION.SDK_INT > 17) {
                    return;
                }
                Method declaredMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("removeJavascriptInterface", String.class);
                declaredMethod.invoke(this, "searchBoxJavaBridge_");
                declaredMethod.invoke(this, "accessibility");
                declaredMethod.invoke(this, "accessibilityTraversal");
            } catch (Exception unused) {
            }
        }
    }
}
