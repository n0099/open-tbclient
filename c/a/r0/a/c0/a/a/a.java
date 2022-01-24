package c.a.r0.a.c0.a.a;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.c0.a.a.b;
import c.a.r0.a.c0.a.c.c;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.input.ReturnKeyType;
/* loaded from: classes.dex */
public abstract class a<V extends SwanEditText, M extends b> extends c.a.r0.a.c0.a.c.b<V, M> {
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
    @Override // c.a.r0.a.c0.a.c.b, c.a.r0.a.c0.a.d.a, c.a.r0.a.c0.b.a
    @NonNull
    /* renamed from: Z */
    public c.a.r0.a.c0.f.b k(@NonNull M m, @NonNull M m2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, m, m2)) == null) {
            c.a.r0.a.c0.f.b k = super.k(m, m2);
            if (q() != 0 && !TextUtils.equals(((SwanEditText) q()).getText().toString(), m2.x)) {
                k.b(6);
            }
            if (m.H != m2.H) {
                k.b(10);
            }
            if (m.J != m2.J) {
                k.b(11);
            }
            if (m.K != m2.K || m.L != m2.L) {
                k.b(12);
            }
            if (!TextUtils.equals(m.M, m2.M)) {
                k.b(13);
            }
            return k;
        }
        return (c.a.r0.a.c0.f.b) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a.c0.a.c.b
    /* renamed from: a0 */
    public void T(@NonNull V v, @NonNull M m, @NonNull c.a.r0.a.c0.f.b bVar) {
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
    @Override // c.a.r0.a.c0.a.d.a
    /* renamed from: b0 */
    public void Q(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, v, m) == null) {
            boolean z = c.a.r0.a.c0.b.a.f5438h;
            v.setBackgroundColor(0);
        }
    }

    public boolean c0(@NonNull V v, @NonNull M m) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, v, m)) == null) {
            if (c.a.r0.a.c0.b.a.f5438h) {
                String str = "renderConfirmType:" + m.M;
            }
            String str2 = m.M;
            char c2 = 65535;
            switch (str2.hashCode()) {
                case -906336856:
                    if (str2.equals("search")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case SpeedStatsStampTable.AD_SDK_DO_SHOW_STAMP_KEY /* 3304 */:
                    if (str2.equals(ReturnKeyType.GO)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3089282:
                    if (str2.equals("done")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 3377907:
                    if (str2.equals("next")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3526536:
                    if (str2.equals(ReturnKeyType.SEND)) {
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
            boolean z = c.a.r0.a.c0.b.a.f5438h;
            Editable text = v.getText();
            int length = text != null ? text.length() : 0;
            int i2 = m.J;
            if (i2 > length || i2 < 0) {
                return;
            }
            v.setSelection(i2);
        }
    }

    public final void e0(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, v, m) == null) {
            boolean z = c.a.r0.a.c0.b.a.f5438h;
            if (m.H >= 0) {
                v.setFilters(new InputFilter[]{new InputFilter.LengthFilter(m.H)});
            }
        }
    }

    public void f0(@NonNull V v, @NonNull M m) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, v, m) == null) {
            boolean z = c.a.r0.a.c0.b.a.f5438h;
            Editable text = v.getText();
            int length = text != null ? text.length() : 0;
            int i3 = m.L;
            if (i3 > length || (i2 = m.K) < 0 || i2 > i3) {
                return;
            }
            v.setSelection(i2, i3);
        }
    }
}
