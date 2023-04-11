package com.baidu.nadcore.webview.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.webkit.SslErrorHandler;
import com.baidu.mobstat.Config;
import com.baidu.nadcore.appframework.BaseActivity;
import com.baidu.nadcore.webview.container.NadBrowserContainer;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
import com.baidu.nadcore.widget.SlideInterceptor;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.tieba.R;
import com.baidu.tieba.o81;
import com.baidu.tieba.v81;
import com.baidu.tieba.w81;
import com.baidu.tieba.y71;
import com.baidu.tieba.y81;
import com.baidu.tieba.z71;
import com.baidu.webkit.sdk.WebChromeClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\b¢\u0006\u0005\b\u009d\u0001\u0010\bJ\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001e\u0010\u000bJ\u000f\u0010\u001f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001f\u0010\u000bJ\u0011\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b!\u0010\"J\u0019\u0010%\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\tH\u0016¢\u0006\u0004\b'\u0010\u000bJ!\u0010+\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00122\b\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b+\u0010,J+\u00100\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00122\b\u0010.\u001a\u0004\u0018\u00010-2\b\u0010/\u001a\u0004\u0018\u00010-H\u0016¢\u0006\u0004\b0\u00101J)\u00104\u001a\u00020\u00062\b\u0010(\u001a\u0004\u0018\u00010\u00122\u0006\u00102\u001a\u00020\u00192\u0006\u00103\u001a\u00020\u0019H\u0016¢\u0006\u0004\b4\u00105J#\u00107\u001a\u0004\u0018\u0001062\u0006\u0010(\u001a\u00020\u00122\b\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b7\u00108J!\u00109\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00122\b\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b9\u0010,J!\u0010:\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b:\u0010;J!\u0010<\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00122\b\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b<\u0010=J\u001f\u0010?\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00122\u0006\u0010>\u001a\u00020\u0019H\u0016¢\u0006\u0004\b?\u0010@J!\u0010A\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00122\b\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\bA\u0010,J+\u0010D\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00122\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010C\u001a\u0004\u0018\u00010BH\u0016¢\u0006\u0004\bD\u0010EJ\u001f\u0010G\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00122\u0006\u0010F\u001a\u00020\u0019H\u0016¢\u0006\u0004\bG\u0010@J3\u0010K\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00122\u0006\u0010H\u001a\u00020\u00192\b\u0010I\u001a\u0004\u0018\u00010)2\b\u0010J\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\bK\u0010LJ3\u0010Q\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00122\u0006\u0010N\u001a\u00020M2\b\u0010O\u001a\u0004\u0018\u00010)2\b\u0010P\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\bQ\u0010RJ5\u0010U\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00122\b\u0010P\u001a\u0004\u0018\u00010)2\b\u0010S\u001a\u0004\u0018\u00010)2\b\u0010T\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\bU\u0010VJ+\u0010Z\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00122\b\u0010N\u001a\u0004\u0018\u00010W2\b\u0010Y\u001a\u0004\u0018\u00010XH\u0016¢\u0006\u0004\bZ\u0010[J!\u0010]\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00122\b\u0010\\\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b]\u0010,J\u0017\u0010^\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0012H\u0016¢\u0006\u0004\b^\u0010_J'\u0010c\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00122\u0006\u0010a\u001a\u00020`2\u0006\u0010b\u001a\u00020`H\u0016¢\u0006\u0004\bc\u0010dJ!\u0010e\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\be\u0010fJ)\u0010h\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00122\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010g\u001a\u00020\tH\u0016¢\u0006\u0004\bh\u0010iJ+\u0010l\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00122\b\u0010j\u001a\u0004\u0018\u00010)2\b\u0010k\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\bl\u0010mJ\u000f\u0010n\u001a\u00020\u0006H\u0016¢\u0006\u0004\bn\u0010\bJ\u000f\u0010o\u001a\u00020\u0006H\u0016¢\u0006\u0004\bo\u0010\bJ\u0011\u0010p\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\bp\u0010qJ\u0011\u0010r\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\br\u0010qJ\u0011\u0010s\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\bs\u0010qJ)\u0010x\u001a\u00020\u00062\u0006\u0010t\u001a\u00020\u00192\u0006\u0010u\u001a\u00020\u00192\b\u0010w\u001a\u0004\u0018\u00010vH\u0014¢\u0006\u0004\bx\u0010yJ\u000f\u0010z\u001a\u00020\u0006H\u0016¢\u0006\u0004\bz\u0010\bJ\u0017\u0010}\u001a\u00020\u00062\u0006\u0010|\u001a\u00020{H\u0016¢\u0006\u0004\b}\u0010~J\u001d\u0010\u0081\u0001\u001a\u00020\u00062\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u007fH\u0014¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u0011\u0010\u0083\u0001\u001a\u00020\u0006H\u0014¢\u0006\u0005\b\u0083\u0001\u0010\bJ\u0011\u0010\u0084\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u0084\u0001\u0010\bJ#\u0010\u0085\u0001\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0005\b\u0085\u0001\u0010\u001dJ#\u0010\u0086\u0001\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0005\b\u0086\u0001\u0010\u001dJ\u0011\u0010\u0087\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u0087\u0001\u0010\bJ\u0011\u0010\u0088\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u0088\u0001\u0010\bJ\u0011\u0010\u0089\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u0089\u0001\u0010\bJ\u001d\u0010\u008b\u0001\u001a\u00020\u00062\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010vH\u0014¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u0011\u0010\u008d\u0001\u001a\u00020\u0006H\u0014¢\u0006\u0005\b\u008d\u0001\u0010\bJ\u0011\u0010\u008e\u0001\u001a\u00020\u0006H\u0014¢\u0006\u0005\b\u008e\u0001\u0010\bJ\u0011\u0010\u008f\u0001\u001a\u00020\u0006H\u0014¢\u0006\u0005\b\u008f\u0001\u0010\bJ\u0011\u0010\u0090\u0001\u001a\u00020\u0006H\u0014¢\u0006\u0005\b\u0090\u0001\u0010\bJ\u001d\u0010\u0091\u0001\u001a\u00020\t2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u007fH\u0014¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J\u0018\u0010\u0094\u0001\u001a\u00020\u00062\u0007\u0010\u0093\u0001\u001a\u00020\u0012¢\u0006\u0005\b\u0094\u0001\u0010_R\u0019\u0010\u0095\u0001\u001a\u00020)8\u0002@\u0002X\u0082D¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R)\u0010\u0098\u0001\u001a\u00030\u0097\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0017\n\u0006\b\u0098\u0001\u0010\u0099\u0001\u001a\u0005\b\u0010\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001¨\u0006\u009e\u0001"}, d2 = {"Lcom/baidu/nadcore/webview/activity/NadWebViewActivity;", "Lcom/baidu/nadcore/widget/SlideInterceptor;", "Lcom/baidu/tieba/y71;", "Lcom/baidu/tieba/z71;", "Lcom/baidu/tieba/v81;", "Lcom/baidu/nadcore/appframework/BaseActivity;", "", "doFinish", "()V", "", "enableUpdateTitle", "()Z", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "Lcom/baidu/nadcore/webview/container/AbsBrowserContainer;", "getBrowserContainer", "()Lcom/baidu/nadcore/webview/container/AbsBrowserContainer;", "Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;", "getBrowserView", "()Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;", "Lcom/baidu/nadcore/webview/extend/NadFontSizeChangeMessage;", "event", "handleFontSizeChange", "(Lcom/baidu/nadcore/webview/extend/NadFontSizeChangeMessage;)Z", "", "keyCode", "Landroid/view/KeyEvent;", "handleKeyDown", "(ILandroid/view/KeyEvent;)Z", "handleLoadUrl", "handleSetContentView", "Landroid/widget/LinearLayout;", "initBrowserLayout", "()Landroid/widget/LinearLayout;", "Landroid/view/MotionEvent;", Config.EVENT_PART, "isSlidable", "(Landroid/view/MotionEvent;)Z", "needAppendPublicParam", "webView", "", "url", "notifyFirstScreenPaintFinishedExt", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Ljava/lang/String;)V", "Landroid/os/Message;", "dontResend", "resend", "notifyFormResubmission", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Landroid/os/Message;Landroid/os/Message;)V", "scrollOffsetY", "scrollExtentY", "notifyGestureScrollEnded", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;II)V", "Lcom/baidu/nadcore/webview/webviewclient/AbsWebResourceResponseWrapper;", "notifyInterceptRequest", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Ljava/lang/String;)Lcom/baidu/nadcore/webview/webviewclient/AbsWebResourceResponseWrapper;", "notifyLoadResource", "notifyOverrideKeyEvent", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Landroid/view/KeyEvent;)Z", "notifyOverrideUrlLoading", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Ljava/lang/String;)Z", "step", "notifyPageBackOrForwardExt", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;I)V", "notifyPageFinished", "Landroid/graphics/Bitmap;", "favicon", "notifyPageStarted", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Ljava/lang/String;Landroid/graphics/Bitmap;)V", "newProgress", "notifyProgressChanged", "errorCode", "description", "failingUrl", "notifyReceivedError", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;ILjava/lang/String;Ljava/lang/String;)V", "Lcom/baidu/nadcore/webview/webviewclient/AbsHttpAuthHandlerWrapper;", "handler", "host", "realm", "notifyReceivedHttpAuthRequest", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Lcom/baidu/nadcore/webview/webviewclient/AbsHttpAuthHandlerWrapper;Ljava/lang/String;Ljava/lang/String;)V", DI.ACCOUNT, WebChromeClient.KEY_ARG_ARRAY, "notifyReceivedLoginRequest", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/webkit/SslErrorHandler;", "Landroid/net/http/SslError;", "error", "notifyReceivedSslError", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Landroid/webkit/SslErrorHandler;Landroid/net/http/SslError;)V", "title", "notifyReceivedTitle", "notifyRequestFocus", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;)V", "", "oldScale", "newScale", "notifyScaleChanged", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;FF)V", "notifyUnhandledKeyEvent", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Landroid/view/KeyEvent;)V", "isReload", "notifyUpdateVisitedHistory", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Ljava/lang/String;Z)V", "originalUrl", "redirectedUrl", "notifyUrlRedirectedExt", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Ljava/lang/String;Ljava/lang/String;)V", "notifyWebViewInitFinished", "notifyWebViewRelease", "obtainHost", "()Ljava/lang/String;", "obtainNid", "obtainPageTitle", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onAttachedToWindow", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreateEx", "(Landroid/os/Bundle;)V", "onDestroyEx", "onHideLoading", "onKeyDown", "onKeyUp", "onLoadFailure", "onLoadSuccess", "onLowMemory", "intent", "onNewIntentEx", "(Landroid/content/Intent;)V", "onPauseEx", "onResumeEx", "onStartEx", "onStopEx", "preCreate", "(Landroid/os/Bundle;)Z", NativeConstants.TYPE_VIEW, "setBrowserView", "TAG", "Ljava/lang/String;", "Lcom/baidu/nadcore/webview/container/NadBrowserContainer;", "browserContainer", "Lcom/baidu/nadcore/webview/container/NadBrowserContainer;", "()Lcom/baidu/nadcore/webview/container/NadBrowserContainer;", "setBrowserContainer", "(Lcom/baidu/nadcore/webview/container/NadBrowserContainer;)V", "<init>", "lib-webview_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public class NadWebViewActivity extends BaseActivity implements SlideInterceptor, y71, z71, v81 {
    public final String u = "NadWebViewActivity";
    public NadBrowserContainer v = new NadBrowserContainer(this, this, this);

    @Override // com.baidu.tieba.v81
    public void F(AbsNadBrowserView webView, float f, float f2) {
        Intrinsics.checkNotNullParameter(webView, "webView");
    }

    @Override // com.baidu.tieba.v81
    public void F0(AbsNadBrowserView webView, String str, boolean z) {
        Intrinsics.checkNotNullParameter(webView, "webView");
    }

    @Override // com.baidu.tieba.v81
    public void G0(AbsNadBrowserView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Intrinsics.checkNotNullParameter(webView, "webView");
    }

    @Override // com.baidu.tieba.v81
    public void L0(AbsNadBrowserView webView, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(webView, "webView");
    }

    @Override // com.baidu.tieba.v81
    public boolean P(AbsNadBrowserView webView, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        return false;
    }

    @Override // com.baidu.tieba.v81
    public boolean P0(AbsNadBrowserView webView, String str) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        return false;
    }

    @Override // com.baidu.tieba.v81
    public void U0(AbsNadBrowserView webView, String str, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(webView, "webView");
    }

    @Override // com.baidu.tieba.v81
    public void V(AbsNadBrowserView webView, String str) {
        Intrinsics.checkNotNullParameter(webView, "webView");
    }

    @Override // com.baidu.tieba.v81
    public void V0(AbsNadBrowserView webView, w81 handler, String str, String str2) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(handler, "handler");
    }

    @Override // com.baidu.tieba.v81
    public void a1() {
    }

    @Override // com.baidu.tieba.v81
    public void b(AbsNadBrowserView webView, int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(webView, "webView");
    }

    @Override // com.baidu.tieba.y71, com.baidu.tieba.j91
    public boolean f() {
        return false;
    }

    @Override // com.baidu.tieba.z71, com.baidu.tieba.k91
    public boolean g() {
        return false;
    }

    @Override // com.baidu.tieba.y71, com.baidu.tieba.j91
    public Activity getActivity() {
        return this;
    }

    @Override // com.baidu.tieba.v81
    public void i(AbsNadBrowserView webView, String str) {
        Intrinsics.checkNotNullParameter(webView, "webView");
    }

    @Override // com.baidu.tieba.v81
    public void j(AbsNadBrowserView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
    }

    @Override // com.baidu.tieba.z71
    public boolean j1() {
        return false;
    }

    @Override // com.baidu.tieba.v81
    public void n0() {
    }

    @Override // com.baidu.tieba.v81
    public void o1(AbsNadBrowserView webView, int i) {
        Intrinsics.checkNotNullParameter(webView, "webView");
    }

    @Override // com.baidu.tieba.b81
    public void onHideLoading() {
    }

    @Override // com.baidu.tieba.b81
    public void onLoadFailure() {
    }

    @Override // com.baidu.tieba.b81
    public void onLoadSuccess() {
    }

    @Override // com.baidu.tieba.v81
    public y81 q0(AbsNadBrowserView webView, String str) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        return null;
    }

    @Override // com.baidu.tieba.v81
    public void u0(AbsNadBrowserView webView, Message message, Message message2) {
        Intrinsics.checkNotNullParameter(webView, "webView");
    }

    @Override // com.baidu.tieba.z71
    public boolean v0() {
        return true;
    }

    @Override // com.baidu.tieba.v81
    public void y(AbsNadBrowserView webView, String str) {
        Intrinsics.checkNotNullParameter(webView, "webView");
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void C1() {
        this.v.onDestroy();
        o81.a(this.u, "销毁落地页Activity");
        super.C1();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void F1() {
        this.v.onPause();
        super.F1();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void I1() {
        super.I1();
        this.v.v();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void J1() {
        super.J1();
        this.v.w();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void K1() {
        this.v.x();
        super.K1();
    }

    @Override // com.baidu.tieba.y71, com.baidu.tieba.j91
    public void d() {
        finish();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.v.s();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.v.onLowMemory();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void B1(Bundle bundle) {
        super.B1(bundle);
        o81.a(this.u, "启动落地页Activity");
        this.v.t();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void E1(Intent intent) {
        super.E1(intent);
        this.v.u(intent);
    }

    @Override // com.baidu.nadcore.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return this.v.I(motionEvent);
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        this.v.onConfigurationChanged(newConfig);
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public boolean L1(Bundle bundle) {
        if (!super.L1(bundle)) {
            return false;
        }
        requestWindowFeature(1);
        String str = this.u;
        o81.a(str, "onCreate intent=" + getIntent().toUri(1));
        getWindow().setSoftInputMode(32);
        R1(R.anim.nad_slide_in_from_right, R.anim.nad_slide_out_to_left, R.anim.nad_slide_in_from_left, R.anim.nad_slide_out_to_right);
        if (Build.VERSION.SDK_INT == 26) {
            setEnableSliding(false);
            setCurrentActivityNoTransparent();
        } else {
            O1(true, this);
            U1(true);
        }
        return true;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.v.r(i, i2, intent);
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.v.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.v.onKeyUp(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }
}
