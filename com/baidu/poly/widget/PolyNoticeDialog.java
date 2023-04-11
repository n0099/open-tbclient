package com.baidu.poly.widget;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class PolyNoticeDialog extends BaseDialogFragment implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public ImageView c;
    public TextView d;
    public LinearLayout e;
    public TextView f;
    public TextView g;
    public a h;

    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void onDismiss();

        void onOptionClick(int i);
    }

    @Override // com.baidu.poly.widget.BaseDialogFragment
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d078f : invokeV.intValue;
    }

    public PolyNoticeDialog() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.c.setVisibility(0);
            this.c.startAnimation(AnimationUtils.loadAnimation(this.c.getContext(), R.anim.obfuscated_res_0x7f0100a3));
        }
    }

    public void i() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (imageView = this.c) != null) {
            imageView.clearAnimation();
            this.c.setVisibility(8);
        }
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            this.d.setVisibility(8);
            this.e.setVisibility(0);
            this.f.setText(str);
            this.g.setText(str2);
        }
    }

    public void c(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.h = aVar;
        }
    }

    public void d(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (textView = this.g) != null) {
            textView.setEnabled(z);
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.d.setVisibility(0);
            this.d.setText(str);
            this.e.setVisibility(8);
        }
    }

    public void f(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && (textView = this.b) != null) {
            textView.setText(str);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.a.setText(str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, view2) == null) && (aVar = this.h) != null) {
            aVar.onOptionClick(view2.getId());
        }
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dialogInterface) == null) {
            super.onDismiss(dialogInterface);
            a aVar = this.h;
            if (aVar != null) {
                aVar.onDismiss();
            }
        }
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, view2, bundle) == null) {
            super.onViewCreated(view2, bundle);
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b94);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b93);
            this.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091b90);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b92);
            this.e = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091b8e);
            this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b8f);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b91);
            this.d.setOnClickListener(this);
            this.f.setOnClickListener(this);
            this.g.setOnClickListener(this);
            a aVar = this.h;
            if (aVar != null) {
                aVar.a();
            }
        }
    }
}
