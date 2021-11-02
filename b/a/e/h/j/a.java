package b.a.e.h.j;

import android.text.TextUtils;
import b.a.e.e.p.f;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static a f2280d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f2281a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<b> f2282b;

    /* renamed from: c  reason: collision with root package name */
    public C0039a f2283c;

    /* renamed from: b.a.e.h.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0039a extends BdAsyncTask<String, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b f2284a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f2285b;

        public C0039a(a aVar, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2285b = aVar;
            this.f2284a = bVar;
        }

        public final boolean b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                try {
                    f.p(new File(str));
                    b.a.e.h.h.a.b().o("plugin_del_unuse", "delete_unuse", str, null);
                } catch (Throwable th) {
                    b.a.e.h.h.a.b().o("plugin_del_unuse", "delete_unuse_fail", str, th.getMessage());
                }
                int length = str.length();
                if (length < 4) {
                    return false;
                }
                File file = new File(str.substring(0, length - 4));
                if (file.exists() && file.isDirectory()) {
                    try {
                        f.p(file);
                        b.a.e.h.h.a.b().o("plugin_del_unuse", "delete_unuse", str, null);
                        return true;
                    } catch (Throwable th2) {
                        b.a.e.h.h.a.b().o("plugin_del_unuse", "delete_unuse_fail", str, th2.getMessage());
                        return true;
                    }
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                b bVar = this.f2284a;
                if (bVar != null) {
                    return Boolean.valueOf(b(bVar.f2286a));
                }
                return Boolean.FALSE;
            }
            return (Boolean) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bool) == null) {
                super.onPostExecute((C0039a) bool);
                this.f2285b.f2283c = null;
                if (this.f2285b.f2282b.size() > 0) {
                    Iterator it = this.f2285b.f2282b.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b bVar = (b) it.next();
                        if (this.f2285b.g(this.f2284a, bVar)) {
                            this.f2285b.f2282b.remove(bVar);
                            break;
                        }
                    }
                }
                if (bool != null && bool.booleanValue() && this.f2285b.f2281a != null) {
                    c cVar = this.f2285b.f2281a;
                    b bVar2 = this.f2284a;
                    cVar.a(bVar2.f2287b, bVar2.f2286a);
                }
                this.f2285b.i();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f2286a;

        /* renamed from: b  reason: collision with root package name */
        public String f2287b;

        public b(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2287b = str;
            this.f2286a = str2;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, String str2);
    }

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
        this.f2282b = new ArrayList<>();
    }

    public static a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (f2280d == null) {
                synchronized (a.class) {
                    if (f2280d == null) {
                        f2280d = new a();
                    }
                }
            }
            return f2280d;
        }
        return (a) invokeV.objValue;
    }

    public void f(ArrayList<b> arrayList, c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, arrayList, cVar) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        this.f2281a = cVar;
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && !TextUtils.isEmpty(next.f2286a) && !TextUtils.isEmpty(next.f2287b)) {
                boolean z = false;
                Iterator<b> it2 = this.f2282b.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (g(it2.next(), next)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.f2282b.add(next);
                }
            }
        }
        i();
    }

    public final boolean g(b bVar, b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, bVar2)) == null) ? (bVar == null || bVar2 == null || TextUtils.isEmpty(bVar2.f2286a) || TextUtils.isEmpty(bVar2.f2287b) || TextUtils.isEmpty(bVar.f2286a) || TextUtils.isEmpty(bVar.f2287b) || !bVar2.f2287b.equals(bVar.f2287b) || !bVar2.f2286a.equals(bVar.f2286a)) ? false : true : invokeLL.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f2282b.size() != 0 && this.f2283c == null) {
            C0039a c0039a = new C0039a(this, this.f2282b.get(0));
            this.f2283c = c0039a;
            c0039a.execute(new String[0]);
        }
    }
}
