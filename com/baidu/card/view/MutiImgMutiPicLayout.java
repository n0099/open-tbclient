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
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.a15;
import com.baidu.tieba.b85;
import com.baidu.tieba.d85;
import com.baidu.tieba.hn;
import com.baidu.tieba.jn;
import com.baidu.tieba.ry;
import com.baidu.tieba.sg;
import com.baidu.tieba.t15;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.up6;
import com.baidu.tieba.yi;
import com.baidu.tieba.z16;
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
public class MutiImgMutiPicLayout extends LinearLayout implements ry<t15> {
    public static /* synthetic */ Interceptable $ic;
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
    public up6<t15> l;
    public t15 m;
    public int n;
    public z16 o;
    public LinkedList<MediaData> p;
    public boolean q;
    public int r;
    public boolean s;
    public boolean t;
    public Context u;
    public TbImageView.h v;

    public void setPreloadSizeReadyCallback(hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, hnVar) == null) {
        }
    }

    /* loaded from: classes3.dex */
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
            up6<t15> subClickListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (subClickListener = this.a.getSubClickListener()) != null) {
                view2.setTag("2");
                subClickListener.a(view2, this.a.m);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements z16 {
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

        @Override // com.baidu.tieba.z16
        public void a(View view2, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                up6<t15> subClickListener = this.a.getSubClickListener();
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
                ThreadCardUtils.startImageViewer(view2, this.a.k, this.a.p, i, this.a.m.getThreadData(), this.a.j);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements TbImageView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MutiImgMutiPicLayout a;

        @Override // com.baidu.tbadk.widget.TbImageView.h
        public void a(TbImageView tbImageView, Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, tbImageView, canvas) == null) {
            }
        }

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
                if (this.a.k) {
                    i = 13;
                } else {
                    i = 14;
                }
                jn A = TbImageMemoryCache.v().A(sg.h().g(tbImageView.getUrl(), i));
                int i3 = 0;
                if (A != null) {
                    i3 = A.r();
                    i2 = A.m();
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
                        if (this.a.q && i2 > i3) {
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
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) != null) || this.d.o == null) {
                return;
            }
            z16 z16Var = this.d.o;
            int i = this.a;
            if (this.b && this.c) {
                z = true;
            } else {
                z = false;
            }
            z16Var.a(view2, i, z);
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
        yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    }

    private int getTextViewWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            return yi.l(TbadkCoreApplication.getInst()) - ((yi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + yi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
        }
        return invokeV.intValue;
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

    public final int g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (this.n > 0) {
                int l = yi.l(getContext());
                if (l == this.r) {
                    return this.n;
                }
                this.r = l;
            }
            int size = (View.MeasureSpec.getSize(i) - (2 * TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002))) / 3;
            this.n = size;
            return size;
        }
        return invokeI.intValue;
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
        this.t = true;
        this.v = new c(this);
        h();
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
            this.j = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.k = z;
        }
    }

    public void setNeedFrsTabName(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.s = z;
        }
    }

    public void setRealContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, context) == null) {
            this.u = context;
        }
    }

    public void setSubClickListener(up6<t15> up6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, up6Var) == null) {
            this.l = up6Var;
        }
    }

    public void setSupportClickImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.t = z;
        }
    }

    private void setImageData(ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, threadData) == null) {
            ArrayList<MediaData> medias = threadData.getMedias();
            if (a15.c().g() && ListUtils.getCount(medias) != 0) {
                LinkedList<MediaData> linkedList = new LinkedList<>();
                for (int i = 0; i < medias.size(); i++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(medias, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                this.p = linkedList;
                d85.d(this.i).o(R.string.J_X11);
                if (linkedList.size() > 3) {
                    this.h.setText(TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(linkedList.size() - 3)}));
                    this.i.setVisibility(0);
                    z = true;
                } else {
                    this.i.setVisibility(8);
                    z = false;
                }
                this.d.setVisibility(8);
                if (ListUtils.getCount(linkedList) == 1) {
                    this.d.setVisibility(0);
                    this.e.setRadiusById(R.string.J_X05);
                    this.e.setVisibility(0);
                    this.f.setVisibility(8);
                    this.g.setVisibility(8);
                    k((MediaData) ListUtils.getItem(medias, 0), this.e, z, false, 0);
                    return;
                } else if (ListUtils.getCount(linkedList) == 2) {
                    this.d.setVisibility(0);
                    this.e.setRadiusById(R.string.J_X12);
                    this.e.setVisibility(0);
                    this.f.setVisibility(8);
                    this.g.setVisibility(0);
                    boolean z2 = z;
                    k((MediaData) ListUtils.getItem(medias, 0), this.e, z2, false, 0);
                    k((MediaData) ListUtils.getItem(medias, 1), this.g, z2, false, 1);
                    return;
                } else if (ListUtils.getCount(linkedList) >= 3) {
                    this.d.setVisibility(0);
                    this.e.setRadiusById(R.string.J_X12);
                    this.e.setVisibility(0);
                    this.f.setVisibility(0);
                    this.g.setVisibility(0);
                    boolean z3 = z;
                    k((MediaData) ListUtils.getItem(medias, 0), this.e, z3, false, 0);
                    k((MediaData) ListUtils.getItem(medias, 1), this.f, z3, false, 1);
                    k((MediaData) ListUtils.getItem(medias, 2), this.g, z3, true, 2);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ry
    /* renamed from: i */
    public void b(t15 t15Var) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, t15Var) == null) {
            this.m = t15Var;
            ThreadData threadData = t15Var.getThreadData();
            ThreadCardUtils.setTitle(this.a, threadData, this.s);
            ThreadCardUtils.setAbstract(this.b, this.a, threadData, getTextViewWidth(), this.s);
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
            RelativeLayout relativeLayout = this.d;
            if (z && z2) {
                z3 = true;
            }
            ThreadCardUtils.dealMainViewTopMargin(relativeLayout, z3, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            setImageData(threadData);
            setVoiceData(threadData);
        }
    }

    public up6<t15> getSubClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.l;
        }
        return (up6) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.multi_image_more_layout, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.b = (TextView) findViewById(R.id.thread_card_abstract);
            this.a = (TextView) findViewById(R.id.thread_card_title);
            PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
            this.c = playVoiceBntNew;
            playVoiceBntNew.setAfterClickListener(new a(this));
            int l = ((yi.l(getContext()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X011) * 2)) - (yi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002) * 2)) / 3;
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
            this.d = relativeLayout;
            relativeLayout.getLayoutParams().height = l;
            TbImageView tbImageView = (TbImageView) findViewById(R.id.thread_card_img_more_one);
            this.e = tbImageView;
            tbImageView.setDrawCorner(true);
            this.e.setRadiusById(R.string.J_X12);
            this.e.setPlaceHolder(2);
            this.e.setConrers(15);
            this.e.getLayoutParams().height = l;
            this.e.getLayoutParams().width = l;
            TbImageView tbImageView2 = (TbImageView) findViewById(R.id.thread_card_img_more_two);
            this.f = tbImageView2;
            tbImageView2.setDrawCorner(false);
            this.f.setPlaceHolder(2);
            this.f.setRadiusById(R.string.J_X02);
            this.f.setConrers(15);
            this.f.getLayoutParams().height = l;
            this.f.getLayoutParams().width = l;
            TbImageView tbImageView3 = (TbImageView) findViewById(R.id.thread_card_img_more_three);
            this.g = tbImageView3;
            tbImageView3.setDrawCorner(true);
            this.g.setPlaceHolder(2);
            this.g.setRadiusById(R.string.J_X11);
            this.g.setConrers(15);
            this.g.getLayoutParams().height = l;
            this.g.getLayoutParams().width = l;
            this.h = (TextView) findViewById(R.id.thread_card_img_more_label);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.thread_card_img_more_shadow);
            this.i = viewGroup;
            viewGroup.getLayoutParams().height = l;
            this.i.getLayoutParams().width = l;
            d85 d2 = d85.d(this.h);
            d2.o(R.string.J_X01);
            d2.f(R.color.CAM_X0607);
            this.h.setTypeface(b85.K(b85.H(R.string.F_X02)));
            this.o = new b(this);
        }
    }

    public final void j(TbImageView tbImageView, int i, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{tbImageView, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (!this.t) {
                tbImageView.setClickable(false);
            } else if (this.o != null && tbImageView != null) {
                View.OnClickListener onClickListener = tbImageView.getOnClickListener();
                if (onClickListener instanceof d) {
                    ((d) onClickListener).a(i, z, z2);
                } else {
                    tbImageView.setOnClickListener(new d(this, i, z, z2));
                }
            } else if (this.o == null && tbImageView != null) {
                tbImageView.setClickable(false);
            }
        }
    }

    public final void k(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{mediaData, tbImageView, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)}) == null) {
            String thumbnailsUrl = ThreadCardUtils.getThumbnailsUrl(mediaData);
            if (this.k) {
                i2 = 13;
            } else {
                i2 = 14;
            }
            if (!StringHelper.equals(thumbnailsUrl, tbImageView.getUrl())) {
                tbImageView.H();
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
            tbImageView.setOnDrawListener(this.v);
            tbImageView.setPlaceHolder(2);
            if (z2 && z) {
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setLongIconSupport(true);
                tbImageView.setGifIconSupport(true);
            }
            tbImageView.N(thumbnailsUrl, i2, false);
            j(tbImageView, i, z, z2);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i, i2) == null) {
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
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
            layoutParams4.width = g;
            layoutParams4.height = g;
            if (this.d.getVisibility() != 8) {
                this.e.setLayoutParams(layoutParams);
                this.f.setLayoutParams(layoutParams2);
                this.g.setLayoutParams(layoutParams3);
                this.i.setLayoutParams(layoutParams4);
                this.d.getLayoutParams().height = g;
            }
        }
    }

    public void setMarginsTop(View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048587, this, view2, i) == null) && (view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            if (marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                view2.setLayoutParams(marginLayoutParams);
            }
        }
    }
}
