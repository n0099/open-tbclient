package com.baidu.live.alablmsdk.d;

import android.content.Context;
import android.view.View;
import com.baidu.live.alablmsdk.c.b.d;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class a {
    private c axS;
    private com.baidu.live.alablmsdk.c.a.a ayK;
    private Context mContext;
    private HashMap<Long, com.baidu.live.alablmsdk.c.b.c> ayJ = new HashMap<>();
    com.baidu.live.alablmsdk.c.a.a ayL = new com.baidu.live.alablmsdk.c.a.a() { // from class: com.baidu.live.alablmsdk.d.a.1
        @Override // com.baidu.live.alablmsdk.c.a.a
        public void onPixelRead(byte[] bArr, int i, int i2) {
            com.baidu.live.alablmsdk.a.b.c.xu().setVideoSize(i, i2);
            if (a.this.ayK != null) {
                a.this.ayK.onPixelRead(bArr, i, i2);
            }
        }

        @Override // com.baidu.live.alablmsdk.c.a.a
        public void onError(int i, String str) {
            com.baidu.live.alablmsdk.a.b.c.xu().onRecorderError(i, str);
            if (a.this.ayK != null) {
                a.this.ayK.onError(i, str);
            }
        }
    };
    private d ayM = new d() { // from class: com.baidu.live.alablmsdk.d.a.2
        @Override // com.baidu.live.alablmsdk.c.b.d
        public void ay(long j) {
            synchronized (a.this.ayJ) {
                com.baidu.live.alablmsdk.a.b.a.ag("out-media-device map remove , id=" + j, "");
                if (j != 0) {
                    a.this.ayJ.remove(Long.valueOf(j));
                }
            }
        }
    };

    public a(Context context, c cVar) {
        this.mContext = context;
        this.axS = cVar;
    }

    public void a(com.baidu.live.alablmsdk.c.a.a aVar) {
        this.ayK = aVar;
    }

    public com.baidu.live.alablmsdk.c.a.a yG() {
        return this.ayL;
    }

    public void i(boolean z, long j) {
        com.baidu.live.alablmsdk.a.b.a.ag("out-media-device enableRemoteDisplay ", "imUk=" + j);
        if (j != 0) {
            synchronized (this.ayJ) {
                if (z) {
                    aG(j);
                    yH();
                }
            }
        }
    }

    private void yH() {
        String str;
        com.baidu.live.alablmsdk.a.b.a.d("out-media-device mapDetailInfoForLog ");
        if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
            StringBuilder sb = new StringBuilder();
            if (this.ayJ.size() > 0) {
                for (Map.Entry<Long, com.baidu.live.alablmsdk.c.b.c> entry : this.ayJ.entrySet()) {
                    if (entry != null) {
                        com.baidu.live.alablmsdk.c.b.c value = entry.getValue();
                        if (value == null) {
                            str = "";
                        } else {
                            str = value.toString();
                        }
                        sb.append("    key=").append(entry.getKey()).append(str);
                    }
                }
            }
            com.baidu.live.alablmsdk.a.b.a.ag("out-media-device map for 循环 texture info = " + sb.toString(), "");
        }
        com.baidu.live.alablmsdk.a.b.a.ag("out-media-device remote user view num " + this.ayJ.size(), "");
    }

    private void aG(long j) {
        String str;
        com.baidu.live.alablmsdk.a.b.a.ag("out-media-device addRemoteUserRtcVideoView remoteUid" + j, "");
        synchronized (this.ayJ) {
            com.baidu.live.alablmsdk.c.b.c cVar = this.ayJ.get(Long.valueOf(j));
            if (cVar == null || !cVar.xM()) {
                if (cVar == null) {
                    str = "";
                } else {
                    str = cVar.toString();
                }
                com.baidu.live.alablmsdk.a.b.a.ag("out-media-device bd: map-externalTextureInfo info has null , remoteUid=" + j, " externalTextureInfo=" + str);
                com.baidu.live.alablmsdk.c.b.c a2 = this.axS.a(j, this.ayM);
                this.ayJ.put(Long.valueOf(j), a2);
                com.baidu.live.alablmsdk.a.b.a.ag("out-media-device bd: mapSize=" + this.ayJ.size() + " , tempExternalTextureInfo = " + a2.toString(), "");
            } else {
                com.baidu.live.alablmsdk.a.b.a.ag("out-media-device bd: map contains , remoteUid=" + j, "");
                this.axS.a(cVar, j);
            }
        }
    }

    public View j(com.baidu.live.alablmsdk.module.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.d("out-media-device getRemoteDisplayViewForUser user ");
        if (cVar == null || cVar.ayk == 0) {
            return null;
        }
        com.baidu.live.alablmsdk.a.b.a.ag("out-media-device getRemoteDisplayViewForUser", " imUk=" + cVar.ayk);
        return aH(cVar.ayk);
    }

    public View aH(long j) {
        View view;
        com.baidu.live.alablmsdk.a.b.a.d("out-media-device getRemoteDisplayViewForUser imUk ");
        if (j == 0) {
            return null;
        }
        synchronized (this.ayJ) {
            if (this.ayJ.containsKey(Long.valueOf(j))) {
                com.baidu.live.alablmsdk.a.b.a.ag("out-media-device mRemoteViewMap sizes " + this.ayJ.size(), "");
                com.baidu.live.alablmsdk.c.b.c cVar = this.ayJ.get(Long.valueOf(j));
                if (cVar != null) {
                    com.baidu.live.alablmsdk.a.b.a.ag("out-media-device get texture view by user , imUk=" + j + ", texture info=" + cVar.toString(), "");
                    view = cVar.yh();
                } else {
                    view = null;
                }
            } else {
                view = null;
            }
        }
        return view;
    }

    public void release() {
        yI();
    }

    public void yI() {
        yJ();
    }

    private void yJ() {
        com.baidu.live.alablmsdk.c.b.c value;
        com.baidu.live.alablmsdk.a.b.a.ag("out-media-device releaseVideoViewMap ", "");
        if (this.ayJ != null) {
            synchronized (this.ayJ) {
                for (Map.Entry<Long, com.baidu.live.alablmsdk.c.b.c> entry : this.ayJ.entrySet()) {
                    if (entry != null && (value = entry.getValue()) != null) {
                        value.release();
                    }
                }
                this.ayJ.clear();
            }
        }
    }
}
