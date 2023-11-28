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
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.live.arch.ServiceLocator;
import com.baidu.live.arch.runtime.MiniShellRuntime;
import com.baidu.live.arch.utils.MiniUniqueId;
import com.baidu.live.mix.MixLiveItemModel;
import com.baidu.live.mix.interfaces.InvokeAbility;
import com.baidu.live.mix.interfaces.MixLiveInterface;
import com.baidu.live.mix.interfaces.MixPagerInfoService;
import com.baidu.live.mix.interfaces.MixShellServiceCenter;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.download.util.LocalFilesFilterKt;
import com.baidu.searchbox.live.action.AbstractEvent;
import com.baidu.searchbox.live.action.MixMediaEvent;
import com.baidu.searchbox.live.action.YYPluginEvent;
import com.baidu.searchbox.live.component.service.LiveItemModelListService;
import com.baidu.searchbox.live.data.constant.MixTagConstants;
import com.baidu.searchbox.live.data.constant.MixYaLogConstants;
import com.baidu.searchbox.live.eventbus.EventAction;
import com.baidu.searchbox.live.eventbus.MixEventBus;
import com.baidu.searchbox.live.frame.IntentData;
import com.baidu.searchbox.live.interfaces.context.PluginContextUtil;
import com.baidu.searchbox.live.interfaces.mix.IMixActivityInterface;
import com.baidu.searchbox.live.interfaces.mix.PluginInvokeService;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.mix.MixRoomInfo;
import com.baidu.searchbox.live.pluginmanager.MiniPluginManager;
import com.baidu.searchbox.live.service.ILiveListState;
import com.baidu.searchbox.live.service.LiveMixRoomInfoService;
import com.baidu.searchbox.live.service.MixListOperatorInterface;
import com.baidu.searchbox.live.service.MixNotifyBackgroundService;
import com.baidu.searchbox.live.service.MixRequestServiceLocator;
import com.baidu.searchbox.live.service.MixYaLogService;
import com.baidu.searchbox.live.shell.list.basic.MixYYFakeShell;
import com.baidu.searchbox.live.shell.list.basic.MixYYFakeShell$invokeAbility$2;
import com.baidu.searchbox.live.ubc.MediaLivePluginLogger;
import com.baidu.searchbox.live.util.ListLogKt;
import com.baidu.searchbox.live.widget.LiveContainer;
import com.baidu.searchbox.player.helper.OrientationHelper;
import com.baidu.searchbox.player.utils.BdActivityUtils;
import com.baidu.searchbox.player.utils.ExtLogUtil;
import com.baidu.tbadk.mutiprocess.live.YyLiveRoomConfig;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.im.dispatcher.AiBotChatDispatcher;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000»\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001T\u0018\u0000 \u0089\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u0089\u0001\u008a\u0001B'\u0012\b\u0010\u0082\u0001\u001a\u00030\u0081\u0001\u0012\b\u0010\u0084\u0001\u001a\u00030\u0083\u0001\u0012\b\u0010\u0086\u0001\u001a\u00030\u0085\u0001¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\nJ\r\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\nJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u001f\u0010\nJ\u000f\u0010 \u001a\u00020\u0006H\u0007¢\u0006\u0004\b \u0010\nJ\u001f\u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0006H\u0016¢\u0006\u0004\b&\u0010\nJ\u0017\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0006H\u0016¢\u0006\u0004\b+\u0010\nJ\u000f\u0010,\u001a\u00020\u0006H\u0016¢\u0006\u0004\b,\u0010\nJ'\u0010/\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00142\u0006\u0010(\u001a\u00020'2\u0006\u0010.\u001a\u00020#H\u0016¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0017H\u0016¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0006H\u0007¢\u0006\u0004\b4\u0010\nJ\u000f\u00105\u001a\u00020\u0006H\u0002¢\u0006\u0004\b5\u0010\nJ/\u0010:\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u000e\u00107\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u0010062\u0006\u00109\u001a\u000208H\u0016¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u0006H\u0007¢\u0006\u0004\b<\u0010\nJ\u000f\u0010=\u001a\u00020\u0006H\u0007¢\u0006\u0004\b=\u0010\nJ\u000f\u0010>\u001a\u00020\u0006H\u0007¢\u0006\u0004\b>\u0010\nJ\u000f\u0010?\u001a\u00020\u0006H\u0002¢\u0006\u0004\b?\u0010\nJ\r\u0010@\u001a\u00020\u0006¢\u0006\u0004\b@\u0010\nJ\u000f\u0010A\u001a\u00020\u0006H\u0002¢\u0006\u0004\bA\u0010\nJ\u000f\u0010B\u001a\u00020\u0006H\u0002¢\u0006\u0004\bB\u0010\nJ\u000f\u0010C\u001a\u00020\u0006H\u0002¢\u0006\u0004\bC\u0010\nJ\u0017\u0010E\u001a\u00020\u00062\u0006\u0010D\u001a\u00020\u0014H\u0002¢\u0006\u0004\bE\u0010FR\"\u0010G\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010FR\u0016\u0010L\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010HR\"\u0010N\u001a\u00020M8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001d\u0010Y\u001a\u00020T8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR\u0016\u0010Z\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010\\\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010[R\u0016\u0010]\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010[R\"\u0010^\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010[\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0016\u0010b\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010[R\u0016\u0010c\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010[R\u0018\u0010e\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010fR.\u0010i\u001a\u0004\u0018\u00010g2\b\u0010h\u001a\u0004\u0018\u00010g8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u0018\u0010p\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0018\u0010s\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u001d\u0010y\u001a\u00020u8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bv\u0010V\u001a\u0004\bw\u0010xR\u001e\u0010|\u001a\n {*\u0004\u0018\u00010z0z8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b|\u0010}R\u0016\u0010~\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010HR\u0019\u0010\u007f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001¨\u0006\u008b\u0001"}, d2 = {"Lcom/baidu/searchbox/live/shell/list/basic/MixYYFakeShell;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/baidu/searchbox/live/eventbus/EventAction;", "Lcom/baidu/searchbox/live/shell/list/basic/AbstractMixFakeShell;", "Lcom/baidu/searchbox/live/action/AbstractEvent;", "event", "", NotificationCompat.CATEGORY_CALL, "(Lcom/baidu/searchbox/live/action/AbstractEvent;)V", "checkImpl", "()V", "Landroid/view/View;", "createContainerView", "()Landroid/view/View;", "createLiveView", "hideActivityBackground", "", "content", LocalFilesFilterKt.FILTER_NAME_LOG, "(Ljava/lang/String;)V", "", AiBotChatDispatcher.AI_SINGLE_REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onCreate", MissionEvent.MESSAGE_DESTROY, "keyCode", "Landroid/view/KeyEvent;", "", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "onLiveAttach", "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "model", "onLiveBindData", "(Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;)V", "onLiveDeselected", "onLiveDetach", CriusAttrConstants.POSITION, "isFromUser", "onLiveSelected", "(ILcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;Z)V", "intent", "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onRealDetach", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "onResume", "onStart", MissionEvent.MESSAGE_STOP, "registerRoomInfoService", "showActivityBackground", "syncActivityLifecycle", "syncAttachState", "syncSelectState", "state", "syncYYActivityLifecycle", "(I)V", "curPosition", "I", "getCurPosition", "()I", "setCurPosition", "curState", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "com/baidu/searchbox/live/shell/list/basic/MixYYFakeShell$invokeAbility$2$1", "invokeAbility$delegate", "Lkotlin/Lazy;", "getInvokeAbility", "()Lcom/baidu/searchbox/live/shell/list/basic/MixYYFakeShell$invokeAbility$2$1;", "invokeAbility", "isAttach", "Z", "isDestroy", "isDetach", "isSelected", "()Z", "setSelected", "(Z)V", "isYYAttach", "isYYSelect", "Lcom/baidu/searchbox/player/helper/OrientationHelper;", "mOrientationHelper", "Lcom/baidu/searchbox/player/helper/OrientationHelper;", "Lcom/baidu/live/mix/interfaces/MixLiveInterface;", "value", "mixLiveImpl", "Lcom/baidu/live/mix/interfaces/MixLiveInterface;", "getMixLiveImpl", "()Lcom/baidu/live/mix/interfaces/MixLiveInterface;", "setMixLiveImpl", "(Lcom/baidu/live/mix/interfaces/MixLiveInterface;)V", "Lcom/baidu/live/mix/MixLiveItemModel;", "mixModel", "Lcom/baidu/live/mix/MixLiveItemModel;", "Lcom/baidu/searchbox/live/mix/MixRoomInfo;", "mixRoomInfo", "Lcom/baidu/searchbox/live/mix/MixRoomInfo;", "Lcom/baidu/searchbox/live/shell/list/basic/MixYYFakeShell$OrientationChangeCallBack;", "orientationChangeCallBack$delegate", "getOrientationChangeCallBack", "()Lcom/baidu/searchbox/live/shell/list/basic/MixYYFakeShell$OrientationChangeCallBack;", "orientationChangeCallBack", "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "kotlin.jvm.PlatformType", "pluginInvokeService", "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "yyState", "yyView", "Landroid/view/View;", "Landroid/content/Context;", "context", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "mixUniqueId", "Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "mixActivity", "<init>", "(Landroid/content/Context;Lcom/baidu/live/arch/utils/MiniUniqueId;Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;)V", "Companion", "OrientationChangeCallBack", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class MixYYFakeShell extends AbstractMixFakeShell implements LifecycleObserver, EventAction<AbstractEvent> {
    public static final String ROOM_ID_YY = "roomid";
    public static final String SID_CONST_KEY = "sid_shiyan";
    public static int STATE_INIT;
    public static boolean hasSelected;
    public static boolean isLoadPlugin;
    public static int lastContextHashCode;
    public int curPosition;
    public int curState;
    public Handler handler;
    public final Lazy invokeAbility$delegate;
    public boolean isAttach;
    public boolean isDestroy;
    public boolean isDetach;
    public boolean isSelected;
    public boolean isYYAttach;
    public boolean isYYSelect;
    public OrientationHelper mOrientationHelper;
    public MixLiveInterface mixLiveImpl;
    public MixLiveItemModel mixModel;
    public MixRoomInfo mixRoomInfo;
    public final Lazy orientationChangeCallBack$delegate;
    public final PluginInvokeService pluginInvokeService;
    public int yyState;
    public View yyView;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MixYYFakeShell.class), "orientationChangeCallBack", "getOrientationChangeCallBack()Lcom/baidu/searchbox/live/shell/list/basic/MixYYFakeShell$OrientationChangeCallBack;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MixYYFakeShell.class), "invokeAbility", "getInvokeAbility()Lcom/baidu/searchbox/live/shell/list/basic/MixYYFakeShell$invokeAbility$2$1;"))};
    @Deprecated
    public static final Companion Companion = new Companion(null);
    public static int STATE_CREATE = 1;
    public static int STATE_START = 2;
    public static int STATE_RESUME = 3;
    public static int STATE_PAUSE = 4;
    public static int STATE_STOP = 5;
    public static int STATE_DESTROY = 6;

    private final MixYYFakeShell$invokeAbility$2.AnonymousClass1 getInvokeAbility() {
        Lazy lazy = this.invokeAbility$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (MixYYFakeShell$invokeAbility$2.AnonymousClass1) lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OrientationChangeCallBack getOrientationChangeCallBack() {
        Lazy lazy = this.orientationChangeCallBack$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (OrientationChangeCallBack) lazy.getValue();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0082\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b*\u0010+R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\"\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\"\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\"\u0010\u0015\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\"\u0010\u0018\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0007\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\"\u0010\u001b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0007\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010 \u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$R\"\u0010'\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0007\u001a\u0004\b(\u0010\t\"\u0004\b)\u0010\u000b¨\u0006,"}, d2 = {"Lcom/baidu/searchbox/live/shell/list/basic/MixYYFakeShell$Companion;", "", "ROOM_ID_YY", "Ljava/lang/String;", "SID_CONST_KEY", "", "STATE_CREATE", "I", "getSTATE_CREATE", "()I", "setSTATE_CREATE", "(I)V", "STATE_DESTROY", "getSTATE_DESTROY", "setSTATE_DESTROY", "STATE_INIT", "getSTATE_INIT", "setSTATE_INIT", "STATE_PAUSE", "getSTATE_PAUSE", "setSTATE_PAUSE", "STATE_RESUME", "getSTATE_RESUME", "setSTATE_RESUME", "STATE_START", "getSTATE_START", "setSTATE_START", "STATE_STOP", "getSTATE_STOP", "setSTATE_STOP", "", "hasSelected", "Z", "getHasSelected", "()Z", "setHasSelected", "(Z)V", "isLoadPlugin", "setLoadPlugin", "lastContextHashCode", "getLastContextHashCode", "setLastContextHashCode", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public final boolean getHasSelected() {
            return MixYYFakeShell.hasSelected;
        }

        public final int getLastContextHashCode() {
            return MixYYFakeShell.lastContextHashCode;
        }

        public final int getSTATE_CREATE() {
            return MixYYFakeShell.STATE_CREATE;
        }

        public final int getSTATE_DESTROY() {
            return MixYYFakeShell.STATE_DESTROY;
        }

        public final int getSTATE_INIT() {
            return MixYYFakeShell.STATE_INIT;
        }

        public final int getSTATE_PAUSE() {
            return MixYYFakeShell.STATE_PAUSE;
        }

        public final int getSTATE_RESUME() {
            return MixYYFakeShell.STATE_RESUME;
        }

        public final int getSTATE_START() {
            return MixYYFakeShell.STATE_START;
        }

        public final int getSTATE_STOP() {
            return MixYYFakeShell.STATE_STOP;
        }

        public final boolean isLoadPlugin() {
            return MixYYFakeShell.isLoadPlugin;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void setHasSelected(boolean z) {
            MixYYFakeShell.hasSelected = z;
        }

        public final void setLastContextHashCode(int i) {
            MixYYFakeShell.lastContextHashCode = i;
        }

        public final void setLoadPlugin(boolean z) {
            MixYYFakeShell.isLoadPlugin = z;
        }

        public final void setSTATE_CREATE(int i) {
            MixYYFakeShell.STATE_CREATE = i;
        }

        public final void setSTATE_DESTROY(int i) {
            MixYYFakeShell.STATE_DESTROY = i;
        }

        public final void setSTATE_INIT(int i) {
            MixYYFakeShell.STATE_INIT = i;
        }

        public final void setSTATE_PAUSE(int i) {
            MixYYFakeShell.STATE_PAUSE = i;
        }

        public final void setSTATE_RESUME(int i) {
            MixYYFakeShell.STATE_RESUME = i;
        }

        public final void setSTATE_START(int i) {
            MixYYFakeShell.STATE_START = i;
        }

        public final void setSTATE_STOP(int i) {
            MixYYFakeShell.STATE_STOP = i;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0011R\u0016\u0010\u001d\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0011¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/live/shell/list/basic/MixYYFakeShell$OrientationChangeCallBack;", "com/baidu/searchbox/player/helper/OrientationHelper$IOrientationChange", "", "i", "", "onOrientationChanged", "(I)V", "DELAY_TIME", "I", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "activityRef", "Ljava/lang/ref/WeakReference;", "getActivityRef", "()Ljava/lang/ref/WeakReference;", "", "canChangeOrientation", "Z", "getCanChangeOrientation", "()Z", "setCanChangeOrientation", "(Z)V", "fullScreenMode", "getFullScreenMode", "setFullScreenMode", "", "mChangedTime", "J", "mIsLandscape", "mIsPortrait", "<init>", "(Ljava/lang/ref/WeakReference;)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class OrientationChangeCallBack implements OrientationHelper.IOrientationChange {
        public final int DELAY_TIME = 1000;
        public final WeakReference<Activity> activityRef;
        public boolean canChangeOrientation;
        public boolean fullScreenMode;
        public long mChangedTime;
        public boolean mIsLandscape;
        public boolean mIsPortrait;

        public OrientationChangeCallBack(WeakReference<Activity> weakReference) {
            this.activityRef = weakReference;
        }

        public final void setCanChangeOrientation(boolean z) {
            this.canChangeOrientation = z;
        }

        public final void setFullScreenMode(boolean z) {
            this.fullScreenMode = z;
        }

        public final WeakReference<Activity> getActivityRef() {
            return this.activityRef;
        }

        public final boolean getCanChangeOrientation() {
            return this.canChangeOrientation;
        }

        public final boolean getFullScreenMode() {
            return this.fullScreenMode;
        }

        @Override // com.baidu.searchbox.player.helper.OrientationHelper.IOrientationChange
        public void onOrientationChanged(int i) {
            Activity activity;
            Activity activity2;
            Activity activity3;
            if (!this.canChangeOrientation || OrientationHelper.isSystemOrientationLocked(MiniShellRuntime.INSTANCE.getAppApplication())) {
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
    }

    @Override // com.baidu.searchbox.live.shell.list.basic.AbstractMixFakeShell
    public View createContainerView() {
        int hashCode = getContext().hashCode();
        int i = lastContextHashCode;
        if (i == 0 || i != hashCode) {
            hasSelected = false;
            lastContextHashCode = hashCode;
            log("MixLiveShell createContainerView rest hasSelected");
        }
        log("MixLiveShell createLiveView ");
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
        createLiveView();
        return getLiveContainer();
    }

    public MixYYFakeShell(final Context context, MiniUniqueId miniUniqueId, IMixActivityInterface iMixActivityInterface) {
        super(context, miniUniqueId, iMixActivityInterface);
        int i = STATE_INIT;
        this.curState = i;
        this.yyState = i;
        this.orientationChangeCallBack$delegate = LazyKt__LazyJVMKt.lazy(new Function0<OrientationChangeCallBack>() { // from class: com.baidu.searchbox.live.shell.list.basic.MixYYFakeShell$orientationChangeCallBack$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MixYYFakeShell.OrientationChangeCallBack invoke() {
                Activity activity = PluginContextUtil.INSTANCE.getActivity(context);
                if (activity == null) {
                    Intrinsics.throwNpe();
                }
                return new MixYYFakeShell.OrientationChangeCallBack(new WeakReference(activity));
            }
        });
        this.handler = new Handler(Looper.getMainLooper());
        this.pluginInvokeService = (PluginInvokeService) ServiceManager.getService(PluginInvokeService.Companion.getSERVICE_REFERENCE());
        this.invokeAbility$delegate = LazyKt__LazyJVMKt.lazy(new Function0<MixYYFakeShell$invokeAbility$2.AnonymousClass1>() { // from class: com.baidu.searchbox.live.shell.list.basic.MixYYFakeShell$invokeAbility$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.searchbox.live.shell.list.basic.MixYYFakeShell$invokeAbility$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                return new InvokeAbility() { // from class: com.baidu.searchbox.live.shell.list.basic.MixYYFakeShell$invokeAbility$2.1
                    @Override // com.baidu.live.mix.interfaces.InvokeAbility
                    public MixShellServiceCenter getMixShellServiceCenter() {
                        return null;
                    }

                    @Override // com.baidu.live.mix.interfaces.InvokeAbility
                    public MixPagerInfoService getPagerInfoService() {
                        return null;
                    }

                    @Override // com.baidu.live.mix.interfaces.InvokeAbility
                    public void removeRoom(JSONObject jSONObject) {
                        MixYYFakeShell mixYYFakeShell = MixYYFakeShell.this;
                        mixYYFakeShell.log("MixLiveShell invokeAbility removeRoom ：" + jSONObject);
                        MixListOperatorInterface mixListOperatorInterface = (MixListOperatorInterface) ServiceLocator.Companion.getGlobalService(MixListOperatorInterface.class);
                        if (mixListOperatorInterface != null) {
                            mixListOperatorInterface.removeRoom(jSONObject);
                        }
                    }

                    @Override // com.baidu.live.mix.interfaces.InvokeAbility
                    public void switchLiveListScrollable(boolean z) {
                        MixYYFakeShell mixYYFakeShell = MixYYFakeShell.this;
                        mixYYFakeShell.log("MixLiveShell invokeAbility switchLiveListScrollable switch：" + z);
                        MixListOperatorInterface mixListOperatorInterface = (MixListOperatorInterface) ServiceLocator.Companion.getGlobalService(MixListOperatorInterface.class);
                        if (mixListOperatorInterface != null) {
                            mixListOperatorInterface.switchLiveListScrollable(z, false);
                        }
                    }

                    @Override // com.baidu.live.mix.interfaces.InvokeAbility
                    public void switchScreenAutoRotate(boolean z) {
                        MixYYFakeShell.OrientationChangeCallBack orientationChangeCallBack;
                        MixYYFakeShell mixYYFakeShell = MixYYFakeShell.this;
                        mixYYFakeShell.log("MixLiveShell invokeAbility switchScreenAutoRotate switch：" + z);
                        orientationChangeCallBack = MixYYFakeShell.this.getOrientationChangeCallBack();
                        orientationChangeCallBack.setCanChangeOrientation(z);
                    }

                    @Override // com.baidu.live.mix.interfaces.InvokeAbility
                    public void eventDispatcher(String str, JSONObject jSONObject) {
                        if (Intrinsics.areEqual("resume_live_background", str)) {
                            MixYYFakeShell.this.showActivityBackground();
                        }
                    }

                    @Override // com.baidu.live.mix.interfaces.InvokeAbility
                    public void insertRoom(int i2, JSONObject jSONObject) {
                        MixYYFakeShell mixYYFakeShell = MixYYFakeShell.this;
                        mixYYFakeShell.log("MixLiveShell invokeAbility insertRoom " + i2 + " " + jSONObject);
                    }

                    @Override // com.baidu.live.mix.interfaces.InvokeAbility
                    public void loadFinish() {
                        MixYYFakeShell.this.log("MixLiveShell invokeAbility loadFinish ");
                    }

                    @Override // com.baidu.live.mix.interfaces.InvokeAbility
                    public void scrollToNextLiveRoom() {
                        MixListOperatorInterface mixListOperatorInterface = (MixListOperatorInterface) ServiceLocator.Companion.getGlobalService(MixListOperatorInterface.class);
                        if (mixListOperatorInterface != null) {
                            mixListOperatorInterface.scrollToNextLiveRoom();
                        }
                    }

                    @Override // com.baidu.live.mix.interfaces.InvokeAbility
                    public void scrollToPreLiveRoom() {
                        MixListOperatorInterface mixListOperatorInterface = (MixListOperatorInterface) ServiceLocator.Companion.getGlobalService(MixListOperatorInterface.class);
                        if (mixListOperatorInterface != null) {
                            mixListOperatorInterface.scrollToPreLiveRoom();
                        }
                    }
                };
            }
        });
    }

    private final void registerRoomInfoService() {
        ServiceLocator.Companion.registerGlobalServices(LiveMixRoomInfoService.class, new LiveMixRoomInfoService() { // from class: com.baidu.searchbox.live.shell.list.basic.MixYYFakeShell$registerRoomInfoService$1
            @Override // com.baidu.searchbox.live.service.LiveMixRoomInfoService
            public void updateRoomInfo(MixRoomInfo mixRoomInfo) {
                MixYYFakeShell.this.mixRoomInfo = mixRoomInfo;
            }

            @Override // com.baidu.searchbox.live.service.LiveMixRoomInfoService
            public MixRoomInfo getRoomInfo() {
                MixRoomInfo mixRoomInfo;
                mixRoomInfo = MixYYFakeShell.this.mixRoomInfo;
                return mixRoomInfo;
            }
        });
    }

    private final void syncActivityLifecycle() {
        if (this.curState == this.yyState) {
            return;
        }
        checkImpl();
        if (this.mixLiveImpl != null) {
            int i = this.curState;
            int i2 = this.yyState;
            if (i > i2) {
                syncYYActivityLifecycle(i2 + 1);
                syncActivityLifecycle();
                return;
            }
            syncYYActivityLifecycle(i);
            syncActivityLifecycle();
        }
    }

    public final int getCurPosition() {
        return this.curPosition;
    }

    public final Handler getHandler() {
        return this.handler;
    }

    public final MixLiveInterface getMixLiveImpl() {
        return this.mixLiveImpl;
    }

    public final void hideActivityBackground() {
        MixNotifyBackgroundService mixNotifyBackgroundService = (MixNotifyBackgroundService) ServiceLocator.Companion.getGlobalService(MixNotifyBackgroundService.class);
        if (mixNotifyBackgroundService != null) {
            mixNotifyBackgroundService.hideActivityBackground();
        }
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        this.isDestroy = false;
        this.curState = STATE_CREATE;
        log("MixLiveShell onCreate ");
        syncActivityLifecycle();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        this.isDestroy = true;
        this.curState = STATE_DESTROY;
        log("MixLiveShell onDestroy ");
        OrientationHelper orientationHelper = this.mOrientationHelper;
        if (orientationHelper != null) {
            orientationHelper.disable();
        }
        this.mOrientationHelper = null;
        syncActivityLifecycle();
        isLoadPlugin = false;
        ServiceLocator.Companion.unregisterGlobalService(LiveMixRoomInfoService.class);
        MixEventBus.getInstance().unRegister(this);
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.baidu.searchbox.live.shell.list.basic.AbstractMixFakeShell
    public void onLiveAttach() {
        super.onLiveAttach();
        this.isAttach = true;
        log("RoomLifrCycle MixLiveShell onLiveAttach ");
        registerRoomInfoService();
        Lifecycle lifeCycle = getMixActivity().getLifeCycle();
        if (lifeCycle != null) {
            lifeCycle.addObserver(this);
        }
        MixEventBus.getInstance().register(this, YYPluginEvent.LoadYYPluginRes.class, this);
        syncAttachState();
    }

    @Override // com.baidu.searchbox.live.shell.list.basic.AbstractMixFakeShell
    public void onLiveDeselected() {
        log("RoomLifrCycle MixLiveShell onLiveDeselected selectSetFalse");
        onRealDetach();
    }

    @Override // com.baidu.searchbox.live.shell.list.basic.AbstractMixFakeShell
    public void onLiveDetach() {
        log("RoomLifrCycle MixLiveShell onLiveDetach");
        this.isAttach = false;
        onRealDetach();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        log("MixLiveShell onPause ");
        this.curState = STATE_PAUSE;
        syncActivityLifecycle();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        log("MixLiveShell onResume ");
        this.curState = STATE_RESUME;
        syncActivityLifecycle();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onStart() {
        log("MixLiveShell onStart ");
        this.curState = STATE_START;
        syncActivityLifecycle();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        log("MixLiveShell onStop ");
        this.curState = STATE_STOP;
        syncActivityLifecycle();
    }

    public final void showActivityBackground() {
        MixNotifyBackgroundService mixNotifyBackgroundService = (MixNotifyBackgroundService) ServiceLocator.Companion.getGlobalService(MixNotifyBackgroundService.class);
        if (mixNotifyBackgroundService != null) {
            mixNotifyBackgroundService.showActivityBackground();
        }
    }

    @Override // com.baidu.searchbox.live.shell.list.basic.AbstractMixFakeShell, com.baidu.live.arch.api.IExtLifecycle
    public void onConfigurationChanged(Configuration configuration) {
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

    @Override // com.baidu.searchbox.live.shell.list.basic.AbstractMixFakeShell, com.baidu.live.arch.api.IExtLifecycle
    public void onNewIntent(Intent intent) {
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

    public final void setCurPosition(int i) {
        this.curPosition = i;
    }

    public final void setHandler(Handler handler) {
        this.handler = handler;
    }

    public final void setMixLiveImpl(MixLiveInterface mixLiveInterface) {
        this.mixLiveImpl = mixLiveInterface;
        if (mixLiveInterface != null) {
            mixLiveInterface.setInvokeListener(getInvokeAbility());
        }
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    @Override // com.baidu.searchbox.live.shell.list.basic.AbstractMixFakeShell, com.baidu.live.arch.api.IExtLifecycle
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z;
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

    private final void checkImpl() {
        Object obj;
        if (this.mixLiveImpl == null && MiniPluginManager.INSTANCE.isYYPluginAvailable()) {
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

    private final void onRealDetach() {
        log("RoomLifrCycle MixLiveShell onRealDetach");
        if (!this.isDetach) {
            this.isDetach = true;
            super.onLiveDetach();
            Lifecycle lifeCycle = getMixActivity().getLifeCycle();
            if (lifeCycle != null) {
                lifeCycle.removeObserver(this);
            }
            MixEventBus.getInstance().unRegister(this);
            ServiceLocator.Companion.unregisterGlobalService(LiveMixRoomInfoService.class);
            this.isSelected = false;
            syncSelectState();
            syncAttachState();
            this.yyView = null;
        }
    }

    private final void createLiveView() {
        View view2;
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
            log("MixLiveShell createLiveView " + view2);
        } catch (Throwable th) {
            log("recreateLiveView crash throwable th :" + th);
        }
    }

    private final void syncAttachState() {
        log("syncAttachState isAttach：" + this.isAttach + " isYYAttach:" + this.isYYAttach + " curState:" + this.curState);
        if (this.isAttach == this.isYYAttach) {
            return;
        }
        checkImpl();
        MixLiveInterface mixLiveInterface = this.mixLiveImpl;
        if (mixLiveInterface != null) {
            if (this.isAttach) {
                if (this.curState == STATE_RESUME) {
                    if (this.yyView == null) {
                        createLiveView();
                    }
                    try {
                        MixLiveInterface mixLiveInterface2 = this.mixLiveImpl;
                        if (mixLiveInterface2 != null) {
                            LiveContainer liveContainer = getLiveContainer();
                            if (liveContainer == null) {
                                Intrinsics.throwNpe();
                            }
                            MixLiveItemModel mixLiveItemModel = this.mixModel;
                            if (mixLiveItemModel == null) {
                                Intrinsics.throwNpe();
                            }
                            mixLiveInterface2.onLiveAttach(liveContainer, mixLiveItemModel);
                        }
                        this.isYYAttach = this.isAttach;
                        return;
                    } catch (Throwable th) {
                        log("onLiveAttach crash throwable th：" + th);
                        return;
                    }
                }
                return;
            }
            if (mixLiveInterface != null) {
                try {
                    mixLiveInterface.onLiveDetach();
                } catch (Throwable th2) {
                    log("onLiveDetach crash throwable th: " + th2);
                    return;
                }
            }
            this.isYYAttach = this.isAttach;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void log(String str) {
        int i;
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
        String sb2 = sb.toString();
        ListLogKt.log(MixTagConstants.MIX_YY_LIVE, sb2);
        MixYaLogService mixYaLogService = (MixYaLogService) MixRequestServiceLocator.Companion.getGlobalService(MixYaLogService.class);
        if (mixYaLogService != null) {
            mixYaLogService.yaLogWithStringFormat(MixYaLogConstants.MIX_CELL_ID, "yy", sb2);
        }
    }

    private final void syncSelectState() {
        String str;
        log("syncSelectState isSelected：" + this.isSelected + " isYYSelect:" + this.isYYSelect + " curState:" + this.curState);
        if (this.isSelected == this.isYYSelect) {
            return;
        }
        checkImpl();
        if (this.mixLiveImpl != null) {
            if (this.isSelected) {
                if (this.curState == STATE_RESUME) {
                    if (this.yyView == null) {
                        createLiveView();
                    }
                    try {
                        MixLiveInterface mixLiveInterface = this.mixLiveImpl;
                        if (mixLiveInterface != null) {
                            MixLiveItemModel mixLiveItemModel = this.mixModel;
                            if (mixLiveItemModel == null) {
                                Intrinsics.throwNpe();
                            }
                            mixLiveInterface.onLiveBindData(mixLiveItemModel);
                        }
                    } catch (Throwable th) {
                        log("mixLiveImpl onLiveBindData crash throwable th: " + th);
                    }
                    try {
                        MixLiveInterface mixLiveInterface2 = this.mixLiveImpl;
                        if (mixLiveInterface2 != null) {
                            int i = this.curPosition;
                            LiveContainer liveContainer = getLiveContainer();
                            if (liveContainer == null) {
                                Intrinsics.throwNpe();
                            }
                            MixLiveItemModel mixLiveItemModel2 = this.mixModel;
                            if (mixLiveItemModel2 == null) {
                                Intrinsics.throwNpe();
                            }
                            mixLiveInterface2.onLiveSelected(i, liveContainer, mixLiveItemModel2, false);
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("MixLiveShell onLiveSelected item=");
                        MixLiveItemModel mixLiveItemModel3 = this.mixModel;
                        if (mixLiveItemModel3 != null) {
                            str = mixLiveItemModel3.toString();
                        } else {
                            str = null;
                        }
                        sb.append(str);
                        log(sb.toString());
                        this.isYYSelect = this.isSelected;
                        return;
                    } catch (Throwable th2) {
                        log("mixLiveImpl?.onLiveSelected crash throwable th$ " + th2);
                        return;
                    }
                }
                return;
            }
            log("RoomLifrCycle MixLiveShell onLiveDeselected");
            try {
                MixLiveInterface mixLiveInterface3 = this.mixLiveImpl;
                if (mixLiveInterface3 != null) {
                    LiveContainer liveContainer2 = getLiveContainer();
                    if (liveContainer2 == null) {
                        Intrinsics.throwNpe();
                    }
                    mixLiveInterface3.onLiveDeselected(liveContainer2);
                }
                this.isYYSelect = this.isSelected;
            } catch (Throwable th3) {
                log("onLiveDeselected crash throwable th：" + th3);
            }
        }
    }

    private final void syncYYActivityLifecycle(int i) {
        log("syncYYActivityLifecycle newYYState：" + i + " oldYYState:" + this.yyState + " curState:" + this.curState);
        MixLiveInterface mixLiveInterface = this.mixLiveImpl;
        if (mixLiveInterface != null && i != STATE_INIT) {
            if (i == STATE_CREATE) {
                if (mixLiveInterface != null) {
                    try {
                        Activity activity = PluginContextUtil.INSTANCE.getActivity(getContext());
                        if (activity == null) {
                            Intrinsics.throwNpe();
                        }
                        mixLiveInterface.attachActivity(activity);
                    } catch (Throwable th) {
                        log("onCreate attachActivity crash throwable th：" + th);
                    }
                }
                try {
                    MixLiveInterface mixLiveInterface2 = this.mixLiveImpl;
                    if (mixLiveInterface2 != null) {
                        mixLiveInterface2.onCreate();
                    }
                    this.yyState = i;
                } catch (Throwable th2) {
                    log("onCreate crash throwable th：" + th2);
                }
            } else if (i == STATE_START) {
                if (mixLiveInterface != null) {
                    try {
                        mixLiveInterface.onStart();
                    } catch (Throwable th3) {
                        log("onStart crash throwable th：" + th3);
                        return;
                    }
                }
                this.yyState = i;
            } else if (i == STATE_RESUME) {
                if (mixLiveInterface != null) {
                    try {
                        mixLiveInterface.onResume();
                    } catch (Throwable th4) {
                        log("onResume crash throwable th：" + th4);
                    }
                }
                this.yyState = i;
                if (this.curState == STATE_RESUME) {
                    syncAttachState();
                    syncSelectState();
                }
            } else if (i == STATE_PAUSE) {
                if (mixLiveInterface != null) {
                    try {
                        mixLiveInterface.onPause();
                    } catch (Throwable th5) {
                        log("onPause crash throwable th：" + th5);
                        return;
                    }
                }
                this.yyState = i;
            } else if (i == STATE_STOP) {
                if (mixLiveInterface != null) {
                    try {
                        mixLiveInterface.onStop();
                    } catch (Throwable th6) {
                        log("onStop crash throwable th：" + th6);
                        return;
                    }
                }
                this.yyState = i;
            } else if (i == STATE_DESTROY) {
                if (mixLiveInterface != null) {
                    try {
                        mixLiveInterface.onDestroy();
                    } catch (Throwable th7) {
                        log("onDestroy crash throwable th：" + th7);
                        return;
                    }
                }
                this.yyState = i;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.live.eventbus.EventAction
    public void call(AbstractEvent abstractEvent) {
        if (abstractEvent != null && abstractEvent.getUniqueId() == getMixUniqueId().getId() && (abstractEvent instanceof YYPluginEvent.LoadYYPluginRes) && ((YYPluginEvent.LoadYYPluginRes) abstractEvent).getRes() == 2) {
            if (this.isDestroy) {
                log("load plugin suc but is destroy");
                return;
            }
            log("MixLiveShell LoadYYPluginSuc isSelected: " + this.isSelected);
            syncActivityLifecycle();
        }
    }

    @Override // com.baidu.searchbox.live.shell.list.basic.AbstractMixFakeShell, com.baidu.live.arch.api.IExtLifecycle
    public void onActivityResult(int i, int i2, Intent intent) {
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
        String str13;
        String str14;
        JSONObject jSONObject4;
        String str15;
        String str16;
        IntentData intent;
        IntentData.SchemeModel schemeData;
        JSONObject otherParams;
        IntentData intent2;
        JSONObject originJson;
        String str17;
        JSONObject optJSONObject;
        String optString;
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
        JSONObject jSONObject5 = jSONObject;
        if (appInfoService != null && (str13 = appInfoService.getSid()) != null) {
            str12 = str9;
        } else {
            str12 = str9;
            str13 = "";
        }
        jSONObject3.put(SID_CONST_KEY, str13);
        jSONObject3.put(ROOM_ID_YY, liveItemModel.getRoomId());
        JSONObject slog = liveItemModel.getSlog();
        if (slog != null && (optJSONObject = slog.optJSONObject("rec_ext")) != null && (optString = optJSONObject.optString("vt_ctr_fea")) != null) {
            str14 = str8;
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("vt_ctr_fea", optString);
            jSONObject3.put(ExtLogUtil.GR_EXT, jSONObject6);
        } else {
            str14 = str8;
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
        if (jSONObject4 != null) {
            str15 = jSONObject4.optString("ext");
        } else {
            str15 = null;
        }
        if (TextUtils.isEmpty(str15) && jSONObject4 != 0) {
            if (jSONObject2 != null) {
                str17 = jSONObject2.toString();
            } else {
                str17 = null;
            }
            jSONObject4.put("ext", str17);
        }
        if (jSONObject4 != null) {
            jSONObject4.put("extLog", jSONObject3);
        }
        if (jSONObject4 != null) {
            JSONObject originJson15 = liveItemModel.getOriginJson();
            jSONObject4.put("extSchema", (originJson15 == null || (r1 = originJson15.optString("extSchema", "")) == null) ? "" : "");
        }
        if (!hasSelected && (originJson = liveItemModel.getOriginJson()) != null && originJson.optInt("isMix") == 1) {
            if (jSONObject4 != null) {
                jSONObject4.put("firstJump", 1);
            }
        } else if (jSONObject4 != null) {
            jSONObject4.remove("firstJump");
        }
        ILiveListState iLiveListState = (ILiveListState) ServiceLocator.Companion.getGlobalService(ILiveListState.class);
        String str18 = (iLiveListState == null || (intent2 = iLiveListState.getIntent()) == null || (str18 = intent2.getLiveSource()) == null) ? "" : "";
        ILiveListState iLiveListState2 = (ILiveListState) ServiceLocator.Companion.getGlobalService(ILiveListState.class);
        if (iLiveListState2 != null && (intent = iLiveListState2.getIntent()) != null && (schemeData = intent.getSchemeData()) != null && (otherParams = schemeData.getOtherParams()) != null) {
            str16 = otherParams.getString("task_token");
        } else {
            str16 = null;
        }
        if (str16 != null && jSONObject4 != null) {
            jSONObject4.put("task_token", str16);
        }
        MixLiveItemModel mixLiveItemModel = new MixLiveItemModel(liveItemModel.getRoomId(), str, str2, str3, str4, str5, str6, str7, str14, str12, jSONObject5, jSONObject4, liveItemModel.getCover(), liveItemModel.getLiveType(), liveItemModel.getScheme(), liveItemModel.getPlayUrl(), str18, liveItemModel.getOtherParams(), null);
        this.mixModel = mixLiveItemModel;
        log("MixLiveShell onLiveBindData mixModel=" + mixLiveItemModel.toString());
    }

    @Override // com.baidu.searchbox.live.shell.list.basic.AbstractMixFakeShell
    public void onLiveSelected(int i, LiveContainer.LiveItemModel liveItemModel, boolean z) {
        ImagePipeline imagePipeline;
        MixLiveItemModel mixLiveItemModel;
        String roomId;
        MixLiveItemModel mixLiveItemModel2;
        JSONObject extendInfo;
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
            createLiveView();
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
        syncSelectState();
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

    @Override // com.baidu.searchbox.live.shell.list.basic.AbstractMixFakeShell, com.baidu.live.arch.api.IExtLifecycle
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
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
