package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.commonLike.forum.ForumLikeBotton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.x1;
import d.a.s0.a0.m;
/* loaded from: classes4.dex */
public class ThreadForumUserInfoLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f12562e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12563f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12564g;

    /* renamed from: h  reason: collision with root package name */
    public ForumLikeBotton f12565h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.r0.r.f0.n.c.a f12566i;
    public b2 j;
    public View.OnClickListener k;
    public View.OnClickListener l;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadForumUserInfoLayout f12567e;

        public a(ThreadForumUserInfoLayout threadForumUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadForumUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12567e = threadForumUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f12567e.j == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f12567e.getContext()).createNormalCfg(this.f12567e.j.V() != null ? this.f12567e.j.V().h() : this.f12567e.j.W(), m.g())));
            if (this.f12567e.k != null) {
                this.f12567e.k.onClick(view);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ThreadForumUserInfoLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.thread_forum_user_info_layout, (ViewGroup) this, true);
            this.f12562e = (TbImageView) inflate.findViewById(R.id.forum_avatar);
            TextView textView = (TextView) inflate.findViewById(R.id.forum_name);
            this.f12563f = textView;
            textView.setOnClickListener(this.l);
            this.f12564g = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
            this.f12565h = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
            if (context instanceof TbPageContextSupport) {
                this.f12566i = new d.a.r0.r.f0.n.c.a(((TbPageContextSupport) context).getPageContext(), this.f12565h);
            }
            setGravity(16);
            d();
        }
    }

    public final void d() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (tbImageView = this.f12562e) == null) {
            return;
        }
        tbImageView.setDefaultBgResource(R.color.CAM_X0205);
        this.f12562e.setOnClickListener(this.l);
    }

    public String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? StringHelper.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE) : (String) invokeL.objValue;
    }

    public final void f(x1 x1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, x1Var) == null) {
            if (x1Var != null && !StringUtils.isNull(x1Var.a())) {
                this.f12562e.setVisibility(0);
                this.f12562e.M(x1Var.a(), 10, false);
                this.f12562e.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
                return;
            }
            this.f12562e.setVisibility(4);
        }
    }

    public void g(x1 x1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, x1Var) == null) {
            if (x1Var != null && !StringUtils.isNull(x1Var.h())) {
                this.f12563f.setText(StringHelper.cutChineseAndEnglishWithSuffix(x1Var.h(), 14, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
                this.f12563f.setVisibility(0);
                return;
            }
            this.f12563f.setVisibility(4);
        }
    }

    public TextView getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f12563f : (TextView) invokeV.objValue;
    }

    public TbImageView getHeaderImg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f12562e : (TbImageView) invokeV.objValue;
    }

    public ForumLikeBotton getLikeButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f12565h : (ForumLikeBotton) invokeV.objValue;
    }

    public TextView getUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f12564g : (TextView) invokeV.objValue;
    }

    public void h(x1 x1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, x1Var) == null) {
            int i2 = 8;
            if (x1Var == null) {
                this.f12565h.setVisibility(8);
                return;
            }
            this.f12566i.f(x1Var);
            this.f12565h.setVisibility((!x1Var.getIsLike() || x1Var.c()) ? 0 : 0);
        }
    }

    public void i(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, b2Var) == null) || b2Var == null || StringUtils.isNull(this.j.H().getName_show())) {
            return;
        }
        this.f12564g.setText(getContext().getString(R.string.user_name_and_publish, e(this.j.H().getName_show())));
        this.f12564g.setVisibility(0);
    }

    public void setData(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, b2Var) == null) || b2Var == null) {
            return;
        }
        this.j = b2Var;
        f(b2Var.V());
        g(b2Var.V());
        i(b2Var);
        h(b2Var.V());
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            this.k = onClickListener;
        }
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        d.a.r0.r.f0.n.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) || (aVar = this.f12566i) == null) {
            return;
        }
        aVar.e(onClickListener);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) {
            TbImageView tbImageView = this.f12562e;
            if (tbImageView != null) {
                tbImageView.setPageId(bdUniqueId);
            }
            d.a.r0.r.f0.n.c.a aVar = this.f12566i;
            if (aVar != null) {
                aVar.g(bdUniqueId);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ThreadForumUserInfoLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadForumUserInfoLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.l = new a(this);
        c(getContext());
    }
}
