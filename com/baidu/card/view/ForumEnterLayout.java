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
    private AbsThreadDataSupport aeW;
    private int agK;
    private ThreadForumEnterButton aje;
    private ThreadForumEnterGoodsButton ajf;
    private TextView ajg;
    private Drawable ajh;
    private final int aji;
    private int ajj;
    private View.OnClickListener ajk;
    private Context mContext;
    private final int mMargin;
    private final View.OnClickListener mOnClickListener;

    public ForumEnterLayout(Context context) {
        super(context);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.aji = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.agK = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.ajg) {
                    ay.a(ForumEnterLayout.this.aeW, view.getContext(), ForumEnterLayout.this.agK, 2);
                } else if (view == ForumEnterLayout.this.aje && ForumEnterLayout.this.ajk != null) {
                    ForumEnterLayout.this.ajk.onClick(view);
                }
                if (ForumEnterLayout.this.aeW != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.aeW.bce());
                }
            }
        };
        init(context);
    }

    public ForumEnterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.aji = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.agK = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.ajg) {
                    ay.a(ForumEnterLayout.this.aeW, view.getContext(), ForumEnterLayout.this.agK, 2);
                } else if (view == ForumEnterLayout.this.aje && ForumEnterLayout.this.ajk != null) {
                    ForumEnterLayout.this.ajk.onClick(view);
                }
                if (ForumEnterLayout.this.aeW != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.aeW.bce());
                }
            }
        };
        init(context);
    }

    public ForumEnterLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.aji = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.agK = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.ajg) {
                    ay.a(ForumEnterLayout.this.aeW, view.getContext(), ForumEnterLayout.this.agK, 2);
                } else if (view == ForumEnterLayout.this.aje && ForumEnterLayout.this.ajk != null) {
                    ForumEnterLayout.this.ajk.onClick(view);
                }
                if (ForumEnterLayout.this.aeW != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.aeW.bce());
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_item, (ViewGroup) this, true);
        this.ajg = (TextView) inflate.findViewById(R.id.text_post);
        this.ajg.setCompoundDrawablePadding(l.getDimens(context, R.dimen.tbds10));
        this.aje = (ThreadForumEnterButton) inflate.findViewById(R.id.forum_enter_button);
        this.ajf = (ThreadForumEnterGoodsButton) inflate.findViewById(R.id.forum_enter_goods_button);
        this.aje.setAfterClickListener(this.mOnClickListener);
        this.ajf.setAfterClickListener(this.mOnClickListener);
        this.ajg.setOnClickListener(this.mOnClickListener);
    }

    public void uj() {
        int equipmentWidth = (l.getEquipmentWidth(this.mContext) - (this.mMargin * 2)) - this.aji;
        if (equipmentWidth > 0) {
            this.ajj = equipmentWidth / 2;
        } else {
            this.ajj = l.getDimens(this.mContext, R.dimen.tbds540);
        }
        this.ajg.setMaxWidth(this.ajj);
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
            switch (this.agK) {
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
        this.aeW = absThreadDataSupport;
        uj();
        bw bce = absThreadDataSupport.bce();
        if ((absThreadDataSupport.bck() || !bce.eef) && !StringUtils.isNull(bce.beI())) {
            this.aje.setVisibility(0);
            this.aje.a(bce, this.ajj);
            z = true;
        } else {
            this.aje.setVisibility(8);
            z = false;
        }
        if (!c(absThreadDataSupport) && absThreadDataSupport.bck() && absThreadDataSupport.bce().bgM()) {
            this.ajf.setVisibility(0);
            this.ajf.q(bce);
            z = true;
        } else {
            this.ajf.setVisibility(8);
        }
        if (ay.w(bce) && bce.isPrivacy) {
            this.ajg.setVisibility(0);
            this.ajg.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds32));
            this.ajg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.ajg, R.color.cp_cont_d);
            this.ajg.setText(R.string.private_desc);
            this.ajg.setOnClickListener(null);
        } else {
            this.ajg.setVisibility(8);
            z2 = z;
        }
        setVisibility(z2 ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.aje.onChangeSkinType();
        this.ajf.onChangeSkinType();
        this.ajh = getArrowRight();
    }

    private Drawable getArrowRight() {
        if (this.ajh == null || this.ajh.mutate() == null) {
            this.ajh = SvgManager.bjq().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        return this.ajh;
    }

    public void setSourceForPb(int i) {
        this.agK = i;
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.ajk = onClickListener;
    }

    private boolean c(AbsThreadDataSupport absThreadDataSupport) {
        return (absThreadDataSupport == null || absThreadDataSupport.bce() == null || absThreadDataSupport.bce().bgJ() == null || absThreadDataSupport.bce().bgJ().getOptions() == null || absThreadDataSupport.bce().bgJ().getOptions().size() <= 0) ? false : true;
    }
}
