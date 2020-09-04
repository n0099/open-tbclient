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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tbadk.core.view.ThreadForumEnterGoodsButton;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class ForumEnterLayout extends RelativeLayout {
    private AbsThreadDataSupport aeY;
    private int agM;
    private ThreadForumEnterButton ajg;
    private ThreadForumEnterGoodsButton ajh;
    private TextView aji;
    private Drawable ajj;
    private final int ajk;
    private int ajl;
    private View.OnClickListener ajm;
    private Context mContext;
    private final int mMargin;
    private final View.OnClickListener mOnClickListener;

    public ForumEnterLayout(Context context) {
        super(context);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.ajk = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.agM = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.aji) {
                    ay.a(ForumEnterLayout.this.aeY, view.getContext(), ForumEnterLayout.this.agM, 2);
                } else if (view == ForumEnterLayout.this.ajg && ForumEnterLayout.this.ajm != null) {
                    ForumEnterLayout.this.ajm.onClick(view);
                }
                if (ForumEnterLayout.this.aeY != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.aeY.bce());
                }
            }
        };
        init(context);
    }

    public ForumEnterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.ajk = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.agM = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.aji) {
                    ay.a(ForumEnterLayout.this.aeY, view.getContext(), ForumEnterLayout.this.agM, 2);
                } else if (view == ForumEnterLayout.this.ajg && ForumEnterLayout.this.ajm != null) {
                    ForumEnterLayout.this.ajm.onClick(view);
                }
                if (ForumEnterLayout.this.aeY != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.aeY.bce());
                }
            }
        };
        init(context);
    }

    public ForumEnterLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.ajk = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.agM = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.aji) {
                    ay.a(ForumEnterLayout.this.aeY, view.getContext(), ForumEnterLayout.this.agM, 2);
                } else if (view == ForumEnterLayout.this.ajg && ForumEnterLayout.this.ajm != null) {
                    ForumEnterLayout.this.ajm.onClick(view);
                }
                if (ForumEnterLayout.this.aeY != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.aeY.bce());
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_item, (ViewGroup) this, true);
        this.aji = (TextView) inflate.findViewById(R.id.text_post);
        this.aji.setCompoundDrawablePadding(l.getDimens(context, R.dimen.tbds10));
        this.ajg = (ThreadForumEnterButton) inflate.findViewById(R.id.forum_enter_button);
        this.ajh = (ThreadForumEnterGoodsButton) inflate.findViewById(R.id.forum_enter_goods_button);
        this.ajg.setAfterClickListener(this.mOnClickListener);
        this.ajh.setAfterClickListener(this.mOnClickListener);
        this.aji.setOnClickListener(this.mOnClickListener);
    }

    public void uj() {
        int equipmentWidth = (l.getEquipmentWidth(this.mContext) - (this.mMargin * 2)) - this.ajk;
        if (equipmentWidth > 0) {
            this.ajl = equipmentWidth / 2;
        } else {
            this.ajl = l.getDimens(this.mContext, R.dimen.tbds540);
        }
        this.aji.setMaxWidth(this.ajl);
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
            switch (this.agM) {
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
        this.aeY = absThreadDataSupport;
        uj();
        bw bce = absThreadDataSupport.bce();
        if ((absThreadDataSupport.bck() || !bce.eej) && !StringUtils.isNull(bce.beI())) {
            this.ajg.setVisibility(0);
            this.ajg.a(bce, this.ajl);
            z = true;
        } else {
            this.ajg.setVisibility(8);
            z = false;
        }
        if (!c(absThreadDataSupport) && absThreadDataSupport.bck() && absThreadDataSupport.bce().bgM()) {
            this.ajh.setVisibility(0);
            this.ajh.q(bce);
            z = true;
        } else {
            this.ajh.setVisibility(8);
        }
        if (ay.w(bce) && bce.isPrivacy) {
            this.aji.setVisibility(0);
            this.aji.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds32));
            this.aji.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.aji, R.color.cp_cont_d);
            this.aji.setText(R.string.private_desc);
            this.aji.setOnClickListener(null);
        } else {
            this.aji.setVisibility(8);
            z2 = z;
        }
        setVisibility(z2 ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.ajg.onChangeSkinType();
        this.ajh.onChangeSkinType();
        this.ajj = getArrowRight();
    }

    private Drawable getArrowRight() {
        if (this.ajj == null || this.ajj.mutate() == null) {
            this.ajj = SvgManager.bjq().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        return this.ajj;
    }

    public void setSourceForPb(int i) {
        this.agM = i;
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.ajm = onClickListener;
    }

    private boolean c(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.bce() == null || absThreadDataSupport.bce().bgJ() == null || absThreadDataSupport.bce().bgJ().getOptions() == null || absThreadDataSupport.bce().bgJ().getOptions().size() <= 0) ? false : true;
    }
}
