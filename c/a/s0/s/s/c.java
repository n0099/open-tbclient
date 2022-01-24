package c.a.s0.s.s;

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
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<Integer, Integer[]> q;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public List<CharSequence> f13752b;

    /* renamed from: c  reason: collision with root package name */
    public InterfaceC0893c f13753c;

    /* renamed from: d  reason: collision with root package name */
    public final Activity f13754d;

    /* renamed from: e  reason: collision with root package name */
    public final ViewGroup f13755e;

    /* renamed from: f  reason: collision with root package name */
    public final ViewGroup f13756f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f13757g;

    /* renamed from: h  reason: collision with root package name */
    public final View f13758h;

    /* renamed from: i  reason: collision with root package name */
    public int f13759i;

    /* renamed from: j  reason: collision with root package name */
    public int f13760j;
    public int k;
    public int l;
    public boolean m;
    public AlertDialog n;
    public int o;
    public LinearLayout.LayoutParams p;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f13761e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f13762f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f13763g;

        public a(c cVar, int i2, TextView textView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2), textView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13763g = cVar;
            this.f13761e = i2;
            this.f13762f = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f13763g.f13753c.a(this.f13763g, this.f13761e, this.f13762f);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final int a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(144829886, "Lc/a/s0/s/s/c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(144829886, "Lc/a/s0/s/s/c$b;");
                    return;
                }
            }
            a = R.style.dialog_ani_b2t;
        }
    }

    /* renamed from: c.a.s0.s.s.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0893c {
        void a(c cVar, int i2, View view);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1970796804, "Lc/a/s0/s/s/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1970796804, "Lc/a/s0/s/s/c;");
                return;
            }
        }
        HashMap<Integer, Integer[]> hashMap = new HashMap<>(2);
        q = hashMap;
        hashMap.put(0, new Integer[]{Integer.valueOf(R.drawable.dialg_alert_btn_bg), Integer.valueOf(R.drawable.dialog_bdalert_button_textcolor_pressed)});
        q.put(1, new Integer[]{Integer.valueOf(R.drawable.btn_blue_square), Integer.valueOf(R.color.CAM_X0201)});
    }

    public c(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f13760j = -1;
        this.k = -1;
        this.l = -1;
        this.m = false;
        this.o = -1;
        this.f13754d = activity;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.dialog_bdlist, (ViewGroup) null);
        this.f13755e = viewGroup;
        this.f13757g = (TextView) viewGroup.findViewById(R.id.dialog_title_list);
        this.f13756f = (ViewGroup) this.f13755e.findViewById(R.id.dialog_content);
        this.f13758h = this.f13755e.findViewById(R.id.line_bg);
        this.f13759i = R.layout.dialog_bdlist_item;
    }

    public void b(c.a.d.a.f<?> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (fVar instanceof TbPageContext) {
                TbPageContext tbPageContext = (TbPageContext) fVar;
                tbPageContext.getLayoutMode().k(skinType == 1);
                tbPageContext.getLayoutMode().j(this.f13755e);
            }
            this.f13755e.setBackgroundResource(R.drawable.transparent_bg);
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
                this.f13757g.setText(this.a);
                this.f13757g.setVisibility(0);
                this.f13758h.setVisibility(0);
            } else {
                this.f13757g.setVisibility(8);
                this.f13758h.setVisibility(8);
            }
            List<CharSequence> list = this.f13752b;
            if (list != null && list.size() > 0) {
                int size = this.f13752b.size();
                for (int i2 = 0; i2 < size; i2++) {
                    d(i2);
                }
            }
            b(fVar);
            return this;
        }
        return (c) invokeL.objValue;
    }

    public final View d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            View inflate = LayoutInflater.from(this.f13754d).inflate(this.f13759i, this.f13756f, false);
            LinearLayout linearLayout = (LinearLayout) inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.dialog_item_btn);
            LinearLayout.LayoutParams layoutParams = this.p;
            if (layoutParams != null) {
                textView.setLayoutParams(layoutParams);
            }
            int i3 = this.l;
            if (i3 != -1) {
                textView.setTextSize(0, i3);
            }
            if (this.o != -1) {
                textView.setPadding(0, 0, 0, 0);
                textView.setGravity(this.o);
            }
            View findViewById = inflate.findViewById(R.id.line);
            CharSequence charSequence = this.f13752b.get(i2);
            if (charSequence.length() <= 0) {
                charSequence = "";
            }
            textView.setText(charSequence);
            if (i2 == this.f13752b.size() - 1) {
                findViewById.setVisibility(8);
                SkinManager.setBackgroundResource(inflate, R.drawable.dialog_single_button_bg_selector);
            } else if (this.f13752b.size() == 1) {
                findViewById.setVisibility(8);
                SkinManager.setBackgroundResource(inflate, R.drawable.dialog_single_button_only_one_bg_selector);
            } else if (i2 == 0 && StringUtils.isNull(this.a)) {
                SkinManager.setBackgroundResource(inflate, R.drawable.dialog_single_button_first_bg_selector);
            } else {
                SkinManager.setBackgroundResource(inflate, R.drawable.dialg_alert_btn_bg);
            }
            if (this.f13753c != null) {
                linearLayout.setOnClickListener(new a(this, i2, textView));
            }
            this.f13756f.addView(inflate);
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
        c.a.d.f.m.g.a(alertDialog, this.f13754d);
    }

    public View f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            ViewGroup viewGroup = this.f13756f;
            if (viewGroup == null) {
                return null;
            }
            int childCount = viewGroup.getChildCount();
            if (i2 < 0 || i2 > childCount - 1) {
                return null;
            }
            return this.f13756f.getChildAt(i2);
        }
        return (View) invokeI.objValue;
    }

    public c g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            this.f13760j = i2;
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            this.k = i2;
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c i(List<CharSequence> list, InterfaceC0893c interfaceC0893c) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, list, interfaceC0893c)) == null) {
            if (list != null && list.size() > 0) {
                this.f13752b = list;
                if (interfaceC0893c != null) {
                    this.f13753c = interfaceC0893c;
                }
            }
            return this;
        }
        return (c) invokeLL.objValue;
    }

    public c j(CharSequence[] charSequenceArr, InterfaceC0893c interfaceC0893c) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, charSequenceArr, interfaceC0893c)) == null) {
            if (charSequenceArr != null && charSequenceArr.length > 0) {
                i(Arrays.asList(charSequenceArr), interfaceC0893c);
            }
            return this;
        }
        return (c) invokeLL.objValue;
    }

    public c k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            l(this.f13754d.getResources().getString(i2));
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
                    c.a.d.f.m.g.i(alertDialog, this.f13754d);
                    return this;
                }
                AlertDialog create = new AlertDialog.Builder(this.f13754d, R.style.NoBackDimEnableDialog).create();
                this.n = create;
                create.setCanceledOnTouchOutside(true);
                if (c.a.d.f.m.g.i(this.n, this.f13754d)) {
                    Window window = this.n.getWindow();
                    if (this.f13760j == -1) {
                        this.f13760j = b.a;
                    }
                    if (this.k == -1) {
                        this.k = 17;
                    }
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.dimAmount = 0.5f;
                    window.setAttributes(attributes);
                    window.setGravity(this.k);
                    window.setContentView(this.f13755e);
                    return this;
                }
                return this;
            }
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        return (c) invokeV.objValue;
    }
}
