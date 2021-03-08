package com.baidu.tbadk.core.dialog;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class g implements j {
    public static final int eWR = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds251);
    public static final int eWS = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds231);
    private Drawable drawable;
    private k eWJ;
    public EMTextView eWK;
    private View eWL;
    private int eWM;
    private int eWN;
    private k.b eWO;
    private boolean eWP;
    private boolean eWQ;
    private boolean eWT;
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
        this.eWM = R.color.CAM_X0204;
        this.eWN = 17;
        this.eWP = false;
        this.eWQ = false;
        this.eWT = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.eWO != null) {
                    g.this.eWO.onClick();
                }
                if (g.this.eWJ != null && g.this.eWJ.bqR() != null) {
                    g.this.eWJ.bqR().a(g.this.eWJ, g.this.mId, g.this.eWK);
                }
            }
        };
        this.mText = str;
        this.eWJ = kVar;
        this.mId = hashCode();
        initView();
        initListener();
    }

    public g(int i, String str, k kVar) {
        this.mTextColor = R.color.CAM_X0105;
        this.eWM = R.color.CAM_X0204;
        this.eWN = 17;
        this.eWP = false;
        this.eWQ = false;
        this.eWT = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.eWO != null) {
                    g.this.eWO.onClick();
                }
                if (g.this.eWJ != null && g.this.eWJ.bqR() != null) {
                    g.this.eWJ.bqR().a(g.this.eWJ, g.this.mId, g.this.eWK);
                }
            }
        };
        this.mId = i;
        this.mText = str;
        this.eWJ = kVar;
        initView();
        initListener();
    }

    public String bqJ() {
        return this.mText;
    }

    @Override // com.baidu.tbadk.core.dialog.j
    public View getView() {
        return this.mView;
    }

    public void setText(String str) {
        this.mText = str;
        this.eWK.setText(this.mText);
    }

    public void a(k.b bVar) {
        this.eWO = bVar;
        initListener();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        ap.setViewTextColor(this.eWK, i);
    }

    @Override // com.baidu.tbadk.core.dialog.j
    public void onChangeSkinType() {
        ap.setBackgroundResource(this.eWK, this.eWM);
        ap.n(this.eWK, this.mTextColor);
        ap.setBackgroundColor(this.eWL, R.color.CAM_X0204);
        MaskView.b(this.eWK, this.eWQ);
    }

    private void initView() {
        if (this.eWJ != null && this.eWJ.getContext() != null) {
            this.mView = LayoutInflater.from(this.eWJ.getContext()).inflate(R.layout.popup_dialog_view_item, this.eWJ.getView(), false);
            this.eWK = (EMTextView) this.mView.findViewById(R.id.item_view);
            this.eWK.setText(this.mText);
            this.eWK.setGravity(this.eWN);
            this.eWL = this.mView.findViewById(R.id.divider_line);
            if (this.eWP) {
                this.eWL.setVisibility(0);
            } else {
                this.eWL.setVisibility(8);
            }
            onChangeSkinType();
        }
    }

    private void bqK() {
        if (this.eWJ != null && this.eWJ.getContext() != null) {
            this.mView = LayoutInflater.from(this.eWJ.getContext()).inflate(R.layout.popup_dialog_view_horizal_item, this.eWJ.getView(), false);
            this.mView.getLayoutParams().width = this.eWT ? eWS : eWR;
            Object tag = this.eWK.getTag();
            this.eWK = (EMTextView) this.mView.findViewById(R.id.item_view);
            this.eWK.setText(this.mText);
            this.eWK.setGravity(this.eWN);
            this.eWK.setTag(tag);
            this.eWL = this.mView.findViewById(R.id.divider_line);
            this.eWL.setVisibility(8);
            this.mImageView = (ImageView) this.mView.findViewById(R.id.item_image);
            this.mImageView.setImageDrawable(this.drawable);
            onChangeSkinType();
            this.mView.setOnClickListener(this.mOnClickListener);
        }
    }

    public void setCanScroll(boolean z) {
        this.eWT = z;
    }

    public void bqL() {
        bqK();
    }

    private void initListener() {
        if (this.eWK != null) {
            this.eWK.setOnClickListener(this.mOnClickListener);
        }
    }

    public void jJ(boolean z) {
        this.eWQ = z;
        MaskView.b(this.eWK, z);
    }
}
