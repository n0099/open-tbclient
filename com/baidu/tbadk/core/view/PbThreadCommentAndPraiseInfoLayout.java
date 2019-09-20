package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class PbThreadCommentAndPraiseInfoLayout extends NewThreadCommentAndPraiseInfoLayout {
    private View.OnClickListener cbs;

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
    protected void aQ(View view) {
        if (this.cbs != null) {
            this.cbs.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aR(View view) {
        if (this.cbs != null) {
            this.cbs.onClick(view);
        }
    }

    public void pa(String str) {
        if (this.Wd != null && !TextUtils.isEmpty(str) && str.equals(this.Wd.getTid())) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.bFY = 4;
            dVar.bGa = 2;
            this.ccb.setStatisticData(dVar);
            this.ccb.aks();
        }
    }

    public void setPostId(String str) {
    }

    public void setOnClickOutListener(View.OnClickListener onClickListener) {
        this.cbs = onClickListener;
    }
}
