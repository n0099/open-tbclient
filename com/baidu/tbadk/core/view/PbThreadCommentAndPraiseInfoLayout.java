package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class PbThreadCommentAndPraiseInfoLayout extends ThreadCommentAndPraiseInfoLayout {
    private View.OnClickListener aJa;

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
        this.aFH.setDisPraiseFrom(7);
        this.aFI.setDisPraiseFrom(7);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void N(View view) {
        if (this.aJa != null) {
            this.aJa.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void O(View view) {
        if (this.aJa != null) {
            this.aJa.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void P(View view) {
        if (ba.bJ(getContext())) {
            if (!com.baidu.adp.lib.util.l.ll()) {
                com.baidu.adp.lib.util.l.showToast(getContext(), e.j.no_network_guide);
            } else if (this.aFH != null) {
                this.aFH.L(view);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void Q(View view) {
        if (ba.bJ(getContext())) {
            if (!com.baidu.adp.lib.util.l.ll()) {
                com.baidu.adp.lib.util.l.showToast(getContext(), e.j.no_network_guide);
            } else if (this.aFI != null) {
                this.aFI.L(view);
            }
        }
    }

    public void gF(String str) {
        if (this.aFJ != null && !TextUtils.isEmpty(str) && str.equals(this.aFJ.getTid())) {
            P(this.aFH);
        }
    }

    public void setPostId(String str) {
        if (this.aFH != null) {
            this.aFH.setPostId(str);
        }
        if (this.aFI != null) {
            this.aFI.setPostId(str);
        }
    }

    public void setOnClickOutListener(View.OnClickListener onClickListener) {
        this.aJa = onClickListener;
    }
}
