package com.baidu.live.talentshow.components.waitpanel;

import android.os.CountDownTimer;
import android.view.KeyEvent;
import com.baidu.live.data.w;
import com.baidu.live.talentshow.components.waitpanel.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class d {
    private b bAI;
    private LiveVideoBCPanelData bAJ;
    private a bAK;
    private CountDownTimer bAL;
    private TbPageContext mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void Mk();

        void SR();
    }

    public d(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void u(w wVar) {
        if (this.bAJ == null) {
            this.bAJ = new LiveVideoBCPanelData();
        }
        this.bAJ.setUserNickName(wVar.aKr.nickName);
        this.bAJ.setUserPortrait(wVar.aKr.portrait);
        this.bAJ.setAnchorNickName(wVar.aJV.userName);
        this.bAJ.setAnchorPortrait(wVar.aJV.portrait);
        this.bAJ.setDownTime(wVar.mLiveInfo.videoBCEnterData.audienceWaitTime);
        TB();
        this.bAL.cancel();
        this.bAL.start();
    }

    public void SF() {
        if (this.bAI == null) {
            this.bAI = new b(this.mContext, this.bAJ);
            this.bAI.a(new a.InterfaceC0212a() { // from class: com.baidu.live.talentshow.components.waitpanel.d.1
                @Override // com.baidu.live.talentshow.components.waitpanel.a.InterfaceC0212a
                public void a(LiveVideoBCPanelData liveVideoBCPanelData) {
                    if (d.this.bAK != null) {
                        d.this.bAK.SR();
                    }
                }
            });
        }
        this.bAI.b(this.bAJ);
        com.baidu.live.talentshow.e.a.UA();
    }

    public void stopTiming() {
        if (this.bAL != null) {
            this.bAL.cancel();
        }
    }

    public void TA() {
        if (this.bAI != null && this.bAI.isShowing()) {
            this.bAI.dismiss();
        }
    }

    public void a(a aVar) {
        this.bAK = aVar;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bAI == null || !this.bAI.isShowing()) {
            return false;
        }
        this.bAI.dismiss();
        return true;
    }

    private void TB() {
        if (this.bAL == null) {
            this.bAL = new CountDownTimer(this.bAJ.getDownTime() * 1000, 1000L) { // from class: com.baidu.live.talentshow.components.waitpanel.d.2
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    if (d.this.bAI != null && d.this.bAJ != null) {
                        d.this.bAJ.setDownTime(((int) (j / 1000)) + 1);
                        d.this.bAI.a((b) d.this.bAJ);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (d.this.bAK != null) {
                        d.this.bAK.Mk();
                    }
                }
            };
        }
    }
}
