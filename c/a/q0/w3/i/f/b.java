package c.a.q0.w3.i.f;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.w.e;
import c.a.p0.w.f;
import c.a.q0.w3.c;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f28304c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, String> f28305a;

    /* renamed from: b  reason: collision with root package name */
    public DownloadData f28306b;

    /* loaded from: classes4.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1316b f28307a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f28308b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f28309c;

        public a(b bVar, InterfaceC1316b interfaceC1316b, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, interfaceC1316b, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28309c = bVar;
            this.f28307a = interfaceC1316b;
            this.f28308b = str;
        }

        @Override // c.a.p0.w.e
        public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i2, str) == null) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                if (this.f28309c.f28306b != null && downloadData.getUrl().equals(this.f28309c.f28306b.getUrl())) {
                    this.f28309c.f28306b = null;
                }
                InterfaceC1316b interfaceC1316b = this.f28307a;
                if (interfaceC1316b != null) {
                    interfaceC1316b.a(str);
                }
            }
        }

        @Override // c.a.p0.w.e
        public void onFileDownloadSucceed(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) || downloadData == null || StringUtils.isNull(downloadData.getPath())) {
                return;
            }
            if (this.f28309c.f28306b != null && downloadData.getUrl().equals(this.f28309c.f28306b.getUrl())) {
                this.f28309c.f28306b = null;
            }
            if (this.f28307a != null) {
                this.f28309c.f28305a.put(downloadData.getPath().substring(c.f28200h.length(), downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                this.f28307a.c(this.f28308b, downloadData.getPath());
            }
        }

        @Override // c.a.p0.w.e
        public boolean onFileDownloaded(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // c.a.p0.w.e
        public void onFileUpdateProgress(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) && downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                if (this.f28309c.f28306b != null && downloadData.getUrl().equals(this.f28309c.f28306b.getUrl())) {
                    this.f28309c.f28306b = null;
                }
                InterfaceC1316b interfaceC1316b = this.f28307a;
                if (interfaceC1316b != null) {
                    interfaceC1316b.b();
                }
            }
        }

        @Override // c.a.p0.w.e
        public boolean onPreDownload(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* renamed from: c.a.q0.w3.i.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1316b {
        void a(String str);

        void b();

        void c(String str, String str2);
    }

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

    public static b g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f28304c == null) {
                synchronized (b.class) {
                    if (f28304c == null) {
                        f28304c = new b();
                    }
                }
            }
            return f28304c;
        }
        return (b) invokeV.objValue;
    }

    public void d() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            HashMap<String, String> hashMap = this.f28305a;
            if (hashMap == null) {
                this.f28305a = new HashMap<>();
            } else {
                hashMap.clear();
            }
            File file = new File(c.f28200h);
            if (file.exists()) {
                for (File file2 : file.listFiles()) {
                    if (file2.isFile()) {
                        this.f28305a.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void e(String str, String str2, InterfaceC1316b interfaceC1316b) {
        String nameMd5FromUrl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, interfaceC1316b) == null) || TextUtils.isEmpty(str2) || (nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str2)) == null) {
            return;
        }
        if (this.f28306b != null) {
            f.k().h(this.f28306b.getUrl(), true);
        }
        File file = new File(c.f28200h);
        if (!file.exists()) {
            file.mkdirs();
        }
        DownloadData downloadData = new DownloadData();
        downloadData.setType(18);
        downloadData.setId(str);
        downloadData.setUrl(str2);
        downloadData.setPath(c.f28200h + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
        downloadData.setCallback(new a(this, interfaceC1316b, str2));
        this.f28306b = downloadData;
        f.k().l(downloadData);
    }

    public String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
            if (nameMd5FromUrl == null) {
                return null;
            }
            HashMap<String, String> hashMap = this.f28305a;
            if (hashMap == null) {
                this.f28305a = new HashMap<>();
                d();
                if (this.f28305a.size() > 0) {
                    return this.f28305a.get(nameMd5FromUrl);
                }
                return null;
            }
            return hashMap.get(nameMd5FromUrl);
        }
        return (String) invokeL.objValue;
    }
}
