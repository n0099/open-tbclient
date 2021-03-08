package com.baidu.live.talentshow.components.enter;

import android.view.View;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.talentshow.d.d;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class a {
    private ab aED;
    private LiveBCChatEnterView bEs;
    private b bEt;
    private View.OnClickListener bEu = new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.enter.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.ed(0);
            if (a.this.bEt != null) {
                a.this.bEt.Z(view);
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

    public void t(ab abVar) {
        this.aED = abVar;
    }

    public void RW() {
        if (this.bEs != null) {
            this.bEs.setEnterVisible(false);
        }
    }

    public View getEnterView() {
        if (this.aED == null) {
            return null;
        }
        if (this.bEs == null) {
            this.bEs = new LiveBCChatEnterView(this.mContext.getPageActivity());
            this.bEs.setOnClickListener(this.bEu);
            this.bEs.setEnterVisible(true);
        }
        if (this.isHost) {
            b(this.bEs);
        } else {
            a(this.bEs);
        }
        return this.bEs;
    }

    public void ed(int i) {
        if (this.bEs != null) {
            if (this.isHost) {
                if (i > 0) {
                    this.bEs.setRedDotVisible(true);
                    return;
                } else {
                    this.bEs.setRedDotVisible(false);
                    return;
                }
            }
            this.bEs.setRedDotVisible(false);
        }
    }

    public void ee(int i) {
        if (!this.isHost) {
            ef(i);
        }
    }

    private void ef(int i) {
        if (this.bEs != null) {
            if (i == d.bHi || i == d.bHh || i == d.bHj) {
                this.bEs.setEnterImageDrawable(a.e.liveshow_enter_connecting);
            } else if (i == d.bHk) {
                this.bEs.setEnterImageDrawable(a.e.liveshow_enter_connected);
            } else {
                this.bEs.setEnterImageDrawable(a.e.liveshow_enter_idle);
            }
        }
    }

    public void a(b bVar) {
        this.bEt = bVar;
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
