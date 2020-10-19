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
    private c aAJ;
    private Context mContext;
    private Set<String> aBp = new HashSet();
    private HashMap<String, RTCVideoView> aBq = new HashMap<>();
    com.baidu.live.alablmsdk.c.a.a aBr = new com.baidu.live.alablmsdk.c.a.a() { // from class: com.baidu.live.alablmsdk.d.a.1
        @Override // com.baidu.live.alablmsdk.c.a.a
        public void onPixelRead(byte[] bArr, int i, int i2) {
            if (a.this.aBo != null) {
                a.this.aBo.p(bArr, i, i2);
            }
        }
    };
    private d aBo = new d();

    public a(Context context, c cVar) {
        this.mContext = context;
        this.aAJ = cVar;
        this.aAJ.a(this.aBo);
    }

    public com.baidu.live.alablmsdk.c.a.a BF() {
        return this.aBr;
    }

    public void b(boolean z, long j) {
        com.baidu.live.alablmsdk.a.c.d(" enableRemoteDisplay imUk=" + j);
        com.baidu.live.alablmsdk.a.c.fJ(" enableRemoteDisplay ");
        if (j != 0) {
            synchronized (this.aBp) {
                if (z) {
                    this.aBp.add(j + "");
                    com.baidu.live.alablmsdk.a.c.d(" remote user video view num = " + this.aBp.size());
                    com.baidu.live.alablmsdk.a.c.fJ(" remote user video view num " + this.aBp.size());
                }
            }
        }
    }

    public void BG() {
        if (this.aAJ != null) {
            this.aAJ.t(BH());
        }
    }

    protected List<RTCVideoView> BH() {
        ArrayList arrayList;
        RTCVideoView fN;
        synchronized (this.aBp) {
            arrayList = new ArrayList();
            for (String str : this.aBp) {
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
        synchronized (this.aBq) {
            if (!this.aBq.containsKey(str)) {
                rTCVideoView = new RTCVideoView(this.mContext);
                this.aBq.put(str, rTCVideoView);
            } else {
                rTCVideoView = this.aBq.get(str);
            }
        }
        return rTCVideoView;
    }

    public RTCVideoView a(com.baidu.live.alablmsdk.module.c cVar) {
        if (cVar == null || cVar.aBd == -1) {
            return null;
        }
        com.baidu.live.alablmsdk.a.c.d(" imUk=" + cVar.aBd);
        com.baidu.live.alablmsdk.a.c.fJ(" getRemoteDisplayViewForUser");
        return V(cVar.aBd);
    }

    public RTCVideoView V(long j) {
        RTCVideoView rTCVideoView = null;
        if (j != 0) {
            String str = j + "";
            synchronized (this.aBq) {
                if (this.aBq.containsKey(str)) {
                    com.baidu.live.alablmsdk.a.c.d(" mRemoteViewMap size = " + this.aBq.size());
                    com.baidu.live.alablmsdk.a.c.fJ(" mRemoteViewMap sizes " + this.aBq.size());
                    rTCVideoView = this.aBq.get(str);
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
        synchronized (this.aBq) {
            this.aBq.clear();
        }
    }

    private void BK() {
        synchronized (this.aBp) {
            this.aBp.clear();
        }
    }
}
