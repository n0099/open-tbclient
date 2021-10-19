package c.a.r0.q0.d;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.y.r;
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
/* loaded from: classes3.dex */
public class b implements c.a.r0.q0.d.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final String f23667g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.r0.g0.c.a f23668a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f23669b;

    /* renamed from: c  reason: collision with root package name */
    public List<DownloadData> f23670c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC1104b f23671d;

    /* renamed from: e  reason: collision with root package name */
    public QmStickerItem f23672e;

    /* renamed from: f  reason: collision with root package name */
    public e f23673f;

    /* loaded from: classes3.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f23674a;

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
            this.f23674a = bVar;
        }

        @Override // c.a.q0.w.e
        public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i2, str) == null) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                this.f23674a.l(downloadData);
                if (this.f23674a.f23671d == null || this.f23674a.f23672e == null || this.f23674a.f23672e.fileUrl == null || !this.f23674a.f23672e.fileUrl.equals(downloadData.getUrl())) {
                    return;
                }
                this.f23674a.f23671d.a(str);
            }
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x008a */
        @Override // c.a.q0.w.e
        public void onFileDownloadSucceed(DownloadData downloadData) {
            File file;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) || downloadData == null || StringUtils.isNull(downloadData.getPath()) || StringUtils.isNull(b.f23667g)) {
                return;
            }
            this.f23674a.l(downloadData);
            if (this.f23674a.f23671d == null || this.f23674a.f23672e == null || this.f23674a.f23672e.fileUrl == null || !this.f23674a.f23672e.fileUrl.equals(downloadData.getUrl()) || !downloadData.getPath().endsWith(".zip")) {
                return;
            }
            String substring = downloadData.getPath().substring(b.f23667g.length() + 1, downloadData.getPath().lastIndexOf("."));
            String str = b.f23667g + "/" + substring;
            try {
                try {
                    try {
                        r.c(new File(downloadData.getPath()), str);
                        this.f23674a.f23669b.put(substring, str);
                        this.f23674a.f23672e.localPath = str;
                        this.f23674a.f23671d.c(this.f23674a.f23672e);
                        String path = downloadData.getPath();
                        file = new File(path);
                        downloadData = path;
                    } catch (ZipException e2) {
                        this.f23674a.f23671d.a("解压失败，请点击重试");
                        FileHelper.deleteFileOrDir(new File(str));
                        BdLog.e(e2);
                        String path2 = downloadData.getPath();
                        file = new File(path2);
                        downloadData = path2;
                    }
                } catch (IOException e3) {
                    this.f23674a.f23671d.a("解压失败，请点击重试");
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
                this.f23674a.l(downloadData);
                if (this.f23674a.f23671d == null || this.f23674a.f23672e == null || this.f23674a.f23672e.fileUrl == null || !this.f23674a.f23672e.fileUrl.equals(downloadData.getUrl())) {
                    return;
                }
                this.f23674a.f23671d.b();
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

    /* renamed from: c.a.r0.q0.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1104b {
        void a(String str);

        void b();

        void c(QmStickerItem qmStickerItem);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1718674601, "Lc/a/r0/q0/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1718674601, "Lc/a/r0/q0/d/b;");
                return;
            }
        }
        f23667g = FileHelper.CreateFileIfNotFound(".stickers") != null ? FileHelper.CreateFileIfNotFound(".stickers").getAbsolutePath() : "";
    }

    public b(c.a.r0.g0.c.a aVar) {
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
        this.f23672e = new QmStickerItem();
        this.f23673f = new a(this);
        this.f23668a = aVar;
        j();
    }

    @Override // c.a.r0.q0.d.a
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
            if (nameMd5FromUrl == null) {
                return null;
            }
            if (this.f23669b == null) {
                this.f23669b = new HashMap<>();
                e();
            }
            return this.f23669b.get(nameMd5FromUrl);
        }
        return (String) invokeL.objValue;
    }

    @Override // c.a.r0.q0.d.a
    public boolean b(QmStickerItem qmStickerItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qmStickerItem)) == null) {
            m(qmStickerItem);
            if (qmStickerItem == null) {
                reset();
                return true;
            } else if (!StringUtils.isNull(qmStickerItem.localPath)) {
                c.a.r0.g0.c.a aVar = this.f23668a;
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

    @Override // c.a.r0.q0.d.a
    public void c(InterfaceC1104b interfaceC1104b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC1104b) == null) {
            this.f23671d = interfaceC1104b;
        }
    }

    @Override // c.a.r0.q0.d.a
    public void d(QmStickerItem qmStickerItem) {
        QmStickerItem qmStickerItem2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, qmStickerItem) == null) {
            m(qmStickerItem);
            if (qmStickerItem == null) {
                return;
            }
            if (!TextUtils.isEmpty(qmStickerItem.fileUrl) && !StringUtils.isNull(f23667g)) {
                String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(qmStickerItem.fileUrl);
                if (nameMd5FromUrl == null) {
                    return;
                }
                File file = new File(f23667g);
                if (!file.exists()) {
                    file.mkdirs();
                }
                StringBuilder sb = new StringBuilder();
                sb.append(".");
                String str2 = qmStickerItem.fileUrl;
                sb.append(str2.substring(str2.lastIndexOf(".") + 1));
                String sb2 = sb.toString();
                if (this.f23670c == null) {
                    this.f23670c = new ArrayList();
                }
                if (k(qmStickerItem.fileUrl)) {
                    return;
                }
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(qmStickerItem.fileUrl);
                downloadData.setPath(f23667g + "/" + nameMd5FromUrl + sb2);
                downloadData.setCallback(this.f23673f);
                this.f23670c.add(downloadData);
                f.k().l(downloadData);
                return;
            }
            b(null);
            if (this.f23671d == null || (qmStickerItem2 = this.f23672e) == null || (str = qmStickerItem2.fileUrl) == null || !str.equals(qmStickerItem.fileUrl)) {
                return;
            }
            this.f23671d.b();
        }
    }

    @Override // c.a.r0.q0.d.a
    public void e() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || StringUtils.isNull(f23667g)) {
            return;
        }
        HashMap<String, String> hashMap = this.f23669b;
        if (hashMap == null) {
            this.f23669b = new HashMap<>();
        } else {
            hashMap.clear();
        }
        File file = new File(f23667g);
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    this.f23669b.put(file2.getName(), file2.getAbsolutePath());
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
            if (!ListUtils.isEmpty(this.f23670c) && str != null) {
                for (DownloadData downloadData : this.f23670c) {
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
        if (!(interceptable == null || interceptable.invokeL(1048583, this, downloadData) == null) || ListUtils.isEmpty(this.f23670c) || downloadData == null) {
            return;
        }
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 < this.f23670c.size()) {
                if (this.f23670c.get(i3) != null && this.f23670c.get(i3).getUrl() != null && this.f23670c.get(i3).getUrl().equals(downloadData.getUrl())) {
                    i2 = i3;
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        this.f23670c.remove(i2);
    }

    public void m(QmStickerItem qmStickerItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qmStickerItem) == null) {
            if (qmStickerItem == null) {
                this.f23672e = new QmStickerItem();
            } else {
                this.f23672e = qmStickerItem;
            }
        }
    }

    @Override // c.a.r0.q0.d.a
    public void reset() {
        c.a.r0.g0.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (aVar = this.f23668a) == null) {
            return;
        }
        aVar.b(null);
    }
}
