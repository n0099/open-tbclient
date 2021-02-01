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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tbadk.core.view.ThreadForumEnterGoodsButton;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ForumEnterLayout extends RelativeLayout {
    private com.baidu.tbadk.core.data.a agj;
    private int aii;
    private ThreadForumEnterButton akB;
    private ThreadForumEnterGoodsButton akC;
    private TextView akD;
    private EMTextView akE;
    private Drawable akF;
    private final int akG;
    private int akH;
    private View.OnClickListener akx;
    private Context mContext;
    private final int mMargin;
    private final View.OnClickListener mOnClickListener;

    public ForumEnterLayout(Context context) {
        super(context);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.akG = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.aii = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.akD) {
                    az.a(ForumEnterLayout.this.agj, view.getContext(), ForumEnterLayout.this.aii, 2);
                } else if (view == ForumEnterLayout.this.akB && ForumEnterLayout.this.akx != null) {
                    ForumEnterLayout.this.akx.onClick(view);
                }
                if (ForumEnterLayout.this.agj != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.agj.bln());
                }
            }
        };
        init(context);
    }

    public ForumEnterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.akG = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.aii = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.akD) {
                    az.a(ForumEnterLayout.this.agj, view.getContext(), ForumEnterLayout.this.aii, 2);
                } else if (view == ForumEnterLayout.this.akB && ForumEnterLayout.this.akx != null) {
                    ForumEnterLayout.this.akx.onClick(view);
                }
                if (ForumEnterLayout.this.agj != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.agj.bln());
                }
            }
        };
        init(context);
    }

    public ForumEnterLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.akG = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.aii = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.akD) {
                    az.a(ForumEnterLayout.this.agj, view.getContext(), ForumEnterLayout.this.aii, 2);
                } else if (view == ForumEnterLayout.this.akB && ForumEnterLayout.this.akx != null) {
                    ForumEnterLayout.this.akx.onClick(view);
                }
                if (ForumEnterLayout.this.agj != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.agj.bln());
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_item, (ViewGroup) this, true);
        this.akD = (TextView) inflate.findViewById(R.id.text_post);
        this.akD.setCompoundDrawablePadding(l.getDimens(context, R.dimen.tbds10));
        this.akB = (ThreadForumEnterButton) inflate.findViewById(R.id.forum_enter_button);
        this.akC = (ThreadForumEnterGoodsButton) inflate.findViewById(R.id.forum_enter_goods_button);
        this.akB.setAfterClickListener(this.mOnClickListener);
        this.akC.setAfterClickListener(this.mOnClickListener);
        this.akD.setOnClickListener(this.mOnClickListener);
        this.akE = (EMTextView) inflate.findViewById(R.id.tv_ueg);
    }

    public void tC() {
        int equipmentWidth = (l.getEquipmentWidth(this.mContext) - (this.mMargin * 2)) - this.akG;
        if (equipmentWidth > 0) {
            this.akH = equipmentWidth / 2;
        } else {
            this.akH = l.getDimens(this.mContext, R.dimen.tbds540);
        }
        this.akD.setMaxWidth(this.akH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, cb cbVar) {
        if (cbVar != null) {
            int id = view.getId();
            String str = null;
            if (id == R.id.forum_enter_button) {
                str = "c13693";
            } else if (id == R.id.text_post) {
                str = "c13695";
            }
            int i = 0;
            switch (this.aii) {
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
                TiebaStatic.log(com.baidu.tieba.s.a.a(str, cbVar, i));
            }
        }
    }

    public void setData(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        this.agj = aVar;
        tC();
        cb bln = aVar.bln();
        if ((aVar.blr() || !bln.eTE) && !StringUtils.isNull(bln.bnU()) && !c(bln)) {
            this.akB.setVisibility(0);
            this.akB.a(bln, this.akH);
            z = true;
        } else {
            this.akB.setVisibility(8);
            z = false;
        }
        if (!c(aVar) && !d(aVar) && aVar.bls() && aVar.bln().bqb()) {
            this.akC.setVisibility(0);
            this.akC.r(bln);
            z = true;
        } else {
            this.akC.setVisibility(8);
        }
        if (az.x(bln) && bln.isPrivacy) {
            this.akD.setVisibility(0);
            this.akD.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds32));
            this.akD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.akD, R.color.CAM_X0109);
            this.akD.setText(R.string.private_desc);
            this.akD.setOnClickListener(null);
            z = true;
        } else {
            this.akD.setVisibility(8);
        }
        int visibility = this.akD.getVisibility();
        if (bln.isAuthorView == 1 && bln.eTH) {
            this.akE.setVisibility(0);
            this.akD.setVisibility(8);
        } else {
            this.akE.setVisibility(8);
            this.akD.setVisibility(visibility);
        }
        setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.akB.onChangeSkinType();
        this.akC.onChangeSkinType();
        this.akF = getArrowRight();
        c.br(this.akE).nY(R.color.CAM_X0109).oa(R.string.F_X01);
    }

    private Drawable getArrowRight() {
        if (this.akF == null || this.akF.mutate() == null) {
            WebPManager.a(R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        return this.akF;
    }

    public void setSourceForPb(int i) {
        this.aii = i;
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.akx = onClickListener;
    }

    private boolean c(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bln() == null || aVar.bln().bpY() == null || aVar.bln().bpY().getOptions() == null || aVar.bln().bpY().getOptions().size() <= 0) ? false : true;
    }

    private boolean c(cb cbVar) {
        return (cbVar == null || cbVar.bnQ() == null || !cbVar.eTF || !d.bjg() || cbVar.bnQ().hadConcerned() || az.x(cbVar)) ? false : true;
    }

    private boolean d(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bln() == null || !aVar.bln().bmv() || aVar.bln().boh() == null) ? false : true;
    }
}
