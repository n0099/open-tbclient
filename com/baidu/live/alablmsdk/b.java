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
    private c aAp;
    private com.baidu.live.alablmsdk.c.b aAq;
    private Context mContext;

    public b(Context context) {
        com.baidu.live.alablmsdk.a.b.ah("BLMRtcEngine constructor", "");
        this.mContext = context.getApplicationContext();
        com.baidu.live.alablmsdk.a.b.d("BLMRtcEngine mContext=" + this.mContext);
        e.Bi().init(this.mContext);
        this.aAp = new c(this.mContext);
        this.aAp.a(this);
    }

    public void a(com.baidu.live.alablmsdk.c.b bVar) {
        this.aAq = bVar;
        com.baidu.live.alablmsdk.a.b.d("setEventListener");
        com.baidu.live.alablmsdk.a.b.fJ("setEventListener");
    }

    public void a(com.baidu.live.alablmsdk.c.a aVar) {
        com.baidu.live.alablmsdk.a.b.d("createRoom");
        com.baidu.live.alablmsdk.a.b.fJ("createRoom");
        this.aAp.a(aVar);
    }

    public void a(String str, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.d("joinRoom");
        com.baidu.live.alablmsdk.a.b.fJ("joinRoom");
        this.aAp.a(str, (com.baidu.live.alablmsdk.module.c) null, cVar);
    }

    public void a(String str, com.baidu.live.alablmsdk.module.c cVar, com.baidu.live.alablmsdk.c.c cVar2) {
        com.baidu.live.alablmsdk.a.b.d("joinRoom");
        com.baidu.live.alablmsdk.a.b.fJ("joinRoom");
        this.aAp.a(str, cVar, cVar2);
    }

    public void a(String str, List<com.baidu.live.alablmsdk.module.c> list, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.d("inviteUsers");
        com.baidu.live.alablmsdk.a.b.fJ("inviteUsers");
        this.aAp.a(str, list, jSONObject, cVar);
    }

    public void b(String str, List<com.baidu.live.alablmsdk.module.c> list, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.ah("cancelInviteUsers", "");
        this.aAp.b(str, list, jSONObject, cVar);
    }

    public void a(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.d("acceptRoom");
        com.baidu.live.alablmsdk.a.b.fJ("acceptRoom");
        this.aAp.a(str, jSONObject, cVar);
    }

    public void b(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.d("rejectRoom");
        com.baidu.live.alablmsdk.a.b.fJ("rejectRoom");
        this.aAp.b(str, jSONObject, cVar);
    }

    public void a(String str, JSONObject jSONObject, List<com.baidu.live.alablmsdk.module.c> list, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.ah("kickOffUsers", "");
        this.aAp.a(str, jSONObject, list, cVar);
    }

    public void c(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.d("leaveRoom");
        com.baidu.live.alablmsdk.a.b.fJ("leaveRoom");
        this.aAp.c(str, jSONObject, cVar);
    }

    public void d(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.d("closeRoom");
        com.baidu.live.alablmsdk.a.b.fJ("closeRoom");
        this.aAp.d(str, jSONObject, cVar);
    }

    public void v(HashMap<String, Object> hashMap) {
        com.baidu.live.alablmsdk.a.b.d("configParamSetting");
        com.baidu.live.alablmsdk.a.b.fJ("configParamSetting");
        this.aAp.v(hashMap);
    }

    public void a(com.baidu.live.alablmsdk.config.a aVar) {
        com.baidu.live.alablmsdk.a.b.d("configLiveStream");
        com.baidu.live.alablmsdk.a.b.fJ("configLiveStream");
        this.aAp.a(aVar);
    }

    public com.baidu.live.alablmsdk.d.a Be() {
        com.baidu.live.alablmsdk.a.b.d("getExternalMediaDevice");
        com.baidu.live.alablmsdk.a.b.fJ("getExternalMediaDevice");
        return this.aAp.Be();
    }

    public void aY(boolean z) {
        if (this.aAp != null) {
            com.baidu.live.alablmsdk.a.b.d("RtcMuteMicrophone" + z);
            com.baidu.live.alablmsdk.a.b.fJ("RtcMuteMicrophone" + z);
            this.aAp.aY(z);
        }
    }

    public static void aZ(boolean z) {
        com.baidu.live.alablmsdk.a.b.ah("setVerboseEnable", "");
        com.baidu.live.alablmsdk.a.b.aZ(z);
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void a(com.baidu.live.alablmsdk.module.rtc.a aVar, BLMStreamState bLMStreamState) {
        if (this.aAq != null) {
            this.aAq.a(aVar, bLMStreamState);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void a(com.baidu.live.alablmsdk.module.rtc.a aVar, int i) {
        if (this.aAq != null) {
            this.aAq.a(aVar, i);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void a(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.aAq != null) {
            this.aAq.a(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void b(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.aAq != null) {
            this.aAq.b(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void c(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.aAq != null) {
            this.aAq.c(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void a(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.aAq != null) {
            this.aAq.a(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void d(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.aAq != null) {
            this.aAq.d(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void e(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.aAq != null) {
            this.aAq.e(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void b(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.aAq != null) {
            this.aAq.b(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void c(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.aAq != null) {
            this.aAq.c(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void d(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.aAq != null) {
            this.aAq.d(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void fH(String str) {
        if (this.aAq != null) {
            this.aAq.fH(str);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void fI(String str) {
        if (this.aAq != null) {
            this.aAq.fI(str);
        }
    }

    public void onRelease() {
        com.baidu.live.alablmsdk.a.b.ah("onRelease", "");
        this.aAq = null;
        this.aAp.release();
    }
}
