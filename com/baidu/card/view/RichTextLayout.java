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
    private boolean ahF;
    private View.OnClickListener ahj;
    public TextView aia;
    private final int amG;
    private boolean amI;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;

    public RichTextLayout(Context context) {
        super(context);
        this.amG = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
        this.amI = false;
        this.ahF = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.richtext_normal_layout, (ViewGroup) this, true);
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.aia = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void D(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.boP() != null) {
            bz boP = aVar.boP();
            OriginalThreadInfo originalThreadInfo = boP.eVB;
            if (originalThreadInfo != null && this.amI) {
                this.mTitle.setVisibility(8);
                c.bv(this.aia).pE(R.string.F_X01).pD(R.dimen.T_X07);
                if (originalThreadInfo.ePW) {
                    ay.a(this.aia, this.mTitle, new SpannableString(originalThreadInfo.title), boP, this.amG, this.amI, this.ahF);
                    ao.setViewTextColor(this.aia, R.color.CAM_X0108);
                } else {
                    ay.a(this.aia, this.mTitle, originalThreadInfo.eQX, boP, this.amG, this.amI, this.ahF);
                }
            } else {
                ay.a(this.mTitle, boP, this.ahF);
                ay.a(this.aia, this.mTitle, boP.bqS(), boP, this.amG, this.amI, this.ahF);
            }
            if (!this.amI) {
                this.aia.setClickable(false);
                this.mTitle.setClickable(false);
            } else if (originalThreadInfo != null && originalThreadInfo.ePW) {
                setOnClickListener(null);
                setClickable(true);
            } else {
                setOnClickListener(this);
                this.aia.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.ahj != null) {
                            RichTextLayout.this.ahj.onClick(view);
                        }
                    }
                });
                this.mTitle.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.ahj != null) {
                            RichTextLayout.this.ahj.onClick(view);
                        }
                    }
                });
                this.aia.setClickable(true);
                this.mTitle.setClickable(true);
            }
        }
    }

    public void setTransmit(boolean z) {
        this.amI = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ahj != null) {
            this.ahj.onClick(view);
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.ahj = onClickListener;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahF = z;
    }
}
