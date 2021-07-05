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
import d.a.c.e.p.l;
import d.a.r0.b.d;
import d.a.r0.r.q.b2;
import d.a.r0.r.u.c;
/* loaded from: classes3.dex */
public class ForumEnterLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f4427e;

    /* renamed from: f  reason: collision with root package name */
    public ThreadForumEnterButton f4428f;

    /* renamed from: g  reason: collision with root package name */
    public ThreadForumEnterGoodsButton f4429g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f4430h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f4431i;
    public d.a.r0.r.q.a j;
    public Drawable k;
    public final int l;
    public final int m;
    public int n;
    public int o;
    public View.OnClickListener p;
    public final View.OnClickListener q;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumEnterLayout f4432e;

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
            this.f4432e = forumEnterLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f4432e.f4430h) {
                    ThreadCardUtils.jumpToPBCommentArea(this.f4432e.j, view.getContext(), this.f4432e.o, 2);
                } else if (view == this.f4432e.f4428f && this.f4432e.p != null) {
                    this.f4432e.p.onClick(view);
                }
                if (this.f4432e.j != null) {
                    ForumEnterLayout forumEnterLayout = this.f4432e;
                    forumEnterLayout.h(view, forumEnterLayout.j.getThreadData());
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
        this.l = l.g(TbadkApplication.getInst(), R.dimen.tbds44);
        this.m = l.g(TbadkApplication.getInst(), R.dimen.tbds60);
        this.o = 0;
        this.q = new a(this);
        i(context);
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

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int k = (l.k(this.f4427e) - (this.l * 2)) - this.m;
            if (k > 0) {
                this.n = k / 2;
            } else {
                this.n = l.g(this.f4427e, R.dimen.tbds540);
            }
            this.f4430h.setMaxWidth(this.n);
        }
    }

    public final void h(View view, b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, b2Var) == null) || b2Var == null) {
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
        TiebaStatic.log(d.a.s0.g3.a.n(str, b2Var, i2));
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.f4427e = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_item, (ViewGroup) this, true);
            TextView textView = (TextView) inflate.findViewById(R.id.text_post);
            this.f4430h = textView;
            textView.setCompoundDrawablePadding(l.g(context, R.dimen.tbds10));
            this.f4428f = (ThreadForumEnterButton) inflate.findViewById(R.id.forum_enter_button);
            this.f4429g = (ThreadForumEnterGoodsButton) inflate.findViewById(R.id.forum_enter_goods_button);
            this.f4428f.setAfterClickListener(this.q);
            this.f4429g.setAfterClickListener(this.q);
            this.f4430h.setOnClickListener(this.q);
            this.f4431i = (EMTextView) inflate.findViewById(R.id.tv_ueg);
        }
    }

    public final boolean j(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, b2Var)) == null) ? (b2Var == null || b2Var.H() == null || !b2Var.X1 || !d.h() || b2Var.H().hadConcerned() || ThreadCardUtils.isSelf(b2Var)) ? false : true : invokeL.booleanValue;
    }

    public final boolean k(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, b2Var)) == null) ? b2Var != null && b2Var.W1 && b2Var.u2() : invokeL.booleanValue;
    }

    public final boolean l(d.a.r0.r.q.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) ? (aVar == null || aVar.getThreadData() == null || !aVar.getThreadData().q2() || aVar.getThreadData().l1() == null) ? false : true : invokeL.booleanValue;
    }

    public final boolean m(d.a.r0.r.q.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, aVar)) == null) ? (aVar == null || aVar.getThreadData() == null || aVar.getThreadData().D0() == null || aVar.getThreadData().D0().getOptions() == null || aVar.getThreadData().D0().getOptions().size() <= 0) ? false : true : invokeL.booleanValue;
    }

    public void n(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i2) == null) {
            this.f4428f.d();
            this.f4429g.e();
            this.k = getArrowRight();
            c d2 = c.d(this.f4431i);
            d2.t(R.color.CAM_X0109);
            d2.y(R.string.F_X01);
        }
    }

    public void setData(d.a.r0.r.q.a aVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.j = aVar;
            g();
            b2 threadData = aVar.getThreadData();
            if (!k(threadData) && ((aVar.showCardEnterFourm() || !threadData.W1) && !StringUtils.isNull(threadData.W()) && !j(threadData))) {
                this.f4428f.setVisibility(0);
                this.f4428f.b(threadData, this.n);
                z = true;
            } else {
                this.f4428f.setVisibility(8);
                z = false;
            }
            if (!m(aVar) && !l(aVar) && aVar.showCardGoodsFourm() && aVar.getThreadData().R1()) {
                this.f4429g.setVisibility(0);
                this.f4429g.a(threadData);
                z = true;
            } else {
                this.f4429g.setVisibility(8);
            }
            if (ThreadCardUtils.isSelf(threadData) && threadData.f2) {
                this.f4430h.setVisibility(0);
                this.f4430h.setTextSize(0, l.g(getContext(), R.dimen.tbds32));
                this.f4430h.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.f4430h, R.color.CAM_X0109);
                this.f4430h.setText(R.string.private_desc);
                this.f4430h.setOnClickListener(null);
                z = true;
            } else {
                this.f4430h.setVisibility(8);
            }
            int visibility = this.f4430h.getVisibility();
            if (threadData.H2 == 1 && threadData.a2) {
                this.f4431i.setVisibility(0);
                this.f4430h.setVisibility(8);
            } else {
                this.f4431i.setVisibility(8);
                this.f4430h.setVisibility(visibility);
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
        this.l = l.g(TbadkApplication.getInst(), R.dimen.tbds44);
        this.m = l.g(TbadkApplication.getInst(), R.dimen.tbds60);
        this.o = 0;
        this.q = new a(this);
        i(context);
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
        this.l = l.g(TbadkApplication.getInst(), R.dimen.tbds44);
        this.m = l.g(TbadkApplication.getInst(), R.dimen.tbds60);
        this.o = 0;
        this.q = new a(this);
        i(context);
    }
}
