package com.baidu.searchbox.fluency;

import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.fluency.config.BdTracesConfig;
import com.baidu.searchbox.fluency.config.FpsConfigCommandListener;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.searchbox.fluency.ubc.FpsPerfSampleCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u000eJ\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/fluency/BdTracesManager;", "Lcom/baidu/searchbox/fluency/tracer/FpsTracer;", "getFpsTracer", "()Lcom/baidu/searchbox/fluency/tracer/FpsTracer;", "Lcom/baidu/searchbox/fluency/config/BdTracesConfig;", "config", "", "init", "(Lcom/baidu/searchbox/fluency/config/BdTracesConfig;)V", "", "isActiveUploadType", "()Z", "isFpsEnable", "provideDefaultTracer", "()V", "fpsTracer", "Lcom/baidu/searchbox/fluency/tracer/FpsTracer;", "Z", "isFpsCCSEnable", "tracesConfig", "Lcom/baidu/searchbox/fluency/config/BdTracesConfig;", "<init>", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class BdTracesManager {
    public static FpsTracer fpsTracer;
    public static BdTracesConfig tracesConfig;
    public static final BdTracesManager INSTANCE = new BdTracesManager();
    public static boolean isActiveUploadType = QuickPersistConfig.getInstance().getBoolean(FpsPerfSampleCallback.KEY_FPS_ACTIVE_UPLOAD, false);
    public static boolean isFpsCCSEnable = QuickPersistConfig.getInstance().getBoolean(FpsConfigCommandListener.SP_FLUENCY_FPS_SWITCHER, false);

    public final FpsTracer getFpsTracer() {
        if (fpsTracer == null) {
            provideDefaultTracer();
        }
        FpsTracer fpsTracer2 = fpsTracer;
        Intrinsics.checkNotNull(fpsTracer2);
        return fpsTracer2;
    }

    public final boolean isActiveUploadType() {
        return isActiveUploadType;
    }

    public final boolean isFpsEnable() {
        if (isActiveUploadType() && isFpsCCSEnable) {
            return true;
        }
        return false;
    }

    private final void provideDefaultTracer() {
        BdTracesConfig.Builder newBuilder = new BdTracesConfig().newBuilder();
        boolean z = true;
        if (!AppConfig.isDebug() && (!isActiveUploadType || !isFpsCCSEnable)) {
            z = false;
        }
        init(newBuilder.fpsEnable(z).debug(AppConfig.isDebug()).timeSliceMs(10000).build());
    }

    public final void init(BdTracesConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        tracesConfig = config;
        fpsTracer = new FpsTracer(config);
    }
}
