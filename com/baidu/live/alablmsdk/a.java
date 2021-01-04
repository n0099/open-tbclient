package com.baidu.live.alablmsdk;

import android.content.Context;
import com.baidu.live.alablmsdk.a.d;
import com.baidu.live.alablmsdk.b.c;
import com.baidu.live.alablmsdk.c.b;
import com.baidu.live.alablmsdk.module.rtc.BLMStreamState;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements b {
    private c aBn;
    private b aBo;
    private Context mContext;

    public a(Context context) {
        com.baidu.live.alablmsdk.a.b.a.aj("BLMRtcEngine constructor", "");
        this.mContext = context.getApplicationContext();
        com.baidu.live.alablmsdk.a.b.a.d("BLMRtcEngine mContext=" + this.mContext);
        d.Bk().init(this.mContext);
        this.aBn = new c(this.mContext);
        this.aBn.a(this);
    }

    public void a(b bVar) {
        this.aBo = bVar;
        com.baidu.live.alablmsdk.a.b.a.d("setEventListener");
        com.baidu.live.alablmsdk.a.b.a.fI("setEventListener");
    }

    public void a(com.baidu.live.alablmsdk.c.a aVar) {
        com.baidu.live.alablmsdk.a.b.a.d("createRoom");
        com.baidu.live.alablmsdk.a.b.a.fI("createRoom");
        this.aBn.a(aVar);
    }

    public void a(String str, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.d("joinRoom");
        com.baidu.live.alablmsdk.a.b.a.fI("joinRoom");
        this.aBn.a(str, (com.baidu.live.alablmsdk.module.c) null, cVar);
    }

    public void a(String str, com.baidu.live.alablmsdk.module.c cVar, com.baidu.live.alablmsdk.c.c cVar2) {
        com.baidu.live.alablmsdk.a.b.a.d("joinRoom");
        com.baidu.live.alablmsdk.a.b.a.fI("joinRoom");
        this.aBn.a(str, cVar, cVar2);
    }

    public void a(String str, List<com.baidu.live.alablmsdk.module.c> list, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.d("inviteUsers");
        com.baidu.live.alablmsdk.a.b.a.fI("inviteUsers");
        this.aBn.a(str, list, jSONObject, cVar);
    }

    public void b(String str, List<com.baidu.live.alablmsdk.module.c> list, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.aj("cancelInviteUsers", "");
        this.aBn.b(str, list, jSONObject, cVar);
    }

    public void a(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.d("acceptRoom");
        com.baidu.live.alablmsdk.a.b.a.fI("acceptRoom");
        this.aBn.a(str, jSONObject, cVar);
    }

    public void b(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.d("rejectRoom");
        com.baidu.live.alablmsdk.a.b.a.fI("rejectRoom");
        this.aBn.b(str, jSONObject, cVar);
    }

    public void a(String str, JSONObject jSONObject, List<com.baidu.live.alablmsdk.module.c> list, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.aj("kickOffUsers", "");
        this.aBn.a(str, jSONObject, list, cVar);
    }

    public void c(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.d("leaveRoom");
        com.baidu.live.alablmsdk.a.b.a.fI("leaveRoom");
        this.aBn.a(str, jSONObject, true, cVar);
    }

    public void d(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.d("closeRoom");
        com.baidu.live.alablmsdk.a.b.a.fI("closeRoom");
        this.aBn.b(str, jSONObject, true, cVar);
    }

    public void v(HashMap<String, Object> hashMap) {
        com.baidu.live.alablmsdk.a.b.a.d("configParamSetting");
        com.baidu.live.alablmsdk.a.b.a.fI("configParamSetting");
        this.aBn.v(hashMap);
    }

    public void a(com.baidu.live.alablmsdk.config.a aVar) {
        com.baidu.live.alablmsdk.a.b.a.d("configLiveStream");
        com.baidu.live.alablmsdk.a.b.a.fI("configLiveStream");
        this.aBn.a(aVar);
    }

    public com.baidu.live.alablmsdk.d.a Bi() {
        com.baidu.live.alablmsdk.a.b.a.d("getExternalMediaDevice");
        com.baidu.live.alablmsdk.a.b.a.fI("getExternalMediaDevice");
        return this.aBn.Bi();
    }

    public void bd(boolean z) {
        if (this.aBn != null) {
            com.baidu.live.alablmsdk.a.b.a.d("RtcMuteMicrophone" + z);
            com.baidu.live.alablmsdk.a.b.a.fI("RtcMuteMicrophone" + z);
            this.aBn.bd(z);
        }
    }

    public void enterForeground() {
        com.baidu.live.alablmsdk.a.b.c.Bp().markEnterForeground();
    }

    public void enterBackground() {
        com.baidu.live.alablmsdk.a.b.c.Bp().markEnterBackground();
    }

    public static void be(boolean z) {
        com.baidu.live.alablmsdk.a.b.a.aj("setVerboseEnable", "");
        com.baidu.live.alablmsdk.a.b.a.be(z);
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void a(com.baidu.live.alablmsdk.module.rtc.a aVar, BLMStreamState bLMStreamState) {
        if (this.aBo != null) {
            this.aBo.a(aVar, bLMStreamState);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void a(com.baidu.live.alablmsdk.module.rtc.a aVar, int i) {
        if (this.aBo != null) {
            this.aBo.a(aVar, i);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void a(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.aBo != null) {
            this.aBo.a(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void b(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.aBo != null) {
            this.aBo.b(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void c(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.aBo != null) {
            this.aBo.c(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void a(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.aBo != null) {
            this.aBo.a(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void d(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.aBo != null) {
            this.aBo.d(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void e(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.aBo != null) {
            this.aBo.e(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void b(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.aBo != null) {
            this.aBo.b(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void c(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.aBo != null) {
            this.aBo.c(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void d(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.aBo != null) {
            this.aBo.d(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void fH(String str) {
        if (this.aBo != null) {
            this.aBo.fH(str);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void onLogReport(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.aBo != null) {
            this.aBo.onLogReport(str, jSONObject, jSONObject2);
        }
    }

    public void onRelease() {
        com.baidu.live.alablmsdk.a.b.a.aj("onRelease", "");
        this.aBo = null;
        this.aBn.release();
    }
}
