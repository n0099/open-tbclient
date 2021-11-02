package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.e.p.k;
import b.a.l.p;
import b.a.q0.s.q.a;
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
/* loaded from: classes8.dex */
public class ThreadSmartAppLayout extends RelativeLayout implements View.OnClickListener, p<a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HeadImageView f45444e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f45445f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f45446g;

    /* renamed from: h  reason: collision with root package name */
    public SmartApp f45447h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f45448i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ThreadSmartAppLayout(Context context) {
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

    public final TbPageContext a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
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

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setBackgroundResource(this, R.drawable.applets_cell_bg);
            SkinManager.setViewTextColor(this.f45445f, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f45446g, R.color.CAM_X0107);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SmartApp smartApp;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view) == null) || (smartApp = this.f45447h) == null) {
            return;
        }
        if (!b.a.r0.v.a.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
            if (k.isEmpty(this.f45447h.h5_url)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(a(getContext()), new String[]{this.f45447h.h5_url});
        }
        View.OnClickListener onClickListener = this.f45448i;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.f45448i = onClickListener;
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.l.p
    public void onBindDataToView(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (aVar != null && aVar.getThreadData() != null && aVar.getThreadData().e1() != null) {
                SmartApp e1 = aVar.getThreadData().e1();
                this.f45447h = e1;
                if (!k.isEmpty(e1.avatar)) {
                    this.f45444e.startLoad(this.f45447h.avatar, 10, false, false);
                }
                if (!k.isEmpty(this.f45447h.name)) {
                    this.f45445f.setText(this.f45447h.name + " " + getContext().getResources().getString(R.string.smart_app_suffix));
                } else {
                    this.f45445f.setText(getContext().getResources().getString(R.string.intelligent_smart_app));
                }
                if (!k.isEmpty(this.f45447h._abstract)) {
                    this.f45446g.setText(this.f45447h._abstract);
                } else {
                    this.f45446g.setText(getContext().getResources().getString(R.string.smart_app_default_abstract));
                }
                setVisibility(0);
                return;
            }
            setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadSmartAppLayout(Context context, AttributeSet attributeSet, int i2) {
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
        LayoutInflater.from(context).inflate(R.layout.thread_smart_app_layout, (ViewGroup) this, true);
        HeadImageView headImageView = (HeadImageView) findViewById(R.id.iv_thread_smart_app_head);
        this.f45444e = headImageView;
        headImageView.setIsRound(true);
        this.f45444e.setPlaceHolder(1);
        this.f45445f = (TextView) findViewById(R.id.tv_thread_smart_app_title);
        this.f45446g = (TextView) findViewById(R.id.tv_thread_smart_app_abstract);
        setOnClickListener(this);
        onChangeSkinType();
    }
}
