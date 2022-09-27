package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.dh;
import com.baidu.tieba.op4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ClickableHeaderImageView extends HeadImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadData S0;
    public boolean T0;
    public View.OnClickListener U0;
    public op4 V0;
    public View.OnClickListener W0;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ClickableHeaderImageView a;

        public a(ClickableHeaderImageView clickableHeaderImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {clickableHeaderImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = clickableHeaderImageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                op4 op4Var = this.a.V0;
                if ((op4Var == null || !op4Var.a(view2)) && this.a.S0 != null) {
                    MetaData s = this.a.T0 ? this.a.S0.getTopAgreePost().s() : this.a.S0.getAuthor();
                    if (s == null || StringUtils.isNull(s.getName_show()) || StringUtils.isNull(s.getUserId())) {
                        return;
                    }
                    long g = dh.g(s.getUserId(), 0L);
                    PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(this.a.getContext()).createNormalConfig(g, g == dh.g(TbadkCoreApplication.getCurrentAccount(), 0L), s.isBigV());
                    createNormalConfig.setSourceTid(this.a.S0.getTid());
                    createNormalConfig.setSourceNid(this.a.S0.getNid());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                    if (this.a.U0 != null) {
                        this.a.U0.onClick(view2);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickableHeaderImageView(Context context) {
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
        this.W0 = new a(this);
        v();
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.U0 = onClickListener;
        }
    }

    public void setData(ThreadData threadData, boolean z, boolean z2) {
        MetaData author;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{threadData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || threadData == null || threadData.getAuthor() == null) {
            return;
        }
        this.S0 = threadData;
        this.T0 = z2;
        if (z2) {
            author = threadData.getTopAgreePost().s();
        } else {
            author = threadData.getAuthor();
        }
        setContentDescription(author.getName_show() + getContext().getString(R.string.obfuscated_res_0x7f0f11cc));
        setUserId(author.getUserId());
        setUserName(author.getUserName());
        if (threadData.getThreadAlaInfo() != null && (this.S0.getThreadType() == 49 || this.S0.getThreadType() == 69)) {
            setUrl(threadData.getAuthor().getAvater());
            K(threadData.getAuthor().getAvater(), 28, false);
        } else {
            setUrl(author.getAvater());
            if (!StringUtils.isNull(author.getAvater()) && author.getAvater().contains("http")) {
                K(author.getAvater(), 10, false);
            } else {
                K(author.getAvater(), 28, false);
            }
        }
        UtilHelper.showHeadImageViewBigV(this, author);
    }

    public void setOnInterceptClickEventListener(op4 op4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, op4Var) == null) {
            this.V0 = op4Var;
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setOnClickListener(this.W0);
            setDefaultResource(17170445);
            setPlaceHolder(1);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickableHeaderImageView(Context context, AttributeSet attributeSet) {
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
        this.W0 = new a(this);
        v();
    }

    public void setData(ThreadData threadData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, threadData, z) == null) {
            setData(threadData, z, false);
        }
    }

    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) {
            setData(threadData, true);
        }
    }

    public void setData(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, metaData) == null) || metaData == null) {
            return;
        }
        ThreadData threadData = new ThreadData();
        threadData.setAuthor(metaData);
        setData(threadData);
    }
}
