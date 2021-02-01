package com.baidu.live.alablmsdk.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.baidu.live.alablmsdk.c.b.f;
import com.baidu.live.alablmsdk.c.b.g;
import com.baidu.live.alablmsdk.config.enums.BLMLiveTransferMode;
import com.baidu.live.alablmsdk.config.enums.BLMRtcType;
import com.baidu.live.alablmsdk.config.enums.RtcForceType;
import com.baidu.live.alablmsdk.d.b.e;
import com.baidu.live.alablmsdk.module.rtc.BLMJoinRoomStage;
import com.baidu.live.alablmsdk.module.rtc.d;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes11.dex */
public class c implements g {
    private g ayO;
    private boolean ayP;
    private f ayQ;
    private com.baidu.live.alablmsdk.c.a.a ayR;
    private Context mContext;
    private boolean hasInit = false;
    private com.baidu.live.alablmsdk.c.a.a ayS = new com.baidu.live.alablmsdk.c.a.a() { // from class: com.baidu.live.alablmsdk.d.c.1
        @Override // com.baidu.live.alablmsdk.c.a.a
        public void onPixelRead(byte[] bArr, int i, int i2) {
            if (c.this.ayR != null) {
                c.this.ayR.onPixelRead(bArr, i, i2);
            }
        }

        @Override // com.baidu.live.alablmsdk.c.a.a
        public void onError(int i, String str) {
        }
    };

    public c(Context context) {
        this.mContext = context;
    }

