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
import c.a.e.e.p.l;
import c.a.l.p;
import c.a.p0.s.k;
import c.a.p0.s.q.c2;
import c.a.q0.a0.b0;
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
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class MutiImgAbLayout extends LinearLayout implements p<c.a.p0.s.q.a> {
    public static /* synthetic */ Interceptable $ic;
    public static final int p;
    public static final int q;
    public static final int r;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean canCenterStart;

    /* renamed from: e  reason: collision with root package name */
    public TextView f38582e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f38583f;

    /* renamed from: g  reason: collision with root package name */
    public String f38584g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f38585h;

    /* renamed from: i  reason: collision with root package name */
    public b0<c.a.p0.s.q.a> f38586i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.p0.s.q.a f38587j;
    public c.a.p0.d1.j.d k;
    public LinkedList<MediaData> l;
    public boolean m;
    public TextView mAbstract;
    public TextView mTitle;
    public PlayVoiceBntNew mVoiceBtn;
    public RelativeLayout moreImgContainer;
    public int[] n;
    public TbImageView.g o;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MutiImgAbLayout f38588e;

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
            this.f38588e = mutiImgAbLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b0<c.a.p0.s.q.a> subClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (subClickListener = this.f38588e.getSubClickListener()) == null) {
                return;
            }
            view.setTag("2");
            subClickListener.a(view, this.f38588e.f38587j);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements c.a.p0.d1.j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MutiImgAbLayout f38589a;

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
            this.f38589a = mutiImgAbLayout;
        }

        @Override // c.a.p0.d1.j.d
        public void a(View view, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                b0<c.a.p0.s.q.a> subClickListener = this.f38589a.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    this.f38589a.f38587j.objType = 2;
                    subClickListener.f15237a = Boolean.valueOf(z);
                    subClickListener.a(view, this.f38589a.f38587j);
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().p) {
                    ThreadCardUtils.startImageViewer(view, this.f38589a.f38585h, this.f38589a.l, i2, this.f38589a.f38587j.getThreadData(), this.f38589a.f38584g);
                } else if ("index".equals(this.f38589a.f38584g)) {
                    ThreadCardUtils.jumpToPB(this.f38589a.f38587j, view.getContext(), 2, false);
                } else if ("frs".equals(this.f38589a.f38584g)) {
                    ThreadCardUtils.jumpToPB(this.f38589a.f38587j, view.getContext(), 3, false);
                } else {
                    ThreadCardUtils.startImageViewer(view, this.f38589a.f38585h, this.f38589a.l, i2, this.f38589a.f38587j.getThreadData(), this.f38589a.f38584g);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MutiImgAbLayout f38590a;

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
            this.f38590a = mutiImgAbLayout;
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
            c.a.e.l.d.a m = c.a.p0.b0.c.k().m(c.a.e.e.l.d.h().g(tbImageView.getUrl(), this.f38590a.f38585h ? 13 : 14));
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
            if (tbImageView.isSmartCrop() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
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
            } else if (tbImageView.isLongPic() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
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
                if (this.f38590a.canCenterStart && i2 > i3) {
                    imageMatrix.postTranslate(f4, 0.0f);
                } else {
                    imageMatrix.postTranslate(f4, f3);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f38591e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f38592f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f38593g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ MutiImgAbLayout f38594h;

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
            this.f38594h = mutiImgAbLayout;
            a(i2, z, z2);
        }

        public void a(int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.f38591e = i2;
                this.f38592f = z;
                this.f38593g = z2;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || this.f38594h.k == null) {
                return;
            }
            this.f38594h.k.a(view, this.f38591e, this.f38592f && this.f38593g);
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
        p = l.k(TbadkCoreApplication.getInst()) - ((l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002);
        q = dimensionPixelSize;
        r = (p - (dimensionPixelSize * 2)) / 3;
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

    private void setImageData(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, c2Var) == null) {
            ArrayList<MediaData> C0 = c2Var.C0();
            if (k.c().g() && ListUtils.getCount(C0) != 0) {
                LinkedList<MediaData> linkedList = new LinkedList<>();
                for (int i2 = 0; i2 < C0.size(); i2++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(C0, i2);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                this.l = linkedList;
                if (ListUtils.getCount(linkedList) >= 2) {
                    this.moreImgContainer.removeAllViews();
                    this.moreImgContainer.setVisibility(0);
                    int i3 = c.a.p0.b.d.q() ? 4 : 3;
                    for (int i4 = 0; i4 < ListUtils.getCount(linkedList) && i4 < i3; i4++) {
                        if (i4 == 2) {
                            j((MediaData) ListUtils.getItem(C0, 2), ListUtils.getCount(linkedList) > i3, true ^ c.a.p0.b.d.q(), 2);
                        } else if (i4 == 3) {
                            j((MediaData) ListUtils.getItem(C0, 3), ListUtils.getCount(linkedList) > i3, true, 3);
                        } else {
                            j((MediaData) ListUtils.getItem(C0, i4), false, false, i4);
                        }
                    }
                    if (linkedList.size() > i3) {
                        this.f38582e.setText(TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(linkedList.size() - i3)}));
                        this.f38583f.setVisibility(0);
                        c.a.p0.s.u.c.d(this.f38583f).n(R.string.J_X09);
                        int i5 = r;
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i5, i5);
                        layoutParams.addRule(11);
                        layoutParams.addRule(12);
                        this.moreImgContainer.addView(this.f38583f, layoutParams);
                        return;
                    }
                    this.f38583f.setVisibility(8);
                    return;
                }
                this.moreImgContainer.setVisibility(8);
                return;
            }
            this.moreImgContainer.setVisibility(8);
        }
    }

    private void setVoiceData(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, c2Var) == null) {
            ArrayList<VoiceData$VoiceModel> B1 = c2Var.B1();
            if (ListUtils.isEmpty(B1)) {
                this.mVoiceBtn.setVisibility(8);
                return;
            }
            this.mVoiceBtn.setVisibility(0);
            VoiceData$VoiceModel voiceData$VoiceModel = B1.get(0);
            this.mVoiceBtn.setVoiceModel(voiceData$VoiceModel);
            this.mVoiceBtn.setTag(voiceData$VoiceModel);
            this.mVoiceBtn.changeSkin();
            if (voiceData$VoiceModel != null) {
                this.mVoiceBtn.refreshViewState(voiceData$VoiceModel.voice_status.intValue());
            }
            this.mVoiceBtn.resetLayoutParams();
        }
    }

    public final String f(MediaData mediaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mediaData)) == null) {
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

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.multi_image_ab_layout, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.mAbstract = (TextView) findViewById(R.id.thread_card_abstract);
            this.mTitle = (TextView) findViewById(R.id.thread_card_title);
            PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
            this.mVoiceBtn = playVoiceBntNew;
            playVoiceBntNew.setAfterClickListener(new a(this));
            this.moreImgContainer = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
            this.f38582e = (TextView) findViewById(R.id.thread_card_img_more_label);
            this.f38583f = (ViewGroup) findViewById(R.id.thread_card_img_more_shadow);
            c.a.p0.s.u.c d2 = c.a.p0.s.u.c.d(this.f38582e);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0607);
            this.f38582e.setTypeface(c.a.p0.s.u.a.H(c.a.p0.s.u.a.E(R.string.F_X02)));
            this.k = new b(this);
        }
    }

    public b0<c.a.p0.s.q.a> getSubClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f38586i : (b0) invokeV.objValue;
    }

    public final void h(TbImageView tbImageView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, tbImageView, i2) == null) || tbImageView == null) {
            return;
        }
        tbImageView.setId(this.n[i2]);
        int count = ListUtils.getCount(this.l);
        RelativeLayout.LayoutParams layoutParams = null;
        if (count == 2) {
            int i3 = (p - q) / 2;
            layoutParams = new RelativeLayout.LayoutParams(i3, i3);
            if (i2 == 1) {
                layoutParams.addRule(1, this.n[0]);
                layoutParams.leftMargin = q;
                tbImageView.setConrers(10);
            } else if (i2 == 0) {
                tbImageView.setConrers(5);
            }
        } else if (count == 3 || !c.a.p0.b.d.q()) {
            if (i2 == 0) {
                int i4 = r;
                int i5 = q;
                layoutParams = new RelativeLayout.LayoutParams((i4 * 2) + i5, (i4 * 2) + i5);
                tbImageView.setConrers(5);
            } else if (i2 == 1) {
                int i6 = r;
                layoutParams = new RelativeLayout.LayoutParams(i6, i6);
                layoutParams.addRule(1, this.n[0]);
                layoutParams.leftMargin = q;
                tbImageView.setConrers(2);
            } else if (i2 == 2) {
                int i7 = r;
                layoutParams = new RelativeLayout.LayoutParams(i7, i7);
                layoutParams.addRule(1, this.n[0]);
                layoutParams.addRule(3, this.n[1]);
                int i8 = q;
                layoutParams.topMargin = i8;
                layoutParams.leftMargin = i8;
                tbImageView.setConrers(8);
            }
        } else if (count > 3 && c.a.p0.b.d.q()) {
            MediaData mediaData = (MediaData) ListUtils.getItem(this.l, 0);
            if (mediaData.picHeight > mediaData.picWidth) {
                if (i2 == 0) {
                    int i9 = r;
                    int i10 = q;
                    layoutParams = new RelativeLayout.LayoutParams((i9 * 2) + i10, (i9 * 3) + (i10 * 2));
                    tbImageView.setConrers(5);
                } else if (i2 == 1) {
                    int i11 = r;
                    layoutParams = new RelativeLayout.LayoutParams(i11, i11);
                    layoutParams.addRule(1, this.n[0]);
                    layoutParams.leftMargin = q;
                    tbImageView.setConrers(2);
                } else if (i2 == 2) {
                    int i12 = r;
                    layoutParams = new RelativeLayout.LayoutParams(i12, i12);
                    layoutParams.addRule(1, this.n[0]);
                    layoutParams.addRule(3, this.n[1]);
                    int i13 = q;
                    layoutParams.topMargin = i13;
                    layoutParams.leftMargin = i13;
                    tbImageView.setConrers(0);
                    tbImageView.setRadiusById(R.string.J_X02);
                } else if (i2 == 3) {
                    int i14 = r;
                    layoutParams = new RelativeLayout.LayoutParams(i14, i14);
                    layoutParams.addRule(1, this.n[0]);
                    layoutParams.addRule(3, this.n[2]);
                    int i15 = q;
                    layoutParams.topMargin = i15;
                    layoutParams.leftMargin = i15;
                    tbImageView.setConrers(8);
                }
            } else if (i2 == 0) {
                layoutParams = new RelativeLayout.LayoutParams(p, (r * 2) + q);
                tbImageView.setConrers(3);
            } else if (i2 == 1) {
                int i16 = r;
                layoutParams = new RelativeLayout.LayoutParams(i16, i16);
                layoutParams.addRule(3, this.n[0]);
                layoutParams.topMargin = q;
                tbImageView.setConrers(4);
            } else if (i2 == 2) {
                int i17 = r;
                layoutParams = new RelativeLayout.LayoutParams(i17, i17);
                layoutParams.addRule(1, this.n[1]);
                layoutParams.addRule(3, this.n[0]);
                int i18 = q;
                layoutParams.topMargin = i18;
                layoutParams.leftMargin = i18;
                tbImageView.setConrers(0);
                tbImageView.setRadiusById(R.string.J_X02);
            } else if (i2 == 3) {
                int i19 = r;
                layoutParams = new RelativeLayout.LayoutParams(i19, i19);
                layoutParams.addRule(1, this.n[2]);
                layoutParams.addRule(3, this.n[0]);
                int i20 = q;
                layoutParams.topMargin = i20;
                layoutParams.leftMargin = i20;
                tbImageView.setConrers(8);
            }
        }
        this.moreImgContainer.addView(tbImageView, layoutParams);
    }

    public final void i(TbImageView tbImageView, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{tbImageView, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (this.k != null && tbImageView != null) {
                View.OnClickListener onClickListener = tbImageView.getOnClickListener();
                if (onClickListener instanceof d) {
                    ((d) onClickListener).a(i2, z, z2);
                } else {
                    tbImageView.setOnClickListener(new d(this, i2, z, z2));
                }
            } else if (this.k != null || tbImageView == null) {
            } else {
                tbImageView.setClickable(false);
            }
        }
    }

    public final void j(MediaData mediaData, boolean z, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{mediaData, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            String f2 = f(mediaData);
            int i3 = this.f38585h ? 13 : 14;
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
            tbImageView.setOnDrawListener(this.o);
            if (z2 && z) {
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setLongIconSupport(true);
                tbImageView.setGifIconSupport(true);
            }
            tbImageView.startLoad(f2, i3, false);
            i(tbImageView, i2, z, z2);
            h(tbImageView, i2);
        }
    }

    public void setCanCenterStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.canCenterStart = z;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f38584g = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f38585h = z;
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
            this.m = z;
        }
    }

    public void setPreloadSizeReadyCallback(c.a.e.l.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
        }
    }

    public void setSubClickListener(b0<c.a.p0.s.q.a> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, b0Var) == null) {
            this.f38586i = b0Var;
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
        this.f38585h = true;
        this.f38587j = null;
        this.canCenterStart = false;
        this.m = false;
        this.n = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4};
        this.o = new c(this);
        g();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    public void onBindDataToView(c.a.p0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.f38587j = aVar;
            c2 threadData = aVar.getThreadData();
            ThreadCardUtils.setTitle(this.mTitle, threadData, this.m);
            ThreadCardUtils.setAbstract(this.mAbstract, this.mTitle, threadData, p, this.m);
            TextView textView = this.mTitle;
            boolean z = false;
            boolean z2 = textView == null || textView.getVisibility() != 0;
            TextView textView2 = this.mAbstract;
            boolean z3 = textView2 == null || textView2.getVisibility() != 0;
            RelativeLayout relativeLayout = this.moreImgContainer;
            if (z2 && z3) {
                z = true;
            }
            ThreadCardUtils.dealMainViewTopMargin(relativeLayout, z, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            setImageData(threadData);
            setVoiceData(threadData);
        }
    }
}
