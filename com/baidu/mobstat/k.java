package com.baidu.mobstat;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public abstract class k {
    public static /* synthetic */ Interceptable $ic;
    public static final k a;
    public static final k b;
    public static final k c;
    public static final k d;
    public static final k e;
    public static final /* synthetic */ k[] g;
    public transient /* synthetic */ FieldHolder $fh;
    public int f;

    public abstract j a(Context context);

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1366709927, "Lcom/baidu/mobstat/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1366709927, "Lcom/baidu/mobstat/k;");
                return;
            }
        }
        a = new k("AP_LIST", 0, 0) { // from class: com.baidu.mobstat.k.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r10, r11, r12);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r10, Integer.valueOf(r11), Integer.valueOf(r12)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.mobstat.k
            public j a(Context context) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, context)) == null) {
                    return new m(context);
                }
                return (j) invokeL.objValue;
            }
        };
        b = new k("APP_LIST", 1, 1) { // from class: com.baidu.mobstat.k.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r10, r11, r12);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r10, Integer.valueOf(r11), Integer.valueOf(r12)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.mobstat.k
            public j a(Context context) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, context)) == null) {
                    return new p(context);
                }
                return (j) invokeL.objValue;
            }
        };
        c = new k("APP_TRACE", 2, 2) { // from class: com.baidu.mobstat.k.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r10, r11, r12);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r10, Integer.valueOf(r11), Integer.valueOf(r12)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.mobstat.k
            public j a(Context context) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, context)) == null) {
                    return new q(context);
                }
                return (j) invokeL.objValue;
            }
        };
        d = new k("APP_CHANGE", 3, 3) { // from class: com.baidu.mobstat.k.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r10, r11, r12);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r10, Integer.valueOf(r11), Integer.valueOf(r12)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.mobstat.k
            public j a(Context context) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, context)) == null) {
                    return new o(context);
                }
                return (j) invokeL.objValue;
            }
        };
        k kVar = new k("APP_APK", 4, 4) { // from class: com.baidu.mobstat.k.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r10, r11, r12);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r10, Integer.valueOf(r11), Integer.valueOf(r12)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.mobstat.k
            public j a(Context context) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, context)) == null) {
                    return new n(context);
                }
                return (j) invokeL.objValue;
            }
        };
        e = kVar;
        g = new k[]{a, b, c, d, kVar};
    }

    public k(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
        if (r2 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0023, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
        if (r2 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0035, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized long a(Context context, long j, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Long.valueOf(j), str})) == null) {
            synchronized (this) {
                long j2 = -1;
                j jVar = null;
                try {
                    jVar = a(context);
                    if (!jVar.a()) {
                        if (jVar != null) {
                            jVar.close();
                        }
                        return -1L;
                    }
                    j2 = jVar.a(String.valueOf(j), str);
                } catch (Exception e2) {
                    ba.c().b(e2);
                }
            }
        } else {
            return invokeCommon.longValue;
        }
    }

    private int a(Context context, List list, ArrayList arrayList, ArrayList arrayList2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{context, list, arrayList, arrayList2, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            int c2 = c(context);
            int i3 = 0;
            int i4 = 0;
            while (c2 > 0) {
                if (c2 < i2) {
                    i2 = c2;
                }
                ArrayList a2 = a(context, i2, i4);
                if (i4 == 0 && a2.size() != 0) {
                    arrayList2.add((i) a2.get(0));
                }
                Iterator it = a2.iterator();
                while (it.hasNext()) {
                    i iVar = (i) it.next();
                    long a3 = iVar.a();
                    String b2 = iVar.b();
                    int length = b2.length() + i3;
                    if (length > i) {
                        break;
                    }
                    arrayList.add(Long.valueOf(a3));
                    list.add(b2);
                    i3 = length;
                }
                c2 -= i2;
                i4 += i2;
            }
            return i3;
        }
        return invokeCommon.intValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    private int c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context)) == null) {
            j jVar = null;
            try {
                try {
                    jVar = a(context);
                } catch (Exception e2) {
                    ba.c().b(e2);
                    if (jVar == null) {
                        return 0;
                    }
                }
                if (jVar.a()) {
                    int b2 = jVar.b();
                    if (jVar != null) {
                        jVar.close();
                    }
                    return b2;
                }
                if (jVar == null) {
                    return 0;
                }
                jVar.close();
                return 0;
            } catch (Throwable th) {
                if (jVar != null) {
                    jVar.close();
                }
                throw th;
            }
        }
        return invokeL.intValue;
    }

    public static k valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            return (k) Enum.valueOf(k.class, str);
        }
        return (k) invokeL.objValue;
    }

    public synchronized boolean b(Context context) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            synchronized (this) {
                if (c(context) == 0) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static k[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return (k[]) g.clone();
        }
        return (k[]) invokeV.objValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return String.valueOf(this.f);
        }
        return (String) invokeV.objValue;
    }

    public synchronized int a(Context context, ArrayList arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, arrayList)) == null) {
            synchronized (this) {
                int i = 0;
                if (arrayList != null) {
                    if (arrayList.size() != 0) {
                        j jVar = null;
                        try {
                            jVar = a(context);
                        } catch (Exception e2) {
                            e = e2;
                        }
                        if (!jVar.a()) {
                            if (jVar != null) {
                                jVar.close();
                            }
                            return 0;
                        }
                        int size = arrayList.size();
                        int i2 = 0;
                        while (i < size) {
                            try {
                                if (!jVar.b(((Long) arrayList.get(i)).longValue())) {
                                    if (jVar != null) {
                                        jVar.close();
                                    }
                                    return i2;
                                }
                                i2++;
                                i++;
                            } catch (Exception e3) {
                                e = e3;
                                i = i2;
                                ba.c().b(e);
                                if (jVar != null) {
                                    jVar.close();
                                }
                                i2 = i;
                                return i2;
                            }
                        }
                        if (jVar != null) {
                            jVar.close();
                        }
                        return i2;
                    }
                }
                return 0;
            }
        }
        return invokeLL.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0020, code lost:
        if (r1 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0022, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0030, code lost:
        if (r1 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0034, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized ArrayList a(Context context, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, context, i, i2)) == null) {
            synchronized (this) {
                ArrayList arrayList = new ArrayList();
                j jVar = null;
                try {
                    jVar = a(context);
                    if (!jVar.a()) {
                        if (jVar != null) {
                            jVar.close();
                        }
                        return arrayList;
                    }
                    arrayList = jVar.a(i, i2);
                } catch (Exception e2) {
                    ba.c().b(e2);
                }
            }
        } else {
            return (ArrayList) invokeLII.objValue;
        }
    }

    public synchronized List a(Context context, int i) {
        InterceptResult invokeLI;
        List arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, context, i)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                a(context, arrayList, arrayList2, arrayList3, i, 500);
                if (arrayList3.size() != 0 && arrayList.size() == 0 && arrayList2.size() == 0) {
                    i iVar = (i) arrayList3.get(0);
                    long a2 = iVar.a();
                    String b2 = iVar.b();
                    arrayList2.add(Long.valueOf(a2));
                    arrayList.add(b2);
                }
                int a3 = a(context, arrayList2);
                if (a3 != arrayList.size()) {
                    arrayList = arrayList.subList(0, a3);
                }
            }
            return arrayList;
        }
        return (List) invokeLI.objValue;
    }

    public synchronized boolean b(Context context, int i) {
        InterceptResult invokeLI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, context, i)) == null) {
            synchronized (this) {
                if (c(context) >= i) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }
        return invokeLI.booleanValue;
    }
}
