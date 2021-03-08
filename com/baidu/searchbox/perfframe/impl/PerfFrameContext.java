package com.baidu.searchbox.perfframe.impl;

import android.content.Context;
import android.util.Log;
import com.baidu.pyramid.a.a.d;
import com.baidu.searchbox.aperf.param.CommonUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.perfframe.ioc.IPerfFrameCallBack;
import com.baidu.searchbox.perfframe.ioc.IPerfFrameRegister;
import com.baidu.searchbox.track.Track;
/* loaded from: classes6.dex */
public class PerfFrameContext {
    private static final IPerfFrameCallBack PERFFRAME_CONTEXT_DEFAULT = new IPerfFrameCallBack() { // from class: com.baidu.searchbox.perfframe.impl.PerfFrameContext.1
        @Override // com.baidu.searchbox.perfframe.ioc.IPerfFrameCallBack
        public void onPerfFrameCallBack(Context context, PerfExpInfo perfExpInfo) {
            if (AppConfig.isDebug()) {
                Log.d("PerfFrame", "onPerfFrameCallBack");
            }
            Log.d("PerfFrame", "onPerfFrameCallBack");
            d<IPerfFrameRegister> perfFrameRegister = PerfFrameRuntime.getInstance().getPerfFrameRegister();
            if (perfFrameRegister != null && perfFrameRegister.getList() != null && perfExpInfo != null) {
                if (AppConfig.isDebug()) {
                    Log.i("PerfFrame", "perfExpInfo = " + perfExpInfo.toString());
                }
                Log.i("PerfFrame", "perfExpInfo = " + perfExpInfo.toString());
                perfExpInfo.setTrackUIs(Track.getInstance().getAllTrackUIs());
                perfExpInfo.setLogId(CommonUtils.getLogId());
                for (IPerfFrameRegister iPerfFrameRegister : perfFrameRegister.getList()) {
                    iPerfFrameRegister.onEvent(context, perfExpInfo);
                }
            }
        }
    };

    public static IPerfFrameCallBack getPerfFrameContext() {
        return PERFFRAME_CONTEXT_DEFAULT;
    }
}
