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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class w extends LinearLayout {
    private static /* synthetic */ int[] ags;
    private TbImageView agg;
    private TextView agh;
    private TextView agi;
    private TextView agj;
    private TextView agk;
    private TextView agl;
    private TextView agm;
    private String agn;
    private String ago;
    private View agp;
    private NoDataViewFactory.ImgType agq;
    private int agr;
    private Context mContext;
    private View mRootView;

    static /* synthetic */ int[] wv() {
        int[] iArr = ags;
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
            ags = iArr;
        }
        return iArr;
    }

    public w(Context context) {
        super(context);
        this.mContext = context;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(r.h.no_data_view, this);
        this.agg = (TbImageView) this.mRootView.findViewById(r.g.iv_no_data_img);
        this.agg.setDefaultBgResource(0);
        this.agg.setDefaultResource(0);
        this.agg.setDefaultErrorResource(0);
        this.agh = (TextView) this.mRootView.findViewById(r.g.tv_text_reamrk);
        this.agi = (TextView) this.mRootView.findViewById(r.g.tv_subtitle);
        this.agj = (TextView) this.mRootView.findViewById(r.g.tv_title);
        this.agk = (TextView) this.mRootView.findViewById(r.g.btn_func);
        this.agp = (LinearLayout) this.mRootView.findViewById(r.g.two_button_layout);
    }

    public void a(NoDataViewFactory.b bVar, NoDataViewFactory.c cVar, NoDataViewFactory.d dVar) {
        setButtonOption(bVar);
        setImgOption(cVar);
        setTextOption(dVar);
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ai(i == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this);
        }
        if (this.agq == NoDataViewFactory.ImgType.WEBVIEW) {
            this.agg.setImageBitmap(at.cQ(r.f.pic_emotion08));
        } else if (this.agq == NoDataViewFactory.ImgType.NODATA) {
            this.agg.setImageBitmap(at.cQ(r.f.no_data_image));
        } else if (this.agq == NoDataViewFactory.ImgType.LOCAL) {
            this.agg.setImageBitmap(at.cQ(this.agr));
        } else if (i == 1) {
            this.agg.c(this.ago, 29, false);
        } else {
            this.agg.c(this.agn, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.agj.setText(dVar.mTitle);
                this.agj.setVisibility(0);
            } else {
                this.agj.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.mSubTitle)) {
                this.agi.setText(dVar.mSubTitle);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.agi.setTextSize(0, getResources().getDimension(r.e.fontsize28));
                    if (dVar.agB >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.agi.getLayoutParams();
                        layoutParams.topMargin = dVar.agB;
                        this.agi.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.XA != 0) {
                    setSubTitleCompoundDrawable(dVar.XA);
                }
            } else {
                this.agi.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.agA)) {
                this.agh.setText(dVar.agA);
                this.agh.setVisibility(0);
                return;
            }
            this.agh.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.agq = cVar.agx;
            this.agr = cVar.agr;
            switch (wv()[cVar.agx.ordinal()]) {
                case 2:
                    this.agn = com.baidu.tbadk.util.b.GT().gq("pic_emotion03.png");
                    this.ago = com.baidu.tbadk.util.b.GT().gq("pic_emotion03_1.png");
                    break;
                case 3:
                    this.agn = com.baidu.tbadk.util.b.GT().gq("pic_emotion05.png");
                    this.ago = com.baidu.tbadk.util.b.GT().gq("pic_emotion05_1.png");
                    break;
                case 4:
                    this.agn = com.baidu.tbadk.util.b.GT().gq("pic_emotion01.png");
                    this.ago = com.baidu.tbadk.util.b.GT().gq("pic_emotion01_1.png");
                    break;
                case 5:
                    this.agn = com.baidu.tbadk.util.b.GT().gq("pic_emotion02.png");
                    this.ago = com.baidu.tbadk.util.b.GT().gq("pic_emotion02_1.png");
                    break;
                case 6:
                    this.agn = com.baidu.tbadk.util.b.GT().gq("pic_emotion06.png");
                    this.ago = com.baidu.tbadk.util.b.GT().gq("pic_emotion06_1.png");
                    break;
                case 7:
                    this.agn = com.baidu.tbadk.util.b.GT().gq("pic_emotion07.png");
                    this.ago = com.baidu.tbadk.util.b.GT().gq("pic_emotion07_1.png");
                    break;
                case 8:
                    this.agn = com.baidu.tbadk.util.b.GT().gq("pic_emotion08.png");
                    this.ago = com.baidu.tbadk.util.b.GT().gq("pic_emotion08_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.agg.getLayoutParams();
            if (cVar.agy >= 0) {
                layoutParams.setMargins(0, cVar.agy, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.agg.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.agk.setVisibility(8);
            this.agp.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.agu;
        NoDataViewFactory.a aVar2 = bVar.agv;
        if (aVar2 == null && aVar != null) {
            this.agk.setOnClickListener(aVar.agt);
            this.agk.setText(aVar.aaa);
            this.agk.setVisibility(0);
            if (bVar.agw >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.agk.getLayoutParams();
                layoutParams.topMargin = bVar.agw;
                this.agk.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.agl = (TextView) this.agp.findViewById(r.g.btn_left);
            this.agm = (TextView) this.agp.findViewById(r.g.btn_right);
            this.agl.setOnClickListener(aVar.agt);
            this.agl.setText(aVar.aaa);
            this.agm.setOnClickListener(aVar2.agt);
            this.agm.setText(aVar2.aaa);
            this.agp.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.h<?> hVar) {
        onChangeSkinType(hVar, TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void onActivityStop() {
        this.agg.setImageDrawable(null);
        this.agg.c(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.agj != null) {
            at.c(this.agj, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.agi != null) {
            at.c(this.agi, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.agh != null) {
            at.c(this.agh, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = at.getDrawable(i);
        int e = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds32);
        int e2 = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds8);
        drawable.setBounds(0, 0, e, e);
        this.agi.setCompoundDrawablePadding(e2);
        this.agi.setCompoundDrawables(drawable, null, null, null);
    }

    public TextView getSuTextView() {
        return this.agi;
    }
}
