package com.baidu.tbadk.core.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class g implements j {
    private View efA;
    private int efB;
    private int efC;
    private k.b efD;
    private boolean efE;
    private k efz;
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
        this.efB = R.color.cp_bg_line_k;
        this.efC = 17;
        this.efE = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.efD != null) {
                    g.this.efD.onClick();
                }
                if (g.this.efz != null && g.this.efz.bhv() != null) {
                    g.this.efz.bhv().a(g.this.efz, g.this.mId, g.this.mTextView);
                }
            }
        };
        this.mText = str;
        this.efz = kVar;
        this.mId = hashCode();
        initView();
        initListener();
    }

    public g(int i, String str, k kVar) {
        this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        this.efB = R.color.cp_bg_line_k;
        this.efC = 17;
        this.efE = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.efD != null) {
                    g.this.efD.onClick();
                }
                if (g.this.efz != null && g.this.efz.bhv() != null) {
                    g.this.efz.bhv().a(g.this.efz, g.this.mId, g.this.mTextView);
                }
            }
        };
        this.mId = i;
        this.mText = str;
        this.efz = kVar;
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
        this.efD = bVar;
        initListener();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        ap.setViewTextColor(this.mTextView, i);
    }

    @Override // com.baidu.tbadk.core.dialog.j
    public void onChangeSkinType() {
        ap.setBackgroundResource(this.mTextView, this.efB);
        ap.setViewTextColor(this.mTextView, this.mTextColor);
        ap.setBackgroundColor(this.efA, R.color.cp_bg_line_c);
    }

    private void initView() {
        if (this.efz != null && this.efz.getContext() != null) {
            this.mView = LayoutInflater.from(this.efz.getContext()).inflate(R.layout.popup_dialog_view_item, this.efz.getView(), false);
            this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
            this.mTextView.setText(this.mText);
            this.mTextView.setGravity(this.efC);
            this.efA = this.mView.findViewById(R.id.divider_line);
            if (this.efE) {
                this.efA.setVisibility(0);
            } else {
                this.efA.setVisibility(8);
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
