package com.baidu.card.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.s0.b.d;
import c.a.s0.s.q.e2;
import c.a.s0.s.u.c;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tbadk.core.view.ThreadForumEnterGoodsButton;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class ForumEnterLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f33141e;

    /* renamed from: f  reason: collision with root package name */
    public ThreadForumEnterButton f33142f;

    /* renamed from: g  reason: collision with root package name */
    public ThreadForumEnterGoodsButton f33143g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f33144h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f33145i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.s0.s.q.a f33146j;
    public Drawable k;
    public final int l;
    public final int m;
    public int n;
    public int o;
    public View.OnClickListener p;
    public final View.OnClickListener q;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumEnterLayout f33147e;

        public a(ForumEnterLayout forumEnterLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEnterLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33147e = forumEnterLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f33147e.f33144h) {
                    ThreadCardUtils.jumpToPBCommentArea(this.f33147e.f33146j, view.getContext(), this.f33147e.o, 2);
                } else if (view == this.f33147e.f33142f && this.f33147e.p != null) {
                    this.f33147e.p.onClick(view);
                }
                if (this.f33147e.f33146j != null) {
                    ForumEnterLayout forumEnterLayout = this.f33147e;
                    forumEnterLayout.g(view, forumEnterLayout.f33146j.getThreadData());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumEnterLayout(Context context) {
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
        this.l = n.f(TbadkApplication.getInst(), R.dimen.tbds44);
        this.m = n.f(TbadkApplication.getInst(), R.dimen.tbds60);
        this.o = 0;
        this.q = new a(this);
        h(context);
    }

    private Drawable getArrowRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            Drawable drawable = this.k;
            if (drawable == null || drawable.mutate() == null) {
                WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            return this.k;
        }
        return (Drawable) invokeV.objValue;
    }

    public void adjustBtnMaxWidth() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int k = (n.k(this.f33141e) - (this.l * 2)) - this.m;
            if (k > 0) {
                this.n = k / 2;
            } else {
                this.n = n.f(this.f33141e, R.dimen.tbds540);
            }
            this.f33144h.setMaxWidth(this.n);
        }
    }

    public final void g(View view, e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, e2Var) == null) || e2Var == null) {
            return;
        }
        int id = view.getId();
        String str = null;
        if (id == R.id.forum_enter_button) {
            str = "c13693";
        } else if (id == R.id.text_post) {
            str = "c13695";
        }
        int i2 = 0;
        int i3 = this.o;
        if (i3 == 1) {
            i2 = 2;
        } else if (i3 == 2) {
            i2 = 1;
        } else if (i3 == 4) {
            i2 = 3;
        }
        if (str == null || i2 <= 0) {
            return;
        }
        TiebaStatic.log(c.a.t0.v3.a.n(str, e2Var, i2));
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.f33141e = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_item, (ViewGroup) this, true);
            TextView textView = (TextView) inflate.findViewById(R.id.text_post);
            this.f33144h = textView;
            textView.setCompoundDrawablePadding(n.f(context, R.dimen.tbds10));
            this.f33142f = (ThreadForumEnterButton) inflate.findViewById(R.id.forum_enter_button);
            this.f33143g = (ThreadForumEnterGoodsButton) inflate.findViewById(R.id.forum_enter_goods_button);
            this.f33142f.setAfterClickListener(this.q);
            this.f33143g.setAfterClickListener(this.q);
            this.f33144h.setOnClickListener(this.q);
            this.f33145i = (EMTextView) inflate.findViewById(R.id.tv_ueg);
        }
    }

    public final boolean i(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, e2Var)) == null) ? (e2Var == null || e2Var.J() == null || !e2Var.b2 || !d.i() || e2Var.J().hadConcerned() || ThreadCardUtils.isSelf(e2Var)) ? false : true : invokeL.booleanValue;
    }

    public final boolean j(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, e2Var)) == null) ? e2Var != null && e2Var.a2 && e2Var.M2() : invokeL.booleanValue;
    }

    public final boolean k(c.a.s0.s.q.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) ? (aVar == null || aVar.getThreadData() == null || !aVar.getThreadData().H2() || aVar.getThreadData().t1() == null) ? false : true : invokeL.booleanValue;
    }

    public final boolean l(c.a.s0.s.q.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, aVar)) == null) ? (aVar == null || aVar.getThreadData() == null || aVar.getThreadData().J0() == null || aVar.getThreadData().J0().getOptions() == null || aVar.getThreadData().J0().getOptions().size() <= 0) ? false : true : invokeL.booleanValue;
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i2) == null) {
            this.f33142f.onChangeSkinType();
            this.f33143g.onChangeSkinType();
            this.k = getArrowRight();
            c d2 = c.d(this.f33145i);
            d2.v(R.color.CAM_X0109);
            d2.A(R.string.F_X01);
        }
    }

    public void setData(c.a.s0.s.q.a aVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f33146j = aVar;
            adjustBtnMaxWidth();
            e2 threadData = aVar.getThreadData();
            if (!j(threadData) && ((aVar.showCardEnterFourm() || !threadData.a2) && !StringUtils.isNull(threadData.a0()) && !i(threadData))) {
                this.f33142f.setVisibility(0);
                this.f33142f.bindData(threadData, this.n);
                z = true;
            } else {
                this.f33142f.setVisibility(8);
                z = false;
            }
            if (!l(aVar) && !k(aVar) && aVar.showCardGoodsFourm() && aVar.getThreadData().d2()) {
                this.f33143g.setVisibility(0);
                this.f33143g.bindData(threadData);
                z = true;
            } else {
                this.f33143g.setVisibility(8);
            }
            if (ThreadCardUtils.isSelf(threadData) && threadData.l2) {
                this.f33144h.setVisibility(0);
                this.f33144h.setTextSize(0, n.f(getContext(), R.dimen.tbds32));
                this.f33144h.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.f33144h, R.color.CAM_X0109);
                this.f33144h.setText(R.string.private_desc);
                this.f33144h.setOnClickListener(null);
                z = true;
            } else {
                this.f33144h.setVisibility(8);
            }
            int visibility = this.f33144h.getVisibility();
            if (threadData.N2 == 1 && threadData.e2) {
                this.f33145i.setVisibility(0);
                this.f33144h.setVisibility(8);
            } else {
                this.f33145i.setVisibility(8);
                this.f33144h.setVisibility(visibility);
            }
            setVisibility(z ? 0 : 8);
        }
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) {
            this.p = onClickListener;
        }
    }

    public void setSourceForPb(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.o = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumEnterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = n.f(TbadkApplication.getInst(), R.dimen.tbds44);
        this.m = n.f(TbadkApplication.getInst(), R.dimen.tbds60);
        this.o = 0;
        this.q = new a(this);
        h(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumEnterLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.l = n.f(TbadkApplication.getInst(), R.dimen.tbds44);
        this.m = n.f(TbadkApplication.getInst(), R.dimen.tbds60);
        this.o = 0;
        this.q = new a(this);
        h(context);
    }
}
