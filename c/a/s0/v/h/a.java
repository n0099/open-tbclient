package c.a.s0.v.h;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.j3.z;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.JsonTransHelper;
import com.baidu.tieba.ad.download.mvp.IDownloadModel;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.recapp.constants.Cmatch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.App;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.s0.j3.f0.n.a a;

    /* renamed from: b  reason: collision with root package name */
    public final int f24698b;

    /* renamed from: c  reason: collision with root package name */
    public final int f24699c;

    /* renamed from: d  reason: collision with root package name */
    public final int f24700d;

    /* renamed from: e  reason: collision with root package name */
    public final List<String> f24701e;

    /* renamed from: f  reason: collision with root package name */
    public final List<c.a.s0.j3.f0.n.b> f24702f;

    /* renamed from: c.a.s0.v.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C1444a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<Integer, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                if (numArr == null || numArr.length <= 1 || numArr[0] == null || numArr[1] == null) {
                    return null;
                }
                this.a.a.c(numArr[0], numArr[1]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ b(a aVar, C1444a c1444a) {
            this(aVar);
        }
    }

    /* loaded from: classes8.dex */
    public class c extends BdAsyncTask<String, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        public /* synthetic */ c(a aVar, C1444a c1444a) {
            this(aVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                if (strArr == null || strArr.length <= 0 || strArr[0] == null) {
                    return null;
                }
                this.a.a.d(strArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d extends BdAsyncTask<Integer, Integer, List<c.a.s0.j3.f0.n.b>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<c.a.s0.j3.f0.n.b> doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                if (numArr == null || numArr.length <= 1 || numArr[0] == null || numArr[1] == null) {
                    return null;
                }
                return this.a.a.f(numArr[0], numArr[1]);
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<c.a.s0.j3.f0.n.b> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                super.onPostExecute(list);
                if (c.a.s0.x1.o.k.a.e(list)) {
                    return;
                }
                this.a.f24702f.addAll(list);
            }
        }

        public /* synthetic */ d(a aVar, C1444a c1444a) {
            this(aVar);
        }
    }

    /* loaded from: classes8.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(763313445, "Lc/a/s0/v/h/a$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(763313445, "Lc/a/s0/v/h/a$e;");
                    return;
                }
            }
            a = new a(null);
        }
    }

    /* loaded from: classes8.dex */
    public class f extends BdAsyncTask<c.a.s0.j3.f0.n.b, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(c.a.s0.j3.f0.n.b... bVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVarArr)) == null) {
                if (bVarArr == null || bVarArr.length <= 0 || bVarArr[0] == null) {
                    return null;
                }
                this.a.a.g(bVarArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ f(a aVar, C1444a c1444a) {
            this(aVar);
        }
    }

    public /* synthetic */ a(C1444a c1444a) {
        this();
    }

    public static String g(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, advertAppInfo)) == null) {
            if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.l4) == null) {
                return null;
            }
            return iLegoAdvert.getDownloadKey();
        }
        return (String) invokeL.objValue;
    }

    public static a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? e.a : (a) invokeV.objValue;
    }

    public final c.a.s0.j3.f0.n.b c(IDownloadModel iDownloadModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iDownloadModel)) == null) {
            c.a.s0.j3.f0.n.b bVar = new c.a.s0.j3.f0.n.b();
            bVar.f18324f = iDownloadModel.getAppJson();
            bVar.f18320b = iDownloadModel.getPkgName();
            bVar.a = iDownloadModel.getDownloadKey();
            bVar.f18322d = 0;
            bVar.f18323e = System.currentTimeMillis();
            bVar.f18321c = System.currentTimeMillis();
            return bVar;
        }
        return (c.a.s0.j3.f0.n.b) invokeL.objValue;
    }

    public final boolean d(@NonNull Cmatch cmatch) {
        InterceptResult invokeL;
        c.a.s0.j3.f0.n.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cmatch)) == null) {
            if (!this.f24701e.contains(cmatch.value) || c.a.s0.x1.o.k.a.e(this.f24702f) || (bVar = (c.a.s0.j3.f0.n.b) c.a.s0.x1.o.k.a.d(this.f24702f, 0)) == null) {
                return false;
            }
            return this.f24699c <= ((int) ((System.currentTimeMillis() - bVar.f18323e) / 60000));
        }
        return invokeL.booleanValue;
    }

    public final void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            new c(this, null).execute(str);
        }
    }

    public final void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            Iterator<c.a.s0.j3.f0.n.b> it = this.f24702f.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().a, str)) {
                    it.remove();
                }
            }
            e(str);
        }
    }

    public final App h(@NonNull App app, @NonNull Cmatch cmatch) {
        InterceptResult invokeLL;
        c.a.s0.j3.f0.n.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, app, cmatch)) == null) {
            if (c.a.s0.x1.o.k.a.e(this.f24702f)) {
                return null;
            }
            Iterator<c.a.s0.j3.f0.n.b> it = this.f24702f.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bVar = null;
                    break;
                }
                bVar = it.next();
                if (!z.r(bVar.f18320b)) {
                    break;
                }
                bVar.f18326h = 2;
                o(bVar);
                it.remove();
            }
            if (bVar == null) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(bVar.f18324f);
                jSONObject.put("pos_name", app.pos_name);
                App parseAppFromJson = JsonTransHelper.parseAppFromJson(jSONObject);
                if (j(cmatch, parseAppFromJson)) {
                    return parseAppFromJson;
                }
                return null;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (App) invokeLL.objValue;
    }

    public final boolean j(Cmatch cmatch, App app) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, cmatch, app)) == null) {
            if (cmatch == Cmatch.PB_BANNER && c.a.s0.j3.a.i(app) == 14 && !c.a.s0.j3.a.q(app)) {
                return false;
            }
            if (cmatch == Cmatch.VIDEO_PB_COMMENT) {
                return (c.a.s0.j3.a.i(app) == 14 || c.a.s0.j3.a.i(app) == 7) ? false : true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        for (c.a.s0.j3.f0.n.b bVar : this.f24702f) {
            if (bVar != null && TextUtils.equals(bVar.a, str)) {
                p(bVar);
            }
        }
    }

    public void l(DownloadStatus downloadStatus, IDownloadModel iDownloadModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, downloadStatus, iDownloadModel) == null) || TextUtils.isEmpty(iDownloadModel.getDownloadKey()) || TextUtils.isEmpty(iDownloadModel.getPkgName())) {
            return;
        }
        c.a.s0.j3.f0.n.b c2 = c(iDownloadModel);
        if (downloadStatus == DownloadStatus.STATUS_INSTALL_SUCCESS) {
            c2.f18326h = 2;
            this.f24702f.remove(c2);
        } else {
            c2.f18326h = 1;
            if (!this.f24702f.contains(c2)) {
                this.f24702f.add(0, c2);
            }
        }
        o(c2);
    }

    public final void m(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            try {
                new d(this, null).execute(Integer.valueOf(i2), Integer.valueOf(i3));
            } catch (Exception unused) {
            }
        }
    }

    public App n(App app, Cmatch cmatch) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, app, cmatch)) == null) {
            if (d(cmatch) && app != null && c.a.s0.j3.a.o(app)) {
                return h(app, cmatch);
            }
            return null;
        }
        return (App) invokeLL.objValue;
    }

    public final void o(c.a.s0.j3.f0.n.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            new f(this, null).execute(bVar);
        }
    }

    public final void p(@NonNull c.a.s0.j3.f0.n.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            int i2 = bVar.f18322d + 1;
            bVar.f18322d = i2;
            if (i2 >= this.f24698b) {
                f(bVar.a);
                return;
            }
            bVar.f18323e = System.currentTimeMillis();
            o(bVar);
        }
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
        this.a = c.a.s0.j3.f0.n.a.e();
        this.f24698b = c.a.s0.a.h().f();
        this.f24699c = c.a.s0.a.h().e();
        this.f24700d = c.a.s0.a.h().d();
        String g2 = c.a.s0.a.h().g();
        if (TextUtils.isEmpty(g2)) {
            this.f24701e = new ArrayList();
        } else {
            this.f24701e = Arrays.asList(g2.split("_"));
        }
        this.f24702f = Collections.synchronizedList(new ArrayList());
        m(this.f24700d, this.f24698b);
        new b(this, null).execute(Integer.valueOf(this.f24700d), Integer.valueOf(this.f24698b));
    }
}
