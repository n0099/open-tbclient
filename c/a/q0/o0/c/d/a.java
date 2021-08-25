package c.a.q0.o0.c.d;

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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f22880c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, String> f22881a;

    /* renamed from: b  reason: collision with root package name */
    public DownloadData f22882b;

    /* renamed from: c.a.q0.o0.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1061a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f22883a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f22884b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f22885c;

        public C1061a(a aVar, b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22885c = aVar;
            this.f22883a = bVar;
            this.f22884b = str;
        }

        @Override // c.a.p0.w.e
        public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i2, str) == null) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                if (this.f22885c.f22882b != null && downloadData.getUrl().equals(this.f22885c.f22882b.getUrl())) {
                    this.f22885c.f22882b = null;
                }
                b bVar = this.f22883a;
                if (bVar != null) {
                    bVar.a(str);
                }
            }
        }

        @Override // c.a.p0.w.e
        public void onFileDownloadSucceed(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) || downloadData == null || StringUtils.isNull(downloadData.getPath())) {
                return;
            }
            if (this.f22885c.f22882b != null && downloadData.getUrl().equals(this.f22885c.f22882b.getUrl())) {
                this.f22885c.f22882b = null;
            }
            if (this.f22883a != null) {
                this.f22885c.f22881a.put(downloadData.getPath().substring(c.f28193a.length(), downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                this.f22883a.c(this.f22884b, downloadData.getPath());
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
                if (this.f22885c.f22882b != null && downloadData.getUrl().equals(this.f22885c.f22882b.getUrl())) {
                    this.f22885c.f22882b = null;
                }
                b bVar = this.f22883a;
                if (bVar != null) {
                    bVar.b();
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

    /* loaded from: classes3.dex */
    public interface b {
        void a(String str);

        void b();

        void c(String str, String str2);
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
            }
        }
    }

    public static a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f22880c == null) {
                synchronized (a.class) {
                    if (f22880c == null) {
                        f22880c = new a();
                    }
                }
            }
            return f22880c;
        }
        return (a) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22882b == null) {
            return;
        }
        f.k().h(this.f22882b.getUrl(), true);
    }

    public void e() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            HashMap<String, String> hashMap = this.f22881a;
            if (hashMap == null) {
                this.f22881a = new HashMap<>();
            } else {
                hashMap.clear();
            }
            File file = new File(c.f28193a);
            if (file.exists()) {
                for (File file2 : file.listFiles()) {
                    if (file2.isFile()) {
                        this.f22881a.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void f(String str, String str2, b bVar) {
        String nameMd5FromUrl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, bVar) == null) || TextUtils.isEmpty(str2) || (nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str2)) == null) {
            return;
        }
        DownloadData downloadData = this.f22882b;
        if (downloadData != null) {
            if (str2.equals(downloadData.getUrl())) {
                return;
            }
            f.k().h(this.f22882b.getUrl(), true);
        }
        File file = new File(c.f28193a);
        if (!file.exists()) {
            file.mkdirs();
        }
        DownloadData downloadData2 = new DownloadData();
        downloadData2.setType(17);
        downloadData2.setId(str);
        downloadData2.setUrl(str2);
        downloadData2.setPath(c.f28193a + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
        downloadData2.setCallback(new C1061a(this, bVar, str2));
        this.f22882b = downloadData2;
        f.k().l(downloadData2);
    }

    public String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
            if (nameMd5FromUrl == null) {
                return null;
            }
            HashMap<String, String> hashMap = this.f22881a;
            if (hashMap == null) {
                this.f22881a = new HashMap<>();
                e();
                if (this.f22881a.size() > 0) {
                    return this.f22881a.get(nameMd5FromUrl);
                }
                return null;
            }
            return hashMap.get(nameMd5FromUrl);
        }
        return (String) invokeL.objValue;
    }
}
