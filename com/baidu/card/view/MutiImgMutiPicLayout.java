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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import d.a.c.e.p.l;
import d.a.i.p;
import d.a.m0.r.k;
import d.a.m0.r.q.a2;
import d.a.n0.z.b0;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MutiImgMutiPicLayout extends LinearLayout implements p<d.a.m0.r.q.a> {
    public static final int x;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4444e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f4445f;

    /* renamed from: g  reason: collision with root package name */
    public PlayVoiceBntNew f4446g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f4447h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f4448i;
    public TbImageView j;
    public TbImageView k;
    public TextView l;
    public String m;
    public boolean n;
    public b0<d.a.m0.r.q.a> o;
    public d.a.m0.r.q.a p;
    public int q;
    public d.a.m0.b1.j.d r;
    public LinkedList<MediaData> s;
    public boolean t;
    public int u;
    public boolean v;
    public TbImageView.g w;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b0<d.a.m0.r.q.a> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
            if (subClickListener != null) {
                view.setTag("2");
                subClickListener.a(view, MutiImgMutiPicLayout.this.p);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements d.a.m0.b1.j.d {
        public b() {
        }

        @Override // d.a.m0.b1.j.d
        public void a(View view, int i2, boolean z) {
            b0<d.a.m0.r.q.a> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
            if (subClickListener != null) {
                view.setTag("1");
                MutiImgMutiPicLayout.this.p.objType = 2;
                subClickListener.f63445a = Boolean.valueOf(z);
                subClickListener.a(view, MutiImgMutiPicLayout.this.p);
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().q) {
                ThreadCardUtils.startImageViewer(view, MutiImgMutiPicLayout.this.n, MutiImgMutiPicLayout.this.s, i2, MutiImgMutiPicLayout.this.p.m(), MutiImgMutiPicLayout.this.m);
            } else if ("index".equals(MutiImgMutiPicLayout.this.m)) {
                ThreadCardUtils.jumpToPB(MutiImgMutiPicLayout.this.p, view.getContext(), 2, false);
            } else if ("frs".equals(MutiImgMutiPicLayout.this.m)) {
                ThreadCardUtils.jumpToPB(MutiImgMutiPicLayout.this.p, view.getContext(), 3, false);
            } else {
                ThreadCardUtils.startImageViewer(view, MutiImgMutiPicLayout.this.n, MutiImgMutiPicLayout.this.s, i2, MutiImgMutiPicLayout.this.p.m(), MutiImgMutiPicLayout.this.m);
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
            int i2;
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
            d.a.c.j.d.a m = d.a.m0.a0.c.k().m(d.a.c.e.l.d.h().g(tbImageView.getUrl(), MutiImgMutiPicLayout.this.n ? 13 : 14));
            int i3 = 0;
            if (m != null) {
                i3 = m.r();
                i2 = m.m();
            } else {
                i2 = 0;
            }
            if (i3 == 0 || i2 == 0) {
                return;
            }
            int width = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
            int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
            Matrix imageMatrix = tbImageView.getImageMatrix();
            float f10 = 0.0f;
            if (tbImageView.K() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                float smartCropCenterPointWidthRatio = tbImageView.getSmartCropCenterPointWidthRatio();
                float smartCropCenterPointHeightRatio = tbImageView.getSmartCropCenterPointHeightRatio();
                if (i3 * height > width * i2) {
                    f7 = height / i2;
                    float f11 = i3;
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
                    float f16 = width / i3;
                    float f17 = i2;
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
            } else if (tbImageView.I() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                if (i3 * height > width * i2) {
                    f5 = height;
                    f6 = i2;
                } else {
                    f5 = width;
                    f6 = i3;
                }
                float f23 = f5 / f6;
                imageMatrix.setScale(f23, f23);
                imageMatrix.postTranslate(0.0f, 0.0f);
            } else if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                if (i3 * height > width * i2) {
                    f2 = height / i2;
                    f4 = (width - (i3 * f2)) * 0.5f;
                    f3 = 0.0f;
                } else {
                    f2 = width / i3;
                    f3 = (height - (i2 * f2)) * 0.5f;
                    f4 = 0.0f;
                }
                imageMatrix.setScale(f2, f2);
                if (MutiImgMutiPicLayout.this.t && i2 > i3) {
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
        public int f4452e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f4453f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f4454g;

        public d(int i2, boolean z, boolean z2) {
            a(i2, z, z2);
        }

        public void a(int i2, boolean z, boolean z2) {
            this.f4452e = i2;
            this.f4453f = z;
            this.f4454g = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgMutiPicLayout.this.r != null) {
                MutiImgMutiPicLayout.this.r.a(view, this.f4452e, this.f4453f && this.f4454g);
            }
        }
    }

    static {
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds7);
        x = l.k(TbadkCoreApplication.getInst()) - ((l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    public MutiImgMutiPicLayout(Context context) {
        this(context, null);
    }

    private void setImageData(a2 a2Var) {
        boolean z;
        ArrayList<MediaData> L0 = a2Var.L0();
        if (k.c().g() && ListUtils.getCount(L0) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i2 = 0; i2 < L0.size(); i2++) {
                MediaData mediaData = (MediaData) ListUtils.getItem(L0, i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.s = linkedList;
            d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(this.l);
            d2.m(R.string.J_X11);
            d2.q(R.array.Mask_X001);
            if (linkedList.size() > 3) {
                this.l.setText(TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(linkedList.size() - 3)}));
                this.l.setVisibility(0);
                z = true;
            } else {
                this.l.setVisibility(8);
                z = false;
            }
            this.f4447h.setVisibility(8);
            if (ListUtils.getCount(linkedList) == 2) {
                this.f4447h.setVisibility(0);
                boolean z2 = z;
                l((MediaData) ListUtils.getItem(L0, 0), this.f4448i, z2, false, 0);
                this.j.setVisibility(8);
                l((MediaData) ListUtils.getItem(L0, 1), this.k, z2, false, 1);
                return;
            } else if (ListUtils.getCount(linkedList) >= 3) {
                this.f4447h.setVisibility(0);
                this.j.setVisibility(0);
                boolean z3 = z;
                l((MediaData) ListUtils.getItem(L0, 0), this.f4448i, z3, false, 0);
                l((MediaData) ListUtils.getItem(L0, 1), this.j, z3, false, 1);
                l((MediaData) ListUtils.getItem(L0, 2), this.k, z3, true, 2);
                return;
            } else {
                this.f4447h.setVisibility(8);
                return;
            }
        }
        this.f4447h.setVisibility(8);
    }

    private void setVoiceData(a2 a2Var) {
        ArrayList<VoiceData$VoiceModel> J1 = a2Var.J1();
        if (ListUtils.isEmpty(J1)) {
            this.f4446g.setVisibility(8);
            return;
        }
        this.f4446g.setVisibility(0);
        VoiceData$VoiceModel voiceData$VoiceModel = J1.get(0);
        this.f4446g.setVoiceModel(voiceData$VoiceModel);
        this.f4446g.setTag(voiceData$VoiceModel);
        this.f4446g.b();
        if (voiceData$VoiceModel != null) {
            this.f4446g.j(voiceData$VoiceModel.voice_status.intValue());
        }
        this.f4446g.l();
    }

    public final int g(int i2) {
        if (this.q > 0) {
            int k = l.k(getContext());
            if (k == this.u) {
                return this.q;
            }
            this.u = k;
        }
        int size = (View.MeasureSpec.getSize(i2) - (2 * TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002))) / 3;
        this.q = size;
        return size;
    }

    public b0<d.a.m0.r.q.a> getSubClickListener() {
        return this.o;
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
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_more_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f4445f = (TextView) findViewById(R.id.thread_card_abstract);
        this.f4444e = (TextView) findViewById(R.id.thread_card_title);
        PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.f4446g = playVoiceBntNew;
        playVoiceBntNew.setAfterClickListener(new a());
        int k = ((l.k(getContext()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X011) * 2)) - (l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002) * 2)) / 3;
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        this.f4447h = relativeLayout;
        relativeLayout.getLayoutParams().height = k;
        TbImageView tbImageView = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.f4448i = tbImageView;
        tbImageView.setDrawCorner(true);
        this.f4448i.setRadiusById(R.string.J_X12);
        this.f4448i.setPlaceHolder(2);
        this.f4448i.setConrers(15);
        this.f4448i.getLayoutParams().height = k;
        this.f4448i.getLayoutParams().width = k;
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
        d.a.m0.r.u.c.d(this.l).v(R.array.S_O_X001);
        this.l.setTypeface(d.a.m0.r.u.a.E(d.a.m0.r.u.a.B(R.string.F_X02)));
        this.r = new b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: j */
    public void a(d.a.m0.r.q.a aVar) {
        this.p = aVar;
        a2 m = aVar.m();
        ThreadCardUtils.setTitle(this.f4444e, m, this.v);
        ThreadCardUtils.setAbstract(this.f4445f, this.f4444e, m, x, this.v);
        TextView textView = this.f4444e;
        boolean z = false;
        boolean z2 = textView == null || textView.getVisibility() != 0;
        TextView textView2 = this.f4445f;
        boolean z3 = textView2 == null || textView2.getVisibility() != 0;
        RelativeLayout relativeLayout = this.f4447h;
        if (z2 && z3) {
            z = true;
        }
        ThreadCardUtils.dealMainViewTopMargin(relativeLayout, z, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        setImageData(m);
        setVoiceData(m);
    }

    public final void k(TbImageView tbImageView, int i2, boolean z, boolean z2) {
        if (this.r != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof d) {
                ((d) onClickListener).a(i2, z, z2);
            } else {
                tbImageView.setOnClickListener(new d(i2, z, z2));
            }
        } else if (this.r != null || tbImageView == null) {
        } else {
            tbImageView.setClickable(false);
        }
    }

    public final void l(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, int i2) {
        String h2 = h(mediaData);
        int i3 = this.n ? 13 : 14;
        if (!StringHelper.equals(h2, tbImageView.getUrl())) {
            tbImageView.Q();
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
        tbImageView.setOnDrawListener(this.w);
        tbImageView.setPlaceHolder(2);
        if (z2 && z) {
            tbImageView.setLongIconSupport(false);
            tbImageView.setGifIconSupport(false);
        } else {
            tbImageView.setLongIconSupport(true);
            tbImageView.setGifIconSupport(true);
        }
        tbImageView.V(h2, i3, false);
        k(tbImageView, i2, z, z2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int g2 = g(i2);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f4448i.getLayoutParams();
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
        if (this.f4447h.getVisibility() != 8) {
            this.f4448i.setLayoutParams(layoutParams);
            this.j.setLayoutParams(layoutParams2);
            this.k.setLayoutParams(layoutParams3);
            this.l.setLayoutParams(layoutParams4);
        }
    }

    public void setCanCenterStart(boolean z) {
        this.t = z;
    }

    public void setFrom(String str) {
        this.m = str;
    }

    public void setFromCDN(boolean z) {
        this.n = z;
    }

    public void setMarginsTop(View view, int i2) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i2) {
                marginLayoutParams.topMargin = i2;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.v = z;
    }

    public void setPreloadSizeReadyCallback(d.a.c.j.c.b bVar) {
    }

    public void setSubClickListener(b0<d.a.m0.r.q.a> b0Var) {
        this.o = b0Var;
    }

    public MutiImgMutiPicLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = true;
        this.p = null;
        this.q = 0;
        this.t = false;
        this.u = 0;
        this.v = false;
        this.w = new c();
        i();
    }
}
