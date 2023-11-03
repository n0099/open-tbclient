package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tu4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ClickableHeaderImageView extends HeadImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadData a;
    public boolean b;
    public View.OnClickListener c;
    public tu4 d;
    public View.OnClickListener e;

    /* loaded from: classes4.dex */
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
            MetaData author;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                tu4 tu4Var = this.a.d;
                if ((tu4Var != null && tu4Var.a(view2)) || this.a.a == null) {
                    return;
                }
                if (this.a.b) {
                    author = this.a.a.getTopAgreePost().t();
                } else {
                    author = this.a.a.getAuthor();
                }
                if (author != null && !StringUtils.isNull(author.getName_show()) && !StringUtils.isNull(author.getUserId())) {
                    long j = JavaTypesHelper.toLong(author.getUserId(), 0L);
                    if (j == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(this.a.getContext()).createNormalConfig(j, z, author.isBigV());
                    createNormalConfig.setSourceTid(this.a.a.getTid());
                    createNormalConfig.setSourceNid(this.a.a.getNid());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                    if (this.a.c != null) {
                        this.a.c.onClick(view2);
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
        this.e = new a(this);
        init();
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
        this.e = new a(this);
        init();
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.c = onClickListener;
        }
    }

    public void setData(MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, metaData) != null) || metaData == null) {
            return;
        }
        ThreadData threadData = new ThreadData();
        threadData.setAuthor(metaData);
        setData(threadData);
    }

    public void setOnInterceptClickEventListener(tu4 tu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tu4Var) == null) {
            this.d = tu4Var;
        }
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOnClickListener(this.e);
            setDefaultResource(17170445);
            setPlaceHolder(1);
        }
    }

    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, threadData) == null) {
            setData(threadData, true);
        }
    }

    public void setData(ThreadData threadData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, threadData, z) == null) {
            setData(threadData, z, false);
        }
    }

    public void setData(ThreadData threadData, boolean z, boolean z2) {
        MetaData author;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{threadData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && threadData != null && threadData.getAuthor() != null) {
            this.a = threadData;
            this.b = z2;
            if (z2) {
                author = threadData.getTopAgreePost().t();
            } else {
                author = threadData.getAuthor();
            }
            setContentDescription(author.getName_show() + getContext().getString(R.string.somebodys_portrait));
            setUserId(author.getUserId());
            setUserName(author.getUserName());
            if (threadData.getThreadAlaInfo() != null && (this.a.getThreadType() == 49 || this.a.getThreadType() == 69)) {
                setUrl(threadData.getAuthor().getAvater());
                startLoad(threadData.getAuthor().getAvater(), 28, false);
            } else {
                setUrl(author.getAvater());
                if (!StringUtils.isNull(author.getAvater()) && author.getAvater().contains("http")) {
                    startLoad(author.getAvater(), 10, false);
                } else {
                    startLoad(author.getAvater(), 28, false);
                }
            }
            UtilHelper.showHeadImageViewBigV(this, author);
        }
    }
}
