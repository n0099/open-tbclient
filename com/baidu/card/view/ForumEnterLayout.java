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
import c.a.o0.r.v.c;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes3.dex */
public class ForumEnterLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public ThreadForumEnterButton f25061b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadForumEnterGoodsButton f25062c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f25063d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f25064e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.o0.r.r.a f25065f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f25066g;

    /* renamed from: h  reason: collision with root package name */
    public final int f25067h;
    public final int i;
    public int j;
    public int k;
    public View.OnClickListener l;
    public final View.OnClickListener m;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumEnterLayout a;

        public a(ForumEnterLayout forumEnterLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEnterLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumEnterLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.a.f25063d) {
                    ThreadCardUtils.jumpToPBCommentArea(this.a.f25065f, view.getContext(), this.a.k, 2);
                } else if (view == this.a.f25061b && this.a.l != null) {
                    this.a.l.onClick(view);
                }
                if (this.a.f25065f != null) {
                    ForumEnterLayout forumEnterLayout = this.a;
                    forumEnterLayout.h(view, forumEnterLayout.f25065f.getThreadData());
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25067h = n.f(TbadkApplication.getInst(), R.dimen.tbds44);
        this.i = n.f(TbadkApplication.getInst(), R.dimen.tbds60);
        this.k = 0;
        this.m = new a(this);
        i(context);
    }

    private Drawable getArrowRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            Drawable drawable = this.f25066g;
            if (drawable == null || drawable.mutate() == null) {
                WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            return this.f25066g;
        }
        return (Drawable) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int k = (n.k(this.a) - (this.f25067h * 2)) - this.i;
            if (k > 0) {
                this.j = k / 2;
            } else {
                this.j = n.f(this.a, R.dimen.tbds540);
            }
            this.f25063d.setMaxWidth(this.j);
        }
    }

    public final void h(View view, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, threadData) == null) || threadData == null) {
            return;
        }
        int id = view.getId();
        String str = null;
        if (id == R.id.obfuscated_res_0x7f090a39) {
            str = "c13693";
        } else if (id == R.id.obfuscated_res_0x7f091f48) {
            str = "c13695";
        }
        int i = 0;
        int i2 = this.k;
        if (i2 == 1) {
            i = 2;
        } else if (i2 == 2) {
            i = 1;
        } else if (i2 == 4) {
            i = 3;
        }
        if (str == null || i <= 0) {
            return;
        }
        TiebaStatic.log(c.a.p0.z3.a.n(str, threadData, i));
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.a = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d019c, (ViewGroup) this, true);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091f48);
            this.f25063d = textView;
            textView.setCompoundDrawablePadding(n.f(context, R.dimen.tbds10));
            this.f25061b = (ThreadForumEnterButton) inflate.findViewById(R.id.obfuscated_res_0x7f090a39);
            this.f25062c = (ThreadForumEnterGoodsButton) inflate.findViewById(R.id.obfuscated_res_0x7f090a3d);
            this.f25061b.setAfterClickListener(this.m);
            this.f25062c.setAfterClickListener(this.m);
            this.f25063d.setOnClickListener(this.m);
            this.f25064e = (EMTextView) inflate.findViewById(R.id.obfuscated_res_0x7f092225);
        }
    }

    public final boolean j(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, threadData)) == null) ? (threadData == null || threadData.getAuthor() == null || !threadData.isFromConcern || !UbsABTestHelper.isConcernForumCardShow() || threadData.getAuthor().hadConcerned() || ThreadCardUtils.isSelf(threadData)) ? false : true : invokeL.booleanValue;
    }

    public final boolean k(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, threadData)) == null) ? threadData != null && threadData.isFromHomPage && threadData.isWorksInfo() : invokeL.booleanValue;
    }

    public final boolean l(c.a.o0.r.r.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) ? (aVar == null || aVar.getThreadData() == null || !aVar.getThreadData().isVideoThreadType() || aVar.getThreadData().getThreadVideoInfo() == null) ? false : true : invokeL.booleanValue;
    }

    public final boolean m(c.a.o0.r.r.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, aVar)) == null) ? (aVar == null || aVar.getThreadData() == null || aVar.getThreadData().getPollData() == null || aVar.getThreadData().getPollData().getOptions() == null || aVar.getThreadData().getPollData().getOptions().size() <= 0) ? false : true : invokeL.booleanValue;
    }

    public void n(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i) == null) {
            this.f25061b.e();
            this.f25062c.e();
            this.f25066g = getArrowRight();
            c d2 = c.d(this.f25064e);
            d2.v(R.color.CAM_X0109);
            d2.A(R.string.F_X01);
        }
    }

    public void setData(c.a.o0.r.r.a aVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f25065f = aVar;
            g();
            ThreadData threadData = aVar.getThreadData();
            if (!k(threadData) && ((aVar.showCardEnterFourm() || !threadData.isFromHomPage) && !StringUtils.isNull(threadData.getForum_name()) && !j(threadData))) {
                this.f25061b.setVisibility(0);
                this.f25061b.b(threadData, this.j);
                z = true;
            } else {
                this.f25061b.setVisibility(8);
                z = false;
            }
            if (!m(aVar) && !l(aVar) && aVar.showCardGoodsFourm() && aVar.getThreadData().isGoods()) {
                this.f25062c.setVisibility(0);
                this.f25062c.a(threadData);
                z = true;
            } else {
                this.f25062c.setVisibility(8);
            }
            if (ThreadCardUtils.isSelf(threadData) && threadData.isPrivacy) {
                this.f25063d.setVisibility(0);
                this.f25063d.setTextSize(0, n.f(getContext(), R.dimen.tbds32));
                this.f25063d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.f25063d, (int) R.color.CAM_X0109);
                this.f25063d.setText(R.string.obfuscated_res_0x7f0f0ecb);
                this.f25063d.setOnClickListener(null);
                z = true;
            } else {
                this.f25063d.setVisibility(8);
            }
            int visibility = this.f25063d.getVisibility();
            if (threadData.isAuthorView == 1 && threadData.isFromPersonPolymeric) {
                this.f25064e.setVisibility(0);
                this.f25063d.setVisibility(8);
            } else {
                this.f25064e.setVisibility(8);
                this.f25063d.setVisibility(visibility);
            }
            setVisibility(z ? 0 : 8);
        }
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) {
            this.l = onClickListener;
        }
    }

    public void setSourceForPb(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.k = i;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f25067h = n.f(TbadkApplication.getInst(), R.dimen.tbds44);
        this.i = n.f(TbadkApplication.getInst(), R.dimen.tbds60);
        this.k = 0;
        this.m = new a(this);
        i(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumEnterLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f25067h = n.f(TbadkApplication.getInst(), R.dimen.tbds44);
        this.i = n.f(TbadkApplication.getInst(), R.dimen.tbds60);
        this.k = 0;
        this.m = new a(this);
        i(context);
    }
}
