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
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b b;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<e> a;
    public Context c;
    public HashMap<String, f> d;

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
        this.a = new ArrayList<>();
        this.d = new HashMap<>();
        this.c = context.getApplicationContext();
        String d = com.baidu.android.pushservice.c.c.d(context);
        if (TextUtils.isEmpty(d)) {
            return;
        }
        try {
            ArrayList<e> c = c(m.b(d));
            if (c != null) {
                this.a.addAll(c);
            }
        } catch (Throwable th) {
            new b.c(this.c).a(Log.getStackTraceString(th)).a();
        }
    }

    public static synchronized b a(Context context) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b(context);
                }
                bVar = b;
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
                    for (int i = 0; i < list.size(); i++) {
                        try {
                            e eVar = list.get(i);
                            if (eVar != null) {
                                stringBuffer.append(eVar.b);
                                stringBuffer.append(",");
                                stringBuffer.append(eVar.a);
                                stringBuffer.append(",");
                                stringBuffer.append(eVar.d);
                                stringBuffer.append(",");
                                stringBuffer.append(eVar.c);
                                if (i != list.size() - 1) {
                                    stringBuffer.append(ParamableElem.DIVIDE_PARAM);
                                }
                            }
                        } catch (Exception e) {
                            e = e;
                            stringBuffer2 = stringBuffer;
                            new b.c(this.c).a(Log.getStackTraceString(e)).a();
                            stringBuffer = stringBuffer2;
                            if (stringBuffer != null) {
                            }
                            return "";
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
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
                if (str.equals(next.b)) {
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
        String c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{eVar, Boolean.valueOf(z), arrayList})) == null) {
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
                        c = m.c(a(arrayList));
                        com.baidu.android.pushservice.c.c.b(this.c, c);
                    }
                    while (it.hasNext()) {
                    }
                }
                if (!z2) {
                    arrayList.add(eVar);
                }
                c = m.c(a(arrayList));
                com.baidu.android.pushservice.c.c.b(this.c, c);
            }
            return c;
        }
        return (String) invokeCommon.objValue;
    }

    public void a(String str, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, fVar) == null) {
            this.d.put(str, fVar);
        }
    }

    public synchronized void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                ArrayList<e> c = c(m.b(str2));
                String str3 = "";
                if (b != null && c != null) {
                    try {
                        if (str.equals("r_v2")) {
                            ArrayList arrayList = new ArrayList();
                            Iterator<e> it = c.iterator();
                            while (it.hasNext()) {
                                arrayList.add(it.next().b);
                            }
                            int i = 0;
                            while (i < b.a.size()) {
                                if (arrayList.contains(b.a.get(i).b)) {
                                    b.a.remove(i);
                                    i--;
                                }
                                i++;
                            }
                            b.a.addAll(c);
                            str3 = a(b.a);
                        }
                        com.baidu.android.pushservice.c.c.b(this.c, m.c(str3));
                    } catch (Exception e) {
                        new b.c(this.c).a(Log.getStackTraceString(e)).a();
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
                String d = com.baidu.android.pushservice.c.c.d(context);
                ArrayList<e> c = TextUtils.isEmpty(d) ? null : c(m.b(d));
                if (b != null && c != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<e> it = c.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().b);
                    }
                    int i = 0;
                    while (i < b.a.size()) {
                        if (arrayList.contains(b.a.get(i).b)) {
                            b.a.remove(i);
                            i--;
                        }
                        i++;
                    }
                    b.a.addAll(c);
                }
            }
        }
    }

    public boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) ? !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.d.containsKey(str) && str2.equals(this.d.get(str).a()) : invokeLL.booleanValue;
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
            } catch (Exception e) {
                new b.c(this.c).a(Log.getStackTraceString(e)).a();
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) ? this.d.get(str) != null ? this.d.get(str).b() : "" : (String) invokeL.objValue;
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.d.remove(str);
        }
    }
}
