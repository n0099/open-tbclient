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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class RichTextLayout extends LinearLayout implements View.OnClickListener, n<AbsThreadDataSupport> {
    public TextView adV;
    private View.OnClickListener adx;
    private boolean afL;
    private final int ahM;
    private boolean ahO;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;

    public RichTextLayout(Context context) {
        super(context);
        this.ahM = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
        this.ahO = false;
        this.afL = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.richtext_normal_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.adV = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.aOi() != null) {
            bk aOi = absThreadDataSupport.aOi();
            OriginalThreadInfo originalThreadInfo = aOi.dHm;
            if (originalThreadInfo != null && this.ahO) {
                this.mTitle.setVisibility(8);
                this.adV.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                if (originalThreadInfo.dCi) {
                    au.a(this.adV, this.mTitle, new SpannableString(originalThreadInfo.title), aOi, this.ahM, this.ahO, this.afL);
                    am.setViewTextColor(this.adV, (int) R.color.cp_cont_c);
                } else {
                    au.a(this.adV, this.mTitle, originalThreadInfo.dDh, aOi, this.ahM, this.ahO, this.afL);
                }
            } else {
                au.a(this.mTitle, aOi, this.afL);
                this.adV.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                au.a(this.adV, this.mTitle, aOi.aPZ(), aOi, this.ahM, this.ahO, this.afL);
            }
            if (!this.ahO) {
                this.adV.setClickable(false);
                this.mTitle.setClickable(false);
            } else if (originalThreadInfo != null && originalThreadInfo.dCi) {
                setOnClickListener(null);
                setClickable(true);
            } else {
                setOnClickListener(this);
                this.adV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.adx != null) {
                            RichTextLayout.this.adx.onClick(view);
                        }
                    }
                });
                this.mTitle.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.adx != null) {
                            RichTextLayout.this.adx.onClick(view);
                        }
                    }
                });
                this.adV.setClickable(true);
                this.mTitle.setClickable(true);
            }
        }
    }

    public void setTransmit(boolean z) {
        this.ahO = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.adx != null) {
            this.adx.onClick(view);
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.adx = onClickListener;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setNeedFrsTabName(boolean z) {
        this.afL = z;
    }
}
