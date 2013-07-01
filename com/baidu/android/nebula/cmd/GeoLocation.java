package com.baidu.android.nebula.cmd;

import android.content.Context;
import com.baidu.android.moplus.util.NoProGuard;
import com.baidu.android.nebula.util.BDLocationManager;
import com.baidu.cyberplayer.sdk.internal.HttpUtils;
import java.util.Map;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GeoLocation implements NoProGuard, e {
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

    private void startRequest() {
        new a(this, this.mContext.getMainLooper()).sendEmptyMessage(0);
    }

    private void startTimeout(long j) {
        if (j <= 0) {
            return;
        }
        b bVar = new b(this);
        this.mTimeoutTm = new Timer();
        this.mTimeoutTm.schedule(bVar, j);
    }

    @Override // com.baidu.android.nebula.cmd.e
    public void execute(com.baidu.android.nebula.a.d dVar, com.baidu.android.nebula.a.a aVar) {
        String str;
        long j;
        long j2;
        Map a2 = dVar.a();
        if (a2 == null || a2.size() < 2) {
            return;
        }
        try {
            j2 = Long.parseLong((String) a2.get("timeout"));
            try {
                str = (String) a2.get("callback");
            } catch (NumberFormatException e) {
                str = null;
                j = j2;
            }
        } catch (NumberFormatException e2) {
            str = null;
            j = 0;
        }
        try {
            this.mGpsEnabled = "1".equals(a2.get("gps"));
        } catch (NumberFormatException e3) {
            j = j2;
            j2 = j;
            if (str != null) {
                return;
            }
            return;
        }
        if (str != null || j2 == 0) {
            return;
        }
        this.mContext = com.baidu.android.nebula.d.c.a().c();
        if (this.mContext != null) {
            if (BDLocationManager.a(this.mContext)) {
                if (!com.baidu.android.nebula.d.a.a(this.mContext).a(dVar.a(HttpUtils.HEADER_NAME_REFERER))) {
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
            aVar.a(200);
        }
    }
}
