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
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tbadk.widget.CardLiveLabelView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.ad.AbsDownloadGuide;
import com.baidu.tieba.R;
import com.baidu.tieba.fw4;
import com.baidu.tieba.it;
import com.baidu.tieba.mm6;
import com.baidu.tieba.mx5;
import com.baidu.tieba.oxa;
import com.baidu.tieba.qv4;
import com.baidu.tieba.rd;
import com.baidu.tieba.s36;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.tieba.zh;
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
public class MutiImgSingleVerticalLayout extends LinearLayout implements it<fw4> {
    public static /* synthetic */ Interceptable $ic;
    public static final int v;
    public transient /* synthetic */ FieldHolder $fh;
    public RoundRelativeLayout a;
    public AbsDownloadGuide b;
    public RelativeLayout c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public PlayVoiceBntNew h;
    public TbImageView i;
    public CardLiveLabelView j;
    public String k;
    public boolean l;
    public mm6<fw4> m;
    public fw4 n;
    public mx5 o;
    public LinkedList<MediaData> p;
    public boolean q;
    public boolean r;
    public d s;
    public Context t;
    public TbImageView.h u;

    /* loaded from: classes3.dex */
    public interface d {
        void a(int i, ThreadData threadData, MediaData mediaData);
    }

    public void setPreloadSizeReadyCallback(zh zhVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, zhVar) == null) {
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
            mm6<fw4> subClickListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (subClickListener = this.a.getSubClickListener()) != null) {
                view2.setTag("2");
                subClickListener.a(view2, this.a.n);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements mx5 {
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

        @Override // com.baidu.tieba.mx5
        public void a(View view2, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                mm6<fw4> subClickListener = this.a.getSubClickListener();
                if (subClickListener != null) {
                    view2.setTag("1");
                    this.a.n.objType = 2;
                    subClickListener.a = Boolean.FALSE;
                    subClickListener.a(view2, this.a.n);
                }
                if (this.a.n == null || !s36.a(this.a.getContext(), this.a.n.getThreadData())) {
                    if (TbadkCoreApplication.getInst().getAdAdSense() != null && TbadkCoreApplication.getInst().getAdAdSense().j) {
                        if ("index".equals(this.a.k)) {
                            ThreadCardUtils.jumpToPB(this.a.n, view2.getContext(), 2, false);
                        } else if ("frs".equals(this.a.k)) {
                            ThreadCardUtils.jumpToPB(this.a.n, view2.getContext(), 3, false);
                        } else {
                            ThreadCardUtils.startImageViewer(view2, this.a.l, this.a.p, i, this.a.n.getThreadData(), this.a.k);
                        }
                    } else if (ListUtils.getItem(this.a.p, i) != null && !rd.isEmpty(((MediaData) ListUtils.getItem(this.a.p, i)).getJumpUrl())) {
                        UrlManager.getInstance().dealOneLink(((MediaData) ListUtils.getItem(this.a.p, i)).getJumpUrl());
                    } else {
                        ThreadCardUtils.startImageViewer(view2, this.a.l, this.a.p, i, this.a.n.getThreadData(), this.a.k);
                    }
                }
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
                if (this.a.l) {
                    i = 13;
                } else {
                    i = 14;
                }
                BdImage D = TbImageMemoryCache.w().D(BdResourceLoader.getInstance().genCacheKey(tbImageView.getUrl(), i));
                int i3 = 0;
                if (D != null) {
                    i3 = D.getWidth();
                    i2 = D.getHeight();
                } else {
                    i2 = 0;
                }
                if (i3 != 0 && i2 != 0) {
                    int width = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                    int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                    Matrix imageMatrix = tbImageView.getImageMatrix();
                    float f9 = 0.0f;
                    if (tbImageView.isSmartCrop() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
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
                    } else if (tbImageView.isLongPic() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
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
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public boolean b;
        public boolean c;
        public final /* synthetic */ MutiImgSingleVerticalLayout d;

        public e(MutiImgSingleVerticalLayout mutiImgSingleVerticalLayout, int i, boolean z, boolean z2) {
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
            int i;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                if (this.d.o != null) {
                    mx5 mx5Var = this.d.o;
                    int i2 = this.a;
                    if (this.b && this.c) {
                        z = true;
                    } else {
                        z = false;
                    }
                    mx5Var.a(view2, i2, z);
                }
                if (this.d.s != null && this.d.n != null && this.d.n.getThreadData() != null && !this.d.p.isEmpty() && (i = this.a) >= 0 && i < this.d.p.size()) {
                    this.d.s.a(this.a, this.d.n.getThreadData(), (MediaData) this.d.p.get(this.a));
                }
            }
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
        v = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
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

    public final void g(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) && threadData != null && this.i != null && this.a != null) {
            AbsDownloadGuide c2 = oxa.c(getContext(), threadData, this.a, this.b);
            this.b = c2;
            if (c2 == null) {
                this.i.setConrers(15);
            } else {
                this.i.setConrers(3);
            }
        }
    }

    public final void n(MediaData mediaData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mediaData) == null) && mediaData != null && this.j != null) {
            if (mediaData.getLottieType() != 0 && !rd.isEmpty(mediaData.getGuideText())) {
                this.j.setVisibility(0);
                this.j.h(mediaData.getGuideText());
                this.j.f();
                return;
            }
            this.j.setVisibility(8);
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
        this.l = true;
        this.n = null;
        this.q = false;
        this.r = false;
        this.u = new c(this);
        h();
    }

    private void setAdLabelInfo(ThreadData threadData) {
        TextView textView;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, this, threadData) == null) && (textView = this.e) != null && threadData != null) {
            EMManager.from(textView).setTextColor(R.color.CAM_X0619);
            TextView textView2 = this.e;
            if (threadData.getShowAdSubscript()) {
                i = 0;
            } else {
                i = 8;
            }
            textView2.setVisibility(i);
        }
    }

    private void setPolicyInfo(ThreadData threadData) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65549, this, threadData) == null) && (textView = this.d) != null && threadData != null) {
            oxa.a(textView, getContext(), threadData);
        }
    }

    public void setBusinessOnClickCallBack(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
            this.s = dVar;
        }
    }

    public void setCanCenterStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.q = z;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.k = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.l = z;
        }
    }

    public void setNeedFrsTabName(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.r = z;
        }
    }

    public void setRealContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, context) == null) {
            this.t = context;
        }
    }

    public void setSubClickListener(mm6<fw4> mm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, mm6Var) == null) {
            this.m = mm6Var;
        }
    }

    private void setImageData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, threadData) == null) {
            ArrayList<MediaData> medias = threadData.getMedias();
            if (qv4.c().g() && ListUtils.getCount(medias) != 0) {
                LinkedList<MediaData> linkedList = new LinkedList<>();
                for (int i = 0; i < medias.size(); i++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(medias, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                this.p = linkedList;
                this.i.setVisibility(8);
                if (ListUtils.getCount(linkedList) == 1) {
                    this.i.setVisibility(0);
                    m((MediaData) ListUtils.getItem(medias, 0), this.i, true, false, true, 0);
                    n((MediaData) ListUtils.getItem(medias, 0));
                    return;
                }
                this.i.setVisibility(8);
                return;
            }
            this.i.setVisibility(8);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.it
    /* renamed from: i */
    public void onBindDataToView(fw4 fw4Var) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fw4Var) == null) {
            this.n = fw4Var;
            ThreadData threadData = fw4Var.getThreadData();
            ThreadCardUtils.setTitle(this.f, threadData, this.r);
            ThreadCardUtils.setAbstract(this.g, this.f, threadData, v, this.r);
            TextView textView = this.f;
            boolean z3 = false;
            if (textView != null && textView.getVisibility() == 0) {
                z = false;
            } else {
                z = true;
            }
            TextView textView2 = this.g;
            if (textView2 != null && textView2.getVisibility() == 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            TbImageView tbImageView = this.i;
            if (z && z2) {
                z3 = true;
            }
            ThreadCardUtils.dealMainViewTopMargin(tbImageView, z3, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            setImageData(threadData);
            setVoiceData(threadData);
            setAdLabelInfo(threadData);
            setPolicyInfo(threadData);
            g(threadData);
        }
    }

    private void setVoiceData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, threadData) == null) {
            ArrayList<VoiceData.VoiceModel> voice = threadData.getVoice();
            if (ListUtils.isEmpty(voice)) {
                this.h.setVisibility(8);
                return;
            }
            this.h.setVisibility(0);
            VoiceData.VoiceModel voiceModel = voice.get(0);
            this.h.setVoiceModel(voiceModel);
            this.h.setTag(voiceModel);
            this.h.b();
            if (voiceModel != null) {
                this.h.j(voiceModel.voice_status.intValue());
            }
            this.h.l();
        }
    }

    public mm6<fw4> getSubClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.m;
        }
        return (mm6) invokeV.objValue;
    }

    public void j() {
        AbsDownloadGuide absDownloadGuide;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (absDownloadGuide = this.b) != null) {
            absDownloadGuide.r();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.multi_image_single_layout, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.c = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09231b);
            this.g = (TextView) findViewById(R.id.thread_card_abstract);
            this.f = (TextView) findViewById(R.id.thread_card_title);
            this.h = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
            this.j = (CardLiveLabelView) findViewById(R.id.left_label_view);
            this.d = (TextView) findViewById(R.id.policy_info);
            this.e = (TextView) findViewById(R.id.ad_label);
            this.a = (RoundRelativeLayout) findViewById(R.id.download_guide_layout);
            this.j.setViewType(2);
            this.h.setAfterClickListener(new a(this));
            TbImageView tbImageView = (TbImageView) findViewById(R.id.thread_card_img_singal);
            this.i = tbImageView;
            tbImageView.setRadiusById(R.string.J_X05);
            this.i.setConrers(15);
            this.i.setDrawCorner(true);
            this.i.setPlaceHolder(3);
            this.i.setLongIconSupport(true);
            this.i.setGifIconSupport(true);
            TextView textView = this.e;
            if (textView != null) {
                EMManager.from(textView).setTextShadow(R.array.S_O_X001);
            }
            TextView textView2 = this.d;
            if (textView2 != null) {
                EMManager.from(textView2).setTextShadow(R.array.S_O_X001);
            }
            this.o = new b(this);
        }
    }

    public void k(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) && i > 0 && i2 > 0) {
            TbImageView tbImageView = this.i;
            if (tbImageView != null && tbImageView.getVisibility() == 0) {
                ViewGroup.LayoutParams layoutParams = this.i.getLayoutParams();
                layoutParams.width = i;
                layoutParams.height = i2;
            }
            RelativeLayout relativeLayout = this.c;
            if (relativeLayout != null) {
                relativeLayout.getLayoutParams().width = i;
            }
        }
    }

    public final void l(TbImageView tbImageView, int i, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{tbImageView, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (this.o != null && tbImageView != null) {
                View.OnClickListener onClickListener = tbImageView.getOnClickListener();
                if (onClickListener instanceof e) {
                    ((e) onClickListener).a(i, z, z2);
                } else {
                    tbImageView.setOnClickListener(new e(this, i, z, z2));
                }
            } else if (this.o == null && tbImageView != null) {
                tbImageView.setClickable(false);
            }
        }
    }

    public final void m(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{mediaData, tbImageView, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i)}) == null) {
            String thumbnailsUrl = ThreadCardUtils.getThumbnailsUrl(mediaData);
            if (this.l) {
                i2 = 46;
            } else {
                i2 = 47;
            }
            mediaData.setLoadUrlType(i2);
            if (!StringHelper.equals(thumbnailsUrl, tbImageView.getUrl())) {
                tbImageView.reset();
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
            tbImageView.setOnDrawListener(this.u);
            tbImageView.startLoad(thumbnailsUrl, i2, false);
            l(tbImageView, i, z2, z3);
        }
    }

    public void setMarginsTop(View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048590, this, view2, i) == null) && (view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            if (marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                view2.setLayoutParams(marginLayoutParams);
            }
        }
    }
}
