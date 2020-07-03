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
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class ForumEnterLayout extends RelativeLayout {
    private AbsThreadDataSupport aea;
    private int afJ;
    private ThreadForumEnterButton ahY;
    private TextView ahZ;
    private Drawable aia;
    private final int aib;
    private int aic;
    private View.OnClickListener aie;
    private Context mContext;
    private final int mMargin;
    private final View.OnClickListener mOnClickListener;

    public ForumEnterLayout(Context context) {
        super(context);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.aib = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.afJ = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.ahZ) {
                    aw.a(ForumEnterLayout.this.aea, view.getContext(), ForumEnterLayout.this.afJ, 2);
                } else if (view == ForumEnterLayout.this.ahY && ForumEnterLayout.this.aie != null) {
                    ForumEnterLayout.this.aie.onClick(view);
                }
                if (ForumEnterLayout.this.aea != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.aea.aPS());
                }
            }
        };
        init(context);
    }

    public ForumEnterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.aib = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.afJ = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.ahZ) {
                    aw.a(ForumEnterLayout.this.aea, view.getContext(), ForumEnterLayout.this.afJ, 2);
                } else if (view == ForumEnterLayout.this.ahY && ForumEnterLayout.this.aie != null) {
                    ForumEnterLayout.this.aie.onClick(view);
                }
                if (ForumEnterLayout.this.aea != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.aea.aPS());
                }
            }
        };
        init(context);
    }

    public ForumEnterLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.aib = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.afJ = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.ahZ) {
                    aw.a(ForumEnterLayout.this.aea, view.getContext(), ForumEnterLayout.this.afJ, 2);
                } else if (view == ForumEnterLayout.this.ahY && ForumEnterLayout.this.aie != null) {
                    ForumEnterLayout.this.aie.onClick(view);
                }
                if (ForumEnterLayout.this.aea != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.aea.aPS());
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_item, (ViewGroup) this, true);
        this.ahZ = (TextView) inflate.findViewById(R.id.text_post);
        this.ahZ.setCompoundDrawablePadding(l.getDimens(context, R.dimen.tbds10));
        this.ahY = (ThreadForumEnterButton) inflate.findViewById(R.id.forum_enter_button);
        this.ahY.setAfterClickListener(this.mOnClickListener);
        this.ahZ.setOnClickListener(this.mOnClickListener);
    }

    public void su() {
        int equipmentWidth = (l.getEquipmentWidth(this.mContext) - (this.mMargin * 2)) - this.aib;
        if (equipmentWidth > 0) {
            this.aic = equipmentWidth / 2;
        } else {
            this.aic = l.getDimens(this.mContext, R.dimen.tbds540);
        }
        this.ahZ.setMaxWidth(this.aic);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, bu buVar) {
        if (buVar != null) {
            int id = view.getId();
            String str = null;
            if (id == R.id.forum_enter_button) {
                str = "c13693";
            } else if (id == R.id.text_post) {
                str = "c13695";
            }
            int i = 0;
            switch (this.afJ) {
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
                TiebaStatic.log(com.baidu.tieba.s.a.a(str, buVar, i));
            }
        }
    }

    public void setData(AbsThreadDataSupport absThreadDataSupport) {
        boolean z;
        boolean z2 = true;
        this.aea = absThreadDataSupport;
        su();
        bu aPS = absThreadDataSupport.aPS();
        if ((absThreadDataSupport.aPY() || !aPS.dOy) && !StringUtils.isNull(aPS.aSt())) {
            this.ahY.setVisibility(0);
            this.ahY.a(aPS, this.aic);
            z = true;
        } else {
            this.ahY.setVisibility(8);
            z = false;
        }
        if (aw.v(aPS) && aPS.isPrivacy) {
            this.ahZ.setVisibility(0);
            this.ahZ.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds32));
            this.ahZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            an.setViewTextColor(this.ahZ, (int) R.color.cp_cont_d);
            this.ahZ.setText(R.string.private_desc);
            this.ahZ.setOnClickListener(null);
        } else if (absThreadDataSupport.aQa()) {
            if (!StringUtils.isNull(aPS.aUr())) {
                this.ahZ.setVisibility(0);
                this.ahZ.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds34));
                this.ahZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, getArrowRight(), (Drawable) null);
                this.ahZ.setTextColor(an.lt(R.color.cp_cont_j));
                this.ahZ.setText(aPS.aUr());
                this.ahZ.setOnClickListener(this.mOnClickListener);
            } else {
                this.ahZ.setVisibility(8);
                z2 = z;
            }
        } else {
            this.ahZ.setVisibility(8);
            z2 = z;
        }
        setVisibility(z2 ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ahY.onChangeSkinType();
        this.aia = getArrowRight();
    }

    private Drawable getArrowRight() {
        if (this.aia == null || this.aia.mutate() == null) {
            this.aia = SvgManager.aWQ().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        return this.aia;
    }

    public void setSourceForPb(int i) {
        this.afJ = i;
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.aie = onClickListener;
    }
}
