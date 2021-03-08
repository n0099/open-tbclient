package com.baidu.live.videochat.player;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.ae.a;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import com.baidu.live.data.bv;
import com.baidu.live.liveroom.e.d;
import com.baidu.live.liveroom.e.g;
import com.baidu.live.liveroom.e.i;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.b;
import com.baidu.live.u.f;
import com.baidu.live.u.h;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class LivePlayer extends FrameLayout implements f {
    private d bTo;
    private b bTp;
    private String bTq;
    private AlaLiveInfoData bsm;
    private Context mContext;

    public LivePlayer(Context context) {
        super(context);
        d aZ;
        this.bTq = "";
        this.mContext = context;
        boolean z = a.Qm().bwx.aML;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            aZ = i.MW().aZ(context);
        } else if (z) {
            aZ = i.MW().ba(context);
        } else {
            aZ = i.MW().aZ(context);
        }
        this.bTo = aZ;
    }

    private FrameLayout.LayoutParams Xk() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    @Override // com.baidu.live.u.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        int i;
        int i2 = 1;
        if (alaLiveInfoData != null) {
            this.bsm = alaLiveInfoData;
            FrameLayout.LayoutParams Xk = Xk();
            bv bvVar = a.Qm().bCs;
            if (bvVar != null && bvVar.aRt != null && ((i = bvVar.aRt.aSl) == 1 || i == 2)) {
                i2 = i;
            }
            if ("ZTE A0622".equals(Build.MODEL)) {
                i2 = 2;
            }
            a(alaLiveInfoData, Xk, i2, alaLiveInfoData.screen_direction != 2 ? 0 : 2);
        }
    }

    private void a(AlaLiveInfoData alaLiveInfoData, FrameLayout.LayoutParams layoutParams, int i, int i2) {
        String str;
        if (TextUtils.isEmpty(alaLiveInfoData.playUrl)) {
            str = h.d(alaLiveInfoData);
        } else {
            str = alaLiveInfoData.playUrl;
        }
        if (!TextUtils.isEmpty(str)) {
            if (BdLog.isDebugMode()) {
                BdLog.e("VideoChatLivePlayer startLive=url=" + str);
            }
            this.bTq = str;
            final d dVar = this.bTo;
            if (dVar.MV() != null && dVar.MV().getParent() != null) {
                ((ViewGroup) dVar.MV().getParent()).removeView(dVar.MV());
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                jSONObject.put("clientIp", a.Qm().bwx.clientIP);
                jSONObject.put("level", AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT);
                jSONObject.put("sessionLine", 1);
                dVar.b(1, jSONObject);
            } catch (Exception e) {
                if (BdLog.isDebugMode()) {
                    BdLog.e(e);
                }
            }
            dVar.setPlayerCallback(null);
            dVar.d(this.mContext, Uri.parse(str));
            dVar.setDecodeMode(i);
            dVar.dI(4);
            addView(dVar.MV(), layoutParams);
            dVar.setPlayerCallback(new g() { // from class: com.baidu.live.videochat.player.LivePlayer.1
                @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                public void a(d dVar2, int i3, int i4) {
                    if (i3 == 904) {
                        if (LivePlayer.this.bTp != null) {
                            LivePlayer.this.bTp.cw(1);
                        }
                        dVar.dI(0);
                    }
                }
            });
            dVar.e(Uri.parse(str));
            dVar.start();
            dVar.setVideoScalingMode(i2);
        }
    }

    private void Xl() {
        if (this.bTo != null && this.bTo.MV() != null && this.bTo.MV().getParent() != null) {
            ((ViewGroup) this.bTo.MV().getParent()).removeView(this.bTo.MV());
        }
        removeAllViews();
    }

    @Override // com.baidu.live.u.f
    public void cM(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("VideoChatLivePlayer stopLivePlayer()");
        }
        if (z) {
            Xl();
        }
        this.bTq = "";
        if (this.bTo != null) {
            this.bTo.setPlayerCallback(null);
            this.bTo.stop();
        }
    }

    @Override // com.baidu.live.u.f
    public View getLivePlayer() {
        return this;
    }

    public void destroy() {
        if (this.bTo != null) {
            this.bTo.setPlayerCallback(null);
            this.bTo.release();
            this.bTo = null;
        }
    }

    @Override // com.baidu.live.u.f
    public void setVideoMode(int i) {
        if (this.bTo != null) {
            this.bTo.setVideoScalingMode(i);
        }
    }

    public void setIPlayerCallBack(b bVar) {
        this.bTp = bVar;
    }

    @Override // com.baidu.live.u.f
    public String getVideoPath() {
        return this.bTq;
    }
}
