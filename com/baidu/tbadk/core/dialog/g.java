package com.baidu.tbadk.core.dialog;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class g implements j {
    public static final int eNQ = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds251);
    public static final int eNR = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds231);
    private Drawable drawable;
    private k eNJ;
    public EMTextView eNK;
    private View eNL;
    private int eNM;
    private int eNN;
    private k.b eNO;
    private boolean eNP;
    private boolean eNS;
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
        this.eNM = R.color.CAM_X0204;
        this.eNN = 17;
        this.eNP = false;
        this.eNS = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.eNO != null) {
                    g.this.eNO.onClick();
                }
                if (g.this.eNJ != null && g.this.eNJ.brO() != null) {
                    g.this.eNJ.brO().a(g.this.eNJ, g.this.mId, g.this.eNK);
                }
            }
        };
        this.mText = str;
        this.eNJ = kVar;
        this.mId = hashCode();
        initView();
        initListener();
    }

    public g(int i, String str, k kVar) {
        this.mTextColor = R.color.CAM_X0105;
        this.eNM = R.color.CAM_X0204;
        this.eNN = 17;
        this.eNP = false;
        this.eNS = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.eNO != null) {
                    g.this.eNO.onClick();
                }
                if (g.this.eNJ != null && g.this.eNJ.brO() != null) {
                    g.this.eNJ.brO().a(g.this.eNJ, g.this.mId, g.this.eNK);
                }
            }
        };
        this.mId = i;
        this.mText = str;
        this.eNJ = kVar;
        initView();
        initListener();
    }

    public String brG() {
        return this.mText;
    }

    @Override // com.baidu.tbadk.core.dialog.j
    public View getView() {
        return this.mView;
    }

    public void setText(String str) {
        this.mText = str;
        this.eNK.setText(this.mText);
    }

    public void a(k.b bVar) {
        this.eNO = bVar;
        initListener();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        ap.setViewTextColor(this.eNK, i);
    }

    @Override // com.baidu.tbadk.core.dialog.j
    public void onChangeSkinType() {
        ap.setBackgroundResource(this.eNK, this.eNM);
        ap.k(this.eNK, this.mTextColor);
        ap.setBackgroundColor(this.eNL, R.color.CAM_X0204);
    }

    private void initView() {
        if (this.eNJ != null && this.eNJ.getContext() != null) {
            this.mView = LayoutInflater.from(this.eNJ.getContext()).inflate(R.layout.popup_dialog_view_item, this.eNJ.getView(), false);
            this.eNK = (EMTextView) this.mView.findViewById(R.id.item_view);
            this.eNK.setText(this.mText);
            this.eNK.setGravity(this.eNN);
            this.eNL = this.mView.findViewById(R.id.divider_line);
            if (this.eNP) {
                this.eNL.setVisibility(0);
            } else {
                this.eNL.setVisibility(8);
            }
            onChangeSkinType();
        }
    }

    private void brH() {
        if (this.eNJ != null && this.eNJ.getContext() != null) {
            this.mView = LayoutInflater.from(this.eNJ.getContext()).inflate(R.layout.popup_dialog_view_horizal_item, this.eNJ.getView(), false);
            this.mView.getLayoutParams().width = this.eNS ? eNR : eNQ;
            Object tag = this.eNK.getTag();
            this.eNK = (EMTextView) this.mView.findViewById(R.id.item_view);
            this.eNK.setText(this.mText);
            this.eNK.setGravity(this.eNN);
            this.eNK.setTag(tag);
            this.eNL = this.mView.findViewById(R.id.divider_line);
            this.eNL.setVisibility(8);
            this.mImageView = (ImageView) this.mView.findViewById(R.id.item_image);
            this.mImageView.setImageDrawable(this.drawable);
            onChangeSkinType();
            this.mView.setOnClickListener(this.mOnClickListener);
        }
    }

    public void setCanScroll(boolean z) {
        this.eNS = z;
    }

    public void brI() {
        brH();
    }

    private void initListener() {
        if (this.eNK != null) {
            this.eNK.setOnClickListener(this.mOnClickListener);
        }
    }
}
