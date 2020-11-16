package com.baidu.tbadk.core.dialog;

import android.view.LayoutInflater;
import android.view.View;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class g implements j {
    private k eGG;
    public EMTextView eGH;
    private View eGI;
    private int eGJ;
    private int eGK;
    private k.b eGL;
    private boolean eGM;
    private int mId;
    private final View.OnClickListener mOnClickListener;
    private String mText;
    private int mTextColor;
    private View mView;

    public int getId() {
        return this.mId;
    }

    public g(k kVar) {
        this(null, kVar);
    }

    public g(String str, k kVar) {
        this.mTextColor = R.color.CAM_X0105;
        this.eGJ = R.color.CAM_X0204;
        this.eGK = 17;
        this.eGM = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.eGL != null) {
                    g.this.eGL.onClick();
                }
                if (g.this.eGG != null && g.this.eGG.bov() != null) {
                    g.this.eGG.bov().a(g.this.eGG, g.this.mId, g.this.eGH);
                }
            }
        };
        this.mText = str;
        this.eGG = kVar;
        this.mId = hashCode();
        initView();
        initListener();
    }

    public g(int i, String str, k kVar) {
        this.mTextColor = R.color.CAM_X0105;
        this.eGJ = R.color.CAM_X0204;
        this.eGK = 17;
        this.eGM = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.eGL != null) {
                    g.this.eGL.onClick();
                }
                if (g.this.eGG != null && g.this.eGG.bov() != null) {
                    g.this.eGG.bov().a(g.this.eGG, g.this.mId, g.this.eGH);
                }
            }
        };
        this.mId = i;
        this.mText = str;
        this.eGG = kVar;
        initView();
        initListener();
    }

    @Override // com.baidu.tbadk.core.dialog.j
    public View getView() {
        return this.mView;
    }

    public void setText(String str) {
        this.mText = str;
        this.eGH.setText(this.mText);
    }

    public void a(k.b bVar) {
        this.eGL = bVar;
        initListener();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        ap.setViewTextColor(this.eGH, i);
    }

    @Override // com.baidu.tbadk.core.dialog.j
    public void onChangeSkinType() {
        ap.setBackgroundResource(this.eGH, this.eGJ);
        ap.k(this.eGH, this.mTextColor);
        ap.setBackgroundColor(this.eGI, R.color.CAM_X0204);
    }

    private void initView() {
        if (this.eGG != null && this.eGG.getContext() != null) {
            this.mView = LayoutInflater.from(this.eGG.getContext()).inflate(R.layout.popup_dialog_view_item, this.eGG.getView(), false);
            this.eGH = (EMTextView) this.mView.findViewById(R.id.item_view);
            this.eGH.setText(this.mText);
            this.eGH.setGravity(this.eGK);
            this.eGI = this.mView.findViewById(R.id.divider_line);
            if (this.eGM) {
                this.eGI.setVisibility(0);
            } else {
                this.eGI.setVisibility(8);
            }
            onChangeSkinType();
        }
    }

    private void initListener() {
        if (this.eGH != null) {
            this.eGH.setOnClickListener(this.mOnClickListener);
        }
    }
}
