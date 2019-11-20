package com.baidu.tbadk.core.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class g implements j {
    private k ceI;
    private View ceJ;
    private int ceK;
    private int ceL;
    private k.b ceM;
    private boolean ceN;
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
        this.ceK = R.color.cp_bg_line_k;
        this.ceL = 17;
        this.ceN = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.ceM != null) {
                    g.this.ceM.onClick();
                }
                if (g.this.ceI != null && g.this.ceI.alb() != null) {
                    g.this.ceI.alb().a(g.this.ceI, g.this.mId, g.this.mTextView);
                }
            }
        };
        this.mText = str;
        this.ceI = kVar;
        this.mId = hashCode();
        initView();
        initListener();
    }

    public g(int i, String str, k kVar) {
        this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        this.ceK = R.color.cp_bg_line_k;
        this.ceL = 17;
        this.ceN = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.ceM != null) {
                    g.this.ceM.onClick();
                }
                if (g.this.ceI != null && g.this.ceI.alb() != null) {
                    g.this.ceI.alb().a(g.this.ceI, g.this.mId, g.this.mTextView);
                }
            }
        };
        this.mId = i;
        this.mText = str;
        this.ceI = kVar;
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
        this.ceM = bVar;
        initListener();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        am.setViewTextColor(this.mTextView, i);
    }

    @Override // com.baidu.tbadk.core.dialog.j
    public void onChangeSkinType() {
        am.setBackgroundResource(this.mTextView, this.ceK);
        am.setViewTextColor(this.mTextView, this.mTextColor);
        am.setBackgroundColor(this.ceJ, R.color.cp_bg_line_c);
    }

    private void initView() {
        if (this.ceI != null && this.ceI.getContext() != null) {
            this.mView = LayoutInflater.from(this.ceI.getContext()).inflate(R.layout.popup_dialog_view_item, this.ceI.ala(), false);
            this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
            this.mTextView.setText(this.mText);
            this.mTextView.setGravity(this.ceL);
            this.ceJ = this.mView.findViewById(R.id.divider_line);
            if (this.ceN) {
                this.ceJ.setVisibility(0);
            } else {
                this.ceJ.setVisibility(8);
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
