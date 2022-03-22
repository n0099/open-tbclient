package c.a.l;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.l.w0.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
public class n0 extends c.a.l.a<c.a.o0.r.r.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public int f3465f;

    /* renamed from: g  reason: collision with root package name */
    public int f3466g;

    /* renamed from: h  reason: collision with root package name */
    public ThreadCommentAndPraiseInfoLayout f3467h;
    public c.a.o0.r.r.a i;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n0 a;

        public a(n0 n0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.d() == null) {
                return;
            }
            this.a.d().a(view, this.a.i);
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n0 a;

        public b(n0 n0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n0Var;
        }

        @Override // c.a.l.w0.a.b
        public boolean a(a.C0196a c0196a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, c0196a)) == null) {
                if (c0196a.c() instanceof Boolean) {
                    if (!((Boolean) c0196a.c()).booleanValue()) {
                        if ((this.a.f3465f & 128) <= 0) {
                            this.a.f3465f &= -5;
                            this.a.f3465f |= 64;
                        }
                    } else {
                        n0 n0Var = this.a;
                        n0Var.f3465f = n0Var.f3466g;
                    }
                    this.a.f3467h.setShowFlag(this.a.f3465f);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3465f = 11;
        this.f3466g = 11;
        if ((TbadkCoreApplication.getInst().getPersonalizeViewData().r instanceof ThreadCardBottomOpSegmentLayout) && TbadkCoreApplication.getInst().getPersonalizeViewData().r.getParent() == null) {
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = (ThreadCommentAndPraiseInfoLayout) TbadkCoreApplication.getInst().getPersonalizeViewData().r;
            this.f3467h = threadCommentAndPraiseInfoLayout;
            threadCommentAndPraiseInfoLayout.setContext(context);
        } else {
            this.f3467h = new ThreadCardBottomOpSegmentLayout(context);
        }
        this.f3467h.setReplyTimeVisible(false);
        this.f3467h.setShowPraiseNum(true);
        this.f3467h.setNeedAddPraiseIcon(true);
        this.f3467h.setNeedAddReplyIcon(true);
        this.f3467h.setShareVisible(true);
        this.f3467h.setForumAfterClickListener(new a(this));
    }

    public void A(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.f3467h.setShareReportFrom(i);
        }
    }

    public void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f3467h.setStType(str);
        }
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f3467h.setTabName(str);
        }
    }

    @Override // c.a.l.a
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            int i2 = i | this.f3465f;
            this.f3465f = i2;
            this.f3467h.setShowFlag(i2);
            this.f3466g = this.f3465f;
        }
    }

    @Override // c.a.l.a
    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            int i2 = (~i) & this.f3465f;
            this.f3465f = i2;
            this.f3467h.setShowFlag(i2);
            this.f3466g = this.f3465f;
        }
    }

    @Override // c.a.l.a
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f3467h : (View) invokeV.objValue;
    }

    @Override // c.a.l.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.m(4, new b(this));
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbPageContext, i) == null) {
            this.f3467h.onChangeSkinType();
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            boolean z = false;
            k(this.f3467h, 0);
            c.a.l.a g2 = this.a.g();
            if (g2 == null) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) g2.g();
            int childCount = viewGroup.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    z = true;
                    break;
                } else if (!(viewGroup.getChildAt(i) instanceof TextView) && viewGroup.getChildAt(i).getVisibility() == 0) {
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                List<h> h2 = this.a.h();
                if (ListUtils.isEmpty(h2)) {
                    return;
                }
                for (h hVar : h2) {
                    if (hVar != null && hVar.g() != null && hVar.g().getVisibility() == 0) {
                        return;
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: u */
    public void a(c.a.o0.r.r.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.i = aVar;
            this.f3467h.setData(aVar.getThreadData());
            t();
        }
    }

    public void v(c.a.o0.r.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) {
            this.f3467h.setAgreeStatisticData(fVar);
        }
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.f3467h.setFrom(i);
        }
    }

    public void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.f3467h.N = i;
        }
    }

    public void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.f3467h.setGameId(i);
        }
    }

    public void z(ThreadCommentAndPraiseInfoLayout.i iVar) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, iVar) == null) || (threadCommentAndPraiseInfoLayout = this.f3467h) == null) {
            return;
        }
        threadCommentAndPraiseInfoLayout.setOnCommentClickCallback(iVar);
    }
}
