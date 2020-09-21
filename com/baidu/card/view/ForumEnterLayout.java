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
/* loaded from: classes20.dex */
public class ForumEnterLayout extends RelativeLayout {
    private AbsThreadDataSupport afq;
    private int ahf;
    private View.OnClickListener ajB;
    private ThreadForumEnterButton ajF;
    private ThreadForumEnterGoodsButton ajG;
    private TextView ajH;
    private Drawable ajI;
    private final int ajJ;
    private int ajK;
    private Context mContext;
    private final int mMargin;
    private final View.OnClickListener mOnClickListener;

    public ForumEnterLayout(Context context) {
        super(context);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.ajJ = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.ahf = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.ajH) {
                    ay.a(ForumEnterLayout.this.afq, view.getContext(), ForumEnterLayout.this.ahf, 2);
                } else if (view == ForumEnterLayout.this.ajF && ForumEnterLayout.this.ajB != null) {
                    ForumEnterLayout.this.ajB.onClick(view);
                }
                if (ForumEnterLayout.this.afq != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.afq.bcY());
                }
            }
        };
        init(context);
    }

    public ForumEnterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.ajJ = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.ahf = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.ajH) {
                    ay.a(ForumEnterLayout.this.afq, view.getContext(), ForumEnterLayout.this.ahf, 2);
                } else if (view == ForumEnterLayout.this.ajF && ForumEnterLayout.this.ajB != null) {
                    ForumEnterLayout.this.ajB.onClick(view);
                }
                if (ForumEnterLayout.this.afq != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.afq.bcY());
                }
            }
        };
        init(context);
    }

    public ForumEnterLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.ajJ = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.ahf = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.ajH) {
                    ay.a(ForumEnterLayout.this.afq, view.getContext(), ForumEnterLayout.this.ahf, 2);
                } else if (view == ForumEnterLayout.this.ajF && ForumEnterLayout.this.ajB != null) {
                    ForumEnterLayout.this.ajB.onClick(view);
                }
                if (ForumEnterLayout.this.afq != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.afq.bcY());
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_item, (ViewGroup) this, true);
        this.ajH = (TextView) inflate.findViewById(R.id.text_post);
        this.ajH.setCompoundDrawablePadding(l.getDimens(context, R.dimen.tbds10));
        this.ajF = (ThreadForumEnterButton) inflate.findViewById(R.id.forum_enter_button);
        this.ajG = (ThreadForumEnterGoodsButton) inflate.findViewById(R.id.forum_enter_goods_button);
        this.ajF.setAfterClickListener(this.mOnClickListener);
        this.ajG.setAfterClickListener(this.mOnClickListener);
        this.ajH.setOnClickListener(this.mOnClickListener);
    }

    public void up() {
        int equipmentWidth = (l.getEquipmentWidth(this.mContext) - (this.mMargin * 2)) - this.ajJ;
        if (equipmentWidth > 0) {
            this.ajK = equipmentWidth / 2;
        } else {
            this.ajK = l.getDimens(this.mContext, R.dimen.tbds540);
        }
        this.ajH.setMaxWidth(this.ajK);
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
            switch (this.ahf) {
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
        this.afq = absThreadDataSupport;
        up();
        bw bcY = absThreadDataSupport.bcY();
        if ((absThreadDataSupport.bde() || !bcY.egt) && !StringUtils.isNull(bcY.bfC()) && !c(bcY)) {
            this.ajF.setVisibility(0);
            this.ajF.a(bcY, this.ajK);
            z = true;
        } else {
            this.ajF.setVisibility(8);
            z = false;
        }
        if (!c(absThreadDataSupport) && !d(absThreadDataSupport) && absThreadDataSupport.bde() && absThreadDataSupport.bcY().bhG()) {
            this.ajG.setVisibility(0);
            this.ajG.r(bcY);
            z = true;
        } else {
            this.ajG.setVisibility(8);
        }
        if (ay.x(bcY) && bcY.isPrivacy) {
            this.ajH.setVisibility(0);
            this.ajH.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds32));
            this.ajH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.ajH, R.color.cp_cont_d);
            this.ajH.setText(R.string.private_desc);
            this.ajH.setOnClickListener(null);
        } else {
            this.ajH.setVisibility(8);
            z2 = z;
        }
        setVisibility(z2 ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ajF.onChangeSkinType();
        this.ajG.onChangeSkinType();
        this.ajI = getArrowRight();
    }

    private Drawable getArrowRight() {
        if (this.ajI == null || this.ajI.mutate() == null) {
            this.ajI = SvgManager.bkl().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        return this.ajI;
    }

    public void setSourceForPb(int i) {
        this.ahf = i;
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.ajB = onClickListener;
    }

    private boolean c(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.bcY() == null || absThreadDataSupport.bcY().bhD() == null || absThreadDataSupport.bcY().bhD().getOptions() == null || absThreadDataSupport.bcY().bhD().getOptions().size() <= 0) ? false : true;
    }

    private boolean c(bw bwVar) {
        return (bwVar == null || bwVar.bfy() == null || !bwVar.egu || !d.bbc() || bwVar.bfy().hadConcerned() || ay.x(bwVar)) ? false : true;
    }

    private boolean d(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.bcY() == null || !absThreadDataSupport.bcY().bee() || absThreadDataSupport.bcY().bfQ() == null) ? false : true;
    }
}
