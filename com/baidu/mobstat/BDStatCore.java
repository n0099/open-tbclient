package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
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

    /* renamed from: a  reason: collision with root package name */
    public static BDStatCore f8511a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f8512b;

    /* renamed from: d  reason: collision with root package name */
    public SessionAnalysis f8514d;

    /* renamed from: e  reason: collision with root package name */
    public EventAnalysis f8515e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f8516f;

    /* renamed from: i  reason: collision with root package name */
    public Handler f8519i;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f8513c = false;

    /* renamed from: g  reason: collision with root package name */
    public long f8517g = 0;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f8518h = false;

    public BDStatCore() {
        HandlerThread handlerThread = new HandlerThread("BDStatCore", 10);
        handlerThread.start();
        this.f8512b = new Handler(handlerThread.getLooper());
        this.f8514d = new SessionAnalysis();
        this.f8515e = new EventAnalysis();
        HandlerThread handlerThread2 = new HandlerThread("dataAnalyzeThread");
        handlerThread2.start();
        handlerThread2.setPriority(10);
        this.f8519i = new Handler(handlerThread2.getLooper());
    }

    public static BDStatCore instance() {
        if (f8511a == null) {
            synchronized (BDStatCore.class) {
                if (f8511a == null) {
                    f8511a = new BDStatCore();
                }
            }
        }
        return f8511a;
    }

    public void autoTrackLaunchInfo(Context context, final LaunchInfo launchInfo, final boolean z) {
        if (launchInfo == null) {
            return;
        }
        if (z) {
            this.f8514d.autoTrackLaunchInfo(launchInfo, z);
            return;
        }
        init(context);
        this.f8512b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.17
            @Override // java.lang.Runnable
            public void run() {
                BDStatCore.this.f8514d.autoTrackLaunchInfo(launchInfo, z);
            }
        });
    }

    public void autoTrackSessionEndTime(final Context context) {
        if (context == null) {
            return;
        }
        init(context);
        final long currentTimeMillis = System.currentTimeMillis();
        this.f8512b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.19
            @Override // java.lang.Runnable
            public void run() {
                BDStatCore.this.f8514d.autoTrackSessionEndTime(context, currentTimeMillis);
            }
        });
    }

    public void autoTrackSessionStartTime(final Context context) {
        if (context == null) {
            return;
        }
        init(context);
        final long currentTimeMillis = System.currentTimeMillis();
        this.f8512b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.18
            @Override // java.lang.Runnable
            public void run() {
                BDStatCore.this.f8514d.autoTrackSessionStartTime(context, currentTimeMillis);
            }
        });
    }

    public void cancelSendLogCheck() {
        Runnable runnable = this.f8516f;
        if (runnable != null) {
            this.f8512b.removeCallbacks(runnable);
        }
        this.f8516f = null;
    }

    public void doSendLogCheck(final Context context) {
        if (context == null) {
            return;
        }
        int sessionTimeOut = this.f8514d.getSessionTimeOut();
        Runnable runnable = new Runnable() { // from class: com.baidu.mobstat.BDStatCore.20
            @Override // java.lang.Runnable
            public void run() {
                BDStatCore.this.f8514d.doSendLogCheck(context, System.currentTimeMillis());
            }
        };
        this.f8516f = runnable;
        this.f8512b.postDelayed(runnable, sessionTimeOut);
    }

    public JSONObject getPageSessionHead() {
        return this.f8514d.getPageSessionHead();
    }

    public int getSessionSize() {
        return this.f8514d.getSessionSize();
    }

    public long getSessionStartTime() {
        return this.f8514d.getSessionStartTime();
    }

    public void init(final Context context) {
        a(context);
        if (this.f8513c) {
            return;
        }
        ActivityLifeTask.registerActivityLifeCallback(context);
        this.f8512b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.1
            @Override // java.lang.Runnable
            public void run() {
                if (BDStatCore.this.f8513c) {
                    return;
                }
                PrefOperate.loadMetaDataConfig(context);
                BDStatCore.this.f8513c = true;
            }
        });
    }

    public void onErised(final Context context, String str, final String str2, final String str3) {
        if (this.f8514d.isSessionStart()) {
            return;
        }
        init(context);
        final long currentTimeMillis = System.currentTimeMillis();
        this.f8512b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.15
            @Override // java.lang.Runnable
            public void run() {
                DataCore.instance().init(context);
                EventAnalysis eventAnalysis = BDStatCore.this.f8515e;
                Context context2 = context;
                long j = currentTimeMillis;
                eventAnalysis.onEvent(context2, j, str2, str3, 1, j, null, null, false);
                DataCore.instance().saveLogData(context, true, false, currentTimeMillis, false);
                if (currentTimeMillis - BDStatCore.this.f8517g <= StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD || !bw.q(context)) {
                    return;
                }
                LogSender.instance().onSend(context);
                BDStatCore.this.f8517g = currentTimeMillis;
            }
        });
    }

    public void onEvent(Context context, String str, String str2, int i2, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        onEvent(context, str, str2, i2, extraInfo, map, z, false);
    }

    public void onEventDuration(Context context, String str, String str2, long j, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        onEventDuration(context, str, str2, j, extraInfo, map, z, false);
    }

    public void onEventEnd(Context context, String str, String str2, ExtraInfo extraInfo, Map<String, String> map) {
        onEventEnd(context, str, str2, extraInfo, map, false);
    }

    public void onEventStart(final Context context, final String str, final String str2, final boolean z) {
        if (context == null) {
            return;
        }
        init(context);
        b(context);
        final long currentTimeMillis = System.currentTimeMillis();
        this.f8512b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.10
            @Override // java.lang.Runnable
            public void run() {
                String str3 = str2;
                if (TextUtils.isEmpty(str3)) {
                    str3 = "";
                }
                BDStatCore.this.f8514d.onSessionStart(context, currentTimeMillis, z);
                bc.c().a("Start event" + BDStatCore.this.a(str, str3, 1, -1L, null, null));
                BDStatCore.this.f8515e.onEventStart(context, str, str3, currentTimeMillis);
            }
        });
    }

    public void onPageEnd(Context context, String str, ExtraInfo extraInfo) {
        onPageEnd(context, str, extraInfo, false);
    }

    public void onPageStart(final Context context, final String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        init(context);
        b(context);
        final int a2 = a();
        final long currentTimeMillis = System.currentTimeMillis();
        this.f8512b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.21
            @Override // java.lang.Runnable
            public void run() {
                bc c2 = bc.c();
                c2.a("Start page view " + str);
                BDStatCore.this.f8514d.onPageStart(context, str, a2, currentTimeMillis);
            }
        });
    }

    public void onPause(Activity activity, final boolean z, final ExtraInfo extraInfo) {
        final Context applicationContext;
        if (activity == null || (applicationContext = activity.getApplicationContext()) == null) {
            return;
        }
        init(applicationContext);
        final WeakReference weakReference = new WeakReference(activity);
        this.f8512b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.4
            @Override // java.lang.Runnable
            public void run() {
                Class<?> cls;
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 == null || (cls = activity2.getClass()) == null) {
                    return;
                }
                String name = activity2.getClass().getName();
                String simpleName = activity2.getClass().getSimpleName();
                CharSequence title = activity2.getTitle();
                String charSequence = title == null ? "" : title.toString();
                if (!z) {
                    bc c2 = bc.c();
                    c2.a("End page view " + cls.getSimpleName());
                }
                BDStatCore.this.f8514d.onPageEndAct(applicationContext, name, simpleName, charSequence, System.currentTimeMillis(), z, extraInfo);
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
        this.f8512b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.23
            @Override // java.lang.Runnable
            public void run() {
                Class<?> cls;
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 == null || (cls = activity2.getClass()) == null) {
                    return;
                }
                String name = activity2.getClass().getName();
                long currentTimeMillis = System.currentTimeMillis();
                if (!z) {
                    bc c2 = bc.c();
                    c2.a("Start page view " + cls.getSimpleName());
                }
                BDStatCore.this.f8514d.onPageStartAct(applicationContext, name, currentTimeMillis, z);
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
        this.f8512b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.12
            @Override // java.lang.Runnable
            public void run() {
                BDStatCore.this.f8514d.onSessionStart(context, currentTimeMillis, z);
            }
        });
    }

    public void onStat(final Context context, final String str) {
        if (this.f8514d.isSessionStart()) {
            return;
        }
        this.f8512b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.14
            @Override // java.lang.Runnable
            public void run() {
                LogSender.instance().sendEmptyLogData(context, str);
            }
        });
    }

    public void setSessionTimeOut(int i2) {
        this.f8514d.setSessionTimeOut(i2);
    }

    public void onEvent(final Context context, final String str, final String str2, final int i2, final ExtraInfo extraInfo, final Map<String, String> map, final boolean z, final boolean z2) {
        if (context == null) {
            return;
        }
        init(context);
        final long currentTimeMillis = System.currentTimeMillis();
        this.f8512b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.7
            @Override // java.lang.Runnable
            public void run() {
                String str3 = str2;
                if (TextUtils.isEmpty(str3)) {
                    str3 = "";
                }
                BDStatCore.this.f8514d.onSessionStart(context, currentTimeMillis, z);
                bc.c().a("Put event" + BDStatCore.this.a(str, str3, i2, 0L, map, extraInfo));
                BDStatCore.this.f8515e.onEvent(context, BDStatCore.this.f8514d.getSessionStartTime(), str, str3, i2, currentTimeMillis, extraInfo, map, z2);
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
        this.f8512b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.13
            @Override // java.lang.Runnable
            public void run() {
                String str3 = str2;
                if (TextUtils.isEmpty(str3)) {
                    str3 = "";
                }
                BDStatCore.this.f8514d.onSessionStart(context, currentTimeMillis, z);
                bc.c().a("Put event" + BDStatCore.this.a(str, str3, 1, j, map, extraInfo));
                BDStatCore.this.f8515e.onEventDuration(context, BDStatCore.this.f8514d.getSessionStartTime(), str, str3, currentTimeMillis, j, extraInfo, map, z2);
            }
        });
    }

    public void onEventEnd(final Context context, final String str, final String str2, final ExtraInfo extraInfo, final Map<String, String> map, final boolean z) {
        if (context == null) {
            return;
        }
        init(context);
        final long currentTimeMillis = System.currentTimeMillis();
        this.f8512b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.11
            @Override // java.lang.Runnable
            public void run() {
                String str3 = str2;
                if (TextUtils.isEmpty(str3)) {
                    str3 = "";
                }
                long sessionStartTime = BDStatCore.this.f8514d.getSessionStartTime();
                bc.c().a("End event" + BDStatCore.this.a(str, str3, 1, -1L, map, extraInfo));
                BDStatCore.this.f8515e.onEventEnd(context, sessionStartTime, str, str3, currentTimeMillis, extraInfo, map, z);
            }
        });
    }

    public void onPageEnd(final Context context, final String str, final ExtraInfo extraInfo, final boolean z) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        init(context);
        final String b2 = b();
        final long currentTimeMillis = System.currentTimeMillis();
        this.f8512b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.22
            @Override // java.lang.Runnable
            public void run() {
                bc c2 = bc.c();
                c2.a("End page view " + str);
                SessionAnalysis sessionAnalysis = BDStatCore.this.f8514d;
                Context context2 = context;
                String str2 = str;
                sessionAnalysis.onPageEnd(context2, str2, str2, b2, currentTimeMillis, extraInfo, z);
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

    private void a(Context context) {
        String appKey = CooperService.instance().getAppKey(context);
        if (TextUtils.isEmpty(appKey)) {
            return;
        }
        av.a(appKey);
    }

    public void onEvent(final Context context, final String str, final String str2, final int i2, final String str3, final String str4, final int i3, final boolean z) {
        if (context == null) {
            return;
        }
        init(context);
        b(context);
        final long currentTimeMillis = System.currentTimeMillis();
        this.f8512b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.8
            @Override // java.lang.Runnable
            public void run() {
                String str5 = str2;
                if (TextUtils.isEmpty(str5)) {
                    str5 = "";
                }
                BDStatCore.this.f8514d.onSessionStart(context, currentTimeMillis, false);
                bc.c().a("Put event" + BDStatCore.this.a(str, str5, i2, 0L, null, null));
                BDStatCore.this.f8515e.onEvent(context, BDStatCore.this.f8514d.getSessionStartTime(), str, str5, i2, currentTimeMillis, str3, str4, i3, z);
            }
        });
    }

    public void onPause(final Fragment fragment) {
        final FragmentActivity activity;
        final Context applicationContext;
        if (fragment == null || (activity = fragment.getActivity()) == null || (applicationContext = activity.getApplicationContext()) == null) {
            return;
        }
        init(applicationContext);
        final WeakReference weakReference = new WeakReference(fragment);
        this.f8512b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.5
            @Override // java.lang.Runnable
            public void run() {
                Fragment fragment2 = (Fragment) weakReference.get();
                if (fragment2 == null || fragment2.getClass() == null) {
                    return;
                }
                String name = fragment.getClass().getName();
                String simpleName = fragment.getClass().getSimpleName();
                CharSequence title = activity.getTitle();
                String charSequence = title == null ? "" : title.toString();
                bc c2 = bc.c();
                c2.a("End page view " + simpleName);
                BDStatCore.this.f8514d.onPageEndFrag(applicationContext, name, simpleName, charSequence, System.currentTimeMillis());
            }
        });
    }

    public void onResume(Fragment fragment) {
        FragmentActivity activity;
        final Context applicationContext;
        if (fragment == null || (activity = fragment.getActivity()) == null || (applicationContext = activity.getApplicationContext()) == null) {
            return;
        }
        init(applicationContext);
        b(applicationContext);
        final WeakReference weakReference = new WeakReference(fragment);
        this.f8512b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.2
            @Override // java.lang.Runnable
            public void run() {
                Class<?> cls;
                Fragment fragment2 = (Fragment) weakReference.get();
                if (fragment2 == null || (cls = fragment2.getClass()) == null) {
                    return;
                }
                String name = fragment2.getClass().getName();
                long currentTimeMillis = System.currentTimeMillis();
                bc c2 = bc.c();
                c2.a("Start page view " + cls.getSimpleName());
                BDStatCore.this.f8514d.onPageStartFrag(applicationContext, name, currentTimeMillis);
            }
        });
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
        for (int i2 = 0; stackTrace != null && i2 < stackTrace.length; i2++) {
            String className = stackTrace[i2].getClassName();
            if (!TextUtils.isEmpty(className) && MissionEvent.MESSAGE_RESUME.equals(stackTrace[i2].getMethodName())) {
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

    public void onEvent(Context context, String str, String str2, int i2, long j, JSONArray jSONArray, JSONArray jSONArray2, String str3, String str4, String str5, Map<String, String> map) {
        onEvent(context, str, str2, i2, j, jSONArray, jSONArray2, str3, str4, str5, map, false);
    }

    private void b(final Context context) {
        Handler handler;
        if (this.f8518h || context == null || (handler = this.f8519i) == null) {
            return;
        }
        handler.postDelayed(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.16
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!t.b(context)) {
                        t.a(2).a(context);
                    }
                } catch (Throwable unused) {
                }
                BDStatCore.this.f8518h = false;
            }
        }, 5000L);
        this.f8518h = true;
    }

    public void onEvent(final Context context, final String str, final String str2, final int i2, final long j, final JSONArray jSONArray, final JSONArray jSONArray2, final String str3, final String str4, final String str5, final Map<String, String> map, final boolean z) {
        if (context == null) {
            return;
        }
        init(context);
        b(context);
        this.f8512b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.9
            @Override // java.lang.Runnable
            public void run() {
                String str6 = str2;
                if (TextUtils.isEmpty(str6)) {
                    str6 = "";
                }
                BDStatCore.this.f8514d.onSessionStart(context, j, false);
                bc.c().a("Put event" + BDStatCore.this.a(str, str6, i2, 0L, map, null));
                BDStatCore.this.f8515e.onEvent(context, BDStatCore.this.f8514d.getSessionStartTime(), str, str6, i2, j, jSONArray, jSONArray2, str3, str4, str5, map, z);
            }
        });
    }

    @SuppressLint({"NewApi"})
    public void onPause(final android.app.Fragment fragment) {
        final Activity activity;
        final Context applicationContext;
        if (fragment == null || (activity = fragment.getActivity()) == null || (applicationContext = activity.getApplicationContext()) == null) {
            return;
        }
        init(applicationContext);
        final WeakReference weakReference = new WeakReference(fragment);
        this.f8512b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.6
            @Override // java.lang.Runnable
            public void run() {
                android.app.Fragment fragment2 = (android.app.Fragment) weakReference.get();
                if (fragment2 == null || fragment2.getClass() == null) {
                    return;
                }
                String name = fragment.getClass().getName();
                String simpleName = fragment.getClass().getSimpleName();
                CharSequence title = activity.getTitle();
                String charSequence = title == null ? "" : title.toString();
                bc c2 = bc.c();
                c2.a("End page view " + simpleName);
                BDStatCore.this.f8514d.onPageEndFrag(applicationContext, name, simpleName, charSequence, System.currentTimeMillis());
            }
        });
    }

    @SuppressLint({"NewApi"})
    public void onResume(android.app.Fragment fragment) {
        Activity activity;
        final Context applicationContext;
        if (fragment == null || (activity = fragment.getActivity()) == null || (applicationContext = activity.getApplicationContext()) == null) {
            return;
        }
        init(applicationContext);
        b(applicationContext);
        final WeakReference weakReference = new WeakReference(fragment);
        this.f8512b.post(new Runnable() { // from class: com.baidu.mobstat.BDStatCore.3
            @Override // java.lang.Runnable
            public void run() {
                Class<?> cls;
                android.app.Fragment fragment2 = (android.app.Fragment) weakReference.get();
                if (fragment2 == null || (cls = fragment2.getClass()) == null) {
                    return;
                }
                String name = fragment2.getClass().getName();
                long currentTimeMillis = System.currentTimeMillis();
                bc c2 = bc.c();
                c2.a("Start page view " + cls.getSimpleName());
                BDStatCore.this.f8514d.onPageStartFrag(applicationContext, name, currentTimeMillis);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(String str, String str2, int i2, long j, Map<String, String> map, ExtraInfo extraInfo) {
        JSONObject jSONObject;
        JSONObject dumpToJson;
        StringBuilder sb = new StringBuilder();
        if (map != null && map.size() != 0) {
            try {
                jSONObject = new JSONObject(map.toString());
            } catch (Exception unused) {
            }
            dumpToJson = extraInfo != null ? extraInfo.dumpToJson() : null;
            sb.append(" eventId " + str + ", with eventLabel " + str2 + ", with acc " + i2);
            if (j > 0) {
                sb.append(", with duration " + j);
            }
            if (jSONObject != null && jSONObject.length() != 0) {
                sb.append(", with attributes " + jSONObject);
            }
            if (dumpToJson != null && dumpToJson.length() != 0) {
                sb.append(", with extraInfo " + dumpToJson);
            }
            return sb.toString();
        }
        jSONObject = null;
        if (extraInfo != null) {
        }
        sb.append(" eventId " + str + ", with eventLabel " + str2 + ", with acc " + i2);
        if (j > 0) {
        }
        if (jSONObject != null) {
            sb.append(", with attributes " + jSONObject);
        }
        if (dumpToJson != null) {
            sb.append(", with extraInfo " + dumpToJson);
        }
        return sb.toString();
    }
}
