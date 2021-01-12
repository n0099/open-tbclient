package com.baidu.live.alablmsdk.d;

import android.content.Context;
import android.view.TextureView;
import com.baidu.live.alablmsdk.module.rtc.b;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class a implements b.a {
    private c axF;
    private Context mContext;
    private HashMap<Long, com.baidu.live.alablmsdk.module.rtc.b> ays = new HashMap<>();
    com.baidu.live.alablmsdk.c.a.a ayt = new com.baidu.live.alablmsdk.c.a.a() { // from class: com.baidu.live.alablmsdk.d.a.1
        @Override // com.baidu.live.alablmsdk.c.a.a
        public void onPixelRead(byte[] bArr, int i, int i2) {
            com.baidu.live.alablmsdk.a.b.c.xu().setVideoSize(i, i2);
            if (a.this.ayr != null) {
                a.this.ayr.o(bArr, i, i2);
            }
        }

        @Override // com.baidu.live.alablmsdk.c.a.a
        public void onError(int i, String str) {
            com.baidu.live.alablmsdk.a.b.c.xu().onRecorderError(i, str);
        }
    };
    private d ayr = new d();

    public a(Context context, c cVar) {
        this.mContext = context;
        this.axF = cVar;
        this.axF.a(this.ayr);
    }

    public com.baidu.live.alablmsdk.c.a.a ys() {
        return this.ayt;
    }

    public void i(boolean z, long j) {
        String str;
        com.baidu.live.alablmsdk.a.b.a.ai(" enableRemoteDisplay ", "imUk=" + j);
        if (j != 0) {
            synchronized (this.ays) {
                if (z) {
                    aD(j);
                    if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                        StringBuilder sb = new StringBuilder();
                        if (this.ays.size() > 0) {
                            for (Map.Entry<Long, com.baidu.live.alablmsdk.module.rtc.b> entry : this.ays.entrySet()) {
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
                        com.baidu.live.alablmsdk.a.b.a.ai("  map for 循环 texture info = " + sb.toString(), "");
                    }
                    com.baidu.live.alablmsdk.a.b.a.ai(" remote user view num " + this.ays.size(), "");
                }
            }
        }
    }

    private TextureView aD(final long j) {
        TextureView textureView;
        com.baidu.live.alablmsdk.a.b.a.ai(" addRemoteUserRtcVideoView remoteUid" + j, "");
        synchronized (this.ays) {
            final com.baidu.live.alablmsdk.module.rtc.b bVar = this.ays.get(Long.valueOf(j));
            if (bVar == null || bVar.mTextureView == null || bVar.mSurface == null) {
                String str = "";
                if (bVar != null) {
                    str = bVar.toString();
                }
                com.baidu.live.alablmsdk.a.b.a.ai(" map-externalTextureInfo info has null , remoteUid=" + j, " externalTextureInfo=" + str);
                bVar = new com.baidu.live.alablmsdk.module.rtc.b(this.mContext, this.axF, j);
                bVar.a(this);
                this.ays.put(Long.valueOf(j), bVar);
                com.baidu.live.alablmsdk.a.b.a.ai(" tempExternalTextureInfo = " + bVar.toString(), "");
            } else {
                com.baidu.live.alablmsdk.a.b.a.ai(" map contains , remoteUid=" + j, "");
                final int i = bVar.mWidth;
                final int i2 = bVar.mHeight;
                com.baidu.live.alablmsdk.a.b.a.ai(" map contains , remoteUid=" + j + " , info=" + bVar, "");
                if (bVar.mSurface != null) {
                    com.baidu.live.alablmsdk.a.c.xo().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.live.alablmsdk.a.b.a.ai(" re destroy set ExternalSurface , width=" + i + " , height=" + i2, "");
                            a.this.axF.destroyExternalSurface(j, bVar.mSurface);
                            a.this.axF.setExternalSurface(j, bVar.mSurface);
                            a.this.axF.changeSurfaceSize(j, i, i2);
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
        synchronized (this.ays) {
            com.baidu.live.alablmsdk.a.b.a.ai(" map remove , id=" + j, "");
            if (j != 0) {
                this.ays.remove(Long.valueOf(j));
            }
        }
    }

    public TextureView c(com.baidu.live.alablmsdk.module.c cVar) {
        if (cVar == null || cVar.axT == 0) {
            return null;
        }
        com.baidu.live.alablmsdk.a.b.a.ai(" getRemoteDisplayViewForUser", " imUk=" + cVar.axT);
        return aE(cVar.axT);
    }

    public TextureView aE(long j) {
        TextureView textureView;
        if (j == 0) {
            return null;
        }
        synchronized (this.ays) {
            if (this.ays.containsKey(Long.valueOf(j))) {
                com.baidu.live.alablmsdk.a.b.a.ai(" mRemoteViewMap sizes " + this.ays.size(), "");
                com.baidu.live.alablmsdk.module.rtc.b bVar = this.ays.get(Long.valueOf(j));
                if (bVar != null) {
                    com.baidu.live.alablmsdk.a.b.a.ai(" get texture view by user , imUk=" + j + ", texture info=" + bVar.toString(), "");
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
        yt();
    }

    public void yt() {
        yu();
    }

    private void yu() {
        com.baidu.live.alablmsdk.module.rtc.b value;
        com.baidu.live.alablmsdk.a.b.a.ai(" releaseVideoViewMap ", "");
        if (this.ays != null) {
            synchronized (this.ays) {
                for (Map.Entry<Long, com.baidu.live.alablmsdk.module.rtc.b> entry : this.ays.entrySet()) {
                    if (entry != null && (value = entry.getValue()) != null) {
                        value.release();
                    }
                }
                this.ays.clear();
            }
        }
    }
}
