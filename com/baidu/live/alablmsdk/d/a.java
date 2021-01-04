package com.baidu.live.alablmsdk.d;

import android.content.Context;
import android.view.TextureView;
import com.baidu.live.alablmsdk.module.rtc.b;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class a implements b.a {
    private c aCs;
    private Context mContext;
    private HashMap<Long, com.baidu.live.alablmsdk.module.rtc.b> aDf = new HashMap<>();
    com.baidu.live.alablmsdk.c.a.a aDg = new com.baidu.live.alablmsdk.c.a.a() { // from class: com.baidu.live.alablmsdk.d.a.1
        @Override // com.baidu.live.alablmsdk.c.a.a
        public void onPixelRead(byte[] bArr, int i, int i2) {
            com.baidu.live.alablmsdk.a.b.c.Bp().setVideoSize(i, i2);
            if (a.this.aDe != null) {
                a.this.aDe.p(bArr, i, i2);
            }
        }

        @Override // com.baidu.live.alablmsdk.c.a.a
        public void onError(int i, String str) {
            com.baidu.live.alablmsdk.a.b.c.Bp().onRecorderError(i, str);
        }
    };
    private d aDe = new d();

    public a(Context context, c cVar) {
        this.mContext = context;
        this.aCs = cVar;
        this.aCs.a(this.aDe);
    }

    public com.baidu.live.alablmsdk.c.a.a Cn() {
        return this.aDg;
    }

    public void i(boolean z, long j) {
        String str;
        com.baidu.live.alablmsdk.a.b.a.aj(" enableRemoteDisplay ", "imUk=" + j);
        if (j != 0) {
            synchronized (this.aDf) {
                if (z) {
                    aD(j);
                    if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                        StringBuilder sb = new StringBuilder();
                        if (this.aDf.size() > 0) {
                            for (Map.Entry<Long, com.baidu.live.alablmsdk.module.rtc.b> entry : this.aDf.entrySet()) {
                                if (entry != null) {
                                    com.baidu.live.alablmsdk.module.rtc.b value = entry.getValue();
                                    if (value == null) {
                                        str = "";
                                    } else {
                                        str = value.toString();
                                    }
                                    sb.append("    key=").append(entry.getKey()).append(str);
                                }
                            }
                        }
                        com.baidu.live.alablmsdk.a.b.a.aj("  map for 循环 texture info = " + sb.toString(), "");
                    }
                    com.baidu.live.alablmsdk.a.b.a.aj(" remote user view num " + this.aDf.size(), "");
                }
            }
        }
    }

    private TextureView aD(final long j) {
        TextureView textureView;
        com.baidu.live.alablmsdk.a.b.a.aj(" addRemoteUserRtcVideoView remoteUid" + j, "");
        synchronized (this.aDf) {
            final com.baidu.live.alablmsdk.module.rtc.b bVar = this.aDf.get(Long.valueOf(j));
            if (bVar == null || bVar.mTextureView == null || bVar.mSurface == null) {
                String str = "";
                if (bVar != null) {
                    str = bVar.toString();
                }
                com.baidu.live.alablmsdk.a.b.a.aj(" map-externalTextureInfo info has null , remoteUid=" + j, " externalTextureInfo=" + str);
                bVar = new com.baidu.live.alablmsdk.module.rtc.b(this.mContext, this.aCs, j);
                bVar.a(this);
                this.aDf.put(Long.valueOf(j), bVar);
                com.baidu.live.alablmsdk.a.b.a.aj(" tempExternalTextureInfo = " + bVar.toString(), "");
            } else {
                com.baidu.live.alablmsdk.a.b.a.aj(" map contains , remoteUid=" + j, "");
                final int i = bVar.mWidth;
                final int i2 = bVar.mHeight;
                com.baidu.live.alablmsdk.a.b.a.aj(" map contains , remoteUid=" + j + " , info=" + bVar, "");
                if (bVar.mSurface != null) {
                    com.baidu.live.alablmsdk.a.c.Bj().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.live.alablmsdk.a.b.a.aj(" re destroy set ExternalSurface , width=" + i + " , height=" + i2, "");
                            a.this.aCs.destroyExternalSurface(j, bVar.mSurface);
                            a.this.aCs.setExternalSurface(j, bVar.mSurface);
                            a.this.aCs.changeSurfaceSize(j, i, i2);
                        }
                    });
                }
            }
            textureView = bVar.mTextureView;
        }
        return textureView;
    }

    @Override // com.baidu.live.alablmsdk.module.rtc.b.a
    public void aC(long j) {
        synchronized (this.aDf) {
            com.baidu.live.alablmsdk.a.b.a.aj(" map remove , id=" + j, "");
            if (j != 0) {
                this.aDf.remove(Long.valueOf(j));
            }
        }
    }

    public TextureView c(com.baidu.live.alablmsdk.module.c cVar) {
        if (cVar == null || cVar.aCG == 0) {
            return null;
        }
        com.baidu.live.alablmsdk.a.b.a.aj(" getRemoteDisplayViewForUser", " imUk=" + cVar.aCG);
        return aE(cVar.aCG);
    }

    public TextureView aE(long j) {
        TextureView textureView;
        if (j == 0) {
            return null;
        }
        synchronized (this.aDf) {
            if (this.aDf.containsKey(Long.valueOf(j))) {
                com.baidu.live.alablmsdk.a.b.a.aj(" mRemoteViewMap sizes " + this.aDf.size(), "");
                com.baidu.live.alablmsdk.module.rtc.b bVar = this.aDf.get(Long.valueOf(j));
                if (bVar != null) {
                    com.baidu.live.alablmsdk.a.b.a.aj(" get texture view by user , imUk=" + j + ", texture info=" + bVar.toString(), "");
                    textureView = bVar.mTextureView;
                } else {
                    textureView = null;
                }
            } else {
                textureView = null;
            }
        }
        return textureView;
    }

    public void release() {
        Co();
    }

    public void Co() {
        Cp();
    }

    private void Cp() {
        com.baidu.live.alablmsdk.module.rtc.b value;
        com.baidu.live.alablmsdk.a.b.a.aj(" releaseVideoViewMap ", "");
        if (this.aDf != null) {
            synchronized (this.aDf) {
                for (Map.Entry<Long, com.baidu.live.alablmsdk.module.rtc.b> entry : this.aDf.entrySet()) {
                    if (entry != null && (value = entry.getValue()) != null) {
                        value.release();
                    }
                }
                this.aDf.clear();
            }
        }
    }
}
