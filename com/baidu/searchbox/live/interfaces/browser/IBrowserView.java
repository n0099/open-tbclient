package com.baidu.searchbox.live.interfaces.browser;

import android.content.Context;
import android.view.View;
import com.baidu.sapi2.SapiOptions;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.webkit.sdk.WebChromeClient;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001:\u0002,-J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000eH&¢\u0006\u0004\b\u0015\u0010\u0010J\u000f\u0010\u0016\u001a\u00020\u000eH&¢\u0006\u0004\b\u0016\u0010\u0010J\u0017\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0002H&¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0002H&¢\u0006\u0004\b\u001b\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000bH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000bH&¢\u0006\u0004\b\u001f\u0010\u001eJ\u0017\u0010\"\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020 H&¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020$H&¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\u0002H&¢\u0006\u0004\b)\u0010\u0019J\u0017\u0010+\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u0011H&¢\u0006\u0004\b+\u0010\u0014¨\u0006."}, d2 = {"Lcom/baidu/searchbox/live/interfaces/browser/IBrowserView;", "Lkotlin/Any;", "", "canGoBack", "()Z", "", "direction", "canScrollVertically", "(I)Z", "Landroid/content/Context;", "context", "Landroid/view/View;", "getView", "(Landroid/content/Context;)Landroid/view/View;", "", "goBack", "()V", "", "url", "loadUrl", "(Ljava/lang/String;)V", MissionEvent.MESSAGE_DESTROY, "refresh", "allow", "setDisallowInterceptTouchEvent", "(Z)V", SapiOptions.KEY_CACHE_ENABLED, "setDynamicDispatcherEnabled", NativeConstants.TYPE_VIEW, "setErrorView", "(Landroid/view/View;)V", "setLoadingView", "Lcom/baidu/searchbox/live/interfaces/browser/IBrowserView$OnBrowserStatusChangeCallBack;", WebChromeClient.KEY_ARG_CALLBACK, "setOnBrowserStatusChangeCallBack", "(Lcom/baidu/searchbox/live/interfaces/browser/IBrowserView$OnBrowserStatusChangeCallBack;)V", "Lcom/baidu/searchbox/live/interfaces/browser/IBrowserView$OnLongPressListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnLongPressListener", "(Lcom/baidu/searchbox/live/interfaces/browser/IBrowserView$OnLongPressListener;)V", "stateViewVisible", "setStateViewVisible", "source", "setUpSelect", "OnBrowserStatusChangeCallBack", "OnLongPressListener", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface IBrowserView {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/browser/IBrowserView$OnBrowserStatusChangeCallBack;", "Lkotlin/Any;", "", "onHideLoading", "()V", "onLoadFailure", "onLoadSuccess", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface OnBrowserStatusChangeCallBack {
        void onHideLoading();

        void onLoadFailure();

        void onLoadSuccess();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/browser/IBrowserView$OnLongPressListener;", "Lkotlin/Any;", "", "onLongPress", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface OnLongPressListener {
        void onLongPress();
    }

    boolean canGoBack();

    boolean canScrollVertically(int i);

    View getView(Context context);

    void goBack();

    void loadUrl(String str);

    void onDestroy();

    void refresh();

    void setDisallowInterceptTouchEvent(boolean z);

    void setDynamicDispatcherEnabled(boolean z);

    void setErrorView(View view2);

    void setLoadingView(View view2);

    void setOnBrowserStatusChangeCallBack(OnBrowserStatusChangeCallBack onBrowserStatusChangeCallBack);

    void setOnLongPressListener(OnLongPressListener onLongPressListener);

    void setStateViewVisible(boolean z);

    void setUpSelect(String str);
}
