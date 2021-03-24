package com.baidu.mobads.openad.b;

import android.os.Build;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.j;
import com.baidu.mobads.openad.a.c;
import com.baidu.mobads.openad.a.d;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.aa;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class a extends c {

    /* renamed from: b  reason: collision with root package name */
    public String f8401b;

    /* renamed from: c  reason: collision with root package name */
    public Boolean f8402c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f8403d;

    /* renamed from: e  reason: collision with root package name */
    public IXAdLogger f8404e;

    /* renamed from: f  reason: collision with root package name */
    public IXAdURIUitls f8405f;

    /* renamed from: com.baidu.mobads.openad.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0108a extends com.baidu.mobads.f.a {

        /* renamed from: c  reason: collision with root package name */
        public b f8407c;

        /* renamed from: d  reason: collision with root package name */
        public double f8408d;

        public C0108a(b bVar, double d2) {
            this.f8407c = bVar;
            this.f8408d = d2;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, INVOKE, INVOKE, IF, IGET, INVOKE, IGET, INVOKE, INVOKE, IF, IGET, INVOKE, IGET, INVOKE, INVOKE, IF, IGET, INVOKE, IGET, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, IGET, INVOKE, INVOKE, IF, IGET, INVOKE, IGET, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x018a, code lost:
            if (r10.f8406a.f8405f == null) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x020e, code lost:
            return null;
         */
        /* JADX WARN: Removed duplicated region for block: B:86:0x0172 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.baidu.mobads.f.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object a() {
            HttpURLConnection httpURLConnection;
            InputStream inputStream;
            try {
                if (this.f8407c.f8411c > 0) {
                    Thread.sleep(this.f8407c.f8411c);
                }
                if (this.f8407c.f8409a.indexOf("mobads.baidu.com") > -1) {
                    j.a().a(1003);
                }
                httpURLConnection = XAdSDKFoundationFacade.getInstance().getURIUitls().getHttpURLConnection(new URL(this.f8407c.f8409a));
                try {
                    httpURLConnection.setConnectTimeout((int) this.f8408d);
                    httpURLConnection.setReadTimeout((int) this.f8408d);
                    httpURLConnection.setUseCaches(false);
                    if (this.f8407c.f8410b != null && this.f8407c.f8410b.length() > 0) {
                        httpURLConnection.setRequestProperty("User-Agent", this.f8407c.f8410b);
                    }
                    httpURLConnection.setRequestProperty("Content-type", this.f8407c.f8412d);
                    httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
                    httpURLConnection.setRequestProperty("Cache-Control", "no-cache");
                    if (Integer.parseInt(Build.VERSION.SDK) < 8) {
                        System.setProperty("http.keepAlive", "false");
                    }
                    if (this.f8407c.f8413e == 1) {
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.connect();
                        int responseCode = httpURLConnection.getResponseCode();
                        if (!a.this.f8402c.booleanValue() && responseCode == 200) {
                            inputStream = httpURLConnection.getInputStream();
                            try {
                                String b2 = a.b(inputStream);
                                try {
                                    if (this.f8407c.f8409a.indexOf("mobads.baidu.com") > -1) {
                                        j.a().a(1004);
                                    }
                                } catch (Throwable unused) {
                                }
                                a.this.dispatchEvent(new d("URLLoader.Load.Complete", b2, this.f8407c.a()));
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable th) {
                                        a.this.f8404e.d("OAdURLLoader", th.getMessage());
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    a.this.f8404e.d("OAdURLLoader", "load throwable :" + th.getMessage());
                                    if (!a.this.f8402c.booleanValue() && !a.this.f8403d.get()) {
                                        a.this.dispatchEvent(new com.baidu.mobads.openad.a.a("URLLoader.Load.Error", "RuntimeError: " + th.toString()));
                                    }
                                } finally {
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable th3) {
                                            a.this.f8404e.d("OAdURLLoader", th3.getMessage());
                                        }
                                    }
                                    if (a.this.f8405f != null) {
                                        a.this.f8405f.closeHttpURLConnection(httpURLConnection);
                                    }
                                }
                            }
                        } else {
                            a.this.dispatchEvent(new com.baidu.mobads.openad.a.a("URLLoader.Load.Error", "RequestError: " + responseCode));
                        }
                    } else if (this.f8407c.f8413e == 0) {
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setDoOutput(true);
                        if (this.f8407c.b() != null) {
                            String encodedQuery = this.f8407c.b().build().getEncodedQuery();
                            OutputStream outputStream = httpURLConnection.getOutputStream();
                            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                            bufferedWriter.write(encodedQuery);
                            bufferedWriter.flush();
                            bufferedWriter.close();
                            outputStream.close();
                        }
                        httpURLConnection.connect();
                        httpURLConnection.getResponseCode();
                        a.this.f8404e.d("OAdURLLoader", "Post connect code :" + httpURLConnection.getResponseCode());
                    }
                    inputStream = null;
                    if (inputStream != null) {
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                }
            } catch (Throwable th5) {
                th = th5;
                httpURLConnection = null;
                inputStream = null;
            }
        }
    }

    public a(String str) {
        this.f8402c = Boolean.FALSE;
        this.f8403d = new AtomicBoolean();
        this.f8404e = XAdSDKFoundationFacade.getInstance().getAdLogger();
        this.f8405f = new aa();
        this.f8401b = str;
    }

    public void a() {
    }

    public static String b(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String str = "";
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return str;
            }
            str = str + readLine + "\n";
        }
    }

    public void a(b bVar, Boolean bool) {
        this.f8402c = bool;
        a(bVar, 20000.0d);
    }

    public void a(b bVar) {
        a(bVar, 20000.0d);
    }

    public void a(b bVar, double d2) {
        try {
            com.baidu.mobads.f.c.a().a((com.baidu.mobads.f.a) new C0108a(bVar, d2));
        } catch (Throwable unused) {
        }
    }

    public a() {
        this(null);
    }
}
