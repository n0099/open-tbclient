package com.baidu.live.alablmsdk.d;

import android.content.Context;
import android.view.TextureView;
import com.baidu.live.alablmsdk.module.rtc.b;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class a implements b.a {
    private c aBi;
    private Context mContext;
    private HashMap<Long, com.baidu.live.alablmsdk.module.rtc.b> aBT = new HashMap<>();
    com.baidu.live.alablmsdk.c.a.a aBU = new com.baidu.live.alablmsdk.c.a.a() { // from class: com.baidu.live.alablmsdk.d.a.1
        @Override // com.baidu.live.alablmsdk.c.a.a
        public void onPixelRead(byte[] bArr, int i, int i2) {
            if (a.this.aBS != null) {
                a.this.aBS.p(bArr, i, i2);
            }
        }
    };
    private d aBS = new d();

    public a(Context context, c cVar) {
        this.mContext = context;
        this.aBi = cVar;
        this.aBi.a(this.aBS);
    }

    public com.baidu.live.alablmsdk.c.a.a BX() {
        return this.aBU;
    }

    public void b(boolean z, long j) {
        String str;
        com.baidu.live.alablmsdk.a.b.ah(" enableRemoteDisplay ", "imUk=" + j);
        if (j != 0) {
            synchronized (this.aBT) {
                if (z) {
                    ag(j);
                    if (com.baidu.live.alablmsdk.a.b.isDebug()) {
                        StringBuilder sb = new StringBuilder();
                        if (this.aBT.size() > 0) {
                            for (Map.Entry<Long, com.baidu.live.alablmsdk.module.rtc.b> entry : this.aBT.entrySet()) {
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
                        com.baidu.live.alablmsdk.a.b.ah("  map for 循环 texture info = " + sb.toString(), "");
                    }
                    com.baidu.live.alablmsdk.a.b.ah(" remote user view num " + this.aBT.size(), "");
                }
            }
        }
    }

    private TextureView ag(final long j) {
        TextureView textureView;
        com.baidu.live.alablmsdk.a.b.ah(" addRemoteUserRtcVideoView remoteUid" + j, "");
        synchronized (this.aBT) {
            final com.baidu.live.alablmsdk.module.rtc.b bVar = this.aBT.get(Long.valueOf(j));
            if (bVar == null || bVar.mTextureView == null || bVar.mSurface == null) {
                String str = "";
                if (bVar != null) {
                    str = bVar.toString();
                }
                com.baidu.live.alablmsdk.a.b.ah(" map-externalTextureInfo info has null , remoteUid=" + j, " externalTextureInfo=" + str);
                bVar = new com.baidu.live.alablmsdk.module.rtc.b(this.mContext, this.aBi, j);
                bVar.a(this);
                this.aBT.put(Long.valueOf(j), bVar);
                com.baidu.live.alablmsdk.a.b.ah(" tempExternalTextureInfo = " + bVar.toString(), "");
            } else {
                com.baidu.live.alablmsdk.a.b.ah(" map contains , remoteUid=" + j, "");
                final int i = bVar.mWidth;
                final int i2 = bVar.mHeight;
                com.baidu.live.alablmsdk.a.b.ah(" map contains , remoteUid=" + j + " , info=" + bVar, "");
                if (bVar.mSurface != null) {
                    com.baidu.live.alablmsdk.a.d.Bh().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.live.alablmsdk.a.b.ah(" re destroy set ExternalSurface , width=" + i + " , height=" + i2, "");
                            a.this.aBi.destroyExternalSurface(j, bVar.mSurface);
                            a.this.aBi.setExternalSurface(j, bVar.mSurface);
                            a.this.aBi.changeSurfaceSize(j, i, i2);
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
        synchronized (this.aBT) {
            com.baidu.live.alablmsdk.a.b.ah(" map remove , id=" + j, "");
            if (j != 0) {
                this.aBT.remove(Long.valueOf(j));
            }
        }
    }

    public TextureView c(com.baidu.live.alablmsdk.module.c cVar) {
        if (cVar == null || cVar.aBv == 0) {
            return null;
        }
        com.baidu.live.alablmsdk.a.b.ah(" getRemoteDisplayViewForUser", " imUk=" + cVar.aBv);
        return ah(cVar.aBv);
    }

    public TextureView ah(long j) {
        TextureView textureView;
        if (j == 0) {
            return null;
        }
        synchronized (this.aBT) {
            if (this.aBT.containsKey(Long.valueOf(j))) {
                com.baidu.live.alablmsdk.a.b.ah(" mRemoteViewMap sizes " + this.aBT.size(), "");
                com.baidu.live.alablmsdk.module.rtc.b bVar = this.aBT.get(Long.valueOf(j));
                if (bVar != null) {
                    com.baidu.live.alablmsdk.a.b.ah(" get texture view by user , imUk=" + j + ", texture info=" + bVar.toString(), "");
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
        BY();
    }

    public void BY() {
        BZ();
    }

    private void BZ() {
        com.baidu.live.alablmsdk.module.rtc.b value;
        com.baidu.live.alablmsdk.a.b.ah(" releaseVideoViewMap ", "");
        if (this.aBT != null) {
            synchronized (this.aBT) {
                for (Map.Entry<Long, com.baidu.live.alablmsdk.module.rtc.b> entry : this.aBT.entrySet()) {
                    if (entry != null && (value = entry.getValue()) != null) {
                        value.release();
                    }
                }
                this.aBT.clear();
            }
        }
    }
}
