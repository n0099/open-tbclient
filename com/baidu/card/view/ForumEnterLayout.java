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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class ForumEnterLayout extends RelativeLayout {
    private AbsThreadDataSupport adw;
    private int afa;
    private ThreadForumEnterButton agT;
    private TextView agU;
    private Drawable agV;
    private final int agW;
    private int agX;
    private View.OnClickListener agY;
    private Context mContext;
    private final int mMargin;
    private final View.OnClickListener mOnClickListener;

    public ForumEnterLayout(Context context) {
        super(context);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.agW = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.afa = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.agU) {
                    au.a(ForumEnterLayout.this.adw, view.getContext(), ForumEnterLayout.this.afa, 2);
                } else if (view == ForumEnterLayout.this.agT && ForumEnterLayout.this.agY != null) {
                    ForumEnterLayout.this.agY.onClick(view);
                }
                if (ForumEnterLayout.this.adw != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.adw.aOi());
                }
            }
        };
        init(context);
    }

    public ForumEnterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.agW = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.afa = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.agU) {
                    au.a(ForumEnterLayout.this.adw, view.getContext(), ForumEnterLayout.this.afa, 2);
                } else if (view == ForumEnterLayout.this.agT && ForumEnterLayout.this.agY != null) {
                    ForumEnterLayout.this.agY.onClick(view);
                }
                if (ForumEnterLayout.this.adw != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.adw.aOi());
                }
            }
        };
        init(context);
    }

    public ForumEnterLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.agW = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.afa = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.agU) {
                    au.a(ForumEnterLayout.this.adw, view.getContext(), ForumEnterLayout.this.afa, 2);
                } else if (view == ForumEnterLayout.this.agT && ForumEnterLayout.this.agY != null) {
                    ForumEnterLayout.this.agY.onClick(view);
                }
                if (ForumEnterLayout.this.adw != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.adw.aOi());
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_item, (ViewGroup) this, true);
        this.agU = (TextView) inflate.findViewById(R.id.text_post);
        this.agU.setCompoundDrawablePadding(l.getDimens(context, R.dimen.tbds10));
        this.agT = (ThreadForumEnterButton) inflate.findViewById(R.id.forum_enter_button);
        this.agT.setAfterClickListener(this.mOnClickListener);
        this.agU.setOnClickListener(this.mOnClickListener);
    }

    public void rZ() {
        int equipmentWidth = (l.getEquipmentWidth(this.mContext) - (this.mMargin * 2)) - this.agW;
        if (equipmentWidth > 0) {
            this.agX = equipmentWidth / 2;
        } else {
            this.agX = l.getDimens(this.mContext, R.dimen.tbds540);
        }
        this.agU.setMaxWidth(this.agX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, bk bkVar) {
        if (bkVar != null) {
            int id = view.getId();
            String str = null;
            if (id == R.id.forum_enter_button) {
                str = "c13693";
            } else if (id == R.id.text_post) {
                str = "c13695";
            }
            int i = 0;
            switch (this.afa) {
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
                TiebaStatic.log(com.baidu.tieba.s.a.a(str, bkVar, i));
            }
        }
    }

    public void setData(AbsThreadDataSupport absThreadDataSupport) {
        boolean z;
        boolean z2 = true;
        this.adw = absThreadDataSupport;
        rZ();
        bk aOi = absThreadDataSupport.aOi();
        if ((absThreadDataSupport.aOo() || !aOi.dHM) && !StringUtils.isNull(aOi.aQC())) {
            this.agT.setVisibility(0);
            this.agT.a(aOi, this.agX);
            z = true;
        } else {
            this.agT.setVisibility(8);
            z = false;
        }
        if (au.v(aOi) && aOi.isPrivacy) {
            this.agU.setVisibility(0);
            this.agU.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds32));
            this.agU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.agU, (int) R.color.cp_cont_d);
            this.agU.setText(R.string.private_desc);
            this.agU.setOnClickListener(null);
        } else if (absThreadDataSupport.aOq()) {
            if (!StringUtils.isNull(aOi.aSC())) {
                this.agU.setVisibility(0);
                this.agU.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds34));
                this.agU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, getArrowRight(), (Drawable) null);
                this.agU.setTextColor(am.ld(R.color.cp_cont_j));
                this.agU.setText(aOi.aSC());
                this.agU.setOnClickListener(this.mOnClickListener);
            } else {
                this.agU.setVisibility(8);
                z2 = z;
            }
        } else {
            this.agU.setVisibility(8);
            z2 = z;
        }
        setVisibility(z2 ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.agT.onChangeSkinType();
        this.agV = getArrowRight();
    }

    private Drawable getArrowRight() {
        if (this.agV == null || this.agV.mutate() == null) {
            this.agV = SvgManager.aUV().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        return this.agV;
    }

    public void setSourceForPb(int i) {
        this.afa = i;
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.agY = onClickListener;
    }
}
