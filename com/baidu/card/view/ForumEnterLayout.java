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
import c.a.e.e.p.l;
import c.a.o0.b.d;
import c.a.o0.s.q.c2;
import c.a.o0.s.u.c;
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
/* loaded from: classes5.dex */
public class ForumEnterLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f38427e;

    /* renamed from: f  reason: collision with root package name */
    public ThreadForumEnterButton f38428f;

    /* renamed from: g  reason: collision with root package name */
    public ThreadForumEnterGoodsButton f38429g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f38430h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f38431i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.o0.s.q.a f38432j;
    public Drawable k;
    public final int l;
    public final int m;
    public int n;
    public int o;
    public View.OnClickListener p;
    public final View.OnClickListener q;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumEnterLayout f38433e;

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
            this.f38433e = forumEnterLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f38433e.f38430h) {
                    ThreadCardUtils.jumpToPBCommentArea(this.f38433e.f38432j, view.getContext(), this.f38433e.o, 2);
                } else if (view == this.f38433e.f38428f && this.f38433e.p != null) {
                    this.f38433e.p.onClick(view);
                }
                if (this.f38433e.f38432j != null) {
                    ForumEnterLayout forumEnterLayout = this.f38433e;
                    forumEnterLayout.g(view, forumEnterLayout.f38432j.getThreadData());
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
            int k = (l.k(this.f38427e) - (this.l * 2)) - this.m;
            if (k > 0) {
                this.n = k / 2;
            } else {
                this.n = l.g(this.f38427e, R.dimen.tbds540);
            }
            this.f38430h.setMaxWidth(this.n);
        }
    }

    public final void g(View view, c2 c2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, c2Var) == null) || c2Var == null) {
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
        TiebaStatic.log(c.a.p0.h3.a.n(str, c2Var, i2));
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.f38427e = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_item, (ViewGroup) this, true);
            TextView textView = (TextView) inflate.findViewById(R.id.text_post);
            this.f38430h = textView;
            textView.setCompoundDrawablePadding(l.g(context, R.dimen.tbds10));
            this.f38428f = (ThreadForumEnterButton) inflate.findViewById(R.id.forum_enter_button);
            this.f38429g = (ThreadForumEnterGoodsButton) inflate.findViewById(R.id.forum_enter_goods_button);
            this.f38428f.setAfterClickListener(this.q);
            this.f38429g.setAfterClickListener(this.q);
            this.f38430h.setOnClickListener(this.q);
            this.f38431i = (EMTextView) inflate.findViewById(R.id.tv_ueg);
        }
    }

    public final boolean i(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, c2Var)) == null) ? (c2Var == null || c2Var.J() == null || !c2Var.Y1 || !d.i() || c2Var.J().hadConcerned() || ThreadCardUtils.isSelf(c2Var)) ? false : true : invokeL.booleanValue;
    }

    public final boolean j(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, c2Var)) == null) ? c2Var != null && c2Var.X1 && c2Var.E2() : invokeL.booleanValue;
    }

    public final boolean k(c.a.o0.s.q.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) ? (aVar == null || aVar.getThreadData() == null || !aVar.getThreadData().A2() || aVar.getThreadData().o1() == null) ? false : true : invokeL.booleanValue;
    }

    public final boolean l(c.a.o0.s.q.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, aVar)) == null) ? (aVar == null || aVar.getThreadData() == null || aVar.getThreadData().G0() == null || aVar.getThreadData().G0().getOptions() == null || aVar.getThreadData().G0().getOptions().size() <= 0) ? false : true : invokeL.booleanValue;
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i2) == null) {
            this.f38428f.onChangeSkinType();
            this.f38429g.onChangeSkinType();
            this.k = getArrowRight();
            c d2 = c.d(this.f38431i);
            d2.t(R.color.CAM_X0109);
            d2.y(R.string.F_X01);
        }
    }

    public void setData(c.a.o0.s.q.a aVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f38432j = aVar;
            adjustBtnMaxWidth();
            c2 threadData = aVar.getThreadData();
            if (!j(threadData) && ((aVar.showCardEnterFourm() || !threadData.X1) && !StringUtils.isNull(threadData.Z()) && !i(threadData))) {
                this.f38428f.setVisibility(0);
                this.f38428f.bindData(threadData, this.n);
                z = true;
            } else {
                this.f38428f.setVisibility(8);
                z = false;
            }
            if (!l(aVar) && !k(aVar) && aVar.showCardGoodsFourm() && aVar.getThreadData().X1()) {
                this.f38429g.setVisibility(0);
                this.f38429g.bindData(threadData);
                z = true;
            } else {
                this.f38429g.setVisibility(8);
            }
            if (ThreadCardUtils.isSelf(threadData) && threadData.g2) {
                this.f38430h.setVisibility(0);
                this.f38430h.setTextSize(0, l.g(getContext(), R.dimen.tbds32));
                this.f38430h.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.f38430h, R.color.CAM_X0109);
                this.f38430h.setText(R.string.private_desc);
                this.f38430h.setOnClickListener(null);
                z = true;
            } else {
                this.f38430h.setVisibility(8);
            }
            int visibility = this.f38430h.getVisibility();
            if (threadData.I2 == 1 && threadData.b2) {
                this.f38431i.setVisibility(0);
                this.f38430h.setVisibility(8);
            } else {
                this.f38431i.setVisibility(8);
                this.f38430h.setVisibility(visibility);
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
        this.l = l.g(TbadkApplication.getInst(), R.dimen.tbds44);
        this.m = l.g(TbadkApplication.getInst(), R.dimen.tbds60);
        this.o = 0;
        this.q = new a(this);
        h(context);
    }
}
