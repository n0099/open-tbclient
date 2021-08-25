package c.a.l;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.l.v0.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public class n0 extends c.a.l.a<c.a.p0.s.q.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: j  reason: collision with root package name */
    public int f3856j;
    public int k;
    public ThreadCommentAndPraiseInfoLayout l;
    public c.a.p0.s.q.a m;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n0 f3857e;

        public a(n0 n0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3857e = n0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f3857e.c() == null) {
                return;
            }
            this.f3857e.c().a(view, this.f3857e.m);
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n0 f3858a;

        public b(n0 n0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3858a = n0Var;
        }

        @Override // c.a.l.v0.a.b
        public boolean a(a.C0096a c0096a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, c0096a)) == null) {
                if (c0096a.c() instanceof Boolean) {
                    if (!((Boolean) c0096a.c()).booleanValue()) {
                        if ((this.f3858a.f3856j & 128) <= 0) {
                            this.f3858a.f3856j &= -5;
                            this.f3858a.f3856j |= 64;
                        }
                    } else {
                        n0 n0Var = this.f3858a;
                        n0Var.f3856j = n0Var.k;
                    }
                    this.f3858a.l.setShowFlag(this.f3858a.f3856j);
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3856j = 11;
        this.k = 11;
        ThreadCardBottomOpSegmentLayout threadCardBottomOpSegmentLayout = new ThreadCardBottomOpSegmentLayout(context);
        this.l = threadCardBottomOpSegmentLayout;
        threadCardBottomOpSegmentLayout.setReplyTimeVisible(false);
        this.l.setShowPraiseNum(true);
        this.l.setNeedAddPraiseIcon(true);
        this.l.setNeedAddReplyIcon(true);
        this.l.setShareVisible(true);
        this.l.setForumAfterClickListener(new a(this));
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.l.setStType(str);
        }
    }

    public void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.l.setTabName(str);
        }
    }

    @Override // c.a.l.a
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            int i3 = i2 | this.f3856j;
            this.f3856j = i3;
            this.l.setShowFlag(i3);
            this.k = this.f3856j;
        }
    }

    @Override // c.a.l.a
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            int i3 = (~i2) & this.f3856j;
            this.f3856j = i3;
            this.l.setShowFlag(i3);
            this.k = this.f3856j;
        }
    }

    @Override // c.a.l.a
    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    @Override // c.a.l.a
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f3788e.m(4, new b(this));
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i2) == null) {
            this.l.onChangeSkinType();
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            boolean z = false;
            j(this.l, 0);
            c.a.l.a f2 = this.f3788e.f();
            if (f2 == null) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) f2.f();
            int childCount = viewGroup.getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    z = true;
                    break;
                } else if (!(viewGroup.getChildAt(i2) instanceof TextView) && viewGroup.getChildAt(i2).getVisibility() == 0) {
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                List<h> h2 = this.f3788e.h();
                if (ListUtils.isEmpty(h2)) {
                    return;
                }
                for (h hVar : h2) {
                    if (hVar != null && hVar.f() != null && hVar.f().getVisibility() == 0) {
                        return;
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: t */
    public void onBindDataToView(c.a.p0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.m = aVar;
            this.l.setData(aVar.getThreadData());
            s();
        }
    }

    public void u(c.a.p0.s.q.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            this.l.setAgreeStatisticData(fVar);
        }
    }

    public void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.l.setFrom(i2);
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.l.sourceFromForPb = i2;
        }
    }

    public void x(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.l.setGameId(i2);
        }
    }

    public void y(ThreadCommentAndPraiseInfoLayout.i iVar) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, iVar) == null) || (threadCommentAndPraiseInfoLayout = this.l) == null) {
            return;
        }
        threadCommentAndPraiseInfoLayout.setOnCommentClickCallback(iVar);
    }

    public void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.l.setShareReportFrom(i2);
        }
    }
}
