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
    private AlaLiveInfoData bdu;
    private d bse;
    private b bsf;
    private String bsg;
    private Context mContext;

    public LivePlayer(Context context) {
        super(context);
        d av;
        this.bsg = "";
        this.mContext = context;
        boolean z = a.Nk().beJ.aFF;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            av = h.Lr().av(context);
        } else if (z) {
            av = h.Lr().aw(context);
        } else {
            av = h.Lr().av(context);
        }
        this.bse = av;
    }

    private FrameLayout.LayoutParams Qs() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    @Override // com.baidu.live.p.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        int i;
        int i2 = 1;
        if (alaLiveInfoData != null) {
            this.bdu = alaLiveInfoData;
            FrameLayout.LayoutParams Qs = Qs();
            be beVar = a.Nk().bkd;
            if (beVar != null && beVar.aJH != null && ((i = beVar.aJH.decodeMode) == 1 || i == 2)) {
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
            this.bsg = str;
            final d dVar = this.bse;
            if (dVar.getPlayerView() != null && dVar.getPlayerView().getParent() != null) {
                ((ViewGroup) dVar.getPlayerView().getParent()).removeView(dVar.getPlayerView());
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                jSONObject.put("clientIp", a.Nk().beJ.clientIP);
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
                        if (LivePlayer.this.bsf != null) {
                            LivePlayer.this.bsf.dD(1);
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
        if (this.bse != null && this.bse.getPlayerView() != null && this.bse.getPlayerView().getParent() != null) {
            ((ViewGroup) this.bse.getPlayerView().getParent()).removeView(this.bse.getPlayerView());
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
        this.bsg = "";
        if (this.bse != null) {
            this.bse.setPlayerCallback(null);
            this.bse.stop();
        }
    }

    @Override // com.baidu.live.p.f
    public View getLivePlayer() {
        return this;
    }

    public void destroy() {
        if (this.bse != null) {
            this.bse.setPlayerCallback(null);
            this.bse.release();
            this.bse = null;
        }
    }

    public void setIPlayerCallBack(b bVar) {
        this.bsf = bVar;
    }

    @Override // com.baidu.live.p.f
    public String getVideoPath() {
        return this.bsg;
    }
}
