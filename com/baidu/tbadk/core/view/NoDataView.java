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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.b.a.f;
import d.b.b.e.p.l;
/* loaded from: classes3.dex */
public class NoDataView extends LinearLayout {
    public static final int u = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds312);
    public static final int v = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds84);
    public static final int w = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    public static final int x = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds32);
    public static final int y = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);

    /* renamed from: e  reason: collision with root package name */
    public Context f13399e;

    /* renamed from: f  reason: collision with root package name */
    public View f13400f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f13401g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f13402h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TBSpecificationBtn l;
    public TBSpecificationBtn m;
    public TBSpecificationBtn n;
    public int o;
    public View p;
    public NoDataViewFactory.ImgType q;
    public int r;
    public int s;
    public int t;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f13403a;

        static {
            int[] iArr = new int[NoDataViewFactory.ImgType.values().length];
            f13403a = iArr;
            try {
                iArr[NoDataViewFactory.ImgType.FINDBAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13403a[NoDataViewFactory.ImgType.EMOTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13403a[NoDataViewFactory.ImgType.CREATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13403a[NoDataViewFactory.ImgType.COLLECTION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13403a[NoDataViewFactory.ImgType.NODATA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13403a[NoDataViewFactory.ImgType.ANTI.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f13403a[NoDataViewFactory.ImgType.SINGALL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f13403a[NoDataViewFactory.ImgType.GIFT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f13403a[NoDataViewFactory.ImgType.WEBVIEW.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f13403a[NoDataViewFactory.ImgType.NETERROR.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public NoDataView(Context context) {
        super(context);
        this.f13399e = context;
        b(context, null);
    }

    public final void a() {
        if (this.l.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.f13402h.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = v;
                this.f13402h.setLayoutParams(marginLayoutParams);
            }
            this.j.setVisibility(8);
            this.s = R.color.CAM_X0107;
        } else if (this.j.getVisibility() == 8) {
            ViewGroup.LayoutParams layoutParams2 = this.f13402h.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams2.topMargin = v;
                this.f13402h.setLayoutParams(marginLayoutParams2);
            }
            this.s = R.color.CAM_X0107;
        } else if (this.k.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams3 = this.f13402h.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                marginLayoutParams3.topMargin = x;
                this.f13402h.setLayoutParams(marginLayoutParams3);
            }
            ViewGroup.LayoutParams layoutParams4 = this.k.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                marginLayoutParams4.topMargin = y;
                this.k.setLayoutParams(marginLayoutParams4);
            }
            this.s = R.color.CAM_X0107;
            this.t = R.color.CAM_X0109;
        } else {
            ViewGroup.LayoutParams layoutParams5 = this.f13401g.getLayoutParams();
            int i = u;
            layoutParams5.width = i;
            layoutParams5.height = i;
            this.f13401g.setLayoutParams(layoutParams5);
            ViewGroup.LayoutParams layoutParams6 = this.f13402h.getLayoutParams();
            if (layoutParams6 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams6;
                marginLayoutParams5.topMargin = w;
                this.f13402h.setLayoutParams(marginLayoutParams5);
            }
            this.t = R.color.CAM_X0109;
        }
        setTitleTextColor(this.s);
        setSubTitleTextColor(this.t);
    }

    public final void b(Context context, AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(this.f13399e).inflate(R.layout.no_data_view, this);
        this.f13400f = inflate;
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.iv_no_data_img);
        this.f13401g = tbImageView;
        tbImageView.setDefaultBgResource(0);
        this.f13401g.setDefaultResource(0);
        this.f13402h = (LinearLayout) this.f13400f.findViewById(R.id.title_container);
        this.i = (TextView) this.f13400f.findViewById(R.id.tv_text_reamrk);
        this.j = (TextView) this.f13400f.findViewById(R.id.tv_subtitle);
        this.k = (TextView) this.f13400f.findViewById(R.id.tv_title);
        this.l = (TBSpecificationBtn) this.f13400f.findViewById(R.id.btn_func);
        d.b.h0.r.f0.m.a aVar = new d.b.h0.r.f0.m.a();
        this.l.setTextSize(R.dimen.T_X05);
        this.l.setConfig(aVar);
        this.p = (LinearLayout) this.f13400f.findViewById(R.id.two_button_layout);
        this.s = R.color.CAM_X0107;
        this.t = R.color.CAM_X0109;
        h();
    }

    public void c(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.e eVar) {
        setButtonOption(cVar);
        setImgOption(dVar);
        setTextOption(eVar);
    }

    public void d(f<?> fVar) {
        f(fVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public void e() {
        this.f13401g.setImageDrawable(null);
        this.f13401g.W(null, 10, false);
    }

    public void f(f<?> fVar, int i) {
        if (fVar instanceof TbPageContext) {
            TbPageContext tbPageContext = (TbPageContext) fVar;
            tbPageContext.getLayoutMode().k(i == 1);
            tbPageContext.getLayoutMode().j(this);
        }
        TBSpecificationBtn tBSpecificationBtn = this.l;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.k();
        }
        TBSpecificationBtn tBSpecificationBtn2 = this.m;
        if (tBSpecificationBtn2 != null) {
            tBSpecificationBtn2.k();
        }
        TBSpecificationBtn tBSpecificationBtn3 = this.n;
        if (tBSpecificationBtn3 != null) {
            tBSpecificationBtn3.k();
        }
        NoDataViewFactory.ImgType imgType = this.q;
        if (imgType == NoDataViewFactory.ImgType.WEBVIEW) {
            this.f13401g.setImageBitmap(SkinManager.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else if (imgType == NoDataViewFactory.ImgType.NODATA) {
            this.f13401g.setImageBitmap(SkinManager.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (imgType == NoDataViewFactory.ImgType.LOCAL) {
            this.f13401g.setImageBitmap(SkinManager.getBitmap565Quality(this.r));
        } else if (imgType == NoDataViewFactory.ImgType.ANTI) {
            this.f13401g.setImageBitmap(SkinManager.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else if (imgType == NoDataViewFactory.ImgType.NETERROR) {
            this.f13401g.setImageBitmap(SkinManager.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else {
            this.f13401g.setImageBitmap(SkinManager.getBitmap565Quality(this.o));
        }
    }

    public void g(NoDataViewFactory.d dVar, f<?> fVar) {
        setImgOption(dVar);
        f(fVar, TbadkCoreApplication.getInst().getSkinType());
    }

    public TextView getSuTextView() {
        return this.j;
    }

    public final void h() {
        int i = l.i(TbadkCoreApplication.getInst());
        if (i > 0) {
            double d2 = i;
            Double.isNaN(d2);
            int i2 = (int) (d2 * 0.16d);
            ViewGroup.LayoutParams layoutParams = this.f13401g.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i2;
                this.f13401g.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void setButtonOption(NoDataViewFactory.c cVar) {
        if (cVar == null) {
            this.l.setVisibility(8);
            this.p.setVisibility(8);
            return;
        }
        NoDataViewFactory.b bVar = cVar.f13406a;
        NoDataViewFactory.b bVar2 = cVar.f13407b;
        if (bVar2 == null && bVar != null) {
            this.l.setOnClickListener(bVar.f13404a);
            this.l.setText(bVar.f13405b);
            this.l.setVisibility(0);
            if (cVar.f13408c >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.l.getLayoutParams();
                layoutParams.topMargin = cVar.f13408c;
                this.l.setLayoutParams(layoutParams);
            }
        }
        if (bVar2 != null && bVar != null) {
            this.m = (TBSpecificationBtn) this.p.findViewById(R.id.btn_left);
            this.n = (TBSpecificationBtn) this.p.findViewById(R.id.btn_right);
            d.b.h0.r.f0.m.a aVar = new d.b.h0.r.f0.m.a();
            this.m.setTextSize(R.dimen.ds32);
            this.m.setConfig(aVar);
            this.n.setTextSize(R.dimen.ds32);
            this.n.setConfig(aVar);
            this.m.setOnClickListener(bVar.f13404a);
            this.m.setText(bVar.f13405b);
            this.n.setOnClickListener(bVar2.f13404a);
            this.n.setText(bVar2.f13405b);
            this.p.setVisibility(0);
        }
        a();
    }

    public void setImgOption(NoDataViewFactory.d dVar) {
        int i;
        if (dVar == null) {
            return;
        }
        NoDataViewFactory.ImgType imgType = dVar.f13412a;
        this.q = imgType;
        this.r = dVar.f13414c;
        switch (a.f13403a[imgType.ordinal()]) {
            case 1:
                this.o = R.drawable.new_pic_emotion_01;
                break;
            case 2:
                this.o = R.drawable.new_pic_emotion_02;
                break;
            case 3:
                this.o = R.drawable.new_pic_emotion_03;
                break;
            case 4:
                this.o = R.drawable.new_pic_emotion_04;
                break;
            case 5:
                this.o = R.drawable.new_pic_emotion_05;
                break;
            case 6:
                this.o = R.drawable.new_pic_emotion_05;
                break;
            case 7:
                this.o = R.drawable.new_pic_emotion_06;
                break;
            case 8:
                this.o = R.drawable.new_pic_emotion_07;
                break;
            case 9:
                this.o = R.drawable.new_pic_emotion_08;
                break;
            case 10:
                this.o = R.drawable.new_pic_emotion_08;
                break;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f13401g.getLayoutParams();
        int i2 = dVar.f13413b;
        if (i2 >= 0) {
            layoutParams.setMargins(0, i2, 0, 0);
        }
        int i3 = dVar.f13415d;
        if (i3 > 0 && (i = dVar.f13416e) > 0) {
            layoutParams.height = i3;
            layoutParams.width = i;
        }
        this.f13401g.setLayoutParams(layoutParams);
    }

    public void setRemarkTextColor(int i) {
        TextView textView = this.i;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, i, 1);
        }
    }

    public void setSubTitleCompoundDrawable(int i) {
        Drawable drawable = SkinManager.getDrawable(i);
        int g2 = l.g(this.f13399e, R.dimen.ds32);
        int g3 = l.g(this.f13399e, R.dimen.ds8);
        drawable.setBounds(0, 0, g2, g2);
        this.j.setCompoundDrawablePadding(g3);
        this.j.setCompoundDrawables(drawable, null, null, null);
    }

    public void setSubTitleTextColor(int i) {
        TextView textView = this.j;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, i, 1);
        }
    }

    public void setSubTitleTextSize(int i) {
        TextView textView = this.j;
        if (textView != null) {
            textView.setTextSize(i);
        }
    }

    public void setTextOption(NoDataViewFactory.e eVar) {
        if (eVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(eVar.f13422a)) {
            this.k.setText(eVar.f13422a);
            this.k.setVisibility(0);
        } else {
            this.k.setVisibility(8);
        }
        if (!TextUtils.isEmpty(eVar.f13423b)) {
            this.j.setVisibility(0);
            this.j.setText(eVar.f13423b);
            if (TextUtils.isEmpty(eVar.f13422a) && eVar.f13425d >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.j.getLayoutParams();
                layoutParams.topMargin = eVar.f13425d;
                this.j.setLayoutParams(layoutParams);
            }
            int i = eVar.f13426e;
            if (i != 0) {
                setSubTitleCompoundDrawable(i);
            }
        } else {
            this.j.setVisibility(8);
        }
        if (!TextUtils.isEmpty(eVar.f13424c)) {
            this.i.setText(eVar.f13424c);
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
        a();
    }

    public void setTitleTextColor(int i) {
        TextView textView = this.k;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, i, 1);
        }
    }

    public NoDataView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
    }
}
