package com.baidu.searchbox.live.interfaces.service;

import android.app.Activity;
import android.app.Notification;
import android.content.Context;
import com.baidu.fsg.face.base.b.c;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u0000 .2\u00020\u0001:\u0003./0J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJC\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H&¢\u0006\u0004\b\u0014\u0010\bJ\u0011\u0010\u0015\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001b\u001a\u00020\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001d\u001a\u00020\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u001d\u0010\u001cJ\u001b\u0010\u001e\u001a\u00020\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u001e\u0010\u001cJ\u0017\u0010 \u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0004H&¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0004H&¢\u0006\u0004\b\"\u0010!J\u0017\u0010%\u001a\u00020\u00172\u0006\u0010$\u001a\u00020#H&¢\u0006\u0004\b%\u0010&J'\u0010+\u001a\u00020\u00172\u0006\u0010$\u001a\u00020#2\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)H&¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0017H&¢\u0006\u0004\b-\u0010\u0019¨\u00061"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/FloatingService;", "Lkotlin/Any;", "Landroid/content/Context;", "context", "", "checkPermission", "(Landroid/content/Context;)Z", "getAlertAuthState", "()Z", "getFloatingAbState", "", "icon", "", "channelId", "channelName", "title", "content", "Landroid/app/Notification;", "getFloatingNotification", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/app/Notification;", "getSettingSwitcherState", "getSettingTipsGuideActivity", "()Ljava/lang/String;", "", "registerFloatingLifecycle", "()V", ILiveNPSPlugin.PARAMS_ROOM_ID, "reportFloatingAuthClickLater", "(Ljava/lang/String;)V", "reportFloatingAuthClickOpen", "reportFloatingAuthShow", c.l, "setAlertAuthState", "(Z)V", "setSettingSwitcher", "Landroid/app/Activity;", "activity", "showFloatingNotSupport", "(Landroid/app/Activity;)V", "Lcom/baidu/searchbox/live/interfaces/service/FloatingService$OnPermissionResultListener;", "resultListener", "Lcom/baidu/searchbox/live/interfaces/service/FloatingService$OnPermissionCancelListener;", "cancelListener", "showGuideDialog", "(Landroid/app/Activity;Lcom/baidu/searchbox/live/interfaces/service/FloatingService$OnPermissionResultListener;Lcom/baidu/searchbox/live/interfaces/service/FloatingService$OnPermissionCancelListener;)V", "unregisterFloatingLifecycle", "Companion", "OnPermissionCancelListener", "OnPermissionResultListener", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public interface FloatingService {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/FloatingService$Companion;", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes9.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE;
        public static /* synthetic */ Interceptable $ic;
        public static final ServiceReference SERVICE_REFERENCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1859057386, "Lcom/baidu/searchbox/live/interfaces/service/FloatingService$Companion;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1859057386, "Lcom/baidu/searchbox/live/interfaces/service/FloatingService$Companion;");
                    return;
                }
            }
            $$INSTANCE = new Companion();
            SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.LIVE_FLOATING);
        }

        public Companion() {
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

        public final ServiceReference getSERVICE_REFERENCE() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? SERVICE_REFERENCE : (ServiceReference) invokeV.objValue;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes9.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static /* synthetic */ Notification getFloatingNotification$default(FloatingService floatingService, Context context, int i2, String str, String str2, String str3, String str4, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str = FloatingServiceKt.NOTIFICATION_CHANNEL_ID;
                }
                return floatingService.getFloatingNotification(context, i2, str, str2, str3, str4);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFloatingNotification");
        }

        public static /* synthetic */ void reportFloatingAuthClickLater$default(FloatingService floatingService, String str, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    str = null;
                }
                floatingService.reportFloatingAuthClickLater(str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportFloatingAuthClickLater");
        }

        public static /* synthetic */ void reportFloatingAuthClickOpen$default(FloatingService floatingService, String str, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    str = null;
                }
                floatingService.reportFloatingAuthClickOpen(str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportFloatingAuthClickOpen");
        }

        public static /* synthetic */ void reportFloatingAuthShow$default(FloatingService floatingService, String str, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    str = null;
                }
                floatingService.reportFloatingAuthShow(str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportFloatingAuthShow");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/FloatingService$OnPermissionCancelListener;", "Lkotlin/Any;", "", "onCancel", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes9.dex */
    public interface OnPermissionCancelListener {
        void onCancel();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/FloatingService$OnPermissionResultListener;", "Lkotlin/Any;", "", "onResultSuccess", "()V", "onResultUnknown", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes9.dex */
    public interface OnPermissionResultListener {
        void onResultSuccess();

        void onResultUnknown();
    }

    boolean checkPermission(Context context);

    boolean getAlertAuthState();

    boolean getFloatingAbState();

    Notification getFloatingNotification(Context context, int i2, String str, String str2, String str3, String str4);

    boolean getSettingSwitcherState();

    String getSettingTipsGuideActivity();

    void registerFloatingLifecycle();

    void reportFloatingAuthClickLater(String str);

    void reportFloatingAuthClickOpen(String str);

    void reportFloatingAuthShow(String str);

    void setAlertAuthState(boolean z);

    void setSettingSwitcher(boolean z);

    void showFloatingNotSupport(Activity activity);

    void showGuideDialog(Activity activity, OnPermissionResultListener onPermissionResultListener, OnPermissionCancelListener onPermissionCancelListener);

    void unregisterFloatingLifecycle();
}
