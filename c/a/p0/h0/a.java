package c.a.p0.h0;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.r.a;
import c.a.o0.r.r.v0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.FollowUserDecorView;
import com.baidu.card.view.ForumEnterLayout;
import com.baidu.card.view.UnfollowedDecorView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class a<T extends c.a.o0.r.r.a> extends b<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> i;
    public BdUniqueId j;
    public T k;
    public ThreadCommentAndPraiseInfoLayout l;
    public ThreadCommentAndPraiseInfoLayout m;
    public NEGFeedBackView n;
    public UnfollowedDecorView o;
    public FollowUserDecorView p;
    public ForumEnterLayout q;
    public boolean r;
    public boolean s;
    public boolean t;
    public View u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = null;
        this.o = null;
        this.r = false;
        this.s = false;
        this.t = false;
    }

    public void A(View view, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048576, this, view, i) == null) && view != null && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void B(NEGFeedBackView.b bVar) {
        NEGFeedBackView nEGFeedBackView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || (nEGFeedBackView = this.n) == null) {
            return;
        }
        nEGFeedBackView.setEventCallback(bVar);
    }

    public void C(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.f15310h = i;
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.l;
            if (threadCommentAndPraiseInfoLayout != null) {
                threadCommentAndPraiseInfoLayout.N = i;
            }
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout2 = this.m;
            if (threadCommentAndPraiseInfoLayout2 != null) {
                threadCommentAndPraiseInfoLayout2.N = i;
            }
        }
    }

    public void D(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, viewGroup) == null) {
            G(viewGroup, H(viewGroup));
            I(viewGroup);
            F();
            if (u()) {
                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.l;
                if (threadCommentAndPraiseInfoLayout != null) {
                    threadCommentAndPraiseInfoLayout.setVisibility(8);
                }
                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout2 = this.m;
                if (threadCommentAndPraiseInfoLayout2 != null) {
                    threadCommentAndPraiseInfoLayout2.setVisibility(8);
                }
                View view = this.u;
                if (view != null) {
                    view.setVisibility(0);
                }
            } else {
                E();
            }
            q();
        }
    }

    public void E() {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (t = this.k) == null || t.getThreadData() == null) {
            return;
        }
        ThreadData threadData = this.k.getThreadData();
        this.l.setVisibility(8);
        this.m.setData(threadData);
    }

    public final void F() {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (t = this.k) == null || t.getThreadData() == null || this.q == null) {
            return;
        }
        if (this.k.showCardEnterFourm()) {
            this.q.setData(this.k.getThreadData());
        } else if (this.r) {
            this.q.setData(this.k.getThreadData());
        }
    }

    public final void G(ViewGroup viewGroup, boolean z) {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048582, this, viewGroup, z) == null) || (t = this.k) == null || t.getThreadData() == null) {
            return;
        }
        if (this.p == null) {
            FollowUserDecorView followUserDecorView = new FollowUserDecorView(this.i.getPageActivity());
            this.p = followUserDecorView;
            followUserDecorView.setIsShowIcon(this.s);
            viewGroup.addView(this.p);
        }
        if (v()) {
            this.p.setPageUniqueId(this.j);
            this.p.setSvgIconResId(0);
            int s = s(R.dimen.tbds166);
            int s2 = s(R.dimen.tbds78);
            int i = R.dimen.tbds44;
            int s3 = s(z ? R.dimen.tbds104 : R.dimen.tbds44);
            int s4 = s(R.dimen.tbds50);
            if (UbsABTestHelper.showNewUI()) {
                s = s(R.dimen.tbds177);
                s2 = s(R.dimen.tbds76);
                if (z) {
                    i = R.dimen.tbds126;
                }
                s3 = s(i);
                s4 = s(R.dimen.tbds52);
                this.p.setUseNewStyle(true);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(s, s2);
            layoutParams.topMargin = s4;
            layoutParams.rightMargin = s3;
            layoutParams.gravity = 53;
            this.p.setLayoutParams(layoutParams);
            this.p.setData(this.k.getThreadData());
            return;
        }
        FollowUserDecorView followUserDecorView2 = this.p;
        if (followUserDecorView2 != null) {
            followUserDecorView2.setVisibility(8);
        }
    }

    public final boolean H(ViewGroup viewGroup) {
        InterceptResult invokeL;
        SparseArray<String> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            T t = this.k;
            if (t == null || t.getThreadData() == null) {
                return false;
            }
            if (this.k.getThreadData() != null && (sparseArray = this.k.feedBackReasonMap) != null && sparseArray.size() > 0) {
                if (this.n == null) {
                    NEGFeedBackView nEGFeedBackView = new NEGFeedBackView(j());
                    this.n = nEGFeedBackView;
                    viewGroup.addView(nEGFeedBackView);
                }
                this.n.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                int f2 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds90);
                int f3 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int f4 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int f5 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f2, f2);
                layoutParams.rightMargin = f4;
                layoutParams.topMargin = f5;
                layoutParams.gravity = 53;
                this.n.setPadding(f3, f3, f3, f3);
                this.n.setLayoutParams(layoutParams);
                v0 v0Var = new v0();
                v0Var.o(this.k.getThreadData().getTid());
                v0Var.k(this.k.getThreadData().getFid());
                v0Var.n(this.k.getThreadData().getNid());
                v0Var.j(this.k.feedBackReasonMap);
                this.n.setVisibility(0);
                this.n.setData(v0Var);
                this.n.setFirstRowSingleColumn(true);
                return true;
            }
            NEGFeedBackView nEGFeedBackView2 = this.n;
            if (nEGFeedBackView2 != null) {
                nEGFeedBackView2.setVisibility(8);
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void I(ViewGroup viewGroup) {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup) == null) || (t = this.k) == null || t.getThreadData() == null) {
            return;
        }
        if (this.o == null) {
            UnfollowedDecorView unfollowedDecorView = new UnfollowedDecorView(this.i.getPageActivity());
            this.o = unfollowedDecorView;
            viewGroup.addView(unfollowedDecorView);
        }
        if (this.k.getThreadData().isFromConcern && !ThreadCardUtils.isSelf(this.k.getThreadData())) {
            this.o.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            int f2 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds90);
            int f3 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int f4 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int f5 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f2, f2);
            layoutParams.rightMargin = f4;
            layoutParams.topMargin = f5;
            layoutParams.gravity = 53;
            this.o.setPadding(f3, f3, f3, f3);
            this.o.setLayoutParams(layoutParams);
            this.o.setVisibility(0);
            this.o.f(this.k.getThreadData());
            return;
        }
        UnfollowedDecorView unfollowedDecorView2 = this.o;
        if (unfollowedDecorView2 != null) {
            unfollowedDecorView2.setVisibility(8);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ForumEnterLayout forumEnterLayout = this.q;
            if ((forumEnterLayout == null || forumEnterLayout.getVisibility() != 0) && !UbsABTestHelper.showNewUI()) {
                A(this.l, s(R.dimen.tbds20));
                A(this.m, s(R.dimen.tbds20));
                return;
            }
            A(this.l, 0);
            A(this.m, 0);
        }
    }

    public int s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) ? c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), i) : invokeI.intValue;
    }

    public void t(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, threadCommentAndPraiseInfoLayout) == null) || threadCommentAndPraiseInfoLayout == null) {
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
        c.a.o0.r.r.f fVar = new c.a.o0.r.r.f();
        fVar.f10852b = 7;
        fVar.f10858h = 1;
        threadCommentAndPraiseInfoLayout.setAgreeStatisticData(fVar);
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public final boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            T t = this.k;
            if (t == null || t.getThreadData() == null || this.k.getThreadData().getAuthor() == null) {
                return false;
            }
            ThreadData threadData = this.k.getThreadData();
            if (ThreadCardUtils.isSelf(threadData)) {
                return false;
            }
            boolean z = threadData.isBjhDynamicThread() || threadData.isBJHArticleThreadType() || threadData.isBJHVideoThreadType();
            if ((!z || !threadData.isFromHomPage) && (!z || !threadData.isFromVideoTab || threadData.getAuthor().hadConcerned())) {
                if (threadData.getThreadAlaInfo() == null || !c.a.p0.h0.e0.j.W(threadData)) {
                    return false;
                }
                if (!threadData.isFromHomPage && !threadData.isFromFeedTab) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void w(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, tbPageContext, i) == null) {
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.l;
            if (threadCommentAndPraiseInfoLayout != null) {
                threadCommentAndPraiseInfoLayout.onChangeSkinType();
            }
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout2 = this.m;
            if (threadCommentAndPraiseInfoLayout2 != null) {
                threadCommentAndPraiseInfoLayout2.onChangeSkinType();
            }
            NEGFeedBackView nEGFeedBackView = this.n;
            if (nEGFeedBackView != null) {
                nEGFeedBackView.q();
            }
            UnfollowedDecorView unfollowedDecorView = this.o;
            if (unfollowedDecorView != null) {
                unfollowedDecorView.k();
            }
            ForumEnterLayout forumEnterLayout = this.q;
            if (forumEnterLayout != null) {
                forumEnterLayout.n(tbPageContext, i);
            }
            FollowUserDecorView followUserDecorView = this.p;
            if (followUserDecorView != null) {
                followUserDecorView.r(i);
            }
        }
    }

    public void x(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        o(bdUniqueId);
        NEGFeedBackView nEGFeedBackView = this.n;
        if (nEGFeedBackView != null) {
            nEGFeedBackView.setUniqueId(bdUniqueId);
        }
        FollowUserDecorView followUserDecorView = this.p;
        if (followUserDecorView != null) {
            followUserDecorView.setPageUniqueId(bdUniqueId);
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.t = z;
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.s = z;
        }
    }
}
