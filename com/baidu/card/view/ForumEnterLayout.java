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
    private com.baidu.tbadk.core.data.a ahB;
    private int ajA;
    private View.OnClickListener alQ;
    private ThreadForumEnterButton alU;
    private ThreadForumEnterGoodsButton alV;
    private TextView alW;
    private EMTextView alX;
    private Drawable alY;
    private final int alZ;
    private int ama;
    private Context mContext;
    private final int mMargin;
    private final View.OnClickListener mOnClickListener;

    public ForumEnterLayout(Context context) {
        super(context);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.alZ = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.ajA = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.alW) {
                    az.a(ForumEnterLayout.this.ahB, view.getContext(), ForumEnterLayout.this.ajA, 2);
                } else if (view == ForumEnterLayout.this.alU && ForumEnterLayout.this.alQ != null) {
                    ForumEnterLayout.this.alQ.onClick(view);
                }
                if (ForumEnterLayout.this.ahB != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.ahB.blp());
                }
            }
        };
        init(context);
    }

    public ForumEnterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.alZ = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.ajA = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.alW) {
                    az.a(ForumEnterLayout.this.ahB, view.getContext(), ForumEnterLayout.this.ajA, 2);
                } else if (view == ForumEnterLayout.this.alU && ForumEnterLayout.this.alQ != null) {
                    ForumEnterLayout.this.alQ.onClick(view);
                }
                if (ForumEnterLayout.this.ahB != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.ahB.blp());
                }
            }
        };
        init(context);
    }

    public ForumEnterLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.alZ = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.ajA = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.alW) {
                    az.a(ForumEnterLayout.this.ahB, view.getContext(), ForumEnterLayout.this.ajA, 2);
                } else if (view == ForumEnterLayout.this.alU && ForumEnterLayout.this.alQ != null) {
                    ForumEnterLayout.this.alQ.onClick(view);
                }
                if (ForumEnterLayout.this.ahB != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.ahB.blp());
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_item, (ViewGroup) this, true);
        this.alW = (TextView) inflate.findViewById(R.id.text_post);
        this.alW.setCompoundDrawablePadding(l.getDimens(context, R.dimen.tbds10));
        this.alU = (ThreadForumEnterButton) inflate.findViewById(R.id.forum_enter_button);
        this.alV = (ThreadForumEnterGoodsButton) inflate.findViewById(R.id.forum_enter_goods_button);
        this.alU.setAfterClickListener(this.mOnClickListener);
        this.alV.setAfterClickListener(this.mOnClickListener);
        this.alW.setOnClickListener(this.mOnClickListener);
        this.alX = (EMTextView) inflate.findViewById(R.id.tv_ueg);
    }

    public void tC() {
        int equipmentWidth = (l.getEquipmentWidth(this.mContext) - (this.mMargin * 2)) - this.alZ;
        if (equipmentWidth > 0) {
            this.ama = equipmentWidth / 2;
        } else {
            this.ama = l.getDimens(this.mContext, R.dimen.tbds540);
        }
        this.alW.setMaxWidth(this.ama);
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
            switch (this.ajA) {
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
        this.ahB = aVar;
        tC();
        cb blp = aVar.blp();
        if ((aVar.blt() || !blp.eVf) && !StringUtils.isNull(blp.bnW()) && !c(blp)) {
            this.alU.setVisibility(0);
            this.alU.a(blp, this.ama);
            z = true;
        } else {
            this.alU.setVisibility(8);
            z = false;
        }
        if (!c(aVar) && !d(aVar) && aVar.blu() && aVar.blp().bqd()) {
            this.alV.setVisibility(0);
            this.alV.r(blp);
            z = true;
        } else {
            this.alV.setVisibility(8);
        }
        if (az.x(blp) && blp.isPrivacy) {
            this.alW.setVisibility(0);
            this.alW.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds32));
            this.alW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.alW, R.color.CAM_X0109);
            this.alW.setText(R.string.private_desc);
            this.alW.setOnClickListener(null);
            z = true;
        } else {
            this.alW.setVisibility(8);
        }
        int visibility = this.alW.getVisibility();
        if (blp.isAuthorView == 1 && blp.eVi) {
            this.alX.setVisibility(0);
            this.alW.setVisibility(8);
        } else {
            this.alX.setVisibility(8);
            this.alW.setVisibility(visibility);
        }
        setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.alU.onChangeSkinType();
        this.alV.onChangeSkinType();
        this.alY = getArrowRight();
        c.br(this.alX).nZ(R.color.CAM_X0109).ob(R.string.F_X01);
    }

    private Drawable getArrowRight() {
        if (this.alY == null || this.alY.mutate() == null) {
            WebPManager.a(R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        return this.alY;
    }

    public void setSourceForPb(int i) {
        this.ajA = i;
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.alQ = onClickListener;
    }

    private boolean c(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.blp() == null || aVar.blp().bqa() == null || aVar.blp().bqa().getOptions() == null || aVar.blp().bqa().getOptions().size() <= 0) ? false : true;
    }

    private boolean c(cb cbVar) {
        return (cbVar == null || cbVar.bnS() == null || !cbVar.eVg || !d.bji() || cbVar.bnS().hadConcerned() || az.x(cbVar)) ? false : true;
    }

    private boolean d(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.blp() == null || !aVar.blp().bmx() || aVar.blp().boj() == null) ? false : true;
    }
}
