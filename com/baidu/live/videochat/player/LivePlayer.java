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
import com.baidu.live.data.ax;
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
    private AlaLiveInfoData bfM;
    private a bgV;
    private b bgW;
    private String bgX;
    private Context mContext;

    public LivePlayer(Context context) {
        super(context);
        a ar;
        this.bgX = "";
        this.mContext = context;
        boolean z = com.baidu.live.v.a.Ge().aWF.awX;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            ar = e.Fc().ar(context);
        } else if (z) {
            ar = e.Fc().as(context);
        } else {
            ar = e.Fc().ar(context);
        }
        this.bgV = ar;
    }

    private FrameLayout.LayoutParams Jg() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    @Override // com.baidu.live.o.f
    public void b(AlaLiveInfoData alaLiveInfoData) {
        int i;
        int i2 = 1;
        if (alaLiveInfoData != null) {
            this.bfM = alaLiveInfoData;
            FrameLayout.LayoutParams Jg = Jg();
            ax axVar = com.baidu.live.v.a.Ge().aYP;
            if (axVar != null && axVar.aAP != null && ((i = axVar.aAP.decodeMode) == 1 || i == 2)) {
                i2 = i;
            }
            if ("ZTE A0622".equals(Build.MODEL)) {
                i2 = 2;
            }
            a(alaLiveInfoData, Jg, i2, alaLiveInfoData.screen_direction != 2 ? 0 : 2);
        }
    }

    private void a(AlaLiveInfoData alaLiveInfoData, FrameLayout.LayoutParams layoutParams, int i, int i2) {
        String c = h.c(alaLiveInfoData);
        if (!TextUtils.isEmpty(c)) {
            if (BdLog.isDebugMode()) {
                BdLog.e("VideoChatLivePlayer startLive=url=" + c);
            }
            this.bgX = c;
            final a aVar = this.bgV;
            if (aVar.getPlayerView() != null && aVar.getPlayerView().getParent() != null) {
                ((ViewGroup) aVar.getPlayerView().getParent()).removeView(aVar.getPlayerView());
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                jSONObject.put("clientIp", com.baidu.live.v.a.Ge().aWF.clientIP);
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
            aVar.cB(8);
            addView(aVar.getPlayerView(), layoutParams);
            aVar.a(new d() { // from class: com.baidu.live.videochat.player.LivePlayer.1
                @Override // com.baidu.live.liveroom.e.c
                public void a(a aVar2, int i3, int i4) {
                    if (i3 == 904) {
                        if (LivePlayer.this.bgW != null) {
                            LivePlayer.this.bgW.bE(1);
                        }
                        aVar.cB(0);
                    }
                }
            });
            aVar.c(Uri.parse(c));
            aVar.start();
            aVar.setVideoScalingMode(i2);
        }
    }

    private void Jh() {
        if (this.bgV != null && this.bgV.getPlayerView() != null && this.bgV.getPlayerView().getParent() != null) {
            ((ViewGroup) this.bgV.getPlayerView().getParent()).removeView(this.bgV.getPlayerView());
        }
        removeAllViews();
    }

    @Override // com.baidu.live.o.f
    public void bW(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("VideoChatLivePlayer stopLivePlayer()");
        }
        if (z) {
            Jh();
        }
        this.bgX = "";
        if (this.bgV != null) {
            this.bgV.a(null);
            this.bgV.stop();
        }
    }

    @Override // com.baidu.live.o.f
    public View getLivePlayer() {
        return this;
    }

    public void destroy() {
        if (this.bgV != null) {
            this.bgV.a(null);
            this.bgV.release();
            this.bgV = null;
        }
    }

    public void setIPlayerCallBack(b bVar) {
        this.bgW = bVar;
    }

    public String getVideoPath() {
        return this.bgX;
    }
}
