package c.a.o0.a.c0.a.a;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.c0.a.a.b;
import c.a.o0.a.c0.a.c.c;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class a<V extends SwanEditText, M extends b> extends c.a.o0.a.c0.a.c.b<V, M> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@Nullable Context context, @NonNull M m) {
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
                super((Context) objArr2[0], (c) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.a.c0.a.c.b, c.a.o0.a.c0.a.d.a, c.a.o0.a.c0.b.a
    @NonNull
    /* renamed from: b0 */
    public c.a.o0.a.c0.f.b k(@NonNull M m, @NonNull M m2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, m, m2)) == null) {
            c.a.o0.a.c0.f.b k = super.k(m, m2);
            if (q() != 0 && !TextUtils.equals(((SwanEditText) q()).getText().toString(), m2.x)) {
                k.b(6);
            }
            if (m.G != m2.G) {
                k.b(10);
            }
            if (m.I != m2.I) {
                k.b(11);
            }
            if (m.J != m2.J || m.K != m2.K) {
                k.b(12);
            }
            if (!TextUtils.equals(m.L, m2.L)) {
                k.b(13);
            }
            return k;
        }
        return (c.a.o0.a.c0.f.b) invokeLL.objValue;
    }

    public void c0(@NonNull V v, @NonNull M m, @NonNull c.a.o0.a.c0.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, v, m, bVar) == null) {
            super.Q(v, m, bVar);
            if (bVar.a(11)) {
                f0(v, m);
            }
            if (bVar.a(12)) {
                h0(v, m);
            }
            if (bVar.a(10)) {
                g0(v, m);
            }
            if (bVar.a(13)) {
                e0(v, m);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.a.c0.a.d.a
    /* renamed from: d0 */
    public void S(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, v, m) == null) {
            boolean z = c.a.o0.a.c0.b.a.f4616h;
            v.setBackgroundColor(0);
        }
    }

    public boolean e0(@NonNull V v, @NonNull M m) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, v, m)) == null) {
            if (c.a.o0.a.c0.b.a.f4616h) {
                String str = "renderConfirmType:" + m.L;
            }
            String str2 = m.L;
            char c2 = 65535;
            switch (str2.hashCode()) {
                case -906336856:
                    if (str2.equals("search")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3304:
                    if (str2.equals("go")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3089282:
                    if (str2.equals(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 3377907:
                    if (str2.equals(UnitedSchemeConstants.UNITED_SCHEME_NEXT)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3526536:
                    if (str2.equals("send")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                v.setImeOptions(4);
            } else if (c2 == 1) {
                v.setImeOptions(3);
            } else if (c2 == 2) {
                v.setImeOptions(5);
            } else if (c2 == 3) {
                v.setImeOptions(2);
            } else if (c2 != 4) {
                return false;
            } else {
                v.setImeOptions(6);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void f0(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, v, m) == null) {
            boolean z = c.a.o0.a.c0.b.a.f4616h;
            Editable text = v.getText();
            int length = text != null ? text.length() : 0;
            int i2 = m.I;
            if (i2 > length || i2 < 0) {
                return;
            }
            v.setSelection(i2);
        }
    }

    public final void g0(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, v, m) == null) {
            boolean z = c.a.o0.a.c0.b.a.f4616h;
            if (m.G >= 0) {
                v.setFilters(new InputFilter[]{new InputFilter.LengthFilter(m.G)});
            }
        }
    }

    public void h0(@NonNull V v, @NonNull M m) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, v, m) == null) {
            boolean z = c.a.o0.a.c0.b.a.f4616h;
            Editable text = v.getText();
            int length = text != null ? text.length() : 0;
            int i3 = m.K;
            if (i3 > length || (i2 = m.J) < 0 || i2 > i3) {
                return;
            }
            v.setSelection(i2, i3);
        }
    }
}
