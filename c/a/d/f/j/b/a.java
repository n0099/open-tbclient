package c.a.d.f.j.b;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.j.a.c;
import c.a.d.f.j.a.e;
import c.a.d.f.j.a.g;
import c.a.d.f.j.a.h;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static String f2857d;

    /* renamed from: e  reason: collision with root package name */
    public static String f2858e;

    /* renamed from: f  reason: collision with root package name */
    public static String f2859f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f2860g;

    /* renamed from: h  reason: collision with root package name */
    public static String f2861h;

    /* renamed from: i  reason: collision with root package name */
    public static String f2862i;

    /* renamed from: j  reason: collision with root package name */
    public static String f2863j;

    /* renamed from: k  reason: collision with root package name */
    public static String f2864k;
    public transient /* synthetic */ FieldHolder $fh;
    public e a;

    /* renamed from: b  reason: collision with root package name */
    public c f2865b;

    /* renamed from: c  reason: collision with root package name */
    public long f2866c;

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
                return;
            }
        }
        i();
    }

    public static void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            f2857d = str;
        }
    }

    public static void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            f2861h = str;
        }
    }

    public static void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            f2862i = str;
        }
    }

    public static void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            f2863j = str;
        }
    }

    public static void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            f2864k = str;
        }
    }

    public static void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65542, null, z) == null) {
            f2860g = z;
        }
    }

    public static void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            f2859f = str;
        }
    }

    public static void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            f2858e = str;
        }
    }

    public final void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            b(eVar, false);
        }
    }

    public final void b(e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, z) == null) || eVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(f2857d)) {
            eVar.b().a("Cookie", f2857d);
        } else {
            eVar.b().a("Cookie", "");
        }
        if (!TextUtils.isEmpty(f2859f)) {
            eVar.b().a("client_user_token", f2859f);
        }
        if (!TextUtils.isEmpty(f2858e)) {
            eVar.b().a("User-Agent", f2858e);
        }
        if (z) {
            eVar.b().a("Accept-Encoding", "gzip");
        } else {
            eVar.b().a("Accept-Encoding", "");
        }
        if (f2860g) {
            eVar.b().a(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        } else {
            eVar.b().a(HTTP.CONN_DIRECTIVE, IntentConfig.CLOSE);
        }
        eVar.b().a("client_logid", String.valueOf(this.f2866c));
        if (!TextUtils.isEmpty(f2861h)) {
            eVar.b().a("cuid", f2861h);
        }
        if (!TextUtils.isEmpty(f2862i)) {
            eVar.b().a("cuid_galaxy2", f2862i);
        }
        if (!TextUtils.isEmpty(f2863j)) {
            eVar.b().a("c3_aid", f2863j);
        }
        if (TextUtils.isEmpty(f2864k)) {
            return;
        }
        eVar.b().a(TiebaStatic.Params.CUID_GID, f2864k);
    }

    public void c() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (cVar = this.f2865b) == null) {
            return;
        }
        cVar.b();
    }

    public boolean d(String str, String str2, boolean z, int i2, int i3, int i4, int i5, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), linkedList, hVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            e eVar = new e();
            this.a = eVar;
            a(eVar);
            this.a.b().s(str);
            this.a.b().o(z4);
            c cVar = new c(this.a);
            this.f2865b = cVar;
            return cVar.c(str2, hVar, i2, i3, i4, i5, z2, z3);
        }
        return invokeCommon.booleanValue;
    }

    public e e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (e) invokeV.objValue;
    }

    public c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f2865b : (c) invokeV.objValue;
    }

    public g g(String str, int i2, int i3, int i4, int i5, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), linkedList})) == null) ? h(str, false, i2, i3, i4, i5, linkedList) : (g) invokeCommon.objValue;
    }

    public g h(String str, boolean z, int i2, int i3, int i4, int i5, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), linkedList})) == null) {
            e eVar = new e();
            this.a = eVar;
            b(eVar, z);
            this.a.b().s(str);
            c cVar = new c(this.a);
            this.f2865b = cVar;
            cVar.e(i2, i4, i5);
            return this.a.c();
        }
        return (g) invokeCommon.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            System.setProperty("http.keepAlive", "false");
            this.f2866c = BdStatisticsManager.getInstance().getClientLogId();
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            c cVar = this.f2865b;
            if (cVar != null) {
                return cVar.l();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public g k(String str, List<BasicNameValuePair> list, boolean z, int i2, int i3, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{str, list, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), linkedList})) == null) {
            e eVar = new e();
            this.a = eVar;
            b(eVar, z);
            this.a.b().s(str);
            if (list != null) {
                for (BasicNameValuePair basicNameValuePair : list) {
                    this.a.b().d(basicNameValuePair);
                }
            }
            if (linkedList != null) {
                Iterator<BasicNameValuePair> it = linkedList.iterator();
                while (it.hasNext()) {
                    BasicNameValuePair next = it.next();
                    this.a.b().a(next.getName(), next.getValue());
                }
            }
            c cVar = new c(this.a);
            this.f2865b = cVar;
            cVar.n(i2, i3, -1);
            return this.a.c();
        }
        return (g) invokeCommon.objValue;
    }

    public g l(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i2, int i3, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{str, Boolean.valueOf(z), arrayList, hashMap, Integer.valueOf(i2), Integer.valueOf(i3), linkedList})) == null) {
            e eVar = new e();
            this.a = eVar;
            b(eVar, z);
            this.a.b().s(str);
            if (linkedList != null) {
                Iterator<BasicNameValuePair> it = linkedList.iterator();
                while (it.hasNext()) {
                    BasicNameValuePair next = it.next();
                    this.a.b().a(next.getName(), next.getValue());
                }
            }
            if (arrayList != null) {
                Iterator<BasicNameValuePair> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    BasicNameValuePair next2 = it2.next();
                    this.a.b().b(next2.getName(), next2.getValue());
                }
            }
            if (hashMap != null) {
                for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                    this.a.b().c(entry.getKey(), entry.getValue());
                }
            }
            c cVar = new c(this.a);
            this.f2865b = cVar;
            cVar.n(i2, i3, -1);
            return this.a.c();
        }
        return (g) invokeCommon.objValue;
    }

    public void m() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (cVar = this.f2865b) == null) {
            return;
        }
        cVar.q();
    }
}
