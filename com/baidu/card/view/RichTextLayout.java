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
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class RichTextLayout extends LinearLayout implements View.OnClickListener, p<com.baidu.tbadk.core.data.a> {
    private boolean agD;
    public TextView agY;
    private View.OnClickListener agk;
    private final int alF;
    private boolean alH;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;

    public RichTextLayout(Context context) {
        super(context);
        this.alF = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
        this.alH = false;
        this.agD = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.richtext_normal_layout, (ViewGroup) this, true);
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.agY = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.bln() != null) {
            cb bln = aVar.bln();
            OriginalThreadInfo originalThreadInfo = bln.eTc;
            if (originalThreadInfo != null && this.alH) {
                this.mTitle.setVisibility(8);
                c.br(this.agY).oa(R.string.F_X01).nZ(R.dimen.T_X07);
                if (originalThreadInfo.eNx) {
                    az.a(this.agY, this.mTitle, new SpannableString(originalThreadInfo.title), bln, this.alF, this.alH, this.agD);
                    ap.setViewTextColor(this.agY, R.color.CAM_X0108);
                } else {
                    az.a(this.agY, this.mTitle, originalThreadInfo.eOy, bln, this.alF, this.alH, this.agD);
                }
            } else {
                az.a(this.mTitle, bln, this.agD);
                az.a(this.agY, this.mTitle, bln.bnr(), bln, this.alF, this.alH, this.agD);
            }
            if (!this.alH) {
                this.agY.setClickable(false);
                this.mTitle.setClickable(false);
            } else if (originalThreadInfo != null && originalThreadInfo.eNx) {
                setOnClickListener(null);
                setClickable(true);
            } else {
                setOnClickListener(this);
                this.agY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.agk != null) {
                            RichTextLayout.this.agk.onClick(view);
                        }
                    }
                });
                this.mTitle.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.agk != null) {
                            RichTextLayout.this.agk.onClick(view);
                        }
                    }
                });
                this.agY.setClickable(true);
                this.mTitle.setClickable(true);
            }
        }
    }

    public void setTransmit(boolean z) {
        this.alH = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.agk != null) {
            this.agk.onClick(view);
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.agk = onClickListener;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setNeedFrsTabName(boolean z) {
        this.agD = z;
    }
}
