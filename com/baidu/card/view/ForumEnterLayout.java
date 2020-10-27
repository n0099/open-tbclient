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
    private AbsThreadDataSupport afI;
    private int ahx;
    private View.OnClickListener ajU;
    private ThreadForumEnterButton ajY;
    private ThreadForumEnterGoodsButton ajZ;
    private TextView aka;
    private Drawable akb;
    private final int akc;
    private int akd;
    private Context mContext;
    private final int mMargin;
    private final View.OnClickListener mOnClickListener;

    public ForumEnterLayout(Context context) {
        super(context);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.akc = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.ahx = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.aka) {
                    ay.a(ForumEnterLayout.this.afI, view.getContext(), ForumEnterLayout.this.ahx, 2);
                } else if (view == ForumEnterLayout.this.ajY && ForumEnterLayout.this.ajU != null) {
                    ForumEnterLayout.this.ajU.onClick(view);
                }
                if (ForumEnterLayout.this.afI != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.afI.bhz());
                }
            }
        };
        init(context);
    }

    public ForumEnterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.akc = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.ahx = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.aka) {
                    ay.a(ForumEnterLayout.this.afI, view.getContext(), ForumEnterLayout.this.ahx, 2);
                } else if (view == ForumEnterLayout.this.ajY && ForumEnterLayout.this.ajU != null) {
                    ForumEnterLayout.this.ajU.onClick(view);
                }
                if (ForumEnterLayout.this.afI != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.afI.bhz());
                }
            }
        };
        init(context);
    }

    public ForumEnterLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.akc = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.ahx = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.aka) {
                    ay.a(ForumEnterLayout.this.afI, view.getContext(), ForumEnterLayout.this.ahx, 2);
                } else if (view == ForumEnterLayout.this.ajY && ForumEnterLayout.this.ajU != null) {
                    ForumEnterLayout.this.ajU.onClick(view);
                }
                if (ForumEnterLayout.this.afI != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.afI.bhz());
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_item, (ViewGroup) this, true);
        this.aka = (TextView) inflate.findViewById(R.id.text_post);
        this.aka.setCompoundDrawablePadding(l.getDimens(context, R.dimen.tbds10));
        this.ajY = (ThreadForumEnterButton) inflate.findViewById(R.id.forum_enter_button);
        this.ajZ = (ThreadForumEnterGoodsButton) inflate.findViewById(R.id.forum_enter_goods_button);
        this.ajY.setAfterClickListener(this.mOnClickListener);
        this.ajZ.setAfterClickListener(this.mOnClickListener);
        this.aka.setOnClickListener(this.mOnClickListener);
    }

    public void up() {
        int equipmentWidth = (l.getEquipmentWidth(this.mContext) - (this.mMargin * 2)) - this.akc;
        if (equipmentWidth > 0) {
            this.akd = equipmentWidth / 2;
        } else {
            this.akd = l.getDimens(this.mContext, R.dimen.tbds540);
        }
        this.aka.setMaxWidth(this.akd);
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
            switch (this.ahx) {
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
        this.afI = absThreadDataSupport;
        up();
        bw bhz = absThreadDataSupport.bhz();
        if ((absThreadDataSupport.bhF() || !bhz.eAZ) && !StringUtils.isNull(bhz.bke()) && !c(bhz)) {
            this.ajY.setVisibility(0);
            this.ajY.a(bhz, this.akd);
            z = true;
        } else {
            this.ajY.setVisibility(8);
            z = false;
        }
        if (!c(absThreadDataSupport) && !d(absThreadDataSupport) && absThreadDataSupport.bhG() && absThreadDataSupport.bhz().bmi()) {
            this.ajZ.setVisibility(0);
            this.ajZ.r(bhz);
            z = true;
        } else {
            this.ajZ.setVisibility(8);
        }
        if (ay.x(bhz) && bhz.isPrivacy) {
            this.aka.setVisibility(0);
            this.aka.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds32));
            this.aka.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.aka, R.color.cp_cont_d);
            this.aka.setText(R.string.private_desc);
            this.aka.setOnClickListener(null);
        } else {
            this.aka.setVisibility(8);
            z2 = z;
        }
        setVisibility(z2 ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ajY.onChangeSkinType();
        this.ajZ.onChangeSkinType();
        this.akb = getArrowRight();
    }

    private Drawable getArrowRight() {
        if (this.akb == null || this.akb.mutate() == null) {
            this.akb = SvgManager.boN().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        return this.akb;
    }

    public void setSourceForPb(int i) {
        this.ahx = i;
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.ajU = onClickListener;
    }

    private boolean c(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.bhz() == null || absThreadDataSupport.bhz().bmf() == null || absThreadDataSupport.bhz().bmf().getOptions() == null || absThreadDataSupport.bhz().bmf().getOptions().size() <= 0) ? false : true;
    }

    private boolean c(bw bwVar) {
        return (bwVar == null || bwVar.bka() == null || !bwVar.eBa || !d.bfD() || bwVar.bka().hadConcerned() || ay.x(bwVar)) ? false : true;
    }

    private boolean d(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.bhz() == null || !absThreadDataSupport.bhz().biG() || absThreadDataSupport.bhz().bks() == null) ? false : true;
    }
}
