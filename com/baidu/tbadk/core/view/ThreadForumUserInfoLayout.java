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
import c.a.r0.s.r.d2;
import c.a.r0.s.r.z1;
import c.a.s0.g0.m;
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
/* loaded from: classes11.dex */
public class ThreadForumUserInfoLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_FORUMNAME_LENGTH = 14;
    public static final int MAX_USERNAME_LENGTH = 14;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f41799e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f41800f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f41801g;

    /* renamed from: h  reason: collision with root package name */
    public ForumLikeBotton f41802h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.s.i0.o.c.a f41803i;

    /* renamed from: j  reason: collision with root package name */
    public d2 f41804j;

    /* renamed from: k  reason: collision with root package name */
    public View.OnClickListener f41805k;
    public int l;
    public View.OnClickListener m;

    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadForumUserInfoLayout f41806e;

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
            this.f41806e = threadForumUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f41806e.f41804j == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f41806e.getContext()).createNormalCfg(this.f41806e.f41804j.Z() != null ? this.f41806e.f41804j.Z().getForumName() : this.f41806e.f41804j.a0(), m.g())));
            if (this.f41806e.f41805k != null) {
                this.f41806e.f41805k.onClick(view);
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
            this.f41799e = (TbImageView) inflate.findViewById(R.id.forum_avatar);
            TextView textView = (TextView) inflate.findViewById(R.id.forum_name);
            this.f41800f = textView;
            textView.setOnClickListener(this.m);
            this.f41801g = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
            this.f41802h = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
            if (context instanceof TbPageContextSupport) {
                this.f41803i = new c.a.r0.s.i0.o.c.a(((TbPageContextSupport) context).getPageContext(), this.f41802h);
            }
            setGravity(16);
            d();
        }
    }

    public final void d() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (tbImageView = this.f41799e) == null) {
            return;
        }
        tbImageView.setDefaultBgResource(R.color.CAM_X0205);
        this.f41799e.setOnClickListener(this.m);
    }

    public final void e(z1 z1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, z1Var) == null) {
            if (z1Var != null && !StringUtils.isNull(z1Var.b())) {
                this.f41799e.setVisibility(0);
                this.f41799e.startLoad(z1Var.b(), 10, false);
                this.f41799e.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
                return;
            }
            this.f41799e.setVisibility(4);
        }
    }

    public TextView getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f41800f : (TextView) invokeV.objValue;
    }

    public TbImageView getHeaderImg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f41799e : (TbImageView) invokeV.objValue;
    }

    public ForumLikeBotton getLikeButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f41802h : (ForumLikeBotton) invokeV.objValue;
    }

    public TextView getUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f41801g : (TextView) invokeV.objValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.l == i2) {
            return;
        }
        this.l = i2;
        SkinManager.setViewTextColor(this.f41800f, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.f41801g, R.color.CAM_X0109);
    }

    public String processUserName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? StringHelper.cutChineseAndEnglishWithSuffix(str, 14, "...") : (String) invokeL.objValue;
    }

    public void setData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, d2Var) == null) || d2Var == null) {
            return;
        }
        this.f41804j = d2Var;
        e(d2Var.Z());
        updateForumName(d2Var.Z());
        updateUserNameAndReplyTime(d2Var);
        updateLikeButton(d2Var.Z());
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.f41805k = onClickListener;
        }
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        c.a.r0.s.i0.o.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) || (aVar = this.f41803i) == null) {
            return;
        }
        aVar.e(onClickListener);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bdUniqueId) == null) {
            TbImageView tbImageView = this.f41799e;
            if (tbImageView != null) {
                tbImageView.setPageId(bdUniqueId);
            }
            c.a.r0.s.i0.o.c.a aVar = this.f41803i;
            if (aVar != null) {
                aVar.g(bdUniqueId);
            }
        }
    }

    public void updateForumName(z1 z1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, z1Var) == null) {
            if (z1Var != null && !StringUtils.isNull(z1Var.getForumName())) {
                this.f41800f.setText(StringHelper.cutChineseAndEnglishWithSuffix(z1Var.getForumName(), 14, "...") + getResources().getString(R.string.forum));
                this.f41800f.setVisibility(0);
                return;
            }
            this.f41800f.setVisibility(4);
        }
    }

    public void updateLikeButton(z1 z1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, z1Var) == null) {
            int i2 = 8;
            if (z1Var == null) {
                this.f41802h.setVisibility(8);
                return;
            }
            this.f41803i.f(z1Var);
            this.f41802h.setVisibility((!z1Var.getIsLike() || z1Var.d()) ? 0 : 0);
        }
    }

    public void updateUserNameAndReplyTime(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, d2Var) == null) || d2Var == null || StringUtils.isNull(this.f41804j.J().getName_show())) {
            return;
        }
        this.f41801g.setText(getContext().getString(R.string.user_name_and_publish, processUserName(this.f41804j.J().getName_show())));
        this.f41801g.setVisibility(0);
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
        this.l = 3;
        this.m = new a(this);
        c(getContext());
    }
}
