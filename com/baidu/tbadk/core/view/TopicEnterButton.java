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
import c.a.o0.r.v.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.data.RecommendTopicData;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class TopicEnterButton extends AppCompatTextView implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final int f30193b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f30194c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f30195d;
    public transient /* synthetic */ FieldHolder $fh;
    public RecommendTopicData.RecommendTopicListData a;

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
        f30193b = n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
        f30194c = n.f(TbadkCoreApplication.getInst(), R.dimen.T_X09);
        f30195d = (((((n.k(TbadkCoreApplication.getInst()) / 2) - n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X005)) - (n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X004) * 2)) - n.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X002)) - f30193b) - f30194c;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        e();
    }

    public void d(RecommendTopicData.RecommendTopicListData recommendTopicListData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, recommendTopicListData) == null) {
            this.a = recommendTopicListData;
            if (recommendTopicListData != null) {
                String topicName = recommendTopicListData.getTopicName();
                if (m.isEmpty(topicName)) {
                    setVisibility(8);
                    return;
                }
                setText(TextUtils.ellipsize(topicName, getPaint(), f30195d, TextUtils.TruncateAt.END));
                setVisibility(0);
                f();
                return;
            }
            setVisibility(8);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setHeight((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds62));
            setMaxLines(1);
            setGravity(17);
            setPadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.M_W_X004), 0, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.M_W_X004), 0);
            setOnClickListener(this);
            f();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c d2 = c.d(this);
            d2.A(R.string.F_X01);
            d2.z(R.dimen.T_X09);
            d2.v(R.color.CAM_X0304);
            d2.e(R.string.A_X07);
            d2.n(R.string.J_X01);
            d2.l(R.dimen.L_X02);
            d2.k(R.color.CAM_X0304);
            Drawable maskDrawable = WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f08088c, WebPManager.ResourceStateType.NORMAL_PRESS);
            setCompoundDrawablePadding(f30193b);
            if (maskDrawable != null) {
                int i = f30194c;
                maskDrawable.setBounds(0, 0, i, i);
            }
            setCompoundDrawables(maskDrawable, null, null, null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RecommendTopicData.RecommendTopicListData recommendTopicListData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || (recommendTopicListData = this.a) == null || m.isEmpty(recommendTopicListData.getTopicName())) {
            return;
        }
        new HotTopicActivityConfig(view.getContext()).createNormalConfig(null, this.a.getTopicName(), "2").start();
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
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicEnterButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        e();
    }
}
