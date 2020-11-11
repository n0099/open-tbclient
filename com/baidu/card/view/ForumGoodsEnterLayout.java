package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.view.ThreadForumEnterGoodsButton;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class ForumGoodsEnterLayout extends RelativeLayout {
    private AbsThreadDataSupport afI;
    private int ahx;
    private View.OnClickListener ajU;
    private ThreadForumEnterGoodsButton ajZ;
    private int akf;
    private Context mContext;
    private int mFrom;

    public ForumGoodsEnterLayout(Context context) {
        super(context);
        this.ahx = 0;
        this.mFrom = 0;
        init(context);
    }

    public ForumGoodsEnterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahx = 0;
        this.mFrom = 0;
        init(context);
    }

    public ForumGoodsEnterLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ahx = 0;
        this.mFrom = 0;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.ajZ = (ThreadForumEnterGoodsButton) LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_goods_enter_item, (ViewGroup) this, true).findViewById(R.id.forum_enter_goods_button);
    }

    public void setData(AbsThreadDataSupport absThreadDataSupport) {
        boolean z;
        this.afI = absThreadDataSupport;
        bw bjZ = absThreadDataSupport.bjZ();
        if (c(absThreadDataSupport) || d(absThreadDataSupport) || absThreadDataSupport.bjZ() == null || !absThreadDataSupport.bjZ().boI() || this.akf == 3) {
            z = false;
        } else {
            this.ajZ.setVisibility(0);
            this.ajZ.setFrom(2);
            this.ajZ.r(bjZ);
            this.ajZ.setAfterClickListener(this.ajU);
            z = true;
        }
        setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ajZ.onChangeSkinType();
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setFrstype(int i) {
        this.akf = i;
    }

    public void setSourceForPb(int i) {
        this.ahx = i;
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.ajU = onClickListener;
    }

    private boolean c(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.bjZ() == null || absThreadDataSupport.bjZ().boF() == null || absThreadDataSupport.bjZ().boF().getOptions() == null || absThreadDataSupport.bjZ().boF().getOptions().size() <= 0) ? false : true;
    }

    private boolean d(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.bjZ() == null || !absThreadDataSupport.bjZ().blg() || absThreadDataSupport.bjZ().bmS() == null) ? false : true;
    }
}
