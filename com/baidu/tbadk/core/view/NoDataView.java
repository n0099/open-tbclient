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
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class NoDataView extends LinearLayout {
    private TbImageView aIe;
    private TextView aIf;
    private TextView aIg;
    private TextView aIh;
    private TextView aIi;
    private TextView aIj;
    private TextView aIk;
    private String aIl;
    private String aIm;
    private View aIn;
    private NoDataViewFactory.ImgType aIo;
    private int aIp;
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
        this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.no_data_view, this);
        this.aIe = (TbImageView) this.mRootView.findViewById(e.g.iv_no_data_img);
        this.aIe.setDefaultBgResource(0);
        this.aIe.setDefaultResource(0);
        this.aIe.setDefaultErrorResource(0);
        this.aIf = (TextView) this.mRootView.findViewById(e.g.tv_text_reamrk);
        this.aIg = (TextView) this.mRootView.findViewById(e.g.tv_subtitle);
        this.aIh = (TextView) this.mRootView.findViewById(e.g.tv_title);
        this.aIi = (TextView) this.mRootView.findViewById(e.g.btn_func);
        this.aIn = (LinearLayout) this.mRootView.findViewById(e.g.two_button_layout);
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
        if (this.aIo == NoDataViewFactory.ImgType.WEBVIEW) {
            this.aIe.setImageBitmap(al.dQ(e.f.pic_emotion08));
        } else if (this.aIo == NoDataViewFactory.ImgType.NODATA) {
            this.aIe.setImageBitmap(al.dQ(e.f.no_data_image));
        } else if (this.aIo == NoDataViewFactory.ImgType.LOCAL) {
            this.aIe.setImageBitmap(al.dQ(this.aIp));
        } else if (this.aIo == NoDataViewFactory.ImgType.ANTI) {
            this.aIe.setImageBitmap(al.dQ(e.f.pic_emotion05));
        } else if (i == 1) {
            this.aIe.startLoad(this.aIm, 29, false);
        } else {
            this.aIe.startLoad(this.aIl, 29, false);
        }
    }

    public void setTextOption(NoDataViewFactory.d dVar) {
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.mTitle)) {
                this.aIh.setText(dVar.mTitle);
                this.aIh.setVisibility(0);
            } else {
                this.aIh.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.art)) {
                this.aIg.setText(dVar.art);
                if (TextUtils.isEmpty(dVar.mTitle)) {
                    this.aIg.setTextSize(0, getResources().getDimension(e.C0210e.fontsize28));
                    if (dVar.aIx >= 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aIg.getLayoutParams();
                        layoutParams.topMargin = dVar.aIx;
                        this.aIg.setLayoutParams(layoutParams);
                    }
                }
                if (dVar.aIy != 0) {
                    setSubTitleCompoundDrawable(dVar.aIy);
                }
            } else {
                this.aIg.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dVar.aIw)) {
                this.aIf.setText(dVar.aIw);
                this.aIf.setVisibility(0);
                return;
            }
            this.aIf.setVisibility(8);
        }
    }

    public void setImgOption(NoDataViewFactory.c cVar) {
        if (cVar != null) {
            this.aIo = cVar.aIv;
            this.aIp = cVar.aIp;
            switch (cVar.aIv) {
                case CREATE:
                    this.aIl = com.baidu.tbadk.util.c.Qf().iN("pic_emotion03.png");
                    this.aIm = com.baidu.tbadk.util.c.Qf().iN("pic_emotion03_1.png");
                    break;
                case NODATA:
                    this.aIl = com.baidu.tbadk.util.c.Qf().iN("pic_emotion05.png");
                    this.aIm = com.baidu.tbadk.util.c.Qf().iN("pic_emotion05_1.png");
                    break;
                case FINDBAR:
                    this.aIl = com.baidu.tbadk.util.c.Qf().iN("pic_emotion01.png");
                    this.aIm = com.baidu.tbadk.util.c.Qf().iN("pic_emotion01_1.png");
                    break;
                case EMOTION:
                    this.aIl = com.baidu.tbadk.util.c.Qf().iN("pic_emotion02.png");
                    this.aIm = com.baidu.tbadk.util.c.Qf().iN("pic_emotion02_1.png");
                    break;
                case GIFT:
                    this.aIl = com.baidu.tbadk.util.c.Qf().iN("pic_emotion07.png");
                    this.aIm = com.baidu.tbadk.util.c.Qf().iN("pic_emotion07_1.png");
                    break;
                case SINGALL:
                    this.aIl = com.baidu.tbadk.util.c.Qf().iN("pic_emotion06.png");
                    this.aIm = com.baidu.tbadk.util.c.Qf().iN("pic_emotion06_1.png");
                    break;
                case WEBVIEW:
                    this.aIl = com.baidu.tbadk.util.c.Qf().iN("pic_emotion08.png");
                    this.aIm = com.baidu.tbadk.util.c.Qf().iN("pic_emotion08_1.png");
                    break;
                case ANTI:
                    this.aIl = com.baidu.tbadk.util.c.Qf().iN("pic_emotion05.png");
                    this.aIm = com.baidu.tbadk.util.c.Qf().iN("pic_emotion05_1.png");
                    break;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aIe.getLayoutParams();
            if (cVar.mMarginTop >= 0) {
                layoutParams.setMargins(0, cVar.mMarginTop, 0, 0);
            }
            if (cVar.mHeight > 0 && cVar.mWidth > 0) {
                layoutParams.height = cVar.mHeight;
                layoutParams.width = cVar.mWidth;
            }
            this.aIe.setLayoutParams(layoutParams);
        }
    }

    public void setButtonOption(NoDataViewFactory.b bVar) {
        if (bVar == null) {
            this.aIi.setVisibility(8);
            this.aIn.setVisibility(8);
            return;
        }
        NoDataViewFactory.a aVar = bVar.aIs;
        NoDataViewFactory.a aVar2 = bVar.aIt;
        if (aVar2 == null && aVar != null) {
            this.aIi.setOnClickListener(aVar.aIr);
            this.aIi.setText(aVar.mText);
            this.aIi.setVisibility(0);
            if (bVar.aIu >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aIi.getLayoutParams();
                layoutParams.topMargin = bVar.aIu;
                this.aIi.setLayoutParams(layoutParams);
            }
        }
        if (aVar2 != null && aVar != null) {
            this.aIj = (TextView) this.aIn.findViewById(e.g.btn_left);
            this.aIk = (TextView) this.aIn.findViewById(e.g.btn_right);
            this.aIj.setOnClickListener(aVar.aIr);
            this.aIj.setText(aVar.mText);
            this.aIk.setOnClickListener(aVar2.aIr);
            this.aIk.setText(aVar2.mText);
            this.aIn.setVisibility(0);
        }
    }

    public void e(com.baidu.adp.base.e<?> eVar) {
        onChangeSkinType(eVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onActivityStop() {
        this.aIe.setImageDrawable(null);
        this.aIe.startLoad(null, 10, false);
    }

    public void setTitleTextColor(int i) {
        if (this.aIh != null) {
            al.c(this.aIh, i, 1);
        }
    }

    public void setSubTitleTextColor(int i) {
        if (this.aIg != null) {
            al.c(this.aIg, i, 1);
        }
    }

    public void setRemarkTextColor(int i) {
        if (this.aIf != null) {
            al.c(this.aIf, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = al.getDrawable(i);
        int h = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds32);
        int h2 = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds8);
        drawable.setBounds(0, 0, h, h);
        this.aIg.setCompoundDrawablePadding(h2);
        this.aIg.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextSize(int i) {
        if (this.aIh != null) {
            this.aIh.setTextSize(i);
        }
    }

    public TextView getSuTextView() {
        return this.aIg;
    }
}
