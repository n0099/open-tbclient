package com.baidu.fsg.face.liveness.utils;

import android.content.Context;
import com.baidu.fsg.base.restnet.beans.business.core.utils.ABTestConstant;
import com.baidu.fsg.base.restnet.beans.business.core.utils.ABTestUtils;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class LivenessABTestUtil {

    /* renamed from: a  reason: collision with root package name */
    private static LivenessABTestUtil f2301a;

    /* renamed from: b  reason: collision with root package name */
    private ABTestUtils f2302b;

    private LivenessABTestUtil() {
    }

    private LivenessABTestUtil(Context context) {
        this.f2302b = new ABTestUtils(context);
    }

    public static synchronized LivenessABTestUtil getInstance(Context context) {
        LivenessABTestUtil livenessABTestUtil;
        synchronized (LivenessABTestUtil.class) {
            if (f2301a == null) {
                f2301a = new LivenessABTestUtil(context);
            }
            livenessABTestUtil = f2301a;
        }
        return livenessABTestUtil;
    }

    public static synchronized void cleanInstance() {
        synchronized (LivenessABTestUtil.class) {
            f2301a = null;
        }
    }

    public boolean isWhiteBgEnable() {
        if (this.f2302b != null) {
            return "1".equals(this.f2302b.getABTestValueString("1", ABTestConstant.LIVENESS_BG_STYLE_EXP_KEY_LIVENESS_BG_STYLE, "0"));
        }
        return false;
    }

    public JSONObject getLivenessBgStyleABTestContent() {
        return this.f2302b != null ? this.f2302b.getABTestStatistics("1", ABTestConstant.LIVENESS_BG_STYLE_EXP_KEY_LIVENESS_BG_STYLE, "0") : new JSONObject();
    }
}
