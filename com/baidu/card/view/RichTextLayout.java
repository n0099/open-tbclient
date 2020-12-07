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
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class RichTextLayout extends LinearLayout implements View.OnClickListener, p<com.baidu.tbadk.core.data.a> {
    private View.OnClickListener agK;
    public TextView ahp;
    private boolean ajm;
    private final int ame;
    private boolean amg;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;

    public RichTextLayout(Context context) {
        super(context);
        this.ame = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (d.bkA() ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007) * 2 : (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
        this.amg = false;
        this.ajm = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.richtext_normal_layout, (ViewGroup) this, true);
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ahp = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.bmn() != null) {
            by bmn = aVar.bmn();
            OriginalThreadInfo originalThreadInfo = bmn.eLH;
            if (originalThreadInfo != null && this.amg) {
                this.mTitle.setVisibility(8);
                c.bm(this.ahp).pu(R.string.F_X01).pt(R.dimen.T_X07);
                if (originalThreadInfo.eGg) {
                    az.a(this.ahp, this.mTitle, new SpannableString(originalThreadInfo.title), bmn, this.ame, this.amg, this.ajm);
                    ap.setViewTextColor(this.ahp, R.color.CAM_X0108);
                } else {
                    az.a(this.ahp, this.mTitle, originalThreadInfo.eHg, bmn, this.ame, this.amg, this.ajm);
                }
            } else {
                az.a(this.mTitle, bmn, this.ajm);
                az.a(this.ahp, this.mTitle, bmn.boq(), bmn, this.ame, this.amg, this.ajm);
            }
            if (!this.amg) {
                this.ahp.setClickable(false);
                this.mTitle.setClickable(false);
            } else if (originalThreadInfo != null && originalThreadInfo.eGg) {
                setOnClickListener(null);
                setClickable(true);
            } else {
                setOnClickListener(this);
                this.ahp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.agK != null) {
                            RichTextLayout.this.agK.onClick(view);
                        }
                    }
                });
                this.mTitle.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.agK != null) {
                            RichTextLayout.this.agK.onClick(view);
                        }
                    }
                });
                this.ahp.setClickable(true);
                this.mTitle.setClickable(true);
            }
        }
    }

    public void setTransmit(boolean z) {
        this.amg = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.agK != null) {
            this.agK.onClick(view);
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.agK = onClickListener;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setNeedFrsTabName(boolean z) {
        this.ajm = z;
    }
}
