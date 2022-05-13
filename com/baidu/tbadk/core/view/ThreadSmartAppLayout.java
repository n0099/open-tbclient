package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.li;
import com.repackage.oy;
import com.repackage.vl5;
import com.repackage.zn4;
import tbclient.SmartApp;
/* loaded from: classes3.dex */
public class ThreadSmartAppLayout extends RelativeLayout implements View.OnClickListener, oy<zn4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView a;
    public TextView b;
    public TextView c;
    public SmartApp d;
    public View.OnClickListener e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ThreadSmartAppLayout(Context context) {
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

    public final TbPageContext b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            if (context instanceof BaseActivity) {
                return ((BaseActivity) context).getPageContext();
            }
            if (context instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) context).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.oy
    /* renamed from: c */
    public void a(zn4 zn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zn4Var) == null) {
            if (zn4Var != null && zn4Var.getThreadData() != null && zn4Var.getThreadData().getSmartApp() != null) {
                SmartApp smartApp = zn4Var.getThreadData().getSmartApp();
                this.d = smartApp;
                if (!li.isEmpty(smartApp.avatar)) {
                    this.a.L(this.d.avatar, 10, false, false);
                }
                if (!li.isEmpty(this.d.name)) {
                    this.b.setText(this.d.name + " " + getContext().getResources().getString(R.string.obfuscated_res_0x7f0f11a6));
                } else {
                    this.b.setText(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f08f0));
                }
                if (!li.isEmpty(this.d._abstract)) {
                    this.c.setText(this.d._abstract);
                } else {
                    this.c.setText(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f11a5));
                }
                setVisibility(0);
                return;
            }
            setVisibility(8);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setBackgroundResource(this, R.drawable.applets_cell_bg);
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0107);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        SmartApp smartApp;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view2) == null) || (smartApp = this.d) == null) {
            return;
        }
        if (!vl5.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
            if (li.isEmpty(this.d.h5_url)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(b(getContext()), new String[]{this.d.h5_url});
        }
        View.OnClickListener onClickListener = this.e;
        if (onClickListener != null) {
            onClickListener.onClick(view2);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.e = onClickListener;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ThreadSmartAppLayout(Context context, AttributeSet attributeSet) {
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
    public ThreadSmartAppLayout(Context context, AttributeSet attributeSet, int i) {
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
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0827, (ViewGroup) this, true);
        HeadImageView headImageView = (HeadImageView) findViewById(R.id.obfuscated_res_0x7f091002);
        this.a = headImageView;
        headImageView.setIsRound(true);
        this.a.setPlaceHolder(1);
        this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f092256);
        this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f092255);
        setOnClickListener(this);
        d();
    }
}
