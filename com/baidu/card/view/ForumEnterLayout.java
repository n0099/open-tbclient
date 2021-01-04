package com.baidu.card.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tbadk.core.view.ThreadForumEnterGoodsButton;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ForumEnterLayout extends RelativeLayout {
    private com.baidu.tbadk.core.data.a ahi;
    private int ajl;
    private View.OnClickListener alA;
    private ThreadForumEnterButton alE;
    private ThreadForumEnterGoodsButton alF;
    private TextView alG;
    private Drawable alH;
    private final int alI;
    private int alJ;
    private Context mContext;
    private final int mMargin;
    private final View.OnClickListener mOnClickListener;

    public ForumEnterLayout(Context context) {
        super(context);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.alI = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.ajl = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.alG) {
                    ay.a(ForumEnterLayout.this.ahi, view.getContext(), ForumEnterLayout.this.ajl, 2);
                } else if (view == ForumEnterLayout.this.alE && ForumEnterLayout.this.alA != null) {
                    ForumEnterLayout.this.alA.onClick(view);
                }
                if (ForumEnterLayout.this.ahi != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.ahi.boO());
                }
            }
        };
        init(context);
    }

    public ForumEnterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.alI = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.ajl = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.alG) {
                    ay.a(ForumEnterLayout.this.ahi, view.getContext(), ForumEnterLayout.this.ajl, 2);
                } else if (view == ForumEnterLayout.this.alE && ForumEnterLayout.this.alA != null) {
                    ForumEnterLayout.this.alA.onClick(view);
                }
                if (ForumEnterLayout.this.ahi != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.ahi.boO());
                }
            }
        };
        init(context);
    }

    public ForumEnterLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.alI = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.ajl = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.alG) {
                    ay.a(ForumEnterLayout.this.ahi, view.getContext(), ForumEnterLayout.this.ajl, 2);
                } else if (view == ForumEnterLayout.this.alE && ForumEnterLayout.this.alA != null) {
                    ForumEnterLayout.this.alA.onClick(view);
                }
                if (ForumEnterLayout.this.ahi != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.ahi.boO());
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_item, (ViewGroup) this, true);
        this.alG = (TextView) inflate.findViewById(R.id.text_post);
        this.alG.setCompoundDrawablePadding(l.getDimens(context, R.dimen.tbds10));
        this.alE = (ThreadForumEnterButton) inflate.findViewById(R.id.forum_enter_button);
        this.alF = (ThreadForumEnterGoodsButton) inflate.findViewById(R.id.forum_enter_goods_button);
        this.alE.setAfterClickListener(this.mOnClickListener);
        this.alF.setAfterClickListener(this.mOnClickListener);
        this.alG.setOnClickListener(this.mOnClickListener);
    }

    public void tQ() {
        int equipmentWidth = (l.getEquipmentWidth(this.mContext) - (this.mMargin * 2)) - this.alI;
        if (equipmentWidth > 0) {
            this.alJ = equipmentWidth / 2;
        } else {
            this.alJ = l.getDimens(this.mContext, R.dimen.tbds540);
        }
        this.alG.setMaxWidth(this.alJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, bz bzVar) {
        if (bzVar != null) {
            int id = view.getId();
            String str = null;
            if (id == R.id.forum_enter_button) {
                str = "c13693";
            } else if (id == R.id.text_post) {
                str = "c13695";
            }
            int i = 0;
            switch (this.ajl) {
                case 1:
                    i = 2;
                    break;
                case 2:
                    i = 1;
                    break;
                case 4:
                    i = 3;
                    break;
            }
            if (str != null && i > 0) {
                TiebaStatic.log(com.baidu.tieba.s.a.a(str, bzVar, i));
            }
        }
    }

    public void setData(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        boolean z2 = true;
        this.ahi = aVar;
        tQ();
        bz boO = aVar.boO();
        if ((aVar.boS() || !boO.eWd) && !StringUtils.isNull(boO.bru()) && !c(boO)) {
            this.alE.setVisibility(0);
            this.alE.a(boO, this.alJ);
            z = true;
        } else {
            this.alE.setVisibility(8);
            z = false;
        }
        if (!c(aVar) && !d(aVar) && aVar.boT() && aVar.boO().btC()) {
            this.alF.setVisibility(0);
            this.alF.r(boO);
            z = true;
        } else {
            this.alF.setVisibility(8);
        }
        if (ay.x(boO) && boO.isPrivacy) {
            this.alG.setVisibility(0);
            this.alG.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds32));
            this.alG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ao.setViewTextColor(this.alG, R.color.CAM_X0109);
            this.alG.setText(R.string.private_desc);
            this.alG.setOnClickListener(null);
        } else {
            this.alG.setVisibility(8);
            z2 = z;
        }
        setVisibility(z2 ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.alE.onChangeSkinType();
        this.alF.onChangeSkinType();
        this.alH = getArrowRight();
    }

    private Drawable getArrowRight() {
        if (this.alH == null || this.alH.mutate() == null) {
            WebPManager.a(R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        return this.alH;
    }

    public void setSourceForPb(int i) {
        this.ajl = i;
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.alA = onClickListener;
    }

    private boolean c(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.boO() == null || aVar.boO().btz() == null || aVar.boO().btz().getOptions() == null || aVar.boO().btz().getOptions().size() <= 0) ? false : true;
    }

    private boolean c(bz bzVar) {
        return (bzVar == null || bzVar.brq() == null || !bzVar.eWe || !d.bmN() || bzVar.brq().hadConcerned() || ay.x(bzVar)) ? false : true;
    }

    private boolean d(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.boO() == null || !aVar.boO().bpV() || aVar.boO().brH() == null) ? false : true;
    }
}
