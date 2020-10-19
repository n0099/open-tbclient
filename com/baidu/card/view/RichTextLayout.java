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
/* loaded from: classes21.dex */
public class RichTextLayout extends LinearLayout implements View.OnClickListener, p<AbsThreadDataSupport> {
    private View.OnClickListener afI;
    public TextView agl;
    private boolean aij;
    private final int akY;
    private boolean ala;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;

    public RichTextLayout(Context context) {
        super(context);
        this.akY = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
        this.ala = false;
        this.aij = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.richtext_normal_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.agl = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bfG() != null) {
            bw bfG = absThreadDataSupport.bfG();
            OriginalThreadInfo originalThreadInfo = bfG.erY;
            if (originalThreadInfo != null && this.ala) {
                this.mTitle.setVisibility(8);
                this.agl.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds40));
                this.agl.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds15), 1.0f);
                if (originalThreadInfo.emx) {
                    ay.a(this.agl, this.mTitle, new SpannableString(originalThreadInfo.title), bfG, this.akY, this.ala, this.aij);
                    ap.setViewTextColor(this.agl, R.color.cp_cont_c);
                } else {
                    ay.a(this.agl, this.mTitle, originalThreadInfo.enz, bfG, this.akY, this.ala, this.aij);
                }
            } else {
                ay.a(this.mTitle, bfG, this.aij);
                this.agl.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds42));
                this.agl.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds7), 1.0f);
                ay.a(this.agl, this.mTitle, bfG.bhI(), bfG, this.akY, this.ala, this.aij);
            }
            if (!this.ala) {
                this.agl.setClickable(false);
                this.mTitle.setClickable(false);
            } else if (originalThreadInfo != null && originalThreadInfo.emx) {
                setOnClickListener(null);
                setClickable(true);
            } else {
                setOnClickListener(this);
                this.agl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.afI != null) {
                            RichTextLayout.this.afI.onClick(view);
                        }
                    }
                });
                this.mTitle.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.afI != null) {
                            RichTextLayout.this.afI.onClick(view);
                        }
                    }
                });
                this.agl.setClickable(true);
                this.mTitle.setClickable(true);
            }
        }
    }

    public void setTransmit(boolean z) {
        this.ala = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.afI != null) {
            this.afI.onClick(view);
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.afI = onClickListener;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setNeedFrsTabName(boolean z) {
        this.aij = z;
    }
}
