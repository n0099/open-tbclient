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
import com.baidu.tbadk.core.data.a;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class RichTextLayout extends LinearLayout implements View.OnClickListener, m<a> {
    private View.OnClickListener JI;
    public TextView Kf;
    private final int NZ;
    private boolean Ob;
    private Context mContext;
    public TextView mTitle;

    public RichTextLayout(Context context) {
        super(context);
        this.NZ = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
        this.Ob = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.richtext_normal_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.Kf = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(a aVar) {
        if (aVar != null && aVar.axQ() != null) {
            bj axQ = aVar.axQ();
            OriginalThreadInfo originalThreadInfo = axQ.cPN;
            if (originalThreadInfo != null && this.Ob) {
                this.mTitle.setVisibility(8);
                this.Kf.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                if (originalThreadInfo.cKG) {
                    au.a(this.Kf, this.mTitle, new SpannableString(originalThreadInfo.title), axQ, this.NZ, this.Ob);
                    am.setViewTextColor(this.Kf, (int) R.color.cp_cont_c);
                } else {
                    au.a(this.Kf, this.mTitle, originalThreadInfo.cLH, axQ, this.NZ, this.Ob);
                }
            } else {
                au.a(this.mTitle, axQ);
                this.Kf.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                au.a(this.Kf, this.mTitle, axQ.azy(), axQ, this.NZ, this.Ob);
            }
            if (!this.Ob) {
                this.Kf.setClickable(false);
                this.mTitle.setClickable(false);
            } else if (originalThreadInfo != null && originalThreadInfo.cKG) {
                setOnClickListener(null);
                setClickable(true);
            } else {
                setOnClickListener(this);
                this.Kf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.JI != null) {
                            RichTextLayout.this.JI.onClick(view);
                        }
                    }
                });
                this.mTitle.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.JI != null) {
                            RichTextLayout.this.JI.onClick(view);
                        }
                    }
                });
                this.Kf.setClickable(true);
                this.mTitle.setClickable(true);
            }
        }
    }

    public void setTransmit(boolean z) {
        this.Ob = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.JI != null) {
            this.JI.onClick(view);
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.JI = onClickListener;
    }
}
