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
import com.baidu.live.data.bm;
import com.baidu.live.liveroom.e.d;
import com.baidu.live.liveroom.e.g;
import com.baidu.live.liveroom.e.i;
import com.baidu.live.r.b;
import com.baidu.live.r.f;
import com.baidu.live.r.h;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.z.a;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LivePlayer extends FrameLayout implements f {
    private d bES;
    private b bET;
    private String bEU;
    private AlaLiveInfoData blu;
    private Context mContext;

    public LivePlayer(Context context) {
        super(context);
        d ay;
        this.bEU = "";
        this.mContext = context;
        boolean z = a.Pq().bmJ.aKA;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            ay = i.Ns().ay(context);
        } else if (z) {
            ay = i.Ns().az(context);
        } else {
            ay = i.Ns().ay(context);
        }
        this.bES = ay;
    }

    private FrameLayout.LayoutParams TR() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    @Override // com.baidu.live.r.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        int i;
        int i2 = 1;
        if (alaLiveInfoData != null) {
            this.blu = alaLiveInfoData;
            FrameLayout.LayoutParams TR = TR();
            bm bmVar = a.Pq().bsy;
            if (bmVar != null && bmVar.aOH != null && ((i = bmVar.aOH.decodeMode) == 1 || i == 2)) {
                i2 = i;
            }
            if ("ZTE A0622".equals(Build.MODEL)) {
                i2 = 2;
            }
            a(alaLiveInfoData, TR, i2, alaLiveInfoData.screen_direction != 2 ? 0 : 2);
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
            this.bEU = str;
            final d dVar = this.bES;
            if (dVar.getPlayerView() != null && dVar.getPlayerView().getParent() != null) {
                ((ViewGroup) dVar.getPlayerView().getParent()).removeView(dVar.getPlayerView());
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                jSONObject.put("clientIp", a.Pq().bmJ.clientIP);
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
            dVar.eQ(4);
            addView(dVar.getPlayerView(), layoutParams);
            dVar.setPlayerCallback(new g() { // from class: com.baidu.live.videochat.player.LivePlayer.1
                @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                public void a(d dVar2, int i3, int i4) {
                    if (i3 == 904) {
                        if (LivePlayer.this.bET != null) {
                            LivePlayer.this.bET.dM(1);
                        }
                        dVar.eQ(0);
                    }
                }
            });
            dVar.c(Uri.parse(str));
            dVar.start();
            dVar.setVideoScalingMode(i2);
        }
    }

    private void TS() {
        if (this.bES != null && this.bES.getPlayerView() != null && this.bES.getPlayerView().getParent() != null) {
            ((ViewGroup) this.bES.getPlayerView().getParent()).removeView(this.bES.getPlayerView());
        }
        removeAllViews();
    }

    @Override // com.baidu.live.r.f
    public void cn(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("VideoChatLivePlayer stopLivePlayer()");
        }
        if (z) {
            TS();
        }
        this.bEU = "";
        if (this.bES != null) {
            this.bES.setPlayerCallback(null);
            this.bES.stop();
        }
    }

    @Override // com.baidu.live.r.f
    public View getLivePlayer() {
        return this;
    }

    public void destroy() {
        if (this.bES != null) {
            this.bES.setPlayerCallback(null);
            this.bES.release();
            this.bES = null;
        }
    }

    public void setIPlayerCallBack(b bVar) {
        this.bET = bVar;
    }

    @Override // com.baidu.live.r.f
    public String getVideoPath() {
        return this.bEU;
    }
}
