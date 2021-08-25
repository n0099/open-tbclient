package c.a.l;

import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.s.q.c2;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.FollowUserDecorView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class j extends c implements p<c2>, q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public FollowUserDecorView f3817i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3818j;
    public int k;
    public int l;

    public j(TbPageContext tbPageContext, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3818j = true;
        this.k = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds166);
        this.l = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds78);
        FollowUserDecorView followUserDecorView = new FollowUserDecorView(tbPageContext.getPageActivity());
        this.f3817i = followUserDecorView;
        followUserDecorView.setUseNewStyle(z);
        g(-1);
        l(z);
    }

    public void j(c.a.p0.s.q.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, aVar, z) == null) {
            this.f3818j = z;
            r(0);
            n(true);
        }
    }

    public final int k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), i2) : invokeI.intValue;
    }

    public final void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.k = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds177);
                this.l = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds76);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.k, this.l);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = k(R.dimen.tbds50);
            if (z) {
                layoutParams.topMargin = k(R.dimen.tbds52);
            }
            h(layoutParams);
            f(this.f3817i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: m */
    public void onBindDataToView(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, c2Var) == null) {
            if (c2Var != null && c2Var.J() != null) {
                o(k(this.f3818j ? R.dimen.tbds120 : R.dimen.tbds44));
                this.f3817i.setVisibility(0);
                this.f3817i.setData(c2Var);
                this.f3817i.setTag(c2Var);
                return;
            }
            this.f3817i.setVisibility(8);
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f3817i.setClickableUnLike(z);
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            if (c() != null) {
                c().rightMargin = i2;
            }
            this.f3817i.setLayoutParams(c());
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i2) == null) {
            this.f3817i.onChangeSkinType(i2);
        }
    }

    public void p(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f3817i.setOnClickEvent(aVar);
        }
    }

    public void q(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            this.f3817i.setPageUniqueId(bdUniqueId);
        }
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f3817i.setSvgIconResId(i2);
        }
    }
}
