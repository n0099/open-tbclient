package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class PbThreadCommentAndPraiseInfoLayout extends NewThreadCommentAndPraiseInfoLayout {
    private View.OnClickListener bRw;

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
        if (this.bRw != null) {
            this.bRw.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aJ(View view) {
        if (this.bRw != null) {
            this.bRw.onClick(view);
        }
    }

    public void nr(String str) {
        if (this.XS != null && !TextUtils.isEmpty(str) && str.equals(this.XS.getTid())) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.bxj = 4;
            dVar.bxl = 2;
            this.bSd.setStatisticData(dVar);
            this.bSd.aee();
        }
    }

    public void setPostId(String str) {
    }

    public void setOnClickOutListener(View.OnClickListener onClickListener) {
        this.bRw = onClickListener;
    }
}
