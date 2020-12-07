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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tbadk.core.view.ThreadForumEnterGoodsButton;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class ForumEnterLayout extends RelativeLayout {
    private com.baidu.tbadk.core.data.a agJ;
    private int aiz;
    private View.OnClickListener akX;
    private ThreadForumEnterButton alb;
    private ThreadForumEnterGoodsButton alc;
    private TextView ald;
    private Drawable ale;
    private final int alf;
    private int alg;
    private Context mContext;
    private final int mMargin;
    private final View.OnClickListener mOnClickListener;

    public ForumEnterLayout(Context context) {
        super(context);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.alf = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.aiz = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.ald) {
                    az.a(ForumEnterLayout.this.agJ, view.getContext(), ForumEnterLayout.this.aiz, 2);
                } else if (view == ForumEnterLayout.this.alb && ForumEnterLayout.this.akX != null) {
                    ForumEnterLayout.this.akX.onClick(view);
                }
                if (ForumEnterLayout.this.agJ != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.agJ.bmn());
                }
            }
        };
        init(context);
    }

    public ForumEnterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.alf = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.aiz = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.ald) {
                    az.a(ForumEnterLayout.this.agJ, view.getContext(), ForumEnterLayout.this.aiz, 2);
                } else if (view == ForumEnterLayout.this.alb && ForumEnterLayout.this.akX != null) {
                    ForumEnterLayout.this.akX.onClick(view);
                }
                if (ForumEnterLayout.this.agJ != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.agJ.bmn());
                }
            }
        };
        init(context);
    }

    public ForumEnterLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.alf = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.aiz = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.ald) {
                    az.a(ForumEnterLayout.this.agJ, view.getContext(), ForumEnterLayout.this.aiz, 2);
                } else if (view == ForumEnterLayout.this.alb && ForumEnterLayout.this.akX != null) {
                    ForumEnterLayout.this.akX.onClick(view);
                }
                if (ForumEnterLayout.this.agJ != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.agJ.bmn());
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_item, (ViewGroup) this, true);
        this.ald = (TextView) inflate.findViewById(R.id.text_post);
        this.ald.setCompoundDrawablePadding(l.getDimens(context, R.dimen.tbds10));
        this.alb = (ThreadForumEnterButton) inflate.findViewById(R.id.forum_enter_button);
        this.alc = (ThreadForumEnterGoodsButton) inflate.findViewById(R.id.forum_enter_goods_button);
        this.alb.setAfterClickListener(this.mOnClickListener);
        this.alc.setAfterClickListener(this.mOnClickListener);
        this.ald.setOnClickListener(this.mOnClickListener);
    }

    public void ur() {
        int equipmentWidth = (l.getEquipmentWidth(this.mContext) - (this.mMargin * 2)) - this.alf;
        if (equipmentWidth > 0) {
            this.alg = equipmentWidth / 2;
        } else {
            this.alg = l.getDimens(this.mContext, R.dimen.tbds540);
        }
        this.ald.setMaxWidth(this.alg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, by byVar) {
        if (byVar != null) {
            int id = view.getId();
            String str = null;
            if (id == R.id.forum_enter_button) {
                str = "c13693";
            } else if (id == R.id.text_post) {
                str = "c13695";
            }
            int i = 0;
            switch (this.aiz) {
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
                TiebaStatic.log(com.baidu.tieba.t.a.a(str, byVar, i));
            }
        }
    }

    public void setData(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        boolean z2 = true;
        this.agJ = aVar;
        ur();
        by bmn = aVar.bmn();
        if ((aVar.bmr() || !bmn.eMi) && !StringUtils.isNull(bmn.boT()) && !c(bmn)) {
            this.alb.setVisibility(0);
            this.alb.a(bmn, this.alg);
            z = true;
        } else {
            this.alb.setVisibility(8);
            z = false;
        }
        if (!c(aVar) && !d(aVar) && aVar.bms() && aVar.bmn().bra()) {
            this.alc.setVisibility(0);
            this.alc.r(bmn);
            z = true;
        } else {
            this.alc.setVisibility(8);
        }
        if (az.x(bmn) && bmn.isPrivacy) {
            this.ald.setVisibility(0);
            this.ald.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds32));
            this.ald.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.ald, R.color.CAM_X0109);
            this.ald.setText(R.string.private_desc);
            this.ald.setOnClickListener(null);
        } else {
            this.ald.setVisibility(8);
            z2 = z;
        }
        setVisibility(z2 ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.alb.onChangeSkinType();
        this.alc.onChangeSkinType();
        this.ale = getArrowRight();
    }

    private Drawable getArrowRight() {
        if (this.ale == null || this.ale.mutate() == null) {
            WebPManager.a(R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        return this.ale;
    }

    public void setSourceForPb(int i) {
        this.aiz = i;
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.akX = onClickListener;
    }

    private boolean c(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bmn() == null || aVar.bmn().bqX() == null || aVar.bmn().bqX().getOptions() == null || aVar.bmn().bqX().getOptions().size() <= 0) ? false : true;
    }

    private boolean c(by byVar) {
        return (byVar == null || byVar.boP() == null || !byVar.eMj || !d.bkz() || byVar.boP().hadConcerned() || az.x(byVar)) ? false : true;
    }

    private boolean d(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bmn() == null || !aVar.bmn().bnv() || aVar.bmn().bph() == null) ? false : true;
    }
}
