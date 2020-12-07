package com.baidu.live.talentshow.components.enter;

import android.view.View;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.talentshow.d.d;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a {
    private w aFN;
    private LiveBCChatEnterView bzl;
    private b bzm;
    private View.OnClickListener bzn = new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.enter.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.fD(0);
            if (a.this.bzm != null) {
                a.this.bzm.Z(view);
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
        this.aFN = wVar;
    }

    public void SZ() {
        if (this.bzl != null) {
            this.bzl.setEnterVisible(false);
        }
    }

    public View getEnterView() {
        if (this.aFN == null) {
            return null;
        }
        if (this.bzl == null) {
            this.bzl = new LiveBCChatEnterView(this.mContext.getPageActivity());
            this.bzl.setOnClickListener(this.bzn);
            this.bzl.setEnterVisible(true);
        }
        if (this.isHost) {
            b(this.bzl);
        } else {
            a(this.bzl);
        }
        return this.bzl;
    }

    public void fD(int i) {
        if (this.bzl != null) {
            if (this.isHost) {
                if (i > 0) {
                    this.bzl.setRedDotVisible(true);
                    return;
                } else {
                    this.bzl.setRedDotVisible(false);
                    return;
                }
            }
            this.bzl.setRedDotVisible(false);
        }
    }

    public void fE(int i) {
        if (!this.isHost) {
            fF(i);
        }
    }

    private void fF(int i) {
        if (this.bzl != null) {
            if (i == d.bBY || i == d.bBX || i == d.bBZ) {
                this.bzl.setEnterImageDrawable(a.e.liveshow_enter_connecting);
            } else if (i == d.bCa) {
                this.bzl.setEnterImageDrawable(a.e.liveshow_enter_connected);
            } else {
                this.bzl.setEnterImageDrawable(a.e.liveshow_enter_idle);
            }
        }
    }

    public void a(b bVar) {
        this.bzm = bVar;
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
