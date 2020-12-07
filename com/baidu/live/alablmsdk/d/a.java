package com.baidu.live.alablmsdk.d;

import android.content.Context;
import android.view.TextureView;
import com.baidu.live.alablmsdk.module.rtc.b;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class a implements b.a {
    private c aCb;
    private Context mContext;
    private HashMap<Long, com.baidu.live.alablmsdk.module.rtc.b> aCO = new HashMap<>();
    com.baidu.live.alablmsdk.c.a.a aCP = new com.baidu.live.alablmsdk.c.a.a() { // from class: com.baidu.live.alablmsdk.d.a.1
        @Override // com.baidu.live.alablmsdk.c.a.a
        public void onPixelRead(byte[] bArr, int i, int i2) {
            com.baidu.live.alablmsdk.a.b.c.BY().setVideoSize(i, i2);
            if (a.this.aCN != null) {
                a.this.aCN.p(bArr, i, i2);
            }
        }

        @Override // com.baidu.live.alablmsdk.c.a.a
        public void onError(int i, String str) {
            com.baidu.live.alablmsdk.a.b.c.BY().onRecorderError(i, str);
        }
    };
    private d aCN = new d();

    public a(Context context, c cVar) {
        this.mContext = context;
        this.aCb = cVar;
        this.aCb.a(this.aCN);
    }

    public com.baidu.live.alablmsdk.c.a.a CW() {
        return this.aCP;
    }

    public void b(boolean z, long j) {
        String str;
        com.baidu.live.alablmsdk.a.b.a.ak(" enableRemoteDisplay ", "imUk=" + j);
        if (j != 0) {
            synchronized (this.aCO) {
                if (z) {
                    aE(j);
                    if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                        StringBuilder sb = new StringBuilder();
                        if (this.aCO.size() > 0) {
                            for (Map.Entry<Long, com.baidu.live.alablmsdk.module.rtc.b> entry : this.aCO.entrySet()) {
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
                        com.baidu.live.alablmsdk.a.b.a.ak("  map for 循环 texture info = " + sb.toString(), "");
                    }
                    com.baidu.live.alablmsdk.a.b.a.ak(" remote user view num " + this.aCO.size(), "");
                }
            }
        }
    }

    private TextureView aE(final long j) {
        TextureView textureView;
        com.baidu.live.alablmsdk.a.b.a.ak(" addRemoteUserRtcVideoView remoteUid" + j, "");
        synchronized (this.aCO) {
            final com.baidu.live.alablmsdk.module.rtc.b bVar = this.aCO.get(Long.valueOf(j));
            if (bVar == null || bVar.mTextureView == null || bVar.mSurface == null) {
                String str = "";
                if (bVar != null) {
                    str = bVar.toString();
                }
                com.baidu.live.alablmsdk.a.b.a.ak(" map-externalTextureInfo info has null , remoteUid=" + j, " externalTextureInfo=" + str);
                bVar = new com.baidu.live.alablmsdk.module.rtc.b(this.mContext, this.aCb, j);
                bVar.a(this);
                this.aCO.put(Long.valueOf(j), bVar);
                com.baidu.live.alablmsdk.a.b.a.ak(" tempExternalTextureInfo = " + bVar.toString(), "");
            } else {
                com.baidu.live.alablmsdk.a.b.a.ak(" map contains , remoteUid=" + j, "");
                final int i = bVar.mWidth;
                final int i2 = bVar.mHeight;
                com.baidu.live.alablmsdk.a.b.a.ak(" map contains , remoteUid=" + j + " , info=" + bVar, "");
                if (bVar.mSurface != null) {
                    com.baidu.live.alablmsdk.a.c.BS().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.live.alablmsdk.a.b.a.ak(" re destroy set ExternalSurface , width=" + i + " , height=" + i2, "");
                            a.this.aCb.destroyExternalSurface(j, bVar.mSurface);
                            a.this.aCb.setExternalSurface(j, bVar.mSurface);
                            a.this.aCb.changeSurfaceSize(j, i, i2);
                        }
                    });
                }
            }
            textureView = bVar.mTextureView;
        }
        return textureView;
    }

    @Override // com.baidu.live.alablmsdk.module.rtc.b.a
    public void aD(long j) {
        synchronized (this.aCO) {
            com.baidu.live.alablmsdk.a.b.a.ak(" map remove , id=" + j, "");
            if (j != 0) {
                this.aCO.remove(Long.valueOf(j));
            }
        }
    }

    public TextureView c(com.baidu.live.alablmsdk.module.c cVar) {
        if (cVar == null || cVar.aCp == 0) {
            return null;
        }
        com.baidu.live.alablmsdk.a.b.a.ak(" getRemoteDisplayViewForUser", " imUk=" + cVar.aCp);
        return aF(cVar.aCp);
    }

    public TextureView aF(long j) {
        TextureView textureView;
        if (j == 0) {
            return null;
        }
        synchronized (this.aCO) {
            if (this.aCO.containsKey(Long.valueOf(j))) {
                com.baidu.live.alablmsdk.a.b.a.ak(" mRemoteViewMap sizes " + this.aCO.size(), "");
                com.baidu.live.alablmsdk.module.rtc.b bVar = this.aCO.get(Long.valueOf(j));
                if (bVar != null) {
                    com.baidu.live.alablmsdk.a.b.a.ak(" get texture view by user , imUk=" + j + ", texture info=" + bVar.toString(), "");
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
        CX();
    }

    public void CX() {
        CY();
    }

    private void CY() {
        com.baidu.live.alablmsdk.module.rtc.b value;
        com.baidu.live.alablmsdk.a.b.a.ak(" releaseVideoViewMap ", "");
        if (this.aCO != null) {
            synchronized (this.aCO) {
                for (Map.Entry<Long, com.baidu.live.alablmsdk.module.rtc.b> entry : this.aCO.entrySet()) {
                    if (entry != null && (value = entry.getValue()) != null) {
                        value.release();
                    }
                }
                this.aCO.clear();
            }
        }
    }
}
