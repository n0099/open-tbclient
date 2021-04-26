package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobstat.Session;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SessionAnalysis {

    /* renamed from: a  reason: collision with root package name */
    public boolean f8734a = false;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, a> f8735b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public a f8736c = new a();

    /* renamed from: d  reason: collision with root package name */
    public a f8737d = new a();

    /* renamed from: e  reason: collision with root package name */
    public boolean f8738e = false;

    /* renamed from: f  reason: collision with root package name */
    public long f8739f = 0;

    /* renamed from: g  reason: collision with root package name */
    public Session f8740g = new Session();

    /* renamed from: h  reason: collision with root package name */
    public int f8741h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f8742i = 0;
    public long j = 0;
    public LaunchInfo k;
    public LaunchInfo l;
    public Callback mCallback;

    /* loaded from: classes2.dex */
    public interface Callback {
        void onCallback(JSONObject jSONObject);
    }

    public SessionAnalysis() {
    }

    private void a(Context context, long j, long j2, int i2, int i3) {
        if (j2 - j > ((long) getSessionTimeOut())) {
            if (j > 0) {
                if (2 == i3) {
                    this.f8740g.setEndTime(j);
                }
                LaunchInfo launchInfo = this.l;
                a(context, j2, false, false, launchInfo != null ? launchInfo.getLaunchType(context) : 0);
            }
            this.f8740g.setTrackStartTime(this.j);
            this.f8740g.setInvokeType(i2);
        }
    }

    private void b(String str) {
        if (!TextUtils.isEmpty(str) && this.f8735b.containsKey(str)) {
            this.f8735b.remove(str);
        }
    }

    public void autoTrackLaunchInfo(LaunchInfo launchInfo, boolean z) {
        if (z) {
            this.k = launchInfo;
        } else {
            this.l = launchInfo;
        }
    }

    public void autoTrackSessionEndTime(Context context, long j) {
        if (context == null) {
            return;
        }
        this.f8740g.setTrackEndTime(j);
        a(context);
    }

    public void autoTrackSessionStartTime(Context context, long j) {
        if (context == null) {
            return;
        }
        this.f8740g.setTrackStartTime(j);
        this.j = j;
    }

    public void clearLastSessionCache(Context context) {
        if (context == null) {
            return;
        }
        String jSONObject = new JSONObject().toString();
        String u = bw.u(context);
        bo.a(context, u + Config.LAST_SESSION_FILE_NAME, jSONObject, false);
    }

    public void doSendLogCheck(Context context, long j) {
        long j2 = this.f8739f;
        if (j2 <= 0 || j - j2 <= getSessionTimeOut()) {
            return;
        }
        a(context, -1L, false, false, 0);
    }

    public JSONObject getPageSessionHead() {
        return this.f8740g.getPageSessionHead();
    }

    public int getSessionSize() {
        return this.f8742i;
    }

    public long getSessionStartTime() {
        return this.f8740g.getStartTime();
    }

    public int getSessionTimeOut() {
        if (this.f8741h <= 0) {
            this.f8741h = 30000;
        }
        return this.f8741h;
    }

    public boolean isSessionStart() {
        return this.f8740g.getStartTime() > 0;
    }

    public void onPageEnd(Context context, String str, String str2, String str3, long j, ExtraInfo extraInfo, boolean z) {
        a a2;
        this.f8738e = false;
        if (TextUtils.isEmpty(str) || (a2 = a(str)) == null) {
            return;
        }
        if (!a2.f8745c) {
            bc c2 = bc.c();
            c2.c("[WARNING] 遗漏StatService.onPageStart(), 请检查邻近页面埋点: " + str);
            return;
        }
        a(context, a2.f8743a, str, a2.f8744b, j, str2, "", str3, false, extraInfo, z);
        b(str);
        this.f8739f = j;
    }

    public void onPageEndAct(Context context, String str, String str2, String str3, long j, boolean z, ExtraInfo extraInfo) {
        this.f8738e = false;
        a aVar = z ? this.f8737d : this.f8736c;
        if (aVar.f8745c) {
            a(context, aVar.f8743a, str, aVar.f8744b, j, str2, str3, str, z, extraInfo, false);
            aVar.f8745c = false;
            this.f8739f = j;
        } else if (z) {
        } else {
            bc c2 = bc.c();
            c2.c("[WARNING] 遗漏StatService.onResume(Activity), 请检查邻近页面埋点: " + str);
        }
    }

    public void onPageEndFrag(Context context, String str, String str2, String str3, long j) {
        a a2;
        if (TextUtils.isEmpty(str) || (a2 = a(str)) == null) {
            return;
        }
        if (!a2.f8745c) {
            bc c2 = bc.c();
            c2.c("[WARNING] 遗漏StatService.onResume(Fragment), 请检查邻近页面埋点: " + str);
            return;
        }
        a(context, a2.f8743a, str, a2.f8744b, j, str2, str3, null, false, null, false);
        b(str);
        this.f8739f = j;
    }

    public void onPageStart(Context context, String str, int i2, long j) {
        a a2;
        onSessionStart(context, j, false);
        if (TextUtils.isEmpty(str) || (a2 = a(str)) == null) {
            return;
        }
        if (a2.f8745c) {
            bc c2 = bc.c();
            c2.c("[WARNING] 遗漏StatService.onPageEnd(), 请检查邻近页面埋点: " + str);
        }
        if (!this.f8738e) {
            a(context, this.f8739f, j, i2, 3);
            this.f8738e = true;
        }
        a2.f8745c = true;
        a2.f8744b = j;
    }

    public void onPageStartAct(Context context, String str, long j, boolean z) {
        onSessionStart(context, j, false);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a aVar = z ? this.f8737d : this.f8736c;
        if (aVar.f8745c && !z) {
            bc c2 = bc.c();
            c2.c("[WARNING] 遗漏StatService.onPause(Activity), 请检查邻近页面埋点: " + str);
        }
        if (!this.f8738e) {
            a(context, this.f8739f, j, 1, 1);
            this.f8738e = true;
        }
        aVar.f8745c = true;
        aVar.f8743a = str;
        aVar.f8744b = j;
    }

    public void onPageStartFrag(Context context, String str, long j) {
        onSessionStart(context, j, false);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a a2 = a(str);
        if (a2.f8745c) {
            bc c2 = bc.c();
            c2.c("[WARNING] 遗漏StatService.onPause(Fragment), 请检查邻近页面埋点: " + str);
        }
        a(context, this.f8739f, j, 2, 2);
        a2.f8745c = true;
        a2.f8743a = str;
        a2.f8744b = j;
    }

    public void onSessionStart(Context context, long j, boolean z) {
        if (this.f8734a) {
            return;
        }
        DataCore.instance().init(context);
        try {
            Thread.sleep(3000L);
        } catch (Exception unused) {
        }
        LaunchInfo launchInfo = this.k;
        a(context, j, z, true, launchInfo != null ? launchInfo.getLaunchType(context) : 0);
        this.f8734a = true;
    }

    public void setSessionTimeOut(int i2) {
        if (i2 < 1) {
            i2 = 30;
            bc.c().b("[WARNING] SessionTimeout should be between 1 and 600. Default value[30] is used");
        } else if (i2 > 600) {
            bc.c().b("[WARNING] SessionTimeout should be between 1 and 600. Default value[600] is used");
            i2 = 600;
        }
        this.f8741h = i2 * 1000;
    }

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f8743a;

        /* renamed from: b  reason: collision with root package name */
        public long f8744b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f8745c = false;

        public a() {
        }

        public a(String str) {
            this.f8743a = str;
        }
    }

    private void a(Context context, String str, String str2, long j, long j2, String str3, String str4, String str5, boolean z, ExtraInfo extraInfo, boolean z2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.equals(str2)) {
            return;
        }
        this.f8740g.addPageView(new Session.a(str3, str4, str5, j2 - j, j, z, extraInfo, z2));
        this.f8740g.setEndTime(j2);
        a(context);
    }

    public SessionAnalysis(Callback callback) {
        this.mCallback = callback;
    }

    private a a(String str) {
        if (!this.f8735b.containsKey(str)) {
            this.f8735b.put(str, new a(str));
        }
        return this.f8735b.get(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Context context, long j, boolean z, boolean z2, int i2) {
        String launcherHomePkgName;
        String str;
        Callback callback;
        if (this.f8740g.hasEnd()) {
            DataCore.instance().putSession(this.f8740g);
            DataCore.instance().flush(context);
            av.a(this.f8740g.getPageSessionHead());
            this.f8740g.setEndTime(0L);
        }
        boolean z3 = j > 0;
        long startTime = z3 ? j : this.f8740g.getStartTime();
        String str2 = "";
        if (i2 == 0) {
            launcherHomePkgName = LaunchInfo.getLauncherHomePkgName(context);
        } else {
            if (z2) {
                LaunchInfo launchInfo = this.k;
                if (launchInfo != null) {
                    str2 = launchInfo.getPushContent();
                    launcherHomePkgName = this.k.getRefererPkgName();
                }
                str = "";
            } else {
                LaunchInfo launchInfo2 = this.l;
                if (launchInfo2 != null) {
                    str2 = launchInfo2.getPushContent();
                    launcherHomePkgName = this.l.getRefererPkgName();
                }
                str = "";
            }
            JSONObject convertedJson = LaunchInfo.getConvertedJson(i2, str2, str);
            if (z3) {
                this.f8740g.reset();
                this.f8740g.setStartTime(j);
                if (convertedJson != null) {
                    this.f8740g.setLaunchInfo(convertedJson);
                }
            }
            DataCore.instance().saveLogData(context, z3, z, startTime, z2, convertedJson);
            callback = this.mCallback;
            if (callback != null) {
                callback.onCallback(DataCore.instance().getLogData());
            }
            LogSender.instance().onSend(context);
            clearLastSessionCache(context);
        }
        String str3 = launcherHomePkgName;
        str = str2;
        str2 = str3;
        JSONObject convertedJson2 = LaunchInfo.getConvertedJson(i2, str2, str);
        if (z3) {
        }
        DataCore.instance().saveLogData(context, z3, z, startTime, z2, convertedJson2);
        callback = this.mCallback;
        if (callback != null) {
        }
        LogSender.instance().onSend(context);
        clearLastSessionCache(context);
    }

    private void a(Context context) {
        if (this.f8740g.hasStart()) {
            String jSONObject = this.f8740g.constructJSONObject().toString();
            this.f8742i = jSONObject.getBytes().length;
            String u = bw.u(context);
            bo.a(context, u + Config.LAST_SESSION_FILE_NAME, jSONObject, false);
        }
    }
}
