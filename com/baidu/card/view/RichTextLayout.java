package com.baidu.card.view;

import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.card.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class RichTextLayout extends LinearLayout implements View.OnClickListener, m<com.baidu.tbadk.core.data.a> {
    private View.OnClickListener adb;
    public TextView ady;
    private boolean afl;
    private final int ahg;
    private boolean ahi;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;

    public RichTextLayout(Context context) {
        super(context);
        this.ahg = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
        this.ahi = false;
        this.afl = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.richtext_normal_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ady = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.aIw() != null) {
            bj aIw = aVar.aIw();
            OriginalThreadInfo originalThreadInfo = aIw.dto;
            if (originalThreadInfo != null && this.ahi) {
                this.mTitle.setVisibility(8);
                this.ady.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                if (originalThreadInfo.doe) {
                    au.a(this.ady, this.mTitle, new SpannableString(originalThreadInfo.title), aIw, this.ahg, this.ahi, this.afl);
                    am.setViewTextColor(this.ady, (int) R.color.cp_cont_c);
                } else {
                    au.a(this.ady, this.mTitle, originalThreadInfo.dpf, aIw, this.ahg, this.ahi, this.afl);
                }
            } else {
                au.a(this.mTitle, aIw, this.afl);
                this.ady.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                au.a(this.ady, this.mTitle, aIw.aKg(), aIw, this.ahg, this.ahi, this.afl);
            }
            if (!this.ahi) {
                this.ady.setClickable(false);
                this.mTitle.setClickable(false);
            } else if (originalThreadInfo != null && originalThreadInfo.doe) {
                setOnClickListener(null);
                setClickable(true);
            } else {
                setOnClickListener(this);
                this.ady.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.adb != null) {
                            RichTextLayout.this.adb.onClick(view);
                        }
                    }
                });
                this.mTitle.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.adb != null) {
                            RichTextLayout.this.adb.onClick(view);
                        }
                    }
                });
                this.ady.setClickable(true);
                this.mTitle.setClickable(true);
            }
        }
    }

    public void setTransmit(boolean z) {
        this.ahi = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.adb != null) {
            this.adb.onClick(view);
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.adb = onClickListener;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setNeedFrsTabName(boolean z) {
        this.afl = z;
    }
}
