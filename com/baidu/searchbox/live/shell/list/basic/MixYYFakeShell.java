package com.baidu.searchbox.live.shell.list.basic;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.arch.ServiceLocator;
import com.baidu.live.arch.runtime.MiniShellRuntime;
import com.baidu.live.arch.utils.MiniUniqueId;
import com.baidu.live.mix.MixLiveItemModel;
import com.baidu.live.mix.interfaces.MixLiveInterface;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.live.action.AbstractEvent;
import com.baidu.searchbox.live.action.MixMediaEvent;
import com.baidu.searchbox.live.action.YYPluginEvent;
import com.baidu.searchbox.live.component.service.LiveItemModelListService;
import com.baidu.searchbox.live.data.constant.MixTagConstants;
import com.baidu.searchbox.live.eventbus.EventAction;
import com.baidu.searchbox.live.eventbus.MixEventBus;
import com.baidu.searchbox.live.frame.IntentData;
import com.baidu.searchbox.live.interfaces.mix.IMixActivityInterface;
import com.baidu.searchbox.live.interfaces.mix.PluginInvokeService;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.mix.MixRoomInfo;
import com.baidu.searchbox.live.pluginmanager.MiniPluginManager;
import com.baidu.searchbox.live.service.ILiveListState;
import com.baidu.searchbox.live.service.LiveMixRoomInfoService;
import com.baidu.searchbox.live.service.MixNotifyBackgroundService;
import com.baidu.searchbox.live.shell.list.basic.MixYYFakeShell$invokeAbility$2;
import com.baidu.searchbox.live.ubc.MediaLivePluginLogger;
import com.baidu.searchbox.live.util.ListLogKt;
import com.baidu.searchbox.live.widget.LiveContainer;
import com.baidu.searchbox.player.helper.OrientationHelper;
import com.baidu.searchbox.player.utils.BdActivityUtils;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.mutiprocess.live.YyLiveRoomConfig;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.request.ImageRequest;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000»\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001M\u0018\u0000 ~2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002~\u007fB\u001f\u0012\u0006\u0010w\u001a\u00020v\u0012\u0006\u0010y\u001a\u00020x\u0012\u0006\u0010{\u001a\u00020z¢\u0006\u0004\b|\u0010}J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\nJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u001e\u0010\nJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u001f\u0010\nJ\u001f\u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0006H\u0016¢\u0006\u0004\b%\u0010\nJ\u0017\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0006H\u0016¢\u0006\u0004\b*\u0010\nJ\u000f\u0010+\u001a\u00020\u0006H\u0016¢\u0006\u0004\b+\u0010\nJ'\u0010.\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00132\u0006\u0010'\u001a\u00020&2\u0006\u0010-\u001a\u00020\"H\u0016¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u0016H\u0016¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0006H\u0007¢\u0006\u0004\b3\u0010\nJ\u000f\u00104\u001a\u00020\u0006H\u0002¢\u0006\u0004\b4\u0010\nJ/\u00109\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u000e\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f052\u0006\u00108\u001a\u000207H\u0016¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0006H\u0007¢\u0006\u0004\b;\u0010\nJ\u000f\u0010<\u001a\u00020\u0006H\u0007¢\u0006\u0004\b<\u0010\nJ\u000f\u0010=\u001a\u00020\u0006H\u0007¢\u0006\u0004\b=\u0010\nJ\u000f\u0010>\u001a\u00020\u0006H\u0002¢\u0006\u0004\b>\u0010\nJ\r\u0010?\u001a\u00020\u0006¢\u0006\u0004\b?\u0010\nR\"\u0010@\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010G\u001a\u00020F8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001d\u0010R\u001a\u00020M8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\u0016\u0010S\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010U\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010TR\"\u0010V\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010T\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0018\u0010[\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R.\u0010_\u001a\u0004\u0018\u00010]2\b\u0010^\u001a\u0004\u0018\u00010]8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u0018\u0010f\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010i\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u001d\u0010o\u001a\u00020k8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bl\u0010O\u001a\u0004\bm\u0010nR\u001e\u0010r\u001a\n q*\u0004\u0018\u00010p0p8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010sR\u0018\u0010t\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010u¨\u0006\u0080\u0001"}, d2 = {"Lcom/baidu/searchbox/live/shell/list/basic/MixYYFakeShell;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/baidu/searchbox/live/eventbus/EventAction;", "Lcom/baidu/searchbox/live/shell/list/basic/AbstractMixFakeShell;", "Lcom/baidu/searchbox/live/action/AbstractEvent;", "event", "", NotificationCompat.CATEGORY_CALL, "(Lcom/baidu/searchbox/live/action/AbstractEvent;)V", "checkImpl", "()V", "Landroid/view/View;", "createContainerView", "()Landroid/view/View;", "hideActivityBackground", "", "content", "log", "(Ljava/lang/String;)V", "", GroupInfoActivityConfig.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onCreate", MissionEvent.MESSAGE_DESTROY, "keyCode", "Landroid/view/KeyEvent;", "", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "onLiveAttach", "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "model", "onLiveBindData", "(Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;)V", "onLiveDeselected", "onLiveDetach", CriusAttrConstants.POSITION, "isFromUser", "onLiveSelected", "(ILcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;Z)V", IntentData.KEY, "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onRealDetach", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "onResume", "onStart", MissionEvent.MESSAGE_STOP, "registerRoomInfoService", "showActivityBackground", "curPosition", "I", "getCurPosition", "()I", "setCurPosition", "(I)V", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "com/baidu/searchbox/live/shell/list/basic/MixYYFakeShell$invokeAbility$2$1", "invokeAbility$delegate", "Lkotlin/Lazy;", "getInvokeAbility", "()Lcom/baidu/searchbox/live/shell/list/basic/MixYYFakeShell$invokeAbility$2$1;", "invokeAbility", "isDestroy", "Z", "isDetach", "isSelected", "()Z", "setSelected", "(Z)V", "Lcom/baidu/searchbox/player/helper/OrientationHelper;", "mOrientationHelper", "Lcom/baidu/searchbox/player/helper/OrientationHelper;", "Lcom/baidu/live/mix/interfaces/MixLiveInterface;", "value", "mixLiveImpl", "Lcom/baidu/live/mix/interfaces/MixLiveInterface;", "getMixLiveImpl", "()Lcom/baidu/live/mix/interfaces/MixLiveInterface;", "setMixLiveImpl", "(Lcom/baidu/live/mix/interfaces/MixLiveInterface;)V", "Lcom/baidu/live/mix/MixLiveItemModel;", "mixModel", "Lcom/baidu/live/mix/MixLiveItemModel;", "Lcom/baidu/searchbox/live/mix/MixRoomInfo;", "mixRoomInfo", "Lcom/baidu/searchbox/live/mix/MixRoomInfo;", "Lcom/baidu/searchbox/live/shell/list/basic/MixYYFakeShell$OrientationChangeCallBack;", "orientationChangeCallBack$delegate", "getOrientationChangeCallBack", "()Lcom/baidu/searchbox/live/shell/list/basic/MixYYFakeShell$OrientationChangeCallBack;", "orientationChangeCallBack", "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "kotlin.jvm.PlatformType", "pluginInvokeService", "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "yyView", "Landroid/view/View;", "Landroid/content/Context;", "context", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "mixUniqueId", "Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "mixActivity", "<init>", "(Landroid/content/Context;Lcom/baidu/live/arch/utils/MiniUniqueId;Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;)V", "Companion", "OrientationChangeCallBack", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MixYYFakeShell extends AbstractMixFakeShell implements LifecycleObserver, EventAction<AbstractEvent> {
    public static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static /* synthetic */ Interceptable $ic = null;
    @Deprecated
    public static final Companion Companion;
    public static final String ROOM_ID_YY = "roomid";
    public static final String SID_CONST_KEY = "sid_shiyan";
    public static boolean hasSelected;
    public static boolean isLoadPlugin;
    public static int lastContextHashCode;
    public transient /* synthetic */ FieldHolder $fh;
    public int curPosition;
    public Handler handler;
    public final Lazy invokeAbility$delegate;
    public boolean isDestroy;
    public boolean isDetach;
    public boolean isSelected;
    public OrientationHelper mOrientationHelper;
    public MixLiveInterface mixLiveImpl;
    public MixLiveItemModel mixModel;
    public MixRoomInfo mixRoomInfo;
    public final Lazy orientationChangeCallBack$delegate;
    public final PluginInvokeService pluginInvokeService;
    public View yyView;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2058280434, "Lcom/baidu/searchbox/live/shell/list/basic/MixYYFakeShell;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2058280434, "Lcom/baidu/searchbox/live/shell/list/basic/MixYYFakeShell;");
                return;
            }
        }
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MixYYFakeShell.class), "orientationChangeCallBack", "getOrientationChangeCallBack()Lcom/baidu/searchbox/live/shell/list/basic/MixYYFakeShell$OrientationChangeCallBack;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MixYYFakeShell.class), "invokeAbility", "getInvokeAbility()Lcom/baidu/searchbox/live/shell/list/basic/MixYYFakeShell$invokeAbility$2$1;"))};
        Companion = new Companion(null);
    }

    private final MixYYFakeShell$invokeAbility$2.AnonymousClass1 getInvokeAbility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            Lazy lazy = this.invokeAbility$delegate;
            KProperty kProperty = $$delegatedProperties[1];
            return (MixYYFakeShell$invokeAbility$2.AnonymousClass1) lazy.getValue();
        }
        return (MixYYFakeShell$invokeAbility$2.AnonymousClass1) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OrientationChangeCallBack getOrientationChangeCallBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            Lazy lazy = this.orientationChangeCallBack$delegate;
            KProperty kProperty = $$delegatedProperties[0];
            return (OrientationChangeCallBack) lazy.getValue();
        }
        return (OrientationChangeCallBack) invokeV.objValue;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\b\u0082\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0007\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/live/shell/list/basic/MixYYFakeShell$Companion;", "", "ROOM_ID_YY", "Ljava/lang/String;", "SID_CONST_KEY", "", "hasSelected", "Z", "getHasSelected", "()Z", "setHasSelected", "(Z)V", "isLoadPlugin", "setLoadPlugin", "", "lastContextHashCode", "I", "getLastContextHashCode", "()I", "setLastContextHashCode", "(I)V", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Companion() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final boolean getHasSelected() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                return invokeV.booleanValue;
            }
            return MixYYFakeShell.hasSelected;
        }

        public final int getLastContextHashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
                return invokeV.intValue;
            }
            return MixYYFakeShell.lastContextHashCode;
        }

        public final boolean isLoadPlugin() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) != null) {
                return invokeV.booleanValue;
            }
            return MixYYFakeShell.isLoadPlugin;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void setHasSelected(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048579, this, z) != null) {
                return;
            }
            MixYYFakeShell.hasSelected = z;
        }

        public final void setLastContextHashCode(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(1048580, this, i) != null) {
                return;
            }
            MixYYFakeShell.lastContextHashCode = i;
        }

        public final void setLoadPlugin(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048581, this, z) != null) {
                return;
            }
            MixYYFakeShell.isLoadPlugin = z;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0011R\u0016\u0010\u001d\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0011¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/live/shell/list/basic/MixYYFakeShell$OrientationChangeCallBack;", "com/baidu/searchbox/player/helper/OrientationHelper$IOrientationChange", "", "i", "", "onOrientationChanged", "(I)V", "DELAY_TIME", "I", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "activityRef", "Ljava/lang/ref/WeakReference;", "getActivityRef", "()Ljava/lang/ref/WeakReference;", "", "canChangeOrientation", "Z", "getCanChangeOrientation", "()Z", "setCanChangeOrientation", "(Z)V", "fullScreenMode", "getFullScreenMode", "setFullScreenMode", "", "mChangedTime", "J", "mIsLandscape", "mIsPortrait", "<init>", "(Ljava/lang/ref/WeakReference;)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class OrientationChangeCallBack implements OrientationHelper.IOrientationChange {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int DELAY_TIME;
        public final WeakReference<Activity> activityRef;
        public boolean canChangeOrientation;
        public boolean fullScreenMode;
        public long mChangedTime;
        public boolean mIsLandscape;
        public boolean mIsPortrait;

        public OrientationChangeCallBack(WeakReference<Activity> weakReference) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {weakReference};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.activityRef = weakReference;
            this.DELAY_TIME = 1000;
        }

        public final WeakReference<Activity> getActivityRef() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.activityRef;
            }
            return (WeakReference) invokeV.objValue;
        }

        public final boolean getCanChangeOrientation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.canChangeOrientation;
            }
            return invokeV.booleanValue;
        }

        public final boolean getFullScreenMode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.fullScreenMode;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.searchbox.player.helper.OrientationHelper.IOrientationChange
        public void onOrientationChanged(int i) {
            Activity activity;
            Activity activity2;
            Activity activity3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || !this.canChangeOrientation || OrientationHelper.isSystemOrientationLocked(MiniShellRuntime.INSTANCE.getAppApplication())) {
                return;
            }
            if (!this.fullScreenMode) {
                this.mIsLandscape = false;
                if (OrientationHelper.isPortrait(i)) {
                    this.mIsPortrait = true;
                }
                if (this.mIsPortrait && System.currentTimeMillis() - this.mChangedTime > this.DELAY_TIME) {
                    if (OrientationHelper.isReverseLandscape(i)) {
                        this.mIsLandscape = true;
                        WeakReference<Activity> weakReference = this.activityRef;
                        if (weakReference != null && (activity3 = weakReference.get()) != null) {
                            BdActivityUtils.requestLandscape(activity3, true);
                            return;
                        }
                        return;
                    } else if (OrientationHelper.isLandscape(i)) {
                        this.mIsLandscape = true;
                        WeakReference<Activity> weakReference2 = this.activityRef;
                        if (weakReference2 != null && (activity2 = weakReference2.get()) != null) {
                            BdActivityUtils.requestLandscape(activity2, false);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            this.mIsPortrait = false;
            if (OrientationHelper.isPortrait(i) && this.mIsLandscape && System.currentTimeMillis() - this.mChangedTime > this.DELAY_TIME) {
                this.mChangedTime = System.currentTimeMillis();
                this.mIsLandscape = false;
                WeakReference<Activity> weakReference3 = this.activityRef;
                if (weakReference3 != null && (activity = weakReference3.get()) != null) {
                    BdActivityUtils.requestPortrait(activity);
                }
            }
        }

        public final void setCanChangeOrientation(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
                this.canChangeOrientation = z;
            }
        }

        public final void setFullScreenMode(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
                this.fullScreenMode = z;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MixYYFakeShell(Context context, MiniUniqueId miniUniqueId, IMixActivityInterface iMixActivityInterface) {
        super(context, miniUniqueId, iMixActivityInterface);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, miniUniqueId, iMixActivityInterface};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (MiniUniqueId) objArr2[1], (IMixActivityInterface) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.orientationChangeCallBack$delegate = LazyKt__LazyJVMKt.lazy(new MixYYFakeShell$orientationChangeCallBack$2(context));
        this.handler = new Handler(Looper.getMainLooper());
        this.pluginInvokeService = (PluginInvokeService) ServiceManager.getService(PluginInvokeService.Companion.getSERVICE_REFERENCE());
        this.invokeAbility$delegate = LazyKt__LazyJVMKt.lazy(new MixYYFakeShell$invokeAbility$2(this));
    }

    private final void registerRoomInfoService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            ServiceLocator.Companion.registerGlobalServices(LiveMixRoomInfoService.class, new LiveMixRoomInfoService(this) { // from class: com.baidu.searchbox.live.shell.list.basic.MixYYFakeShell$registerRoomInfoService$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MixYYFakeShell this$0;

                /* JADX DEBUG: Incorrect args count in method signature: ()V */
                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.searchbox.live.service.LiveMixRoomInfoService
                public void updateRoomInfo(MixRoomInfo mixRoomInfo) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mixRoomInfo) != null) {
                        return;
                    }
                    this.this$0.mixRoomInfo = mixRoomInfo;
                }

                @Override // com.baidu.searchbox.live.service.LiveMixRoomInfoService
                public MixRoomInfo getRoomInfo() {
                    InterceptResult invokeV;
                    MixRoomInfo mixRoomInfo;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                        return (MixRoomInfo) invokeV.objValue;
                    }
                    mixRoomInfo = this.this$0.mixRoomInfo;
                    return mixRoomInfo;
                }
            });
        }
    }

    public final int getCurPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.curPosition;
        }
        return invokeV.intValue;
    }

    public final Handler getHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.handler;
        }
        return (Handler) invokeV.objValue;
    }

    public final MixLiveInterface getMixLiveImpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mixLiveImpl;
        }
        return (MixLiveInterface) invokeV.objValue;
    }

    public final void hideActivityBackground() {
        MixNotifyBackgroundService mixNotifyBackgroundService;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (mixNotifyBackgroundService = (MixNotifyBackgroundService) ServiceLocator.Companion.getGlobalService(MixNotifyBackgroundService.class)) != null) {
            mixNotifyBackgroundService.hideActivityBackground();
        }
    }

    public final boolean isSelected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.isSelected;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.shell.list.basic.AbstractMixFakeShell
    public void onLiveDeselected() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            log("RoomLifrCycle MixLiveShell onLiveDeselected selectSetFalse");
            onRealDetach();
        }
    }

    @Override // com.baidu.searchbox.live.shell.list.basic.AbstractMixFakeShell
    public void onLiveDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            log("RoomLifrCycle MixLiveShell onLiveDetach");
            onRealDetach();
        }
    }

    public final void showActivityBackground() {
        MixNotifyBackgroundService mixNotifyBackgroundService;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && (mixNotifyBackgroundService = (MixNotifyBackgroundService) ServiceLocator.Companion.getGlobalService(MixNotifyBackgroundService.class)) != null) {
            mixNotifyBackgroundService.showActivityBackground();
        }
    }

    public final void setCurPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.curPosition = i;
        }
    }

    public final void setHandler(Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, handler) == null) {
            this.handler = handler;
        }
    }

    public final void setMixLiveImpl(MixLiveInterface mixLiveInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, mixLiveInterface) == null) {
            this.mixLiveImpl = mixLiveInterface;
            if (mixLiveInterface != null) {
                mixLiveInterface.setInvokeListener(getInvokeAbility());
            }
        }
    }

    public final void setSelected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.isSelected = z;
        }
    }

    private final void checkImpl() {
        Object obj;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65548, this) == null) && this.mixLiveImpl == null && MiniPluginManager.INSTANCE.isYYPluginAvailable()) {
            try {
                PluginInvokeService pluginInvokeService = this.pluginInvokeService;
                MixLiveInterface mixLiveInterface = null;
                if (pluginInvokeService != null) {
                    obj = pluginInvokeService.createYYMixLiveImpl();
                } else {
                    obj = null;
                }
                if (obj instanceof MixLiveInterface) {
                    mixLiveInterface = obj;
                }
                setMixLiveImpl(mixLiveInterface);
                log("call create mixliveimpl");
            } catch (Throwable th) {
                log("call create crash throwable th: " + th);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.isDestroy = true;
            log("MixLiveShell onDestroy ");
            OrientationHelper orientationHelper = this.mOrientationHelper;
            if (orientationHelper != null) {
                orientationHelper.disable();
            }
            this.mOrientationHelper = null;
            checkImpl();
            try {
                MixLiveInterface mixLiveInterface = this.mixLiveImpl;
                if (mixLiveInterface != null) {
                    mixLiveInterface.onDestroy();
                }
            } catch (Throwable th) {
                log("onDestroy crash throwable th：" + th);
            }
            isLoadPlugin = false;
            ServiceLocator.Companion.unregisterGlobalService(LiveMixRoomInfoService.class);
            MixEventBus.getInstance().unRegister(this);
            Handler handler = this.handler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        }
    }

    @Override // com.baidu.searchbox.live.shell.list.basic.AbstractMixFakeShell
    public void onLiveAttach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onLiveAttach();
            log("RoomLifrCycle MixLiveShell onLiveAttach ");
            Lifecycle lifeCycle = getMixActivity().getLifeCycle();
            if (lifeCycle != null) {
                lifeCycle.addObserver(this);
            }
            MixEventBus.getInstance().register(this, YYPluginEvent.LoadYYPluginRes.class, this);
            checkImpl();
            try {
                MixLiveInterface mixLiveInterface = this.mixLiveImpl;
                if (mixLiveInterface != null) {
                    LiveContainer liveContainer = getLiveContainer();
                    if (liveContainer == null) {
                        Intrinsics.throwNpe();
                    }
                    MixLiveItemModel mixLiveItemModel = this.mixModel;
                    if (mixLiveItemModel == null) {
                        Intrinsics.throwNpe();
                    }
                    mixLiveInterface.onLiveAttach(liveContainer, mixLiveItemModel);
                }
            } catch (Throwable th) {
                log("onLiveAttach crash throwable th：" + th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void log(String str) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, str) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" mixLiveImpl:");
            MixLiveInterface mixLiveInterface = this.mixLiveImpl;
            if (mixLiveInterface != null) {
                i = mixLiveInterface.hashCode();
            } else {
                i = 0;
            }
            sb.append(i);
            sb.append(" this:");
            sb.append(hashCode());
            sb.append(WebvttCueParser.CHAR_SPACE);
            sb.append("context:");
            sb.append(getContext().hashCode());
            ListLogKt.log(MixTagConstants.MIX_YY_LIVE, sb.toString());
        }
    }

    private final void onRealDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            log("RoomLifrCycle MixLiveShell onRealDetach");
            if (!this.isDetach) {
                this.isDetach = true;
                super.onLiveDetach();
                Lifecycle lifeCycle = getMixActivity().getLifeCycle();
                if (lifeCycle != null) {
                    lifeCycle.removeObserver(this);
                }
                MixEventBus.getInstance().unRegister(this);
                checkImpl();
                if (this.isSelected) {
                    log("RoomLifrCycle MixLiveShell onLiveDetach onLiveDeselected");
                    try {
                        MixLiveInterface mixLiveInterface = this.mixLiveImpl;
                        if (mixLiveInterface != null) {
                            LiveContainer liveContainer = getLiveContainer();
                            if (liveContainer == null) {
                                Intrinsics.throwNpe();
                            }
                            mixLiveInterface.onLiveDeselected(liveContainer);
                        }
                    } catch (Throwable th) {
                        log("onLiveDetach crash throwable th：" + th);
                    }
                }
                log("RoomLifrCycle MixLiveShell onLiveDetach selectSetFalse isSelected: " + this.isSelected);
                try {
                    MixLiveInterface mixLiveInterface2 = this.mixLiveImpl;
                    if (mixLiveInterface2 != null) {
                        mixLiveInterface2.onLiveDetach();
                    }
                } catch (Throwable th2) {
                    log("onLiveDetach crash throwable th: " + th2);
                }
                this.yyView = null;
            }
            this.isSelected = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.live.eventbus.EventAction
    public void call(AbstractEvent abstractEvent) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, abstractEvent) == null) && abstractEvent != null && abstractEvent.getUniqueId() == getMixUniqueId().getId() && (abstractEvent instanceof YYPluginEvent.LoadYYPluginRes) && ((YYPluginEvent.LoadYYPluginRes) abstractEvent).getRes() == 2) {
            if (this.isDestroy) {
                log("load plugin suc but is destroy");
                return;
            }
            log("MixLiveShell LoadYYPluginSuc isSelected: " + this.isSelected);
            checkImpl();
            try {
                MixLiveInterface mixLiveInterface = this.mixLiveImpl;
                if (mixLiveInterface != null) {
                    Context context = getContext();
                    if (context != null) {
                        mixLiveInterface.attachActivity((Activity) context);
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
                    }
                }
            } catch (Throwable th) {
                log("mixLiveImpl attachActivity th: " + th.getMessage());
            }
            try {
                MixLiveInterface mixLiveInterface2 = this.mixLiveImpl;
                if (mixLiveInterface2 != null) {
                    mixLiveInterface2.onCreate();
                }
            } catch (Throwable th2) {
                log("mixLiveImpl onCreate th: " + th2.getMessage());
            }
            try {
                MixLiveInterface mixLiveInterface3 = this.mixLiveImpl;
                if (mixLiveInterface3 != null) {
                    mixLiveInterface3.onStart();
                }
            } catch (Throwable th3) {
                log("mixLiveImpl onStart th: " + th3.getMessage());
            }
            if (this.isSelected) {
                if (this.yyView == null) {
                    try {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        MixLiveInterface mixLiveInterface4 = this.mixLiveImpl;
                        if (mixLiveInterface4 != null) {
                            view2 = mixLiveInterface4.createLiveView(getContext());
                        } else {
                            view2 = null;
                        }
                        this.yyView = view2;
                        log("MixLiveShell recreateLiveView " + view2);
                        if (view2 != null) {
                            if (view2.getParent() != null) {
                                if (!Intrinsics.areEqual(view2.getParent(), getLiveContainer())) {
                                    log("LoadYYPluginRes yyView remove old parent");
                                    ViewParent parent = view2.getParent();
                                    if (parent != null) {
                                        ((ViewGroup) parent).removeView(view2);
                                        LiveContainer liveContainer = getLiveContainer();
                                        if (liveContainer != null) {
                                            liveContainer.addView(view2, layoutParams);
                                        }
                                    } else {
                                        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
                                    }
                                }
                            } else {
                                LiveContainer liveContainer2 = getLiveContainer();
                                if (liveContainer2 != null) {
                                    liveContainer2.addView(view2, layoutParams);
                                }
                            }
                        }
                    } catch (Throwable th4) {
                        log("recreateLiveView crash throwable th :" + th4);
                    }
                }
                try {
                    MixLiveInterface mixLiveInterface5 = this.mixLiveImpl;
                    if (mixLiveInterface5 != null) {
                        mixLiveInterface5.onResume();
                    }
                } catch (Throwable th5) {
                    log("mixLiveImpl onResume th: " + th5.getMessage());
                }
                try {
                    MixLiveInterface mixLiveInterface6 = this.mixLiveImpl;
                    if (mixLiveInterface6 != null) {
                        LiveContainer liveContainer3 = getLiveContainer();
                        if (liveContainer3 == null) {
                            Intrinsics.throwNpe();
                        }
                        MixLiveItemModel mixLiveItemModel = this.mixModel;
                        if (mixLiveItemModel == null) {
                            Intrinsics.throwNpe();
                        }
                        mixLiveInterface6.onLiveAttach(liveContainer3, mixLiveItemModel);
                    }
                } catch (Throwable th6) {
                    log("mixLiveImpl onLiveAttach th: " + th6.getMessage());
                }
                try {
                    MixLiveInterface mixLiveInterface7 = this.mixLiveImpl;
                    if (mixLiveInterface7 != null) {
                        MixLiveItemModel mixLiveItemModel2 = this.mixModel;
                        if (mixLiveItemModel2 == null) {
                            Intrinsics.throwNpe();
                        }
                        mixLiveInterface7.onLiveBindData(mixLiveItemModel2);
                    }
                } catch (Throwable th7) {
                    log("mixLiveImpl onLiveBindData th: " + th7.getMessage());
                }
                try {
                    MixLiveInterface mixLiveInterface8 = this.mixLiveImpl;
                    if (mixLiveInterface8 != null) {
                        int i = this.curPosition;
                        LiveContainer liveContainer4 = getLiveContainer();
                        if (liveContainer4 == null) {
                            Intrinsics.throwNpe();
                        }
                        MixLiveItemModel mixLiveItemModel3 = this.mixModel;
                        if (mixLiveItemModel3 == null) {
                            Intrinsics.throwNpe();
                        }
                        mixLiveInterface8.onLiveSelected(i, liveContainer4, mixLiveItemModel3, false);
                        return;
                    }
                    return;
                } catch (Throwable th8) {
                    log("mixLiveImpl onLiveSelected th: " + th8.getMessage());
                    return;
                }
            }
            log("load plugin suc but not selected");
        }
    }

    @Override // com.baidu.searchbox.live.shell.list.basic.AbstractMixFakeShell
    public void onLiveBindData(LiveContainer.LiveItemModel liveItemModel) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String str11;
        JSONObject jSONObject3;
        String str12;
        JSONObject jSONObject4;
        IntentData intent;
        String liveSource;
        JSONObject originJson;
        String str13;
        JSONObject optJSONObject;
        String optString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, liveItemModel) == null) {
            super.onLiveBindData(liveItemModel);
            log("MixLiveShell onLiveBindData " + liveItemModel.getRoomId() + WebvttCueParser.CHAR_SPACE + liveItemModel.getTitle());
            JSONObject originJson2 = liveItemModel.getOriginJson();
            if (originJson2 != null) {
                str = originJson2.optString("sid");
            } else {
                str = null;
            }
            JSONObject originJson3 = liveItemModel.getOriginJson();
            if (originJson3 != null) {
                str2 = originJson3.optString(YyLiveRoomConfig.KEY_SSID);
            } else {
                str2 = null;
            }
            JSONObject originJson4 = liveItemModel.getOriginJson();
            if (originJson4 != null) {
                str3 = originJson4.optString("templateId");
            } else {
                str3 = null;
            }
            JSONObject originJson5 = liveItemModel.getOriginJson();
            if (originJson5 != null) {
                str4 = originJson5.optString("token");
            } else {
                str4 = null;
            }
            JSONObject originJson6 = liveItemModel.getOriginJson();
            if (originJson6 != null) {
                str5 = originJson6.optString("recommend");
            } else {
                str5 = null;
            }
            JSONObject originJson7 = liveItemModel.getOriginJson();
            if (originJson7 != null) {
                str6 = originJson7.optString("anchorUid");
            } else {
                str6 = null;
            }
            JSONObject originJson8 = liveItemModel.getOriginJson();
            if (originJson8 != null) {
                str7 = originJson8.optString("thumb");
            } else {
                str7 = null;
            }
            JSONObject originJson9 = liveItemModel.getOriginJson();
            if (originJson9 != null) {
                str8 = originJson9.optString("from");
            } else {
                str8 = null;
            }
            JSONObject originJson10 = liveItemModel.getOriginJson();
            if (originJson10 != null) {
                str9 = originJson10.optString("tpl");
            } else {
                str9 = null;
            }
            JSONObject originJson11 = liveItemModel.getOriginJson();
            if (originJson11 != null) {
                str10 = originJson11.optString(YyLiveRoomConfig.KEY_STREAMINFO);
            } else {
                str10 = null;
            }
            try {
                jSONObject = new JSONObject(str10);
            } catch (Exception unused) {
                jSONObject = null;
            }
            JSONObject originJson12 = liveItemModel.getOriginJson();
            if (originJson12 != null) {
                jSONObject2 = originJson12.optJSONObject("ext");
            } else {
                jSONObject2 = null;
            }
            JSONObject originJson13 = liveItemModel.getOriginJson();
            if (originJson13 != null) {
                str11 = originJson13.optString("extLog");
            } else {
                str11 = null;
            }
            try {
                jSONObject3 = new JSONObject(str11);
            } catch (Exception e) {
                e.printStackTrace();
                jSONObject3 = null;
            }
            if (jSONObject3 == null) {
                jSONObject3 = new JSONObject();
            }
            AppInfoService appInfoService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
            String str14 = "";
            JSONObject jSONObject5 = jSONObject;
            jSONObject3.put(SID_CONST_KEY, (appInfoService == null || (r0 = appInfoService.getSid()) == null) ? "" : "");
            jSONObject3.put(ROOM_ID_YY, liveItemModel.getRoomId());
            JSONObject slog = liveItemModel.getSlog();
            if (slog != null && (optJSONObject = slog.optJSONObject("rec_ext")) != null && (optString = optJSONObject.optString("vt_ctr_fea")) != null) {
                str12 = str9;
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("vt_ctr_fea", optString);
                jSONObject3.put("gr_ext", jSONObject6);
            } else {
                str12 = str9;
            }
            JSONObject originJson14 = liveItemModel.getOriginJson();
            if (originJson14 != null) {
                jSONObject4 = originJson14.optJSONObject("extendInfo");
            } else {
                jSONObject4 = null;
            }
            if (jSONObject4 == null) {
                jSONObject4 = new JSONObject();
            }
            if (TextUtils.isEmpty(jSONObject4.optString("ext"))) {
                if (jSONObject2 != null) {
                    str13 = jSONObject2.toString();
                } else {
                    str13 = null;
                }
                jSONObject4.put("ext", str13);
            }
            jSONObject4.put("extLog", jSONObject3);
            JSONObject originJson15 = liveItemModel.getOriginJson();
            jSONObject4.put("extSchema", (originJson15 == null || (r2 = originJson15.optString("extSchema", "")) == null) ? "" : "");
            if (!hasSelected && (originJson = liveItemModel.getOriginJson()) != null && originJson.optInt("isMix") == 1) {
                jSONObject4.put("firstJump", 1);
            } else {
                jSONObject4.remove("firstJump");
            }
            ILiveListState iLiveListState = (ILiveListState) ServiceLocator.Companion.getGlobalService(ILiveListState.class);
            if (iLiveListState != null && (intent = iLiveListState.getIntent()) != null && (liveSource = intent.getLiveSource()) != null) {
                str14 = liveSource;
            }
            MixLiveItemModel mixLiveItemModel = new MixLiveItemModel(liveItemModel.getRoomId(), str, str2, str3, str4, str5, str6, str7, str8, str12, jSONObject5, jSONObject4, liveItemModel.getCover(), liveItemModel.getLiveType(), liveItemModel.getScheme(), liveItemModel.getPlayUrl(), str14, liveItemModel.getOtherParams(), null);
            this.mixModel = mixLiveItemModel;
            log("MixLiveShell onLiveBindData mixModel=" + mixLiveItemModel.toString());
        }
    }

    @Override // com.baidu.searchbox.live.shell.list.basic.AbstractMixFakeShell
    public View createContainerView() {
        InterceptResult invokeV;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int hashCode = getContext().hashCode();
            int i = lastContextHashCode;
            if (i == 0 || i != hashCode) {
                hasSelected = false;
                lastContextHashCode = hashCode;
                log("MixLiveShell createContainerView rest hasSelected");
            }
            log("MixLiveShell createLiveView ");
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            checkImpl();
            Application appApplication = MiniShellRuntime.INSTANCE.getAppApplication();
            if (appApplication != null) {
                OrientationHelper orientationHelper = new OrientationHelper(appApplication, 3);
                this.mOrientationHelper = orientationHelper;
                if (orientationHelper != null && orientationHelper.canDetectOrientation()) {
                    OrientationHelper orientationHelper2 = this.mOrientationHelper;
                    if (orientationHelper2 != null) {
                        orientationHelper2.enableSensor();
                    }
                    OrientationHelper orientationHelper3 = this.mOrientationHelper;
                    if (orientationHelper3 != null) {
                        orientationHelper3.setListener(getOrientationChangeCallBack());
                    }
                }
            }
            try {
                MixLiveInterface mixLiveInterface = this.mixLiveImpl;
                if (mixLiveInterface != null) {
                    view2 = mixLiveInterface.createLiveView(getContext());
                } else {
                    view2 = null;
                }
                this.yyView = view2;
                if (view2 != null) {
                    if (view2.getParent() != null) {
                        if (true ^ Intrinsics.areEqual(view2.getParent(), getLiveContainer())) {
                            log("createContainerView yyView remove old parent");
                            ViewParent parent = view2.getParent();
                            if (parent != null) {
                                ((ViewGroup) parent).removeView(view2);
                                LiveContainer liveContainer = getLiveContainer();
                                if (liveContainer != null) {
                                    liveContainer.addView(view2, layoutParams);
                                }
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
                            }
                        }
                    } else {
                        LiveContainer liveContainer2 = getLiveContainer();
                        if (liveContainer2 != null) {
                            liveContainer2.addView(view2, layoutParams);
                        }
                    }
                }
                log("MixLiveShell createLiveView " + view2);
            } catch (Throwable th) {
                log("LiveContainer createLiveView crash throwable th: " + th);
            }
            return getLiveContainer();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.shell.list.basic.AbstractMixFakeShell, com.baidu.live.arch.api.IExtLifecycle
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            log("MixLiveShell onActivityResult " + i + " " + i2 + " " + intent);
            checkImpl();
            try {
                MixLiveInterface mixLiveInterface = this.mixLiveImpl;
                if (mixLiveInterface != null) {
                    mixLiveInterface.onActivityResult(i, i2, intent);
                }
            } catch (Throwable th) {
                log("onActivityResult crash throwable th：" + th);
            }
        }
    }

    @Override // com.baidu.searchbox.live.shell.list.basic.AbstractMixFakeShell, com.baidu.live.arch.api.IExtLifecycle
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            log("MixLiveShell onConfigurationChanged ");
            checkImpl();
            try {
                MixLiveInterface mixLiveInterface = this.mixLiveImpl;
                if (mixLiveInterface != null) {
                    mixLiveInterface.onConfigurationChanged(configuration);
                }
            } catch (Throwable th) {
                log("onConfigurationChanged crash throwable th：" + th);
            }
        }
    }

    @Override // com.baidu.searchbox.live.shell.list.basic.AbstractMixFakeShell, com.baidu.live.arch.api.IExtLifecycle
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, intent) == null) {
            super.onNewIntent(intent);
            log("MixLiveShell onNewIntent ");
            hasSelected = false;
            checkImpl();
            try {
                MixLiveInterface mixLiveInterface = this.mixLiveImpl;
                if (mixLiveInterface != null) {
                    mixLiveInterface.onNewIntent(intent);
                }
            } catch (Throwable th) {
                log("onNewIntent crash throwable th：" + th);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.isDestroy = false;
            log("MixLiveShell onCreate ");
            checkImpl();
            registerRoomInfoService();
            try {
                MixLiveInterface mixLiveInterface = this.mixLiveImpl;
                if (mixLiveInterface != null) {
                    Context context = getContext();
                    if (context != null) {
                        mixLiveInterface.attachActivity((Activity) context);
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
                    }
                }
            } catch (Throwable th) {
                log("onCreate attachActivity crash throwable th：" + th);
            }
            try {
                MixLiveInterface mixLiveInterface2 = this.mixLiveImpl;
                if (mixLiveInterface2 != null) {
                    mixLiveInterface2.onCreate();
                }
            } catch (Throwable th2) {
                log("onCreate onCreate crash throwable th：" + th2);
            }
        }
    }

    @Override // com.baidu.searchbox.live.shell.list.basic.AbstractMixFakeShell, com.baidu.live.arch.api.IExtLifecycle
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i, keyEvent)) == null) {
            log("MixLiveShell onKeyDown " + i);
            checkImpl();
            if (!super.onKeyDown(i, keyEvent)) {
                MixLiveInterface mixLiveInterface = this.mixLiveImpl;
                if (mixLiveInterface != null) {
                    z = mixLiveInterface.onKeyDown(i, keyEvent);
                } else {
                    z = false;
                }
                if (!z) {
                    return false;
                }
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.searchbox.live.shell.list.basic.AbstractMixFakeShell
    public void onLiveSelected(int i, LiveContainer.LiveItemModel liveItemModel, boolean z) {
        View view2;
        ImagePipeline imagePipeline;
        String str;
        MixLiveItemModel mixLiveItemModel;
        String roomId;
        MixLiveItemModel mixLiveItemModel2;
        JSONObject extendInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i), liveItemModel, Boolean.valueOf(z)}) == null) {
            super.onLiveSelected(i, liveItemModel, z);
            this.isDetach = false;
            MediaLivePluginLogger.Companion.getInstance().logLiveRoomLeave("yyLive");
            this.curPosition = i;
            if (!isLoadPlugin) {
                isLoadPlugin = true;
                MixEventBus mixEventBus = MixEventBus.getInstance();
                YYPluginEvent.StartLoadYYPluginEvent startLoadYYPluginEvent = YYPluginEvent.StartLoadYYPluginEvent.INSTANCE;
                startLoadYYPluginEvent.setUniqueId(getMixUniqueId().getId());
                mixEventBus.post(startLoadYYPluginEvent);
            }
            log("RoomLifrCycle MixLiveShell onLiveSelected ");
            checkImpl();
            if (this.yyView == null) {
                try {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    MixLiveInterface mixLiveInterface = this.mixLiveImpl;
                    if (mixLiveInterface != null) {
                        view2 = mixLiveInterface.createLiveView(getContext());
                    } else {
                        view2 = null;
                    }
                    this.yyView = view2;
                    log("MixLiveShell recreateLiveView " + view2);
                    if (view2 != null) {
                        if (view2.getParent() != null) {
                            if (!Intrinsics.areEqual(view2.getParent(), getLiveContainer())) {
                                log("onLiveSelected yyView remove old parent");
                                ViewParent parent = view2.getParent();
                                if (parent != null) {
                                    ((ViewGroup) parent).removeView(view2);
                                    LiveContainer liveContainer = getLiveContainer();
                                    if (liveContainer != null) {
                                        liveContainer.addView(view2, layoutParams);
                                    }
                                } else {
                                    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
                                }
                            }
                        } else {
                            LiveContainer liveContainer2 = getLiveContainer();
                            if (liveContainer2 != null) {
                                liveContainer2.addView(view2, layoutParams);
                            }
                        }
                    }
                } catch (Throwable th) {
                    log("onLiveSelected yyView create crash throwable th: " + th);
                }
            }
            this.isSelected = true;
            log("RoomLifrCycle MixLiveShell onLiveSelected selectSetTrue :" + this.isSelected);
            if (hasSelected && (mixLiveItemModel2 = this.mixModel) != null && (extendInfo = mixLiveItemModel2.getExtendInfo()) != null) {
                extendInfo.remove("firstJump");
            }
            if (MiniPluginManager.INSTANCE.isMediaPluginAvailable() && (mixLiveItemModel = this.mixModel) != null && (roomId = mixLiveItemModel.getRoomId()) != null) {
                MixEventBus mixEventBus2 = MixEventBus.getInstance();
                MixMediaEvent.YYGoBackPopUp yYGoBackPopUp = new MixMediaEvent.YYGoBackPopUp(roomId);
                yYGoBackPopUp.setUniqueId(getMixUniqueId().getId());
                mixEventBus2.post(yYGoBackPopUp);
            }
            try {
                MixLiveInterface mixLiveInterface2 = this.mixLiveImpl;
                if (mixLiveInterface2 != null) {
                    MixLiveItemModel mixLiveItemModel3 = this.mixModel;
                    if (mixLiveItemModel3 == null) {
                        Intrinsics.throwNpe();
                    }
                    mixLiveInterface2.onLiveBindData(mixLiveItemModel3);
                }
            } catch (Throwable th2) {
                log("mixLiveImpl onLiveBindData crash throwable th: " + th2);
            }
            try {
                MixLiveInterface mixLiveInterface3 = this.mixLiveImpl;
                if (mixLiveInterface3 != null) {
                    LiveContainer liveContainer3 = getLiveContainer();
                    if (liveContainer3 == null) {
                        Intrinsics.throwNpe();
                    }
                    MixLiveItemModel mixLiveItemModel4 = this.mixModel;
                    if (mixLiveItemModel4 == null) {
                        Intrinsics.throwNpe();
                    }
                    mixLiveInterface3.onLiveSelected(i, liveContainer3, mixLiveItemModel4, false);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("MixLiveShell onLiveSelected item=");
                MixLiveItemModel mixLiveItemModel5 = this.mixModel;
                if (mixLiveItemModel5 != null) {
                    str = mixLiveItemModel5.toString();
                } else {
                    str = null;
                }
                sb.append(str);
                log(sb.toString());
            } catch (Throwable th3) {
                log("mixLiveImpl?.onLiveSelected crash throwable th$ " + th3);
            }
            LiveItemModelListService liveItemModelListService = (LiveItemModelListService) ServiceLocator.Companion.getGlobalService(LiveItemModelListService.class);
            if (liveItemModelListService != null) {
                List<LiveContainer.LiveItemModel> liveItemModels = liveItemModelListService.getLiveItemModels();
                if (liveItemModelListService.getCurrentPosition() >= 0 && liveItemModelListService.getCurrentPosition() + 1 < liveItemModels.size()) {
                    int currentPosition = liveItemModelListService.getCurrentPosition() + 1;
                    if (!liveItemModels.get(currentPosition).isYYLive() && (imagePipeline = Fresco.getImagePipeline()) != null) {
                        imagePipeline.prefetchToBitmapCache(ImageRequest.fromUri(liveItemModels.get(currentPosition).getCover()), null);
                    }
                }
            }
            hasSelected = true;
            log("MixLiveShell hasSelected " + hasSelected);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            log("MixLiveShell onPause ");
            checkImpl();
            try {
                MixLiveInterface mixLiveInterface = this.mixLiveImpl;
                if (mixLiveInterface != null) {
                    mixLiveInterface.onPause();
                }
            } catch (Throwable th) {
                log("onPause crash throwable th：" + th);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            log("MixLiveShell onResume ");
            checkImpl();
            try {
                MixLiveInterface mixLiveInterface = this.mixLiveImpl;
                if (mixLiveInterface != null) {
                    mixLiveInterface.onResume();
                }
            } catch (Throwable th) {
                log("onResume crash throwable th：" + th);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            log("MixLiveShell onStart ");
            checkImpl();
            try {
                MixLiveInterface mixLiveInterface = this.mixLiveImpl;
                if (mixLiveInterface != null) {
                    mixLiveInterface.onStart();
                }
            } catch (Throwable th) {
                log("onStart crash throwable th： " + th);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            log("MixLiveShell onStop ");
            checkImpl();
            try {
                MixLiveInterface mixLiveInterface = this.mixLiveImpl;
                if (mixLiveInterface != null) {
                    mixLiveInterface.onStop();
                }
            } catch (Throwable th) {
                log("onStop crash throwable th：" + th);
            }
        }
    }

    @Override // com.baidu.searchbox.live.shell.list.basic.AbstractMixFakeShell, com.baidu.live.arch.api.IExtLifecycle
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048596, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
            log("MixLiveShell onRequestPermissionsResult ");
            checkImpl();
            try {
                MixLiveInterface mixLiveInterface = this.mixLiveImpl;
                if (mixLiveInterface != null) {
                    mixLiveInterface.onRequestPermissionsResult(i, strArr, iArr);
                }
            } catch (Throwable th) {
                log("onRequestPermissionsResult crash throwable th：" + th);
            }
        }
    }
}
