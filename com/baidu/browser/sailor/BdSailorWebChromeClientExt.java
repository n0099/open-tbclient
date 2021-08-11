package com.baidu.browser.sailor;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.core.INoProGuard;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.JsPromptResult;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes5.dex */
public class BdSailorWebChromeClientExt implements INoProGuard {
    public static /* synthetic */ Interceptable $ic;
    public static final BdSailorWebChromeClientExt DEFAULT;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-917861993, "Lcom/baidu/browser/sailor/BdSailorWebChromeClientExt;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-917861993, "Lcom/baidu/browser/sailor/BdSailorWebChromeClientExt;");
                return;
            }
        }
        DEFAULT = new BdSailorWebChromeClientExt();
    }

    public BdSailorWebChromeClientExt() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Deprecated
    public void copyTextExt(BdSailorWebView bdSailorWebView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bdSailorWebView, str) == null) {
        }
    }

    @Deprecated
    public void doTextSearchExt(BdSailorWebView bdSailorWebView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdSailorWebView, str) == null) {
        }
    }

    @Deprecated
    public void doTextTranslateExt(BdSailorWebView bdSailorWebView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bdSailorWebView, str) == null) {
        }
    }

    @Deprecated
    public void hideMagnifierExt(BdSailorWebView bdSailorWebView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, bdSailorWebView, i2, i3) == null) {
        }
    }

    public void hideSelectionActionDialogExt(BdSailorWebView bdSailorWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdSailorWebView) == null) {
        }
    }

    @Deprecated
    public void moveMagnifierExt(BdSailorWebView bdSailorWebView, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{bdSailorWebView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
        }
    }

    @Deprecated
    public boolean needNotifyNativeExitFullScreenExt(BdSailorWebView bdSailorWebView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bdSailorWebView)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public void notifyClickWhenLoadExt(BdSailorWebView bdSailorWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdSailorWebView) == null) {
        }
    }

    @Deprecated
    public void notifyClientStatusExt(BdSailorWebView bdSailorWebView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdSailorWebView, i2) == null) {
        }
    }

    @Deprecated
    public void onFeaturePermissionsHidePromptExt(BdSailorWebView bdSailorWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdSailorWebView) == null) {
        }
    }

    public boolean onFlyflowJsiConsole(BdSailorWebView bdSailorWebView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, bdSailorWebView, str, str2)) == null) {
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public boolean onFlyflowJsiPrompt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048587, this, bdSailorWebView, str, str2, str3, jsPromptResult)) == null) {
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    public void onNativeElementEnterFullScreenExt(BdSailorWebView bdSailorWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bdSailorWebView) == null) {
        }
    }

    public void onNativeElementExitFullScreenExt(BdSailorWebView bdSailorWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bdSailorWebView) == null) {
        }
    }

    public void onNextPagePreloadFinishedExt() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    public void onPrerenderChanged(int i2, WebView.PrerenderStatus prerenderStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i2, prerenderStatus) == null) {
        }
    }

    public void onReceivedFocusNodeHrefExt(BdSailorWebView bdSailorWebView, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048592, this, bdSailorWebView, i2, str, str2) == null) {
        }
    }

    @Deprecated
    public void onSetLoadURLExt(BdSailorWebView bdSailorWebView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, bdSailorWebView, str) == null) {
        }
    }

    public void onSetWallPaperExt(BdSailorWebView bdSailorWebView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, bdSailorWebView, str) == null) {
        }
    }

    public void onShowCommentPanel(BdSailorWebView bdSailorWebView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048595, this, bdSailorWebView, str, str2) == null) {
        }
    }

    public void onShowValidateComponent(BdSailorWebView bdSailorWebView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048596, this, bdSailorWebView, str, str2) == null) {
        }
    }

    @Deprecated
    public void performLongClickExt(BdSailorWebView bdSailorWebView, int i2, String str, String str2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{bdSailorWebView, Integer.valueOf(i2), str, str2, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
        }
    }

    public void performLongClickExt(BdSailorWebView bdSailorWebView, WebView.HitTestResult hitTestResult, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048598, this, bdSailorWebView, hitTestResult, i2, i3) == null) {
        }
    }

    @Deprecated
    public void showMagnifierExt(BdSailorWebView bdSailorWebView, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{bdSailorWebView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
        }
    }

    public void showSelectionActionDialogExt(BdSailorWebView bdSailorWebView, int i2, int i3, int i4, int i5, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{bdSailorWebView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str}) == null) {
        }
    }
}
