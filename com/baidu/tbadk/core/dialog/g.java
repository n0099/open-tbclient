package com.baidu.tbadk.core.dialog;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class g implements j {
    public static final int eXN = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds251);
    public static final int eXO = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds231);
    private Drawable drawable;
    private k eXG;
    public EMTextView eXH;
    private View eXI;
    private int eXJ;
    private int eXK;
    private k.b eXL;
    private boolean eXM;
    private boolean eXP;
    private int mId;
    private ImageView mImageView;
    private final View.OnClickListener mOnClickListener;
    private String mText;
    private int mTextColor;
    private View mView;

    public int getId() {
        return this.mId;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public g(k kVar) {
        this(null, kVar);
    }

    public g(String str, k kVar) {
        this.mTextColor = R.color.CAM_X0105;
        this.eXJ = R.color.CAM_X0204;
        this.eXK = 17;
        this.eXM = false;
        this.eXP = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.eXL != null) {
                    g.this.eXL.onClick();
                }
                if (g.this.eXG != null && g.this.eXG.buq() != null) {
                    g.this.eXG.buq().a(g.this.eXG, g.this.mId, g.this.eXH);
                }
            }
        };
        this.mText = str;
        this.eXG = kVar;
        this.mId = hashCode();
        initView();
        initListener();
    }

    public g(int i, String str, k kVar) {
        this.mTextColor = R.color.CAM_X0105;
        this.eXJ = R.color.CAM_X0204;
        this.eXK = 17;
        this.eXM = false;
        this.eXP = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.eXL != null) {
                    g.this.eXL.onClick();
                }
                if (g.this.eXG != null && g.this.eXG.buq() != null) {
                    g.this.eXG.buq().a(g.this.eXG, g.this.mId, g.this.eXH);
                }
            }
        };
        this.mId = i;
        this.mText = str;
        this.eXG = kVar;
        initView();
        initListener();
    }

    public String bui() {
        return this.mText;
    }

    @Override // com.baidu.tbadk.core.dialog.j
    public View getView() {
        return this.mView;
    }

    public void setText(String str) {
        this.mText = str;
        this.eXH.setText(this.mText);
    }

    public void a(k.b bVar) {
        this.eXL = bVar;
        initListener();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        ao.setViewTextColor(this.eXH, i);
    }

    @Override // com.baidu.tbadk.core.dialog.j
    public void onChangeSkinType() {
        ao.setBackgroundResource(this.eXH, this.eXJ);
        ao.n(this.eXH, this.mTextColor);
        ao.setBackgroundColor(this.eXI, R.color.CAM_X0204);
    }

    private void initView() {
        if (this.eXG != null && this.eXG.getContext() != null) {
            this.mView = LayoutInflater.from(this.eXG.getContext()).inflate(R.layout.popup_dialog_view_item, this.eXG.getView(), false);
            this.eXH = (EMTextView) this.mView.findViewById(R.id.item_view);
            this.eXH.setText(this.mText);
            this.eXH.setGravity(this.eXK);
            this.eXI = this.mView.findViewById(R.id.divider_line);
            if (this.eXM) {
                this.eXI.setVisibility(0);
            } else {
                this.eXI.setVisibility(8);
            }
            onChangeSkinType();
        }
    }

    private void buj() {
        if (this.eXG != null && this.eXG.getContext() != null) {
            this.mView = LayoutInflater.from(this.eXG.getContext()).inflate(R.layout.popup_dialog_view_horizal_item, this.eXG.getView(), false);
            this.mView.getLayoutParams().width = this.eXP ? eXO : eXN;
            Object tag = this.eXH.getTag();
            this.eXH = (EMTextView) this.mView.findViewById(R.id.item_view);
            this.eXH.setText(this.mText);
            this.eXH.setGravity(this.eXK);
            this.eXH.setTag(tag);
            this.eXI = this.mView.findViewById(R.id.divider_line);
            this.eXI.setVisibility(8);
            this.mImageView = (ImageView) this.mView.findViewById(R.id.item_image);
            this.mImageView.setImageDrawable(this.drawable);
            onChangeSkinType();
            this.mView.setOnClickListener(this.mOnClickListener);
        }
    }

    public void setCanScroll(boolean z) {
        this.eXP = z;
    }

    public void buk() {
        buj();
    }

    private void initListener() {
        if (this.eXH != null) {
            this.eXH.setOnClickListener(this.mOnClickListener);
        }
    }
}
