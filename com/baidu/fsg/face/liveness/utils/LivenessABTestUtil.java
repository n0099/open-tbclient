package com.baidu.fsg.face.liveness.utils;

import android.content.Context;
import com.baidu.fsg.base.restnet.beans.business.core.utils.ABTestConstant;
import com.baidu.fsg.base.restnet.beans.business.core.utils.ABTestUtils;
import org.json.JSONObject;
/* loaded from: classes17.dex */
public class LivenessABTestUtil {

    /* renamed from: a  reason: collision with root package name */
    private static LivenessABTestUtil f1727a;
    private ABTestUtils b;

    private LivenessABTestUtil() {
    }

    private LivenessABTestUtil(Context context) {
        this.b = new ABTestUtils(context);
    }

    public static synchronized LivenessABTestUtil getInstance(Context context) {
        LivenessABTestUtil livenessABTestUtil;
        synchronized (LivenessABTestUtil.class) {
            if (f1727a == null) {
                f1727a = new LivenessABTestUtil(context);
            }
            livenessABTestUtil = f1727a;
        }
        return livenessABTestUtil;
    }

    public static synchronized void cleanInstance() {
        synchronized (LivenessABTestUtil.class) {
            f1727a = null;
        }
    }

    public boolean isWhiteBgEnable() {
        if (this.b != null) {
            return "1".equals(this.b.getABTestValueString("1", ABTestConstant.LIVENESS_BG_STYLE_EXP_KEY_LIVENESS_BG_STYLE, "0"));
        }
        return false;
    }

    public JSONObject getLivenessBgStyleABTestContent() {
        return this.b != null ? this.b.getABTestStatistics("1", ABTestConstant.LIVENESS_BG_STYLE_EXP_KEY_LIVENESS_BG_STYLE, "0") : new JSONObject();
    }
}
