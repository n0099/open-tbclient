package com.baidu.searchbox.fluency.config;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000:\u0001\u0013B\t\b\u0016¢\u0006\u0004\b\u000f\u0010\u0010B\u0011\b\u0000\u0012\u0006\u0010\u0011\u001a\u00020\u0001¢\u0006\u0004\b\u000f\u0010\u0012J\u000f\u0010\u0002\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0005\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0006\u001a\u0004\b\b\u0010\u0007R\u0019\u0010\t\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\t\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/fluency/config/BdTracesConfig;", "Lcom/baidu/searchbox/fluency/config/BdTracesConfig$Builder;", "newBuilder", "()Lcom/baidu/searchbox/fluency/config/BdTracesConfig$Builder;", "", "isDebug", "Z", "()Z", "isDevEnv", "isFpsEnable", "", "timeSliceMs", "I", "getTimeSliceMs", "()I", "<init>", "()V", "builder", "(Lcom/baidu/searchbox/fluency/config/BdTracesConfig$Builder;)V", "Builder", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class BdTracesConfig {
    public final boolean isDebug;
    public final boolean isDevEnv;
    public final boolean isFpsEnable;
    public final int timeSliceMs;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u0000B\u0011\b\u0010\u0012\u0006\u0010\u001d\u001a\u00020\u0001¢\u0006\u0004\b\u001e\u0010\u001fB\u0007¢\u0006\u0004\b\u001e\u0010 J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\u0007J\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0005\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\b\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\"\u0010\n\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\"\u0010\r\u001a\u00020\f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/baidu/searchbox/fluency/config/BdTracesConfig$Builder;", "Lcom/baidu/searchbox/fluency/config/BdTracesConfig;", "build", "()Lcom/baidu/searchbox/fluency/config/BdTracesConfig;", "", "isDebug", "debug", "(Z)Lcom/baidu/searchbox/fluency/config/BdTracesConfig$Builder;", "isDevEnv", "devEnv", "isFpsEnable", "fpsEnable", "", "timeSliceMs", "(I)Lcom/baidu/searchbox/fluency/config/BdTracesConfig$Builder;", "Z", "isDebug$lib_fps_release", "()Z", "setDebug$lib_fps_release", "(Z)V", "isDevEnv$lib_fps_release", "setDevEnv$lib_fps_release", "isFpsEnable$lib_fps_release", "setFpsEnable$lib_fps_release", "I", "getTimeSliceMs$lib_fps_release", "()I", "setTimeSliceMs$lib_fps_release", "(I)V", "config", "<init>", "(Lcom/baidu/searchbox/fluency/config/BdTracesConfig;)V", "()V", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Builder {
        public boolean isDebug;
        public boolean isDevEnv;
        public boolean isFpsEnable;
        public int timeSliceMs;

        public Builder() {
            this.timeSliceMs = 10000;
        }

        public final BdTracesConfig build() {
            return new BdTracesConfig(this);
        }

        public final int getTimeSliceMs$lib_fps_release() {
            return this.timeSliceMs;
        }

        public final boolean isDebug$lib_fps_release() {
            return this.isDebug;
        }

        public final boolean isDevEnv$lib_fps_release() {
            return this.isDevEnv;
        }

        public final boolean isFpsEnable$lib_fps_release() {
            return this.isFpsEnable;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(BdTracesConfig config) {
            this();
            Intrinsics.checkNotNullParameter(config, "config");
            this.isFpsEnable = config.isFpsEnable();
            this.isDebug = config.isDebug();
            this.isDevEnv = config.isDevEnv();
            this.timeSliceMs = config.getTimeSliceMs();
        }

        public final Builder debug(boolean z) {
            this.isDebug = z;
            return this;
        }

        public final Builder devEnv(boolean z) {
            this.isDevEnv = z;
            return this;
        }

        public final Builder fpsEnable(boolean z) {
            this.isFpsEnable = z;
            return this;
        }

        public final void setDebug$lib_fps_release(boolean z) {
            this.isDebug = z;
        }

        public final void setDevEnv$lib_fps_release(boolean z) {
            this.isDevEnv = z;
        }

        public final void setFpsEnable$lib_fps_release(boolean z) {
            this.isFpsEnable = z;
        }

        public final void setTimeSliceMs$lib_fps_release(int i) {
            this.timeSliceMs = i;
        }

        public final Builder timeSliceMs(int i) {
            this.timeSliceMs = i;
            return this;
        }
    }

    public BdTracesConfig() {
        this(new Builder());
    }

    public final int getTimeSliceMs() {
        return this.timeSliceMs;
    }

    public final boolean isDebug() {
        return this.isDebug;
    }

    public final boolean isDevEnv() {
        return this.isDevEnv;
    }

    public final boolean isFpsEnable() {
        return this.isFpsEnable;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public BdTracesConfig(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.isFpsEnable = builder.isFpsEnable$lib_fps_release();
        this.isDebug = builder.isDebug$lib_fps_release();
        this.isDevEnv = builder.isDevEnv$lib_fps_release();
        this.timeSliceMs = builder.getTimeSliceMs$lib_fps_release();
    }
}
