package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class PbThreadCommentAndPraiseInfoLayout extends NewThreadCommentAndPraiseInfoLayout {
    private View.OnClickListener bRv;

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
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aI(View view) {
        if (this.bRv != null) {
            this.bRv.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aJ(View view) {
        if (this.bRv != null) {
            this.bRv.onClick(view);
        }
    }

    public void nr(String str) {
        if (this.XR != null && !TextUtils.isEmpty(str) && str.equals(this.XR.getTid())) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.bxh = 4;
            dVar.bxj = 2;
            this.bSc.setStatisticData(dVar);
            this.bSc.aee();
        }
    }

    public void setPostId(String str) {
    }

    public void setOnClickOutListener(View.OnClickListener onClickListener) {
        this.bRv = onClickListener;
    }
}
