package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BDStatCore {
    public static final int INVOKE_ACT = 1;
    public static final int INVOKE_API = 0;
    public static final int INVOKE_CUSTOME = 3;
    public static final int INVOKE_FRAG = 2;
    public static BDStatCore a;
    public Handler b;
    public SessionAnalysis d;
    public EventAnalysis e;
    public Runnable f;
    public Handler i;
    public volatile boolean c = false;
    public long g = 0;
    public volatile boolean h = false;

    public void doSendNewSessionLog(Context context) {
    }

    public BDStatCore() {
        HandlerThread handlerThread = new HandlerThread("BDStatCore", 10);
        handlerThread.start();
        this.b = new Handler(handlerThread.getLooper());
        this.d = new SessionAnalysis();
        this.e = new EventAnalysis();
        HandlerThread handlerThread2 = new HandlerThread("dataAnalyzeThread");
        handlerThread2.start();
        handlerThread2.setPriority(10);
        this.i = new Handler(handlerThread2.getLooper());
    }

    private int a() {
        Class<?> cls;
        Class<?> cls2;
        Class<?> cls3;
        try {
            cls = Class.forName("android.app.Fragment");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        try {
            cls2 = Class.forName("androidx.fragment.app.Fragment");
        } catch (ClassNotFoundException unused2) {
            cls2 = null;
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i = 0; stackTrace != null && i < stackTrace.length; i++) {
            String className = stackTrace[i].getClassName();
            if (!TextUtils.isEmpty(className) && "onResume".equals(stackTrace[i].getMethodName())) {
                try {
                    cls3 = Class.forName(className);
                } catch (Throwable unused3) {
                    cls3 = null;
                }
                if (cls3 == null) {
                    continue;
                } else if (Activity.class.isAssignableFrom(cls3)) {
                    return 1;
                } else {
                    if (cls != null && cls.isAssignableFrom(cls3)) {
                        return 2;
                    }
                    if (cls2 != null && cls2.isAssignableFrom(cls3)) {
                        return 2;
                    }
                }
            }
        }
        return 3;
    }

    public void onPageStart(final Context context, final String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        init(context);
        b(context);
        final int a2 = a();
        final long currentTimeMillis = System.currentTimeMillis();
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.22
            @Override // java.lang.Runnable
            public void run() {
                bb c = bb.c();
                c.a("Start page view " + str);
                BDStatCore.this.d.onPageStart(context, str, a2, currentTimeMillis);
            }
        });
    }

    public void onResume(Activity activity, final boolean z) {
        final Context applicationContext;
        if (activity == null || (applicationContext = activity.getApplicationContext()) == null) {
            return;
        }
        init(applicationContext);
        b(applicationContext);
        final WeakReference weakReference = new WeakReference(activity);
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.2
            @Override // java.lang.Runnable
            public void run() {
                Class<?> cls;
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 == null || (cls = activity2.getClass()) == null) {
                    return;
                }
                String name = activity2.getClass().getName();
                long currentTimeMillis = System.currentTimeMillis();
                if (z) {
                    av.a().a(applicationContext, name);
                }
                if (!z) {
                    bb c = bb.c();
                    c.a("Start page view " + cls.getSimpleName());
                }
                BDStatCore.this.d.onPageStartAct(applicationContext, name, currentTimeMillis, z);
            }
        });
    }

    public void onSessionStart(final Context context, final boolean z) {
        if (context == null) {
            return;
        }
        init(context);
        b(context);
        final long currentTimeMillis = System.currentTimeMillis();
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.12
            @Override // java.lang.Runnable
            public void run() {
                BDStatCore.this.d.onSessionStart(context, currentTimeMillis, z);
            }
        });
    }

    public void onStat(final Context context, final String str) {
        if (this.d.isSessionStart()) {
            return;
        }
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.15
            @Override // java.lang.Runnable
            public void run() {
                LogSender.instance().sendEmptyLogData(context, str);
            }
        });
    }

    public void setAutoSendLog(Context context, boolean z) {
        if (context == null) {
            return;
        }
        init(context);
        b(context);
        this.d.setAutoSend(z);
    }

    public void onEvent(Context context, String str, String str2, int i, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        onEvent(context, str, str2, i, extraInfo, map, z, false);
    }

    public void onEventDuration(Context context, String str, String str2, long j, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        onEventDuration(context, str, str2, j, extraInfo, map, z, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(String str, String str2, int i, long j, Map<String, String> map, ExtraInfo extraInfo) {
        JSONObject jSONObject;
        StringBuilder sb = new StringBuilder();
        JSONObject jSONObject2 = null;
        if (map != null && map.size() != 0) {
            try {
                jSONObject = new JSONObject(map.toString());
            } catch (Exception unused) {
            }
            if (extraInfo != null) {
                jSONObject2 = extraInfo.dumpToJson();
            }
            sb.append(" eventId " + str + ", with eventLabel " + str2 + ", with acc " + i);
            if (j > 0) {
                sb.append(", with duration " + j);
            }
            if (jSONObject != null && jSONObject.length() != 0) {
                sb.append(", with attributes " + jSONObject);
            }
            if (jSONObject2 != null && jSONObject2.length() != 0) {
                sb.append(", with extraInfo " + jSONObject2);
            }
            return sb.toString();
        }
        jSONObject = null;
        if (extraInfo != null) {
        }
        sb.append(" eventId " + str + ", with eventLabel " + str2 + ", with acc " + i);
        if (j > 0) {
        }
        if (jSONObject != null) {
            sb.append(", with attributes " + jSONObject);
        }
        if (jSONObject2 != null) {
            sb.append(", with extraInfo " + jSONObject2);
        }
        return sb.toString();
    }

    private void a(Context context) {
        String appKey = CooperService.instance().getAppKey(context);
        if (!TextUtils.isEmpty(appKey)) {
            au.a(appKey);
        }
    }

    public void autoTrackSessionEndTime(final Context context) {
        if (context == null) {
            return;
        }
        init(context);
        final long currentTimeMillis = System.currentTimeMillis();
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.20
            @Override // java.lang.Runnable
            public void run() {
                BDStatCore.this.d.autoTrackSessionEndTime(context, currentTimeMillis);
            }
        });
    }

    public void autoTrackSessionStartTime(final Context context) {
        if (context == null) {
            return;
        }
        init(context);
        final long currentTimeMillis = System.currentTimeMillis();
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.19
            @Override // java.lang.Runnable
            public void run() {
                BDStatCore.this.d.autoTrackSessionStartTime(context, currentTimeMillis);
            }
        });
    }

    public void doSendLogCheck(final Context context) {
        if (context == null) {
            return;
        }
        int sessionTimeOut = this.d.getSessionTimeOut();
        Runnable runnable = new Runnable() { // from class: com.baidu.mobstat.BDStatCore.21
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (CooperService.instance().isCloseTrace()) {
                        ActivityLifeObserver.instance().clearObservers();
                        ActivityLifeObserver.instance().unRegister(context);
                    } else {
                        BDStatCore.this.d.doSendLogCheck(context, System.currentTimeMillis());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.f = runnable;
        this.b.postDelayed(runnable, sessionTimeOut);
    }

    public void init(final Context context) {
        a(context);
        if (this.c) {
            return;
        }
        ActivityLifeTask.registerActivityLifeCallback(context);
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.1
            @Override // java.lang.Runnable
            public void run() {
                if (BDStatCore.this.c) {
                    return;
                }
                PrefOperate.loadMetaDataConfig(context);
                BDStatCore.this.c = true;
            }
        });
    }

    @SuppressLint({"NewApi"})
    public void onPause(final Fragment fragment) {
        final Activity activity;
        final Context applicationContext;
        if (fragment == null || (activity = fragment.getActivity()) == null || (applicationContext = activity.getApplicationContext()) == null) {
            return;
        }
        init(applicationContext);
        final WeakReference weakReference = new WeakReference(fragment);
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.7
            @Override // java.lang.Runnable
            public void run() {
                String charSequence;
                Fragment fragment2 = (Fragment) weakReference.get();
                if (fragment2 == null || fragment2.getClass() == null) {
                    return;
                }
                String name = fragment.getClass().getName();
                String simpleName = fragment.getClass().getSimpleName();
                CharSequence title = activity.getTitle();
                if (title == null) {
                    charSequence = "";
                } else {
                    charSequence = title.toString();
                }
                String str = charSequence;
                bb c = bb.c();
                c.a("End page view " + simpleName);
                BDStatCore.this.d.onPageEndFrag(applicationContext, name, simpleName, str, System.currentTimeMillis());
            }
        });
    }

    @SuppressLint({"NewApi"})
    public void onResume(Fragment fragment) {
        Activity activity;
        final Context applicationContext;
        if (fragment == null || (activity = fragment.getActivity()) == null || (applicationContext = activity.getApplicationContext()) == null) {
            return;
        }
        init(applicationContext);
        b(applicationContext);
        final WeakReference weakReference = new WeakReference(fragment);
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.4
            @Override // java.lang.Runnable
            public void run() {
                Class<?> cls;
                Fragment fragment2 = (Fragment) weakReference.get();
                if (fragment2 == null || (cls = fragment2.getClass()) == null) {
                    return;
                }
                String name = fragment2.getClass().getName();
                long currentTimeMillis = System.currentTimeMillis();
                bb c = bb.c();
                c.a("Start page view " + cls.getSimpleName());
                BDStatCore.this.d.onPageStartFrag(applicationContext, name, currentTimeMillis);
            }
        });
    }

    public void setSessionTimeOut(int i) {
        this.d.setSessionTimeOut(i);
    }

    private void b(final Context context) {
        Handler handler;
        if (!CooperService.instance().isEnableBplus(context) || !bu.a().d() || this.h || context == null || (handler = this.i) == null) {
            return;
        }
        handler.postDelayed(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.17
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!s.b(context)) {
                        s.a(2).a(context);
                    }
                } catch (Throwable unused) {
                }
                BDStatCore.this.h = false;
            }
        }, 5000L);
        this.h = true;
    }

    public void onPause(final androidx.fragment.app.Fragment fragment) {
        final FragmentActivity activity;
        final Context applicationContext;
        if (fragment == null || (activity = fragment.getActivity()) == null || (applicationContext = activity.getApplicationContext()) == null) {
            return;
        }
        init(applicationContext);
        final WeakReference weakReference = new WeakReference(fragment);
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.6
            @Override // java.lang.Runnable
            public void run() {
                String charSequence;
                androidx.fragment.app.Fragment fragment2 = (androidx.fragment.app.Fragment) weakReference.get();
                if (fragment2 == null || fragment2.getClass() == null) {
                    return;
                }
                String name = fragment.getClass().getName();
                String simpleName = fragment.getClass().getSimpleName();
                CharSequence title = activity.getTitle();
                if (title == null) {
                    charSequence = "";
                } else {
                    charSequence = title.toString();
                }
                String str = charSequence;
                bb c = bb.c();
                c.a("End page view " + simpleName);
                BDStatCore.this.d.onPageEndFrag(applicationContext, name, simpleName, str, System.currentTimeMillis());
            }
        });
    }

    public void onResume(androidx.fragment.app.Fragment fragment) {
        FragmentActivity activity;
        final Context applicationContext;
        if (fragment == null || (activity = fragment.getActivity()) == null || (applicationContext = activity.getApplicationContext()) == null) {
            return;
        }
        init(applicationContext);
        b(applicationContext);
        final WeakReference weakReference = new WeakReference(fragment);
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.3
            @Override // java.lang.Runnable
            public void run() {
                Class<?> cls;
                androidx.fragment.app.Fragment fragment2 = (androidx.fragment.app.Fragment) weakReference.get();
                if (fragment2 == null || (cls = fragment2.getClass()) == null) {
                    return;
                }
                String name = fragment2.getClass().getName();
                long currentTimeMillis = System.currentTimeMillis();
                bb c = bb.c();
                c.a("Start page view " + cls.getSimpleName());
                BDStatCore.this.d.onPageStartFrag(applicationContext, name, currentTimeMillis);
            }
        });
    }

    private String b() {
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            if (!TextUtils.isEmpty(className)) {
                Class<?> cls = null;
                try {
                    cls = Class.forName(className);
                } catch (Throwable unused) {
                }
                if (cls != null && Activity.class.isAssignableFrom(cls)) {
                    return cls.getName();
                }
            }
        }
        return "";
    }

    public static BDStatCore instance() {
        if (a == null) {
            synchronized (BDStatCore.class) {
                if (a == null) {
                    a = new BDStatCore();
                }
            }
        }
        return a;
    }

    public void cancelSendLogCheck() {
        Runnable runnable = this.f;
        if (runnable != null) {
            this.b.removeCallbacks(runnable);
        }
        this.f = null;
    }

    public JSONObject getPageSessionHead() {
        return this.d.getPageSessionHead();
    }

    public int getSessionSize() {
        return this.d.getSessionSize();
    }

    public long getSessionStartTime() {
        return this.d.getSessionStartTime();
    }

    public void autoTrackLaunchInfo(Context context, final LaunchInfo launchInfo, final boolean z) {
        if (launchInfo == null) {
            return;
        }
        if (z) {
            this.d.autoTrackLaunchInfo(launchInfo, z);
            return;
        }
        init(context);
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.18
            @Override // java.lang.Runnable
            public void run() {
                BDStatCore.this.d.autoTrackLaunchInfo(launchInfo, z);
            }
        });
    }

    public void onPageEnd(Context context, String str, ExtraInfo extraInfo) {
        onPageEnd(context, str, extraInfo, false);
    }

    public void onPause(Activity activity, final boolean z, final ExtraInfo extraInfo) {
        final Context applicationContext;
        if (activity == null || (applicationContext = activity.getApplicationContext()) == null) {
            return;
        }
        init(applicationContext);
        final WeakReference weakReference = new WeakReference(activity);
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.5
            @Override // java.lang.Runnable
            public void run() {
                Class<?> cls;
                String charSequence;
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 == null || (cls = activity2.getClass()) == null) {
                    return;
                }
                String name = activity2.getClass().getName();
                String simpleName = activity2.getClass().getSimpleName();
                CharSequence title = activity2.getTitle();
                if (title == null) {
                    charSequence = "";
                } else {
                    charSequence = title.toString();
                }
                String str = charSequence;
                if (!z) {
                    bb c = bb.c();
                    c.a("End page view " + cls.getSimpleName());
                }
                BDStatCore.this.d.onPageEndAct(applicationContext, name, simpleName, str, System.currentTimeMillis(), z, extraInfo);
            }
        });
    }

    public void onErised(final Context context, String str, final String str2, final String str3) {
        if (this.d.isSessionStart()) {
            return;
        }
        init(context);
        final long currentTimeMillis = System.currentTimeMillis();
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.16
            @Override // java.lang.Runnable
            public void run() {
                DataCore.instance().init(context);
                EventAnalysis eventAnalysis = BDStatCore.this.e;
                Context context2 = context;
                long j = currentTimeMillis;
                eventAnalysis.onEvent(context2, j, str2, str3, 1, j, null, null, false);
                DataCore.instance().saveLogData(context, true, false, currentTimeMillis, false);
                if (currentTimeMillis - BDStatCore.this.g > 30000 && bw.o(context)) {
                    LogSender.instance().onSend(context);
                    BDStatCore.this.g = currentTimeMillis;
                }
            }
        });
    }

    public void onEventStart(final Context context, final String str, final String str2, final boolean z) {
        if (context == null) {
            return;
        }
        init(context);
        b(context);
        final long currentTimeMillis = System.currentTimeMillis();
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.11
            @Override // java.lang.Runnable
            public void run() {
                String str3 = str2;
                if (TextUtils.isEmpty(str3)) {
                    str3 = "";
                }
                BDStatCore.this.d.onSessionStart(context, currentTimeMillis, z);
                bb.c().a("Start event" + BDStatCore.this.a(str, str3, 1, -1L, null, null));
                BDStatCore.this.e.onEventStart(context, str, str3, currentTimeMillis);
            }
        });
    }

    public void onPageEnd(final Context context, final String str, final ExtraInfo extraInfo, final boolean z) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        init(context);
        final String b = b();
        final long currentTimeMillis = System.currentTimeMillis();
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.23
            @Override // java.lang.Runnable
            public void run() {
                bb c = bb.c();
                c.a("End page view " + str);
                SessionAnalysis sessionAnalysis = BDStatCore.this.d;
                Context context2 = context;
                String str2 = str;
                sessionAnalysis.onPageEnd(context2, str2, str2, b, currentTimeMillis, extraInfo, z);
            }
        });
    }

    public void onEvent(Context context, String str, String str2, int i, long j, JSONArray jSONArray, JSONArray jSONArray2, String str3, String str4, String str5, Map<String, String> map) {
        onEvent(context, str, str2, i, j, jSONArray, jSONArray2, str3, str4, str5, map, false);
    }

    public void onEvent(final Context context, final String str, final String str2, final int i, final long j, final JSONArray jSONArray, final JSONArray jSONArray2, final String str3, final String str4, final String str5, final Map<String, String> map, final boolean z) {
        if (context == null) {
            return;
        }
        init(context);
        b(context);
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.10
            @Override // java.lang.Runnable
            public void run() {
                String str6 = str2;
                if (TextUtils.isEmpty(str6)) {
                    str6 = "";
                }
                BDStatCore.this.d.onSessionStart(context, j, false);
                bb.c().a("Put event" + BDStatCore.this.a(str, str6, i, 0L, map, null));
                BDStatCore.this.e.onEvent(context, BDStatCore.this.d.getSessionStartTime(), str, str6, i, j, jSONArray, jSONArray2, str3, str4, str5, map, z);
            }
        });
    }

    public void onEvent(final Context context, final String str, final String str2, final int i, final ExtraInfo extraInfo, final Map<String, String> map, final boolean z, final boolean z2) {
        if (context == null) {
            return;
        }
        init(context);
        final long currentTimeMillis = System.currentTimeMillis();
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.8
            @Override // java.lang.Runnable
            public void run() {
                String str3 = str2;
                if (TextUtils.isEmpty(str3)) {
                    str3 = "";
                }
                BDStatCore.this.d.onSessionStart(context, currentTimeMillis, z);
                bb.c().a("Put event" + BDStatCore.this.a(str, str3, i, 0L, map, extraInfo));
                BDStatCore.this.e.onEvent(context, BDStatCore.this.d.getSessionStartTime(), str, str3, i, currentTimeMillis, extraInfo, map, z2);
            }
        });
    }

    public void onEvent(final Context context, final String str, final String str2, final int i, final String str3, final String str4, final int i2, final boolean z) {
        if (context == null) {
            return;
        }
        init(context);
        b(context);
        final long currentTimeMillis = System.currentTimeMillis();
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.9
            @Override // java.lang.Runnable
            public void run() {
                String str5 = str2;
                if (TextUtils.isEmpty(str5)) {
                    str5 = "";
                }
                BDStatCore.this.d.onSessionStart(context, currentTimeMillis, false);
                bb.c().a("Put event" + BDStatCore.this.a(str, str5, i, 0L, null, null));
                BDStatCore.this.e.onEvent(context, BDStatCore.this.d.getSessionStartTime(), str, str5, i, currentTimeMillis, str3, str4, i2, z);
            }
        });
    }

    public void onEventDuration(final Context context, final String str, final String str2, final long j, final ExtraInfo extraInfo, final Map<String, String> map, final boolean z, final boolean z2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        init(context);
        b(context);
        final long currentTimeMillis = System.currentTimeMillis();
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.14
            @Override // java.lang.Runnable
            public void run() {
                String str3 = str2;
                if (TextUtils.isEmpty(str3)) {
                    str3 = "";
                }
                BDStatCore.this.d.onSessionStart(context, currentTimeMillis, z);
                bb.c().a("Put event" + BDStatCore.this.a(str, str3, 1, j, map, extraInfo));
                BDStatCore.this.e.onEventDuration(context, BDStatCore.this.d.getSessionStartTime(), str, str3, currentTimeMillis, j, extraInfo, map, z2);
            }
        });
    }

    public void onEventEnd(Context context, String str, String str2, ExtraInfo extraInfo, Map<String, String> map) {
        onEventEnd(context, str, str2, extraInfo, map, false);
    }

    public void onEventEnd(final Context context, final String str, final String str2, final ExtraInfo extraInfo, final Map<String, String> map, final boolean z) {
        if (context == null) {
            return;
        }
        init(context);
        final long currentTimeMillis = System.currentTimeMillis();
        this.b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.13
            @Override // java.lang.Runnable
            public void run() {
                String str3 = str2;
                if (TextUtils.isEmpty(str3)) {
                    str3 = "";
                }
                long sessionStartTime = BDStatCore.this.d.getSessionStartTime();
                bb.c().a("End event" + BDStatCore.this.a(str, str3, 1, -1L, map, extraInfo));
                BDStatCore.this.e.onEventEnd(context, sessionStartTime, str, str3, currentTimeMillis, extraInfo, map, z);
            }
        });
    }
}
