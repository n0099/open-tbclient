package com.baidu.card.view;

import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.card.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class RichTextLayout extends LinearLayout implements View.OnClickListener, o<AbsThreadDataSupport> {
    private View.OnClickListener aeZ;
    public TextView afB;
    private boolean ahx;
    private final int akh;
    private boolean akj;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;

    public RichTextLayout(Context context) {
        super(context);
        this.akh = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
        this.akj = false;
        this.ahx = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.richtext_normal_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.afB = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bce() != null) {
            bw bce = absThreadDataSupport.bce();
            OriginalThreadInfo originalThreadInfo = bce.edI;
            if (originalThreadInfo != null && this.akj) {
                this.mTitle.setVisibility(8);
                this.afB.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds40));
                this.afB.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds15), 1.0f);
                if (originalThreadInfo.dYl) {
                    ay.a(this.afB, this.mTitle, new SpannableString(originalThreadInfo.title), bce, this.akh, this.akj, this.ahx);
                    ap.setViewTextColor(this.afB, R.color.cp_cont_c);
                } else {
                    ay.a(this.afB, this.mTitle, originalThreadInfo.dZl, bce, this.akh, this.akj, this.ahx);
                }
            } else {
                ay.a(this.mTitle, bce, this.ahx);
                this.afB.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds42));
                this.afB.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds7), 1.0f);
                ay.a(this.afB, this.mTitle, bce.bef(), bce, this.akh, this.akj, this.ahx);
            }
            if (!this.akj) {
                this.afB.setClickable(false);
                this.mTitle.setClickable(false);
            } else if (originalThreadInfo != null && originalThreadInfo.dYl) {
                setOnClickListener(null);
                setClickable(true);
            } else {
                setOnClickListener(this);
                this.afB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.aeZ != null) {
                            RichTextLayout.this.aeZ.onClick(view);
                        }
                    }
                });
                this.mTitle.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.aeZ != null) {
                            RichTextLayout.this.aeZ.onClick(view);
                        }
                    }
                });
                this.afB.setClickable(true);
                this.mTitle.setClickable(true);
            }
        }
    }

    public void setTransmit(boolean z) {
        this.akj = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aeZ != null) {
            this.aeZ.onClick(view);
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.aeZ = onClickListener;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahx = z;
    }
}
