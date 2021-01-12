package com.baidu.live.alablmsdk;

import android.content.Context;
import com.baidu.live.alablmsdk.a.d;
import com.baidu.live.alablmsdk.b.c;
import com.baidu.live.alablmsdk.c.b;
import com.baidu.live.alablmsdk.module.rtc.BLMStreamState;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a implements b {
    private c awA;
    private b awB;
    private Context mContext;

    public a(Context context) {
        com.baidu.live.alablmsdk.a.b.a.ai("BLMRtcEngine constructor", "");
        this.mContext = context.getApplicationContext();
        com.baidu.live.alablmsdk.a.b.a.d("BLMRtcEngine mContext=" + this.mContext);
        d.xp().init(this.mContext);
        this.awA = new c(this.mContext);
        this.awA.a(this);
    }

    public void a(b bVar) {
        this.awB = bVar;
        com.baidu.live.alablmsdk.a.b.a.d("setEventListener");
        com.baidu.live.alablmsdk.a.b.a.ew("setEventListener");
    }

    public void a(com.baidu.live.alablmsdk.c.a aVar) {
        com.baidu.live.alablmsdk.a.b.a.d("createRoom");
        com.baidu.live.alablmsdk.a.b.a.ew("createRoom");
        this.awA.a(aVar);
    }

    public void a(String str, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.d("joinRoom");
        com.baidu.live.alablmsdk.a.b.a.ew("joinRoom");
        this.awA.a(str, (com.baidu.live.alablmsdk.module.c) null, cVar);
    }

    public void a(String str, com.baidu.live.alablmsdk.module.c cVar, com.baidu.live.alablmsdk.c.c cVar2) {
        com.baidu.live.alablmsdk.a.b.a.d("joinRoom");
        com.baidu.live.alablmsdk.a.b.a.ew("joinRoom");
        this.awA.a(str, cVar, cVar2);
    }

    public void a(String str, List<com.baidu.live.alablmsdk.module.c> list, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.d("inviteUsers");
        com.baidu.live.alablmsdk.a.b.a.ew("inviteUsers");
        this.awA.a(str, list, jSONObject, cVar);
    }

    public void b(String str, List<com.baidu.live.alablmsdk.module.c> list, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.ai("cancelInviteUsers", "");
        this.awA.b(str, list, jSONObject, cVar);
    }

    public void a(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.d("acceptRoom");
        com.baidu.live.alablmsdk.a.b.a.ew("acceptRoom");
        this.awA.a(str, jSONObject, cVar);
    }

    public void b(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.d("rejectRoom");
        com.baidu.live.alablmsdk.a.b.a.ew("rejectRoom");
        this.awA.b(str, jSONObject, cVar);
    }

    public void a(String str, JSONObject jSONObject, List<com.baidu.live.alablmsdk.module.c> list, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.ai("kickOffUsers", "");
        this.awA.a(str, jSONObject, list, cVar);
    }

    public void c(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.d("leaveRoom");
        com.baidu.live.alablmsdk.a.b.a.ew("leaveRoom");
        this.awA.a(str, jSONObject, true, cVar);
    }

    public void d(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.d("closeRoom");
        com.baidu.live.alablmsdk.a.b.a.ew("closeRoom");
        this.awA.b(str, jSONObject, true, cVar);
    }

    public void v(HashMap<String, Object> hashMap) {
        com.baidu.live.alablmsdk.a.b.a.d("configParamSetting");
        com.baidu.live.alablmsdk.a.b.a.ew("configParamSetting");
        this.awA.v(hashMap);
    }

    public void a(com.baidu.live.alablmsdk.config.a aVar) {
        com.baidu.live.alablmsdk.a.b.a.d("configLiveStream");
        com.baidu.live.alablmsdk.a.b.a.ew("configLiveStream");
        this.awA.a(aVar);
    }

    public com.baidu.live.alablmsdk.d.a xn() {
        com.baidu.live.alablmsdk.a.b.a.d("getExternalMediaDevice");
        com.baidu.live.alablmsdk.a.b.a.ew("getExternalMediaDevice");
        return this.awA.xn();
    }

    public void aZ(boolean z) {
        if (this.awA != null) {
            com.baidu.live.alablmsdk.a.b.a.d("RtcMuteMicrophone" + z);
            com.baidu.live.alablmsdk.a.b.a.ew("RtcMuteMicrophone" + z);
            this.awA.aZ(z);
        }
    }

    public void enterForeground() {
        com.baidu.live.alablmsdk.a.b.c.xu().markEnterForeground();
    }

    public void enterBackground() {
        com.baidu.live.alablmsdk.a.b.c.xu().markEnterBackground();
    }

    public static void ba(boolean z) {
        com.baidu.live.alablmsdk.a.b.a.ai("setVerboseEnable", "");
        com.baidu.live.alablmsdk.a.b.a.ba(z);
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void a(com.baidu.live.alablmsdk.module.rtc.a aVar, BLMStreamState bLMStreamState) {
        if (this.awB != null) {
            this.awB.a(aVar, bLMStreamState);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void a(com.baidu.live.alablmsdk.module.rtc.a aVar, int i) {
        if (this.awB != null) {
            this.awB.a(aVar, i);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void a(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.awB != null) {
            this.awB.a(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void b(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.awB != null) {
            this.awB.b(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void c(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.awB != null) {
            this.awB.c(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void a(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.awB != null) {
            this.awB.a(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void d(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.awB != null) {
            this.awB.d(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void e(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.awB != null) {
            this.awB.e(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void b(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.awB != null) {
            this.awB.b(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void c(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.awB != null) {
            this.awB.c(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void d(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.awB != null) {
            this.awB.d(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void ev(String str) {
        if (this.awB != null) {
            this.awB.ev(str);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void onLogReport(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.awB != null) {
            this.awB.onLogReport(str, jSONObject, jSONObject2);
        }
    }

    public void onRelease() {
        com.baidu.live.alablmsdk.a.b.a.ai("onRelease", "");
        this.awB = null;
        this.awA.release();
    }
}
