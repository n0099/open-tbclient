package com.baidu.live.talentshow.components.enter;

import android.view.View;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.talentshow.d.d;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class a {
    private x aGe;
    private LiveBCChatEnterView bDY;
    private b bDZ;
    private View.OnClickListener bEa = new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.enter.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.fE(0);
            if (a.this.bDZ != null) {
                a.this.bDZ.Z(view);
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
        this.aGe = xVar;
    }

    public void Ue() {
        if (this.bDY != null) {
            this.bDY.setEnterVisible(false);
        }
    }

    public View getEnterView() {
        if (this.aGe == null) {
            return null;
        }
        if (this.bDY == null) {
            this.bDY = new LiveBCChatEnterView(this.mContext.getPageActivity());
            this.bDY.setOnClickListener(this.bEa);
            this.bDY.setEnterVisible(true);
        }
        if (this.isHost) {
            b(this.bDY);
        } else {
            a(this.bDY);
        }
        return this.bDY;
    }

    public void fE(int i) {
        if (this.bDY != null) {
            if (this.isHost) {
                if (i > 0) {
                    this.bDY.setRedDotVisible(true);
                    return;
                } else {
                    this.bDY.setRedDotVisible(false);
                    return;
                }
            }
            this.bDY.setRedDotVisible(false);
        }
    }

    public void fF(int i) {
        if (!this.isHost) {
            fG(i);
        }
    }

    private void fG(int i) {
        if (this.bDY != null) {
            if (i == d.bGL || i == d.bGK || i == d.bGM) {
                this.bDY.setEnterImageDrawable(a.e.liveshow_enter_connecting);
            } else if (i == d.bGN) {
                this.bDY.setEnterImageDrawable(a.e.liveshow_enter_connected);
            } else {
                this.bDY.setEnterImageDrawable(a.e.liveshow_enter_idle);
            }
        }
    }

    public void a(b bVar) {
        this.bDZ = bVar;
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
