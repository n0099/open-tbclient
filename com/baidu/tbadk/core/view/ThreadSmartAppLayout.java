package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.l.p;
import c.a.o0.r.r.a;
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
import tbclient.SmartApp;
/* loaded from: classes5.dex */
public class ThreadSmartAppLayout extends RelativeLayout implements View.OnClickListener, p<a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f30169b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f30170c;

    /* renamed from: d  reason: collision with root package name */
    public SmartApp f30171d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f30172e;

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
    @Override // c.a.l.p
    /* renamed from: c */
    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            if (aVar != null && aVar.getThreadData() != null && aVar.getThreadData().getSmartApp() != null) {
                SmartApp smartApp = aVar.getThreadData().getSmartApp();
                this.f30171d = smartApp;
                if (!m.isEmpty(smartApp.avatar)) {
                    this.a.K(this.f30171d.avatar, 10, false, false);
                }
                if (!m.isEmpty(this.f30171d.name)) {
                    this.f30169b.setText(this.f30171d.name + " " + getContext().getResources().getString(R.string.obfuscated_res_0x7f0f1182));
                } else {
                    this.f30169b.setText(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f08ec));
                }
                if (!m.isEmpty(this.f30171d._abstract)) {
                    this.f30170c.setText(this.f30171d._abstract);
                } else {
                    this.f30170c.setText(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f1181));
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
            SkinManager.setViewTextColor(this.f30169b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f30170c, (int) R.color.CAM_X0107);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SmartApp smartApp;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view) == null) || (smartApp = this.f30171d) == null) {
            return;
        }
        if (!c.a.p0.b0.a.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
            if (m.isEmpty(this.f30171d.h5_url)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(b(getContext()), new String[]{this.f30171d.h5_url});
        }
        View.OnClickListener onClickListener = this.f30172e;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.f30172e = onClickListener;
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
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0837, (ViewGroup) this, true);
        HeadImageView headImageView = (HeadImageView) findViewById(R.id.obfuscated_res_0x7f090ffa);
        this.a = headImageView;
        headImageView.setIsRound(true);
        this.a.setPlaceHolder(1);
        this.f30169b = (TextView) findViewById(R.id.obfuscated_res_0x7f09221a);
        this.f30170c = (TextView) findViewById(R.id.obfuscated_res_0x7f092219);
        setOnClickListener(this);
        d();
    }
}
