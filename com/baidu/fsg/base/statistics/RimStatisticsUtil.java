package com.baidu.fsg.base.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.fsg.base.statistics.StatService;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.base.utils.ResUtils;
import java.util.ArrayList;
import java.util.Collection;
/* loaded from: classes16.dex */
public final class RimStatisticsUtil {
    private static final String TAG = "logsender";
    private static boolean mInited = false;
    private static Context sAppContext;
    private boolean hasInit;
    private r mHttpImpl;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static RimStatisticsUtil f1483a = new RimStatisticsUtil();

        private a() {
        }
    }

    public static RimStatisticsUtil getInstance() {
        return a.f1483a;
    }

    private RimStatisticsUtil() {
    }

    public static void initStatisticsModule(Context context) {
        if (cacheAppContext(context)) {
            RimStatisticsUtil rimStatisticsUtil = getInstance();
            try {
                if (!rimStatisticsUtil.hasInit) {
                    rimStatisticsUtil.hasInit = true;
                    d.a().a(context);
                    initData();
                }
            } catch (Exception e) {
            }
        }
    }

    public boolean isReleaseVersion() {
        return true;
    }

    public String getSignKey() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getSignKey1());
        stringBuffer.append(getSignKey2());
        stringBuffer.append(getSignKey3());
        return RimArmor.getInstance().localDecryptProxy(stringBuffer.toString());
    }

    private String getSignKey1() {
        return com.baidu.fsg.base.a.h;
    }

    private String getSignKey3() {
        return "G4Ytg9bd7jt7sJG9sGf";
    }

    private String getSignKey2() {
        return ResUtils.getString(sAppContext, "rim_base_asdasdasd_assdadsads");
    }

    public void triggerSending() {
        LogUtil.d(TAG, "=====triggerSending====");
        l.a().a(b.p);
        l.a().a(b.o);
    }

    private static boolean cacheAppContext(Context context) {
        if (sAppContext == null && context != null) {
            sAppContext = context;
        }
        return sAppContext != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context getAppContext() {
        return sAppContext;
    }

    public static void onIn(String str, long j) {
        try {
            if (0 < j) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Long.toString(j));
                StatService.a(str, StatService.ETag.in, arrayList);
            } else {
                StatService.a(str, StatService.ETag.in, (Collection<String>) null);
            }
        } catch (Exception e) {
        }
    }

    public static void onOut(String str) {
        try {
            StatService.a(str, StatService.ETag.out, (Collection<String>) null);
        } catch (Exception e) {
        }
    }

    public static void onPush(String str) {
        try {
            StatService.a(str, StatService.ETag.push, (Collection<String>) null);
        } catch (Exception e) {
        }
    }

    public static void onBack(String str) {
        try {
            StatService.a(str, StatService.ETag.back, (Collection<String>) null);
        } catch (Exception e) {
        }
    }

    public static void onEvent(String str) {
        onEventWithValues(str, null);
    }

    public static void onEventWithValue(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            try {
                StatService.a(str, (String) null, str2);
            } catch (Exception e) {
            }
        }
    }

    public static void onEventWithValues(String str, Collection<String> collection) {
        try {
            StatService.a(str, (String) null, collection);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.d(TAG, e.toString());
        }
    }

    public static void onEventStart(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                StatService.a(str);
            } catch (Exception e) {
            }
        }
    }

    public static void onEventEnd(String str, int i) {
        onEventEndWithValue(str, i, null);
    }

    public static void onEventEndWithValue(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str)) {
            try {
                StatService.b(str, Integer.toString(i), str2);
            } catch (Exception e) {
            }
        }
    }

    public static void onEventEndWithValues(String str, int i, Collection<String> collection) {
        if (!TextUtils.isEmpty(str)) {
            try {
                StatService.b(str, Integer.toString(i), collection);
            } catch (Exception e) {
            }
        }
    }

    private static boolean initData() {
        if (mInited) {
            return false;
        }
        mInited = true;
        f.a().b();
        return true;
    }
}
