package com.baidu.mobads.sdk.internal;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.u;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Observable;
/* loaded from: classes3.dex */
public class al extends Observable implements u, Runnable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int i = 10240;
    public static final int j = 10240;
    public static final String k = ".tmp";
    public static final String m = "FileDownloader";
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public URL b;
    public String c;
    public String d;
    public int e;
    public u.a f;
    public int g;
    public int h;
    public byte[] l;
    public boolean n;

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.internal.u
    @Deprecated
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.internal.u
    @Deprecated
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.internal.u
    @Deprecated
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.internal.u
    @Deprecated
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    @Deprecated
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    @Deprecated
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public al(Context context, URL url, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, url, str, str2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = false;
        this.a = context;
        this.b = url;
        this.c = str;
        this.n = z;
        if (str2 != null && str2.trim().length() > 0) {
            this.d = str2;
        } else {
            String file = url.getFile();
            this.d = file.substring(file.lastIndexOf(47) + 1);
        }
        this.e = -1;
        this.f = u.a.c;
        this.g = 0;
        this.h = 0;
    }

    private HttpURLConnection a(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, this, httpURLConnection)) != null) {
            return (HttpURLConnection) invokeL.objValue;
        }
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 302 || responseCode == 301) {
                    URL url = new URL(httpURLConnection.getHeaderField("Location"));
                    this.b = url;
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                    try {
                        httpURLConnection2.setConnectTimeout(10000);
                        httpURLConnection2.setInstanceFollowRedirects(false);
                        httpURLConnection2.setRequestProperty("Range", "bytes=0-");
                        httpURLConnection = httpURLConnection2;
                    } catch (Exception unused) {
                        return httpURLConnection2;
                    }
                } else {
                    return httpURLConnection;
                }
            } catch (Exception unused2) {
                return httpURLConnection;
            }
        }
    }

    private void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            a(u.a.f);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a(u.a.c);
            p();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.c + this.d;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public float k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return Math.abs((this.g / this.e) * 100.0f);
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public u.a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.f;
        }
        return (u.a) invokeV.objValue;
    }

    public byte[] o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.l;
        }
        return (byte[]) invokeV.objValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ba.a().a(this);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            setChanged();
            notifyObservers();
        }
    }

    public void a(int i2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f)}) == null) {
            this.g += i2;
            q();
        }
    }

    public void a(u.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f = aVar;
            q();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            bp.a(this.c + this.d + ".tmp", this.c + this.d);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x01f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        BufferedInputStream bufferedInputStream;
        HttpURLConnection httpURLConnection;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        Exception e;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            BufferedOutputStream bufferedOutputStream = null;
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            bufferedOutputStream = null;
            bufferedOutputStream = null;
            bufferedOutputStream = null;
            bufferedOutputStream = null;
            bufferedOutputStream = null;
            try {
                if (this.b != null && !co.a().f(this.b.toString())) {
                    co.a().a((HttpURLConnection) null);
                    return;
                }
                HttpURLConnection a = co.a().a(this.b);
                try {
                    a.setConnectTimeout(10000);
                    a.setInstanceFollowRedirects(true);
                    a.connect();
                    int responseCode = a.getResponseCode();
                    if (responseCode == 302 || responseCode == 301) {
                        a.setInstanceFollowRedirects(false);
                        a = a(a);
                        responseCode = a.getResponseCode();
                    }
                    if (responseCode / 100 != 2) {
                        s();
                    }
                    int contentLength = a.getContentLength();
                    if (contentLength > 0) {
                        this.e = contentLength;
                    }
                    File file = new File(this.c);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    bufferedInputStream = new BufferedInputStream(a.getInputStream());
                    try {
                        BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(g() + ".tmp"));
                        try {
                            byte[] bArr = new byte[10240];
                            if (this.n) {
                                byteArrayOutputStream2 = new ByteArrayOutputStream();
                            }
                            int i2 = 0;
                            while (this.f == u.a.c && (read = bufferedInputStream.read(bArr, 0, 10240)) != -1) {
                                bufferedOutputStream2.write(bArr, 0, read);
                                if (byteArrayOutputStream2 != null) {
                                    byteArrayOutputStream2.write(bArr, 0, read);
                                }
                                i2 += read;
                                a(read, i2 / this.e);
                            }
                            bufferedOutputStream2.flush();
                            if (byteArrayOutputStream2 != null) {
                                byteArrayOutputStream2.flush();
                            }
                            if (this.f == u.a.c) {
                                r();
                                a(u.a.e);
                            } else {
                                u.a aVar = u.a.f;
                            }
                            try {
                                bufferedOutputStream2.close();
                            } catch (Exception e2) {
                                br.a().c(m, e2.getMessage());
                            }
                            if (byteArrayOutputStream2 != null) {
                                try {
                                    byteArrayOutputStream2.close();
                                } catch (Exception e3) {
                                    br.a().c(m, e3.getMessage());
                                }
                            }
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e4) {
                                br.a().c(m, e4.getMessage());
                            }
                            co.a().a(a);
                        } catch (Exception e5) {
                            e = e5;
                            HttpURLConnection httpURLConnection2 = a;
                            byteArrayOutputStream = null;
                            bufferedOutputStream = bufferedOutputStream2;
                            httpURLConnection = httpURLConnection2;
                            try {
                                br.a().c(m, e.getMessage());
                                s();
                                if (bufferedOutputStream != null) {
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (Exception e6) {
                                        br.a().c(m, e6.getMessage());
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception e7) {
                                        br.a().c(m, e7.getMessage());
                                    }
                                }
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (Exception e8) {
                                        br.a().c(m, e8.getMessage());
                                    }
                                }
                                co.a().a(httpURLConnection);
                            } catch (Throwable th2) {
                                th = th2;
                                if (bufferedOutputStream != null) {
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (Exception e9) {
                                        br.a().c(m, e9.getMessage());
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception e10) {
                                        br.a().c(m, e10.getMessage());
                                    }
                                }
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (Exception e11) {
                                        br.a().c(m, e11.getMessage());
                                    }
                                }
                                co.a().a(httpURLConnection);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            HttpURLConnection httpURLConnection3 = a;
                            byteArrayOutputStream = null;
                            bufferedOutputStream = bufferedOutputStream2;
                            httpURLConnection = httpURLConnection3;
                            if (bufferedOutputStream != null) {
                            }
                            if (byteArrayOutputStream != null) {
                            }
                            if (bufferedInputStream != null) {
                            }
                            co.a().a(httpURLConnection);
                            throw th;
                        }
                    } catch (Exception e12) {
                        e = e12;
                        httpURLConnection = a;
                        byteArrayOutputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        httpURLConnection = a;
                        byteArrayOutputStream = null;
                    }
                } catch (Exception e13) {
                    httpURLConnection = a;
                    e = e13;
                    byteArrayOutputStream = null;
                    bufferedInputStream = null;
                } catch (Throwable th5) {
                    httpURLConnection = a;
                    th = th5;
                    byteArrayOutputStream = null;
                    bufferedInputStream = null;
                }
            } catch (Exception e14) {
                bufferedInputStream = null;
                httpURLConnection = null;
                e = e14;
                byteArrayOutputStream = null;
            } catch (Throwable th6) {
                bufferedInputStream = null;
                httpURLConnection = null;
                th = th6;
                byteArrayOutputStream = null;
            }
        }
    }
}
