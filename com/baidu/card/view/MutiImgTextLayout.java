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
import d.a.d.e.p.l;
import d.a.d.k.c.b;
import d.a.k.p;
import d.a.p0.s.q.b2;
import d.a.q0.a0.b0;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class MutiImgTextLayout extends LinearLayout implements p<d.a.p0.s.q.a> {
    public static /* synthetic */ Interceptable $ic;
    public static final int k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4565e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f4566f;

    /* renamed from: g  reason: collision with root package name */
    public PlayVoiceBntNew f4567g;

    /* renamed from: h  reason: collision with root package name */
    public b0<d.a.p0.s.q.a> f4568h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.p0.s.q.a f4569i;
    public boolean j;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MutiImgTextLayout f4570e;

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
            this.f4570e = mutiImgTextLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b0<d.a.p0.s.q.a> subClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (subClickListener = this.f4570e.getSubClickListener()) == null) {
                return;
            }
            view.setTag("2");
            subClickListener.a(view, this.f4570e.f4569i);
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
        k = l.k(TbadkCoreApplication.getInst()) - ((l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
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

    private void setVoiceData(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, b2Var) == null) {
            ArrayList<VoiceData$VoiceModel> y1 = b2Var.y1();
            if (ListUtils.isEmpty(y1)) {
                this.f4567g.setVisibility(8);
                return;
            }
            this.f4567g.setVisibility(0);
            VoiceData$VoiceModel voiceData$VoiceModel = y1.get(0);
            this.f4567g.setVoiceModel(voiceData$VoiceModel);
            this.f4567g.setTag(voiceData$VoiceModel);
            this.f4567g.b();
            if (voiceData$VoiceModel != null) {
                this.f4567g.j(voiceData$VoiceModel.voice_status.intValue());
            }
            this.f4567g.l();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.multi_image_text_layout, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f4566f = (TextView) findViewById(R.id.thread_card_abstract);
            this.f4565e = (TextView) findViewById(R.id.thread_card_title);
            PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
            this.f4567g = playVoiceBntNew;
            playVoiceBntNew.setAfterClickListener(new a(this));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k.p
    /* renamed from: d */
    public void a(d.a.p0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f4569i = aVar;
            b2 threadData = aVar.getThreadData();
            ThreadCardUtils.setTitle(this.f4565e, threadData, this.j);
            ThreadCardUtils.setAbstract(this.f4566f, this.f4565e, threadData, k, this.j);
            TextView textView = this.f4565e;
            boolean z = true;
            boolean z2 = textView == null || textView.getVisibility() != 0;
            TextView textView2 = this.f4566f;
            ThreadCardUtils.dealMainViewTopMargin(this.f4567g, z2 && (textView2 == null || textView2.getVisibility() != 0), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            setVoiceData(threadData);
            PlayVoiceBntNew playVoiceBntNew = this.f4567g;
            if (playVoiceBntNew != null && playVoiceBntNew.getVisibility() == 0) {
                z = false;
            }
            if (z) {
                TextView textView3 = this.f4566f;
                if (textView3 != null && textView3.getVisibility() == 0) {
                    this.f4566f.setPadding(0, 0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds3));
                    return;
                }
                TextView textView4 = this.f4565e;
                if (textView4 == null || textView4.getVisibility() != 0) {
                    return;
                }
                this.f4565e.setPadding(0, 0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds3));
                return;
            }
            TextView textView5 = this.f4565e;
            if (textView5 != null) {
                textView5.setPadding(0, 0, 0, 0);
            }
            TextView textView6 = this.f4566f;
            if (textView6 != null) {
                textView6.setPadding(0, 0, 0, 0);
            }
        }
    }

    public b0<d.a.p0.s.q.a> getSubClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f4568h : (b0) invokeV.objValue;
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
            this.j = z;
        }
    }

    public void setPreloadSizeReadyCallback(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
        }
    }

    public void setSubClickListener(b0<d.a.p0.s.q.a> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, b0Var) == null) {
            this.f4568h = b0Var;
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
        this.f4569i = null;
        this.j = false;
        c();
    }
}
