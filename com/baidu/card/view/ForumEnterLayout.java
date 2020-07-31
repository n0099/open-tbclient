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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class ForumEnterLayout extends RelativeLayout {
    private AbsThreadDataSupport adQ;
    private int afA;
    private ThreadForumEnterButton ahQ;
    private TextView ahR;
    private Drawable ahS;
    private final int ahT;
    private int ahU;
    private View.OnClickListener ahV;
    private Context mContext;
    private final int mMargin;
    private final View.OnClickListener mOnClickListener;

    public ForumEnterLayout(Context context) {
        super(context);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.ahT = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.afA = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.ahR) {
                    ax.a(ForumEnterLayout.this.adQ, view.getContext(), ForumEnterLayout.this.afA, 2);
                } else if (view == ForumEnterLayout.this.ahQ && ForumEnterLayout.this.ahV != null) {
                    ForumEnterLayout.this.ahV.onClick(view);
                }
                if (ForumEnterLayout.this.adQ != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.adQ.aTN());
                }
            }
        };
        init(context);
    }

    public ForumEnterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.ahT = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.afA = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.ahR) {
                    ax.a(ForumEnterLayout.this.adQ, view.getContext(), ForumEnterLayout.this.afA, 2);
                } else if (view == ForumEnterLayout.this.ahQ && ForumEnterLayout.this.ahV != null) {
                    ForumEnterLayout.this.ahV.onClick(view);
                }
                if (ForumEnterLayout.this.adQ != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.adQ.aTN());
                }
            }
        };
        init(context);
    }

    public ForumEnterLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.ahT = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.afA = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.ahR) {
                    ax.a(ForumEnterLayout.this.adQ, view.getContext(), ForumEnterLayout.this.afA, 2);
                } else if (view == ForumEnterLayout.this.ahQ && ForumEnterLayout.this.ahV != null) {
                    ForumEnterLayout.this.ahV.onClick(view);
                }
                if (ForumEnterLayout.this.adQ != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.adQ.aTN());
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_item, (ViewGroup) this, true);
        this.ahR = (TextView) inflate.findViewById(R.id.text_post);
        this.ahR.setCompoundDrawablePadding(l.getDimens(context, R.dimen.tbds10));
        this.ahQ = (ThreadForumEnterButton) inflate.findViewById(R.id.forum_enter_button);
        this.ahQ.setAfterClickListener(this.mOnClickListener);
        this.ahR.setOnClickListener(this.mOnClickListener);
    }

    public void sw() {
        int equipmentWidth = (l.getEquipmentWidth(this.mContext) - (this.mMargin * 2)) - this.ahT;
        if (equipmentWidth > 0) {
            this.ahU = equipmentWidth / 2;
        } else {
            this.ahU = l.getDimens(this.mContext, R.dimen.tbds540);
        }
        this.ahR.setMaxWidth(this.ahU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, bv bvVar) {
        if (bvVar != null) {
            int id = view.getId();
            String str = null;
            if (id == R.id.forum_enter_button) {
                str = "c13693";
            } else if (id == R.id.text_post) {
                str = "c13695";
            }
            int i = 0;
            switch (this.afA) {
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
                TiebaStatic.log(com.baidu.tieba.s.a.a(str, bvVar, i));
            }
        }
    }

    public void setData(AbsThreadDataSupport absThreadDataSupport) {
        boolean z;
        boolean z2 = true;
        this.adQ = absThreadDataSupport;
        sw();
        bv aTN = absThreadDataSupport.aTN();
        if ((absThreadDataSupport.aTT() || !aTN.dUJ) && !StringUtils.isNull(aTN.aWp())) {
            this.ahQ.setVisibility(0);
            this.ahQ.a(aTN, this.ahU);
            z = true;
        } else {
            this.ahQ.setVisibility(8);
            z = false;
        }
        if (ax.w(aTN) && aTN.isPrivacy) {
            this.ahR.setVisibility(0);
            this.ahR.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds32));
            this.ahR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ao.setViewTextColor(this.ahR, R.color.cp_cont_d);
            this.ahR.setText(R.string.private_desc);
            this.ahR.setOnClickListener(null);
        } else {
            this.ahR.setVisibility(8);
            z2 = z;
        }
        setVisibility(z2 ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ahQ.onChangeSkinType();
        this.ahS = getArrowRight();
    }

    private Drawable getArrowRight() {
        if (this.ahS == null || this.ahS.mutate() == null) {
            this.ahS = SvgManager.baR().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        return this.ahS;
    }

    public void setSourceForPb(int i) {
        this.afA = i;
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.ahV = onClickListener;
    }
}
