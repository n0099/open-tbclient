package com.baidu.card.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.gn;
import com.baidu.tieba.in;
import com.baidu.tieba.l15;
import com.baidu.tieba.qo6;
import com.baidu.tieba.qy;
import com.baidu.tieba.r05;
import com.baidu.tieba.rg;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.v06;
import com.baidu.tieba.xi;
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
public class MutiImgSingleVerticalLayout extends LinearLayout implements qy<l15> {
    public static /* synthetic */ Interceptable $ic;
    public static final int o;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public PlayVoiceBntNew c;
    public TbImageView d;
    public String e;
    public boolean f;
    public qo6<l15> g;
    public l15 h;
    public v06 i;
    public LinkedList<MediaData> j;
    public boolean k;
    public boolean l;
    public Context m;
    public TbImageView.h n;

    public void setPreloadSizeReadyCallback(gn gnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, gnVar) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MutiImgSingleVerticalLayout a;

        public a(MutiImgSingleVerticalLayout mutiImgSingleVerticalLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mutiImgSingleVerticalLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mutiImgSingleVerticalLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            qo6<l15> subClickListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (subClickListener = this.a.getSubClickListener()) != null) {
                view2.setTag("2");
                subClickListener.a(view2, this.a.h);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements v06 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MutiImgSingleVerticalLayout a;

        public b(MutiImgSingleVerticalLayout mutiImgSingleVerticalLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mutiImgSingleVerticalLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mutiImgSingleVerticalLayout;
        }

        @Override // com.baidu.tieba.v06
        public void a(View view2, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                qo6<l15> subClickListener = this.a.getSubClickListener();
                if (subClickListener != null) {
                    view2.setTag("1");
                    this.a.h.objType = 2;
                    subClickListener.a = Boolean.FALSE;
                    subClickListener.a(view2, this.a.h);
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() != null && TbadkCoreApplication.getInst().getAdAdSense().j) {
                    if ("index".equals(this.a.e)) {
                        ThreadCardUtils.jumpToPB(this.a.h, view2.getContext(), 2, false);
                        return;
                    } else if ("frs".equals(this.a.e)) {
                        ThreadCardUtils.jumpToPB(this.a.h, view2.getContext(), 3, false);
                        return;
                    } else {
                        ThreadCardUtils.startImageViewer(view2, this.a.f, this.a.j, i, this.a.h.getThreadData(), this.a.e);
                        return;
                    }
                }
                ThreadCardUtils.startImageViewer(view2, this.a.f, this.a.j, i, this.a.h.getThreadData(), this.a.e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements TbImageView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MutiImgSingleVerticalLayout a;

        @Override // com.baidu.tbadk.widget.TbImageView.h
        public void a(TbImageView tbImageView, Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, tbImageView, canvas) == null) {
            }
        }

        public c(MutiImgSingleVerticalLayout mutiImgSingleVerticalLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mutiImgSingleVerticalLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mutiImgSingleVerticalLayout;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.h
        public void b(TbImageView tbImageView, Canvas canvas) {
            int i;
            int i2;
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbImageView, canvas) == null) && tbImageView != null && tbImageView.getImageMatrix() != null) {
                if (this.a.f) {
                    i = 13;
                } else {
                    i = 14;
                }
                in w = TbImageMemoryCache.u().w(rg.h().g(tbImageView.getUrl(), i));
                int i3 = 0;
                if (w != null) {
                    i3 = w.r();
                    i2 = w.m();
                } else {
                    i2 = 0;
                }
                if (i3 != 0 && i2 != 0) {
                    int width = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                    int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                    Matrix imageMatrix = tbImageView.getImageMatrix();
                    float f9 = 0.0f;
                    if (tbImageView.B() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                        float smartCropCenterPointWidthRatio = tbImageView.getSmartCropCenterPointWidthRatio();
                        float smartCropCenterPointHeightRatio = tbImageView.getSmartCropCenterPointHeightRatio();
                        if (i3 * height > width * i2) {
                            f6 = height / i2;
                            float f10 = i3;
                            float f11 = smartCropCenterPointWidthRatio * f10 * f6;
                            float f12 = width;
                            float f13 = 0.5f * f12;
                            if (f11 < f13) {
                                f8 = 0.0f;
                            } else {
                                float f14 = f10 * f6;
                                if (f14 - f11 < f13) {
                                    f8 = f12 - f14;
                                } else {
                                    f8 = f13 - f11;
                                }
                            }
                            f9 = f8;
                        } else {
                            float f15 = width / i3;
                            float f16 = i2;
                            float f17 = smartCropCenterPointHeightRatio * f16 * f15;
                            float f18 = height;
                            float f19 = 0.5f * f18;
                            if (f17 < f19) {
                                f6 = f15;
                            } else {
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
                        }
                        f7 = 0.0f;
                        imageMatrix.setScale(f6, f6);
                        imageMatrix.postTranslate(f9, f7);
                    } else if (tbImageView.z() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                        if (i3 * height > width * i2) {
                            f4 = height;
                            f5 = i2;
                        } else {
                            f4 = width;
                            f5 = i3;
                        }
                        float f22 = f4 / f5;
                        imageMatrix.setScale(f22, f22);
                        imageMatrix.postTranslate(0.0f, 0.0f);
                    } else if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                        if (i3 * height > width * i2) {
                            f = height / i2;
                            f3 = (width - (i3 * f)) * 0.5f;
                            f2 = 0.0f;
                        } else {
                            f = width / i3;
                            f2 = (height - (i2 * f)) * 0.5f;
                            f3 = 0.0f;
                        }
                        imageMatrix.setScale(f, f);
                        if (this.a.k && i2 > i3) {
                            imageMatrix.postTranslate(f3, 0.0f);
                        } else {
                            imageMatrix.postTranslate(f3, f2);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public boolean b;
        public boolean c;
        public final /* synthetic */ MutiImgSingleVerticalLayout d;

        public d(MutiImgSingleVerticalLayout mutiImgSingleVerticalLayout, int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mutiImgSingleVerticalLayout, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = mutiImgSingleVerticalLayout;
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
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) != null) || this.d.i == null) {
                return;
            }
            v06 v06Var = this.d.i;
            int i = this.a;
            if (this.b && this.c) {
                z = true;
            } else {
                z = false;
            }
            v06Var.a(view2, i, z);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1348820890, "Lcom/baidu/card/view/MutiImgSingleVerticalLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1348820890, "Lcom/baidu/card/view/MutiImgSingleVerticalLayout;");
                return;
            }
        }
        o = xi.l(TbadkCoreApplication.getInst()) - ((xi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + xi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MutiImgSingleVerticalLayout(Context context) {
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MutiImgSingleVerticalLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MutiImgSingleVerticalLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutiImgSingleVerticalLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.f = true;
        this.h = null;
        this.k = false;
        this.l = false;
        this.n = new c(this);
        g();
    }

    public void setCanCenterStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.k = z;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.e = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f = z;
        }
    }

