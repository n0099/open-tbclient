package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class g extends LinearLayout {
    private TbImageView alI;
    private TextView alJ;
    private TextView alK;
    private TextView alL;
    private TextView alM;
    private TextView alN;
    private TextView alO;
    private String alP;
    private String alQ;
    private View alR;
    private NoDataViewFactory.ImgType alS;
    private int alT;
    private Context mContext;
    private View mRootView;

    public g(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.no_data_view, this);
        this.alI = (TbImageView) this.mRootView.findViewById(d.g.iv_no_data_img);
        this.alI.setDefaultBgResource(0);
        this.alI.setDefaultResource(0);
        this.alI.setDefaultErrorResource(0);
        this.alJ = (TextView) this.mRootView.findViewById(d.g.tv_text_reamrk);
        this.alK = (TextView) this.mRootView.findViewById(d.g.tv_subtitle);
        this.alL = (TextView) this.mRootView.findViewById(d.g.tv_title);
        this.alM = (TextView) this.mRootView.findViewById(d.g.btn_func);
        this.alR = (LinearLayout) this.mRootView.findViewById(d.g.two_button_layout);
    }

    public void a(NoDataViewFactory.b bVar, NoDataViewFactory.c cVar, NoDataViewFactory.d dVar) {
        setButtonOption(bVar);
        setImgOption(cVar);
        setTextOption(dVar);
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().ag(i == 1);
            ((TbPageContext) eVar).getLayoutMode().t(this);
        }
        if (this.alS == NoDataViewFactory.ImgType.WEBVIEW) {
            this.alI.setImageBitmap(aj.cT(d.f.pic_emotion08));
        } else if (this.alS == NoDataViewFactory.ImgType.NODATA) {
            this.alI.setImageBitmap(aj.cT(d.f.no_data_image));
        } else if (this.alS == NoDataViewFactory.ImgType.LOCAL) {
            this.alI.setImageBitmap(aj.cT(this.alT));
        } else if (i == 1) {
            this.alI.startLoad(this.alQ, 29, false);
        } else {
            this.alI.startLoad(this.alP, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.alL.setText(dVar.mTitle);
                this.alL.setVisibility(0);
            } else {
                this.alL.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.Wp)) {
                this.alK.setText(dVar.Wp);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.alK.setTextSize(0, getResources().getDimension(d.e.fontsize28));
                    if (dVar.amd >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alK.getLayoutParams();
                        layoutParams.topMargin = dVar.amd;
                        this.alK.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.ame != 0) {
                    setSubTitleCompoundDrawable(dVar.ame);
                }
            } else {
                this.alK.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.amc)) {
                this.alJ.setText(dVar.amc);
                this.alJ.setVisibility(0);
                return;
            }
            this.alJ.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.alS = cVar.alZ;
            this.alT = cVar.alT;
            switch (cVar.alZ) {
                case CREATE:
                    this.alP = com.baidu.tbadk.util.b.Hb().gK("pic_emotion03.png");
                    this.alQ = com.baidu.tbadk.util.b.Hb().gK("pic_emotion03_1.png");
                    break;
                case NODATA:
                    this.alP = com.baidu.tbadk.util.b.Hb().gK("pic_emotion05.png");
                    this.alQ = com.baidu.tbadk.util.b.Hb().gK("pic_emotion05_1.png");
                    break;
                case FINDBAR:
                    this.alP = com.baidu.tbadk.util.b.Hb().gK("pic_emotion01.png");
                    this.alQ = com.baidu.tbadk.util.b.Hb().gK("pic_emotion01_1.png");
                    break;
                case EMOTION:
                    this.alP = com.baidu.tbadk.util.b.Hb().gK("pic_emotion02.png");
                    this.alQ = com.baidu.tbadk.util.b.Hb().gK("pic_emotion02_1.png");
                    break;
                case GIFT:
                    this.alP = com.baidu.tbadk.util.b.Hb().gK("pic_emotion07.png");
                    this.alQ = com.baidu.tbadk.util.b.Hb().gK("pic_emotion07_1.png");
                    break;
                case SINGALL:
                    this.alP = com.baidu.tbadk.util.b.Hb().gK("pic_emotion06.png");
                    this.alQ = com.baidu.tbadk.util.b.Hb().gK("pic_emotion06_1.png");
                    break;
                case WEBVIEW:
                    this.alP = com.baidu.tbadk.util.b.Hb().gK("pic_emotion08.png");
                    this.alQ = com.baidu.tbadk.util.b.Hb().gK("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alI.getLayoutParams();
            if (cVar.ama >= 0) {
                layoutParams.setMargins(0, cVar.ama, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.alI.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.alM.setVisibility(8);
            this.alR.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.alW;
        NoDataViewFactory.a aVar2 = bVar.alX;
        if (aVar2 == null && aVar != null) {
            this.alM.setOnClickListener(aVar.alV);
            this.alM.setText(aVar.afc);
            this.alM.setVisibility(0);
            if (bVar.alY >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alM.getLayoutParams();
                layoutParams.topMargin = bVar.alY;
                this.alM.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.alN = (TextView) this.alR.findViewById(d.g.btn_left);
            this.alO = (TextView) this.alR.findViewById(d.g.btn_right);
            this.alN.setOnClickListener(aVar.alV);
            this.alN.setText(aVar.afc);
            this.alO.setOnClickListener(aVar2.alV);
            this.alO.setText(aVar2.afc);
            this.alR.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onActivityStop() {
        this.alI.setImageDrawable(null);
        this.alI.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.alL != null) {
            aj.c(this.alL, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.alK != null) {
            aj.c(this.alK, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.alJ != null) {
            aj.c(this.alJ, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = aj.getDrawable(i);
        int f = l.f(this.mContext, d.e.ds32);
        int f2 = l.f(this.mContext, d.e.ds8);
        drawable.setBounds(0, 0, f, f);
        this.alK.setCompoundDrawablePadding(f2);
        this.alK.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.alK;
    }
}
