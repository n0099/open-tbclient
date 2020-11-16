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
    private TbImageView eSW;
    private LinearLayout eSX;
    private TextView eSY;
    private TextView eSZ;
    private TextView eTa;
    private TBSpecificationBtn eTb;
    private TBSpecificationBtn eTc;
    private TBSpecificationBtn eTd;
    private int eTe;
    private View eTf;
    private NoDataViewFactory.ImgType eTg;
    private int eTh;
    private int eTi;
    private int eTj;
    private Context mContext;
    private View mRootView;
    private static final int eTk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds312);
    private static final int eTl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds84);
    private static final int eTm = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    private static final int eTn = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds32);
    private static final int aky = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);

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
        this.eSW = (TbImageView) this.mRootView.findViewById(R.id.iv_no_data_img);
        this.eSW.setDefaultBgResource(0);
        this.eSW.setDefaultResource(0);
        this.eSW.setDefaultErrorResource(0);
        this.eSX = (LinearLayout) this.mRootView.findViewById(R.id.title_container);
        this.eSY = (TextView) this.mRootView.findViewById(R.id.tv_text_reamrk);
        this.eSZ = (TextView) this.mRootView.findViewById(R.id.tv_subtitle);
        this.eTa = (TextView) this.mRootView.findViewById(R.id.tv_title);
        this.eTb = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_func);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.eTb.setTextSize(R.dimen.T_X05);
        this.eTb.setConfig(aVar);
        this.eTf = (LinearLayout) this.mRootView.findViewById(R.id.two_button_layout);
        this.eTi = R.color.CAM_X0107;
        this.eTj = R.color.CAM_X0109;
        brB();
    }

    private void brB() {
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        if (equipmentHeight > 0) {
            int i = (int) (equipmentHeight * 0.16d);
            ViewGroup.LayoutParams layoutParams = this.eSW.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.eSW.setLayoutParams(marginLayoutParams);
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
        if (this.eTb != null) {
            this.eTb.brT();
        }
        if (this.eTc != null) {
            this.eTc.brT();
        }
        if (this.eTd != null) {
            this.eTd.brT();
        }
        if (this.eTg == NoDataViewFactory.ImgType.WEBVIEW) {
            this.eSW.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else if (this.eTg == NoDataViewFactory.ImgType.NODATA) {
            this.eSW.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.eTg == NoDataViewFactory.ImgType.LOCAL) {
            this.eSW.setImageBitmap(ap.getBitmap565Quality(this.eTh));
        } else if (this.eTg == NoDataViewFactory.ImgType.ANTI) {
            this.eSW.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.eTg == NoDataViewFactory.ImgType.NETERROR) {
            this.eSW.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else {
            this.eSW.setImageBitmap(ap.getBitmap565Quality(this.eTe));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.eTa.setText(dVar.mTitle);
                this.eTa.setVisibility(0);
            } else {
                this.eTa.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.eSZ.setVisibility(0);
                this.eSZ.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.eTv >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eSZ.getLayoutParams();
                    layoutParams.topMargin = dVar.eTv;
                    this.eSZ.setLayoutParams(layoutParams);
                }
                if (dVar.mDrawableId != 0) {
                    setSubTitleCompoundDrawable(dVar.mDrawableId);
                }
            } else {
                this.eSZ.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.eTu)) {
                this.eSY.setText(dVar.eTu);
                this.eSY.setVisibility(0);
            } else {
                this.eSY.setVisibility(8);
            }
            brD();
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.eTg = cVar.eTt;
            this.eTh = cVar.eTh;
            switch (cVar.eTt) {
                case FINDBAR:
                    this.eTe = R.drawable.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.eTe = R.drawable.new_pic_emotion_02;
                    break;
                case CREATE:
                    this.eTe = R.drawable.new_pic_emotion_03;
                    break;
                case COLLECTION:
                    this.eTe = R.drawable.new_pic_emotion_04;
                    break;
                case NODATA:
                    this.eTe = R.drawable.new_pic_emotion_05;
                    break;
                case ANTI:
                    this.eTe = R.drawable.new_pic_emotion_05;
                    break;
                case SINGALL:
                    this.eTe = R.drawable.new_pic_emotion_06;
                    break;
                case GIFT:
                    this.eTe = R.drawable.new_pic_emotion_07;
                    break;
                case WEBVIEW:
                    this.eTe = R.drawable.new_pic_emotion_08;
                    break;
                case NETERROR:
                    this.eTe = R.drawable.new_pic_emotion_08;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eSW.getLayoutParams();
            if (cVar.mMarginTop >= 0) {
                layoutParams.setMargins(0, cVar.mMarginTop, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.eSW.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.eTb.setVisibility(8);
            this.eTf.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.eTq;
        NoDataViewFactory.a aVar2 = bVar.eTr;
        if (aVar2 == null && aVar != null) {
            this.eTb.setOnClickListener(aVar.eTp);
            this.eTb.setText(aVar.mText);
            this.eTb.setVisibility(0);
            if (bVar.eTs >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eTb.getLayoutParams();
                layoutParams.topMargin = bVar.eTs;
                this.eTb.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.eTc = (TBSpecificationBtn) this.eTf.findViewById(R.id.btn_left);
            this.eTd = (TBSpecificationBtn) this.eTf.findViewById(R.id.btn_right);
            com.baidu.tbadk.core.view.commonBtn.a aVar3 = new com.baidu.tbadk.core.view.commonBtn.a();
            this.eTc.setTextSize(R.dimen.ds32);
            this.eTc.setConfig(aVar3);
            this.eTd.setTextSize(R.dimen.ds32);
            this.eTd.setConfig(aVar3);
            this.eTc.setOnClickListener(aVar.eTp);
            this.eTc.setText(aVar.mText);
            this.eTd.setOnClickListener(aVar2.eTp);
            this.eTd.setText(aVar2.mText);
            this.eTf.setVisibility(0);
        }
        brD();
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void brC() {
        this.eSW.setImageDrawable(null);
        this.eSW.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.eTa != null) {
            ap.setViewTextColor(this.eTa, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.eSZ != null) {
            ap.setViewTextColor(this.eSZ, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.eSY != null) {
            ap.setViewTextColor(this.eSY, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = ap.getDrawable(i);
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds32);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8);
        drawable.setBounds(0, 0, dimens, dimens);
        this.eSZ.setCompoundDrawablePadding(dimens2);
        this.eSZ.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.eSZ != null) {
            this.eSZ.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.eSZ;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.e<?> eVar) {
        setImgOption(cVar);
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    private void brD() {
        if (this.eTb.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.eSX.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = eTl;
                this.eSX.setLayoutParams(marginLayoutParams);
            }
            this.eSZ.setVisibility(8);
            this.eTi = R.color.CAM_X0107;
        } else if (this.eSZ.getVisibility() == 8) {
            ViewGroup.LayoutParams layoutParams2 = this.eSX.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams2.topMargin = eTl;
                this.eSX.setLayoutParams(marginLayoutParams2);
            }
            this.eTi = R.color.CAM_X0107;
        } else if (this.eTa.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams3 = this.eSX.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                marginLayoutParams3.topMargin = eTn;
                this.eSX.setLayoutParams(marginLayoutParams3);
            }
            ViewGroup.LayoutParams layoutParams4 = this.eTa.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                marginLayoutParams4.topMargin = aky;
                this.eTa.setLayoutParams(marginLayoutParams4);
            }
            this.eTi = R.color.CAM_X0107;
            this.eTj = R.color.CAM_X0109;
        } else {
            ViewGroup.LayoutParams layoutParams5 = this.eSW.getLayoutParams();
            layoutParams5.width = eTk;
            layoutParams5.height = eTk;
            this.eSW.setLayoutParams(layoutParams5);
            ViewGroup.LayoutParams layoutParams6 = this.eSX.getLayoutParams();
            if (layoutParams6 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams6;
                marginLayoutParams5.topMargin = eTm;
                this.eSX.setLayoutParams(marginLayoutParams5);
            }
            this.eTj = R.color.CAM_X0109;
        }
        setTitleTextColor(this.eTi);
        setSubTitleTextColor(this.eTj);
    }
}
