package c.a.r0.d3;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.f;
import c.a.e.e.m.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f17145a;

    /* renamed from: b  reason: collision with root package name */
    public String f17146b;

    /* renamed from: c  reason: collision with root package name */
    public View f17147c;

    /* renamed from: d  reason: collision with root package name */
    public int f17148d;

    /* renamed from: e  reason: collision with root package name */
    public int f17149e;

    /* renamed from: f  reason: collision with root package name */
    public int f17150f;

    /* renamed from: g  reason: collision with root package name */
    public String f17151g;

    /* renamed from: h  reason: collision with root package name */
    public String f17152h;

    /* renamed from: i  reason: collision with root package name */
    public String f17153i;

    /* renamed from: j  reason: collision with root package name */
    public String f17154j;
    public c k;
    public c l;
    public c m;
    public DialogInterface.OnCancelListener n;
    public DialogInterface.OnKeyListener o;
    public AlertDialog p;
    public final Activity q;
    public final ViewGroup r;
    public boolean s;
    public boolean t;

    /* renamed from: c.a.r0.d3.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0829a implements ViewHelper.ViewCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f17155a;

        public C0829a(a aVar, AtomicBoolean atomicBoolean) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, atomicBoolean};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17155a = atomicBoolean;
        }

        @Override // com.baidu.tbadk.core.util.ViewHelper.ViewCallback
        public boolean onViewFound(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (view instanceof EditText) {
                    this.f17155a.set(true);
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final a f17156e;

        /* renamed from: f  reason: collision with root package name */
        public final c f17157f;

        public b(a aVar, a aVar2, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17156e = aVar2;
            this.f17157f = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (cVar = this.f17157f) == null) {
                return;
            }
            cVar.a(this.f17156e);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(a aVar);
    }

    public a(Activity activity) {
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
        this.f17145a = -1;
        this.f17148d = -1;
        this.f17149e = R.drawable.btn_blue_bg;
        this.f17150f = R.color.CAM_X0111;
        this.s = false;
        this.t = true;
        this.q = activity;
        this.r = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.dialog_icon_bdalert, (ViewGroup) null);
    }

    public final void a(f<?> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (fVar instanceof TbPageContext) {
                TbPageContext tbPageContext = (TbPageContext) fVar;
                tbPageContext.getLayoutMode().k(skinType == 1);
                tbPageContext.getLayoutMode().j(this.r);
            }
        }
    }

    public a b(f<?> fVar) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) {
            if (this.s) {
                return this;
            }
            this.s = true;
            a(fVar);
            TextView textView = (TextView) this.r.findViewById(R.id.title);
            LinearLayout linearLayout = (LinearLayout) this.r.findViewById(R.id.content);
            ImageView imageView = (ImageView) this.r.findViewById(R.id.bdalert_icon);
            TextView textView2 = (TextView) this.r.findViewById(R.id.message);
            Button button = (Button) this.r.findViewById(R.id.yes);
            SkinManager.setBackgroundResource(button, this.f17149e);
            SkinManager.setViewTextColor(button, this.f17150f, 3);
            Button button2 = (Button) this.r.findViewById(R.id.no);
            Button button3 = (Button) this.r.findViewById(R.id.cancel);
            if (!TextUtils.isEmpty(this.f17146b)) {
                textView.setText(this.f17146b);
            } else {
                textView.setVisibility(8);
            }
            if (this.f17147c != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.f17147c);
            }
            int i2 = this.f17148d;
            if (i2 != -1) {
                SkinManager.setImageResource(imageView, i2);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.f17151g)) {
                textView2.setText(this.f17151g);
            }
            if (TextUtils.isEmpty(this.f17152h)) {
                z = false;
            } else {
                button.setText(this.f17152h);
                c cVar = this.k;
                if (cVar != null) {
                    button.setOnClickListener(new b(this, this, cVar));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.f17153i)) {
                z2 = false;
            } else {
                button2.setText(this.f17153i);
                c cVar2 = this.l;
                if (cVar2 != null) {
                    button2.setOnClickListener(new b(this, this, cVar2));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.f17154j)) {
                z3 = false;
            } else {
                button3.setText(this.f17154j);
                c cVar3 = this.m;
                if (cVar3 != null) {
                    button3.setOnClickListener(new b(this, this, cVar3));
                }
                z3 = true;
            }
            e(z, z2, z3, button, button2, button3);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public final int c(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, context, f2)) == null) ? (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f) : invokeLF.intValue;
    }

    public void d() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (alertDialog = this.p) == null) {
            return;
        }
        g.a(alertDialog, this.q);
    }

    public final void e(boolean z, boolean z2, boolean z3, Button button, Button button2, Button button3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), button, button2, button3}) == null) {
            boolean[] zArr = {z2, z, z3};
            Button[] buttonArr = {button2, button, button3};
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < 3; i2++) {
                if (zArr[i2]) {
                    arrayList.add(buttonArr[i2]);
                    buttonArr[i2].setVisibility(0);
                } else {
                    buttonArr[i2].setVisibility(8);
                }
            }
            if (arrayList.size() == 3) {
                int i3 = 0;
                while (i3 < 3) {
                    f((Button) arrayList.get(i3), 0, i3 == 2 ? 0 : 20);
                    i3++;
                }
            }
            if (arrayList.size() == 2) {
                int i4 = 0;
                while (i4 < 2) {
                    f((Button) arrayList.get(i4), 0, i4 == 1 ? 0 : 20);
                    i4++;
                }
            }
            if (arrayList.size() == 1) {
                f((Button) arrayList.get(0), 0, 0);
            }
        }
    }

    public final void f(Button button, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, button, i2, i3) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
            layoutParams.width = c(this.q, i2);
            layoutParams.rightMargin = i3;
            layoutParams.weight = 1.0f;
            button.setLayoutParams(layoutParams);
        }
    }

    public a g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            this.t = z;
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            this.f17148d = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            Activity activity = this.q;
            if (activity != null) {
                this.f17151g = activity.getResources().getString(i2);
            }
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a j(int i2, c cVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i2, cVar)) == null) {
            Activity activity = this.q;
            if (activity != null) {
                this.f17153i = activity.getResources().getString(i2);
                this.l = cVar;
            }
            return this;
        }
        return (a) invokeIL.objValue;
    }

    public a k(DialogInterface.OnKeyListener onKeyListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, onKeyListener)) == null) {
            this.o = onKeyListener;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a l(int i2, c cVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048587, this, i2, cVar)) == null) {
            Activity activity = this.q;
            if (activity != null) {
                this.f17152h = activity.getResources().getString(i2);
                this.k = cVar;
            }
            return this;
        }
        return (a) invokeIL.objValue;
    }

    public a m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            this.f17149e = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            this.f17150f = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            p(true);
            return this;
        }
        return (a) invokeV.objValue;
    }

    public final a p(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            if (this.s) {
                AlertDialog alertDialog = this.p;
                if (alertDialog != null) {
                    if (z) {
                        g.i(alertDialog, this.q);
                    } else {
                        alertDialog.show();
                    }
                    return this;
                }
                AlertDialog create = new AlertDialog.Builder(this.q).create();
                this.p = create;
                create.setCanceledOnTouchOutside(this.t);
                DialogInterface.OnCancelListener onCancelListener = this.n;
                if (onCancelListener != null) {
                    this.p.setOnCancelListener(onCancelListener);
                }
                DialogInterface.OnKeyListener onKeyListener = this.o;
                if (onKeyListener != null) {
                    this.p.setOnKeyListener(onKeyListener);
                }
                if (z) {
                    g.i(this.p, this.q);
                } else {
                    this.p.show();
                }
                Window window = this.p.getWindow();
                if (this.f17145a == -1) {
                    this.f17145a = 17;
                }
                window.setGravity(this.f17145a);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.addFlags(2);
                window.setLayout(-2, -2);
                window.setContentView(this.r);
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                ViewHelper.processAllViewsIn(this.r, false, new C0829a(this, atomicBoolean));
                if (atomicBoolean.get()) {
                    window.clearFlags(131080);
                }
                return this;
            }
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        return (a) invokeZ.objValue;
    }
}
