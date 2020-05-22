package com.baidu.tbadk.core.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class g implements j {
    private k dIR;
    private View dIS;
    private int dIT;
    private int dIU;
    private k.b dIV;
    private boolean dIW;
    private int mId;
    private final View.OnClickListener mOnClickListener;
    private String mText;
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
        this.dIT = R.color.cp_bg_line_k;
        this.dIU = 17;
        this.dIW = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.dIV != null) {
                    g.this.dIV.onClick();
                }
                if (g.this.dIR != null && g.this.dIR.aTg() != null) {
                    g.this.dIR.aTg().a(g.this.dIR, g.this.mId, g.this.mTextView);
                }
            }
        };
        this.mText = str;
        this.dIR = kVar;
        this.mId = hashCode();
        initView();
        initListener();
    }

    public g(int i, String str, k kVar) {
        this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        this.dIT = R.color.cp_bg_line_k;
        this.dIU = 17;
        this.dIW = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.dIV != null) {
                    g.this.dIV.onClick();
                }
                if (g.this.dIR != null && g.this.dIR.aTg() != null) {
                    g.this.dIR.aTg().a(g.this.dIR, g.this.mId, g.this.mTextView);
                }
            }
        };
        this.mId = i;
        this.mText = str;
        this.dIR = kVar;
        initView();
        initListener();
    }

    @Override // com.baidu.tbadk.core.dialog.j
    public View getView() {
        return this.mView;
    }

    public void setText(String str) {
        this.mText = str;
        this.mTextView.setText(this.mText);
    }

    public void a(k.b bVar) {
        this.dIV = bVar;
        initListener();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        am.setViewTextColor(this.mTextView, i);
    }

    @Override // com.baidu.tbadk.core.dialog.j
    public void onChangeSkinType() {
        am.setBackgroundResource(this.mTextView, this.dIT);
        am.setViewTextColor(this.mTextView, this.mTextColor);
        am.setBackgroundColor(this.dIS, R.color.cp_bg_line_c);
    }

    private void initView() {
        if (this.dIR != null && this.dIR.getContext() != null) {
            this.mView = LayoutInflater.from(this.dIR.getContext()).inflate(R.layout.popup_dialog_view_item, this.dIR.getView(), false);
            this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
            this.mTextView.setText(this.mText);
            this.mTextView.setGravity(this.dIU);
            this.dIS = this.mView.findViewById(R.id.divider_line);
            if (this.dIW) {
                this.dIS.setVisibility(0);
            } else {
                this.dIS.setVisibility(8);
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
