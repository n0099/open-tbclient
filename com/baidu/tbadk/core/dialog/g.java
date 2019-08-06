package com.baidu.tbadk.core.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class g implements j {
    private String amD;
    private k bNW;
    private View bNX;
    private int bNY;
    private int bNZ;
    private k.b bOa;
    private boolean bOb;
    private int mId;
    private final View.OnClickListener mOnClickListener;
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
        this.bNY = R.color.cp_bg_line_d;
        this.bNZ = 17;
        this.bOb = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.bOa != null) {
                    g.this.bOa.onClick();
                }
                if (g.this.bNW != null && g.this.bNW.ahc() != null) {
                    g.this.bNW.ahc().a(g.this.bNW, g.this.mId, g.this.mTextView);
                }
            }
        };
        this.amD = str;
        this.bNW = kVar;
        this.mId = hashCode();
        initView();
        initListener();
    }

    public g(int i, String str, k kVar) {
        this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        this.bNY = R.color.cp_bg_line_d;
        this.bNZ = 17;
        this.bOb = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.bOa != null) {
                    g.this.bOa.onClick();
                }
                if (g.this.bNW != null && g.this.bNW.ahc() != null) {
                    g.this.bNW.ahc().a(g.this.bNW, g.this.mId, g.this.mTextView);
                }
            }
        };
        this.mId = i;
        this.amD = str;
        this.bNW = kVar;
        initView();
        initListener();
    }

    @Override // com.baidu.tbadk.core.dialog.j
    public View getView() {
        return this.mView;
    }

    public void setText(String str) {
        this.amD = str;
        this.mTextView.setText(this.amD);
    }

    public void a(k.b bVar) {
        this.bOa = bVar;
        initListener();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        am.j(this.mTextView, i);
    }

    @Override // com.baidu.tbadk.core.dialog.j
    public void onChangeSkinType() {
        am.k(this.mTextView, this.bNY);
        am.j(this.mTextView, this.mTextColor);
        am.l(this.bNX, R.color.cp_bg_line_c);
    }

    private void initView() {
        if (this.bNW != null && this.bNW.getContext() != null) {
            this.mView = LayoutInflater.from(this.bNW.getContext()).inflate(R.layout.popup_dialog_view_item, this.bNW.ahb(), false);
            this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
            this.mTextView.setText(this.amD);
            this.mTextView.setGravity(this.bNZ);
            this.bNX = this.mView.findViewById(R.id.divider_line);
            if (this.bOb) {
                this.bNX.setVisibility(0);
            } else {
                this.bNX.setVisibility(8);
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
