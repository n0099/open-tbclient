package com.baidu.card.view;

import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.card.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class RichTextLayout extends LinearLayout implements View.OnClickListener, m<com.baidu.tbadk.core.data.a> {
    public TextView KA;
    private View.OnClickListener Ke;
    private boolean Mw;
    private final int OB;
    private boolean OD;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;

    public RichTextLayout(Context context) {
        super(context);
        this.OB = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
        this.OD = false;
        this.Mw = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.richtext_normal_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.KA = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.aAj() != null) {
            bj aAj = aVar.aAj();
            OriginalThreadInfo originalThreadInfo = aAj.cUe;
            if (originalThreadInfo != null && this.OD) {
                this.mTitle.setVisibility(8);
                this.KA.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                if (originalThreadInfo.cOY) {
                    au.a(this.KA, this.mTitle, new SpannableString(originalThreadInfo.title), aAj, this.OB, this.OD, this.Mw);
                    am.setViewTextColor(this.KA, (int) R.color.cp_cont_c);
                } else {
                    au.a(this.KA, this.mTitle, originalThreadInfo.cPZ, aAj, this.OB, this.OD, this.Mw);
                }
            } else {
                au.a(this.mTitle, aAj, this.Mw);
                this.KA.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                au.a(this.KA, this.mTitle, aAj.aBT(), aAj, this.OB, this.OD, this.Mw);
            }
            if (!this.OD) {
                this.KA.setClickable(false);
                this.mTitle.setClickable(false);
            } else if (originalThreadInfo != null && originalThreadInfo.cOY) {
                setOnClickListener(null);
                setClickable(true);
            } else {
                setOnClickListener(this);
                this.KA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.Ke != null) {
                            RichTextLayout.this.Ke.onClick(view);
                        }
                    }
                });
                this.mTitle.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.Ke != null) {
                            RichTextLayout.this.Ke.onClick(view);
                        }
                    }
                });
                this.KA.setClickable(true);
                this.mTitle.setClickable(true);
            }
        }
    }

    public void setTransmit(boolean z) {
        this.OD = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.Ke != null) {
            this.Ke.onClick(view);
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.Ke = onClickListener;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setNeedFrsTabName(boolean z) {
        this.Mw = z;
    }
}
