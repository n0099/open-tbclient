package com.baidu.live.talentshow.components.waitpanel;

import android.os.CountDownTimer;
import android.view.KeyEvent;
import com.baidu.live.data.w;
import com.baidu.live.talentshow.components.waitpanel.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class d {
    private a bvA;
    private CountDownTimer bvB;
    private b bvy;
    private LiveVideoBCPanelData bvz;
    private TbPageContext mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void Ki();

        void Qt();
    }

    public d(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void u(w wVar) {
        if (this.bvz == null) {
            this.bvz = new LiveVideoBCPanelData();
        }
        this.bvz.setUserNickName(wVar.aHG.nickName);
        this.bvz.setUserPortrait(wVar.aHG.portrait);
        this.bvz.setAnchorNickName(wVar.aHk.userName);
        this.bvz.setAnchorPortrait(wVar.aHk.portrait);
        this.bvz.setDownTime(wVar.mLiveInfo.videoBCEnterData.audienceWaitTime);
        Rd();
        this.bvB.cancel();
        this.bvB.start();
    }

    public void Qh() {
        if (this.bvy == null) {
            this.bvy = new b(this.mContext, this.bvz);
            this.bvy.a(new a.InterfaceC0202a() { // from class: com.baidu.live.talentshow.components.waitpanel.d.1
                @Override // com.baidu.live.talentshow.components.waitpanel.a.InterfaceC0202a
                public void a(LiveVideoBCPanelData liveVideoBCPanelData) {
                    if (d.this.bvA != null) {
                        d.this.bvA.Qt();
                    }
                }
            });
        }
        this.bvy.b(this.bvz);
        com.baidu.live.talentshow.e.a.Sc();
    }

    public void stopTiming() {
        if (this.bvB != null) {
            this.bvB.cancel();
        }
    }

    public void Rc() {
        if (this.bvy != null && this.bvy.isShowing()) {
            this.bvy.dismiss();
        }
    }

    public void a(a aVar) {
        this.bvA = aVar;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bvy == null || !this.bvy.isShowing()) {
            return false;
        }
        this.bvy.dismiss();
        return true;
    }

    private void Rd() {
        if (this.bvB == null) {
            this.bvB = new CountDownTimer(this.bvz.getDownTime() * 1000, 1000L) { // from class: com.baidu.live.talentshow.components.waitpanel.d.2
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    if (d.this.bvy != null && d.this.bvz != null) {
                        d.this.bvz.setDownTime(((int) (j / 1000)) + 1);
                        d.this.bvy.a((b) d.this.bvz);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (d.this.bvA != null) {
                        d.this.bvA.Ki();
                    }
                }
            };
        }
    }
}
