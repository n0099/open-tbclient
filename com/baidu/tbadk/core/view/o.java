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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class o extends LinearLayout {
    private static /* synthetic */ int[] agy;
    private TbImageView agm;
    private TextView agn;
    private TextView ago;
    private TextView agp;
    private TextView agq;
    private TextView agr;
    private TextView ags;
    private String agt;
    private String agu;
    private View agv;
    private NoDataViewFactory.ImgType agw;
    private int agx;
    private Context mContext;
    private View mRootView;

    static /* synthetic */ int[] wU() {
        int[] iArr = agy;
        if (iArr == null) {
            iArr = new int[NoDataViewFactory.ImgType.valuesCustom().length];
            try {
                iArr[NoDataViewFactory.ImgType.CREATE.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[NoDataViewFactory.ImgType.EMOTION.ordinal()] = 5;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[NoDataViewFactory.ImgType.FINDBAR.ordinal()] = 4;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[NoDataViewFactory.ImgType.GIFT.ordinal()] = 7;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[NoDataViewFactory.ImgType.LOCAL.ordinal()] = 9;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[NoDataViewFactory.ImgType.NODATA.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[NoDataViewFactory.ImgType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[NoDataViewFactory.ImgType.SINGALL.ordinal()] = 6;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[NoDataViewFactory.ImgType.WEBVIEW.ordinal()] = 8;
            } catch (NoSuchFieldError e9) {
            }
            agy = iArr;
        }
        return iArr;
    }

    public o(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(t.h.no_data_view, this);
        this.agm = (TbImageView) this.mRootView.findViewById(t.g.iv_no_data_img);
        this.agm.setDefaultBgResource(0);
        this.agm.setDefaultResource(0);
        this.agn = (TextView) this.mRootView.findViewById(t.g.tv_text_reamrk);
        this.ago = (TextView) this.mRootView.findViewById(t.g.tv_subtitle);
        this.agp = (TextView) this.mRootView.findViewById(t.g.tv_title);
        this.agq = (TextView) this.mRootView.findViewById(t.g.btn_func);
        this.agv = (LinearLayout) this.mRootView.findViewById(t.g.two_button_layout);
    }

    public void a(NoDataViewFactory.b bVar, NoDataViewFactory.c cVar, NoDataViewFactory.d dVar) {
        setButtonOption(bVar);
        setImgOption(cVar);
        setTextOption(dVar);
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ac(i == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this);
        }
        if (this.agw == NoDataViewFactory.ImgType.WEBVIEW) {
            this.agm.setImageBitmap(ar.cQ(t.f.pic_emotion08));
        } else if (this.agw == NoDataViewFactory.ImgType.NODATA) {
            this.agm.setImageBitmap(ar.cQ(t.f.no_data_image));
        } else if (this.agw == NoDataViewFactory.ImgType.LOCAL) {
            this.agm.setImageBitmap(ar.cQ(this.agx));
        } else if (i == 1) {
            this.agm.d(this.agu, 29, false);
        } else {
            this.agm.d(this.agt, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.agp.setText(dVar.mTitle);
                this.agp.setVisibility(0);
            } else {
                this.agp.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.Vn)) {
                this.ago.setText(dVar.Vn);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.ago.setTextSize(0, getResources().getDimension(t.e.fontsize28));
                    if (dVar.agH >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ago.getLayoutParams();
                        layoutParams.topMargin = dVar.agH;
                        this.ago.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.Zt != 0) {
                    setSubTitleCompoundDrawable(dVar.Zt);
                }
            } else {
                this.ago.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.agG)) {
                this.agn.setText(dVar.agG);
                this.agn.setVisibility(0);
                return;
            }
            this.agn.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.agw = cVar.agD;
            this.agx = cVar.agx;
            switch (wU()[cVar.agD.ordinal()]) {
                case 2:
                    this.agt = com.baidu.tbadk.util.b.Gt().fZ("pic_emotion03.png");
                    this.agu = com.baidu.tbadk.util.b.Gt().fZ("pic_emotion03_1.png");
                    break;
                case 3:
                    this.agt = com.baidu.tbadk.util.b.Gt().fZ("pic_emotion05.png");
                    this.agu = com.baidu.tbadk.util.b.Gt().fZ("pic_emotion05_1.png");
                    break;
                case 4:
                    this.agt = com.baidu.tbadk.util.b.Gt().fZ("pic_emotion01.png");
                    this.agu = com.baidu.tbadk.util.b.Gt().fZ("pic_emotion01_1.png");
                    break;
                case 5:
                    this.agt = com.baidu.tbadk.util.b.Gt().fZ("pic_emotion02.png");
                    this.agu = com.baidu.tbadk.util.b.Gt().fZ("pic_emotion02_1.png");
                    break;
                case 6:
                    this.agt = com.baidu.tbadk.util.b.Gt().fZ("pic_emotion06.png");
                    this.agu = com.baidu.tbadk.util.b.Gt().fZ("pic_emotion06_1.png");
                    break;
                case 7:
                    this.agt = com.baidu.tbadk.util.b.Gt().fZ("pic_emotion07.png");
                    this.agu = com.baidu.tbadk.util.b.Gt().fZ("pic_emotion07_1.png");
                    break;
                case 8:
                    this.agt = com.baidu.tbadk.util.b.Gt().fZ("pic_emotion08.png");
                    this.agu = com.baidu.tbadk.util.b.Gt().fZ("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.agm.getLayoutParams();
            if (cVar.agE >= 0) {
                layoutParams.setMargins(0, cVar.agE, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.agm.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.agq.setVisibility(8);
            this.agv.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.agA;
        NoDataViewFactory.a aVar2 = bVar.agB;
        if (aVar2 == null && aVar != null) {
            this.agq.setOnClickListener(aVar.agz);
            this.agq.setText(aVar.aaR);
            this.agq.setVisibility(0);
            if (bVar.agC >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.agq.getLayoutParams();
                layoutParams.topMargin = bVar.agC;
                this.agq.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.agr = (TextView) this.agv.findViewById(t.g.btn_left);
            this.ags = (TextView) this.agv.findViewById(t.g.btn_right);
            this.agr.setOnClickListener(aVar.agz);
            this.agr.setText(aVar.aaR);
            this.ags.setOnClickListener(aVar2.agz);
            this.ags.setText(aVar2.aaR);
            this.agv.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.h<?> hVar) {
        onChangeSkinType(hVar, TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void onActivityStop() {
        this.agm.setImageDrawable(null);
        this.agm.d(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.agp != null) {
            ar.b(this.agp, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.ago != null) {
            ar.b(this.ago, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.agn != null) {
            ar.b(this.agn, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = ar.getDrawable(i);
        int c = com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds32);
        int c2 = com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds8);
        drawable.setBounds(0, 0, c, c);
        this.ago.setCompoundDrawablePadding(c2);
        this.ago.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.ago;
    }
}
