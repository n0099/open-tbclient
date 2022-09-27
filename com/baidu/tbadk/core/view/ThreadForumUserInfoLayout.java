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
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.commonLike.forum.ForumLikeBotton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.sy4;
import com.baidu.tieba.t16;
import com.baidu.tieba.xt4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ThreadForumUserInfoLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;
    public TextView b;
    public TextView c;
    public ForumLikeBotton d;
    public sy4 e;
    public ThreadData f;
    public View.OnClickListener g;
    public View.OnClickListener h;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadForumUserInfoLayout a;

        public a(ThreadForumUserInfoLayout threadForumUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadForumUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadForumUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.f == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getContext()).createNormalCfg(this.a.f.getForumData() != null ? this.a.f.getForumData().c() : this.a.f.getForum_name(), t16.g())));
            if (this.a.g != null) {
                this.a.g.onClick(view2);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0885, (ViewGroup) this, true);
            this.a = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090a4b);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090a8e);
            this.b = textView;
            textView.setOnClickListener(this.h);
            this.c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0924b8);
            this.d = (ForumLikeBotton) inflate.findViewById(R.id.obfuscated_res_0x7f0912ff);
            if (context instanceof TbPageContextSupport) {
                this.e = new sy4(((TbPageContextSupport) context).getPageContext(), this.d);
            }
            setGravity(16);
            d();
        }
    }

    public final void d() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (tbImageView = this.a) == null) {
            return;
        }
        tbImageView.setDefaultBgResource(R.color.CAM_X0205);
        this.a.setOnClickListener(this.h);
    }

    public String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? StringHelper.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE) : (String) invokeL.objValue;
    }

    public final void f(xt4 xt4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, xt4Var) == null) {
            if (xt4Var != null && !StringUtils.isNull(xt4Var.a())) {
                this.a.setVisibility(0);
                this.a.K(xt4Var.a(), 10, false);
                this.a.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
                return;
            }
            this.a.setVisibility(4);
        }
    }

    public void g(xt4 xt4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, xt4Var) == null) {
            if (xt4Var != null && !StringUtils.isNull(xt4Var.c())) {
                this.b.setText(StringHelper.cutChineseAndEnglishWithSuffix(xt4Var.c(), 14, StringHelper.STRING_MORE) + getResources().getString(R.string.obfuscated_res_0x7f0f066e));
                this.b.setVisibility(0);
                return;
            }
            this.b.setVisibility(4);
        }
    }

    public TextView getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b : (TextView) invokeV.objValue;
    }

    public TbImageView getHeaderImg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (TbImageView) invokeV.objValue;
    }

    public ForumLikeBotton getLikeButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.d : (ForumLikeBotton) invokeV.objValue;
    }

    public TextView getUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.c : (TextView) invokeV.objValue;
    }

    public void h(xt4 xt4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, xt4Var) == null) {
            int i = 8;
            if (xt4Var == null) {
                this.d.setVisibility(8);
                return;
            }
            this.e.f(xt4Var);
            this.d.setVisibility((!xt4Var.getIsLike() || xt4Var.f()) ? 0 : 0);
        }
    }

    public void i(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, threadData) == null) || threadData == null || StringUtils.isNull(this.f.getAuthor().getName_show())) {
            return;
        }
        this.c.setText(getContext().getString(R.string.obfuscated_res_0x7f0f150f, e(this.f.getAuthor().getName_show())));
        this.c.setVisibility(0);
    }

    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, threadData) == null) || threadData == null) {
            return;
        }
        this.f = threadData;
        f(threadData.getForumData());
        g(threadData.getForumData());
        i(threadData);
        h(threadData.getForumData());
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            this.g = onClickListener;
        }
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        sy4 sy4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) || (sy4Var = this.e) == null) {
            return;
        }
        sy4Var.e(onClickListener);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) {
            TbImageView tbImageView = this.a;
            if (tbImageView != null) {
                tbImageView.setPageId(bdUniqueId);
            }
            sy4 sy4Var = this.e;
            if (sy4Var != null) {
                sy4Var.g(bdUniqueId);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadForumUserInfoLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.h = new a(this);
        c(getContext());
    }
}
