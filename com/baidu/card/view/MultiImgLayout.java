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
import c.a.d.f.p.n;
import c.a.l.p;
import c.a.s0.g1.j.d;
import c.a.s0.s.k;
import c.a.s0.s.q.d2;
import c.a.t0.g0.d0;
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
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes10.dex */
public class MultiImgLayout extends LinearLayout implements p<c.a.s0.s.q.a> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final int f34265j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f34266e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34267f;

    /* renamed from: g  reason: collision with root package name */
    public d0<c.a.s0.s.q.a> f34268g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.s0.s.q.a f34269h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f34270i;
    public TextView mAbstract;
    public ConstrainImageGroup mImageGroup;
    public TextView mTitle;
    public PlayVoiceBntNew mVoiceBtn;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MultiImgLayout f34271e;

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
            this.f34271e = multiImgLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d0<c.a.s0.s.q.a> subClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (subClickListener = this.f34271e.getSubClickListener()) == null) {
                return;
            }
            view.setTag("2");
            subClickListener.a(view, this.f34271e.f34269h);
        }
    }

    /* loaded from: classes10.dex */
    public class b implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinkedList a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MultiImgLayout f34272b;

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
            this.f34272b = multiImgLayout;
            this.a = linkedList;
        }

        @Override // c.a.s0.g1.j.d
        public void a(View view, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                if (this.f34272b.f34268g == null || !this.f34272b.f34268g.c(view, this.f34272b.f34269h, "")) {
                    d0<c.a.s0.s.q.a> subClickListener = this.f34272b.getSubClickListener();
                    if (subClickListener != null) {
                        view.setTag("1");
                        this.f34272b.f34269h.objType = 2;
                        subClickListener.a = Boolean.valueOf(z);
                        subClickListener.a(view, this.f34272b.f34269h);
                        this.f34272b.f34269h.objType = 1;
                    }
                    if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().p) {
                        ThreadCardUtils.startImageViewer(view, this.f34272b.f34267f, this.a, i2, this.f34272b.f34269h.getThreadData(), this.f34272b.f34266e);
                    } else if ("frs".equals(this.f34272b.f34266e)) {
                        ThreadCardUtils.jumpToPB(this.f34272b.f34269h, view.getContext(), 3, false);
                    } else if ("index".equals(this.f34272b.f34266e)) {
                        ThreadCardUtils.jumpToPB(this.f34272b.f34269h, view.getContext(), 2, false);
                    } else {
                        ThreadCardUtils.startImageViewer(view, this.f34272b.f34267f, this.a, i2, this.f34272b.f34269h.getThreadData(), this.f34272b.f34266e);
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
        n.f(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        n.f(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        n.f(TbadkCoreApplication.getInst(), R.dimen.tbds7);
        f34265j = n.k(TbadkCoreApplication.getInst()) - ((n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
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

    private void setImageData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, d2Var) == null) {
            this.mImageGroup.setFromCDN(this.f34267f);
            this.mImageGroup.setSinglePicUseStyleV10(true);
            ArrayList<MediaData> F0 = d2Var.F0();
            if (k.c().g() && ListUtils.getCount(F0) != 0) {
                LinkedList linkedList = new LinkedList();
                for (int i2 = 0; i2 < F0.size(); i2++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(F0, i2);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (ListUtils.getCount(linkedList) > 0) {
                    this.mImageGroup.setVisibility(0);
                    this.mImageGroup.setFromCDN(this.f34267f);
                    this.mImageGroup.setImageClickListener(new b(this, linkedList));
                    this.mImageGroup.setImageMediaList(linkedList);
                    return;
                }
                this.mImageGroup.setVisibility(8);
                return;
            }
            this.mImageGroup.setVisibility(8);
        }
    }

    private void setVoiceData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, d2Var) == null) {
            ArrayList<VoiceData$VoiceModel> F1 = d2Var.F1();
            if (ListUtils.isEmpty(F1)) {
                this.mVoiceBtn.setVisibility(8);
                return;
            }
            this.mVoiceBtn.setVisibility(0);
            VoiceData$VoiceModel voiceData$VoiceModel = F1.get(0);
            this.mVoiceBtn.setVoiceModel(voiceData$VoiceModel);
            this.mVoiceBtn.setTag(voiceData$VoiceModel);
            this.mVoiceBtn.changeSkin();
            if (voiceData$VoiceModel != null) {
                this.mVoiceBtn.refreshViewState(voiceData$VoiceModel.voice_status.intValue());
            }
            this.mVoiceBtn.resetLayoutParams();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.multi_image_layout, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.mAbstract = (TextView) findViewById(R.id.thread_card_abstract);
            this.mTitle = (TextView) findViewById(R.id.thread_card_title);
            PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
            this.mVoiceBtn = playVoiceBntNew;
            playVoiceBntNew.setAfterClickListener(new a(this));
            this.mImageGroup = (ConstrainImageGroup) findViewById(R.id.thread_card_img_group);
            this.mImageGroup.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002));
            c.a.s0.g1.j.a aVar = new c.a.s0.g1.j.a(3);
            aVar.d(1.0d);
            this.mImageGroup.setImageProcessor(aVar);
        }
    }

    public d0<c.a.s0.s.q.a> getSubClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f34268g : (d0) invokeV.objValue;
    }

    public void setConstrainImagePool(c.a.d.f.k.b<TbImageView> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) || (constrainImageGroup = this.mImageGroup) == null) {
            return;
        }
        constrainImageGroup.setImageViewPool(bVar);
    }

    public void setConstrainLayoutPool(c.a.d.f.k.b<ConstrainImageLayout> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) || (constrainImageGroup = this.mImageGroup) == null) {
            return;
        }
        constrainImageGroup.setConstrainLayoutPool(bVar);
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f34266e = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f34267f = z;
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
            this.f34270i = z;
        }
    }

    public void setPreloadSizeReadyCallback(c.a.d.n.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.mImageGroup.setPreloadSizeReadyCallback(bVar);
        }
    }

    public void setSingleImageRatio(double d2) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Double.valueOf(d2)}) == null) || (constrainImageGroup = this.mImageGroup) == null) {
            return;
        }
        constrainImageGroup.setSingleImageRatio(d2);
    }

    public void setSubClickListener(d0<c.a.s0.s.q.a> d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, d0Var) == null) {
            this.f34268g = d0Var;
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
        this.f34267f = true;
        this.f34269h = null;
        this.f34270i = false;
        e();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    public void onBindDataToView(c.a.s0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f34269h = aVar;
            d2 threadData = aVar.getThreadData();
            ThreadCardUtils.setTitle(this.mTitle, threadData, this.f34270i);
            ThreadCardUtils.setAbstract(this.mAbstract, this.mTitle, threadData, f34265j, this.f34270i);
            TextView textView = this.mTitle;
            boolean z = false;
            boolean z2 = textView == null || textView.getVisibility() != 0;
            TextView textView2 = this.mAbstract;
            boolean z3 = textView2 == null || textView2.getVisibility() != 0;
            ConstrainImageGroup constrainImageGroup = this.mImageGroup;
            if (z2 && z3) {
                z = true;
            }
            ThreadCardUtils.dealMainViewTopMargin(constrainImageGroup, z, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            setImageData(threadData);
            setVoiceData(threadData);
        }
    }
}
