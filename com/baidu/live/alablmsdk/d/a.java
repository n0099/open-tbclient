package com.baidu.live.alablmsdk.d;

import android.content.Context;
import android.view.View;
import com.baidu.live.alablmsdk.c.b.d;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class a {
    private com.baidu.live.alablmsdk.c.a.a aAk;
    private c azs;
    private Context mContext;
    private HashMap<Long, com.baidu.live.alablmsdk.c.b.c> aAj = new HashMap<>();
    com.baidu.live.alablmsdk.c.a.a aAl = new com.baidu.live.alablmsdk.c.a.a() { // from class: com.baidu.live.alablmsdk.d.a.1
        @Override // com.baidu.live.alablmsdk.c.a.a
        public void onPixelRead(byte[] bArr, int i, int i2) {
            com.baidu.live.alablmsdk.a.b.c.xx().setVideoSize(i, i2);
            if (a.this.aAk != null) {
                a.this.aAk.onPixelRead(bArr, i, i2);
            }
        }

        @Override // com.baidu.live.alablmsdk.c.a.a
        public void onError(int i, String str) {
            com.baidu.live.alablmsdk.a.b.c.xx().onRecorderError(i, str);
            if (a.this.aAk != null) {
                a.this.aAk.onError(i, str);
            }
        }
    };
    private d aAm = new d() { // from class: com.baidu.live.alablmsdk.d.a.2
        @Override // com.baidu.live.alablmsdk.c.b.d
        public void ay(long j) {
            synchronized (a.this.aAj) {
                com.baidu.live.alablmsdk.a.b.a.ag("out-media-device map remove , id=" + j, "");
                if (j != 0) {
                    a.this.aAj.remove(Long.valueOf(j));
                }
            }
        }
    };

    public a(Context context, c cVar) {
        this.mContext = context;
        this.azs = cVar;
    }

    public void a(com.baidu.live.alablmsdk.c.a.a aVar) {
        this.aAk = aVar;
    }

    public com.baidu.live.alablmsdk.c.a.a yJ() {
        return this.aAl;
    }

    public void j(boolean z, long j) {
        com.baidu.live.alablmsdk.a.b.a.ag("out-media-device enableRemoteDisplay ", "imUk=" + j);
        if (j != 0) {
            synchronized (this.aAj) {
                if (z) {
                    aG(j);
                    yK();
                }
            }
        }
    }

    private void yK() {
        String str;
        com.baidu.live.alablmsdk.a.b.a.d("out-media-device mapDetailInfoForLog ");
        if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
            StringBuilder sb = new StringBuilder();
            if (this.aAj.size() > 0) {
                for (Map.Entry<Long, com.baidu.live.alablmsdk.c.b.c> entry : this.aAj.entrySet()) {
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
        com.baidu.live.alablmsdk.a.b.a.ag("out-media-device remote user view num " + this.aAj.size(), "");
    }

    private void aG(long j) {
        String str;
        com.baidu.live.alablmsdk.a.b.a.ag("out-media-device addRemoteUserRtcVideoView remoteUid" + j, "");
        synchronized (this.aAj) {
            com.baidu.live.alablmsdk.c.b.c cVar = this.aAj.get(Long.valueOf(j));
            if (cVar == null || !cVar.xP()) {
                if (cVar == null) {
                    str = "";
                } else {
                    str = cVar.toString();
                }
                com.baidu.live.alablmsdk.a.b.a.ag("out-media-device bd: map-externalTextureInfo info has null , remoteUid=" + j, " externalTextureInfo=" + str);
                com.baidu.live.alablmsdk.c.b.c a2 = this.azs.a(j, this.aAm);
                this.aAj.put(Long.valueOf(j), a2);
                com.baidu.live.alablmsdk.a.b.a.ag("out-media-device bd: mapSize=" + this.aAj.size() + " , tempExternalTextureInfo = " + a2.toString(), "");
            } else {
                com.baidu.live.alablmsdk.a.b.a.ag("out-media-device bd: map contains , remoteUid=" + j, "");
                this.azs.a(cVar, j);
            }
        }
    }

    public View j(com.baidu.live.alablmsdk.module.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.d("out-media-device getRemoteDisplayViewForUser user ");
        if (cVar == null || cVar.azK == 0) {
            return null;
        }
        com.baidu.live.alablmsdk.a.b.a.ag("out-media-device getRemoteDisplayViewForUser", " imUk=" + cVar.azK);
        return aH(cVar.azK);
    }

    public View aH(long j) {
        View view;
        com.baidu.live.alablmsdk.a.b.a.d("out-media-device getRemoteDisplayViewForUser imUk ");
        if (j == 0) {
            return null;
        }
        synchronized (this.aAj) {
            if (this.aAj.containsKey(Long.valueOf(j))) {
                com.baidu.live.alablmsdk.a.b.a.ag("out-media-device mRemoteViewMap sizes " + this.aAj.size(), "");
                com.baidu.live.alablmsdk.c.b.c cVar = this.aAj.get(Long.valueOf(j));
                if (cVar != null) {
                    com.baidu.live.alablmsdk.a.b.a.ag("out-media-device get texture view by user , imUk=" + j + ", texture info=" + cVar.toString(), "");
                    view = cVar.yk();
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
        yL();
    }

    public void yL() {
        yM();
    }

    private void yM() {
        com.baidu.live.alablmsdk.c.b.c value;
        com.baidu.live.alablmsdk.a.b.a.ag("out-media-device releaseVideoViewMap ", "");
        if (this.aAj != null) {
            synchronized (this.aAj) {
                for (Map.Entry<Long, com.baidu.live.alablmsdk.c.b.c> entry : this.aAj.entrySet()) {
                    if (entry != null && (value = entry.getValue()) != null) {
                        value.release();
                    }
                }
                this.aAj.clear();
            }
        }
    }
}
