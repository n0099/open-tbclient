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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class NoDataView extends LinearLayout {
    private TbImageView dTY;
    private LinearLayout dTZ;
    private TextView dUa;
    private TextView dUb;
    private TextView dUc;
    private TBSpecificationBtn dUd;
    private TBSpecificationBtn dUe;
    private TBSpecificationBtn dUf;
    private int dUg;
    private View dUh;
    private NoDataViewFactory.ImgType dUi;
    private int dUj;
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
        this.dTY = (TbImageView) this.mRootView.findViewById(R.id.iv_no_data_img);
        this.dTY.setDefaultBgResource(0);
        this.dTY.setDefaultResource(0);
        this.dTY.setDefaultErrorResource(0);
        this.dTZ = (LinearLayout) this.mRootView.findViewById(R.id.title_container);
        this.dUa = (TextView) this.mRootView.findViewById(R.id.tv_text_reamrk);
        this.dUb = (TextView) this.mRootView.findViewById(R.id.tv_subtitle);
        this.dUc = (TextView) this.mRootView.findViewById(R.id.tv_title);
        this.dUd = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_func);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.dUd.setTextSize(R.dimen.tbds42);
        this.dUd.setConfig(bVar);
        this.dUh = (LinearLayout) this.mRootView.findViewById(R.id.two_button_layout);
        aVY();
    }

    private void aVY() {
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        if (equipmentHeight > 0) {
            int i = (int) (equipmentHeight * 0.11d);
            ViewGroup.LayoutParams layoutParams = this.dTY.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.dTY.setLayoutParams(marginLayoutParams);
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
        if (this.dUd != null) {
            this.dUd.aWq();
        }
        if (this.dUe != null) {
            this.dUe.aWq();
        }
        if (this.dUf != null) {
            this.dUf.aWq();
        }
        if (this.dUi == NoDataViewFactory.ImgType.WEBVIEW) {
            this.dTY.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else if (this.dUi == NoDataViewFactory.ImgType.NODATA) {
            this.dTY.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.dUi == NoDataViewFactory.ImgType.LOCAL) {
            this.dTY.setImageBitmap(am.getBitmap565Quality(this.dUj));
        } else if (this.dUi == NoDataViewFactory.ImgType.ANTI) {
            this.dTY.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.dUi == NoDataViewFactory.ImgType.NETERROR) {
            this.dTY.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else {
            this.dTY.setImageBitmap(am.getBitmap565Quality(this.dUg));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.dUc.setText(dVar.mTitle);
                this.dUc.setVisibility(0);
            } else {
                this.dUc.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.dUb.setVisibility(0);
                this.dUb.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.dUr >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dUb.getLayoutParams();
                    layoutParams.topMargin = dVar.dUr;
                    this.dUb.setLayoutParams(layoutParams);
                }
                if (dVar.mDrawableId != 0) {
                    setSubTitleCompoundDrawable(dVar.mDrawableId);
                }
            } else {
                this.dUb.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.dUq)) {
                this.dUa.setText(dVar.dUq);
                this.dUa.setVisibility(0);
                return;
            }
            this.dUa.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.dUi = cVar.dUp;
            this.dUj = cVar.dUj;
            switch (cVar.dUp) {
                case FINDBAR:
                    this.dUg = R.drawable.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.dUg = R.drawable.new_pic_emotion_02;
                    break;
                case CREATE:
                    this.dUg = R.drawable.new_pic_emotion_03;
                    break;
                case COLLECTION:
                    this.dUg = R.drawable.new_pic_emotion_04;
                    break;
                case NODATA:
                    this.dUg = R.drawable.new_pic_emotion_05;
                    break;
                case ANTI:
                    this.dUg = R.drawable.new_pic_emotion_05;
                    break;
                case SINGALL:
                    this.dUg = R.drawable.new_pic_emotion_06;
                    break;
                case GIFT:
                    this.dUg = R.drawable.new_pic_emotion_07;
                    break;
                case WEBVIEW:
                    this.dUg = R.drawable.new_pic_emotion_08;
                    break;
                case NETERROR:
                    this.dUg = R.drawable.new_pic_emotion_08;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dTY.getLayoutParams();
            if (cVar.mMarginTop >= 0) {
                layoutParams.setMargins(0, cVar.mMarginTop, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.dTY.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.dUd.setVisibility(8);
            this.dUh.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.dUm;
        NoDataViewFactory.a aVar2 = bVar.dUn;
        if (aVar2 == null && aVar != null) {
            this.dUd.setOnClickListener(aVar.dUl);
            this.dUd.setText(aVar.mText);
            this.dUd.setVisibility(0);
            if (bVar.dUo >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dUd.getLayoutParams();
                layoutParams.topMargin = bVar.dUo;
                this.dUd.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.dUe = (TBSpecificationBtn) this.dUh.findViewById(R.id.btn_left);
            this.dUf = (TBSpecificationBtn) this.dUh.findViewById(R.id.btn_right);
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            this.dUe.setTextSize(R.dimen.ds32);
            this.dUe.setConfig(bVar2);
            this.dUf.setTextSize(R.dimen.ds32);
            this.dUf.setConfig(bVar2);
            this.dUe.setOnClickListener(aVar.dUl);
            this.dUe.setText(aVar.mText);
            this.dUf.setOnClickListener(aVar2.dUl);
            this.dUf.setText(aVar2.mText);
            this.dUh.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void aVZ() {
        this.dTY.setImageDrawable(null);
        this.dTY.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.dUc != null) {
            am.setViewTextColor(this.dUc, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.dUb != null) {
            am.setViewTextColor(this.dUb, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.dUa != null) {
            am.setViewTextColor(this.dUa, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = am.getDrawable(i);
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds32);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8);
        drawable.setBounds(0, 0, dimens, dimens);
        this.dUb.setCompoundDrawablePadding(dimens2);
        this.dUb.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.dUb != null) {
            this.dUb.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.dUb;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.e<?> eVar) {
        setImgOption(cVar);
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTitleContainerMargin(@DimenRes int i, @DimenRes int i2) {
        if (this.dTZ != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dTZ.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i2);
        }
    }
}
