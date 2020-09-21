package com.baidu.tbadk.core.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class g implements j {
    private k ehS;
    private View ehT;
    private int ehU;
    private int ehV;
    private k.b ehW;
    private boolean ehX;
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
        this.ehU = R.color.cp_bg_line_k;
        this.ehV = 17;
        this.ehX = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.ehW != null) {
                    g.this.ehW.onClick();
                }
                if (g.this.ehS != null && g.this.ehS.bip() != null) {
                    g.this.ehS.bip().a(g.this.ehS, g.this.mId, g.this.mTextView);
                }
            }
        };
        this.mText = str;
        this.ehS = kVar;
        this.mId = hashCode();
        initView();
        initListener();
    }

    public g(int i, String str, k kVar) {
        this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        this.ehU = R.color.cp_bg_line_k;
        this.ehV = 17;
        this.ehX = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.ehW != null) {
                    g.this.ehW.onClick();
                }
                if (g.this.ehS != null && g.this.ehS.bip() != null) {
                    g.this.ehS.bip().a(g.this.ehS, g.this.mId, g.this.mTextView);
                }
            }
        };
        this.mId = i;
        this.mText = str;
        this.ehS = kVar;
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
        this.ehW = bVar;
        initListener();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        ap.setViewTextColor(this.mTextView, i);
    }

    @Override // com.baidu.tbadk.core.dialog.j
    public void onChangeSkinType() {
        ap.setBackgroundResource(this.mTextView, this.ehU);
        ap.setViewTextColor(this.mTextView, this.mTextColor);
        ap.setBackgroundColor(this.ehT, R.color.cp_bg_line_c);
    }

    private void initView() {
        if (this.ehS != null && this.ehS.getContext() != null) {
            this.mView = LayoutInflater.from(this.ehS.getContext()).inflate(R.layout.popup_dialog_view_item, this.ehS.getView(), false);
            this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
            this.mTextView.setText(this.mText);
            this.mTextView.setGravity(this.ehV);
            this.ehT = this.mView.findViewById(R.id.divider_line);
            if (this.ehX) {
                this.ehT.setVisibility(0);
            } else {
                this.ehT.setVisibility(8);
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
