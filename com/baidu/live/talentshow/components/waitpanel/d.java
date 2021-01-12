package com.baidu.live.talentshow.components.waitpanel;

import android.os.CountDownTimer;
import android.view.KeyEvent;
import com.baidu.live.data.x;
import com.baidu.live.talentshow.components.waitpanel.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class d {
    private b bAJ;
    private LiveVideoBCPanelData bAK;
    private a bAL;
    private CountDownTimer bAM;
    private TbPageContext mContext;

    /* loaded from: classes10.dex */
    public interface a {
        void Qd();

        void onTimeout();
    }

    public d(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void v(x xVar) {
        if (this.bAK == null) {
            this.bAK = new LiveVideoBCPanelData();
        }
        this.bAK.setUserNickName(xVar.aGd.nickName);
        this.bAK.setUserPortrait(xVar.aGd.portrait);
        this.bAK.setAnchorNickName(xVar.aFH.userName);
        this.bAK.setAnchorPortrait(xVar.aFH.portrait);
        this.bAK.setDownTime(xVar.mLiveInfo.videoBCEnterData.audienceWaitTime);
        QL();
        this.bAM.cancel();
        this.bAM.start();
    }

    public void PO() {
        if (this.bAJ == null) {
            this.bAJ = new b(this.mContext, this.bAK);
            this.bAJ.a(new a.InterfaceC0201a() { // from class: com.baidu.live.talentshow.components.waitpanel.d.1
                @Override // com.baidu.live.talentshow.components.waitpanel.a.InterfaceC0201a
                public void a(LiveVideoBCPanelData liveVideoBCPanelData) {
                    if (d.this.bAL != null) {
                        d.this.bAL.Qd();
                    }
                }
            });
        }
        this.bAJ.b(this.bAK);
        com.baidu.live.talentshow.e.a.RM();
    }

    public void stopTiming() {
        if (this.bAM != null) {
            this.bAM.cancel();
        }
    }

    public void QK() {
        if (this.bAJ != null && this.bAJ.isShowing()) {
            this.bAJ.dismiss();
        }
    }

    public void a(a aVar) {
        this.bAL = aVar;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bAJ == null || !this.bAJ.isShowing()) {
            return false;
        }
        this.bAJ.dismiss();
        return true;
    }

    private void QL() {
        if (this.bAM == null) {
            this.bAM = new CountDownTimer(this.bAK.getDownTime() * 1000, 1000L) { // from class: com.baidu.live.talentshow.components.waitpanel.d.2
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    if (d.this.bAJ != null && d.this.bAK != null) {
                        d.this.bAK.setDownTime(((int) (j / 1000)) + 1);
                        d.this.bAJ.a((b) d.this.bAK);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (d.this.bAL != null) {
                        d.this.bAL.onTimeout();
                    }
                }
            };
        }
    }
}
