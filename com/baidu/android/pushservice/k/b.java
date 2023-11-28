package com.baidu.android.pushservice.k;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.p.f;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ArrayList<e> b;
    public HashMap<String, f> c;

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList<>();
        this.c = new HashMap<>();
        this.a = context.getApplicationContext();
        String h = com.baidu.android.pushservice.m.d.h(context);
        if (TextUtils.isEmpty(h)) {
            return;
        }
        try {
            ArrayList<e> e = e(Utility.b(h));
            if (e != null) {
                this.b.addAll(e);
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized b a(Context context) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (b.class) {
                if (d == null) {
                    d = new b(context);
                }
                bVar = d;
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public String a(e eVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, eVar, z)) == null) ? a(eVar, z, this.b) : (String) invokeLZ.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0010 A[Catch: all -> 0x0049, TryCatch #0 {, blocks: (B:6:0x0006, B:7:0x000a, B:9:0x0010, B:11:0x0020, B:13:0x002a, B:15:0x002f, B:19:0x0037, B:20:0x003a), top: B:30:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized String a(e eVar, boolean z, ArrayList<e> arrayList) {
        InterceptResult invokeCommon;
        String c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{eVar, Boolean.valueOf(z), arrayList})) == null) {
            synchronized (this) {
                boolean z2 = false;
                Iterator<e> it = arrayList.iterator();
                while (it.hasNext()) {
                    e next = it.next();
                    if (next.b.equals(eVar.b) || next.a.equals(eVar.a)) {
                        arrayList.remove(next);
                        if (z) {
                            arrayList.add(eVar);
                        }
                        z2 = true;
                        if (!z2 && z) {
                            arrayList.add(eVar);
                        }
                        c = Utility.c(a(arrayList));
                        com.baidu.android.pushservice.m.d.g(this.a, c);
                    }
                    while (it.hasNext()) {
                    }
                }
                if (!z2) {
                    arrayList.add(eVar);
                }
                c = Utility.c(a(arrayList));
                com.baidu.android.pushservice.m.d.g(this.a, c);
            }
            return c;
        }
        return (String) invokeCommon.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? this.c.get(str) != null ? this.c.get(str).b() : "" : (String) invokeL.objValue;
    }

    public final String a(List<e> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (list != null && list.size() != 0) {
                StringBuffer stringBuffer = null;
                try {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    for (int i = 0; i < list.size(); i++) {
                        try {
                            e eVar = list.get(i);
                            if (eVar != null) {
                                stringBuffer2.append(eVar.b);
                                stringBuffer2.append(",");
                                stringBuffer2.append(eVar.a);
                                stringBuffer2.append(",");
                                stringBuffer2.append(eVar.d);
                                stringBuffer2.append(",");
                                stringBuffer2.append(eVar.c);
                                if (i != list.size() - 1) {
                                    stringBuffer2.append(ParamableElem.DIVIDE_PARAM);
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                    stringBuffer = stringBuffer2;
                } catch (Exception unused2) {
                }
                if (stringBuffer != null) {
                    return stringBuffer.toString();
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public void a(String str, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, fVar) == null) {
            this.c.put(str, fVar);
        }
    }

    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) ? !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.c.containsKey(str) && str2.equals(this.c.get(str).a()) : invokeLL.booleanValue;
    }

    public e b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Iterator<e> it = this.b.iterator();
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
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            synchronized (this) {
                String h = com.baidu.android.pushservice.m.d.h(context);
                ArrayList<e> e = TextUtils.isEmpty(h) ? null : e(Utility.b(h));
                if (d != null && e != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<e> it = e.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().b);
                    }
                    int i = 0;
                    while (i < d.b.size()) {
                        if (arrayList.contains(d.b.get(i).b)) {
                            d.b.remove(i);
                            i--;
                        }
                        i++;
                    }
                    d.b.addAll(e);
                }
            }
        }
    }

    public synchronized void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                ArrayList<e> e = e(Utility.b(str2));
                String str3 = "";
                if (d != null && e != null) {
                    try {
                        if (str.equals("r_v2")) {
                            ArrayList arrayList = new ArrayList();
                            Iterator<e> it = e.iterator();
                            while (it.hasNext()) {
                                arrayList.add(it.next().b);
                            }
                            int i = 0;
                            while (i < d.b.size()) {
                                if (arrayList.contains(d.b.get(i).b)) {
                                    d.b.remove(i);
                                    i--;
                                }
                                i++;
                            }
                            d.b.addAll(e);
                            str3 = a(d.b);
                        }
                        com.baidu.android.pushservice.m.d.g(this.a, Utility.c(str3));
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    public e c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (this.b == null || TextUtils.isEmpty(str)) {
                return null;
            }
            Iterator<e> it = this.b.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (str.equals(next.b)) {
                    return next;
                }
            }
            return null;
        }
        return (e) invokeL.objValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.c.remove(str);
        }
    }

    public ArrayList<e> e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            ArrayList<e> arrayList = new ArrayList<>();
            try {
                for (String str2 : str.trim().split(ParamableElem.DIVIDE_PARAM)) {
                    String[] split = str2.trim().split(",");
                    if (split.length >= 3) {
                        e eVar = new e();
                        eVar.b = split[0].trim();
                        eVar.a = split[1].trim();
                        eVar.d = split[2].trim();
                        if (split.length > 3) {
                            eVar.c = Integer.parseInt(split[split.length - 1].trim());
                        }
                        arrayList.add(eVar);
                    }
                }
            } catch (Exception unused) {
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }
}
