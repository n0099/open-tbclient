package com.baidu.swan.apps.res.widget.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.swan.apps.res.ui.SwanAppScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.dl3;
import com.baidu.tieba.ds2;
import com.baidu.tieba.fl3;
import com.baidu.tieba.gp1;
import com.baidu.tieba.qm3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class BaseActivityDialog extends Activity implements DialogInterface {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean q;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public LinearLayout c;
    public TextView d;
    public TextView e;
    public TextView f;
    public View g;
    public View h;
    public View i;
    public FrameLayout j;
    public ImageView k;
    public RelativeLayout l;
    public e m;
    public SwanAppScrollView n;
    public LinearLayout o;
    public int p;

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public static volatile HashMap<String, e> t;
        public static ArrayList u;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public CharSequence b;
        public String c;
        public String d;
        public View e;
        public Drawable f;
        public boolean g;
        public int h;
        public Bundle i;
        public DialogInterface.OnClickListener j;
        public DialogInterface.OnClickListener k;
        public DialogInterface.OnCancelListener l;
        public DialogInterface.OnDismissListener m;
        public Context n;
        public Class<? extends Activity> o;
        public int p;
        public String q;
        public Object r;
        public boolean s;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ boolean a;
            public final /* synthetic */ e b;

            public a(e eVar, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = eVar;
                this.a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Context appContext = AppRuntime.getAppContext();
                    if (this.b.o == null) {
                        this.b.o = BaseActivityDialog.class;
                    }
                    Intent intent = new Intent(appContext, this.b.o);
                    intent.putExtra("BOX_ACTIVITY_DIALOG_NIGHT_MODE", this.a);
                    String valueOf = String.valueOf(intent.hashCode());
                    intent.putExtra("BOX_ACTIVITY_DIALOG_FOR_BUILDER", valueOf);
                    if (!TextUtils.isEmpty(this.b.q)) {
                        intent.putExtra("BOX_ACTIVITY_DIALOG_FROM", this.b.q);
                    }
                    if (this.b.i != null) {
                        intent.putExtras(this.b.i);
                    }
                    e.t(valueOf, this.b);
                    intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                    fl3.g(appContext, intent);
                }
            }
        }

        /* loaded from: classes3.dex */
        public static class b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public Object a;
        }

        /* loaded from: classes3.dex */
        public static class c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public DialogInterface a;
            public int b;

            public c(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dialogInterface, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dialogInterface;
                this.b = i;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-381900710, "Lcom/baidu/swan/apps/res/widget/dialog/BaseActivityDialog$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-381900710, "Lcom/baidu/swan/apps/res/widget/dialog/BaseActivityDialog$e;");
                    return;
                }
            }
            t = new HashMap<>();
            u = new ArrayList();
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public e() {
            this(BaseActivityDialog.class);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    this((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public void D() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                E(false);
            }
        }

        public void s() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                u.remove(this.r);
                this.j = null;
                this.k = null;
                this.l = null;
                this.m = null;
                this.e = null;
                this.f = null;
            }
        }

        public e(Class<? extends Activity> cls) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.g = true;
            this.p = -1;
            this.n = AppRuntime.getAppContext();
            this.o = cls;
        }

        public static e r(String str) {
            InterceptResult invokeL;
            e remove;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    synchronized (t) {
                        remove = t.remove(str);
                    }
                    return remove;
                }
                return null;
            }
            return (e) invokeL.objValue;
        }

        public e B(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                C(this.n.getString(i));
                return this;
            }
            return (e) invokeI.objValue;
        }

        public e C(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.a = str;
                return this;
            }
            return (e) invokeL.objValue;
        }

        public void E(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
                qm3.a0(new a(this, z));
            }
        }

        public void onEvent(c cVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048581, this, cVar) != null) || cVar == null) {
                return;
            }
            DialogInterface.OnClickListener onClickListener = null;
            int i = cVar.b;
            if (i != -2) {
                if (i == -1) {
                    onClickListener = this.j;
                }
            } else {
                onClickListener = this.k;
            }
            if (onClickListener != null) {
                onClickListener.onClick(cVar.a, cVar.b);
            }
        }

        public e u(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                v(this.n.getString(i));
                return this;
            }
            return (e) invokeI.objValue;
        }

        public e v(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.b = str;
                return this;
            }
            return (e) invokeL.objValue;
        }

        public e y(DialogInterface.OnDismissListener onDismissListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, onDismissListener)) == null) {
                this.m = onDismissListener;
                return this;
            }
            return (e) invokeL.objValue;
        }

        public static void t(String str, e eVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65557, null, str, eVar) == null) && !TextUtils.isEmpty(str) && eVar != null) {
                synchronized (t) {
                    t.put(str, eVar);
                }
            }
        }

        public e A(String str, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, onClickListener)) == null) {
                this.c = str;
                this.j = onClickListener;
                return this;
            }
            return (e) invokeLL.objValue;
        }

        public e w(int i, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i, onClickListener)) == null) {
                x(this.n.getString(i), onClickListener);
                return this;
            }
            return (e) invokeIL.objValue;
        }

        public e x(String str, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, onClickListener)) == null) {
                this.d = str;
                this.k = onClickListener;
                return this;
            }
            return (e) invokeLL.objValue;
        }

        public e z(int i, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i, onClickListener)) == null) {
                A(this.n.getString(i), onClickListener);
                return this;
            }
            return (e) invokeIL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements Action<e.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseActivityDialog a;

        public a(BaseActivityDialog baseActivityDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseActivityDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseActivityDialog;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.bdeventbus.Action
        public void call(e.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                this.a.m.onEvent(cVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Action<e.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseActivityDialog a;

        public b(BaseActivityDialog baseActivityDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseActivityDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseActivityDialog;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.bdeventbus.Action
        public void call(e.b bVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) && bVar.a == this.a.m.r) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseActivityDialog a;

        public c(BaseActivityDialog baseActivityDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseActivityDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseActivityDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.d(-1);
                BdEventBus.Companion.getDefault().post(new e.c(this.a, -1));
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseActivityDialog a;

        public d(BaseActivityDialog baseActivityDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseActivityDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseActivityDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.d(-2);
                this.a.dismiss();
                BdEventBus.Companion.getDefault().post(new e.c(this.a, -2));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1363524357, "Lcom/baidu/swan/apps/res/widget/dialog/BaseActivityDialog;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1363524357, "Lcom/baidu/swan/apps/res/widget/dialog/BaseActivityDialog;");
                return;
            }
        }
        q = gp1.a;
    }

    public BaseActivityDialog() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // android.content.DialogInterface
    public void cancel() {
        DialogInterface.OnCancelListener onCancelListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            e eVar = this.m;
            if (eVar != null && (onCancelListener = eVar.l) != null) {
                onCancelListener.onCancel(this);
            }
            finish();
        }
    }

    @Override // android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            e();
            finish();
        }
    }

    public void e() {
        e eVar;
        DialogInterface.OnDismissListener onDismissListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (eVar = this.m) != null && (onDismissListener = eVar.m) != null) {
            onDismissListener.onDismiss(this);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.m != null) {
                BdEventBus.Companion.getDefault().unregister(this.m);
                this.m.s();
                this.m = null;
            }
            o(null);
        }
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Resources b2 = ds2.M().b();
            if (b2 != null) {
                return b2;
            }
            return super.getResources();
        }
        return (Resources) invokeV.objValue;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            e();
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            f();
            super.onDestroy();
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && z) {
            this.o.setVisibility(8);
            this.g.setVisibility(8);
        }
    }

    public void h(Drawable drawable) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, drawable) == null) {
            this.k.setImageDrawable(drawable);
            ImageView imageView = this.k;
            if (drawable != null) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.d.setEnabled(z);
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.d.setTextColor(i);
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.a.setText(str);
        }
    }

    public TextView b() {
        InterceptResult invokeV;
        int i;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            TextView textView2 = this.d;
            if (textView2 != null && textView2.getVisibility() == 0) {
                textView = this.d;
                i = 1;
            } else {
                i = 0;
                textView = null;
            }
            TextView textView3 = this.e;
            if (textView3 != null && textView3.getVisibility() == 0) {
                i++;
                textView = this.e;
            }
            TextView textView4 = this.f;
            if (textView4 != null && textView4.getVisibility() == 0) {
                i++;
                textView = this.f;
            }
            if (i != 1) {
                return null;
            }
            return textView;
        }
        return (TextView) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f09082c);
            this.b = (TextView) findViewById(R.id.dialog_message);
            this.c = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090822);
            this.d = (TextView) findViewById(R.id.positive_button);
            this.e = (TextView) findViewById(R.id.negative_button);
            this.f = (TextView) findViewById(R.id.neutral_button);
            this.h = findViewById(R.id.obfuscated_res_0x7f090853);
            this.i = findViewById(R.id.obfuscated_res_0x7f090854);
            this.j = (FrameLayout) findViewById(R.id.dialog_custom_content);
            this.k = (ImageView) findViewById(R.id.dialog_icon);
            this.l = (RelativeLayout) findViewById(R.id.searchbox_alert_dialog);
            this.g = findViewById(R.id.obfuscated_res_0x7f090852);
            this.n = (SwanAppScrollView) findViewById(R.id.message_scrollview);
            this.o = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090464);
            this.p = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070123);
            if (this.m.p > 0) {
                this.n.getLayoutParams().height = this.m.p;
            }
            if (dl3.k() || dl3.l()) {
                int dimensionPixelSize = this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07012a);
                this.b.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
        }
    }

    public void i(CharSequence charSequence) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, charSequence) == null) {
            this.b.setText(charSequence);
            LinearLayout linearLayout = this.c;
            if (!TextUtils.isEmpty(charSequence)) {
                i = 0;
            } else {
                i = 8;
            }
            linearLayout.setVisibility(i);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.p);
            layoutParams.addRule(3, R.id.obfuscated_res_0x7f090822);
            this.o.setLayoutParams(layoutParams);
        }
    }

    public void o(View view2) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, view2) == null) && (frameLayout = this.j) != null) {
            frameLayout.removeAllViews();
            if (view2 != null) {
                this.j.addView(view2);
                this.c.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.p);
                layoutParams.addRule(3, R.id.dialog_customPanel);
                this.o.setLayoutParams(layoutParams);
            }
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.e.setText(str);
            this.e.setOnClickListener(new d(this));
            if (TextUtils.isEmpty(str)) {
                this.e.setVisibility(8);
                if (this.d.getVisibility() == 0) {
                    this.h.setVisibility(8);
                    return;
                }
                return;
            }
            this.e.setVisibility(0);
            if (this.d.getVisibility() == 0) {
                this.h.setVisibility(0);
            }
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.d.setText(str);
            this.d.setOnClickListener(new c(this));
            if (TextUtils.isEmpty(str)) {
                this.d.setVisibility(8);
                if (this.e.getVisibility() == 0) {
                    this.h.setVisibility(8);
                    return;
                }
                return;
            }
            this.d.setVisibility(0);
            if (this.e.getVisibility() == 0) {
                this.h.setVisibility(0);
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0096);
            getWindow().setLayout(-1, -1);
            e r = e.r(getIntent().getStringExtra("BOX_ACTIVITY_DIALOG_FOR_BUILDER"));
            this.m = r;
            if (r == null) {
                if (q) {
                    Log.e("BaseActivityDialog", "The builder for dialog activity can NOT be null.");
                }
                finish();
                return;
            }
            BdEventBus.Companion.getDefault().register(this.m, e.c.class, new a(this));
            BdEventBus.Companion.getDefault().register(this.m, e.b.class, new b(this));
            c();
            p();
            q();
        }
    }

    public void p() {
        e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || (eVar = this.m) == null) {
            return;
        }
        n(eVar.a);
        h(eVar.f);
        i(eVar.b);
        o(eVar.e);
        l(eVar.g);
        m(eVar.h);
        k(eVar.c);
        j(eVar.d);
        g(eVar.s);
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            Resources resources = getResources();
            int color = resources.getColor(R.color.obfuscated_res_0x7f0603a9);
            int color2 = resources.getColor(R.color.obfuscated_res_0x7f06039c);
            int color3 = resources.getColor(R.color.obfuscated_res_0x7f0603a6);
            this.l.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f080143));
            this.a.setTextColor(color);
            this.b.setTextColor(color2);
            this.d.setTextColor(color);
            this.e.setTextColor(color);
            this.f.setTextColor(color);
            this.g.setBackgroundColor(color3);
            this.h.setBackgroundColor(color3);
            this.i.setBackgroundColor(color3);
            this.d.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0800cc));
            this.e.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0800cb));
            this.f.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0800cd));
            TextView b2 = b();
            if (b2 != null) {
                b2.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0800ca));
            }
        }
    }
}
