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
    private TbImageView fjc;
    private LinearLayout fjd;
    private TextView fje;
    private TextView fjf;
    private TextView fjg;
    private TBSpecificationBtn fjh;
    private TBSpecificationBtn fji;
    private TBSpecificationBtn fjj;
    private int fjk;
    private View fjl;
    private NoDataViewFactory.ImgType fjm;
    private int fjn;
    private int fjo;
    private int fjp;
    private Context mContext;
    private View mRootView;
    private static final int fjq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds312);
    private static final int fjr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds84);
    private static final int fjs = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    private static final int fjt = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds32);
    private static final int ams = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);

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
        this.fjc = (TbImageView) this.mRootView.findViewById(R.id.iv_no_data_img);
        this.fjc.setDefaultBgResource(0);
        this.fjc.setDefaultResource(0);
        this.fjd = (LinearLayout) this.mRootView.findViewById(R.id.title_container);
        this.fje = (TextView) this.mRootView.findViewById(R.id.tv_text_reamrk);
        this.fjf = (TextView) this.mRootView.findViewById(R.id.tv_subtitle);
        this.fjg = (TextView) this.mRootView.findViewById(R.id.tv_title);
        this.fjh = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_func);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.fjh.setTextSize(R.dimen.T_X05);
        this.fjh.setConfig(aVar);
        this.fjl = (LinearLayout) this.mRootView.findViewById(R.id.two_button_layout);
        this.fjo = R.color.CAM_X0107;
        this.fjp = R.color.CAM_X0109;
        btZ();
    }

    private void btZ() {
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        if (equipmentHeight > 0) {
            int i = (int) (equipmentHeight * 0.16d);
            ViewGroup.LayoutParams layoutParams = this.fjc.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.fjc.setLayoutParams(marginLayoutParams);
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
        if (this.fjh != null) {
            this.fjh.bus();
        }
        if (this.fji != null) {
            this.fji.bus();
        }
        if (this.fjj != null) {
            this.fjj.bus();
        }
        if (this.fjm == NoDataViewFactory.ImgType.WEBVIEW) {
            this.fjc.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else if (this.fjm == NoDataViewFactory.ImgType.NODATA) {
            this.fjc.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.fjm == NoDataViewFactory.ImgType.LOCAL) {
            this.fjc.setImageBitmap(ap.getBitmap565Quality(this.fjn));
        } else if (this.fjm == NoDataViewFactory.ImgType.ANTI) {
            this.fjc.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.fjm == NoDataViewFactory.ImgType.NETERROR) {
            this.fjc.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else {
            this.fjc.setImageBitmap(ap.getBitmap565Quality(this.fjk));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.fjg.setText(dVar.mTitle);
                this.fjg.setVisibility(0);
            } else {
                this.fjg.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.fjf.setVisibility(0);
                this.fjf.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.fjB >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fjf.getLayoutParams();
                    layoutParams.topMargin = dVar.fjB;
                    this.fjf.setLayoutParams(layoutParams);
                }
                if (dVar.fjC != 0) {
                    setSubTitleCompoundDrawable(dVar.fjC);
                }
            } else {
                this.fjf.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.fjA)) {
                this.fje.setText(dVar.fjA);
                this.fje.setVisibility(0);
            } else {
                this.fje.setVisibility(8);
            }
            bub();
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.fjm = cVar.fjz;
            this.fjn = cVar.fjn;
            switch (cVar.fjz) {
                case FINDBAR:
                    this.fjk = R.drawable.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.fjk = R.drawable.new_pic_emotion_02;
                    break;
                case CREATE:
                    this.fjk = R.drawable.new_pic_emotion_03;
                    break;
                case COLLECTION:
                    this.fjk = R.drawable.new_pic_emotion_04;
                    break;
                case NODATA:
                    this.fjk = R.drawable.new_pic_emotion_05;
                    break;
                case ANTI:
                    this.fjk = R.drawable.new_pic_emotion_05;
                    break;
                case SINGALL:
                    this.fjk = R.drawable.new_pic_emotion_06;
                    break;
                case GIFT:
                    this.fjk = R.drawable.new_pic_emotion_07;
                    break;
                case WEBVIEW:
                    this.fjk = R.drawable.new_pic_emotion_08;
                    break;
                case NETERROR:
                    this.fjk = R.drawable.new_pic_emotion_08;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fjc.getLayoutParams();
            if (cVar.mMarginTop >= 0) {
                layoutParams.setMargins(0, cVar.mMarginTop, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.fjc.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.fjh.setVisibility(8);
            this.fjl.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.fjw;
        NoDataViewFactory.a aVar2 = bVar.fjx;
        if (aVar2 == null && aVar != null) {
            this.fjh.setOnClickListener(aVar.fjv);
            this.fjh.setText(aVar.mText);
            this.fjh.setVisibility(0);
            if (bVar.fjy >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fjh.getLayoutParams();
                layoutParams.topMargin = bVar.fjy;
                this.fjh.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.fji = (TBSpecificationBtn) this.fjl.findViewById(R.id.btn_left);
            this.fjj = (TBSpecificationBtn) this.fjl.findViewById(R.id.btn_right);
            com.baidu.tbadk.core.view.commonBtn.a aVar3 = new com.baidu.tbadk.core.view.commonBtn.a();
            this.fji.setTextSize(R.dimen.ds32);
            this.fji.setConfig(aVar3);
            this.fjj.setTextSize(R.dimen.ds32);
            this.fjj.setConfig(aVar3);
            this.fji.setOnClickListener(aVar.fjv);
            this.fji.setText(aVar.mText);
            this.fjj.setOnClickListener(aVar2.fjv);
            this.fjj.setText(aVar2.mText);
            this.fjl.setVisibility(0);
        }
        bub();
    }

    public void e(com.baidu.adp.base.f<?> fVar) {
        onChangeSkinType(fVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void bua() {
        this.fjc.setImageDrawable(null);
        this.fjc.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.fjg != null) {
            ap.setViewTextColor(this.fjg, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.fjf != null) {
            ap.setViewTextColor(this.fjf, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.fje != null) {
            ap.setViewTextColor(this.fje, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = ap.getDrawable(i);
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds32);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8);
        drawable.setBounds(0, 0, dimens, dimens);
        this.fjf.setCompoundDrawablePadding(dimens2);
        this.fjf.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.fjf != null) {
            this.fjf.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.fjf;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.f<?> fVar) {
        setImgOption(cVar);
        onChangeSkinType(fVar, TbadkCoreApplication.getInst().getSkinType());
    }

    private void bub() {
        if (this.fjh.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.fjd.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = fjr;
                this.fjd.setLayoutParams(marginLayoutParams);
            }
            this.fjf.setVisibility(8);
            this.fjo = R.color.CAM_X0107;
        } else if (this.fjf.getVisibility() == 8) {
            ViewGroup.LayoutParams layoutParams2 = this.fjd.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams2.topMargin = fjr;
                this.fjd.setLayoutParams(marginLayoutParams2);
            }
            this.fjo = R.color.CAM_X0107;
        } else if (this.fjg.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams3 = this.fjd.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                marginLayoutParams3.topMargin = fjt;
                this.fjd.setLayoutParams(marginLayoutParams3);
            }
            ViewGroup.LayoutParams layoutParams4 = this.fjg.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                marginLayoutParams4.topMargin = ams;
                this.fjg.setLayoutParams(marginLayoutParams4);
            }
            this.fjo = R.color.CAM_X0107;
            this.fjp = R.color.CAM_X0109;
        } else {
            ViewGroup.LayoutParams layoutParams5 = this.fjc.getLayoutParams();
            layoutParams5.width = fjq;
            layoutParams5.height = fjq;
            this.fjc.setLayoutParams(layoutParams5);
            ViewGroup.LayoutParams layoutParams6 = this.fjd.getLayoutParams();
            if (layoutParams6 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams6;
                marginLayoutParams5.topMargin = fjs;
                this.fjd.setLayoutParams(marginLayoutParams5);
            }
            this.fjp = R.color.CAM_X0109;
        }
        setTitleTextColor(this.fjo);
        setSubTitleTextColor(this.fjp);
    }
}
