package com.baidu.swan.games.view.webview;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.e34;
import com.repackage.rf1;
@Keep
/* loaded from: classes2.dex */
public class GameWebViewJavascriptInterface {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String JAVASCRIPT_INTERFACE_NAME = "swan";
    public static final String TAG = "GameJavascriptInterface";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(621753652, "Lcom/baidu/swan/games/view/webview/GameWebViewJavascriptInterface;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(621753652, "Lcom/baidu/swan/games/view/webview/GameWebViewJavascriptInterface;");
                return;
            }
        }
        DEBUG = rf1.a;
    }

    public GameWebViewJavascriptInterface() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @JavascriptInterface
    public void closeGameWebView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (DEBUG) {
                Log.i(TAG, "closeGameWebView");
            }
            e34 F = e34.F();
            if (F != null) {
                F.close();
            }
        }
    }

    @JavascriptInterface
    public void onGameLoadingFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (DEBUG) {
                Log.i(TAG, "onGameLoadingFinish");
            }
            e34 F = e34.F();
            if (F != null) {
                F.I();
            }
        }
    }
}
