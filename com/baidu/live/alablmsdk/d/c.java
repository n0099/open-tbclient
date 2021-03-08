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
/* loaded from: classes10.dex */
public class c implements g {
    private g aAo;
    private boolean aAp;
    private f aAq;
    private com.baidu.live.alablmsdk.c.a.a aAr;
    private Context mContext;
    private boolean hasInit = false;
    private com.baidu.live.alablmsdk.c.a.a aAs = new com.baidu.live.alablmsdk.c.a.a() { // from class: com.baidu.live.alablmsdk.d.c.1
        @Override // com.baidu.live.alablmsdk.c.a.a
        public void onPixelRead(byte[] bArr, int i, int i2) {
            if (c.this.aAr != null) {
                c.this.aAr.onPixelRead(bArr, i, i2);
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
            this.aAp = z;
            if (rtcForceType == RtcForceType.BAIDU_RTC) {
                this.aAp = true;
            } else if (rtcForceType == RtcForceType.YY_RTC) {
                this.aAp = false;
            }
            if (this.aAp) {
                com.baidu.live.alablmsdk.a.b.a.ag(" RtcServiceProxy init new BdRtcRoom ", "");
                this.aAo = new com.baidu.live.alablmsdk.d.a.c(this.mContext);
                com.baidu.live.alablmsdk.a.b.c.xx().eM("bdcloud");
                Log.d("blmsdk", com.baidu.pass.biometrics.face.liveness.d.b.f2804a);
            } else {
                com.baidu.live.alablmsdk.a.b.a.ag(" RtcServiceProxy init new YYRtcRoom ", "");
                this.aAo = new e(this.mContext);
                com.baidu.live.alablmsdk.a.b.c.xx().eM("yy");
                Log.d("blmsdk", "y");
            }
            this.aAr = this.aAo.yq();
            this.aAo.a(this.aAq);
            this.hasInit = true;
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void a(f fVar) {
        this.aAq = fVar;
    }

    public boolean yN() {
        return this.aAp;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void v(HashMap<String, Object> hashMap) {
        RtcForceType rtcForceType;
        Object obj;
        Object obj2;
        com.baidu.live.alablmsdk.config.b.xQ().xR();
        BLMRtcType bLMRtcType = BLMRtcType.BDRTC;
        if (hashMap != null && hashMap.containsKey("rtc_business_source_key") && (obj2 = hashMap.get("rtc_business_source_key")) != null) {
            BLMRtcType eP = com.baidu.live.alablmsdk.config.b.xQ().eP((String) obj2);
            bLMRtcType = eP == BLMRtcType.NONE ? BLMRtcType.BDRTC : eP;
        }
        RtcForceType rtcForceType2 = RtcForceType.DEFAULT;
        if (hashMap == null || !hashMap.containsKey("rtc_force_type_key") || (obj = hashMap.get("rtc_force_type_key")) == null || !(obj instanceof RtcForceType)) {
            rtcForceType = rtcForceType2;
        } else {
            rtcForceType = (RtcForceType) obj;
            com.baidu.live.alablmsdk.a.b.a.ag(" config mIsForceYY " + rtcForceType, "");
        }
        a(rtcForceType, BLMRtcType.BDRTC == bLMRtcType);
        if (this.aAo != null) {
            this.aAo.v(hashMap);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public int w(HashMap<String, Object> hashMap) {
        if (this.aAo == null) {
            return 1000;
        }
        return this.aAo.w(hashMap);
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void a(com.baidu.live.alablmsdk.config.a aVar) {
        if (this.aAo != null) {
            this.aAo.a(aVar);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void a(BLMLiveTransferMode bLMLiveTransferMode) {
        if (this.aAo != null) {
            this.aAo.a(bLMLiveTransferMode);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void b(BLMLiveTransferMode bLMLiveTransferMode) {
        if (this.aAo != null) {
            this.aAo.b(bLMLiveTransferMode);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public int yl() {
        if (this.aAo != null) {
            return this.aAo.yl();
        }
        return 1000;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void xn() {
        if (this.aAo != null) {
            this.aAo.xn();
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void eT(String str) {
        if (this.aAo != null) {
            this.aAo.eT(str);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void aY(boolean z) {
        if (this.aAo != null) {
            this.aAo.aY(z);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void aZ(boolean z) {
        if (this.aAo != null) {
            this.aAo.aZ(z);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void setUserAttribute(String str) {
        if (this.aAo != null) {
            this.aAo.setUserAttribute(str);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void b(String str, List<com.baidu.live.alablmsdk.module.c> list, boolean z) {
        if (this.aAo != null) {
            this.aAo.b(str, list, z);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void ym() {
        if (this.aAo != null) {
            this.aAo.ym();
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public d yn() {
        if (this.aAo != null) {
            return this.aAo.yn();
        }
        return null;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public boolean h(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (this.aAo != null) {
            return this.aAo.h(str, cVar);
        }
        return false;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public boolean yo() {
        if (this.aAo != null) {
            return this.aAo.yo();
        }
        return false;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public String yp() {
        if (this.aAo != null) {
            return this.aAo.yp();
        }
        return null;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public com.baidu.live.alablmsdk.c.a.a yq() {
        return this.aAs;
    }

    public void a(com.baidu.live.alablmsdk.module.rtc.b bVar, com.baidu.live.alablmsdk.c.c cVar) {
        if (bVar != null) {
            if (yN()) {
                if (!TextUtils.isEmpty(bVar.azh) && !TextUtils.isEmpty(bVar.aAf) && !TextUtils.isEmpty(bVar.aAe) && bVar.aAg != 0) {
                    if (this.aAo != null && (this.aAo instanceof com.baidu.live.alablmsdk.d.a.c)) {
                        ((com.baidu.live.alablmsdk.d.a.c) this.aAo).c(bVar.azh, bVar.aAe, bVar.aAf, bVar.aAg);
                    }
                } else if (cVar != null) {
                    com.baidu.live.alablmsdk.module.common.a aVar = new com.baidu.live.alablmsdk.module.common.a();
                    aVar.msg = "bd rtc joinRoom baseInfo check error";
                    cVar.a(-1, BLMJoinRoomStage.JOIN, aVar);
                }
            } else if (this.aAo != null && (this.aAo instanceof e)) {
                ((e) this.aAo).fe(bVar.azh);
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
        if (this.aAo != null) {
            this.aAo.az(j);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void yr() {
        if (this.aAo != null) {
            this.aAo.yr();
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void ys() {
        if (this.aAo != null) {
            this.aAo.ys();
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void release() {
        if (this.aAo != null) {
            this.aAo.release();
            com.baidu.live.alablmsdk.config.b.xQ().xS();
        }
    }

    public void setExternalSurface(long j, Surface surface) {
        if (this.aAo != null && (this.aAo instanceof com.baidu.live.alablmsdk.d.a.c)) {
            ((com.baidu.live.alablmsdk.d.a.c) this.aAo).setExternalSurface(j, surface);
        }
    }

    public void changeSurfaceSize(long j, int i, int i2) {
        if (this.aAo != null && (this.aAo instanceof com.baidu.live.alablmsdk.d.a.c)) {
            ((com.baidu.live.alablmsdk.d.a.c) this.aAo).changeSurfaceSize(j, i, i2);
        }
    }

    public void destroyExternalSurface(long j, Surface surface) {
        if (this.aAo != null && (this.aAo instanceof com.baidu.live.alablmsdk.d.a.c)) {
            ((com.baidu.live.alablmsdk.d.a.c) this.aAo).destroyExternalSurface(j, surface);
        }
    }

    public com.baidu.live.alablmsdk.c.b.c a(long j, com.baidu.live.alablmsdk.c.b.d dVar) {
        if (yN()) {
            com.baidu.live.alablmsdk.a.b.a.ag(" create external texture info ", " bd rtc ");
            com.baidu.live.alablmsdk.d.a.b bVar = new com.baidu.live.alablmsdk.d.a.b(this.mContext, this, j);
            bVar.a(dVar);
            com.baidu.live.alablmsdk.a.b.a.d(" create external texture info return. bd ");
            return bVar;
        }
        com.baidu.live.alablmsdk.a.b.a.ag(" create external texture info ", " yy rtc ");
        com.baidu.live.alablmsdk.d.b.c cVar = new com.baidu.live.alablmsdk.d.b.c(this.mContext);
        cVar.a(dVar);
        if (this.aAo instanceof e) {
            ((e) this.aAo).d(cVar.yk(), j + "");
        }
        com.baidu.live.alablmsdk.a.b.a.d(" create external texture info return. yy ");
        return cVar;
    }

    public void a(com.baidu.live.alablmsdk.c.b.c cVar, final long j) {
        if (cVar != null && j != 0) {
            if (yN()) {
                if (cVar instanceof com.baidu.live.alablmsdk.d.a.b) {
                    final com.baidu.live.alablmsdk.d.a.b bVar = (com.baidu.live.alablmsdk.d.a.b) cVar;
                    final int i = bVar.mWidth;
                    final int i2 = bVar.mHeight;
                    com.baidu.live.alablmsdk.a.b.a.ag(" bd rtc: map contains , remoteId=" + j + " , info=" + bVar, "");
                    if (bVar.mSurface != null) {
                        com.baidu.live.alablmsdk.a.c.xr().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.2
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
            } else if (this.aAo instanceof e) {
                ((e) this.aAo).d(cVar.yk(), j + "");
                return;
            } else {
                com.baidu.live.alablmsdk.a.b.a.ag(" note: error , is not BdRtc, but mRtcRoom not instanceof YYRtcRoom", "");
                return;
            }
        }
        com.baidu.live.alablmsdk.a.b.a.ag(" note: error , updateExternalTextureInfo textureInfo==null or remoteId==0", "");
    }

    public void eC(String str) {
        com.baidu.live.alablmsdk.config.b.xQ().eC(str);
        com.baidu.live.alablmsdk.a.b.a.eG(" setCloudRtcConfig =" + str);
    }

    public void a(com.baidu.live.alablmsdk.c.b.e eVar) {
        if (this.aAo != null && (this.aAo instanceof e)) {
            ((e) this.aAo).a(eVar);
        }
    }

    public void eD(String str) {
        if (this.aAo != null && (this.aAo instanceof e)) {
            ((e) this.aAo).eD(str);
            com.baidu.live.alablmsdk.a.b.a.eG(" updateYYRtcToken =" + str);
        }
    }
}
