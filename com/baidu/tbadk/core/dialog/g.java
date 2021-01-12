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
    public static final int eTc = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds251);
    public static final int eTd = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds231);
    private Drawable drawable;
    private k eSV;
    public EMTextView eSW;
    private View eSX;
    private int eSY;
    private int eSZ;
    private k.b eTa;
    private boolean eTb;
    private boolean eTe;
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
        this.eSY = R.color.CAM_X0204;
        this.eSZ = 17;
        this.eTb = false;
        this.eTe = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.eTa != null) {
                    g.this.eTa.onClick();
                }
                if (g.this.eSV != null && g.this.eSV.bqx() != null) {
                    g.this.eSV.bqx().a(g.this.eSV, g.this.mId, g.this.eSW);
                }
            }
        };
        this.mText = str;
        this.eSV = kVar;
        this.mId = hashCode();
        initView();
        initListener();
    }

    public g(int i, String str, k kVar) {
        this.mTextColor = R.color.CAM_X0105;
        this.eSY = R.color.CAM_X0204;
        this.eSZ = 17;
        this.eTb = false;
        this.eTe = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.eTa != null) {
                    g.this.eTa.onClick();
                }
                if (g.this.eSV != null && g.this.eSV.bqx() != null) {
                    g.this.eSV.bqx().a(g.this.eSV, g.this.mId, g.this.eSW);
                }
            }
        };
        this.mId = i;
        this.mText = str;
        this.eSV = kVar;
        initView();
        initListener();
    }

    public String bqp() {
        return this.mText;
    }

    @Override // com.baidu.tbadk.core.dialog.j
    public View getView() {
        return this.mView;
    }

    public void setText(String str) {
        this.mText = str;
        this.eSW.setText(this.mText);
    }

    public void a(k.b bVar) {
        this.eTa = bVar;
        initListener();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        ao.setViewTextColor(this.eSW, i);
    }

    @Override // com.baidu.tbadk.core.dialog.j
    public void onChangeSkinType() {
        ao.setBackgroundResource(this.eSW, this.eSY);
        ao.n(this.eSW, this.mTextColor);
        ao.setBackgroundColor(this.eSX, R.color.CAM_X0204);
    }

    private void initView() {
        if (this.eSV != null && this.eSV.getContext() != null) {
            this.mView = LayoutInflater.from(this.eSV.getContext()).inflate(R.layout.popup_dialog_view_item, this.eSV.getView(), false);
            this.eSW = (EMTextView) this.mView.findViewById(R.id.item_view);
            this.eSW.setText(this.mText);
            this.eSW.setGravity(this.eSZ);
            this.eSX = this.mView.findViewById(R.id.divider_line);
            if (this.eTb) {
                this.eSX.setVisibility(0);
            } else {
                this.eSX.setVisibility(8);
            }
            onChangeSkinType();
        }
    }

    private void bqq() {
        if (this.eSV != null && this.eSV.getContext() != null) {
            this.mView = LayoutInflater.from(this.eSV.getContext()).inflate(R.layout.popup_dialog_view_horizal_item, this.eSV.getView(), false);
            this.mView.getLayoutParams().width = this.eTe ? eTd : eTc;
            Object tag = this.eSW.getTag();
            this.eSW = (EMTextView) this.mView.findViewById(R.id.item_view);
            this.eSW.setText(this.mText);
            this.eSW.setGravity(this.eSZ);
            this.eSW.setTag(tag);
            this.eSX = this.mView.findViewById(R.id.divider_line);
            this.eSX.setVisibility(8);
            this.mImageView = (ImageView) this.mView.findViewById(R.id.item_image);
            this.mImageView.setImageDrawable(this.drawable);
            onChangeSkinType();
            this.mView.setOnClickListener(this.mOnClickListener);
        }
    }

    public void setCanScroll(boolean z) {
        this.eTe = z;
    }

    public void bqr() {
        bqq();
    }

    private void initListener() {
        if (this.eSW != null) {
            this.eSW.setOnClickListener(this.mOnClickListener);
        }
    }
}
