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
    private AlaLiveInfoData bgj;
    private d bvt;
    private b bvu;
    private String bvv;
    private Context mContext;

    public LivePlayer(Context context) {
        super(context);
        d av;
        this.bvv = "";
        this.mContext = context;
        boolean z = a.NN().bhy.aGU;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            av = i.LT().av(context);
        } else if (z) {
            av = i.LT().aw(context);
        } else {
            av = i.LT().av(context);
        }
        this.bvt = av;
    }

    private FrameLayout.LayoutParams Ra() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    @Override // com.baidu.live.q.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        int i;
        int i2 = 1;
        if (alaLiveInfoData != null) {
            this.bgj = alaLiveInfoData;
            FrameLayout.LayoutParams Ra = Ra();
            bj bjVar = a.NN().bmW;
            if (bjVar != null && bjVar.aKX != null && ((i = bjVar.aKX.decodeMode) == 1 || i == 2)) {
                i2 = i;
            }
            if ("ZTE A0622".equals(Build.MODEL)) {
                i2 = 2;
            }
            a(alaLiveInfoData, Ra, i2, alaLiveInfoData.screen_direction != 2 ? 0 : 2);
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
            this.bvv = str;
            final d dVar = this.bvt;
            if (dVar.getPlayerView() != null && dVar.getPlayerView().getParent() != null) {
                ((ViewGroup) dVar.getPlayerView().getParent()).removeView(dVar.getPlayerView());
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                jSONObject.put("clientIp", a.NN().bhy.clientIP);
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
            dVar.eE(4);
            addView(dVar.getPlayerView(), layoutParams);
            dVar.setPlayerCallback(new g() { // from class: com.baidu.live.videochat.player.LivePlayer.1
                @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                public void a(d dVar2, int i3, int i4) {
                    if (i3 == 904) {
                        if (LivePlayer.this.bvu != null) {
                            LivePlayer.this.bvu.dH(1);
                        }
                        dVar.eE(0);
                    }
                }
            });
            dVar.c(Uri.parse(str));
            dVar.start();
            dVar.setVideoScalingMode(i2);
        }
    }

    private void Rb() {
        if (this.bvt != null && this.bvt.getPlayerView() != null && this.bvt.getPlayerView().getParent() != null) {
            ((ViewGroup) this.bvt.getPlayerView().getParent()).removeView(this.bvt.getPlayerView());
        }
        removeAllViews();
    }

    @Override // com.baidu.live.q.f
    public void ci(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("VideoChatLivePlayer stopLivePlayer()");
        }
        if (z) {
            Rb();
        }
        this.bvv = "";
        if (this.bvt != null) {
            this.bvt.setPlayerCallback(null);
            this.bvt.stop();
        }
    }

    @Override // com.baidu.live.q.f
    public View getLivePlayer() {
        return this;
    }

    public void destroy() {
        if (this.bvt != null) {
            this.bvt.setPlayerCallback(null);
            this.bvt.release();
            this.bvt = null;
        }
    }

    public void setIPlayerCallBack(b bVar) {
        this.bvu = bVar;
    }

    @Override // com.baidu.live.q.f
    public String getVideoPath() {
        return this.bvv;
    }
}
