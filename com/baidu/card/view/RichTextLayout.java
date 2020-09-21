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
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class RichTextLayout extends LinearLayout implements View.OnClickListener, p<AbsThreadDataSupport> {
    public TextView afT;
    private View.OnClickListener afr;
    private boolean ahR;
    private final int akG;
    private boolean akI;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;

    public RichTextLayout(Context context) {
        super(context);
        this.akG = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
        this.akI = false;
        this.ahR = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.richtext_normal_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.afT = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void G(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bcY() != null) {
            bw bcY = absThreadDataSupport.bcY();
            OriginalThreadInfo originalThreadInfo = bcY.efS;
            if (originalThreadInfo != null && this.akI) {
                this.mTitle.setVisibility(8);
                this.afT.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds40));
                this.afT.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds15), 1.0f);
                if (originalThreadInfo.eav) {
                    ay.a(this.afT, this.mTitle, new SpannableString(originalThreadInfo.title), bcY, this.akG, this.akI, this.ahR);
                    ap.setViewTextColor(this.afT, R.color.cp_cont_c);
                } else {
                    ay.a(this.afT, this.mTitle, originalThreadInfo.ebv, bcY, this.akG, this.akI, this.ahR);
                }
            } else {
                ay.a(this.mTitle, bcY, this.ahR);
                this.afT.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds42));
                this.afT.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds7), 1.0f);
                ay.a(this.afT, this.mTitle, bcY.beZ(), bcY, this.akG, this.akI, this.ahR);
            }
            if (!this.akI) {
                this.afT.setClickable(false);
                this.mTitle.setClickable(false);
            } else if (originalThreadInfo != null && originalThreadInfo.eav) {
                setOnClickListener(null);
                setClickable(true);
            } else {
                setOnClickListener(this);
                this.afT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.afr != null) {
                            RichTextLayout.this.afr.onClick(view);
                        }
                    }
                });
                this.mTitle.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.afr != null) {
                            RichTextLayout.this.afr.onClick(view);
                        }
                    }
                });
                this.afT.setClickable(true);
                this.mTitle.setClickable(true);
            }
        }
    }

    public void setTransmit(boolean z) {
        this.akI = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.afr != null) {
            this.afr.onClick(view);
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.afr = onClickListener;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahR = z;
    }
}
