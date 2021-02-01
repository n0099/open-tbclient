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
    public static final int eVs = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds251);
    public static final int eVt = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds231);
    private Drawable drawable;
    private k eVk;
    public EMTextView eVl;
    private View eVm;
    private int eVn;
    private int eVo;
    private k.b eVp;
    private boolean eVq;
    private boolean eVr;
    private boolean eVu;
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
        this.eVn = R.color.CAM_X0204;
        this.eVo = 17;
        this.eVq = false;
        this.eVr = false;
        this.eVu = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.eVp != null) {
                    g.this.eVp.onClick();
                }
                if (g.this.eVk != null && g.this.eVk.bqQ() != null) {
                    g.this.eVk.bqQ().a(g.this.eVk, g.this.mId, g.this.eVl);
                }
            }
        };
        this.mText = str;
        this.eVk = kVar;
        this.mId = hashCode();
        initView();
        initListener();
    }

    public g(int i, String str, k kVar) {
        this.mTextColor = R.color.CAM_X0105;
        this.eVn = R.color.CAM_X0204;
        this.eVo = 17;
        this.eVq = false;
        this.eVr = false;
        this.eVu = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.eVp != null) {
                    g.this.eVp.onClick();
                }
                if (g.this.eVk != null && g.this.eVk.bqQ() != null) {
                    g.this.eVk.bqQ().a(g.this.eVk, g.this.mId, g.this.eVl);
                }
            }
        };
        this.mId = i;
        this.mText = str;
        this.eVk = kVar;
        initView();
        initListener();
    }

    public String bqI() {
        return this.mText;
    }

    @Override // com.baidu.tbadk.core.dialog.j
    public View getView() {
        return this.mView;
    }

    public void setText(String str) {
        this.mText = str;
        this.eVl.setText(this.mText);
    }

    public void a(k.b bVar) {
        this.eVp = bVar;
        initListener();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        ap.setViewTextColor(this.eVl, i);
    }

    @Override // com.baidu.tbadk.core.dialog.j
    public void onChangeSkinType() {
        ap.setBackgroundResource(this.eVl, this.eVn);
        ap.n(this.eVl, this.mTextColor);
        ap.setBackgroundColor(this.eVm, R.color.CAM_X0204);
        MaskView.b(this.eVl, this.eVr);
    }

    private void initView() {
        if (this.eVk != null && this.eVk.getContext() != null) {
            this.mView = LayoutInflater.from(this.eVk.getContext()).inflate(R.layout.popup_dialog_view_item, this.eVk.getView(), false);
            this.eVl = (EMTextView) this.mView.findViewById(R.id.item_view);
            this.eVl.setText(this.mText);
            this.eVl.setGravity(this.eVo);
            this.eVm = this.mView.findViewById(R.id.divider_line);
            if (this.eVq) {
                this.eVm.setVisibility(0);
            } else {
                this.eVm.setVisibility(8);
            }
            onChangeSkinType();
        }
    }

    private void bqJ() {
        if (this.eVk != null && this.eVk.getContext() != null) {
            this.mView = LayoutInflater.from(this.eVk.getContext()).inflate(R.layout.popup_dialog_view_horizal_item, this.eVk.getView(), false);
            this.mView.getLayoutParams().width = this.eVu ? eVt : eVs;
            Object tag = this.eVl.getTag();
            this.eVl = (EMTextView) this.mView.findViewById(R.id.item_view);
            this.eVl.setText(this.mText);
            this.eVl.setGravity(this.eVo);
            this.eVl.setTag(tag);
            this.eVm = this.mView.findViewById(R.id.divider_line);
            this.eVm.setVisibility(8);
            this.mImageView = (ImageView) this.mView.findViewById(R.id.item_image);
            this.mImageView.setImageDrawable(this.drawable);
            onChangeSkinType();
            this.mView.setOnClickListener(this.mOnClickListener);
        }
    }

    public void setCanScroll(boolean z) {
        this.eVu = z;
    }

    public void bqK() {
        bqJ();
    }

    private void initListener() {
        if (this.eVl != null) {
            this.eVl.setOnClickListener(this.mOnClickListener);
        }
    }

    public void jJ(boolean z) {
        this.eVr = z;
        MaskView.b(this.eVl, z);
    }
}
