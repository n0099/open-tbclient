package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class PbThreadCommentAndPraiseInfoLayout extends NewThreadCommentAndPraiseInfoLayout {
    private View.OnClickListener cat;

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
        if (this.cat != null) {
            this.cat.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aR(View view) {
        if (this.cat != null) {
            this.cat.onClick(view);
        }
    }

    public void oS(String str) {
        if (this.We != null && !TextUtils.isEmpty(str) && str.equals(this.We.getTid())) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.bFz = 4;
            dVar.bFB = 2;
            this.cbb.setStatisticData(dVar);
            this.cbb.ake();
        }
    }

    public void setPostId(String str) {
    }

    public void setOnClickOutListener(View.OnClickListener onClickListener) {
        this.cat = onClickListener;
    }
}
