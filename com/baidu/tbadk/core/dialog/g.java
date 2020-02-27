package com.baidu.tbadk.core.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class g implements j {
    private k cVs;
    private View cVt;
    private int cVu;
    private int cVv;
    private k.b cVw;
    private boolean cVx;
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
        this.cVu = R.color.cp_bg_line_k;
        this.cVv = 17;
        this.cVx = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.cVw != null) {
                    g.this.cVw.onClick();
                }
                if (g.this.cVs != null && g.this.cVs.aEO() != null) {
                    g.this.cVs.aEO().a(g.this.cVs, g.this.mId, g.this.mTextView);
                }
            }
        };
        this.mText = str;
        this.cVs = kVar;
        this.mId = hashCode();
        initView();
        initListener();
    }

    public g(int i, String str, k kVar) {
        this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        this.cVu = R.color.cp_bg_line_k;
        this.cVv = 17;
        this.cVx = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.cVw != null) {
                    g.this.cVw.onClick();
                }
                if (g.this.cVs != null && g.this.cVs.aEO() != null) {
                    g.this.cVs.aEO().a(g.this.cVs, g.this.mId, g.this.mTextView);
                }
            }
        };
        this.mId = i;
        this.mText = str;
        this.cVs = kVar;
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
        this.cVw = bVar;
        initListener();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        am.setViewTextColor(this.mTextView, i);
    }

    @Override // com.baidu.tbadk.core.dialog.j
    public void onChangeSkinType() {
        am.setBackgroundResource(this.mTextView, this.cVu);
        am.setViewTextColor(this.mTextView, this.mTextColor);
        am.setBackgroundColor(this.cVt, R.color.cp_bg_line_c);
    }

    private void initView() {
        if (this.cVs != null && this.cVs.getContext() != null) {
            this.mView = LayoutInflater.from(this.cVs.getContext()).inflate(R.layout.popup_dialog_view_item, this.cVs.getView(), false);
            this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
            this.mTextView.setText(this.mText);
            this.mTextView.setGravity(this.cVv);
            this.cVt = this.mView.findViewById(R.id.divider_line);
            if (this.cVx) {
                this.cVt.setVisibility(0);
            } else {
                this.cVt.setVisibility(8);
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
