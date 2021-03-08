package com.baidu.live.talentshow.components.waitpanel;

import android.os.CountDownTimer;
import android.view.KeyEvent;
import com.baidu.live.data.ab;
import com.baidu.live.talentshow.components.waitpanel.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class d {
    private b bFP;
    private LiveVideoBCPanelData bFQ;
    private a bFR;
    private CountDownTimer bFS;
    private TbPageContext mContext;

    /* loaded from: classes10.dex */
    public interface a {
        void RQ();

        void onTimeout();
    }

    public d(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void v(ab abVar) {
        if (this.bFQ == null) {
            this.bFQ = new LiveVideoBCPanelData();
        }
        this.bFQ.setUserNickName(abVar.aJZ.nickName);
        this.bFQ.setUserPortrait(abVar.aJZ.portrait);
        this.bFQ.setAnchorNickName(abVar.aJD.userName);
        this.bFQ.setAnchorPortrait(abVar.aJD.portrait);
        this.bFQ.setDownTime(abVar.mLiveInfo.videoBCEnterData.audienceWaitTime);
        Sy();
        this.bFS.cancel();
        this.bFS.start();
    }

    public void RB() {
        if (this.bFP == null) {
            this.bFP = new b(this.mContext, this.bFQ);
            this.bFP.a(new a.InterfaceC0209a() { // from class: com.baidu.live.talentshow.components.waitpanel.d.1
                @Override // com.baidu.live.talentshow.components.waitpanel.a.InterfaceC0209a
                public void a(LiveVideoBCPanelData liveVideoBCPanelData) {
                    if (d.this.bFR != null) {
                        d.this.bFR.RQ();
                    }
                }
            });
        }
        this.bFP.b(this.bFQ);
        com.baidu.live.talentshow.e.a.Tw();
    }

    public void stopTiming() {
        if (this.bFS != null) {
            this.bFS.cancel();
        }
    }

    public void Sx() {
        if (this.bFP != null && this.bFP.isShowing()) {
            this.bFP.dismiss();
        }
    }

    public void a(a aVar) {
        this.bFR = aVar;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bFP == null || !this.bFP.isShowing()) {
            return false;
        }
        this.bFP.dismiss();
        return true;
    }

    private void Sy() {
        if (this.bFS == null) {
            this.bFS = new CountDownTimer(this.bFQ.getDownTime() * 1000, 1000L) { // from class: com.baidu.live.talentshow.components.waitpanel.d.2
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    if (d.this.bFP != null && d.this.bFQ != null) {
                        d.this.bFQ.setDownTime(((int) (j / 1000)) + 1);
                        d.this.bFP.a((b) d.this.bFQ);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (d.this.bFR != null) {
                        d.this.bFR.onTimeout();
                    }
                }
            };
        }
    }
}
