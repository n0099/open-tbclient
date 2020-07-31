package com.baidu.tbadk.core.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class g implements j {
    private k dVZ;
    private View dWa;
    private int dWb;
    private int dWc;
    private k.b dWd;
    private boolean dWe;
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
        this.dWb = R.color.cp_bg_line_k;
        this.dWc = 17;
        this.dWe = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.dWd != null) {
                    g.this.dWd.onClick();
                }
                if (g.this.dVZ != null && g.this.dVZ.aZa() != null) {
                    g.this.dVZ.aZa().a(g.this.dVZ, g.this.mId, g.this.mTextView);
                }
            }
        };
        this.mText = str;
        this.dVZ = kVar;
        this.mId = hashCode();
        initView();
        initListener();
    }

    public g(int i, String str, k kVar) {
        this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        this.dWb = R.color.cp_bg_line_k;
        this.dWc = 17;
        this.dWe = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.dWd != null) {
                    g.this.dWd.onClick();
                }
                if (g.this.dVZ != null && g.this.dVZ.aZa() != null) {
                    g.this.dVZ.aZa().a(g.this.dVZ, g.this.mId, g.this.mTextView);
                }
            }
        };
        this.mId = i;
        this.mText = str;
        this.dVZ = kVar;
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
        this.dWd = bVar;
        initListener();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        ao.setViewTextColor(this.mTextView, i);
    }

    @Override // com.baidu.tbadk.core.dialog.j
    public void onChangeSkinType() {
        ao.setBackgroundResource(this.mTextView, this.dWb);
        ao.setViewTextColor(this.mTextView, this.mTextColor);
        ao.setBackgroundColor(this.dWa, R.color.cp_bg_line_c);
    }

    private void initView() {
        if (this.dVZ != null && this.dVZ.getContext() != null) {
            this.mView = LayoutInflater.from(this.dVZ.getContext()).inflate(R.layout.popup_dialog_view_item, this.dVZ.getView(), false);
            this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
            this.mTextView.setText(this.mText);
            this.mTextView.setGravity(this.dWc);
            this.dWa = this.mView.findViewById(R.id.divider_line);
            if (this.dWe) {
                this.dWa.setVisibility(0);
            } else {
                this.dWa.setVisibility(8);
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
