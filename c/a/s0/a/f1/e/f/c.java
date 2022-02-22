package c.a.s0.a.f1.e.f;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.f1.e.f.c;
import c.a.s0.a.z2.g1.f;
import c.a.s0.a.z2.z0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.TypeCastException;
/* loaded from: classes.dex */
public abstract class c<SelfT extends c<SelfT>> implements f<SelfT> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f6082e;

    /* loaded from: classes.dex */
    public static final class a extends c<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public a E() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (a) invokeV.objValue;
        }

        @Override // c.a.s0.a.z2.g1.f
        public /* bridge */ /* synthetic */ f a() {
            E();
            return this;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Bundle bundle) {
            super(bundle);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bundle};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Bundle) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((Bundle) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static String r(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            return str + "." + str2;
        }
        return (String) invokeLL.objValue;
    }

    public SelfT A(@Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, strArr)) == null) {
            c.a.s0.a.f1.e.f.a.f6079f.d(this, str, strArr);
            return (SelfT) a();
        }
        return (SelfT) invokeLL.objValue;
    }

    public SelfT B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (q()) {
                this.f6082e.remove(str);
            }
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    public Bundle C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!q()) {
                this.f6082e = new Bundle();
            }
            return this.f6082e;
        }
        return (Bundle) invokeV.objValue;
    }

    public Bundle D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? q() ? new Bundle(C()) : new Bundle() : (Bundle) invokeV.objValue;
    }

    public SelfT b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (q()) {
                this.f6082e.clear();
            }
            return (SelfT) a();
        }
        return (SelfT) invokeV.objValue;
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? q() && this.f6082e.containsKey(str) : invokeL.booleanValue;
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? c.a.s0.a.f1.e.f.a.a.a(this, str).booleanValue() : invokeL.booleanValue;
    }

    public boolean e(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048583, this, str, z)) == null) ? c.a.s0.a.f1.e.f.a.a.b(this, str, Boolean.valueOf(z)).booleanValue() : invokeLZ.booleanValue;
    }

    @Nullable
    public Bundle f(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? c.a.s0.a.f1.e.f.a.f6080g.a(this, str) : (Bundle) invokeL.objValue;
    }

    public float g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) ? c.a.s0.a.f1.e.f.a.f6077d.a(this, str).floatValue() : invokeL.floatValue;
    }

    public float h(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048586, this, str, f2)) == null) ? c.a.s0.a.f1.e.f.a.f6077d.b(this, str, Float.valueOf(f2)).floatValue() : invokeLF.floatValue;
    }

    public int i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) ? c.a.s0.a.f1.e.f.a.f6075b.a(this, str).intValue() : invokeL.intValue;
    }

    public int j(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, str, i2)) == null) ? c.a.s0.a.f1.e.f.a.f6075b.b(this, str, Integer.valueOf(i2)).intValue() : invokeLI.intValue;
    }

    public long k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) ? c.a.s0.a.f1.e.f.a.f6076c.a(this, str).longValue() : invokeL.longValue;
    }

    public long l(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048590, this, str, j2)) == null) ? c.a.s0.a.f1.e.f.a.f6076c.b(this, str, Long.valueOf(j2)).longValue() : invokeLJ.longValue;
    }

    @Nullable
    public <T extends Parcelable> T m(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            try {
                return (T) c.a.s0.a.f1.e.f.a.f6081h.a(this, str);
            } catch (TypeCastException unused) {
                return null;
            }
        }
        return (T) invokeL.objValue;
    }

    @Nullable
    public String n(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) ? c.a.s0.a.f1.e.f.a.f6078e.a(this, str) : (String) invokeL.objValue;
    }

    public String o(@Nullable String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) ? c.a.s0.a.f1.e.f.a.f6078e.b(this, str, str2) : (String) invokeLL.objValue;
    }

    @Nullable
    public String[] p(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) ? c.a.s0.a.f1.e.f.a.f6079f.a(this, str) : (String[]) invokeL.objValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f6082e != null : invokeV.booleanValue;
    }

    public SelfT s(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, bundle)) == null) {
            if (bundle != null && !bundle.isEmpty()) {
                C().putAll(bundle);
            }
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT t(@Nullable String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048597, this, str, z)) == null) {
            c.a.s0.a.f1.e.f.a.a.d(this, str, Boolean.valueOf(z));
            return (SelfT) a();
        }
        return (SelfT) invokeLZ.objValue;
    }

    public synchronized String toString() {
        InterceptResult invokeV;
        String bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            synchronized (this) {
                bundle = q() ? this.f6082e.toString() : SchemeCollecter.CLASSIFY_EMPTY;
            }
            return bundle;
        }
        return (String) invokeV.objValue;
    }

    public SelfT u(@Nullable String str, @Nullable Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, str, bundle)) == null) {
            c.a.s0.a.f1.e.f.a.f6080g.d(this, str, bundle);
            return (SelfT) a();
        }
        return (SelfT) invokeLL.objValue;
    }

    public SelfT update(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, bundle)) == null) {
            s(bundle);
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT v(@Nullable String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048601, this, str, f2)) == null) {
            c.a.s0.a.f1.e.f.a.f6077d.d(this, str, Float.valueOf(f2));
            return (SelfT) a();
        }
        return (SelfT) invokeLF.objValue;
    }

    public SelfT w(@Nullable String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048602, this, str, i2)) == null) {
            c.a.s0.a.f1.e.f.a.f6075b.d(this, str, Integer.valueOf(i2));
            return (SelfT) a();
        }
        return (SelfT) invokeLI.objValue;
    }

    public SelfT x(@Nullable String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048603, this, str, j2)) == null) {
            c.a.s0.a.f1.e.f.a.f6076c.d(this, str, Long.valueOf(j2));
            return (SelfT) a();
        }
        return (SelfT) invokeLJ.objValue;
    }

    public SelfT y(@Nullable String str, @Nullable Parcelable parcelable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, parcelable)) == null) {
            c.a.s0.a.f1.e.f.a.f6081h.d(this, str, parcelable);
            return (SelfT) a();
        }
        return (SelfT) invokeLL.objValue;
    }

    public SelfT z(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, str, str2)) == null) {
            c.a.s0.a.f1.e.f.a.f6078e.d(this, str, str2);
            return (SelfT) a();
        }
        return (SelfT) invokeLL.objValue;
    }

    public c(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bundle};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        new z0();
        this.f6082e = bundle;
    }
}
