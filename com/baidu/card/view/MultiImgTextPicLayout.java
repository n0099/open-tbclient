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
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
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
import d.a.j.m0;
import d.a.j.p;
import d.a.o0.r.k;
import d.a.o0.r.q.b2;
import d.a.p0.a0.b0;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgTextPicLayout extends LinearLayout implements p<d.a.o0.r.q.a> {
    public static /* synthetic */ Interceptable $ic;
    public static final int y;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4464e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f4465f;

    /* renamed from: g  reason: collision with root package name */
    public PlayVoiceBntNew f4466g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f4467h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f4468i;
    public TbImageView j;
    public TbImageView k;
    public TextView l;
    public TbImageView m;
    public String n;
    public boolean o;
    public b0<d.a.o0.r.q.a> p;
    public d.a.o0.r.q.a q;
    public int r;
    public d.a.o0.b1.j.d s;
    public LinkedList<MediaData> t;
    public boolean u;
    public int v;
    public boolean w;
    public TbImageView.g x;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MultiImgTextPicLayout f4469e;

        public a(MultiImgTextPicLayout multiImgTextPicLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImgTextPicLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4469e = multiImgTextPicLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b0<d.a.o0.r.q.a> subClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (subClickListener = this.f4469e.getSubClickListener()) == null) {
                return;
            }
            view.setTag("2");
            subClickListener.a(view, this.f4469e.q);
        }
    }

    /* loaded from: classes.dex */
    public class b implements d.a.o0.b1.j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MultiImgTextPicLayout f4470a;

        public b(MultiImgTextPicLayout multiImgTextPicLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImgTextPicLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4470a = multiImgTextPicLayout;
        }

        @Override // d.a.o0.b1.j.d
        public void a(View view, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                b0<d.a.o0.r.q.a> subClickListener = this.f4470a.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    this.f4470a.q.objType = 2;
                    subClickListener.f53781a = Boolean.valueOf(z);
                    subClickListener.a(view, this.f4470a.q);
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().q) {
                    ThreadCardUtils.startImageViewer(view, this.f4470a.o, this.f4470a.t, i2, this.f4470a.q.getThreadData(), this.f4470a.n);
                } else if ("index".equals(this.f4470a.n)) {
                    ThreadCardUtils.jumpToPB(this.f4470a.q, view.getContext(), 2, false);
                } else if ("frs".equals(this.f4470a.n)) {
                    ThreadCardUtils.jumpToPB(this.f4470a.q, view.getContext(), 3, false);
                } else {
                    ThreadCardUtils.startImageViewer(view, this.f4470a.o, this.f4470a.t, i2, this.f4470a.q.getThreadData(), this.f4470a.n);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MultiImgTextPicLayout f4471a;

        public c(MultiImgTextPicLayout multiImgTextPicLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImgTextPicLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4471a = multiImgTextPicLayout;
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
            d.a.c.k.d.a m = d.a.o0.a0.c.k().m(d.a.c.e.l.d.h().g(tbImageView.getUrl(), this.f4471a.o ? 13 : 14));
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
                if (this.f4471a.u && i2 > i3) {
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
        public int f4472e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f4473f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f4474g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ MultiImgTextPicLayout f4475h;

        public d(MultiImgTextPicLayout multiImgTextPicLayout, int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImgTextPicLayout, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4475h = multiImgTextPicLayout;
            a(i2, z, z2);
        }

        public void a(int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.f4472e = i2;
                this.f4473f = z;
                this.f4474g = z2;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || this.f4475h.s == null) {
                return;
            }
            this.f4475h.s.a(view, this.f4472e, this.f4473f && this.f4474g);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1005291465, "Lcom/baidu/card/view/MultiImgTextPicLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1005291465, "Lcom/baidu/card/view/MultiImgTextPicLayout;");
                return;
            }
        }
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds7);
        y = l.k(TbadkCoreApplication.getInst()) - ((l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultiImgTextPicLayout(Context context) {
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
        boolean z;
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
                this.t = linkedList;
                if (linkedList.size() == 1) {
                    this.l.setVisibility(8);
                    this.f4467h.setVisibility(8);
                    this.m.setVisibility(0);
                    l((MediaData) ListUtils.getItem(z0, 0), this.m, false, false, 0);
                    return;
                }
                this.m.setVisibility(8);
                d.a.o0.b.g.b.h(this.l, R.drawable.thread_card_more_number_bg);
                if (linkedList.size() > 3) {
                    this.l.setText(TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(linkedList.size() - 3)}));
                    this.l.setVisibility(0);
                    z = true;
                } else {
                    this.l.setVisibility(8);
                    z = false;
                }
                this.f4467h.setVisibility(8);
                if (ListUtils.getCount(linkedList) == 2) {
                    this.f4467h.setVisibility(0);
                    boolean z2 = z;
                    l((MediaData) ListUtils.getItem(z0, 0), this.f4468i, z2, false, 0);
                    this.j.setVisibility(8);
                    l((MediaData) ListUtils.getItem(z0, 1), this.k, z2, false, 1);
                    return;
                } else if (ListUtils.getCount(linkedList) >= 3) {
                    this.f4467h.setVisibility(0);
                    this.j.setVisibility(0);
                    boolean z3 = z;
                    l((MediaData) ListUtils.getItem(z0, 0), this.f4468i, z3, false, 0);
                    l((MediaData) ListUtils.getItem(z0, 1), this.j, z3, false, 1);
                    l((MediaData) ListUtils.getItem(z0, 2), this.k, z3, true, 2);
                    return;
                } else {
                    this.f4467h.setVisibility(8);
                    return;
                }
            }
            this.f4467h.setVisibility(8);
        }
    }

    private void setImageTextData(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, b2Var) == null) {
        }
    }

    private void setSingleImgData(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, b2Var) == null) {
            this.l.setVisibility(8);
            this.f4467h.setVisibility(8);
            ArrayList<MediaData> z0 = b2Var.z0();
            if (k.c().g() && ListUtils.getCount(z0) != 0) {
                LinkedList<MediaData> linkedList = new LinkedList<>();
                MediaData mediaData = null;
                int i2 = 0;
                while (true) {
                    if (i2 < z0.size()) {
                        mediaData = (MediaData) ListUtils.getItem(z0, i2);
                        if (mediaData != null && mediaData.getType() == 3) {
                            linkedList.add(mediaData);
                            break;
                        }
                        i2++;
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
    }

    private void setVoiceData(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, b2Var) == null) {
            ArrayList<VoiceData$VoiceModel> x1 = b2Var.x1();
            if (ListUtils.isEmpty(x1)) {
                this.f4466g.setVisibility(8);
                return;
            }
            this.f4466g.setVisibility(0);
            VoiceData$VoiceModel voiceData$VoiceModel = x1.get(0);
            this.f4466g.setVoiceModel(voiceData$VoiceModel);
            this.f4466g.setTag(voiceData$VoiceModel);
            this.f4466g.b();
            if (voiceData$VoiceModel != null) {
                this.f4466g.j(voiceData$VoiceModel.voice_status.intValue());
            }
            this.f4466g.l();
        }
    }

    public final int g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (this.r > 0) {
                int k = l.k(getContext());
                if (k == this.v) {
                    return this.r;
                }
                this.v = k;
            }
            int size = (View.MeasureSpec.getSize(i2) - (2 * TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10))) / 3;
            this.r = size;
            return size;
        }
        return invokeI.intValue;
    }

    public b0<d.a.o0.r.q.a> getSubClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.p : (b0) invokeV.objValue;
    }

    public final String h(MediaData mediaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, mediaData)) == null) {
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

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.multi_image_card_layout, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f4465f = (TextView) findViewById(R.id.thread_card_abstract);
            this.f4464e = (TextView) findViewById(R.id.thread_card_title);
            PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
            this.f4466g = playVoiceBntNew;
            playVoiceBntNew.setAfterClickListener(new a(this));
            int k = ((l.k(getContext()) - (m0.k * 2)) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
            this.f4467h = relativeLayout;
            d.a.o0.b.g.b.d(relativeLayout, R.dimen.tbds26, R.dimen.tbds14);
            d.a.o0.b.g.b.m(this.f4464e, R.dimen.tbds7, R.dimen.tbds10);
            d.a.o0.b.g.b.m(this.f4465f, R.dimen.tbds7, R.dimen.tbds10);
            this.f4467h.getLayoutParams().height = k;
            TbImageView tbImageView = (TbImageView) findViewById(R.id.thread_card_img_more_one);
            this.f4468i = tbImageView;
            tbImageView.setDrawCorner(true);
            this.f4468i.setRadiusById(R.string.J_X12);
            this.f4468i.setPlaceHolder(2);
            this.f4468i.setConrers(15);
            this.f4468i.getLayoutParams().height = k;
            this.f4468i.getLayoutParams().width = k;
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
            d.a.o0.r.u.c.d(this.l).w(R.array.S_O_X001);
            this.l.setTypeface(d.a.o0.r.u.a.F(d.a.o0.r.u.a.C(R.string.F_X02)));
            TbImageView tbImageView4 = (TbImageView) findViewById(R.id.thread_card_img_singal);
            this.m = tbImageView4;
            tbImageView4.setRadiusById(R.string.J_X05);
            this.m.setConrers(15);
            this.m.setDrawCorner(true);
            this.m.setPlaceHolder(3);
            this.m.setLongIconSupport(true);
            this.m.setGifIconSupport(true);
            d.a.o0.b.g.b.d(this.m, R.dimen.tbds28, R.dimen.tbds14);
            this.s = new b(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j.p
    /* renamed from: j */
    public void a(d.a.o0.r.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.q = aVar;
            b2 threadData = aVar.getThreadData();
            ThreadCardUtils.setTitle(this.f4464e, threadData, this.w);
            ThreadCardUtils.setAbstract(this.f4465f, this.f4464e, threadData, y, this.w);
            setImageData(threadData);
            setVoiceData(threadData);
        }
    }

    public final void k(TbImageView tbImageView, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{tbImageView, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (this.s != null && tbImageView != null) {
                View.OnClickListener onClickListener = tbImageView.getOnClickListener();
                if (onClickListener instanceof d) {
                    ((d) onClickListener).a(i2, z, z2);
                } else {
                    tbImageView.setOnClickListener(new d(this, i2, z, z2));
                }
            } else if (this.s != null || tbImageView == null) {
            } else {
                tbImageView.setClickable(false);
            }
        }
    }

    public final void l(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{mediaData, tbImageView, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            String h2 = h(mediaData);
            int i3 = this.o ? 13 : 14;
            if (!StringHelper.equals(h2, tbImageView.getUrl())) {
                tbImageView.I();
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
            tbImageView.M(h2, i3, false);
            k(tbImageView, i2, z, z2);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int g2 = g(i2);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f4468i.getLayoutParams();
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
            if (this.f4467h.getVisibility() != 8) {
                this.f4468i.setLayoutParams(layoutParams);
                this.j.setLayoutParams(layoutParams2);
                this.k.setLayoutParams(layoutParams3);
                this.l.setLayoutParams(layoutParams4);
            }
        }
    }

    public void setCanCenterStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.u = z;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.n = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.o = z;
        }
    }

    public void setMarginsTop(View view, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048588, this, view, i2) == null) && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i2) {
                marginLayoutParams.topMargin = i2;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void setNeedFrsTabName(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.w = z;
        }
    }

    public void setPreloadSizeReadyCallback(d.a.c.k.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) {
        }
    }

    public void setSubClickListener(b0<d.a.o0.r.q.a> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, b0Var) == null) {
            this.p = b0Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiImgTextPicLayout(Context context, @Nullable AttributeSet attributeSet) {
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
        this.o = true;
        this.q = null;
        this.r = 0;
        this.u = false;
        this.v = 0;
        this.w = false;
        this.x = new c(this);
        i();
    }
}
