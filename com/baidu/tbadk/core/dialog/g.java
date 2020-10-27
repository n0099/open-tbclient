package com.baidu.tbadk.core.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class g implements j {
    private View eCA;
    private int eCB;
    private int eCC;
    private k.b eCD;
    private boolean eCE;
    private k eCz;
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
        this.eCB = R.color.cp_bg_line_k;
        this.eCC = 17;
        this.eCE = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.eCD != null) {
                    g.this.eCD.onClick();
                }
                if (g.this.eCz != null && g.this.eCz.bmR() != null) {
                    g.this.eCz.bmR().a(g.this.eCz, g.this.mId, g.this.mTextView);
                }
            }
        };
        this.mText = str;
        this.eCz = kVar;
        this.mId = hashCode();
        initView();
        initListener();
    }

    public g(int i, String str, k kVar) {
        this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        this.eCB = R.color.cp_bg_line_k;
        this.eCC = 17;
        this.eCE = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.eCD != null) {
                    g.this.eCD.onClick();
                }
                if (g.this.eCz != null && g.this.eCz.bmR() != null) {
                    g.this.eCz.bmR().a(g.this.eCz, g.this.mId, g.this.mTextView);
                }
            }
        };
        this.mId = i;
        this.mText = str;
        this.eCz = kVar;
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
        this.eCD = bVar;
        initListener();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        ap.setViewTextColor(this.mTextView, i);
    }

    @Override // com.baidu.tbadk.core.dialog.j
    public void onChangeSkinType() {
        ap.setBackgroundResource(this.mTextView, this.eCB);
        ap.setViewTextColor(this.mTextView, this.mTextColor);
        ap.setBackgroundColor(this.eCA, R.color.cp_bg_line_c);
    }

    private void initView() {
        if (this.eCz != null && this.eCz.getContext() != null) {
            this.mView = LayoutInflater.from(this.eCz.getContext()).inflate(R.layout.popup_dialog_view_item, this.eCz.getView(), false);
            this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
            this.mTextView.setText(this.mText);
            this.mTextView.setGravity(this.eCC);
            this.eCA = this.mView.findViewById(R.id.divider_line);
            if (this.eCE) {
                this.eCA.setVisibility(0);
            } else {
                this.eCA.setVisibility(8);
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
