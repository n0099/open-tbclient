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
import com.repackage.b06;
import com.repackage.bh5;
import com.repackage.ey;
import com.repackage.fo4;
import com.repackage.hx;
import com.repackage.i55;
import com.repackage.kg;
import com.repackage.ks4;
import com.repackage.ms4;
import com.repackage.qi;
import com.repackage.rn4;
import com.repackage.xm;
import com.repackage.zm;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgTextPicLayout extends LinearLayout implements hx<fo4> {
    public static /* synthetic */ Interceptable $ic;
    public static final int u;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public PlayVoiceBntNew c;
    public RelativeLayout d;
    public TbImageView e;
    public TbImageView f;
    public TbImageView g;
    public TextView h;
    public TbImageView i;
    public String j;
    public boolean k;
    public b06<fo4> l;
    public fo4 m;
    public int n;
    public bh5 o;
    public LinkedList<MediaData> p;
    public boolean q;
    public int r;
    public boolean s;
    public TbImageView.h t;

    /* loaded from: classes.dex */
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
        public void onClick(View view2) {
            b06<fo4> subClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (subClickListener = this.a.getSubClickListener()) == null) {
                return;
            }
            view2.setTag("2");
            subClickListener.a(view2, this.a.m);
        }
    }

    /* loaded from: classes.dex */
    public class b implements bh5 {
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

        @Override // com.repackage.bh5
        public void a(View view2, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                b06<fo4> subClickListener = this.a.getSubClickListener();
                if (subClickListener != null) {
                    view2.setTag("1");
                    this.a.m.objType = 2;
                    subClickListener.a = Boolean.valueOf(z);
                    subClickListener.a(view2, this.a.m);
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().j) {
                    ThreadCardUtils.startImageViewer(view2, this.a.k, this.a.p, i, this.a.m.getThreadData(), this.a.j);
                } else if ("index".equals(this.a.j)) {
                    ThreadCardUtils.jumpToPB(this.a.m, view2.getContext(), 2, false);
                } else if ("frs".equals(this.a.j)) {
                    ThreadCardUtils.jumpToPB(this.a.m, view2.getContext(), 3, false);
                } else {
                    ThreadCardUtils.startImageViewer(view2, this.a.k, this.a.p, i, this.a.m.getThreadData(), this.a.j);
                }
            }
        }
    }

    /* loaded from: classes.dex */
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
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbImageView, canvas) == null) || tbImageView == null || tbImageView.getImageMatrix() == null) {
                return;
            }
            zm m = i55.k().m(kg.h().g(tbImageView.getUrl(), this.a.k ? 13 : 14));
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
            float f9 = 0.0f;
            if (tbImageView.z() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                float smartCropCenterPointWidthRatio = tbImageView.getSmartCropCenterPointWidthRatio();
                float smartCropCenterPointHeightRatio = tbImageView.getSmartCropCenterPointHeightRatio();
                if (i2 * height > width * i) {
                    f6 = height / i;
                    float f10 = i2;
                    float f11 = smartCropCenterPointWidthRatio * f10 * f6;
                    float f12 = width;
                    float f13 = 0.5f * f12;
                    if (f11 < f13) {
                        f8 = 0.0f;
                    } else {
                        float f14 = f10 * f6;
                        f8 = f14 - f11 < f13 ? f12 - f14 : f13 - f11;
                    }
                    f9 = f8;
                } else {
                    float f15 = width / i2;
                    float f16 = i;
                    float f17 = smartCropCenterPointHeightRatio * f16 * f15;
                    float f18 = height;
                    float f19 = 0.5f * f18;
                    if (f17 >= f19) {
                        float f20 = f16 * f15;
                        if (f20 - f17 < f19) {
                            f7 = f18 - f20;
                            f6 = f15;
                        } else {
                            float f21 = f19 - f17;
                            f6 = f15;
                            f7 = f21;
                        }
                        imageMatrix.setScale(f6, f6);
                        imageMatrix.postTranslate(f9, f7);
                    }
                    f6 = f15;
                }
                f7 = 0.0f;
                imageMatrix.setScale(f6, f6);
                imageMatrix.postTranslate(f9, f7);
            } else if (tbImageView.x() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                if (i2 * height > width * i) {
                    f4 = height;
                    f5 = i;
                } else {
                    f4 = width;
                    f5 = i2;
                }
                float f22 = f4 / f5;
                imageMatrix.setScale(f22, f22);
                imageMatrix.postTranslate(0.0f, 0.0f);
            } else if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                if (i2 * height > width * i) {
                    f = height / i;
                    f3 = (width - (i2 * f)) * 0.5f;
                    f2 = 0.0f;
                } else {
                    f = width / i2;
                    f2 = (height - (i * f)) * 0.5f;
                    f3 = 0.0f;
                }
                imageMatrix.setScale(f, f);
                if (this.a.q && i > i2) {
                    imageMatrix.postTranslate(f3, 0.0f);
                } else {
                    imageMatrix.postTranslate(f3, f2);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public boolean b;
        public boolean c;
        public final /* synthetic */ MultiImgTextPicLayout d;

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
            this.d = multiImgTextPicLayout;
            a(i, z, z2);
        }

        public void a(int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.a = i;
                this.b = z;
                this.c = z2;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) || this.d.o == null) {
                return;
            }
            this.d.o.a(view2, this.a, this.b && this.c);
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
        qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds7);
        u = qi.k(TbadkCoreApplication.getInst()) - ((qi.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + qi.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
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
            if (rn4.c().g() && ListUtils.getCount(medias) != 0) {
                LinkedList<MediaData> linkedList = new LinkedList<>();
                for (int i = 0; i < medias.size(); i++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(medias, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                this.p = linkedList;
                if (linkedList.size() == 1) {
                    this.h.setVisibility(8);
                    this.d.setVisibility(8);
                    this.i.setVisibility(0);
                    l((MediaData) ListUtils.getItem(medias, 0), this.i, false, false, 0);
                    return;
                }
                this.i.setVisibility(8);
                HomeGroupUbsUIHelper.handleImgMask(this.h, R.drawable.obfuscated_res_0x7f0811de);
                if (linkedList.size() > 3) {
                    this.h.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f043e, new Object[]{Integer.valueOf(linkedList.size() - 3)}));
                    this.h.setVisibility(0);
                    z = true;
                } else {
                    this.h.setVisibility(8);
                    z = false;
                }
                this.d.setVisibility(8);
                if (ListUtils.getCount(linkedList) == 2) {
                    this.d.setVisibility(0);
                    boolean z2 = z;
                    l((MediaData) ListUtils.getItem(medias, 0), this.e, z2, false, 0);
                    this.f.setVisibility(8);
                    l((MediaData) ListUtils.getItem(medias, 1), this.g, z2, false, 1);
                    return;
                } else if (ListUtils.getCount(linkedList) >= 3) {
                    this.d.setVisibility(0);
                    this.f.setVisibility(0);
                    boolean z3 = z;
                    l((MediaData) ListUtils.getItem(medias, 0), this.e, z3, false, 0);
                    l((MediaData) ListUtils.getItem(medias, 1), this.f, z3, false, 1);
                    l((MediaData) ListUtils.getItem(medias, 2), this.g, z3, true, 2);
                    return;
                } else {
                    this.d.setVisibility(8);
                    return;
                }
            }
            this.d.setVisibility(8);
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
            this.h.setVisibility(8);
            this.d.setVisibility(8);
            ArrayList<MediaData> medias = threadData.getMedias();
            if (rn4.c().g() && ListUtils.getCount(medias) != 0) {
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
                this.c.setVisibility(8);
                return;
            }
            this.c.setVisibility(0);
            VoiceData.VoiceModel voiceModel = voice.get(0);
            this.c.setVoiceModel(voiceModel);
            this.c.setTag(voiceModel);
            this.c.e();
            if (voiceModel != null) {
                this.c.m(voiceModel.voice_status.intValue());
            }
            this.c.o();
        }
    }

    public final int g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (this.n > 0) {
                int k = qi.k(getContext());
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

    public b06<fo4> getSubClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.l : (b06) invokeV.objValue;
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
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d05ae, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f09211d);
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f09212b);
            PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.obfuscated_res_0x7f09212c);
            this.c = playVoiceBntNew;
            playVoiceBntNew.setAfterClickListener(new a(this));
            int k = ((qi.k(getContext()) - (ey.k * 2)) - (qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f092122);
            this.d = relativeLayout;
            HomeGroupUbsUIHelper.handleContentInterval(relativeLayout, R.dimen.tbds26, R.dimen.tbds14);
            HomeGroupUbsUIHelper.handleTextLineSpacingExtra(this.a, R.dimen.tbds7, R.dimen.tbds10);
            HomeGroupUbsUIHelper.handleTextLineSpacingExtra(this.b, R.dimen.tbds7, R.dimen.tbds10);
            this.d.getLayoutParams().height = k;
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f092124);
            this.e = tbImageView;
            tbImageView.setDrawCorner(true);
            this.e.setRadiusById(R.string.J_X12);
            this.e.setPlaceHolder(2);
            this.e.setConrers(15);
            this.e.getLayoutParams().height = k;
            this.e.getLayoutParams().width = k;
            TbImageView tbImageView2 = (TbImageView) findViewById(R.id.obfuscated_res_0x7f092127);
            this.f = tbImageView2;
            tbImageView2.setDrawCorner(false);
            this.f.setPlaceHolder(2);
            this.f.setRadiusById(R.string.J_X02);
            this.f.setConrers(15);
            this.f.getLayoutParams().height = k;
            this.f.getLayoutParams().width = k;
            TbImageView tbImageView3 = (TbImageView) findViewById(R.id.obfuscated_res_0x7f092126);
            this.g = tbImageView3;
            tbImageView3.setDrawCorner(true);
            this.g.setPlaceHolder(2);
            this.g.setRadiusById(R.string.J_X11);
            this.g.setConrers(15);
            this.g.getLayoutParams().height = k;
            this.g.getLayoutParams().width = k;
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f092123);
            this.h = textView;
            textView.getLayoutParams().height = k;
            this.h.getLayoutParams().width = k;
            ms4.d(this.h).y(R.array.S_O_X001);
            this.h.setTypeface(ks4.H(ks4.E(R.string.F_X02)));
            TbImageView tbImageView4 = (TbImageView) findViewById(R.id.obfuscated_res_0x7f092128);
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
    @Override // com.repackage.hx
    /* renamed from: j */
    public void a(fo4 fo4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fo4Var) == null) {
            this.m = fo4Var;
            ThreadData threadData = fo4Var.getThreadData();
            ThreadCardUtils.setTitle(this.a, threadData, this.s);
            ThreadCardUtils.setAbstract(this.b, this.a, threadData, u, this.s);
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
            String h = h(mediaData);
            int i2 = this.k ? 13 : 14;
            if (!StringHelper.equals(h, tbImageView.getUrl())) {
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
            tbImageView.K(h, i2, false);
            k(tbImageView, i, z, z2);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
            super.onMeasure(i, i2);
            int g = g(i);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
            layoutParams.width = g;
            layoutParams.height = g;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
            layoutParams2.width = g;
            layoutParams2.height = g;
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.g.getLayoutParams();
            layoutParams3.width = g;
            layoutParams3.height = g;
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
            layoutParams4.width = g;
            layoutParams4.height = g;
            if (this.d.getVisibility() != 8) {
                this.e.setLayoutParams(layoutParams);
                this.f.setLayoutParams(layoutParams2);
                this.g.setLayoutParams(layoutParams3);
                this.h.setLayoutParams(layoutParams4);
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

    public void setMarginsTop(View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048588, this, view2, i) == null) && (view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            if (marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                view2.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void setNeedFrsTabName(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.s = z;
        }
    }

    public void setPreloadSizeReadyCallback(xm xmVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, xmVar) == null) {
        }
    }

    public void setSubClickListener(b06<fo4> b06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, b06Var) == null) {
            this.l = b06Var;
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
