package com.baidu.searchbox.player.kernel;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.baidu.mobads.sdk.internal.cl;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.env.PlayerRuntime;
import com.baidu.searchbox.player.interfaces.OnMediaRuntimeInfoListener;
import com.baidu.searchbox.player.interfaces.OnSnapShotFrameListener;
import com.baidu.searchbox.player.model.BasicVideoSeries;
import com.baidu.searchbox.player.model.KernelMediaInfo;
import com.baidu.searchbox.player.model.VideoUrlModel;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.searchbox.player.util.YYUtil;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.searchbox.player.utils.DeviceUtil;
import com.baidu.tieba.thc;
import com.baidu.tieba.uhc;
import com.baidu.tieba.vhc;
import com.baidu.tieba.zgc;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 d2\u00020\u0001:\u0001dB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\bH\u0016J\b\u0010\u001c\u001a\u00020\bH\u0016J\b\u0010\u001d\u001a\u00020\bH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J\u0012\u0010\"\u001a\u00020\u00162\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\bH\u0016J\b\u0010&\u001a\u00020\bH\u0016J\b\u0010'\u001a\u00020\bH\u0016J\b\u0010(\u001a\u00020\bH\u0016J\b\u0010)\u001a\u00020\bH\u0016J\b\u0010*\u001a\u00020\bH\u0016J\u0010\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\bH\u0002J\b\u0010-\u001a\u00020\u0016H\u0002J\u0010\u0010.\u001a\u00020\u00162\u0006\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u00020\u0016H\u0016J\b\u00102\u001a\u00020\u0016H\u0016J\b\u00103\u001a\u00020\u0016H\u0016J\b\u00104\u001a\u00020\u0016H\u0002J\b\u00105\u001a\u00020\u0016H\u0016J\u0018\u00106\u001a\u00020\u00162\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\bH\u0016J\b\u00109\u001a\u00020\u0016H\u0014J\u0010\u0010:\u001a\u00020\u00162\u0006\u0010;\u001a\u00020\bH\u0016J\u001c\u0010<\u001a\u00020\u00162\b\u0010=\u001a\u0004\u0018\u00010!2\b\u0010>\u001a\u0004\u0018\u00010!H\u0016J\u001c\u0010?\u001a\u00020\u00162\b\u0010=\u001a\u0004\u0018\u00010!2\b\u0010>\u001a\u0004\u0018\u00010@H\u0016J\u0012\u0010A\u001a\u00020\u00162\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\u0010\u0010D\u001a\u00020\u00162\u0006\u0010E\u001a\u000200H\u0016J\u001c\u0010F\u001a\u00020\u00162\b\u0010=\u001a\u0004\u0018\u00010!2\b\u0010>\u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010G\u001a\u00020\u00162\b\u0010H\u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010I\u001a\u00020\u00162\u0006\u0010J\u001a\u00020KH\u0016J6\u0010L\u001a\u00020\u00162\b\u0010M\u001a\u0004\u0018\u00010!2\"\u0010N\u001a\u001e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0Oj\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!`PH\u0016J\u0010\u0010Q\u001a\u00020\u00162\u0006\u0010R\u001a\u00020\bH\u0016J\u0010\u0010S\u001a\u00020\u00162\u0006\u0010T\u001a\u00020\bH\u0016J\u0012\u0010U\u001a\u00020\u00162\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010V\u001a\u00020\u0016H\u0016J\b\u0010W\u001a\u00020\u0016H\u0016J\u001a\u0010X\u001a\u0002002\b\u0010Y\u001a\u0004\u0018\u00010Z2\u0006\u0010[\u001a\u00020KH\u0016J\u0012\u0010\\\u001a\u00020]2\b\u0010^\u001a\u0004\u0018\u00010_H\u0014J\u0006\u0010`\u001a\u000200J\u0012\u0010a\u001a\u00020\u00162\b\u0010H\u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010b\u001a\u0002002\u0006\u0010c\u001a\u00020!H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000¨\u0006e"}, d2 = {"Lcom/baidu/searchbox/player/kernel/YYVideoKernel;", "Lcom/baidu/searchbox/player/kernel/AbsVideoKernel;", "()V", "container", "Landroid/widget/FrameLayout;", "converter", "Lcom/baidu/searchbox/player/kernel/YYKernelInfoConverter;", "corePoolSize", "", "cpuCount", "keepAliveSeconds", "", "maximumPoolSize", "screenShotPoolExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "getScreenShotPoolExecutor", "()Ljava/util/concurrent/ThreadPoolExecutor;", "screenShotPoolExecutor$delegate", "Lkotlin/Lazy;", "yyKernel", "Lcom/yy/transvod/player/VodPlayer;", "addPlayerViewToContainer", "", "bindUniqueKey", "getBVideoView", "Landroid/view/View;", "getBufferingPosition", "getDecodeMode", "getDuration", "getDurationMs", "getKernelMediaInfo", "Lcom/baidu/searchbox/player/model/KernelMediaInfo;", "getKernelType", "", "getMediaRuntimeInfo", "runtimeInfoListener", "Lcom/baidu/searchbox/player/interfaces/OnMediaRuntimeInfoListener;", "getPlayedTime", "getPosition", "getPositionMs", "getSyncPositionMs", "getVideoHeight", "getVideoWidth", "getYYDecodeMode", "yyCodec", "initYYKernel", "mute", "isMute", "", "onInit", "onRelease", DownloadStatisticConstants.UBC_TYPE_PAUSE, "removeUniqueKey", DownloadStatisticConstants.UBC_TYPE_RESUME, "seekToMs", "pos", "seekMode", "setDataSourceAndPrepare", "setDecodeMode", "mode", "setDynamicOption", "key", "value", "setExternalInfo", "", "setKernelCallBack", "callBack", "Lcom/baidu/searchbox/player/kernel/IKernelPlayer;", "setLooping", "loop", "setOption", "setProxy", cl.c, "setSpeed", "i", "", "setVideoFormatOptions", "format", "options", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "setVideoRotation", "rotate", "setVideoScalingMode", "scalingMode", "setYYKernelCallback", "start", "stop", "takeSnapshotAsync", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/baidu/searchbox/player/interfaces/OnSnapShotFrameListener;", "scale", "transformVideoUrlModel", "Lcom/baidu/searchbox/player/model/VideoUrlModel;", "series", "Lcom/baidu/searchbox/player/model/BasicVideoSeries;", "tryReuseOrCreateYYKernel", "updateFreeProxy", SmsLoginView.f.j, "type", "Companion", "yykernel-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class YYVideoKernel extends AbsVideoKernel {
    public static final String KERNEL_TYPE_YY = "KERNEL_TYPE_YY";
    public FrameLayout container;
    public final YYKernelInfoConverter converter = new YYKernelInfoConverter(this, null, 2, null);
    public final int corePoolSize;
    public final int cpuCount;
    public final long keepAliveSeconds;
    public final int maximumPoolSize;
    public final Lazy screenShotPoolExecutor$delegate;
    public uhc yyKernel;
    public static final Companion Companion = new Companion(null);
    public static final thc options = new thc();

    private final int getYYDecodeMode(int i) {
        if (i != 0) {
            return i != 1 ? 0 : 2;
        }
        return 1;
    }

    @JvmStatic
    public static final void installLib() {
        Companion.installLib();
    }

    @JvmStatic
    public static final boolean isLibReady() {
        return Companion.isLibReady();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public KernelMediaInfo getKernelMediaInfo() {
        return null;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public String getKernelType() {
        return KERNEL_TYPE_YY;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void getMediaRuntimeInfo(OnMediaRuntimeInfoListener onMediaRuntimeInfoListener) {
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getPlayedTime() {
        return 0;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setDecodeMode(int i) {
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setDynamicOption(String str, String str2) {
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setExternalInfo(String str, Object obj) {
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setOption(String str, String str2) {
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setProxy(String str) {
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setSpeed(float f) {
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setVideoFormatOptions(String str, HashMap<String, String> options2) {
        Intrinsics.checkNotNullParameter(options2, "options");
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void updateFreeProxy(String str) {
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/player/kernel/YYVideoKernel$Companion;", "", "()V", YYVideoKernel.KERNEL_TYPE_YY, "", "options", "Lcom/yy/transvod/player/PlayerOptions;", "createYYKernel", "Lcom/yy/transvod/player/VodPlayer;", "installLib", "", "isLibReady", "", "yykernel-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }

        public final uhc createYYKernel() {
            YYVideoKernel.options.b = 1;
            YYVideoKernel.options.c = 1;
            YYVideoKernel.options.g = true;
            YYVideoKernel.options.m = true ^ DeviceUtil.is64BitABIs();
            uhc.s(false);
            return new uhc(BDPlayerConfig.getAppContext(), YYVideoKernel.options);
        }

        @JvmStatic
        public final void installLib() {
            if (!isLibReady()) {
                uhc.k(BDPlayerConfig.getAppContext(), null);
            }
        }

        @JvmStatic
        public final boolean isLibReady() {
            return uhc.l(BDPlayerConfig.getAppContext());
        }
    }

    private final void bindUniqueKey() {
        String playerKey = PlayerRuntime.toPlayerKey(getVideoUrlModel().getVid());
        vhc b = vhc.b();
        uhc uhcVar = this.yyKernel;
        if (uhcVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yyKernel");
            uhcVar = null;
        }
        b.a(playerKey, uhcVar);
    }

    private final ThreadPoolExecutor getScreenShotPoolExecutor() {
        return (ThreadPoolExecutor) this.screenShotPoolExecutor$delegate.getValue();
    }

    private final void initYYKernel() {
        this.container = new FrameLayout(BDPlayerConfig.getAppContext());
        this.yyKernel = Companion.createYYKernel();
    }

    private final void removeUniqueKey() {
        vhc.b().d(PlayerRuntime.toPlayerKey(getVideoUrlModel().getVid()));
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public View getBVideoView() {
        FrameLayout frameLayout = this.container;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
            return null;
        }
        return frameLayout;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getBufferingPosition() {
        return this.converter.getBufferingPosition();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getDecodeMode() {
        return getYYDecodeMode(options.c);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getDuration() {
        uhc uhcVar = this.yyKernel;
        if (uhcVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yyKernel");
            uhcVar = null;
        }
        return (int) uhcVar.e();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getDurationMs() {
        uhc uhcVar = this.yyKernel;
        if (uhcVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yyKernel");
            uhcVar = null;
        }
        return (int) uhcVar.e();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getPosition() {
        uhc uhcVar = this.yyKernel;
        if (uhcVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yyKernel");
            uhcVar = null;
        }
        return ((int) uhcVar.c()) / 1000;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getPositionMs() {
        uhc uhcVar = this.yyKernel;
        if (uhcVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yyKernel");
            uhcVar = null;
        }
        return (int) uhcVar.c();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getSyncPositionMs() {
        uhc uhcVar = this.yyKernel;
        if (uhcVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yyKernel");
            uhcVar = null;
        }
        return (int) uhcVar.c();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getVideoHeight() {
        uhc uhcVar = this.yyKernel;
        if (uhcVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yyKernel");
            uhcVar = null;
        }
        return uhcVar.i();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getVideoWidth() {
        uhc uhcVar = this.yyKernel;
        if (uhcVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yyKernel");
            uhcVar = null;
        }
        return uhcVar.j();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel, com.baidu.searchbox.player.pool.IPoolItem
    public void onInit() {
        super.onInit();
        addPlayerViewToContainer();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel, com.baidu.searchbox.player.pool.IPoolItem
    public void onRelease() {
        super.onRelease();
        uhc uhcVar = this.yyKernel;
        if (uhcVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yyKernel");
            uhcVar = null;
        }
        uhcVar.H();
        setKernelCallBack(null);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void pause() {
        super.pause();
        uhc uhcVar = this.yyKernel;
        if (uhcVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yyKernel");
            uhcVar = null;
        }
        uhcVar.m();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void resume() {
        super.resume();
        uhc uhcVar = this.yyKernel;
        if (uhcVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yyKernel");
            uhcVar = null;
        }
        uhcVar.o();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void start() {
        super.start();
        bindUniqueKey();
        uhc uhcVar = this.yyKernel;
        if (uhcVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yyKernel");
            uhcVar = null;
        }
        uhcVar.G();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void stop() {
        removeUniqueKey();
        super.stop();
        uhc uhcVar = this.yyKernel;
        if (uhcVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yyKernel");
            uhcVar = null;
        }
        uhcVar.H();
    }

    public final boolean tryReuseOrCreateYYKernel() {
        uhc uhcVar;
        uhc c = vhc.b().c(PlayerRuntime.toPlayerKey(getVideoUrlModel().getVid()), false);
        if (c == null) {
            uhcVar = Companion.createYYKernel();
        } else {
            uhcVar = c;
        }
        this.yyKernel = uhcVar;
        addPlayerViewToContainer();
        if (c == null) {
            return false;
        }
        return true;
    }

    public YYVideoKernel() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        this.cpuCount = availableProcessors;
        this.maximumPoolSize = (availableProcessors * 2) + 1;
        this.corePoolSize = Math.max(2, Math.min(availableProcessors - 1, 4));
        this.keepAliveSeconds = 30L;
        this.screenShotPoolExecutor$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ThreadPoolExecutor>() { // from class: com.baidu.searchbox.player.kernel.YYVideoKernel$screenShotPoolExecutor$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final ThreadPoolExecutor invoke() {
                int i;
                int i2;
                long j;
                i = YYVideoKernel.this.corePoolSize;
                i2 = YYVideoKernel.this.maximumPoolSize;
                j = YYVideoKernel.this.keepAliveSeconds;
                return new ThreadPoolExecutor(i, i2, j, TimeUnit.SECONDS, new LinkedBlockingDeque());
            }
        });
        initYYKernel();
    }

    private final void addPlayerViewToContainer() {
        View view2;
        ViewGroup viewGroup;
        FrameLayout frameLayout = this.container;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
            frameLayout = null;
        }
        frameLayout.removeAllViews();
        uhc uhcVar = this.yyKernel;
        if (uhcVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yyKernel");
            uhcVar = null;
        }
        Object g = uhcVar.g();
        if (g instanceof View) {
            view2 = (View) g;
        } else {
            view2 = null;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.removeView(view2);
            }
            FrameLayout frameLayout3 = this.container;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("container");
            } else {
                frameLayout2 = frameLayout3;
            }
            frameLayout2.addView(view2, -1, -1);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void mute(boolean z) {
        uhc uhcVar = null;
        if (z) {
            uhc uhcVar2 = this.yyKernel;
            if (uhcVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("yyKernel");
            } else {
                uhcVar = uhcVar2;
            }
            uhcVar.n();
            return;
        }
        uhc uhcVar3 = this.yyKernel;
        if (uhcVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yyKernel");
        } else {
            uhcVar = uhcVar3;
        }
        uhcVar.p();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setKernelCallBack(IKernelPlayer iKernelPlayer) {
        this.converter.setKernelCallback(iKernelPlayer);
        if (iKernelPlayer != null) {
            setYYKernelCallback(this.converter);
        } else {
            setYYKernelCallback(null);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setLooping(boolean z) {
        int i;
        uhc uhcVar = this.yyKernel;
        if (uhcVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yyKernel");
            uhcVar = null;
        }
        if (z) {
            i = -1;
        } else {
            i = 0;
        }
        uhcVar.w(i);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setVideoRotation(int i) {
        int i2;
        if (i != 90) {
            if (i != 180) {
                if (i != 270) {
                    i2 = 0;
                } else {
                    i2 = 3;
                }
            } else {
                i2 = 2;
            }
        } else {
            i2 = 1;
        }
        uhc uhcVar = this.yyKernel;
        if (uhcVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yyKernel");
            uhcVar = null;
        }
        uhcVar.F(i2);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setVideoScalingMode(int i) {
        int i2;
        switch (i) {
            case 0:
            case 2:
            case 7:
            case 8:
            case 9:
            case 10:
                i2 = 2;
                break;
            case 1:
            case 6:
            default:
                i2 = 0;
                break;
            case 3:
            case 4:
            case 5:
                i2 = 1;
                break;
        }
        uhc uhcVar = this.yyKernel;
        if (uhcVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yyKernel");
            uhcVar = null;
        }
        uhcVar.v(i2);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel, com.baidu.searchbox.player.pool.IPoolItem
    public boolean verify(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return Intrinsics.areEqual(KERNEL_TYPE_YY, type);
    }

    private final void setYYKernelCallback(YYKernelInfoConverter yYKernelInfoConverter) {
        uhc uhcVar = this.yyKernel;
        uhc uhcVar2 = null;
        if (uhcVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yyKernel");
            uhcVar = null;
        }
        uhcVar.D(yYKernelInfoConverter);
        uhc uhcVar3 = this.yyKernel;
        if (uhcVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yyKernel");
            uhcVar3 = null;
        }
        uhcVar3.B(yYKernelInfoConverter);
        uhc uhcVar4 = this.yyKernel;
        if (uhcVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yyKernel");
            uhcVar4 = null;
        }
        uhcVar4.z(yYKernelInfoConverter);
        uhc uhcVar5 = this.yyKernel;
        if (uhcVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yyKernel");
            uhcVar5 = null;
        }
        uhcVar5.E(yYKernelInfoConverter);
        uhc uhcVar6 = this.yyKernel;
        if (uhcVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yyKernel");
            uhcVar6 = null;
        }
        uhcVar6.D(yYKernelInfoConverter);
        uhc uhcVar7 = this.yyKernel;
        if (uhcVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yyKernel");
            uhcVar7 = null;
        }
        uhcVar7.C(yYKernelInfoConverter);
        uhc uhcVar8 = this.yyKernel;
        if (uhcVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yyKernel");
            uhcVar8 = null;
        }
        uhcVar8.y(yYKernelInfoConverter);
        uhc uhcVar9 = this.yyKernel;
        if (uhcVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yyKernel");
            uhcVar9 = null;
        }
        uhcVar9.A(yYKernelInfoConverter);
        uhc uhcVar10 = this.yyKernel;
        if (uhcVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yyKernel");
        } else {
            uhcVar2 = uhcVar10;
        }
        uhcVar2.x(Executors.newSingleThreadExecutor(), yYKernelInfoConverter);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void seekToMs(int i, int i2) {
        uhc uhcVar = this.yyKernel;
        if (uhcVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yyKernel");
            uhcVar = null;
        }
        uhcVar.r(i);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public boolean takeSnapshotAsync(final OnSnapShotFrameListener onSnapShotFrameListener, float f) {
        if (onSnapShotFrameListener != null) {
            uhc uhcVar = this.yyKernel;
            if (uhcVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("yyKernel");
                uhcVar = null;
            }
            uhcVar.q(getScreenShotPoolExecutor(), new uhc.d() { // from class: com.baidu.tieba.gj1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.uhc.d
                public final void a(Bitmap bitmap) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, bitmap) == null) {
                        OnSnapShotFrameListener.this.onSnapShotComplete(bitmap);
                    }
                }
            });
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setDataSourceAndPrepare() {
        int i;
        boolean z;
        int i2;
        VideoUrlModel videoUrlModel = getVideoUrlModel();
        Intrinsics.checkNotNullExpressionValue(videoUrlModel, "getVideoUrlModel<VideoUrlModel>()");
        Number number = 0;
        Object obj = videoUrlModel.getExtBundle().get((Object) YYOption.UrlProtocol.KEY);
        if (obj instanceof Integer) {
            number = obj;
        }
        int intValue = number.intValue();
        Number number2 = 1;
        Object obj2 = videoUrlModel.getExtBundle().get((Object) YYOption.SourceFormat.KEY);
        if (obj2 instanceof Integer) {
            number2 = obj2;
        }
        int intValue2 = number2.intValue();
        Number number3 = 1;
        Object obj3 = videoUrlModel.getExtBundle().get((Object) YYOption.CachePolicy.KEY);
        if (obj3 instanceof Integer) {
            number3 = obj3;
        }
        int intValue3 = number3.intValue();
        Boolean bool = Boolean.FALSE;
        Object obj4 = videoUrlModel.getExtBundle().get((Object) YYOption.IsLive.KEY);
        if (obj4 instanceof Boolean) {
            bool = obj4;
        }
        boolean booleanValue = bool.booleanValue();
        if (YYUtil.isLiveUrl(getVideoUrl())) {
            i2 = 2;
            i = 2;
            z = true;
        } else {
            i = intValue3;
            z = booleanValue;
            i2 = intValue2;
        }
        Number number4 = 10;
        Object obj5 = videoUrlModel.getExtBundle().get((Object) YYOption.CachePolicy.BUFFER_SIZE_KEY);
        if (obj5 instanceof Integer) {
            number4 = obj5;
        }
        int intValue4 = number4.intValue();
        zgc zgcVar = new zgc(getVideoUrl(), intValue, i2, i, z);
        zgcVar.n(intValue4);
        Object obj6 = videoUrlModel.getExtBundle().get((Object) YYOption.ROOM_ID);
        String str = "";
        if (!(obj6 instanceof String)) {
            obj6 = "";
        }
        String str2 = (String) obj6;
        Object obj7 = videoUrlModel.getExtBundle().get((Object) "yyuid");
        if (obj7 instanceof String) {
            str = obj7;
        }
        zgcVar.g().b(str2, str);
        uhc uhcVar = this.yyKernel;
        if (uhcVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yyKernel");
            uhcVar = null;
        }
        uhcVar.u(zgcVar);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public VideoUrlModel transformVideoUrlModel(BasicVideoSeries basicVideoSeries) {
        VideoUrlModel videoUrlModel = new VideoUrlModel(null, null, false, 0, null, false, 63, null);
        if (basicVideoSeries != null) {
            videoUrlModel.setVid(basicVideoSeries.getVid());
            videoUrlModel.setVideoUrl(basicVideoSeries.getPlayUrl());
            videoUrlModel.setNeedPrepare(basicVideoSeries.isNeedPrepare());
            videoUrlModel.setPlayerStageType(basicVideoSeries.getPlayerStageType());
            videoUrlModel.setOption(YYOption.CachePolicy.BUFFER_SIZE_KEY, Integer.valueOf(YYUtil.getYYBufferSize(basicVideoSeries)));
            String extLog = basicVideoSeries.getExtLog();
            if (extLog != null) {
                try {
                    JSONObject jSONObject = new JSONObject(extLog);
                    videoUrlModel.setOption(YYOption.ROOM_ID, jSONObject.optString(YYOption.ROOM_ID));
                    videoUrlModel.setOption("yyuid", jSONObject.optString("yyuid"));
                } catch (Exception e) {
                    BdVideoLog.e(e.getMessage());
                }
            }
        }
        return videoUrlModel;
    }
}
