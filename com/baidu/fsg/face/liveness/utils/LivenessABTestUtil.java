package com.baidu.fsg.face.liveness.utils;

import android.content.Context;
import com.baidu.fsg.base.restnet.beans.business.core.utils.ABTestConstant;
import com.baidu.fsg.base.restnet.beans.business.core.utils.ABTestUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LivenessABTestUtil {

    /* renamed from: a  reason: collision with root package name */
    public static LivenessABTestUtil f5981a;

    /* renamed from: b  reason: collision with root package name */
    public ABTestUtils f5982b;

    public LivenessABTestUtil() {
    }

    public static synchronized void cleanInstance() {
        synchronized (LivenessABTestUtil.class) {
            f5981a = null;
        }
    }

    public static synchronized LivenessABTestUtil getInstance(Context context) {
        LivenessABTestUtil livenessABTestUtil;
        synchronized (LivenessABTestUtil.class) {
            if (f5981a == null) {
                f5981a = new LivenessABTestUtil(context);
            }
            livenessABTestUtil = f5981a;
        }
        return livenessABTestUtil;
    }

    public JSONObject getLivenessBgStyleABTestContent() {
        ABTestUtils aBTestUtils = this.f5982b;
        if (aBTestUtils != null) {
            return aBTestUtils.getABTestStatistics("1", ABTestConstant.LIVENESS_BG_STYLE_EXP_KEY_LIVENESS_BG_STYLE, "0");
        }
        return new JSONObject();
    }

    public boolean isWhiteBgEnable() {
        ABTestUtils aBTestUtils = this.f5982b;
        if (aBTestUtils != null) {
            return "1".equals(aBTestUtils.getABTestValueString("1", ABTestConstant.LIVENESS_BG_STYLE_EXP_KEY_LIVENESS_BG_STYLE, "0"));
        }
        return false;
    }

    public LivenessABTestUtil(Context context) {
        this.f5982b = new ABTestUtils(context);
    }
}
