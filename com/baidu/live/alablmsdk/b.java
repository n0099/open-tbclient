package com.baidu.live.alablmsdk;

import android.content.Context;
import com.baidu.live.alablmsdk.a.c;
import com.baidu.live.alablmsdk.a.e;
import com.baidu.live.alablmsdk.module.rtc.BLMStreamState;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class b implements com.baidu.live.alablmsdk.c.b {
    private com.baidu.live.alablmsdk.b.b aAk;
    private com.baidu.live.alablmsdk.c.b aAl;
    private Context mContext;

    public b(Context context) {
        c.fJ("BLMRtcEngine constructor");
        this.mContext = context.getApplicationContext();
        c.d("BLMRtcEngine mContext=" + this.mContext);
        e.Bj().init(this.mContext);
        this.aAk = new com.baidu.live.alablmsdk.b.b(this.mContext);
        this.aAk.a(this);
    }

    public void a(com.baidu.live.alablmsdk.c.b bVar) {
        this.aAl = bVar;
        c.d("setEventListener");
        c.fJ("setEventListener");
    }

    public void a(com.baidu.live.alablmsdk.c.a aVar) {
        c.d("createRoom");
        c.fJ("createRoom");
        this.aAk.a(aVar);
    }

    public void a(String str, com.baidu.live.alablmsdk.c.c cVar) {
        c.d("joinRoom");
        c.fJ("joinRoom");
        this.aAk.a(str, cVar);
    }

    public void a(String str, List<com.baidu.live.alablmsdk.module.c> list, String str2, com.baidu.live.alablmsdk.c.c cVar) {
        c.d("inviteUsers");
        c.fJ("inviteUsers");
        this.aAk.a(str, list, str2, cVar);
    }

    public void b(String str, List<com.baidu.live.alablmsdk.module.c> list, String str2, com.baidu.live.alablmsdk.c.c cVar) {
        c.d("cancelInviteUsers");
        c.fJ("cancelInviteUsers");
        this.aAk.b(str, list, str2, cVar);
    }

    public void a(String str, String str2, com.baidu.live.alablmsdk.c.c cVar) {
        c.d("acceptRoom");
        c.fJ("acceptRoom");
        this.aAk.a(str, str2, cVar);
    }

    public void b(String str, String str2, com.baidu.live.alablmsdk.c.c cVar) {
        c.d("rejectRoom");
        c.fJ("rejectRoom");
        this.aAk.b(str, str2, cVar);
    }

    public void c(String str, String str2, com.baidu.live.alablmsdk.c.c cVar) {
        c.d("leaveRoom");
        c.fJ("leaveRoom");
        this.aAk.c(str, str2, cVar);
    }

    public void d(String str, String str2, com.baidu.live.alablmsdk.c.c cVar) {
        c.d("closeRoom");
        c.fJ("closeRoom");
        this.aAk.d(str, str2, cVar);
    }

    public void v(HashMap<String, Object> hashMap) {
        c.d("configParamSetting");
        c.fJ("configParamSetting");
        this.aAk.v(hashMap);
    }

    public void a(com.baidu.live.alablmsdk.config.a aVar) {
        c.d("configLiveStream");
        c.fJ("configLiveStream");
        this.aAk.a(aVar);
    }

    public com.baidu.live.alablmsdk.d.a Be() {
        c.d("getExternalMediaDevice");
        c.fJ("getExternalMediaDevice");
        return this.aAk.Be();
    }

    public void aY(boolean z) {
        if (this.aAk != null) {
            c.d("RtcMuteMicrophone" + z);
            c.fJ("RtcMuteMicrophone" + z);
            this.aAk.aY(z);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void a(com.baidu.live.alablmsdk.module.rtc.a aVar, BLMStreamState bLMStreamState) {
        if (this.aAl != null) {
            this.aAl.a(aVar, bLMStreamState);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void a(com.baidu.live.alablmsdk.module.rtc.a aVar, int i) {
        if (this.aAl != null) {
            this.aAl.a(aVar, i);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void a(String str, com.baidu.live.alablmsdk.module.c cVar, String str2) {
        if (this.aAl != null) {
            this.aAl.a(str, cVar, str2);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void b(String str, com.baidu.live.alablmsdk.module.c cVar, String str2) {
        if (this.aAl != null) {
            this.aAl.b(str, cVar, str2);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void c(String str, com.baidu.live.alablmsdk.module.c cVar, String str2) {
        if (this.aAl != null) {
            this.aAl.c(str, cVar, str2);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void a(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.aAl != null) {
            this.aAl.a(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void d(String str, com.baidu.live.alablmsdk.module.c cVar, String str2) {
        if (this.aAl != null) {
            this.aAl.d(str, cVar, str2);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void e(String str, com.baidu.live.alablmsdk.module.c cVar, String str2) {
        if (this.aAl != null) {
            this.aAl.e(str, cVar, str2);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void b(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.aAl != null) {
            this.aAl.b(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void c(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.aAl != null) {
            this.aAl.c(str, cVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void fH(String str) {
        if (this.aAl != null) {
            this.aAl.fH(str);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b
    public void fI(String str) {
        if (this.aAl != null) {
            this.aAl.fI(str);
        }
    }

    public void onRelease() {
        c.d("onRelease");
        c.fJ("onRelease");
        this.aAl = null;
        this.aAk.release();
    }
}
