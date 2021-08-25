package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import c.a.e.e.m.b;
import c.a.p0.n.d;
import c.a.p0.s.q.c2;
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
    public c2 r0;
    public boolean s0;
    public View.OnClickListener t0;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ClickableHeaderImageView f47497e;

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
            this.f47497e = clickableHeaderImageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d dVar = this.f47497e.mInterceptClickEventListener;
                if ((dVar == null || !dVar.onClickEvent(view)) && this.f47497e.r0 != null) {
                    MetaData t = this.f47497e.s0 ? this.f47497e.r0.t1().t() : this.f47497e.r0.J();
                    if (t == null || StringUtils.isNull(t.getName_show()) || StringUtils.isNull(t.getUserId())) {
                        return;
                    }
                    long f2 = b.f(t.getUserId(), 0L);
                    PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(this.f47497e.getContext()).createNormalConfig(f2, f2 == b.f(TbadkCoreApplication.getCurrentAccount(), 0L), t.isBigV());
                    createNormalConfig.setSourceTid(this.f47497e.r0.q1());
                    createNormalConfig.setSourceNid(this.f47497e.r0.D0());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                    if (this.f47497e.t0 != null) {
                        this.f47497e.t0.onClick(view);
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
            this.t0 = onClickListener;
        }
    }

    public void setData(c2 c2Var, boolean z, boolean z2) {
        MetaData J;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{c2Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || c2Var == null || c2Var.J() == null) {
            return;
        }
        this.r0 = c2Var;
        this.s0 = z2;
        if (z2) {
            J = c2Var.t1().t();
        } else {
            J = c2Var.J();
        }
        setContentDescription(J.getName_show() + getContext().getString(R.string.somebodys_portrait));
        setUserId(J.getUserId());
        setUserName(J.getUserName());
        if (c2Var.j1() != null && (this.r0.m1() == 49 || this.r0.m1() == 69)) {
            setUrl(c2Var.J().getAvater());
            startLoad(c2Var.J().getAvater(), 28, false);
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

    public void setData(c2 c2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, c2Var, z) == null) {
            setData(c2Var, z, false);
        }
    }

    public void setData(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c2Var) == null) {
            setData(c2Var, true);
        }
    }

    public void setData(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, metaData) == null) || metaData == null) {
            return;
        }
        c2 c2Var = new c2();
        c2Var.r3(metaData);
        setData(c2Var);
    }
}
