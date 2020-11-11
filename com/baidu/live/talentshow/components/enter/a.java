package com.baidu.live.talentshow.components.enter;

import android.view.View;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.talentshow.d.d;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a {
    private w aES;
    private LiveBCChatEnterView bvM;
    private b bvN;
    private View.OnClickListener bvO = new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.enter.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.fj(0);
            if (a.this.bvN != null) {
                a.this.bvN.Z(view);
            }
        }
    };
    private boolean isHost;
    private TbPageContext mContext;

    public a(TbPageContext tbPageContext, boolean z) {
        this.isHost = false;
        this.mContext = tbPageContext;
        this.isHost = z;
    }

    public void s(w wVar) {
        this.aES = wVar;
    }

    public void Rk() {
        if (this.bvM != null) {
            this.bvM.setEnterVisible(false);
        }
    }

    public View getEnterView() {
        if (this.aES == null) {
            return null;
        }
        if (this.bvM == null) {
            this.bvM = new LiveBCChatEnterView(this.mContext.getPageActivity());
            this.bvM.setOnClickListener(this.bvO);
            this.bvM.setEnterVisible(true);
        }
        if (this.isHost) {
            b(this.bvM);
        } else {
            a(this.bvM);
        }
        return this.bvM;
    }

    public void fj(int i) {
        if (this.bvM != null) {
            if (this.isHost) {
                if (i > 0) {
                    this.bvM.setRedDotVisible(true);
                    return;
                } else {
                    this.bvM.setRedDotVisible(false);
                    return;
                }
            }
            this.bvM.setRedDotVisible(false);
        }
    }

    public void fk(int i) {
        if (!this.isHost) {
            fl(i);
        }
    }

    private void fl(int i) {
        if (this.bvM != null) {
            if (i == d.byB || i == d.byA || i == d.byC) {
                this.bvM.setEnterImageDrawable(a.e.liveshow_enter_connecting);
            } else if (i == d.byD) {
                this.bvM.setEnterImageDrawable(a.e.liveshow_enter_connected);
            } else {
                this.bvM.setEnterImageDrawable(a.e.liveshow_enter_idle);
            }
        }
    }

    public void a(b bVar) {
        this.bvN = bVar;
    }

    private void a(LiveBCChatEnterView liveBCChatEnterView) {
        liveBCChatEnterView.setEnterVisible(true);
        liveBCChatEnterView.setRedDotVisible(false);
    }

    private void b(LiveBCChatEnterView liveBCChatEnterView) {
        liveBCChatEnterView.setEnterVisible(true);
        liveBCChatEnterView.setRedDotVisible(false);
    }
}
