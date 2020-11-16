package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.view.ThreadForumEnterGoodsButton;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class ForumGoodsEnterLayout extends RelativeLayout {
    private com.baidu.tbadk.core.data.a afN;
    private int ahz;
    private View.OnClickListener ajX;
    private ThreadForumEnterGoodsButton akc;
    private int aki;
    private Context mContext;
    private int mFrom;

    public ForumGoodsEnterLayout(Context context) {
        super(context);
        this.ahz = 0;
        this.mFrom = 0;
        init(context);
    }

    public ForumGoodsEnterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahz = 0;
        this.mFrom = 0;
        init(context);
    }

    public ForumGoodsEnterLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ahz = 0;
        this.mFrom = 0;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.akc = (ThreadForumEnterGoodsButton) LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_goods_enter_item, (ViewGroup) this, true).findViewById(R.id.forum_enter_goods_button);
    }

    public void setData(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        this.afN = aVar;
        bx bjd = aVar.bjd();
        if (c(aVar) || d(aVar) || aVar.bjd() == null || !aVar.bjd().bnM() || this.aki == 3) {
            z = false;
        } else {
            this.akc.setVisibility(0);
            this.akc.setFrom(2);
            this.akc.r(bjd);
            this.akc.setAfterClickListener(this.ajX);
            z = true;
        }
        setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.akc.onChangeSkinType();
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setFrstype(int i) {
        this.aki = i;
    }

    public void setSourceForPb(int i) {
        this.ahz = i;
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.ajX = onClickListener;
    }

    private boolean c(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bjd() == null || aVar.bjd().bnJ() == null || aVar.bjd().bnJ().getOptions() == null || aVar.bjd().bnJ().getOptions().size() <= 0) ? false : true;
    }

    private boolean d(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bjd() == null || !aVar.bjd().bki() || aVar.bjd().blU() == null) ? false : true;
    }
}
