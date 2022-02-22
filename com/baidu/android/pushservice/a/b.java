package com.baidu.android.pushservice.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.httpapi.f;
import com.baidu.android.pushservice.i.m;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f31867b;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<e> a;

    /* renamed from: c  reason: collision with root package name */
    public Context f31868c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, f> f31869d;

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList<>();
        this.f31869d = new HashMap<>();
        this.f31868c = context.getApplicationContext();
        String d2 = com.baidu.android.pushservice.c.c.d(context);
        if (TextUtils.isEmpty(d2)) {
            return;
        }
        try {
            ArrayList<e> c2 = c(m.b(d2));
            if (c2 != null) {
                this.a.addAll(c2);
            }
        } catch (Throwable th) {
            new b.c(this.f31868c).a(Log.getStackTraceString(th)).a();
        }
    }

    public static synchronized b a(Context context) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (b.class) {
                if (f31867b == null) {
                    f31867b = new b(context);
                }
                bVar = f31867b;
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(List<e> list) {
        InterceptResult invokeL;
        StringBuffer stringBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, list)) == null) {
            if (list != null && list.size() != 0) {
                StringBuffer stringBuffer2 = null;
                try {
                    stringBuffer = new StringBuffer();
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        try {
                            e eVar = list.get(i2);
                            if (eVar != null) {
                                stringBuffer.append(eVar.f31865b);
                                stringBuffer.append(",");
                                stringBuffer.append(eVar.a);
                                stringBuffer.append(",");
                                stringBuffer.append(eVar.f31873d);
                                stringBuffer.append(",");
                                stringBuffer.append(eVar.f31866c);
                                if (i2 != list.size() - 1) {
                                    stringBuffer.append(";");
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            stringBuffer2 = stringBuffer;
                            new b.c(this.f31868c).a(Log.getStackTraceString(e)).a();
                            stringBuffer = stringBuffer2;
                            if (stringBuffer != null) {
                            }
                            return "";
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                }
                if (stringBuffer != null) {
                    return stringBuffer.toString();
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public e a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.a == null || TextUtils.isEmpty(str)) {
                return null;
            }
            Iterator<e> it = this.a.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (str.equals(next.f31865b)) {
                    return next;
                }
            }
            return null;
        }
        return (e) invokeL.objValue;
    }

    public String a(e eVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, z)) == null) ? a(eVar, z, this.a) : (String) invokeLZ.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0010 A[Catch: all -> 0x0049, TryCatch #0 {, blocks: (B:6:0x0006, B:7:0x000a, B:9:0x0010, B:11:0x0020, B:13:0x002a, B:15:0x002f, B:19:0x0037, B:20:0x003a), top: B:30:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized String a(e eVar, boolean z, ArrayList<e> arrayList) {
        InterceptResult invokeCommon;
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{eVar, Boolean.valueOf(z), arrayList})) == null) {
            synchronized (this) {
                boolean z2 = false;
                Iterator<e> it = arrayList.iterator();
                while (it.hasNext()) {
                    e next = it.next();
                    if (next.f31865b.equals(eVar.f31865b) || next.a.equals(eVar.a)) {
                        arrayList.remove(next);
                        if (z) {
                            arrayList.add(eVar);
                        }
                        z2 = true;
                        if (!z2 && z) {
                            arrayList.add(eVar);
                        }
                        c2 = m.c(a(arrayList));
                        com.baidu.android.pushservice.c.c.b(this.f31868c, c2);
                    }
                    while (it.hasNext()) {
                    }
                }
                if (!z2) {
                    arrayList.add(eVar);
                }
                c2 = m.c(a(arrayList));
                com.baidu.android.pushservice.c.c.b(this.f31868c, c2);
            }
            return c2;
        }
        return (String) invokeCommon.objValue;
    }

    public void a(String str, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, fVar) == null) {
            this.f31869d.put(str, fVar);
        }
    }

    public synchronized void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                ArrayList<e> c2 = c(m.b(str2));
                String str3 = "";
                if (f31867b != null && c2 != null) {
                    try {
                        if (str.equals("r_v2")) {
                            ArrayList arrayList = new ArrayList();
                            Iterator<e> it = c2.iterator();
                            while (it.hasNext()) {
                                arrayList.add(it.next().f31865b);
                            }
                            int i2 = 0;
                            while (i2 < f31867b.a.size()) {
                                if (arrayList.contains(f31867b.a.get(i2).f31865b)) {
                                    f31867b.a.remove(i2);
                                    i2--;
                                }
                                i2++;
                            }
                            f31867b.a.addAll(c2);
                            str3 = a(f31867b.a);
                        }
                        com.baidu.android.pushservice.c.c.b(this.f31868c, m.c(str3));
                    } catch (Exception e2) {
                        new b.c(this.f31868c).a(Log.getStackTraceString(e2)).a();
                    }
                }
            }
        }
    }

    public e b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Iterator<e> it = this.a.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (!TextUtils.isEmpty(next.a) && next.a.equals(str)) {
                    return next;
                }
            }
            return null;
        }
        return (e) invokeL.objValue;
    }

    public synchronized void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            synchronized (this) {
                String d2 = com.baidu.android.pushservice.c.c.d(context);
                ArrayList<e> c2 = TextUtils.isEmpty(d2) ? null : c(m.b(d2));
                if (f31867b != null && c2 != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<e> it = c2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().f31865b);
                    }
                    int i2 = 0;
                    while (i2 < f31867b.a.size()) {
                        if (arrayList.contains(f31867b.a.get(i2).f31865b)) {
                            f31867b.a.remove(i2);
                            i2--;
                        }
                        i2++;
                    }
                    f31867b.a.addAll(c2);
                }
            }
        }
    }

    public boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) ? !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.f31869d.containsKey(str) && str2.equals(this.f31869d.get(str).a()) : invokeLL.booleanValue;
    }

    public ArrayList<e> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            ArrayList<e> arrayList = new ArrayList<>();
            try {
                for (String str2 : str.trim().split(";")) {
                    String[] split = str2.trim().split(",");
                    if (split.length >= 3) {
                        e eVar = new e();
                        eVar.f31865b = split[0].trim();
                        eVar.a = split[1].trim();
                        eVar.f31873d = split[2].trim();
                        if (split.length > 3) {
                            eVar.f31866c = Integer.parseInt(split[split.length - 1].trim());
                        }
                        arrayList.add(eVar);
                    }
                }
            } catch (Exception e2) {
                new b.c(this.f31868c).a(Log.getStackTraceString(e2)).a();
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) ? this.f31869d.get(str) != null ? this.f31869d.get(str).b() : "" : (String) invokeL.objValue;
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f31869d.remove(str);
        }
    }
}
