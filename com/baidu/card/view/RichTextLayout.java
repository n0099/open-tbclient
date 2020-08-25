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
    private View.OnClickListener aeX;
    public TextView afz;
    private boolean ahv;
    private final int akf;
    private boolean akh;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;

    public RichTextLayout(Context context) {
        super(context);
        this.akf = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
        this.akh = false;
        this.ahv = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.richtext_normal_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.afz = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bce() != null) {
            bw bce = absThreadDataSupport.bce();
            OriginalThreadInfo originalThreadInfo = bce.edE;
            if (originalThreadInfo != null && this.akh) {
                this.mTitle.setVisibility(8);
                this.afz.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds40));
                this.afz.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds15), 1.0f);
                if (originalThreadInfo.dYh) {
                    ay.a(this.afz, this.mTitle, new SpannableString(originalThreadInfo.title), bce, this.akf, this.akh, this.ahv);
                    ap.setViewTextColor(this.afz, R.color.cp_cont_c);
                } else {
                    ay.a(this.afz, this.mTitle, originalThreadInfo.dZh, bce, this.akf, this.akh, this.ahv);
                }
            } else {
                ay.a(this.mTitle, bce, this.ahv);
                this.afz.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds42));
                this.afz.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds7), 1.0f);
                ay.a(this.afz, this.mTitle, bce.bef(), bce, this.akf, this.akh, this.ahv);
            }
            if (!this.akh) {
                this.afz.setClickable(false);
                this.mTitle.setClickable(false);
            } else if (originalThreadInfo != null && originalThreadInfo.dYh) {
                setOnClickListener(null);
                setClickable(true);
            } else {
                setOnClickListener(this);
                this.afz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.aeX != null) {
                            RichTextLayout.this.aeX.onClick(view);
                        }
                    }
                });
                this.mTitle.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.aeX != null) {
                            RichTextLayout.this.aeX.onClick(view);
                        }
                    }
                });
                this.afz.setClickable(true);
                this.mTitle.setClickable(true);
            }
        }
    }

    public void setTransmit(boolean z) {
        this.akh = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aeX != null) {
            this.aeX.onClick(view);
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.aeX = onClickListener;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahv = z;
    }
}
