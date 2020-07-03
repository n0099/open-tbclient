package com.baidu.mobads.openad.d;

import android.os.Build;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.c.d;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidubce.http.Headers;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.protocol.HTTP;
/* loaded from: classes10.dex */
public class a extends com.baidu.mobads.openad.c.c {
    public static int a = 1024;
    private static final TimeUnit h = TimeUnit.SECONDS;
    private static int i = 5;
    private static BlockingQueue<Runnable> j = new LinkedBlockingQueue();
    private static ThreadPoolExecutor k;
    private String b;
    private AtomicBoolean d;
    private Boolean e;
    private HttpURLConnection f;
    private AtomicBoolean g;

    static {
        try {
            k = new ThreadPoolExecutor(i, i, 1L, h, j);
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e(e);
        }
    }

    public a(String str) {
        this.d = new AtomicBoolean(false);
        this.e = false;
        this.g = new AtomicBoolean();
        this.b = str;
    }

    public a() {
        this(null);
    }

    public void a(c cVar, Boolean bool) {
        this.e = bool;
        a(cVar, 20000.0d);
    }

    public void a(c cVar) {
        a(cVar, 20000.0d);
    }

    public void a(c cVar, double d) {
        try {
            k.execute(new RunnableC0215a(cVar, d));
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mobads.openad.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class RunnableC0215a implements Runnable {
        private c b;
        private double c;

        public RunnableC0215a(c cVar, double d) {
            this.b = cVar;
            this.c = d;
        }

        @Override // java.lang.Runnable
        public void run() {
            IXAdLogger adLogger;
            Object[] objArr;
            InputStream inputStream = null;
            try {
                if (this.b.c > 0) {
                    Thread.sleep(this.b.c);
                }
                a.this.d.set(true);
                a.this.f = (HttpURLConnection) new URL(this.b.a).openConnection();
                a.this.f.setConnectTimeout((int) this.c);
                a.this.f.setUseCaches(false);
                if (this.b.b != null && this.b.b.length() > 0) {
                    a.this.f.setRequestProperty("User-Agent", this.b.b);
                }
                a.this.f.setRequestProperty("Content-type", this.b.d);
                a.this.f.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
                a.this.f.setRequestProperty(Headers.CACHE_CONTROL, "no-cache");
                if (Integer.parseInt(Build.VERSION.SDK) < 8) {
                    System.setProperty("http.keepAlive", "false");
                }
                if (this.b.e == 1) {
                    a.this.f.setRequestMethod("GET");
                    a.this.f.connect();
                    a.this.f.getHeaderFields();
                    if (!a.this.e.booleanValue()) {
                        inputStream = a.this.f.getInputStream();
                        a.this.dispatchEvent(new d("URLLoader.Load.Complete", a.b(inputStream), this.b.a()));
                    }
                    a.this.f.getResponseCode();
                } else if (this.b.e == 0) {
                    a.this.f.setRequestMethod("POST");
                    a.this.f.setDoInput(true);
                    a.this.f.setDoOutput(true);
                    if (this.b.b() != null) {
                        String encodedQuery = this.b.b().build().getEncodedQuery();
                        OutputStream outputStream = a.this.f.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        bufferedWriter.write(encodedQuery);
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                    }
                    a.this.f.connect();
                    a.this.f.getResponseCode();
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th) {
                        XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdURLLoader", th.getMessage());
                    }
                }
                if (a.this.f != null) {
                    try {
                        a.this.f.disconnect();
                    } catch (Throwable th2) {
                        adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
                        objArr = new Object[]{"OAdURLLoader", th2.getMessage()};
                        adLogger.e(objArr);
                    }
                }
            } catch (Throwable th3) {
                try {
                    if (!a.this.e.booleanValue() && !a.this.g.get()) {
                        a.this.dispatchEvent(new com.baidu.mobads.openad.c.a("URLLoader.Load.Error", "RuntimeError: " + th3.toString()));
                    }
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Throwable th4) {
                            XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdURLLoader", th4.getMessage());
                        }
                    }
                    if (a.this.f != null) {
                        try {
                            a.this.f.disconnect();
                        } catch (Throwable th5) {
                            adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
                            objArr = new Object[]{"OAdURLLoader", th5.getMessage()};
                            adLogger.e(objArr);
                        }
                    }
                } catch (Throwable th6) {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Throwable th7) {
                            XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdURLLoader", th7.getMessage());
                        }
                    }
                    if (a.this.f != null) {
                        try {
                            a.this.f.disconnect();
                        } catch (Throwable th8) {
                            XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdURLLoader", th8.getMessage());
                        }
                    }
                    throw th6;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(InputStream inputStream) {
        String str = "";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                str = str + readLine + "\n";
            } else {
                return str;
            }
        }
    }

    public void a() {
        new Thread(new b(this)).start();
    }

    @Override // com.baidu.mobads.openad.c.c
    public void dispose() {
        this.g.set(true);
        a();
        super.dispose();
    }
}
