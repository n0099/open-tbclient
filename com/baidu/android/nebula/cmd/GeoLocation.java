package com.baidu.android.nebula.cmd;

import android.content.Context;
import com.baidu.android.moplus.util.NoProGuard;
import com.baidu.android.nebula.util.BDLocationManager;
import com.baidu.browser.webpool.BdWebPoolView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import java.util.Map;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GeoLocation implements NoProGuard, n {
    private static final boolean DEBUG = false;
    public static final int ERROR_LOC_FAIL = 2;
    public static final int ERROR_PERMISSION_DENY = 1;
    public static final int ERROR_TIMEOUT = 3;
    private static final String TAG = "GeoLocation";
    private volatile com.baidu.android.nebula.util.c mLocInfo;
    private int mErrcode = -1;
    Context mContext = null;
    private BDLocationManager mLocMgr = null;
    private com.baidu.android.nebula.util.e mLocListener = null;
    private Timer mTimeoutTm = null;
    private boolean mGpsEnabled = false;

    public GeoLocation() {
        a.a();
        a.a(TAG);
    }

    private void startRequest() {
        new e(this, this.mContext.getMainLooper()).sendEmptyMessage(0);
    }

    private void startTimeout(long j) {
        if (j <= 0) {
            return;
        }
        f fVar = new f(this);
        this.mTimeoutTm = new Timer();
        this.mTimeoutTm.schedule(fVar, j);
    }

    @Override // com.baidu.android.nebula.cmd.n
    public void execute(com.baidu.android.nebula.a.d dVar, com.baidu.android.nebula.a.a aVar) {
        String str;
        long j;
        long j2;
        a.a(System.currentTimeMillis());
        Map a = dVar.a();
        if (a == null || a.size() < 2) {
            a.a(-1);
            return;
        }
        try {
            j2 = Long.parseLong((String) a.get("timeout"));
            try {
                str = (String) a.get("callback");
                try {
                    a.d((String) a.get("mcmdf"));
                    this.mGpsEnabled = SocialConstants.TRUE.equals(a.get("gps"));
                } catch (NumberFormatException e) {
                    j = j2;
                    j2 = j;
                    if (str != null) {
                    }
                    a.a(-1);
                    return;
                }
            } catch (NumberFormatException e2) {
                str = null;
                j = j2;
            }
        } catch (NumberFormatException e3) {
            str = null;
            j = 0;
        }
        if (str != null || j2 == 0) {
            a.a(-1);
            return;
        }
        this.mContext = com.baidu.android.nebula.d.c.a().c();
        if (this.mContext == null) {
            a.a(-1);
            return;
        }
        a.b(this.mContext.getPackageName());
        if (BDLocationManager.a(this.mContext)) {
            if (!com.baidu.android.nebula.d.a.a(this.mContext).a(dVar.a("Referer"))) {
                this.mErrcode = 4;
            }
        } else {
            this.mErrcode = 1;
        }
        if (this.mErrcode == -1) {
            startTimeout(j2);
            startRequest();
        }
        synchronized (this) {
            try {
                if (this.mErrcode == -1 && this.mLocInfo == null) {
                    wait();
                }
            } catch (InterruptedException e4) {
            }
        }
        if (this.mLocMgr != null && this.mLocListener != null) {
            this.mLocMgr.b(this.mLocListener);
        }
        if (this.mLocMgr != null) {
            this.mLocMgr.a(false);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error", this.mErrcode);
            if (this.mLocInfo != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("latitude", this.mLocInfo.b());
                jSONObject2.put("longitude", this.mLocInfo.a());
                jSONObject2.put("accuracy", this.mLocInfo.c());
                jSONObject.put("coords", jSONObject2);
            }
        } catch (JSONException e5) {
        }
        aVar.a("text/javascript");
        aVar.a().put("Cache-Control", "no-cache");
        aVar.b(str + " && " + str + "(" + jSONObject.toString() + ");");
        aVar.a(BdWebPoolView.DELAYED_TIME);
        a.a(this.mErrcode);
    }

    @Override // com.baidu.android.nebula.cmd.n
    public void writeToStatic() {
        m.a().a(this.mContext, a.toString());
    }
}
