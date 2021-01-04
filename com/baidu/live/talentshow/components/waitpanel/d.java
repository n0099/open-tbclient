package com.baidu.live.talentshow.components.waitpanel;

import android.os.CountDownTimer;
import android.view.KeyEvent;
import com.baidu.live.data.x;
import com.baidu.live.talentshow.components.waitpanel.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class d {
    private b bFv;
    private LiveVideoBCPanelData bFw;
    private a bFx;
    private CountDownTimer bFy;
    private TbPageContext mContext;

    /* loaded from: classes11.dex */
    public interface a {
        void TY();

        void onTimeout();
    }

    public d(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void v(x xVar) {
        if (this.bFw == null) {
            this.bFw = new LiveVideoBCPanelData();
        }
        this.bFw.setUserNickName(xVar.aKQ.nickName);
        this.bFw.setUserPortrait(xVar.aKQ.portrait);
        this.bFw.setAnchorNickName(xVar.aKu.userName);
        this.bFw.setAnchorPortrait(xVar.aKu.portrait);
        this.bFw.setDownTime(xVar.mLiveInfo.videoBCEnterData.audienceWaitTime);
        UG();
        this.bFy.cancel();
        this.bFy.start();
    }

    public void TJ() {
        if (this.bFv == null) {
            this.bFv = new b(this.mContext, this.bFw);
            this.bFv.a(new a.InterfaceC0210a() { // from class: com.baidu.live.talentshow.components.waitpanel.d.1
                @Override // com.baidu.live.talentshow.components.waitpanel.a.InterfaceC0210a
                public void a(LiveVideoBCPanelData liveVideoBCPanelData) {
                    if (d.this.bFx != null) {
                        d.this.bFx.TY();
                    }
                }
            });
        }
        this.bFv.b(this.bFw);
        com.baidu.live.talentshow.e.a.VF();
    }

    public void stopTiming() {
        if (this.bFy != null) {
            this.bFy.cancel();
        }
    }

    public void UF() {
        if (this.bFv != null && this.bFv.isShowing()) {
            this.bFv.dismiss();
        }
    }

    public void a(a aVar) {
        this.bFx = aVar;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bFv == null || !this.bFv.isShowing()) {
            return false;
        }
        this.bFv.dismiss();
        return true;
    }

    private void UG() {
        if (this.bFy == null) {
            this.bFy = new CountDownTimer(this.bFw.getDownTime() * 1000, 1000L) { // from class: com.baidu.live.talentshow.components.waitpanel.d.2
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    if (d.this.bFv != null && d.this.bFw != null) {
                        d.this.bFw.setDownTime(((int) (j / 1000)) + 1);
                        d.this.bFv.a((b) d.this.bFw);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (d.this.bFx != null) {
                        d.this.bFx.onTimeout();
                    }
                }
            };
        }
    }
}
