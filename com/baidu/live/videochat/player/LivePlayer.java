package com.baidu.live.videochat.player;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.aa.a;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import com.baidu.live.data.bn;
import com.baidu.live.liveroom.e.d;
import com.baidu.live.liveroom.e.g;
import com.baidu.live.liveroom.e.i;
import com.baidu.live.s.b;
import com.baidu.live.s.f;
import com.baidu.live.s.h;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LivePlayer extends FrameLayout implements f {
    private d bIN;
    private b bIO;
    private String bIP;
    private AlaLiveInfoData bld;
    private Context mContext;

    public LivePlayer(Context context) {
        super(context);
        d ay;
        this.bIP = "";
        this.mContext = context;
        boolean z = a.Ph().bms.aJP;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            ay = i.Nj().ay(context);
        } else if (z) {
            ay = i.Nj().az(context);
        } else {
            ay = i.Nj().ay(context);
        }
        this.bIN = ay;
    }

    private FrameLayout.LayoutParams VI() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    @Override // com.baidu.live.s.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        int i;
        int i2 = 1;
        if (alaLiveInfoData != null) {
            this.bld = alaLiveInfoData;
            FrameLayout.LayoutParams VI = VI();
            bn bnVar = a.Ph().bsh;
            if (bnVar != null && bnVar.aNT != null && ((i = bnVar.aNT.decodeMode) == 1 || i == 2)) {
                i2 = i;
            }
            if ("ZTE A0622".equals(Build.MODEL)) {
                i2 = 2;
            }
            a(alaLiveInfoData, VI, i2, alaLiveInfoData.screen_direction != 2 ? 0 : 2);
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
            this.bIP = str;
            final d dVar = this.bIN;
            if (dVar.getPlayerView() != null && dVar.getPlayerView().getParent() != null) {
                ((ViewGroup) dVar.getPlayerView().getParent()).removeView(dVar.getPlayerView());
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                jSONObject.put("clientIp", a.Ph().bms.clientIP);
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
            dVar.eM(4);
            addView(dVar.getPlayerView(), layoutParams);
            dVar.setPlayerCallback(new g() { // from class: com.baidu.live.videochat.player.LivePlayer.1
                @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                public void a(d dVar2, int i3, int i4) {
                    if (i3 == 904) {
                        if (LivePlayer.this.bIO != null) {
                            LivePlayer.this.bIO.dI(1);
                        }
                        dVar.eM(0);
                    }
                }
            });
            dVar.c(Uri.parse(str));
            dVar.start();
            dVar.setVideoScalingMode(i2);
        }
    }

    private void VJ() {
        if (this.bIN != null && this.bIN.getPlayerView() != null && this.bIN.getPlayerView().getParent() != null) {
            ((ViewGroup) this.bIN.getPlayerView().getParent()).removeView(this.bIN.getPlayerView());
        }
        removeAllViews();
    }

    @Override // com.baidu.live.s.f
    public void cq(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("VideoChatLivePlayer stopLivePlayer()");
        }
        if (z) {
            VJ();
        }
        this.bIP = "";
        if (this.bIN != null) {
            this.bIN.setPlayerCallback(null);
            this.bIN.stop();
        }
    }

    @Override // com.baidu.live.s.f
    public View getLivePlayer() {
        return this;
    }

    public void destroy() {
        if (this.bIN != null) {
            this.bIN.setPlayerCallback(null);
            this.bIN.release();
            this.bIN = null;
        }
    }

    public void setIPlayerCallBack(b bVar) {
        this.bIO = bVar;
    }

    @Override // com.baidu.live.s.f
    public String getVideoPath() {
        return this.bIP;
    }
}
