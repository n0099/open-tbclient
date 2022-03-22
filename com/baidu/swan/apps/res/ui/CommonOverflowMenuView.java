package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.s1.b.e.a;
import c.a.n0.a.s1.b.e.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class CommonOverflowMenuView extends LinearLayout implements a.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f29086b;

    /* renamed from: c  reason: collision with root package name */
    public ColorStateList f29087c;

    /* renamed from: d  reason: collision with root package name */
    public List<ImageView> f29088d;

    /* renamed from: e  reason: collision with root package name */
    public List<TextView> f29089e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<b, ImageView> f29090f;

    /* renamed from: g  reason: collision with root package name */
    public View f29091g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f29092h;
    public SwanAppScrollView i;
    public Object j;

    /* loaded from: classes4.dex */
    public class a implements c.a.n0.a.z1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonOverflowMenuView a;

        public a(CommonOverflowMenuView commonOverflowMenuView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonOverflowMenuView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = commonOverflowMenuView;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonOverflowMenuView(Context context) {
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
        this.a = R.drawable.obfuscated_res_0x7f08014c;
        this.f29086b = R.color.obfuscated_res_0x7f0603ae;
        this.f29088d = new ArrayList();
        this.f29089e = new ArrayList();
        this.f29090f = new HashMap<>();
        new SparseArray();
        this.j = new Object();
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d00c0, (ViewGroup) this, true);
            this.f29091g = inflate;
            this.f29092h = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0913f0);
            this.i = (SwanAppScrollView) this.f29091g.findViewById(R.id.obfuscated_res_0x7f0913f3);
            setFocusable(true);
            setFocusableInTouchMode(true);
            b();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f29087c = AppCompatResources.getColorStateList(getContext(), R.color.obfuscated_res_0x7f060391);
            setBackground(getResources().getDrawable(R.drawable.obfuscated_res_0x7f08014b));
            for (ImageView imageView : this.f29088d) {
                imageView.setBackgroundColor(getResources().getColor(this.f29086b));
            }
            for (TextView textView : this.f29089e) {
                textView.setTextColor(this.f29087c);
            }
            for (Map.Entry<b, ImageView> entry : this.f29090f.entrySet()) {
                entry.getValue().setImageDrawable(entry.getKey().b());
            }
        }
    }

    public int getItemBgRes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.intValue;
    }

    public LinearLayout getLinearContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f29092h : (LinearLayout) invokeV.objValue;
    }

    public ColorStateList getTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f29087c : (ColorStateList) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onAttachedToWindow();
            c.a.n0.a.s0.a.M().f(this.j, new a(this));
            b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetachedFromWindow();
            c.a.n0.a.s0.a.M().g(this.j);
        }
    }

    public void setItemBackground(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.a = i;
        }
    }

    public void setItemDivider(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
            this.f29086b = i;
        }
    }

    public void setItemTextColor(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.f29087c = AppCompatResources.getColorStateList(getContext(), i);
        }
    }

    public void setMaxHeightPixel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.i.setMaxHeight(i);
        }
    }

    public void setMaxHeightRes(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.i.setMaxHeight(getContext().getResources().getDimensionPixelSize(i));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonOverflowMenuView(Context context, AttributeSet attributeSet) {
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
        this.a = R.drawable.obfuscated_res_0x7f08014c;
        this.f29086b = R.color.obfuscated_res_0x7f0603ae;
        this.f29088d = new ArrayList();
        this.f29089e = new ArrayList();
        this.f29090f = new HashMap<>();
        new SparseArray();
        this.j = new Object();
        a(context);
    }
}
