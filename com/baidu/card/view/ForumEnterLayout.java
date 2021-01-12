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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tbadk.core.view.ThreadForumEnterGoodsButton;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ForumEnterLayout extends RelativeLayout {
    private com.baidu.tbadk.core.data.a agr;
    private int aiu;
    private View.OnClickListener akI;
    private ThreadForumEnterButton akM;
    private ThreadForumEnterGoodsButton akN;
    private TextView akO;
    private Drawable akP;
    private final int akQ;
    private int akR;
    private Context mContext;
    private final int mMargin;
    private final View.OnClickListener mOnClickListener;

    public ForumEnterLayout(Context context) {
        super(context);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.akQ = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.aiu = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.akO) {
                    ay.a(ForumEnterLayout.this.agr, view.getContext(), ForumEnterLayout.this.aiu, 2);
                } else if (view == ForumEnterLayout.this.akM && ForumEnterLayout.this.akI != null) {
                    ForumEnterLayout.this.akI.onClick(view);
                }
                if (ForumEnterLayout.this.agr != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.agr.bkV());
                }
            }
        };
        init(context);
    }

    public ForumEnterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.akQ = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.aiu = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.akO) {
                    ay.a(ForumEnterLayout.this.agr, view.getContext(), ForumEnterLayout.this.aiu, 2);
                } else if (view == ForumEnterLayout.this.akM && ForumEnterLayout.this.akI != null) {
                    ForumEnterLayout.this.akI.onClick(view);
                }
                if (ForumEnterLayout.this.agr != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.agr.bkV());
                }
            }
        };
        init(context);
    }

    public ForumEnterLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.akQ = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.aiu = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.akO) {
                    ay.a(ForumEnterLayout.this.agr, view.getContext(), ForumEnterLayout.this.aiu, 2);
                } else if (view == ForumEnterLayout.this.akM && ForumEnterLayout.this.akI != null) {
                    ForumEnterLayout.this.akI.onClick(view);
                }
                if (ForumEnterLayout.this.agr != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.agr.bkV());
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_item, (ViewGroup) this, true);
        this.akO = (TextView) inflate.findViewById(R.id.text_post);
        this.akO.setCompoundDrawablePadding(l.getDimens(context, R.dimen.tbds10));
        this.akM = (ThreadForumEnterButton) inflate.findViewById(R.id.forum_enter_button);
        this.akN = (ThreadForumEnterGoodsButton) inflate.findViewById(R.id.forum_enter_goods_button);
        this.akM.setAfterClickListener(this.mOnClickListener);
        this.akN.setAfterClickListener(this.mOnClickListener);
        this.akO.setOnClickListener(this.mOnClickListener);
    }

    public void tF() {
        int equipmentWidth = (l.getEquipmentWidth(this.mContext) - (this.mMargin * 2)) - this.akQ;
        if (equipmentWidth > 0) {
            this.akR = equipmentWidth / 2;
        } else {
            this.akR = l.getDimens(this.mContext, R.dimen.tbds540);
        }
        this.akO.setMaxWidth(this.akR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, bz bzVar) {
        if (bzVar != null) {
            int id = view.getId();
            String str = null;
            if (id == R.id.forum_enter_button) {
                str = "c13693";
            } else if (id == R.id.text_post) {
                str = "c13695";
            }
            int i = 0;
            switch (this.aiu) {
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
                TiebaStatic.log(com.baidu.tieba.s.a.a(str, bzVar, i));
            }
        }
    }

    public void setData(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        boolean z2 = true;
        this.agr = aVar;
        tF();
        bz bkV = aVar.bkV();
        if ((aVar.bkZ() || !bkV.eRs) && !StringUtils.isNull(bkV.bnB()) && !c(bkV)) {
            this.akM.setVisibility(0);
            this.akM.a(bkV, this.akR);
            z = true;
        } else {
            this.akM.setVisibility(8);
            z = false;
        }
        if (!c(aVar) && !d(aVar) && aVar.bla() && aVar.bkV().bpJ()) {
            this.akN.setVisibility(0);
            this.akN.r(bkV);
            z = true;
        } else {
            this.akN.setVisibility(8);
        }
        if (ay.x(bkV) && bkV.isPrivacy) {
            this.akO.setVisibility(0);
            this.akO.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds32));
            this.akO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ao.setViewTextColor(this.akO, R.color.CAM_X0109);
            this.akO.setText(R.string.private_desc);
            this.akO.setOnClickListener(null);
        } else {
            this.akO.setVisibility(8);
            z2 = z;
        }
        setVisibility(z2 ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.akM.onChangeSkinType();
        this.akN.onChangeSkinType();
        this.akP = getArrowRight();
    }

    private Drawable getArrowRight() {
        if (this.akP == null || this.akP.mutate() == null) {
            WebPManager.a(R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        return this.akP;
    }

    public void setSourceForPb(int i) {
        this.aiu = i;
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.akI = onClickListener;
    }

    private boolean c(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bkV() == null || aVar.bkV().bpG() == null || aVar.bkV().bpG().getOptions() == null || aVar.bkV().bpG().getOptions().size() <= 0) ? false : true;
    }

    private boolean c(bz bzVar) {
        return (bzVar == null || bzVar.bnx() == null || !bzVar.eRt || !d.biU() || bzVar.bnx().hadConcerned() || ay.x(bzVar)) ? false : true;
    }

    private boolean d(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bkV() == null || !aVar.bkV().bmc() || aVar.bkV().bnO() == null) ? false : true;
    }
}
