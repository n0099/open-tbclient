package com.baidu.tbadk.core.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class g implements j {
    private k efD;
    private View efE;
    private int efF;
    private int efG;
    private k.b efH;
    private boolean efI;
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
        this.efF = R.color.cp_bg_line_k;
        this.efG = 17;
        this.efI = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.efH != null) {
                    g.this.efH.onClick();
                }
                if (g.this.efD != null && g.this.efD.bhv() != null) {
                    g.this.efD.bhv().a(g.this.efD, g.this.mId, g.this.mTextView);
                }
            }
        };
        this.mText = str;
        this.efD = kVar;
        this.mId = hashCode();
        initView();
        initListener();
    }

    public g(int i, String str, k kVar) {
        this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        this.efF = R.color.cp_bg_line_k;
        this.efG = 17;
        this.efI = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.efH != null) {
                    g.this.efH.onClick();
                }
                if (g.this.efD != null && g.this.efD.bhv() != null) {
                    g.this.efD.bhv().a(g.this.efD, g.this.mId, g.this.mTextView);
                }
            }
        };
        this.mId = i;
        this.mText = str;
        this.efD = kVar;
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
        this.efH = bVar;
        initListener();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        ap.setViewTextColor(this.mTextView, i);
    }

    @Override // com.baidu.tbadk.core.dialog.j
    public void onChangeSkinType() {
        ap.setBackgroundResource(this.mTextView, this.efF);
        ap.setViewTextColor(this.mTextView, this.mTextColor);
        ap.setBackgroundColor(this.efE, R.color.cp_bg_line_c);
    }

    private void initView() {
        if (this.efD != null && this.efD.getContext() != null) {
            this.mView = LayoutInflater.from(this.efD.getContext()).inflate(R.layout.popup_dialog_view_item, this.efD.getView(), false);
            this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
            this.mTextView.setText(this.mText);
            this.mTextView.setGravity(this.efG);
            this.efE = this.mView.findViewById(R.id.divider_line);
            if (this.efI) {
                this.efE.setVisibility(0);
            } else {
                this.efE.setVisibility(8);
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
