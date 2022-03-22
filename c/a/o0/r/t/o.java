package c.a.o0.r.t;

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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AlertDialog.Builder a;

    /* renamed from: b  reason: collision with root package name */
    public final Activity f11086b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f11087c;

    /* renamed from: d  reason: collision with root package name */
    public AlertDialog f11088d;

    /* renamed from: e  reason: collision with root package name */
    public View f11089e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f11090f;

    /* renamed from: g  reason: collision with root package name */
    public CharSequence f11091g;

    /* renamed from: h  reason: collision with root package name */
    public CharSequence f11092h;
    public int i;
    public boolean j;
    public MovementMethod k;
    public View l;
    public TBAlertConfig.b m;
    public boolean n;
    public boolean o;
    public View.OnClickListener p;
    public View.OnClickListener q;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f11093b;

        public a(o oVar, TextView textView, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar, textView, view};
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
            this.f11093b = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && UtilHelper.getDimenPixelSize(R.dimen.tbds868) == this.a.getHeight()) {
                this.f11093b.setVisibility(0);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o a;

        public b(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f11088d == null) {
                return;
            }
            this.a.f11088d.dismiss();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o a;

        public c(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.f11088d != null) {
                    this.a.f11088d.dismiss();
                }
                if (this.a.q != null) {
                    this.a.q.onClick(view);
                }
            }
        }
    }

    public o(@NonNull Activity activity) {
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
        this.f11086b = activity;
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
        int i = context.getResources().getDisplayMetrics().widthPixels;
        int i2 = (i * 837) / 1076;
        int f2 = c.a.d.f.p.n.f(context, R.dimen.tbds756);
        if (i2 < f2) {
            i2 = Math.min(i, f2);
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = i2;
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setAttributes(attributes);
    }

    public AlertDialog c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!this.f11087c) {
                this.f11087c = true;
                x();
                this.f11088d = this.a.create();
            }
            return this.f11088d;
        }
        return (AlertDialog) invokeV.objValue;
    }

    public void d() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (alertDialog = this.f11088d) == null) {
            return;
        }
        alertDialog.dismiss();
    }

    public o g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.o = true;
            return this;
        }
        return (o) invokeV.objValue;
    }

    public o h(View.OnClickListener onClickListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, onClickListener)) == null) {
            this.q = onClickListener;
            return this;
        }
        return (o) invokeL.objValue;
    }

    public o i(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            this.a.setCancelable(z);
            return this;
        }
        return (o) invokeZ.objValue;
    }

    public o j(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view)) == null) {
            this.l = view;
            return this;
        }
        return (o) invokeL.objValue;
    }

    public o k(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view)) == null) {
            this.f11089e = view;
            return this;
        }
        return (o) invokeL.objValue;
    }

    public o l(@StringRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            this.f11092h = TbadkCoreApplication.getInst().getResources().getString(i);
            return this;
        }
        return (o) invokeI.objValue;
    }

    public o m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            this.i = i;
            return this;
        }
        return (o) invokeI.objValue;
    }

    public o n(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            this.j = z;
            return this;
        }
        return (o) invokeZ.objValue;
    }

    public o o(MovementMethod movementMethod) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, movementMethod)) == null) {
            this.k = movementMethod;
            return this;
        }
        return (o) invokeL.objValue;
    }

    public o p(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, charSequence)) == null) {
            this.f11092h = charSequence;
            return this;
        }
        return (o) invokeL.objValue;
    }

    public o q(DialogInterface.OnDismissListener onDismissListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, onDismissListener)) == null) {
            this.a.setOnDismissListener(onDismissListener);
            return this;
        }
        return (o) invokeL.objValue;
    }

    public o r(TBAlertConfig.a... aVarArr) {
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
        return (o) invokeL.objValue;
    }

    public o s(TBAlertConfig.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, bVar)) == null) {
            this.m = bVar;
            return this;
        }
        return (o) invokeL.objValue;
    }

    public o t(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            this.n = z;
            return this;
        }
        return (o) invokeZ.objValue;
    }

    public o u(@StringRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            this.f11091g = TbadkCoreApplication.getInst().getResources().getString(i);
            return this;
        }
        return (o) invokeI.objValue;
    }

    public o v(@StringRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            this.f11090f = TbadkCoreApplication.getInst().getResources().getString(i);
            return this;
        }
        return (o) invokeI.objValue;
    }

    public o w(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, charSequence)) == null) {
            this.f11090f = charSequence;
            return this;
        }
        return (o) invokeL.objValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            LinearLayout linearLayout = new LinearLayout(this.f11086b);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            View view = this.f11089e;
            if (view != null) {
                if (view.getLayoutParams() == null) {
                    linearLayout.addView(this.f11089e, new ViewGroup.LayoutParams(-1, -2));
                } else {
                    linearLayout.addView(this.f11089e);
                }
            }
            LinearLayout linearLayout2 = new LinearLayout(this.f11086b);
            linearLayout2.setOrientation(1);
            linearLayout2.setGravity(17);
            linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(linearLayout2);
            d2.m(this.f11089e == null ? 0 : 2);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
            TextView k = p.k(this.f11086b);
            k.setText(this.f11090f);
            k.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), UtilHelper.getDimenPixelSize(R.dimen.M_H_X009), UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), UtilHelper.getDimenPixelSize(R.dimen.M_H_X007));
            linearLayout2.addView(k);
            CharSequence charSequence = this.f11091g;
            if (charSequence != null && !StringUtils.isNull(charSequence.toString())) {
                k.setPadding(k.getPaddingLeft(), k.getPaddingTop(), k.getPaddingRight(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                TextView k2 = p.k(this.f11086b);
                k2.setText(this.f11091g);
                k2.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), UtilHelper.getDimenPixelSize(R.dimen.M_H_X007));
                linearLayout2.addView(k2);
            }
            if (!TextUtils.isEmpty(this.f11092h)) {
                RelativeLayout relativeLayout = new RelativeLayout(this.f11086b);
                relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                TextView b2 = p.b(this.f11086b, this.j);
                b2.setText(this.f11092h);
                b2.setGravity(this.i);
                b2.setId(R.id.obfuscated_res_0x7f090777);
                b2.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), 0);
                b2.setMaxHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds868));
                b2.setMovementMethod(this.k);
                relativeLayout.addView(b2, new ViewGroup.LayoutParams(-1, -2));
                View view2 = new View(this.f11086b);
                view2.setVisibility(4);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(R.dimen.tbds104));
                layoutParams.addRule(8, R.id.obfuscated_res_0x7f090777);
                SkinManager.setBackgroundColorToTransparent(view2, R.color.CAM_X0205, GradientDrawable.Orientation.BOTTOM_TOP);
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
                linearLayout2.addView(p.i(this.f11086b, this.m, this.p));
            }
            linearLayout.addView(linearLayout2, new ViewGroup.LayoutParams(-1, -2));
            if (this.n) {
                ImageView imageView = new ImageView(this.f11086b);
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f080807);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds104), c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds105));
                layoutParams2.setMargins(0, c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X010), 0, 0);
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
