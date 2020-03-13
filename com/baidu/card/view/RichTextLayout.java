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
    private final int OA;
    private boolean OC;
    private Context mContext;
    public TextView mTitle;

    public RichTextLayout(Context context) {
        super(context);
        this.OA = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
        this.OC = false;
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
        if (aVar != null && aVar.aAg() != null) {
            bj aAg = aVar.aAg();
            OriginalThreadInfo originalThreadInfo = aAg.cTR;
            if (originalThreadInfo != null && this.OC) {
                this.mTitle.setVisibility(8);
                this.KA.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                if (originalThreadInfo.cOL) {
                    au.a(this.KA, this.mTitle, new SpannableString(originalThreadInfo.title), aAg, this.OA, this.OC);
                    am.setViewTextColor(this.KA, (int) R.color.cp_cont_c);
                } else {
                    au.a(this.KA, this.mTitle, originalThreadInfo.cPM, aAg, this.OA, this.OC);
                }
            } else {
                au.a(this.mTitle, aAg);
                this.KA.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                au.a(this.KA, this.mTitle, aAg.aBQ(), aAg, this.OA, this.OC);
            }
            if (!this.OC) {
                this.KA.setClickable(false);
                this.mTitle.setClickable(false);
            } else if (originalThreadInfo != null && originalThreadInfo.cOL) {
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
        this.OC = z;
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
}
