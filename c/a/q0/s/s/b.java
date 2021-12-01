package c.a.q0.s.s;

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
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<Integer, Integer[]> q;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public List<CharSequence> f13125b;

    /* renamed from: c  reason: collision with root package name */
    public c f13126c;

    /* renamed from: d  reason: collision with root package name */
    public final Activity f13127d;

    /* renamed from: e  reason: collision with root package name */
    public final ViewGroup f13128e;

    /* renamed from: f  reason: collision with root package name */
    public final ViewGroup f13129f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f13130g;

    /* renamed from: h  reason: collision with root package name */
    public final View f13131h;

    /* renamed from: i  reason: collision with root package name */
    public int f13132i;

    /* renamed from: j  reason: collision with root package name */
    public int f13133j;

    /* renamed from: k  reason: collision with root package name */
    public int f13134k;
    public int l;
    public boolean m;
    public AlertDialog n;
    public int o;
    public LinearLayout.LayoutParams p;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f13135e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f13136f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f13137g;

        public a(b bVar, int i2, TextView textView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2), textView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13137g = bVar;
            this.f13135e = i2;
            this.f13136f = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f13137g.f13126c.a(this.f13137g, this.f13135e, this.f13136f);
            }
        }
    }

    /* renamed from: c.a.q0.s.s.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0811b {
        public static /* synthetic */ Interceptable $ic;
        public static final int a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-556264483, "Lc/a/q0/s/s/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-556264483, "Lc/a/q0/s/s/b$b;");
                    return;
                }
            }
            a = R.style.dialog_ani_b2t;
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(b bVar, int i2, View view);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1644112091, "Lc/a/q0/s/s/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1644112091, "Lc/a/q0/s/s/b;");
                return;
            }
        }
        HashMap<Integer, Integer[]> hashMap = new HashMap<>(2);
        q = hashMap;
        hashMap.put(0, new Integer[]{Integer.valueOf(R.drawable.dialg_alert_btn_bg), Integer.valueOf(R.drawable.dialog_bdalert_button_textcolor_pressed)});
        q.put(1, new Integer[]{Integer.valueOf(R.drawable.btn_blue_square), Integer.valueOf(R.color.CAM_X0201)});
    }

    public b(Activity activity) {
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
        this.f13133j = -1;
        this.f13134k = -1;
        this.l = -1;
        this.m = false;
        this.o = -1;
        this.f13127d = activity;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.dialog_bdlist, (ViewGroup) null);
        this.f13128e = viewGroup;
        this.f13130g = (TextView) viewGroup.findViewById(R.id.dialog_title_list);
        this.f13129f = (ViewGroup) this.f13128e.findViewById(R.id.dialog_content);
        this.f13131h = this.f13128e.findViewById(R.id.line_bg);
        this.f13132i = R.layout.dialog_bdlist_item;
    }

    public void b(c.a.d.a.f<?> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (fVar instanceof TbPageContext) {
                TbPageContext tbPageContext = (TbPageContext) fVar;
                tbPageContext.getLayoutMode().k(skinType == 1);
                tbPageContext.getLayoutMode().j(this.f13128e);
            }
            this.f13128e.setBackgroundResource(R.drawable.transparent_bg);
        }
    }

    public b c(c.a.d.a.f<?> fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) {
            if (this.m) {
                return this;
            }
            this.m = true;
            if (!TextUtils.isEmpty(this.a)) {
                this.f13130g.setText(this.a);
                this.f13130g.setVisibility(0);
                this.f13131h.setVisibility(0);
            } else {
                this.f13130g.setVisibility(8);
                this.f13131h.setVisibility(8);
            }
            List<CharSequence> list = this.f13125b;
            if (list != null && list.size() > 0) {
                int size = this.f13125b.size();
                for (int i2 = 0; i2 < size; i2++) {
                    d(i2);
                }
            }
            b(fVar);
            return this;
        }
        return (b) invokeL.objValue;
    }

    public final View d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            View inflate = LayoutInflater.from(this.f13127d).inflate(this.f13132i, this.f13129f, false);
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
            CharSequence charSequence = this.f13125b.get(i2);
            if (charSequence.length() <= 0) {
                charSequence = "";
            }
            textView.setText(charSequence);
            if (i2 == this.f13125b.size() - 1) {
                findViewById.setVisibility(8);
                SkinManager.setBackgroundResource(inflate, R.drawable.dialog_single_button_bg_selector);
            } else if (this.f13125b.size() == 1) {
                findViewById.setVisibility(8);
                SkinManager.setBackgroundResource(inflate, R.drawable.dialog_single_button_only_one_bg_selector);
            } else if (i2 == 0 && StringUtils.isNull(this.a)) {
                SkinManager.setBackgroundResource(inflate, R.drawable.dialog_single_button_first_bg_selector);
            } else {
                SkinManager.setBackgroundResource(inflate, R.drawable.dialg_alert_btn_bg);
            }
            if (this.f13126c != null) {
                linearLayout.setOnClickListener(new a(this, i2, textView));
            }
            this.f13129f.addView(inflate);
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
        c.a.d.f.m.g.a(alertDialog, this.f13127d);
    }

    public View f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            ViewGroup viewGroup = this.f13129f;
            if (viewGroup == null) {
                return null;
            }
            int childCount = viewGroup.getChildCount();
            if (i2 < 0 || i2 > childCount - 1) {
                return null;
            }
            return this.f13129f.getChildAt(i2);
        }
        return (View) invokeI.objValue;
    }

    public b g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            this.f13133j = i2;
            return this;
        }
        return (b) invokeI.objValue;
    }

    public b h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            this.f13134k = i2;
            return this;
        }
        return (b) invokeI.objValue;
    }

    public b i(List<CharSequence> list, c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, list, cVar)) == null) {
            if (list != null && list.size() > 0) {
                this.f13125b = list;
                if (cVar != null) {
                    this.f13126c = cVar;
                }
            }
            return this;
        }
        return (b) invokeLL.objValue;
    }

    public b j(CharSequence[] charSequenceArr, c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, charSequenceArr, cVar)) == null) {
            if (charSequenceArr != null && charSequenceArr.length > 0) {
                i(Arrays.asList(charSequenceArr), cVar);
            }
            return this;
        }
        return (b) invokeLL.objValue;
    }

    public b k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            l(this.f13127d.getResources().getString(i2));
            return this;
        }
        return (b) invokeI.objValue;
    }

    public b l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            this.a = str;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.m) {
                AlertDialog alertDialog = this.n;
                if (alertDialog != null) {
                    c.a.d.f.m.g.i(alertDialog, this.f13127d);
                    return this;
                }
                AlertDialog create = new AlertDialog.Builder(this.f13127d, R.style.NoBackDimEnableDialog).create();
                this.n = create;
                create.setCanceledOnTouchOutside(true);
                if (c.a.d.f.m.g.i(this.n, this.f13127d)) {
                    Window window = this.n.getWindow();
                    if (this.f13133j == -1) {
                        this.f13133j = C0811b.a;
                    }
                    if (this.f13134k == -1) {
                        this.f13134k = 17;
                    }
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.dimAmount = 0.5f;
                    window.setAttributes(attributes);
                    window.setGravity(this.f13134k);
                    window.setContentView(this.f13128e);
                    return this;
                }
                return this;
            }
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        return (b) invokeV.objValue;
    }
}
