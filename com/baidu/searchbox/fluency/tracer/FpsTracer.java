package com.baidu.searchbox.fluency.tracer;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.aperf.param.CommonUtils;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.devicescore.IDeviceScore;
import com.baidu.searchbox.fluency.config.BdTracesConfig;
import com.baidu.searchbox.fluency.core.FrameRefreshMonitor;
import com.baidu.searchbox.fluency.listener.FrameRateListener;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.searchbox.fluency.ubc.FpsPerfSampleCallback;
import com.baidu.searchbox.fluency.utils.FpsConstants;
import com.baidu.searchbox.fluency.utils.FpsHandlerThread;
import com.baidu.searchbox.fluency.utils.Logcat;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt__MathJVMKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 <2\u00020\u0001:\u0003<=>B\u000f\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b:\u0010;J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJG\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010\u001e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b!\u0010\"JG\u0010#\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H\u0002¢\u0006\u0004\b#\u0010\u001aJ\u000f\u0010$\u001a\u00020\u0004H\u0016¢\u0006\u0004\b$\u0010\u000fJ\u000f\u0010%\u001a\u00020\u0004H\u0016¢\u0006\u0004\b%\u0010\u000fJ\u0015\u0010&\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b&\u0010\u0006R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R:\u00102\u001a&\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u000600R\u00020\u00000/j\u0012\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u000600R\u00020\u0000`18\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00118\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b4\u0010.R&\u00107\u001a\u0012\u0012\u0004\u0012\u00020\u000205j\b\u0012\u0004\u0012\u00020\u0002`68\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010,¨\u0006?"}, d2 = {"Lcom/baidu/searchbox/fluency/tracer/FpsTracer;", "Lcom/baidu/searchbox/fluency/tracer/Tracer;", "Lcom/baidu/searchbox/fluency/listener/FrameRateListener;", "listener", "", "addListener", "(Lcom/baidu/searchbox/fluency/listener/FrameRateListener;)V", "", "from", "page", "type", "", "beginFpsCollect", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "deleteCsvFileIfExist", "()V", "scene", "", "startNs", "endNs", "", "isVsyncFrame", "inputCostNs", "animationCostNs", "traversalCostNs", "doFrame", "(Ljava/lang/String;JJZJJJ)V", "key", "endFpsCollect", "(Ljava/lang/Object;)V", "generateCollectorKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Ljava/io/File;", "getCsvFile", "()Ljava/io/File;", "notifyListener", "onAlive", "onDead", "removeListener", "Lcom/baidu/searchbox/fluency/config/BdTracesConfig;", UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, "Lcom/baidu/searchbox/fluency/config/BdTracesConfig;", "", "droppedSum", "I", "durationSum", "J", "Ljava/util/HashMap;", "Lcom/baidu/searchbox/fluency/tracer/FpsTracer$FpsCollector;", "Lkotlin/collections/HashMap;", "fpsCollectorCache", "Ljava/util/HashMap;", "frameIntervalNs", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "listeners", "Ljava/util/HashSet;", "timeSliceMs", "<init>", "(Lcom/baidu/searchbox/fluency/config/BdTracesConfig;)V", "Companion", "FpsCollector", "FrameCollectItem", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class FpsTracer extends Tracer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CSV_PATH_DEFAULT = "/CSV/";
    public static final Companion Companion;
    public static final String TAG = "FrameTracer";
    public static final String UBC_KEY_EXT = "ext";
    public static final String UBC_KEY_FLUENCY = "fluency";
    public static final String UBC_KEY_FROM = "from";
    public static final String UBC_KEY_NET_TYPE = "nettype";
    public static final String UBC_KEY_PAGE = "page";
    public static final String UBC_KEY_TOP_VIEW = "toppage";
    public static final String UBC_KEY_TYPE = "type";
    public transient /* synthetic */ FieldHolder $fh;
    public final BdTracesConfig config;
    public int droppedSum;
    public long durationSum;
    public final HashMap<String, FpsCollector> fpsCollectorCache;
    public final long frameIntervalNs;
    public final HashSet<FrameRateListener> listeners;
    public int timeSliceMs;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0003R\u0016\u0010\b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0003R\u0016\u0010\t\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0003R\u0016\u0010\n\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0003R\u0016\u0010\u000b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0003¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/fluency/tracer/FpsTracer$Companion;", "", "CSV_PATH_DEFAULT", "Ljava/lang/String;", "TAG", "UBC_KEY_EXT", "UBC_KEY_FLUENCY", "UBC_KEY_FROM", "UBC_KEY_NET_TYPE", "UBC_KEY_PAGE", "UBC_KEY_TOP_VIEW", "UBC_KEY_TYPE", "<init>", "()V", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
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

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b-\u0010.J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007JO\u0010\u0014\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b¢\u0006\u0004\b\u001e\u0010\u001fR:\u0010$\u001a&\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u00060!R\u00020\"0 j\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u00060!R\u00020\"`#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010\u001b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010+R\u0016\u0010\u001c\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010+R\u0016\u0010,\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010+R\u0016\u0010\u001d\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010+¨\u0006/"}, d2 = {"Lcom/baidu/searchbox/fluency/tracer/FpsTracer$FpsCollector;", "Lcom/baidu/searchbox/fluency/listener/FrameRateListener;", "", "Lcom/baidu/searchbox/fluency/listener/FrameRateListener$FrameReplay;", "frameList", "", "doReplay", "(Ljava/util/List;)V", "", "topPage", "", "startNs", "endNs", "", "dropFrames", "", "isVsyncFrame", "inputCostNs", "animationCostNs", "traversalCostNs", "doReplayInner", "(Ljava/lang/String;JJIZJJJ)V", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "getIntervalFrameReplay", "()I", "from", "page", "type", "setStatParams", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Ljava/util/HashMap;", "Lcom/baidu/searchbox/fluency/tracer/FpsTracer$FrameCollectItem;", "Lcom/baidu/searchbox/fluency/tracer/FpsTracer;", "Lkotlin/collections/HashMap;", "collectMap", "Ljava/util/HashMap;", "fpsExecutor", "Ljava/util/concurrent/Executor;", "Landroid/os/Handler;", "frameHandler", "Landroid/os/Handler;", "Ljava/lang/String;", "scene", "<init>", "(Lcom/baidu/searchbox/fluency/tracer/FpsTracer;)V", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public final class FpsCollector extends FrameRateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final HashMap<String, FrameCollectItem> collectMap;
        public final Executor fpsExecutor;
        public final Handler frameHandler;
        public String from;
        public String page;
        public String scene;
        public final /* synthetic */ FpsTracer this$0;
        public String type;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public FpsCollector(FpsTracer fpsTracer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fpsTracer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = fpsTracer;
            this.from = "";
            this.page = "";
            this.type = "";
            this.scene = "";
            this.collectMap = new HashMap<>();
            this.frameHandler = new Handler(FpsHandlerThread.INSTANCE.getDefaultHandlerThread().getLooper());
            this.fpsExecutor = new Executor(this) { // from class: com.baidu.searchbox.fluency.tracer.FpsTracer$FpsCollector$fpsExecutor$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FpsTracer.FpsCollector this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i3 = newInitContext2.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    Handler handler;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, runnable) == null) {
                        handler = this.this$0.frameHandler;
                        handler.post(runnable);
                    }
                }
            };
        }

        /* JADX WARN: Type inference failed for: r8v2, types: [com.baidu.searchbox.fluency.tracer.FpsTracer$FrameCollectItem, T] */
        /* JADX WARN: Type inference failed for: r8v9, types: [com.baidu.searchbox.fluency.tracer.FpsTracer$FrameCollectItem, T] */
        private final void doReplayInner(String str, long j, long j2, int i, boolean z, long j3, long j4, long j5) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Boolean.valueOf(z), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)}) == null) && !TextUtils.isEmpty(str) && z) {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                FrameCollectItem frameCollectItem = this.collectMap.get(this.scene);
                objectRef.element = frameCollectItem;
                if (frameCollectItem == null) {
                    ?? frameCollectItem2 = new FrameCollectItem(this.this$0, this.from, this.page, this.type, this.scene, str);
                    objectRef.element = frameCollectItem2;
                    this.collectMap.put(this.scene, (FrameCollectItem) frameCollectItem2);
                }
                ((FrameCollectItem) objectRef.element).collect(i);
                if (((FrameCollectItem) objectRef.element).getSumFrameCost() >= this.this$0.timeSliceMs) {
                    this.collectMap.remove(this.scene);
                    if (AppConfig.isDebug()) {
                        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new FpsTracer$FpsCollector$doReplayInner$1(objectRef, null), 3, null);
                    } else {
                        ((FrameCollectItem) objectRef.element).report();
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.fluency.listener.FrameRateListener
        public void doReplay(List<FrameRateListener.FrameReplay> frameList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, frameList) == null) {
                Intrinsics.checkNotNullParameter(frameList, "frameList");
                super.doReplay(frameList);
                for (FrameRateListener.FrameReplay frameReplay : frameList) {
                    doReplayInner(frameReplay.getTopPage(), frameReplay.getStartNs(), frameReplay.getEndNs(), frameReplay.getDropFrame(), frameReplay.isVsyncFrame(), frameReplay.getInputCostNs(), frameReplay.getAnimationCostNs(), frameReplay.getTraversalCostNs());
                }
            }
        }

        @Override // com.baidu.searchbox.fluency.listener.FrameRateListener
        public Executor getExecutor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.fpsExecutor : (Executor) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.fluency.listener.FrameRateListener
        public int getIntervalFrameReplay() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return 200;
            }
            return invokeV.intValue;
        }

        public final void setStatParams(String from, String page, String type) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, from, page, type) == null) {
                Intrinsics.checkNotNullParameter(from, "from");
                Intrinsics.checkNotNullParameter(page, "page");
                Intrinsics.checkNotNullParameter(type, "type");
                this.from = from;
                this.page = page;
                this.type = type;
                this.scene = this.this$0.generateCollectorKey(from, page, type);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0011\b\u0086\u0004\u0018\u0000B/\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u001f\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\r¢\u0006\u0004\b'\u0010(J\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ7\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u00068\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001eR\u0016\u0010\u0011\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\"\u0010 \u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u001d\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\u0013\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001eR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lcom/baidu/searchbox/fluency/tracer/FpsTracer$FrameCollectItem;", "", "droppedFrames", "", "collect", "(I)V", "", "getDeviceScore", "()Ljava/lang/Float;", "report", "()V", "saveCsv", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "from", "page", "type", "topPage", "Lorg/json/JSONObject;", "fluencyObj", "ubcEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "", FpsConstants.REPORT_DROP_LEVEL, "[I", FpsConstants.REPORT_DROP_SUM, "frameIntervalCost", "F", "Ljava/lang/String;", "scene", "sumFrameCost", "getSumFrameCost", "()F", "setSumFrameCost", "(F)V", "sumFrames", "I", "<init>", "(Lcom/baidu/searchbox/fluency/tracer/FpsTracer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public final class FrameCollectItem {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int[] dropLevel;
        public int[] dropSum;
        public final float frameIntervalCost;
        public final String from;
        public final String page;
        public final String scene;
        public float sumFrameCost;
        public int sumFrames;
        public final /* synthetic */ FpsTracer this$0;
        public final String topPage;
        public final String type;

        public FrameCollectItem(FpsTracer fpsTracer, String from, String page, String type, String scene, String topPage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fpsTracer, from, page, type, scene, topPage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(page, "page");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(topPage, "topPage");
            this.this$0 = fpsTracer;
            this.from = from;
            this.page = page;
            this.type = type;
            this.scene = scene;
            this.topPage = topPage;
            this.dropLevel = new int[DropLevel.values().length];
            this.dropSum = new int[DropLevel.values().length];
            this.frameIntervalCost = 16.666668f;
        }

        private final Float getDeviceScore() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
                IDeviceScore iDeviceScore = (IDeviceScore) ServiceManager.getService(IDeviceScore.SERVICE_REFERENCE);
                if (iDeviceScore != null) {
                    return Float.valueOf(iDeviceScore.getFinalScore(AppRuntime.getAppContext()));
                }
                return null;
            }
            return (Float) invokeV.objValue;
        }

        private final void ubcEvent(String str, String str2, String str3, String str4, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLLL(65543, this, str, str2, str3, str4, jSONObject) == null) {
                UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("from", str);
                jSONObject2.put("page", str2);
                jSONObject2.put("type", str3);
                JSONObject jSONObject3 = new JSONObject();
                String oSVersion = CommonUtils.getOSVersion();
                if (oSVersion != null) {
                    jSONObject3.put("osversion", oSVersion);
                }
                String appVersion = CommonUtils.getAppVersion();
                if (appVersion != null) {
                    jSONObject3.put("appversion", appVersion);
                }
                Float deviceScore = getDeviceScore();
                if (deviceScore != null) {
                    jSONObject3.put("devicescore", Float.valueOf(deviceScore.floatValue()));
                }
                String network = CommonUtils.getNetwork();
                if (network != null) {
                    jSONObject3.put("network", network);
                }
                jSONObject3.put(FpsTracer.UBC_KEY_NET_TYPE, NetWorkUtils.getNetworkClass());
                jSONObject3.put(FpsTracer.UBC_KEY_TOP_VIEW, str4);
                jSONObject3.put(FpsTracer.UBC_KEY_FLUENCY, jSONObject);
                jSONObject2.put("ext", jSONObject3);
                uBCManager.onEvent(FpsPerfSampleCallback.UBC_FPS_ID, jSONObject2);
            }
        }

        public final void collect(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.sumFrameCost += (i + 1) * this.frameIntervalCost;
                this.sumFrames++;
                if (i >= 40) {
                    int[] iArr = this.dropLevel;
                    int index = DropLevel.DROPPED_FROZEN.getIndex();
                    iArr[index] = iArr[index] + 1;
                    int[] iArr2 = this.dropSum;
                    int index2 = DropLevel.DROPPED_FROZEN.getIndex();
                    iArr2[index2] = iArr2[index2] + i;
                } else if (i >= 25) {
                    int[] iArr3 = this.dropLevel;
                    int index3 = DropLevel.DROPPED_HIGH.getIndex();
                    iArr3[index3] = iArr3[index3] + 1;
                    int[] iArr4 = this.dropSum;
                    int index4 = DropLevel.DROPPED_HIGH.getIndex();
                    iArr4[index4] = iArr4[index4] + i;
                } else if (i >= 10) {
                    int[] iArr5 = this.dropLevel;
                    int index5 = DropLevel.DROPPED_MIDDLE.getIndex();
                    iArr5[index5] = iArr5[index5] + 1;
                    int[] iArr6 = this.dropSum;
                    int index6 = DropLevel.DROPPED_MIDDLE.getIndex();
                    iArr6[index6] = iArr6[index6] + i;
                } else if (i >= 3) {
                    int[] iArr7 = this.dropLevel;
                    int index7 = DropLevel.DROPPED_NORMAL.getIndex();
                    iArr7[index7] = iArr7[index7] + 1;
                    int[] iArr8 = this.dropSum;
                    int index8 = DropLevel.DROPPED_NORMAL.getIndex();
                    iArr8[index8] = iArr8[index8] + i;
                } else {
                    int[] iArr9 = this.dropLevel;
                    int index9 = DropLevel.DROPPED_BEST.getIndex();
                    iArr9[index9] = iArr9[index9] + 1;
                    int[] iArr10 = this.dropSum;
                    int index10 = DropLevel.DROPPED_BEST.getIndex();
                    iArr10[index10] = iArr10[index10] + Math.max(i, 0);
                }
            }
        }

        public final float getSumFrameCost() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.sumFrameCost : invokeV.floatValue;
        }

        public final void report() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    try {
                        int roundToInt = MathKt__MathJVMKt.roundToInt(Math.min(60.0f, (this.sumFrames * 1000.0f) / this.sumFrameCost));
                        Logcat logcat = Logcat.INSTANCE;
                        logcat.d(FpsTracer.TAG, "[report] fps: " + roundToInt + StringUtil.ARRAY_ELEMENT_SEPARATOR + toString());
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(DropLevel.DROPPED_FROZEN.name(), this.dropLevel[DropLevel.DROPPED_FROZEN.getIndex()]);
                        jSONObject.put(DropLevel.DROPPED_HIGH.name(), this.dropLevel[DropLevel.DROPPED_HIGH.getIndex()]);
                        jSONObject.put(DropLevel.DROPPED_MIDDLE.name(), this.dropLevel[DropLevel.DROPPED_MIDDLE.getIndex()]);
                        jSONObject.put(DropLevel.DROPPED_NORMAL.name(), this.dropLevel[DropLevel.DROPPED_NORMAL.getIndex()]);
                        jSONObject.put(DropLevel.DROPPED_BEST.name(), this.dropLevel[DropLevel.DROPPED_BEST.getIndex()]);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(DropLevel.DROPPED_FROZEN.name(), this.dropSum[DropLevel.DROPPED_FROZEN.getIndex()]);
                        jSONObject2.put(DropLevel.DROPPED_HIGH.name(), this.dropSum[DropLevel.DROPPED_HIGH.getIndex()]);
                        jSONObject2.put(DropLevel.DROPPED_MIDDLE.name(), this.dropSum[DropLevel.DROPPED_MIDDLE.getIndex()]);
                        jSONObject2.put(DropLevel.DROPPED_NORMAL.name(), this.dropSum[DropLevel.DROPPED_NORMAL.getIndex()]);
                        jSONObject2.put(DropLevel.DROPPED_BEST.name(), this.dropSum[DropLevel.DROPPED_BEST.getIndex()]);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(FpsConstants.REPORT_FPS, roundToInt);
                        jSONObject3.put(FpsConstants.REPORT_DROP_LEVEL, jSONObject);
                        jSONObject3.put(FpsConstants.REPORT_DROP_SUM, jSONObject2);
                        ubcEvent(this.from, this.page, this.type, this.topPage, jSONObject3);
                    } catch (JSONException e) {
                        Logcat logcat2 = Logcat.INSTANCE;
                        logcat2.e(FpsTracer.TAG, "[report], json error: " + e);
                    }
                } finally {
                    this.sumFrames = 0;
                    this.sumFrameCost = 0.0f;
                }
            }
        }

        public final Object saveCsv(Continuation<? super Unit> continuation) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, continuation)) == null) {
                Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new FpsTracer$FrameCollectItem$saveCsv$2(this, null), continuation);
                return withContext == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
            }
            return invokeL.objValue;
        }

        public final void setSumFrameCost(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048580, this, f) == null) {
                this.sumFrameCost = f;
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("topPage=");
                sb.append(this.topPage);
                sb.append(", scene=");
                sb.append(this.scene);
                sb.append(", sumFrames=");
                sb.append(this.sumFrames);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("sumFrameCost=");
                sb.append(this.sumFrameCost);
                sb.append(", dropLevel=");
                String arrays = Arrays.toString(this.dropLevel);
                Intrinsics.checkNotNullExpressionValue(arrays, "java.util.Arrays.toString(this)");
                sb.append(arrays);
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1694677708, "Lcom/baidu/searchbox/fluency/tracer/FpsTracer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1694677708, "Lcom/baidu/searchbox/fluency/tracer/FpsTracer;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    public FpsTracer(BdTracesConfig config) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {config};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        this.listeners = new HashSet<>();
        this.frameIntervalNs = FpsConstants.DEFAULT_FRAME_DURATION;
        this.timeSliceMs = this.config.getTimeSliceMs();
        if (AppConfig.isDebug()) {
            deleteCsvFileIfExist();
        }
        this.fpsCollectorCache = new HashMap<>();
    }

    private final void deleteCsvFileIfExist() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            File csvFile = getCsvFile();
            if (csvFile.exists()) {
                csvFile.delete();
                Logcat logcat = Logcat.INSTANCE;
                logcat.d(TAG, "delete file: " + csvFile.getAbsolutePath());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String generateCollectorKey(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, this, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "nulls";
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "nulls";
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = "nulls";
            }
            return str + "_" + str2 + "_" + str3;
        }
        return (String) invokeLLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getCsvFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            File file = new File(AppRuntime.getAppContext().getExternalFilesDir(null), CSV_PATH_DEFAULT);
            if (!file.exists()) {
                file.mkdir();
            }
            return new File(file, "fps_feed.csv");
        }
        return (File) invokeV.objValue;
    }

    private final void notifyListener(final String str, final long j, final long j2, final boolean z, final long j3, final long j4, final long j5) {
        FpsTracer fpsTracer;
        long currentTimeMillis;
        HashSet<FrameRateListener> hashSet;
        Iterator<FrameRateListener> it;
        final int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65545, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)}) != null) {
            return;
        }
        FpsTracer fpsTracer2 = this;
        long currentTimeMillis2 = System.currentTimeMillis();
        long j6 = j2 - j;
        try {
            int i2 = (int) (j6 / fpsTracer2.frameIntervalNs);
            fpsTracer2.droppedSum += i2;
            fpsTracer2.durationSum += Math.max(j6, fpsTracer2.frameIntervalNs);
            HashSet<FrameRateListener> hashSet2 = fpsTracer2.listeners;
            synchronized (hashSet2) {
                try {
                    Iterator<FrameRateListener> it2 = fpsTracer2.listeners.iterator();
                    while (it2.hasNext()) {
                        try {
                            final FrameRateListener next = it2.next();
                            if (next.getExecutor() != null) {
                                if (next.getIntervalFrameReplay() > 0) {
                                    i = i2;
                                    hashSet = hashSet2;
                                    try {
                                        next.collect(str, j, j2, i2, z, j3, j4, j5);
                                        it = it2;
                                    } catch (Throwable th) {
                                        th = th;
                                        fpsTracer = fpsTracer2;
                                        try {
                                            throw th;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                                            if (fpsTracer.config.isDebug() && currentTimeMillis > fpsTracer.frameIntervalNs) {
                                                Logcat.INSTANCE.e(TAG, "[notifyListener] too heavy, cost " + currentTimeMillis + ", size of listeners: " + fpsTracer.listeners.size());
                                            }
                                            throw th;
                                        }
                                    }
                                } else {
                                    i = i2;
                                    hashSet = hashSet2;
                                    try {
                                        Executor executor = next.getExecutor();
                                        Intrinsics.checkNotNull(executor);
                                        it = it2;
                                        executor.execute(new Runnable(next, this, str, j, j2, i, z, j3, j4, j5) { // from class: com.baidu.searchbox.fluency.tracer.FpsTracer$notifyListener$$inlined$synchronized$lambda$1
                                            public static /* synthetic */ Interceptable $ic;
                                            public final /* synthetic */ long $animationCostNs$inlined;
                                            public final /* synthetic */ int $dropFrame$inlined;
                                            public final /* synthetic */ long $endNs$inlined;
                                            public transient /* synthetic */ FieldHolder $fh;
                                            public final /* synthetic */ long $inputCostNs$inlined;
                                            public final /* synthetic */ boolean $isVsyncFrame$inlined;
                                            public final /* synthetic */ FrameRateListener $listener;
                                            public final /* synthetic */ String $scene$inlined;
                                            public final /* synthetic */ long $startNs$inlined;
                                            public final /* synthetic */ long $traversalCostNs$inlined;
                                            public final /* synthetic */ FpsTracer this$0;

                                            {
                                                Interceptable interceptable2 = $ic;
                                                if (interceptable2 != null) {
                                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                                    newInitContext.initArgs = r4;
                                                    Object[] objArr = {next, this, str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Boolean.valueOf(z), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)};
                                                    interceptable2.invokeUnInit(65536, newInitContext);
                                                    int i3 = newInitContext.flag;
                                                    if ((i3 & 1) != 0) {
                                                        int i4 = i3 & 2;
                                                        newInitContext.thisArg = this;
                                                        interceptable2.invokeInitBody(65536, newInitContext);
                                                        return;
                                                    }
                                                }
                                                this.$listener = next;
                                                this.this$0 = this;
                                                this.$scene$inlined = str;
                                                this.$startNs$inlined = j;
                                                this.$endNs$inlined = j2;
                                                this.$dropFrame$inlined = i;
                                                this.$isVsyncFrame$inlined = z;
                                                this.$inputCostNs$inlined = j3;
                                                this.$animationCostNs$inlined = j4;
                                                this.$traversalCostNs$inlined = j5;
                                            }

                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                Interceptable interceptable2 = $ic;
                                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                                    this.$listener.doFrameAsync(this.$scene$inlined, this.$startNs$inlined, this.$endNs$inlined, this.$dropFrame$inlined, this.$isVsyncFrame$inlined, this.$inputCostNs$inlined, this.$animationCostNs$inlined, this.$traversalCostNs$inlined);
                                                }
                                            }
                                        });
                                    } catch (Throwable th3) {
                                        th = th3;
                                        fpsTracer = this;
                                        throw th;
                                    }
                                }
                            } else {
                                it = it2;
                                i = i2;
                                hashSet = hashSet2;
                                next.doFrameSync(str, j, j2, i, z, j3, j4, j5);
                            }
                            fpsTracer2 = this;
                            i2 = i;
                            hashSet2 = hashSet;
                            it2 = it;
                        } catch (Throwable th4) {
                            th = th4;
                            hashSet = hashSet2;
                            fpsTracer = this;
                            throw th;
                        }
                    }
                    hashSet = hashSet2;
                    Unit unit = Unit.INSTANCE;
                    try {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                        if (!this.config.isDebug() || currentTimeMillis3 <= this.frameIntervalNs) {
                            return;
                        }
                        Logcat.INSTANCE.e(TAG, "[notifyListener] too heavy, cost " + currentTimeMillis3 + ", size of listeners: " + this.listeners.size());
                    } catch (Throwable th5) {
                        th = th5;
                        fpsTracer = this;
                        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                        if (fpsTracer.config.isDebug()) {
                            Logcat.INSTANCE.e(TAG, "[notifyListener] too heavy, cost " + currentTimeMillis + ", size of listeners: " + fpsTracer.listeners.size());
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    hashSet = hashSet2;
                }
            }
        } catch (Throwable th7) {
            th = th7;
            fpsTracer = fpsTracer2;
        }
    }

    public final void addListener(FrameRateListener listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, listener) == null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            if (!isAlive()) {
                onStartTrace();
            }
            synchronized (this.listeners) {
                this.listeners.add(listener);
            }
        }
    }

    public final Object beginFpsCollect(String from, String page, String type) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, from, page, type)) == null) {
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(page, "page");
            Intrinsics.checkNotNullParameter(type, "type");
            String generateCollectorKey = generateCollectorKey(from, page, type);
            if (!this.config.isFpsEnable()) {
                Logcat.INSTANCE.d(TAG, "[beginFpsCollect] FPS disable!");
                return generateCollectorKey;
            }
            FpsCollector fpsCollector = this.fpsCollectorCache.get(generateCollectorKey);
            if (fpsCollector == null) {
                fpsCollector = new FpsCollector(this);
                fpsCollector.setStatParams(from, page, type);
                this.fpsCollectorCache.put(generateCollectorKey, fpsCollector);
            }
            addListener(fpsCollector);
            return generateCollectorKey;
        }
        return invokeLLL.objValue;
    }

    @Override // com.baidu.searchbox.fluency.core.FrameRefreshMonitor.FrameRefreshObserver
    public void doFrame(String scene, long j, long j2, boolean z, long j3, long j4, long j5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{scene, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)}) == null) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            if (BdBoxActivityManager.isForeground()) {
                notifyListener(scene, j, j2, z, j3, j4, j5);
            }
        }
    }

    public final void endFpsCollect(Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, obj) == null) || obj == null) {
            return;
        }
        if (!this.config.isFpsEnable()) {
            Logcat.INSTANCE.d(TAG, "[endFpsCollect] FPS disable!");
            return;
        }
        FpsCollector fpsCollector = this.fpsCollectorCache.get(obj);
        if (fpsCollector != null) {
            removeListener(fpsCollector);
        }
    }

    @Override // com.baidu.searchbox.fluency.tracer.Tracer
    public void onAlive() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onAlive();
            FrameRefreshMonitor.INSTANCE.addFrameRefreshObserver(this);
        }
    }

    @Override // com.baidu.searchbox.fluency.tracer.Tracer
    public void onDead() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDead();
            FrameRefreshMonitor.INSTANCE.removeFrameRefreshObserver(this);
        }
    }

    public final void removeListener(FrameRateListener listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, listener) == null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            synchronized (this.listeners) {
                this.listeners.remove(listener);
                if (this.listeners.isEmpty()) {
                    onCloseTrace();
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
