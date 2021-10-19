package c.b.c.b.n;

import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f31641a;

    /* renamed from: b  reason: collision with root package name */
    public HttpURLConnection f31642b;

    /* renamed from: c  reason: collision with root package name */
    public String f31643c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f31644d;

    /* renamed from: e  reason: collision with root package name */
    public DataOutputStream f31645e;

    /* renamed from: f  reason: collision with root package name */
    public GZIPOutputStream f31646f;

    public d(String str, String str2, boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31643c = str2;
        this.f31644d = z;
        this.f31641a = "AAA" + System.currentTimeMillis() + "AAA";
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        this.f31642b = httpURLConnection;
        httpURLConnection.setUseCaches(false);
        this.f31642b.setDoOutput(true);
        this.f31642b.setDoInput(true);
        this.f31642b.setRequestMethod("POST");
        HttpURLConnection httpURLConnection2 = this.f31642b;
        httpURLConnection2.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.f31641a);
        if (z) {
            this.f31642b.setRequestProperty("Content-Encoding", AsyncHttpClient.ENCODING_GZIP);
            this.f31646f = new GZIPOutputStream(this.f31642b.getOutputStream());
            return;
        }
        this.f31645e = new DataOutputStream(this.f31642b.getOutputStream());
    }

    public String a() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList<String> arrayList = new ArrayList();
            byte[] bytes = ("\r\n--" + this.f31641a + "--" + Part.CRLF).getBytes();
            if (this.f31644d) {
                this.f31646f.write(bytes);
                this.f31646f.finish();
                this.f31646f.close();
            } else {
                this.f31645e.write(bytes);
                this.f31645e.flush();
                this.f31645e.close();
            }
            int responseCode = this.f31642b.getResponseCode();
            if (responseCode == 200) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f31642b.getInputStream()));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    arrayList.add(readLine);
                }
                bufferedReader.close();
                this.f31642b.disconnect();
                StringBuilder sb = new StringBuilder();
                for (String str : arrayList) {
                    sb.append(str);
                }
                return sb.toString();
            }
            throw new IOException("Server returned non-OK status: " + responseCode);
        }
        return (String) invokeV.objValue;
    }

    public void b(String str, File file) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, file) == null) {
            String name = file.getName();
            StringBuilder sb = new StringBuilder();
            sb.append("--");
            sb.append(this.f31641a);
            sb.append(Part.CRLF);
            sb.append("Content-Disposition: form-data; name=\"");
            sb.append(str);
            sb.append("\"; filename=\"");
            sb.append(name);
            sb.append("\"");
            sb.append(Part.CRLF);
            sb.append("Content-Transfer-Encoding: binary");
            sb.append(Part.CRLF);
            sb.append(Part.CRLF);
            if (this.f31644d) {
                this.f31646f.write(sb.toString().getBytes());
            } else {
                this.f31645e.write(sb.toString().getBytes());
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                } else if (this.f31644d) {
                    this.f31646f.write(bArr, 0, read);
                } else {
                    this.f31645e.write(bArr, 0, read);
                }
            }
            fileInputStream.close();
            if (this.f31644d) {
                this.f31646f.write(Part.CRLF.getBytes());
                return;
            }
            this.f31645e.write(sb.toString().getBytes());
            this.f31645e.flush();
        }
    }

    public void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("--");
            sb.append(this.f31641a);
            sb.append(Part.CRLF);
            sb.append("Content-Disposition: form-data; name=\"");
            sb.append(str);
            sb.append("\"");
            sb.append(Part.CRLF);
            sb.append("Content-Type: text/plain; charset=");
            sb.append(this.f31643c);
            sb.append(Part.CRLF);
            sb.append(Part.CRLF);
            sb.append(str2);
            sb.append(Part.CRLF);
            try {
                if (this.f31644d) {
                    this.f31646f.write(sb.toString().getBytes());
                } else {
                    this.f31645e.write(sb.toString().getBytes());
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
