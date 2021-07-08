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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.m.b;
import d.a.o0.m.d;
import d.a.o0.r.q.b2;
/* loaded from: classes3.dex */
public class ClickableHeaderImageView extends HeadImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b2 S0;
    public boolean T0;
    public View.OnClickListener U0;
    public d V0;
    public View.OnClickListener W0;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ClickableHeaderImageView f12401e;

        public a(ClickableHeaderImageView clickableHeaderImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {clickableHeaderImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12401e = clickableHeaderImageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d dVar = this.f12401e.V0;
                if ((dVar == null || !dVar.a(view)) && this.f12401e.S0 != null) {
                    MetaData t = this.f12401e.T0 ? this.f12401e.S0.p1().t() : this.f12401e.S0.H();
                    if (t == null || StringUtils.isNull(t.getName_show()) || StringUtils.isNull(t.getUserId())) {
                        return;
                    }
                    long f2 = b.f(t.getUserId(), 0L);
                    PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(this.f12401e.getContext()).createNormalConfig(f2, f2 == b.f(TbadkCoreApplication.getCurrentAccount(), 0L), t.isBigV());
                    createNormalConfig.setSourceTid(this.f12401e.S0.n1());
                    createNormalConfig.setSourceNid(this.f12401e.S0.A0());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                    if (this.f12401e.U0 != null) {
                        this.f12401e.U0.onClick(view);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    public void setData(b2 b2Var, boolean z, boolean z2) {
        MetaData H;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{b2Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || b2Var == null || b2Var.H() == null) {
            return;
        }
        this.S0 = b2Var;
        this.T0 = z2;
        if (z2) {
            H = b2Var.p1().t();
        } else {
            H = b2Var.H();
        }
        setContentDescription(H.getName_show() + getContext().getString(R.string.somebodys_portrait));
        setUserId(H.getUserId());
        setUserName(H.getUserName());
        if (b2Var.g1() != null && (this.S0.j1() == 49 || this.S0.j1() == 69)) {
            setUrl(b2Var.H().getAvater());
            M(b2Var.H().getAvater(), 28, false);
        } else {
            setUrl(H.getAvater());
            if (!StringUtils.isNull(H.getAvater()) && H.getAvater().contains("http")) {
                M(H.getAvater(), 10, false);
            } else {
                M(H.getAvater(), 28, false);
            }
        }
        UtilHelper.showHeadImageViewBigV(this, H);
    }

    public void setOnInterceptClickEventListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            this.V0 = dVar;
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
        this.W0 = new a(this);
        v();
    }

    public void setData(b2 b2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, b2Var, z) == null) {
            setData(b2Var, z, false);
        }
    }

    public void setData(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b2Var) == null) {
            setData(b2Var, true);
        }
    }

    public void setData(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, metaData) == null) || metaData == null) {
            return;
        }
        b2 b2Var = new b2();
        b2Var.h3(metaData);
        setData(b2Var);
    }
}
