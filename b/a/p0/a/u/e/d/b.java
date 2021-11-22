package b.a.p0.a.u.e.d;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import b.a.p0.a.d2.e;
import b.a.p0.a.g1.f;
import b.a.p0.a.p.d.i0;
import b.a.p0.a.u.c.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.u.e.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* renamed from: b.a.p0.a.u.e.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0418b implements b.a.p0.a.u.e.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0418b(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements b.a.p0.a.u.e.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull b.a.p0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // b.a.p0.a.u.c.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "HostDownloadManager" : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "HostDownloadManagerApi" : (String) invokeV.objValue;
    }

    public b.a.p0.a.u.h.b query(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#query", false);
            if (e.a0() == null) {
                return new b.a.p0.a.u.h.b(1001);
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> s = s(str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) s.first;
            if (bVar.isSuccess() && (obj = s.second) != null) {
                JSONObject jSONObject = (JSONObject) obj;
                String optString = jSONObject.optString("taskID");
                if (TextUtils.isEmpty(optString)) {
                    return new b.a.p0.a.u.h.b(202, "taskId is empty");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new b.a.p0.a.u.h.b(202, "cb is empty");
                }
                i0 z = b.a.p0.a.c1.a.z();
                if (z != null) {
                    z.b(optString, new C0418b(this, optString2));
                }
                return b.a.p0.a.u.h.b.f();
            }
            b.a.p0.a.e0.d.c("HostDownloadManagerApi", "parse fail");
            return bVar;
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b x(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            e a0 = e.a0();
            if (a0 == null) {
                return new b.a.p0.a.u.h.b(1001);
            }
            if (a0.x() == null) {
                return new b.a.p0.a.u.h.b(1001);
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> s = s(str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) s.first;
            if (bVar.isSuccess() && (obj = s.second) != null) {
                JSONObject jSONObject = (JSONObject) obj;
                String optString = jSONObject.optString("url");
                if (TextUtils.isEmpty(optString)) {
                    return new b.a.p0.a.u.h.b(202, "url is empty");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new b.a.p0.a.u.h.b(202, "cb is empty");
                }
                String optString3 = jSONObject.optString("name");
                JSONObject optJSONObject = jSONObject.optJSONObject("header");
                i0 z = b.a.p0.a.c1.a.z();
                if (z != null) {
                    z.d(optString, optString3, optJSONObject, new a(this, optString2));
                }
                return b.a.p0.a.u.h.b.f();
            }
            b.a.p0.a.e0.d.c("HostDownloadManagerApi", "parse fail");
            return bVar;
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            q("#openDownloadCenter", false);
            if (e.a0() == null) {
                return new b.a.p0.a.u.h.b(1001);
            }
            i0 z = b.a.p0.a.c1.a.z();
            if (z != null) {
                z.a();
            }
            return b.a.p0.a.u.h.b.f();
        }
        return (b.a.p0.a.u.h.b) invokeV.objValue;
    }

    public b.a.p0.a.u.h.b z(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#openFile", false);
            if (e.a0() == null) {
                return new b.a.p0.a.u.h.b(1001);
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> s = s(str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) s.first;
            if (bVar.isSuccess() && (obj = s.second) != null) {
                JSONObject jSONObject = (JSONObject) obj;
                String optString = jSONObject.optString("taskID");
                if (TextUtils.isEmpty(optString)) {
                    return new b.a.p0.a.u.h.b(202, "taskId is empty");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new b.a.p0.a.u.h.b(202, "cb is empty");
                }
                SwanAppActivity activity = f.U().getActivity();
                if (activity == null) {
                    return new b.a.p0.a.u.h.b(1001);
                }
                i0 z = b.a.p0.a.c1.a.z();
                if (z != null) {
                    z.c(activity, optString, new c(this, optString2));
                }
                return b.a.p0.a.u.h.b.f();
            }
            b.a.p0.a.e0.d.c("HostDownloadManagerApi", "parse fail");
            return bVar;
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }
}
