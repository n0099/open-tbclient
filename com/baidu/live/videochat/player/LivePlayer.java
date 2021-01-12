package com.baidu.live.videochat.player;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.af.a;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import com.baidu.live.data.bq;
import com.baidu.live.liveroom.e.d;
import com.baidu.live.liveroom.e.g;
import com.baidu.live.liveroom.e.i;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.v.b;
import com.baidu.live.v.f;
import com.baidu.live.v.h;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class LivePlayer extends FrameLayout implements f {
    private d bNY;
    private b bNZ;
    private String bOa;
    private AlaLiveInfoData bnl;
    private Context mContext;

    public LivePlayer(Context context) {
        super(context);
        d ba;
        this.bOa = "";
        this.mContext = context;
        boolean z = a.OJ().bru.aIB;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            ba = i.Lv().ba(context);
        } else if (z) {
            ba = i.Lv().bb(context);
        } else {
            ba = i.Lv().ba(context);
        }
        this.bNY = ba;
    }

    private FrameLayout.LayoutParams Vy() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    @Override // com.baidu.live.v.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        int i;
        int i2 = 1;
        if (alaLiveInfoData != null) {
            this.bnl = alaLiveInfoData;
            FrameLayout.LayoutParams Vy = Vy();
            bq bqVar = a.OJ().bxp;
            if (bqVar != null && bqVar.aMV != null && ((i = bqVar.aMV.aNK) == 1 || i == 2)) {
                i2 = i;
            }
            if ("ZTE A0622".equals(Build.MODEL)) {
                i2 = 2;
            }
            a(alaLiveInfoData, Vy, i2, alaLiveInfoData.screen_direction != 2 ? 0 : 2);
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
            this.bOa = str;
            final d dVar = this.bNY;
            if (dVar.Lu() != null && dVar.Lu().getParent() != null) {
                ((ViewGroup) dVar.Lu().getParent()).removeView(dVar.Lu());
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                jSONObject.put("clientIp", a.OJ().bru.clientIP);
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
            dVar.dB(4);
            addView(dVar.Lu(), layoutParams);
            dVar.setPlayerCallback(new g() { // from class: com.baidu.live.videochat.player.LivePlayer.1
                @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                public void a(d dVar2, int i3, int i4) {
                    if (i3 == 904) {
                        if (LivePlayer.this.bNZ != null) {
                            LivePlayer.this.bNZ.cs(1);
                        }
                        dVar.dB(0);
                    }
                }
            });
            dVar.e(Uri.parse(str));
            dVar.start();
            dVar.setVideoScalingMode(i2);
        }
    }

    private void Vz() {
        if (this.bNY != null && this.bNY.Lu() != null && this.bNY.Lu().getParent() != null) {
            ((ViewGroup) this.bNY.Lu().getParent()).removeView(this.bNY.Lu());
        }
        removeAllViews();
    }

    @Override // com.baidu.live.v.f
    public void cD(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("VideoChatLivePlayer stopLivePlayer()");
        }
        if (z) {
            Vz();
        }
        this.bOa = "";
        if (this.bNY != null) {
            this.bNY.setPlayerCallback(null);
            this.bNY.stop();
        }
    }

    @Override // com.baidu.live.v.f
    public View getLivePlayer() {
        return this;
    }

    public void destroy() {
        if (this.bNY != null) {
            this.bNY.setPlayerCallback(null);
            this.bNY.release();
            this.bNY = null;
        }
    }

    public void setIPlayerCallBack(b bVar) {
        this.bNZ = bVar;
    }

    @Override // com.baidu.live.v.f
    public String getVideoPath() {
        return this.bOa;
    }
}
