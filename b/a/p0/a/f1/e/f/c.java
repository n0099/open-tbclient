package b.a.p0.a.f1.e.f;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.f1.e.f.c;
import b.a.p0.a.v2.e1.d;
import b.a.p0.a.v2.y0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.TypeCastException;
/* loaded from: classes.dex */
public abstract class c<SelfT extends c<SelfT>> implements d<SelfT> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f5061e;

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

        public a D() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (a) invokeV.objValue;
        }

        @Override // b.a.p0.a.v2.e1.d
        public /* bridge */ /* synthetic */ d a() {
            D();
            return this;
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

    public SelfT A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (q()) {
                this.f5061e.remove(str);
            }
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    public Bundle B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!q()) {
                this.f5061e = new Bundle();
            }
            return this.f5061e;
        }
        return (Bundle) invokeV.objValue;
    }

    public Bundle C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? q() ? new Bundle(B()) : new Bundle() : (Bundle) invokeV.objValue;
    }

    public SelfT b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (q()) {
                this.f5061e.clear();
            }
            return (SelfT) a();
        }
        return (SelfT) invokeV.objValue;
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? q() && this.f5061e.containsKey(str) : invokeL.booleanValue;
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? b.a.p0.a.f1.e.f.a.f5052a.a(this, str).booleanValue() : invokeL.booleanValue;
    }

    public boolean e(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) ? b.a.p0.a.f1.e.f.a.f5052a.b(this, str, Boolean.valueOf(z)).booleanValue() : invokeLZ.booleanValue;
    }

    @Nullable
    public Bundle f(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? b.a.p0.a.f1.e.f.a.f5058g.a(this, str) : (Bundle) invokeL.objValue;
    }

    public float g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? b.a.p0.a.f1.e.f.a.f5055d.a(this, str).floatValue() : invokeL.floatValue;
    }

    public float h(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048585, this, str, f2)) == null) ? b.a.p0.a.f1.e.f.a.f5055d.b(this, str, Float.valueOf(f2)).floatValue() : invokeLF.floatValue;
    }

    public int i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? b.a.p0.a.f1.e.f.a.f5053b.a(this, str).intValue() : invokeL.intValue;
    }

    public int j(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, str, i2)) == null) ? b.a.p0.a.f1.e.f.a.f5053b.b(this, str, Integer.valueOf(i2)).intValue() : invokeLI.intValue;
    }

    public long k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) ? b.a.p0.a.f1.e.f.a.f5054c.a(this, str).longValue() : invokeL.longValue;
    }

    public long l(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048589, this, str, j)) == null) ? b.a.p0.a.f1.e.f.a.f5054c.b(this, str, Long.valueOf(j)).longValue() : invokeLJ.longValue;
    }

    @Nullable
    public <T extends Parcelable> T m(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            try {
                return (T) b.a.p0.a.f1.e.f.a.f5059h.a(this, str);
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) ? b.a.p0.a.f1.e.f.a.f5056e.a(this, str) : (String) invokeL.objValue;
    }

    public String o(@Nullable String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, str, str2)) == null) ? b.a.p0.a.f1.e.f.a.f5056e.b(this, str, str2) : (String) invokeLL.objValue;
    }

    @Nullable
    public String[] p(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? b.a.p0.a.f1.e.f.a.f5057f.a(this, str) : (String[]) invokeL.objValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f5061e != null : invokeV.booleanValue;
    }

    public SelfT r(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, bundle)) == null) {
            if (bundle != null && !bundle.isEmpty()) {
                B().putAll(bundle);
            }
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT s(@Nullable String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048596, this, str, z)) == null) {
            b.a.p0.a.f1.e.f.a.f5052a.d(this, str, Boolean.valueOf(z));
            return (SelfT) a();
        }
        return (SelfT) invokeLZ.objValue;
    }

    public SelfT t(@Nullable String str, @Nullable Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, str, bundle)) == null) {
            b.a.p0.a.f1.e.f.a.f5058g.d(this, str, bundle);
            return (SelfT) a();
        }
        return (SelfT) invokeLL.objValue;
    }

    public synchronized String toString() {
        InterceptResult invokeV;
        String bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            synchronized (this) {
                bundle = q() ? this.f5061e.toString() : "empty";
            }
            return bundle;
        }
        return (String) invokeV.objValue;
    }

    public SelfT u(@Nullable String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048599, this, str, f2)) == null) {
            b.a.p0.a.f1.e.f.a.f5055d.d(this, str, Float.valueOf(f2));
            return (SelfT) a();
        }
        return (SelfT) invokeLF.objValue;
    }

    public SelfT update(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, bundle)) == null) {
            r(bundle);
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT v(@Nullable String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048601, this, str, i2)) == null) {
            b.a.p0.a.f1.e.f.a.f5053b.d(this, str, Integer.valueOf(i2));
            return (SelfT) a();
        }
        return (SelfT) invokeLI.objValue;
    }

    public SelfT w(@Nullable String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048602, this, str, j)) == null) {
            b.a.p0.a.f1.e.f.a.f5054c.d(this, str, Long.valueOf(j));
            return (SelfT) a();
        }
        return (SelfT) invokeLJ.objValue;
    }

    public SelfT x(@Nullable String str, @Nullable Parcelable parcelable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, str, parcelable)) == null) {
            b.a.p0.a.f1.e.f.a.f5059h.d(this, str, parcelable);
            return (SelfT) a();
        }
        return (SelfT) invokeLL.objValue;
    }

    public SelfT y(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            b.a.p0.a.f1.e.f.a.f5056e.d(this, str, str2);
            return (SelfT) a();
        }
        return (SelfT) invokeLL.objValue;
    }

    public SelfT z(@Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, str, strArr)) == null) {
            b.a.p0.a.f1.e.f.a.f5057f.d(this, str, strArr);
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
        new y0();
        this.f5061e = bundle;
    }
}
