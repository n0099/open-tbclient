package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class PbThreadCommentAndPraiseInfoLayout extends ThreadCommentAndPraiseInfoLayout {
    private View.OnClickListener aEg;

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
        this.aAO.setDisPraiseFrom(7);
        this.aAP.setDisPraiseFrom(7);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void N(View view) {
        if (this.aEg != null) {
            this.aEg.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void O(View view) {
        if (this.aEg != null) {
            this.aEg.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void P(View view) {
        if (ba.bI(getContext())) {
            if (!com.baidu.adp.lib.util.l.lo()) {
                com.baidu.adp.lib.util.l.showToast(getContext(), e.j.no_network_guide);
            } else if (this.aAO != null) {
                this.aAO.L(view);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void Q(View view) {
        if (ba.bI(getContext())) {
            if (!com.baidu.adp.lib.util.l.lo()) {
                com.baidu.adp.lib.util.l.showToast(getContext(), e.j.no_network_guide);
            } else if (this.aAP != null) {
                this.aAP.L(view);
            }
        }
    }

    public void fX(String str) {
        if (this.aAQ != null && !TextUtils.isEmpty(str) && str.equals(this.aAQ.getTid())) {
            P(this.aAO);
        }
    }

    public void setPostId(String str) {
        if (this.aAO != null) {
            this.aAO.setPostId(str);
        }
        if (this.aAP != null) {
            this.aAP.setPostId(str);
        }
    }

    public void setOnClickOutListener(View.OnClickListener onClickListener) {
        this.aEg = onClickListener;
    }
}
