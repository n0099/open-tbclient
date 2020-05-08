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
    public TextView adB;
    private View.OnClickListener adf;
    private boolean afo;
    private final int ahj;
    private boolean ahl;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;

    public RichTextLayout(Context context) {
        super(context);
        this.ahj = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
        this.ahl = false;
        this.afo = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.richtext_normal_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.adB = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void B(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.aIu() != null) {
            bj aIu = aVar.aIu();
            OriginalThreadInfo originalThreadInfo = aIu.dtt;
            if (originalThreadInfo != null && this.ahl) {
                this.mTitle.setVisibility(8);
                this.adB.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                if (originalThreadInfo.doi) {
                    au.a(this.adB, this.mTitle, new SpannableString(originalThreadInfo.title), aIu, this.ahj, this.ahl, this.afo);
                    am.setViewTextColor(this.adB, (int) R.color.cp_cont_c);
                } else {
                    au.a(this.adB, this.mTitle, originalThreadInfo.dpj, aIu, this.ahj, this.ahl, this.afo);
                }
            } else {
                au.a(this.mTitle, aIu, this.afo);
                this.adB.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                au.a(this.adB, this.mTitle, aIu.aKe(), aIu, this.ahj, this.ahl, this.afo);
            }
            if (!this.ahl) {
                this.adB.setClickable(false);
                this.mTitle.setClickable(false);
            } else if (originalThreadInfo != null && originalThreadInfo.doi) {
                setOnClickListener(null);
                setClickable(true);
            } else {
                setOnClickListener(this);
                this.adB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.adf != null) {
                            RichTextLayout.this.adf.onClick(view);
                        }
                    }
                });
                this.mTitle.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.adf != null) {
                            RichTextLayout.this.adf.onClick(view);
                        }
                    }
                });
                this.adB.setClickable(true);
                this.mTitle.setClickable(true);
            }
        }
    }

    public void setTransmit(boolean z) {
        this.ahl = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.adf != null) {
            this.adf.onClick(view);
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.adf = onClickListener;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setNeedFrsTabName(boolean z) {
        this.afo = z;
    }
}
