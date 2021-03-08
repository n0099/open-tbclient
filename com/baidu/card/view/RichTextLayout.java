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
    private View.OnClickListener ahC;
    private boolean ahV;
    public TextView air;
    private final int amX;
    private boolean amZ;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;

    public RichTextLayout(Context context) {
        super(context);
        this.amX = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
        this.amZ = false;
        this.ahV = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.richtext_normal_layout, (ViewGroup) this, true);
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.air = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void E(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.blp() != null) {
            cb blp = aVar.blp();
            OriginalThreadInfo originalThreadInfo = blp.eUD;
            if (originalThreadInfo != null && this.amZ) {
                this.mTitle.setVisibility(8);
                c.br(this.air).ob(R.string.F_X01).oa(R.dimen.T_X07);
                if (originalThreadInfo.eOY) {
                    az.a(this.air, this.mTitle, new SpannableString(originalThreadInfo.title), blp, this.amX, this.amZ, this.ahV);
                    ap.setViewTextColor(this.air, R.color.CAM_X0108);
                } else {
                    az.a(this.air, this.mTitle, originalThreadInfo.ePZ, blp, this.amX, this.amZ, this.ahV);
                }
            } else {
                az.a(this.mTitle, blp, this.ahV);
                az.a(this.air, this.mTitle, blp.bnt(), blp, this.amX, this.amZ, this.ahV);
            }
            if (!this.amZ) {
                this.air.setClickable(false);
                this.mTitle.setClickable(false);
            } else if (originalThreadInfo != null && originalThreadInfo.eOY) {
                setOnClickListener(null);
                setClickable(true);
            } else {
                setOnClickListener(this);
                this.air.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.ahC != null) {
                            RichTextLayout.this.ahC.onClick(view);
                        }
                    }
                });
                this.mTitle.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.ahC != null) {
                            RichTextLayout.this.ahC.onClick(view);
                        }
                    }
                });
                this.air.setClickable(true);
                this.mTitle.setClickable(true);
            }
        }
    }

    public void setTransmit(boolean z) {
        this.amZ = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ahC != null) {
            this.ahC.onClick(view);
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.ahC = onClickListener;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahV = z;
    }
}
