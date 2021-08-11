package c.a.o0.b1;

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
/* loaded from: classes3.dex */
public class q extends BdAsyncTask<String, String, b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Activity f12642a;

    /* renamed from: b  reason: collision with root package name */
    public String f12643b;

    /* renamed from: c  reason: collision with root package name */
    public int f12644c;

    /* renamed from: d  reason: collision with root package name */
    public a f12645d;

    /* renamed from: e  reason: collision with root package name */
    public String f12646e;

    /* renamed from: f  reason: collision with root package name */
    public String f12647f;

    /* renamed from: g  reason: collision with root package name */
    public File f12648g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12649h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12650i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f12651j;

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f12652a;

        /* renamed from: b  reason: collision with root package name */
        public String f12653b;

        public b(q qVar, boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar, Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12652a = z;
            this.f12653b = str;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12653b : (String) invokeV.objValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12652a : invokeV.booleanValue;
        }
    }

    public q(Activity activity, String str, a aVar) {
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
        this.f12644c = 0;
        this.f12650i = true;
        this.f12651j = false;
        this.f12642a = activity;
        this.f12643b = str;
        this.f12645d = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public b doInBackground(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
            if (TextUtils.isEmpty(this.f12643b)) {
                return new b(this, false, "url is null");
            }
            if (!j()) {
                return new b(this, false, "make file error");
            }
            if (!this.f12649h) {
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
            int b2 = c.a.e.c.j.b.d().b().b();
            int b3 = c.a.e.c.j.b.d().c().b();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c(this.f12643b, this.f12647f, 3) : invokeV.booleanValue;
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
            if (c.a.e.e.p.j.z()) {
                if (c.a.e.e.p.j.x() && (c2 = c.a.e.e.p.j.c()) != null && c2.length() > 0) {
                    if (c.a.e.e.p.j.F(c2) && c.a.e.e.p.j.D()) {
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
                        httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(c2, c.a.e.e.p.j.d())));
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
            c.a.e.e.p.f.k(str);
            return new File(str);
        }
        return (File) invokeL.objValue;
    }

    public q h(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.f12649h = z;
            return this;
        }
        return (q) invokeZ.objValue;
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
                if (this.f12644c == 1) {
                    FileHelper.CheckTempDir(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/");
                    FileHelper.CheckTempDir(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + SevenZipUtils.FILE_NAME_TEMP + "/");
                    FileHelper.CheckTempDir(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + SevenZipUtils.FILE_NAME_TEMP + "/.nomedia/");
                    externalStoragePublicDirectory = new File(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + SevenZipUtils.FILE_NAME_TEMP + "/.nomedia/");
                } else {
                    externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                }
                if (externalStoragePublicDirectory != null && externalStoragePublicDirectory.exists()) {
                    String absolutePath = externalStoragePublicDirectory.getAbsolutePath();
                    this.f12646e = absolutePath;
                    if (!TextUtils.isEmpty(absolutePath) && !this.f12646e.endsWith("/")) {
                        this.f12646e += "/";
                    }
                } else {
                    this.f12646e = Environment.getExternalStorageDirectory().getPath() + "/tieba/";
                }
                File file = new File(this.f12646e);
                if (!file.exists()) {
                    file.mkdir();
                }
                this.f12647f = this.f12646e + (this.f12644c == 1 ? "shareDialogTempImg" : UUID.randomUUID().toString().replace("-", "").toLowerCase()) + f(this.f12643b);
                File file2 = new File(this.f12647f);
                this.f12648g = file2;
                if (file2.exists()) {
                    this.f12648g.delete();
                }
                if (this.f12648g.exists()) {
                    return true;
                }
                this.f12648g.createNewFile();
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
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f12648g == null) {
            return;
        }
        TbadkCoreApplication.getInst().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(this.f12648g)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public void onPostExecute(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            super.onPostExecute(bVar);
            if (bVar == null) {
                a aVar = this.f12645d;
                if (aVar != null) {
                    aVar.onError(-2, "error");
                }
            } else if (!bVar.b()) {
                a aVar2 = this.f12645d;
                if (aVar2 != null) {
                    aVar2.onError(-1, bVar.a());
                }
            } else {
                if (this.f12651j && i(new File(this.f12647f))) {
                    String replace = this.f12647f.replace(f(this.f12647f), ".gif");
                    this.f12648g.renameTo(new File(replace));
                    this.f12647f = replace;
                    this.f12648g = new File(this.f12647f);
                }
                k();
                a aVar3 = this.f12645d;
                if (aVar3 != null) {
                    aVar3.onSuccess(this.f12647f);
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
                            c.a.e.e.m.a.e(httpURLConnection);
                            try {
                                if (this.f12648g != null) {
                                    this.f12648g.delete();
                                }
                            } catch (Exception unused) {
                            }
                            this.f12647f = this.f12646e + (this.f12644c == 1 ? "shareDialogTempImg" : UUID.randomUUID().toString().replace("-", "").toLowerCase()) + f(headerField);
                            File file = new File(this.f12647f);
                            this.f12648g = file;
                            if (file.exists()) {
                                this.f12648g.delete();
                            }
                            if (!this.f12648g.exists()) {
                                this.f12648g.createNewFile();
                            }
                            c.a.e.e.m.a.d(fileOutputStream);
                            FileOutputStream fileOutputStream2 = new FileOutputStream(this.f12648g, true);
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
                if ((headerField2 != null ? c.a.e.e.m.b.d(headerField2, 0) : 0) != 0 || !this.f12650i) {
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
                                c.a.e.e.m.a.c(inputStream);
                                c.a.e.e.m.a.e(httpURLConnection);
                                c.a.e.e.m.a.d(fileOutputStream);
                                return true;
                            } catch (Exception unused3) {
                                throw new FileNotFoundException();
                            }
                        }
                        th = th2;
                        c.a.e.e.m.a.c(inputStream);
                        c.a.e.e.m.a.e(httpURLConnection);
                        c.a.e.e.m.a.d(fileOutputStream);
                        throw th;
                    }
                }
            }
            c.a.e.e.m.a.c(null);
            c.a.e.e.m.a.e(httpURLConnection);
            c.a.e.e.m.a.d(fileOutputStream);
            return false;
        }
        return invokeLLII.booleanValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            String str = this.f12643b;
            byte[] decode = Base64.decode(str.substring(str.indexOf(",") + 1, this.f12643b.length()), 0);
            for (int i2 = 0; i2 < decode.length; i2++) {
                if (decode[i2] < 0) {
                    decode[i2] = (byte) (decode[i2] + 256);
                }
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(this.f12648g, true);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(decode);
                fileOutputStream.flush();
                c.a.e.e.m.a.d(fileOutputStream);
                return true;
            } catch (Exception e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                c.a.e.e.m.a.d(fileOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                c.a.e.e.m.a.d(fileOutputStream2);
                throw th;
            }
        }
        return invokeV.booleanValue;
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f12650i = z;
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f12644c = i2;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f12651j = z;
        }
    }
}
