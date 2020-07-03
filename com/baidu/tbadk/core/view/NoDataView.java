package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DimenRes;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class NoDataView extends LinearLayout {
    private TbImageView ebn;
    private LinearLayout ebo;
    private TextView ebp;
    private TextView ebq;
    private TextView ebr;
    private TBSpecificationBtn ebs;
    private TBSpecificationBtn ebt;
    private TBSpecificationBtn ebu;
    private int ebv;
    private View ebw;
    private NoDataViewFactory.ImgType ebx;
    private int eby;
    private Context mContext;
    private View mRootView;

    public NoDataView(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    public NoDataView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.no_data_view, this);
        this.ebn = (TbImageView) this.mRootView.findViewById(R.id.iv_no_data_img);
        this.ebn.setDefaultBgResource(0);
        this.ebn.setDefaultResource(0);
        this.ebn.setDefaultErrorResource(0);
        this.ebo = (LinearLayout) this.mRootView.findViewById(R.id.title_container);
        this.ebp = (TextView) this.mRootView.findViewById(R.id.tv_text_reamrk);
        this.ebq = (TextView) this.mRootView.findViewById(R.id.tv_subtitle);
        this.ebr = (TextView) this.mRootView.findViewById(R.id.tv_title);
        this.ebs = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_func);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.ebs.setTextSize(R.dimen.tbds42);
        this.ebs.setConfig(bVar);
        this.ebw = (LinearLayout) this.mRootView.findViewById(R.id.two_button_layout);
        aXT();
    }

    private void aXT() {
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        if (equipmentHeight > 0) {
            int i = (int) (equipmentHeight * 0.11d);
            ViewGroup.LayoutParams layoutParams = this.ebn.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.ebn.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void a(NoDataViewFactory.b bVar, NoDataViewFactory.c cVar, NoDataViewFactory.d dVar) {
        setButtonOption(bVar);
        setImgOption(cVar);
        setTextOption(dVar);
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().setNightMode(i == 1);
            ((TbPageContext) eVar).getLayoutMode().onModeChanged(this);
        }
        if (this.ebs != null) {
            this.ebs.aYj();
        }
        if (this.ebt != null) {
            this.ebt.aYj();
        }
        if (this.ebu != null) {
            this.ebu.aYj();
        }
        if (this.ebx == NoDataViewFactory.ImgType.WEBVIEW) {
            this.ebn.setImageBitmap(an.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else if (this.ebx == NoDataViewFactory.ImgType.NODATA) {
            this.ebn.setImageBitmap(an.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.ebx == NoDataViewFactory.ImgType.LOCAL) {
            this.ebn.setImageBitmap(an.getBitmap565Quality(this.eby));
        } else if (this.ebx == NoDataViewFactory.ImgType.ANTI) {
            this.ebn.setImageBitmap(an.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.ebx == NoDataViewFactory.ImgType.NETERROR) {
            this.ebn.setImageBitmap(an.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else {
            this.ebn.setImageBitmap(an.getBitmap565Quality(this.ebv));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.ebr.setText(dVar.mTitle);
                this.ebr.setVisibility(0);
            } else {
                this.ebr.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.ebq.setVisibility(0);
                this.ebq.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.ebG >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ebq.getLayoutParams();
                    layoutParams.topMargin = dVar.ebG;
                    this.ebq.setLayoutParams(layoutParams);
                }
                if (dVar.mDrawableId != 0) {
                    setSubTitleCompoundDrawable(dVar.mDrawableId);
                }
            } else {
                this.ebq.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.ebF)) {
                this.ebp.setText(dVar.ebF);
                this.ebp.setVisibility(0);
                return;
            }
            this.ebp.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.ebx = cVar.ebE;
            this.eby = cVar.eby;
            switch (cVar.ebE) {
                case FINDBAR:
                    this.ebv = R.drawable.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.ebv = R.drawable.new_pic_emotion_02;
                    break;
                case CREATE:
                    this.ebv = R.drawable.new_pic_emotion_03;
                    break;
                case COLLECTION:
                    this.ebv = R.drawable.new_pic_emotion_04;
                    break;
                case NODATA:
                    this.ebv = R.drawable.new_pic_emotion_05;
                    break;
                case ANTI:
                    this.ebv = R.drawable.new_pic_emotion_05;
                    break;
                case SINGALL:
                    this.ebv = R.drawable.new_pic_emotion_06;
                    break;
                case GIFT:
                    this.ebv = R.drawable.new_pic_emotion_07;
                    break;
                case WEBVIEW:
                    this.ebv = R.drawable.new_pic_emotion_08;
                    break;
                case NETERROR:
                    this.ebv = R.drawable.new_pic_emotion_08;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ebn.getLayoutParams();
            if (cVar.mMarginTop >= 0) {
                layoutParams.setMargins(0, cVar.mMarginTop, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.ebn.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.ebs.setVisibility(8);
            this.ebw.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.ebB;
        NoDataViewFactory.a aVar2 = bVar.ebC;
        if (aVar2 == null && aVar != null) {
            this.ebs.setOnClickListener(aVar.ebA);
            this.ebs.setText(aVar.mText);
            this.ebs.setVisibility(0);
            if (bVar.ebD >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ebs.getLayoutParams();
                layoutParams.topMargin = bVar.ebD;
                this.ebs.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.ebt = (TBSpecificationBtn) this.ebw.findViewById(R.id.btn_left);
            this.ebu = (TBSpecificationBtn) this.ebw.findViewById(R.id.btn_right);
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            this.ebt.setTextSize(R.dimen.ds32);
            this.ebt.setConfig(bVar2);
            this.ebu.setTextSize(R.dimen.ds32);
            this.ebu.setConfig(bVar2);
            this.ebt.setOnClickListener(aVar.ebA);
            this.ebt.setText(aVar.mText);
            this.ebu.setOnClickListener(aVar2.ebA);
            this.ebu.setText(aVar2.mText);
            this.ebw.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void aXU() {
        this.ebn.setImageDrawable(null);
        this.ebn.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.ebr != null) {
            an.setViewTextColor(this.ebr, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.ebq != null) {
            an.setViewTextColor(this.ebq, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.ebp != null) {
            an.setViewTextColor(this.ebp, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = an.getDrawable(i);
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds32);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8);
        drawable.setBounds(0, 0, dimens, dimens);
        this.ebq.setCompoundDrawablePadding(dimens2);
        this.ebq.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.ebq != null) {
            this.ebq.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.ebq;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.e<?> eVar) {
        setImgOption(cVar);
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTitleContainerMargin(@DimenRes int i, @DimenRes int i2) {
        if (this.ebo != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ebo.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i2);
        }
    }
}
