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
/* loaded from: classes11.dex */
public class a implements b {
    private c awp;
    private b awq;
    private Context mContext;

    public a(Context context) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine constructor", "");
        this.mContext = context.getApplicationContext();
        com.baidu.live.alablmsdk.a.b.a.d("engine mContext=" + this.mContext);
        d.xp().init(this.mContext);
        this.awp = new c(this.mContext);
        this.awp.a(this);
    }

    public void a(b bVar) {
        this.awq = bVar;
        com.baidu.live.alablmsdk.a.b.a.ag("engine setEventListener", "");
    }

    public void ev(String str) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine setCloudRtcConfig", "" + str);
        this.awp.ev(str);
    }

    public void a(e eVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine setYYRtcGenTokenService", "");
        this.awp.a(eVar);
    }

    public void ew(String str) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine updateYYRtcToken", "");
        this.awp.ew(str);
    }

    public void a(com.baidu.live.alablmsdk.c.a aVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine createRoom", "");
        this.awp.a(aVar);
    }

    public void a(String str, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine joinRoom", "");
        this.awp.a(str, (com.baidu.live.alablmsdk.module.c) null, cVar);
    }

    public void a(String str, com.baidu.live.alablmsdk.module.c cVar, com.baidu.live.alablmsdk.c.c cVar2) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine joinRoom", "");
        this.awp.a(str, cVar, cVar2);
    }

    public void a(String str, List<com.baidu.live.alablmsdk.module.c> list, JSONObject jSONObject, com.baidu.live.alablmsdk.c.d dVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine inviteUsers", "");
        this.awp.a(str, list, jSONObject, dVar);
    }

    public void b(String str, List<com.baidu.live.alablmsdk.module.c> list, JSONObject jSONObject, com.baidu.live.alablmsdk.c.d dVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine cancelInviteUsers", "");
        this.awp.b(str, list, jSONObject, dVar);
    }

    public void a(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.c.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine acceptRoom", "");
        this.awp.a(str, jSONObject, cVar);
    }

    public void a(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.c.d dVar) {
        com.baidu.live.alablmsdk.a.b.a.eA("engine rejectRoom");
        this.awp.a(str, jSONObject, dVar);
    }

    public void a(String str, JSONObject jSONObject, List<com.baidu.live.alablmsdk.module.c> list, com.baidu.live.alablmsdk.c.d dVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine kickOffUsers", "");
        this.awp.a(str, jSONObject, list, dVar);
    }

    public void a(String str, boolean z, List<com.baidu.live.alablmsdk.module.c> list, com.baidu.live.alablmsdk.c.d dVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine shutUpUsers", "");
        this.awp.a(str, z, list, dVar);
    }

    public void b(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.c.d dVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine leaveRoom", "");
        this.awp.a(str, jSONObject, true, dVar);
    }

    public void c(String str, JSONObject jSONObject, com.baidu.live.alablmsdk.c.d dVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine closeRoom", "");
        this.awp.a(str, false, jSONObject, true, dVar);
    }

    public void a(String str, boolean z, JSONObject jSONObject, com.baidu.live.alablmsdk.c.d dVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine closeRoom ignorePermission", "");
        this.awp.a(str, z, jSONObject, true, dVar);
    }

    public void v(HashMap<String, Object> hashMap) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine configParamSetting", "");
        this.awp.v(hashMap);
    }

    public int w(HashMap<String, Object> hashMap) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine updateParamSetting", "");
        return this.awp.w(hashMap);
    }

    public void a(com.baidu.live.alablmsdk.config.a aVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine configLiveStream", "");
        this.awp.a(aVar);
    }

    public void a(BLMLiveTransferMode bLMLiveTransferMode) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine startLiveServerStreaming mode" + bLMLiveTransferMode, "");
        this.awp.a(bLMLiveTransferMode);
    }

    public void b(BLMLiveTransferMode bLMLiveTransferMode) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine stopLiveServerStreaming mode " + bLMLiveTransferMode, "");
        this.awp.b(bLMLiveTransferMode);
    }

    public int a(com.baidu.live.alablmsdk.c.d dVar) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine publishStream", "");
        return this.awp.a(dVar);
    }

    public void xk() {
        com.baidu.live.alablmsdk.a.b.a.ag("engine stopPublishStream", "");
        this.awp.xk();
    }

    public com.baidu.live.alablmsdk.d.a xl() {
        return this.awp.xl();
    }

    public com.baidu.live.alablmsdk.d.b xm() {
        return this.awp.xm();
    }

    public void aY(boolean z) {
        if (this.awp != null) {
            com.baidu.live.alablmsdk.a.b.a.eA("engine RtcMuteMicrophone " + z);
            this.awp.aY(z);
        }
    }

    public void aZ(boolean z) {
        if (this.awp != null) {
            com.baidu.live.alablmsdk.a.b.a.ag("engine muteSpeaker", "");
            this.awp.aZ(z);
        }
    }

    public void a(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.awp != null) {
            this.awp.h(str, cVar);
        }
    }

    public void enterForeground() {
        com.baidu.live.alablmsdk.a.b.c.xu().markEnterForeground();
    }

    public void enterBackground() {
        com.baidu.live.alablmsdk.a.b.c.xu().markEnterBackground();
    }

    public static void ba(boolean z) {
        com.baidu.live.alablmsdk.a.b.a.ag("engine setVerboseEnable", "");
        com.baidu.live.alablmsdk.a.b.a.ba(z);
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void g(int i, String str) {
        if (this.awq != null) {
            this.awq.g(i, str);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void a(com.baidu.live.alablmsdk.module.rtc.c cVar, BLMStreamState bLMStreamState) {
        if (this.awq != null) {
            this.awq.a(cVar, bLMStreamState);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void a(com.baidu.live.alablmsdk.module.rtc.c cVar, int i) {
        if (this.awq != null) {
            this.awq.a(cVar, i);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void a(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.awq != null) {
            this.awq.a(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void b(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.awq != null) {
            this.awq.b(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void c(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.awq != null) {
            this.awq.c(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void b(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.awq != null) {
            this.awq.b(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void d(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.awq != null) {
            this.awq.d(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void e(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        if (this.awq != null) {
            this.awq.e(str, cVar, jSONObject);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void c(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.awq != null) {
            this.awq.c(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void d(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.awq != null) {
            this.awq.d(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void e(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.awq != null) {
            this.awq.e(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void f(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.awq != null) {
            this.awq.f(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void g(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.awq != null) {
            this.awq.g(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void a(com.baidu.live.alablmsdk.module.rtc.a aVar) {
        if (this.awq != null) {
            this.awq.a(aVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void ey(String str) {
        if (this.awq != null) {
            this.awq.ey(str);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void onLogReport(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.awq != null) {
            this.awq.onLogReport(str, jSONObject, jSONObject2);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public String xn() {
        return null;
    }

    public void onRelease() {
        com.baidu.live.alablmsdk.a.b.a.ag("engine onRelease", "");
        this.awq = null;
        this.awp.release();
    }
}
