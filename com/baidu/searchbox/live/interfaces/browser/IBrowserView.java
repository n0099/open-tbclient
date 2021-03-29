package com.baidu.searchbox.live.interfaces.browser;

import android.content.Context;
import android.view.View;
import com.baidu.sapi2.SapiOptions;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001!J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000eH&¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0004H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0004H&¢\u0006\u0004\b\u0018\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\tH&¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\tH&¢\u0006\u0004\b\u001c\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/live/interfaces/browser/IBrowserView;", "Lkotlin/Any;", "", "direction", "", "canScrollVertically", "(I)Z", "Landroid/content/Context;", "context", "Landroid/view/View;", "getView", "(Landroid/content/Context;)Landroid/view/View;", "", "url", "", "loadUrl", "(Ljava/lang/String;)V", MissionEvent.MESSAGE_DESTROY, "()V", "refresh", "allow", "setDisallowInterceptTouchEvent", "(Z)V", SapiOptions.t, "setDynamicDispatcherEnabled", "view", "setErrorView", "(Landroid/view/View;)V", "setLoadingView", "Lcom/baidu/searchbox/live/interfaces/browser/IBrowserView$OnBrowserStatusChangeCallBack;", "callback", "setOnBrowserStatusChangeCallBack", "(Lcom/baidu/searchbox/live/interfaces/browser/IBrowserView$OnBrowserStatusChangeCallBack;)V", "OnBrowserStatusChangeCallBack", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface IBrowserView {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/browser/IBrowserView$OnBrowserStatusChangeCallBack;", "Lkotlin/Any;", "", "onHideLoading", "()V", "onLoadFailure", "onLoadSuccess", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface OnBrowserStatusChangeCallBack {
        void onHideLoading();

        void onLoadFailure();

        void onLoadSuccess();
    }

    boolean canScrollVertically(int i);

    View getView(Context context);

    void loadUrl(String str);

    void onDestroy();

    void refresh();

    void setDisallowInterceptTouchEvent(boolean z);

    void setDynamicDispatcherEnabled(boolean z);

    void setErrorView(View view);

    void setLoadingView(View view);

    void setOnBrowserStatusChangeCallBack(OnBrowserStatusChangeCallBack onBrowserStatusChangeCallBack);
}
