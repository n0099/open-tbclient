package c.a.q0.w3.l;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final String f28501f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, String> f28502a;

    /* renamed from: b  reason: collision with root package name */
    public List<DownloadData> f28503b;

    /* renamed from: c  reason: collision with root package name */
    public b f28504c;

    /* renamed from: d  reason: collision with root package name */
    public String f28505d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.w.e f28506e;

    /* loaded from: classes4.dex */
    public class a implements c.a.p0.w.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f28507a;

        public a(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28507a = lVar;
        }

        @Override // c.a.p0.w.e
        public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i2, str) == null) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                this.f28507a.i(downloadData);
                if (this.f28507a.f28504c == null || !this.f28507a.f28505d.equals(downloadData.getUrl())) {
                    return;
                }
                this.f28507a.f28504c.a(str);
            }
        }

        @Override // c.a.p0.w.e
        public void onFileDownloadSucceed(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) || downloadData == null || StringUtils.isNull(downloadData.getPath()) || StringUtils.isNull(l.f28501f)) {
                return;
            }
            this.f28507a.i(downloadData);
            if (this.f28507a.f28504c == null || !this.f28507a.f28505d.equals(downloadData.getUrl())) {
                return;
            }
            this.f28507a.f28502a.put(downloadData.getPath().substring(l.f28501f.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
            this.f28507a.f28504c.c(this.f28507a.f28505d, downloadData.getPath());
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
                this.f28507a.i(downloadData);
                if (this.f28507a.f28504c == null || !this.f28507a.f28505d.equals(downloadData.getUrl())) {
                    return;
                }
                this.f28507a.f28504c.b();
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

    /* loaded from: classes4.dex */
    public interface b {
        void a(String str);

        void b();

        void c(String str, String str2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1263598309, "Lc/a/q0/w3/l/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1263598309, "Lc/a/q0/w3/l/l;");
                return;
            }
        }
        f28501f = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public l() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28506e = new a(this);
    }

    public void e() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || StringUtils.isNull(f28501f)) {
            return;
        }
        HashMap<String, String> hashMap = this.f28502a;
        if (hashMap == null) {
            this.f28502a = new HashMap<>();
        } else {
            hashMap.clear();
        }
        File file = new File(f28501f);
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    this.f28502a.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (!TextUtils.isEmpty(str) && !StringUtils.isNull(f28501f)) {
                String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
                if (nameMd5FromUrl == null) {
                    return;
                }
                File file = new File(f28501f);
                if (!file.exists()) {
                    file.mkdirs();
                }
                String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
                if (this.f28503b == null) {
                    this.f28503b = new ArrayList();
                }
                if (h(str)) {
                    return;
                }
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(str);
                downloadData.setPath(f28501f + "/" + nameMd5FromUrl + str2);
                downloadData.setCallback(this.f28506e);
                this.f28503b.add(downloadData);
                c.a.p0.w.f.k().l(downloadData);
                return;
            }
            b bVar = this.f28504c;
            if (bVar != null) {
                bVar.a("");
            }
        }
    }

    public String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
            if (nameMd5FromUrl == null) {
                return null;
            }
            if (this.f28502a == null) {
                this.f28502a = new HashMap<>();
                e();
            }
            return this.f28502a.get(nameMd5FromUrl);
        }
        return (String) invokeL.objValue;
    }

    public final boolean h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (!ListUtils.isEmpty(this.f28503b) && str != null) {
                for (DownloadData downloadData : this.f28503b) {
                    if (downloadData != null && str.equals(downloadData.getUrl())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void i(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, downloadData) == null) || ListUtils.isEmpty(this.f28503b) || downloadData == null) {
            return;
        }
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 < this.f28503b.size()) {
                if (this.f28503b.get(i3) != null && this.f28503b.get(i3).getUrl() != null && this.f28503b.get(i3).getUrl().equals(downloadData.getUrl())) {
                    i2 = i3;
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        this.f28503b.remove(i2);
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (str == null) {
                this.f28505d = "";
            } else {
                this.f28505d = str;
            }
        }
    }

    public void k(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f28504c = bVar;
        }
    }
}
