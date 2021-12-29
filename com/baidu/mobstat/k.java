package com.baidu.mobstat;

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
/* loaded from: classes10.dex */
public abstract class k {
    public static /* synthetic */ Interceptable $ic;
    public static final k a;

    /* renamed from: b  reason: collision with root package name */
    public static final k f38144b;

    /* renamed from: c  reason: collision with root package name */
    public static final k f38145c;

    /* renamed from: d  reason: collision with root package name */
    public static final k f38146d;

    /* renamed from: e  reason: collision with root package name */
    public static final k f38147e;

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ k[] f38148g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public int f38149f;

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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.mobstat.k
            public j a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new n() : (j) invokeV.objValue;
            }
        };
        f38144b = new k("APP_LIST", 1, 1) { // from class: com.baidu.mobstat.k.2
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.mobstat.k
            public j a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new q() : (j) invokeV.objValue;
            }
        };
        f38145c = new k("APP_TRACE", 2, 2) { // from class: com.baidu.mobstat.k.3
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.mobstat.k
            public j a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new r() : (j) invokeV.objValue;
            }
        };
        f38146d = new k("APP_CHANGE", 3, 3) { // from class: com.baidu.mobstat.k.4
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.mobstat.k
            public j a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new p() : (j) invokeV.objValue;
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.mobstat.k
            public j a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new o() : (j) invokeV.objValue;
            }
        };
        f38147e = kVar;
        f38148g = new k[]{a, f38144b, f38145c, f38146d, kVar};
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    private int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            j jVar = null;
            try {
                try {
                    jVar = a();
                } catch (Exception e2) {
                    bb.c().b(e2);
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
        return invokeV.intValue;
    }

    public static k valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? (k) Enum.valueOf(k.class, str) : (k) invokeL.objValue;
    }

    public static k[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? (k[]) f38148g.clone() : (k[]) invokeV.objValue;
    }

    public abstract j a();

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
    public synchronized ArrayList<i> a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeII = interceptable.invokeII(1048579, this, i2, i3)) != null) {
            return (ArrayList) invokeII.objValue;
        }
        synchronized (this) {
            ArrayList<i> arrayList = new ArrayList<>();
            j jVar = null;
            try {
                jVar = a();
                if (!jVar.a()) {
                    if (jVar != null) {
                        jVar.close();
                    }
                    return arrayList;
                }
                arrayList = jVar.a(i2, i3);
            } catch (Exception e2) {
                bb.c().b(e2);
            }
        }
    }

    public synchronized boolean b() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                z = c() == 0;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? String.valueOf(this.f38149f) : (String) invokeV.objValue;
    }

    public k(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38149f = i3;
    }

    public synchronized boolean b(int i2) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            synchronized (this) {
                z = c() >= i2;
            }
            return z;
        }
        return invokeI.booleanValue;
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
    public synchronized long a(long j2, String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeJL = interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2, str)) != null) {
            return invokeJL.longValue;
        }
        synchronized (this) {
            long j3 = -1;
            j jVar = null;
            try {
                jVar = a();
                if (!jVar.a()) {
                    if (jVar != null) {
                        jVar.close();
                    }
                    return -1L;
                }
                j3 = jVar.a(String.valueOf(j2), str);
            } catch (Exception e2) {
                bb.c().b(e2);
            }
        }
    }

    public synchronized int a(ArrayList<Long> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, arrayList)) == null) {
            synchronized (this) {
                int i2 = 0;
                if (arrayList != null) {
                    if (arrayList.size() != 0) {
                        j jVar = null;
                        try {
                            jVar = a();
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
                        int i3 = 0;
                        while (i2 < size) {
                            try {
                                if (!jVar.b(arrayList.get(i2).longValue())) {
                                    if (jVar != null) {
                                        jVar.close();
                                    }
                                    return i3;
                                }
                                i3++;
                                i2++;
                            } catch (Exception e3) {
                                e = e3;
                                i2 = i3;
                                bb.c().b(e);
                                if (jVar != null) {
                                    jVar.close();
                                }
                                i3 = i2;
                                return i3;
                            }
                        }
                        if (jVar != null) {
                            jVar.close();
                        }
                        return i3;
                    }
                }
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public synchronized List<String> a(int i2) {
        InterceptResult invokeI;
        List<String> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            synchronized (this) {
                arrayList = new ArrayList<>();
                ArrayList<Long> arrayList2 = new ArrayList<>();
                ArrayList<i> arrayList3 = new ArrayList<>();
                a(arrayList, arrayList2, arrayList3, i2, 500);
                if (arrayList3.size() != 0 && arrayList.size() == 0 && arrayList2.size() == 0) {
                    i iVar = arrayList3.get(0);
                    long a2 = iVar.a();
                    String b2 = iVar.b();
                    arrayList2.add(Long.valueOf(a2));
                    arrayList.add(b2);
                }
                int a3 = a(arrayList2);
                if (a3 != arrayList.size()) {
                    arrayList = arrayList.subList(0, a3);
                }
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    private int a(List<String> list, ArrayList<Long> arrayList, ArrayList<i> arrayList2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{list, arrayList, arrayList2, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            int c2 = c();
            int i4 = 0;
            int i5 = 0;
            while (c2 > 0) {
                if (c2 < i3) {
                    i3 = c2;
                }
                ArrayList<i> a2 = a(i3, i5);
                if (i5 == 0 && a2.size() != 0) {
                    arrayList2.add(a2.get(0));
                }
                Iterator<i> it = a2.iterator();
                while (it.hasNext()) {
                    i next = it.next();
                    long a3 = next.a();
                    String b2 = next.b();
                    int length = b2.length() + i4;
                    if (length > i2) {
                        break;
                    }
                    arrayList.add(Long.valueOf(a3));
                    list.add(b2);
                    i4 = length;
                }
                c2 -= i3;
                i5 += i3;
            }
            return i4;
        }
        return invokeCommon.intValue;
    }
}
