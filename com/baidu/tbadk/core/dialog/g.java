package com.baidu.tbadk.core.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class g implements j {
    private k cRg;
    private View cRh;
    private int cRi;
    private int cRj;
    private k.b cRk;
    private boolean cRl;
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
        this.cRi = R.color.cp_bg_line_k;
        this.cRj = 17;
        this.cRl = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.cRk != null) {
                    g.this.cRk.onClick();
                }
                if (g.this.cRg != null && g.this.cRg.aCl() != null) {
                    g.this.cRg.aCl().a(g.this.cRg, g.this.mId, g.this.mTextView);
                }
            }
        };
        this.mText = str;
        this.cRg = kVar;
        this.mId = hashCode();
        initView();
        initListener();
    }

    public g(int i, String str, k kVar) {
        this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        this.cRi = R.color.cp_bg_line_k;
        this.cRj = 17;
        this.cRl = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.cRk != null) {
                    g.this.cRk.onClick();
                }
                if (g.this.cRg != null && g.this.cRg.aCl() != null) {
                    g.this.cRg.aCl().a(g.this.cRg, g.this.mId, g.this.mTextView);
                }
            }
        };
        this.mId = i;
        this.mText = str;
        this.cRg = kVar;
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
        this.cRk = bVar;
        initListener();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        am.setViewTextColor(this.mTextView, i);
    }

    @Override // com.baidu.tbadk.core.dialog.j
    public void onChangeSkinType() {
        am.setBackgroundResource(this.mTextView, this.cRi);
        am.setViewTextColor(this.mTextView, this.mTextColor);
        am.setBackgroundColor(this.cRh, R.color.cp_bg_line_c);
    }

    private void initView() {
        if (this.cRg != null && this.cRg.getContext() != null) {
            this.mView = LayoutInflater.from(this.cRg.getContext()).inflate(R.layout.popup_dialog_view_item, this.cRg.aCk(), false);
            this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
            this.mTextView.setText(this.mText);
            this.mTextView.setGravity(this.cRj);
            this.cRh = this.mView.findViewById(R.id.divider_line);
            if (this.cRl) {
                this.cRh.setVisibility(0);
            } else {
                this.cRh.setVisibility(8);
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
