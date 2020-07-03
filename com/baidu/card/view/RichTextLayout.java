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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class RichTextLayout extends LinearLayout implements View.OnClickListener, n<AbsThreadDataSupport> {
    public TextView aeA;
    private View.OnClickListener aeb;
    private boolean agw;
    private final int aiW;
    private boolean aiY;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;

    public RichTextLayout(Context context) {
        super(context);
        this.aiW = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
        this.aiY = false;
        this.agw = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.richtext_normal_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.aeA = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.aPS() != null) {
            bu aPS = absThreadDataSupport.aPS();
            OriginalThreadInfo originalThreadInfo = aPS.dNX;
            if (originalThreadInfo != null && this.aiY) {
                this.mTitle.setVisibility(8);
                this.aeA.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                if (originalThreadInfo.dID) {
                    aw.a(this.aeA, this.mTitle, new SpannableString(originalThreadInfo.title), aPS, this.aiW, this.aiY, this.agw);
                    an.setViewTextColor(this.aeA, (int) R.color.cp_cont_c);
                } else {
                    aw.a(this.aeA, this.mTitle, originalThreadInfo.dJC, aPS, this.aiW, this.aiY, this.agw);
                }
            } else {
                aw.a(this.mTitle, aPS, this.agw);
                this.aeA.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                aw.a(this.aeA, this.mTitle, aPS.aRQ(), aPS, this.aiW, this.aiY, this.agw);
            }
            if (!this.aiY) {
                this.aeA.setClickable(false);
                this.mTitle.setClickable(false);
            } else if (originalThreadInfo != null && originalThreadInfo.dID) {
                setOnClickListener(null);
                setClickable(true);
            } else {
                setOnClickListener(this);
                this.aeA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.aeb != null) {
                            RichTextLayout.this.aeb.onClick(view);
                        }
                    }
                });
                this.mTitle.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.aeb != null) {
                            RichTextLayout.this.aeb.onClick(view);
                        }
                    }
                });
                this.aeA.setClickable(true);
                this.mTitle.setClickable(true);
            }
        }
    }

    public void setTransmit(boolean z) {
        this.aiY = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aeb != null) {
            this.aeb.onClick(view);
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.aeb = onClickListener;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setNeedFrsTabName(boolean z) {
        this.agw = z;
    }
}
