package com.baidu.searchbox.live.interfaces.service;

import android.app.Activity;
import android.app.Dialog;
import android.app.Notification;
import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.player.layer.AbsLayer;
import com.baidu.webkit.sdk.WebChromeClient;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u0000 J2\u00020\u0001:\u0005JKLMNJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\bJC\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011H&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0011H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u000fH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H&¢\u0006\u0004\b\u001d\u0010\bJ\u0011\u0010\u001e\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0004\b\u001e\u0010\u001aJ\u000f\u0010\u001f\u001a\u00020\u0011H&¢\u0006\u0004\b\u001f\u0010\u001aJ\u001b\u0010 \u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b \u0010\rJ\u000f\u0010\"\u001a\u00020!H&¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0004H&¢\u0006\u0004\b$\u0010\bJ\u000f\u0010%\u001a\u00020\u0004H&¢\u0006\u0004\b%\u0010\bJ\u0017\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0011H&¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020!H&¢\u0006\u0004\b)\u0010#J\u001b\u0010+\u001a\u00020!2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0004\b+\u0010,J\u001b\u0010-\u001a\u00020!2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0004\b-\u0010,J\u001b\u0010.\u001a\u00020!2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0004\b.\u0010,J\u0017\u00100\u001a\u00020!2\u0006\u0010/\u001a\u00020\u0004H&¢\u0006\u0004\b0\u00101J\u0019\u00104\u001a\u00020!2\b\u00103\u001a\u0004\u0018\u000102H&¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020!2\u0006\u0010/\u001a\u00020\u0004H&¢\u0006\u0004\b6\u00101J\u001f\u00107\u001a\u00020!2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0011H\u0016¢\u0006\u0004\b7\u00108J)\u00107\u001a\u00020!2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u00112\b\u0010:\u001a\u0004\u0018\u000109H\u0016¢\u0006\u0004\b7\u0010;J\u0017\u0010>\u001a\u00020!2\u0006\u0010=\u001a\u00020<H&¢\u0006\u0004\b>\u0010?J'\u0010D\u001a\u00020!2\u0006\u0010=\u001a\u00020<2\u0006\u0010A\u001a\u00020@2\u0006\u0010C\u001a\u00020BH&¢\u0006\u0004\bD\u0010EJ+\u0010G\u001a\u0004\u0018\u00010F2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u00112\b\u0010:\u001a\u0004\u0018\u000109H&¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020!H&¢\u0006\u0004\bI\u0010#¨\u0006O"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/FloatingService;", "Lkotlin/Any;", "Landroid/content/Context;", "context", "", "checkPermission", "(Landroid/content/Context;)Z", "getAlertAuthState", "()Z", "Lcom/baidu/searchbox/live/interfaces/service/FloatingService$LayerCallback;", WebChromeClient.KEY_ARG_CALLBACK, "Lcom/baidu/searchbox/player/layer/AbsLayer;", "getFloatLayer", "(Lcom/baidu/searchbox/live/interfaces/service/FloatingService$LayerCallback;)Lcom/baidu/searchbox/player/layer/AbsLayer;", "getFloatingAbState", "", "icon", "", "channelId", "channelName", "title", "content", "Landroid/app/Notification;", "getFloatingNotification", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/app/Notification;", "getGestureAction", "()Ljava/lang/String;", "getGestureKey", "()I", "getSettingSwitcherState", "getSettingTipsGuideActivity", "getSingleTapAction", "getYYFloatLayer", "", "initBDPlayer", "()V", "isFloatViewShowing", "isKernelPlayerInitFinished", "source", "needShowFloatOpenGuideDialog", "(Ljava/lang/String;)Z", "registerFloatingLifecycle", "roomId", "reportFloatingAuthClickLater", "(Ljava/lang/String;)V", "reportFloatingAuthClickOpen", "reportFloatingAuthShow", "enable", "setAlertAuthState", "(Z)V", "", "config", "setConfigPropertyCompat", "(Ljava/lang/Object;)V", "setSettingSwitcher", "showFloatOpenGuideDialog", "(Landroid/content/Context;Ljava/lang/String;)V", "Lcom/baidu/searchbox/live/interfaces/service/FloatingService$OnShowFloatOpenGuideDialogListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "(Landroid/content/Context;Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/service/FloatingService$OnShowFloatOpenGuideDialogListener;)V", "Landroid/app/Activity;", "activity", "showFloatingNotSupport", "(Landroid/app/Activity;)V", "Lcom/baidu/searchbox/live/interfaces/service/FloatingService$OnPermissionResultListener;", "resultListener", "Lcom/baidu/searchbox/live/interfaces/service/FloatingService$OnPermissionCancelListener;", "cancelListener", "showGuideDialog", "(Landroid/app/Activity;Lcom/baidu/searchbox/live/interfaces/service/FloatingService$OnPermissionResultListener;Lcom/baidu/searchbox/live/interfaces/service/FloatingService$OnPermissionCancelListener;)V", "Landroid/app/Dialog;", "showOpenGuideDialog", "(Landroid/content/Context;Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/service/FloatingService$OnShowFloatOpenGuideDialogListener;)Landroid/app/Dialog;", "unregisterFloatingLifecycle", "Companion", "LayerCallback", "OnPermissionCancelListener", "OnPermissionResultListener", "OnShowFloatOpenGuideDialogListener", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface FloatingService {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/FloatingService$LayerCallback;", "Lkotlin/Any;", "Landroid/content/Context;", "context", "", "onBackClick", "(Landroid/content/Context;)V", "onCloseClick", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface LayerCallback {
        void onBackClick(Context context);

        void onCloseClick();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/FloatingService$OnPermissionCancelListener;", "Lkotlin/Any;", "", "onCancel", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface OnPermissionCancelListener {
        void onCancel();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/FloatingService$OnPermissionResultListener;", "Lkotlin/Any;", "", "onResultSuccess", "()V", "onResultUnknown", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface OnPermissionResultListener {
        void onResultSuccess();

        void onResultUnknown();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/FloatingService$OnShowFloatOpenGuideDialogListener;", "Lkotlin/Any;", "", "onClickNegative", "()V", "onClickPositive", "onShow", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface OnShowFloatOpenGuideDialogListener {
        void onClickNegative();

        void onClickPositive();

        void onShow();
    }

    boolean checkPermission(Context context);

    boolean getAlertAuthState();

    AbsLayer getFloatLayer(LayerCallback layerCallback);

    boolean getFloatingAbState();

    Notification getFloatingNotification(Context context, int i, String str, String str2, String str3, String str4);

    String getGestureAction();

    int getGestureKey();

    boolean getSettingSwitcherState();

    String getSettingTipsGuideActivity();

    String getSingleTapAction();

    AbsLayer getYYFloatLayer(LayerCallback layerCallback);

    void initBDPlayer();

    boolean isFloatViewShowing();

    boolean isKernelPlayerInitFinished();

    boolean needShowFloatOpenGuideDialog(String str);

    void registerFloatingLifecycle();

    void reportFloatingAuthClickLater(String str);

    void reportFloatingAuthClickOpen(String str);

    void reportFloatingAuthShow(String str);

    void setAlertAuthState(boolean z);

    void setConfigPropertyCompat(Object obj);

    void setSettingSwitcher(boolean z);

    void showFloatOpenGuideDialog(Context context, String str);

    void showFloatOpenGuideDialog(Context context, String str, OnShowFloatOpenGuideDialogListener onShowFloatOpenGuideDialogListener);

    void showFloatingNotSupport(Activity activity);

    void showGuideDialog(Activity activity, OnPermissionResultListener onPermissionResultListener, OnPermissionCancelListener onPermissionCancelListener);

    Dialog showOpenGuideDialog(Context context, String str, OnShowFloatOpenGuideDialogListener onShowFloatOpenGuideDialogListener);

    void unregisterFloatingLifecycle();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/FloatingService$Companion;", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.LIVE_FLOATING);

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static void showFloatOpenGuideDialog(FloatingService floatingService, Context context, String str) {
        }

        public static void showFloatOpenGuideDialog(FloatingService floatingService, Context context, String str, OnShowFloatOpenGuideDialogListener onShowFloatOpenGuideDialogListener) {
        }

        public static /* synthetic */ Notification getFloatingNotification$default(FloatingService floatingService, Context context, int i, String str, String str2, String str3, String str4, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    str = FloatingServiceKt.NOTIFICATION_CHANNEL_ID;
                }
                return floatingService.getFloatingNotification(context, i, str, str2, str3, str4);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFloatingNotification");
        }

        public static /* synthetic */ void reportFloatingAuthClickLater$default(FloatingService floatingService, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                floatingService.reportFloatingAuthClickLater(str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportFloatingAuthClickLater");
        }

        public static /* synthetic */ void reportFloatingAuthClickOpen$default(FloatingService floatingService, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                floatingService.reportFloatingAuthClickOpen(str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportFloatingAuthClickOpen");
        }

        public static /* synthetic */ void reportFloatingAuthShow$default(FloatingService floatingService, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                floatingService.reportFloatingAuthShow(str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportFloatingAuthShow");
        }
    }
}
