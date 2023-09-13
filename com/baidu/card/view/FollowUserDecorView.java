package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.oa5;
import com.baidu.tieba.qb5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class FollowUserDecorView extends FollowUserButton {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId r;
    public qb5 s;
    public boolean t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FollowUserDecorView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FollowUserDecorView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FollowUserDecorView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.FollowUserButton
    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            super.q(z);
            if (!z) {
                oa5 oa5Var = new oa5();
                if (this.t) {
                    oa5Var.j(R.drawable.icon_pure_follow26, 0, TBSpecificationButtonConfig.IconType.WEBP);
                    oa5Var.i(R.color.CAM_X0304);
                    oa5Var.h(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26));
                    oa5Var.g(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X002));
                }
                oa5Var.u(R.color.CAM_X0304);
                setConfig(oa5Var);
            }
        }
    }

    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) {
            if (threadData != null && threadData.getAuthor() != null) {
                if (this.s == null) {
                    qb5 qb5Var = new qb5(r(getContext()), this);
                    this.s = qb5Var;
                    qb5Var.j(this.r);
                }
                setVisibility(0);
                this.s.o(true);
                this.s.l(threadData.getAuthor());
                this.s.n(threadData.tid);
                return;
            }
            setVisibility(8);
        }
    }

    public final TbPageContext r(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            if (context instanceof BaseActivity) {
                return ((BaseActivity) context).getPageContext();
            }
            if (context instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) context).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeL.objValue;
    }

    public void setIsShowIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.t = z;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            this.r = bdUniqueId;
            qb5 qb5Var = this.s;
            if (qb5Var != null) {
                qb5Var.j(bdUniqueId);
            }
        }
    }
}
