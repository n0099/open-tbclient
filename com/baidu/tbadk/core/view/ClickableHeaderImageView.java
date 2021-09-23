package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import c.a.e.e.m.b;
import c.a.q0.n.d;
import c.a.q0.s.q.d2;
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
/* loaded from: classes6.dex */
public class ClickableHeaderImageView extends HeadImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d mInterceptClickEventListener;
    public View.OnClickListener mOnClickListener;
    public d2 s0;
    public boolean t0;
    public View.OnClickListener u0;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ClickableHeaderImageView f47719e;

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
            this.f47719e = clickableHeaderImageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d dVar = this.f47719e.mInterceptClickEventListener;
                if ((dVar == null || !dVar.onClickEvent(view)) && this.f47719e.s0 != null) {
                    MetaData t = this.f47719e.t0 ? this.f47719e.s0.v1().t() : this.f47719e.s0.J();
                    if (t == null || StringUtils.isNull(t.getName_show()) || StringUtils.isNull(t.getUserId())) {
                        return;
                    }
                    long g2 = b.g(t.getUserId(), 0L);
                    PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(this.f47719e.getContext()).createNormalConfig(g2, g2 == b.g(TbadkCoreApplication.getCurrentAccount(), 0L), t.isBigV());
                    createNormalConfig.setSourceTid(this.f47719e.s0.s1());
                    createNormalConfig.setSourceNid(this.f47719e.s0.F0());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                    if (this.f47719e.u0 != null) {
                        this.f47719e.u0.onClick(view);
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
        this.mOnClickListener = new a(this);
        init();
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOnClickListener(this.mOnClickListener);
            setDefaultResource(17170445);
            setPlaceHolder(1);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.u0 = onClickListener;
        }
    }

    public void setData(d2 d2Var, boolean z, boolean z2) {
        MetaData J;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{d2Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || d2Var == null || d2Var.J() == null) {
            return;
        }
        this.s0 = d2Var;
        this.t0 = z2;
        if (z2) {
            J = d2Var.v1().t();
        } else {
            J = d2Var.J();
        }
        setContentDescription(J.getName_show() + getContext().getString(R.string.somebodys_portrait));
        setUserId(J.getUserId());
        setUserName(J.getUserName());
        if (d2Var.l1() != null && (this.s0.o1() == 49 || this.s0.o1() == 69)) {
            setUrl(d2Var.J().getAvater());
            startLoad(d2Var.J().getAvater(), 28, false);
        } else {
            setUrl(J.getAvater());
            if (!StringUtils.isNull(J.getAvater()) && J.getAvater().contains("http")) {
                startLoad(J.getAvater(), 10, false);
            } else {
                startLoad(J.getAvater(), 28, false);
            }
        }
        UtilHelper.showHeadImageViewBigV(this, J);
    }

    public void setOnInterceptClickEventListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.mInterceptClickEventListener = dVar;
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
        this.mOnClickListener = new a(this);
        init();
    }

    public void setData(d2 d2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, d2Var, z) == null) {
            setData(d2Var, z, false);
        }
    }

    public void setData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2Var) == null) {
            setData(d2Var, true);
        }
    }

    public void setData(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, metaData) == null) || metaData == null) {
            return;
        }
        d2 d2Var = new d2();
        d2Var.x3(metaData);
        setData(d2Var);
    }
}
