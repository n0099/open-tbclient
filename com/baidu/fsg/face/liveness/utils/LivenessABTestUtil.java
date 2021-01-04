package com.baidu.fsg.face.liveness.utils;

import android.content.Context;
import com.baidu.fsg.base.restnet.beans.business.core.utils.ABTestConstant;
import com.baidu.fsg.base.restnet.beans.business.core.utils.ABTestUtils;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class LivenessABTestUtil {

    /* renamed from: a  reason: collision with root package name */
    private static LivenessABTestUtil f2352a;

    /* renamed from: b  reason: collision with root package name */
    private ABTestUtils f2353b;

    private LivenessABTestUtil() {
    }

    private LivenessABTestUtil(Context context) {
        this.f2353b = new ABTestUtils(context);
    }

    public static synchronized LivenessABTestUtil getInstance(Context context) {
        LivenessABTestUtil livenessABTestUtil;
        synchronized (LivenessABTestUtil.class) {
            if (f2352a == null) {
                f2352a = new LivenessABTestUtil(context);
            }
            livenessABTestUtil = f2352a;
        }
        return livenessABTestUtil;
    }

    public static synchronized void cleanInstance() {
        synchronized (LivenessABTestUtil.class) {
            f2352a = null;
        }
    }

    public boolean isWhiteBgEnable() {
        if (this.f2353b != null) {
            return "1".equals(this.f2353b.getABTestValueString("1", ABTestConstant.LIVENESS_BG_STYLE_EXP_KEY_LIVENESS_BG_STYLE, "0"));
        }
        return false;
    }

    public JSONObject getLivenessBgStyleABTestContent() {
        return this.f2353b != null ? this.f2353b.getABTestStatistics("1", ABTestConstant.LIVENESS_BG_STYLE_EXP_KEY_LIVENESS_BG_STYLE, "0") : new JSONObject();
    }
}
