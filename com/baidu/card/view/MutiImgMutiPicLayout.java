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
import b.a.e.f.p.l;
import b.a.l.p;
import b.a.q0.s.k;
import b.a.q0.s.q.d2;
import b.a.r0.b0.d0;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class MutiImgMutiPicLayout extends LinearLayout implements p<b.a.q0.s.q.a> {
    public static /* synthetic */ Interceptable $ic;
    public static final int q;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean canCenterStart;

    /* renamed from: e  reason: collision with root package name */
    public TextView f37586e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f37587f;

    /* renamed from: g  reason: collision with root package name */
    public String f37588g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f37589h;

    /* renamed from: i  reason: collision with root package name */
    public d0<b.a.q0.s.q.a> f37590i;
    public b.a.q0.s.q.a j;
    public int k;
    public b.a.q0.e1.j.d l;
    public LinkedList<MediaData> m;
    public TextView mAbstract;
    public TextView mTitle;
    public PlayVoiceBntNew mVoiceBtn;
    public RelativeLayout moreImgContainer;
    public TbImageView moreImgOne;
    public TbImageView moreImgThree;
    public TbImageView moreImgTwo;
    public int n;
    public boolean o;
    public TbImageView.h p;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MutiImgMutiPicLayout f37591e;

        public a(MutiImgMutiPicLayout mutiImgMutiPicLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mutiImgMutiPicLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37591e = mutiImgMutiPicLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d0<b.a.q0.s.q.a> subClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (subClickListener = this.f37591e.getSubClickListener()) == null) {
                return;
            }
            view.setTag("2");
            subClickListener.a(view, this.f37591e.j);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements b.a.q0.e1.j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MutiImgMutiPicLayout f37592a;

        public b(MutiImgMutiPicLayout mutiImgMutiPicLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mutiImgMutiPicLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37592a = mutiImgMutiPicLayout;
        }

        @Override // b.a.q0.e1.j.d
        public void a(View view, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                d0<b.a.q0.s.q.a> subClickListener = this.f37592a.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    this.f37592a.j.objType = 2;
                    subClickListener.f16228a = Boolean.valueOf(z);
                    subClickListener.a(view, this.f37592a.j);
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().p) {
                    ThreadCardUtils.startImageViewer(view, this.f37592a.f37589h, this.f37592a.m, i2, this.f37592a.j.getThreadData(), this.f37592a.f37588g);
                } else if ("index".equals(this.f37592a.f37588g)) {
                    ThreadCardUtils.jumpToPB(this.f37592a.j, view.getContext(), 2, false);
                } else if ("frs".equals(this.f37592a.f37588g)) {
                    ThreadCardUtils.jumpToPB(this.f37592a.j, view.getContext(), 3, false);
                } else {
                    ThreadCardUtils.startImageViewer(view, this.f37592a.f37589h, this.f37592a.m, i2, this.f37592a.j.getThreadData(), this.f37592a.f37588g);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements TbImageView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MutiImgMutiPicLayout f37593a;

        public c(MutiImgMutiPicLayout mutiImgMutiPicLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mutiImgMutiPicLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37593a = mutiImgMutiPicLayout;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.h
        public void a(TbImageView tbImageView, Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, tbImageView, canvas) == null) {
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.h
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
            b.a.e.m.d.a m = b.a.q0.c0.c.k().m(b.a.e.f.l.d.h().g(tbImageView.getUrl(), this.f37593a.f37589h ? 13 : 14));
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
                if (this.f37593a.canCenterStart && i2 > i3) {
                    imageMatrix.postTranslate(f4, 0.0f);
                } else {
                    imageMatrix.postTranslate(f4, f3);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f37594e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f37595f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f37596g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ MutiImgMutiPicLayout f37597h;

        public d(MutiImgMutiPicLayout mutiImgMutiPicLayout, int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mutiImgMutiPicLayout, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37597h = mutiImgMutiPicLayout;
            a(i2, z, z2);
        }

        public void a(int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.f37594e = i2;
                this.f37595f = z;
                this.f37596g = z2;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || this.f37597h.l == null) {
                return;
            }
            this.f37597h.l.a(view, this.f37594e, this.f37595f && this.f37596g);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-724071695, "Lcom/baidu/card/view/MutiImgMutiPicLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-724071695, "Lcom/baidu/card/view/MutiImgMutiPicLayout;");
                return;
            }
        }
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds7);
        q = l.k(TbadkCoreApplication.getInst()) - ((l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MutiImgMutiPicLayout(Context context) {
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

    private void setImageData(d2 d2Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, d2Var) == null) {
            ArrayList<MediaData> E0 = d2Var.E0();
            if (k.c().g() && ListUtils.getCount(E0) != 0) {
                LinkedList<MediaData> linkedList = new LinkedList<>();
                for (int i2 = 0; i2 < E0.size(); i2++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(E0, i2);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                this.m = linkedList;
                b.a.q0.s.u.c.d(this.f37587f).n(R.string.J_X11);
                if (linkedList.size() > 3) {
                    this.f37586e.setText(TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(linkedList.size() - 3)}));
                    this.f37587f.setVisibility(0);
                    z = true;
                } else {
                    this.f37587f.setVisibility(8);
                    z = false;
                }
                this.moreImgContainer.setVisibility(8);
                if (ListUtils.getCount(linkedList) == 2) {
                    this.moreImgContainer.setVisibility(0);
                    boolean z2 = z;
                    j((MediaData) ListUtils.getItem(E0, 0), this.moreImgOne, z2, false, 0);
                    this.moreImgTwo.setVisibility(8);
                    j((MediaData) ListUtils.getItem(E0, 1), this.moreImgThree, z2, false, 1);
                    return;
                } else if (ListUtils.getCount(linkedList) >= 3) {
                    this.moreImgContainer.setVisibility(0);
                    this.moreImgTwo.setVisibility(0);
                    boolean z3 = z;
                    j((MediaData) ListUtils.getItem(E0, 0), this.moreImgOne, z3, false, 0);
                    j((MediaData) ListUtils.getItem(E0, 1), this.moreImgTwo, z3, false, 1);
                    j((MediaData) ListUtils.getItem(E0, 2), this.moreImgThree, z3, true, 2);
                    return;
                } else {
                    this.moreImgContainer.setVisibility(8);
                    return;
                }
            }
            this.moreImgContainer.setVisibility(8);
        }
    }

    private void setVoiceData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, d2Var) == null) {
            ArrayList<VoiceData$VoiceModel> E1 = d2Var.E1();
            if (ListUtils.isEmpty(E1)) {
                this.mVoiceBtn.setVisibility(8);
                return;
            }
            this.mVoiceBtn.setVisibility(0);
            VoiceData$VoiceModel voiceData$VoiceModel = E1.get(0);
            this.mVoiceBtn.setVoiceModel(voiceData$VoiceModel);
            this.mVoiceBtn.setTag(voiceData$VoiceModel);
            this.mVoiceBtn.changeSkin();
            if (voiceData$VoiceModel != null) {
                this.mVoiceBtn.refreshViewState(voiceData$VoiceModel.voice_status.intValue());
            }
            this.mVoiceBtn.resetLayoutParams();
        }
    }

    public final int f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (this.k > 0) {
                int k = l.k(getContext());
                if (k == this.n) {
                    return this.k;
                }
                this.n = k;
            }
            int size = (View.MeasureSpec.getSize(i2) - (2 * TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002))) / 3;
            this.k = size;
            return size;
        }
        return invokeI.intValue;
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

    public d0<b.a.q0.s.q.a> getSubClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37590i : (d0) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.multi_image_more_layout, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.mAbstract = (TextView) findViewById(R.id.thread_card_abstract);
            this.mTitle = (TextView) findViewById(R.id.thread_card_title);
            PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
            this.mVoiceBtn = playVoiceBntNew;
            playVoiceBntNew.setAfterClickListener(new a(this));
            int k = ((l.k(getContext()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X011) * 2)) - (l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002) * 2)) / 3;
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
            this.moreImgContainer = relativeLayout;
            relativeLayout.getLayoutParams().height = k;
            TbImageView tbImageView = (TbImageView) findViewById(R.id.thread_card_img_more_one);
            this.moreImgOne = tbImageView;
            tbImageView.setDrawCorner(true);
            this.moreImgOne.setRadiusById(R.string.J_X12);
            this.moreImgOne.setPlaceHolder(2);
            this.moreImgOne.setConrers(15);
            this.moreImgOne.getLayoutParams().height = k;
            this.moreImgOne.getLayoutParams().width = k;
            TbImageView tbImageView2 = (TbImageView) findViewById(R.id.thread_card_img_more_two);
            this.moreImgTwo = tbImageView2;
            tbImageView2.setDrawCorner(false);
            this.moreImgTwo.setPlaceHolder(2);
            this.moreImgTwo.setRadiusById(R.string.J_X02);
            this.moreImgTwo.setConrers(15);
            this.moreImgTwo.getLayoutParams().height = k;
            this.moreImgTwo.getLayoutParams().width = k;
            TbImageView tbImageView3 = (TbImageView) findViewById(R.id.thread_card_img_more_three);
            this.moreImgThree = tbImageView3;
            tbImageView3.setDrawCorner(true);
            this.moreImgThree.setPlaceHolder(2);
            this.moreImgThree.setRadiusById(R.string.J_X11);
            this.moreImgThree.setConrers(15);
            this.moreImgThree.getLayoutParams().height = k;
            this.moreImgThree.getLayoutParams().width = k;
            this.f37586e = (TextView) findViewById(R.id.thread_card_img_more_label);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.thread_card_img_more_shadow);
            this.f37587f = viewGroup;
            viewGroup.getLayoutParams().height = k;
            this.f37587f.getLayoutParams().width = k;
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.f37586e);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0607);
            this.f37586e.setTypeface(b.a.q0.s.u.a.H(b.a.q0.s.u.a.E(R.string.F_X02)));
            this.l = new b(this);
        }
    }

    public final void i(TbImageView tbImageView, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{tbImageView, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (this.l != null && tbImageView != null) {
                View.OnClickListener onClickListener = tbImageView.getOnClickListener();
                if (onClickListener instanceof d) {
                    ((d) onClickListener).a(i2, z, z2);
                } else {
                    tbImageView.setOnClickListener(new d(this, i2, z, z2));
                }
            } else if (this.l != null || tbImageView == null) {
            } else {
                tbImageView.setClickable(false);
            }
        }
    }

    public final void j(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{mediaData, tbImageView, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            String g2 = g(mediaData);
            int i3 = this.f37589h ? 13 : 14;
            if (!StringHelper.equals(g2, tbImageView.getUrl())) {
                tbImageView.reset();
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
            tbImageView.setOnDrawListener(this.p);
            tbImageView.setPlaceHolder(2);
            if (z2 && z) {
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setLongIconSupport(true);
                tbImageView.setGifIconSupport(true);
            }
            tbImageView.startLoad(g2, i3, false);
            i(tbImageView, i2, z, z2);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int f2 = f(i2);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.moreImgOne.getLayoutParams();
            layoutParams.width = f2;
            layoutParams.height = f2;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.moreImgTwo.getLayoutParams();
            layoutParams2.width = f2;
            layoutParams2.height = f2;
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.moreImgThree.getLayoutParams();
            layoutParams3.width = f2;
            layoutParams3.height = f2;
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f37587f.getLayoutParams();
            layoutParams4.width = f2;
            layoutParams4.height = f2;
            if (this.moreImgContainer.getVisibility() != 8) {
                this.moreImgOne.setLayoutParams(layoutParams);
                this.moreImgTwo.setLayoutParams(layoutParams2);
                this.moreImgThree.setLayoutParams(layoutParams3);
                this.f37587f.setLayoutParams(layoutParams4);
            }
        }
    }

    public void setCanCenterStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.canCenterStart = z;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f37588g = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f37589h = z;
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
            this.o = z;
        }
    }

    public void setPreloadSizeReadyCallback(b.a.e.m.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) {
        }
    }

    public void setSubClickListener(d0<b.a.q0.s.q.a> d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, d0Var) == null) {
            this.f37590i = d0Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutiImgMutiPicLayout(Context context, @Nullable AttributeSet attributeSet) {
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
        this.f37589h = true;
        this.j = null;
        this.k = 0;
        this.canCenterStart = false;
        this.n = 0;
        this.o = false;
        this.p = new c(this);
        h();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.l.p
    public void onBindDataToView(b.a.q0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.j = aVar;
            d2 threadData = aVar.getThreadData();
            ThreadCardUtils.setTitle(this.mTitle, threadData, this.o);
            ThreadCardUtils.setAbstract(this.mAbstract, this.mTitle, threadData, q, this.o);
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
