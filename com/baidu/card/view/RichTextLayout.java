package com.baidu.card.view;

import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.card.p;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class RichTextLayout extends LinearLayout implements View.OnClickListener, p<com.baidu.tbadk.core.data.a> {
    private boolean agO;
    private View.OnClickListener ags;
    public TextView ahj;
    private final int alP;
    private boolean alR;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;

    public RichTextLayout(Context context) {
        super(context);
        this.alP = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
        this.alR = false;
        this.agO = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.richtext_normal_layout, (ViewGroup) this, true);
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ahj = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.bkV() != null) {
            bz bkV = aVar.bkV();
            OriginalThreadInfo originalThreadInfo = bkV.eQQ;
            if (originalThreadInfo != null && this.alR) {
                this.mTitle.setVisibility(8);
                c.bv(this.ahj).nX(R.string.F_X01).nW(R.dimen.T_X07);
                if (originalThreadInfo.eLl) {
                    ay.a(this.ahj, this.mTitle, new SpannableString(originalThreadInfo.title), bkV, this.alP, this.alR, this.agO);
                    ao.setViewTextColor(this.ahj, R.color.CAM_X0108);
                } else {
                    ay.a(this.ahj, this.mTitle, originalThreadInfo.eMm, bkV, this.alP, this.alR, this.agO);
                }
            } else {
                ay.a(this.mTitle, bkV, this.agO);
                ay.a(this.ahj, this.mTitle, bkV.bmY(), bkV, this.alP, this.alR, this.agO);
            }
            if (!this.alR) {
                this.ahj.setClickable(false);
                this.mTitle.setClickable(false);
            } else if (originalThreadInfo != null && originalThreadInfo.eLl) {
                setOnClickListener(null);
                setClickable(true);
            } else {
                setOnClickListener(this);
                this.ahj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.ags != null) {
                            RichTextLayout.this.ags.onClick(view);
                        }
                    }
                });
                this.mTitle.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.ags != null) {
                            RichTextLayout.this.ags.onClick(view);
                        }
                    }
                });
                this.ahj.setClickable(true);
                this.mTitle.setClickable(true);
            }
        }
    }

    public void setTransmit(boolean z) {
        this.alR = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ags != null) {
            this.ags.onClick(view);
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.ags = onClickListener;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setNeedFrsTabName(boolean z) {
        this.agO = z;
    }
}
