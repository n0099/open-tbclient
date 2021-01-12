package com.baidu.live.talentshow.components.enter;

import android.view.View;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.talentshow.d.d;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class a {
    private x aBr;
    private LiveBCChatEnterView bzm;
    private b bzn;
    private View.OnClickListener bzo = new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.enter.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dY(0);
            if (a.this.bzn != null) {
                a.this.bzn.Z(view);
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

    public void t(x xVar) {
        this.aBr = xVar;
    }

    public void Qj() {
        if (this.bzm != null) {
            this.bzm.setEnterVisible(false);
        }
    }

    public View getEnterView() {
        if (this.aBr == null) {
            return null;
        }
        if (this.bzm == null) {
            this.bzm = new LiveBCChatEnterView(this.mContext.getPageActivity());
            this.bzm.setOnClickListener(this.bzo);
            this.bzm.setEnterVisible(true);
        }
        if (this.isHost) {
            b(this.bzm);
        } else {
            a(this.bzm);
        }
        return this.bzm;
    }

    public void dY(int i) {
        if (this.bzm != null) {
            if (this.isHost) {
                if (i > 0) {
                    this.bzm.setRedDotVisible(true);
                    return;
                } else {
                    this.bzm.setRedDotVisible(false);
                    return;
                }
            }
            this.bzm.setRedDotVisible(false);
        }
    }

    public void dZ(int i) {
        if (!this.isHost) {
            ea(i);
        }
    }

    private void ea(int i) {
        if (this.bzm != null) {
            if (i == d.bBZ || i == d.bBY || i == d.bCa) {
                this.bzm.setEnterImageDrawable(a.e.liveshow_enter_connecting);
            } else if (i == d.bCb) {
                this.bzm.setEnterImageDrawable(a.e.liveshow_enter_connected);
            } else {
                this.bzm.setEnterImageDrawable(a.e.liveshow_enter_idle);
            }
        }
    }

    public void a(b bVar) {
        this.bzn = bVar;
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
