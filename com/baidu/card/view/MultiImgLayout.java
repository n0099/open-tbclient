package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.k.p;
import d.a.p0.d1.j.d;
import d.a.p0.s.k;
import d.a.p0.s.q.b2;
import d.a.q0.a0.b0;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgLayout extends LinearLayout implements p<d.a.p0.s.q.a> {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4482e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f4483f;

    /* renamed from: g  reason: collision with root package name */
    public PlayVoiceBntNew f4484g;

    /* renamed from: h  reason: collision with root package name */
    public ConstrainImageGroup f4485h;

    /* renamed from: i  reason: collision with root package name */
    public String f4486i;
    public boolean j;
    public b0<d.a.p0.s.q.a> k;
    public d.a.p0.s.q.a l;
    public boolean m;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MultiImgLayout f4487e;

        public a(MultiImgLayout multiImgLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImgLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4487e = multiImgLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b0<d.a.p0.s.q.a> subClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (subClickListener = this.f4487e.getSubClickListener()) == null) {
                return;
            }
            view.setTag("2");
            subClickListener.a(view, this.f4487e.l);
        }
    }

    /* loaded from: classes.dex */
    public class b implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LinkedList f4488a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MultiImgLayout f4489b;

        public b(MultiImgLayout multiImgLayout, LinkedList linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImgLayout, linkedList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4489b = multiImgLayout;
            this.f4488a = linkedList;
        }

        @Override // d.a.p0.d1.j.d
        public void a(View view, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                if (this.f4489b.k == null || !this.f4489b.k.c(view, this.f4489b.l, "")) {
                    b0<d.a.p0.s.q.a> subClickListener = this.f4489b.getSubClickListener();
                    if (subClickListener != null) {
                        view.setTag("1");
                        this.f4489b.l.objType = 2;
                        subClickListener.f54324a = Boolean.valueOf(z);
                        subClickListener.a(view, this.f4489b.l);
                        this.f4489b.l.objType = 1;
                    }
                    if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().q) {
                        ThreadCardUtils.startImageViewer(view, this.f4489b.j, this.f4488a, i2, this.f4489b.l.getThreadData(), this.f4489b.f4486i);
                    } else if ("frs".equals(this.f4489b.f4486i)) {
                        ThreadCardUtils.jumpToPB(this.f4489b.l, view.getContext(), 3, false);
                    } else if ("index".equals(this.f4489b.f4486i)) {
                        ThreadCardUtils.jumpToPB(this.f4489b.l, view.getContext(), 2, false);
                    } else {
                        ThreadCardUtils.startImageViewer(view, this.f4489b.j, this.f4488a, i2, this.f4489b.l.getThreadData(), this.f4489b.f4486i);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1429617170, "Lcom/baidu/card/view/MultiImgLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1429617170, "Lcom/baidu/card/view/MultiImgLayout;");
                return;
            }
        }
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds7);
        n = l.k(TbadkCoreApplication.getInst()) - ((l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultiImgLayout(Context context) {
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
        if (interceptable == null || interceptable.invokeL(65543, this, b2Var) == null) {
            this.f4485h.setFromCDN(this.j);
            this.f4485h.setSinglePicUseStyleV10(true);
            ArrayList<MediaData> A0 = b2Var.A0();
            if (k.c().g() && ListUtils.getCount(A0) != 0) {
                LinkedList linkedList = new LinkedList();
                for (int i2 = 0; i2 < A0.size(); i2++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(A0, i2);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (ListUtils.getCount(linkedList) > 0) {
                    this.f4485h.setVisibility(0);
                    this.f4485h.setFromCDN(this.j);
                    this.f4485h.setImageClickListener(new b(this, linkedList));
                    this.f4485h.setImageMediaList(linkedList);
                    return;
                }
                this.f4485h.setVisibility(8);
                return;
            }
            this.f4485h.setVisibility(8);
        }
    }

    private void setVoiceData(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, b2Var) == null) {
            ArrayList<VoiceData$VoiceModel> y1 = b2Var.y1();
            if (ListUtils.isEmpty(y1)) {
                this.f4484g.setVisibility(8);
                return;
            }
            this.f4484g.setVisibility(0);
            VoiceData$VoiceModel voiceData$VoiceModel = y1.get(0);
            this.f4484g.setVoiceModel(voiceData$VoiceModel);
            this.f4484g.setTag(voiceData$VoiceModel);
            this.f4484g.b();
            if (voiceData$VoiceModel != null) {
                this.f4484g.j(voiceData$VoiceModel.voice_status.intValue());
            }
            this.f4484g.l();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.multi_image_layout, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f4483f = (TextView) findViewById(R.id.thread_card_abstract);
            this.f4482e = (TextView) findViewById(R.id.thread_card_title);
            PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
            this.f4484g = playVoiceBntNew;
            playVoiceBntNew.setAfterClickListener(new a(this));
            this.f4485h = (ConstrainImageGroup) findViewById(R.id.thread_card_img_group);
            this.f4485h.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002));
            d.a.p0.d1.j.a aVar = new d.a.p0.d1.j.a(3);
            aVar.d(1.0d);
            this.f4485h.setImageProcessor(aVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k.p
    /* renamed from: g */
    public void a(d.a.p0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.l = aVar;
            b2 threadData = aVar.getThreadData();
            ThreadCardUtils.setTitle(this.f4482e, threadData, this.m);
            ThreadCardUtils.setAbstract(this.f4483f, this.f4482e, threadData, n, this.m);
            TextView textView = this.f4482e;
            boolean z = false;
            boolean z2 = textView == null || textView.getVisibility() != 0;
            TextView textView2 = this.f4483f;
            boolean z3 = textView2 == null || textView2.getVisibility() != 0;
            ConstrainImageGroup constrainImageGroup = this.f4485h;
            if (z2 && z3) {
                z = true;
            }
            ThreadCardUtils.dealMainViewTopMargin(constrainImageGroup, z, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            setImageData(threadData);
            setVoiceData(threadData);
        }
    }

    public b0<d.a.p0.s.q.a> getSubClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : (b0) invokeV.objValue;
    }

    public void setConstrainImagePool(d.a.d.e.k.b<TbImageView> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) || (constrainImageGroup = this.f4485h) == null) {
            return;
        }
        constrainImageGroup.setImageViewPool(bVar);
    }

    public void setConstrainLayoutPool(d.a.d.e.k.b<ConstrainImageLayout> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) || (constrainImageGroup = this.f4485h) == null) {
            return;
        }
        constrainImageGroup.setConstrainLayoutPool(bVar);
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f4486i = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.j = z;
        }
    }

    public void setMarginsTop(View view, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, i2) == null) && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i2) {
                marginLayoutParams.topMargin = i2;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void setNeedFrsTabName(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.m = z;
        }
    }

    public void setPreloadSizeReadyCallback(d.a.d.k.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.f4485h.setPreloadSizeReadyCallback(bVar);
        }
    }

    public void setSingleImageRatio(double d2) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Double.valueOf(d2)}) == null) || (constrainImageGroup = this.f4485h) == null) {
            return;
        }
        constrainImageGroup.setSingleImageRatio(d2);
    }

    public void setSubClickListener(b0<d.a.p0.s.q.a> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, b0Var) == null) {
            this.k = b0Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiImgLayout(Context context, @Nullable AttributeSet attributeSet) {
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
        this.j = true;
        this.l = null;
        this.m = false;
        f();
    }
}
