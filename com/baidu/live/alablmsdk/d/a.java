package com.baidu.live.alablmsdk.d;

import android.content.Context;
import android.view.TextureView;
import com.baidu.live.alablmsdk.module.rtc.b;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class a implements b.a {
    private c azx;
    private Context mContext;
    private HashMap<Long, com.baidu.live.alablmsdk.module.rtc.b> aAi = new HashMap<>();
    com.baidu.live.alablmsdk.c.a.a aAj = new com.baidu.live.alablmsdk.c.a.a() { // from class: com.baidu.live.alablmsdk.d.a.1
        @Override // com.baidu.live.alablmsdk.c.a.a
        public void onPixelRead(byte[] bArr, int i, int i2) {
            if (a.this.aAh != null) {
                a.this.aAh.p(bArr, i, i2);
            }
        }
    };
    private d aAh = new d();

    public a(Context context, c cVar) {
        this.mContext = context;
        this.azx = cVar;
        this.azx.a(this.aAh);
    }

    public com.baidu.live.alablmsdk.c.a.a Bo() {
        return this.aAj;
    }

    public void b(boolean z, long j) {
        String str;
        com.baidu.live.alablmsdk.a.b.ag(" enableRemoteDisplay ", "imUk=" + j);
        if (j != 0) {
            synchronized (this.aAi) {
                if (z) {
                    ag(j);
                    if (com.baidu.live.alablmsdk.a.b.isDebug()) {
                        StringBuilder sb = new StringBuilder();
                        if (this.aAi.size() > 0) {
                            for (Map.Entry<Long, com.baidu.live.alablmsdk.module.rtc.b> entry : this.aAi.entrySet()) {
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
                        com.baidu.live.alablmsdk.a.b.ag("  map for 循环 texture info = " + sb.toString(), "");
                    }
                    com.baidu.live.alablmsdk.a.b.ag(" remote user view num " + this.aAi.size(), "");
                }
            }
        }
    }

    private TextureView ag(final long j) {
        TextureView textureView;
        com.baidu.live.alablmsdk.a.b.ag(" addRemoteUserRtcVideoView remoteUid" + j, "");
        synchronized (this.aAi) {
            final com.baidu.live.alablmsdk.module.rtc.b bVar = this.aAi.get(Long.valueOf(j));
            if (bVar == null || bVar.mTextureView == null || bVar.mSurface == null) {
                String str = "";
                if (bVar != null) {
                    str = bVar.toString();
                }
                com.baidu.live.alablmsdk.a.b.ag(" map-externalTextureInfo info has null , remoteUid=" + j, " externalTextureInfo=" + str);
                bVar = new com.baidu.live.alablmsdk.module.rtc.b(this.mContext, this.azx, j);
                bVar.a(this);
                this.aAi.put(Long.valueOf(j), bVar);
                com.baidu.live.alablmsdk.a.b.ag(" tempExternalTextureInfo = " + bVar.toString(), "");
            } else {
                com.baidu.live.alablmsdk.a.b.ag(" map contains , remoteUid=" + j, "");
                final int i = bVar.mWidth;
                final int i2 = bVar.mHeight;
                com.baidu.live.alablmsdk.a.b.ag(" map contains , remoteUid=" + j + " , info=" + bVar, "");
                if (bVar.mSurface != null) {
                    com.baidu.live.alablmsdk.a.d.Ay().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.live.alablmsdk.a.b.ag(" re destroy set ExternalSurface , width=" + i + " , height=" + i2, "");
                            a.this.azx.destroyExternalSurface(j, bVar.mSurface);
                            a.this.azx.setExternalSurface(j, bVar.mSurface);
                            a.this.azx.changeSurfaceSize(j, i, i2);
                        }
                    });
                }
            }
            textureView = bVar.mTextureView;
        }
        return textureView;
    }

    @Override // com.baidu.live.alablmsdk.module.rtc.b.a
    public void af(long j) {
        synchronized (this.aAi) {
            com.baidu.live.alablmsdk.a.b.ag(" map remove , id=" + j, "");
            if (j != 0) {
                this.aAi.remove(Long.valueOf(j));
            }
        }
    }

    public TextureView c(com.baidu.live.alablmsdk.module.c cVar) {
        if (cVar == null || cVar.azK == 0) {
            return null;
        }
        com.baidu.live.alablmsdk.a.b.ag(" getRemoteDisplayViewForUser", " imUk=" + cVar.azK);
        return ah(cVar.azK);
    }

    public TextureView ah(long j) {
        TextureView textureView;
        if (j == 0) {
            return null;
        }
        synchronized (this.aAi) {
            if (this.aAi.containsKey(Long.valueOf(j))) {
                com.baidu.live.alablmsdk.a.b.ag(" mRemoteViewMap sizes " + this.aAi.size(), "");
                com.baidu.live.alablmsdk.module.rtc.b bVar = this.aAi.get(Long.valueOf(j));
                if (bVar != null) {
                    com.baidu.live.alablmsdk.a.b.ag(" get texture view by user , imUk=" + j + ", texture info=" + bVar.toString(), "");
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
        Bp();
    }

    public void Bp() {
        Bq();
    }

    private void Bq() {
        com.baidu.live.alablmsdk.module.rtc.b value;
        com.baidu.live.alablmsdk.a.b.ag(" releaseVideoViewMap ", "");
        if (this.aAi != null) {
            synchronized (this.aAi) {
                for (Map.Entry<Long, com.baidu.live.alablmsdk.module.rtc.b> entry : this.aAi.entrySet()) {
                    if (entry != null && (value = entry.getValue()) != null) {
                        value.release();
                    }
                }
                this.aAi.clear();
            }
        }
    }
}
