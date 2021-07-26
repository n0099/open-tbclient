package com.baidu.swan.menu;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.k.f;
import d.a.o0.k.g;
import d.a.o0.k.h;
import d.a.o0.k.i;
import d.a.o0.k.j;
/* loaded from: classes3.dex */
public abstract class BaseMenuView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f12048e;

    /* renamed from: f  reason: collision with root package name */
    public View f12049f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12050g;

    /* renamed from: h  reason: collision with root package name */
    public View f12051h;

    /* renamed from: i  reason: collision with root package name */
    public final int f12052i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseMenuView(@NonNull Context context) {
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

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f12049f.getLayoutParams().height = i2 + this.f12052i;
            this.f12049f.requestLayout();
        }
    }

    public abstract boolean b();

    public void c(View view, FrameLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, layoutParams) == null) || view == null) {
            return;
        }
        int height = view.getHeight();
        if (height != 0) {
            this.f12049f.getLayoutParams().height = height + this.f12052i;
        }
        this.f12051h = view;
        layoutParams.bottomMargin = this.f12052i;
        addView(view, layoutParams);
    }

    public View getBgView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f12049f : (View) invokeV.objValue;
    }

    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f12051h : (View) invokeV.objValue;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.f12050g.setOnClickListener(onClickListener);
        }
    }

    public void setMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Resources resources = getResources();
            this.f12049f.setBackground(resources.getDrawable(h.swan_app_menu_content_bg));
            this.f12050g.setBackgroundColor(resources.getColor(f.aiapp_menu_cancel_text_color_bg));
            this.f12050g.setTextColor(resources.getColorStateList(f.aiapp_menu_cancel_text_color_day));
            this.f12050g.setAlpha(1.0f);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
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
        this.f12048e = context;
        View inflate = FrameLayout.inflate(context, j.aiapp_menu_base_view_layout, this);
        this.f12049f = inflate.findViewById(i.background);
        this.f12050g = (TextView) inflate.findViewById(i.cancel);
        this.f12052i = (int) context.getResources().getDimension(g.aiapp_menu_cancel_btn_height);
    }
}
