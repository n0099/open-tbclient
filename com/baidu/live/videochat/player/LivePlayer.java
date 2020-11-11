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
    private String bKA;
    private d bKy;
    private b bKz;
    private AlaLiveInfoData bmO;
    private Context mContext;

    public LivePlayer(Context context) {
        super(context);
        d ay;
        this.bKA = "";
        this.mContext = context;
        boolean z = a.PQ().bod.aLA;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            ay = i.NS().ay(context);
        } else if (z) {
            ay = i.NS().az(context);
        } else {
            ay = i.NS().ay(context);
        }
        this.bKy = ay;
    }

    private FrameLayout.LayoutParams Wr() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    @Override // com.baidu.live.s.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        int i;
        int i2 = 1;
        if (alaLiveInfoData != null) {
            this.bmO = alaLiveInfoData;
            FrameLayout.LayoutParams Wr = Wr();
            bn bnVar = a.PQ().btT;
            if (bnVar != null && bnVar.aPE != null && ((i = bnVar.aPE.decodeMode) == 1 || i == 2)) {
                i2 = i;
            }
            if ("ZTE A0622".equals(Build.MODEL)) {
                i2 = 2;
            }
            a(alaLiveInfoData, Wr, i2, alaLiveInfoData.screen_direction != 2 ? 0 : 2);
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
            this.bKA = str;
            final d dVar = this.bKy;
            if (dVar.getPlayerView() != null && dVar.getPlayerView().getParent() != null) {
                ((ViewGroup) dVar.getPlayerView().getParent()).removeView(dVar.getPlayerView());
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                jSONObject.put("clientIp", a.PQ().bod.clientIP);
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
                        if (LivePlayer.this.bKz != null) {
                            LivePlayer.this.bKz.dM(1);
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

    private void Ws() {
        if (this.bKy != null && this.bKy.getPlayerView() != null && this.bKy.getPlayerView().getParent() != null) {
            ((ViewGroup) this.bKy.getPlayerView().getParent()).removeView(this.bKy.getPlayerView());
        }
        removeAllViews();
    }

    @Override // com.baidu.live.s.f
    public void co(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("VideoChatLivePlayer stopLivePlayer()");
        }
        if (z) {
            Ws();
        }
        this.bKA = "";
        if (this.bKy != null) {
            this.bKy.setPlayerCallback(null);
            this.bKy.stop();
        }
    }

    @Override // com.baidu.live.s.f
    public View getLivePlayer() {
        return this;
    }

    public void destroy() {
        if (this.bKy != null) {
            this.bKy.setPlayerCallback(null);
            this.bKy.release();
            this.bKy = null;
        }
    }

    public void setIPlayerCallBack(b bVar) {
        this.bKz = bVar;
    }

    @Override // com.baidu.live.s.f
    public String getVideoPath() {
        return this.bKA;
    }
}
