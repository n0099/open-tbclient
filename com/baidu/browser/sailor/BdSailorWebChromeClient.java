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
import com.baidu.browser.core.INoProGuard;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.webkit.sdk.GeolocationPermissions;
import com.baidu.webkit.sdk.JsPromptResult;
import com.baidu.webkit.sdk.JsResult;
import com.baidu.webkit.sdk.PermissionRequest;
import com.baidu.webkit.sdk.WebChromeClient;
import com.baidu.webkit.sdk.WebStorage;
/* loaded from: classes4.dex */
public class BdSailorWebChromeClient implements INoProGuard {
    private Activity getActivityFromContext(BdSailorWebView bdSailorWebView) {
        if (bdSailorWebView.getContext() instanceof Activity) {
            return (Activity) bdSailorWebView.getContext();
        }
        if (bdSailorWebView.getContext() instanceof MutableContextWrapper) {
            Context baseContext = ((MutableContextWrapper) bdSailorWebView.getContext()).getBaseContext();
            if (baseContext instanceof Activity) {
                return (Activity) baseContext;
            }
        }
        return null;
    }

    @Deprecated
    public void doTextSearchExt(BdSailorWebView bdSailorWebView, String str) {
    }

    @Deprecated
    public void doTextTranslateExt(BdSailorWebView bdSailorWebView, String str) {
    }

    public Bitmap getDefaultVideoPoster(BdSailorWebView bdSailorWebView) {
        return null;
    }

    public View getVideoLoadingProgressView(BdSailorWebView bdSailorWebView) {
        return null;
    }

    public void getVisitedHistory(BdSailorWebView bdSailorWebView, ValueCallback<String[]> valueCallback) {
    }

    public void onCloseWindow(BdSailorWebView bdSailorWebView) {
    }

    public boolean onConsoleMessage(BdSailorWebView bdSailorWebView, ConsoleMessage consoleMessage) {
        return false;
    }

    public boolean onCreateWindow(BdSailorWebView bdSailorWebView, boolean z, boolean z2, Message message) {
        return false;
    }

    public void onExceededDatabaseQuota(BdSailorWebView bdSailorWebView, String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        quotaUpdater.updateQuota(j);
    }

    public boolean onFlyflowJsiPrompt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return false;
    }

    public void onGeolocationPermissionsHidePrompt(BdSailorWebView bdSailorWebView) {
    }

    public void onGeolocationPermissionsShowPrompt(BdSailorWebView bdSailorWebView, String str, GeolocationPermissions.Callback callback) {
        callback.invoke(str, true, false);
    }

    public boolean onHideCustomView(BdSailorWebView bdSailorWebView) {
        return false;
    }

    public boolean onJsAlert(BdSailorWebView bdSailorWebView, String str, String str2, JsResult jsResult) {
        return false;
    }

    public boolean onJsBeforeUnload(BdSailorWebView bdSailorWebView, String str, String str2, JsResult jsResult) {
        return false;
    }

    public boolean onJsConfirm(BdSailorWebView bdSailorWebView, String str, String str2, JsResult jsResult) {
        return false;
    }

    public boolean onJsPrompt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return false;
    }

    public boolean onJsTimeout(BdSailorWebView bdSailorWebView) {
        return false;
    }

    public void onOffsetsForFullscreenChanged(BdSailorWebView bdSailorWebView, float f, float f2, float f3) {
    }

    public void onPermissionRequest(BdSailorWebView bdSailorWebView, PermissionRequest permissionRequest) {
        if (permissionRequest.defaultHandler()) {
            return;
        }
        permissionRequest.deny();
    }

    public void onPermissionRequestCanceled(BdSailorWebView bdSailorWebView, PermissionRequest permissionRequest) {
    }

    public void onProgressChanged(BdSailorWebView bdSailorWebView, int i) {
    }

    public void onReachedMaxAppCacheSize(BdSailorWebView bdSailorWebView, long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        quotaUpdater.updateQuota(0L);
    }

    public void onReceivedIcon(BdSailorWebView bdSailorWebView, Bitmap bitmap) {
    }

    public void onReceivedTitle(BdSailorWebView bdSailorWebView, String str) {
    }

    public void onReceivedTouchIconUrl(BdSailorWebView bdSailorWebView, String str, boolean z) {
    }

    public void onRequestFocus(BdSailorWebView bdSailorWebView) {
    }

    public boolean onShowCustomView(BdSailorWebView bdSailorWebView, View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        return false;
    }

    public boolean onShowCustomView(BdSailorWebView bdSailorWebView, View view, WebChromeClient.CustomViewCallback customViewCallback) {
        return false;
    }

    public boolean onShowFileChooser(BdSailorWebView bdSailorWebView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        Activity activityFromContext = getActivityFromContext(bdSailorWebView);
        if (activityFromContext != null) {
            return BdSailorPlatform.onShowFileChooser(activityFromContext, valueCallback, fileChooserParams);
        }
        valueCallback.onReceiveValue(null);
        return false;
    }

    public void openFileChooser(BdSailorWebView bdSailorWebView, ValueCallback<Uri> valueCallback) {
        Activity activityFromContext = getActivityFromContext(bdSailorWebView);
        if (activityFromContext != null) {
            BdSailorPlatform.openFileChooser(activityFromContext, valueCallback);
        } else {
            valueCallback.onReceiveValue(null);
        }
    }

    public void openFileChooser(BdSailorWebView bdSailorWebView, ValueCallback<Uri> valueCallback, String str) {
        Activity activityFromContext = getActivityFromContext(bdSailorWebView);
        if (activityFromContext != null) {
            BdSailorPlatform.openFileChooser(activityFromContext, valueCallback, str);
        } else {
            valueCallback.onReceiveValue(null);
        }
    }

    public void openFileChooser(BdSailorWebView bdSailorWebView, ValueCallback<Uri> valueCallback, String str, String str2) {
        Activity activityFromContext = getActivityFromContext(bdSailorWebView);
        if (activityFromContext != null) {
            BdSailorPlatform.openFileChooser(activityFromContext, valueCallback, str, str2);
        } else {
            valueCallback.onReceiveValue(null);
        }
    }
}
