package com.baidu.tbadk.core.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class g implements j {
    private String anb;
    private boolean bOA;
    private k bOv;
    private View bOw;
    private int bOx;
    private int bOy;
    private k.b bOz;
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
        this.bOx = R.color.cp_bg_line_k;
        this.bOy = 17;
        this.bOA = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.bOz != null) {
                    g.this.bOz.onClick();
                }
                if (g.this.bOv != null && g.this.bOv.ahg() != null) {
                    g.this.bOv.ahg().a(g.this.bOv, g.this.mId, g.this.mTextView);
                }
            }
        };
        this.anb = str;
        this.bOv = kVar;
        this.mId = hashCode();
        initView();
        initListener();
    }

    public g(int i, String str, k kVar) {
        this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        this.bOx = R.color.cp_bg_line_k;
        this.bOy = 17;
        this.bOA = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.bOz != null) {
                    g.this.bOz.onClick();
                }
                if (g.this.bOv != null && g.this.bOv.ahg() != null) {
                    g.this.bOv.ahg().a(g.this.bOv, g.this.mId, g.this.mTextView);
                }
            }
        };
        this.mId = i;
        this.anb = str;
        this.bOv = kVar;
        initView();
        initListener();
    }

    @Override // com.baidu.tbadk.core.dialog.j
    public View getView() {
        return this.mView;
    }

    public void setText(String str) {
        this.anb = str;
        this.mTextView.setText(this.anb);
    }

    public void a(k.b bVar) {
        this.bOz = bVar;
        initListener();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        am.j(this.mTextView, i);
    }

    @Override // com.baidu.tbadk.core.dialog.j
    public void onChangeSkinType() {
        am.k(this.mTextView, this.bOx);
        am.j(this.mTextView, this.mTextColor);
        am.l(this.bOw, R.color.cp_bg_line_c);
    }

    private void initView() {
        if (this.bOv != null && this.bOv.getContext() != null) {
            this.mView = LayoutInflater.from(this.bOv.getContext()).inflate(R.layout.popup_dialog_view_item, this.bOv.ahf(), false);
            this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
            this.mTextView.setText(this.anb);
            this.mTextView.setGravity(this.bOy);
            this.bOw = this.mView.findViewById(R.id.divider_line);
            if (this.bOA) {
                this.bOw.setVisibility(0);
            } else {
                this.bOw.setVisibility(8);
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
