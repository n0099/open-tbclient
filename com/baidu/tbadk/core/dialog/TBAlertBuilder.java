package com.baidu.tbadk.core.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.ii;
import com.baidu.tieba.r05;
import com.baidu.tieba.r25;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class TBAlertBuilder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AlertDialog.Builder a;
    public final Activity b;
    public boolean c;
    public AlertDialog d;
    public View e;
    public CharSequence f;
    public CharSequence g;
    public CharSequence h;
    public int i;
    public boolean j;
    public MovementMethod k;
    public View l;
    public TBAlertConfig.b m;
    public boolean n;
    public boolean o;
    public View.OnClickListener p;
    public View.OnClickListener q;
    public boolean r;
    public LinearLayout s;
    public r05 t;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextView a;
        public final /* synthetic */ View b;

        public a(TBAlertBuilder tBAlertBuilder, TextView textView, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBAlertBuilder, textView, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = textView;
            this.b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && UtilHelper.getDimenPixelSize(R.dimen.tbds868) == this.a.getHeight()) {
                this.b.setVisibility(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBAlertBuilder a;

        public b(TBAlertBuilder tBAlertBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBAlertBuilder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBAlertBuilder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.d != null) {
                this.a.d.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBAlertBuilder a;

        public c(TBAlertBuilder tBAlertBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBAlertBuilder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBAlertBuilder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.d != null) {
                    this.a.d.dismiss();
                }
                if (this.a.q != null) {
                    this.a.q.onClick(view2);
                }
            }
        }
    }

    public TBAlertBuilder(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = 17;
        this.k = ScrollingMovementMethod.getInstance();
        this.b = activity;
        this.a = new AlertDialog.Builder(activity);
        this.t = new r05();
    }

    public static void e(@NonNull Dialog dialog) {
        Window window;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, dialog) != null) || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawableResource(17170445);
    }

    public static void f(@NonNull Dialog dialog) {
        Window window;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, dialog) != null) || (window = dialog.getWindow()) == null) {
            return;
        }
        Context context = dialog.getContext();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = h(context);
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setAttributes(attributes);
    }

    public static int h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            int i = context.getResources().getDisplayMetrics().widthPixels;
            int i2 = (i * 837) / 1076;
            int g = ii.g(context, R.dimen.tbds756);
            if (i2 < g) {
                return Math.min(i, g);
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public AlertDialog A(AlertDialog alertDialog) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, alertDialog)) == null) {
            GreyUtil.grey(alertDialog);
            alertDialog.show();
            e(alertDialog);
            f(alertDialog);
            return alertDialog;
        }
        return (AlertDialog) invokeL.objValue;
    }

    public TBAlertBuilder j(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            this.a.setCancelable(z);
            return this;
        }
        return (TBAlertBuilder) invokeZ.objValue;
    }

    public TBAlertBuilder k(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view2)) == null) {
            this.l = view2;
            return this;
        }
        return (TBAlertBuilder) invokeL.objValue;
    }

    public TBAlertBuilder l(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2)) == null) {
            this.e = view2;
            return this;
        }
        return (TBAlertBuilder) invokeL.objValue;
    }

    public TBAlertBuilder m(@StringRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            this.h = TbadkCoreApplication.getInst().getResources().getString(i);
            return this;
        }
        return (TBAlertBuilder) invokeI.objValue;
    }

    public TBAlertBuilder n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            this.i = i;
            return this;
        }
        return (TBAlertBuilder) invokeI.objValue;
    }

    public TBAlertBuilder o(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            this.j = z;
            return this;
        }
        return (TBAlertBuilder) invokeZ.objValue;
    }

    public TBAlertBuilder p(MovementMethod movementMethod) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, movementMethod)) == null) {
            this.k = movementMethod;
            return this;
        }
        return (TBAlertBuilder) invokeL.objValue;
    }

    public TBAlertBuilder q(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, charSequence)) == null) {
            this.h = charSequence;
            return this;
        }
        return (TBAlertBuilder) invokeL.objValue;
    }

    public TBAlertBuilder r(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
            this.r = z;
            return this;
        }
        return (TBAlertBuilder) invokeZ.objValue;
    }

    public TBAlertBuilder s(DialogInterface.OnDismissListener onDismissListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, onDismissListener)) == null) {
            this.a.setOnDismissListener(onDismissListener);
            return this;
        }
        return (TBAlertBuilder) invokeL.objValue;
    }

    public TBAlertBuilder t(DialogInterface.OnKeyListener onKeyListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, onKeyListener)) == null) {
            this.a.setOnKeyListener(onKeyListener);
            return this;
        }
        return (TBAlertBuilder) invokeL.objValue;
    }

    public TBAlertBuilder v(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048594, this, z)) == null) {
            this.n = z;
            return this;
        }
        return (TBAlertBuilder) invokeZ.objValue;
    }

    public TBAlertBuilder w(@StringRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            this.f = TbadkCoreApplication.getInst().getResources().getString(i);
            return this;
        }
        return (TBAlertBuilder) invokeI.objValue;
    }

    public TBAlertBuilder x(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, charSequence)) == null) {
            this.f = charSequence;
            return this;
        }
        return (TBAlertBuilder) invokeL.objValue;
    }

    public final void c(View view2, boolean z) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, z) == null) {
            r25 d = r25.d(view2);
            if (this.e == null) {
                i = 0;
            } else {
                i = 2;
            }
            d.n(i);
            d.o(R.string.J_X06);
            if (z) {
                i2 = R.color.transparent;
            } else {
                i2 = R.color.CAM_X0205;
            }
            d.f(i2);
        }
    }

    public AlertDialog d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!this.c) {
                this.c = true;
                y();
                this.d = this.a.create();
            }
            return this.d;
        }
        return (AlertDialog) invokeV.objValue;
    }

    @Keep
    public void dismiss() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (alertDialog = this.d) != null) {
            alertDialog.dismiss();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c(this.s, this.r);
            this.t.g();
        }
    }

    public TBAlertBuilder i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            this.o = true;
            return this;
        }
        return (TBAlertBuilder) invokeV.objValue;
    }

    public AlertDialog z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            AlertDialog d = d();
            A(d);
            return d;
        }
        return (AlertDialog) invokeV.objValue;
    }

    public TBAlertBuilder u(TBAlertConfig.a... aVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, aVarArr)) == null) {
            int length = aVarArr.length;
            if (length != 1) {
                if (length != 2) {
                    if (length == 3) {
                        this.m = TBAlertConfig.b(aVarArr[0], aVarArr[1], aVarArr[2]);
                    }
                } else {
                    this.m = TBAlertConfig.c(aVarArr[0], aVarArr[1]);
                }
            } else {
                this.m = TBAlertConfig.a(aVarArr[0]);
            }
            return this;
        }
        return (TBAlertBuilder) invokeL.objValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            LinearLayout linearLayout = new LinearLayout(this.b);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            View view2 = this.e;
            if (view2 != null) {
                if (view2.getLayoutParams() == null) {
                    linearLayout.addView(this.e, new ViewGroup.LayoutParams(-1, -2));
                } else {
                    linearLayout.addView(this.e);
                }
            }
            LinearLayout linearLayout2 = new LinearLayout(this.b);
            this.s = linearLayout2;
            linearLayout2.setOrientation(1);
            this.s.setGravity(17);
            this.s.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            c(this.s, this.r);
            if (!TextUtils.isEmpty(this.f)) {
                TextView l = this.t.l(this.b);
                l.setText(this.f);
                l.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), UtilHelper.getDimenPixelSize(R.dimen.M_H_X009), UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), UtilHelper.getDimenPixelSize(R.dimen.M_H_X007));
                this.s.addView(l);
                CharSequence charSequence = this.g;
                if (charSequence != null && !StringUtils.isNull(charSequence.toString())) {
                    l.setPadding(l.getPaddingLeft(), l.getPaddingTop(), l.getPaddingRight(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                    TextView l2 = this.t.l(this.b);
                    l2.setText(this.g);
                    l2.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), UtilHelper.getDimenPixelSize(R.dimen.M_H_X007));
                    this.s.addView(l2);
                }
            }
            if (!TextUtils.isEmpty(this.h)) {
                RelativeLayout relativeLayout = new RelativeLayout(this.b);
                relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                TextView b2 = this.t.b(this.b, this.j);
                b2.setText(this.h);
                b2.setGravity(this.i);
                b2.setId(R.id.obfuscated_res_0x7f090842);
                b2.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), 0);
                b2.setMaxHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds868));
                b2.setMovementMethod(this.k);
                relativeLayout.addView(b2, new ViewGroup.LayoutParams(-1, -2));
                View view3 = new View(this.b);
                view3.setVisibility(4);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(R.dimen.tbds104));
                layoutParams.addRule(8, R.id.obfuscated_res_0x7f090842);
                SkinManager.setBackgroundColorToTransparent(view3, R.color.CAM_X0205, GradientDrawable.Orientation.BOTTOM_TOP);
                relativeLayout.addView(view3, layoutParams);
                this.s.addView(relativeLayout);
                b2.post(new a(this, b2, view3));
            }
            View view4 = this.l;
            if (view4 != null) {
                if (view4.getLayoutParams() == null) {
                    this.s.addView(this.l, new ViewGroup.LayoutParams(-1, -2));
                } else {
                    this.s.addView(this.l);
                }
            }
            if (this.m != null) {
                if (this.o) {
                    this.p = new b(this);
                }
                this.s.addView(this.t.j(this.b, this.m, this.p));
            }
            linearLayout.addView(this.s, new ViewGroup.LayoutParams(-1, -2));
            if (this.n) {
                ImageView imageView = new ImageView(this.b);
                imageView.setImageResource(R.drawable.icon_mask_pop_close);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds104), ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds105));
                layoutParams2.setMargins(0, ii.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X010), 0, 0);
                imageView.setOnClickListener(new c(this));
                linearLayout.addView(imageView, layoutParams2);
            }
            this.a.setView(linearLayout);
        }
    }
}
