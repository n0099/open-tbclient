package com.baidu.searchbox.perfframe;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.perfframe.impl.PerfExpInfo;
import com.baidu.searchbox.perfframe.impl.PerfFrameContext;
import com.baidu.searchbox.perfframe.ioc.IPerfFrame;
/* loaded from: classes3.dex */
public class PerfFrame implements IPerfFrame {
    public static String TAG = "PerfFrame";
    public boolean mIsNeedDynamicperf;
    public boolean mIsNeedMainStackTrace;
    public boolean mIsNeedPageTrace;
    public boolean mIsNeedStaticperf;

    /* loaded from: classes3.dex */
    public static class Builder {
        public boolean mIsNeedDynamicperf;
        public boolean mIsNeedMainStackTrace;
        public boolean mIsNeedPageTrace;
        public boolean mIsNeedStaticperf;

        public PerfFrame create() {
            return new PerfFrame(this);
        }

        public Builder setNeedDynamicperf(boolean z) {
            this.mIsNeedDynamicperf = z;
            return this;
        }

        public Builder setNeedMainStackTrace(boolean z) {
            this.mIsNeedMainStackTrace = z;
            return this;
        }

        public Builder setNeedPageTrace(boolean z) {
            this.mIsNeedPageTrace = z;
            return this;
        }

        public Builder setNeedStaticperf(boolean z) {
            this.mIsNeedStaticperf = z;
            return this;
        }
    }

    @Override // com.baidu.searchbox.perfframe.ioc.IPerfFrame
    public void submitPerformanceData(String str, String str2, long j, long j2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        PerfExpInfo perfExpInfo = new PerfExpInfo(str, str2, j, j2, str3, str4, str5);
        perfExpInfo.setNeedDynamicperf(this.mIsNeedDynamicperf);
        perfExpInfo.setNeedStaticperf(this.mIsNeedStaticperf);
        perfExpInfo.setNeedPageTrace(this.mIsNeedPageTrace);
        perfExpInfo.setNeedMainStackTrace(this.mIsNeedMainStackTrace);
        if (AppConfig.isDebug()) {
            String str6 = TAG;
            Log.d(str6, "perfExpInfo：" + perfExpInfo.toString());
        }
        PerfFrameContext.getPerfFrameContext().onPerfFrameCallBack(AppRuntime.getAppContext(), perfExpInfo);
    }

    public PerfFrame() {
    }

    public PerfFrame(Builder builder) {
        this.mIsNeedPageTrace = builder.mIsNeedPageTrace;
        this.mIsNeedDynamicperf = builder.mIsNeedDynamicperf;
        this.mIsNeedStaticperf = builder.mIsNeedStaticperf;
        this.mIsNeedMainStackTrace = builder.mIsNeedMainStackTrace;
    }
}
