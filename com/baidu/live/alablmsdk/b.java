package com.baidu.live.alablmsdk;

import android.content.Context;
import com.baidu.live.alablmsdk.a.c;
import com.baidu.live.alablmsdk.a.e;
import com.baidu.live.alablmsdk.module.rtc.BLMStreamState;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class b implements com.baidu.live.alablmsdk.c.b {
    private com.baidu.live.alablmsdk.b.b aAp;
    private com.baidu.live.alablmsdk.c.b aAq;
    private Context mContext;

    public b(Context context) {
        c.fJ("BLMRtcEngine constructor");
        this.mContext = context.getApplicationContext();
        c.d("BLMRtcEngine mContext=" + this.mContext);
        e.Bj().init(this.mContext);
        this.aAp = new com.baidu.live.alablmsdk.b.b(this.mContext);
        this.aAp.a(this);
    }

    public void a(com.baidu.live.alablmsdk.c.b bVar) {
        this.aAq = bVar;
        c.d("setEventListener");
        c.fJ("setEventListener");
    }

    public void a(com.baidu.live.alablmsdk.c.a aVar) {
        c.d("createRoom");
        c.fJ("createRoom");
        this.aAp.a(aVar);
    }

    public void a(String str, com.baidu.live.alablmsdk.c.c cVar) {
        c.d("joinRoom");
        c.fJ("joinRoom");
        this.aAp.a(str, cVar);
    }

    public void a(String str, List<com.baidu.live.alablmsdk.module.c> list, String str2, com.baidu.live.alablmsdk.c.c cVar) {
        c.d("inviteUsers");
        c.fJ("inviteUsers");
        this.aAp.a(str, list, str2, cVar);
    }

    public void b(String str, List<com.baidu.live.alablmsdk.module.c> list, String str2, com.baidu.live.alablmsdk.c.c cVar) {
        c.d("cancelInviteUsers");
        c.fJ("cancelInviteUsers");
        this.aAp.b(str, list, str2, cVar);
    }

    public void a(String str, String str2, com.baidu.live.alablmsdk.c.c cVar) {
        c.d("acceptRoom");
        c.fJ("acceptRoom");
        this.aAp.a(str, str2, cVar);
    }

    public void b(String str, String str2, com.baidu.live.alablmsdk.c.c cVar) {
        c.d("rejectRoom");
        c.fJ("rejectRoom");
        this.aAp.b(str, str2, cVar);
    }

    public void c(String str, String str2, com.baidu.live.alablmsdk.c.c cVar) {
        c.d("leaveRoom");
        c.fJ("leaveRoom");
        this.aAp.c(str, str2, cVar);
    }

    public void d(String str, String str2, com.baidu.live.alablmsdk.c.c cVar) {
        c.d("closeRoom");
        c.fJ("closeRoom");
        this.aAp.d(str, str2, cVar);
    }

    public void v(HashMap<String, Object> hashMap) {
        c.d("configParamSetting");
        c.fJ("configParamSetting");
        this.aAp.v(hashMap);
    }

    public void a(com.baidu.live.alablmsdk.config.a aVar) {
        c.d("configLiveStream");
        c.fJ("configLiveStream");
        this.aAp.a(aVar);
    }

    public com.baidu.live.alablmsdk.d.a Be() {
        c.d("getExternalMediaDevice");
        c.fJ("getExternalMediaDevice");
        return this.aAp.Be();
    }

    public void aY(boolean z) {
        if (this.aAp != null) {
            c.d("RtcMuteMicrophone" + z);
            c.fJ("RtcMuteMicrophone" + z);
            this.aAp.aY(z);
        }
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
    public void a(String str, com.baidu.live.alablmsdk.module.c cVar, String str2) {
        if (this.aAq != null) {
            this.aAq.a(str, cVar, str2);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void b(String str, com.baidu.live.alablmsdk.module.c cVar, String str2) {
        if (this.aAq != null) {
            this.aAq.b(str, cVar, str2);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void c(String str, com.baidu.live.alablmsdk.module.c cVar, String str2) {
        if (this.aAq != null) {
            this.aAq.c(str, cVar, str2);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void a(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.aAq != null) {
            this.aAq.a(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void d(String str, com.baidu.live.alablmsdk.module.c cVar, String str2) {
        if (this.aAq != null) {
            this.aAq.d(str, cVar, str2);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void e(String str, com.baidu.live.alablmsdk.module.c cVar, String str2) {
        if (this.aAq != null) {
            this.aAq.e(str, cVar, str2);
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
        c.d("onRelease");
        c.fJ("onRelease");
        this.aAq = null;
        this.aAp.release();
    }
}
