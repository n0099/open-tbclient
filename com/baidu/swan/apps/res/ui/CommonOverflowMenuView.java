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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.ln2;
import com.baidu.tieba.o33;
import com.baidu.tieba.p33;
import com.baidu.tieba.s93;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class CommonOverflowMenuView extends LinearLayout implements o33.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public ColorStateList c;
    public List<ImageView> d;
    public List<TextView> e;
    public HashMap<p33, ImageView> f;
    public View g;
    public LinearLayout h;
    public SwanAppScrollView i;
    public Object j;

    /* loaded from: classes3.dex */
    public class a implements s93 {
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
        this.b = R.color.obfuscated_res_0x7f0603c8;
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new HashMap<>();
        new SparseArray();
        this.j = new Object();
        a(context);
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
        this.b = R.color.obfuscated_res_0x7f0603c8;
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new HashMap<>();
        new SparseArray();
        this.j = new Object();
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d00bd, (ViewGroup) this, true);
            this.g = inflate;
            this.h = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0915a4);
            this.i = (SwanAppScrollView) this.g.findViewById(R.id.obfuscated_res_0x7f0915a7);
            setFocusable(true);
            setFocusableInTouchMode(true);
            b();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c = AppCompatResources.getColorStateList(getContext(), R.color.obfuscated_res_0x7f0603ab);
            setBackground(getResources().getDrawable(R.drawable.obfuscated_res_0x7f08014b));
            for (ImageView imageView : this.d) {
                imageView.setBackgroundColor(getResources().getColor(this.b));
            }
            for (TextView textView : this.e) {
                textView.setTextColor(this.c);
            }
            for (Map.Entry<p33, ImageView> entry : this.f.entrySet()) {
                entry.getValue().setImageDrawable(entry.getKey().b());
            }
        }
    }

    public int getItemBgRes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public LinearLayout getLinearContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.h;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public ColorStateList getTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (ColorStateList) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onAttachedToWindow();
            ln2.M().f(this.j, new a(this));
            b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetachedFromWindow();
            ln2.M().g(this.j);
        }
    }

    public void setItemBackground(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.a = i;
        }
    }

    public void setItemTextColor(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.c = AppCompatResources.getColorStateList(getContext(), i);
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

    public void setItemDivider(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
            this.b = i;
        }
    }
}