    private void a(RtcForceType rtcForceType, boolean z) {
        if (!this.hasInit) {
            this.ayP = z;
            if (rtcForceType == RtcForceType.BAIDU_RTC) {
                this.ayP = true;
            } else if (rtcForceType == RtcForceType.YY_RTC) {
                this.ayP = false;
            }
            if (this.ayP) {
                com.baidu.live.alablmsdk.a.b.a.ag(" RtcServiceProxy init new BdRtcRoom ", "");
                this.ayO = new com.baidu.live.alablmsdk.d.a.c(this.mContext);
                com.baidu.live.alablmsdk.a.b.c.xu().eG("bdcloud");
                Log.d("blmsdk", com.baidu.pass.biometrics.face.liveness.d.b.f4046a);
            } else {
                com.baidu.live.alablmsdk.a.b.a.ag(" RtcServiceProxy init new YYRtcRoom ", "");
                this.ayO = new e(this.mContext);
                com.baidu.live.alablmsdk.a.b.c.xu().eG("yy");
                Log.d("blmsdk", "y");
            }
            this.ayR = this.ayO.yn();
            this.ayO.a(this.ayQ);
            this.hasInit = true;
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void a(f fVar) {
        this.ayQ = fVar;
    }

    public boolean yK() {
        return this.ayP;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void v(HashMap<String, Object> hashMap) {
        RtcForceType rtcForceType;
        Object obj;
        Object obj2;
        com.baidu.live.alablmsdk.config.b.xN().xO();
        BLMRtcType bLMRtcType = BLMRtcType.BDRTC;
        if (hashMap != null && hashMap.containsKey("rtc_business_source_key") && (obj2 = hashMap.get("rtc_business_source_key")) != null) {
            BLMRtcType eJ = com.baidu.live.alablmsdk.config.b.xN().eJ((String) obj2);
            bLMRtcType = eJ == BLMRtcType.NONE ? BLMRtcType.BDRTC : eJ;
        }
        RtcForceType rtcForceType2 = RtcForceType.DEFAULT;
        if (hashMap == null || !hashMap.containsKey("rtc_force_type_key") || (obj = hashMap.get("rtc_force_type_key")) == null || !(obj instanceof RtcForceType)) {
            rtcForceType = rtcForceType2;
        } else {
            rtcForceType = (RtcForceType) obj;
            com.baidu.live.alablmsdk.a.b.a.ag(" config mIsForceYY " + rtcForceType, "");
        }
        a(rtcForceType, BLMRtcType.BDRTC == bLMRtcType);
        if (this.ayO != null) {
            this.ayO.v(hashMap);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public int w(HashMap<String, Object> hashMap) {
        if (this.ayO == null) {
            return 1000;
        }
        return this.ayO.w(hashMap);
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void a(com.baidu.live.alablmsdk.config.a aVar) {
        if (this.ayO != null) {
            this.ayO.a(aVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void a(BLMLiveTransferMode bLMLiveTransferMode) {
        if (this.ayO != null) {
            this.ayO.a(bLMLiveTransferMode);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void b(BLMLiveTransferMode bLMLiveTransferMode) {
        if (this.ayO != null) {
            this.ayO.b(bLMLiveTransferMode);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public int yi() {
        if (this.ayO != null) {
            return this.ayO.yi();
        }
        return 1000;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void xk() {
        if (this.ayO != null) {
            this.ayO.xk();
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void eN(String str) {
        if (this.ayO != null) {
            this.ayO.eN(str);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void aY(boolean z) {
        if (this.ayO != null) {
            this.ayO.aY(z);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void aZ(boolean z) {
        if (this.ayO != null) {
            this.ayO.aZ(z);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void setUserAttribute(String str) {
        if (this.ayO != null) {
            this.ayO.setUserAttribute(str);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void b(String str, List<com.baidu.live.alablmsdk.module.c> list, boolean z) {
        if (this.ayO != null) {
            this.ayO.b(str, list, z);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void yj() {
        if (this.ayO != null) {
            this.ayO.yj();
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public d yk() {
        if (this.ayO != null) {
            return this.ayO.yk();
        }
        return null;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public boolean h(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.ayO != null) {
            return this.ayO.h(str, cVar);
        }
        return false;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public boolean yl() {
        if (this.ayO != null) {
            return this.ayO.yl();
        }
        return false;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public String ym() {
        if (this.ayO != null) {
            return this.ayO.ym();
        }
        return null;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public com.baidu.live.alablmsdk.c.a.a yn() {
        return this.ayS;
    }

    public void a(com.baidu.live.alablmsdk.module.rtc.b bVar, com.baidu.live.alablmsdk.c.c cVar) {
        if (bVar != null) {
            if (yK()) {
                if (!TextUtils.isEmpty(bVar.axH) && !TextUtils.isEmpty(bVar.ayF) && !TextUtils.isEmpty(bVar.ayE) && bVar.ayG != 0) {
                    if (this.ayO != null && (this.ayO instanceof com.baidu.live.alablmsdk.d.a.c)) {
                        ((com.baidu.live.alablmsdk.d.a.c) this.ayO).c(bVar.axH, bVar.ayE, bVar.ayF, bVar.ayG);
                    }
                } else if (cVar != null) {
                    com.baidu.live.alablmsdk.module.common.a aVar = new com.baidu.live.alablmsdk.module.common.a();
                    aVar.msg = "bd rtc joinRoom baseInfo check error";
                    cVar.a(-1, BLMJoinRoomStage.JOIN, aVar);
                }
            } else if (this.ayO != null && (this.ayO instanceof e)) {
                ((e) this.ayO).eY(bVar.axH);
            } else if (cVar != null) {
                com.baidu.live.alablmsdk.module.common.a aVar2 = new com.baidu.live.alablmsdk.module.common.a();
                aVar2.msg = " yy rtc joinRoom mRtcRoom check error";
                cVar.a(-1, BLMJoinRoomStage.JOIN, aVar2);
            }
        } else if (cVar != null) {
            com.baidu.live.alablmsdk.module.common.a aVar3 = new com.baidu.live.alablmsdk.module.common.a();
            aVar3.msg = "joinRoom baseInfo null";
            cVar.a(-1, BLMJoinRoomStage.JOIN, aVar3);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void az(long j) {
        if (this.ayO != null) {
            this.ayO.az(j);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void yo() {
        if (this.ayO != null) {
            this.ayO.yo();
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void yp() {
        if (this.ayO != null) {
            this.ayO.yp();
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void release() {
        if (this.ayO != null) {
            this.ayO.release();
            com.baidu.live.alablmsdk.config.b.xN().xP();
        }
    }

    public void setExternalSurface(long j, Surface surface) {
        if (this.ayO != null && (this.ayO instanceof com.baidu.live.alablmsdk.d.a.c)) {
            ((com.baidu.live.alablmsdk.d.a.c) this.ayO).setExternalSurface(j, surface);
        }
    }

    public void changeSurfaceSize(long j, int i, int i2) {
        if (this.ayO != null && (this.ayO instanceof com.baidu.live.alablmsdk.d.a.c)) {
            ((com.baidu.live.alablmsdk.d.a.c) this.ayO).changeSurfaceSize(j, i, i2);
        }
    }

    public void destroyExternalSurface(long j, Surface surface) {
        if (this.ayO != null && (this.ayO instanceof com.baidu.live.alablmsdk.d.a.c)) {
            ((com.baidu.live.alablmsdk.d.a.c) this.ayO).destroyExternalSurface(j, surface);
        }
    }

    public com.baidu.live.alablmsdk.c.b.c a(long j, com.baidu.live.alablmsdk.c.b.d dVar) {
        if (yK()) {
            com.baidu.live.alablmsdk.a.b.a.ag(" create external texture info ", " bd rtc ");
            com.baidu.live.alablmsdk.d.a.b bVar = new com.baidu.live.alablmsdk.d.a.b(this.mContext, this, j);
            bVar.a(dVar);
            com.baidu.live.alablmsdk.a.b.a.d(" create external texture info return. bd ");
            return bVar;
        }
        com.baidu.live.alablmsdk.a.b.a.ag(" create external texture info ", " yy rtc ");
        com.baidu.live.alablmsdk.d.b.c cVar = new com.baidu.live.alablmsdk.d.b.c(this.mContext);
        cVar.a(dVar);
        if (this.ayO instanceof e) {
            ((e) this.ayO).d(cVar.yh(), j + "");
        }
        com.baidu.live.alablmsdk.a.b.a.d(" create external texture info return. yy ");
        return cVar;
    }

    public void a(com.baidu.live.alablmsdk.c.b.c cVar, final long j) {
        if (cVar != null && j != 0) {
            if (yK()) {
                if (cVar instanceof com.baidu.live.alablmsdk.d.a.b) {
                    final com.baidu.live.alablmsdk.d.a.b bVar = (com.baidu.live.alablmsdk.d.a.b) cVar;
                    final int i = bVar.mWidth;
                    final int i2 = bVar.mHeight;
                    com.baidu.live.alablmsdk.a.b.a.ag(" bd rtc: map contains , remoteId=" + j + " , info=" + bVar, "");
                    if (bVar.mSurface != null) {
                        com.baidu.live.alablmsdk.a.c.xo().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.2
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.live.alablmsdk.a.b.a.ag(" bd rtc: re destroy set ExternalSurface , width=" + i + " , height=" + i2, "");
                                c.this.destroyExternalSurface(j, bVar.mSurface);
                                c.this.setExternalSurface(j, bVar.mSurface);
                                c.this.changeSurfaceSize(j, i, i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                com.baidu.live.alablmsdk.a.b.a.ag(" note: error , isBdRtc , textureInfo not instanceof BdRemoteTextureInfo", "");
                return;
            } else if (this.ayO instanceof e) {
                ((e) this.ayO).d(cVar.yh(), j + "");
                return;
            } else {
                com.baidu.live.alablmsdk.a.b.a.ag(" note: error , is not BdRtc, but mRtcRoom not instanceof YYRtcRoom", "");
                return;
            }
        }
        com.baidu.live.alablmsdk.a.b.a.ag(" note: error , updateExternalTextureInfo textureInfo==null or remoteId==0", "");
    }

    public void ev(String str) {
        com.baidu.live.alablmsdk.config.b.xN().ev(str);
        com.baidu.live.alablmsdk.a.b.a.eA(" setCloudRtcConfig =" + str);
    }

    public void a(com.baidu.live.alablmsdk.c.b.e eVar) {
        if (this.ayO != null && (this.ayO instanceof e)) {
            ((e) this.ayO).a(eVar);
        }
    }

    public void ew(String str) {
        if (this.ayO != null && (this.ayO instanceof e)) {
            ((e) this.ayO).ew(str);
            com.baidu.live.alablmsdk.a.b.a.eA(" updateYYRtcToken =" + str);
        }
    }
}
