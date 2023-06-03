package com.baidu.searchbox.live.interfaces.service;

import android.content.Context;
import android.view.View;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\bf\u0018\u0000  2\u00020\u0001:\u0002 !J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004JY\u0010\u0015\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016Jc\u0010\u0015\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&¢\u0006\u0004\b\u0015\u0010\u0018J\u0081\u0001\u0010\u0015\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u001dJ\u008b\u0001\u0010\u0015\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u001f¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/ShareService;", "Lkotlin/Any;", "", "canShareInLandScreen", "()Z", "", "clean", "()V", "isShowing", "Landroid/content/Context;", "context", "Landroid/view/View;", "root", "", "title", "content", GameAssistConstKt.KEY_LINKURL, GameAssistConstKt.KEY_ICONURL, "ext", "Lcom/baidu/searchbox/live/interfaces/service/ShareService$IOnSocialListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, GameAssistConstKt.METHOD_START_SHARE, "(Landroid/content/Context;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/service/ShareService$IOnSocialListener;)V", "userInfo", "(Landroid/content/Context;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/service/ShareService$IOnSocialListener;)V", "source", "", "type", "talosLiteData", "(Landroid/content/Context;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/baidu/searchbox/live/interfaces/service/ShareService$IOnSocialListener;)V", "ugcScheme", "(Landroid/content/Context;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/service/ShareService$IOnSocialListener;)V", "Companion", "IOnSocialListener", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public interface ShareService {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/ShareService$IOnSocialListener;", "Lkotlin/Any;", "", "msg", "", GameAssistConstKt.TYPE_CALLBACK_CANCEL, "(Ljava/lang/String;)V", GameAssistConstKt.TYPE_CALLBACK_COMPLETE, GameAssistConstKt.TYPE_CALLBACK_ERROR, GameAssistConstKt.TYPE_CALLBACK_ITEMCLICKED, "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public interface IOnSocialListener {
        void onCancel(String str);

        void onComplete(String str);

        void onError(String str);

        void onItemClicked(String str);
    }

    boolean canShareInLandScreen();

    void clean();

    boolean isShowing();

    void startShare(Context context, View view2, String str, String str2, String str3, String str4, String str5, IOnSocialListener iOnSocialListener);

    void startShare(Context context, View view2, String str, String str2, String str3, String str4, String str5, String str6, IOnSocialListener iOnSocialListener);

    void startShare(Context context, View view2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, IOnSocialListener iOnSocialListener);

    void startShare(Context context, View view2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9, IOnSocialListener iOnSocialListener);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/ShareService$Companion;", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef("share");

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static void startShare(ShareService shareService, Context context, View view2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, IOnSocialListener iOnSocialListener) {
            shareService.startShare(context, view2, str, str2, str3, str4, str5, str6, iOnSocialListener);
        }

        public static void startShare(ShareService shareService, Context context, View view2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9, IOnSocialListener iOnSocialListener) {
            shareService.startShare(context, view2, str, str2, str3, str4, str5, str6, iOnSocialListener);
        }

        public static /* synthetic */ void startShare$default(ShareService shareService, Context context, View view2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, IOnSocialListener iOnSocialListener, int i2, Object obj) {
            int i3;
            if (obj == null) {
                if ((i2 & 512) != 0) {
                    i3 = 1;
                } else {
                    i3 = i;
                }
                shareService.startShare(context, view2, str, str2, str3, str4, str5, str6, str7, i3, str8, iOnSocialListener);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startShare");
        }

        public static /* synthetic */ void startShare$default(ShareService shareService, Context context, View view2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9, IOnSocialListener iOnSocialListener, int i2, Object obj) {
            int i3;
            if (obj == null) {
                if ((i2 & 512) != 0) {
                    i3 = 1;
                } else {
                    i3 = i;
                }
                shareService.startShare(context, view2, str, str2, str3, str4, str5, str6, str7, i3, str8, str9, iOnSocialListener);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startShare");
        }
    }
}
