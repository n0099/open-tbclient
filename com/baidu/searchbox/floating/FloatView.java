package com.baidu.searchbox.floating;

import android.app.Notification;
import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.fsg.face.base.b.c;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.searchbox.floating.animator.FloatViewAnimator;
import com.baidu.searchbox.floating.config.Config;
import com.baidu.searchbox.floating.listener.FloatViewListener;
import com.baidu.searchbox.floating.service.FloatViewService;
import com.baidu.searchbox.floating.utils.OverlayPermissionCheck;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u0003:\u0002\u0004\u0003B\u0007¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/floating/FloatView;", "<init>", "()V", "Companion", "Builder", "lib-player-floating_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class FloatView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static final String TAG = "FloatView";
    public static boolean isClickCloseButton;
    public static boolean isRegisterLifecycle;
    public transient /* synthetic */ FieldHolder $fh;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000B\u000f\u0012\u0006\u0010\u0006\u001a\u00020*¢\u0006\u0004\b0\u00101J\u0015\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000e\u001a\u00020\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010#\u001a\u00020\u00002\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 ¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\t¢\u0006\u0004\b%\u0010\u000bJ\u0015\u0010(\u001a\u00020\u00002\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)R\u0019\u0010\u0006\u001a\u00020*8\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010+\u001a\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/¨\u00062"}, d2 = {"Lcom/baidu/searchbox/floating/FloatView$Builder;", "Lcom/baidu/searchbox/floating/listener/FloatViewListener;", "listener", "addFloatListener", "(Lcom/baidu/searchbox/floating/listener/FloatViewListener;)Lcom/baidu/searchbox/floating/FloatView$Builder;", "Lcom/baidu/searchbox/floating/IFloating;", "context", "bindContext", "(Lcom/baidu/searchbox/floating/IFloating;)Lcom/baidu/searchbox/floating/FloatView$Builder;", "", "createFloatView", "()V", "", "", "filters", "(Ljava/util/List;)Lcom/baidu/searchbox/floating/FloatView$Builder;", "Lcom/baidu/searchbox/floating/animator/FloatViewAnimator;", ShaderParams.VALUE_TYPE_ANIMATOR, "setAnimator", "(Lcom/baidu/searchbox/floating/animator/FloatViewAnimator;)Lcom/baidu/searchbox/floating/FloatView$Builder;", "Lcom/baidu/searchbox/floating/config/Config;", UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, "setConfig", "(Lcom/baidu/searchbox/floating/config/Config;)Lcom/baidu/searchbox/floating/FloatView$Builder;", "", c.l, "setDragEnable", "(Z)Lcom/baidu/searchbox/floating/FloatView$Builder;", "Landroid/view/View;", "floatingView", "setFloatingView", "(Landroid/view/View;)Lcom/baidu/searchbox/floating/FloatView$Builder;", "", "x", "y", "setLocation", "(II)Lcom/baidu/searchbox/floating/FloatView$Builder;", "show", "Landroid/app/Notification;", ActionJsonData.TAG_NOTIFICATION, "startForeground", "(Landroid/app/Notification;)Lcom/baidu/searchbox/floating/FloatView$Builder;", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "mConfig", "Lcom/baidu/searchbox/floating/config/Config;", "<init>", "(Landroid/content/Context;)V", "lib-player-floating_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes9.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context context;
        public Config mConfig;

        public Builder(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.context = context;
            this.mConfig = new Config();
        }

        private final void createFloatView() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                FloatViewService.Companion.startService(this.context, this.mConfig);
            }
        }

        public final Builder addFloatListener(FloatViewListener floatViewListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, floatViewListener)) == null) {
                this.mConfig.getFloatViewListeners().add(floatViewListener);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final Builder bindContext(IFloating iFloating) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iFloating)) == null) {
                this.mConfig.setFloatingContext(iFloating);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final Builder filters(List<String> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
                this.mConfig.getFilter().clear();
                this.mConfig.getFilter().addAll(list);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final Context getContext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.context : (Context) invokeV.objValue;
        }

        public final Builder setAnimator(FloatViewAnimator floatViewAnimator) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, floatViewAnimator)) == null) {
                this.mConfig.setAnimator(floatViewAnimator);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final Builder setConfig(Config config) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, config)) == null) {
                this.mConfig = config;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final Builder setDragEnable(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.mConfig.setCanDrag(z);
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public final Builder setFloatingView(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view)) == null) {
                this.mConfig.setFloatingView(view);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final Builder setLocation(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3)) == null) {
                this.mConfig.setLocation(new Pair<>(Integer.valueOf(i2), Integer.valueOf(i3)));
                return this;
            }
            return (Builder) invokeII.objValue;
        }

        public final void show() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                if (this.mConfig.getFloatingView() != null) {
                    if (OverlayPermissionCheck.INSTANCE.hasPermission(this.context)) {
                        createFloatView();
                        return;
                    }
                    for (FloatViewListener floatViewListener : this.mConfig.getFloatViewListeners()) {
                        floatViewListener.onPermissionResult(false);
                    }
                    BdVideoLog.w("没有在其它应用上显示的权限");
                    return;
                }
                for (FloatViewListener floatViewListener2 : this.mConfig.getFloatViewListeners()) {
                    floatViewListener2.onViewCreate(false, null);
                }
                BdVideoLog.w("悬浮窗为空，请确保调用过`Builder.setFloatingView(view)");
            }
        }

        public final Builder startForeground(Notification notification) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, notification)) == null) {
                this.mConfig.setNotification(notification);
                this.mConfig.setForeground(true);
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b%\u0010&J!\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0012\u0010\u0011J\u001b\u0010\u0015\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0017\u0010\u0011J\u001b\u0010\u0018\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013¢\u0006\u0004\b\u0018\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010\u000f\"\u0004\b!\u0010\"R\"\u0010#\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0012\n\u0004\b#\u0010 \u001a\u0004\b#\u0010\u000f\"\u0004\b$\u0010\"¨\u0006'"}, d2 = {"Lcom/baidu/searchbox/floating/FloatView$Companion;", "Landroid/content/Context;", "context", "", "immediately", "", "dismissAppFloatView", "(Landroid/content/Context;Z)V", "Landroid/view/View;", "getAppContentView", "()Landroid/view/View;", "Lcom/baidu/searchbox/floating/IFloating;", "getAppPlayerContext", "()Lcom/baidu/searchbox/floating/IFloating;", "hasFloatView", "()Z", "hideAppFloatView", "(Landroid/content/Context;)V", "invalidate", "Lkotlin/Function0;", "lifeCycle", "registerLifeCycle", "(Lkotlin/Function0;)V", "showAppFloatView", "unregisterLifecycle", "Lcom/baidu/searchbox/floating/FloatView$Builder;", "with", "(Landroid/content/Context;)Lcom/baidu/searchbox/floating/FloatView$Builder;", "", "TAG", "Ljava/lang/String;", "isClickCloseButton", "Z", "setClickCloseButton", "(Z)V", "isRegisterLifecycle", "setRegisterLifecycle", "<init>", "()V", "lib-player-floating_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes9.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Companion() {
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

        @JvmStatic
        public static /* bridge */ /* synthetic */ void dismissAppFloatView$default(Companion companion, Context context, boolean z, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            companion.dismissAppFloatView(context, z);
        }

        private final boolean isRegisterLifecycle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? FloatView.isRegisterLifecycle : invokeV.booleanValue;
        }

        private final void setRegisterLifecycle(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, this, z) == null) {
                FloatView.isRegisterLifecycle = z;
            }
        }

        @JvmStatic
        public final void dismissAppFloatView(Context context, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, context, z) == null) {
                FloatViewService.Companion.dismiss(context, z);
            }
        }

        public final View getAppContentView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Config config = FloatViewService.Companion.getConfig();
                if (config != null) {
                    return config.getFloatingView();
                }
                return null;
            }
            return (View) invokeV.objValue;
        }

        public final IFloating getAppPlayerContext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Config config = FloatViewService.Companion.getConfig();
                if (config != null) {
                    return config.getFloatingContext();
                }
                return null;
            }
            return (IFloating) invokeV.objValue;
        }

        @JvmStatic
        public final boolean hasFloatView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (getAppContentView() != null) {
                    View appContentView = getAppContentView();
                    if ((appContentView != null ? appContentView.getParent() : null) != null) {
                        return true;
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public final void hideAppFloatView(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
                FloatViewService.Companion.setVisible(context, false);
            }
        }

        public final void invalidate(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
                FloatViewService.Companion.invalidate(context);
            }
        }

        public final boolean isClickCloseButton() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? FloatView.isClickCloseButton : invokeV.booleanValue;
        }

        public final void registerLifeCycle(Function0<Unit> function0) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048583, this, function0) == null) || isRegisterLifecycle()) {
                return;
            }
            setRegisterLifecycle(true);
            function0.invoke();
        }

        public final void setClickCloseButton(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
                FloatView.isClickCloseButton = z;
            }
        }

        public final void showAppFloatView(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
                FloatViewService.Companion.setVisible(context, true);
            }
        }

        public final void unregisterLifecycle(Function0<Unit> function0) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048586, this, function0) == null) && isRegisterLifecycle()) {
                setRegisterLifecycle(false);
                function0.invoke();
            }
        }

        @JvmStatic
        public final Builder with(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, context)) == null) ? new Builder(context) : (Builder) invokeL.objValue;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(492022217, "Lcom/baidu/searchbox/floating/FloatView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(492022217, "Lcom/baidu/searchbox/floating/FloatView;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    public FloatView() {
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

    @JvmStatic
    public static final void dismissAppFloatView(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65542, null, context, z) == null) {
            Companion.dismissAppFloatView(context, z);
        }
    }

    @JvmStatic
    public static final boolean hasFloatView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? Companion.hasFloatView() : invokeV.booleanValue;
    }

    @JvmStatic
    public static final Builder with(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? Companion.with(context) : (Builder) invokeL.objValue;
    }
}
