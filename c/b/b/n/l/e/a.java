package c.b.b.n.l.e;

import androidx.core.view.InputDeviceCompat;
import c.b.b.q.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.beans.BankSignFactory;
/* loaded from: classes7.dex */
public class a extends c.b.b.n.l.a {
    public static /* synthetic */ Interceptable $ic;
    public static final long l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public boolean f27593h;

    /* renamed from: i  reason: collision with root package name */
    public int f27594i;

    /* renamed from: j  reason: collision with root package name */
    public int f27595j;

    /* renamed from: k  reason: collision with root package name */
    public float f27596k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-390527302, "Lc/b/b/n/l/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-390527302, "Lc/b/b/n/l/e/a;");
                return;
            }
        }
        l = c.b.b.n.l.a.d("blended");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: e */
    public int compareTo(c.b.b.n.l.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            long j2 = this.f27579e;
            long j3 = aVar.f27579e;
            if (j2 != j3) {
                return (int) (j2 - j3);
            }
            a aVar2 = (a) aVar;
            boolean z = this.f27593h;
            if (z != aVar2.f27593h) {
                return z ? 1 : -1;
            }
            int i2 = this.f27594i;
            int i3 = aVar2.f27594i;
            if (i2 != i3) {
                return i2 - i3;
            }
            int i4 = this.f27595j;
            int i5 = aVar2.f27595j;
            if (i4 != i5) {
                return i4 - i5;
            }
            if (com.badlogic.gdx.math.d.e(this.f27596k, aVar2.f27596k)) {
                return 0;
            }
            return this.f27596k < aVar2.f27596k ? 1 : -1;
        }
        return invokeL.intValue;
    }

    @Override // c.b.b.n.l.a
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (((((((super.hashCode() * 947) + (this.f27593h ? 1 : 0)) * 947) + this.f27594i) * 947) + this.f27595j) * 947) + t.b(this.f27596k);
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(boolean z, int i2, int i3, float f2) {
        super(l);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super(((Long) newInitContext.callArgs[0]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.f27596k = 1.0f;
        this.f27593h = z;
        this.f27594i = i2;
        this.f27595j = i3;
        this.f27596k = f2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(int i2, int i3, float f2) {
        this(true, i2, i3, f2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Float) objArr2[3]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(a aVar) {
        this(aVar == null || aVar.f27593h, aVar == null ? BankSignFactory.BEAN_ID_QUERY : aVar.f27594i, aVar == null ? BankSignFactory.BEAN_ID_BIND_CARD : aVar.f27595j, aVar == null ? 1.0f : aVar.f27596k);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Float) objArr2[3]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }
}
