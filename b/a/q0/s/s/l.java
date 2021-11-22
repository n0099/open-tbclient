package b.a.q0.s.s;

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
/* loaded from: classes4.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final AlertDialog.Builder f14372a;

    /* renamed from: b  reason: collision with root package name */
    public final Activity f14373b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f14374c;

    /* renamed from: d  reason: collision with root package name */
    public AlertDialog f14375d;

    /* renamed from: e  reason: collision with root package name */
    public View f14376e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f14377f;

    /* renamed from: g  reason: collision with root package name */
    public CharSequence f14378g;

    /* renamed from: h  reason: collision with root package name */
    public int f14379h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14380i;
    public MovementMethod j;
    public View k;
    public TBAlertConfig.b l;
    public boolean m;
    public boolean n;
    public View.OnClickListener o;
    public View.OnClickListener p;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f14381e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f14382f;

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
            this.f14381e = textView;
            this.f14382f = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && UtilHelper.getDimenPixelSize(R.dimen.tbds868) == this.f14381e.getHeight()) {
                this.f14382f.setVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f14383e;

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
            this.f14383e = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f14383e.f14375d == null) {
                return;
            }
            this.f14383e.f14375d.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f14384e;

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
            this.f14384e = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f14384e.f14375d != null) {
                    this.f14384e.f14375d.dismiss();
                }
                if (this.f14384e.p != null) {
                    this.f14384e.p.onClick(view);
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
        this.f14379h = 17;
        this.j = ScrollingMovementMethod.getInstance();
        this.f14373b = activity;
        this.f14372a = new AlertDialog.Builder(activity);
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
        int g2 = b.a.e.f.p.l.g(context, R.dimen.tbds756);
        if (i3 < g2) {
            i3 = Math.min(i2, g2);
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
            if (!this.f14374c) {
                this.f14374c = true;
                s();
                this.f14375d = this.f14372a.create();
            }
            return this.f14375d;
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
            this.f14372a.setCancelable(z);
            return this;
        }
        return (l) invokeZ.objValue;
    }

    public l h(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view)) == null) {
            this.k = view;
            return this;
        }
        return (l) invokeL.objValue;
    }

    public l i(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) {
            this.f14376e = view;
            return this;
        }
        return (l) invokeL.objValue;
    }

    public l j(@StringRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            this.f14378g = TbadkCoreApplication.getInst().getResources().getString(i2);
            return this;
        }
        return (l) invokeI.objValue;
    }

    public l k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            this.f14379h = i2;
            return this;
        }
        return (l) invokeI.objValue;
    }

    public l l(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.f14380i = z;
            return this;
        }
        return (l) invokeZ.objValue;
    }

    public l m(MovementMethod movementMethod) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, movementMethod)) == null) {
            this.j = movementMethod;
            return this;
        }
        return (l) invokeL.objValue;
    }

    public l n(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, charSequence)) == null) {
            this.f14378g = charSequence;
            return this;
        }
        return (l) invokeL.objValue;
    }

    public l o(DialogInterface.OnDismissListener onDismissListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, onDismissListener)) == null) {
            this.f14372a.setOnDismissListener(onDismissListener);
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
            this.f14377f = TbadkCoreApplication.getInst().getResources().getString(i2);
            return this;
        }
        return (l) invokeI.objValue;
    }

    public l r(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, charSequence)) == null) {
            this.f14377f = charSequence;
            return this;
        }
        return (l) invokeL.objValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            LinearLayout linearLayout = new LinearLayout(this.f14373b);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            View view = this.f14376e;
            if (view != null) {
                if (view.getLayoutParams() == null) {
                    linearLayout.addView(this.f14376e, new ViewGroup.LayoutParams(-1, -2));
                } else {
                    linearLayout.addView(this.f14376e);
                }
            }
            LinearLayout linearLayout2 = new LinearLayout(this.f14373b);
            linearLayout2.setOrientation(1);
            linearLayout2.setGravity(17);
            linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(linearLayout2);
            d2.m(this.f14376e == null ? 0 : 2);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
            TextView k = m.k(this.f14373b);
            k.setText(this.f14377f);
            k.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), UtilHelper.getDimenPixelSize(R.dimen.M_H_X009), UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), UtilHelper.getDimenPixelSize(R.dimen.M_H_X007));
            linearLayout2.addView(k);
            if (!TextUtils.isEmpty(this.f14378g)) {
                RelativeLayout relativeLayout = new RelativeLayout(this.f14373b);
                relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                TextView b2 = m.b(this.f14373b, this.f14380i);
                b2.setText(this.f14378g);
                b2.setGravity(this.f14379h);
                b2.setId(R.id.desc);
                b2.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), 0);
                b2.setMaxHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds868));
                b2.setMovementMethod(this.j);
                relativeLayout.addView(b2, new ViewGroup.LayoutParams(-1, -2));
                View view2 = new View(this.f14373b);
                view2.setVisibility(4);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(R.dimen.tbds104));
                layoutParams.addRule(8, R.id.desc);
                SkinManager.setBackgroundColorToTransparent(view2, R.color.CAM_X0205, GradientDrawable.Orientation.BOTTOM_TOP);
                relativeLayout.addView(view2, layoutParams);
                linearLayout2.addView(relativeLayout);
                b2.post(new a(this, b2, view2));
            }
            View view3 = this.k;
            if (view3 != null) {
                linearLayout2.addView(view3, new ViewGroup.LayoutParams(-1, -2));
            }
            if (this.l != null) {
                if (this.n) {
                    this.o = new b(this);
                }
                linearLayout2.addView(m.i(this.f14373b, this.l, this.o));
            }
            linearLayout.addView(linearLayout2, new ViewGroup.LayoutParams(-1, -2));
            if (this.m) {
                ImageView imageView = new ImageView(this.f14373b);
                imageView.setImageResource(R.drawable.icon_mask_pop_close);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(b.a.e.f.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds104), b.a.e.f.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds105));
                layoutParams2.setMargins(0, b.a.e.f.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X010), 0, 0);
                imageView.setOnClickListener(new c(this));
                linearLayout.addView(imageView, layoutParams2);
            }
            this.f14372a.setView(linearLayout);
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
