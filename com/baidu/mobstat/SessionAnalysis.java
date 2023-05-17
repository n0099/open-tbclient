package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobstat.Session;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SessionAnalysis {
    public boolean a = false;
    public Map<String, a> b = new HashMap();
    public a c = new a();
    public a d = new a();
    public boolean e = false;
    public long f = 0;
    public Session g = new Session();
    public int h = 0;
    public int i = 0;
    public long j = 0;
    public boolean k = true;
    public LaunchInfo l;
    public LaunchInfo m;
    public Callback mCallback;

    /* loaded from: classes3.dex */
    public interface Callback {
        void onCallback(JSONObject jSONObject);
    }

    public void doSendNewSessionLog(Context context) {
    }

    /* loaded from: classes3.dex */
    public static class a {
        public String a;
        public long b;
        public boolean c = false;

        public a() {
        }

        public a(String str) {
            this.a = str;
        }
    }

    public SessionAnalysis() {
    }

    public JSONObject getPageSessionHead() {
        return this.g.getPageSessionHead();
    }

    public int getSessionSize() {
        return this.i;
    }

    public long getSessionStartTime() {
        return this.g.getStartTime();
    }

    public int getSessionTimeOut() {
        if (this.h <= 0) {
            this.h = 30000;
        }
        return this.h;
    }

    public boolean isSessionStart() {
        if (this.g.getStartTime() > 0) {
            return true;
        }
        return false;
    }

    public SessionAnalysis(Callback callback) {
        this.mCallback = callback;
    }

    private void a(Context context) {
        if (this.g.hasStart()) {
            String jSONObject = this.g.constructJSONObject().toString();
            this.i = jSONObject.getBytes().length;
            String s = bw.s(context);
            bn.a(context, s + Config.LAST_SESSION_FILE_NAME, jSONObject, false);
        }
    }

    private a a(String str) {
        if (!this.b.containsKey(str)) {
            this.b.put(str, new a(str));
        }
        return this.b.get(str);
    }

    private void b(String str) {
        if (!TextUtils.isEmpty(str) && this.b.containsKey(str)) {
            this.b.remove(str);
        }
    }

    public void clearLastSessionCache(Context context) {
        if (context == null) {
            return;
        }
        String jSONObject = new JSONObject().toString();
        String s = bw.s(context);
        bn.a(context, s + Config.LAST_SESSION_FILE_NAME, jSONObject, false);
    }

    public void setAutoSend(boolean z) {
        this.k = z;
    }

    public void setSessionTimeOut(int i) {
        if (i < 1) {
            i = 30;
            bb.c().b("[WARNING] SessionTimeout should be between 1 and 600. Default value[30] is used");
        } else if (i > 600) {
            bb.c().b("[WARNING] SessionTimeout should be between 1 and 600. Default value[600] is used");
            i = 600;
        }
        this.h = i * 1000;
    }

    private void a(Context context, long j, long j2, int i, int i2) {
        boolean z;
        int i3 = 0;
        if (j2 - j > getSessionTimeOut()) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return;
        }
        if (j > 0) {
            if (2 == i2) {
                this.g.setEndTime(j);
            }
            LaunchInfo launchInfo = this.m;
            if (launchInfo != null) {
                i3 = launchInfo.getLaunchType(context);
            }
            a(context, j2, false, false, i3);
        }
        this.g.setTrackStartTime(this.j);
        this.g.setInvokeType(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Context context, long j, boolean z, boolean z2, int i) {
        boolean z3;
        long startTime;
        String launcherHomePkgName;
        String str;
        JSONObject jSONObject;
        Callback callback;
        if (this.g.hasEnd()) {
            DataCore.instance().putSession(this.g);
            DataCore.instance().flush(context);
            au.a(this.g.getPageSessionHead());
            this.g.setEndTime(0L);
        }
        if (j > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            startTime = j;
        } else {
            startTime = this.g.getStartTime();
        }
        String str2 = "";
        if (i != 0) {
            if (z2) {
                LaunchInfo launchInfo = this.l;
                if (launchInfo != null) {
                    str2 = launchInfo.getPushContent();
                    launcherHomePkgName = this.l.getRefererPkgName();
                }
                str = "";
            } else {
                LaunchInfo launchInfo2 = this.m;
                if (launchInfo2 != null) {
                    str2 = launchInfo2.getPushContent();
                    launcherHomePkgName = this.m.getRefererPkgName();
                }
                str = "";
            }
            if (!bu.a().e()) {
                jSONObject = LaunchInfo.getConvertedJson(i, str2, str);
            } else {
                jSONObject = null;
            }
            JSONObject jSONObject2 = jSONObject;
            if (z3) {
                this.g.reset();
                this.g.setStartTime(j);
                if (jSONObject2 != null) {
                    this.g.setLaunchInfo(jSONObject2);
                }
            }
            DataCore.instance().saveLogData(context, z3, z, startTime, z2, jSONObject2);
            callback = this.mCallback;
            if (callback != null) {
                callback.onCallback(DataCore.instance().getLogData());
            }
            if (!z3 || this.k) {
                LogSender.instance().onSend(context);
            }
            clearLastSessionCache(context);
        }
        launcherHomePkgName = LaunchInfo.getLauncherHomePkgName(context);
        String str3 = launcherHomePkgName;
        str = str2;
        str2 = str3;
        if (!bu.a().e()) {
        }
        JSONObject jSONObject22 = jSONObject;
        if (z3) {
        }
        DataCore.instance().saveLogData(context, z3, z, startTime, z2, jSONObject22);
        callback = this.mCallback;
        if (callback != null) {
        }
        if (!z3) {
        }
        LogSender.instance().onSend(context);
        clearLastSessionCache(context);
    }

    private void a(Context context, String str, String str2, long j, long j2, String str3, String str4, String str5, boolean z, ExtraInfo extraInfo, boolean z2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.equals(str2)) {
            return;
        }
        this.g.addPageView(new Session.a(str3, str4, str5, j2 - j, j, z, extraInfo, z2, DataCore.instance().getPagePy()));
        this.g.setEndTime(j2);
        a(context);
        if (!TextUtils.isEmpty(DataCore.instance().getTempPyd())) {
            DataCore.instance().flush(context);
        }
    }

    public void autoTrackLaunchInfo(LaunchInfo launchInfo, boolean z) {
        if (z) {
            this.l = launchInfo;
        } else {
            this.m = launchInfo;
        }
    }

    public void autoTrackSessionEndTime(Context context, long j) {
        if (context == null) {
            return;
        }
        this.g.setTrackEndTime(j);
        a(context);
    }

    public void autoTrackSessionStartTime(Context context, long j) {
        if (context == null) {
            return;
        }
        this.g.setTrackStartTime(j);
        this.j = j;
    }

    public void doSendLogCheck(Context context, long j) {
        long j2 = this.f;
        if (j2 > 0 && j - j2 > getSessionTimeOut()) {
            a(context, -1L, false, false, 0);
        }
    }

    public void onPageEnd(Context context, String str, String str2, String str3, long j, ExtraInfo extraInfo, boolean z) {
        a a2;
        this.e = false;
        if (TextUtils.isEmpty(str) || (a2 = a(str)) == null) {
            return;
        }
        if (!a2.c) {
            bb c = bb.c();
            c.c("[WARNING] 遗漏StatService.onPageStart(), 请检查邻近页面埋点: " + str);
            return;
        }
        a(context, a2.a, str, a2.b, j, str2, "", str3, false, extraInfo, z);
        b(str);
        this.f = j;
    }

    public void onPageEndAct(Context context, String str, String str2, String str3, long j, boolean z, ExtraInfo extraInfo) {
        a aVar;
        this.e = false;
        if (z) {
            aVar = this.d;
        } else {
            aVar = this.c;
        }
        a aVar2 = aVar;
        if (!aVar2.c) {
            if (!z) {
                bb c = bb.c();
                c.c("[WARNING] 遗漏StatService.onResume(Activity), 请检查邻近页面埋点: " + str);
                return;
            }
            return;
        }
        a(context, aVar2.a, str, aVar2.b, j, str2, str3, str, z, extraInfo, false);
        aVar2.c = false;
        this.f = j;
    }

    public void onPageEndFrag(Context context, String str, String str2, String str3, long j) {
        a a2;
        if (TextUtils.isEmpty(str) || (a2 = a(str)) == null) {
            return;
        }
        if (!a2.c) {
            bb c = bb.c();
            c.c("[WARNING] 遗漏StatService.onResume(Fragment), 请检查邻近页面埋点: " + str);
            return;
        }
        a(context, a2.a, str, a2.b, j, str2, str3, null, false, null, false);
        b(str);
        this.f = j;
    }

    public void onPageStart(Context context, String str, int i, long j) {
        a a2;
        onSessionStart(context, j, false);
        if (TextUtils.isEmpty(str) || (a2 = a(str)) == null) {
            return;
        }
        if (a2.c) {
            bb c = bb.c();
            c.c("[WARNING] 遗漏StatService.onPageEnd(), 请检查邻近页面埋点: " + str);
        }
        if (!this.e) {
            a(context, this.f, j, i, 3);
            this.e = true;
        }
        a2.c = true;
        a2.b = j;
    }

    public void onPageStartAct(Context context, String str, long j, boolean z) {
        a aVar;
        onSessionStart(context, j, false);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (z) {
            aVar = this.d;
        } else {
            aVar = this.c;
        }
        if (aVar.c && !z) {
            bb c = bb.c();
            c.c("[WARNING] 遗漏StatService.onPause(Activity), 请检查邻近页面埋点: " + str);
        }
        if (!this.e) {
            a(context, this.f, j, 1, 1);
            this.e = true;
        }
        aVar.c = true;
        aVar.a = str;
        aVar.b = j;
    }

    public void onPageStartFrag(Context context, String str, long j) {
        onSessionStart(context, j, false);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a a2 = a(str);
        if (a2.c) {
            bb c = bb.c();
            c.c("[WARNING] 遗漏StatService.onPause(Fragment), 请检查邻近页面埋点: " + str);
        }
        a(context, this.f, j, 2, 2);
        a2.c = true;
        a2.a = str;
        a2.b = j;
    }

    public void onSessionStart(Context context, long j, boolean z) {
        int i;
        if (this.a) {
            return;
        }
        DataCore.instance().init(context);
        try {
            Thread.sleep(3000L);
        } catch (Exception unused) {
        }
        LaunchInfo launchInfo = this.l;
        if (launchInfo != null) {
            i = launchInfo.getLaunchType(context);
        } else {
            i = 0;
        }
        a(context, j, z, true, i);
        this.a = true;
    }
}
