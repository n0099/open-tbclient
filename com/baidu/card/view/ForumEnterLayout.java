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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tbadk.core.view.ThreadForumEnterGoodsButton;
import com.baidu.tieba.R;
import com.baidu.tieba.bw4;
import com.baidu.tieba.upa;
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
    public ThreadForumEnterButton b;
    public ThreadForumEnterGoodsButton c;
    public TextView d;
    public EMTextView e;
    public bw4 f;
    public Drawable g;
    public final int h;
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 == this.a.d) {
                    ThreadCardUtils.jumpToPBCommentArea(this.a.f, view2.getContext(), this.a.k, 2);
                } else if (view2 == this.a.b && this.a.l != null) {
                    this.a.l.onClick(view2);
                }
                if (this.a.f != null) {
                    ForumEnterLayout forumEnterLayout = this.a;
                    forumEnterLayout.h(view2, forumEnterLayout.f.getThreadData());
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
        this.h = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.i = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.k = 0;
        this.m = new a(this);
        i(context);
    }

    public final boolean m(bw4 bw4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bw4Var)) == null) {
            if (bw4Var != null && bw4Var.getThreadData() != null && bw4Var.getThreadData().getPollData() != null && bw4Var.getThreadData().getPollData().getOptions() != null && bw4Var.getThreadData().getPollData().getOptions().size() > 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
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
        this.h = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.i = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
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
        this.h = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
        this.i = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds60);
        this.k = 0;
        this.m = new a(this);
        i(context);
    }

    public final boolean k(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, threadData)) == null) {
            if (threadData != null && threadData.isFromHomPage && threadData.isWorksInfo()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean l(bw4 bw4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bw4Var)) == null) {
            if (bw4Var != null && bw4Var.getThreadData() != null && bw4Var.getThreadData().isVideoThreadType() && bw4Var.getThreadData().getThreadVideoInfo() != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
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

    private Drawable getArrowRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            Drawable drawable = this.g;
            if (drawable == null || drawable.mutate() == null) {
                WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            return this.g;
        }
        return (Drawable) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int equipmentWidth = (BdUtilHelper.getEquipmentWidth(this.a) - (this.h * 2)) - this.i;
            if (equipmentWidth > 0) {
                this.j = equipmentWidth / 2;
            } else {
                this.j = BdUtilHelper.getDimens(this.a, R.dimen.tbds540);
            }
            this.d.setMaxWidth(this.j);
        }
    }

    public final void h(View view2, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) != null) || threadData == null) {
            return;
        }
        int id = view2.getId();
        String str = null;
        if (id == R.id.forum_enter_button) {
            str = "c13693";
        } else if (id == R.id.text_post) {
            str = "c13695";
        }
        int i = 0;
        int i2 = this.k;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 4) {
                    i = 3;
                }
            } else {
                i = 1;
            }
        } else {
            i = 2;
        }
        if (str != null && i > 0) {
            TiebaStatic.log(upa.n(str, threadData, i));
        }
    }

    public void n(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i) == null) {
            this.b.e();
            this.c.e();
            this.g = getArrowRight();
            EMManager.from(this.e).setTextColor(R.color.CAM_X0109).setTextStyle(R.string.F_X01);
        }
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.a = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_item, (ViewGroup) this, true);
            TextView textView = (TextView) inflate.findViewById(R.id.text_post);
            this.d = textView;
            textView.setCompoundDrawablePadding(BdUtilHelper.getDimens(context, R.dimen.tbds10));
            this.b = (ThreadForumEnterButton) inflate.findViewById(R.id.forum_enter_button);
            this.c = (ThreadForumEnterGoodsButton) inflate.findViewById(R.id.forum_enter_goods_button);
            this.b.setAfterClickListener(this.m);
            this.c.setAfterClickListener(this.m);
            this.d.setOnClickListener(this.m);
            this.e = (EMTextView) inflate.findViewById(R.id.tv_ueg);
        }
    }

    public final boolean j(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, threadData)) == null) {
            if (threadData == null || threadData.getAuthor() == null || !threadData.isFromConcern || !UbsABTestHelper.isConcernForumCardShow() || threadData.getAuthor().hadConcerned() || ThreadCardUtils.isSelf(threadData)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setData(bw4 bw4Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bw4Var) == null) {
            this.f = bw4Var;
            g();
            ThreadData threadData = bw4Var.getThreadData();
            int i = 8;
            if (!k(threadData) && ((bw4Var.showCardEnterFourm() || !threadData.isFromHomPage) && !StringUtils.isNull(threadData.getForum_name()) && !j(threadData))) {
                this.b.setVisibility(0);
                this.b.b(threadData, this.j);
                z = true;
            } else {
                this.b.setVisibility(8);
                z = false;
            }
            if (!m(bw4Var) && !l(bw4Var) && bw4Var.showCardGoodsFourm() && bw4Var.getThreadData().isGoods()) {
                this.c.setVisibility(0);
                this.c.a(threadData);
                z = true;
            } else {
                this.c.setVisibility(8);
            }
            if (ThreadCardUtils.isSelf(threadData) && threadData.isPrivacy) {
                this.d.setVisibility(0);
                this.d.setTextSize(0, BdUtilHelper.getDimens(getContext(), R.dimen.tbds32));
                this.d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0109);
                this.d.setText(R.string.private_desc);
                this.d.setOnClickListener(null);
                z = true;
            } else {
                this.d.setVisibility(8);
            }
            int visibility = this.d.getVisibility();
            if (threadData.isAuthorView == 1 && threadData.isFromPersonPolymeric) {
                this.e.setVisibility(0);
                this.d.setVisibility(8);
            } else {
                this.e.setVisibility(8);
                this.d.setVisibility(visibility);
            }
            if (z) {
                i = 0;
            }
            setVisibility(i);
        }
    }
}
