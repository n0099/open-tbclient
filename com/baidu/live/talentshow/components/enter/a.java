package com.baidu.live.talentshow.components.enter;

import android.view.View;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.talentshow.d.d;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class a {
    private ab aDd;
    private LiveBCChatEnterView bCS;
    private b bCT;
    private View.OnClickListener bCU = new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.enter.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.ec(0);
            if (a.this.bCT != null) {
                a.this.bCT.Z(view);
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
        this.aDd = abVar;
    }

    public void RT() {
        if (this.bCS != null) {
            this.bCS.setEnterVisible(false);
        }
    }

    public View getEnterView() {
        if (this.aDd == null) {
            return null;
        }
        if (this.bCS == null) {
            this.bCS = new LiveBCChatEnterView(this.mContext.getPageActivity());
            this.bCS.setOnClickListener(this.bCU);
            this.bCS.setEnterVisible(true);
        }
        if (this.isHost) {
            b(this.bCS);
        } else {
            a(this.bCS);
        }
        return this.bCS;
    }

    public void ec(int i) {
        if (this.bCS != null) {
            if (this.isHost) {
                if (i > 0) {
                    this.bCS.setRedDotVisible(true);
                    return;
                } else {
                    this.bCS.setRedDotVisible(false);
                    return;
                }
            }
            this.bCS.setRedDotVisible(false);
        }
    }

    public void ed(int i) {
        if (!this.isHost) {
            ee(i);
        }
    }

    private void ee(int i) {
        if (this.bCS != null) {
            if (i == d.bFI || i == d.bFH || i == d.bFJ) {
                this.bCS.setEnterImageDrawable(a.e.liveshow_enter_connecting);
            } else if (i == d.bFK) {
                this.bCS.setEnterImageDrawable(a.e.liveshow_enter_connected);
            } else {
                this.bCS.setEnterImageDrawable(a.e.liveshow_enter_idle);
            }
        }
    }

    public void a(b bVar) {
        this.bCT = bVar;
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
