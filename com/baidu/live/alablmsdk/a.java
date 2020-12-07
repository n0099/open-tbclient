package com.baidu.live.alablmsdk;

import android.content.Context;
import com.baidu.live.alablmsdk.a.d;
import com.baidu.live.alablmsdk.b.c;
import com.baidu.live.alablmsdk.c.b;
import com.baidu.live.alablmsdk.module.rtc.BLMStreamState;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements b {
    private c aAW;
    private b aAX;
    private Context mContext;

    public a(Context context) {
        com.baidu.live.alablmsdk.a.b.a.ak("BLMRtcEngine constructor", "");
        this.mContext = context.getApplicationContext();
        com.baidu.live.alablmsdk.a.b.a.d("BLMRtcEngine mContext=" + this.mContext);
        d.BT().init(this.mContext);
        this.aAW = new c(this.mContext);
        this.aAW.a(this);
    }

    public void a(b bVar) {
        this.aAX = bVar;
        com.baidu.live.alablmsdk.a.b.a.d("setEventListener");
        com.baidu.live.alablmsdk.a.b.a.fY("setEventListener");
    }

    public void a(com.baidu.live.alablmsdk.c.a aVar) {
        com.baidu.live.alablmsdk.a.b.a.d("createRoom");
        com.baidu.live.alablmsdk.a.b.a.fY("createRoom");
        this.aAW.a(aVar);
    }

    public void a(String str, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.d("joinRoom");
        com.baidu.live.alablmsdk.a.b.a.fY("joinRoom");
        this.aAW.a(str, (com.baidu.live.alablmsdk.module.c) null, cVar);
    }

    public void a(String str, com.baidu.live.alablmsdk.module.c cVar, com.baidu.live.alablmsdk.c.c cVar2) {
        com.baidu.live.alablmsdk.a.b.a.d("joinRoom");
        com.baidu.live.alablmsdk.a.b.a.fY("joinRoom");
        this.aAW.a(str, cVar, cVar2);
    }

    public void a(String str, List<com.baidu.live.alablmsdk.module.c> list, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.d("inviteUsers");
        com.baidu.live.alablmsdk.a.b.a.fY("inviteUsers");
        this.aAW.a(str, list, jSONObject, cVar);
    }

    public void b(String str, List<com.baidu.live.alablmsdk.module.c> list, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.ak("cancelInviteUsers", "");
        this.aAW.b(str, list, jSONObject, cVar);
    }

    public void a(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.d("acceptRoom");
        com.baidu.live.alablmsdk.a.b.a.fY("acceptRoom");
        this.aAW.a(str, jSONObject, cVar);
    }

    public void b(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.d("rejectRoom");
        com.baidu.live.alablmsdk.a.b.a.fY("rejectRoom");
        this.aAW.b(str, jSONObject, cVar);
    }

    public void a(String str, JSONObject jSONObject, List<com.baidu.live.alablmsdk.module.c> list, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.ak("kickOffUsers", "");
        this.aAW.a(str, jSONObject, list, cVar);
    }

    public void c(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.d("leaveRoom");
        com.baidu.live.alablmsdk.a.b.a.fY("leaveRoom");
        this.aAW.a(str, jSONObject, true, cVar);
    }

    public void d(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.d("closeRoom");
        com.baidu.live.alablmsdk.a.b.a.fY("closeRoom");
        this.aAW.b(str, jSONObject, true, cVar);
    }

    public void v(HashMap<String, Object> hashMap) {
        com.baidu.live.alablmsdk.a.b.a.d("configParamSetting");
        com.baidu.live.alablmsdk.a.b.a.fY("configParamSetting");
        this.aAW.v(hashMap);
    }

    public void a(com.baidu.live.alablmsdk.config.a aVar) {
        com.baidu.live.alablmsdk.a.b.a.d("configLiveStream");
        com.baidu.live.alablmsdk.a.b.a.fY("configLiveStream");
        this.aAW.a(aVar);
    }

    public com.baidu.live.alablmsdk.d.a BR() {
        com.baidu.live.alablmsdk.a.b.a.d("getExternalMediaDevice");
        com.baidu.live.alablmsdk.a.b.a.fY("getExternalMediaDevice");
        return this.aAW.BR();
    }

    public void bg(boolean z) {
        if (this.aAW != null) {
            com.baidu.live.alablmsdk.a.b.a.d("RtcMuteMicrophone" + z);
            com.baidu.live.alablmsdk.a.b.a.fY("RtcMuteMicrophone" + z);
            this.aAW.bg(z);
        }
    }

    public void enterForeground() {
        com.baidu.live.alablmsdk.a.b.c.BY().markEnterForeground();
    }

    public void enterBackground() {
        com.baidu.live.alablmsdk.a.b.c.BY().markEnterBackground();
    }

    public static void bh(boolean z) {
        com.baidu.live.alablmsdk.a.b.a.ak("setVerboseEnable", "");
        com.baidu.live.alablmsdk.a.b.a.bh(z);
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void a(com.baidu.live.alablmsdk.module.rtc.a aVar, BLMStreamState bLMStreamState) {
        if (this.aAX != null) {
            this.aAX.a(aVar, bLMStreamState);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void a(com.baidu.live.alablmsdk.module.rtc.a aVar, int i) {
        if (this.aAX != null) {
            this.aAX.a(aVar, i);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void a(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.aAX != null) {
            this.aAX.a(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void b(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.aAX != null) {
            this.aAX.b(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void c(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.aAX != null) {
            this.aAX.c(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void a(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.aAX != null) {
            this.aAX.a(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void d(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.aAX != null) {
            this.aAX.d(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void e(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.aAX != null) {
            this.aAX.e(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void b(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.aAX != null) {
            this.aAX.b(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void c(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.aAX != null) {
            this.aAX.c(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void d(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.aAX != null) {
            this.aAX.d(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void fX(String str) {
        if (this.aAX != null) {
            this.aAX.fX(str);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void onLogReport(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.aAX != null) {
            this.aAX.onLogReport(str, jSONObject, jSONObject2);
        }
    }

    public void onRelease() {
        com.baidu.live.alablmsdk.a.b.a.ak("onRelease", "");
        this.aAX = null;
        this.aAW.release();
    }
}
