package b.a.l;

import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.q.d2;
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
public class j extends c implements p<d2>, q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public FollowUserDecorView f3327i;
    public boolean j;
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
        this.j = true;
        this.k = b.a.e.f.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds166);
        this.l = b.a.e.f.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds78);
        FollowUserDecorView followUserDecorView = new FollowUserDecorView(tbPageContext.getPageActivity());
        this.f3327i = followUserDecorView;
        followUserDecorView.setUseNewStyle(z);
        g(-1);
        l(z);
    }

    public void j(b.a.q0.s.q.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, aVar, z) == null) {
            this.j = z;
            s(0);
            n(true);
        }
    }

    public final int k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? b.a.e.f.p.l.g(TbadkCoreApplication.getInst(), i2) : invokeI.intValue;
    }

    public final void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.k = b.a.e.f.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds177);
                this.l = b.a.e.f.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds76);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.k, this.l);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = k(R.dimen.tbds50);
            if (z) {
                layoutParams.topMargin = k(R.dimen.tbds52);
            }
            h(layoutParams);
            f(this.f3327i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.l.p
    /* renamed from: m */
    public void onBindDataToView(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, d2Var) == null) {
            if (d2Var != null && d2Var.J() != null) {
                p(k(this.j ? R.dimen.tbds120 : R.dimen.tbds44));
                this.f3327i.setVisibility(0);
                this.f3327i.setData(d2Var);
                this.f3327i.setTag(d2Var);
                return;
            }
            this.f3327i.setVisibility(8);
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f3327i.setClickableUnLike(z);
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f3327i.setIsShowIcon(z);
        }
    }

    @Override // b.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i2) == null) {
            this.f3327i.onChangeSkinType(i2);
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            if (c() != null) {
                c().rightMargin = i2;
            }
            this.f3327i.setLayoutParams(c());
        }
    }

    public void q(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.f3327i.setOnClickEvent(aVar);
        }
    }

    public void r(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bdUniqueId) == null) {
            this.f3327i.setPageUniqueId(bdUniqueId);
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f3327i.setSvgIconResId(i2);
        }
    }
}
