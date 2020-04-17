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
import com.baidu.live.data.as;
import com.baidu.live.liveroom.e.a;
import com.baidu.live.liveroom.e.d;
import com.baidu.live.liveroom.e.e;
import com.baidu.live.o.b;
import com.baidu.live.o.f;
import com.baidu.live.o.h;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LivePlayer extends FrameLayout implements f {
    private AlaLiveInfoData aYl;
    private a aZt;
    private b aZu;
    private String aZv;
    private Context mContext;

    public LivePlayer(Context context) {
        super(context);
        a at;
        this.aZv = "";
        this.mContext = context;
        boolean z = com.baidu.live.v.a.Eo().aQp.arQ;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            at = e.DF().at(context);
        } else if (z) {
            at = e.DF().au(context);
        } else {
            at = e.DF().at(context);
        }
        this.aZt = at;
    }

    private FrameLayout.LayoutParams Ho() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    @Override // com.baidu.live.o.f
    public void b(AlaLiveInfoData alaLiveInfoData) {
        int i;
        int i2 = 1;
        if (alaLiveInfoData != null) {
            this.aYl = alaLiveInfoData;
            FrameLayout.LayoutParams Ho = Ho();
            as asVar = com.baidu.live.v.a.Eo().aRw;
            if (asVar != null && asVar.avB != null && ((i = asVar.avB.decodeMode) == 1 || i == 2)) {
                i2 = i;
            }
            if ("ZTE A0622".equals(Build.MODEL)) {
                i2 = 2;
            }
            a(alaLiveInfoData, Ho, i2, alaLiveInfoData.screen_direction != 2 ? 0 : 2);
        }
    }

    private void a(AlaLiveInfoData alaLiveInfoData, FrameLayout.LayoutParams layoutParams, int i, int i2) {
        String c = h.c(alaLiveInfoData);
        if (!TextUtils.isEmpty(c)) {
            if (BdLog.isDebugMode()) {
                BdLog.e("VideoChatLivePlayer startLive=url=" + c);
            }
            this.aZv = c;
            final a aVar = this.aZt;
            if (aVar.getPlayerView() != null && aVar.getPlayerView().getParent() != null) {
                ((ViewGroup) aVar.getPlayerView().getParent()).removeView(aVar.getPlayerView());
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                jSONObject.put("clientIp", com.baidu.live.v.a.Eo().aQp.clientIP);
                jSONObject.put(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT);
                jSONObject.put("sessionLine", 1);
                aVar.b(1, jSONObject);
            } catch (Exception e) {
                if (BdLog.isDebugMode()) {
                    BdLog.e(e);
                }
            }
            aVar.a(null);
            aVar.d(this.mContext, Uri.parse(c));
            aVar.setDecodeMode(i);
            aVar.cu(8);
            addView(aVar.getPlayerView(), layoutParams);
            aVar.a(new d() { // from class: com.baidu.live.videochat.player.LivePlayer.1
                @Override // com.baidu.live.liveroom.e.c
                public void a(a aVar2, int i3, int i4) {
                    if (i3 == 904) {
                        if (LivePlayer.this.aZu != null) {
                            LivePlayer.this.aZu.bx(1);
                        }
                        aVar.cu(0);
                    }
                }
            });
            aVar.c(Uri.parse(c));
            aVar.start();
            aVar.setVideoScalingMode(i2);
        }
    }

    private void Hp() {
        if (this.aZt != null && this.aZt.getPlayerView() != null && this.aZt.getPlayerView().getParent() != null) {
            ((ViewGroup) this.aZt.getPlayerView().getParent()).removeView(this.aZt.getPlayerView());
        }
        removeAllViews();
    }

    @Override // com.baidu.live.o.f
    public void bM(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("VideoChatLivePlayer stopLivePlayer()");
        }
        if (z) {
            Hp();
        }
        this.aZv = "";
        if (this.aZt != null) {
            this.aZt.a(null);
            this.aZt.stop();
        }
    }

    @Override // com.baidu.live.o.f
    public View getLivePlayer() {
        return this;
    }

    public void destroy() {
        if (this.aZt != null) {
            this.aZt.a(null);
            this.aZt.release();
            this.aZt = null;
        }
    }

    public void setIPlayerCallBack(b bVar) {
        this.aZu = bVar;
    }

    public String getVideoPath() {
        return this.aZv;
    }
}
