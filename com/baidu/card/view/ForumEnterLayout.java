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
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tbadk.core.view.ThreadForumEnterGoodsButton;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class ForumEnterLayout extends RelativeLayout {
    private AbsThreadDataSupport afH;
    private int ahw;
    private View.OnClickListener ajT;
    private ThreadForumEnterButton ajX;
    private ThreadForumEnterGoodsButton ajY;
    private TextView ajZ;
    private Drawable aka;
    private final int akb;
    private int akc;
    private Context mContext;
    private final int mMargin;
    private final View.OnClickListener mOnClickListener;

    public ForumEnterLayout(Context context) {
        super(context);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.akb = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.ahw = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.ajZ) {
                    ay.a(ForumEnterLayout.this.afH, view.getContext(), ForumEnterLayout.this.ahw, 2);
                } else if (view == ForumEnterLayout.this.ajX && ForumEnterLayout.this.ajT != null) {
                    ForumEnterLayout.this.ajT.onClick(view);
                }
                if (ForumEnterLayout.this.afH != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.afH.bfG());
                }
            }
        };
        init(context);
    }

    public ForumEnterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.akb = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.ahw = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.ajZ) {
                    ay.a(ForumEnterLayout.this.afH, view.getContext(), ForumEnterLayout.this.ahw, 2);
                } else if (view == ForumEnterLayout.this.ajX && ForumEnterLayout.this.ajT != null) {
                    ForumEnterLayout.this.ajT.onClick(view);
                }
                if (ForumEnterLayout.this.afH != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.afH.bfG());
                }
            }
        };
        init(context);
    }

    public ForumEnterLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.akb = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.ahw = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.ajZ) {
                    ay.a(ForumEnterLayout.this.afH, view.getContext(), ForumEnterLayout.this.ahw, 2);
                } else if (view == ForumEnterLayout.this.ajX && ForumEnterLayout.this.ajT != null) {
                    ForumEnterLayout.this.ajT.onClick(view);
                }
                if (ForumEnterLayout.this.afH != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.afH.bfG());
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_item, (ViewGroup) this, true);
        this.ajZ = (TextView) inflate.findViewById(R.id.text_post);
        this.ajZ.setCompoundDrawablePadding(l.getDimens(context, R.dimen.tbds10));
        this.ajX = (ThreadForumEnterButton) inflate.findViewById(R.id.forum_enter_button);
        this.ajY = (ThreadForumEnterGoodsButton) inflate.findViewById(R.id.forum_enter_goods_button);
        this.ajX.setAfterClickListener(this.mOnClickListener);
        this.ajY.setAfterClickListener(this.mOnClickListener);
        this.ajZ.setOnClickListener(this.mOnClickListener);
    }

    public void up() {
        int equipmentWidth = (l.getEquipmentWidth(this.mContext) - (this.mMargin * 2)) - this.akb;
        if (equipmentWidth > 0) {
            this.akc = equipmentWidth / 2;
        } else {
            this.akc = l.getDimens(this.mContext, R.dimen.tbds540);
        }
        this.ajZ.setMaxWidth(this.akc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, bw bwVar) {
        if (bwVar != null) {
            int id = view.getId();
            String str = null;
            if (id == R.id.forum_enter_button) {
                str = "c13693";
            } else if (id == R.id.text_post) {
                str = "c13695";
            }
            int i = 0;
            switch (this.ahw) {
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
                TiebaStatic.log(com.baidu.tieba.s.a.a(str, bwVar, i));
            }
        }
    }

    public void setData(AbsThreadDataSupport absThreadDataSupport) {
        boolean z;
        boolean z2 = true;
        this.afH = absThreadDataSupport;
        up();
        bw bfG = absThreadDataSupport.bfG();
        if ((absThreadDataSupport.bfM() || !bfG.esz) && !StringUtils.isNull(bfG.bil()) && !c(bfG)) {
            this.ajX.setVisibility(0);
            this.ajX.a(bfG, this.akc);
            z = true;
        } else {
            this.ajX.setVisibility(8);
            z = false;
        }
        if (!c(absThreadDataSupport) && !d(absThreadDataSupport) && absThreadDataSupport.bfN() && absThreadDataSupport.bfG().bkp()) {
            this.ajY.setVisibility(0);
            this.ajY.r(bfG);
            z = true;
        } else {
            this.ajY.setVisibility(8);
        }
        if (ay.x(bfG) && bfG.isPrivacy) {
            this.ajZ.setVisibility(0);
            this.ajZ.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds32));
            this.ajZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.ajZ, R.color.cp_cont_d);
            this.ajZ.setText(R.string.private_desc);
            this.ajZ.setOnClickListener(null);
        } else {
            this.ajZ.setVisibility(8);
            z2 = z;
        }
        setVisibility(z2 ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ajX.onChangeSkinType();
        this.ajY.onChangeSkinType();
        this.aka = getArrowRight();
    }

    private Drawable getArrowRight() {
        if (this.aka == null || this.aka.mutate() == null) {
            this.aka = SvgManager.bmU().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        return this.aka;
    }

    public void setSourceForPb(int i) {
        this.ahw = i;
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.ajT = onClickListener;
    }

    private boolean c(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.bfG() == null || absThreadDataSupport.bfG().bkm() == null || absThreadDataSupport.bfG().bkm().getOptions() == null || absThreadDataSupport.bfG().bkm().getOptions().size() <= 0) ? false : true;
    }

    private boolean c(bw bwVar) {
        return (bwVar == null || bwVar.bih() == null || !bwVar.esA || !d.bdK() || bwVar.bih().hadConcerned() || ay.x(bwVar)) ? false : true;
    }

    private boolean d(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.bfG() == null || !absThreadDataSupport.bfG().bgN() || absThreadDataSupport.bfG().biz() == null) ? false : true;
    }
}
