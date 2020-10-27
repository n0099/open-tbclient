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
    private View.OnClickListener afJ;
    public TextView agm;
    private boolean aik;
    private final int akZ;
    private boolean alb;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;

    public RichTextLayout(Context context) {
        super(context);
        this.akZ = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
        this.alb = false;
        this.aik = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.richtext_normal_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.agm = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bhz() != null) {
            bw bhz = absThreadDataSupport.bhz();
            OriginalThreadInfo originalThreadInfo = bhz.eAy;
            if (originalThreadInfo != null && this.alb) {
                this.mTitle.setVisibility(8);
                this.agm.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds40));
                this.agm.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds15), 1.0f);
                if (originalThreadInfo.euX) {
                    ay.a(this.agm, this.mTitle, new SpannableString(originalThreadInfo.title), bhz, this.akZ, this.alb, this.aik);
                    ap.setViewTextColor(this.agm, R.color.cp_cont_c);
                } else {
                    ay.a(this.agm, this.mTitle, originalThreadInfo.evX, bhz, this.akZ, this.alb, this.aik);
                }
            } else {
                ay.a(this.mTitle, bhz, this.aik);
                this.agm.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds42));
                this.agm.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds7), 1.0f);
                ay.a(this.agm, this.mTitle, bhz.bjB(), bhz, this.akZ, this.alb, this.aik);
            }
            if (!this.alb) {
                this.agm.setClickable(false);
                this.mTitle.setClickable(false);
            } else if (originalThreadInfo != null && originalThreadInfo.euX) {
                setOnClickListener(null);
                setClickable(true);
            } else {
                setOnClickListener(this);
                this.agm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.afJ != null) {
                            RichTextLayout.this.afJ.onClick(view);
                        }
                    }
                });
                this.mTitle.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.afJ != null) {
                            RichTextLayout.this.afJ.onClick(view);
                        }
                    }
                });
                this.agm.setClickable(true);
                this.mTitle.setClickable(true);
            }
        }
    }

    public void setTransmit(boolean z) {
        this.alb = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.afJ != null) {
            this.afJ.onClick(view);
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.afJ = onClickListener;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setNeedFrsTabName(boolean z) {
        this.aik = z;
    }
}
