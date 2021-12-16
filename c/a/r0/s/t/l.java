package c.a.r0.s.t;

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
/* loaded from: classes6.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AlertDialog.Builder a;

    /* renamed from: b  reason: collision with root package name */
    public final Activity f13576b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f13577c;

    /* renamed from: d  reason: collision with root package name */
    public AlertDialog f13578d;

    /* renamed from: e  reason: collision with root package name */
    public View f13579e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f13580f;

    /* renamed from: g  reason: collision with root package name */
    public CharSequence f13581g;

    /* renamed from: h  reason: collision with root package name */
    public int f13582h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13583i;

    /* renamed from: j  reason: collision with root package name */
    public MovementMethod f13584j;

    /* renamed from: k  reason: collision with root package name */
    public View f13585k;
    public TBAlertConfig.b l;
    public boolean m;
    public boolean n;
    public View.OnClickListener o;
    public View.OnClickListener p;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f13586e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f13587f;

        public a(l lVar, TextView textView, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, textView, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13586e = textView;
            this.f13587f = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && UtilHelper.getDimenPixelSize(R.dimen.tbds868) == this.f13586e.getHeight()) {
                this.f13587f.setVisibility(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f13588e;

        public b(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13588e = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f13588e.f13578d == null) {
                return;
            }
            this.f13588e.f13578d.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f13589e;

        public c(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13589e = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f13589e.f13578d != null) {
                    this.f13589e.f13578d.dismiss();
                }
                if (this.f13589e.p != null) {
                    this.f13589e.p.onClick(view);
                }
            }
        }
    }

    public l(@NonNull Activity activity) {
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
        this.f13582h = 17;
        this.f13584j = ScrollingMovementMethod.getInstance();
        this.f13576b = activity;
        this.a = new AlertDialog.Builder(activity);
    }

    public static void d(@NonNull Dialog dialog) {
        Window window;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, dialog) == null) || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawableResource(17170445);
    }

    public static void e(@NonNull Dialog dialog) {
        Window window;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, dialog) == null) || (window = dialog.getWindow()) == null) {
            return;
        }
        Context context = dialog.getContext();
        int i2 = context.getResources().getDisplayMetrics().widthPixels;
        int i3 = (i2 * 837) / 1076;
        int f2 = c.a.d.f.p.m.f(context, R.dimen.tbds756);
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
            if (!this.f13577c) {
                this.f13577c = true;
                s();
                this.f13578d = this.a.create();
            }
            return this.f13578d;
        }
        return (AlertDialog) invokeV.objValue;
    }

    public l f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.n = true;
            return this;
        }
        return (l) invokeV.objValue;
    }

    public l g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            this.a.setCancelable(z);
            return this;
        }
        return (l) invokeZ.objValue;
    }

    public l h(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view)) == null) {
            this.f13585k = view;
            return this;
        }
        return (l) invokeL.objValue;
    }

    public l i(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) {
            this.f13579e = view;
            return this;
        }
        return (l) invokeL.objValue;
    }

    public l j(@StringRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            this.f13581g = TbadkCoreApplication.getInst().getResources().getString(i2);
            return this;
        }
        return (l) invokeI.objValue;
    }

    public l k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            this.f13582h = i2;
            return this;
        }
        return (l) invokeI.objValue;
    }

    public l l(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.f13583i = z;
            return this;
        }
        return (l) invokeZ.objValue;
    }

    public l m(MovementMethod movementMethod) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, movementMethod)) == null) {
            this.f13584j = movementMethod;
            return this;
        }
        return (l) invokeL.objValue;
    }

    public l n(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, charSequence)) == null) {
            this.f13581g = charSequence;
            return this;
        }
        return (l) invokeL.objValue;
    }

    public l o(DialogInterface.OnDismissListener onDismissListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, onDismissListener)) == null) {
            this.a.setOnDismissListener(onDismissListener);
            return this;
        }
        return (l) invokeL.objValue;
    }

    public l p(TBAlertConfig.a... aVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, aVarArr)) == null) {
            int length = aVarArr.length;
            if (length == 1) {
                this.l = TBAlertConfig.a(aVarArr[0]);
            } else if (length == 2) {
                this.l = TBAlertConfig.c(aVarArr[0], aVarArr[1]);
            } else if (length == 3) {
                this.l = TBAlertConfig.b(aVarArr[0], aVarArr[1], aVarArr[2]);
            }
            return this;
        }
        return (l) invokeL.objValue;
    }

    public l q(@StringRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            this.f13580f = TbadkCoreApplication.getInst().getResources().getString(i2);
            return this;
        }
        return (l) invokeI.objValue;
    }

    public l r(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, charSequence)) == null) {
            this.f13580f = charSequence;
            return this;
        }
        return (l) invokeL.objValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            LinearLayout linearLayout = new LinearLayout(this.f13576b);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            View view = this.f13579e;
            if (view != null) {
                if (view.getLayoutParams() == null) {
                    linearLayout.addView(this.f13579e, new ViewGroup.LayoutParams(-1, -2));
                } else {
                    linearLayout.addView(this.f13579e);
                }
            }
            LinearLayout linearLayout2 = new LinearLayout(this.f13576b);
            linearLayout2.setOrientation(1);
            linearLayout2.setGravity(17);
            linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            c.a.r0.s.v.c d2 = c.a.r0.s.v.c.d(linearLayout2);
            d2.m(this.f13579e == null ? 0 : 2);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
            TextView k2 = m.k(this.f13576b);
            k2.setText(this.f13580f);
            k2.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), UtilHelper.getDimenPixelSize(R.dimen.M_H_X009), UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), UtilHelper.getDimenPixelSize(R.dimen.M_H_X007));
            linearLayout2.addView(k2);
            if (!TextUtils.isEmpty(this.f13581g)) {
                RelativeLayout relativeLayout = new RelativeLayout(this.f13576b);
                relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                TextView b2 = m.b(this.f13576b, this.f13583i);
                b2.setText(this.f13581g);
                b2.setGravity(this.f13582h);
                b2.setId(R.id.desc);
                b2.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), 0);
                b2.setMaxHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds868));
                b2.setMovementMethod(this.f13584j);
                relativeLayout.addView(b2, new ViewGroup.LayoutParams(-1, -2));
                View view2 = new View(this.f13576b);
                view2.setVisibility(4);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(R.dimen.tbds104));
                layoutParams.addRule(8, R.id.desc);
                SkinManager.setBackgroundColorToTransparent(view2, R.color.CAM_X0205, GradientDrawable.Orientation.BOTTOM_TOP);
                relativeLayout.addView(view2, layoutParams);
                linearLayout2.addView(relativeLayout);
                b2.post(new a(this, b2, view2));
            }
            View view3 = this.f13585k;
            if (view3 != null) {
                linearLayout2.addView(view3, new ViewGroup.LayoutParams(-1, -2));
            }
            if (this.l != null) {
                if (this.n) {
                    this.o = new b(this);
                }
                linearLayout2.addView(m.i(this.f13576b, this.l, this.o));
            }
            linearLayout.addView(linearLayout2, new ViewGroup.LayoutParams(-1, -2));
            if (this.m) {
                ImageView imageView = new ImageView(this.f13576b);
                imageView.setImageResource(R.drawable.icon_mask_pop_close);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), R.dimen.tbds104), c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), R.dimen.tbds105));
                layoutParams2.setMargins(0, c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X010), 0, 0);
                imageView.setOnClickListener(new c(this));
                linearLayout.addView(imageView, layoutParams2);
            }
            this.a.setView(linearLayout);
        }
    }

    public AlertDialog t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            AlertDialog c2 = c();
            u(c2);
            return c2;
        }
        return (AlertDialog) invokeV.objValue;
    }

    public AlertDialog u(AlertDialog alertDialog) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, alertDialog)) == null) {
            alertDialog.show();
            d(alertDialog);
            e(alertDialog);
            return alertDialog;
        }
        return (AlertDialog) invokeL.objValue;
    }
}
