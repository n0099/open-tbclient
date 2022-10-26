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
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.arch.ServiceLocator;
import com.baidu.live.arch.api.IExtLifecycle;
import com.baidu.live.arch.runtime.MiniShellRuntime;
import com.baidu.live.arch.utils.MiniJsonUtils;
import com.baidu.live.arch.utils.MiniPluginUtils;
import com.baidu.live.arch.utils.MiniUiThreadUtil;
import com.baidu.live.arch.utils.MiniUniqueId;
import com.baidu.live.arch.utils.MixUriUtilKt;
import com.baidu.pass.biometrics.face.liveness.b.a;
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
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.searchbox.live.interfaces.mix.IMixActivityInterface;
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
import com.baidu.searchbox.live.ubc.MediaLivePlayLogger;
import com.baidu.searchbox.live.ubc.MediaLivePluginLogger;
import com.baidu.searchbox.live.util.ListExtKt;
import com.baidu.searchbox.live.util.ListLogKt;
import com.baidu.searchbox.live.util.ListUbc;
import com.baidu.searchbox.live.widget.LiveContainer;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import com.baidubce.auth.NTLMEngineImpl;
import com.google.protobuf.CodedInputStream;
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
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¶\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002¦\u0001\u0018\u0000 Û\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002Û\u0001B%\u0012\u0006\u0010n\u001a\u00020m\u0012\b\u0010¿\u0001\u001a\u00030¾\u0001\u0012\b\u0010¼\u0001\u001a\u00030»\u0001¢\u0006\u0006\bÙ\u0001\u0010Ú\u0001J!\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\u001b\u001a\u00020\b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJM\u0010%\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u00062\u0006\u0010!\u001a\u00020 2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b%\u0010&J\u0015\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020\"¢\u0006\u0004\b(\u0010)J\r\u0010*\u001a\u00020\b¢\u0006\u0004\b*\u0010\u0014JI\u00102\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\u00062\b\b\u0002\u00101\u001a\u00020\u0006H\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\bH\u0002¢\u0006\u0004\b4\u0010\u0014J\u000f\u00105\u001a\u00020\bH\u0002¢\u0006\u0004\b5\u0010\u0014J)\u0010:\u001a\u00020\b2\u0006\u00106\u001a\u00020\"2\u0006\u00107\u001a\u00020\"2\b\u00109\u001a\u0004\u0018\u000108H\u0016¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020\b2\u0006\u0010'\u001a\u00020\"H\u0016¢\u0006\u0004\b<\u0010)J\u0017\u0010=\u001a\u00020\b2\u0006\u0010'\u001a\u00020\"H\u0016¢\u0006\u0004\b=\u0010)J\u0017\u0010@\u001a\u00020\b2\u0006\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\b@\u0010AJ\r\u0010B\u001a\u00020\b¢\u0006\u0004\bB\u0010\u0014J\r\u0010C\u001a\u00020\b¢\u0006\u0004\bC\u0010\u0014J\u001f\u0010F\u001a\u00020 2\u0006\u0010D\u001a\u00020\"2\u0006\u0010\u0010\u001a\u00020EH\u0016¢\u0006\u0004\bF\u0010GJ\u0017\u0010I\u001a\u00020\b2\u0006\u0010H\u001a\u000208H\u0016¢\u0006\u0004\bI\u0010JJ\u001d\u0010M\u001a\u00020\b2\f\u00109\u001a\b\u0012\u0004\u0012\u00020L0KH\u0002¢\u0006\u0004\bM\u0010NJ/\u0010S\u001a\u00020\b2\u0006\u00106\u001a\u00020\"2\u000e\u0010P\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060O2\u0006\u0010R\u001a\u00020QH\u0016¢\u0006\u0004\bS\u0010TJ'\u0010X\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010W2\u0006\u0010V\u001a\u00020UH\u0002¢\u0006\u0004\bX\u0010YJ!\u0010\\\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00062\b\u0010[\u001a\u0004\u0018\u00010ZH\u0002¢\u0006\u0004\b\\\u0010]J\u000f\u0010^\u001a\u00020\bH\u0002¢\u0006\u0004\b^\u0010\u0014J\u000f\u0010_\u001a\u00020\bH\u0002¢\u0006\u0004\b_\u0010\u0014J\u000f\u0010`\u001a\u00020\bH\u0002¢\u0006\u0004\b`\u0010\u0014J\u000f\u0010a\u001a\u00020\bH\u0002¢\u0006\u0004\ba\u0010\u0014J\u000f\u0010b\u001a\u00020\bH\u0002¢\u0006\u0004\bb\u0010\u0014J-\u0010e\u001a\u00020\b2\u0006\u0010c\u001a\u00020\u00062\u0006\u0010d\u001a\u00020\"2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018H\u0002¢\u0006\u0004\be\u0010fJ\u0017\u0010i\u001a\u00020\b2\u0006\u0010h\u001a\u00020gH\u0002¢\u0006\u0004\bi\u0010jJ\u000f\u0010k\u001a\u00020\bH\u0002¢\u0006\u0004\bk\u0010\u0014J\u000f\u0010l\u001a\u00020\bH\u0002¢\u0006\u0004\bl\u0010\u0014R\u0019\u0010n\u001a\u00020m8\u0006@\u0006¢\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bp\u0010qR$\u0010r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\br\u0010s\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\"\u0010x\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010)R(\u0010~\u001a\u0004\u0018\u00010}8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R)\u0010\u0084\u0001\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a\u0006\b\u0084\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0019\u0010\u0089\u0001\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u0085\u0001R$\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040\u00188\u0006@\u0006¢\u0006\u0010\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R#\u0010\u0093\u0001\u001a\u00030\u008e\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u008f\u0001\u0010\u0090\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0019\u0010\u0094\u0001\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0019\u0010\u0096\u0001\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0095\u0001R$\u0010\u0099\u0001\u001a\r \u0098\u0001*\u0005\u0018\u00010\u0097\u00010\u0097\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0018\u0010\u009b\u0001\u001a\u00020\"8\u0002@\u0002X\u0082D¢\u0006\u0007\n\u0005\b\u009b\u0001\u0010yR\u0019\u0010\u009c\u0001\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u0085\u0001R\u001c\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009d\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R\u001c\u0010¡\u0001\u001a\u0005\u0018\u00010 \u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001R\u001c\u0010¤\u0001\u001a\u0005\u0018\u00010£\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001R#\u0010ª\u0001\u001a\u00030¦\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b§\u0001\u0010\u0090\u0001\u001a\u0006\b¨\u0001\u0010©\u0001R\u001c\u0010¬\u0001\u001a\u0005\u0018\u00010«\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001R,\u0010¯\u0001\u001a\u0005\u0018\u00010®\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¯\u0001\u0010°\u0001\u001a\u0006\b±\u0001\u0010²\u0001\"\u0006\b³\u0001\u0010´\u0001R\u001c\u0010¶\u0001\u001a\u0005\u0018\u00010µ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R\u001c\u0010¹\u0001\u001a\u0005\u0018\u00010¸\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R\u001a\u0010¼\u0001\u001a\u00030»\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¼\u0001\u0010½\u0001R\u001a\u0010¿\u0001\u001a\u00030¾\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¿\u0001\u0010À\u0001R\u001b\u0010Á\u0001\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÁ\u0001\u0010Â\u0001R+\u0010Ã\u0001\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÃ\u0001\u0010Ä\u0001\u001a\u0006\bÅ\u0001\u0010Æ\u0001\"\u0006\bÇ\u0001\u0010È\u0001R,\u0010Ê\u0001\u001a\u0005\u0018\u00010É\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÊ\u0001\u0010Ë\u0001\u001a\u0006\bÌ\u0001\u0010Í\u0001\"\u0006\bÎ\u0001\u0010Ï\u0001R\u0019\u0010Ð\u0001\u001a\u00020 8\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÐ\u0001\u0010\u0085\u0001R\u0019\u0010Ñ\u0001\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0001\u0010\u0085\u0001R,\u0010Ô\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0005\u0012\u00030Ó\u00010Ò\u00010\u00188\u0006@\u0006¢\u0006\u0010\n\u0006\bÔ\u0001\u0010\u008b\u0001\u001a\u0006\bÕ\u0001\u0010\u008d\u0001R\u001a\u0010×\u0001\u001a\u00030Ö\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b×\u0001\u0010Ø\u0001¨\u0006Ü\u0001"}, d2 = {"Lcom/baidu/searchbox/live/list/controller/ListController;", "Lcom/baidu/live/arch/api/IExtLifecycle;", "Lcom/baidu/searchbox/live/eventbus/EventAction;", "Lcom/baidu/searchbox/live/list/controller/IListListener;", "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "model", "", "id", "", "bindHLReplayInfo", "(Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;Ljava/lang/String;)V", "Lorg/json/JSONArray;", "roomIdJSONArray", "cacheCloseRoomIdList", "(Lorg/json/JSONArray;)V", "Lcom/baidu/searchbox/live/action/AbstractEvent;", "event", NotificationCompat.CATEGORY_CALL, "(Lcom/baidu/searchbox/live/action/AbstractEvent;)V", "changeScrollState", "()V", "Landroid/view/View;", "createView", "()Landroid/view/View;", "", "origin", "addition", "distinct", "(Ljava/util/List;Ljava/util/List;)V", ILiveNPSPlugin.PARAMS_ROOM_ID, "value", "status", "", "useCache", "", "error", StatConstants.KEY_EXT_ERR_MSG, "doEnterUbcByRequestEnter", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/String;)V", CriusAttrConstants.POSITION, "fetchMoreLiveIfNeed", "(I)V", "finish", AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, "scheme", "from", "", "clickTime", "clickFrom", "playUrl", "jumpToNewLiveRoom", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "loadLiveRoom", "logEventOnReach", GroupInfoActivityConfig.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onAfterSelect", "onBeforeSelect", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onCreate", MissionEvent.MESSAGE_DESTROY, "keyCode", "Landroid/view/KeyEvent;", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", IntentData.KEY, "onNewIntent", "(Landroid/content/Intent;)V", "Lcom/baidu/searchbox/live/model/res/MixResult;", "Lcom/baidu/searchbox/live/data/resp/LiveRoomEnterRespData;", "onPreRoomEnterDataLoaded", "(Lcom/baidu/searchbox/live/model/res/MixResult;)V", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "Lorg/json/JSONObject;", "input", "", "paramsJsonToMap", "(Lorg/json/JSONObject;)Ljava/util/Map;", "Lcom/baidu/searchbox/live/widget/LiveContainer$PlaySourceInfo;", "sourceInfo", "parseClickTime", "(Ljava/lang/String;Lcom/baidu/searchbox/live/widget/LiveContainer$PlaySourceInfo;)Ljava/lang/String;", "preReqRoomEnter", "queryLiveList", "registerMixRequestService", "registerYYLifeCyclePlugin", "reloadLiveRoom", "pageSession", "hasMore", "slideListSuccess", "(Ljava/lang/String;ILjava/util/List;)V", "Lcom/baidu/searchbox/live/data/pojo/LiveTypeData;", "itemLiveType", "templateIdSuccess", "(Lcom/baidu/searchbox/live/data/pojo/LiveTypeData;)V", "unBindHLReplayInfo", "unregisterMixRequestService", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "curRoomModel", "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "getCurRoomModel", "()Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "setCurRoomModel", "(Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;)V", "currentPosition", "I", "getCurrentPosition", "()I", "setCurrentPosition", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "isFromForward", "Z", "()Z", "setFromForward", "(Z)V", "isRegistYYActivityLifeCyclePlugin", "itemData", "Ljava/util/List;", "getItemData", "()Ljava/util/List;", "Lcom/baidu/searchbox/live/list/controller/IListManager;", "listManager$delegate", "Lkotlin/Lazy;", "getListManager", "()Lcom/baidu/searchbox/live/list/controller/IListManager;", "listManager", "listRequestDuration", "J", "listRequestTime", "Lcom/baidu/searchbox/live/interfaces/service/LiveSessionService;", "kotlin.jvm.PlatformType", "liveSessionService", "Lcom/baidu/searchbox/live/interfaces/service/LiveSessionService;", "loadMoreFraction", "localSwitchCanScroll", "Lcom/baidu/searchbox/live/frame/IntentData;", "mIntentData", "Lcom/baidu/searchbox/live/frame/IntentData;", "Lcom/baidu/searchbox/live/frame/ListInfo;", "mListInfo", "Lcom/baidu/searchbox/live/frame/ListInfo;", "Lcom/baidu/searchbox/live/list/plugin/LiveRoomInfoStatPlugin;", "mLiveRoomInfoStatPlugin", "Lcom/baidu/searchbox/live/list/plugin/LiveRoomInfoStatPlugin;", "com/baidu/searchbox/live/list/controller/ListController$mMixEventDispatcher$2$1", "mMixEventDispatcher$delegate", "getMMixEventDispatcher", "()Lcom/baidu/searchbox/live/list/controller/ListController$mMixEventDispatcher$2$1;", "mMixEventDispatcher", "Lcom/baidu/searchbox/live/model/MixModel;", "mNetModel", "Lcom/baidu/searchbox/live/model/MixModel;", "Lcom/baidu/searchbox/live/frame/PageInfo;", "mPageInfo", "Lcom/baidu/searchbox/live/frame/PageInfo;", "getMPageInfo", "()Lcom/baidu/searchbox/live/frame/PageInfo;", "setMPageInfo", "(Lcom/baidu/searchbox/live/frame/PageInfo;)V", "Lcom/baidu/searchbox/live/list/plugin/YYActivityLifeCyclePlugin;", "mYYLifeCyclePlugin", "Lcom/baidu/searchbox/live/list/plugin/YYActivityLifeCyclePlugin;", "Lcom/baidu/searchbox/live/list/plugin/YYLoadPluginPlugin;", "mYYLoadPluginPlugin", "Lcom/baidu/searchbox/live/list/plugin/YYLoadPluginPlugin;", "Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "mixActivity", "Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "mixUniqueId", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "playSource", "Lcom/baidu/searchbox/live/widget/LiveContainer$PlaySourceInfo;", "preReqRoomEnterData", "Lcom/baidu/searchbox/live/data/resp/LiveRoomEnterRespData;", "getPreReqRoomEnterData", "()Lcom/baidu/searchbox/live/data/resp/LiveRoomEnterRespData;", "setPreReqRoomEnterData", "(Lcom/baidu/searchbox/live/data/resp/LiveRoomEnterRespData;)V", "Lcom/baidu/searchbox/live/model/res/MixResultStatData;", "preReqStatData", "Lcom/baidu/searchbox/live/model/res/MixResultStatData;", "getPreReqStatData", "()Lcom/baidu/searchbox/live/model/res/MixResultStatData;", "setPreReqStatData", "(Lcom/baidu/searchbox/live/model/res/MixResultStatData;)V", "prefetchEnterSwitch", "serverSwitchCanScroll", "Ljava/lang/ref/WeakReference;", "Lcom/baidu/searchbox/live/shell/list/basic/AbstractMixFakeShell;", "shellList", "getShellList", "Lcom/baidu/ubc/UBCManager;", "ubcManager", "Lcom/baidu/ubc/UBCManager;", "<init>", "(Landroid/content/Context;Lcom/baidu/live/arch/utils/MiniUniqueId;Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;)V", "Companion", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class ListController implements IExtLifecycle, EventAction, IListListener {
    public static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static final String KEY_PARAMS = "params";
    public transient /* synthetic */ FieldHolder $fh;
    public final Context context;
    public LiveContainer.LiveItemModel curRoomModel;
    public int currentPosition;
    public Handler handler;
    public boolean isFromForward;
    public boolean isRegistYYActivityLifeCyclePlugin;
    public final List itemData;
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
    public final List shellList;
    public final UBCManager ubcManager;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1711405834, "Lcom/baidu/searchbox/live/list/controller/ListController;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1711405834, "Lcom/baidu/searchbox/live/list/controller/ListController;");
                return;
            }
        }
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ListController.class), "listManager", "getListManager()Lcom/baidu/searchbox/live/list/controller/IListManager;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ListController.class), "mMixEventDispatcher", "getMMixEventDispatcher()Lcom/baidu/searchbox/live/list/controller/ListController$mMixEventDispatcher$2$1;"))};
        Companion = new Companion(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IListManager getListManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, this)) == null) {
            Lazy lazy = this.listManager$delegate;
            KProperty kProperty = $$delegatedProperties[0];
            return (IListManager) lazy.getValue();
        }
        return (IListManager) invokeV.objValue;
    }

    private final ListController$mMixEventDispatcher$2.AnonymousClass1 getMMixEventDispatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65574, this)) == null) {
            Lazy lazy = this.mMixEventDispatcher$delegate;
            KProperty kProperty = $$delegatedProperties[1];
            return (ListController$mMixEventDispatcher$2.AnonymousClass1) lazy.getValue();
        }
        return (ListController$mMixEventDispatcher$2.AnonymousClass1) invokeV.objValue;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/live/list/controller/ListController$Companion;", "", "KEY_PARAMS", "Ljava/lang/String;", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public final class Companion {
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

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ListController(Context context, MiniUniqueId miniUniqueId, IMixActivityInterface iMixActivityInterface) {
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, miniUniqueId, iMixActivityInterface};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
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
        this.listManager$delegate = LazyKt__LazyJVMKt.lazy(new ListController$listManager$2(this));
        this.mMixEventDispatcher$delegate = LazyKt__LazyJVMKt.lazy(new ListController$mMixEventDispatcher$2(this));
        this.liveSessionService = (LiveSessionService) ServiceManager.getService(LiveSessionService.Companion.getSERVICE_REFERENCE());
        Object service = ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        Intrinsics.checkExpressionValueIsNotNull(service, "ServiceManager.getServic…anager.SERVICE_REFERENCE)");
        this.ubcManager = (UBCManager) service;
    }

    private final void bindHLReplayInfo(LiveContainer.LiveItemModel liveItemModel, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65567, this, liveItemModel, str) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("nid", str);
            if (liveItemModel != null) {
                liveItemModel.setHlReplay(jSONObject);
            }
        }
    }

    private final void distinct(List list, List list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65570, this, list, list2) == null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                LiveContainer.LiveItemModel liveItemModel = (LiveContainer.LiveItemModel) it.next();
                if (list2.contains(liveItemModel)) {
                    list2.remove(liveItemModel);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPreRoomEnterDataLoaded(MixResult mixResult) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65579, this, mixResult) == null) && (mixResult instanceof MixResult.MixSuccess)) {
            MixResult.MixSuccess mixSuccess = (MixResult.MixSuccess) mixResult;
            this.preReqRoomEnterData = (LiveRoomEnterRespData) mixSuccess.getData();
            this.preReqStatData = mixSuccess.getStatData();
        }
    }

    public final void fetchMoreLiveIfNeed(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && i >= this.itemData.size() - this.loadMoreFraction) {
            queryLiveList();
        }
    }

    @Override // com.baidu.searchbox.live.list.controller.IListListener
    public void onAfterSelect(int i) {
        LiveRoomInfoStatPlugin liveRoomInfoStatPlugin;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.isFromForward = false;
            fetchMoreLiveIfNeed(i);
            List list = this.itemData;
            if (list != null && i >= 0 && i < list.size() && (liveRoomInfoStatPlugin = this.mLiveRoomInfoStatPlugin) != null) {
                liveRoomInfoStatPlugin.dispatchLiveItemModelSelectedAction((LiveContainer.LiveItemModel) this.itemData.get(i));
            }
        }
    }

    @Override // com.baidu.live.arch.api.IExtLifecycle
    public void onConfigurationChanged(Configuration configuration) {
        List<WeakReference> list;
        AbstractMixFakeShell abstractMixFakeShell;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, configuration) == null) && (list = this.shellList) != null) {
            for (WeakReference weakReference : list) {
                if (weakReference != null && (abstractMixFakeShell = (AbstractMixFakeShell) weakReference.get()) != null) {
                    abstractMixFakeShell.onConfigurationChanged(configuration);
                }
            }
        }
    }

    public final void setCurRoomModel(LiveContainer.LiveItemModel liveItemModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, liveItemModel) == null) {
            this.curRoomModel = liveItemModel;
        }
    }

    public final void setCurrentPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.currentPosition = i;
        }
    }

    public final void setFromForward(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.isFromForward = z;
        }
    }

    public final void setHandler(Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, handler) == null) {
            this.handler = handler;
        }
    }

    public final void setMPageInfo(PageInfo pageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, pageInfo) == null) {
            this.mPageInfo = pageInfo;
        }
    }

    public final void setPreReqRoomEnterData(LiveRoomEnterRespData liveRoomEnterRespData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, liveRoomEnterRespData) == null) {
            this.preReqRoomEnterData = liveRoomEnterRespData;
        }
    }

    public final void setPreReqStatData(MixResultStatData mixResultStatData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, mixResultStatData) == null) {
            this.preReqStatData = mixResultStatData;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cacheCloseRoomIdList(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65568, this, jSONArray) != null) || jSONArray == null) {
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

    @Override // com.baidu.live.arch.api.IExtLifecycle
    public void onNewIntent(Intent intent) {
        AbstractMixFakeShell abstractMixFakeShell;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, intent) == null) {
            this.mIntentData = ListExtKt.parseLiveData(intent);
            reloadLiveRoom();
            List<WeakReference> list = this.shellList;
            if (list != null) {
                for (WeakReference weakReference : list) {
                    if (weakReference != null && (abstractMixFakeShell = (AbstractMixFakeShell) weakReference.get()) != null) {
                        abstractMixFakeShell.onNewIntent(intent);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changeScrollState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void queryLiveList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65583, this) == null) {
            this.listRequestTime = System.currentTimeMillis();
            this.listRequestDuration = 0L;
            MixModel mixModel = this.mNetModel;
            if (mixModel != null) {
                mixModel.queryLiveList();
            }
        }
    }

    private final void registerMixRequestService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65584, this) == null) {
            MixRequestServiceLocator.Companion.registerGlobalServices(MixRequestService.class, new MixRequestService(this) { // from class: com.baidu.searchbox.live.list.controller.ListController$registerMixRequestService$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ListController this$0;

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

                @Override // com.baidu.searchbox.live.service.MixRequestService
                public void requestRoomEnter(RoomEnterParams roomEnterParams, boolean z, OnMixDataLoaded onMixDataLoaded) {
                    MixModel mixModel;
                    LiveRoomEnterRespData preReqRoomEnterData;
                    JSONObject jSONObject;
                    long j;
                    JSONObject optJSONObject;
                    JSONObject optJSONObject2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{roomEnterParams, Boolean.valueOf(z), onMixDataLoaded}) == null) {
                        ListController.doEnterUbcByRequestEnter$default(this.this$0, roomEnterParams.getId(), "req_start", "", z, null, null, 48, null);
                        if (z && (preReqRoomEnterData = this.this$0.getPreReqRoomEnterData()) != null) {
                            JSONObject respJsonObj = preReqRoomEnterData.getRespJsonObj();
                            String str = null;
                            if (respJsonObj != null) {
                                jSONObject = respJsonObj.optJSONObject("data");
                            } else {
                                jSONObject = null;
                            }
                            if (jSONObject != null && (optJSONObject2 = jSONObject.optJSONObject("room")) != null) {
                                str = optJSONObject2.optString("room_id");
                            }
                            if (Intrinsics.areEqual(str, roomEnterParams.getId())) {
                                long currentTimeMillis = System.currentTimeMillis() - preReqRoomEnterData.getConstructTimeMills();
                                JSONObject optJSONObject3 = jSONObject.optJSONObject(SetImageWatermarkTypeReqMsg.SWITCH);
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
                                        onMixDataLoaded.onMixDataLoaded(new MixResult.MixSuccess(liveRoomEnterRespData, this.this$0.getPreReqStatData()));
                                    }
                                    ListController.doEnterUbcByRequestEnter$default(this.this$0, roomEnterParams.getId(), "req_end", "success", z, null, null, 48, null);
                                    return;
                                }
                            }
                        }
                        mixModel = this.this$0.mNetModel;
                        if (mixModel != null) {
                            mixModel.reqRoomEnter(roomEnterParams, onMixDataLoaded);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reloadLiveRoom() {
        IntentData intentData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65586, this) == null) && (intentData = this.mIntentData) != null && intentData.getSchemeData() != null) {
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
        IntentData intentData;
        IntentData.SchemeModel schemeData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65589, this) == null) && (intentData = this.mIntentData) != null && (schemeData = intentData.getSchemeData()) != null) {
            schemeData.setHlReplyIntoLive(null);
        }
    }

    private final void unregisterMixRequestService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65590, this) == null) {
            MixRequestServiceLocator.Companion.unregisterGlobalService(MixRequestService.class);
        }
    }

    public final View createView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return getListManager().createView();
        }
        return (View) invokeV.objValue;
    }

    public final Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.context;
        }
        return (Context) invokeV.objValue;
    }

    public final LiveContainer.LiveItemModel getCurRoomModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.curRoomModel;
        }
        return (LiveContainer.LiveItemModel) invokeV.objValue;
    }

    public final int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.currentPosition;
        }
        return invokeV.intValue;
    }

    public final Handler getHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.handler;
        }
        return (Handler) invokeV.objValue;
    }

    public final List getItemData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.itemData;
        }
        return (List) invokeV.objValue;
    }

    public final PageInfo getMPageInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mPageInfo;
        }
        return (PageInfo) invokeV.objValue;
    }

    public final LiveRoomEnterRespData getPreReqRoomEnterData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.preReqRoomEnterData;
        }
        return (LiveRoomEnterRespData) invokeV.objValue;
    }

    public final MixResultStatData getPreReqStatData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.preReqStatData;
        }
        return (MixResultStatData) invokeV.objValue;
    }

    public final List getShellList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.shellList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean isFromForward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.isFromForward;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doEnterUbcByRequestEnter(String str, String str2, String str3, boolean z, Integer num, String str4) {
        int i;
        String str5;
        IntentData.SchemeModel model;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65571, this, new Object[]{str, str2, str3, Boolean.valueOf(z), num, str4}) == null) {
            LiveSessionService liveSessionService = this.liveSessionService;
            int i2 = 0;
            if (liveSessionService != null) {
                i = liveSessionService.getSessionOrder();
            } else {
                i = 0;
            }
            if (i < 1) {
                IntentData intentData = this.mIntentData;
                if (Intrinsics.areEqual((intentData == null || (model = intentData.getModel()) == null || (r0 = model.getRoomType()) == null) ? "0" : "0", "0") && this.ubcManager != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("from", "live");
                        jSONObject.put("type", "enter_live");
                        jSONObject.put("value", str2);
                        IntentData intentData2 = this.mIntentData;
                        if (intentData2 != null) {
                            str5 = intentData2.getSource();
                        } else {
                            str5 = null;
                        }
                        jSONObject.put("source", str5);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(MixYYFakeShell.ROOM_ID_YY, str);
                        jSONObject2.put("status", str3);
                        if (z) {
                            i2 = 1;
                        }
                        jSONObject2.put("useCache", i2);
                        if (num != null) {
                            jSONObject2.put("error", num.intValue());
                        }
                        if (str4 != null) {
                            jSONObject2.put(StatConstants.KEY_EXT_ERR_MSG, str4);
                        }
                        jSONObject.put("ext", jSONObject2);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    this.ubcManager.onEvent("5153", jSONObject);
                }
            }
        }
    }

    public static /* synthetic */ void doEnterUbcByRequestEnter$default(ListController listController, String str, String str2, String str3, boolean z, Integer num, String str4, int i, Object obj) {
        Integer num2;
        String str5;
        if ((i & 16) != 0) {
            num2 = null;
        } else {
            num2 = num;
        }
        if ((i & 32) != 0) {
            str5 = null;
        } else {
            str5 = str4;
        }
        listController.doEnterUbcByRequestEnter(str, str2, str3, z, num2, str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0109  */
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
        String str14;
        JSONObject ext;
        JSONObject jSONObject;
        JSONObject ext2;
        JSONObject jSONObject2;
        JSONObject extLog;
        JSONObject jSONObject3;
        IntentData.SchemeModel copy;
        String schemeParam;
        String str15;
        String jSONObject4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65575, this, new Object[]{str, str2, str3, str4, Long.valueOf(j), str5, str6}) == null) {
            String str16 = "";
            IntentData intentData2 = this.mIntentData;
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
                    IntentData.SchemeModel parseSchemeData = IntentData.Companion.parseSchemeData(jSONObject4);
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
                                Result.m698constructorimpl(Unit.INSTANCE);
                            } catch (Throwable th2) {
                                th = th2;
                                Result.Companion companion2 = Result.Companion;
                                Result.m698constructorimpl(ResultKt.createFailure(th));
                                str10 = str7;
                                str11 = str8;
                                str12 = str9;
                                if (!TextUtils.isEmpty(str)) {
                                }
                                intent = new Intent();
                                intent.putExtra(ILiveNPSPlugin.PARAMS_ROOM_ID, str13);
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
                            Result.m698constructorimpl(ResultKt.createFailure(th));
                            str10 = str7;
                            str11 = str8;
                            str12 = str9;
                            if (!TextUtils.isEmpty(str)) {
                            }
                            intent = new Intent();
                            intent.putExtra(ILiveNPSPlugin.PARAMS_ROOM_ID, str13);
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
                        Result.m698constructorimpl(ResultKt.createFailure(th));
                        str10 = str7;
                        str11 = str8;
                        str12 = str9;
                        if (!TextUtils.isEmpty(str)) {
                        }
                        intent = new Intent();
                        intent.putExtra(ILiveNPSPlugin.PARAMS_ROOM_ID, str13);
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
                    intent.putExtra(ILiveNPSPlugin.PARAMS_ROOM_ID, str13);
                    intentData = this.mIntentData;
                    if (intentData != null && (schemeData = intentData.getSchemeData()) != null) {
                        if (!TextUtils.isEmpty(schemeData.getSource())) {
                            if (schemeModel != null) {
                                str15 = schemeModel.getSource();
                            } else {
                                str15 = null;
                            }
                            if (TextUtils.isEmpty(str15)) {
                                str14 = "";
                                if (schemeData.getExt() == null) {
                                    if (schemeModel != null) {
                                        ext = schemeModel.getExt();
                                    } else {
                                        jSONObject2 = null;
                                        String liveBackScheme = schemeData.getLiveBackScheme();
                                        JSONObject extRequest = schemeData.getExtRequest();
                                        if (schemeData.getExtLog() != null) {
                                            if (schemeModel != null) {
                                                extLog = schemeModel.getExtLog();
                                            } else {
                                                jSONObject3 = null;
                                                copy = schemeData.copy((r50 & 1) != 0 ? schemeData.roomId : str13, (r50 & 2) != 0 ? schemeData.roomType : str11, (r50 & 4) != 0 ? schemeData.source : str14, (r50 & 8) != 0 ? schemeData.cover : str2, (r50 & 16) != 0 ? schemeData.playUrl : str6, (r50 & 32) != 0 ? schemeData.status : "", (r50 & 64) != 0 ? schemeData.format : "", (r50 & 128) != 0 ? schemeData.screen : "", (r50 & 256) != 0 ? schemeData.template : "", (r50 & 512) != 0 ? schemeData.liveBackScheme : liveBackScheme, (r50 & 1024) != 0 ? schemeData.ext : jSONObject2, (r50 & 2048) != 0 ? schemeData.extRequest : extRequest, (r50 & 4096) != 0 ? schemeData.extLog : jSONObject3, (r50 & 8192) != 0 ? schemeData.query : null, (r50 & 16384) != 0 ? schemeData.extParams : schemeData.getExtParams(), (r50 & 32768) != 0 ? schemeData.askId : "", (r50 & 65536) != 0 ? schemeData.templateId : str10, (r50 & 131072) != 0 ? schemeData.otherParams : null, (r50 & 262144) != 0 ? schemeData.invokePop : null, (r50 & 524288) != 0 ? schemeData.searchIntoLiveJson : null, (r50 & 1048576) != 0 ? schemeData.hlReplyIntoLive : null, (r50 & 2097152) != 0 ? schemeData.shareUid : null, (r50 & 4194304) != 0 ? schemeData.shareTag : null, (r50 & 8388608) != 0 ? schemeData.avcUrl : null, (r50 & 16777216) != 0 ? schemeData.hevcUrl : null, (r50 & 33554432) != 0 ? schemeData.rtcUrl : null, (r50 & CodedInputStream.DEFAULT_SIZE_LIMIT) != 0 ? schemeData.title : str12, (r50 & 134217728) != 0 ? schemeData.shareTaskInfo : null, (r50 & LaunchTaskConstants.OTHER_PROCESS) != 0 ? schemeData.quic : null, (r50 & NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH) != 0 ? schemeData.inviterId : null, (r50 & 1073741824) != 0 ? schemeData.highlightUrl : null, (r50 & Integer.MIN_VALUE) != 0 ? schemeData.introduceTips : null);
                                                intent.putExtra("params", copy.toSchemeParams());
                                                MiniShellRuntime miniShellRuntime = MiniShellRuntime.INSTANCE;
                                                if (str != null) {
                                                    str16 = str;
                                                }
                                                String buildLiveScheme = miniShellRuntime.buildLiveScheme(str16, schemeData.getSource());
                                                schemeParam = MixUriUtilKt.setSchemeParam(buildLiveScheme, CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair("clickTime", String.valueOf(j)), new Pair("clickFrom", str5)}), true);
                                                if (schemeParam == null) {
                                                    schemeParam = buildLiveScheme;
                                                }
                                                if (!((schemeParam != null || schemeParam.length() == 0) ? true : true)) {
                                                    buildLiveScheme = schemeParam;
                                                }
                                                intent.putExtra("scheme", buildLiveScheme);
                                            }
                                        } else {
                                            extLog = schemeData.getExtLog();
                                        }
                                        jSONObject3 = extLog;
                                        copy = schemeData.copy((r50 & 1) != 0 ? schemeData.roomId : str13, (r50 & 2) != 0 ? schemeData.roomType : str11, (r50 & 4) != 0 ? schemeData.source : str14, (r50 & 8) != 0 ? schemeData.cover : str2, (r50 & 16) != 0 ? schemeData.playUrl : str6, (r50 & 32) != 0 ? schemeData.status : "", (r50 & 64) != 0 ? schemeData.format : "", (r50 & 128) != 0 ? schemeData.screen : "", (r50 & 256) != 0 ? schemeData.template : "", (r50 & 512) != 0 ? schemeData.liveBackScheme : liveBackScheme, (r50 & 1024) != 0 ? schemeData.ext : jSONObject2, (r50 & 2048) != 0 ? schemeData.extRequest : extRequest, (r50 & 4096) != 0 ? schemeData.extLog : jSONObject3, (r50 & 8192) != 0 ? schemeData.query : null, (r50 & 16384) != 0 ? schemeData.extParams : schemeData.getExtParams(), (r50 & 32768) != 0 ? schemeData.askId : "", (r50 & 65536) != 0 ? schemeData.templateId : str10, (r50 & 131072) != 0 ? schemeData.otherParams : null, (r50 & 262144) != 0 ? schemeData.invokePop : null, (r50 & 524288) != 0 ? schemeData.searchIntoLiveJson : null, (r50 & 1048576) != 0 ? schemeData.hlReplyIntoLive : null, (r50 & 2097152) != 0 ? schemeData.shareUid : null, (r50 & 4194304) != 0 ? schemeData.shareTag : null, (r50 & 8388608) != 0 ? schemeData.avcUrl : null, (r50 & 16777216) != 0 ? schemeData.hevcUrl : null, (r50 & 33554432) != 0 ? schemeData.rtcUrl : null, (r50 & CodedInputStream.DEFAULT_SIZE_LIMIT) != 0 ? schemeData.title : str12, (r50 & 134217728) != 0 ? schemeData.shareTaskInfo : null, (r50 & LaunchTaskConstants.OTHER_PROCESS) != 0 ? schemeData.quic : null, (r50 & NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH) != 0 ? schemeData.inviterId : null, (r50 & 1073741824) != 0 ? schemeData.highlightUrl : null, (r50 & Integer.MIN_VALUE) != 0 ? schemeData.introduceTips : null);
                                        intent.putExtra("params", copy.toSchemeParams());
                                        MiniShellRuntime miniShellRuntime2 = MiniShellRuntime.INSTANCE;
                                        if (str != null) {
                                        }
                                        String buildLiveScheme2 = miniShellRuntime2.buildLiveScheme(str16, schemeData.getSource());
                                        schemeParam = MixUriUtilKt.setSchemeParam(buildLiveScheme2, CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair("clickTime", String.valueOf(j)), new Pair("clickFrom", str5)}), true);
                                        if (schemeParam == null) {
                                        }
                                        if (!((schemeParam != null || schemeParam.length() == 0) ? true : true)) {
                                        }
                                        intent.putExtra("scheme", buildLiveScheme2);
                                    }
                                } else {
                                    JSONObject ext3 = schemeData.getExt();
                                    if (ext3 == null) {
                                        Intrinsics.throwNpe();
                                    }
                                    JSONObject optJSONObject = ext3.optJSONObject("ext");
                                    if (optJSONObject == null) {
                                        JSONObject ext4 = schemeData.getExt();
                                        if (ext4 == null) {
                                            Intrinsics.throwNpe();
                                        }
                                        if (schemeModel != null && (ext2 = schemeModel.getExt()) != null) {
                                            jSONObject = ext2.optJSONObject("ext");
                                        } else {
                                            jSONObject = null;
                                        }
                                        ext4.put("ext", jSONObject);
                                    } else if (TextUtils.isEmpty(optJSONObject.optString("source"))) {
                                        optJSONObject.put("source", str14);
                                    }
                                    ext = schemeData.getExt();
                                }
                                jSONObject2 = ext;
                                String liveBackScheme2 = schemeData.getLiveBackScheme();
                                JSONObject extRequest2 = schemeData.getExtRequest();
                                if (schemeData.getExtLog() != null) {
                                }
                                jSONObject3 = extLog;
                                copy = schemeData.copy((r50 & 1) != 0 ? schemeData.roomId : str13, (r50 & 2) != 0 ? schemeData.roomType : str11, (r50 & 4) != 0 ? schemeData.source : str14, (r50 & 8) != 0 ? schemeData.cover : str2, (r50 & 16) != 0 ? schemeData.playUrl : str6, (r50 & 32) != 0 ? schemeData.status : "", (r50 & 64) != 0 ? schemeData.format : "", (r50 & 128) != 0 ? schemeData.screen : "", (r50 & 256) != 0 ? schemeData.template : "", (r50 & 512) != 0 ? schemeData.liveBackScheme : liveBackScheme2, (r50 & 1024) != 0 ? schemeData.ext : jSONObject2, (r50 & 2048) != 0 ? schemeData.extRequest : extRequest2, (r50 & 4096) != 0 ? schemeData.extLog : jSONObject3, (r50 & 8192) != 0 ? schemeData.query : null, (r50 & 16384) != 0 ? schemeData.extParams : schemeData.getExtParams(), (r50 & 32768) != 0 ? schemeData.askId : "", (r50 & 65536) != 0 ? schemeData.templateId : str10, (r50 & 131072) != 0 ? schemeData.otherParams : null, (r50 & 262144) != 0 ? schemeData.invokePop : null, (r50 & 524288) != 0 ? schemeData.searchIntoLiveJson : null, (r50 & 1048576) != 0 ? schemeData.hlReplyIntoLive : null, (r50 & 2097152) != 0 ? schemeData.shareUid : null, (r50 & 4194304) != 0 ? schemeData.shareTag : null, (r50 & 8388608) != 0 ? schemeData.avcUrl : null, (r50 & 16777216) != 0 ? schemeData.hevcUrl : null, (r50 & 33554432) != 0 ? schemeData.rtcUrl : null, (r50 & CodedInputStream.DEFAULT_SIZE_LIMIT) != 0 ? schemeData.title : str12, (r50 & 134217728) != 0 ? schemeData.shareTaskInfo : null, (r50 & LaunchTaskConstants.OTHER_PROCESS) != 0 ? schemeData.quic : null, (r50 & NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH) != 0 ? schemeData.inviterId : null, (r50 & 1073741824) != 0 ? schemeData.highlightUrl : null, (r50 & Integer.MIN_VALUE) != 0 ? schemeData.introduceTips : null);
                                intent.putExtra("params", copy.toSchemeParams());
                                MiniShellRuntime miniShellRuntime22 = MiniShellRuntime.INSTANCE;
                                if (str != null) {
                                }
                                String buildLiveScheme22 = miniShellRuntime22.buildLiveScheme(str16, schemeData.getSource());
                                schemeParam = MixUriUtilKt.setSchemeParam(buildLiveScheme22, CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair("clickTime", String.valueOf(j)), new Pair("clickFrom", str5)}), true);
                                if (schemeParam == null) {
                                }
                                if (!((schemeParam != null || schemeParam.length() == 0) ? true : true)) {
                                }
                                intent.putExtra("scheme", buildLiveScheme22);
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
                        str14 = source;
                        if (schemeData.getExt() == null) {
                        }
                        jSONObject2 = ext;
                        String liveBackScheme22 = schemeData.getLiveBackScheme();
                        JSONObject extRequest22 = schemeData.getExtRequest();
                        if (schemeData.getExtLog() != null) {
                        }
                        jSONObject3 = extLog;
                        copy = schemeData.copy((r50 & 1) != 0 ? schemeData.roomId : str13, (r50 & 2) != 0 ? schemeData.roomType : str11, (r50 & 4) != 0 ? schemeData.source : str14, (r50 & 8) != 0 ? schemeData.cover : str2, (r50 & 16) != 0 ? schemeData.playUrl : str6, (r50 & 32) != 0 ? schemeData.status : "", (r50 & 64) != 0 ? schemeData.format : "", (r50 & 128) != 0 ? schemeData.screen : "", (r50 & 256) != 0 ? schemeData.template : "", (r50 & 512) != 0 ? schemeData.liveBackScheme : liveBackScheme22, (r50 & 1024) != 0 ? schemeData.ext : jSONObject2, (r50 & 2048) != 0 ? schemeData.extRequest : extRequest22, (r50 & 4096) != 0 ? schemeData.extLog : jSONObject3, (r50 & 8192) != 0 ? schemeData.query : null, (r50 & 16384) != 0 ? schemeData.extParams : schemeData.getExtParams(), (r50 & 32768) != 0 ? schemeData.askId : "", (r50 & 65536) != 0 ? schemeData.templateId : str10, (r50 & 131072) != 0 ? schemeData.otherParams : null, (r50 & 262144) != 0 ? schemeData.invokePop : null, (r50 & 524288) != 0 ? schemeData.searchIntoLiveJson : null, (r50 & 1048576) != 0 ? schemeData.hlReplyIntoLive : null, (r50 & 2097152) != 0 ? schemeData.shareUid : null, (r50 & 4194304) != 0 ? schemeData.shareTag : null, (r50 & 8388608) != 0 ? schemeData.avcUrl : null, (r50 & 16777216) != 0 ? schemeData.hevcUrl : null, (r50 & 33554432) != 0 ? schemeData.rtcUrl : null, (r50 & CodedInputStream.DEFAULT_SIZE_LIMIT) != 0 ? schemeData.title : str12, (r50 & 134217728) != 0 ? schemeData.shareTaskInfo : null, (r50 & LaunchTaskConstants.OTHER_PROCESS) != 0 ? schemeData.quic : null, (r50 & NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH) != 0 ? schemeData.inviterId : null, (r50 & 1073741824) != 0 ? schemeData.highlightUrl : null, (r50 & Integer.MIN_VALUE) != 0 ? schemeData.introduceTips : null);
                        intent.putExtra("params", copy.toSchemeParams());
                        MiniShellRuntime miniShellRuntime222 = MiniShellRuntime.INSTANCE;
                        if (str != null) {
                        }
                        String buildLiveScheme222 = miniShellRuntime222.buildLiveScheme(str16, schemeData.getSource());
                        schemeParam = MixUriUtilKt.setSchemeParam(buildLiveScheme222, CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair("clickTime", String.valueOf(j)), new Pair("clickFrom", str5)}), true);
                        if (schemeParam == null) {
                        }
                        if (!((schemeParam != null || schemeParam.length() == 0) ? true : true)) {
                        }
                        intent.putExtra("scheme", buildLiveScheme222);
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
            Result.m698constructorimpl(Unit.INSTANCE);
            str10 = str7;
            str11 = str8;
            str12 = str9;
            if (!TextUtils.isEmpty(str)) {
            }
            intent = new Intent();
            intent.putExtra(ILiveNPSPlugin.PARAMS_ROOM_ID, str13);
            intentData = this.mIntentData;
            if (intentData != null) {
                if (!TextUtils.isEmpty(schemeData.getSource())) {
                }
                str14 = source;
                if (schemeData.getExt() == null) {
                }
                jSONObject2 = ext;
                String liveBackScheme222 = schemeData.getLiveBackScheme();
                JSONObject extRequest222 = schemeData.getExtRequest();
                if (schemeData.getExtLog() != null) {
                }
                jSONObject3 = extLog;
                copy = schemeData.copy((r50 & 1) != 0 ? schemeData.roomId : str13, (r50 & 2) != 0 ? schemeData.roomType : str11, (r50 & 4) != 0 ? schemeData.source : str14, (r50 & 8) != 0 ? schemeData.cover : str2, (r50 & 16) != 0 ? schemeData.playUrl : str6, (r50 & 32) != 0 ? schemeData.status : "", (r50 & 64) != 0 ? schemeData.format : "", (r50 & 128) != 0 ? schemeData.screen : "", (r50 & 256) != 0 ? schemeData.template : "", (r50 & 512) != 0 ? schemeData.liveBackScheme : liveBackScheme222, (r50 & 1024) != 0 ? schemeData.ext : jSONObject2, (r50 & 2048) != 0 ? schemeData.extRequest : extRequest222, (r50 & 4096) != 0 ? schemeData.extLog : jSONObject3, (r50 & 8192) != 0 ? schemeData.query : null, (r50 & 16384) != 0 ? schemeData.extParams : schemeData.getExtParams(), (r50 & 32768) != 0 ? schemeData.askId : "", (r50 & 65536) != 0 ? schemeData.templateId : str10, (r50 & 131072) != 0 ? schemeData.otherParams : null, (r50 & 262144) != 0 ? schemeData.invokePop : null, (r50 & 524288) != 0 ? schemeData.searchIntoLiveJson : null, (r50 & 1048576) != 0 ? schemeData.hlReplyIntoLive : null, (r50 & 2097152) != 0 ? schemeData.shareUid : null, (r50 & 4194304) != 0 ? schemeData.shareTag : null, (r50 & 8388608) != 0 ? schemeData.avcUrl : null, (r50 & 16777216) != 0 ? schemeData.hevcUrl : null, (r50 & 33554432) != 0 ? schemeData.rtcUrl : null, (r50 & CodedInputStream.DEFAULT_SIZE_LIMIT) != 0 ? schemeData.title : str12, (r50 & 134217728) != 0 ? schemeData.shareTaskInfo : null, (r50 & LaunchTaskConstants.OTHER_PROCESS) != 0 ? schemeData.quic : null, (r50 & NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH) != 0 ? schemeData.inviterId : null, (r50 & 1073741824) != 0 ? schemeData.highlightUrl : null, (r50 & Integer.MIN_VALUE) != 0 ? schemeData.introduceTips : null);
                intent.putExtra("params", copy.toSchemeParams());
                MiniShellRuntime miniShellRuntime2222 = MiniShellRuntime.INSTANCE;
                if (str != null) {
                }
                String buildLiveScheme2222 = miniShellRuntime2222.buildLiveScheme(str16, schemeData.getSource());
                schemeParam = MixUriUtilKt.setSchemeParam(buildLiveScheme2222, CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair("clickTime", String.valueOf(j)), new Pair("clickFrom", str5)}), true);
                if (schemeParam == null) {
                }
                if (!((schemeParam != null || schemeParam.length() == 0) ? true : true)) {
                }
                intent.putExtra("scheme", buildLiveScheme2222);
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

    /* JADX DEBUG: Multi-variable search result rejected for r3v26, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r3v27, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r3v28, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r3v39, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void loadLiveRoom() {
        LiveContainer.LiveItemModel liveItemModel;
        String roomType;
        String title;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65577, this) == null) {
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
                String str2 = "0";
                if (this.prefetchEnterSwitch && Intrinsics.areEqual(intentData.getModel().getRoomType(), "0")) {
                    preReqRoomEnter();
                }
                if (!TextUtils.isEmpty(intentData.getModel().getRoomType()) && (!Intrinsics.areEqual("0", intentData.getModel().getRoomType()) || !TextUtils.isEmpty(intentData.getModel().getTemplateId()))) {
                    this.isFromForward = true;
                    if (Intrinsics.areEqual(intentData.getModel().getRoomType(), "3")) {
                        IntentData intentData2 = this.mIntentData;
                        if (intentData2 != null) {
                            str = intentData2.getScheme();
                        } else {
                            str = null;
                        }
                        if (str != null) {
                            try {
                                Map stringToMap = MixUriUtilKt.stringToMap(MixUriUtilKt.getParamsStr(str));
                                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                                boolean containsKey = stringToMap.containsKey("params");
                                T t = stringToMap;
                                if (containsKey) {
                                    try {
                                        t = paramsJsonToMap(new JSONObject((String) stringToMap.get("params")));
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
                                        liveItemModel.setLiveType(str2);
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
                                        liveItemModel.setQuic(intentData.getModel().getQuic());
                                        liveItemModel.setHighlightUrl(intentData.getModel().getHighlightUrl());
                                        liveItemModel.setExt(intentData.getModel().getExt());
                                        liveItemModel.setSource(intentData.getModel().getSource());
                                        liveItemModel.setShareTaskInfo(intentData.getModel().getShareTaskInfo());
                                        liveItemModel.setKabrSpts(intentData.getModel().getKabrSpts());
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
                        str2 = roomType;
                    }
                    liveItemModel.setLiveType(str2);
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
                    liveItemModel.setQuic(intentData.getModel().getQuic());
                    liveItemModel.setHighlightUrl(intentData.getModel().getHighlightUrl());
                    liveItemModel.setExt(intentData.getModel().getExt());
                    liveItemModel.setSource(intentData.getModel().getSource());
                    liveItemModel.setShareTaskInfo(intentData.getModel().getShareTaskInfo());
                    liveItemModel.setKabrSpts(intentData.getModel().getKabrSpts());
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
                if (mixModel != null) {
                    mixModel.reqLiveType(new OnMixDataLoaded(this) { // from class: com.baidu.searchbox.live.list.controller.ListController$loadLiveRoom$$inlined$run$lambda$1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ListController this$0;

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

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.searchbox.live.model.res.OnMixDataLoaded
                        public void onMixDataLoaded(MixResult mixResult) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null && interceptable2.invokeL(1048576, this, mixResult) != null) {
                                return;
                            }
                            this.this$0.onPreRoomEnterDataLoaded(mixResult);
                        }
                    });
                }
                ListLogKt.log("MixLiveCell_fake_list", "listComponent room type=" + intentData.getModel().getRoomType() + " || templateId=" + intentData.getModel().getTemplateId() + " is empty, request livetype context:" + this.context.hashCode());
            }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65578, this) == null) {
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
                jSONObject.put(ILiveNPSPlugin.PARAMS_ROOM_ID, str2);
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
    }

    public final void onCreate() {
        IntentData intentData;
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.mixActivity.setMixInvokeAbility(getMMixEventDispatcher());
            MediaLivePluginLogger.Companion.getInstance().logListOnCreateStart();
            Context context = this.context;
            if (context != null) {
                Activity activity = (Activity) context;
                if (activity != null && (intent = activity.getIntent()) != null) {
                    intentData = ListExtKt.parseLiveData(intent);
                } else {
                    intentData = null;
                }
                this.mIntentData = intentData;
                ServiceLocator.Companion.registerGlobalServices(ILiveListState.class, new ILiveListState(this) { // from class: com.baidu.searchbox.live.list.controller.ListController$onCreate$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ListController this$0;

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

                    @Override // com.baidu.searchbox.live.service.ILiveListState
                    public IntentData getIntent() {
                        InterceptResult invokeV;
                        IntentData intentData2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                            return (IntentData) invokeV.objValue;
                        }
                        intentData2 = this.this$0.mIntentData;
                        return intentData2;
                    }

                    @Override // com.baidu.searchbox.live.service.ILiveListState
                    public ListInfo getListInfo() {
                        InterceptResult invokeV;
                        ListInfo listInfo;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
                            return (ListInfo) invokeV.objValue;
                        }
                        listInfo = this.this$0.mListInfo;
                        return listInfo;
                    }

                    @Override // com.baidu.searchbox.live.service.ILiveListState
                    public PageInfo getPageInfo() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                            return this.this$0.getMPageInfo();
                        }
                        return (PageInfo) invokeV.objValue;
                    }
                });
                ServiceLocator.Companion.registerGlobalServices(LiveItemModelListService.class, new LiveItemModelListService(this) { // from class: com.baidu.searchbox.live.list.controller.ListController$onCreate$2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ListController this$0;

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

                    @Override // com.baidu.searchbox.live.component.service.LiveItemModelListService
                    public int getCurrentPosition() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            return this.this$0.getCurrentPosition();
                        }
                        return invokeV.intValue;
                    }

                    @Override // com.baidu.searchbox.live.component.service.LiveItemModelListService
                    public List getLiveItemModels() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            return this.this$0.getItemData();
                        }
                        return (List) invokeV.objValue;
                    }
                });
                ServiceLocator.Companion.registerGlobalServices(MixListOperatorInterface.class, new MixListOperatorInterface(this) { // from class: com.baidu.searchbox.live.list.controller.ListController$onCreate$3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ListController this$0;

                    @Override // com.baidu.searchbox.live.service.MixListOperatorInterface
                    public void insertRoom(int i, JSONObject jSONObject) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048579, this, i, jSONObject) == null) {
                        }
                    }

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

                    @Override // com.baidu.searchbox.live.service.MixListOperatorInterface
                    public void reloadLiveRoom(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeL(1048580, this, obj) != null) {
                            return;
                        }
                        this.this$0.reloadLiveRoom();
                    }

                    @Override // com.baidu.searchbox.live.service.MixListOperatorInterface
                    public void reloadSlideList(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048581, this, obj) == null) {
                            ListController listController = this.this$0;
                            listController.fetchMoreLiveIfNeed(listController.getCurrentPosition());
                        }
                    }

                    @Override // com.baidu.searchbox.live.service.MixListOperatorInterface
                    public void removeRoom(JSONObject jSONObject) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048582, this, jSONObject) == null) {
                            jSONObject.optString("source");
                            JSONArray roomIdJSONArray = jSONObject.optJSONArray("room_ids");
                            ListController listController = this.this$0;
                            Intrinsics.checkExpressionValueIsNotNull(roomIdJSONArray, "roomIdJSONArray");
                            listController.cacheCloseRoomIdList(roomIdJSONArray);
                        }
                    }

                    @Override // com.baidu.searchbox.live.service.MixListOperatorInterface
                    public void commonEvent(String str, Object obj) {
                        IntentData intentData2;
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, str, obj) == null) && str.hashCode() == -500901780 && str.equals(MixConstants.KEY_ROOM_INFO_RES_SUCCESS)) {
                            if (!(obj instanceof JSONObject)) {
                                obj = null;
                            }
                            JSONObject jSONObject = (JSONObject) obj;
                            if (jSONObject != null) {
                                String optString = jSONObject.optString("templateId");
                                int optInt = jSONObject.optInt("roomType");
                                String optString2 = jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID);
                                if (this.this$0.getCurrentPosition() >= 0 && this.this$0.getCurrentPosition() < this.this$0.getItemData().size()) {
                                    LiveContainer.LiveItemModel liveItemModel = (LiveContainer.LiveItemModel) this.this$0.getItemData().get(this.this$0.getCurrentPosition());
                                    ListLogKt.log("MixLiveCell_fake_list", "item model : roomId = " + liveItemModel.getRoomId() + ", roomType= " + liveItemModel.getLiveType() + ", templateId=" + liveItemModel.getTemplateId() + ", response : roomId = " + optString2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + "roomType=" + optInt + ", templateId=" + optString);
                                    if (!Intrinsics.areEqual(optString2, liveItemModel.getRoomId())) {
                                        return;
                                    }
                                    intentData2 = this.this$0.mIntentData;
                                    if (intentData2 != null) {
                                        intentData2.getModel().setRoomType(String.valueOf(optInt));
                                        intentData2.getModel().setTemplateId(optString);
                                    }
                                    liveItemModel.setLiveType(String.valueOf(optInt));
                                    liveItemModel.setTemplateId(optString);
                                }
                            }
                        }
                    }

                    @Override // com.baidu.searchbox.live.service.MixListOperatorInterface
                    public void doJumpNewLiveRoom(JSONObject jSONObject) {
                        IntentData intentData2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                            intentData2 = this.this$0.mIntentData;
                            if (intentData2 != null && intentData2.isHLReplay()) {
                                this.this$0.unBindHLReplayInfo();
                            }
                            if (jSONObject != null) {
                                ListController listController = this.this$0;
                                String optString = jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID, "");
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
                    }

                    @Override // com.baidu.searchbox.live.service.MixListOperatorInterface
                    public List getListData() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                            return this.this$0.getItemData();
                        }
                        return (List) invokeV.objValue;
                    }

                    @Override // com.baidu.searchbox.live.service.MixListOperatorInterface
                    public void scrollToNextLiveRoom() {
                        IListManager listManager;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048583, this) == null) {
                            listManager = this.this$0.getListManager();
                            listManager.scrollToNextLiveRoom();
                        }
                    }

                    @Override // com.baidu.searchbox.live.service.MixListOperatorInterface
                    public void scrollToPreLiveRoom() {
                        IListManager listManager;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                            listManager = this.this$0.getListManager();
                            listManager.scrollToPreLiveRoom();
                        }
                    }

                    @Override // com.baidu.searchbox.live.service.MixListOperatorInterface
                    public void switchLiveListScrollable(boolean z, boolean z2) {
                        IListManager listManager;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                            if (z2) {
                                this.this$0.serverSwitchCanScroll = z;
                                this.this$0.changeScrollState();
                                return;
                            }
                            listManager = this.this$0.getListManager();
                            listManager.setIsScrollable(z);
                            this.this$0.localSwitchCanScroll = z;
                            this.this$0.changeScrollState();
                        }
                    }
                });
                registerMixRequestService();
                MixModel mixModel = new MixModel(this.mixUniqueId);
                mixModel.setOnMixDataLoadedCallBack(new MixModel.OnMixDataLoadedCallBack(this) { // from class: com.baidu.searchbox.live.list.controller.ListController$onCreate$$inlined$apply$lambda$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ListController this$0;

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

                    @Override // com.baidu.searchbox.live.model.MixModel.OnMixDataLoadedCallBack
                    public void onTemplateIdSuccess(LiveTypeData liveTypeData) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeL(1048579, this, liveTypeData) != null) {
                            return;
                        }
                        this.this$0.templateIdSuccess(liveTypeData);
                    }

                    @Override // com.baidu.searchbox.live.model.MixModel.OnMixDataLoadedCallBack
                    public void onSlideListFail(Exception exc, Integer num) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeLL(1048576, this, exc, num) != null) {
                            return;
                        }
                        this.this$0.doEnterUbcByRequestEnter("", "room_list", a.g0, false, num, exc.getMessage());
                    }

                    @Override // com.baidu.searchbox.live.model.MixModel.OnMixDataLoadedCallBack
                    public void onSlideListSuccess(String str, int i, List list) {
                        IMixActivityInterface iMixActivityInterface;
                        LiveRoomInfoStatPlugin liveRoomInfoStatPlugin;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i, list) == null) {
                            this.this$0.mListInfo = new ListInfo(str, i);
                            iMixActivityInterface = this.this$0.mixActivity;
                            if (iMixActivityInterface != null) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("pageSession", str);
                                jSONObject.put("hasMore", i);
                                iMixActivityInterface.setMixEventDispatcher(MixConstants.KEY_LIST_INFO, jSONObject);
                            }
                            liveRoomInfoStatPlugin = this.this$0.mLiveRoomInfoStatPlugin;
                            if (liveRoomInfoStatPlugin != null) {
                                liveRoomInfoStatPlugin.dispatchListResult(str, i, list);
                            }
                            this.this$0.slideListSuccess(str, i, list);
                        }
                    }

                    @Override // com.baidu.searchbox.live.model.MixModel.OnMixDataLoadedCallBack
                    public void onTemplateIdFail() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            this.this$0.doEnterUbcByRequestEnter("", "template_id", a.g0, false, -1, "unknown");
                        }
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
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
        }
    }

    private final Map paramsJsonToMap(JSONObject jSONObject) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65580, this, jSONObject)) == null) {
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
        return (Map) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String parseClickTime(String str, LiveContainer.PlaySourceInfo playSourceInfo) {
        InterceptResult invokeLL;
        boolean z;
        Uri uri;
        Integer num;
        String str2;
        Long valueOf;
        String str3;
        String str4;
        String clickFrom;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65581, this, str, playSourceInfo)) == null) {
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
        return (String) invokeLL.objValue;
    }

    private final void preReqRoomEnter() {
        IntentData intentData;
        String str;
        String str2;
        String jSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65582, this) == null) && (intentData = this.mIntentData) != null) {
            String id = intentData.getId();
            String source = intentData.getSource();
            JSONObject searchIntoLiveJson = intentData.getModel().getSearchIntoLiveJson();
            if (searchIntoLiveJson != null) {
                str = searchIntoLiveJson.optString("question");
            } else {
                str = null;
            }
            JSONObject hlReplyIntoLive = intentData.getModel().getHlReplyIntoLive();
            String str3 = "";
            if (hlReplyIntoLive != null) {
                str2 = hlReplyIntoLive.optString("nid", "");
            } else {
                str2 = null;
            }
            JSONObject ext = intentData.getModel().getExt();
            if (ext != null && (jSONObject = ext.toString()) != null) {
                str3 = jSONObject;
            }
            RoomEnterParams roomEnterParams = new RoomEnterParams(id, source, str, str2, str3, false, 32, null);
            roomEnterParams.setAudio(Boolean.valueOf(Intrinsics.areEqual(intentData.getModel().getTemplateId(), "5")));
            MixModel mixModel = this.mNetModel;
            if (mixModel != null) {
                mixModel.reqRoomEnter(roomEnterParams, new OnMixDataLoaded(this) { // from class: com.baidu.searchbox.live.list.controller.ListController$preReqRoomEnter$$inlined$let$lambda$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ListController this$0;

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

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.live.model.res.OnMixDataLoaded
                    public void onMixDataLoaded(MixResult mixResult) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeL(1048576, this, mixResult) != null) {
                            return;
                        }
                        this.this$0.onPreRoomEnterDataLoaded(mixResult);
                    }
                });
            }
        }
    }

    private final void registerYYLifeCyclePlugin() {
        Lifecycle lifeCycle;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65585, this) == null) && !this.isRegistYYActivityLifeCyclePlugin) {
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

    public final void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
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
    }

    public final void onDestroy() {
        IMixActivityInterface iMixActivityInterface;
        Lifecycle lifeCycle;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
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
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void slideListSuccess(String str, int i, List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65587, this, str, i, list) == null) {
            final int size = this.itemData.size();
            distinct(this.itemData, list);
            this.itemData.addAll(list);
            MediaLivePlayLogger.Companion.getInstance().logLiveRoomEndSlideParseAddItem();
            MiniUiThreadUtil.INSTANCE.runOnUiThread(new Runnable(this, size) { // from class: com.baidu.searchbox.live.list.controller.ListController$slideListSuccess$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int $size;
                public final /* synthetic */ ListController this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(size)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.$size = size;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IListManager listManager;
                    long j;
                    long j2;
                    IListManager listManager2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        MediaLivePluginLogger.Companion.getInstance().logListSlideEndAndAddItem();
                        listManager = this.this$0.getListManager();
                        listManager.onListChange(this.$size);
                        if (this.this$0.getCurRoomModel() == null && this.this$0.getItemData().size() > 0) {
                            ListController listController = this.this$0;
                            listController.setCurRoomModel((LiveContainer.LiveItemModel) listController.getItemData().get(0));
                            listManager2 = this.this$0.getListManager();
                            LiveContainer.LiveItemModel curRoomModel = this.this$0.getCurRoomModel();
                            if (curRoomModel == null) {
                                Intrinsics.throwNpe();
                            }
                            listManager2.resetCurRoom(curRoomModel);
                        }
                        j = this.this$0.listRequestTime;
                        if (j > 0) {
                            ListController listController2 = this.this$0;
                            long currentTimeMillis = System.currentTimeMillis();
                            j2 = this.this$0.listRequestTime;
                            listController2.listRequestDuration = currentTimeMillis - j2;
                        }
                        MediaLivePluginLogger.Companion.getInstance().logListLoadRoomAndNextListAddItem();
                    }
                }
            });
            ListLogKt.log("MixLiveCell_fake_list", "listComponent slidlist request success size:" + this.itemData.size() + " context:" + this.context.hashCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void templateIdSuccess(LiveTypeData liveTypeData) {
        IntentData intentData;
        boolean z;
        String nidFromHLReplay;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65588, this, liveTypeData) == null) && (intentData = this.mIntentData) != null) {
            MediaLivePlayLogger.startLaunchInfoSigleLine$default(MediaLivePlayLogger.Companion.getInstance(), intentData.getId(), "precreate", false, 4, null);
            if (this.playSource == null) {
                LiveContainer.PlaySourceInfo playSourceInfo = new LiveContainer.PlaySourceInfo();
                playSourceInfo.setClickTime(Long.valueOf(System.currentTimeMillis()));
                playSourceInfo.setClickFrom("precreate");
                this.playSource = playSourceInfo;
            }
            String parseClickTime = parseClickTime(intentData.getScheme(), this.playSource);
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
            String str = "";
            if (title == null) {
                title = "";
            }
            liveItemModel.setTitle(title);
            liveItemModel.setIntroduceTips(intentData.getModel().getIntroduceTips());
            liveItemModel.setShareTaskInfo(intentData.getModel().getShareTaskInfo());
            if (intentData.isHLReplay()) {
                IntentData intentData2 = this.mIntentData;
                if (intentData2 != null && (nidFromHLReplay = intentData2.getNidFromHLReplay()) != null) {
                    str = nidFromHLReplay;
                }
                bindHLReplayInfo(liveItemModel, str);
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
                queryLiveList();
                ListLogKt.log("MixLiveCell_fake_list", "livetype request success, enter, request slidlist context:" + this.context.hashCode());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.live.eventbus.EventAction
    public void call(AbstractEvent abstractEvent) {
        IMixActivityInterface iMixActivityInterface;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, abstractEvent) != null) || abstractEvent == null || abstractEvent.getUniqueId() != this.mixUniqueId.getId()) {
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
        List<WeakReference> list;
        AbstractMixFakeShell abstractMixFakeShell;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048591, this, i, i2, intent) == null) && (list = this.shellList) != null) {
            for (WeakReference weakReference : list) {
                if (weakReference != null && (abstractMixFakeShell = (AbstractMixFakeShell) weakReference.get()) != null) {
                    abstractMixFakeShell.onActivityResult(i, i2, intent);
                }
            }
        }
    }

    @Override // com.baidu.live.arch.api.IExtLifecycle
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        List<WeakReference> list;
        AbstractMixFakeShell abstractMixFakeShell;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048599, this, i, strArr, iArr) == null) && (list = this.shellList) != null) {
            for (WeakReference weakReference : list) {
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
        String templateId;
        String roomId;
        LiveContainer.LiveItemModel liveItemModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            LiveContainer.LiveItemModel liveItemModel2 = this.curRoomModel;
            String str4 = "";
            if (liveItemModel2 != null && (roomId = liveItemModel2.getRoomId()) != null) {
                LiveContainer.LiveItemModel liveItemModel3 = this.curRoomModel;
                if (liveItemModel3 != null && !liveItemModel3.isYYLive() && (liveItemModel = this.curRoomModel) != null && !liveItemModel.isAudioLive()) {
                    LiveComponentLoadLogger companion = LiveComponentLoadLogger.Companion.getInstance();
                    LiveContainer.LiveItemModel liveItemModel4 = this.curRoomModel;
                    companion.launchMediaCompLoadFlow(roomId, (liveItemModel4 == null || (r3 = liveItemModel4.getTemplateId()) == null) ? "" : "", !this.isFromForward);
                } else {
                    LiveComponentLoadLogger.Companion.getInstance().cancelCurrentComponentFlow(roomId);
                }
            }
            if (this.isFromForward) {
                MediaLivePluginLogger companion2 = MediaLivePluginLogger.Companion.getInstance();
                LiveContainer.LiveItemModel liveItemModel5 = this.curRoomModel;
                String str5 = null;
                if (liveItemModel5 != null) {
                    str = liveItemModel5.getLiveType();
                } else {
                    str = null;
                }
                LiveContainer.LiveItemModel liveItemModel6 = this.curRoomModel;
                if (liveItemModel6 != null) {
                    str2 = liveItemModel6.getTemplateId();
                } else {
                    str2 = null;
                }
                companion2.updateStartPageInfoIntentRoomInfo(str, str2, this.isFromForward);
                LiveComponentLoadLogger companion3 = LiveComponentLoadLogger.Companion.getInstance();
                LiveContainer.LiveItemModel liveItemModel7 = this.curRoomModel;
                if (liveItemModel7 != null) {
                    str3 = liveItemModel7.getRoomId();
                } else {
                    str3 = null;
                }
                IntentData intentData = this.mIntentData;
                if (intentData != null) {
                    str5 = intentData.getSource();
                }
                LiveContainer.LiveItemModel liveItemModel8 = this.curRoomModel;
                if (liveItemModel8 != null && (templateId = liveItemModel8.getTemplateId()) != null) {
                    str4 = templateId;
                }
                companion3.bindRoomIdToExternalEnterFlow(str3, str5, str4);
            }
            this.mPageInfo = new PageInfo(true, i, this.isFromForward, this.listRequestDuration);
        }
    }

    @Override // com.baidu.live.arch.api.IExtLifecycle
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        AbstractMixFakeShell abstractMixFakeShell;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048597, this, i, keyEvent)) == null) {
            for (WeakReference weakReference : this.shellList) {
                if (weakReference != null) {
                    abstractMixFakeShell = (AbstractMixFakeShell) weakReference.get();
                } else {
                    abstractMixFakeShell = null;
                }
                if (abstractMixFakeShell != null) {
                    Object obj = weakReference.get();
                    if (obj == null) {
                        Intrinsics.throwNpe();
                    }
                    if (((AbstractMixFakeShell) obj).onKeyDown(i, keyEvent)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeIL.booleanValue;
    }
}
