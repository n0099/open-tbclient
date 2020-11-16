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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tbadk.core.view.ThreadForumEnterGoodsButton;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class ForumEnterLayout extends RelativeLayout {
    private com.baidu.tbadk.core.data.a afN;
    private int ahz;
    private View.OnClickListener ajX;
    private ThreadForumEnterButton akb;
    private ThreadForumEnterGoodsButton akc;
    private TextView akd;
    private Drawable ake;
    private final int akf;
    private int akg;
    private Context mContext;
    private final int mMargin;
    private final View.OnClickListener mOnClickListener;

    public ForumEnterLayout(Context context) {
        super(context);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.akf = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.ahz = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.akd) {
                    az.a(ForumEnterLayout.this.afN, view.getContext(), ForumEnterLayout.this.ahz, 2);
                } else if (view == ForumEnterLayout.this.akb && ForumEnterLayout.this.ajX != null) {
                    ForumEnterLayout.this.ajX.onClick(view);
                }
                if (ForumEnterLayout.this.afN != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.afN.bjd());
                }
            }
        };
        init(context);
    }

    public ForumEnterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.akf = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.ahz = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.akd) {
                    az.a(ForumEnterLayout.this.afN, view.getContext(), ForumEnterLayout.this.ahz, 2);
                } else if (view == ForumEnterLayout.this.akb && ForumEnterLayout.this.ajX != null) {
                    ForumEnterLayout.this.ajX.onClick(view);
                }
                if (ForumEnterLayout.this.afN != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.afN.bjd());
                }
            }
        };
        init(context);
    }

    public ForumEnterLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.akf = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.ahz = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ForumEnterLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ForumEnterLayout.this.akd) {
                    az.a(ForumEnterLayout.this.afN, view.getContext(), ForumEnterLayout.this.ahz, 2);
                } else if (view == ForumEnterLayout.this.akb && ForumEnterLayout.this.ajX != null) {
                    ForumEnterLayout.this.ajX.onClick(view);
                }
                if (ForumEnterLayout.this.afN != null) {
                    ForumEnterLayout.this.a(view, ForumEnterLayout.this.afN.bjd());
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_item, (ViewGroup) this, true);
        this.akd = (TextView) inflate.findViewById(R.id.text_post);
        this.akd.setCompoundDrawablePadding(l.getDimens(context, R.dimen.tbds10));
        this.akb = (ThreadForumEnterButton) inflate.findViewById(R.id.forum_enter_button);
        this.akc = (ThreadForumEnterGoodsButton) inflate.findViewById(R.id.forum_enter_goods_button);
        this.akb.setAfterClickListener(this.mOnClickListener);
        this.akc.setAfterClickListener(this.mOnClickListener);
        this.akd.setOnClickListener(this.mOnClickListener);
    }

    public void uo() {
        int equipmentWidth = (l.getEquipmentWidth(this.mContext) - (this.mMargin * 2)) - this.akf;
        if (equipmentWidth > 0) {
            this.akg = equipmentWidth / 2;
        } else {
            this.akg = l.getDimens(this.mContext, R.dimen.tbds540);
        }
        this.akd.setMaxWidth(this.akg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, bx bxVar) {
        if (bxVar != null) {
            int id = view.getId();
            String str = null;
            if (id == R.id.forum_enter_button) {
                str = "c13693";
            } else if (id == R.id.text_post) {
                str = "c13695";
            }
            int i = 0;
            switch (this.ahz) {
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
                TiebaStatic.log(com.baidu.tieba.t.a.a(str, bxVar, i));
            }
        }
    }

    public void setData(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        boolean z2 = true;
        this.afN = aVar;
        uo();
        bx bjd = aVar.bjd();
        if ((aVar.bjh() || !bjd.eFg) && !StringUtils.isNull(bjd.blG()) && !c(bjd)) {
            this.akb.setVisibility(0);
            this.akb.a(bjd, this.akg);
            z = true;
        } else {
            this.akb.setVisibility(8);
            z = false;
        }
        if (!c(aVar) && !d(aVar) && aVar.bji() && aVar.bjd().bnM()) {
            this.akc.setVisibility(0);
            this.akc.r(bjd);
            z = true;
        } else {
            this.akc.setVisibility(8);
        }
        if (az.x(bjd) && bjd.isPrivacy) {
            this.akd.setVisibility(0);
            this.akd.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds32));
            this.akd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.akd, R.color.CAM_X0109);
            this.akd.setText(R.string.private_desc);
            this.akd.setOnClickListener(null);
        } else {
            this.akd.setVisibility(8);
            z2 = z;
        }
        setVisibility(z2 ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.akb.onChangeSkinType();
        this.akc.onChangeSkinType();
        this.ake = getArrowRight();
    }

    private Drawable getArrowRight() {
        if (this.ake == null || this.ake.mutate() == null) {
            WebPManager.a(R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        return this.ake;
    }

    public void setSourceForPb(int i) {
        this.ahz = i;
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.ajX = onClickListener;
    }

    private boolean c(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bjd() == null || aVar.bjd().bnJ() == null || aVar.bjd().bnJ().getOptions() == null || aVar.bjd().bnJ().getOptions().size() <= 0) ? false : true;
    }

    private boolean c(bx bxVar) {
        return (bxVar == null || bxVar.blC() == null || !bxVar.eFh || !d.bhv() || bxVar.blC().hadConcerned() || az.x(bxVar)) ? false : true;
    }

    private boolean d(com.baidu.tbadk.core.data.a aVar) {
        return (aVar == null || aVar.bjd() == null || !aVar.bjd().bki() || aVar.bjd().blU() == null) ? false : true;
    }
}
