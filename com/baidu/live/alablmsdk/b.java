package com.baidu.live.alablmsdk;

import android.content.Context;
import com.baidu.live.alablmsdk.a.e;
import com.baidu.live.alablmsdk.b.c;
import com.baidu.live.alablmsdk.module.rtc.BLMStreamState;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements com.baidu.live.alablmsdk.c.b {
    private c ayE;
    private com.baidu.live.alablmsdk.c.b ayF;
    private Context mContext;

    public b(Context context) {
        com.baidu.live.alablmsdk.a.b.ag("BLMRtcEngine constructor", "");
        this.mContext = context.getApplicationContext();
        com.baidu.live.alablmsdk.a.b.d("BLMRtcEngine mContext=" + this.mContext);
        e.Az().init(this.mContext);
        this.ayE = new c(this.mContext);
        this.ayE.a(this);
    }

    public void a(com.baidu.live.alablmsdk.c.b bVar) {
        this.ayF = bVar;
        com.baidu.live.alablmsdk.a.b.d("setEventListener");
        com.baidu.live.alablmsdk.a.b.fD("setEventListener");
    }

    public void a(com.baidu.live.alablmsdk.c.a aVar) {
        com.baidu.live.alablmsdk.a.b.d("createRoom");
        com.baidu.live.alablmsdk.a.b.fD("createRoom");
        this.ayE.a(aVar);
    }

    public void a(String str, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.d("joinRoom");
        com.baidu.live.alablmsdk.a.b.fD("joinRoom");
        this.ayE.a(str, (com.baidu.live.alablmsdk.module.c) null, cVar);
    }

    public void a(String str, com.baidu.live.alablmsdk.module.c cVar, com.baidu.live.alablmsdk.c.c cVar2) {
        com.baidu.live.alablmsdk.a.b.d("joinRoom");
        com.baidu.live.alablmsdk.a.b.fD("joinRoom");
        this.ayE.a(str, cVar, cVar2);
    }

    public void a(String str, List<com.baidu.live.alablmsdk.module.c> list, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.d("inviteUsers");
        com.baidu.live.alablmsdk.a.b.fD("inviteUsers");
        this.ayE.a(str, list, jSONObject, cVar);
    }

    public void b(String str, List<com.baidu.live.alablmsdk.module.c> list, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.ag("cancelInviteUsers", "");
        this.ayE.b(str, list, jSONObject, cVar);
    }

    public void a(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.d("acceptRoom");
        com.baidu.live.alablmsdk.a.b.fD("acceptRoom");
        this.ayE.a(str, jSONObject, cVar);
    }

    public void b(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.d("rejectRoom");
        com.baidu.live.alablmsdk.a.b.fD("rejectRoom");
        this.ayE.b(str, jSONObject, cVar);
    }

    public void a(String str, JSONObject jSONObject, List<com.baidu.live.alablmsdk.module.c> list, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.ag("kickOffUsers", "");
        this.ayE.a(str, jSONObject, list, cVar);
    }

    public void c(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.d("leaveRoom");
        com.baidu.live.alablmsdk.a.b.fD("leaveRoom");
        this.ayE.c(str, jSONObject, cVar);
    }

    public void d(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.d("closeRoom");
        com.baidu.live.alablmsdk.a.b.fD("closeRoom");
        this.ayE.d(str, jSONObject, cVar);
    }

    public void v(HashMap<String, Object> hashMap) {
        com.baidu.live.alablmsdk.a.b.d("configParamSetting");
        com.baidu.live.alablmsdk.a.b.fD("configParamSetting");
        this.ayE.v(hashMap);
    }

    public void a(com.baidu.live.alablmsdk.config.a aVar) {
        com.baidu.live.alablmsdk.a.b.d("configLiveStream");
        com.baidu.live.alablmsdk.a.b.fD("configLiveStream");
        this.ayE.a(aVar);
    }

    public com.baidu.live.alablmsdk.d.a Av() {
        com.baidu.live.alablmsdk.a.b.d("getExternalMediaDevice");
        com.baidu.live.alablmsdk.a.b.fD("getExternalMediaDevice");
        return this.ayE.Av();
    }

    public void ba(boolean z) {
        if (this.ayE != null) {
            com.baidu.live.alablmsdk.a.b.d("RtcMuteMicrophone" + z);
            com.baidu.live.alablmsdk.a.b.fD("RtcMuteMicrophone" + z);
            this.ayE.ba(z);
        }
    }

    public static void bb(boolean z) {
        com.baidu.live.alablmsdk.a.b.ag("setVerboseEnable", "");
        com.baidu.live.alablmsdk.a.b.bb(z);
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void a(com.baidu.live.alablmsdk.module.rtc.a aVar, BLMStreamState bLMStreamState) {
        if (this.ayF != null) {
            this.ayF.a(aVar, bLMStreamState);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void a(com.baidu.live.alablmsdk.module.rtc.a aVar, int i) {
        if (this.ayF != null) {
            this.ayF.a(aVar, i);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void a(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.ayF != null) {
            this.ayF.a(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void b(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.ayF != null) {
            this.ayF.b(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void c(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.ayF != null) {
            this.ayF.c(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void a(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.ayF != null) {
            this.ayF.a(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void d(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.ayF != null) {
            this.ayF.d(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void e(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.ayF != null) {
            this.ayF.e(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void b(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.ayF != null) {
            this.ayF.b(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void c(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.ayF != null) {
            this.ayF.c(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void d(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.ayF != null) {
            this.ayF.d(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void fB(String str) {
        if (this.ayF != null) {
            this.ayF.fB(str);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void fC(String str) {
        if (this.ayF != null) {
            this.ayF.fC(str);
        }
    }

    public void onRelease() {
        com.baidu.live.alablmsdk.a.b.ag("onRelease", "");
        this.ayF = null;
        this.ayE.release();
    }
}
