package com.baidu.live.talentshow.components.enter;

import android.view.View;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.talentshow.d.d;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a {
    private w aDh;
    private LiveBCChatEnterView bua;
    private b bub;
    private View.OnClickListener buc = new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.enter.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.ff(0);
            if (a.this.bub != null) {
                a.this.bub.Z(view);
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
        this.aDh = wVar;
    }

    public void QB() {
        if (this.bua != null) {
            this.bua.setEnterVisible(false);
        }
    }

    public View getEnterView() {
        if (this.aDh == null) {
            return null;
        }
        if (this.bua == null) {
            this.bua = new LiveBCChatEnterView(this.mContext.getPageActivity());
            this.bua.setOnClickListener(this.buc);
            this.bua.setEnterVisible(true);
        }
        if (this.isHost) {
            b(this.bua);
        } else {
            a(this.bua);
        }
        return this.bua;
    }

    public void ff(int i) {
        if (this.bua != null) {
            if (this.isHost) {
                if (i > 0) {
                    this.bua.setRedDotVisible(true);
                    return;
                } else {
                    this.bua.setRedDotVisible(false);
                    return;
                }
            }
            this.bua.setRedDotVisible(false);
        }
    }

    public void fg(int i) {
        if (!this.isHost) {
            fh(i);
        }
    }

    private void fh(int i) {
        if (this.bua != null) {
            if (i == d.bwQ || i == d.bwP || i == d.bwR) {
                this.bua.setEnterImageDrawable(a.e.liveshow_enter_connecting);
            } else if (i == d.bwS) {
                this.bua.setEnterImageDrawable(a.e.liveshow_enter_connected);
            } else {
                this.bua.setEnterImageDrawable(a.e.liveshow_enter_idle);
            }
        }
    }

    public void a(b bVar) {
        this.bub = bVar;
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
