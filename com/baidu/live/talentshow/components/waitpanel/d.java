package com.baidu.live.talentshow.components.waitpanel;

import android.os.CountDownTimer;
import android.view.KeyEvent;
import com.baidu.live.data.ab;
import com.baidu.live.talentshow.components.waitpanel.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class d {
    private b bEp;
    private LiveVideoBCPanelData bEq;
    private a bEr;
    private CountDownTimer bEs;
    private TbPageContext mContext;

    /* loaded from: classes11.dex */
    public interface a {
        void RN();

        void onTimeout();
    }

    public d(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void v(ab abVar) {
        if (this.bEq == null) {
            this.bEq = new LiveVideoBCPanelData();
        }
        this.bEq.setUserNickName(abVar.aIz.nickName);
        this.bEq.setUserPortrait(abVar.aIz.portrait);
        this.bEq.setAnchorNickName(abVar.aId.userName);
        this.bEq.setAnchorPortrait(abVar.aId.portrait);
        this.bEq.setDownTime(abVar.mLiveInfo.videoBCEnterData.audienceWaitTime);
        Sv();
        this.bEs.cancel();
        this.bEs.start();
    }

    public void Ry() {
        if (this.bEp == null) {
            this.bEp = new b(this.mContext, this.bEq);
            this.bEp.a(new a.InterfaceC0203a() { // from class: com.baidu.live.talentshow.components.waitpanel.d.1
                @Override // com.baidu.live.talentshow.components.waitpanel.a.InterfaceC0203a
                public void a(LiveVideoBCPanelData liveVideoBCPanelData) {
                    if (d.this.bEr != null) {
                        d.this.bEr.RN();
                    }
                }
            });
        }
        this.bEp.b(this.bEq);
        com.baidu.live.talentshow.e.a.Tt();
    }

    public void stopTiming() {
        if (this.bEs != null) {
            this.bEs.cancel();
        }
    }

    public void Su() {
        if (this.bEp != null && this.bEp.isShowing()) {
            this.bEp.dismiss();
        }
    }

    public void a(a aVar) {
        this.bEr = aVar;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bEp == null || !this.bEp.isShowing()) {
            return false;
        }
        this.bEp.dismiss();
        return true;
    }

    private void Sv() {
        if (this.bEs == null) {
            this.bEs = new CountDownTimer(this.bEq.getDownTime() * 1000, 1000L) { // from class: com.baidu.live.talentshow.components.waitpanel.d.2
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    if (d.this.bEp != null && d.this.bEq != null) {
                        d.this.bEq.setDownTime(((int) (j / 1000)) + 1);
                        d.this.bEp.a((b) d.this.bEq);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (d.this.bEr != null) {
                        d.this.bEr.onTimeout();
                    }
                }
            };
        }
    }
}
