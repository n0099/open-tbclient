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
public class MutiImgSingleVerticalLayout extends LinearLayout implements p<d.a.m0.r.q.a> {
    public static final int r = l.k(TbadkCoreApplication.getInst()) - ((l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);

    /* renamed from: e  reason: collision with root package name */
    public TextView f4480e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f4481f;

    /* renamed from: g  reason: collision with root package name */
    public PlayVoiceBntNew f4482g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f4483h;

    /* renamed from: i  reason: collision with root package name */
    public String f4484i;
    public boolean j;
    public b0<d.a.m0.r.q.a> k;
    public d.a.m0.r.q.a l;
    public d.a.m0.b1.j.d m;
    public LinkedList<MediaData> n;
    public boolean o;
    public boolean p;
    public TbImageView.g q;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b0<d.a.m0.r.q.a> subClickListener = MutiImgSingleVerticalLayout.this.getSubClickListener();
            if (subClickListener != null) {
                view.setTag("2");
                subClickListener.a(view, MutiImgSingleVerticalLayout.this.l);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements d.a.m0.b1.j.d {
        public b() {
        }

        @Override // d.a.m0.b1.j.d
        public void a(View view, int i2, boolean z) {
            b0<d.a.m0.r.q.a> subClickListener = MutiImgSingleVerticalLayout.this.getSubClickListener();
            if (subClickListener != null) {
                view.setTag("1");
                MutiImgSingleVerticalLayout.this.l.objType = 2;
                subClickListener.f67163a = Boolean.FALSE;
                subClickListener.a(view, MutiImgSingleVerticalLayout.this.l);
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().q) {
                ThreadCardUtils.startImageViewer(view, MutiImgSingleVerticalLayout.this.j, MutiImgSingleVerticalLayout.this.n, i2, MutiImgSingleVerticalLayout.this.l.i(), MutiImgSingleVerticalLayout.this.f4484i);
            } else if ("index".equals(MutiImgSingleVerticalLayout.this.f4484i)) {
                ThreadCardUtils.jumpToPB(MutiImgSingleVerticalLayout.this.l, view.getContext(), 2, false);
            } else if ("frs".equals(MutiImgSingleVerticalLayout.this.f4484i)) {
                ThreadCardUtils.jumpToPB(MutiImgSingleVerticalLayout.this.l, view.getContext(), 3, false);
            } else {
                ThreadCardUtils.startImageViewer(view, MutiImgSingleVerticalLayout.this.j, MutiImgSingleVerticalLayout.this.n, i2, MutiImgSingleVerticalLayout.this.l.i(), MutiImgSingleVerticalLayout.this.f4484i);
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
            d.a.c.k.d.a m = d.a.m0.a0.c.k().m(d.a.c.e.l.d.h().g(tbImageView.getUrl(), MutiImgSingleVerticalLayout.this.j ? 13 : 14));
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
                if (MutiImgSingleVerticalLayout.this.o && i2 > i3) {
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
        public int f4488e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f4489f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f4490g;

        public d(int i2, boolean z, boolean z2) {
            a(i2, z, z2);
        }

        public void a(int i2, boolean z, boolean z2) {
            this.f4488e = i2;
            this.f4489f = z;
            this.f4490g = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgSingleVerticalLayout.this.m != null) {
                MutiImgSingleVerticalLayout.this.m.a(view, this.f4488e, this.f4489f && this.f4490g);
            }
        }
    }

    public MutiImgSingleVerticalLayout(Context context) {
        this(context, null);
    }

    private void setImageData(a2 a2Var) {
        ArrayList<MediaData> L0 = a2Var.L0();
        if (k.c().g() && ListUtils.getCount(L0) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i2 = 0; i2 < L0.size(); i2++) {
                MediaData mediaData = (MediaData) ListUtils.getItem(L0, i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.n = linkedList;
            this.f4483h.setVisibility(8);
            if (ListUtils.getCount(linkedList) == 1) {
                this.f4483h.setVisibility(0);
                k((MediaData) ListUtils.getItem(L0, 0), this.f4483h, true, false, true, 0);
                return;
            }
            this.f4483h.setVisibility(8);
            return;
        }
        this.f4483h.setVisibility(8);
    }

    private void setVoiceData(a2 a2Var) {
        ArrayList<VoiceData$VoiceModel> K1 = a2Var.K1();
        if (ListUtils.isEmpty(K1)) {
            this.f4482g.setVisibility(8);
            return;
        }
        this.f4482g.setVisibility(0);
        VoiceData$VoiceModel voiceData$VoiceModel = K1.get(0);
        this.f4482g.setVoiceModel(voiceData$VoiceModel);
        this.f4482g.setTag(voiceData$VoiceModel);
        this.f4482g.b();
        if (voiceData$VoiceModel != null) {
            this.f4482g.k(voiceData$VoiceModel.voice_status.intValue());
        }
        this.f4482g.m();
    }

    public final String g(MediaData mediaData) {
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

    public b0<d.a.m0.r.q.a> getSubClickListener() {
        return this.k;
    }

    public final void h() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_single_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f4481f = (TextView) findViewById(R.id.thread_card_abstract);
        this.f4480e = (TextView) findViewById(R.id.thread_card_title);
        PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.f4482g = playVoiceBntNew;
        playVoiceBntNew.setAfterClickListener(new a());
        TbImageView tbImageView = (TbImageView) findViewById(R.id.thread_card_img_singal);
        this.f4483h = tbImageView;
        tbImageView.setRadiusById(R.string.J_X05);
        this.f4483h.setConrers(15);
        this.f4483h.setDrawCorner(true);
        this.f4483h.setPlaceHolder(3);
        this.f4483h.setLongIconSupport(true);
        this.f4483h.setGifIconSupport(true);
        this.m = new b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: i */
    public void a(d.a.m0.r.q.a aVar) {
        this.l = aVar;
        a2 i2 = aVar.i();
        ThreadCardUtils.setTitle(this.f4480e, i2, this.p);
        ThreadCardUtils.setAbstract(this.f4481f, this.f4480e, i2, r, this.p);
        TextView textView = this.f4480e;
        boolean z = false;
        boolean z2 = textView == null || textView.getVisibility() != 0;
        TextView textView2 = this.f4481f;
        boolean z3 = textView2 == null || textView2.getVisibility() != 0;
        TbImageView tbImageView = this.f4483h;
        if (z2 && z3) {
            z = true;
        }
        ThreadCardUtils.dealMainViewTopMargin(tbImageView, z, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        setImageData(i2);
        setVoiceData(i2);
    }

    public final void j(TbImageView tbImageView, int i2, boolean z, boolean z2) {
        if (this.m != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof d) {
                ((d) onClickListener).a(i2, z, z2);
            } else {
                tbImageView.setOnClickListener(new d(i2, z, z2));
            }
        } else if (this.m != null || tbImageView == null) {
        } else {
            tbImageView.setClickable(false);
        }
    }

    public final void k(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i2) {
        String g2 = g(mediaData);
        int i3 = this.j ? 46 : 47;
        if (!StringHelper.equals(g2, tbImageView.getUrl())) {
            tbImageView.Q();
        }
        setCanCenterStart(true);
        boolean isLongPic = mediaData.isLongPic();
        boolean isSmartCrop = mediaData.isSmartCrop();
        tbImageView.setIsLongPic(isLongPic);
        tbImageView.setIsSmartCrop(isSmartCrop);
        tbImageView.setSmartCropCenterPointWidthRatio((float) mediaData.getSmartCropCenterPointWidthRatio());
        tbImageView.setSmartCropCenterPointHeightRatio((float) mediaData.getSmartCropCenterPointHeightRatio());
        tbImageView.setForegroundColor(0);
        tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.L_X01));
        tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        tbImageView.setBorderSurroundContent(true);
        tbImageView.setPlaceHolder(3);
        tbImageView.setDrawBorder(true);
        tbImageView.setOnDrawListener(this.q);
        tbImageView.U(g2, i3, false);
        j(tbImageView, i2, z2, z3);
    }

    public void setCanCenterStart(boolean z) {
        this.o = z;
    }

    public void setFrom(String str) {
        this.f4484i = str;
    }

    public void setFromCDN(boolean z) {
        this.j = z;
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
        this.p = z;
    }

    public void setPreloadSizeReadyCallback(d.a.c.k.c.b bVar) {
    }

    public void setSubClickListener(b0<d.a.m0.r.q.a> b0Var) {
        this.k = b0Var;
    }

    public MutiImgSingleVerticalLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = true;
        this.l = null;
        this.o = false;
        this.p = false;
        this.q = new c();
        h();
    }
}