    public void setNeedFrsTabName(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.l = z;
        }
    }

    public void setRealContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, context) == null) {
            this.m = context;
        }
    }

    public void setSubClickListener(qo6<l15> qo6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, qo6Var) == null) {
            this.g = qo6Var;
        }
    }

    private void setImageData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, threadData) == null) {
            ArrayList<MediaData> medias = threadData.getMedias();
            if (r05.c().g() && ListUtils.getCount(medias) != 0) {
                LinkedList<MediaData> linkedList = new LinkedList<>();
                for (int i = 0; i < medias.size(); i++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(medias, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                this.j = linkedList;
                this.d.setVisibility(8);
                if (ListUtils.getCount(linkedList) == 1) {
                    this.d.setVisibility(0);
                    j((MediaData) ListUtils.getItem(medias, 0), this.d, true, false, true, 0);
                    return;
                }
                this.d.setVisibility(8);
                return;
            }
            this.d.setVisibility(8);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qy
    /* renamed from: h */
    public void a(l15 l15Var) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, l15Var) == null) {
            this.h = l15Var;
            ThreadData threadData = l15Var.getThreadData();
            ThreadCardUtils.setTitle(this.a, threadData, this.l);
            ThreadCardUtils.setAbstract(this.b, this.a, threadData, o, this.l);
            TextView textView = this.a;
            boolean z3 = false;
            if (textView != null && textView.getVisibility() == 0) {
                z = false;
            } else {
                z = true;
            }
            TextView textView2 = this.b;
            if (textView2 != null && textView2.getVisibility() == 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            TbImageView tbImageView = this.d;
            if (z && z2) {
                z3 = true;
            }
            ThreadCardUtils.dealMainViewTopMargin(tbImageView, z3, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            setImageData(threadData);
            setVoiceData(threadData);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.multi_image_single_layout, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.b = (TextView) findViewById(R.id.thread_card_abstract);
            this.a = (TextView) findViewById(R.id.thread_card_title);
            PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
            this.c = playVoiceBntNew;
            playVoiceBntNew.setAfterClickListener(new a(this));
            TbImageView tbImageView = (TbImageView) findViewById(R.id.thread_card_img_singal);
            this.d = tbImageView;
            tbImageView.setRadiusById(R.string.J_X05);
            this.d.setConrers(15);
            this.d.setDrawCorner(true);
            this.d.setPlaceHolder(3);
            this.d.setLongIconSupport(true);
            this.d.setGifIconSupport(true);
            this.i = new b(this);
        }
    }

    public qo6<l15> getSubClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return (qo6) invokeV.objValue;
    }

    public final void i(TbImageView tbImageView, int i, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{tbImageView, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (this.i != null && tbImageView != null) {
                View.OnClickListener onClickListener = tbImageView.getOnClickListener();
                if (onClickListener instanceof d) {
                    ((d) onClickListener).a(i, z, z2);
                } else {
                    tbImageView.setOnClickListener(new d(this, i, z, z2));
                }
            } else if (this.i == null && tbImageView != null) {
                tbImageView.setClickable(false);
            }
        }
    }

    public final void j(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{mediaData, tbImageView, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i)}) == null) {
            String thumbnailsUrl = ThreadCardUtils.getThumbnailsUrl(mediaData);
            if (this.f) {
                i2 = 46;
            } else {
                i2 = 47;
            }
            mediaData.setLoadUrlType(i2);
            if (!StringHelper.equals(thumbnailsUrl, tbImageView.getUrl())) {
                tbImageView.H();
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
            tbImageView.setOnDrawListener(this.n);
            tbImageView.N(thumbnailsUrl, i2, false);
            i(tbImageView, i, z2, z3);
        }
    }

    public void setMarginsTop(View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048585, this, view2, i) == null) && (view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            if (marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                view2.setLayoutParams(marginLayoutParams);
            }
        }
    }
}
