package b.a.q0.c1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.SevenZipUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.URL;
import java.util.UUID;
/* loaded from: classes4.dex */
public class t extends BdAsyncTask<String, String, b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Activity f12850a;

    /* renamed from: b  reason: collision with root package name */
    public String f12851b;

    /* renamed from: c  reason: collision with root package name */
    public int f12852c;

    /* renamed from: d  reason: collision with root package name */
    public a f12853d;

    /* renamed from: e  reason: collision with root package name */
    public String f12854e;

    /* renamed from: f  reason: collision with root package name */
    public String f12855f;

    /* renamed from: g  reason: collision with root package name */
    public File f12856g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12857h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12858i;
    public boolean j;

    /* loaded from: classes4.dex */
    public static abstract class a {
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

        public abstract void onError(int i2, String str);

        public abstract void onSuccess(String str);
    }

    /* loaded from: classes4.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f12859a;

        /* renamed from: b  reason: collision with root package name */
        public String f12860b;

        public b(t tVar, boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar, Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12859a = z;
            this.f12860b = str;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12860b : (String) invokeV.objValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12859a : invokeV.booleanValue;
        }
    }

    public t(Activity activity, String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, str, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12852c = 0;
        this.f12858i = true;
        this.j = false;
        this.f12850a = activity;
        this.f12851b = str;
        this.f12853d = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public b doInBackground(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
            if (TextUtils.isEmpty(this.f12851b)) {
                return new b(this, false, "url is null");
            }
            if (!j()) {
                return new b(this, false, "make file error");
            }
            if (!this.f12857h) {
                if (!d()) {
                    return new b(this, false, "download error");
                }
            } else if (!n()) {
                return new b(this, false, "decode base64 error");
            }
            return new b(this, true, null);
        }
        return (b) invokeL.objValue;
    }

    public final boolean c(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, i2)) == null) {
            int b2 = b.a.e.c.j.b.d().b().b();
            int b3 = b.a.e.c.j.b.d().c().b();
            boolean z = false;
            for (int i3 = 0; i3 < i2; i3++) {
                try {
                    z = m(str, str2, b3, b2);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return z;
        }
        return invokeLLI.booleanValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c(this.f12851b, this.f12855f, 3) : invokeV.booleanValue;
    }

    public final HttpURLConnection e(URL url, int i2, int i3) throws SocketException, ProtocolException {
        InterceptResult invokeLII;
        String c2;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, url, i2, i3)) == null) {
            HttpURLConnection httpURLConnection2 = null;
            try {
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (b.a.e.f.p.j.z()) {
                if (b.a.e.f.p.j.x() && (c2 = b.a.e.f.p.j.c()) != null && c2.length() > 0) {
                    if (b.a.e.f.p.j.F(c2) && b.a.e.f.p.j.D()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(c2);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                    } else {
                        httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(c2, b.a.e.f.p.j.d())));
                    }
                    httpURLConnection2 = httpURLConnection;
                }
                if (httpURLConnection2 == null) {
                    httpURLConnection2 = (HttpURLConnection) url.openConnection();
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.setRequestMethod("GET");
                    httpURLConnection2.setConnectTimeout(i2);
                    httpURLConnection2.setReadTimeout(i3);
                    return httpURLConnection2;
                }
                throw new SocketException();
            }
            return null;
        }
        return (HttpURLConnection) invokeLII.objValue;
    }

    public final String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX;
            }
            if (str.endsWith(EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX)) {
                return EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX;
            }
            if (str.endsWith(".PNG")) {
                return ".PNG";
            }
            if (str.endsWith(ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX)) {
                return ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX;
            }
            if (str.endsWith(".jpeg")) {
                return ".jpeg";
            }
            if (str.endsWith(".JPEG")) {
                return ".JPEG";
            }
            if (str.endsWith(".gif")) {
                return ".gif";
            }
            if (str.endsWith(".GIF")) {
                return ".GIF";
            }
            String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            if (split != null && split.length > 0) {
                String str2 = split[split.length - 1];
                if (str2.startsWith("png")) {
                    return EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX;
                }
                if (str2.startsWith("PNG")) {
                    return ".PNG";
                }
                if (str2.startsWith("jpg")) {
                    return ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX;
                }
                if (str2.startsWith("jpeg")) {
                    return ".jpeg";
                }
                if (str2.startsWith("JPEG")) {
                    return ".JPEG";
                }
                if (str2.startsWith("gif")) {
                    return ".gif";
                }
                if (str2.startsWith("GIF")) {
                    return ".GIF";
                }
            }
            return ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public final File g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            b.a.e.f.p.f.k(str);
            return new File(str);
        }
        return (File) invokeL.objValue;
    }

    public t h(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.f12857h = z;
            return this;
        }
        return (t) invokeZ.objValue;
    }

    public final boolean i(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, file)) == null) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                fileInputStream.skip(fileInputStream.available() - 1);
                int[] iArr = {fileInputStream.read(), fileInputStream.read(), fileInputStream.read(), fileInputStream.read(), fileInputStream.read()};
                fileInputStream.close();
                if (iArr[0] == 71 && iArr[1] == 73 && iArr[2] == 70 && iArr[3] == 56) {
                    return iArr[4] == 59;
                }
                return false;
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                return false;
            } catch (IOException e3) {
                e3.printStackTrace();
                return false;
            } catch (Exception e4) {
                e4.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        File externalStoragePublicDirectory;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            try {
                if (this.f12852c == 1) {
                    FileHelper.CheckTempDir(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/");
                    FileHelper.CheckTempDir(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + SevenZipUtils.FILE_NAME_TEMP + "/");
                    FileHelper.CheckTempDir(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + SevenZipUtils.FILE_NAME_TEMP + "/.nomedia/");
                    externalStoragePublicDirectory = new File(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + SevenZipUtils.FILE_NAME_TEMP + "/.nomedia/");
                } else {
                    externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                }
                if (externalStoragePublicDirectory != null && externalStoragePublicDirectory.exists()) {
                    String absolutePath = externalStoragePublicDirectory.getAbsolutePath();
                    this.f12854e = absolutePath;
                    if (!TextUtils.isEmpty(absolutePath) && !this.f12854e.endsWith("/")) {
                        this.f12854e += "/";
                    }
                } else {
                    this.f12854e = Environment.getExternalStorageDirectory().getPath() + "/tieba/";
                }
                File file = new File(this.f12854e);
                if (!file.exists()) {
                    file.mkdir();
                }
                this.f12855f = this.f12854e + (this.f12852c == 1 ? "shareDialogTempImg" : UUID.randomUUID().toString().replace("-", "").toLowerCase()) + f(this.f12851b);
                File file2 = new File(this.f12855f);
                this.f12856g = file2;
                if (file2.exists()) {
                    this.f12856g.delete();
                }
                if (this.f12856g.exists()) {
                    return true;
                }
                this.f12856g.createNewFile();
                return true;
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f12856g == null) {
            return;
        }
        TbadkCoreApplication.getInst().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(this.f12856g)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public void onPostExecute(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            super.onPostExecute(bVar);
            if (bVar == null) {
                a aVar = this.f12853d;
                if (aVar != null) {
                    aVar.onError(-2, "error");
                }
            } else if (!bVar.b()) {
                a aVar2 = this.f12853d;
                if (aVar2 != null) {
                    aVar2.onError(-1, bVar.a());
                }
            } else {
                if (this.j && i(new File(this.f12855f))) {
                    String replace = this.f12855f.replace(f(this.f12855f), ".gif");
                    this.f12856g.renameTo(new File(replace));
                    this.f12855f = replace;
                    this.f12856g = new File(this.f12855f);
                }
                k();
                a aVar3 = this.f12853d;
                if (aVar3 != null) {
                    aVar3.onSuccess(this.f12855f);
                }
            }
        }
    }

    public final boolean m(String str, String str2, int i2, int i3) throws Exception {
        InterceptResult invokeLLII;
        HttpURLConnection httpURLConnection;
        FileOutputStream fileOutputStream;
        int responseCode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048588, this, str, str2, i2, i3)) == null) {
            InputStream inputStream = null;
            try {
                httpURLConnection = e(new URL(str), i2, i3);
                try {
                    fileOutputStream = new FileOutputStream(g(str2), true);
                    try {
                        httpURLConnection.connect();
                        responseCode = httpURLConnection.getResponseCode();
                        if (responseCode == 302) {
                            String headerField = httpURLConnection.getHeaderField("Location");
                            b.a.e.f.m.a.e(httpURLConnection);
                            try {
                                if (this.f12856g != null) {
                                    this.f12856g.delete();
                                }
                            } catch (Exception unused) {
                            }
                            this.f12855f = this.f12854e + (this.f12852c == 1 ? "shareDialogTempImg" : UUID.randomUUID().toString().replace("-", "").toLowerCase()) + f(headerField);
                            File file = new File(this.f12855f);
                            this.f12856g = file;
                            if (file.exists()) {
                                this.f12856g.delete();
                            }
                            if (!this.f12856g.exists()) {
                                this.f12856g.createNewFile();
                            }
                            b.a.e.f.m.a.d(fileOutputStream);
                            FileOutputStream fileOutputStream2 = new FileOutputStream(this.f12856g, true);
                            try {
                                httpURLConnection = e(new URL(headerField), i2, i3);
                                httpURLConnection.connect();
                                responseCode = httpURLConnection.getResponseCode();
                                fileOutputStream = fileOutputStream2;
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream = fileOutputStream2;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
            } catch (Throwable th4) {
                th = th4;
                httpURLConnection = null;
                fileOutputStream = null;
            }
            if (responseCode == 200) {
                String headerField2 = httpURLConnection.getHeaderField("Content-Length");
                if ((headerField2 != null ? b.a.e.f.m.b.e(headerField2, 0) : 0) != 0 || !this.f12858i) {
                    inputStream = httpURLConnection.getInputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read != -1) {
                            try {
                                fileOutputStream.write(bArr, 0, read);
                            } catch (Exception unused2) {
                                throw new FileNotFoundException();
                            }
                        } else {
                            try {
                                fileOutputStream.flush();
                                b.a.e.f.m.a.c(inputStream);
                                b.a.e.f.m.a.e(httpURLConnection);
                                b.a.e.f.m.a.d(fileOutputStream);
                                return true;
                            } catch (Exception unused3) {
                                throw new FileNotFoundException();
                            }
                        }
                        th = th2;
                        b.a.e.f.m.a.c(inputStream);
                        b.a.e.f.m.a.e(httpURLConnection);
                        b.a.e.f.m.a.d(fileOutputStream);
                        throw th;
                    }
                }
            }
            b.a.e.f.m.a.c(null);
            b.a.e.f.m.a.e(httpURLConnection);
            b.a.e.f.m.a.d(fileOutputStream);
            return false;
        }
        return invokeLLII.booleanValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            String str = this.f12851b;
            byte[] decode = Base64.decode(str.substring(str.indexOf(",") + 1, this.f12851b.length()), 0);
            for (int i2 = 0; i2 < decode.length; i2++) {
                if (decode[i2] < 0) {
                    decode[i2] = (byte) (decode[i2] + 256);
                }
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(this.f12856g, true);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(decode);
                fileOutputStream.flush();
                b.a.e.f.m.a.d(fileOutputStream);
                return true;
            } catch (Exception e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                b.a.e.f.m.a.d(fileOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                b.a.e.f.m.a.d(fileOutputStream2);
                throw th;
            }
        }
        return invokeV.booleanValue;
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f12858i = z;
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f12852c = i2;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.j = z;
        }
    }
}
