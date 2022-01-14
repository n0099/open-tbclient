package com.baidu.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.l.p;
import c.a.s0.g1.j.d;
import c.a.s0.s.k;
import c.a.s0.s.q.e2;
import c.a.t0.g0.d0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
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
/* loaded from: classes10.dex */
public class MutiImgDoubleLayout extends LinearLayout implements p<c.a.s0.s.q.a> {
    public static /* synthetic */ Interceptable $ic;
    public static final int l;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout doubleImgContainer;
    public TbImageView doubleImgOne;
    public TbImageView doubleImgTwo;

    /* renamed from: e  reason: collision with root package name */
    public String f33189e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f33190f;

    /* renamed from: g  reason: collision with root package name */
    public d0<c.a.s0.s.q.a> f33191g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.s0.s.q.a f33192h;

    /* renamed from: i  reason: collision with root package name */
    public int f33193i;

    /* renamed from: j  reason: collision with root package name */
    public d f33194j;
    public LinkedList<MediaData> k;
    public TextView mAbstract;
    public TextView mTitle;
    public PlayVoiceBntNew mVoiceBtn;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MutiImgDoubleLayout f33195e;

        public a(MutiImgDoubleLayout mutiImgDoubleLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mutiImgDoubleLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33195e = mutiImgDoubleLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d0<c.a.s0.s.q.a> subClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (subClickListener = this.f33195e.getSubClickListener()) == null) {
                return;
            }
            view.setTag("2");
            subClickListener.a(view, this.f33195e.f33192h);
        }
    }

    /* loaded from: classes10.dex */
    public class b implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MutiImgDoubleLayout a;

        public b(MutiImgDoubleLayout mutiImgDoubleLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mutiImgDoubleLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mutiImgDoubleLayout;
        }

        @Override // c.a.s0.g1.j.d
        public void a(View view, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                d0<c.a.s0.s.q.a> subClickListener = this.a.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    this.a.f33192h.objType = 2;
                    subClickListener.a(view, this.a.f33192h);
                    this.a.f33192h.objType = 1;
                }
                ThreadCardUtils.startImageViewer(view, this.a.f33190f, this.a.k, i2, this.a.f33192h.getThreadData(), this.a.f33189e);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f33196e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f33197f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f33198g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ MutiImgDoubleLayout f33199h;

        public c(MutiImgDoubleLayout mutiImgDoubleLayout, int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mutiImgDoubleLayout, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33199h = mutiImgDoubleLayout;
            a(i2, z, z2);
        }

        public void a(int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.f33196e = i2;
                this.f33197f = z;
                this.f33198g = z2;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || this.f33199h.f33194j == null) {
                return;
            }
            this.f33199h.f33194j.a(view, this.f33196e, this.f33197f && this.f33198g);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(668624915, "Lcom/baidu/card/view/MutiImgDoubleLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(668624915, "Lcom/baidu/card/view/MutiImgDoubleLayout;");
                return;
            }
        }
        n.f(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        n.f(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        n.f(TbadkCoreApplication.getInst(), R.dimen.tbds7);
        l = n.k(TbadkCoreApplication.getInst()) - ((n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MutiImgDoubleLayout(Context context) {
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

    private void setImageData(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, e2Var) == null) {
            ArrayList<MediaData> F0 = e2Var.F0();
            if (k.c().g() && ListUtils.getCount(F0) != 0) {
                LinkedList<MediaData> linkedList = new LinkedList<>();
                for (int i2 = 0; i2 < F0.size(); i2++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(F0, i2);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                this.k = linkedList;
                this.doubleImgContainer.setVisibility(8);
                if (ListUtils.getCount(linkedList) == 2) {
                    this.doubleImgContainer.setVisibility(0);
                    this.doubleImgOne.setConrers(15);
                    j((MediaData) ListUtils.getItem(F0, 0), this.doubleImgOne, true, false, false, 0);
                    this.doubleImgTwo.setConrers(15);
                    j((MediaData) ListUtils.getItem(F0, 1), this.doubleImgTwo, true, false, true, 1);
                    return;
                }
                this.doubleImgContainer.setVisibility(8);
                return;
            }
            this.doubleImgContainer.setVisibility(8);
        }
    }

    private void setVoiceData(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, e2Var) == null) {
            ArrayList<VoiceData$VoiceModel> F1 = e2Var.F1();
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

    public final int f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int i3 = this.f33193i;
            if (i3 > 0) {
                return i3;
            }
            int size = (View.MeasureSpec.getSize(i2) - (2 * TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10))) / 3;
            this.f33193i = size;
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

    public d0<c.a.s0.s.q.a> getSubClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33191g : (d0) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.multi_image_double_layout, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.mAbstract = (TextView) findViewById(R.id.thread_card_abstract);
            this.mTitle = (TextView) findViewById(R.id.thread_card_title);
            PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
            this.mVoiceBtn = playVoiceBntNew;
            playVoiceBntNew.setAfterClickListener(new a(this));
            c.a.s0.b.g.b.d(this.mVoiceBtn, R.dimen.tbds28, R.dimen.tbds14);
            c.a.s0.b.g.b.m(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
            c.a.s0.b.g.b.m(this.mAbstract, R.dimen.tbds7, R.dimen.tbds10);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.thread_card_img_double_container);
            this.doubleImgContainer = relativeLayout;
            c.a.s0.b.g.b.d(relativeLayout, R.dimen.tbds20, R.dimen.tbds14);
            this.doubleImgOne = (TbImageView) findViewById(R.id.thread_card_img_double_one);
            this.doubleImgTwo = (TbImageView) findViewById(R.id.thread_card_img_double_two);
            this.f33194j = new b(this);
        }
    }

    public final void i(TbImageView tbImageView, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{tbImageView, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (this.f33194j != null && tbImageView != null) {
                View.OnClickListener onClickListener = tbImageView.getOnClickListener();
                if (onClickListener instanceof c) {
                    ((c) onClickListener).a(i2, z, z2);
                } else {
                    tbImageView.setOnClickListener(new c(this, i2, z, z2));
                }
            } else if (this.f33194j != null || tbImageView == null) {
            } else {
                tbImageView.setClickable(false);
            }
        }
    }

    public final void j(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{mediaData, tbImageView, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i2)}) == null) {
            String g2 = g(mediaData);
            int i3 = this.f33190f ? 13 : 14;
            if (!StringHelper.equals(g2, tbImageView.getUrl())) {
                tbImageView.reset();
            }
            if (z) {
                tbImageView.setRadius(n.f(getContext(), R.dimen.tbds10));
                tbImageView.setDrawBorder(true);
                tbImageView.setForegroundColor(0);
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
                tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                tbImageView.setBorderSurroundContent(true);
            }
            tbImageView.startLoad(g2, i3, false);
            i(tbImageView, i2, z2, z3);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int f2 = f(i2);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.doubleImgOne.getLayoutParams();
            layoutParams.width = f2;
            layoutParams.height = f2;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.doubleImgTwo.getLayoutParams();
            layoutParams2.width = f2;
            layoutParams2.height = f2;
            if (this.doubleImgContainer.getVisibility() != 8) {
                this.doubleImgOne.setLayoutParams(layoutParams);
                this.doubleImgTwo.setLayoutParams(layoutParams2);
            }
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f33189e = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f33190f = z;
        }
    }

    public void setMarginsTop(View view, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048587, this, view, i2) == null) && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i2) {
                marginLayoutParams.topMargin = i2;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void setPreloadSizeReadyCallback(c.a.d.n.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
        }
    }

    public void setSubClickListener(d0<c.a.s0.s.q.a> d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, d0Var) == null) {
            this.f33191g = d0Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutiImgDoubleLayout(Context context, @Nullable AttributeSet attributeSet) {
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
        this.f33190f = true;
        this.f33192h = null;
        this.f33193i = 0;
        h();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    public void onBindDataToView(c.a.s0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.f33192h = aVar;
            e2 threadData = aVar.getThreadData();
            ThreadCardUtils.setTitle(this.mTitle, threadData);
            ThreadCardUtils.setAbstract(this.mAbstract, this.mTitle, threadData, l);
            setImageData(threadData);
            setVoiceData(threadData);
        }
    }
}
