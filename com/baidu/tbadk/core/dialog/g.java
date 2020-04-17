package com.baidu.tbadk.core.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class g implements j {
    private k duS;
    private View duT;
    private int duU;
    private int duV;
    private k.b duW;
    private boolean duX;
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
        this.duU = R.color.cp_bg_line_k;
        this.duV = 17;
        this.duX = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.duW != null) {
                    g.this.duW.onClick();
                }
                if (g.this.duS != null && g.this.duS.aNi() != null) {
                    g.this.duS.aNi().a(g.this.duS, g.this.mId, g.this.mTextView);
                }
            }
        };
        this.mText = str;
        this.duS = kVar;
        this.mId = hashCode();
        initView();
        initListener();
    }

    public g(int i, String str, k kVar) {
        this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        this.duU = R.color.cp_bg_line_k;
        this.duV = 17;
        this.duX = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.duW != null) {
                    g.this.duW.onClick();
                }
                if (g.this.duS != null && g.this.duS.aNi() != null) {
                    g.this.duS.aNi().a(g.this.duS, g.this.mId, g.this.mTextView);
                }
            }
        };
        this.mId = i;
        this.mText = str;
        this.duS = kVar;
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
        this.duW = bVar;
        initListener();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        am.setViewTextColor(this.mTextView, i);
    }

    @Override // com.baidu.tbadk.core.dialog.j
    public void onChangeSkinType() {
        am.setBackgroundResource(this.mTextView, this.duU);
        am.setViewTextColor(this.mTextView, this.mTextColor);
        am.setBackgroundColor(this.duT, R.color.cp_bg_line_c);
    }

    private void initView() {
        if (this.duS != null && this.duS.getContext() != null) {
            this.mView = LayoutInflater.from(this.duS.getContext()).inflate(R.layout.popup_dialog_view_item, this.duS.getView(), false);
            this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
            this.mTextView.setText(this.mText);
            this.mTextView.setGravity(this.duV);
            this.duT = this.mView.findViewById(R.id.divider_line);
            if (this.duX) {
                this.duT.setVisibility(0);
            } else {
                this.duT.setVisibility(8);
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
