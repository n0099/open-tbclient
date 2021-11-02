package b.a.r0.t3;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c extends BdAsyncTask<String, String, Integer> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f23858a;

    /* renamed from: b  reason: collision with root package name */
    public a f23859b;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b();

        void c();

        void onError(String str);
    }

    public c(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23858a = "https://lookup.api.bsb.baidu.com/urlquery?url=" + URLEncoder.encode(str) + "&ver=2.0&key=Gar7ku5AswED&cid=" + TbadkCoreApplication.getInst().getCuid();
        this.f23859b = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Integer doInBackground(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
            try {
                NetWork netWork = new NetWork(this.f23858a);
                netWork.getNetContext().getRequest().mIsNeedAddCommenParam = false;
                netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                JSONArray optJSONArray = new JSONObject(new String(netWork.getNetData())).optJSONArray("result");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        if (optJSONObject != null) {
                            return Integer.valueOf(optJSONObject.optInt(FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT, -1));
                        }
                    }
                    return -1;
                }
                return -1;
            } catch (Exception e2) {
                e2.printStackTrace();
                return -1;
            }
        }
        return (Integer) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Integer num) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, num) == null) || this.f23859b == null || num == null) {
            return;
        }
        if (num.intValue() == -1) {
            this.f23859b.onError(null);
        } else if (num.intValue() == 1) {
            this.f23859b.c();
        } else if (num.intValue() != 2 && num.intValue() != 0) {
            this.f23859b.a();
        } else {
            this.f23859b.b();
        }
    }
}
