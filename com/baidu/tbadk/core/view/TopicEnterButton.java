package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.data.RecommendTopicData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.switchs.NewWebHotTopicPageSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.aw5;
import com.baidu.tieba.bi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class TopicEnterButton extends AppCompatTextView implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int b;
    public static final int c;
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
        b = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
        c = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X09);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()) / 2;
        BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005);
        BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
        BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            EMManager.from(this).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X09).setTextColor(R.color.CAM_X0304).setAlpha(R.string.A_X07).setCorner(R.string.J_X01).setBorderWidth(R.dimen.L_X02).setBorderColor(R.color.CAM_X0304);
            Drawable maskDrawable = WebPManager.getMaskDrawable((int) R.drawable.icon_pb_huati, WebPManager.ResourceStateType.NORMAL_PRESS);
            setCompoundDrawablePadding(b);
            if (maskDrawable != null) {
                int i = c;
                maskDrawable.setBounds(0, 0, i, i);
            }
            setCompoundDrawables(maskDrawable, null, null, null);
        }
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        RecommendTopicData.RecommendTopicListData recommendTopicListData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) && (recommendTopicListData = this.a) != null && !bi.isEmpty(recommendTopicListData.getTopicName())) {
            if (NewWebHotTopicPageSwitch.isOn()) {
                if (view2.getContext() instanceof BaseActivity) {
                    aw5.f(((BaseActivity) view2.getContext()).getPageContext(), null, this.a.getTopicName());
                    return;
                }
                return;
            }
            new HotTopicActivityConfig(view2.getContext()).createNormalConfig(null, this.a.getTopicName(), "2").start();
        }
    }
}
