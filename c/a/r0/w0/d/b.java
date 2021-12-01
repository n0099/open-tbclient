package c.a.r0.w0.d;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.z.r;
import c.a.q0.w.e;
import c.a.q0.w.f;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.external.sticker.data.QmStickerItem;
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
/* loaded from: classes7.dex */
public class b implements c.a.r0.w0.d.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final String f25028g;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.l0.c.a a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f25029b;

    /* renamed from: c  reason: collision with root package name */
    public List<DownloadData> f25030c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC1430b f25031d;

    /* renamed from: e  reason: collision with root package name */
    public QmStickerItem f25032e;

    /* renamed from: f  reason: collision with root package name */
    public e f25033f;

    /* loaded from: classes7.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.q0.w.e
        public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i2, str) == null) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                this.a.l(downloadData);
                if (this.a.f25031d == null || this.a.f25032e == null || this.a.f25032e.fileUrl == null || !this.a.f25032e.fileUrl.equals(downloadData.getUrl())) {
                    return;
                }
                this.a.f25031d.a(str);
            }
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x008a */
        @Override // c.a.q0.w.e
        public void onFileDownloadSucceed(DownloadData downloadData) {
            File file;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) || downloadData == null || StringUtils.isNull(downloadData.getPath()) || StringUtils.isNull(b.f25028g)) {
                return;
            }
            this.a.l(downloadData);
            if (this.a.f25031d == null || this.a.f25032e == null || this.a.f25032e.fileUrl == null || !this.a.f25032e.fileUrl.equals(downloadData.getUrl()) || !downloadData.getPath().endsWith(".zip")) {
                return;
            }
            String substring = downloadData.getPath().substring(b.f25028g.length() + 1, downloadData.getPath().lastIndexOf("."));
            String str = b.f25028g + "/" + substring;
            try {
                try {
                    try {
                        r.c(new File(downloadData.getPath()), str);
                        this.a.f25029b.put(substring, str);
                        this.a.f25032e.localPath = str;
                        this.a.f25031d.c(this.a.f25032e);
                        String path = downloadData.getPath();
                        file = new File(path);
                        downloadData = path;
                    } catch (ZipException e2) {
                        this.a.f25031d.a("解压失败，请点击重试");
                        FileHelper.deleteFileOrDir(new File(str));
                        BdLog.e(e2);
                        String path2 = downloadData.getPath();
                        file = new File(path2);
                        downloadData = path2;
                    }
                } catch (IOException e3) {
                    this.a.f25031d.a("解压失败，请点击重试");
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

        @Override // c.a.q0.w.e
        public boolean onFileDownloaded(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // c.a.q0.w.e
        public void onFileUpdateProgress(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) && downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                this.a.l(downloadData);
                if (this.a.f25031d == null || this.a.f25032e == null || this.a.f25032e.fileUrl == null || !this.a.f25032e.fileUrl.equals(downloadData.getUrl())) {
                    return;
                }
                this.a.f25031d.b();
            }
        }

        @Override // c.a.q0.w.e
        public boolean onPreDownload(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* renamed from: c.a.r0.w0.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1430b {
        void a(String str);

        void b();

        void c(QmStickerItem qmStickerItem);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1546237905, "Lc/a/r0/w0/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1546237905, "Lc/a/r0/w0/d/b;");
                return;
            }
        }
        f25028g = FileHelper.CreateFileIfNotFound(".stickers") != null ? FileHelper.CreateFileIfNotFound(".stickers").getAbsolutePath() : "";
    }

    public b(c.a.r0.l0.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f25032e = new QmStickerItem();
        this.f25033f = new a(this);
        this.a = aVar;
        j();
    }

    @Override // c.a.r0.w0.d.a
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
            if (nameMd5FromUrl == null) {
                return null;
            }
            if (this.f25029b == null) {
                this.f25029b = new HashMap<>();
                e();
            }
            return this.f25029b.get(nameMd5FromUrl);
        }
        return (String) invokeL.objValue;
    }

    @Override // c.a.r0.w0.d.a
    public boolean b(QmStickerItem qmStickerItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qmStickerItem)) == null) {
            m(qmStickerItem);
            if (qmStickerItem == null) {
                reset();
                return true;
            } else if (!StringUtils.isNull(qmStickerItem.localPath)) {
                c.a.r0.l0.c.a aVar = this.a;
                if (aVar != null) {
                    return aVar.b(qmStickerItem);
                }
                return true;
            } else {
                reset();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r0.w0.d.a
    public void c(InterfaceC1430b interfaceC1430b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC1430b) == null) {
            this.f25031d = interfaceC1430b;
        }
    }

    @Override // c.a.r0.w0.d.a
    public void d(QmStickerItem qmStickerItem) {
        QmStickerItem qmStickerItem2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, qmStickerItem) == null) {
            m(qmStickerItem);
            if (qmStickerItem == null) {
                return;
            }
            if (!TextUtils.isEmpty(qmStickerItem.fileUrl) && !StringUtils.isNull(f25028g)) {
                String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(qmStickerItem.fileUrl);
                if (nameMd5FromUrl == null) {
                    return;
                }
                File file = new File(f25028g);
                if (!file.exists()) {
                    file.mkdirs();
                }
                StringBuilder sb = new StringBuilder();
                sb.append(".");
                String str2 = qmStickerItem.fileUrl;
                sb.append(str2.substring(str2.lastIndexOf(".") + 1));
                String sb2 = sb.toString();
                if (this.f25030c == null) {
                    this.f25030c = new ArrayList();
                }
                if (k(qmStickerItem.fileUrl)) {
                    return;
                }
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(qmStickerItem.fileUrl);
                downloadData.setPath(f25028g + "/" + nameMd5FromUrl + sb2);
                downloadData.setCallback(this.f25033f);
                this.f25030c.add(downloadData);
                f.k().l(downloadData);
                return;
            }
            b(null);
            if (this.f25031d == null || (qmStickerItem2 = this.f25032e) == null || (str = qmStickerItem2.fileUrl) == null || !str.equals(qmStickerItem.fileUrl)) {
                return;
            }
            this.f25031d.b();
        }
    }

    @Override // c.a.r0.w0.d.a
    public void e() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || StringUtils.isNull(f25028g)) {
            return;
        }
        HashMap<String, String> hashMap = this.f25029b;
        if (hashMap == null) {
            this.f25029b = new HashMap<>();
        } else {
            hashMap.clear();
        }
        File file = new File(f25028g);
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    this.f25029b.put(file2.getName(), file2.getAbsolutePath());
                }
            }
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (!ListUtils.isEmpty(this.f25030c) && str != null) {
                for (DownloadData downloadData : this.f25030c) {
                    if (downloadData != null && str.equals(downloadData.getUrl())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void l(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, downloadData) == null) || ListUtils.isEmpty(this.f25030c) || downloadData == null) {
            return;
        }
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 < this.f25030c.size()) {
                if (this.f25030c.get(i3) != null && this.f25030c.get(i3).getUrl() != null && this.f25030c.get(i3).getUrl().equals(downloadData.getUrl())) {
                    i2 = i3;
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        this.f25030c.remove(i2);
    }

    public void m(QmStickerItem qmStickerItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qmStickerItem) == null) {
            if (qmStickerItem == null) {
                this.f25032e = new QmStickerItem();
            } else {
                this.f25032e = qmStickerItem;
            }
        }
    }

    @Override // c.a.r0.w0.d.a
    public void reset() {
        c.a.r0.l0.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (aVar = this.a) == null) {
            return;
        }
        aVar.b(null);
    }
}
