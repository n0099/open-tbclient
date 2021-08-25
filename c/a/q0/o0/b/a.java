package c.a.q0.o0.b;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.s.y.r;
import c.a.p0.w.e;
import c.a.p0.w.f;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipException;
/* loaded from: classes3.dex */
public class a implements c.a.q0.o0.b.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final String f22854i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public VideoControllerLayout f22855a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.q0.f0.c.a f22856b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.q0.f0.a.a f22857c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, String> f22858d;

    /* renamed from: e  reason: collision with root package name */
    public List<DownloadData> f22859e;

    /* renamed from: f  reason: collision with root package name */
    public b f22860f;

    /* renamed from: g  reason: collision with root package name */
    public QmFilterItem f22861g;

    /* renamed from: h  reason: collision with root package name */
    public e f22862h;

    /* renamed from: c.a.q0.o0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1059a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f22863a;

        public C1059a(a aVar) {
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
            this.f22863a = aVar;
        }

        @Override // c.a.p0.w.e
        public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i2, str) == null) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                this.f22863a.o(downloadData);
                if (this.f22863a.f22860f == null || this.f22863a.f22861g == null || this.f22863a.f22861g.fileUrl == null || !this.f22863a.f22861g.fileUrl.equals(downloadData.getUrl())) {
                    return;
                }
                this.f22863a.f22860f.a(str);
            }
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x008a */
        @Override // c.a.p0.w.e
        public void onFileDownloadSucceed(DownloadData downloadData) {
            File file;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) || downloadData == null || StringUtils.isNull(downloadData.getPath()) || StringUtils.isNull(a.f22854i)) {
                return;
            }
            this.f22863a.o(downloadData);
            if (this.f22863a.f22860f == null || this.f22863a.f22861g == null || this.f22863a.f22861g.fileUrl == null || !this.f22863a.f22861g.fileUrl.equals(downloadData.getUrl()) || !downloadData.getPath().endsWith(".zip")) {
                return;
            }
            String substring = downloadData.getPath().substring(a.f22854i.length() + 1, downloadData.getPath().lastIndexOf("."));
            String str = a.f22854i + "/" + substring;
            try {
                try {
                    try {
                        r.c(new File(downloadData.getPath()), str);
                        this.f22863a.f22858d.put(substring, str);
                        this.f22863a.f22861g.localPath = str;
                        this.f22863a.f22860f.c(this.f22863a.f22861g);
                        String path = downloadData.getPath();
                        file = new File(path);
                        downloadData = path;
                    } catch (ZipException e2) {
                        this.f22863a.f22860f.a("解压失败，请点击重试");
                        FileHelper.deleteFileOrDir(new File(str));
                        BdLog.e(e2);
                        String path2 = downloadData.getPath();
                        file = new File(path2);
                        downloadData = path2;
                    }
                } catch (IOException e3) {
                    this.f22863a.f22860f.a("解压失败，请点击重试");
                    FileHelper.deleteFileOrDir(new File(str));
                    BdLog.e(e3);
                    String path3 = downloadData.getPath();
                    file = new File(path3);
                    downloadData = path3;
                }
                FileHelper.deleteFileOrDir(file);
            } catch (Throwable th) {
                FileHelper.deleteFileOrDir(new File(downloadData.getPath()));
                throw th;
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
                this.f22863a.o(downloadData);
                if (this.f22863a.f22860f == null || this.f22863a.f22861g == null || this.f22863a.f22861g.fileUrl == null || !this.f22863a.f22861g.fileUrl.equals(downloadData.getUrl())) {
                    return;
                }
                this.f22863a.f22860f.b();
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

        void c(QmFilterItem qmFilterItem);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(140121131, "Lc/a/q0/o0/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(140121131, "Lc/a/q0/o0/b/a;");
                return;
            }
        }
        f22854i = FileHelper.CreateFileIfNotFound(".filters") != null ? FileHelper.CreateFileIfNotFound(".filters").getAbsolutePath() : "";
    }

    public a(c.a.q0.f0.c.a aVar, c.a.q0.f0.a.a aVar2, VideoControllerLayout videoControllerLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, aVar2, videoControllerLayout};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f22861g = new QmFilterItem();
        this.f22862h = new C1059a(this);
        this.f22856b = aVar;
        this.f22857c = aVar2;
        this.f22855a = videoControllerLayout;
        m();
    }

    @Override // c.a.q0.o0.b.b
    public boolean a(QmFilterItem qmFilterItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qmFilterItem)) == null) {
            p(qmFilterItem);
            if (qmFilterItem == null) {
                reset();
                return true;
            } else if (!StringUtils.isNull(qmFilterItem.localPath)) {
                c.a.q0.f0.c.a aVar = this.f22856b;
                if (aVar != null) {
                    aVar.a(qmFilterItem);
                    return true;
                }
                c.a.q0.f0.a.a aVar2 = this.f22857c;
                if (aVar2 != null) {
                    aVar2.a(qmFilterItem);
                }
                return true;
            } else {
                reset();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.q0.o0.b.b
    public QmFilterItem b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22861g : (QmFilterItem) invokeV.objValue;
    }

    @Override // c.a.q0.o0.b.b
    public void c(QmFilterItem qmFilterItem) {
        QmFilterItem qmFilterItem2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qmFilterItem) == null) {
            p(qmFilterItem);
            if (qmFilterItem == null) {
                return;
            }
            if (!TextUtils.isEmpty(qmFilterItem.fileUrl) && !StringUtils.isNull(f22854i)) {
                String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(qmFilterItem.fileUrl);
                if (nameMd5FromUrl == null) {
                    return;
                }
                File file = new File(f22854i);
                if (!file.exists()) {
                    file.mkdirs();
                }
                StringBuilder sb = new StringBuilder();
                sb.append(".");
                String str2 = qmFilterItem.fileUrl;
                sb.append(str2.substring(str2.lastIndexOf(".") + 1));
                String sb2 = sb.toString();
                if (this.f22859e == null) {
                    this.f22859e = new ArrayList();
                }
                if (n(qmFilterItem.fileUrl)) {
                    return;
                }
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(qmFilterItem.fileUrl);
                downloadData.setPath(f22854i + "/" + nameMd5FromUrl + sb2);
                downloadData.setCallback(this.f22862h);
                this.f22859e.add(downloadData);
                f.k().l(downloadData);
                return;
            }
            a(null);
            if (this.f22860f == null || (qmFilterItem2 = this.f22861g) == null || (str = qmFilterItem2.fileUrl) == null || !str.equals(qmFilterItem.fileUrl)) {
                return;
            }
            this.f22860f.b();
        }
    }

    @Override // c.a.q0.o0.b.b
    public void d(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f22860f = bVar;
        }
    }

    @Override // c.a.q0.o0.b.b
    public void e() {
        VideoControllerLayout videoControllerLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (videoControllerLayout = this.f22855a) == null) {
            return;
        }
        videoControllerLayout.setSelectedToRightIndex();
    }

    @Override // c.a.q0.o0.b.b
    public String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
            if (nameMd5FromUrl == null) {
                return null;
            }
            if (this.f22858d == null) {
                this.f22858d = new HashMap<>();
                h();
            }
            return this.f22858d.get(nameMd5FromUrl);
        }
        return (String) invokeL.objValue;
    }

    @Override // c.a.q0.o0.b.b
    public void g() {
        VideoControllerLayout videoControllerLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (videoControllerLayout = this.f22855a) == null) {
            return;
        }
        videoControllerLayout.setSelectedToLeftIndex();
    }

    @Override // c.a.q0.o0.b.b
    public void h() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || StringUtils.isNull(f22854i)) {
            return;
        }
        HashMap<String, String> hashMap = this.f22858d;
        if (hashMap == null) {
            this.f22858d = new HashMap<>();
        } else {
            hashMap.clear();
        }
        File file = new File(f22854i);
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    this.f22858d.put(file2.getName(), file2.getAbsolutePath());
                }
            }
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (!ListUtils.isEmpty(this.f22859e) && str != null) {
                for (DownloadData downloadData : this.f22859e) {
                    if (downloadData != null && str.equals(downloadData.getUrl())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void o(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, downloadData) == null) || ListUtils.isEmpty(this.f22859e) || downloadData == null) {
            return;
        }
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 < this.f22859e.size()) {
                if (this.f22859e.get(i3) != null && this.f22859e.get(i3).getUrl() != null && this.f22859e.get(i3).getUrl().equals(downloadData.getUrl())) {
                    i2 = i3;
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        this.f22859e.remove(i2);
    }

    public void p(QmFilterItem qmFilterItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, qmFilterItem) == null) {
            if (qmFilterItem == null) {
                this.f22861g = new QmFilterItem();
            } else {
                this.f22861g = qmFilterItem;
            }
        }
    }

    @Override // c.a.q0.o0.b.b
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            c.a.q0.f0.c.a aVar = this.f22856b;
            if (aVar != null) {
                aVar.a(null);
            }
            c.a.q0.f0.a.a aVar2 = this.f22857c;
            if (aVar2 != null) {
                aVar2.a(null);
            }
        }
    }
}
