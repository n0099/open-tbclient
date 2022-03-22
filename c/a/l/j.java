package c.a.l;

import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.FollowUserDecorView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class j extends c implements p<ThreadData>, q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FollowUserDecorView f3430e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3431f;

    /* renamed from: g  reason: collision with root package name */
    public int f3432g;

    /* renamed from: h  reason: collision with root package name */
    public int f3433h;

    public j(TbPageContext tbPageContext, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3431f = true;
        this.f3432g = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds166);
        this.f3433h = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds78);
        FollowUserDecorView followUserDecorView = new FollowUserDecorView(tbPageContext.getPageActivity());
        this.f3430e = followUserDecorView;
        followUserDecorView.setUseNewStyle(z);
        h(-1);
        m(z);
    }

    public void k(c.a.o0.r.r.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, z) == null) {
            this.f3431f = z;
            t(0);
            o(true);
        }
    }

    public final int l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), i) : invokeI.intValue;
    }

    public final void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.f3432g = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds177);
                this.f3433h = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds76);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f3432g, this.f3433h);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l(R.dimen.tbds50);
            if (z) {
                layoutParams.topMargin = l(R.dimen.tbds52);
            }
            i(layoutParams);
            g(this.f3430e);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: n */
    public void a(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) {
            if (threadData != null && threadData.getAuthor() != null) {
                q(l(this.f3431f ? R.dimen.tbds120 : R.dimen.tbds44));
                this.f3430e.setVisibility(0);
                this.f3430e.setData(threadData);
                this.f3430e.setTag(threadData);
                return;
            }
            this.f3430e.setVisibility(8);
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f3430e.setClickableUnLike(z);
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, tbPageContext, i) == null) {
            this.f3430e.r(i);
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f3430e.setIsShowIcon(z);
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            if (d() != null) {
                d().rightMargin = i;
            }
            this.f3430e.setLayoutParams(d());
        }
    }

    public void r(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.f3430e.setOnClickEvent(aVar);
        }
    }

    public void s(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bdUniqueId) == null) {
            this.f3430e.setPageUniqueId(bdUniqueId);
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.f3430e.setSvgIconResId(i);
        }
    }
}
