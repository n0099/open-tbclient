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
import d.a.c.e.p.l;
import d.a.j.p;
import d.a.r0.b1.j.d;
import d.a.r0.r.k;
import d.a.r0.r.q.b2;
import d.a.s0.a0.b0;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MultiImgLayout extends LinearLayout implements p<d.a.r0.r.q.a> {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4451e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f4452f;

    /* renamed from: g  reason: collision with root package name */
    public PlayVoiceBntNew f4453g;

    /* renamed from: h  reason: collision with root package name */
    public ConstrainImageGroup f4454h;

    /* renamed from: i  reason: collision with root package name */
    public String f4455i;
    public boolean j;
    public b0<d.a.r0.r.q.a> k;
    public d.a.r0.r.q.a l;
    public boolean m;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MultiImgLayout f4456e;

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
            this.f4456e = multiImgLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b0<d.a.r0.r.q.a> subClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (subClickListener = this.f4456e.getSubClickListener()) == null) {
                return;
            }
            view.setTag("2");
            subClickListener.a(view, this.f4456e.l);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LinkedList f4457a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MultiImgLayout f4458b;

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
            this.f4458b = multiImgLayout;
            this.f4457a = linkedList;
        }

        @Override // d.a.r0.b1.j.d
        public void a(View view, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                if (this.f4458b.k == null || !this.f4458b.k.c(view, this.f4458b.l, "")) {
                    b0<d.a.r0.r.q.a> subClickListener = this.f4458b.getSubClickListener();
                    if (subClickListener != null) {
                        view.setTag("1");
                        this.f4458b.l.objType = 2;
                        subClickListener.f57036a = Boolean.valueOf(z);
                        subClickListener.a(view, this.f4458b.l);
                        this.f4458b.l.objType = 1;
                    }
                    if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().q) {
                        ThreadCardUtils.startImageViewer(view, this.f4458b.j, this.f4457a, i2, this.f4458b.l.getThreadData(), this.f4458b.f4455i);
                    } else if ("frs".equals(this.f4458b.f4455i)) {
                        ThreadCardUtils.jumpToPB(this.f4458b.l, view.getContext(), 3, false);
                    } else if ("index".equals(this.f4458b.f4455i)) {
                        ThreadCardUtils.jumpToPB(this.f4458b.l, view.getContext(), 2, false);
                    } else {
                        ThreadCardUtils.startImageViewer(view, this.f4458b.j, this.f4457a, i2, this.f4458b.l.getThreadData(), this.f4458b.f4455i);
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
            this.f4454h.setFromCDN(this.j);
            this.f4454h.setSinglePicUseStyleV10(true);
            ArrayList<MediaData> z0 = b2Var.z0();
            if (k.c().g() && ListUtils.getCount(z0) != 0) {
                LinkedList linkedList = new LinkedList();
                for (int i2 = 0; i2 < z0.size(); i2++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(z0, i2);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (ListUtils.getCount(linkedList) > 0) {
                    this.f4454h.setVisibility(0);
                    this.f4454h.setFromCDN(this.j);
                    this.f4454h.setImageClickListener(new b(this, linkedList));
                    this.f4454h.setImageMediaList(linkedList);
                    return;
                }
                this.f4454h.setVisibility(8);
                return;
            }
            this.f4454h.setVisibility(8);
        }
    }

    private void setVoiceData(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, b2Var) == null) {
            ArrayList<VoiceData$VoiceModel> x1 = b2Var.x1();
            if (ListUtils.isEmpty(x1)) {
                this.f4453g.setVisibility(8);
                return;
            }
            this.f4453g.setVisibility(0);
            VoiceData$VoiceModel voiceData$VoiceModel = x1.get(0);
            this.f4453g.setVoiceModel(voiceData$VoiceModel);
            this.f4453g.setTag(voiceData$VoiceModel);
            this.f4453g.b();
            if (voiceData$VoiceModel != null) {
                this.f4453g.k(voiceData$VoiceModel.voice_status.intValue());
            }
            this.f4453g.m();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.multi_image_layout, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f4452f = (TextView) findViewById(R.id.thread_card_abstract);
            this.f4451e = (TextView) findViewById(R.id.thread_card_title);
            PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
            this.f4453g = playVoiceBntNew;
            playVoiceBntNew.setAfterClickListener(new a(this));
            this.f4454h = (ConstrainImageGroup) findViewById(R.id.thread_card_img_group);
            this.f4454h.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002));
            d.a.r0.b1.j.a aVar = new d.a.r0.b1.j.a(3);
            aVar.d(1.0d);
            this.f4454h.setImageProcessor(aVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j.p
    /* renamed from: g */
    public void a(d.a.r0.r.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.l = aVar;
            b2 threadData = aVar.getThreadData();
            ThreadCardUtils.setTitle(this.f4451e, threadData, this.m);
            ThreadCardUtils.setAbstract(this.f4452f, this.f4451e, threadData, n, this.m);
            TextView textView = this.f4451e;
            boolean z = false;
            boolean z2 = textView == null || textView.getVisibility() != 0;
            TextView textView2 = this.f4452f;
            boolean z3 = textView2 == null || textView2.getVisibility() != 0;
            ConstrainImageGroup constrainImageGroup = this.f4454h;
            if (z2 && z3) {
                z = true;
            }
            ThreadCardUtils.dealMainViewTopMargin(constrainImageGroup, z, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            setImageData(threadData);
            setVoiceData(threadData);
        }
    }

    public b0<d.a.r0.r.q.a> getSubClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : (b0) invokeV.objValue;
    }

    public void setConstrainImagePool(d.a.c.e.k.b<TbImageView> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) || (constrainImageGroup = this.f4454h) == null) {
            return;
        }
        constrainImageGroup.setImageViewPool(bVar);
    }

    public void setConstrainLayoutPool(d.a.c.e.k.b<ConstrainImageLayout> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) || (constrainImageGroup = this.f4454h) == null) {
            return;
        }
        constrainImageGroup.setConstrainLayoutPool(bVar);
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f4455i = str;
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

    public void setPreloadSizeReadyCallback(d.a.c.k.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.f4454h.setPreloadSizeReadyCallback(bVar);
        }
    }

    public void setSingleImageRatio(double d2) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Double.valueOf(d2)}) == null) || (constrainImageGroup = this.f4454h) == null) {
            return;
        }
        constrainImageGroup.setSingleImageRatio(d2);
    }

    public void setSubClickListener(b0<d.a.r0.r.q.a> b0Var) {
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
