package com.baidu.browser.webpool;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import com.baidu.browser.webkit.BdGeolocationPermissions;
import com.baidu.browser.webkit.BdValueCallback;
import com.baidu.browser.webkit.BdWebChromeClient;
import com.baidu.browser.webkit.BdWebStorage;
import com.baidu.browser.webkit.BdWebView;
/* loaded from: classes.dex */
public class BdWebPoolChromeClient {
    public void onProgressChanged(BdWebPoolView bdWebPoolView, int i) {
    }

    public void onReceivedTitle(BdWebPoolView bdWebPoolView, String str) {
    }

    public void onReceivedIcon(BdWebPoolView bdWebPoolView, Bitmap bitmap) {
    }

    public void onReceivedTouchIconUrl(BdWebPoolView bdWebPoolView, String str, boolean z) {
    }

    public void onShowCustomView(View view, BdWebChromeClient.BdCustomViewCallback bdCustomViewCallback) {
    }

    public void onHideCustomView() {
    }

    public boolean onCreateWindow(BdWebPoolView bdWebPoolView, boolean z, boolean z2, Message message, BdWebView.BdWebViewTransport bdWebViewTransport) {
        return false;
    }

    public void onRequestFocus(BdWebPoolView bdWebPoolView) {
    }

    public void onCloseWindow(BdWebPoolView bdWebPoolView) {
    }

    public void openFileChooser(BdValueCallback<Uri> bdValueCallback, String str, String str2) {
    }

    public void openFileChooser(BdValueCallback<Uri> bdValueCallback, String str) {
    }

    public void openFileChooser(BdValueCallback<Uri> bdValueCallback) {
    }

    public void onGeolocationPermissionsShowPrompt(String str, BdGeolocationPermissions.BdCallback bdCallback) {
    }

    public void onGeolocationPermissionsHidePrompt() {
    }

    public String getStringById(int i) {
        return null;
    }

    public void copyText(BdWebPoolView bdWebPoolView, String str) {
    }

    public void hideMagnifier(BdWebPoolView bdWebPoolView, int i, int i2) {
    }

    public void hideSelectionActionDialog(BdWebPoolView bdWebPoolView) {
    }

    public void moveMagnifier(BdWebPoolView bdWebPoolView, int i, int i2, int i3, int i4) {
    }

    public void performLongClick(BdWebPoolView bdWebPoolView, int i, String str, String str2, int i2, int i3) {
    }

    public void showMagnifier(BdWebPoolView bdWebPoolView, int i, int i2, int i3, int i4) {
    }

    public void showSelectionActionDialog(BdWebPoolView bdWebPoolView, int i, int i2, int i3, int i4, String str) {
    }

    public Bitmap getDefaultVideoPoster() {
        return null;
    }

    public View getVideoLoadingProgressView() {
        return null;
    }

    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, BdWebStorage.BdQuotaUpdater bdQuotaUpdater) {
    }

    public void onReachedMaxAppCacheSize(long j, long j2, BdWebStorage.BdQuotaUpdater bdQuotaUpdater) {
    }

    public void onSetLoadURL(BdWebPoolView bdWebPoolView, String str) {
    }
}
