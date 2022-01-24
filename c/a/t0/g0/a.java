package c.a.t0.g0;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.q.a;
import c.a.s0.s.q.e2;
import c.a.s0.s.q.x0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.FollowUserDecorView;
import com.baidu.card.view.ForumEnterLayout;
import com.baidu.card.view.UnfollowedDecorView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class a<T extends c.a.s0.s.q.a> extends b<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public BdUniqueId n;
    public T o;
    public ThreadCommentAndPraiseInfoLayout p;
    public ThreadCommentAndPraiseInfoLayout q;
    public NEGFeedBackView r;
    public UnfollowedDecorView s;
    public FollowUserDecorView t;
    public ForumEnterLayout u;
    public boolean v;
    public boolean w;
    public boolean x;
    public View y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = null;
        this.s = null;
        this.v = false;
        this.w = false;
        this.x = false;
    }

    public void A(NEGFeedBackView.b bVar) {
        NEGFeedBackView nEGFeedBackView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || (nEGFeedBackView = this.r) == null) {
            return;
        }
        nEGFeedBackView.setEventCallback(bVar);
    }

    public void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.l = i2;
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.p;
            if (threadCommentAndPraiseInfoLayout != null) {
                threadCommentAndPraiseInfoLayout.sourceFromForPb = i2;
            }
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout2 = this.q;
            if (threadCommentAndPraiseInfoLayout2 != null) {
                threadCommentAndPraiseInfoLayout2.sourceFromForPb = i2;
            }
        }
    }

    public void C(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup) == null) {
            F(viewGroup, G(viewGroup));
            H(viewGroup);
            E();
            if (t()) {
                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.p;
                if (threadCommentAndPraiseInfoLayout != null) {
                    threadCommentAndPraiseInfoLayout.setVisibility(8);
                }
                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout2 = this.q;
                if (threadCommentAndPraiseInfoLayout2 != null) {
                    threadCommentAndPraiseInfoLayout2.setVisibility(8);
                }
                View view = this.y;
                if (view != null) {
                    view.setVisibility(0);
                }
            } else {
                D();
            }
            p();
        }
    }

    public void D() {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (t = this.o) == null || t.getThreadData() == null) {
            return;
        }
        e2 threadData = this.o.getThreadData();
        this.p.setVisibility(8);
        this.q.setData(threadData);
    }

    public final void E() {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (t = this.o) == null || t.getThreadData() == null || this.u == null) {
            return;
        }
        if (this.o.showCardEnterFourm()) {
            this.u.setData(this.o.getThreadData());
        } else if (this.v) {
            this.u.setData(this.o.getThreadData());
        }
    }

    public final void F(ViewGroup viewGroup, boolean z) {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, viewGroup, z) == null) || (t = this.o) == null || t.getThreadData() == null) {
            return;
        }
        if (this.t == null) {
            FollowUserDecorView followUserDecorView = new FollowUserDecorView(this.m.getPageActivity());
            this.t = followUserDecorView;
            followUserDecorView.setIsShowIcon(this.w);
            viewGroup.addView(this.t);
        }
        if (u()) {
            this.t.setPageUniqueId(this.n);
            this.t.setSvgIconResId(0);
            int q = q(R.dimen.tbds166);
            int q2 = q(R.dimen.tbds78);
            int q3 = q(z ? R.dimen.tbds104 : R.dimen.tbds44);
            int q4 = q(R.dimen.tbds50);
            if (c.a.s0.b.d.A0()) {
                q = q(R.dimen.tbds177);
                q2 = q(R.dimen.tbds76);
                q3 = q(z ? R.dimen.tbds126 : R.dimen.tbds44);
                q4 = q(R.dimen.tbds52);
                this.t.setUseNewStyle(true);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(q, q2);
            layoutParams.topMargin = q4;
            layoutParams.rightMargin = q3;
            layoutParams.gravity = 53;
            this.t.setLayoutParams(layoutParams);
            this.t.setData(this.o.getThreadData());
            return;
        }
        FollowUserDecorView followUserDecorView2 = this.t;
        if (followUserDecorView2 != null) {
            followUserDecorView2.setVisibility(8);
        }
    }

    public final boolean G(ViewGroup viewGroup) {
        InterceptResult invokeL;
        SparseArray<String> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            T t = this.o;
            if (t == null || t.getThreadData() == null) {
                return false;
            }
            if (this.o.getThreadData() != null && (sparseArray = this.o.feedBackReasonMap) != null && sparseArray.size() > 0) {
                if (this.r == null) {
                    NEGFeedBackView nEGFeedBackView = new NEGFeedBackView(i());
                    this.r = nEGFeedBackView;
                    viewGroup.addView(nEGFeedBackView);
                }
                this.r.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                int f2 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds90);
                int f3 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int f4 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int f5 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f2, f2);
                layoutParams.rightMargin = f4;
                layoutParams.topMargin = f5;
                layoutParams.gravity = 53;
                this.r.setPadding(f3, f3, f3, f3);
                this.r.setLayoutParams(layoutParams);
                x0 x0Var = new x0();
                x0Var.o(this.o.getThreadData().w1());
                x0Var.k(this.o.getThreadData().U());
                x0Var.n(this.o.getThreadData().H0());
                x0Var.j(this.o.feedBackReasonMap);
                this.r.setVisibility(0);
                this.r.setData(x0Var);
                this.r.setFirstRowSingleColumn(true);
                return true;
            }
            NEGFeedBackView nEGFeedBackView2 = this.r;
            if (nEGFeedBackView2 != null) {
                nEGFeedBackView2.setVisibility(8);
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void H(ViewGroup viewGroup) {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, viewGroup) == null) || (t = this.o) == null || t.getThreadData() == null) {
            return;
        }
        if (this.s == null) {
            UnfollowedDecorView unfollowedDecorView = new UnfollowedDecorView(this.m.getPageActivity());
            this.s = unfollowedDecorView;
            viewGroup.addView(unfollowedDecorView);
        }
        if (this.o.getThreadData().b2 && !ThreadCardUtils.isSelf(this.o.getThreadData())) {
            this.s.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            int f2 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds90);
            int f3 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int f4 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int f5 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f2, f2);
            layoutParams.rightMargin = f4;
            layoutParams.topMargin = f5;
            layoutParams.gravity = 53;
            this.s.setPadding(f3, f3, f3, f3);
            this.s.setLayoutParams(layoutParams);
            this.s.setVisibility(0);
            this.s.bindData(this.o.getThreadData());
            return;
        }
        UnfollowedDecorView unfollowedDecorView2 = this.s;
        if (unfollowedDecorView2 != null) {
            unfollowedDecorView2.setVisibility(8);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ForumEnterLayout forumEnterLayout = this.u;
            if ((forumEnterLayout == null || forumEnterLayout.getVisibility() != 0) && !c.a.s0.b.d.A0()) {
                z(this.p, q(R.dimen.tbds20));
                z(this.q, q(R.dimen.tbds20));
                return;
            }
            z(this.p, 0);
            z(this.q, 0);
        }
    }

    public int q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), i2) : invokeI.intValue;
    }

    public void s(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, threadCommentAndPraiseInfoLayout) == null) || threadCommentAndPraiseInfoLayout == null) {
            return;
        }
        threadCommentAndPraiseInfoLayout.setOnClickListener(this);
        threadCommentAndPraiseInfoLayout.setReplyTimeVisible(false);
        threadCommentAndPraiseInfoLayout.setShowPraiseNum(true);
        threadCommentAndPraiseInfoLayout.setCommentNumEnable(true);
        threadCommentAndPraiseInfoLayout.setNeedAddReplyIcon(true);
        threadCommentAndPraiseInfoLayout.setNeedAddPraiseIcon(true);
        if (threadCommentAndPraiseInfoLayout.getCommentContainer() != null) {
            threadCommentAndPraiseInfoLayout.getCommentContainer().setOnClickListener(this);
        }
        threadCommentAndPraiseInfoLayout.setShareVisible(true);
        threadCommentAndPraiseInfoLayout.setFrom(7);
        threadCommentAndPraiseInfoLayout.setShareReportFrom(3);
        threadCommentAndPraiseInfoLayout.hideDisagree();
        c.a.s0.s.q.f fVar = new c.a.s0.s.q.f();
        fVar.f13557b = 7;
        fVar.f13563h = 1;
        threadCommentAndPraiseInfoLayout.setAgreeStatisticData(fVar);
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.x : invokeV.booleanValue;
    }

    public final boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            T t = this.o;
            if (t == null || t.getThreadData() == null || this.o.getThreadData().J() == null) {
                return false;
            }
            e2 threadData = this.o.getThreadData();
            if (ThreadCardUtils.isSelf(threadData)) {
                return false;
            }
            boolean z = threadData.V1() || threadData.Q1() || threadData.T1();
            if ((!z || !threadData.a2) && (!z || !threadData.c2 || threadData.J().hadConcerned())) {
                if (threadData.p1() == null || !c.a.t0.g0.f0.j.Y(threadData)) {
                    return false;
                }
                if (!threadData.a2 && !threadData.d2) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void v(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, tbPageContext, i2) == null) {
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.p;
            if (threadCommentAndPraiseInfoLayout != null) {
                threadCommentAndPraiseInfoLayout.onChangeSkinType();
            }
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout2 = this.q;
            if (threadCommentAndPraiseInfoLayout2 != null) {
                threadCommentAndPraiseInfoLayout2.onChangeSkinType();
            }
            NEGFeedBackView nEGFeedBackView = this.r;
            if (nEGFeedBackView != null) {
                nEGFeedBackView.onChangeSkinType();
            }
            UnfollowedDecorView unfollowedDecorView = this.s;
            if (unfollowedDecorView != null) {
                unfollowedDecorView.onChangeSkinType();
            }
            ForumEnterLayout forumEnterLayout = this.u;
            if (forumEnterLayout != null) {
                forumEnterLayout.onChangeSkinType(tbPageContext, i2);
            }
            FollowUserDecorView followUserDecorView = this.t;
            if (followUserDecorView != null) {
                followUserDecorView.onChangeSkinType(i2);
            }
        }
    }

    public void w(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        n(bdUniqueId);
        NEGFeedBackView nEGFeedBackView = this.r;
        if (nEGFeedBackView != null) {
            nEGFeedBackView.setUniqueId(bdUniqueId);
        }
        FollowUserDecorView followUserDecorView = this.t;
        if (followUserDecorView != null) {
            followUserDecorView.setPageUniqueId(bdUniqueId);
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.x = z;
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.w = z;
        }
    }

    public void z(View view, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048593, this, view, i2) == null) && view != null && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i2) {
                marginLayoutParams.topMargin = i2;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }
}
