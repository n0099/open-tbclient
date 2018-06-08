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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class NoDataView extends LinearLayout {
    private TbImageView avd;
    private TextView ave;
    private TextView avf;
    private TextView avg;
    private TextView avh;
    private TextView avi;
    private TextView avj;
    private String avk;
    private String avl;
    private View avm;
    private NoDataViewFactory.ImgType avn;
    private int avo;
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
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.no_data_view, this);
        this.avd = (TbImageView) this.mRootView.findViewById(d.g.iv_no_data_img);
        this.avd.setDefaultBgResource(0);
        this.avd.setDefaultResource(0);
        this.avd.setDefaultErrorResource(0);
        this.ave = (TextView) this.mRootView.findViewById(d.g.tv_text_reamrk);
        this.avf = (TextView) this.mRootView.findViewById(d.g.tv_subtitle);
        this.avg = (TextView) this.mRootView.findViewById(d.g.tv_title);
        this.avh = (TextView) this.mRootView.findViewById(d.g.btn_func);
        this.avm = (LinearLayout) this.mRootView.findViewById(d.g.two_button_layout);
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
        if (this.avn == NoDataViewFactory.ImgType.WEBVIEW) {
            this.avd.setImageBitmap(al.cS(d.f.pic_emotion08));
        } else if (this.avn == NoDataViewFactory.ImgType.NODATA) {
            this.avd.setImageBitmap(al.cS(d.f.no_data_image));
        } else if (this.avn == NoDataViewFactory.ImgType.LOCAL) {
            this.avd.setImageBitmap(al.cS(this.avo));
        } else if (this.avn == NoDataViewFactory.ImgType.ANTI) {
            this.avd.setImageBitmap(al.cS(d.f.pic_emotion05));
        } else if (i == 1) {
            this.avd.startLoad(this.avl, 29, false);
        } else {
            this.avd.startLoad(this.avk, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.avg.setText(dVar.mTitle);
                this.avg.setVisibility(0);
            } else {
                this.avg.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.afx)) {
                this.avf.setText(dVar.afx);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.avf.setTextSize(0, getResources().getDimension(d.e.fontsize28));
                    if (dVar.avx >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.avf.getLayoutParams();
                        layoutParams.topMargin = dVar.avx;
                        this.avf.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.avy != 0) {
                    setSubTitleCompoundDrawable(dVar.avy);
                }
            } else {
                this.avf.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.avw)) {
                this.ave.setText(dVar.avw);
                this.ave.setVisibility(0);
                return;
            }
            this.ave.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.avn = cVar.avu;
            this.avo = cVar.avo;
            switch (cVar.avu) {
                case CREATE:
                    this.avk = com.baidu.tbadk.util.b.KQ().hs("pic_emotion03.png");
                    this.avl = com.baidu.tbadk.util.b.KQ().hs("pic_emotion03_1.png");
                    break;
                case NODATA:
                    this.avk = com.baidu.tbadk.util.b.KQ().hs("pic_emotion05.png");
                    this.avl = com.baidu.tbadk.util.b.KQ().hs("pic_emotion05_1.png");
                    break;
                case FINDBAR:
                    this.avk = com.baidu.tbadk.util.b.KQ().hs("pic_emotion01.png");
                    this.avl = com.baidu.tbadk.util.b.KQ().hs("pic_emotion01_1.png");
                    break;
                case EMOTION:
                    this.avk = com.baidu.tbadk.util.b.KQ().hs("pic_emotion02.png");
                    this.avl = com.baidu.tbadk.util.b.KQ().hs("pic_emotion02_1.png");
                    break;
                case GIFT:
                    this.avk = com.baidu.tbadk.util.b.KQ().hs("pic_emotion07.png");
                    this.avl = com.baidu.tbadk.util.b.KQ().hs("pic_emotion07_1.png");
                    break;
                case SINGALL:
                    this.avk = com.baidu.tbadk.util.b.KQ().hs("pic_emotion06.png");
                    this.avl = com.baidu.tbadk.util.b.KQ().hs("pic_emotion06_1.png");
                    break;
                case WEBVIEW:
                    this.avk = com.baidu.tbadk.util.b.KQ().hs("pic_emotion08.png");
                    this.avl = com.baidu.tbadk.util.b.KQ().hs("pic_emotion08_1.png");
                    break;
                case ANTI:
                    this.avk = com.baidu.tbadk.util.b.KQ().hs("pic_emotion05.png");
                    this.avl = com.baidu.tbadk.util.b.KQ().hs("pic_emotion05_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.avd.getLayoutParams();
            if (cVar.avv >= 0) {
                layoutParams.setMargins(0, cVar.avv, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.avd.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.avh.setVisibility(8);
            this.avm.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.avr;
        NoDataViewFactory.a aVar2 = bVar.avs;
        if (aVar2 == null && aVar != null) {
            this.avh.setOnClickListener(aVar.avq);
            this.avh.setText(aVar.aon);
            this.avh.setVisibility(0);
            if (bVar.avt >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.avh.getLayoutParams();
                layoutParams.topMargin = bVar.avt;
                this.avh.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.avi = (TextView) this.avm.findViewById(d.g.btn_left);
            this.avj = (TextView) this.avm.findViewById(d.g.btn_right);
            this.avi.setOnClickListener(aVar.avq);
            this.avi.setText(aVar.aon);
            this.avj.setOnClickListener(aVar2.avq);
            this.avj.setText(aVar2.aon);
            this.avm.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onActivityStop() {
        this.avd.setImageDrawable(null);
        this.avd.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.avg != null) {
            al.c(this.avg, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.avf != null) {
            al.c(this.avf, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.ave != null) {
            al.c(this.ave, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = al.getDrawable(i);
        int e = com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds32);
        int e2 = com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds8);
        drawable.setBounds(0, 0, e, e);
        this.avf.setCompoundDrawablePadding(e2);
        this.avf.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.avg != null) {
            this.avg.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.avf;
    }
}
