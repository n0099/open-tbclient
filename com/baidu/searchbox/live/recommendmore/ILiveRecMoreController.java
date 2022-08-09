package com.baidu.searchbox.live.recommendmore;

import android.content.Context;
import android.net.http.Headers;
import android.view.View;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.kwad.sdk.core.scene.URLPackage;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H&¢\u0006\u0004\b\u0011\u0010\u000bJ\u000f\u0010\u0012\u001a\u00020\u0007H&¢\u0006\u0004\b\u0012\u0010\u000bJ\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH&¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/live/recommendmore/ILiveRecMoreController;", "Lkotlin/Any;", "Landroid/view/View;", "getView", "()Landroid/view/View;", "Landroid/content/Context;", "context", "", "init", "(Landroid/content/Context;)V", "onDismiss", "()V", "", "tab", URLPackage.KEY_CHANNEL_ID, Headers.REFRESH, "(Ljava/lang/String;Ljava/lang/String;)V", "release", "resetView", "Lcom/baidu/searchbox/live/recommendmore/LiveRecMoreActionListener;", "listener", "setActionListener", "(Lcom/baidu/searchbox/live/recommendmore/LiveRecMoreActionListener;)V", ILiveNPSPlugin.PARAMS_ROOM_ID, "nid", "source", "updateInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface ILiveRecMoreController {
    View getView();

    void init(Context context);

    void onDismiss();

    void refresh(String str, String str2);

    void release();

    void resetView();

    void setActionListener(LiveRecMoreActionListener liveRecMoreActionListener);

    void updateInfo(String str, String str2, String str3);
}
