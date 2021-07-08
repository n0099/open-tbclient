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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.j.p;
import d.a.o0.r.k;
import d.a.o0.r.q.b2;
import d.a.p0.a0.b0;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class MutiImgAbLayout extends LinearLayout implements p<d.a.o0.r.q.a> {
    public static /* synthetic */ Interceptable $ic;
    public static final int u;
    public static final int v;
    public static final int w;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4476e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f4477f;

    /* renamed from: g  reason: collision with root package name */
    public PlayVoiceBntNew f4478g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f4479h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f4480i;
    public ViewGroup j;
    public String k;
    public boolean l;
    public b0<d.a.o0.r.q.a> m;
    public d.a.o0.r.q.a n;
    public d.a.o0.b1.j.d o;
    public LinkedList<MediaData> p;
    public boolean q;
    public boolean r;
    public int[] s;
    public TbImageView.g t;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MutiImgAbLayout f4481e;

        public a(MutiImgAbLayout mutiImgAbLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mutiImgAbLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4481e = mutiImgAbLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b0<d.a.o0.r.q.a> subClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (subClickListener = this.f4481e.getSubClickListener()) == null) {
                return;
            }
            view.setTag("2");
            subClickListener.a(view, this.f4481e.n);
        }
    }

    /* loaded from: classes.dex */
    public class b implements d.a.o0.b1.j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MutiImgAbLayout f4482a;

        public b(MutiImgAbLayout mutiImgAbLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mutiImgAbLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4482a = mutiImgAbLayout;
        }

        @Override // d.a.o0.b1.j.d
        public void a(View view, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                b0<d.a.o0.r.q.a> subClickListener = this.f4482a.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    this.f4482a.n.objType = 2;
                    subClickListener.f53781a = Boolean.valueOf(z);
                    subClickListener.a(view, this.f4482a.n);
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().q) {
                    ThreadCardUtils.startImageViewer(view, this.f4482a.l, this.f4482a.p, i2, this.f4482a.n.getThreadData(), this.f4482a.k);
                } else if ("index".equals(this.f4482a.k)) {
                    ThreadCardUtils.jumpToPB(this.f4482a.n, view.getContext(), 2, false);
                } else if ("frs".equals(this.f4482a.k)) {
                    ThreadCardUtils.jumpToPB(this.f4482a.n, view.getContext(), 3, false);
                } else {
                    ThreadCardUtils.startImageViewer(view, this.f4482a.l, this.f4482a.p, i2, this.f4482a.n.getThreadData(), this.f4482a.k);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MutiImgAbLayout f4483a;

        public c(MutiImgAbLayout mutiImgAbLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mutiImgAbLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4483a = mutiImgAbLayout;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(TbImageView tbImageView, Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, tbImageView, canvas) == null) {
            }
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
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbImageView, canvas) == null) || tbImageView == null || tbImageView.getImageMatrix() == null) {
                return;
            }
            d.a.c.k.d.a m = d.a.o0.a0.c.k().m(d.a.c.e.l.d.h().g(tbImageView.getUrl(), this.f4483a.l ? 13 : 14));
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
            if (tbImageView.z() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
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
            } else if (tbImageView.x() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
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
                if (this.f4483a.q && i2 > i3) {
                    imageMatrix.postTranslate(f4, 0.0f);
                } else {
                    imageMatrix.postTranslate(f4, f3);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f4484e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f4485f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f4486g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ MutiImgAbLayout f4487h;

        public d(MutiImgAbLayout mutiImgAbLayout, int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mutiImgAbLayout, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4487h = mutiImgAbLayout;
            a(i2, z, z2);
        }

        public void a(int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.f4484e = i2;
                this.f4485f = z;
                this.f4486g = z2;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || this.f4487h.o == null) {
                return;
            }
            this.f4487h.o.a(view, this.f4484e, this.f4485f && this.f4486g);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(702299971, "Lcom/baidu/card/view/MutiImgAbLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(702299971, "Lcom/baidu/card/view/MutiImgAbLayout;");
                return;
            }
        }
        u = l.k(TbadkCoreApplication.getInst()) - ((l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002);
        v = dimensionPixelSize;
        w = (u - (dimensionPixelSize * 2)) / 3;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MutiImgAbLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void setImageData(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, b2Var) == null) {
            ArrayList<MediaData> z0 = b2Var.z0();
            if (k.c().g() && ListUtils.getCount(z0) != 0) {
                LinkedList<MediaData> linkedList = new LinkedList<>();
                for (int i2 = 0; i2 < z0.size(); i2++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(z0, i2);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                this.p = linkedList;
                if (ListUtils.getCount(linkedList) >= 2) {
                    this.f4479h.removeAllViews();
                    this.f4479h.setVisibility(0);
                    int i3 = d.a.o0.b.d.o() ? 4 : 3;
                    for (int i4 = 0; i4 < ListUtils.getCount(linkedList) && i4 < i3; i4++) {
                        if (i4 == 2) {
                            l((MediaData) ListUtils.getItem(z0, 2), ListUtils.getCount(linkedList) > i3, true ^ d.a.o0.b.d.o(), 2);
                        } else if (i4 == 3) {
                            l((MediaData) ListUtils.getItem(z0, 3), ListUtils.getCount(linkedList) > i3, true, 3);
                        } else {
                            l((MediaData) ListUtils.getItem(z0, i4), false, false, i4);
                        }
                    }
                    if (linkedList.size() > i3) {
                        this.f4480i.setText(TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(linkedList.size() - i3)}));
                        this.j.setVisibility(0);
                        d.a.o0.r.u.c.d(this.j).n(R.string.J_X09);
                        int i5 = w;
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i5, i5);
                        layoutParams.addRule(11);
                        layoutParams.addRule(12);
                        this.f4479h.addView(this.j, layoutParams);
                        return;
                    }
                    this.j.setVisibility(8);
                    return;
                }
                this.f4479h.setVisibility(8);
                return;
            }
            this.f4479h.setVisibility(8);
        }
    }

    private void setVoiceData(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, b2Var) == null) {
            ArrayList<VoiceData$VoiceModel> x1 = b2Var.x1();
            if (ListUtils.isEmpty(x1)) {
                this.f4478g.setVisibility(8);
                return;
            }
            this.f4478g.setVisibility(0);
            VoiceData$VoiceModel voiceData$VoiceModel = x1.get(0);
            this.f4478g.setVoiceModel(voiceData$VoiceModel);
            this.f4478g.setTag(voiceData$VoiceModel);
            this.f4478g.b();
            if (voiceData$VoiceModel != null) {
                this.f4478g.j(voiceData$VoiceModel.voice_status.intValue());
            }
            this.f4478g.l();
        }
    }

    public final String g(MediaData mediaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaData)) == null) {
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
        return (String) invokeL.objValue;
    }

    public b0<d.a.o0.r.q.a> getSubClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.m : (b0) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.multi_image_ab_layout, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f4477f = (TextView) findViewById(R.id.thread_card_abstract);
            this.f4476e = (TextView) findViewById(R.id.thread_card_title);
            PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
            this.f4478g = playVoiceBntNew;
            playVoiceBntNew.setAfterClickListener(new a(this));
            this.f4479h = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
            this.f4480i = (TextView) findViewById(R.id.thread_card_img_more_label);
            this.j = (ViewGroup) findViewById(R.id.thread_card_img_more_shadow);
            d.a.o0.r.u.c d2 = d.a.o0.r.u.c.d(this.f4480i);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0607);
            this.f4480i.setTypeface(d.a.o0.r.u.a.F(d.a.o0.r.u.a.C(R.string.F_X02)));
            this.o = new b(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j.p
    /* renamed from: i */
    public void a(d.a.o0.r.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.n = aVar;
            b2 threadData = aVar.getThreadData();
            ThreadCardUtils.setTitle(this.f4476e, threadData, this.r);
            ThreadCardUtils.setAbstract(this.f4477f, this.f4476e, threadData, u, this.r);
            TextView textView = this.f4476e;
            boolean z = false;
            boolean z2 = textView == null || textView.getVisibility() != 0;
            TextView textView2 = this.f4477f;
            boolean z3 = textView2 == null || textView2.getVisibility() != 0;
            RelativeLayout relativeLayout = this.f4479h;
            if (z2 && z3) {
                z = true;
            }
            ThreadCardUtils.dealMainViewTopMargin(relativeLayout, z, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            setImageData(threadData);
            setVoiceData(threadData);
        }
    }

    public final void j(TbImageView tbImageView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, tbImageView, i2) == null) || tbImageView == null) {
            return;
        }
        tbImageView.setId(this.s[i2]);
        int count = ListUtils.getCount(this.p);
        RelativeLayout.LayoutParams layoutParams = null;
        if (count == 2) {
            int i3 = (u - v) / 2;
            layoutParams = new RelativeLayout.LayoutParams(i3, i3);
            if (i2 == 1) {
                layoutParams.addRule(1, this.s[0]);
                layoutParams.leftMargin = v;
                tbImageView.setConrers(10);
            } else if (i2 == 0) {
                tbImageView.setConrers(5);
            }
        } else if (count == 3 || !d.a.o0.b.d.o()) {
            if (i2 == 0) {
                int i4 = w;
                int i5 = v;
                layoutParams = new RelativeLayout.LayoutParams((i4 * 2) + i5, (i4 * 2) + i5);
                tbImageView.setConrers(5);
            } else if (i2 == 1) {
                int i6 = w;
                layoutParams = new RelativeLayout.LayoutParams(i6, i6);
                layoutParams.addRule(1, this.s[0]);
                layoutParams.leftMargin = v;
                tbImageView.setConrers(2);
            } else if (i2 == 2) {
                int i7 = w;
                layoutParams = new RelativeLayout.LayoutParams(i7, i7);
                layoutParams.addRule(1, this.s[0]);
                layoutParams.addRule(3, this.s[1]);
                int i8 = v;
                layoutParams.topMargin = i8;
                layoutParams.leftMargin = i8;
                tbImageView.setConrers(8);
            }
        } else if (count > 3 && d.a.o0.b.d.o()) {
            MediaData mediaData = (MediaData) ListUtils.getItem(this.p, 0);
            if (mediaData.picHeight > mediaData.picWidth) {
                if (i2 == 0) {
                    int i9 = w;
                    int i10 = v;
                    layoutParams = new RelativeLayout.LayoutParams((i9 * 2) + i10, (i9 * 3) + (i10 * 2));
                    tbImageView.setConrers(5);
                } else if (i2 == 1) {
                    int i11 = w;
                    layoutParams = new RelativeLayout.LayoutParams(i11, i11);
                    layoutParams.addRule(1, this.s[0]);
                    layoutParams.leftMargin = v;
                    tbImageView.setConrers(2);
                } else if (i2 == 2) {
                    int i12 = w;
                    layoutParams = new RelativeLayout.LayoutParams(i12, i12);
                    layoutParams.addRule(1, this.s[0]);
                    layoutParams.addRule(3, this.s[1]);
                    int i13 = v;
                    layoutParams.topMargin = i13;
                    layoutParams.leftMargin = i13;
                    tbImageView.setConrers(0);
                    tbImageView.setRadiusById(R.string.J_X02);
                } else if (i2 == 3) {
                    int i14 = w;
                    layoutParams = new RelativeLayout.LayoutParams(i14, i14);
                    layoutParams.addRule(1, this.s[0]);
                    layoutParams.addRule(3, this.s[2]);
                    int i15 = v;
                    layoutParams.topMargin = i15;
                    layoutParams.leftMargin = i15;
                    tbImageView.setConrers(8);
                }
            } else if (i2 == 0) {
                layoutParams = new RelativeLayout.LayoutParams(u, (w * 2) + v);
                tbImageView.setConrers(3);
            } else if (i2 == 1) {
                int i16 = w;
                layoutParams = new RelativeLayout.LayoutParams(i16, i16);
                layoutParams.addRule(3, this.s[0]);
                layoutParams.topMargin = v;
                tbImageView.setConrers(4);
            } else if (i2 == 2) {
                int i17 = w;
                layoutParams = new RelativeLayout.LayoutParams(i17, i17);
                layoutParams.addRule(1, this.s[1]);
                layoutParams.addRule(3, this.s[0]);
                int i18 = v;
                layoutParams.topMargin = i18;
                layoutParams.leftMargin = i18;
                tbImageView.setConrers(0);
                tbImageView.setRadiusById(R.string.J_X02);
            } else if (i2 == 3) {
                int i19 = w;
                layoutParams = new RelativeLayout.LayoutParams(i19, i19);
                layoutParams.addRule(1, this.s[2]);
                layoutParams.addRule(3, this.s[0]);
                int i20 = v;
                layoutParams.topMargin = i20;
                layoutParams.leftMargin = i20;
                tbImageView.setConrers(8);
            }
        }
        this.f4479h.addView(tbImageView, layoutParams);
    }

    public final void k(TbImageView tbImageView, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{tbImageView, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (this.o != null && tbImageView != null) {
                View.OnClickListener onClickListener = tbImageView.getOnClickListener();
                if (onClickListener instanceof d) {
                    ((d) onClickListener).a(i2, z, z2);
                } else {
                    tbImageView.setOnClickListener(new d(this, i2, z, z2));
                }
            } else if (this.o != null || tbImageView == null) {
            } else {
                tbImageView.setClickable(false);
            }
        }
    }

    public final void l(MediaData mediaData, boolean z, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{mediaData, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            String g2 = g(mediaData);
            int i3 = this.l ? 13 : 14;
            setCanCenterStart(false);
            boolean isLongPic = mediaData.isLongPic();
            boolean isSmartCrop = mediaData.isSmartCrop();
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setDrawCorner(true);
            tbImageView.setRadiusById(R.string.J_X05);
            tbImageView.setPlaceHolder(2);
            tbImageView.setConrers(15);
            tbImageView.setScaleType(ImageView.ScaleType.MATRIX);
            tbImageView.setIsLongPic(isLongPic);
            tbImageView.setIsSmartCrop(isSmartCrop);
            tbImageView.setSmartCropCenterPointWidthRatio((float) mediaData.getSmartCropCenterPointWidthRatio());
            tbImageView.setSmartCropCenterPointHeightRatio((float) mediaData.getSmartCropCenterPointHeightRatio());
            tbImageView.setForegroundColor(0);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setOnDrawListener(this.t);
            if (z2 && z) {
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setLongIconSupport(true);
                tbImageView.setGifIconSupport(true);
            }
            tbImageView.M(g2, i3, false);
            k(tbImageView, i2, z, z2);
            j(tbImageView, i2);
        }
    }

    public void setCanCenterStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.q = z;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.k = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.l = z;
        }
    }

    public void setMarginsTop(View view, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048587, this, view, i2) == null) && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i2) {
                marginLayoutParams.topMargin = i2;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void setNeedFrsTabName(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.r = z;
        }
    }

    public void setPreloadSizeReadyCallback(d.a.c.k.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
        }
    }

    public void setSubClickListener(b0<d.a.o0.r.q.a> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, b0Var) == null) {
            this.m = b0Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutiImgAbLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.l = true;
        this.n = null;
        this.q = false;
        this.r = false;
        this.s = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4};
        this.t = new c(this);
        h();
    }
}
