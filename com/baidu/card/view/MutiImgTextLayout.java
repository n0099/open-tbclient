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
import c.a.d.n.c.b;
import c.a.l.p;
import c.a.s0.s.q.e2;
import c.a.t0.g0.d0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
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
/* loaded from: classes10.dex */
public class MutiImgTextLayout extends LinearLayout implements p<c.a.s0.s.q.a> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final int f33267h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d0<c.a.s0.s.q.a> f33268e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.s0.s.q.a f33269f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f33270g;
    public TextView mAbstract;
    public TextView mTitle;
    public PlayVoiceBntNew mVoiceBtn;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MutiImgTextLayout f33271e;

        public a(MutiImgTextLayout mutiImgTextLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mutiImgTextLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33271e = mutiImgTextLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d0<c.a.s0.s.q.a> subClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (subClickListener = this.f33271e.getSubClickListener()) == null) {
                return;
            }
            view.setTag("2");
            subClickListener.a(view, this.f33271e.f33269f);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-621594633, "Lcom/baidu/card/view/MutiImgTextLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-621594633, "Lcom/baidu/card/view/MutiImgTextLayout;");
                return;
            }
        }
        f33267h = n.k(TbadkCoreApplication.getInst()) - ((n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MutiImgTextLayout(Context context) {
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

    private void setVoiceData(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, e2Var) == null) {
            ArrayList<VoiceData$VoiceModel> G1 = e2Var.G1();
            if (ListUtils.isEmpty(G1)) {
                this.mVoiceBtn.setVisibility(8);
                return;
            }
            this.mVoiceBtn.setVisibility(0);
            VoiceData$VoiceModel voiceData$VoiceModel = G1.get(0);
            this.mVoiceBtn.setVoiceModel(voiceData$VoiceModel);
            this.mVoiceBtn.setTag(voiceData$VoiceModel);
            this.mVoiceBtn.changeSkin();
            if (voiceData$VoiceModel != null) {
                this.mVoiceBtn.refreshViewState(voiceData$VoiceModel.voice_status.intValue());
            }
            this.mVoiceBtn.resetLayoutParams();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.multi_image_text_layout, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.mAbstract = (TextView) findViewById(R.id.thread_card_abstract);
            this.mTitle = (TextView) findViewById(R.id.thread_card_title);
            PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
            this.mVoiceBtn = playVoiceBntNew;
            playVoiceBntNew.setAfterClickListener(new a(this));
        }
    }

    public d0<c.a.s0.s.q.a> getSubClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33268e : (d0) invokeV.objValue;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    public void setMarginsTop(View view, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048583, this, view, i2) == null) && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i2) {
                marginLayoutParams.topMargin = i2;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void setNeedFrsTabName(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f33270g = z;
        }
    }

    public void setPreloadSizeReadyCallback(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
        }
    }

    public void setSubClickListener(d0<c.a.s0.s.q.a> d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, d0Var) == null) {
            this.f33268e = d0Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutiImgTextLayout(Context context, @Nullable AttributeSet attributeSet) {
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
        this.f33269f = null;
        this.f33270g = false;
        b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    public void onBindDataToView(c.a.s0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f33269f = aVar;
            e2 threadData = aVar.getThreadData();
            ThreadCardUtils.setTitle(this.mTitle, threadData, this.f33270g);
            ThreadCardUtils.setAbstract(this.mAbstract, this.mTitle, threadData, f33267h, this.f33270g);
            TextView textView = this.mTitle;
            boolean z = true;
            boolean z2 = textView == null || textView.getVisibility() != 0;
            TextView textView2 = this.mAbstract;
            ThreadCardUtils.dealMainViewTopMargin(this.mVoiceBtn, z2 && (textView2 == null || textView2.getVisibility() != 0), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            setVoiceData(threadData);
            PlayVoiceBntNew playVoiceBntNew = this.mVoiceBtn;
            if (playVoiceBntNew != null && playVoiceBntNew.getVisibility() == 0) {
                z = false;
            }
            if (z) {
                TextView textView3 = this.mAbstract;
                if (textView3 != null && textView3.getVisibility() == 0) {
                    this.mAbstract.setPadding(0, 0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds3));
                    return;
                }
                TextView textView4 = this.mTitle;
                if (textView4 == null || textView4.getVisibility() != 0) {
                    return;
                }
                this.mTitle.setPadding(0, 0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds3));
                return;
            }
            TextView textView5 = this.mTitle;
            if (textView5 != null) {
                textView5.setPadding(0, 0, 0, 0);
            }
            TextView textView6 = this.mAbstract;
            if (textView6 != null) {
                textView6.setPadding(0, 0, 0, 0);
            }
        }
    }
}
