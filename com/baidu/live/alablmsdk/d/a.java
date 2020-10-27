package com.baidu.live.alablmsdk.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.rtc.RTCVideoView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes4.dex */
public class a {
    private c aAO;
    private Context mContext;
    private Set<String> aBu = new HashSet();
    private HashMap<String, RTCVideoView> aBv = new HashMap<>();
    com.baidu.live.alablmsdk.c.a.a aBw = new com.baidu.live.alablmsdk.c.a.a() { // from class: com.baidu.live.alablmsdk.d.a.1
        @Override // com.baidu.live.alablmsdk.c.a.a
        public void onPixelRead(byte[] bArr, int i, int i2) {
            if (a.this.aBt != null) {
                a.this.aBt.p(bArr, i, i2);
            }
        }
    };
    private d aBt = new d();

    public a(Context context, c cVar) {
        this.mContext = context;
        this.aAO = cVar;
        this.aAO.a(this.aBt);
    }

    public com.baidu.live.alablmsdk.c.a.a BF() {
        return this.aBw;
    }

    public void b(boolean z, long j) {
        com.baidu.live.alablmsdk.a.c.d(" enableRemoteDisplay imUk=" + j);
        com.baidu.live.alablmsdk.a.c.fJ(" enableRemoteDisplay ");
        if (j != 0) {
            synchronized (this.aBu) {
                if (z) {
                    this.aBu.add(j + "");
                    com.baidu.live.alablmsdk.a.c.d(" remote user video view num = " + this.aBu.size());
                    com.baidu.live.alablmsdk.a.c.fJ(" remote user video view num " + this.aBu.size());
                }
            }
        }
    }

    public void BG() {
        if (this.aAO != null) {
            this.aAO.t(BH());
        }
    }

    protected List<RTCVideoView> BH() {
        ArrayList arrayList;
        RTCVideoView fN;
        synchronized (this.aBu) {
            arrayList = new ArrayList();
            for (String str : this.aBu) {
                if (!TextUtils.isEmpty(str) && (fN = fN(str)) != null) {
                    com.baidu.live.alablmsdk.a.c.d(" 添加 videoview = " + fN);
                    com.baidu.live.alablmsdk.a.c.fJ("add video view");
                    arrayList.add(fN);
                }
            }
            com.baidu.live.alablmsdk.a.c.d(" getRemoteDisplayGroup size=" + arrayList.size());
            com.baidu.live.alablmsdk.a.c.fJ(" getRemoteDisplayGroup size=" + arrayList.size());
        }
        return arrayList;
    }

    private RTCVideoView fN(String str) {
        RTCVideoView rTCVideoView;
        synchronized (this.aBv) {
            if (!this.aBv.containsKey(str)) {
                rTCVideoView = new RTCVideoView(this.mContext);
                this.aBv.put(str, rTCVideoView);
            } else {
                rTCVideoView = this.aBv.get(str);
            }
        }
        return rTCVideoView;
    }

    public RTCVideoView a(com.baidu.live.alablmsdk.module.c cVar) {
        if (cVar == null || cVar.aBi == -1) {
            return null;
        }
        com.baidu.live.alablmsdk.a.c.d(" imUk=" + cVar.aBi);
        com.baidu.live.alablmsdk.a.c.fJ(" getRemoteDisplayViewForUser");
        return V(cVar.aBi);
    }

    public RTCVideoView V(long j) {
        RTCVideoView rTCVideoView = null;
        if (j != 0) {
            String str = j + "";
            synchronized (this.aBv) {
                if (this.aBv.containsKey(str)) {
                    com.baidu.live.alablmsdk.a.c.d(" mRemoteViewMap size = " + this.aBv.size());
                    com.baidu.live.alablmsdk.a.c.fJ(" mRemoteViewMap sizes " + this.aBv.size());
                    rTCVideoView = this.aBv.get(str);
                }
            }
        }
        return rTCVideoView;
    }

    public void release() {
        BI();
    }

    public void BI() {
        BJ();
        BK();
    }

    private void BJ() {
        synchronized (this.aBv) {
            this.aBv.clear();
        }
    }

    private void BK() {
        synchronized (this.aBu) {
            this.aBu.clear();
        }
    }
}
