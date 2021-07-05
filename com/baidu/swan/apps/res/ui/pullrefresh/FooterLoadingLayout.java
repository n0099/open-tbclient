package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.c;
import d.a.q0.a.d;
import d.a.q0.a.f;
import d.a.q0.a.g;
import d.a.q0.a.h;
import d.a.q0.a.r1.n.a;
/* loaded from: classes4.dex */
public class FooterLoadingLayout extends LoadingLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public LoadingAnimView f11354i;
    public TextView j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FooterLoadingLayout(Context context) {
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
        n(context);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, viewGroup, attributeSet)) == null) {
            View b2 = a.a().b(g.aiapps_pull_to_load_footer, viewGroup, false);
            b2.setBackgroundColor(context.getResources().getColor(c.aiapps_pull_loading_bg));
            return b2;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.j.setVisibility(0);
            this.j.setText(h.aiapps_pull_to_refresh_header_no_more_msg);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.j.setVisibility(0);
            this.j.setText(h.aiapps_pull_to_refresh_header_hint_normal);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View findViewById = findViewById(f.pull_to_load_footer_content);
            if (findViewById != null) {
                return findViewById.getHeight();
            }
            return (int) getResources().getDimension(d.aiapps_picture_pull_to_refresh_footer_height);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f11354i.setVisibility(0);
            this.f11354i.d();
            this.j.setVisibility(0);
            this.j.setText(h.aiapps_pull_to_refresh_header_hint_loading);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.j.setVisibility(0);
            this.j.setText(h.aiapps_pull_to_refresh_header_hint_ready);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.j.setText(h.aiapps_pull_to_refresh_header_hint_loading);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void l(ILoadingLayout$State iLoadingLayout$State, ILoadingLayout$State iLoadingLayout$State2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, iLoadingLayout$State, iLoadingLayout$State2) == null) {
            this.f11354i.setVisibility(8);
            this.f11354i.e();
            this.j.setVisibility(4);
            super.l(iLoadingLayout$State, iLoadingLayout$State2);
        }
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            this.f11354i = (LoadingAnimView) findViewById(f.pull_to_load_footer_progressbar);
            TextView textView = (TextView) findViewById(f.pull_to_load_footer_hint_textview);
            this.j = textView;
            textView.setTextColor(getResources().getColor(c.aiapps_picture_loading_text_color));
            setState(ILoadingLayout$State.RESET);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, charSequence) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FooterLoadingLayout(Context context, AttributeSet attributeSet) {
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
        n(context);
    }
}
