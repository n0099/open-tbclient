package com.baidu.card.view;

import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.card.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class RichTextLayout extends LinearLayout implements View.OnClickListener, n<AbsThreadDataSupport> {
    private View.OnClickListener adR;
    public TextView aeq;
    private boolean agn;
    private final int aiQ;
    private boolean aiS;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;

    public RichTextLayout(Context context) {
        super(context);
        this.aiQ = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
        this.aiS = false;
        this.agn = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.richtext_normal_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.aeq = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.aTN() != null) {
            bv aTN = absThreadDataSupport.aTN();
            OriginalThreadInfo originalThreadInfo = aTN.dUi;
            if (originalThreadInfo != null && this.aiS) {
                this.mTitle.setVisibility(8);
                this.aeq.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds40));
                this.aeq.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds15), 1.0f);
                if (originalThreadInfo.dOO) {
                    ax.a(this.aeq, this.mTitle, new SpannableString(originalThreadInfo.title), aTN, this.aiQ, this.aiS, this.agn);
                    ao.setViewTextColor(this.aeq, R.color.cp_cont_c);
                } else {
                    ax.a(this.aeq, this.mTitle, originalThreadInfo.dPO, aTN, this.aiQ, this.aiS, this.agn);
                }
            } else {
                ax.a(this.mTitle, aTN, this.agn);
                this.aeq.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds42));
                this.aeq.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds7), 1.0f);
                ax.a(this.aeq, this.mTitle, aTN.aVM(), aTN, this.aiQ, this.aiS, this.agn);
            }
            if (!this.aiS) {
                this.aeq.setClickable(false);
                this.mTitle.setClickable(false);
            } else if (originalThreadInfo != null && originalThreadInfo.dOO) {
                setOnClickListener(null);
                setClickable(true);
            } else {
                setOnClickListener(this);
                this.aeq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.adR != null) {
                            RichTextLayout.this.adR.onClick(view);
                        }
                    }
                });
                this.mTitle.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.adR != null) {
                            RichTextLayout.this.adR.onClick(view);
                        }
                    }
                });
                this.aeq.setClickable(true);
                this.mTitle.setClickable(true);
            }
        }
    }

    public void setTransmit(boolean z) {
        this.aiS = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.adR != null) {
            this.adR.onClick(view);
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.adR = onClickListener;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setNeedFrsTabName(boolean z) {
        this.agn = z;
    }
}
