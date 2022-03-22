package c.a.o0.r.t;

import android.app.Activity;
import android.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<Integer, Integer[]> q;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public List<CharSequence> f11024b;

    /* renamed from: c  reason: collision with root package name */
    public InterfaceC0843c f11025c;

    /* renamed from: d  reason: collision with root package name */
    public final Activity f11026d;

    /* renamed from: e  reason: collision with root package name */
    public final ViewGroup f11027e;

    /* renamed from: f  reason: collision with root package name */
    public final ViewGroup f11028f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f11029g;

    /* renamed from: h  reason: collision with root package name */
    public final View f11030h;
    public int i;
    public int j;
    public int k;
    public int l;
    public boolean m;
    public AlertDialog n;
    public int o;
    public LinearLayout.LayoutParams p;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TextView f11031b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f11032c;

        public a(c cVar, int i, TextView textView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i), textView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11032c = cVar;
            this.a = i;
            this.f11031b = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f11032c.f11025c.a(this.f11032c, this.a, this.f11031b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a */
        public static final int obfuscated_res_0x7f1003a3 = 2131755939;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1323486842, "Lc/a/o0/r/t/c$b;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1323486842, "Lc/a/o0/r/t/c$b;");
            }
        }
    }

    /* renamed from: c.a.o0.r.t.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0843c {
        void a(c cVar, int i, View view);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(935454392, "Lc/a/o0/r/t/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(935454392, "Lc/a/o0/r/t/c;");
                return;
            }
        }
        HashMap<Integer, Integer[]> hashMap = new HashMap<>(2);
        q = hashMap;
        hashMap.put(0, new Integer[]{Integer.valueOf((int) R.drawable.dialg_alert_btn_bg), Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080494)});
        q.put(1, new Integer[]{Integer.valueOf((int) R.drawable.btn_blue_square), Integer.valueOf((int) R.color.CAM_X0201)});
    }

    public c(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.m = false;
        this.o = -1;
        this.f11026d = activity;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.obfuscated_res_0x7f0d022d, (ViewGroup) null);
        this.f11027e = viewGroup;
        this.f11029g = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0907b8);
        this.f11028f = (ViewGroup) this.f11027e.findViewById(R.id.obfuscated_res_0x7f09079d);
        this.f11030h = this.f11027e.findViewById(R.id.obfuscated_res_0x7f09125f);
        this.i = R.layout.obfuscated_res_0x7f0d022e;
    }

    public void b(c.a.d.a.f<?> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (fVar instanceof TbPageContext) {
                TbPageContext tbPageContext = (TbPageContext) fVar;
                tbPageContext.getLayoutMode().k(skinType == 1);
                tbPageContext.getLayoutMode().j(this.f11027e);
            }
            this.f11027e.setBackgroundResource(R.drawable.obfuscated_res_0x7f081200);
        }
    }

    public c c(c.a.d.a.f<?> fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) {
            if (this.m) {
                return this;
            }
            this.m = true;
            if (!TextUtils.isEmpty(this.a)) {
                this.f11029g.setText(this.a);
                this.f11029g.setVisibility(0);
                this.f11030h.setVisibility(0);
            } else {
                this.f11029g.setVisibility(8);
                this.f11030h.setVisibility(8);
            }
            List<CharSequence> list = this.f11024b;
            if (list != null && list.size() > 0) {
                int size = this.f11024b.size();
                for (int i = 0; i < size; i++) {
                    d(i);
                }
            }
            b(fVar);
            return this;
        }
        return (c) invokeL.objValue;
    }

    public final View d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            View inflate = LayoutInflater.from(this.f11026d).inflate(this.i, this.f11028f, false);
            LinearLayout linearLayout = (LinearLayout) inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0907a9);
            LinearLayout.LayoutParams layoutParams = this.p;
            if (layoutParams != null) {
                textView.setLayoutParams(layoutParams);
            }
            int i2 = this.l;
            if (i2 != -1) {
                textView.setTextSize(0, i2);
            }
            if (this.o != -1) {
                textView.setPadding(0, 0, 0, 0);
                textView.setGravity(this.o);
            }
            View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f091255);
            CharSequence charSequence = this.f11024b.get(i);
            if (charSequence.length() <= 0) {
                charSequence = "";
            }
            textView.setText(charSequence);
            if (i == this.f11024b.size() - 1) {
                findViewById.setVisibility(8);
                SkinManager.setBackgroundResource(inflate, R.drawable.dialog_single_button_bg_selector);
            } else if (this.f11024b.size() == 1) {
                findViewById.setVisibility(8);
                SkinManager.setBackgroundResource(inflate, R.drawable.dialog_single_button_only_one_bg_selector);
            } else if (i == 0 && StringUtils.isNull(this.a)) {
                SkinManager.setBackgroundResource(inflate, R.drawable.dialog_single_button_first_bg_selector);
            } else {
                SkinManager.setBackgroundResource(inflate, R.drawable.dialg_alert_btn_bg);
            }
            if (this.f11025c != null) {
                linearLayout.setOnClickListener(new a(this, i, textView));
            }
            this.f11028f.addView(inflate);
            return inflate;
        }
        return (View) invokeI.objValue;
    }

    public void e() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (alertDialog = this.n) == null) {
            return;
        }
        c.a.d.f.m.g.a(alertDialog, this.f11026d);
    }

    public View f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            ViewGroup viewGroup = this.f11028f;
            if (viewGroup == null) {
                return null;
            }
            int childCount = viewGroup.getChildCount();
            if (i < 0 || i > childCount - 1) {
                return null;
            }
            return this.f11028f.getChildAt(i);
        }
        return (View) invokeI.objValue;
    }

    public c g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            this.j = i;
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            this.k = i;
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c i(List<CharSequence> list, InterfaceC0843c interfaceC0843c) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, list, interfaceC0843c)) == null) {
            if (list != null && list.size() > 0) {
                this.f11024b = list;
                if (interfaceC0843c != null) {
                    this.f11025c = interfaceC0843c;
                }
            }
            return this;
        }
        return (c) invokeLL.objValue;
    }

    public c j(CharSequence[] charSequenceArr, InterfaceC0843c interfaceC0843c) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, charSequenceArr, interfaceC0843c)) == null) {
            if (charSequenceArr != null && charSequenceArr.length > 0) {
                i(Arrays.asList(charSequenceArr), interfaceC0843c);
            }
            return this;
        }
        return (c) invokeLL.objValue;
    }

    public c k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            l(this.f11026d.getResources().getString(i));
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            this.a = str;
            return this;
        }
        return (c) invokeL.objValue;
    }

    public c m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.m) {
                AlertDialog alertDialog = this.n;
                if (alertDialog != null) {
                    c.a.d.f.m.g.i(alertDialog, this.f11026d);
                    return this;
                }
                AlertDialog create = new AlertDialog.Builder(this.f11026d, R.style.obfuscated_res_0x7f100139).create();
                this.n = create;
                create.setCanceledOnTouchOutside(true);
                if (c.a.d.f.m.g.i(this.n, this.f11026d)) {
                    Window window = this.n.getWindow();
                    if (this.j == -1) {
                        this.j = b.obfuscated_res_0x7f1003a3;
                    }
                    if (this.k == -1) {
                        this.k = 17;
                    }
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.dimAmount = 0.5f;
                    window.setAttributes(attributes);
                    window.setGravity(this.k);
                    window.setContentView(this.f11027e);
                    return this;
                }
                return this;
            }
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        return (c) invokeV.objValue;
    }
}
