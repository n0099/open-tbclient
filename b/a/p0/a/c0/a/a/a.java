package b.a.p0.a.c0.a.a;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.c0.a.a.b;
import b.a.p0.a.c0.a.c.c;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class a<V extends SwanEditText, M extends b> extends b.a.p0.a.c0.a.c.b<V, M> {
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
    @Override // b.a.p0.a.c0.a.c.b, b.a.p0.a.c0.a.d.a, b.a.p0.a.c0.b.a
    @NonNull
    /* renamed from: Z */
    public b.a.p0.a.c0.f.b k(@NonNull M m, @NonNull M m2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, m, m2)) == null) {
            b.a.p0.a.c0.f.b k = super.k(m, m2);
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
        return (b.a.p0.a.c0.f.b) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.c0.a.c.b
    /* renamed from: a0 */
    public void T(@NonNull V v, @NonNull M m, @NonNull b.a.p0.a.c0.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, v, m, bVar) == null) {
            super.O(v, m, bVar);
            if (bVar.a(11)) {
                d0(v, m);
            }
            if (bVar.a(12)) {
                f0(v, m);
            }
            if (bVar.a(10)) {
                e0(v, m);
            }
            if (bVar.a(13)) {
                c0(v, m);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.c0.a.d.a
    /* renamed from: b0 */
    public void Q(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, v, m) == null) {
            boolean z = b.a.p0.a.c0.b.a.f4044h;
            v.setBackgroundColor(0);
        }
    }

    public boolean c0(@NonNull V v, @NonNull M m) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, v, m)) == null) {
            if (b.a.p0.a.c0.b.a.f4044h) {
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

    public void d0(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, v, m) == null) {
            boolean z = b.a.p0.a.c0.b.a.f4044h;
            Editable text = v.getText();
            int length = text != null ? text.length() : 0;
            int i2 = m.I;
            if (i2 > length || i2 < 0) {
                return;
            }
            v.setSelection(i2);
        }
    }

    public final void e0(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, v, m) == null) {
            boolean z = b.a.p0.a.c0.b.a.f4044h;
            if (m.G >= 0) {
                v.setFilters(new InputFilter[]{new InputFilter.LengthFilter(m.G)});
            }
        }
    }

    public void f0(@NonNull V v, @NonNull M m) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, v, m) == null) {
            boolean z = b.a.p0.a.c0.b.a.f4044h;
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
