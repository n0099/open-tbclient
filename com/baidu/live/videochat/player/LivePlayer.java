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
import com.baidu.live.data.bo;
import com.baidu.live.liveroom.e.d;
import com.baidu.live.liveroom.e.g;
import com.baidu.live.liveroom.e.i;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.b;
import com.baidu.live.u.f;
import com.baidu.live.u.h;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LivePlayer extends FrameLayout implements f {
    private d bNV;
    private b bNW;
    private String bNX;
    private AlaLiveInfoData bqm;
    private Context mContext;

    public LivePlayer(Context context) {
        super(context);
        d bc;
        this.bNX = "";
        this.mContext = context;
        boolean z = a.RB().brA.aMK;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            bc = i.PB().bc(context);
        } else if (z) {
            bc = i.PB().bd(context);
        } else {
            bc = i.PB().bc(context);
        }
        this.bNV = bc;
    }

    private FrameLayout.LayoutParams Yi() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    @Override // com.baidu.live.u.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        int i;
        int i2 = 1;
        if (alaLiveInfoData != null) {
            this.bqm = alaLiveInfoData;
            FrameLayout.LayoutParams Yi = Yi();
            bo boVar = a.RB().bxq;
            if (boVar != null && boVar.aQT != null && ((i = boVar.aQT.aRI) == 1 || i == 2)) {
                i2 = i;
            }
            if ("ZTE A0622".equals(Build.MODEL)) {
                i2 = 2;
            }
            a(alaLiveInfoData, Yi, i2, alaLiveInfoData.screen_direction != 2 ? 0 : 2);
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
            this.bNX = str;
            final d dVar = this.bNV;
            if (dVar.getPlayerView() != null && dVar.getPlayerView().getParent() != null) {
                ((ViewGroup) dVar.getPlayerView().getParent()).removeView(dVar.getPlayerView());
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                jSONObject.put("clientIp", a.RB().brA.clientIP);
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
            dVar.fj(4);
            addView(dVar.getPlayerView(), layoutParams);
            dVar.setPlayerCallback(new g() { // from class: com.baidu.live.videochat.player.LivePlayer.1
                @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                public void a(d dVar2, int i3, int i4) {
                    if (i3 == 904) {
                        if (LivePlayer.this.bNW != null) {
                            LivePlayer.this.bNW.eb(1);
                        }
                        dVar.fj(0);
                    }
                }
            });
            dVar.c(Uri.parse(str));
            dVar.start();
            dVar.setVideoScalingMode(i2);
        }
    }

    private void Yj() {
        if (this.bNV != null && this.bNV.getPlayerView() != null && this.bNV.getPlayerView().getParent() != null) {
            ((ViewGroup) this.bNV.getPlayerView().getParent()).removeView(this.bNV.getPlayerView());
        }
        removeAllViews();
    }

    @Override // com.baidu.live.u.f
    public void cE(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("VideoChatLivePlayer stopLivePlayer()");
        }
        if (z) {
            Yj();
        }
        this.bNX = "";
        if (this.bNV != null) {
            this.bNV.setPlayerCallback(null);
            this.bNV.stop();
        }
    }

    @Override // com.baidu.live.u.f
    public View getLivePlayer() {
        return this;
    }

    public void destroy() {
        if (this.bNV != null) {
            this.bNV.setPlayerCallback(null);
            this.bNV.release();
            this.bNV = null;
        }
    }

    public void setIPlayerCallBack(b bVar) {
        this.bNW = bVar;
    }

    @Override // com.baidu.live.u.f
    public String getVideoPath() {
        return this.bNX;
    }
}
