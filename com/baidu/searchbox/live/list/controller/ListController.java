package com.baidu.searchbox.live.list.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.live.arch.ServiceLocator;
import com.baidu.live.arch.api.IExtLifecycle;
import com.baidu.live.arch.runtime.MiniShellRuntime;
import com.baidu.live.arch.utils.MiniJsonUtils;
import com.baidu.live.arch.utils.MiniPluginUtils;
import com.baidu.live.arch.utils.MiniUiThreadUtil;
import com.baidu.live.arch.utils.MiniUniqueId;
import com.baidu.live.arch.utils.MixUriUtilKt;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.live.action.AbstractEvent;
import com.baidu.searchbox.live.action.MixMediaEvent;
import com.baidu.searchbox.live.action.YYPluginEvent;
import com.baidu.searchbox.live.component.service.LiveItemModelListService;
import com.baidu.searchbox.live.data.constant.MixConstants;
import com.baidu.searchbox.live.data.pojo.LiveTypeData;
import com.baidu.searchbox.live.data.req.RoomEnterParams;
import com.baidu.searchbox.live.data.resp.LiveRoomEnterRespData;
import com.baidu.searchbox.live.eventbus.EventAction;
import com.baidu.searchbox.live.eventbus.MixEventBus;
import com.baidu.searchbox.live.frame.IntentData;
import com.baidu.searchbox.live.frame.ListInfo;
import com.baidu.searchbox.live.frame.PageInfo;
import com.baidu.searchbox.live.interfaces.context.PluginContextUtil;
import com.baidu.searchbox.live.interfaces.mix.IMixActivityInterface;
import com.baidu.searchbox.live.interfaces.mix.MixInvokeAbility;
import com.baidu.searchbox.live.interfaces.mix.PluginInvokeService;
import com.baidu.searchbox.live.interfaces.service.AbConfigService;
import com.baidu.searchbox.live.interfaces.service.LiveSessionService;
import com.baidu.searchbox.live.list.controller.ListController$mMixEventDispatcher$2;
import com.baidu.searchbox.live.list.plugin.LiveRoomInfoStatPlugin;
import com.baidu.searchbox.live.list.plugin.YYActivityLifeCyclePlugin;
import com.baidu.searchbox.live.list.plugin.YYLoadPluginPlugin;
import com.baidu.searchbox.live.model.MixModel;
import com.baidu.searchbox.live.model.res.MixResult;
import com.baidu.searchbox.live.model.res.MixResultStatData;
import com.baidu.searchbox.live.model.res.OnMixDataLoaded;
import com.baidu.searchbox.live.pluginmanager.MiniPluginManager;
import com.baidu.searchbox.live.service.ILiveListState;
import com.baidu.searchbox.live.service.MixListOperatorInterface;
import com.baidu.searchbox.live.service.MixRequestService;
import com.baidu.searchbox.live.service.MixRequestServiceLocator;
import com.baidu.searchbox.live.shell.list.basic.AbstractMixFakeShell;
import com.baidu.searchbox.live.shell.list.basic.MixYYFakeShell;
import com.baidu.searchbox.live.ubc.LiveComponentLoadLogger;
import com.baidu.searchbox.live.ubc.MediaLiveEnterRoomRate;
import com.baidu.searchbox.live.ubc.MediaLivePlayLogger;
import com.baidu.searchbox.live.ubc.MediaLivePluginLogger;
import com.baidu.searchbox.live.util.ListExtKt;
import com.baidu.searchbox.live.util.ListLogKt;
import com.baidu.searchbox.live.util.ListUbc;
import com.baidu.searchbox.live.widget.LiveContainer;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.searchbox.ui.SystemBarTintManager;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.ubc.UBCManager;
import com.baidubce.auth.NTLMEngineImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000´\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002©\u0001\u0018\u0000 Þ\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002Þ\u0001B%\u0012\u0006\u0010g\u001a\u00020f\u0012\b\u0010Â\u0001\u001a\u00030Á\u0001\u0012\b\u0010¿\u0001\u001a\u00030¾\u0001¢\u0006\u0006\bÜ\u0001\u0010Ý\u0001J!\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\u001b\u001a\u00020\b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\b¢\u0006\u0004\b!\u0010\u0014JI\u0010*\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00062\b\b\u0002\u0010)\u001a\u00020\u0006H\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\bH\u0002¢\u0006\u0004\b,\u0010\u0014J\u000f\u0010-\u001a\u00020\bH\u0002¢\u0006\u0004\b-\u0010\u0014J)\u00102\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020\u001d2\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b4\u0010 J\u0017\u00105\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b5\u0010 J\u0017\u00108\u001a\u00020\b2\u0006\u00107\u001a\u000206H\u0016¢\u0006\u0004\b8\u00109J\r\u0010:\u001a\u00020\b¢\u0006\u0004\b:\u0010\u0014J\r\u0010;\u001a\u00020\b¢\u0006\u0004\b;\u0010\u0014J\u001f\u0010?\u001a\u00020>2\u0006\u0010<\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020=H\u0016¢\u0006\u0004\b?\u0010@J\u0017\u0010B\u001a\u00020\b2\u0006\u0010A\u001a\u000200H\u0016¢\u0006\u0004\bB\u0010CJ\u001d\u0010F\u001a\u00020\b2\f\u00101\u001a\b\u0012\u0004\u0012\u00020E0DH\u0002¢\u0006\u0004\bF\u0010GJ/\u0010L\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u001d2\u000e\u0010I\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060H2\u0006\u0010K\u001a\u00020JH\u0016¢\u0006\u0004\bL\u0010MJ'\u0010Q\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010P2\u0006\u0010O\u001a\u00020NH\u0002¢\u0006\u0004\bQ\u0010RJ!\u0010U\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\b\u0010T\u001a\u0004\u0018\u00010SH\u0002¢\u0006\u0004\bU\u0010VJ\u000f\u0010W\u001a\u00020\bH\u0002¢\u0006\u0004\bW\u0010\u0014J\u000f\u0010X\u001a\u00020\bH\u0002¢\u0006\u0004\bX\u0010\u0014J\u000f\u0010Y\u001a\u00020\bH\u0002¢\u0006\u0004\bY\u0010\u0014J\u000f\u0010Z\u001a\u00020\bH\u0002¢\u0006\u0004\bZ\u0010\u0014J\u000f\u0010[\u001a\u00020\bH\u0002¢\u0006\u0004\b[\u0010\u0014J-\u0010^\u001a\u00020\b2\u0006\u0010\\\u001a\u00020\u00062\u0006\u0010]\u001a\u00020\u001d2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018H\u0002¢\u0006\u0004\b^\u0010_J\u0017\u0010b\u001a\u00020\b2\u0006\u0010a\u001a\u00020`H\u0002¢\u0006\u0004\bb\u0010cJ\u000f\u0010d\u001a\u00020\bH\u0002¢\u0006\u0004\bd\u0010\u0014J\u000f\u0010e\u001a\u00020\bH\u0002¢\u0006\u0004\be\u0010\u0014R\u0019\u0010g\u001a\u00020f8\u0006@\u0006¢\u0006\f\n\u0004\bg\u0010h\u001a\u0004\bi\u0010jR$\u0010k\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\"\u0010q\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010 R$\u0010w\u001a\u0004\u0018\u00010v8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bw\u0010x\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R%\u0010}\u001a\u00020>8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R(\u0010\u0083\u0001\u001a\u00020>8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u0083\u0001\u0010~\u001a\u0006\b\u0084\u0001\u0010\u0080\u0001\"\u0006\b\u0085\u0001\u0010\u0082\u0001R(\u0010\u0086\u0001\u001a\u00020>8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u0086\u0001\u0010~\u001a\u0006\b\u0086\u0001\u0010\u0080\u0001\"\u0006\b\u0087\u0001\u0010\u0082\u0001R\u0018\u0010\u0088\u0001\u001a\u00020>8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010~R$\u0010\u0089\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040\u00188\u0006@\u0006¢\u0006\u0010\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R#\u0010\u0092\u0001\u001a\u00030\u008d\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0019\u0010\u0093\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0019\u0010\u0095\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0094\u0001R$\u0010\u0098\u0001\u001a\r \u0097\u0001*\u0005\u0018\u00010\u0096\u00010\u0096\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0018\u0010\u009a\u0001\u001a\u00020\u001d8\u0002@\u0002X\u0082D¢\u0006\u0007\n\u0005\b\u009a\u0001\u0010rR\u0018\u0010\u009b\u0001\u001a\u00020>8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009b\u0001\u0010~R,\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009c\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009d\u0001\u0010\u009e\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R\u001c\u0010¤\u0001\u001a\u0005\u0018\u00010£\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001R\u001c\u0010§\u0001\u001a\u0005\u0018\u00010¦\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R#\u0010\u00ad\u0001\u001a\u00030©\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bª\u0001\u0010\u008f\u0001\u001a\u0006\b«\u0001\u0010¬\u0001R\u001c\u0010¯\u0001\u001a\u0005\u0018\u00010®\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001R,\u0010²\u0001\u001a\u0005\u0018\u00010±\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b²\u0001\u0010³\u0001\u001a\u0006\b´\u0001\u0010µ\u0001\"\u0006\b¶\u0001\u0010·\u0001R\u001c\u0010¹\u0001\u001a\u0005\u0018\u00010¸\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R\u001c\u0010¼\u0001\u001a\u0005\u0018\u00010»\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0001\u0010½\u0001R\u001a\u0010¿\u0001\u001a\u00030¾\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¿\u0001\u0010À\u0001R\u001a\u0010Â\u0001\u001a\u00030Á\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001R\u001b\u0010Ä\u0001\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÄ\u0001\u0010Å\u0001R+\u0010Æ\u0001\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÆ\u0001\u0010Ç\u0001\u001a\u0006\bÈ\u0001\u0010É\u0001\"\u0006\bÊ\u0001\u0010Ë\u0001R,\u0010Í\u0001\u001a\u0005\u0018\u00010Ì\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÍ\u0001\u0010Î\u0001\u001a\u0006\bÏ\u0001\u0010Ð\u0001\"\u0006\bÑ\u0001\u0010Ò\u0001R\u0018\u0010Ó\u0001\u001a\u00020>8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bÓ\u0001\u0010~R\u0018\u0010Ô\u0001\u001a\u00020>8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÔ\u0001\u0010~R,\u0010×\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0005\u0012\u00030Ö\u00010Õ\u00010\u00188\u0006@\u0006¢\u0006\u0010\n\u0006\b×\u0001\u0010\u008a\u0001\u001a\u0006\bØ\u0001\u0010\u008c\u0001R\u001a\u0010Ú\u0001\u001a\u00030Ù\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÚ\u0001\u0010Û\u0001¨\u0006ß\u0001"}, d2 = {"Lcom/baidu/searchbox/live/list/controller/ListController;", "Lcom/baidu/live/arch/api/IExtLifecycle;", "Lcom/baidu/searchbox/live/eventbus/EventAction;", "Lcom/baidu/searchbox/live/list/controller/IListListener;", "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "model", "", "id", "", "bindHLReplayInfo", "(Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;Ljava/lang/String;)V", "Lorg/json/JSONArray;", "roomIdJSONArray", "cacheCloseRoomIdList", "(Lorg/json/JSONArray;)V", "Lcom/baidu/searchbox/live/action/AbstractEvent;", "event", NotificationCompat.CATEGORY_CALL, "(Lcom/baidu/searchbox/live/action/AbstractEvent;)V", "changeScrollState", "()V", "Landroid/view/View;", "createView", "()Landroid/view/View;", "", "origin", "addition", "distinct", "(Ljava/util/List;Ljava/util/List;)V", "", CriusAttrConstants.POSITION, "fetchMoreLiveIfNeed", "(I)V", "finish", "roomId", AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, "scheme", "from", "", "clickTime", "clickFrom", "playUrl", "jumpToNewLiveRoom", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "loadLiveRoom", "logEventOnReach", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onAfterSelect", "onBeforeSelect", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onCreate", MissionEvent.MESSAGE_DESTROY, "keyCode", "Landroid/view/KeyEvent;", "", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "Lcom/baidu/searchbox/live/model/res/MixResult;", "Lcom/baidu/searchbox/live/data/resp/LiveRoomEnterRespData;", "onPreRoomEnterDataLoaded", "(Lcom/baidu/searchbox/live/model/res/MixResult;)V", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "Lorg/json/JSONObject;", "input", "", "paramsJsonToMap", "(Lorg/json/JSONObject;)Ljava/util/Map;", "Lcom/baidu/searchbox/live/widget/LiveContainer$PlaySourceInfo;", "sourceInfo", "parseClickTime", "(Ljava/lang/String;Lcom/baidu/searchbox/live/widget/LiveContainer$PlaySourceInfo;)Ljava/lang/String;", "preReqRoomEnter", "queryLiveList", "registerMixRequestService", "registerYYLifeCyclePlugin", "reloadLiveRoom", "pageSession", "hasMore", "slideListSuccess", "(Ljava/lang/String;ILjava/util/List;)V", "Lcom/baidu/searchbox/live/data/pojo/LiveTypeData;", "itemLiveType", "templateIdSuccess", "(Lcom/baidu/searchbox/live/data/pojo/LiveTypeData;)V", "unBindHLReplayInfo", "unregisterMixRequestService", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "curRoomModel", "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "getCurRoomModel", "()Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "setCurRoomModel", "(Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;)V", "currentPosition", "I", "getCurrentPosition", "()I", "setCurrentPosition", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "hasReqEnd", "Z", "getHasReqEnd", "()Z", "setHasReqEnd", "(Z)V", "hasReqStart", "getHasReqStart", "setHasReqStart", "isFromForward", "setFromForward", "isRegistYYActivityLifeCyclePlugin", "itemData", "Ljava/util/List;", "getItemData", "()Ljava/util/List;", "Lcom/baidu/searchbox/live/list/controller/IListManager;", "listManager$delegate", "Lkotlin/Lazy;", "getListManager", "()Lcom/baidu/searchbox/live/list/controller/IListManager;", "listManager", "listRequestDuration", "J", "listRequestTime", "Lcom/baidu/searchbox/live/interfaces/service/LiveSessionService;", "kotlin.jvm.PlatformType", "liveSessionService", "Lcom/baidu/searchbox/live/interfaces/service/LiveSessionService;", "loadMoreFraction", "localSwitchCanScroll", "Lcom/baidu/searchbox/live/frame/IntentData;", "mIntentData", "Lcom/baidu/searchbox/live/frame/IntentData;", "getMIntentData", "()Lcom/baidu/searchbox/live/frame/IntentData;", "setMIntentData", "(Lcom/baidu/searchbox/live/frame/IntentData;)V", "Lcom/baidu/searchbox/live/frame/ListInfo;", "mListInfo", "Lcom/baidu/searchbox/live/frame/ListInfo;", "Lcom/baidu/searchbox/live/list/plugin/LiveRoomInfoStatPlugin;", "mLiveRoomInfoStatPlugin", "Lcom/baidu/searchbox/live/list/plugin/LiveRoomInfoStatPlugin;", "com/baidu/searchbox/live/list/controller/ListController$mMixEventDispatcher$2$1", "mMixEventDispatcher$delegate", "getMMixEventDispatcher", "()Lcom/baidu/searchbox/live/list/controller/ListController$mMixEventDispatcher$2$1;", "mMixEventDispatcher", "Lcom/baidu/searchbox/live/model/MixModel;", "mNetModel", "Lcom/baidu/searchbox/live/model/MixModel;", "Lcom/baidu/searchbox/live/frame/PageInfo;", "mPageInfo", "Lcom/baidu/searchbox/live/frame/PageInfo;", "getMPageInfo", "()Lcom/baidu/searchbox/live/frame/PageInfo;", "setMPageInfo", "(Lcom/baidu/searchbox/live/frame/PageInfo;)V", "Lcom/baidu/searchbox/live/list/plugin/YYActivityLifeCyclePlugin;", "mYYLifeCyclePlugin", "Lcom/baidu/searchbox/live/list/plugin/YYActivityLifeCyclePlugin;", "Lcom/baidu/searchbox/live/list/plugin/YYLoadPluginPlugin;", "mYYLoadPluginPlugin", "Lcom/baidu/searchbox/live/list/plugin/YYLoadPluginPlugin;", "Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "mixActivity", "Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "mixUniqueId", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "playSource", "Lcom/baidu/searchbox/live/widget/LiveContainer$PlaySourceInfo;", "preReqRoomEnterData", "Lcom/baidu/searchbox/live/data/resp/LiveRoomEnterRespData;", "getPreReqRoomEnterData", "()Lcom/baidu/searchbox/live/data/resp/LiveRoomEnterRespData;", "setPreReqRoomEnterData", "(Lcom/baidu/searchbox/live/data/resp/LiveRoomEnterRespData;)V", "Lcom/baidu/searchbox/live/model/res/MixResultStatData;", "preReqStatData", "Lcom/baidu/searchbox/live/model/res/MixResultStatData;", "getPreReqStatData", "()Lcom/baidu/searchbox/live/model/res/MixResultStatData;", "setPreReqStatData", "(Lcom/baidu/searchbox/live/model/res/MixResultStatData;)V", "prefetchEnterSwitch", "serverSwitchCanScroll", "Ljava/lang/ref/WeakReference;", "Lcom/baidu/searchbox/live/shell/list/basic/AbstractMixFakeShell;", "shellList", "getShellList", "Lcom/baidu/ubc/UBCManager;", "ubcManager", "Lcom/baidu/ubc/UBCManager;", "<init>", "(Landroid/content/Context;Lcom/baidu/live/arch/utils/MiniUniqueId;Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;)V", "Companion", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class ListController implements IExtLifecycle, EventAction<AbstractEvent>, IListListener {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ListController.class), "listManager", "getListManager()Lcom/baidu/searchbox/live/list/controller/IListManager;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ListController.class), "mMixEventDispatcher", "getMMixEventDispatcher()Lcom/baidu/searchbox/live/list/controller/ListController$mMixEventDispatcher$2$1;"))};
    public static final Companion Companion = new Companion(null);
    public static final String KEY_PARAMS = "params";
    public final Context context;
    public LiveContainer.LiveItemModel curRoomModel;
    public int currentPosition;
    public Handler handler;
    public boolean hasReqEnd;
    public boolean hasReqStart;
    public boolean isFromForward;
    public boolean isRegistYYActivityLifeCyclePlugin;
    public final List<LiveContainer.LiveItemModel> itemData;
    public final Lazy listManager$delegate;
    public long listRequestDuration;
    public long listRequestTime;
    public final LiveSessionService liveSessionService;
    public final int loadMoreFraction;
    public boolean localSwitchCanScroll;
    public IntentData mIntentData;
    public ListInfo mListInfo;
    public LiveRoomInfoStatPlugin mLiveRoomInfoStatPlugin;
    public final Lazy mMixEventDispatcher$delegate;
    public MixModel mNetModel;
    public PageInfo mPageInfo;
    public YYActivityLifeCyclePlugin mYYLifeCyclePlugin;
    public YYLoadPluginPlugin mYYLoadPluginPlugin;
    public final IMixActivityInterface mixActivity;
    public final MiniUniqueId mixUniqueId;
    public LiveContainer.PlaySourceInfo playSource;
    public LiveRoomEnterRespData preReqRoomEnterData;
    public MixResultStatData preReqStatData;
    public final boolean prefetchEnterSwitch;
    public boolean serverSwitchCanScroll;
    public final List<WeakReference<AbstractMixFakeShell>> shellList;
    public final UBCManager ubcManager;

    /* JADX INFO: Access modifiers changed from: private */
    public final IListManager getListManager() {
        Lazy lazy = this.listManager$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (IListManager) lazy.getValue();
    }

    private final ListController$mMixEventDispatcher$2.AnonymousClass1 getMMixEventDispatcher() {
        Lazy lazy = this.mMixEventDispatcher$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (ListController$mMixEventDispatcher$2.AnonymousClass1) lazy.getValue();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/live/list/controller/ListController$Companion;", "", "KEY_PARAMS", "Ljava/lang/String;", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ListController(Context context, MiniUniqueId miniUniqueId, IMixActivityInterface iMixActivityInterface) {
        boolean z;
        int i;
        this.context = context;
        this.mixUniqueId = miniUniqueId;
        this.mixActivity = iMixActivityInterface;
        AbConfigService abConfigService = (AbConfigService) ServiceManager.getService(AbConfigService.Companion.getSERVICE_REFERENCE());
        boolean z2 = false;
        if (abConfigService != null) {
            z = abConfigService.getSwitch(MiniPluginManager.LIVE_PRE_REQUEST_ENTER_SWITCH, false);
        } else {
            z = false;
        }
        if (z) {
            PluginInvokeService pluginMgrService = MiniPluginManager.INSTANCE.getPluginMgrService();
            if (pluginMgrService != null) {
                i = pluginMgrService.getPluginVersionCode("com.baidu.searchbox.livenps");
            } else {
                i = 0;
            }
            if (i >= 604000000) {
                z2 = true;
            }
        }
        this.prefetchEnterSwitch = z2;
        this.loadMoreFraction = 3;
        this.serverSwitchCanScroll = true;
        this.localSwitchCanScroll = true;
        this.itemData = new ArrayList();
        this.shellList = new ArrayList();
        this.listManager$delegate = LazyKt__LazyJVMKt.lazy(new Function0<IListManager>() { // from class: com.baidu.searchbox.live.list.controller.ListController$listManager$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IListManager invoke() {
                MiniUniqueId miniUniqueId2;
                IMixActivityInterface iMixActivityInterface2;
                MiniUniqueId miniUniqueId3;
                IMixActivityInterface iMixActivityInterface3;
                if (((AbConfigService) ServiceManager.getService(AbConfigService.Companion.getSERVICE_REFERENCE())).getSwitch("live_android_mixview_pager", false)) {
                    ListController listController = ListController.this;
                    Context context2 = listController.getContext();
                    miniUniqueId3 = ListController.this.mixUniqueId;
                    iMixActivityInterface3 = ListController.this.mixActivity;
                    return new PagerController(listController, context2, miniUniqueId3, iMixActivityInterface3);
                }
                ListController listController2 = ListController.this;
                Context context3 = listController2.getContext();
                miniUniqueId2 = ListController.this.mixUniqueId;
                iMixActivityInterface2 = ListController.this.mixActivity;
                return new RecyleController(listController2, context3, miniUniqueId2, iMixActivityInterface2);
            }
        });
        this.mMixEventDispatcher$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ListController$mMixEventDispatcher$2.AnonymousClass1>() { // from class: com.baidu.searchbox.live.list.controller.ListController$mMixEventDispatcher$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.searchbox.live.list.controller.ListController$mMixEventDispatcher$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                return new MixInvokeAbility() { // from class: com.baidu.searchbox.live.list.controller.ListController$mMixEventDispatcher$2.1
                    /* JADX WARN: Code restructure failed: missing block: B:34:0x006d, code lost:
                        if (android.text.TextUtils.isEmpty(r4) != false) goto L32;
                     */
                    @Override // com.baidu.searchbox.live.interfaces.mix.MixInvokeAbility
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void onCommonEvent(String str, Object obj) {
                        IntentData.SchemeModel schemeModel;
                        String str2;
                        MixModel mixModel;
                        String str3;
                        String str4;
                        if (str.hashCode() == -179496859 && str.equals(MixConstants.KEY_NETWORK_CHANGED)) {
                            String str5 = null;
                            if (!(obj instanceof Boolean)) {
                                obj = null;
                            }
                            Boolean bool = (Boolean) obj;
                            if (bool != null && bool.booleanValue()) {
                                boolean z3 = true;
                                if (ListController.this.getItemData().size() <= 1) {
                                    IntentData mIntentData = ListController.this.getMIntentData();
                                    if (mIntentData != null) {
                                        schemeModel = mIntentData.getModel();
                                    } else {
                                        schemeModel = null;
                                    }
                                    if (schemeModel != null) {
                                        str2 = schemeModel.getRoomType();
                                    } else {
                                        str2 = null;
                                    }
                                    if (!TextUtils.isEmpty(str2)) {
                                        if (schemeModel != null) {
                                            str3 = schemeModel.getRoomType();
                                        } else {
                                            str3 = null;
                                        }
                                        if (Intrinsics.areEqual("0", str3)) {
                                            if (schemeModel != null) {
                                                str4 = schemeModel.getTemplateId();
                                            } else {
                                                str4 = null;
                                            }
                                        }
                                        z3 = false;
                                    }
                                    if (ListController.this.getItemData().size() == 0) {
                                        IntentData mIntentData2 = ListController.this.getMIntentData();
                                        if (mIntentData2 != null) {
                                            str5 = mIntentData2.getId();
                                        }
                                        if (!TextUtils.isEmpty(str5) && z3) {
                                            mixModel = ListController.this.mNetModel;
                                            if (mixModel != null) {
                                                mixModel.reqLiveType();
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    ListController.this.queryLiveList();
                                }
                            }
                        }
                    }
                };
            }
        });
        this.liveSessionService = (LiveSessionService) ServiceManager.getService(LiveSessionService.Companion.getSERVICE_REFERENCE());
        Object service = ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        Intrinsics.checkExpressionValueIsNotNull(service, "ServiceManager.getServic…anager.SERVICE_REFERENCE)");
        this.ubcManager = (UBCManager) service;
    }

    private final void bindHLReplayInfo(LiveContainer.LiveItemModel liveItemModel, String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("nid", str);
        if (liveItemModel != null) {
            liveItemModel.setHlReplay(jSONObject);
        }
    }

    private final void distinct(List<LiveContainer.LiveItemModel> list, List<LiveContainer.LiveItemModel> list2) {
        for (LiveContainer.LiveItemModel liveItemModel : list) {
            if (list2.contains(liveItemModel)) {
                list2.remove(liveItemModel);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cacheCloseRoomIdList(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            if (!TextUtils.isEmpty(jSONArray.optString(i))) {
                arrayList.add(jSONArray.optString(i));
            }
        }
        getListManager().onCloseRoom(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPreRoomEnterDataLoaded(MixResult<LiveRoomEnterRespData> mixResult) {
        if (mixResult instanceof MixResult.MixSuccess) {
            MixResult.MixSuccess mixSuccess = (MixResult.MixSuccess) mixResult;
            this.preReqRoomEnterData = (LiveRoomEnterRespData) mixSuccess.getData();
            this.preReqStatData = mixSuccess.getStatData();
        }
    }

    public final void fetchMoreLiveIfNeed(int i) {
        if (i >= this.itemData.size() - this.loadMoreFraction) {
            queryLiveList();
        }
    }

    @Override // com.baidu.searchbox.live.list.controller.IListListener
    public void onAfterSelect(int i) {
        LiveRoomInfoStatPlugin liveRoomInfoStatPlugin;
        this.isFromForward = false;
        fetchMoreLiveIfNeed(i);
        List<LiveContainer.LiveItemModel> list = this.itemData;
        if (list != null && i >= 0 && i < list.size() && (liveRoomInfoStatPlugin = this.mLiveRoomInfoStatPlugin) != null) {
            liveRoomInfoStatPlugin.dispatchLiveItemModelSelectedAction(this.itemData.get(i));
        }
    }

    @Override // com.baidu.live.arch.api.IExtLifecycle
    public void onConfigurationChanged(Configuration configuration) {
        AbstractMixFakeShell abstractMixFakeShell;
        List<WeakReference<AbstractMixFakeShell>> list = this.shellList;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference != null && (abstractMixFakeShell = (AbstractMixFakeShell) weakReference.get()) != null) {
                    abstractMixFakeShell.onConfigurationChanged(configuration);
                }
            }
        }
    }

    @Override // com.baidu.live.arch.api.IExtLifecycle
    public void onNewIntent(Intent intent) {
        AbstractMixFakeShell abstractMixFakeShell;
        this.mIntentData = ListExtKt.parseLiveData(intent);
        reloadLiveRoom();
        List<WeakReference<AbstractMixFakeShell>> list = this.shellList;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference != null && (abstractMixFakeShell = (AbstractMixFakeShell) weakReference.get()) != null) {
                    abstractMixFakeShell.onNewIntent(intent);
                }
            }
        }
    }

    public final void setCurRoomModel(LiveContainer.LiveItemModel liveItemModel) {
        this.curRoomModel = liveItemModel;
    }

    public final void setCurrentPosition(int i) {
        this.currentPosition = i;
    }

    public final void setFromForward(boolean z) {
        this.isFromForward = z;
    }

    public final void setHandler(Handler handler) {
        this.handler = handler;
    }

    public final void setHasReqEnd(boolean z) {
        this.hasReqEnd = z;
    }

    public final void setHasReqStart(boolean z) {
        this.hasReqStart = z;
    }

    public final void setMIntentData(IntentData intentData) {
        this.mIntentData = intentData;
    }

    public final void setMPageInfo(PageInfo pageInfo) {
        this.mPageInfo = pageInfo;
    }

    public final void setPreReqRoomEnterData(LiveRoomEnterRespData liveRoomEnterRespData) {
        this.preReqRoomEnterData = liveRoomEnterRespData;
    }

    public final void setPreReqStatData(MixResultStatData mixResultStatData) {
        this.preReqStatData = mixResultStatData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changeScrollState() {
        if (this.serverSwitchCanScroll) {
            IListManager listManager = getListManager();
            if (listManager != null) {
                listManager.setIsScrollable(this.localSwitchCanScroll);
                return;
            }
            return;
        }
        IListManager listManager2 = getListManager();
        if (listManager2 != null) {
            listManager2.setIsScrollable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void queryLiveList() {
        this.listRequestTime = System.currentTimeMillis();
        this.listRequestDuration = 0L;
        MixModel mixModel = this.mNetModel;
        if (mixModel != null) {
            mixModel.queryLiveList();
        }
    }

    private final void registerMixRequestService() {
        MixRequestServiceLocator.Companion.registerGlobalServices(MixRequestService.class, new MixRequestService() { // from class: com.baidu.searchbox.live.list.controller.ListController$registerMixRequestService$1
            @Override // com.baidu.searchbox.live.service.MixRequestService
            public void requestRoomEnter(RoomEnterParams roomEnterParams, boolean z, OnMixDataLoaded<MixResult<LiveRoomEnterRespData>> onMixDataLoaded) {
                MixModel mixModel;
                JSONObject jSONObject;
                String str;
                long j;
                JSONObject optJSONObject;
                JSONObject optJSONObject2;
                if (z) {
                    LiveRoomEnterRespData preReqRoomEnterData = ListController.this.getPreReqRoomEnterData();
                    String str2 = null;
                    if (preReqRoomEnterData != null) {
                        JSONObject respJsonObj = preReqRoomEnterData.getRespJsonObj();
                        if (respJsonObj != null) {
                            jSONObject = respJsonObj.optJSONObject("data");
                        } else {
                            jSONObject = null;
                        }
                        if (jSONObject != null && (optJSONObject2 = jSONObject.optJSONObject(YYOption.ROOM_ID)) != null) {
                            str = optJSONObject2.optString("room_id");
                        } else {
                            str = null;
                        }
                        if (Intrinsics.areEqual(str, roomEnterParams.getId())) {
                            long currentTimeMillis = System.currentTimeMillis() - preReqRoomEnterData.getConstructTimeMills();
                            JSONObject optJSONObject3 = jSONObject.optJSONObject("switch");
                            if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("sdk_loading")) != null) {
                                j = optJSONObject.optLong("enter_expire");
                            } else {
                                j = 5000;
                            }
                            if (currentTimeMillis <= j) {
                                LiveRoomEnterRespData liveRoomEnterRespData = new LiveRoomEnterRespData(preReqRoomEnterData.getRespJsonObj());
                                liveRoomEnterRespData.setHitCache(true);
                                liveRoomEnterRespData.setConstructTimeMills(preReqRoomEnterData.getConstructTimeMills());
                                if (onMixDataLoaded != null) {
                                    onMixDataLoaded.onMixDataLoaded(new MixResult.MixSuccess(liveRoomEnterRespData, ListController.this.getPreReqStatData()));
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    MediaLiveEnterRoomRate mediaLiveEnterRoomRate = MediaLiveEnterRoomRate.INSTANCE;
                    String id = roomEnterParams.getId();
                    IntentData mIntentData = ListController.this.getMIntentData();
                    if (mIntentData != null) {
                        str2 = mIntentData.getSource();
                    }
                    mediaLiveEnterRoomRate.doEnterUbcByRequestEnter(id, "req_end_cache_invalid", str2);
                }
                mixModel = ListController.this.mNetModel;
                if (mixModel != null) {
                    mixModel.reqRoomEnter(roomEnterParams, onMixDataLoaded);
                }
            }
        });
    }

    private final void registerYYLifeCyclePlugin() {
        Lifecycle lifeCycle;
        if (!this.isRegistYYActivityLifeCyclePlugin) {
            this.mYYLifeCyclePlugin = new YYActivityLifeCyclePlugin(this.context);
            IMixActivityInterface iMixActivityInterface = this.mixActivity;
            if (iMixActivityInterface != null && (lifeCycle = iMixActivityInterface.getLifeCycle()) != null) {
                YYActivityLifeCyclePlugin yYActivityLifeCyclePlugin = this.mYYLifeCyclePlugin;
                if (yYActivityLifeCyclePlugin == null) {
                    Intrinsics.throwNpe();
                }
                lifeCycle.addObserver(yYActivityLifeCyclePlugin);
            }
            this.isRegistYYActivityLifeCyclePlugin = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reloadLiveRoom() {
        IntentData intentData = this.mIntentData;
        if (intentData != null && intentData.getSchemeData() != null) {
            int size = this.itemData.size();
            if (size > 0) {
                this.itemData.clear();
                getListManager().clear(size);
            }
            loadLiveRoom();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unBindHLReplayInfo() {
        IntentData.SchemeModel schemeData;
        IntentData intentData = this.mIntentData;
        if (intentData != null && (schemeData = intentData.getSchemeData()) != null) {
            schemeData.setHlReplyIntoLive(null);
        }
    }

    private final void unregisterMixRequestService() {
        MixRequestServiceLocator.Companion.unregisterGlobalService(MixRequestService.class);
    }

    public final View createView() {
        return getListManager().createView();
    }

    public final void finish() {
        ServiceLocator.Companion.unregisterGlobalService(ILiveListState.class);
        ServiceLocator.Companion.unregisterGlobalService(LiveItemModelListService.class);
        ServiceLocator.Companion.unregisterGlobalService(MixListOperatorInterface.class);
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        unregisterMixRequestService();
        MixModel mixModel = this.mNetModel;
        if (mixModel != null) {
            mixModel.removeReqEnterIdCallbacks(null);
        }
        this.preReqRoomEnterData = null;
        this.preReqStatData = null;
    }

    public final Context getContext() {
        return this.context;
    }

    public final LiveContainer.LiveItemModel getCurRoomModel() {
        return this.curRoomModel;
    }

    public final int getCurrentPosition() {
        return this.currentPosition;
    }

    public final Handler getHandler() {
        return this.handler;
    }

    public final boolean getHasReqEnd() {
        return this.hasReqEnd;
    }

    public final boolean getHasReqStart() {
        return this.hasReqStart;
    }

    public final List<LiveContainer.LiveItemModel> getItemData() {
        return this.itemData;
    }

    public final IntentData getMIntentData() {
        return this.mIntentData;
    }

    public final PageInfo getMPageInfo() {
        return this.mPageInfo;
    }

    public final LiveRoomEnterRespData getPreReqRoomEnterData() {
        return this.preReqRoomEnterData;
    }

    public final MixResultStatData getPreReqStatData() {
        return this.preReqStatData;
    }

    public final List<WeakReference<AbstractMixFakeShell>> getShellList() {
        return this.shellList;
    }

    public final boolean isFromForward() {
        return this.isFromForward;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(19:36|(3:(1:39)(1:98)|40|(1:42)(2:(1:94)(1:97)|(1:96)))(1:99)|43|(1:(15:46|47|(1:(1:50)(11:72|52|53|54|(1:56)|57|(1:59)(1:69)|(1:68)|(1:64)|65|66))(1:73)|51|52|53|54|(0)|57|(0)(0)|(1:61)|68|(0)|65|66))(5:75|(1:77)|78|(4:80|(1:82)|(1:89)(1:86)|87)(2:90|(1:92))|88)|74|47|(0)(0)|51|52|53|54|(0)|57|(0)(0)|(0)|68|(0)|65|66) */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x01f9, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01fa, code lost:
        r2 = kotlin.Result.Companion;
        r0 = kotlin.Result.m851constructorimpl(kotlin.ResultKt.createFailure(r0));
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01e3 A[Catch: all -> 0x01f9, TryCatch #4 {all -> 0x01f9, blocks: (B:102:0x01a7, B:105:0x01b3, B:110:0x01e3, B:115:0x01ed), top: B:136:0x01a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x015f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void jumpToNewLiveRoom(String str, String str2, String str3, String str4, long j, String str5, String str6) {
        IntentData.SchemeModel schemeModel;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        IntentData.SchemeModel model;
        String roomId;
        Intent intent;
        IntentData intentData;
        IMixActivityInterface iMixActivityInterface;
        IMixActivityInterface iMixActivityInterface2;
        IntentData.SchemeModel schemeData;
        String source;
        JSONObject jSONObject;
        JSONObject ext;
        JSONObject jSONObject2;
        JSONObject extLog;
        JSONObject jSONObject3;
        IntentData.SchemeModel copy;
        String schemeParam;
        String str14;
        String jSONObject4;
        String str15 = "";
        IntentData intentData2 = this.mIntentData;
        JSONObject jSONObject5 = null;
        if (intentData2 != null) {
            schemeModel = intentData2.getSchemeData();
        } else {
            schemeModel = null;
        }
        boolean z = false;
        try {
            Result.Companion companion = Result.Companion;
        } catch (Throwable th) {
            th = th;
            str7 = "";
            str8 = str7;
        }
        if (!TextUtils.isEmpty(str3)) {
            Uri uriScheme = Uri.parse(str3);
            Intrinsics.checkExpressionValueIsNotNull(uriScheme, "uriScheme");
            String query = uriScheme.getQuery();
            if (query != null && StringsKt__StringsKt.contains$default((CharSequence) query, (CharSequence) "params", false, 2, (Object) null) && !TextUtils.isEmpty(uriScheme.getQueryParameter("params"))) {
                jSONObject4 = uriScheme.getQueryParameter("params");
                if (jSONObject4 == null) {
                    Intrinsics.throwNpe();
                }
            } else {
                JSONObject paramsToJson = MiniJsonUtils.INSTANCE.paramsToJson(str3);
                jSONObject4 = paramsToJson != null ? paramsToJson.toString() : null;
            }
            if (jSONObject4 != null) {
                IntentData.SchemeModel parseSchemeData = IntentData.Companion.parseSchemeData(jSONObject4, str3);
                str7 = parseSchemeData.getTemplateId();
                try {
                    str8 = parseSchemeData.getRoomType();
                    try {
                        str9 = parseSchemeData.getTitle();
                        try {
                            IntentData intentData3 = this.mIntentData;
                            if (intentData3 != null) {
                                intentData3.setModel(parseSchemeData);
                            }
                            Result.m851constructorimpl(Unit.INSTANCE);
                        } catch (Throwable th2) {
                            th = th2;
                            Result.Companion companion2 = Result.Companion;
                            Result.m851constructorimpl(ResultKt.createFailure(th));
                            str10 = str7;
                            str11 = str8;
                            str12 = str9;
                            if (!TextUtils.isEmpty(str)) {
                            }
                            intent = new Intent();
                            intent.putExtra("roomId", str13);
                            intentData = this.mIntentData;
                            if (intentData != null) {
                            }
                            this.mIntentData = ListExtKt.parseLiveData(intent);
                            iMixActivityInterface = this.mixActivity;
                            if (iMixActivityInterface != null) {
                            }
                            iMixActivityInterface2 = this.mixActivity;
                            if (iMixActivityInterface2 != null) {
                            }
                            reloadLiveRoom();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str9 = "";
                        Result.Companion companion22 = Result.Companion;
                        Result.m851constructorimpl(ResultKt.createFailure(th));
                        str10 = str7;
                        str11 = str8;
                        str12 = str9;
                        if (!TextUtils.isEmpty(str)) {
                        }
                        intent = new Intent();
                        intent.putExtra("roomId", str13);
                        intentData = this.mIntentData;
                        if (intentData != null) {
                        }
                        this.mIntentData = ListExtKt.parseLiveData(intent);
                        iMixActivityInterface = this.mixActivity;
                        if (iMixActivityInterface != null) {
                        }
                        iMixActivityInterface2 = this.mixActivity;
                        if (iMixActivityInterface2 != null) {
                        }
                        reloadLiveRoom();
                    }
                } catch (Throwable th4) {
                    th = th4;
                    str8 = "";
                    str9 = str8;
                    Result.Companion companion222 = Result.Companion;
                    Result.m851constructorimpl(ResultKt.createFailure(th));
                    str10 = str7;
                    str11 = str8;
                    str12 = str9;
                    if (!TextUtils.isEmpty(str)) {
                    }
                    intent = new Intent();
                    intent.putExtra("roomId", str13);
                    intentData = this.mIntentData;
                    if (intentData != null) {
                    }
                    this.mIntentData = ListExtKt.parseLiveData(intent);
                    iMixActivityInterface = this.mixActivity;
                    if (iMixActivityInterface != null) {
                    }
                    iMixActivityInterface2 = this.mixActivity;
                    if (iMixActivityInterface2 != null) {
                    }
                    reloadLiveRoom();
                }
                str10 = str7;
                str11 = str8;
                str12 = str9;
                if (!TextUtils.isEmpty(str)) {
                    str13 = str;
                } else {
                    IntentData intentData4 = this.mIntentData;
                    if (intentData4 == null || (model = intentData4.getModel()) == null || (roomId = model.getRoomId()) == null) {
                        str13 = "";
                    } else {
                        str13 = roomId;
                    }
                }
                intent = new Intent();
                intent.putExtra("roomId", str13);
                intentData = this.mIntentData;
                if (intentData != null && (schemeData = intentData.getSchemeData()) != null) {
                    if (!TextUtils.isEmpty(schemeData.getSource())) {
                        if (schemeModel != null) {
                            str14 = schemeModel.getSource();
                        } else {
                            str14 = null;
                        }
                        if (TextUtils.isEmpty(str14)) {
                            source = "";
                        } else {
                            if (schemeModel != null) {
                                source = schemeModel.getSource();
                            } else {
                                source = null;
                            }
                            if (source == null) {
                                Intrinsics.throwNpe();
                            }
                        }
                    } else {
                        source = schemeData.getSource();
                    }
                    if (schemeData.getExt() != null) {
                        if (schemeModel != null) {
                            jSONObject2 = schemeModel.getExt();
                            String liveBackScheme = schemeData.getLiveBackScheme();
                            JSONObject extRequest = schemeData.getExtRequest();
                            if (schemeData.getExtLog() == null) {
                                if (schemeModel != null) {
                                    extLog = schemeModel.getExtLog();
                                } else {
                                    jSONObject3 = null;
                                    copy = schemeData.copy((r50 & 1) != 0 ? schemeData.roomId : str13, (r50 & 2) != 0 ? schemeData.roomType : str11, (r50 & 4) != 0 ? schemeData.source : source, (r50 & 8) != 0 ? schemeData.cover : str2, (r50 & 16) != 0 ? schemeData.playUrl : str6, (r50 & 32) != 0 ? schemeData.status : "", (r50 & 64) != 0 ? schemeData.format : "", (r50 & 128) != 0 ? schemeData.screen : "", (r50 & 256) != 0 ? schemeData.template : "", (r50 & 512) != 0 ? schemeData.liveBackScheme : liveBackScheme, (r50 & 1024) != 0 ? schemeData.ext : jSONObject2, (r50 & 2048) != 0 ? schemeData.extRequest : extRequest, (r50 & 4096) != 0 ? schemeData.extLog : jSONObject3, (r50 & 8192) != 0 ? schemeData.query : null, (r50 & 16384) != 0 ? schemeData.extParams : schemeData.getExtParams(), (r50 & 32768) != 0 ? schemeData.askId : "", (r50 & 65536) != 0 ? schemeData.templateId : str10, (r50 & 131072) != 0 ? schemeData.otherParams : null, (r50 & 262144) != 0 ? schemeData.invokePop : null, (r50 & 524288) != 0 ? schemeData.searchIntoLiveJson : null, (r50 & 1048576) != 0 ? schemeData.hlReplyIntoLive : null, (r50 & 2097152) != 0 ? schemeData.shareUid : null, (r50 & 4194304) != 0 ? schemeData.shareTag : null, (r50 & 8388608) != 0 ? schemeData.avcUrl : null, (r50 & 16777216) != 0 ? schemeData.hevcUrl : null, (r50 & 33554432) != 0 ? schemeData.rtcUrl : null, (r50 & 67108864) != 0 ? schemeData.title : str12, (r50 & SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION) != 0 ? schemeData.shareTaskInfo : null, (r50 & LaunchTaskConstants.OTHER_PROCESS) != 0 ? schemeData.quic : null, (r50 & NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH) != 0 ? schemeData.inviterId : null, (r50 & 1073741824) != 0 ? schemeData.highlightUrl : null, (r50 & Integer.MIN_VALUE) != 0 ? schemeData.introduceTips : null);
                                    intent.putExtra("params", copy.toSchemeParams());
                                    Result.Companion companion3 = Result.Companion;
                                    Uri parse = Uri.parse(str3);
                                    MiniShellRuntime miniShellRuntime = MiniShellRuntime.INSTANCE;
                                    if (str != null) {
                                        str15 = str;
                                    }
                                    String buildLiveScheme = miniShellRuntime.buildLiveScheme(str15, schemeData.getSource(), parse);
                                    schemeParam = MixUriUtilKt.setSchemeParam(buildLiveScheme, CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair("clickTime", String.valueOf(j)), new Pair("clickFrom", str5)}), true);
                                    if (schemeParam != null) {
                                        schemeParam = buildLiveScheme;
                                    }
                                    if (!((schemeParam != null || schemeParam.length() == 0) ? true : true)) {
                                        buildLiveScheme = schemeParam;
                                    }
                                    Object m851constructorimpl = Result.m851constructorimpl(intent.putExtra("scheme", buildLiveScheme));
                                    Result.m850boximpl(m851constructorimpl);
                                }
                            } else {
                                extLog = schemeData.getExtLog();
                            }
                            jSONObject3 = extLog;
                            copy = schemeData.copy((r50 & 1) != 0 ? schemeData.roomId : str13, (r50 & 2) != 0 ? schemeData.roomType : str11, (r50 & 4) != 0 ? schemeData.source : source, (r50 & 8) != 0 ? schemeData.cover : str2, (r50 & 16) != 0 ? schemeData.playUrl : str6, (r50 & 32) != 0 ? schemeData.status : "", (r50 & 64) != 0 ? schemeData.format : "", (r50 & 128) != 0 ? schemeData.screen : "", (r50 & 256) != 0 ? schemeData.template : "", (r50 & 512) != 0 ? schemeData.liveBackScheme : liveBackScheme, (r50 & 1024) != 0 ? schemeData.ext : jSONObject2, (r50 & 2048) != 0 ? schemeData.extRequest : extRequest, (r50 & 4096) != 0 ? schemeData.extLog : jSONObject3, (r50 & 8192) != 0 ? schemeData.query : null, (r50 & 16384) != 0 ? schemeData.extParams : schemeData.getExtParams(), (r50 & 32768) != 0 ? schemeData.askId : "", (r50 & 65536) != 0 ? schemeData.templateId : str10, (r50 & 131072) != 0 ? schemeData.otherParams : null, (r50 & 262144) != 0 ? schemeData.invokePop : null, (r50 & 524288) != 0 ? schemeData.searchIntoLiveJson : null, (r50 & 1048576) != 0 ? schemeData.hlReplyIntoLive : null, (r50 & 2097152) != 0 ? schemeData.shareUid : null, (r50 & 4194304) != 0 ? schemeData.shareTag : null, (r50 & 8388608) != 0 ? schemeData.avcUrl : null, (r50 & 16777216) != 0 ? schemeData.hevcUrl : null, (r50 & 33554432) != 0 ? schemeData.rtcUrl : null, (r50 & 67108864) != 0 ? schemeData.title : str12, (r50 & SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION) != 0 ? schemeData.shareTaskInfo : null, (r50 & LaunchTaskConstants.OTHER_PROCESS) != 0 ? schemeData.quic : null, (r50 & NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH) != 0 ? schemeData.inviterId : null, (r50 & 1073741824) != 0 ? schemeData.highlightUrl : null, (r50 & Integer.MIN_VALUE) != 0 ? schemeData.introduceTips : null);
                            intent.putExtra("params", copy.toSchemeParams());
                            Result.Companion companion32 = Result.Companion;
                            Uri parse2 = Uri.parse(str3);
                            MiniShellRuntime miniShellRuntime2 = MiniShellRuntime.INSTANCE;
                            if (str != null) {
                            }
                            String buildLiveScheme2 = miniShellRuntime2.buildLiveScheme(str15, schemeData.getSource(), parse2);
                            schemeParam = MixUriUtilKt.setSchemeParam(buildLiveScheme2, CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair("clickTime", String.valueOf(j)), new Pair("clickFrom", str5)}), true);
                            if (schemeParam != null) {
                            }
                            if (!((schemeParam != null || schemeParam.length() == 0) ? true : true)) {
                            }
                            Object m851constructorimpl2 = Result.m851constructorimpl(intent.putExtra("scheme", buildLiveScheme2));
                            Result.m850boximpl(m851constructorimpl2);
                        }
                    } else {
                        JSONObject ext2 = schemeData.getExt();
                        if (ext2 == null) {
                            Intrinsics.throwNpe();
                        }
                        JSONObject optJSONObject = ext2.optJSONObject("ext");
                        if (optJSONObject == null) {
                            JSONObject ext3 = schemeData.getExt();
                            if (ext3 == null) {
                                Intrinsics.throwNpe();
                            }
                            if (schemeModel != null && (ext = schemeModel.getExt()) != null) {
                                jSONObject = ext.optJSONObject("ext");
                            } else {
                                jSONObject = null;
                            }
                            ext3.put("ext", jSONObject);
                        } else if (TextUtils.isEmpty(optJSONObject.optString("source"))) {
                            optJSONObject.put("source", source);
                        }
                        jSONObject5 = schemeData.getExt();
                    }
                    jSONObject2 = jSONObject5;
                    String liveBackScheme2 = schemeData.getLiveBackScheme();
                    JSONObject extRequest2 = schemeData.getExtRequest();
                    if (schemeData.getExtLog() == null) {
                    }
                    jSONObject3 = extLog;
                    copy = schemeData.copy((r50 & 1) != 0 ? schemeData.roomId : str13, (r50 & 2) != 0 ? schemeData.roomType : str11, (r50 & 4) != 0 ? schemeData.source : source, (r50 & 8) != 0 ? schemeData.cover : str2, (r50 & 16) != 0 ? schemeData.playUrl : str6, (r50 & 32) != 0 ? schemeData.status : "", (r50 & 64) != 0 ? schemeData.format : "", (r50 & 128) != 0 ? schemeData.screen : "", (r50 & 256) != 0 ? schemeData.template : "", (r50 & 512) != 0 ? schemeData.liveBackScheme : liveBackScheme2, (r50 & 1024) != 0 ? schemeData.ext : jSONObject2, (r50 & 2048) != 0 ? schemeData.extRequest : extRequest2, (r50 & 4096) != 0 ? schemeData.extLog : jSONObject3, (r50 & 8192) != 0 ? schemeData.query : null, (r50 & 16384) != 0 ? schemeData.extParams : schemeData.getExtParams(), (r50 & 32768) != 0 ? schemeData.askId : "", (r50 & 65536) != 0 ? schemeData.templateId : str10, (r50 & 131072) != 0 ? schemeData.otherParams : null, (r50 & 262144) != 0 ? schemeData.invokePop : null, (r50 & 524288) != 0 ? schemeData.searchIntoLiveJson : null, (r50 & 1048576) != 0 ? schemeData.hlReplyIntoLive : null, (r50 & 2097152) != 0 ? schemeData.shareUid : null, (r50 & 4194304) != 0 ? schemeData.shareTag : null, (r50 & 8388608) != 0 ? schemeData.avcUrl : null, (r50 & 16777216) != 0 ? schemeData.hevcUrl : null, (r50 & 33554432) != 0 ? schemeData.rtcUrl : null, (r50 & 67108864) != 0 ? schemeData.title : str12, (r50 & SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION) != 0 ? schemeData.shareTaskInfo : null, (r50 & LaunchTaskConstants.OTHER_PROCESS) != 0 ? schemeData.quic : null, (r50 & NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH) != 0 ? schemeData.inviterId : null, (r50 & 1073741824) != 0 ? schemeData.highlightUrl : null, (r50 & Integer.MIN_VALUE) != 0 ? schemeData.introduceTips : null);
                    intent.putExtra("params", copy.toSchemeParams());
                    Result.Companion companion322 = Result.Companion;
                    Uri parse22 = Uri.parse(str3);
                    MiniShellRuntime miniShellRuntime22 = MiniShellRuntime.INSTANCE;
                    if (str != null) {
                    }
                    String buildLiveScheme22 = miniShellRuntime22.buildLiveScheme(str15, schemeData.getSource(), parse22);
                    schemeParam = MixUriUtilKt.setSchemeParam(buildLiveScheme22, CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair("clickTime", String.valueOf(j)), new Pair("clickFrom", str5)}), true);
                    if (schemeParam != null) {
                    }
                    if (!((schemeParam != null || schemeParam.length() == 0) ? true : true)) {
                    }
                    Object m851constructorimpl22 = Result.m851constructorimpl(intent.putExtra("scheme", buildLiveScheme22));
                    Result.m850boximpl(m851constructorimpl22);
                }
                this.mIntentData = ListExtKt.parseLiveData(intent);
                iMixActivityInterface = this.mixActivity;
                if (iMixActivityInterface != null) {
                    iMixActivityInterface.setMixEventDispatcher(MixConstants.KEY_CLOSE_IM, null);
                }
                iMixActivityInterface2 = this.mixActivity;
                if (iMixActivityInterface2 != null) {
                    iMixActivityInterface2.setMixEventDispatcher(MixConstants.KEY_NEW_INTENT, intent);
                }
                reloadLiveRoom();
            }
        }
        str7 = "";
        str8 = str7;
        str9 = str8;
        Result.m851constructorimpl(Unit.INSTANCE);
        str10 = str7;
        str11 = str8;
        str12 = str9;
        if (!TextUtils.isEmpty(str)) {
        }
        intent = new Intent();
        intent.putExtra("roomId", str13);
        intentData = this.mIntentData;
        if (intentData != null) {
            if (!TextUtils.isEmpty(schemeData.getSource())) {
            }
            if (schemeData.getExt() != null) {
            }
            jSONObject2 = jSONObject5;
            String liveBackScheme22 = schemeData.getLiveBackScheme();
            JSONObject extRequest22 = schemeData.getExtRequest();
            if (schemeData.getExtLog() == null) {
            }
            jSONObject3 = extLog;
            copy = schemeData.copy((r50 & 1) != 0 ? schemeData.roomId : str13, (r50 & 2) != 0 ? schemeData.roomType : str11, (r50 & 4) != 0 ? schemeData.source : source, (r50 & 8) != 0 ? schemeData.cover : str2, (r50 & 16) != 0 ? schemeData.playUrl : str6, (r50 & 32) != 0 ? schemeData.status : "", (r50 & 64) != 0 ? schemeData.format : "", (r50 & 128) != 0 ? schemeData.screen : "", (r50 & 256) != 0 ? schemeData.template : "", (r50 & 512) != 0 ? schemeData.liveBackScheme : liveBackScheme22, (r50 & 1024) != 0 ? schemeData.ext : jSONObject2, (r50 & 2048) != 0 ? schemeData.extRequest : extRequest22, (r50 & 4096) != 0 ? schemeData.extLog : jSONObject3, (r50 & 8192) != 0 ? schemeData.query : null, (r50 & 16384) != 0 ? schemeData.extParams : schemeData.getExtParams(), (r50 & 32768) != 0 ? schemeData.askId : "", (r50 & 65536) != 0 ? schemeData.templateId : str10, (r50 & 131072) != 0 ? schemeData.otherParams : null, (r50 & 262144) != 0 ? schemeData.invokePop : null, (r50 & 524288) != 0 ? schemeData.searchIntoLiveJson : null, (r50 & 1048576) != 0 ? schemeData.hlReplyIntoLive : null, (r50 & 2097152) != 0 ? schemeData.shareUid : null, (r50 & 4194304) != 0 ? schemeData.shareTag : null, (r50 & 8388608) != 0 ? schemeData.avcUrl : null, (r50 & 16777216) != 0 ? schemeData.hevcUrl : null, (r50 & 33554432) != 0 ? schemeData.rtcUrl : null, (r50 & 67108864) != 0 ? schemeData.title : str12, (r50 & SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION) != 0 ? schemeData.shareTaskInfo : null, (r50 & LaunchTaskConstants.OTHER_PROCESS) != 0 ? schemeData.quic : null, (r50 & NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH) != 0 ? schemeData.inviterId : null, (r50 & 1073741824) != 0 ? schemeData.highlightUrl : null, (r50 & Integer.MIN_VALUE) != 0 ? schemeData.introduceTips : null);
            intent.putExtra("params", copy.toSchemeParams());
            Result.Companion companion3222 = Result.Companion;
            Uri parse222 = Uri.parse(str3);
            MiniShellRuntime miniShellRuntime222 = MiniShellRuntime.INSTANCE;
            if (str != null) {
            }
            String buildLiveScheme222 = miniShellRuntime222.buildLiveScheme(str15, schemeData.getSource(), parse222);
            schemeParam = MixUriUtilKt.setSchemeParam(buildLiveScheme222, CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair("clickTime", String.valueOf(j)), new Pair("clickFrom", str5)}), true);
            if (schemeParam != null) {
            }
            if (!((schemeParam != null || schemeParam.length() == 0) ? true : true)) {
            }
            Object m851constructorimpl222 = Result.m851constructorimpl(intent.putExtra("scheme", buildLiveScheme222));
            Result.m850boximpl(m851constructorimpl222);
        }
        this.mIntentData = ListExtKt.parseLiveData(intent);
        iMixActivityInterface = this.mixActivity;
        if (iMixActivityInterface != null) {
        }
        iMixActivityInterface2 = this.mixActivity;
        if (iMixActivityInterface2 != null) {
        }
        reloadLiveRoom();
    }

    public static /* synthetic */ void jumpToNewLiveRoom$default(ListController listController, String str, String str2, String str3, String str4, long j, String str5, String str6, int i, Object obj) {
        String str7;
        if ((i & 64) != 0) {
            str7 = "";
        } else {
            str7 = str6;
        }
        listController.jumpToNewLiveRoom(str, str2, str3, str4, j, str5, str7);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.baidu.searchbox.live.model.MixModel */
    /* JADX DEBUG: Multi-variable search result rejected for r3v27, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r3v28, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r3v29, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r3v40, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void loadLiveRoom() {
        String str;
        LiveContainer.LiveItemModel liveItemModel;
        String roomType;
        String title;
        String str2;
        ListLogKt.log("MixLiveCell_fake_list", "listComponent loadLiveRoom context:" + this.context.hashCode());
        logEventOnReach();
        IntentData intentData = this.mIntentData;
        if (intentData != null) {
            if (TextUtils.isEmpty(intentData.getId())) {
                MediaLivePluginLogger.Companion.getInstance().logListBeginSlideReqStart();
                queryLiveList();
                ListLogKt.log("MixLiveCell_fake_list", "listComponent room id is empty, request slidlist context:" + this.context.hashCode());
                return;
            }
            JSONObject jSONObject = null;
            if (StringsKt__StringsKt.contains$default((CharSequence) intentData.getScheme(), (CharSequence) "//live/yylive/joinlive", false, 2, (Object) null)) {
                intentData.getModel().setRoomType("3");
            }
            String str3 = "0";
            if (this.prefetchEnterSwitch && Intrinsics.areEqual(intentData.getModel().getRoomType(), "0")) {
                preReqRoomEnter();
            }
            if (!TextUtils.isEmpty(intentData.getModel().getRoomType()) && (!Intrinsics.areEqual("0", intentData.getModel().getRoomType()) || !TextUtils.isEmpty(intentData.getModel().getTemplateId()))) {
                this.isFromForward = true;
                MediaLiveEnterRoomRate mediaLiveEnterRoomRate = MediaLiveEnterRoomRate.INSTANCE;
                String id = intentData.getId();
                IntentData intentData2 = this.mIntentData;
                if (intentData2 != null) {
                    str = intentData2.getSource();
                } else {
                    str = null;
                }
                mediaLiveEnterRoomRate.doEnterFirstSegmentEnd(id, "0", "", str, "normal", Boolean.valueOf(true ^ Intrinsics.areEqual(intentData.getModel().getRoomType(), "3")));
                if (Intrinsics.areEqual(intentData.getModel().getRoomType(), "3")) {
                    IntentData intentData3 = this.mIntentData;
                    if (intentData3 != null) {
                        str2 = intentData3.getScheme();
                    } else {
                        str2 = null;
                    }
                    if (str2 != null) {
                        try {
                            Map<String, String> stringToMap = MixUriUtilKt.stringToMap(MixUriUtilKt.getParamsStr(str2));
                            Ref.ObjectRef objectRef = new Ref.ObjectRef();
                            boolean containsKey = stringToMap.containsKey("params");
                            T t = stringToMap;
                            if (containsKey) {
                                try {
                                    t = paramsJsonToMap(new JSONObject(stringToMap.get("params")));
                                } catch (Exception unused) {
                                    t = 0;
                                }
                            }
                            objectRef.element = t;
                            if (t != null) {
                                JSONObject jSONObject2 = new JSONObject(MiniJsonUtils.INSTANCE.bundleToJsonStr((Map) t));
                                try {
                                    Unit unit = Unit.INSTANCE;
                                    jSONObject = jSONObject2;
                                } catch (Exception e) {
                                    e = e;
                                    jSONObject = jSONObject2;
                                    e.printStackTrace();
                                    Unit unit2 = Unit.INSTANCE;
                                    String scheme = intentData.getScheme();
                                    LiveContainer.PlaySourceInfo playSourceInfo = this.playSource;
                                    liveItemModel = new LiveContainer.LiveItemModel();
                                    liveItemModel.setRoomId(intentData.getId());
                                    liveItemModel.setCover(intentData.getModel().getCover());
                                    roomType = intentData.getModel().getRoomType();
                                    if (roomType != null) {
                                    }
                                    liveItemModel.setLiveType(str3);
                                    liveItemModel.setScheme(scheme);
                                    liveItemModel.setPlayUrl(intentData.getModel().getPlayUrl());
                                    liveItemModel.setStatus(intentData.getModel().getStatus());
                                    liveItemModel.setFormat(intentData.getModel().getFormat());
                                    liveItemModel.setScreen(intentData.getModel().getScreen());
                                    liveItemModel.setTemplate(intentData.getModel().getTemplate());
                                    liveItemModel.setTemplateId(intentData.getModel().getTemplateId());
                                    liveItemModel.setPlaySource(playSourceInfo);
                                    title = intentData.getModel().getTitle();
                                    if (title == null) {
                                    }
                                    liveItemModel.setTitle(title);
                                    liveItemModel.setOtherParams(intentData.getModel().getOtherParams());
                                    liveItemModel.setOriginJson(jSONObject);
                                    liveItemModel.setAvcUrl(intentData.getModel().getAvcUrl());
                                    liveItemModel.setHevcUrl(intentData.getModel().getHevcUrl());
                                    liveItemModel.setRtcUrl(intentData.getModel().getRtcUrl());
                                    liveItemModel.setRtcHevcUrl(intentData.getModel().getRtcHevcUrl());
                                    liveItemModel.setQuic(intentData.getModel().getQuic());
                                    liveItemModel.setHighlightUrl(intentData.getModel().getHighlightUrl());
                                    liveItemModel.setExt(intentData.getModel().getExt());
                                    liveItemModel.setSource(intentData.getModel().getSource());
                                    liveItemModel.setShareTaskInfo(intentData.getModel().getShareTaskInfo());
                                    liveItemModel.setKabrSpts(intentData.getModel().getKabrSpts());
                                    liveItemModel.setCommonShareInfo(intentData.getModel().getCommonShareInfo());
                                    liveItemModel.setMultiRate(intentData.getModel().getMultiRate());
                                    liveItemModel.setFromIntent(intentData.getModel().getFromIntent());
                                    liveItemModel.setVrParams(intentData.getModel().getVrParams());
                                    liveItemModel.setPlayRateSetting(intentData.getModel().getPlayRateSetting());
                                    liveItemModel.setInterventions(intentData.getModel().getInterventions());
                                    this.itemData.add(liveItemModel);
                                    if (this.itemData.indexOf(liveItemModel) < 0) {
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                        }
                    }
                }
                String scheme2 = intentData.getScheme();
                LiveContainer.PlaySourceInfo playSourceInfo2 = this.playSource;
                liveItemModel = new LiveContainer.LiveItemModel();
                liveItemModel.setRoomId(intentData.getId());
                liveItemModel.setCover(intentData.getModel().getCover());
                roomType = intentData.getModel().getRoomType();
                if (roomType != null) {
                    str3 = roomType;
                }
                liveItemModel.setLiveType(str3);
                liveItemModel.setScheme(scheme2);
                liveItemModel.setPlayUrl(intentData.getModel().getPlayUrl());
                liveItemModel.setStatus(intentData.getModel().getStatus());
                liveItemModel.setFormat(intentData.getModel().getFormat());
                liveItemModel.setScreen(intentData.getModel().getScreen());
                liveItemModel.setTemplate(intentData.getModel().getTemplate());
                liveItemModel.setTemplateId(intentData.getModel().getTemplateId());
                liveItemModel.setPlaySource(playSourceInfo2);
                title = intentData.getModel().getTitle();
                if (title == null) {
                    title = "";
                }
                liveItemModel.setTitle(title);
                liveItemModel.setOtherParams(intentData.getModel().getOtherParams());
                liveItemModel.setOriginJson(jSONObject);
                liveItemModel.setAvcUrl(intentData.getModel().getAvcUrl());
                liveItemModel.setHevcUrl(intentData.getModel().getHevcUrl());
                liveItemModel.setRtcUrl(intentData.getModel().getRtcUrl());
                liveItemModel.setRtcHevcUrl(intentData.getModel().getRtcHevcUrl());
                liveItemModel.setQuic(intentData.getModel().getQuic());
                liveItemModel.setHighlightUrl(intentData.getModel().getHighlightUrl());
                liveItemModel.setExt(intentData.getModel().getExt());
                liveItemModel.setSource(intentData.getModel().getSource());
                liveItemModel.setShareTaskInfo(intentData.getModel().getShareTaskInfo());
                liveItemModel.setKabrSpts(intentData.getModel().getKabrSpts());
                liveItemModel.setCommonShareInfo(intentData.getModel().getCommonShareInfo());
                liveItemModel.setMultiRate(intentData.getModel().getMultiRate());
                liveItemModel.setFromIntent(intentData.getModel().getFromIntent());
                liveItemModel.setVrParams(intentData.getModel().getVrParams());
                liveItemModel.setPlayRateSetting(intentData.getModel().getPlayRateSetting());
                liveItemModel.setInterventions(intentData.getModel().getInterventions());
                this.itemData.add(liveItemModel);
                if (this.itemData.indexOf(liveItemModel) < 0) {
                    this.curRoomModel = liveItemModel;
                    getListManager().resetCurRoom(liveItemModel);
                    LiveRoomInfoStatPlugin liveRoomInfoStatPlugin = this.mLiveRoomInfoStatPlugin;
                    if (liveRoomInfoStatPlugin != null) {
                        liveRoomInfoStatPlugin.dispatchFirstLiveItemModelAction(liveItemModel);
                    }
                    queryLiveList();
                    ListLogKt.log("MixLiveCell_fake_list", "listComponent enter first, request slidlist context:" + this.context.hashCode());
                    MediaLivePluginLogger.Companion.getInstance().logListLoadRoomAndNextListAddItem();
                    return;
                }
                return;
            }
            MediaLivePluginLogger.Companion.getInstance().logListBeginGetLiveTypeStart();
            MixModel mixModel = this.mNetModel;
            if (mixModel != 0) {
                mixModel.reqLiveType(new OnMixDataLoaded<MixResult<? extends LiveRoomEnterRespData>>() { // from class: com.baidu.searchbox.live.list.controller.ListController$loadLiveRoom$$inlined$run$lambda$1
                    /* renamed from: onMixDataLoaded  reason: avoid collision after fix types in other method */
                    public void onMixDataLoaded2(MixResult<LiveRoomEnterRespData> mixResult) {
                        ListController.this.onPreRoomEnterDataLoaded(mixResult);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.baidu.searchbox.live.model.res.OnMixDataLoaded
                    public /* bridge */ /* synthetic */ void onMixDataLoaded(MixResult<? extends LiveRoomEnterRespData> mixResult) {
                        onMixDataLoaded2((MixResult<LiveRoomEnterRespData>) mixResult);
                    }
                });
            }
            ListLogKt.log("MixLiveCell_fake_list", "listComponent room type=" + intentData.getModel().getRoomType() + " || templateId=" + intentData.getModel().getTemplateId() + " is empty, request livetype context:" + this.context.hashCode());
        }
    }

    private final void logEventOnReach() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        IntentData.SchemeModel model;
        IntentData.SchemeModel model2;
        IntentData.SchemeModel model3;
        JSONObject jSONObject = new JSONObject();
        String str6 = null;
        try {
            IntentData intentData = this.mIntentData;
            if (intentData != null) {
                str = intentData.getId();
            } else {
                str = null;
            }
            jSONObject.put(MixYYFakeShell.ROOM_ID_YY, str);
            IntentData intentData2 = this.mIntentData;
            if (intentData2 != null) {
                str2 = intentData2.getId();
            } else {
                str2 = null;
            }
            jSONObject.put("roomId", str2);
            IntentData intentData3 = this.mIntentData;
            if (intentData3 != null && (model3 = intentData3.getModel()) != null) {
                str3 = model3.getScreen();
            } else {
                str3 = null;
            }
            jSONObject.put("screen", str3);
            IntentData intentData4 = this.mIntentData;
            if (intentData4 != null && (model2 = intentData4.getModel()) != null) {
                str4 = model2.getRoomType();
            } else {
                str4 = null;
            }
            jSONObject.put("roomType", str4);
            IntentData intentData5 = this.mIntentData;
            if (intentData5 != null && (model = intentData5.getModel()) != null) {
                str5 = model.getTemplateId();
            } else {
                str5 = null;
            }
            jSONObject.put("templateID", str5);
            jSONObject.put("live_version", String.valueOf(MiniPluginUtils.INSTANCE.getComponentInstalledVersion("com.baidu.searchbox.livenps")));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ListUbc listUbc = ListUbc.getInstance();
        IntentData intentData6 = this.mIntentData;
        if (intentData6 != null) {
            str6 = intentData6.getSource();
        }
        listUbc.reportReachEvent(ListUbc.KEY_ID_REACH_LIVEROOM, ListUbc.UBC_TYPE_REACH, "", "", str6, jSONObject);
    }

    public final void onCreate() {
        IntentData intentData;
        Intent intent;
        this.mixActivity.setMixInvokeAbility(getMMixEventDispatcher());
        MediaLivePluginLogger.Companion.getInstance().logListOnCreateStart();
        Activity activity = PluginContextUtil.INSTANCE.getActivity(this.context);
        if (activity != null && (intent = activity.getIntent()) != null) {
            intentData = ListExtKt.parseLiveData(intent);
        } else {
            intentData = null;
        }
        this.mIntentData = intentData;
        ServiceLocator.Companion.registerGlobalServices(ILiveListState.class, new ILiveListState() { // from class: com.baidu.searchbox.live.list.controller.ListController$onCreate$1
            @Override // com.baidu.searchbox.live.service.ILiveListState
            public IntentData getIntent() {
                return ListController.this.getMIntentData();
            }

            @Override // com.baidu.searchbox.live.service.ILiveListState
            public ListInfo getListInfo() {
                ListInfo listInfo;
                listInfo = ListController.this.mListInfo;
                return listInfo;
            }

            @Override // com.baidu.searchbox.live.service.ILiveListState
            public PageInfo getPageInfo() {
                return ListController.this.getMPageInfo();
            }
        });
        ServiceLocator.Companion.registerGlobalServices(LiveItemModelListService.class, new LiveItemModelListService() { // from class: com.baidu.searchbox.live.list.controller.ListController$onCreate$2
            @Override // com.baidu.searchbox.live.component.service.LiveItemModelListService
            public int getCurrentPosition() {
                return ListController.this.getCurrentPosition();
            }

            @Override // com.baidu.searchbox.live.component.service.LiveItemModelListService
            public List<LiveContainer.LiveItemModel> getLiveItemModels() {
                return ListController.this.getItemData();
            }
        });
        ServiceLocator.Companion.registerGlobalServices(MixListOperatorInterface.class, new MixListOperatorInterface() { // from class: com.baidu.searchbox.live.list.controller.ListController$onCreate$3
            @Override // com.baidu.searchbox.live.service.MixListOperatorInterface
            public void insertRoom(int i, JSONObject jSONObject) {
            }

            @Override // com.baidu.searchbox.live.service.MixListOperatorInterface
            public void reloadLiveRoom(Object obj) {
                ListController.this.reloadLiveRoom();
            }

            @Override // com.baidu.searchbox.live.service.MixListOperatorInterface
            public void reloadSlideList(Object obj) {
                ListController listController = ListController.this;
                listController.fetchMoreLiveIfNeed(listController.getCurrentPosition());
            }

            @Override // com.baidu.searchbox.live.service.MixListOperatorInterface
            public void removeRoom(JSONObject jSONObject) {
                jSONObject.optString("source");
                JSONArray roomIdJSONArray = jSONObject.optJSONArray("room_ids");
                ListController listController = ListController.this;
                Intrinsics.checkExpressionValueIsNotNull(roomIdJSONArray, "roomIdJSONArray");
                listController.cacheCloseRoomIdList(roomIdJSONArray);
            }

            @Override // com.baidu.searchbox.live.service.MixListOperatorInterface
            public void commonEvent(String str, Object obj) {
                if (str.hashCode() == -500901780 && str.equals(MixConstants.KEY_ROOM_INFO_RES_SUCCESS)) {
                    String str2 = null;
                    if (!(obj instanceof JSONObject)) {
                        obj = null;
                    }
                    JSONObject jSONObject = (JSONObject) obj;
                    if (jSONObject != null) {
                        String optString = jSONObject.optString("templateId");
                        int optInt = jSONObject.optInt("roomType");
                        String optString2 = jSONObject.optString("roomId");
                        if (ListController.this.getCurrentPosition() >= 0 && ListController.this.getCurrentPosition() < ListController.this.getItemData().size()) {
                            LiveContainer.LiveItemModel liveItemModel = ListController.this.getItemData().get(ListController.this.getCurrentPosition());
                            ListLogKt.log("MixLiveCell_fake_list", "item model : roomId = " + liveItemModel.getRoomId() + ", roomType= " + liveItemModel.getLiveType() + ", templateId=" + liveItemModel.getTemplateId() + ", response : roomId = " + optString2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + "roomType=" + optInt + ", templateId=" + optString);
                            MediaLiveEnterRoomRate mediaLiveEnterRoomRate = MediaLiveEnterRoomRate.INSTANCE;
                            IntentData mIntentData = ListController.this.getMIntentData();
                            if (mIntentData != null) {
                                str2 = mIntentData.getSource();
                            }
                            mediaLiveEnterRoomRate.doEnterFirstSegmentTemplateNotMatchError(optString2, "", "", str2);
                            if (Intrinsics.areEqual(optString2, liveItemModel.getRoomId())) {
                                IntentData mIntentData2 = ListController.this.getMIntentData();
                                if (mIntentData2 != null) {
                                    mIntentData2.getModel().setRoomType(String.valueOf(optInt));
                                    mIntentData2.getModel().setTemplateId(optString);
                                }
                                liveItemModel.setLiveType(String.valueOf(optInt));
                                liveItemModel.setTemplateId(optString);
                            }
                        }
                    }
                }
            }

            @Override // com.baidu.searchbox.live.service.MixListOperatorInterface
            public void doJumpNewLiveRoom(JSONObject jSONObject) {
                IntentData mIntentData = ListController.this.getMIntentData();
                if (mIntentData != null && mIntentData.isHLReplay()) {
                    ListController.this.unBindHLReplayInfo();
                }
                if (jSONObject != null) {
                    ListController listController = ListController.this;
                    String optString = jSONObject.optString("roomId", "");
                    Intrinsics.checkExpressionValueIsNotNull(optString, "it.optString(\"roomId\", \"\")");
                    String optString2 = jSONObject.optString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, "");
                    Intrinsics.checkExpressionValueIsNotNull(optString2, "it.optString(\"cover\", \"\")");
                    String optString3 = jSONObject.optString("scheme", "");
                    Intrinsics.checkExpressionValueIsNotNull(optString3, "it.optString(\"scheme\", \"\")");
                    String optString4 = jSONObject.optString("from", "");
                    Intrinsics.checkExpressionValueIsNotNull(optString4, "it.optString(\"from\", \"\")");
                    long optLong = jSONObject.optLong("clickTime", 0L);
                    String optString5 = jSONObject.optString("clickFrom", "");
                    Intrinsics.checkExpressionValueIsNotNull(optString5, "it.optString(\"clickFrom\", \"\")");
                    String optString6 = jSONObject.optString("playUrl", "");
                    Intrinsics.checkExpressionValueIsNotNull(optString6, "it.optString(\"playUrl\", \"\")");
                    listController.jumpToNewLiveRoom(optString, optString2, optString3, optString4, optLong, optString5, optString6);
                }
            }

            @Override // com.baidu.searchbox.live.service.MixListOperatorInterface
            public List<LiveContainer.LiveItemModel> getListData() {
                return ListController.this.getItemData();
            }

            @Override // com.baidu.searchbox.live.service.MixListOperatorInterface
            public void scrollToNextLiveRoom() {
                IListManager listManager;
                listManager = ListController.this.getListManager();
                listManager.scrollToNextLiveRoom();
            }

            @Override // com.baidu.searchbox.live.service.MixListOperatorInterface
            public void scrollToPreLiveRoom() {
                IListManager listManager;
                listManager = ListController.this.getListManager();
                listManager.scrollToPreLiveRoom();
            }

            @Override // com.baidu.searchbox.live.service.MixListOperatorInterface
            public void switchLiveListScrollable(boolean z, boolean z2) {
                IListManager listManager;
                if (z2) {
                    ListController.this.serverSwitchCanScroll = z;
                    ListController.this.changeScrollState();
                    return;
                }
                listManager = ListController.this.getListManager();
                listManager.setIsScrollable(z);
                ListController.this.localSwitchCanScroll = z;
                ListController.this.changeScrollState();
            }
        });
        registerMixRequestService();
        MixModel mixModel = new MixModel(this.mixUniqueId);
        mixModel.setOnMixDataLoadedCallBack(new MixModel.OnMixDataLoadedCallBack() { // from class: com.baidu.searchbox.live.list.controller.ListController$onCreate$$inlined$apply$lambda$1
            @Override // com.baidu.searchbox.live.model.MixModel.OnMixDataLoadedCallBack
            public void onTemplateIdSuccess(LiveTypeData liveTypeData) {
                ListController.this.templateIdSuccess(liveTypeData);
            }

            @Override // com.baidu.searchbox.live.model.MixModel.OnMixDataLoadedCallBack
            public void onSlideListFail(Exception exc, Integer num, String str) {
                String str2;
                String str3;
                MediaLiveEnterRoomRate mediaLiveEnterRoomRate = MediaLiveEnterRoomRate.INSTANCE;
                if (num != null) {
                    str2 = String.valueOf(num.intValue());
                } else {
                    str2 = null;
                }
                String message = exc.getMessage();
                IntentData mIntentData = ListController.this.getMIntentData();
                if (mIntentData != null) {
                    str3 = mIntentData.getSource();
                } else {
                    str3 = null;
                }
                mediaLiveEnterRoomRate.doEnterFirstSegmentApiError("", str2, message, str3, str, "slide_list");
            }

            @Override // com.baidu.searchbox.live.model.MixModel.OnMixDataLoadedCallBack
            public void onTemplateIdFail(Exception exc, Integer num, String str) {
                String str2;
                String str3;
                MediaLiveEnterRoomRate mediaLiveEnterRoomRate = MediaLiveEnterRoomRate.INSTANCE;
                if (num != null) {
                    str2 = String.valueOf(num.intValue());
                } else {
                    str2 = null;
                }
                String message = exc.getMessage();
                IntentData mIntentData = ListController.this.getMIntentData();
                if (mIntentData != null) {
                    str3 = mIntentData.getSource();
                } else {
                    str3 = null;
                }
                mediaLiveEnterRoomRate.doEnterFirstSegmentApiError("", str2, message, str3, str, "template_id");
            }

            @Override // com.baidu.searchbox.live.model.MixModel.OnMixDataLoadedCallBack
            public void onSlideListSuccess(String str, int i, List<LiveContainer.LiveItemModel> list) {
                IMixActivityInterface iMixActivityInterface;
                LiveRoomInfoStatPlugin liveRoomInfoStatPlugin;
                ListController.this.mListInfo = new ListInfo(str, i);
                iMixActivityInterface = ListController.this.mixActivity;
                if (iMixActivityInterface != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pageSession", str);
                    jSONObject.put("hasMore", i);
                    iMixActivityInterface.setMixEventDispatcher(MixConstants.KEY_LIST_INFO, jSONObject);
                }
                liveRoomInfoStatPlugin = ListController.this.mLiveRoomInfoStatPlugin;
                if (liveRoomInfoStatPlugin != null) {
                    liveRoomInfoStatPlugin.dispatchListResult(str, i, list);
                }
                ListController.this.slideListSuccess(str, i, list);
            }
        });
        this.mNetModel = mixModel;
        MediaLivePluginLogger.Companion.getInstance().logListOnCreateEndAndNextToLoadRoom();
        loadLiveRoom();
        MixEventBus.getInstance().register(this, YYPluginEvent.StartLoadYYPluginEvent.class, this);
        MixEventBus.getInstance().register(this, YYPluginEvent.LoadYYPluginRes.class, this);
        MixEventBus.getInstance().register(this, MixMediaEvent.YYGoBackPopUp.class, this);
        if (MiniPluginManager.INSTANCE.isYYPluginAvailable()) {
            registerYYLifeCyclePlugin();
        }
        LiveRoomInfoStatPlugin liveRoomInfoStatPlugin = new LiveRoomInfoStatPlugin(this.context, this.mixUniqueId);
        this.mLiveRoomInfoStatPlugin = liveRoomInfoStatPlugin;
        if (liveRoomInfoStatPlugin != null) {
            liveRoomInfoStatPlugin.onCreate();
        }
    }

    private final Map<String, String> paramsJsonToMap(JSONObject jSONObject) {
        String str;
        if (jSONObject == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkExpressionValueIsNotNull(keys, "input.keys()");
        while (keys.hasNext()) {
            String key = keys.next();
            Object opt = jSONObject.opt(key);
            if (opt instanceof String) {
                Intrinsics.checkExpressionValueIsNotNull(key, "key");
                linkedHashMap.put(key, opt);
            } else {
                Intrinsics.checkExpressionValueIsNotNull(key, "key");
                if (opt != null) {
                    str = opt.toString();
                } else {
                    str = null;
                }
                linkedHashMap.put(key, str);
            }
        }
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String parseClickTime(String str, LiveContainer.PlaySourceInfo playSourceInfo) {
        boolean z;
        Uri uri;
        Integer num;
        String str2;
        Long valueOf;
        String str3;
        String str4;
        String clickFrom;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return str;
        }
        String str5 = null;
        try {
            uri = Uri.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
            uri = null;
        }
        if (playSourceInfo != null) {
            num = Integer.valueOf(playSourceInfo.getFirstJump());
        } else {
            num = null;
        }
        if (uri != null) {
            str2 = uri.getQueryParameter("clickTime");
        } else {
            str2 = null;
        }
        if (str2 != null) {
            try {
                valueOf = Long.valueOf(Long.parseLong(str2));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (uri == null) {
                str3 = uri.getQueryParameter("clickFrom");
            } else {
                str3 = null;
            }
            if (valueOf != null) {
                if (playSourceInfo != null) {
                    valueOf = playSourceInfo.getClickTime();
                } else {
                    valueOf = null;
                }
                if (playSourceInfo != null) {
                    str5 = playSourceInfo.getClickFrom();
                }
            } else {
                num = 1;
                if (str3 == null) {
                    if (playSourceInfo != null && (clickFrom = playSourceInfo.getClickFrom()) != null && StringsKt__StringsJVMKt.endsWith$default(clickFrom, "_unknow", false, 2, null)) {
                        str3 = playSourceInfo.getClickFrom();
                    } else {
                        StringBuilder sb = new StringBuilder();
                        if (playSourceInfo != null) {
                            str4 = playSourceInfo.getClickFrom();
                        } else {
                            str4 = null;
                        }
                        sb.append(str4);
                        sb.append("_unknow");
                        str3 = sb.toString();
                    }
                }
                Uri uriParam = MixUriUtilKt.setUriParam(uri, CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair("clickTime", null), new Pair("clickFrom", null)}), true);
                if (uriParam != null) {
                    str = uriParam.toString();
                    Intrinsics.checkExpressionValueIsNotNull(str, "newUri.toString()");
                }
                str5 = str3;
            }
            if (playSourceInfo != null) {
                playSourceInfo.setClickTime(valueOf);
            }
            if (playSourceInfo != null) {
                playSourceInfo.setClickFrom(str5);
            }
            if (num != null) {
                int intValue = num.intValue();
                if (playSourceInfo != null) {
                    playSourceInfo.setFirstJump(intValue);
                }
            }
            return str;
        }
        valueOf = null;
        if (uri == null) {
        }
        if (valueOf != null) {
        }
        if (playSourceInfo != null) {
        }
        if (playSourceInfo != null) {
        }
        if (num != null) {
        }
        return str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.searchbox.live.model.MixModel */
    /* JADX WARN: Multi-variable type inference failed */
    private final void preReqRoomEnter() {
        String str;
        String str2;
        String str3;
        String jSONObject;
        String jSONObject2;
        IntentData intentData = this.mIntentData;
        if (intentData != null) {
            String id = intentData.getId();
            String source = intentData.getSource();
            JSONObject searchIntoLiveJson = intentData.getModel().getSearchIntoLiveJson();
            if (searchIntoLiveJson != null) {
                str = searchIntoLiveJson.optString("question");
            } else {
                str = null;
            }
            JSONObject hlReplyIntoLive = intentData.getModel().getHlReplyIntoLive();
            String str4 = "";
            if (hlReplyIntoLive != null) {
                str2 = hlReplyIntoLive.optString("nid", "");
            } else {
                str2 = null;
            }
            JSONObject ext = intentData.getModel().getExt();
            if (ext == null || (jSONObject2 = ext.toString()) == null) {
                str3 = "";
            } else {
                str3 = jSONObject2;
            }
            RoomEnterParams roomEnterParams = new RoomEnterParams(id, source, str, str2, str3, false, 32, null);
            JSONObject extLog = intentData.getModel().getExtLog();
            if (extLog != null && (jSONObject = extLog.toString()) != null) {
                str4 = jSONObject;
            }
            roomEnterParams.setExtLog(str4);
            roomEnterParams.setAudio(Boolean.valueOf(Intrinsics.areEqual(intentData.getModel().getTemplateId(), "5")));
            MixModel mixModel = this.mNetModel;
            if (mixModel != 0) {
                mixModel.reqRoomEnter(roomEnterParams, new OnMixDataLoaded<MixResult<? extends LiveRoomEnterRespData>>() { // from class: com.baidu.searchbox.live.list.controller.ListController$preReqRoomEnter$$inlined$let$lambda$1
                    /* renamed from: onMixDataLoaded  reason: avoid collision after fix types in other method */
                    public void onMixDataLoaded2(MixResult<LiveRoomEnterRespData> mixResult) {
                        ListController.this.onPreRoomEnterDataLoaded(mixResult);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.baidu.searchbox.live.model.res.OnMixDataLoaded
                    public /* bridge */ /* synthetic */ void onMixDataLoaded(MixResult<? extends LiveRoomEnterRespData> mixResult) {
                        onMixDataLoaded2((MixResult<LiveRoomEnterRespData>) mixResult);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void slideListSuccess(String str, int i, List<LiveContainer.LiveItemModel> list) {
        final int size = this.itemData.size();
        distinct(this.itemData, list);
        this.itemData.addAll(list);
        MediaLivePlayLogger.Companion.getInstance().logLiveRoomEndSlideParseAddItem();
        MiniUiThreadUtil.INSTANCE.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.live.list.controller.ListController$slideListSuccess$1
            @Override // java.lang.Runnable
            public final void run() {
                IListManager listManager;
                long j;
                long j2;
                IListManager listManager2;
                String str2;
                String str3;
                MediaLivePluginLogger.Companion.getInstance().logListSlideEndAndAddItem();
                listManager = ListController.this.getListManager();
                listManager.onListChange(size);
                if (ListController.this.getCurRoomModel() == null && ListController.this.getItemData().size() > 0) {
                    ListController listController = ListController.this;
                    boolean z = false;
                    listController.setCurRoomModel(listController.getItemData().get(0));
                    listManager2 = ListController.this.getListManager();
                    LiveContainer.LiveItemModel curRoomModel = ListController.this.getCurRoomModel();
                    if (curRoomModel == null) {
                        Intrinsics.throwNpe();
                    }
                    listManager2.resetCurRoom(curRoomModel);
                    MediaLiveEnterRoomRate mediaLiveEnterRoomRate = MediaLiveEnterRoomRate.INSTANCE;
                    LiveContainer.LiveItemModel curRoomModel2 = ListController.this.getCurRoomModel();
                    if (curRoomModel2 != null) {
                        str2 = curRoomModel2.getRoomId();
                    } else {
                        str2 = null;
                    }
                    IntentData mIntentData = ListController.this.getMIntentData();
                    if (mIntentData != null) {
                        str3 = mIntentData.getSource();
                    } else {
                        str3 = null;
                    }
                    LiveContainer.LiveItemModel curRoomModel3 = ListController.this.getCurRoomModel();
                    mediaLiveEnterRoomRate.doEnterFirstSegmentEnd(str2, "", "", str3, "slide_list", Boolean.valueOf((curRoomModel3 == null || !curRoomModel3.isYYLive()) ? true : true));
                }
                j = ListController.this.listRequestTime;
                if (j > 0) {
                    ListController listController2 = ListController.this;
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = ListController.this.listRequestTime;
                    listController2.listRequestDuration = currentTimeMillis - j2;
                }
                MediaLivePluginLogger.Companion.getInstance().logListLoadRoomAndNextListAddItem();
            }
        });
        ListLogKt.log("MixLiveCell_fake_list", "listComponent slidlist request success size:" + this.itemData.size() + " context:" + this.context.hashCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void templateIdSuccess(LiveTypeData liveTypeData) {
        boolean z;
        String str;
        String str2;
        String nidFromHLReplay;
        IntentData intentData = this.mIntentData;
        if (intentData != null) {
            MediaLivePlayLogger.startLaunchInfoSigleLine$default(MediaLivePlayLogger.Companion.getInstance(), intentData.getId(), "precreate", false, 4, null);
            if (this.playSource == null) {
                LiveContainer.PlaySourceInfo playSourceInfo = new LiveContainer.PlaySourceInfo();
                playSourceInfo.setClickTime(Long.valueOf(System.currentTimeMillis()));
                playSourceInfo.setClickFrom("precreate");
                this.playSource = playSourceInfo;
            }
            String parseClickTime = parseClickTime(intentData.getScheme(), this.playSource);
            boolean z2 = false;
            if (parseClickTime != null && parseClickTime.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                intentData.setScheme(parseClickTime);
            }
            MediaLivePluginLogger.Companion.getInstance().logGetLiveTypeEndAndItem();
            this.isFromForward = true;
            String scheme = intentData.getScheme();
            LiveContainer.PlaySourceInfo playSourceInfo2 = this.playSource;
            LiveContainer.LiveItemModel liveItemModel = new LiveContainer.LiveItemModel();
            liveItemModel.setRoomId(intentData.getId());
            liveItemModel.setCover(intentData.getModel().getCover());
            String liveType = liveTypeData.getLiveType();
            if (liveType == null) {
                liveType = "0";
            }
            liveItemModel.setLiveType(liveType);
            liveItemModel.setScheme(scheme);
            liveItemModel.setPlayUrl(intentData.getModel().getPlayUrl());
            liveItemModel.setStatus(intentData.getModel().getStatus());
            liveItemModel.setFormat(intentData.getModel().getFormat());
            liveItemModel.setScreen(intentData.getModel().getScreen());
            liveItemModel.setTemplate(intentData.getModel().getTemplate());
            liveItemModel.setTemplateId(liveTypeData.getTemplateId());
            liveItemModel.setPlaySource(playSourceInfo2);
            String title = intentData.getModel().getTitle();
            String str3 = "";
            if (title == null) {
                title = "";
            }
            liveItemModel.setTitle(title);
            liveItemModel.setIntroduceTips(intentData.getModel().getIntroduceTips());
            liveItemModel.setShareTaskInfo(intentData.getModel().getShareTaskInfo());
            liveItemModel.setCommonShareInfo(intentData.getModel().getCommonShareInfo());
            liveItemModel.setVrParams(intentData.getModel().getVrParams());
            liveItemModel.setInterventions(intentData.getModel().getInterventions());
            if (intentData.isHLReplay()) {
                IntentData intentData2 = this.mIntentData;
                if (intentData2 != null && (nidFromHLReplay = intentData2.getNidFromHLReplay()) != null) {
                    str3 = nidFromHLReplay;
                }
                bindHLReplayInfo(liveItemModel, str3);
            }
            this.itemData.add(liveItemModel);
            if (this.itemData.indexOf(liveItemModel) >= 0) {
                this.curRoomModel = liveItemModel;
                getListManager().resetCurRoom(liveItemModel);
                LiveRoomInfoStatPlugin liveRoomInfoStatPlugin = this.mLiveRoomInfoStatPlugin;
                if (liveRoomInfoStatPlugin != null) {
                    liveRoomInfoStatPlugin.dispatchFirstLiveItemModelAction(liveItemModel);
                }
                MediaLivePluginLogger.Companion.getInstance().logListLoadRoomAndNextListAddItem();
                MediaLiveEnterRoomRate mediaLiveEnterRoomRate = MediaLiveEnterRoomRate.INSTANCE;
                LiveContainer.LiveItemModel liveItemModel2 = this.curRoomModel;
                if (liveItemModel2 != null) {
                    str = liveItemModel2.getRoomId();
                } else {
                    str = null;
                }
                IntentData intentData3 = this.mIntentData;
                if (intentData3 != null) {
                    str2 = intentData3.getSource();
                } else {
                    str2 = null;
                }
                LiveContainer.LiveItemModel liveItemModel3 = this.curRoomModel;
                mediaLiveEnterRoomRate.doEnterFirstSegmentEnd(str, "", "", str2, "template_id", Boolean.valueOf((liveItemModel3 == null || !liveItemModel3.isYYLive()) ? true : true));
                queryLiveList();
                ListLogKt.log("MixLiveCell_fake_list", "livetype request success, enter, request slidlist context:" + this.context.hashCode());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.live.eventbus.EventAction
    public void call(AbstractEvent abstractEvent) {
        IMixActivityInterface iMixActivityInterface;
        if (abstractEvent == null || abstractEvent.getUniqueId() != this.mixUniqueId.getId()) {
            return;
        }
        if (abstractEvent instanceof YYPluginEvent.StartLoadYYPluginEvent) {
            if (this.mYYLoadPluginPlugin == null) {
                YYLoadPluginPlugin yYLoadPluginPlugin = new YYLoadPluginPlugin(this.context, this.mixUniqueId);
                this.mYYLoadPluginPlugin = yYLoadPluginPlugin;
                if (yYLoadPluginPlugin != null) {
                    yYLoadPluginPlugin.onCreate();
                }
            }
        } else if (abstractEvent instanceof YYPluginEvent.LoadYYPluginRes) {
            YYPluginEvent.LoadYYPluginRes loadYYPluginRes = (YYPluginEvent.LoadYYPluginRes) abstractEvent;
            if (loadYYPluginRes.getRes() == 1) {
                registerYYLifeCyclePlugin();
            } else if (loadYYPluginRes.getRes() == 2) {
                registerYYLifeCyclePlugin();
            }
        } else if ((abstractEvent instanceof MixMediaEvent.YYGoBackPopUp) && (iMixActivityInterface = this.mixActivity) != null) {
            iMixActivityInterface.setMixEventDispatcher(MixConstants.KEY_YYGoBackPopUp, ((MixMediaEvent.YYGoBackPopUp) abstractEvent).getRoomId());
        }
    }

    @Override // com.baidu.live.arch.api.IExtLifecycle
    public void onActivityResult(int i, int i2, Intent intent) {
        AbstractMixFakeShell abstractMixFakeShell;
        List<WeakReference<AbstractMixFakeShell>> list = this.shellList;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference != null && (abstractMixFakeShell = (AbstractMixFakeShell) weakReference.get()) != null) {
                    abstractMixFakeShell.onActivityResult(i, i2, intent);
                }
            }
        }
    }

    @Override // com.baidu.live.arch.api.IExtLifecycle
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AbstractMixFakeShell abstractMixFakeShell;
        List<WeakReference<AbstractMixFakeShell>> list = this.shellList;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference != null && (abstractMixFakeShell = (AbstractMixFakeShell) weakReference.get()) != null) {
                    abstractMixFakeShell.onRequestPermissionsResult(i, strArr, iArr);
                }
            }
        }
    }

    @Override // com.baidu.searchbox.live.list.controller.IListListener
    public void onBeforeSelect(int i) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String templateId;
        String str7;
        String str8;
        String roomId;
        LiveContainer.LiveItemModel liveItemModel;
        String str9;
        String templateId2;
        LiveContainer.LiveItemModel liveItemModel2 = this.curRoomModel;
        String str10 = "";
        if (liveItemModel2 != null && (roomId = liveItemModel2.getRoomId()) != null) {
            LiveContainer.LiveItemModel liveItemModel3 = this.curRoomModel;
            if (liveItemModel3 != null && !liveItemModel3.isYYLive() && (liveItemModel = this.curRoomModel) != null && !liveItemModel.isAudioLive()) {
                LiveComponentLoadLogger companion = LiveComponentLoadLogger.Companion.getInstance();
                LiveContainer.LiveItemModel liveItemModel4 = this.curRoomModel;
                if (liveItemModel4 == null || (templateId2 = liveItemModel4.getTemplateId()) == null) {
                    str9 = "";
                } else {
                    str9 = templateId2;
                }
                LiveComponentLoadLogger.launchMediaCompLoadFlow$default(companion, roomId, str9, !this.isFromForward, null, 8, null);
            } else {
                LiveComponentLoadLogger.Companion.getInstance().cancelCurrentComponentFlow(roomId);
            }
        }
        if (this.isFromForward) {
            LiveContainer.LiveItemModel liveItemModel5 = this.curRoomModel;
            String str11 = null;
            if (liveItemModel5 != null && liveItemModel5.isMediaBusiness()) {
                MediaLiveEnterRoomRate mediaLiveEnterRoomRate = MediaLiveEnterRoomRate.INSTANCE;
                LiveContainer.LiveItemModel liveItemModel6 = this.curRoomModel;
                if (liveItemModel6 != null) {
                    str7 = liveItemModel6.getRoomId();
                } else {
                    str7 = null;
                }
                IntentData intentData = this.mIntentData;
                if (intentData != null) {
                    str8 = intentData.getSource();
                } else {
                    str8 = null;
                }
                mediaLiveEnterRoomRate.doEnterSecondSegmentInit(str7, "", "", str8);
            } else {
                MediaLiveEnterRoomRate mediaLiveEnterRoomRate2 = MediaLiveEnterRoomRate.INSTANCE;
                LiveContainer.LiveItemModel liveItemModel7 = this.curRoomModel;
                if (liveItemModel7 != null) {
                    str = liveItemModel7.getRoomId();
                } else {
                    str = null;
                }
                IntentData intentData2 = this.mIntentData;
                if (intentData2 != null) {
                    str2 = intentData2.getSource();
                } else {
                    str2 = null;
                }
                mediaLiveEnterRoomRate2.doEnterSecondSegmentInitOtherLive(str, "", "", str2);
            }
            MediaLivePluginLogger companion2 = MediaLivePluginLogger.Companion.getInstance();
            LiveContainer.LiveItemModel liveItemModel8 = this.curRoomModel;
            if (liveItemModel8 != null) {
                str3 = liveItemModel8.getLiveType();
            } else {
                str3 = null;
            }
            LiveContainer.LiveItemModel liveItemModel9 = this.curRoomModel;
            if (liveItemModel9 != null) {
                str4 = liveItemModel9.getTemplateId();
            } else {
                str4 = null;
            }
            boolean z = this.isFromForward;
            LiveContainer.LiveItemModel liveItemModel10 = this.curRoomModel;
            if (liveItemModel10 != null) {
                str5 = liveItemModel10.getRoomId();
            } else {
                str5 = null;
            }
            companion2.updateStartPageInfoIntentRoomInfo(str3, str4, z, str5);
            LiveComponentLoadLogger companion3 = LiveComponentLoadLogger.Companion.getInstance();
            LiveContainer.LiveItemModel liveItemModel11 = this.curRoomModel;
            if (liveItemModel11 != null) {
                str6 = liveItemModel11.getRoomId();
            } else {
                str6 = null;
            }
            IntentData intentData3 = this.mIntentData;
            if (intentData3 != null) {
                str11 = intentData3.getSource();
            }
            LiveContainer.LiveItemModel liveItemModel12 = this.curRoomModel;
            if (liveItemModel12 != null && (templateId = liveItemModel12.getTemplateId()) != null) {
                str10 = templateId;
            }
            companion3.bindRoomIdToExternalEnterFlow(str6, str11, str10);
        }
        this.mPageInfo = new PageInfo(true, i, this.isFromForward, this.listRequestDuration);
    }

    public final void onDestroy() {
        String str;
        IMixActivityInterface iMixActivityInterface;
        Lifecycle lifeCycle;
        MixEventBus.getInstance().unRegister(this);
        YYActivityLifeCyclePlugin yYActivityLifeCyclePlugin = this.mYYLifeCyclePlugin;
        if (yYActivityLifeCyclePlugin != null && (iMixActivityInterface = this.mixActivity) != null && (lifeCycle = iMixActivityInterface.getLifeCycle()) != null) {
            lifeCycle.removeObserver(yYActivityLifeCyclePlugin);
        }
        LiveRoomInfoStatPlugin liveRoomInfoStatPlugin = this.mLiveRoomInfoStatPlugin;
        if (liveRoomInfoStatPlugin != null) {
            liveRoomInfoStatPlugin.onDestroy();
        }
        this.shellList.clear();
        YYLoadPluginPlugin yYLoadPluginPlugin = this.mYYLoadPluginPlugin;
        if (yYLoadPluginPlugin != null) {
            yYLoadPluginPlugin.onDestroy();
        }
        getListManager().onDestroy();
        MixModel mixModel = this.mNetModel;
        String str2 = null;
        if (mixModel != null) {
            mixModel.setOnMixDataLoadedCallBack(null);
        }
        MediaLiveEnterRoomRate mediaLiveEnterRoomRate = MediaLiveEnterRoomRate.INSTANCE;
        IntentData intentData = this.mIntentData;
        if (intentData != null) {
            str = intentData.getId();
        } else {
            str = null;
        }
        IntentData intentData2 = this.mIntentData;
        if (intentData2 != null) {
            str2 = intentData2.getSource();
        }
        mediaLiveEnterRoomRate.clearFlag(str, str2);
        this.hasReqStart = false;
        this.hasReqEnd = false;
    }

    @Override // com.baidu.live.arch.api.IExtLifecycle
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AbstractMixFakeShell abstractMixFakeShell;
        for (WeakReference<AbstractMixFakeShell> weakReference : this.shellList) {
            if (weakReference != null) {
                abstractMixFakeShell = weakReference.get();
            } else {
                abstractMixFakeShell = null;
            }
            if (abstractMixFakeShell != null) {
                AbstractMixFakeShell abstractMixFakeShell2 = weakReference.get();
                if (abstractMixFakeShell2 == null) {
                    Intrinsics.throwNpe();
                }
                if (abstractMixFakeShell2.onKeyDown(i, keyEvent)) {
                    return true;
                }
            }
        }
        return false;
    }
}
