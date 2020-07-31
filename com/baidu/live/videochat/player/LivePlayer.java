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
import com.baidu.live.data.bc;
import com.baidu.live.liveroom.e.a;
import com.baidu.live.liveroom.e.d;
import com.baidu.live.liveroom.e.e;
import com.baidu.live.p.b;
import com.baidu.live.p.f;
import com.baidu.live.p.h;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LivePlayer extends FrameLayout implements f {
    private AlaLiveInfoData aYc;
    private a bmw;
    private b bmx;
    private String bmy;
    private Context mContext;

    public LivePlayer(Context context) {
        super(context);
        a as;
        this.bmy = "";
        this.mContext = context;
        boolean z = com.baidu.live.v.a.Hs().aZn.aAt;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            as = e.FF().as(context);
        } else if (z) {
            as = e.FF().at(context);
        } else {
            as = e.FF().as(context);
        }
        this.bmw = as;
    }

    private FrameLayout.LayoutParams KA() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    @Override // com.baidu.live.p.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        int i;
        int i2 = 1;
        if (alaLiveInfoData != null) {
            this.aYc = alaLiveInfoData;
            FrameLayout.LayoutParams KA = KA();
            bc bcVar = com.baidu.live.v.a.Hs().beo;
            if (bcVar != null && bcVar.aEv != null && ((i = bcVar.aEv.decodeMode) == 1 || i == 2)) {
                i2 = i;
            }
            if ("ZTE A0622".equals(Build.MODEL)) {
                i2 = 2;
            }
            a(alaLiveInfoData, KA, i2, alaLiveInfoData.screen_direction != 2 ? 0 : 2);
        }
    }

    private void a(AlaLiveInfoData alaLiveInfoData, FrameLayout.LayoutParams layoutParams, int i, int i2) {
        String d = h.d(alaLiveInfoData);
        if (!TextUtils.isEmpty(d)) {
            if (BdLog.isDebugMode()) {
                BdLog.e("VideoChatLivePlayer startLive=url=" + d);
            }
            this.bmy = d;
            final a aVar = this.bmw;
            if (aVar.getPlayerView() != null && aVar.getPlayerView().getParent() != null) {
                ((ViewGroup) aVar.getPlayerView().getParent()).removeView(aVar.getPlayerView());
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                jSONObject.put("clientIp", com.baidu.live.v.a.Hs().aZn.clientIP);
                jSONObject.put(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT);
                jSONObject.put("sessionLine", 1);
                aVar.b(1, jSONObject);
            } catch (Exception e) {
                if (BdLog.isDebugMode()) {
                    BdLog.e(e);
                }
            }
            aVar.a(null);
            aVar.d(this.mContext, Uri.parse(d));
            aVar.setDecodeMode(i);
            aVar.cK(8);
            addView(aVar.getPlayerView(), layoutParams);
            aVar.a(new d() { // from class: com.baidu.live.videochat.player.LivePlayer.1
                @Override // com.baidu.live.liveroom.e.c
                public void a(a aVar2, int i3, int i4) {
                    if (i3 == 904) {
                        if (LivePlayer.this.bmx != null) {
                            LivePlayer.this.bmx.bR(1);
                        }
                        aVar.cK(0);
                    }
                }
            });
            aVar.c(Uri.parse(d));
            aVar.start();
            aVar.setVideoScalingMode(i2);
        }
    }

    private void KB() {
        if (this.bmw != null && this.bmw.getPlayerView() != null && this.bmw.getPlayerView().getParent() != null) {
            ((ViewGroup) this.bmw.getPlayerView().getParent()).removeView(this.bmw.getPlayerView());
        }
        removeAllViews();
    }

    @Override // com.baidu.live.p.f
    public void bZ(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("VideoChatLivePlayer stopLivePlayer()");
        }
        if (z) {
            KB();
        }
        this.bmy = "";
        if (this.bmw != null) {
            this.bmw.a(null);
            this.bmw.stop();
        }
    }

    @Override // com.baidu.live.p.f
    public View getLivePlayer() {
        return this;
    }

    public void destroy() {
        if (this.bmw != null) {
            this.bmw.a(null);
            this.bmw.release();
            this.bmw = null;
        }
    }

    public void setIPlayerCallBack(b bVar) {
        this.bmx = bVar;
    }

    public String getVideoPath() {
        return this.bmy;
    }
}
