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
import c.a.p0.s.q.c2;
import c.a.p0.s.q.y1;
import c.a.q0.a0.m;
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
/* loaded from: classes6.dex */
public class ThreadForumUserInfoLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_FORUMNAME_LENGTH = 14;
    public static final int MAX_USERNAME_LENGTH = 14;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f47702e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f47703f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f47704g;

    /* renamed from: h  reason: collision with root package name */
    public ForumLikeBotton f47705h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.p0.s.f0.o.c.a f47706i;

    /* renamed from: j  reason: collision with root package name */
    public c2 f47707j;
    public View.OnClickListener k;
    public int l;
    public View.OnClickListener m;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadForumUserInfoLayout f47708e;

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
            this.f47708e = threadForumUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f47708e.f47707j == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f47708e.getContext()).createNormalCfg(this.f47708e.f47707j.Y() != null ? this.f47708e.f47707j.Y().getForumName() : this.f47708e.f47707j.Z(), m.g())));
            if (this.f47708e.k != null) {
                this.f47708e.k.onClick(view);
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
            this.f47702e = (TbImageView) inflate.findViewById(R.id.forum_avatar);
            TextView textView = (TextView) inflate.findViewById(R.id.forum_name);
            this.f47703f = textView;
            textView.setOnClickListener(this.m);
            this.f47704g = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
            this.f47705h = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
            if (context instanceof TbPageContextSupport) {
                this.f47706i = new c.a.p0.s.f0.o.c.a(((TbPageContextSupport) context).getPageContext(), this.f47705h);
            }
            setGravity(16);
            d();
        }
    }

    public final void d() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (tbImageView = this.f47702e) == null) {
            return;
        }
        tbImageView.setDefaultBgResource(R.color.CAM_X0205);
        this.f47702e.setOnClickListener(this.m);
    }

    public final void e(y1 y1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, y1Var) == null) {
            if (y1Var != null && !StringUtils.isNull(y1Var.b())) {
                this.f47702e.setVisibility(0);
                this.f47702e.startLoad(y1Var.b(), 10, false);
                this.f47702e.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
                return;
            }
            this.f47702e.setVisibility(4);
        }
    }

    public TextView getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f47703f : (TextView) invokeV.objValue;
    }

    public TbImageView getHeaderImg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f47702e : (TbImageView) invokeV.objValue;
    }

    public ForumLikeBotton getLikeButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f47705h : (ForumLikeBotton) invokeV.objValue;
    }

    public TextView getUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f47704g : (TextView) invokeV.objValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.l == i2) {
            return;
        }
        this.l = i2;
        SkinManager.setViewTextColor(this.f47703f, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.f47704g, R.color.CAM_X0109);
    }

    public String processUserName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? StringHelper.cutChineseAndEnglishWithSuffix(str, 14, "...") : (String) invokeL.objValue;
    }

    public void setData(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, c2Var) == null) || c2Var == null) {
            return;
        }
        this.f47707j = c2Var;
        e(c2Var.Y());
        updateForumName(c2Var.Y());
        updateUserNameAndReplyTime(c2Var);
        updateLikeButton(c2Var.Y());
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.k = onClickListener;
        }
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        c.a.p0.s.f0.o.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) || (aVar = this.f47706i) == null) {
            return;
        }
        aVar.e(onClickListener);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bdUniqueId) == null) {
            TbImageView tbImageView = this.f47702e;
            if (tbImageView != null) {
                tbImageView.setPageId(bdUniqueId);
            }
            c.a.p0.s.f0.o.c.a aVar = this.f47706i;
            if (aVar != null) {
                aVar.g(bdUniqueId);
            }
        }
    }

    public void updateForumName(y1 y1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, y1Var) == null) {
            if (y1Var != null && !StringUtils.isNull(y1Var.getForumName())) {
                this.f47703f.setText(StringHelper.cutChineseAndEnglishWithSuffix(y1Var.getForumName(), 14, "...") + getResources().getString(R.string.forum));
                this.f47703f.setVisibility(0);
                return;
            }
            this.f47703f.setVisibility(4);
        }
    }

    public void updateLikeButton(y1 y1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, y1Var) == null) {
            int i2 = 8;
            if (y1Var == null) {
                this.f47705h.setVisibility(8);
                return;
            }
            this.f47706i.f(y1Var);
            this.f47705h.setVisibility((!y1Var.getIsLike() || y1Var.d()) ? 0 : 0);
        }
    }

    public void updateUserNameAndReplyTime(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, c2Var) == null) || c2Var == null || StringUtils.isNull(this.f47707j.J().getName_show())) {
            return;
        }
        this.f47704g.setText(getContext().getString(R.string.user_name_and_publish, processUserName(this.f47707j.J().getName_show())));
        this.f47704g.setVisibility(0);
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
