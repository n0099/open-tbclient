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
import com.baidu.live.data.bj;
import com.baidu.live.liveroom.e.d;
import com.baidu.live.liveroom.e.g;
import com.baidu.live.liveroom.e.i;
import com.baidu.live.q.b;
import com.baidu.live.q.f;
import com.baidu.live.q.h;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.x.a;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LivePlayer extends FrameLayout implements f {
    private d bBW;
    private b bBX;
    private String bBY;
    private AlaLiveInfoData bjZ;
    private Context mContext;

    public LivePlayer(Context context) {
        super(context);
        d ay;
        this.bBY = "";
        this.mContext = context;
        boolean z = a.OS().blo.aJY;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            ay = i.MY().ay(context);
        } else if (z) {
            ay = i.MY().az(context);
        } else {
            ay = i.MY().ay(context);
        }
        this.bBW = ay;
    }

    private FrameLayout.LayoutParams SS() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    @Override // com.baidu.live.q.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        int i;
        int i2 = 1;
        if (alaLiveInfoData != null) {
            this.bjZ = alaLiveInfoData;
            FrameLayout.LayoutParams SS = SS();
            bj bjVar = a.OS().bqJ;
            if (bjVar != null && bjVar.aOc != null && ((i = bjVar.aOc.decodeMode) == 1 || i == 2)) {
                i2 = i;
            }
            if ("ZTE A0622".equals(Build.MODEL)) {
                i2 = 2;
            }
            a(alaLiveInfoData, SS, i2, alaLiveInfoData.screen_direction != 2 ? 0 : 2);
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
            this.bBY = str;
            final d dVar = this.bBW;
            if (dVar.getPlayerView() != null && dVar.getPlayerView().getParent() != null) {
                ((ViewGroup) dVar.getPlayerView().getParent()).removeView(dVar.getPlayerView());
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                jSONObject.put("clientIp", a.OS().blo.clientIP);
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
            dVar.eN(4);
            addView(dVar.getPlayerView(), layoutParams);
            dVar.setPlayerCallback(new g() { // from class: com.baidu.live.videochat.player.LivePlayer.1
                @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                public void a(d dVar2, int i3, int i4) {
                    if (i3 == 904) {
                        if (LivePlayer.this.bBX != null) {
                            LivePlayer.this.bBX.dM(1);
                        }
                        dVar.eN(0);
                    }
                }
            });
            dVar.c(Uri.parse(str));
            dVar.start();
            dVar.setVideoScalingMode(i2);
        }
    }

    private void ST() {
        if (this.bBW != null && this.bBW.getPlayerView() != null && this.bBW.getPlayerView().getParent() != null) {
            ((ViewGroup) this.bBW.getPlayerView().getParent()).removeView(this.bBW.getPlayerView());
        }
        removeAllViews();
    }

    @Override // com.baidu.live.q.f
    public void cl(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("VideoChatLivePlayer stopLivePlayer()");
        }
        if (z) {
            ST();
        }
        this.bBY = "";
        if (this.bBW != null) {
            this.bBW.setPlayerCallback(null);
            this.bBW.stop();
        }
    }

    @Override // com.baidu.live.q.f
    public View getLivePlayer() {
        return this;
    }

    public void destroy() {
        if (this.bBW != null) {
            this.bBW.setPlayerCallback(null);
            this.bBW.release();
            this.bBW = null;
        }
    }

    public void setIPlayerCallBack(b bVar) {
        this.bBX = bVar;
    }

    @Override // com.baidu.live.q.f
    public String getVideoPath() {
        return this.bBY;
    }
}
