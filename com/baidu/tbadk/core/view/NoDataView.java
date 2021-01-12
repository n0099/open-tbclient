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
    private TbImageView ffk;
    private LinearLayout ffl;
    private TextView ffm;
    private TextView ffn;
    private TextView ffo;
    private TBSpecificationBtn ffp;
    private TBSpecificationBtn ffq;
    private TBSpecificationBtn ffr;
    private int ffs;
    private View fft;
    private NoDataViewFactory.ImgType ffu;
    private int ffv;
    private int ffw;
    private int ffx;
    private Context mContext;
    private View mRootView;
    private static final int ffy = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds312);
    private static final int ffz = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds84);
    private static final int ffA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    private static final int ffB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds32);
    private static final int alj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);

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
        this.ffk = (TbImageView) this.mRootView.findViewById(R.id.iv_no_data_img);
        this.ffk.setDefaultBgResource(0);
        this.ffk.setDefaultResource(0);
        this.ffl = (LinearLayout) this.mRootView.findViewById(R.id.title_container);
        this.ffm = (TextView) this.mRootView.findViewById(R.id.tv_text_reamrk);
        this.ffn = (TextView) this.mRootView.findViewById(R.id.tv_subtitle);
        this.ffo = (TextView) this.mRootView.findViewById(R.id.tv_title);
        this.ffp = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_func);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.ffp.setTextSize(R.dimen.T_X05);
        this.ffp.setConfig(aVar);
        this.fft = (LinearLayout) this.mRootView.findViewById(R.id.two_button_layout);
        this.ffw = R.color.CAM_X0107;
        this.ffx = R.color.CAM_X0109;
        btC();
    }

    private void btC() {
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        if (equipmentHeight > 0) {
            int i = (int) (equipmentHeight * 0.16d);
            ViewGroup.LayoutParams layoutParams = this.ffk.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.ffk.setLayoutParams(marginLayoutParams);
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
        if (this.ffp != null) {
            this.ffp.btV();
        }
        if (this.ffq != null) {
            this.ffq.btV();
        }
        if (this.ffr != null) {
            this.ffr.btV();
        }
        if (this.ffu == NoDataViewFactory.ImgType.WEBVIEW) {
            this.ffk.setImageBitmap(ao.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else if (this.ffu == NoDataViewFactory.ImgType.NODATA) {
            this.ffk.setImageBitmap(ao.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.ffu == NoDataViewFactory.ImgType.LOCAL) {
            this.ffk.setImageBitmap(ao.getBitmap565Quality(this.ffv));
        } else if (this.ffu == NoDataViewFactory.ImgType.ANTI) {
            this.ffk.setImageBitmap(ao.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.ffu == NoDataViewFactory.ImgType.NETERROR) {
            this.ffk.setImageBitmap(ao.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else {
            this.ffk.setImageBitmap(ao.getBitmap565Quality(this.ffs));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.ffo.setText(dVar.mTitle);
                this.ffo.setVisibility(0);
            } else {
                this.ffo.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.ffn.setVisibility(0);
                this.ffn.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.ffJ >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ffn.getLayoutParams();
                    layoutParams.topMargin = dVar.ffJ;
                    this.ffn.setLayoutParams(layoutParams);
                }
                if (dVar.ffK != 0) {
                    setSubTitleCompoundDrawable(dVar.ffK);
                }
            } else {
                this.ffn.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.ffI)) {
                this.ffm.setText(dVar.ffI);
                this.ffm.setVisibility(0);
            } else {
                this.ffm.setVisibility(8);
            }
            btE();
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.ffu = cVar.ffH;
            this.ffv = cVar.ffv;
            switch (cVar.ffH) {
                case FINDBAR:
                    this.ffs = R.drawable.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.ffs = R.drawable.new_pic_emotion_02;
                    break;
                case CREATE:
                    this.ffs = R.drawable.new_pic_emotion_03;
                    break;
                case COLLECTION:
                    this.ffs = R.drawable.new_pic_emotion_04;
                    break;
                case NODATA:
                    this.ffs = R.drawable.new_pic_emotion_05;
                    break;
                case ANTI:
                    this.ffs = R.drawable.new_pic_emotion_05;
                    break;
                case SINGALL:
                    this.ffs = R.drawable.new_pic_emotion_06;
                    break;
                case GIFT:
                    this.ffs = R.drawable.new_pic_emotion_07;
                    break;
                case WEBVIEW:
                    this.ffs = R.drawable.new_pic_emotion_08;
                    break;
                case NETERROR:
                    this.ffs = R.drawable.new_pic_emotion_08;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ffk.getLayoutParams();
            if (cVar.mMarginTop >= 0) {
                layoutParams.setMargins(0, cVar.mMarginTop, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.ffk.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.ffp.setVisibility(8);
            this.fft.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.ffE;
        NoDataViewFactory.a aVar2 = bVar.ffF;
        if (aVar2 == null && aVar != null) {
            this.ffp.setOnClickListener(aVar.ffD);
            this.ffp.setText(aVar.mText);
            this.ffp.setVisibility(0);
            if (bVar.ffG >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ffp.getLayoutParams();
                layoutParams.topMargin = bVar.ffG;
                this.ffp.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.ffq = (TBSpecificationBtn) this.fft.findViewById(R.id.btn_left);
            this.ffr = (TBSpecificationBtn) this.fft.findViewById(R.id.btn_right);
            com.baidu.tbadk.core.view.commonBtn.a aVar3 = new com.baidu.tbadk.core.view.commonBtn.a();
            this.ffq.setTextSize(R.dimen.ds32);
            this.ffq.setConfig(aVar3);
            this.ffr.setTextSize(R.dimen.ds32);
            this.ffr.setConfig(aVar3);
            this.ffq.setOnClickListener(aVar.ffD);
            this.ffq.setText(aVar.mText);
            this.ffr.setOnClickListener(aVar2.ffD);
            this.ffr.setText(aVar2.mText);
            this.fft.setVisibility(0);
        }
        btE();
    }

    public void e(com.baidu.adp.base.f<?> fVar) {
        onChangeSkinType(fVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void btD() {
        this.ffk.setImageDrawable(null);
        this.ffk.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.ffo != null) {
            ao.setViewTextColor(this.ffo, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.ffn != null) {
            ao.setViewTextColor(this.ffn, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.ffm != null) {
            ao.setViewTextColor(this.ffm, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = ao.getDrawable(i);
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds32);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8);
        drawable.setBounds(0, 0, dimens, dimens);
        this.ffn.setCompoundDrawablePadding(dimens2);
        this.ffn.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.ffn != null) {
            this.ffn.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.ffn;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.f<?> fVar) {
        setImgOption(cVar);
        onChangeSkinType(fVar, TbadkCoreApplication.getInst().getSkinType());
    }

    private void btE() {
        if (this.ffp.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.ffl.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = ffz;
                this.ffl.setLayoutParams(marginLayoutParams);
            }
            this.ffn.setVisibility(8);
            this.ffw = R.color.CAM_X0107;
        } else if (this.ffn.getVisibility() == 8) {
            ViewGroup.LayoutParams layoutParams2 = this.ffl.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams2.topMargin = ffz;
                this.ffl.setLayoutParams(marginLayoutParams2);
            }
            this.ffw = R.color.CAM_X0107;
        } else if (this.ffo.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams3 = this.ffl.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                marginLayoutParams3.topMargin = ffB;
                this.ffl.setLayoutParams(marginLayoutParams3);
            }
            ViewGroup.LayoutParams layoutParams4 = this.ffo.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                marginLayoutParams4.topMargin = alj;
                this.ffo.setLayoutParams(marginLayoutParams4);
            }
            this.ffw = R.color.CAM_X0107;
            this.ffx = R.color.CAM_X0109;
        } else {
            ViewGroup.LayoutParams layoutParams5 = this.ffk.getLayoutParams();
            layoutParams5.width = ffy;
            layoutParams5.height = ffy;
            this.ffk.setLayoutParams(layoutParams5);
            ViewGroup.LayoutParams layoutParams6 = this.ffl.getLayoutParams();
            if (layoutParams6 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams6;
                marginLayoutParams5.topMargin = ffA;
                this.ffl.setLayoutParams(marginLayoutParams5);
            }
            this.ffx = R.color.CAM_X0109;
        }
        setTitleTextColor(this.ffw);
        setSubTitleTextColor(this.ffx);
    }
}
