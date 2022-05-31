package com.baidu.card.view;

import android.app.Activity;
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
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
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
import com.repackage.am4;
import com.repackage.bx;
import com.repackage.ce5;
import com.repackage.fg;
import com.repackage.li;
import com.repackage.nw5;
import com.repackage.om4;
import com.repackage.sm;
import com.repackage.tc5;
import com.repackage.u25;
import com.repackage.um;
import com.repackage.uq4;
import com.repackage.wq4;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MutiImgMutiPicLayout extends LinearLayout implements bx<om4> {
    public static /* synthetic */ Interceptable $ic;
    public static final int v;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public PlayVoiceBntNew c;
    public RelativeLayout d;
    public TbImageView e;
    public TbImageView f;
    public TbImageView g;
    public TextView h;
    public ViewGroup i;
    public String j;
    public boolean k;
    public nw5<om4> l;
    public om4 m;
    public int n;
    public ce5 o;
    public LinkedList<MediaData> p;
    public boolean q;
    public int r;
    public boolean s;
    public Context t;
    public TbImageView.h u;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MutiImgMutiPicLayout a;

        public a(MutiImgMutiPicLayout mutiImgMutiPicLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mutiImgMutiPicLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mutiImgMutiPicLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            nw5<om4> subClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (subClickListener = this.a.getSubClickListener()) == null) {
                return;
            }
            view2.setTag("2");
            subClickListener.a(view2, this.a.m);
        }
    }

    /* loaded from: classes.dex */
    public class b implements ce5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MutiImgMutiPicLayout a;

        public b(MutiImgMutiPicLayout mutiImgMutiPicLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mutiImgMutiPicLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mutiImgMutiPicLayout;
        }

        @Override // com.repackage.ce5
        public void a(View view2, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                nw5<om4> subClickListener = this.a.getSubClickListener();
                if (subClickListener != null) {
                    view2.setTag("1");
                    this.a.m.objType = 2;
                    subClickListener.a = Boolean.valueOf(z);
                    subClickListener.a(view2, this.a.m);
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() != null && TbadkCoreApplication.getInst().getAdAdSense().j) {
                    if ("index".equals(this.a.j)) {
                        ThreadCardUtils.jumpToPB(this.a.m, view2.getContext(), 2, false);
                        return;
                    } else if ("frs".equals(this.a.j)) {
                        ThreadCardUtils.jumpToPB(this.a.m, view2.getContext(), 3, false);
                        return;
                    } else {
                        ThreadCardUtils.startImageViewer(view2, this.a.k, this.a.p, i, this.a.m.getThreadData(), this.a.j);
                        return;
                    }
                }
                if (tc5.c()) {
                    if (tc5.b(view2.getContext() instanceof Activity ? view2.getContext() : this.a.t, this.a.j, this.a.m)) {
                        return;
                    }
                }
                ThreadCardUtils.startImageViewer(view2, this.a.k, this.a.p, i, this.a.m.getThreadData(), this.a.j);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements TbImageView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MutiImgMutiPicLayout a;

        public c(MutiImgMutiPicLayout mutiImgMutiPicLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mutiImgMutiPicLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mutiImgMutiPicLayout;
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
            um m = u25.k().m(fg.h().g(tbImageView.getUrl(), this.a.k ? 13 : 14));
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
            if (tbImageView.A() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
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
            } else if (tbImageView.y() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
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
        public final /* synthetic */ MutiImgMutiPicLayout d;

        public d(MutiImgMutiPicLayout mutiImgMutiPicLayout, int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mutiImgMutiPicLayout, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = mutiImgMutiPicLayout;
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
        li.f(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        li.f(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        li.f(TbadkCoreApplication.getInst(), R.dimen.tbds7);
        v = li.k(TbadkCoreApplication.getInst()) - ((li.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + li.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
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
        if (interceptable == null || interceptable.invokeL(65545, this, threadData) == null) {
            ArrayList<MediaData> medias = threadData.getMedias();
            if (am4.c().g() && ListUtils.getCount(medias) != 0) {
                LinkedList<MediaData> linkedList = new LinkedList<>();
                for (int i = 0; i < medias.size(); i++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(medias, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                this.p = linkedList;
                wq4.d(this.i).n(R.string.J_X11);
                if (linkedList.size() > 3) {
                    this.h.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f043b, new Object[]{Integer.valueOf(linkedList.size() - 3)}));
                    this.i.setVisibility(0);
                    z = true;
                } else {
                    this.i.setVisibility(8);
                    z = false;
                }
                this.d.setVisibility(8);
                if (ListUtils.getCount(linkedList) == 2) {
                    this.d.setVisibility(0);
                    boolean z2 = z;
                    m((MediaData) ListUtils.getItem(medias, 0), this.e, z2, false, 0);
                    this.f.setVisibility(8);
                    m((MediaData) ListUtils.getItem(medias, 1), this.g, z2, false, 1);
                    return;
                } else if (ListUtils.getCount(linkedList) >= 3) {
                    this.d.setVisibility(0);
                    this.f.setVisibility(0);
                    boolean z3 = z;
                    m((MediaData) ListUtils.getItem(medias, 0), this.e, z3, false, 0);
                    m((MediaData) ListUtils.getItem(medias, 1), this.f, z3, false, 1);
                    m((MediaData) ListUtils.getItem(medias, 2), this.g, z3, true, 2);
                    return;
                } else {
                    this.d.setVisibility(8);
                    return;
                }
            }
            this.d.setVisibility(8);
        }
    }

    private void setVoiceData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, threadData) == null) {
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

    public nw5<om4> getSubClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : (nw5) invokeV.objValue;
    }

    public final int h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (this.n > 0) {
                int k = li.k(getContext());
                if (k == this.r) {
                    return this.n;
                }
                this.r = k;
            }
            int size = (View.MeasureSpec.getSize(i) - (2 * TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002))) / 3;
            this.n = size;
            return size;
        }
        return invokeI.intValue;
    }

    public final String i(MediaData mediaData) {
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

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0573, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f091f78);
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f091f86);
            PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.obfuscated_res_0x7f091f87);
            this.c = playVoiceBntNew;
            playVoiceBntNew.setAfterClickListener(new a(this));
            int k = ((li.k(getContext()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X011) * 2)) - (li.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X002) * 2)) / 3;
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091f7d);
            this.d = relativeLayout;
            relativeLayout.getLayoutParams().height = k;
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f091f7f);
            this.e = tbImageView;
            tbImageView.setDrawCorner(true);
            this.e.setRadiusById(R.string.J_X12);
            this.e.setPlaceHolder(2);
            this.e.setConrers(15);
            this.e.getLayoutParams().height = k;
            this.e.getLayoutParams().width = k;
            TbImageView tbImageView2 = (TbImageView) findViewById(R.id.obfuscated_res_0x7f091f82);
            this.f = tbImageView2;
            tbImageView2.setDrawCorner(false);
            this.f.setPlaceHolder(2);
            this.f.setRadiusById(R.string.J_X02);
            this.f.setConrers(15);
            this.f.getLayoutParams().height = k;
            this.f.getLayoutParams().width = k;
            TbImageView tbImageView3 = (TbImageView) findViewById(R.id.obfuscated_res_0x7f091f81);
            this.g = tbImageView3;
            tbImageView3.setDrawCorner(true);
            this.g.setPlaceHolder(2);
            this.g.setRadiusById(R.string.J_X11);
            this.g.setConrers(15);
            this.g.getLayoutParams().height = k;
            this.g.getLayoutParams().width = k;
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f091f7e);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091f80);
            this.i = viewGroup;
            viewGroup.getLayoutParams().height = k;
            this.i.getLayoutParams().width = k;
            wq4 d2 = wq4.d(this.h);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0607);
            this.h.setTypeface(uq4.H(uq4.E(R.string.F_X02)));
            this.o = new b(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bx
    /* renamed from: k */
    public void a(om4 om4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, om4Var) == null) {
            this.m = om4Var;
            ThreadData threadData = om4Var.getThreadData();
            ThreadCardUtils.setTitle(this.a, threadData, this.s);
            ThreadCardUtils.setAbstract(this.b, this.a, threadData, v, this.s);
            TextView textView = this.a;
            boolean z = false;
            boolean z2 = textView == null || textView.getVisibility() != 0;
            TextView textView2 = this.b;
            boolean z3 = textView2 == null || textView2.getVisibility() != 0;
            RelativeLayout relativeLayout = this.d;
            if (z2 && z3) {
                z = true;
            }
            ThreadCardUtils.dealMainViewTopMargin(relativeLayout, z, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            setImageData(threadData);
            setVoiceData(threadData);
        }
    }

    public final void l(TbImageView tbImageView, int i, boolean z, boolean z2) {
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

    public final void m(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{mediaData, tbImageView, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)}) == null) {
            String i2 = i(mediaData);
            int i3 = this.k ? 13 : 14;
            if (!StringHelper.equals(i2, tbImageView.getUrl())) {
                tbImageView.G();
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
            tbImageView.setOnDrawListener(this.u);
            tbImageView.setPlaceHolder(2);
            if (z2 && z) {
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setLongIconSupport(true);
                tbImageView.setGifIconSupport(true);
            }
            tbImageView.K(i2, i3, false);
            l(tbImageView, i, z, z2);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
            super.onMeasure(i, i2);
            int h = h(i);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
            layoutParams.width = h;
            layoutParams.height = h;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
            layoutParams2.width = h;
            layoutParams2.height = h;
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.g.getLayoutParams();
            layoutParams3.width = h;
            layoutParams3.height = h;
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
            layoutParams4.width = h;
            layoutParams4.height = h;
            if (this.d.getVisibility() != 8) {
                this.e.setLayoutParams(layoutParams);
                this.f.setLayoutParams(layoutParams2);
                this.g.setLayoutParams(layoutParams3);
                this.i.setLayoutParams(layoutParams4);
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

    public void setPreloadSizeReadyCallback(sm smVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, smVar) == null) {
        }
    }

    public void setRealContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, context) == null) {
            this.t = context;
        }
    }

    public void setSubClickListener(nw5<om4> nw5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, nw5Var) == null) {
            this.l = nw5Var;
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
        this.u = new c(this);
        j();
    }
}
