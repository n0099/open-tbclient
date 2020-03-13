package com.baidu.tbadk.core.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class g implements j {
    private k cVu;
    private View cVv;
    private int cVw;
    private int cVx;
    private k.b cVy;
    private boolean cVz;
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
        this.cVw = R.color.cp_bg_line_k;
        this.cVx = 17;
        this.cVz = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.cVy != null) {
                    g.this.cVy.onClick();
                }
                if (g.this.cVu != null && g.this.cVu.aEQ() != null) {
                    g.this.cVu.aEQ().a(g.this.cVu, g.this.mId, g.this.mTextView);
                }
            }
        };
        this.mText = str;
        this.cVu = kVar;
        this.mId = hashCode();
        initView();
        initListener();
    }

    public g(int i, String str, k kVar) {
        this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        this.cVw = R.color.cp_bg_line_k;
        this.cVx = 17;
        this.cVz = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.cVy != null) {
                    g.this.cVy.onClick();
                }
                if (g.this.cVu != null && g.this.cVu.aEQ() != null) {
                    g.this.cVu.aEQ().a(g.this.cVu, g.this.mId, g.this.mTextView);
                }
            }
        };
        this.mId = i;
        this.mText = str;
        this.cVu = kVar;
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
        this.cVy = bVar;
        initListener();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        am.setViewTextColor(this.mTextView, i);
    }

    @Override // com.baidu.tbadk.core.dialog.j
    public void onChangeSkinType() {
        am.setBackgroundResource(this.mTextView, this.cVw);
        am.setViewTextColor(this.mTextView, this.mTextColor);
        am.setBackgroundColor(this.cVv, R.color.cp_bg_line_c);
    }

    private void initView() {
        if (this.cVu != null && this.cVu.getContext() != null) {
            this.mView = LayoutInflater.from(this.cVu.getContext()).inflate(R.layout.popup_dialog_view_item, this.cVu.getView(), false);
            this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
            this.mTextView.setText(this.mText);
            this.mTextView.setGravity(this.cVx);
            this.cVv = this.mView.findViewById(R.id.divider_line);
            if (this.cVz) {
                this.cVv.setVisibility(0);
            } else {
                this.cVv.setVisibility(8);
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
