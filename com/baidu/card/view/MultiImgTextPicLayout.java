package com.baidu.card.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import d.b.c.e.p.l;
import d.b.i.l0;
import d.b.i.p;
import d.b.i0.r.k;
import d.b.i0.r.q.a2;
import d.b.j0.x.b0;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgTextPicLayout extends LinearLayout implements p<d.b.i0.r.q.a> {
    public static final int y;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4467e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f4468f;

    /* renamed from: g  reason: collision with root package name */
    public PlayVoiceBntNew f4469g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f4470h;
    public TbImageView i;
    public TbImageView j;
    public TbImageView k;
    public TextView l;
    public TbImageView m;
    public String n;
    public boolean o;
    public b0<d.b.i0.r.q.a> p;
    public d.b.i0.r.q.a q;
    public int r;
    public d.b.i0.b1.j.d s;
    public LinkedList<MediaData> t;
    public boolean u;
    public int v;
    public boolean w;
    public TbImageView.g x;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b0<d.b.i0.r.q.a> subClickListener = MultiImgTextPicLayout.this.getSubClickListener();
            if (subClickListener != null) {
                view.setTag("2");
                subClickListener.a(view, MultiImgTextPicLayout.this.q);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements d.b.i0.b1.j.d {
        public b() {
        }

        @Override // d.b.i0.b1.j.d
        public void a(View view, int i, boolean z) {
            b0<d.b.i0.r.q.a> subClickListener = MultiImgTextPicLayout.this.getSubClickListener();
            if (subClickListener != null) {
                view.setTag("1");
                MultiImgTextPicLayout.this.q.objType = 2;
                subClickListener.f64180a = Boolean.valueOf(z);
                subClickListener.a(view, MultiImgTextPicLayout.this.q);
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().q) {
                ThreadCardUtils.startImageViewer(view, MultiImgTextPicLayout.this.o, MultiImgTextPicLayout.this.t, i, MultiImgTextPicLayout.this.q.n(), MultiImgTextPicLayout.this.n);
            } else if ("index".equals(MultiImgTextPicLayout.this.n)) {
                ThreadCardUtils.jumpToPB(MultiImgTextPicLayout.this.q, view.getContext(), 2, false);
            } else if ("frs".equals(MultiImgTextPicLayout.this.n)) {
                ThreadCardUtils.jumpToPB(MultiImgTextPicLayout.this.q, view.getContext(), 3, false);
            } else {
                ThreadCardUtils.startImageViewer(view, MultiImgTextPicLayout.this.o, MultiImgTextPicLayout.this.t, i, MultiImgTextPicLayout.this.q.n(), MultiImgTextPicLayout.this.n);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements TbImageView.g {
        public c() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(TbImageView tbImageView, Canvas canvas) {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void b(TbImageView tbImageView, Canvas canvas) {
            int i;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            if (tbImageView == null || tbImageView.getImageMatrix() == null) {
                return;
            }
            d.b.c.j.d.a m = d.b.i0.a0.c.k().m(d.b.c.e.l.d.h().g(tbImageView.getUrl(), MultiImgTextPicLayout.this.o ? 13 : 14));
            int i2 = 0;
            if (m != null) {
                i2 = m.r();
                i = m.m();
            } else {
                i = 0;
            }
            if (i2 == 0 || i == 0) {
                return;
            }
            int width = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
            int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
            Matrix imageMatrix = tbImageView.getImageMatrix();
            float f10 = 0.0f;
            if (tbImageView.L() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                float smartCropCenterPointWidthRatio = tbImageView.getSmartCropCenterPointWidthRatio();
                float smartCropCenterPointHeightRatio = tbImageView.getSmartCropCenterPointHeightRatio();
                if (i2 * height > width * i) {
                    f7 = height / i;
                    float f11 = i2;
                    float f12 = smartCropCenterPointWidthRatio * f11 * f7;
                    float f13 = width;
                    float f14 = 0.5f * f13;
                    if (f12 < f14) {
                        f9 = 0.0f;
                    } else {
                        float f15 = f11 * f7;
                        f9 = f15 - f12 < f14 ? f13 - f15 : f14 - f12;
                    }
                    f10 = f9;
                } else {
                    float f16 = width / i2;
                    float f17 = i;
                    float f18 = smartCropCenterPointHeightRatio * f17 * f16;
                    float f19 = height;
                    float f20 = 0.5f * f19;
                    if (f18 >= f20) {
                        float f21 = f17 * f16;
                        if (f21 - f18 < f20) {
                            f8 = f19 - f21;
                            f7 = f16;
                        } else {
                            float f22 = f20 - f18;
                            f7 = f16;
                            f8 = f22;
                        }
                        imageMatrix.setScale(f7, f7);
                        imageMatrix.postTranslate(f10, f8);
                    }
                    f7 = f16;
                }
                f8 = 0.0f;
                imageMatrix.setScale(f7, f7);
                imageMatrix.postTranslate(f10, f8);
            } else if (tbImageView.J() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                if (i2 * height > width * i) {
                    f5 = height;
                    f6 = i;
                } else {
                    f5 = width;
                    f6 = i2;
                }
                float f23 = f5 / f6;
                imageMatrix.setScale(f23, f23);
                imageMatrix.postTranslate(0.0f, 0.0f);
            } else if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                if (i2 * height > width * i) {
                    f2 = height / i;
                    f4 = (width - (i2 * f2)) * 0.5f;
                    f3 = 0.0f;
                } else {
                    f2 = width / i2;
                    f3 = (height - (i * f2)) * 0.5f;
                    f4 = 0.0f;
                }
                imageMatrix.setScale(f2, f2);
                if (MultiImgTextPicLayout.this.u && i > i2) {
                    imageMatrix.postTranslate(f4, 0.0f);
                } else {
                    imageMatrix.postTranslate(f4, f3);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public int f4474e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f4475f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f4476g;

        public d(int i, boolean z, boolean z2) {
            a(i, z, z2);
        }

        public void a(int i, boolean z, boolean z2) {
            this.f4474e = i;
            this.f4475f = z;
            this.f4476g = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MultiImgTextPicLayout.this.s != null) {
                MultiImgTextPicLayout.this.s.a(view, this.f4474e, this.f4475f && this.f4476g);
            }
        }
    }

    static {
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds7);
        y = l.k(TbadkCoreApplication.getInst()) - ((l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    public MultiImgTextPicLayout(Context context) {
        this(context, null);
    }

    private void setImageData(a2 a2Var) {
        boolean z;
        ArrayList<MediaData> K0 = a2Var.K0();
        if (k.c().g() && ListUtils.getCount(K0) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < K0.size(); i++) {
                MediaData mediaData = (MediaData) ListUtils.getItem(K0, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.t = linkedList;
            if (linkedList.size() == 1) {
                this.l.setVisibility(8);
                this.f4470h.setVisibility(8);
                this.m.setVisibility(0);
                l((MediaData) ListUtils.getItem(K0, 0), this.m, false, false, 0);
                return;
            }
            this.m.setVisibility(8);
            d.b.i0.b.g.b.f(this.l, R.drawable.thread_card_more_number_bg);
            if (linkedList.size() > 3) {
                this.l.setText(TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(linkedList.size() - 3)}));
                this.l.setVisibility(0);
                z = true;
            } else {
                this.l.setVisibility(8);
                z = false;
            }
            this.f4470h.setVisibility(8);
            if (ListUtils.getCount(linkedList) == 2) {
                this.f4470h.setVisibility(0);
                boolean z2 = z;
                l((MediaData) ListUtils.getItem(K0, 0), this.i, z2, false, 0);
                this.j.setVisibility(8);
                l((MediaData) ListUtils.getItem(K0, 1), this.k, z2, false, 1);
                return;
            } else if (ListUtils.getCount(linkedList) >= 3) {
                this.f4470h.setVisibility(0);
                this.j.setVisibility(0);
                boolean z3 = z;
                l((MediaData) ListUtils.getItem(K0, 0), this.i, z3, false, 0);
                l((MediaData) ListUtils.getItem(K0, 1), this.j, z3, false, 1);
                l((MediaData) ListUtils.getItem(K0, 2), this.k, z3, true, 2);
                return;
            } else {
                this.f4470h.setVisibility(8);
                return;
            }
        }
        this.f4470h.setVisibility(8);
    }

    private void setImageTextData(a2 a2Var) {
    }

    private void setSingleImgData(a2 a2Var) {
        this.l.setVisibility(8);
        this.f4470h.setVisibility(8);
        ArrayList<MediaData> K0 = a2Var.K0();
        if (k.c().g() && ListUtils.getCount(K0) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            MediaData mediaData = null;
            int i = 0;
            while (true) {
                if (i < K0.size()) {
                    mediaData = (MediaData) ListUtils.getItem(K0, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
            MediaData mediaData2 = mediaData;
            this.t = linkedList;
            this.m.setVisibility(8);
            if (ListUtils.getCount(linkedList) == 1) {
                this.m.setVisibility(0);
                l(mediaData2, this.m, false, false, 0);
                return;
            }
            this.m.setVisibility(8);
            return;
        }
        this.m.setVisibility(8);
    }

    private void setVoiceData(a2 a2Var) {
        ArrayList<VoiceData$VoiceModel> H1 = a2Var.H1();
        if (ListUtils.isEmpty(H1)) {
            this.f4469g.setVisibility(8);
            return;
        }
        this.f4469g.setVisibility(0);
        VoiceData$VoiceModel voiceData$VoiceModel = H1.get(0);
        this.f4469g.setVoiceModel(voiceData$VoiceModel);
        this.f4469g.setTag(voiceData$VoiceModel);
        this.f4469g.b();
        if (voiceData$VoiceModel != null) {
            this.f4469g.k(voiceData$VoiceModel.voice_status.intValue());
        }
        this.f4469g.m();
    }

    public final int g(int i) {
        if (this.r > 0) {
            int k = l.k(getContext());
            if (k == this.v) {
                return this.r;
            }
            this.v = k;
        }
        int size = (View.MeasureSpec.getSize(i) - (2 * TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10))) / 3;
        this.r = size;
        return size;
    }

    public b0<d.b.i0.r.q.a> getSubClickListener() {
        return this.p;
    }

    public final String h(MediaData mediaData) {
        if (mediaData == null) {
            return "";
        }
        String picUrl = mediaData.getPicUrl();
        if (TextUtils.isEmpty(picUrl)) {
            picUrl = mediaData.getSmallUrl();
        }
        if (TextUtils.isEmpty(picUrl)) {
            picUrl = mediaData.getThumbnails_url();
        }
        return TextUtils.isEmpty(picUrl) ? mediaData.getSrc_pic() : picUrl;
    }

    public final void i() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_card_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f4468f = (TextView) findViewById(R.id.thread_card_abstract);
        this.f4467e = (TextView) findViewById(R.id.thread_card_title);
        PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.f4469g = playVoiceBntNew;
        playVoiceBntNew.setAfterClickListener(new a());
        int k = ((l.k(getContext()) - (l0.i * 2)) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        this.f4470h = relativeLayout;
        d.b.i0.b.g.b.b(relativeLayout, R.dimen.tbds26, R.dimen.tbds14);
        d.b.i0.b.g.b.k(this.f4467e, R.dimen.tbds7, R.dimen.tbds10);
        d.b.i0.b.g.b.k(this.f4468f, R.dimen.tbds7, R.dimen.tbds10);
        this.f4470h.getLayoutParams().height = k;
        TbImageView tbImageView = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.i = tbImageView;
        tbImageView.setDrawCorner(true);
        this.i.setRadiusById(R.string.J_X12);
        this.i.setPlaceHolder(2);
        this.i.setConrers(15);
        this.i.getLayoutParams().height = k;
        this.i.getLayoutParams().width = k;
        TbImageView tbImageView2 = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.j = tbImageView2;
        tbImageView2.setDrawCorner(false);
        this.j.setPlaceHolder(2);
        this.j.setRadiusById(R.string.J_X02);
        this.j.setConrers(15);
        this.j.getLayoutParams().height = k;
        this.j.getLayoutParams().width = k;
        TbImageView tbImageView3 = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.k = tbImageView3;
        tbImageView3.setDrawCorner(true);
        this.k.setPlaceHolder(2);
        this.k.setRadiusById(R.string.J_X11);
        this.k.setConrers(15);
        this.k.getLayoutParams().height = k;
        this.k.getLayoutParams().width = k;
        TextView textView = (TextView) findViewById(R.id.thread_card_img_more_label);
        this.l = textView;
        textView.getLayoutParams().height = k;
        this.l.getLayoutParams().width = k;
        d.b.i0.r.u.c.d(this.l).t(R.array.S_O_X001);
        this.l.setTypeface(d.b.i0.r.u.a.C(d.b.i0.r.u.a.z(R.string.F_X02)));
        TbImageView tbImageView4 = (TbImageView) findViewById(R.id.thread_card_img_singal);
        this.m = tbImageView4;
        tbImageView4.setRadiusById(R.string.J_X05);
        this.m.setConrers(15);
        this.m.setDrawCorner(true);
        this.m.setPlaceHolder(3);
        this.m.setLongIconSupport(true);
        this.m.setGifIconSupport(true);
        d.b.i0.b.g.b.b(this.m, R.dimen.tbds28, R.dimen.tbds14);
        this.s = new b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: j */
    public void a(d.b.i0.r.q.a aVar) {
        this.q = aVar;
        a2 n = aVar.n();
        ThreadCardUtils.setTitle(this.f4467e, n, this.w);
        ThreadCardUtils.setAbstract(this.f4468f, this.f4467e, n, y, this.w);
        setImageData(n);
        setVoiceData(n);
    }

    public final void k(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.s != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof d) {
                ((d) onClickListener).a(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new d(i, z, z2));
            }
        } else if (this.s != null || tbImageView == null) {
        } else {
            tbImageView.setClickable(false);
        }
    }

    public final void l(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, int i) {
        String h2 = h(mediaData);
        int i2 = this.o ? 13 : 14;
        if (!StringHelper.equals(h2, tbImageView.getUrl())) {
            tbImageView.S();
        }
        setCanCenterStart(false);
        boolean isLongPic = mediaData.isLongPic();
        boolean isSmartCrop = mediaData.isSmartCrop();
        tbImageView.setScaleType(ImageView.ScaleType.MATRIX);
        tbImageView.setIsLongPic(isLongPic);
        tbImageView.setIsSmartCrop(isSmartCrop);
        tbImageView.setSmartCropCenterPointWidthRatio((float) mediaData.getSmartCropCenterPointWidthRatio());
        tbImageView.setSmartCropCenterPointHeightRatio((float) mediaData.getSmartCropCenterPointHeightRatio());
        tbImageView.setForegroundColor(0);
        tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        tbImageView.setBorderSurroundContent(true);
        tbImageView.setDrawBorder(true);
        tbImageView.setOnDrawListener(this.x);
        tbImageView.setPlaceHolder(2);
        if (z2 && z) {
            tbImageView.setLongIconSupport(false);
            tbImageView.setGifIconSupport(false);
        } else {
            tbImageView.setLongIconSupport(true);
            tbImageView.setGifIconSupport(true);
        }
        tbImageView.W(h2, i2, false);
        k(tbImageView, i, z, z2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int g2 = g(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams.width = g2;
        layoutParams.height = g2;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams2.width = g2;
        layoutParams2.height = g2;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
        layoutParams3.width = g2;
        layoutParams3.height = g2;
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
        layoutParams4.width = g2;
        layoutParams4.height = g2;
        if (this.f4470h.getVisibility() != 8) {
            this.i.setLayoutParams(layoutParams);
            this.j.setLayoutParams(layoutParams2);
            this.k.setLayoutParams(layoutParams3);
            this.l.setLayoutParams(layoutParams4);
        }
    }

    public void setCanCenterStart(boolean z) {
        this.u = z;
    }

    public void setFrom(String str) {
        this.n = str;
    }

    public void setFromCDN(boolean z) {
        this.o = z;
    }

    public void setMarginsTop(View view, int i) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.w = z;
    }

    public void setPreloadSizeReadyCallback(d.b.c.j.c.b bVar) {
    }

    public void setSubClickListener(b0<d.b.i0.r.q.a> b0Var) {
        this.p = b0Var;
    }

    public MultiImgTextPicLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.o = true;
        this.q = null;
        this.r = 0;
        this.u = false;
        this.v = 0;
        this.w = false;
        this.x = new c();
        i();
    }
}
