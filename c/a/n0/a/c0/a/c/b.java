package c.a.n0.a.c0.a.c;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.c0.a.c.c;
import c.a.n0.a.e0.d;
import com.baidu.adp.widget.HorizontalTranslateLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class b<V extends TextView, M extends c> extends c.a.n0.a.c0.a.d.a<V, M> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@Nullable Context context, @NonNull M m) {
        super(context, m);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, m};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (c.a.n0.a.c0.a.d.b) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.c0.a.d.a, c.a.n0.a.c0.b.a
    @NonNull
    /* renamed from: U */
    public c.a.n0.a.c0.f.b k(@NonNull M m, @NonNull M m2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, m, m2)) == null) {
            c.a.n0.a.c0.f.b k = super.k(m, m2);
            if (!TextUtils.equals(m.x, m2.x)) {
                k.b(6);
            }
            return k;
        }
        return (c.a.n0.a.c0.f.b) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.c0.a.d.a
    /* renamed from: V */
    public void Q(@NonNull V v, @NonNull M m, @NonNull c.a.n0.a.c0.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, v, m, bVar) == null) {
            super.D(v, m, bVar);
            if (bVar.a(6)) {
                W(v, m);
            }
            if (bVar.a(4)) {
                X(v, m);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: android.text.SpannableStringBuilder */
    /* JADX WARN: Multi-variable type inference failed */
    public void W(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, v, m) == null) {
            boolean z = c.a.n0.a.c0.b.a.f4370h;
            boolean z2 = !TextUtils.isEmpty(m.x) && m.B >= 0;
            String str = m.x;
            if (z2) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                spannableStringBuilder.setSpan(new a(m.B), 0, str.length(), 33);
                str = spannableStringBuilder;
            }
            v.setIncludeFontPadding(!z2);
            v.setText(str);
        }
    }

    public final void X(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, v, m) == null) || m.n == null) {
            return;
        }
        boolean z = c.a.n0.a.c0.b.a.f4370h;
        if (m.z) {
            v.setTextColor(m.y);
        }
        float f2 = (float) m.A;
        if (f2 > 0.0f) {
            v.setTextSize(1, f2);
        }
        Z(v, m);
        Y(v, m);
        String str = m.E;
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1039745817) {
            if (hashCode == -1039592053 && str.equals("nowrap")) {
                c2 = 1;
            }
        } else if (str.equals("normal")) {
            c2 = 0;
        }
        if (c2 == 0) {
            v.setSingleLine(false);
        } else if (c2 == 1) {
            v.setSingleLine(true);
        }
        if ("ellipsis".equals(m.F)) {
            v.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    public void Y(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, v, m) == null) || m.n == null) {
            return;
        }
        boolean z = c.a.n0.a.c0.b.a.f4370h;
        String str = m.D;
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1039745817) {
            if (hashCode == 3029637 && str.equals("bold")) {
                c2 = 1;
            }
        } else if (str.equals("normal")) {
            c2 = 0;
        }
        if (c2 == 0) {
            v.setTypeface(Typeface.SANS_SERIF, 0);
        } else if (c2 != 1) {
            d.l("Component-TextView", "invalid font weight : " + m.D);
            v.setTypeface(Typeface.SANS_SERIF, 0);
        } else {
            v.setTypeface(Typeface.SANS_SERIF, 1);
        }
    }

    public void Z(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, v, m) == null) {
            a0(v, m, 48);
        }
    }

    public final void a0(@NonNull V v, @NonNull M m, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048585, this, v, m, i2) == null) || m.n == null) {
            return;
        }
        boolean z = c.a.n0.a.c0.b.a.f4370h;
        String str = m.C;
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1364013995) {
            if (hashCode != 3317767) {
                if (hashCode == 108511772 && str.equals(HorizontalTranslateLayout.RIGHT)) {
                    c2 = 1;
                }
            } else if (str.equals("left")) {
                c2 = 0;
            }
        } else if (str.equals("center")) {
            c2 = 2;
        }
        if (c2 != 0) {
            if (c2 == 1) {
                i3 = 8388613 | i2;
            } else if (c2 != 2) {
                d.l("Component-TextView", "invalid text align: " + m.C);
            } else {
                i3 = i2 | 1;
            }
            v.setGravity(i3);
        }
        i3 = i2 | GravityCompat.START;
        v.setGravity(i3);
    }
}
