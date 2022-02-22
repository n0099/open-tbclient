package c.a.t0.s.t;

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
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AlertDialog.Builder a;

    /* renamed from: b  reason: collision with root package name */
    public final Activity f14095b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f14096c;

    /* renamed from: d  reason: collision with root package name */
    public AlertDialog f14097d;

    /* renamed from: e  reason: collision with root package name */
    public View f14098e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f14099f;

    /* renamed from: g  reason: collision with root package name */
    public CharSequence f14100g;

    /* renamed from: h  reason: collision with root package name */
    public CharSequence f14101h;

    /* renamed from: i  reason: collision with root package name */
    public int f14102i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f14103j;
    public MovementMethod k;
    public View l;
    public TBAlertConfig.b m;
    public boolean n;
    public boolean o;
    public View.OnClickListener p;
    public View.OnClickListener q;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f14104e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f14105f;

        public a(m mVar, TextView textView, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, textView, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14104e = textView;
            this.f14105f = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && UtilHelper.getDimenPixelSize(c.a.u0.a4.e.tbds868) == this.f14104e.getHeight()) {
                this.f14105f.setVisibility(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f14106e;

        public b(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14106e = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f14106e.f14097d == null) {
                return;
            }
            this.f14106e.f14097d.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f14107e;

        public c(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14107e = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f14107e.f14097d != null) {
                    this.f14107e.f14097d.dismiss();
                }
                if (this.f14107e.q != null) {
                    this.f14107e.q.onClick(view);
                }
            }
        }
    }

    public m(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14102i = 17;
        this.k = ScrollingMovementMethod.getInstance();
        this.f14095b = activity;
        this.a = new AlertDialog.Builder(activity);
    }

    public static void e(@NonNull Dialog dialog) {
        Window window;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, dialog) == null) || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawableResource(17170445);
    }

    public static void f(@NonNull Dialog dialog) {
        Window window;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, dialog) == null) || (window = dialog.getWindow()) == null) {
            return;
        }
        Context context = dialog.getContext();
        int i2 = context.getResources().getDisplayMetrics().widthPixels;
        int i3 = (i2 * 837) / 1076;
        int f2 = c.a.d.f.p.n.f(context, c.a.u0.a4.e.tbds756);
        if (i3 < f2) {
            i3 = Math.min(i2, f2);
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = i3;
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setAttributes(attributes);
    }

    public AlertDialog c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!this.f14096c) {
                this.f14096c = true;
                x();
                this.f14097d = this.a.create();
            }
            return this.f14097d;
        }
        return (AlertDialog) invokeV.objValue;
    }

    public void d() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (alertDialog = this.f14097d) == null) {
            return;
        }
        alertDialog.dismiss();
    }

    public m g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.o = true;
            return this;
        }
        return (m) invokeV.objValue;
    }

    public m h(View.OnClickListener onClickListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, onClickListener)) == null) {
            this.q = onClickListener;
            return this;
        }
        return (m) invokeL.objValue;
    }

    public m i(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            this.a.setCancelable(z);
            return this;
        }
        return (m) invokeZ.objValue;
    }

    public m j(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view)) == null) {
            this.l = view;
            return this;
        }
        return (m) invokeL.objValue;
    }

    public m k(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view)) == null) {
            this.f14098e = view;
            return this;
        }
        return (m) invokeL.objValue;
    }

    public m l(@StringRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            this.f14101h = TbadkCoreApplication.getInst().getResources().getString(i2);
            return this;
        }
        return (m) invokeI.objValue;
    }

    public m m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            this.f14102i = i2;
            return this;
        }
        return (m) invokeI.objValue;
    }

    public m n(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            this.f14103j = z;
            return this;
        }
        return (m) invokeZ.objValue;
    }

    public m o(MovementMethod movementMethod) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, movementMethod)) == null) {
            this.k = movementMethod;
            return this;
        }
        return (m) invokeL.objValue;
    }

    public m p(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, charSequence)) == null) {
            this.f14101h = charSequence;
            return this;
        }
        return (m) invokeL.objValue;
    }

    public m q(DialogInterface.OnDismissListener onDismissListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, onDismissListener)) == null) {
            this.a.setOnDismissListener(onDismissListener);
            return this;
        }
        return (m) invokeL.objValue;
    }

    public m r(TBAlertConfig.a... aVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, aVarArr)) == null) {
            int length = aVarArr.length;
            if (length == 1) {
                this.m = TBAlertConfig.a(aVarArr[0]);
            } else if (length == 2) {
                this.m = TBAlertConfig.c(aVarArr[0], aVarArr[1]);
            } else if (length == 3) {
                this.m = TBAlertConfig.b(aVarArr[0], aVarArr[1], aVarArr[2]);
            }
            return this;
        }
        return (m) invokeL.objValue;
    }

    public m s(TBAlertConfig.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, bVar)) == null) {
            this.m = bVar;
            return this;
        }
        return (m) invokeL.objValue;
    }

    public m t(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            this.n = z;
            return this;
        }
        return (m) invokeZ.objValue;
    }

    public m u(@StringRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            this.f14100g = TbadkCoreApplication.getInst().getResources().getString(i2);
            return this;
        }
        return (m) invokeI.objValue;
    }

    public m v(@StringRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
            this.f14099f = TbadkCoreApplication.getInst().getResources().getString(i2);
            return this;
        }
        return (m) invokeI.objValue;
    }

    public m w(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, charSequence)) == null) {
            this.f14099f = charSequence;
            return this;
        }
        return (m) invokeL.objValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            LinearLayout linearLayout = new LinearLayout(this.f14095b);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            View view = this.f14098e;
            if (view != null) {
                if (view.getLayoutParams() == null) {
                    linearLayout.addView(this.f14098e, new ViewGroup.LayoutParams(-1, -2));
                } else {
                    linearLayout.addView(this.f14098e);
                }
            }
            LinearLayout linearLayout2 = new LinearLayout(this.f14095b);
            linearLayout2.setOrientation(1);
            linearLayout2.setGravity(17);
            linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            c.a.t0.s.v.c d2 = c.a.t0.s.v.c.d(linearLayout2);
            d2.m(this.f14098e == null ? 0 : 2);
            d2.n(c.a.u0.a4.j.J_X06);
            d2.f(c.a.u0.a4.d.CAM_X0205);
            TextView k = n.k(this.f14095b);
            k.setText(this.f14099f);
            k.setPadding(UtilHelper.getDimenPixelSize(c.a.u0.a4.e.M_W_X013), UtilHelper.getDimenPixelSize(c.a.u0.a4.e.M_H_X009), UtilHelper.getDimenPixelSize(c.a.u0.a4.e.M_W_X013), UtilHelper.getDimenPixelSize(c.a.u0.a4.e.M_H_X007));
            linearLayout2.addView(k);
            CharSequence charSequence = this.f14100g;
            if (charSequence != null && !StringUtils.isNull(charSequence.toString())) {
                k.setPadding(k.getPaddingLeft(), k.getPaddingTop(), k.getPaddingRight(), UtilHelper.getDimenPixelSize(c.a.u0.a4.e.M_H_X003));
                TextView k2 = n.k(this.f14095b);
                k2.setText(this.f14100g);
                k2.setPadding(UtilHelper.getDimenPixelSize(c.a.u0.a4.e.M_W_X013), 0, UtilHelper.getDimenPixelSize(c.a.u0.a4.e.M_W_X013), UtilHelper.getDimenPixelSize(c.a.u0.a4.e.M_H_X007));
                linearLayout2.addView(k2);
            }
            if (!TextUtils.isEmpty(this.f14101h)) {
                RelativeLayout relativeLayout = new RelativeLayout(this.f14095b);
                relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                TextView b2 = n.b(this.f14095b, this.f14103j);
                b2.setText(this.f14101h);
                b2.setGravity(this.f14102i);
                b2.setId(c.a.u0.a4.g.desc);
                b2.setPadding(UtilHelper.getDimenPixelSize(c.a.u0.a4.e.M_W_X013), 0, UtilHelper.getDimenPixelSize(c.a.u0.a4.e.M_W_X013), 0);
                b2.setMaxHeight(UtilHelper.getDimenPixelSize(c.a.u0.a4.e.tbds868));
                b2.setMovementMethod(this.k);
                relativeLayout.addView(b2, new ViewGroup.LayoutParams(-1, -2));
                View view2 = new View(this.f14095b);
                view2.setVisibility(4);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(c.a.u0.a4.e.tbds104));
                layoutParams.addRule(8, c.a.u0.a4.g.desc);
                SkinManager.setBackgroundColorToTransparent(view2, c.a.u0.a4.d.CAM_X0205, GradientDrawable.Orientation.BOTTOM_TOP);
                relativeLayout.addView(view2, layoutParams);
                linearLayout2.addView(relativeLayout);
                b2.post(new a(this, b2, view2));
            }
            View view3 = this.l;
            if (view3 != null) {
                linearLayout2.addView(view3, new ViewGroup.LayoutParams(-1, -2));
            }
            if (this.m != null) {
                if (this.o) {
                    this.p = new b(this);
                }
                linearLayout2.addView(n.i(this.f14095b, this.m, this.p));
            }
            linearLayout.addView(linearLayout2, new ViewGroup.LayoutParams(-1, -2));
            if (this.n) {
                ImageView imageView = new ImageView(this.f14095b);
                imageView.setImageResource(c.a.u0.a4.f.icon_mask_pop_close);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.u0.a4.e.tbds104), c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.u0.a4.e.tbds105));
                layoutParams2.setMargins(0, c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.u0.a4.e.M_H_X010), 0, 0);
                imageView.setOnClickListener(new c(this));
                linearLayout.addView(imageView, layoutParams2);
            }
            this.a.setView(linearLayout);
        }
    }

    public AlertDialog y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            AlertDialog c2 = c();
            z(c2);
            return c2;
        }
        return (AlertDialog) invokeV.objValue;
    }

    public AlertDialog z(AlertDialog alertDialog) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, alertDialog)) == null) {
            alertDialog.show();
            e(alertDialog);
            f(alertDialog);
            return alertDialog;
        }
        return (AlertDialog) invokeL.objValue;
    }
}
