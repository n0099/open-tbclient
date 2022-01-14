package c.a.s0.s.j0.p.d;

import c.a.d.f.p.m;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.tbadk.core.view.itemcard.download.ItemDownloadExtraData;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends BdAsyncTask<String, Integer, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r2v0, types: [int] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Integer doInBackground(String... strArr) {
            InterceptResult invokeL;
            HttpURLConnection httpURLConnection;
            DataOutputStream dataOutputStream;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                HttpURLConnection httpURLConnection2 = null;
                if (strArr != null) {
                    ?? length = strArr.length;
                    try {
                        if (length != 0) {
                            try {
                                httpURLConnection = (HttpURLConnection) new URL("https://appc.baidu.com/appsrv?action=appdistributionlog&native_api=1").openConnection();
                                try {
                                    httpURLConnection.setRequestMethod("POST");
                                    httpURLConnection.setDoOutput(true);
                                    httpURLConnection.setDoInput(true);
                                    httpURLConnection.setConnectTimeout(c.a.d.c.j.b.d().c().b());
                                    httpURLConnection.setReadTimeout(c.a.d.c.j.b.d().b().b());
                                    httpURLConnection.setRequestProperty("Content-Type", "application/json");
                                    httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                                    httpURLConnection.connect();
                                    try {
                                        dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                                        try {
                                            dataOutputStream.write(strArr[0].getBytes("UTF-8"));
                                            dataOutputStream.flush();
                                            c.a.d.f.m.a.d(dataOutputStream);
                                            httpURLConnection.getResponseCode();
                                        } catch (Throwable th) {
                                            th = th;
                                            c.a.d.f.m.a.d(dataOutputStream);
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        dataOutputStream = null;
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    c.a.d.f.m.a.e(httpURLConnection);
                                    return null;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                httpURLConnection = null;
                            } catch (Throwable th3) {
                                th = th3;
                                c.a.d.f.m.a.e(httpURLConnection2);
                                throw th;
                            }
                            c.a.d.f.m.a.e(httpURLConnection);
                            return null;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        httpURLConnection2 = length;
                    }
                }
                return null;
            }
            return (Integer) invokeL.objValue;
        }
    }

    public static void a(DownloadData downloadData, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65536, null, downloadData, i2) == null) && downloadData != null && (downloadData.getExtra() instanceof ItemDownloadExtraData) && ((ItemDownloadExtraData) downloadData.getExtra()).isShouzhuData()) {
            ItemDownloadExtraData itemDownloadExtraData = (ItemDownloadExtraData) downloadData.getExtra();
            if (m.isEmpty(itemDownloadExtraData.shouzhuSource)) {
                itemDownloadExtraData.shouzhuSource = c.f().g(itemDownloadExtraData.pkgName);
            }
            c(downloadData, i2);
            b(itemDownloadExtraData.pkgName, itemDownloadExtraData.appName, itemDownloadExtraData.shouzhuScene, itemDownloadExtraData.shouzhuCategory, itemDownloadExtraData.shouzhuSource, i2);
        }
    }

    public static void b(String str, String str2, int i2, int i3, String str3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), str3, Integer.valueOf(i4)}) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pkgname", str);
                jSONObject.put("appname", str2);
                jSONObject.put("host", 4);
                jSONObject.put("scene", i2);
                jSONObject.put("category", i3);
                jSONObject.put("event", i4);
                jSONObject.put("source", str3);
                new a().execute(jSONObject.toString());
            } catch (JSONException unused) {
            }
        }
    }

    public static void c(DownloadData downloadData, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, downloadData, i2) == null) {
            if (i2 != 100 && i2 != 200) {
                if (i2 != 300) {
                    if (i2 != 400) {
                        if (i2 != 500) {
                            if (i2 != 600) {
                                if (i2 == 700 || i2 == 800) {
                                    c.f().e(downloadData);
                                    return;
                                } else if (i2 != 900) {
                                    return;
                                } else {
                                    c.f().k(downloadData);
                                    return;
                                }
                            }
                        }
                    }
                    c.f().j(downloadData);
                    return;
                }
                c.f().d(downloadData);
                return;
            }
            c.f();
        }
    }
}
