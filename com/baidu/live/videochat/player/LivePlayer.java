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
import com.baidu.platform.comapi.map.MapBundleKey;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class LivePlayer extends FrameLayout implements f {
    private d bSK;
    private b bSL;
    private String bSM;
    private AlaLiveInfoData brX;
    private Context mContext;

    public LivePlayer(Context context) {
        super(context);
        d bb;
        this.bSM = "";
        this.mContext = context;
        boolean z = a.SE().bwi.aNo;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            bb = i.Pq().bb(context);
        } else if (z) {
            bb = i.Pq().bc(context);
        } else {
            bb = i.Pq().bb(context);
        }
        this.bSK = bb;
    }

    private FrameLayout.LayoutParams Zr() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    @Override // com.baidu.live.v.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        int i;
        int i2 = 1;
        if (alaLiveInfoData != null) {
            this.brX = alaLiveInfoData;
            FrameLayout.LayoutParams Zr = Zr();
            bq bqVar = a.SE().bCb;
            if (bqVar != null && bqVar.aRI != null && ((i = bqVar.aRI.aSx) == 1 || i == 2)) {
                i2 = i;
            }
            if ("ZTE A0622".equals(Build.MODEL)) {
                i2 = 2;
            }
            a(alaLiveInfoData, Zr, i2, alaLiveInfoData.screen_direction != 2 ? 0 : 2);
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
            this.bSM = str;
            final d dVar = this.bSK;
            if (dVar.Pp() != null && dVar.Pp().getParent() != null) {
                ((ViewGroup) dVar.Pp().getParent()).removeView(dVar.Pp());
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                jSONObject.put("clientIp", a.SE().bwi.clientIP);
                jSONObject.put(MapBundleKey.MapObjKey.OBJ_LEVEL, AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT);
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
            dVar.fh(4);
            addView(dVar.Pp(), layoutParams);
            dVar.setPlayerCallback(new g() { // from class: com.baidu.live.videochat.player.LivePlayer.1
                @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                public void a(d dVar2, int i3, int i4) {
                    if (i3 == 904) {
                        if (LivePlayer.this.bSL != null) {
                            LivePlayer.this.bSL.dY(1);
                        }
                        dVar.fh(0);
                    }
                }
            });
            dVar.e(Uri.parse(str));
            dVar.start();
            dVar.setVideoScalingMode(i2);
        }
    }

    private void Zs() {
        if (this.bSK != null && this.bSK.Pp() != null && this.bSK.Pp().getParent() != null) {
            ((ViewGroup) this.bSK.Pp().getParent()).removeView(this.bSK.Pp());
        }
        removeAllViews();
    }

    @Override // com.baidu.live.v.f
    public void cH(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("VideoChatLivePlayer stopLivePlayer()");
        }
        if (z) {
            Zs();
        }
        this.bSM = "";
        if (this.bSK != null) {
            this.bSK.setPlayerCallback(null);
            this.bSK.stop();
        }
    }

    @Override // com.baidu.live.v.f
    public View getLivePlayer() {
        return this;
    }

    public void destroy() {
        if (this.bSK != null) {
            this.bSK.setPlayerCallback(null);
            this.bSK.release();
            this.bSK = null;
        }
    }

    public void setIPlayerCallBack(b bVar) {
        this.bSL = bVar;
    }

    @Override // com.baidu.live.v.f
    public String getVideoPath() {
        return this.bSM;
    }
}
