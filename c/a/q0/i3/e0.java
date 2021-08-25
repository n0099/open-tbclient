package c.a.q0.i3;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes3.dex */
public class e0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class b extends BdAsyncTask<String, Integer, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Integer doInBackground(String... strArr) {
            InterceptResult invokeL;
            Throwable th;
            HttpURLConnection httpURLConnection;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                if (strArr == null || strArr.length == 0) {
                    return null;
                }
                try {
                    httpURLConnection = (HttpURLConnection) new URL(strArr[0]).openConnection();
                    try {
                        try {
                            httpURLConnection.setRequestMethod("GET");
                            httpURLConnection.setConnectTimeout(3000);
                            httpURLConnection.setReadTimeout(3000);
                            httpURLConnection.connect();
                            httpURLConnection.getResponseCode();
                        } catch (Exception e2) {
                            e = e2;
                            BdLog.e(e);
                            c.a.e.e.m.a.e(httpURLConnection);
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        c.a.e.e.m.a.e(httpURLConnection);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    httpURLConnection = null;
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = null;
                    c.a.e.e.m.a.e(httpURLConnection);
                    throw th;
                }
                c.a.e.e.m.a.e(httpURLConnection);
                return null;
            }
            return (Integer) invokeL.objValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        new b(null).execute(str + "&TIME=" + System.currentTimeMillis());
    }
}
