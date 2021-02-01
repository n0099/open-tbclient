package com.baidu.live.videochat.player;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.ae.a;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import com.baidu.live.data.bv;
import com.baidu.live.liveroom.e.d;
import com.baidu.live.liveroom.e.g;
import com.baidu.live.liveroom.e.i;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.b;
import com.baidu.live.u.f;
import com.baidu.live.u.h;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class LivePlayer extends FrameLayout implements f {
    private d bRO;
    private b bRP;
    private String bRQ;
    private AlaLiveInfoData bqM;
    private Context mContext;

    public LivePlayer(Context context) {
        super(context);
        d ba;
        this.bRQ = "";
        this.mContext = context;
        boolean z = a.Qj().buX.aLl;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            ba = i.MT().ba(context);
        } else if (z) {
            ba = i.MT().bb(context);
        } else {
            ba = i.MT().ba(context);
        }
        this.bRO = ba;
    }

    private FrameLayout.LayoutParams Xh() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    @Override // com.baidu.live.u.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        int i;
        int i2 = 1;
        if (alaLiveInfoData != null) {
            this.bqM = alaLiveInfoData;
            FrameLayout.LayoutParams Xh = Xh();
            bv bvVar = a.Qj().bAS;
            if (bvVar != null && bvVar.aPT != null && ((i = bvVar.aPT.aQL) == 1 || i == 2)) {
                i2 = i;
            }
            if ("ZTE A0622".equals(Build.MODEL)) {
                i2 = 2;
            }
            a(alaLiveInfoData, Xh, i2, alaLiveInfoData.screen_direction != 2 ? 0 : 2);
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
            this.bRQ = str;
            final d dVar = this.bRO;
            if (dVar.MS() != null && dVar.MS().getParent() != null) {
                ((ViewGroup) dVar.MS().getParent()).removeView(dVar.MS());
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                jSONObject.put("clientIp", a.Qj().buX.clientIP);
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
            dVar.dH(4);
            addView(dVar.MS(), layoutParams);
            dVar.setPlayerCallback(new g() { // from class: com.baidu.live.videochat.player.LivePlayer.1
                @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                public void a(d dVar2, int i3, int i4) {
                    if (i3 == 904) {
                        if (LivePlayer.this.bRP != null) {
                            LivePlayer.this.bRP.cv(1);
                        }
                        dVar.dH(0);
                    }
                }
            });
            dVar.e(Uri.parse(str));
            dVar.start();
            dVar.setVideoScalingMode(i2);
        }
    }

    private void Xi() {
        if (this.bRO != null && this.bRO.MS() != null && this.bRO.MS().getParent() != null) {
            ((ViewGroup) this.bRO.MS().getParent()).removeView(this.bRO.MS());
        }
        removeAllViews();
    }

    @Override // com.baidu.live.u.f
    public void cM(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("VideoChatLivePlayer stopLivePlayer()");
        }
        if (z) {
            Xi();
        }
        this.bRQ = "";
        if (this.bRO != null) {
            this.bRO.setPlayerCallback(null);
            this.bRO.stop();
        }
    }

    @Override // com.baidu.live.u.f
    public View getLivePlayer() {
        return this;
    }

    public void destroy() {
        if (this.bRO != null) {
            this.bRO.setPlayerCallback(null);
            this.bRO.release();
            this.bRO = null;
        }
    }

    @Override // com.baidu.live.u.f
    public void setVideoMode(int i) {
        if (this.bRO != null) {
            this.bRO.setVideoScalingMode(i);
        }
    }

    public void setIPlayerCallBack(b bVar) {
        this.bRP = bVar;
    }

    @Override // com.baidu.live.u.f
    public String getVideoPath() {
        return this.bRQ;
    }
}
