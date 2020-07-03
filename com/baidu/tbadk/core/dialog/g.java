package com.baidu.tbadk.core.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class g implements j {
    private k dPH;
    private View dPI;
    private int dPJ;
    private int dPK;
    private k.b dPL;
    private boolean dPM;
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
        this.dPJ = R.color.cp_bg_line_k;
        this.dPK = 17;
        this.dPM = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.dPL != null) {
                    g.this.dPL.onClick();
                }
                if (g.this.dPH != null && g.this.dPH.aVa() != null) {
                    g.this.dPH.aVa().a(g.this.dPH, g.this.mId, g.this.mTextView);
                }
            }
        };
        this.mText = str;
        this.dPH = kVar;
        this.mId = hashCode();
        initView();
        initListener();
    }

    public g(int i, String str, k kVar) {
        this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        this.dPJ = R.color.cp_bg_line_k;
        this.dPK = 17;
        this.dPM = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.dPL != null) {
                    g.this.dPL.onClick();
                }
                if (g.this.dPH != null && g.this.dPH.aVa() != null) {
                    g.this.dPH.aVa().a(g.this.dPH, g.this.mId, g.this.mTextView);
                }
            }
        };
        this.mId = i;
        this.mText = str;
        this.dPH = kVar;
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
        this.dPL = bVar;
        initListener();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        an.setViewTextColor(this.mTextView, i);
    }

    @Override // com.baidu.tbadk.core.dialog.j
    public void onChangeSkinType() {
        an.setBackgroundResource(this.mTextView, this.dPJ);
        an.setViewTextColor(this.mTextView, this.mTextColor);
        an.setBackgroundColor(this.dPI, R.color.cp_bg_line_c);
    }

    private void initView() {
        if (this.dPH != null && this.dPH.getContext() != null) {
            this.mView = LayoutInflater.from(this.dPH.getContext()).inflate(R.layout.popup_dialog_view_item, this.dPH.getView(), false);
            this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
            this.mTextView.setText(this.mText);
            this.mTextView.setGravity(this.dPK);
            this.dPI = this.mView.findViewById(R.id.divider_line);
            if (this.dPM) {
                this.dPI.setVisibility(0);
            } else {
                this.dPI.setVisibility(8);
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
