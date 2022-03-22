package c.a.n0.a.s.a.a;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.s.a.a.b;
import c.a.n0.a.s.a.c.c;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.input.ReturnKeyType;
/* loaded from: classes.dex */
public abstract class a<V extends SwanEditText, M extends b> extends c.a.n0.a.s.a.c.b<V, M> {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (c) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.s.a.c.b, c.a.n0.a.s.a.d.a, c.a.n0.a.s.b.a
    @NonNull
    /* renamed from: Z */
    public c.a.n0.a.s.f.b k(@NonNull M m, @NonNull M m2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, m, m2)) == null) {
            c.a.n0.a.s.f.b k = super.k(m, m2);
            if (q() != 0 && !TextUtils.equals(((SwanEditText) q()).getText().toString(), m2.t)) {
                k.b(6);
            }
            if (m.D != m2.D) {
                k.b(10);
            }
            if (m.F != m2.F) {
                k.b(11);
            }
            if (m.G != m2.G || m.H != m2.H) {
                k.b(12);
            }
            if (!TextUtils.equals(m.I, m2.I)) {
                k.b(13);
            }
            return k;
        }
        return (c.a.n0.a.s.f.b) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.s.a.c.b
    /* renamed from: a0 */
    public void T(@NonNull V v, @NonNull M m, @NonNull c.a.n0.a.s.f.b bVar) {
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
    @Override // c.a.n0.a.s.a.d.a
    /* renamed from: b0 */
    public void Q(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, v, m) == null) {
            if (c.a.n0.a.s.b.a.f6086h) {
                Log.d("Component-EditText", "renderBackground");
            }
            v.setBackgroundColor(0);
        }
    }

    public boolean c0(@NonNull V v, @NonNull M m) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, v, m)) == null) {
            if (c.a.n0.a.s.b.a.f6086h) {
                Log.d("Component-EditText", "renderConfirmType:" + m.I);
            }
            String str = m.I;
            char c2 = 65535;
            switch (str.hashCode()) {
                case -906336856:
                    if (str.equals("search")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case SpeedStatsStampTable.AD_LOAD_BEAR_END_STAMP_KEY /* 3304 */:
                    if (str.equals(ReturnKeyType.GO)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3089282:
                    if (str.equals("done")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 3377907:
                    if (str.equals("next")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3526536:
                    if (str.equals(ReturnKeyType.SEND)) {
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
            if (c.a.n0.a.s.b.a.f6086h) {
                Log.d("Component-EditText", "renderCursor");
            }
            Editable text = v.getText();
            int length = text != null ? text.length() : 0;
            int i = m.F;
            if (i > length || i < 0) {
                return;
            }
            v.setSelection(i);
        }
    }

    public final void e0(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, v, m) == null) {
            if (c.a.n0.a.s.b.a.f6086h) {
                Log.d("Component-EditText", "renderMaxLength");
            }
            if (m.D >= 0) {
                v.setFilters(new InputFilter[]{new InputFilter.LengthFilter(m.D)});
            }
        }
    }

    public void f0(@NonNull V v, @NonNull M m) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, v, m) == null) {
            if (c.a.n0.a.s.b.a.f6086h) {
                Log.d("Component-EditText", "renderSelection");
            }
            Editable text = v.getText();
            int length = text != null ? text.length() : 0;
            int i2 = m.H;
            if (i2 > length || (i = m.G) < 0 || i > i2) {
                return;
            }
            v.setSelection(i, i2);
        }
    }
}
