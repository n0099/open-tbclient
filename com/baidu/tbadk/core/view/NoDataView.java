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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class NoDataView extends LinearLayout {
    private LinearLayout etA;
    private TextView etB;
    private TextView etC;
    private TextView etD;
    private TBSpecificationBtn etE;
    private TBSpecificationBtn etF;
    private TBSpecificationBtn etG;
    private int etH;
    private View etI;
    private NoDataViewFactory.ImgType etJ;
    private int etK;
    private TbImageView etz;
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
        this.etz = (TbImageView) this.mRootView.findViewById(R.id.iv_no_data_img);
        this.etz.setDefaultBgResource(0);
        this.etz.setDefaultResource(0);
        this.etz.setDefaultErrorResource(0);
        this.etA = (LinearLayout) this.mRootView.findViewById(R.id.title_container);
        this.etB = (TextView) this.mRootView.findViewById(R.id.tv_text_reamrk);
        this.etC = (TextView) this.mRootView.findViewById(R.id.tv_subtitle);
        this.etD = (TextView) this.mRootView.findViewById(R.id.tv_title);
        this.etE = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_func);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.etE.setTextSize(R.dimen.tbds42);
        this.etE.setConfig(aVar);
        this.etI = (LinearLayout) this.mRootView.findViewById(R.id.two_button_layout);
        blk();
    }

    private void blk() {
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        if (equipmentHeight > 0) {
            int i = (int) (equipmentHeight * 0.11d);
            ViewGroup.LayoutParams layoutParams = this.etz.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.etz.setLayoutParams(marginLayoutParams);
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
        if (this.etE != null) {
            this.etE.blA();
        }
        if (this.etF != null) {
            this.etF.blA();
        }
        if (this.etG != null) {
            this.etG.blA();
        }
        if (this.etJ == NoDataViewFactory.ImgType.WEBVIEW) {
            this.etz.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else if (this.etJ == NoDataViewFactory.ImgType.NODATA) {
            this.etz.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.etJ == NoDataViewFactory.ImgType.LOCAL) {
            this.etz.setImageBitmap(ap.getBitmap565Quality(this.etK));
        } else if (this.etJ == NoDataViewFactory.ImgType.ANTI) {
            this.etz.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (this.etJ == NoDataViewFactory.ImgType.NETERROR) {
            this.etz.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else {
            this.etz.setImageBitmap(ap.getBitmap565Quality(this.etH));
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.etD.setText(dVar.mTitle);
                this.etD.setVisibility(0);
            } else {
                this.etD.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.etC.setVisibility(0);
                this.etC.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle) && dVar.etS >= 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.etC.getLayoutParams();
                    layoutParams.topMargin = dVar.etS;
                    this.etC.setLayoutParams(layoutParams);
                }
                if (dVar.mDrawableId != 0) {
                    setSubTitleCompoundDrawable(dVar.mDrawableId);
                }
            } else {
                this.etC.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.etR)) {
                this.etB.setText(dVar.etR);
                this.etB.setVisibility(0);
                return;
            }
            this.etB.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.etJ = cVar.etQ;
            this.etK = cVar.etK;
            switch (cVar.etQ) {
                case FINDBAR:
                    this.etH = R.drawable.new_pic_emotion_01;
                    break;
                case EMOTION:
                    this.etH = R.drawable.new_pic_emotion_02;
                    break;
                case CREATE:
                    this.etH = R.drawable.new_pic_emotion_03;
                    break;
                case COLLECTION:
                    this.etH = R.drawable.new_pic_emotion_04;
                    break;
                case NODATA:
                    this.etH = R.drawable.new_pic_emotion_05;
                    break;
                case ANTI:
                    this.etH = R.drawable.new_pic_emotion_05;
                    break;
                case SINGALL:
                    this.etH = R.drawable.new_pic_emotion_06;
                    break;
                case GIFT:
                    this.etH = R.drawable.new_pic_emotion_07;
                    break;
                case WEBVIEW:
                    this.etH = R.drawable.new_pic_emotion_08;
                    break;
                case NETERROR:
                    this.etH = R.drawable.new_pic_emotion_08;
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.etz.getLayoutParams();
            if (cVar.mMarginTop >= 0) {
                layoutParams.setMargins(0, cVar.mMarginTop, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.etz.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.etE.setVisibility(8);
            this.etI.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.etN;
        NoDataViewFactory.a aVar2 = bVar.etO;
        if (aVar2 == null && aVar != null) {
            this.etE.setOnClickListener(aVar.etM);
            this.etE.setText(aVar.mText);
            this.etE.setVisibility(0);
            if (bVar.etP >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.etE.getLayoutParams();
                layoutParams.topMargin = bVar.etP;
                this.etE.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.etF = (TBSpecificationBtn) this.etI.findViewById(R.id.btn_left);
            this.etG = (TBSpecificationBtn) this.etI.findViewById(R.id.btn_right);
            com.baidu.tbadk.core.view.commonBtn.a aVar3 = new com.baidu.tbadk.core.view.commonBtn.a();
            this.etF.setTextSize(R.dimen.ds32);
            this.etF.setConfig(aVar3);
            this.etG.setTextSize(R.dimen.ds32);
            this.etG.setConfig(aVar3);
            this.etF.setOnClickListener(aVar.etM);
            this.etF.setText(aVar.mText);
            this.etG.setOnClickListener(aVar2.etM);
            this.etG.setText(aVar2.mText);
            this.etI.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void bll() {
        this.etz.setImageDrawable(null);
        this.etz.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.etD != null) {
            ap.setViewTextColor(this.etD, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.etC != null) {
            ap.setViewTextColor(this.etC, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.etB != null) {
            ap.setViewTextColor(this.etB, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = ap.getDrawable(i);
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds32);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8);
        drawable.setBounds(0, 0, dimens, dimens);
        this.etC.setCompoundDrawablePadding(dimens2);
        this.etC.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.etC != null) {
            this.etC.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.etC;
    }

    public void a(NoDataViewFactory.c cVar, com.baidu.adp.base.e<?> eVar) {
        setImgOption(cVar);
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTitleContainerMargin(@DimenRes int i, @DimenRes int i2) {
        if (this.etA != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.etA.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, i2);
        }
    }
}
