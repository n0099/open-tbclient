package com.baidu.live.alablmsdk;

import android.content.Context;
import com.baidu.live.alablmsdk.a.d;
import com.baidu.live.alablmsdk.b.c;
import com.baidu.live.alablmsdk.c.b;
import com.baidu.live.alablmsdk.c.b.e;
import com.baidu.live.alablmsdk.config.enums.BLMLiveTransferMode;
import com.baidu.live.alablmsdk.module.rtc.BLMStreamState;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a implements b {
    private c axP;
    private b axQ;
    private Context mContext;

    public a(Context context) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine constructor", "");
        this.mContext = context.getApplicationContext();
        com.baidu.live.alablmsdk.a.b.a.d("engine mContext=" + this.mContext);
        d.xs().init(this.mContext);
        this.axP = new c(this.mContext);
        this.axP.a(this);
    }

    public void a(b bVar) {
        this.axQ = bVar;
        com.baidu.live.alablmsdk.a.b.a.ag("engine setEventListener", "");
    }

    public void eC(String str) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine setCloudRtcConfig", "" + str);
        this.axP.eC(str);
    }

    public void a(e eVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine setYYRtcGenTokenService", "");
        this.axP.a(eVar);
    }

    public void eD(String str) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine updateYYRtcToken", "");
        this.axP.eD(str);
    }

    public void a(com.baidu.live.alablmsdk.c.a aVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine createRoom", "");
        this.axP.a(aVar);
    }

    public void a(String str, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine joinRoom", "");
        this.axP.a(str, (com.baidu.live.alablmsdk.module.c) null, cVar);
    }

    public void a(String str, com.baidu.live.alablmsdk.module.c cVar, com.baidu.live.alablmsdk.c.c cVar2) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine joinRoom", "");
        this.axP.a(str, cVar, cVar2);
    }

    public void a(String str, List<com.baidu.live.alablmsdk.module.c> list, JSONObject jSONObject, com.baidu.live.alablmsdk.c.d dVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine inviteUsers", "");
        this.axP.a(str, list, jSONObject, dVar);
    }

    public void b(String str, List<com.baidu.live.alablmsdk.module.c> list, JSONObject jSONObject, com.baidu.live.alablmsdk.c.d dVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine cancelInviteUsers", "");
        this.axP.b(str, list, jSONObject, dVar);
    }

    public void a(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine acceptRoom", "");
        this.axP.a(str, jSONObject, cVar);
    }

    public void a(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.c.d dVar) {
        com.baidu.live.alablmsdk.a.b.a.eG("engine rejectRoom");
        this.axP.a(str, jSONObject, dVar);
    }

    public void a(String str, JSONObject jSONObject, List<com.baidu.live.alablmsdk.module.c> list, com.baidu.live.alablmsdk.c.d dVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine kickOffUsers", "");
        this.axP.a(str, jSONObject, list, dVar);
    }

    public void a(String str, boolean z, List<com.baidu.live.alablmsdk.module.c> list, com.baidu.live.alablmsdk.c.d dVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine shutUpUsers", "");
        this.axP.a(str, z, list, dVar);
    }

    public void b(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.c.d dVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine leaveRoom", "");
        this.axP.a(str, jSONObject, true, dVar);
    }

    public void c(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.c.d dVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine closeRoom", "");
        this.axP.a(str, false, jSONObject, true, dVar);
    }

    public void a(String str, boolean z, JSONObject jSONObject, com.baidu.live.alablmsdk.c.d dVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine closeRoom ignorePermission", "");
        this.axP.a(str, z, jSONObject, true, dVar);
    }

    public void v(HashMap<String, Object> hashMap) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine configParamSetting", "");
        this.axP.v(hashMap);
    }

    public int w(HashMap<String, Object> hashMap) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine updateParamSetting", "");
        return this.axP.w(hashMap);
    }

    public void a(com.baidu.live.alablmsdk.config.a aVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine configLiveStream", "");
        this.axP.a(aVar);
    }

    public void a(BLMLiveTransferMode bLMLiveTransferMode) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine startLiveServerStreaming mode" + bLMLiveTransferMode, "");
        this.axP.a(bLMLiveTransferMode);
    }

    public void b(BLMLiveTransferMode bLMLiveTransferMode) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine stopLiveServerStreaming mode " + bLMLiveTransferMode, "");
        this.axP.b(bLMLiveTransferMode);
    }

    public int a(com.baidu.live.alablmsdk.c.d dVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine publishStream", "");
        return this.axP.a(dVar);
    }

    public void xn() {
        com.baidu.live.alablmsdk.a.b.a.ag("engine stopPublishStream", "");
        this.axP.xn();
    }

    public com.baidu.live.alablmsdk.d.a xo() {
        return this.axP.xo();
    }

    public com.baidu.live.alablmsdk.d.b xp() {
        return this.axP.xp();
    }

    public void aY(boolean z) {
        if (this.axP != null) {
            com.baidu.live.alablmsdk.a.b.a.eG("engine RtcMuteMicrophone " + z);
            this.axP.aY(z);
        }
    }

    public void aZ(boolean z) {
        if (this.axP != null) {
            com.baidu.live.alablmsdk.a.b.a.ag("engine muteSpeaker", "");
            this.axP.aZ(z);
        }
    }

    public void a(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.axP != null) {
            this.axP.h(str, cVar);
        }
    }

    public void enterForeground() {
        com.baidu.live.alablmsdk.a.b.c.xx().markEnterForeground();
    }

    public void enterBackground() {
        com.baidu.live.alablmsdk.a.b.c.xx().markEnterBackground();
    }

    public static void ba(boolean z) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine setVerboseEnable", "");
        com.baidu.live.alablmsdk.a.b.a.ba(z);
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void g(int i, String str) {
        if (this.axQ != null) {
            this.axQ.g(i, str);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void a(com.baidu.live.alablmsdk.module.rtc.c cVar, BLMStreamState bLMStreamState) {
        if (this.axQ != null) {
            this.axQ.a(cVar, bLMStreamState);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void a(com.baidu.live.alablmsdk.module.rtc.c cVar, int i) {
        if (this.axQ != null) {
            this.axQ.a(cVar, i);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void a(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.axQ != null) {
            this.axQ.a(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void b(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.axQ != null) {
            this.axQ.b(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void c(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.axQ != null) {
            this.axQ.c(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void b(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.axQ != null) {
            this.axQ.b(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void d(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.axQ != null) {
            this.axQ.d(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void e(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.axQ != null) {
            this.axQ.e(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void c(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.axQ != null) {
            this.axQ.c(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void d(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.axQ != null) {
            this.axQ.d(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void e(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.axQ != null) {
            this.axQ.e(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void f(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.axQ != null) {
            this.axQ.f(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void g(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.axQ != null) {
            this.axQ.g(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void a(com.baidu.live.alablmsdk.module.rtc.a aVar) {
        if (this.axQ != null) {
            this.axQ.a(aVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void eE(String str) {
        if (this.axQ != null) {
            this.axQ.eE(str);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void onLogReport(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.axQ != null) {
            this.axQ.onLogReport(str, jSONObject, jSONObject2);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public String xq() {
        return null;
    }

    public void onRelease() {
        com.baidu.live.alablmsdk.a.b.a.ag("engine onRelease", "");
        this.axQ = null;
        this.axP.release();
    }
}
