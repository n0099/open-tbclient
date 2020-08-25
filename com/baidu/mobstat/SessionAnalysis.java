package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.mobstat.Session;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class SessionAnalysis {
    private boolean a = false;
    private Map<String, a> b = new HashMap();
    private a c = new a();
    private a d = new a();
    private boolean e = false;
    private long f = 0;
    private Session g = new Session();
    private int h = 0;
    private int i = 0;
    private long j = 0;
    private LaunchInfo k;
    private LaunchInfo l;
    public Callback mCallback;

    /* loaded from: classes11.dex */
    public interface Callback {
        void onCallback(JSONObject jSONObject);
    }

    public SessionAnalysis() {
    }

    public SessionAnalysis(Callback callback) {
        this.mCallback = callback;
    }

    public void setSessionTimeOut(int i) {
        if (i < 1) {
            i = 30;
            bc.c().b("[WARNING] SessionTimeout should be between 1 and 600. Default value[30] is used");
        } else if (i > 600) {
            bc.c().b("[WARNING] SessionTimeout should be between 1 and 600. Default value[600] is used");
            i = 600;
        }
        this.h = i * 1000;
    }

    public int getSessionTimeOut() {
        if (this.h <= 0) {
            this.h = 30000;
        }
        return this.h;
    }

    public long getSessionStartTime() {
        return this.g.getStartTime();
    }

    public JSONObject getPageSessionHead() {
        return this.g.getPageSessionHead();
    }

    public int getSessionSize() {
        return this.i;
    }

    public void doSendLogCheck(Context context, long j) {
        if (this.f > 0 && j - this.f > getSessionTimeOut()) {
            a(context, -1L, false, false, 0);
        }
    }

    public void autoTrackLaunchInfo(LaunchInfo launchInfo, boolean z) {
        if (z) {
            this.k = launchInfo;
        } else {
            this.l = launchInfo;
        }
    }

    public void autoTrackSessionStartTime(Context context, long j) {
        if (context != null) {
            this.g.setTrackStartTime(j);
            this.j = j;
        }
    }

    public void autoTrackSessionEndTime(Context context, long j) {
        if (context != null) {
            this.g.setTrackEndTime(j);
            a(context);
        }
    }

    public void onSessionStart(Context context, long j, boolean z) {
        if (!this.a) {
            DataCore.instance().init(context);
            try {
                Thread.sleep(IMConnection.RETRY_DELAY_TIMES);
            } catch (Exception e) {
            }
            int i = 0;
            if (this.k != null) {
                i = this.k.getLaunchType(context);
            }
            a(context, j, z, true, i);
            this.a = true;
        }
    }

    public void onPageStart(Context context, String str, int i, long j) {
        a a2;
        onSessionStart(context, j, false);
        if (!TextUtils.isEmpty(str) && (a2 = a(str)) != null) {
            if (a2.c) {
                bc.c().c("[WARNING] 遗漏StatService.onPageEnd(), 请检查邻近页面埋点: " + str);
            }
            if (!this.e) {
                a(context, this.f, j, i, 3);
                this.e = true;
            }
            a2.c = true;
            a2.b = j;
        }
    }

    public void onPageEnd(Context context, String str, String str2, String str3, long j, ExtraInfo extraInfo, boolean z) {
        a a2;
        this.e = false;
        if (!TextUtils.isEmpty(str) && (a2 = a(str)) != null) {
            if (!a2.c) {
                bc.c().c("[WARNING] 遗漏StatService.onPageStart(), 请检查邻近页面埋点: " + str);
                return;
            }
            a(context, a2.a, str, a2.b, j, str2, "", str3, false, extraInfo, z);
            b(str);
            this.f = j;
        }
    }

    public void onPageStartAct(Context context, String str, long j, boolean z) {
        onSessionStart(context, j, false);
        if (!TextUtils.isEmpty(str)) {
            a aVar = z ? this.d : this.c;
            if (aVar.c && !z) {
                bc.c().c("[WARNING] 遗漏StatService.onPause(Activity), 请检查邻近页面埋点: " + str);
            }
            if (!this.e) {
                a(context, this.f, j, 1, 1);
                this.e = true;
            }
            aVar.c = true;
            aVar.a = str;
            aVar.b = j;
        }
    }

    public void onPageEndAct(Context context, String str, String str2, String str3, long j, boolean z, ExtraInfo extraInfo) {
        this.e = false;
        a aVar = z ? this.d : this.c;
        if (!aVar.c) {
            if (!z) {
                bc.c().c("[WARNING] 遗漏StatService.onResume(Activity), 请检查邻近页面埋点: " + str);
                return;
            }
            return;
        }
        a(context, aVar.a, str, aVar.b, j, str2, str3, str, z, extraInfo, false);
        aVar.c = false;
        this.f = j;
    }

    public void onPageStartFrag(Context context, String str, long j) {
        onSessionStart(context, j, false);
        if (!TextUtils.isEmpty(str)) {
            a a2 = a(str);
            if (a2.c) {
                bc.c().c("[WARNING] 遗漏StatService.onPause(Fragment), 请检查邻近页面埋点: " + str);
            }
            a(context, this.f, j, 2, 2);
            a2.c = true;
            a2.a = str;
            a2.b = j;
        }
    }

    public void onPageEndFrag(Context context, String str, String str2, String str3, long j) {
        a a2;
        if (!TextUtils.isEmpty(str) && (a2 = a(str)) != null) {
            if (!a2.c) {
                bc.c().c("[WARNING] 遗漏StatService.onResume(Fragment), 请检查邻近页面埋点: " + str);
                return;
            }
            a(context, a2.a, str, a2.b, j, str2, str3, null, false, null, false);
            b(str);
            this.f = j;
        }
    }

    private void a(Context context, long j, long j2, int i, int i2) {
        if (j2 - j > ((long) getSessionTimeOut())) {
            if (j > 0) {
                if (2 == i2) {
                    this.g.setEndTime(j);
                }
                a(context, j2, false, false, this.l != null ? this.l.getLaunchType(context) : 0);
            }
            this.g.setTrackStartTime(this.j);
            this.g.setInvokeType(i);
        }
    }

    private void a(Context context, String str, String str2, long j, long j2, String str3, String str4, String str5, boolean z, ExtraInfo extraInfo, boolean z2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str.equals(str2)) {
            this.g.addPageView(new Session.a(str3, str4, str5, j2 - j, j, z, extraInfo, z2));
            this.g.setEndTime(j2);
            a(context);
        }
    }

    private a a(String str) {
        if (!this.b.containsKey(str)) {
            this.b.put(str, new a(str));
        }
        return this.b.get(str);
    }

    private void a(Context context, long j, boolean z, boolean z2, int i) {
        if (this.g.hasEnd()) {
            DataCore.instance().putSession(this.g);
            DataCore.instance().flush(context);
            av.a(this.g.getPageSessionHead());
            this.g.setEndTime(0L);
        }
        boolean z3 = j > 0;
        long startTime = z3 ? j : this.g.getStartTime();
        String str = "";
        String str2 = "";
        if (i != 0) {
            if (z2) {
                if (this.k != null) {
                    str = this.k.getPushContent();
                    str2 = this.k.getRefererPkgName();
                }
            } else if (this.l != null) {
                str = this.l.getPushContent();
                str2 = this.l.getRefererPkgName();
            }
        } else {
            str2 = LaunchInfo.getLauncherHomePkgName(context);
        }
        JSONObject convertedJson = LaunchInfo.getConvertedJson(i, str2, str);
        if (z3) {
            this.g.reset();
            this.g.setStartTime(j);
            if (convertedJson != null) {
                this.g.setLaunchInfo(convertedJson);
            }
        }
        DataCore.instance().saveLogData(context, z3, z, startTime, z2, convertedJson);
        if (this.mCallback != null) {
            this.mCallback.onCallback(DataCore.instance().getLogData());
        }
        LogSender.instance().onSend(context);
        clearLastSessionCache(context);
    }

    private void a(Context context) {
        if (this.g.hasStart()) {
            String jSONObject = this.g.constructJSONObject().toString();
            this.i = jSONObject.getBytes().length;
            bo.a(context, bw.u(context) + Config.LAST_SESSION_FILE_NAME, jSONObject, false);
        }
    }

    public void clearLastSessionCache(Context context) {
        if (context != null) {
            bo.a(context, bw.u(context) + Config.LAST_SESSION_FILE_NAME, new JSONObject().toString(), false);
        }
    }

    private void b(String str) {
        if (!TextUtils.isEmpty(str) && this.b.containsKey(str)) {
            this.b.remove(str);
        }
    }

    public boolean isSessionStart() {
        return this.g.getStartTime() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class a {
        String a;
        long b;
        boolean c = false;

        public a() {
        }

        public a(String str) {
            this.a = str;
        }
    }
}
