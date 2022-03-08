package com.baidu.browser.sailor;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.ValueCallback;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.core.INoProGuard;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.GeolocationPermissions;
import com.baidu.webkit.sdk.JsPromptResult;
import com.baidu.webkit.sdk.JsResult;
import com.baidu.webkit.sdk.PermissionRequest;
import com.baidu.webkit.sdk.WebChromeClient;
import com.baidu.webkit.sdk.WebStorage;
/* loaded from: classes4.dex */
public class BdSailorWebChromeClient implements INoProGuard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BdSailorWebChromeClient() {
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

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
        if ((r5 instanceof android.app.Activity) != false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Activity getActivityFromContext(BdSailorWebView bdSailorWebView) {
        InterceptResult invokeL;
        Context baseContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, bdSailorWebView)) == null) {
            if (!(bdSailorWebView.getContext() instanceof Activity)) {
                if (bdSailorWebView.getContext() instanceof MutableContextWrapper) {
                    baseContext = ((MutableContextWrapper) bdSailorWebView.getContext()).getBaseContext();
                }
                return null;
            }
            baseContext = bdSailorWebView.getContext();
            return (Activity) baseContext;
        }
        return (Activity) invokeL.objValue;
    }

    @Deprecated
    public void doTextSearchExt(BdSailorWebView bdSailorWebView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bdSailorWebView, str) == null) {
        }
    }

    @Deprecated
    public void doTextTranslateExt(BdSailorWebView bdSailorWebView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdSailorWebView, str) == null) {
        }
    }

    public Bitmap getDefaultVideoPoster(BdSailorWebView bdSailorWebView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdSailorWebView)) == null) {
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    public View getVideoLoadingProgressView(BdSailorWebView bdSailorWebView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bdSailorWebView)) == null) {
            return null;
        }
        return (View) invokeL.objValue;
    }

    public void getVisitedHistory(BdSailorWebView bdSailorWebView, ValueCallback<String[]> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bdSailorWebView, valueCallback) == null) {
        }
    }

    public void onCloseWindow(BdSailorWebView bdSailorWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdSailorWebView) == null) {
        }
    }

    public boolean onConsoleMessage(BdSailorWebView bdSailorWebView, ConsoleMessage consoleMessage) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bdSailorWebView, consoleMessage)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean onCreateWindow(BdSailorWebView bdSailorWebView, boolean z, boolean z2, Message message) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{bdSailorWebView, Boolean.valueOf(z), Boolean.valueOf(z2), message})) == null) {
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void onExceededDatabaseQuota(BdSailorWebView bdSailorWebView, String str, String str2, long j2, long j3, long j4, WebStorage.QuotaUpdater quotaUpdater) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{bdSailorWebView, str, str2, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), quotaUpdater}) == null) {
            quotaUpdater.updateQuota(j2);
        }
    }

    public boolean onFlyflowJsiPrompt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048585, this, bdSailorWebView, str, str2, str3, jsPromptResult)) == null) {
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    public void onGeolocationPermissionsHidePrompt(BdSailorWebView bdSailorWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bdSailorWebView) == null) {
        }
    }

    public void onGeolocationPermissionsShowPrompt(BdSailorWebView bdSailorWebView, String str, GeolocationPermissions.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, bdSailorWebView, str, callback) == null) {
            callback.invoke(str, true, false);
        }
    }

    public boolean onHideCustomView(BdSailorWebView bdSailorWebView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, bdSailorWebView)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean onJsAlert(BdSailorWebView bdSailorWebView, String str, String str2, JsResult jsResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, bdSailorWebView, str, str2, jsResult)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public boolean onJsBeforeUnload(BdSailorWebView bdSailorWebView, String str, String str2, JsResult jsResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, bdSailorWebView, str, str2, jsResult)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public boolean onJsConfirm(BdSailorWebView bdSailorWebView, String str, String str2, JsResult jsResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048591, this, bdSailorWebView, str, str2, jsResult)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public boolean onJsPrompt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048592, this, bdSailorWebView, str, str2, str3, jsPromptResult)) == null) {
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    public boolean onJsTimeout(BdSailorWebView bdSailorWebView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, bdSailorWebView)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public void onOffsetsForFullscreenChanged(BdSailorWebView bdSailorWebView, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{bdSailorWebView, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
        }
    }

    public void onPermissionRequest(BdSailorWebView bdSailorWebView, PermissionRequest permissionRequest) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, bdSailorWebView, permissionRequest) == null) || permissionRequest.defaultHandler()) {
            return;
        }
        permissionRequest.deny();
    }

    public void onPermissionRequestCanceled(BdSailorWebView bdSailorWebView, PermissionRequest permissionRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, bdSailorWebView, permissionRequest) == null) {
        }
    }

    public void onProgressChanged(BdSailorWebView bdSailorWebView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, bdSailorWebView, i2) == null) {
        }
    }

    public void onReachedMaxAppCacheSize(BdSailorWebView bdSailorWebView, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{bdSailorWebView, Long.valueOf(j2), Long.valueOf(j3), quotaUpdater}) == null) {
            quotaUpdater.updateQuota(0L);
        }
    }

    public void onReceivedIcon(BdSailorWebView bdSailorWebView, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, bdSailorWebView, bitmap) == null) {
        }
    }

    public void onReceivedTitle(BdSailorWebView bdSailorWebView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, bdSailorWebView, str) == null) {
        }
    }

    public void onReceivedTouchIconUrl(BdSailorWebView bdSailorWebView, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048601, this, bdSailorWebView, str, z) == null) {
        }
    }

    public void onRequestFocus(BdSailorWebView bdSailorWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bdSailorWebView) == null) {
        }
    }

    public boolean onShowCustomView(BdSailorWebView bdSailorWebView, View view, int i2, WebChromeClient.CustomViewCallback customViewCallback) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048603, this, bdSailorWebView, view, i2, customViewCallback)) == null) {
            return false;
        }
        return invokeLLIL.booleanValue;
    }

    public boolean onShowCustomView(BdSailorWebView bdSailorWebView, View view, WebChromeClient.CustomViewCallback customViewCallback) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048604, this, bdSailorWebView, view, customViewCallback)) == null) {
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public boolean onShowFileChooser(BdSailorWebView bdSailorWebView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048605, this, bdSailorWebView, valueCallback, fileChooserParams)) == null) {
            Activity activityFromContext = getActivityFromContext(bdSailorWebView);
            if (activityFromContext != null) {
                return BdSailorPlatform.onShowFileChooser(activityFromContext, valueCallback, fileChooserParams);
            }
            valueCallback.onReceiveValue(null);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void openFileChooser(BdSailorWebView bdSailorWebView, ValueCallback<Uri> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, bdSailorWebView, valueCallback) == null) {
            Activity activityFromContext = getActivityFromContext(bdSailorWebView);
            if (activityFromContext != null) {
                BdSailorPlatform.openFileChooser(activityFromContext, valueCallback);
            } else {
                valueCallback.onReceiveValue(null);
            }
        }
    }

    public void openFileChooser(BdSailorWebView bdSailorWebView, ValueCallback<Uri> valueCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048607, this, bdSailorWebView, valueCallback, str) == null) {
            Activity activityFromContext = getActivityFromContext(bdSailorWebView);
            if (activityFromContext != null) {
                BdSailorPlatform.openFileChooser(activityFromContext, valueCallback, str);
            } else {
                valueCallback.onReceiveValue(null);
            }
        }
    }

    public void openFileChooser(BdSailorWebView bdSailorWebView, ValueCallback<Uri> valueCallback, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048608, this, bdSailorWebView, valueCallback, str, str2) == null) {
            Activity activityFromContext = getActivityFromContext(bdSailorWebView);
            if (activityFromContext != null) {
                BdSailorPlatform.openFileChooser(activityFromContext, valueCallback, str, str2);
            } else {
                valueCallback.onReceiveValue(null);
            }
        }
    }
}
