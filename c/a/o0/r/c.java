package c.a.o0.r;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static String f10553f;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, b> f10554b;

    /* renamed from: c  reason: collision with root package name */
    public Resources f10555c;

    /* renamed from: d  reason: collision with root package name */
    public Resources f10556d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10557e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(997619837, "Lc/a/o0/r/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(997619837, "Lc/a/o0/r/c;");
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f10554b = new HashMap();
        this.f10557e = false;
    }

    public static int g(Resources resources, Resources resources2, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, resources, resources2, i)) == null) {
            String resourceName = resources.getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                i2 = i;
            } else {
                String packageName = SkinManager.getPackageName();
                f10553f = packageName;
                if (StringUtils.isNull(packageName)) {
                    f10553f = BdBaseApplication.getInst().getPackageName();
                }
                resourceName = f10553f + resourceName.substring(resourceName.indexOf(":"));
                i2 = resources2.getIdentifier(resourceName + SkinManager.nightSufix, null, null);
            }
            if (i2 == 0) {
                BdLog.e(resourceName + " 缺少夜间资源,使用了日间资源");
                return i;
            }
            return i2;
        }
        return invokeLLI.intValue;
    }

    public final void a(View view) {
        Drawable f2;
        Drawable f3;
        Drawable f4;
        int q;
        ColorStateList e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            String str = "@" + view.getId();
            Map<String, b> map = this.f10554b;
            if (map == null || !map.containsKey(str)) {
                return;
            }
            b bVar = this.f10554b.get(str);
            if (view instanceof TextView) {
                if (bVar.v() != 0 && (e2 = e(this.a, bVar.u(), bVar.v())) != null) {
                    ((TextView) view).setTextColor(e2);
                }
                if (bVar.t() != 0) {
                    ((TextView) view).setHintTextColor(e(this.a, bVar.s(), bVar.t()));
                }
                if (bVar.r() != 0) {
                    TextView textView = (TextView) view;
                    Context context = view.getContext();
                    if (this.a) {
                        q = bVar.r();
                    } else {
                        q = bVar.q();
                    }
                    textView.setTextAppearance(context, q);
                }
                if (bVar.k() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, f(this.a, bVar.j(), bVar.k()), (Drawable) null, (Drawable) null);
                }
                if (bVar.g() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(f(this.a, bVar.f(), bVar.g()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.i() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, f(this.a, bVar.h(), bVar.i()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.n() != 0 && (f4 = f(this.a, bVar.m(), bVar.n())) != null) {
                    ((ImageView) view).setImageDrawable(f4);
                }
            } else if (view instanceof ImageView) {
                if (bVar.n() != 0 && (f3 = f(this.a, bVar.m(), bVar.n())) != null) {
                    ((ImageView) view).setImageDrawable(f3);
                }
            } else if ((view instanceof ProgressBar) && bVar.p() != 0 && (f2 = f(this.a, bVar.o(), bVar.p())) != null) {
                ((ProgressBar) view).setProgressDrawable(f2);
            }
            if (bVar.c() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.f10555c.getResourceTypeName(bVar.b());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(d(this.a, bVar.b(), bVar.c()));
                } else {
                    view.setBackgroundDrawable(f(this.a, bVar.b(), bVar.c()));
                }
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    public final void b(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) {
            String str = "@" + viewGroup.getId();
            Map<String, b> map = this.f10554b;
            if (map == null || !map.containsKey(str)) {
                return;
            }
            b bVar = this.f10554b.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.e() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(f(this.a, bVar.d(), bVar.e()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.c() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.f10555c.getResourceTypeName(bVar.b());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(d(this.a, bVar.b(), bVar.c()));
                } else {
                    viewGroup.setBackgroundDrawable(f(this.a, bVar.b(), bVar.c()));
                }
                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    public void c() {
        Map<String, b> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (map = this.f10554b) == null) {
            return;
        }
        map.clear();
        this.f10554b = null;
    }

    public final int d(boolean z, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 2 || (!this.f10557e && skinType == 4)) {
                return SkinManager.getColor(i);
            }
            if (!z) {
                return this.f10555c.getColor(i);
            }
            if (i == i2) {
                Resources resources = this.f10555c;
                this.f10556d = resources;
                i2 = g(resources, resources, i);
            }
            Resources resources2 = this.f10556d;
            if (resources2 == null) {
                return this.f10555c.getColor(i);
            }
            try {
                return resources2.getColor(i2);
            } catch (Resources.NotFoundException unused) {
                return this.f10555c.getColor(i);
            }
        }
        return invokeCommon.intValue;
    }

    public final ColorStateList e(boolean z, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 2 || (!this.f10557e && skinType == 4)) {
                return SkinManager.getColorList(i);
            }
            if (!z) {
                return this.f10555c.getColorStateList(i);
            }
            if (i == i2) {
                Resources resources = this.f10555c;
                this.f10556d = resources;
                i2 = g(resources, resources, i);
            }
            Resources resources2 = this.f10556d;
            if (resources2 == null) {
                return this.f10555c.getColorStateList(i);
            }
            try {
                return resources2.getColorStateList(i2);
            } catch (Resources.NotFoundException unused) {
                return this.f10555c.getColorStateList(i);
            }
        }
        return (ColorStateList) invokeCommon.objValue;
    }

    public final Drawable f(boolean z, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 2 || (!this.f10557e && skinType == 4)) {
                return SkinManager.getDrawable(i);
            }
            if (!z) {
                try {
                    return this.f10555c.getDrawable(i);
                } catch (Throwable unused) {
                    return null;
                }
            }
            if (i == i2) {
                Resources resources = this.f10555c;
                this.f10556d = resources;
                i2 = g(resources, resources, i);
            }
            Resources resources2 = this.f10556d;
            if (resources2 == null) {
                try {
                    return this.f10555c.getDrawable(i);
                } catch (Throwable unused2) {
                    return null;
                }
            }
            try {
                try {
                    return resources2.getDrawable(i2);
                } catch (Throwable unused3) {
                    return null;
                }
            } catch (Resources.NotFoundException unused4) {
                return this.f10555c.getDrawable(i);
            } catch (ArrayIndexOutOfBoundsException unused5) {
                return null;
            }
        }
        return (Drawable) invokeCommon.objValue;
    }

    public final int[] h(String str) {
        InterceptResult invokeL;
        int parseInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
                return new int[]{parseInt, g(this.f10555c, this.f10556d, parseInt)};
            }
            return null;
        }
        return (int[]) invokeL.objValue;
    }

    public void i(String str, Context context, AttributeSet attributeSet) {
        int[] h2;
        int e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, context, attributeSet) == null) {
            try {
                Resources resources = context.getResources();
                this.f10555c = resources;
                this.f10556d = resources;
                int attributeCount = attributeSet.getAttributeCount();
                b bVar = new b();
                bVar.R(str);
                boolean z = false;
                for (int i = 0; i < attributeCount; i++) {
                    String attributeName = attributeSet.getAttributeName(i);
                    String attributeValue = attributeSet.getAttributeValue(i);
                    if (attributeName.equals("id")) {
                        bVar.G(attributeValue);
                    } else if (attributeName.equals("tb_background")) {
                        int[] h3 = h(attributeValue);
                        if (h3 != null) {
                            bVar.w(h3[0]);
                            bVar.x(h3[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_src")) {
                        int[] h4 = h(attributeValue);
                        if (h4 != null) {
                            bVar.H(h4[0]);
                            bVar.I(h4[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_textColor")) {
                        int[] h5 = h(attributeValue);
                        if (h5 != null) {
                            bVar.P(h5[0]);
                            bVar.Q(h5[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_style")) {
                        int[] h6 = h(attributeValue);
                        if (h6 != null) {
                            bVar.L(h6[0]);
                            bVar.M(h6[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_divider")) {
                        int[] h7 = h(attributeValue);
                        if (h7 != null) {
                            bVar.y(h7[0]);
                            bVar.z(h7[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_drawableTop")) {
                        int[] h8 = h(attributeValue);
                        if (h8 != null) {
                            bVar.E(h8[0]);
                            bVar.F(h8[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_drawableLeft")) {
                        int[] h9 = h(attributeValue);
                        if (h9 != null) {
                            bVar.A(h9[0]);
                            bVar.B(h9[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_drawableRight")) {
                        int[] h10 = h(attributeValue);
                        if (h10 != null) {
                            bVar.C(h10[0]);
                            bVar.D(h10[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_progressDrawable")) {
                        int[] h11 = h(attributeValue);
                        if (h11 != null) {
                            bVar.J(h11[0]);
                            bVar.K(h11[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_textColorHint") && (h2 = h(attributeValue)) != null) {
                        bVar.N(h2[0]);
                        bVar.O(h2[1]);
                        z = true;
                    }
                    if (z && TbConfig.getDebugSwitch() && (e2 = c.a.d.f.m.b.e(attributeValue.substring(1), 0)) != 0) {
                        String resourceName = this.f10555c.getResourceName(e2);
                        bVar.a(attributeName + "=" + resourceName);
                    }
                }
                if (!z || TextUtils.isEmpty(bVar.l()) || this.f10554b == null || this.f10554b.containsKey(bVar.l())) {
                    return;
                }
                this.f10554b.put(bVar.l(), bVar);
            } catch (Resources.NotFoundException unused) {
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public void j(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) || view == null) {
            return;
        }
        Stack stack = new Stack();
        stack.push(view);
        while (!stack.isEmpty()) {
            View view2 = (View) stack.pop();
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                b(viewGroup);
                if (!(view2 instanceof AdapterView)) {
                    int childCount = viewGroup.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        stack.push(viewGroup.getChildAt(i));
                    }
                }
            } else {
                a(view2);
            }
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.a = z;
        }
    }

    public void l(Resources resources) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, resources) == null) {
            this.f10556d = resources;
        }
    }
}
