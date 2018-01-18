package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class h extends LinearLayout {
    private TbImageView aZK;
    private TextView aZL;
    private TextView aZM;
    private TextView aZN;
    private TextView aZO;
    private TextView aZP;
    private TextView aZQ;
    private String aZR;
    private String aZS;
    private View aZT;
    private NoDataViewFactory.ImgType aZU;
    private int aZV;
    private Context mContext;
    private View mRootView;

    public h(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.no_data_view, this);
        this.aZK = (TbImageView) this.mRootView.findViewById(d.g.iv_no_data_img);
        this.aZK.setDefaultBgResource(0);
        this.aZK.setDefaultResource(0);
        this.aZK.setDefaultErrorResource(0);
        this.aZL = (TextView) this.mRootView.findViewById(d.g.tv_text_reamrk);
        this.aZM = (TextView) this.mRootView.findViewById(d.g.tv_subtitle);
        this.aZN = (TextView) this.mRootView.findViewById(d.g.tv_title);
        this.aZO = (TextView) this.mRootView.findViewById(d.g.btn_func);
        this.aZT = (LinearLayout) this.mRootView.findViewById(d.g.two_button_layout);
    }

    public void a(NoDataViewFactory.b bVar, NoDataViewFactory.c cVar, NoDataViewFactory.d dVar) {
        setButtonOption(bVar);
        setImgOption(cVar);
        setTextOption(dVar);
    }

    public void onChangeSkinType(com.baidu.adp.base.e<?> eVar, int i) {
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().aM(i == 1);
            ((TbPageContext) eVar).getLayoutMode().aM(this);
        }
        if (this.aZU == NoDataViewFactory.ImgType.WEBVIEW) {
            this.aZK.setImageBitmap(aj.fQ(d.f.pic_emotion08));
        } else if (this.aZU == NoDataViewFactory.ImgType.NODATA) {
            this.aZK.setImageBitmap(aj.fQ(d.f.no_data_image));
        } else if (this.aZU == NoDataViewFactory.ImgType.LOCAL) {
            this.aZK.setImageBitmap(aj.fQ(this.aZV));
        } else if (i == 1) {
            this.aZK.startLoad(this.aZS, 29, false);
        } else {
            this.aZK.startLoad(this.aZR, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.aZN.setText(dVar.mTitle);
                this.aZN.setVisibility(0);
            } else {
                this.aZN.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.aKN)) {
                this.aZM.setText(dVar.aKN);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.aZM.setTextSize(0, getResources().getDimension(d.e.fontsize28));
                    if (dVar.baf >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aZM.getLayoutParams();
                        layoutParams.topMargin = dVar.baf;
                        this.aZM.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.bag != 0) {
                    setSubTitleCompoundDrawable(dVar.bag);
                }
            } else {
                this.aZM.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.bae)) {
                this.aZL.setText(dVar.bae);
                this.aZL.setVisibility(0);
                return;
            }
            this.aZL.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.aZU = cVar.bab;
            this.aZV = cVar.aZV;
            switch (cVar.bab) {
                case CREATE:
                    this.aZR = com.baidu.tbadk.util.b.Oo().gO("pic_emotion03.png");
                    this.aZS = com.baidu.tbadk.util.b.Oo().gO("pic_emotion03_1.png");
                    break;
                case NODATA:
                    this.aZR = com.baidu.tbadk.util.b.Oo().gO("pic_emotion05.png");
                    this.aZS = com.baidu.tbadk.util.b.Oo().gO("pic_emotion05_1.png");
                    break;
                case FINDBAR:
                    this.aZR = com.baidu.tbadk.util.b.Oo().gO("pic_emotion01.png");
                    this.aZS = com.baidu.tbadk.util.b.Oo().gO("pic_emotion01_1.png");
                    break;
                case EMOTION:
                    this.aZR = com.baidu.tbadk.util.b.Oo().gO("pic_emotion02.png");
                    this.aZS = com.baidu.tbadk.util.b.Oo().gO("pic_emotion02_1.png");
                    break;
                case GIFT:
                    this.aZR = com.baidu.tbadk.util.b.Oo().gO("pic_emotion07.png");
                    this.aZS = com.baidu.tbadk.util.b.Oo().gO("pic_emotion07_1.png");
                    break;
                case SINGALL:
                    this.aZR = com.baidu.tbadk.util.b.Oo().gO("pic_emotion06.png");
                    this.aZS = com.baidu.tbadk.util.b.Oo().gO("pic_emotion06_1.png");
                    break;
                case WEBVIEW:
                    this.aZR = com.baidu.tbadk.util.b.Oo().gO("pic_emotion08.png");
                    this.aZS = com.baidu.tbadk.util.b.Oo().gO("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aZK.getLayoutParams();
            if (cVar.bac >= 0) {
                layoutParams.setMargins(0, cVar.bac, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.aZK.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.aZO.setVisibility(8);
            this.aZT.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.aZY;
        NoDataViewFactory.a aVar2 = bVar.aZZ;
        if (aVar2 == null && aVar != null) {
            this.aZO.setOnClickListener(aVar.aZX);
            this.aZO.setText(aVar.aTp);
            this.aZO.setVisibility(0);
            if (bVar.baa >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aZO.getLayoutParams();
                layoutParams.topMargin = bVar.baa;
                this.aZO.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.aZP = (TextView) this.aZT.findViewById(d.g.btn_left);
            this.aZQ = (TextView) this.aZT.findViewById(d.g.btn_right);
            this.aZP.setOnClickListener(aVar.aZX);
            this.aZP.setText(aVar.aTp);
            this.aZQ.setOnClickListener(aVar2.aZX);
            this.aZQ.setText(aVar2.aTp);
            this.aZT.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onActivityStop() {
        this.aZK.setImageDrawable(null);
        this.aZK.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.aZN != null) {
            aj.e(this.aZN, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.aZM != null) {
            aj.e(this.aZM, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.aZL != null) {
            aj.e(this.aZL, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = aj.getDrawable(i);
        int s = com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds32);
        int s2 = com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds8);
        drawable.setBounds(0, 0, s, s);
        this.aZM.setCompoundDrawablePadding(s2);
        this.aZM.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.aZM;
    }
}
