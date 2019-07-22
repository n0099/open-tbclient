package com.baidu.tbadk.core.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class g implements j {
    private String amD;
    private k bNR;
    private View bNS;
    private int bNT;
    private int bNU;
    private k.b bNV;
    private boolean bNW;
    private int mId;
    private final View.OnClickListener mOnClickListener;
    private int mTextColor;
    public TextView mTextView;
    private View mView;

    public int getId() {
        return this.mId;
    }

    public g(k kVar) {
        this(null, kVar);
    }

    public g(String str, k kVar) {
        this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        this.bNT = R.color.cp_bg_line_d;
        this.bNU = 17;
        this.bNW = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.bNV != null) {
                    g.this.bNV.onClick();
                }
                if (g.this.bNR != null && g.this.bNR.aha() != null) {
                    g.this.bNR.aha().a(g.this.bNR, g.this.mId, g.this.mTextView);
                }
            }
        };
        this.amD = str;
        this.bNR = kVar;
        this.mId = hashCode();
        initView();
        initListener();
    }

    public g(int i, String str, k kVar) {
        this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        this.bNT = R.color.cp_bg_line_d;
        this.bNU = 17;
        this.bNW = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.bNV != null) {
                    g.this.bNV.onClick();
                }
                if (g.this.bNR != null && g.this.bNR.aha() != null) {
                    g.this.bNR.aha().a(g.this.bNR, g.this.mId, g.this.mTextView);
                }
            }
        };
        this.mId = i;
        this.amD = str;
        this.bNR = kVar;
        initView();
        initListener();
    }

    @Override // com.baidu.tbadk.core.dialog.j
    public View getView() {
        return this.mView;
    }

    public void setText(String str) {
        this.amD = str;
        this.mTextView.setText(this.amD);
    }

    public void a(k.b bVar) {
        this.bNV = bVar;
        initListener();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        am.j(this.mTextView, i);
    }

    @Override // com.baidu.tbadk.core.dialog.j
    public void onChangeSkinType() {
        am.k(this.mTextView, this.bNT);
        am.j(this.mTextView, this.mTextColor);
        am.l(this.bNS, R.color.cp_bg_line_c);
    }

    private void initView() {
        if (this.bNR != null && this.bNR.getContext() != null) {
            this.mView = LayoutInflater.from(this.bNR.getContext()).inflate(R.layout.popup_dialog_view_item, this.bNR.agZ(), false);
            this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
            this.mTextView.setText(this.amD);
            this.mTextView.setGravity(this.bNU);
            this.bNS = this.mView.findViewById(R.id.divider_line);
            if (this.bNW) {
                this.bNS.setVisibility(0);
            } else {
                this.bNS.setVisibility(8);
            }
            onChangeSkinType();
        }
    }

    private void initListener() {
        if (this.mTextView != null) {
            this.mTextView.setOnClickListener(this.mOnClickListener);
        }
    }
}
