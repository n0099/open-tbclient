package c.a.u0.b.e;

import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.TurbonetEngine;
import com.baidu.turbonet.net.UrlRequest;
import com.baidu.turbonet.net.UrlRequestException;
import com.baidu.turbonet.net.UrlResponseInfo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes9.dex */
public class d extends HttpURLConnection {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TurbonetEngine a;

    /* renamed from: b  reason: collision with root package name */
    public final g f26348b;

    /* renamed from: c  reason: collision with root package name */
    public UrlRequest f26349c;

    /* renamed from: d  reason: collision with root package name */
    public final List<Pair<String, String>> f26350d;

    /* renamed from: e  reason: collision with root package name */
    public e f26351e;

    /* renamed from: f  reason: collision with root package name */
    public f f26352f;

    /* renamed from: g  reason: collision with root package name */
    public UrlResponseInfo f26353g;

    /* renamed from: h  reason: collision with root package name */
    public UrlRequestException f26354h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f26355i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f26356j;
    public List<Map.Entry<String, String>> k;
    public Map<String, List<String>> l;
    public boolean m;
    public boolean n;
    public boolean o;
    public String p;
    public String q;
    public int r;
    public boolean s;
    public boolean t;

    /* loaded from: classes9.dex */
    public class a extends UrlRequest.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, urlRequest, urlResponseInfo) == null) {
                this.a.f26353g = urlResponseInfo;
                g(new IOException("stream closed"));
            }
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, urlRequest, urlResponseInfo, urlRequestException) == null) {
                if (urlRequestException != null) {
                    c.a.u0.a.a.c("cr_CronetHttpURLConn", "****** onFailed, url is: %s, error is: %s", this.a.getURL().toString(), urlRequestException);
                    this.a.f26353g = urlResponseInfo;
                    this.a.f26354h = urlRequestException;
                    g(this.a.f26354h);
                    return;
                }
                throw new IllegalStateException("Exception cannot be null in onFailed.");
            }
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, urlRequest, urlResponseInfo, byteBuffer) == null) {
                this.a.f26353g = urlResponseInfo;
                this.a.f26348b.quit();
            }
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void d(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, urlRequest, urlResponseInfo, str) == null) {
                this.a.f26355i = true;
                try {
                    URL url = new URL(str);
                    boolean equals = url.getProtocol().equals(((HttpURLConnection) this.a).url.getProtocol());
                    if (((HttpURLConnection) this.a).instanceFollowRedirects) {
                        ((HttpURLConnection) this.a).url = url;
                    }
                    if (((HttpURLConnection) this.a).instanceFollowRedirects && (equals || this.a.o)) {
                        this.a.f26349c.d();
                        return;
                    }
                } catch (MalformedURLException unused) {
                }
                this.a.f26353g = urlResponseInfo;
                this.a.f26349c.cancel();
                g(null);
            }
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void e(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, urlRequest, urlResponseInfo) == null) {
                this.a.f26353g = urlResponseInfo;
                this.a.f26348b.quit();
            }
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void f(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, urlRequest, urlResponseInfo) == null) {
                c.a.u0.a.a.h("cr_CronetHttpURLConn", "****** Request Completed, url is %s, status code is %d, total received bytes is %d", urlResponseInfo.h(), Integer.valueOf(urlResponseInfo.c()), Long.valueOf(urlResponseInfo.g()));
                this.a.f26353g = urlResponseInfo;
                g(null);
            }
        }

        public final void g(IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, iOException) == null) {
                if (this.a.f26351e != null) {
                    this.a.f26351e.d(iOException);
                }
                if (this.a.f26352f != null) {
                    this.a.f26352f.h(iOException);
                }
                this.a.f26356j = true;
                this.a.f26348b.quit();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(URL url, TurbonetEngine turbonetEngine) {
        super(url);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {url, turbonetEngine};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((URL) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26355i = false;
        this.f26356j = false;
        this.o = false;
        this.r = 0;
        this.s = false;
        this.t = false;
        this.a = turbonetEngine;
        this.f26348b = new g(getURL().toString());
        this.f26351e = new e(this);
        this.f26350d = new ArrayList();
    }

    public final void A(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048576, this, str, str2, z) == null) {
            if (!((HttpURLConnection) this).connected) {
                int q = q(str);
                if (q >= 0) {
                    if (z) {
                        this.f26350d.remove(q);
                    } else {
                        throw new UnsupportedOperationException("Cannot add multiple headers of the same key, " + str + ". crbug.com/432719.");
                    }
                }
                this.f26350d.add(Pair.create(str, str2));
                return;
            }
            throw new IllegalStateException("Cannot modify request property after connection is made.");
        }
    }

    public final void B() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || ((HttpURLConnection) this).connected) {
            return;
        }
        UrlRequest.Builder builder = new UrlRequest.Builder(getURL().toString(), new a(this), this.f26348b, this.a);
        if (((HttpURLConnection) this).doOutput) {
            if (((HttpURLConnection) this).method.equals("GET")) {
                ((HttpURLConnection) this).method = "POST";
            }
            f fVar = this.f26352f;
            if (fVar != null) {
                builder.k(fVar.f(), this.f26348b);
                if (getRequestProperty("Content-Length") == null && !z()) {
                    addRequestProperty("Content-Length", Long.toString(this.f26352f.f().a()));
                }
                this.f26352f.g();
            } else if (getRequestProperty("Content-Length") == null) {
                addRequestProperty("Content-Length", "0");
            }
            if (getRequestProperty("Content-Type") == null) {
                addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            }
        }
        for (Pair<String, String> pair : this.f26350d) {
            builder.a((String) pair.first, (String) pair.second);
        }
        if (!getUseCaches()) {
            builder.c();
        }
        builder.f(((HttpURLConnection) this).method);
        if (this.m) {
            builder.d();
        }
        if (this.n) {
            builder.l();
        }
        if (!TextUtils.isEmpty(this.p)) {
            builder.e(this.p);
        }
        if (!TextUtils.isEmpty(this.q)) {
            builder.g(this.q);
        }
        builder.i(getConnectTimeout());
        builder.h(getReadTimeout());
        builder.j(v());
        ((HttpURLConnection) this).connected = true;
        UrlRequest b2 = builder.b();
        this.f26349c = b2;
        b2.start();
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            A(str, str2, false);
        }
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            getOutputStream();
            B();
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && ((HttpURLConnection) this).connected) {
            this.f26349c.cancel();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                w();
                if (this.f26353g.c() >= 400) {
                    return this.f26351e;
                }
                return null;
            } catch (IOException unused) {
                return null;
            }
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            try {
                w();
                Map<String, List<String>> r = r();
                if (r.containsKey(str)) {
                    List<String> list = r.get(str);
                    return list.get(list.size() - 1);
                }
                return null;
            } catch (IOException unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            Map.Entry<String, String> t = t(i2);
            if (t == null) {
                return null;
            }
            return t.getKey();
        }
        return (String) invokeI.objValue;
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            try {
                w();
                return r();
            } catch (IOException unused) {
                return Collections.emptyMap();
            }
        }
        return (Map) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            w();
            if (!((HttpURLConnection) this).instanceFollowRedirects && this.f26355i) {
                throw new IOException("Cannot read response body of a redirect.");
            }
            if (this.f26353g.c() < 400) {
                return this.f26351e;
            }
            throw new FileNotFoundException(((HttpURLConnection) this).url.toString());
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.f26352f == null && ((HttpURLConnection) this).doOutput) {
                if (!((HttpURLConnection) this).connected) {
                    if (z()) {
                        this.f26352f = new b(this, ((HttpURLConnection) this).chunkLength, this.f26348b, this.s, this.t);
                        B();
                    } else {
                        long x = x();
                        if (x != -1) {
                            this.f26352f = new c(this, x, this.f26348b);
                            B();
                        } else {
                            c.a.u0.a.a.a("cr_CronetHttpURLConn", "Outputstream is being buffered in memory.");
                            String requestProperty = getRequestProperty("Content-Length");
                            if (requestProperty == null) {
                                this.f26352f = new c.a.u0.b.e.a(this);
                            } else {
                                try {
                                    this.f26352f = new c.a.u0.b.e.a(this, Long.parseLong(requestProperty));
                                } catch (NumberFormatException unused) {
                                    c.a.u0.a.a.c("cr_CronetHttpURLConn", "CONTENT_LENGTH has wrong format.", new Object[0]);
                                    this.f26352f = new c.a.u0.b.e.a(this);
                                }
                            }
                        }
                    }
                } else {
                    throw new ProtocolException("Cannot write to OutputStream after receiving response.");
                }
            }
            return this.f26352f;
        }
        return (OutputStream) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (!((HttpURLConnection) this).connected) {
                TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                for (Pair<String, String> pair : this.f26350d) {
                    if (!treeMap.containsKey(pair.first)) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(pair.second);
                        treeMap.put(pair.first, Collections.unmodifiableList(arrayList));
                    } else {
                        throw new IllegalStateException("Should not have multiple values.");
                    }
                }
                return Collections.unmodifiableMap(treeMap);
            }
            throw new IllegalStateException("Cannot access request headers after connection is set.");
        }
        return (Map) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            int q = q(str);
            if (q >= 0) {
                return (String) this.f26350d.get(q).second;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            w();
            return this.f26353g.c();
        }
        return invokeV.intValue;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            w();
            return this.f26353g.d();
        }
        return (String) invokeV.objValue;
    }

    public final void o() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.f26356j) {
                UrlRequestException urlRequestException = this.f26354h;
                if (urlRequestException == null) {
                    if (this.f26353g == null) {
                        throw new NullPointerException("Response info is null when there is no exception.");
                    }
                    return;
                }
                throw urlRequestException;
            }
            throw new IllegalStateException("No response.");
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.o = true;
        }
    }

    public final int q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            for (int i2 = 0; i2 < this.f26350d.size(); i2++) {
                if (((String) this.f26350d.get(i2).first).equalsIgnoreCase(str)) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public final Map<String, List<String>> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            Map<String, List<String>> map = this.l;
            if (map != null) {
                return map;
            }
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (Map.Entry<String, String> entry : s()) {
                ArrayList arrayList = new ArrayList();
                if (treeMap.containsKey(entry.getKey())) {
                    arrayList.addAll((Collection) treeMap.get(entry.getKey()));
                }
                arrayList.add(entry.getValue());
                treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
            }
            Map<String, List<String>> unmodifiableMap = Collections.unmodifiableMap(treeMap);
            this.l = unmodifiableMap;
            return unmodifiableMap;
        }
        return (Map) invokeV.objValue;
    }

    public final List<Map.Entry<String, String>> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            List<Map.Entry<String, String>> list = this.k;
            if (list != null) {
                return list;
            }
            this.k = new ArrayList();
            for (Map.Entry<String, String> entry : this.f26353g.b()) {
                if (!entry.getKey().equalsIgnoreCase("Content-Encoding")) {
                    this.k.add(new AbstractMap.SimpleImmutableEntry(entry));
                }
            }
            List<Map.Entry<String, String>> unmodifiableList = Collections.unmodifiableList(this.k);
            this.k = unmodifiableList;
            return unmodifiableList;
        }
        return (List) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, str2) == null) {
            A(str, str2, true);
        }
    }

    public final Map.Entry<String, String> t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            try {
                w();
                List<Map.Entry<String, String>> s = s();
                if (i2 >= s.size()) {
                    return null;
                }
                return s.get(i2);
            } catch (IOException unused) {
                return null;
            }
        }
        return (Map.Entry) invokeI.objValue;
    }

    public void u(ByteBuffer byteBuffer) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, byteBuffer) == null) {
            this.f26349c.read(byteBuffer);
            this.f26348b.b(getReadTimeout());
        }
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.r : invokeV.intValue;
    }

    public final void w() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            f fVar = this.f26352f;
            if (fVar != null) {
                fVar.e();
                if (z()) {
                    this.f26352f.close();
                }
            }
            if (!this.f26356j) {
                B();
                this.f26348b.b(getReadTimeout());
                this.f26356j = true;
            }
            o();
        }
    }

    public final long x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            long j2 = ((HttpURLConnection) this).fixedContentLength;
            try {
                long j3 = getClass().getField("fixedContentLengthLong").getLong(this);
                return j3 != -1 ? j3 : j2;
            } catch (Exception unused) {
                return j2;
            }
        }
        return invokeV.longValue;
    }

    public UrlResponseInfo y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f26353g : (UrlResponseInfo) invokeV.objValue;
    }

    public final boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? ((HttpURLConnection) this).chunkLength > 0 : invokeV.booleanValue;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            Map.Entry<String, String> t = t(i2);
            if (t == null) {
                return null;
            }
            return t.getValue();
        }
        return (String) invokeI.objValue;
    }
}
