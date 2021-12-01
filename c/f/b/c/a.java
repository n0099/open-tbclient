package c.f.b.c;

import android.text.TextUtils;
import c.f.b.c.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.Md5Utils;
import com.dxmpay.wallet.utils.FileUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes7.dex */
public class a implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f28599e;

    /* renamed from: f  reason: collision with root package name */
    public String f28600f;

    /* renamed from: g  reason: collision with root package name */
    public String f28601g;

    /* renamed from: h  reason: collision with root package name */
    public b.a f28602h;

    public a(String str, String str2, String str3, b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28599e = str;
        this.f28600f = str2;
        this.f28601g = str3;
        this.f28602h = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f28599e).openConnection();
                httpURLConnection.setConnectTimeout(50000);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() == 200) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    File file = new File(this.f28601g);
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] bArr = new byte[524288];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                        if (this.f28602h != null) {
                            this.f28602h.a();
                        }
                    }
                    fileOutputStream.flush();
                    inputStream.close();
                    if (FileUtils.existsFile(file) && TextUtils.equals(Md5Utils.getMd5FromFileV2(this.f28601g), this.f28600f)) {
                        if (this.f28602h != null) {
                            this.f28602h.a(this.f28601g);
                        }
                    } else if (this.f28602h != null) {
                        this.f28602h.b("md5 not match");
                    }
                } else if (this.f28602h != null) {
                    b.a aVar = this.f28602h;
                    aVar.b("Server Response Code is " + httpURLConnection.getResponseCode());
                }
            } catch (IOException e2) {
                b.a aVar2 = this.f28602h;
                if (aVar2 != null) {
                    aVar2.b(e2.getMessage());
                }
            }
        }
    }
}
