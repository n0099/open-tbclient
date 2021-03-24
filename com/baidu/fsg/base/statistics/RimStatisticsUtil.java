package com.baidu.fsg.base.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.fsg.base.statistics.StatService;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.base.utils.ResUtils;
import java.util.ArrayList;
import java.util.Collection;
/* loaded from: classes2.dex */
public final class RimStatisticsUtil {
    public static final String TAG = "logsender";
    public static boolean mInited = false;
    public static Context sAppContext;
    public boolean hasInit;
    public r mHttpImpl;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static RimStatisticsUtil f5262a = new RimStatisticsUtil();
    }

    public static boolean cacheAppContext(Context context) {
        if (sAppContext == null && context != null) {
            sAppContext = context;
        }
        return sAppContext != null;
    }

    public static Context getAppContext() {
        return sAppContext;
    }

    public static RimStatisticsUtil getInstance() {
        return a.f5262a;
    }

    private String getSignKey1() {
        return com.baidu.fsg.base.a.f5111h;
    }

    private String getSignKey2() {
        return ResUtils.getString(sAppContext, "rim_base_asdasdasd_assdadsads");
    }

    private String getSignKey3() {
        return "G4Ytg9bd7jt7sJG9sGf";
    }

    public static boolean initData() {
        if (mInited) {
            return false;
        }
        mInited = true;
        f.a().b();
        return true;
    }

    public static void initStatisticsModule(Context context) {
        if (cacheAppContext(context)) {
            RimStatisticsUtil rimStatisticsUtil = getInstance();
            try {
                if (rimStatisticsUtil.hasInit) {
                    return;
                }
                rimStatisticsUtil.hasInit = true;
                d.a().a(context);
                initData();
            } catch (Exception unused) {
            }
        }
    }

    public static void onBack(String str) {
        try {
            StatService.a(str, StatService.ETag.back, (Collection<String>) null);
        } catch (Exception unused) {
        }
    }

    public static void onEvent(String str) {
        onEventWithValues(str, null);
    }

    public static void onEventEnd(String str, int i) {
        onEventEndWithValue(str, i, null);
    }

    public static void onEventEndWithValue(String str, int i, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.b(str, Integer.toString(i), str2);
        } catch (Exception unused) {
        }
    }

    public static void onEventEndWithValues(String str, int i, Collection<String> collection) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.b(str, Integer.toString(i), collection);
        } catch (Exception unused) {
        }
    }

    public static void onEventStart(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.a(str);
        } catch (Exception unused) {
        }
    }

    public static void onEventWithValue(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.a(str, (String) null, str2);
        } catch (Exception unused) {
        }
    }

    public static void onEventWithValues(String str, Collection<String> collection) {
        try {
            StatService.a(str, (String) null, collection);
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtil.d("logsender", e2.toString());
        }
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
        } catch (Exception unused) {
        }
    }

    public static void onOut(String str) {
        try {
            StatService.a(str, StatService.ETag.out, (Collection<String>) null);
        } catch (Exception unused) {
        }
    }

    public static void onPush(String str) {
        try {
            StatService.a(str, StatService.ETag.push, (Collection<String>) null);
        } catch (Exception unused) {
        }
    }

    public String getSignKey() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getSignKey1());
        stringBuffer.append(getSignKey2());
        stringBuffer.append(getSignKey3());
        return RimArmor.getInstance().localDecryptProxy(stringBuffer.toString());
    }

    public boolean isReleaseVersion() {
        return true;
    }

    public void triggerSending() {
        LogUtil.d("logsender", "=====triggerSending====");
        l.a().a("normal_log");
        l.a().a(b.o);
    }

    public RimStatisticsUtil() {
    }
}
