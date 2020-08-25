package com.baidu.live.videochat.player;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import com.baidu.live.data.be;
import com.baidu.live.liveroom.e.d;
import com.baidu.live.liveroom.e.g;
import com.baidu.live.liveroom.e.h;
import com.baidu.live.p.b;
import com.baidu.live.p.f;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.w.a;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class LivePlayer extends FrameLayout implements f {
    private AlaLiveInfoData bds;
    private d bsb;
    private b bsc;
    private String bsd;
    private Context mContext;

    public LivePlayer(Context context) {
        super(context);
        d av;
        this.bsd = "";
        this.mContext = context;
        boolean z = a.Nk().beH.aFD;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            av = h.Lr().av(context);
        } else if (z) {
            av = h.Lr().aw(context);
        } else {
            av = h.Lr().av(context);
        }
        this.bsb = av;
    }

    private FrameLayout.LayoutParams Qs() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    @Override // com.baidu.live.p.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        int i;
        int i2 = 1;
        if (alaLiveInfoData != null) {
            this.bds = alaLiveInfoData;
            FrameLayout.LayoutParams Qs = Qs();
            be beVar = a.Nk().bka;
            if (beVar != null && beVar.aJF != null && ((i = beVar.aJF.decodeMode) == 1 || i == 2)) {
                i2 = i;
            }
            if ("ZTE A0622".equals(Build.MODEL)) {
                i2 = 2;
            }
            a(alaLiveInfoData, Qs, i2, alaLiveInfoData.screen_direction != 2 ? 0 : 2);
        }
    }

    private void a(AlaLiveInfoData alaLiveInfoData, FrameLayout.LayoutParams layoutParams, int i, int i2) {
        String str;
        if (TextUtils.isEmpty(alaLiveInfoData.playUrl)) {
            str = com.baidu.live.p.h.d(alaLiveInfoData);
        } else {
            str = alaLiveInfoData.playUrl;
        }
        if (!TextUtils.isEmpty(str)) {
            if (BdLog.isDebugMode()) {
                BdLog.e("VideoChatLivePlayer startLive=url=" + str);
            }
            this.bsd = str;
            final d dVar = this.bsb;
            if (dVar.getPlayerView() != null && dVar.getPlayerView().getParent() != null) {
                ((ViewGroup) dVar.getPlayerView().getParent()).removeView(dVar.getPlayerView());
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                jSONObject.put("clientIp", a.Nk().beH.clientIP);
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
            dVar.eA(8);
            addView(dVar.getPlayerView(), layoutParams);
            dVar.setPlayerCallback(new g() { // from class: com.baidu.live.videochat.player.LivePlayer.1
                @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                public void a(d dVar2, int i3, int i4) {
                    if (i3 == 904) {
                        if (LivePlayer.this.bsc != null) {
                            LivePlayer.this.bsc.dD(1);
                        }
                        dVar.eA(0);
                    }
                }
            });
            dVar.c(Uri.parse(str));
            dVar.start();
            dVar.setVideoScalingMode(i2);
        }
    }

    private void Qt() {
        if (this.bsb != null && this.bsb.getPlayerView() != null && this.bsb.getPlayerView().getParent() != null) {
            ((ViewGroup) this.bsb.getPlayerView().getParent()).removeView(this.bsb.getPlayerView());
        }
        removeAllViews();
    }

    @Override // com.baidu.live.p.f
    public void ch(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("VideoChatLivePlayer stopLivePlayer()");
        }
        if (z) {
            Qt();
        }
        this.bsd = "";
        if (this.bsb != null) {
            this.bsb.setPlayerCallback(null);
            this.bsb.stop();
        }
    }

    @Override // com.baidu.live.p.f
    public View getLivePlayer() {
        return this;
    }

    public void destroy() {
        if (this.bsb != null) {
            this.bsb.setPlayerCallback(null);
            this.bsb.release();
            this.bsb = null;
        }
    }

    public void setIPlayerCallBack(b bVar) {
        this.bsc = bVar;
    }

    @Override // com.baidu.live.p.f
    public String getVideoPath() {
        return this.bsd;
    }
}
