package c.a.p0.x2.b0;

import android.net.Uri;
import android.text.TextUtils;
import c.a.e.a.e;
import c.a.o0.c.f;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends c.a.o0.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f28331a;

    /* renamed from: c.a.p0.x2.b0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1326a extends BdAsyncTask<Object, Integer, f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f28332a;

        /* renamed from: b  reason: collision with root package name */
        public String f28333b;

        /* renamed from: c  reason: collision with root package name */
        public String f28334c;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f28335d;

        /* renamed from: e  reason: collision with root package name */
        public e f28336e;

        public C1326a(a aVar, String str, String str2, HashMap<String, String> hashMap, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, str2, hashMap, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28332a = null;
            this.f28333b = str;
            this.f28334c = str2;
            this.f28335d = hashMap;
            this.f28336e = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public f doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                f fVar = new f();
                try {
                    this.f28332a = new NetWork(this.f28334c);
                    Set<String> keySet = this.f28335d.keySet();
                    if (keySet.size() > 0) {
                        for (String str : keySet) {
                            if (!"url".equalsIgnoreCase(str)) {
                                this.f28332a.addPostData(str, this.f28335d.get(str));
                            }
                        }
                    }
                    this.f28332a.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                    this.f28332a.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                    this.f28332a.getNetContext().getRequest().mIsNeedTbs = true;
                    String postNetData = this.f28332a.postNetData();
                    if (!this.f28332a.getNetContext().getResponse().isNetSuccess()) {
                        fVar.f12681b = this.f28332a.getNetErrorCode();
                        fVar.f12682c = this.f28332a.getNetString();
                    } else {
                        fVar.f12681b = this.f28332a.getServerErrorCode();
                        fVar.f12682c = this.f28332a.getErrorString();
                    }
                    if (this.f28332a.getNetContext().getResponse().isRequestSuccess() && !TextUtils.isEmpty(postNetData)) {
                        JSONObject jSONObject = new JSONObject(postNetData);
                        if (jSONObject.has("code")) {
                            if (jSONObject.optInt("code", -1) == 0) {
                                fVar.f12680a = true;
                                return fVar;
                            }
                            String optString = jSONObject.has("msg") ? jSONObject.optString("msg", "") : "";
                            fVar.f12680a = false;
                            fVar.f12682c = optString;
                            return fVar;
                        }
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                fVar.f12680a = false;
                return fVar;
            }
            return (f) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(f fVar) {
            e eVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) || (eVar = this.f28336e) == null) {
                return;
            }
            eVar.c(fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.f28332a != null) {
                    this.f28332a.cancelNetConnect();
                    this.f28332a = null;
                }
                super.cancel(true);
                e eVar = this.f28336e;
                if (eVar != null) {
                    eVar.c(null);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                super.onCancelled();
                e eVar = this.f28336e;
                if (eVar != null) {
                    eVar.c(null);
                }
            }
        }
    }

    public a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28331a = str;
    }

    @Override // c.a.o0.c.a, c.a.o0.c.d
    public void a(Object obj, HashMap<String, String> hashMap, String str, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, obj, hashMap, str, eVar) == null) || hashMap == null || hashMap.isEmpty() || !hashMap.containsKey("url")) {
            return;
        }
        String str2 = hashMap.get("url");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        C1326a c1326a = new C1326a(this, str, str2, hashMap, eVar);
        c1326a.setPriority(2);
        c1326a.execute(new Object[0]);
    }

    @Override // c.a.o0.c.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Uri parse = Uri.parse(this.f28331a);
            if (parse != null) {
                return parse.getAuthority() + parse.getPath();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }
}
