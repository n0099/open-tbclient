package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.t0.s.v.c;
import c.a.u0.a4.d;
import c.a.u0.a4.e;
import c.a.u0.a4.f;
import c.a.u0.a4.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.data.RecommendTopicData;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class TopicEnterButton extends AppCompatTextView implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final int f40816f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f40817g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f40818h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RecommendTopicData.RecommendTopicListData f40819e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2059440419, "Lcom/baidu/tbadk/core/view/TopicEnterButton;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2059440419, "Lcom/baidu/tbadk/core/view/TopicEnterButton;");
                return;
            }
        }
        f40816f = n.f(TbadkCoreApplication.getInst(), e.M_W_X002);
        f40817g = n.f(TbadkCoreApplication.getInst(), e.T_X09);
        f40818h = (((((n.k(TbadkCoreApplication.getInst()) / 2) - n.f(TbadkCoreApplication.getInst(), e.M_W_X005)) - (n.f(TbadkCoreApplication.getInst(), e.M_W_X004) * 2)) - n.f(TbadkCoreApplication.getInst(), e.M_H_X002)) - f40816f) - f40817g;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicEnterButton(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        init();
    }

    public void bindData(RecommendTopicData.RecommendTopicListData recommendTopicListData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, recommendTopicListData) == null) {
            this.f40819e = recommendTopicListData;
            if (recommendTopicListData != null) {
                String topicName = recommendTopicListData.getTopicName();
                if (m.isEmpty(topicName)) {
                    setVisibility(8);
                    return;
                }
                setText(TextUtils.ellipsize(topicName, getPaint(), f40818h, TextUtils.TruncateAt.END));
                setVisibility(0);
                onChangeSkinType();
                return;
            }
            setVisibility(8);
        }
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setHeight((int) TbadkCoreApplication.getInst().getResources().getDimension(e.tbds62));
            setMaxLines(1);
            setGravity(17);
            setPadding((int) TbadkCoreApplication.getInst().getResources().getDimension(e.M_W_X004), 0, (int) TbadkCoreApplication.getInst().getResources().getDimension(e.M_W_X004), 0);
            setOnClickListener(this);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c d2 = c.d(this);
            d2.A(j.F_X01);
            d2.z(e.T_X09);
            d2.v(d.CAM_X0304);
            d2.e(j.A_X07);
            d2.n(j.J_X01);
            d2.l(e.L_X02);
            d2.k(d.CAM_X0304);
            Drawable maskDrawable = WebPManager.getMaskDrawable(f.icon_pb_huati, WebPManager.ResourceStateType.NORMAL_PRESS);
            setCompoundDrawablePadding(f40816f);
            if (maskDrawable != null) {
                int i2 = f40817g;
                maskDrawable.setBounds(0, 0, i2, i2);
            }
            setCompoundDrawables(maskDrawable, null, null, null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RecommendTopicData.RecommendTopicListData recommendTopicListData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || (recommendTopicListData = this.f40819e) == null || m.isEmpty(recommendTopicListData.getTopicName())) {
            return;
        }
        new HotTopicActivityConfig(view.getContext()).createNormalConfig(null, this.f40819e.getTopicName(), "2").start();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicEnterButton(Context context, @Nullable AttributeSet attributeSet) {
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
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicEnterButton(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        init();
    }
}
