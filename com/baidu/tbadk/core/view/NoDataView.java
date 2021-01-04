package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class NoDataView extends LinearLayout {
    private TbImageView fjV;
    private LinearLayout fjW;
    private TextView fjX;
    private TextView fjY;
    private TextView fjZ;
    private TBSpecificationBtn fka;
    private TBSpecificationBtn fkb;
    private TBSpecificationBtn fkc;
    private int fkd;
    private View fke;
    private NoDataViewFactory.ImgType fkf;
    private int fkg;
    private int fkh;
    private int fki;
    private Context mContext;
    private View mRootView;
    private static final int fkj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds312);
    private static final int fkk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds84);
    private static final int fkl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    private static final int fkm = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds32);
    private static final int amb = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);

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
        this.fjV = (TbImageView) this.mRootView.findViewById(R.id.iv_no_data_img);
        this.fjV.setDefaultBgResource(0);
        this.fjV.setDefaultResource(0);
        this.fjW = (LinearLayout) this.mRootView.findViewById(R.id.title_container);
        this.fjX = (TextView) this.mRootView.findViewById(R.id.tv_text_reamrk);
        this.fjY = (TextView) this.mRootView.findViewById(R.id.tv_subtitle);
        this.fjZ = (TextView) this.mRootView.findViewById(R.id.tv_title);
        this.fka = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_func);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.fka.setTextSize(R.dimen.T_X05);
        this.fka.setConfig(aVar);
        this.fke = (LinearLayout) this.mRootView.findViewById(R.id.two_button_layout);
        this.fkh = R.color.CAM_X0107;
        this.fki = R.color.CAM_X0109;
        bxv();
    }

    private void bxv() {
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        if (equipmentHeight > 0) {
            int i = (int) (equipmentHeight * 0.16d);
            ViewGroup.LayoutParams layoutParams = this.fjV.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.fjV.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void a(NoDataViewFactory.b bVar, NoDataViewFactory.c cVar, NoDataViewFactory.d dVar) {
        setButtonOption(bVar);
        setImgOption(cVar);
        setTextOption(dVar);
    }

    public void onChangeSkinType(com.baidu.adp.base.f<?> fVar, int i) {
        if (fVar instanceof TbPageContext) {
            ((TbPageContext) fVar).getLayoutMode().setNightMode(i == 1);
            ((TbPageContext) fVar).getLayoutMode().onModeChanged(this);
        }
        if (this.fka != null) {
            this.fka.bxO();
        }
        if (this.fkb != null) {
            this.fkb.bxO();
        }
        if (this.fkc != null) {
            this.fkc.bxO();
        }
        if (this.fkf == NoDataViewFactory.ImgType.WEBVIEW) {
            this.fjV.setImageBitmap(ao.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else if (this.fkf == NoDataViewFactory.ImgType.NODATA) {
            this.fjV.setImageBitmap(ao.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.fkf == NoDataViewFactory.ImgType.LOCAL) {
            this.fjV.setImageBitmap(ao.getBitmap565Quality(this.fkg));
        } else if (this.fkf == NoDataViewFactory.ImgType.ANTI) {
            this.fjV.setImageBitmap(ao.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.fkf == NoDataViewFactory.ImgType.NETERROR) {
            this.fjV.setImageBitmap(ao.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else {
            this.fjV.setImageBitmap(ao.getBitmap565Quality(this.fkd));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.fjZ.setText(dVar.mTitle);
                this.fjZ.setVisibility(0);
            } else {
                this.fjZ.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.fjY.setVisibility(0);
                this.fjY.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.fku >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fjY.getLayoutParams();
                    layoutParams.topMargin = dVar.fku;
                    this.fjY.setLayoutParams(layoutParams);
                }
                if (dVar.fkv != 0) {
                    setSubTitleCompoundDrawable(dVar.fkv);
                }
            } else {
                this.fjY.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.fkt)) {
                this.fjX.setText(dVar.fkt);
                this.fjX.setVisibility(0);
            } else {
                this.fjX.setVisibility(8);
            }
            bxx();
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.fkf = cVar.fks;
            this.fkg = cVar.fkg;
            switch (cVar.fks) {
                case FINDBAR:
                    this.fkd = R.drawable.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.fkd = R.drawable.new_pic_emotion_02;
                    break;
                case CREATE:
                    this.fkd = R.drawable.new_pic_emotion_03;
                    break;
                case COLLECTION:
                    this.fkd = R.drawable.new_pic_emotion_04;
                    break;
                case NODATA:
                    this.fkd = R.drawable.new_pic_emotion_05;
                    break;
                case ANTI:
                    this.fkd = R.drawable.new_pic_emotion_05;
                    break;
                case SINGALL:
                    this.fkd = R.drawable.new_pic_emotion_06;
                    break;
                case GIFT:
                    this.fkd = R.drawable.new_pic_emotion_07;
                    break;
                case WEBVIEW:
                    this.fkd = R.drawable.new_pic_emotion_08;
                    break;
                case NETERROR:
                    this.fkd = R.drawable.new_pic_emotion_08;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fjV.getLayoutParams();
            if (cVar.mMarginTop >= 0) {
                layoutParams.setMargins(0, cVar.mMarginTop, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.fjV.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.fka.setVisibility(8);
            this.fke.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.fkp;
        NoDataViewFactory.a aVar2 = bVar.fkq;
        if (aVar2 == null && aVar != null) {
            this.fka.setOnClickListener(aVar.fko);
            this.fka.setText(aVar.mText);
            this.fka.setVisibility(0);
            if (bVar.fkr >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fka.getLayoutParams();
                layoutParams.topMargin = bVar.fkr;
                this.fka.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.fkb = (TBSpecificationBtn) this.fke.findViewById(R.id.btn_left);
            this.fkc = (TBSpecificationBtn) this.fke.findViewById(R.id.btn_right);
            com.baidu.tbadk.core.view.commonBtn.a aVar3 = new com.baidu.tbadk.core.view.commonBtn.a();
            this.fkb.setTextSize(R.dimen.ds32);
            this.fkb.setConfig(aVar3);
            this.fkc.setTextSize(R.dimen.ds32);
            this.fkc.setConfig(aVar3);
            this.fkb.setOnClickListener(aVar.fko);
            this.fkb.setText(aVar.mText);
            this.fkc.setOnClickListener(aVar2.fko);
            this.fkc.setText(aVar2.mText);
            this.fke.setVisibility(0);
        }
        bxx();
    }

    public void e(com.baidu.adp.base.f<?> fVar) {
        onChangeSkinType(fVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void bxw() {
        this.fjV.setImageDrawable(null);
        this.fjV.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.fjZ != null) {
            ao.setViewTextColor(this.fjZ, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.fjY != null) {
            ao.setViewTextColor(this.fjY, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.fjX != null) {
            ao.setViewTextColor(this.fjX, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = ao.getDrawable(i);
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds32);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8);
        drawable.setBounds(0, 0, dimens, dimens);
        this.fjY.setCompoundDrawablePadding(dimens2);
        this.fjY.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.fjY != null) {
            this.fjY.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.fjY;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.f<?> fVar) {
        setImgOption(cVar);
        onChangeSkinType(fVar, TbadkCoreApplication.getInst().getSkinType());
    }

    private void bxx() {
        if (this.fka.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.fjW.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = fkk;
                this.fjW.setLayoutParams(marginLayoutParams);
            }
            this.fjY.setVisibility(8);
            this.fkh = R.color.CAM_X0107;
        } else if (this.fjY.getVisibility() == 8) {
            ViewGroup.LayoutParams layoutParams2 = this.fjW.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams2.topMargin = fkk;
                this.fjW.setLayoutParams(marginLayoutParams2);
            }
            this.fkh = R.color.CAM_X0107;
        } else if (this.fjZ.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams3 = this.fjW.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                marginLayoutParams3.topMargin = fkm;
                this.fjW.setLayoutParams(marginLayoutParams3);
            }
            ViewGroup.LayoutParams layoutParams4 = this.fjZ.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                marginLayoutParams4.topMargin = amb;
                this.fjZ.setLayoutParams(marginLayoutParams4);
            }
            this.fkh = R.color.CAM_X0107;
            this.fki = R.color.CAM_X0109;
        } else {
            ViewGroup.LayoutParams layoutParams5 = this.fjV.getLayoutParams();
            layoutParams5.width = fkj;
            layoutParams5.height = fkj;
            this.fjV.setLayoutParams(layoutParams5);
            ViewGroup.LayoutParams layoutParams6 = this.fjW.getLayoutParams();
            if (layoutParams6 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams6;
                marginLayoutParams5.topMargin = fkl;
                this.fjW.setLayoutParams(marginLayoutParams5);
            }
            this.fki = R.color.CAM_X0109;
        }
        setTitleTextColor(this.fkh);
        setSubTitleTextColor(this.fki);
    }
}
