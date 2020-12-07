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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class NoDataView extends LinearLayout {
    private View faA;
    private NoDataViewFactory.ImgType faB;
    private int faC;
    private int faD;
    private int faE;
    private TbImageView far;
    private LinearLayout fas;
    private TextView fat;
    private TextView fau;
    private TextView fav;
    private TBSpecificationBtn faw;
    private TBSpecificationBtn fax;
    private TBSpecificationBtn fay;
    private int faz;
    private Context mContext;
    private View mRootView;
    private static final int faF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds312);
    private static final int faG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds84);
    private static final int faH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    private static final int faI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds32);
    private static final int alz = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);

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
        this.far = (TbImageView) this.mRootView.findViewById(R.id.iv_no_data_img);
        this.far.setDefaultBgResource(0);
        this.far.setDefaultResource(0);
        this.far.setDefaultErrorResource(0);
        this.fas = (LinearLayout) this.mRootView.findViewById(R.id.title_container);
        this.fat = (TextView) this.mRootView.findViewById(R.id.tv_text_reamrk);
        this.fau = (TextView) this.mRootView.findViewById(R.id.tv_subtitle);
        this.fav = (TextView) this.mRootView.findViewById(R.id.tv_title);
        this.faw = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_func);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.faw.setTextSize(R.dimen.T_X05);
        this.faw.setConfig(aVar);
        this.faA = (LinearLayout) this.mRootView.findViewById(R.id.two_button_layout);
        this.faD = R.color.CAM_X0107;
        this.faE = R.color.CAM_X0109;
        bva();
    }

    private void bva() {
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        if (equipmentHeight > 0) {
            int i = (int) (equipmentHeight * 0.16d);
            ViewGroup.LayoutParams layoutParams = this.far.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.far.setLayoutParams(marginLayoutParams);
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
        if (this.faw != null) {
            this.faw.bvt();
        }
        if (this.fax != null) {
            this.fax.bvt();
        }
        if (this.fay != null) {
            this.fay.bvt();
        }
        if (this.faB == NoDataViewFactory.ImgType.WEBVIEW) {
            this.far.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else if (this.faB == NoDataViewFactory.ImgType.NODATA) {
            this.far.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.faB == NoDataViewFactory.ImgType.LOCAL) {
            this.far.setImageBitmap(ap.getBitmap565Quality(this.faC));
        } else if (this.faB == NoDataViewFactory.ImgType.ANTI) {
            this.far.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.faB == NoDataViewFactory.ImgType.NETERROR) {
            this.far.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else {
            this.far.setImageBitmap(ap.getBitmap565Quality(this.faz));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.fav.setText(dVar.mTitle);
                this.fav.setVisibility(0);
            } else {
                this.fav.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.fau.setVisibility(0);
                this.fau.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.faQ >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fau.getLayoutParams();
                    layoutParams.topMargin = dVar.faQ;
                    this.fau.setLayoutParams(layoutParams);
                }
                if (dVar.faR != 0) {
                    setSubTitleCompoundDrawable(dVar.faR);
                }
            } else {
                this.fau.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.faP)) {
                this.fat.setText(dVar.faP);
                this.fat.setVisibility(0);
            } else {
                this.fat.setVisibility(8);
            }
            bvc();
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.faB = cVar.faO;
            this.faC = cVar.faC;
            switch (cVar.faO) {
                case FINDBAR:
                    this.faz = R.drawable.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.faz = R.drawable.new_pic_emotion_02;
                    break;
                case CREATE:
                    this.faz = R.drawable.new_pic_emotion_03;
                    break;
                case COLLECTION:
                    this.faz = R.drawable.new_pic_emotion_04;
                    break;
                case NODATA:
                    this.faz = R.drawable.new_pic_emotion_05;
                    break;
                case ANTI:
                    this.faz = R.drawable.new_pic_emotion_05;
                    break;
                case SINGALL:
                    this.faz = R.drawable.new_pic_emotion_06;
                    break;
                case GIFT:
                    this.faz = R.drawable.new_pic_emotion_07;
                    break;
                case WEBVIEW:
                    this.faz = R.drawable.new_pic_emotion_08;
                    break;
                case NETERROR:
                    this.faz = R.drawable.new_pic_emotion_08;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.far.getLayoutParams();
            if (cVar.mMarginTop >= 0) {
                layoutParams.setMargins(0, cVar.mMarginTop, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.far.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.faw.setVisibility(8);
            this.faA.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.faL;
        NoDataViewFactory.a aVar2 = bVar.faM;
        if (aVar2 == null && aVar != null) {
            this.faw.setOnClickListener(aVar.faK);
            this.faw.setText(aVar.mText);
            this.faw.setVisibility(0);
            if (bVar.faN >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.faw.getLayoutParams();
                layoutParams.topMargin = bVar.faN;
                this.faw.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.fax = (TBSpecificationBtn) this.faA.findViewById(R.id.btn_left);
            this.fay = (TBSpecificationBtn) this.faA.findViewById(R.id.btn_right);
            com.baidu.tbadk.core.view.commonBtn.a aVar3 = new com.baidu.tbadk.core.view.commonBtn.a();
            this.fax.setTextSize(R.dimen.ds32);
            this.fax.setConfig(aVar3);
            this.fay.setTextSize(R.dimen.ds32);
            this.fay.setConfig(aVar3);
            this.fax.setOnClickListener(aVar.faK);
            this.fax.setText(aVar.mText);
            this.fay.setOnClickListener(aVar2.faK);
            this.fay.setText(aVar2.mText);
            this.faA.setVisibility(0);
        }
        bvc();
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void bvb() {
        this.far.setImageDrawable(null);
        this.far.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.fav != null) {
            ap.setViewTextColor(this.fav, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.fau != null) {
            ap.setViewTextColor(this.fau, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.fat != null) {
            ap.setViewTextColor(this.fat, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = ap.getDrawable(i);
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds32);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8);
        drawable.setBounds(0, 0, dimens, dimens);
        this.fau.setCompoundDrawablePadding(dimens2);
        this.fau.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.fau != null) {
            this.fau.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.fau;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.e<?> eVar) {
        setImgOption(cVar);
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    private void bvc() {
        if (this.faw.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.fas.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = faG;
                this.fas.setLayoutParams(marginLayoutParams);
            }
            this.fau.setVisibility(8);
            this.faD = R.color.CAM_X0107;
        } else if (this.fau.getVisibility() == 8) {
            ViewGroup.LayoutParams layoutParams2 = this.fas.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams2.topMargin = faG;
                this.fas.setLayoutParams(marginLayoutParams2);
            }
            this.faD = R.color.CAM_X0107;
        } else if (this.fav.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams3 = this.fas.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                marginLayoutParams3.topMargin = faI;
                this.fas.setLayoutParams(marginLayoutParams3);
            }
            ViewGroup.LayoutParams layoutParams4 = this.fav.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                marginLayoutParams4.topMargin = alz;
                this.fav.setLayoutParams(marginLayoutParams4);
            }
            this.faD = R.color.CAM_X0107;
            this.faE = R.color.CAM_X0109;
        } else {
            ViewGroup.LayoutParams layoutParams5 = this.far.getLayoutParams();
            layoutParams5.width = faF;
            layoutParams5.height = faF;
            this.far.setLayoutParams(layoutParams5);
            ViewGroup.LayoutParams layoutParams6 = this.fas.getLayoutParams();
            if (layoutParams6 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams6;
                marginLayoutParams5.topMargin = faH;
                this.fas.setLayoutParams(marginLayoutParams5);
            }
            this.faE = R.color.CAM_X0109;
        }
        setTitleTextColor(this.faD);
        setSubTitleTextColor(this.faE);
    }
}
