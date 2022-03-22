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
import c.a.d.f.p.n;
import c.a.l.m0;
import c.a.l.p;
import c.a.o0.r.l;
import c.a.p0.h0.b0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
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
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MultiImgTextPicLayout extends LinearLayout implements p<c.a.o0.r.r.a> {
    public static /* synthetic */ Interceptable $ic;
    public static final int u;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f25095b;

    /* renamed from: c  reason: collision with root package name */
    public PlayVoiceBntNew f25096c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f25097d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f25098e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f25099f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f25100g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f25101h;
    public TbImageView i;
    public String j;
    public boolean k;
    public b0<c.a.o0.r.r.a> l;
    public c.a.o0.r.r.a m;
    public int n;
    public c.a.o0.e1.j.d o;
    public LinkedList<MediaData> p;
    public boolean q;
    public int r;
    public boolean s;
    public TbImageView.h t;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiImgTextPicLayout a;

        public a(MultiImgTextPicLayout multiImgTextPicLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImgTextPicLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = multiImgTextPicLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b0<c.a.o0.r.r.a> subClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (subClickListener = this.a.getSubClickListener()) == null) {
                return;
            }
            view.setTag("2");
            subClickListener.a(view, this.a.m);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.a.o0.e1.j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiImgTextPicLayout a;

        public b(MultiImgTextPicLayout multiImgTextPicLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImgTextPicLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = multiImgTextPicLayout;
        }

        @Override // c.a.o0.e1.j.d
        public void a(View view, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                b0<c.a.o0.r.r.a> subClickListener = this.a.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    this.a.m.objType = 2;
                    subClickListener.a = Boolean.valueOf(z);
                    subClickListener.a(view, this.a.m);
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().p) {
                    ThreadCardUtils.startImageViewer(view, this.a.k, this.a.p, i, this.a.m.getThreadData(), this.a.j);
                } else if ("index".equals(this.a.j)) {
                    ThreadCardUtils.jumpToPB(this.a.m, view.getContext(), 2, false);
                } else if ("frs".equals(this.a.j)) {
                    ThreadCardUtils.jumpToPB(this.a.m, view.getContext(), 3, false);
                } else {
                    ThreadCardUtils.startImageViewer(view, this.a.k, this.a.p, i, this.a.m.getThreadData(), this.a.j);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements TbImageView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiImgTextPicLayout a;

        public c(MultiImgTextPicLayout multiImgTextPicLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImgTextPicLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = multiImgTextPicLayout;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.h
        public void a(TbImageView tbImageView, Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, tbImageView, canvas) == null) {
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.h
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
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbImageView, canvas) == null) || tbImageView == null || tbImageView.getImageMatrix() == null) {
                return;
            }
            c.a.d.o.d.a m = c.a.o0.b0.c.k().m(c.a.d.f.l.d.h().g(tbImageView.getUrl(), this.a.k ? 13 : 14));
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
            if (tbImageView.z() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
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
            } else if (tbImageView.x() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
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
                if (this.a.q && i > i2) {
                    imageMatrix.postTranslate(f4, 0.0f);
                } else {
                    imageMatrix.postTranslate(f4, f3);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f25102b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f25103c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ MultiImgTextPicLayout f25104d;

        public d(MultiImgTextPicLayout multiImgTextPicLayout, int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImgTextPicLayout, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25104d = multiImgTextPicLayout;
            a(i, z, z2);
        }

        public void a(int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.a = i;
                this.f25102b = z;
                this.f25103c = z2;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || this.f25104d.o == null) {
                return;
            }
            this.f25104d.o.a(view, this.a, this.f25102b && this.f25103c);
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
        n.f(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        n.f(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        n.f(TbadkCoreApplication.getInst(), R.dimen.tbds7);
        u = n.k(TbadkCoreApplication.getInst()) - ((n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void setImageData(ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, threadData) == null) {
            ArrayList<MediaData> medias = threadData.getMedias();
            if (l.c().g() && ListUtils.getCount(medias) != 0) {
                LinkedList<MediaData> linkedList = new LinkedList<>();
                for (int i = 0; i < medias.size(); i++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(medias, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                this.p = linkedList;
                if (linkedList.size() == 1) {
                    this.f25101h.setVisibility(8);
                    this.f25097d.setVisibility(8);
                    this.i.setVisibility(0);
                    l((MediaData) ListUtils.getItem(medias, 0), this.i, false, false, 0);
                    return;
                }
                this.i.setVisibility(8);
                HomeGroupUbsUIHelper.handleImgMask(this.f25101h, R.drawable.obfuscated_res_0x7f0811d0);
                if (linkedList.size() > 3) {
                    this.f25101h.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0427, new Object[]{Integer.valueOf(linkedList.size() - 3)}));
                    this.f25101h.setVisibility(0);
                    z = true;
                } else {
                    this.f25101h.setVisibility(8);
                    z = false;
                }
                this.f25097d.setVisibility(8);
                if (ListUtils.getCount(linkedList) == 2) {
                    this.f25097d.setVisibility(0);
                    boolean z2 = z;
                    l((MediaData) ListUtils.getItem(medias, 0), this.f25098e, z2, false, 0);
                    this.f25099f.setVisibility(8);
                    l((MediaData) ListUtils.getItem(medias, 1), this.f25100g, z2, false, 1);
                    return;
                } else if (ListUtils.getCount(linkedList) >= 3) {
                    this.f25097d.setVisibility(0);
                    this.f25099f.setVisibility(0);
                    boolean z3 = z;
                    l((MediaData) ListUtils.getItem(medias, 0), this.f25098e, z3, false, 0);
                    l((MediaData) ListUtils.getItem(medias, 1), this.f25099f, z3, false, 1);
                    l((MediaData) ListUtils.getItem(medias, 2), this.f25100g, z3, true, 2);
                    return;
                } else {
                    this.f25097d.setVisibility(8);
                    return;
                }
            }
            this.f25097d.setVisibility(8);
        }
    }

    private void setImageTextData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, threadData) == null) {
        }
    }

    private void setSingleImgData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, threadData) == null) {
            this.f25101h.setVisibility(8);
            this.f25097d.setVisibility(8);
            ArrayList<MediaData> medias = threadData.getMedias();
            if (l.c().g() && ListUtils.getCount(medias) != 0) {
                LinkedList<MediaData> linkedList = new LinkedList<>();
                MediaData mediaData = null;
                int i = 0;
                while (true) {
                    if (i < medias.size()) {
                        mediaData = (MediaData) ListUtils.getItem(medias, i);
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
                this.p = linkedList;
                this.i.setVisibility(8);
                if (ListUtils.getCount(linkedList) == 1) {
                    this.i.setVisibility(0);
                    l(mediaData2, this.i, false, false, 0);
                    return;
                }
                this.i.setVisibility(8);
                return;
            }
            this.i.setVisibility(8);
        }
    }

    private void setVoiceData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, threadData) == null) {
            ArrayList<VoiceData.VoiceModel> voice = threadData.getVoice();
            if (ListUtils.isEmpty(voice)) {
                this.f25096c.setVisibility(8);
                return;
            }
            this.f25096c.setVisibility(0);
            VoiceData.VoiceModel voiceModel = voice.get(0);
            this.f25096c.setVoiceModel(voiceModel);
            this.f25096c.setTag(voiceModel);
            this.f25096c.d();
            if (voiceModel != null) {
                this.f25096c.m(voiceModel.voice_status.intValue());
            }
            this.f25096c.o();
        }
    }

    public final int g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (this.n > 0) {
                int k = n.k(getContext());
                if (k == this.r) {
                    return this.n;
                }
                this.r = k;
            }
            int size = (View.MeasureSpec.getSize(i) - (2 * TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10))) / 3;
            this.n = size;
            return size;
        }
        return invokeI.intValue;
    }

    public b0<c.a.o0.r.r.a> getSubClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.l : (b0) invokeV.objValue;
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
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d058c, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f25095b = (TextView) findViewById(R.id.obfuscated_res_0x7f091f8d);
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f091f9b);
            PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.obfuscated_res_0x7f091f9c);
            this.f25096c = playVoiceBntNew;
            playVoiceBntNew.setAfterClickListener(new a(this));
            int k = ((n.k(getContext()) - (m0.k * 2)) - (n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091f92);
            this.f25097d = relativeLayout;
            HomeGroupUbsUIHelper.handleContentInterval(relativeLayout, R.dimen.tbds26, R.dimen.tbds14);
            HomeGroupUbsUIHelper.handleTextLineSpacingExtra(this.a, R.dimen.tbds7, R.dimen.tbds10);
            HomeGroupUbsUIHelper.handleTextLineSpacingExtra(this.f25095b, R.dimen.tbds7, R.dimen.tbds10);
            this.f25097d.getLayoutParams().height = k;
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f091f94);
            this.f25098e = tbImageView;
            tbImageView.setDrawCorner(true);
            this.f25098e.setRadiusById(R.string.J_X12);
            this.f25098e.setPlaceHolder(2);
            this.f25098e.setConrers(15);
            this.f25098e.getLayoutParams().height = k;
            this.f25098e.getLayoutParams().width = k;
            TbImageView tbImageView2 = (TbImageView) findViewById(R.id.obfuscated_res_0x7f091f97);
            this.f25099f = tbImageView2;
            tbImageView2.setDrawCorner(false);
            this.f25099f.setPlaceHolder(2);
            this.f25099f.setRadiusById(R.string.J_X02);
            this.f25099f.setConrers(15);
            this.f25099f.getLayoutParams().height = k;
            this.f25099f.getLayoutParams().width = k;
            TbImageView tbImageView3 = (TbImageView) findViewById(R.id.obfuscated_res_0x7f091f96);
            this.f25100g = tbImageView3;
            tbImageView3.setDrawCorner(true);
            this.f25100g.setPlaceHolder(2);
            this.f25100g.setRadiusById(R.string.J_X11);
            this.f25100g.setConrers(15);
            this.f25100g.getLayoutParams().height = k;
            this.f25100g.getLayoutParams().width = k;
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091f93);
            this.f25101h = textView;
            textView.getLayoutParams().height = k;
            this.f25101h.getLayoutParams().width = k;
            c.a.o0.r.v.c.d(this.f25101h).y(R.array.S_O_X001);
            this.f25101h.setTypeface(c.a.o0.r.v.a.H(c.a.o0.r.v.a.E(R.string.F_X02)));
            TbImageView tbImageView4 = (TbImageView) findViewById(R.id.obfuscated_res_0x7f091f98);
            this.i = tbImageView4;
            tbImageView4.setRadiusById(R.string.J_X05);
            this.i.setConrers(15);
            this.i.setDrawCorner(true);
            this.i.setPlaceHolder(3);
            this.i.setLongIconSupport(true);
            this.i.setGifIconSupport(true);
            HomeGroupUbsUIHelper.handleContentInterval(this.i, R.dimen.tbds28, R.dimen.tbds14);
            this.o = new b(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: j */
    public void a(c.a.o0.r.r.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.m = aVar;
            ThreadData threadData = aVar.getThreadData();
            ThreadCardUtils.setTitle(this.a, threadData, this.s);
            ThreadCardUtils.setAbstract(this.f25095b, this.a, threadData, u, this.s);
            setImageData(threadData);
            setVoiceData(threadData);
        }
    }

    public final void k(TbImageView tbImageView, int i, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{tbImageView, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (this.o != null && tbImageView != null) {
                View.OnClickListener onClickListener = tbImageView.getOnClickListener();
                if (onClickListener instanceof d) {
                    ((d) onClickListener).a(i, z, z2);
                } else {
                    tbImageView.setOnClickListener(new d(this, i, z, z2));
                }
            } else if (this.o != null || tbImageView == null) {
            } else {
                tbImageView.setClickable(false);
            }
        }
    }

    public final void l(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{mediaData, tbImageView, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)}) == null) {
            String h2 = h(mediaData);
            int i2 = this.k ? 13 : 14;
            if (!StringHelper.equals(h2, tbImageView.getUrl())) {
                tbImageView.F();
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
            tbImageView.setOnDrawListener(this.t);
            tbImageView.setPlaceHolder(2);
            if (z2 && z) {
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setLongIconSupport(true);
                tbImageView.setGifIconSupport(true);
            }
            tbImageView.J(h2, i2, false);
            k(tbImageView, i, z, z2);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
            super.onMeasure(i, i2);
            int g2 = g(i);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f25098e.getLayoutParams();
            layoutParams.width = g2;
            layoutParams.height = g2;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f25099f.getLayoutParams();
            layoutParams2.width = g2;
            layoutParams2.height = g2;
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f25100g.getLayoutParams();
            layoutParams3.width = g2;
            layoutParams3.height = g2;
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f25101h.getLayoutParams();
            layoutParams4.width = g2;
            layoutParams4.height = g2;
            if (this.f25097d.getVisibility() != 8) {
                this.f25098e.setLayoutParams(layoutParams);
                this.f25099f.setLayoutParams(layoutParams2);
                this.f25100g.setLayoutParams(layoutParams3);
                this.f25101h.setLayoutParams(layoutParams4);
            }
        }
    }

    public void setCanCenterStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.q = z;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.j = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.k = z;
        }
    }

    public void setMarginsTop(View view, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048588, this, view, i) == null) && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void setNeedFrsTabName(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.s = z;
        }
    }

    public void setPreloadSizeReadyCallback(c.a.d.o.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) {
        }
    }

    public void setSubClickListener(b0<c.a.o0.r.r.a> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, b0Var) == null) {
            this.l = b0Var;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.k = true;
        this.m = null;
        this.n = 0;
        this.q = false;
        this.r = 0;
        this.s = false;
        this.t = new c(this);
        i();
    }
}
