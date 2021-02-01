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
    private TbImageView fhA;
    private LinearLayout fhB;
    private TextView fhC;
    private TextView fhD;
    private TextView fhE;
    private TBSpecificationBtn fhF;
    private TBSpecificationBtn fhG;
    private TBSpecificationBtn fhH;
    private int fhI;
    private View fhJ;
    private NoDataViewFactory.ImgType fhK;
    private int fhL;
    private int fhM;
    private int fhN;
    private Context mContext;
    private View mRootView;
    private static final int fhO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds312);
    private static final int fhP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds84);
    private static final int fhQ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    private static final int fhR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds32);
    private static final int akZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);

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
        this.fhA = (TbImageView) this.mRootView.findViewById(R.id.iv_no_data_img);
        this.fhA.setDefaultBgResource(0);
        this.fhA.setDefaultResource(0);
        this.fhB = (LinearLayout) this.mRootView.findViewById(R.id.title_container);
        this.fhC = (TextView) this.mRootView.findViewById(R.id.tv_text_reamrk);
        this.fhD = (TextView) this.mRootView.findViewById(R.id.tv_subtitle);
        this.fhE = (TextView) this.mRootView.findViewById(R.id.tv_title);
        this.fhF = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_func);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.fhF.setTextSize(R.dimen.T_X05);
        this.fhF.setConfig(aVar);
        this.fhJ = (LinearLayout) this.mRootView.findViewById(R.id.two_button_layout);
        this.fhM = R.color.CAM_X0107;
        this.fhN = R.color.CAM_X0109;
        btW();
    }

    private void btW() {
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        if (equipmentHeight > 0) {
            int i = (int) (equipmentHeight * 0.16d);
            ViewGroup.LayoutParams layoutParams = this.fhA.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.fhA.setLayoutParams(marginLayoutParams);
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
        if (this.fhF != null) {
            this.fhF.bup();
        }
        if (this.fhG != null) {
            this.fhG.bup();
        }
        if (this.fhH != null) {
            this.fhH.bup();
        }
        if (this.fhK == NoDataViewFactory.ImgType.WEBVIEW) {
            this.fhA.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else if (this.fhK == NoDataViewFactory.ImgType.NODATA) {
            this.fhA.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.fhK == NoDataViewFactory.ImgType.LOCAL) {
            this.fhA.setImageBitmap(ap.getBitmap565Quality(this.fhL));
        } else if (this.fhK == NoDataViewFactory.ImgType.ANTI) {
            this.fhA.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.fhK == NoDataViewFactory.ImgType.NETERROR) {
            this.fhA.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else {
            this.fhA.setImageBitmap(ap.getBitmap565Quality(this.fhI));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.fhE.setText(dVar.mTitle);
                this.fhE.setVisibility(0);
            } else {
                this.fhE.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.fhD.setVisibility(0);
                this.fhD.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.fhZ >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fhD.getLayoutParams();
                    layoutParams.topMargin = dVar.fhZ;
                    this.fhD.setLayoutParams(layoutParams);
                }
                if (dVar.fia != 0) {
                    setSubTitleCompoundDrawable(dVar.fia);
                }
            } else {
                this.fhD.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.fhY)) {
                this.fhC.setText(dVar.fhY);
                this.fhC.setVisibility(0);
            } else {
                this.fhC.setVisibility(8);
            }
            btY();
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.fhK = cVar.fhX;
            this.fhL = cVar.fhL;
            switch (cVar.fhX) {
                case FINDBAR:
                    this.fhI = R.drawable.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.fhI = R.drawable.new_pic_emotion_02;
                    break;
                case CREATE:
                    this.fhI = R.drawable.new_pic_emotion_03;
                    break;
                case COLLECTION:
                    this.fhI = R.drawable.new_pic_emotion_04;
                    break;
                case NODATA:
                    this.fhI = R.drawable.new_pic_emotion_05;
                    break;
                case ANTI:
                    this.fhI = R.drawable.new_pic_emotion_05;
                    break;
                case SINGALL:
                    this.fhI = R.drawable.new_pic_emotion_06;
                    break;
                case GIFT:
                    this.fhI = R.drawable.new_pic_emotion_07;
                    break;
                case WEBVIEW:
                    this.fhI = R.drawable.new_pic_emotion_08;
                    break;
                case NETERROR:
                    this.fhI = R.drawable.new_pic_emotion_08;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fhA.getLayoutParams();
            if (cVar.mMarginTop >= 0) {
                layoutParams.setMargins(0, cVar.mMarginTop, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.fhA.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.fhF.setVisibility(8);
            this.fhJ.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.fhU;
        NoDataViewFactory.a aVar2 = bVar.fhV;
        if (aVar2 == null && aVar != null) {
            this.fhF.setOnClickListener(aVar.fhT);
            this.fhF.setText(aVar.mText);
            this.fhF.setVisibility(0);
            if (bVar.fhW >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fhF.getLayoutParams();
                layoutParams.topMargin = bVar.fhW;
                this.fhF.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.fhG = (TBSpecificationBtn) this.fhJ.findViewById(R.id.btn_left);
            this.fhH = (TBSpecificationBtn) this.fhJ.findViewById(R.id.btn_right);
            com.baidu.tbadk.core.view.commonBtn.a aVar3 = new com.baidu.tbadk.core.view.commonBtn.a();
            this.fhG.setTextSize(R.dimen.ds32);
            this.fhG.setConfig(aVar3);
            this.fhH.setTextSize(R.dimen.ds32);
            this.fhH.setConfig(aVar3);
            this.fhG.setOnClickListener(aVar.fhT);
            this.fhG.setText(aVar.mText);
            this.fhH.setOnClickListener(aVar2.fhT);
            this.fhH.setText(aVar2.mText);
            this.fhJ.setVisibility(0);
        }
        btY();
    }

    public void e(com.baidu.adp.base.f<?> fVar) {
        onChangeSkinType(fVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void btX() {
        this.fhA.setImageDrawable(null);
        this.fhA.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.fhE != null) {
            ap.setViewTextColor(this.fhE, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.fhD != null) {
            ap.setViewTextColor(this.fhD, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.fhC != null) {
            ap.setViewTextColor(this.fhC, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = ap.getDrawable(i);
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds32);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8);
        drawable.setBounds(0, 0, dimens, dimens);
        this.fhD.setCompoundDrawablePadding(dimens2);
        this.fhD.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.fhD != null) {
            this.fhD.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.fhD;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.f<?> fVar) {
        setImgOption(cVar);
        onChangeSkinType(fVar, TbadkCoreApplication.getInst().getSkinType());
    }

    private void btY() {
        if (this.fhF.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.fhB.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = fhP;
                this.fhB.setLayoutParams(marginLayoutParams);
            }
            this.fhD.setVisibility(8);
            this.fhM = R.color.CAM_X0107;
        } else if (this.fhD.getVisibility() == 8) {
            ViewGroup.LayoutParams layoutParams2 = this.fhB.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams2.topMargin = fhP;
                this.fhB.setLayoutParams(marginLayoutParams2);
            }
            this.fhM = R.color.CAM_X0107;
        } else if (this.fhE.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams3 = this.fhB.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                marginLayoutParams3.topMargin = fhR;
                this.fhB.setLayoutParams(marginLayoutParams3);
            }
            ViewGroup.LayoutParams layoutParams4 = this.fhE.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                marginLayoutParams4.topMargin = akZ;
                this.fhE.setLayoutParams(marginLayoutParams4);
            }
            this.fhM = R.color.CAM_X0107;
            this.fhN = R.color.CAM_X0109;
        } else {
            ViewGroup.LayoutParams layoutParams5 = this.fhA.getLayoutParams();
            layoutParams5.width = fhO;
            layoutParams5.height = fhO;
            this.fhA.setLayoutParams(layoutParams5);
            ViewGroup.LayoutParams layoutParams6 = this.fhB.getLayoutParams();
            if (layoutParams6 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams6;
                marginLayoutParams5.topMargin = fhQ;
                this.fhB.setLayoutParams(marginLayoutParams5);
            }
            this.fhN = R.color.CAM_X0109;
        }
        setTitleTextColor(this.fhM);
        setSubTitleTextColor(this.fhN);
    }
}
