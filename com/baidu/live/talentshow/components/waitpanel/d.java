package com.baidu.live.talentshow.components.waitpanel;

import android.os.CountDownTimer;
import android.view.KeyEvent;
import com.baidu.live.data.w;
import com.baidu.live.talentshow.components.waitpanel.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class d {
    private b bxj;
    private LiveVideoBCPanelData bxk;
    private a bxl;
    private CountDownTimer bxm;
    private TbPageContext mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void KR();

        void Rc();
    }

    public d(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void u(w wVar) {
        if (this.bxk == null) {
            this.bxk = new LiveVideoBCPanelData();
        }
        this.bxk.setUserNickName(wVar.aJr.nickName);
        this.bxk.setUserPortrait(wVar.aJr.portrait);
        this.bxk.setAnchorNickName(wVar.aIV.userName);
        this.bxk.setAnchorPortrait(wVar.aIV.portrait);
        this.bxk.setDownTime(wVar.mLiveInfo.videoBCEnterData.audienceWaitTime);
        RM();
        this.bxm.cancel();
        this.bxm.start();
    }

    public void QQ() {
        if (this.bxj == null) {
            this.bxj = new b(this.mContext, this.bxk);
            this.bxj.a(new a.InterfaceC0204a() { // from class: com.baidu.live.talentshow.components.waitpanel.d.1
                @Override // com.baidu.live.talentshow.components.waitpanel.a.InterfaceC0204a
                public void a(LiveVideoBCPanelData liveVideoBCPanelData) {
                    if (d.this.bxl != null) {
                        d.this.bxl.Rc();
                    }
                }
            });
        }
        this.bxj.b(this.bxk);
        com.baidu.live.talentshow.e.a.SL();
    }

    public void stopTiming() {
        if (this.bxm != null) {
            this.bxm.cancel();
        }
    }

    public void RL() {
        if (this.bxj != null && this.bxj.isShowing()) {
            this.bxj.dismiss();
        }
    }

    public void a(a aVar) {
        this.bxl = aVar;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bxj == null || !this.bxj.isShowing()) {
            return false;
        }
        this.bxj.dismiss();
        return true;
    }

    private void RM() {
        if (this.bxm == null) {
            this.bxm = new CountDownTimer(this.bxk.getDownTime() * 1000, 1000L) { // from class: com.baidu.live.talentshow.components.waitpanel.d.2
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    if (d.this.bxj != null && d.this.bxk != null) {
                        d.this.bxk.setDownTime(((int) (j / 1000)) + 1);
                        d.this.bxj.a((b) d.this.bxk);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (d.this.bxl != null) {
                        d.this.bxl.KR();
                    }
                }
            };
        }
    }
}
