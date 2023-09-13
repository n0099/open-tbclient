package com.baidu.searchbox.perfframe.impl;

import android.content.Context;
import android.util.Log;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.aperf.param.CommonUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.perfframe.ioc.IPerfFrameCallBack;
import com.baidu.searchbox.perfframe.ioc.IPerfFrameRegister;
import com.baidu.searchbox.track.Track;
import com.baidu.tieba.pk1;
@Autowired
/* loaded from: classes4.dex */
public class PerfFrameContext {
    public static final IPerfFrameCallBack PERFFRAME_CONTEXT_DEFAULT = new IPerfFrameCallBack() { // from class: com.baidu.searchbox.perfframe.impl.PerfFrameContext.1
        @Override // com.baidu.searchbox.perfframe.ioc.IPerfFrameCallBack
        public void onPerfFrameCallBack(Context context, PerfExpInfo perfExpInfo) {
            if (AppConfig.isDebug()) {
                Log.d("PerfFrame", "onPerfFrameCallBack");
            }
            pk1<IPerfFrameRegister> perfFrameRegister = PerfFrameRuntime.getInstance().getPerfFrameRegister();
            if (perfFrameRegister != null && perfFrameRegister.getList() != null && perfExpInfo != null) {
                if (AppConfig.isDebug()) {
                    Log.i("PerfFrame", "perfExpInfo = " + perfExpInfo.toString());
                }
                perfExpInfo.setTrackUIs(Track.getInstance().getAllTrackUIs());
                perfExpInfo.setLogId(CommonUtils.getLogId());
                for (IPerfFrameRegister iPerfFrameRegister : perfFrameRegister.getList()) {
                    iPerfFrameRegister.onEvent(context, perfExpInfo);
                }
            }
        }
    };

    @Inject(force = false)
    public static IPerfFrameCallBack getPerfFrameContext() {
        return PERFFRAME_CONTEXT_DEFAULT;
    }
}
