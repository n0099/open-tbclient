package b.a.r0.r.e;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.r0.a3.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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

    public void a(int i2, @Nullable String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) {
            boolean p = z.p(i2);
            boolean z = i2 == 1000;
            b.a.r0.a3.l0.c cVar = new b.a.r0.a3.l0.c();
            if (p) {
                cVar.c(z ? "APP" : "URL");
                if (!z) {
                    cVar.l(i2);
                }
            } else {
                cVar.c("DOWNLOAD_BUTTON");
            }
            cVar.i(p ? SDKLogTypeConstants.CLOSE_GAME_TYPE : 2);
            cVar.h(p ? "DEEPLINK" : "DOWNLOAD_PAGE");
            if (!TextUtils.isEmpty(str)) {
                DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
                downloadStaticsData.setApk_name(str);
                cVar.t(downloadStaticsData);
            }
            if (!TextUtils.isEmpty(str2)) {
                cVar.v(str2);
            }
            b.a.r0.a3.l0.e.b().d(cVar);
        }
    }

    public void b(int i2, @Nullable String str, String str2, @NonNull AdDownloadData adDownloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, str2, adDownloadData}) == null) {
            c(adDownloadData.getPage(), i2, str, str2, adDownloadData.getDownloadUrl(), TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(adDownloadData.adId(), 0L));
        }
    }

    public void c(String str, int i2, @Nullable String str2, String str3, String str4, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Integer.valueOf(i2), str2, str3, str4, Long.valueOf(j)}) == null) {
            b.a.r0.a3.l0.c cVar = new b.a.r0.a3.l0.c();
            cVar.i(i2);
            if (TextUtils.isEmpty(str)) {
                str = "DOWNLOAD_PAGE";
            }
            cVar.h(str);
            cVar.c("DOWNLOAD_BUTTON");
            if (!TextUtils.isEmpty(str2)) {
                DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
                downloadStaticsData.setApk_name(str2);
                cVar.t(downloadStaticsData);
            }
            if (!TextUtils.isEmpty(str3)) {
                cVar.v(str3);
            }
            cVar.k(str2);
            cVar.q(str4);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ad_download_content_length", j);
                cVar.s(jSONObject.toString());
            } catch (JSONException unused) {
            }
            b.a.r0.a3.l0.e.b().d(cVar);
        }
    }
}
