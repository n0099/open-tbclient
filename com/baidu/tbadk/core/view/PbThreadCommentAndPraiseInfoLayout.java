package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class PbThreadCommentAndPraiseInfoLayout extends ThreadCommentAndPraiseInfoLayout {
    private View.OnClickListener aEW;

    public PbThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        init();
    }

    public PbThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void init() {
        setReplyTimeVisible(false);
        setIsBarViewVisible(false);
        setManageVisible(false);
        setInFrsAllThread(false);
        setShowPraiseNum(true);
        setNeedAddPraiseIcon(true);
        setNeedAddReplyIcon(true);
        setShareVisible(true);
        this.aBD.setDisPraiseFrom(7);
        this.aBE.setDisPraiseFrom(7);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void N(View view) {
        if (this.aEW != null) {
            this.aEW.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void O(View view) {
        if (this.aEW != null) {
            this.aEW.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void P(View view) {
        if (ba.bG(getContext())) {
            if (!com.baidu.adp.lib.util.l.lm()) {
                com.baidu.adp.lib.util.l.showToast(getContext(), e.j.no_network_guide);
            } else if (this.aBD != null) {
                this.aBD.L(view);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void Q(View view) {
        if (ba.bG(getContext())) {
            if (!com.baidu.adp.lib.util.l.lm()) {
                com.baidu.adp.lib.util.l.showToast(getContext(), e.j.no_network_guide);
            } else if (this.aBE != null) {
                this.aBE.L(view);
            }
        }
    }

    public void fY(String str) {
        if (this.aBF != null && !TextUtils.isEmpty(str) && str.equals(this.aBF.getTid())) {
            P(this.aBD);
        }
    }

    public void setPostId(String str) {
        if (this.aBD != null) {
            this.aBD.setPostId(str);
        }
        if (this.aBE != null) {
            this.aBE.setPostId(str);
        }
    }

    public void setOnClickOutListener(View.OnClickListener onClickListener) {
        this.aEW = onClickListener;
    }
}
