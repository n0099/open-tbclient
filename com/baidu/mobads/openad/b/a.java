package com.baidu.mobads.openad.b;

import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.openad.a.c;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.aa;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class a extends c {

    /* renamed from: b  reason: collision with root package name */
    private String f3420b;
    private Boolean c;
    private AtomicBoolean d;
    private IXAdLogger e;
    private IXAdURIUitls f;

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.mobads.openad.b.a.a.a():java.lang.Object] */
    static /* synthetic */ Boolean a(a aVar) {
        return aVar.c;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.mobads.openad.b.a.a.a():java.lang.Object] */
    static /* synthetic */ String a(InputStream inputStream) {
        return b(inputStream);
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.mobads.openad.b.a.a.a():java.lang.Object] */
    static /* synthetic */ IXAdLogger b(a aVar) {
        return aVar.e;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.mobads.openad.b.a.a.a():java.lang.Object] */
    static /* synthetic */ AtomicBoolean c(a aVar) {
        return aVar.d;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.mobads.openad.b.a.a.a():java.lang.Object] */
    static /* synthetic */ IXAdURIUitls d(a aVar) {
        return aVar.f;
    }

    public a(String str) {
        this.c = false;
        this.d = new AtomicBoolean();
        this.e = XAdSDKFoundationFacade.getInstance().getAdLogger();
        this.f = new aa();
        this.f3420b = str;
    }

    public a() {
        this(null);
    }

    public void a(b bVar, Boolean bool) {
        this.c = bool;
        a(bVar, 20000.0d);
    }

    public void a(b bVar) {
        a(bVar, 20000.0d);
    }

    public void a(b bVar, double d) {
        try {
            com.baidu.mobads.f.c.a().a((com.baidu.mobads.f.a) new C0266a(bVar, d));
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mobads.openad.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0266a extends com.baidu.mobads.f.a {
        private b c;
        private double d;

        public C0266a(b bVar, double d) {
            this.c = bVar;
            this.d = d;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
            	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
            	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
            */
        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [176=4] */
        @Override // com.baidu.mobads.f.a
        protected java.lang.Object a() {
            /*
                r9 = this;
                r7 = -1
                r1 = 0
                r6 = 1
                java.lang.String r0 = ""
                com.baidu.mobads.openad.b.b r0 = r9.c     // Catch: java.lang.Throwable -> L10c
                long r2 = r0.c     // Catch: java.lang.Throwable -> L10c
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L17
                com.baidu.mobads.openad.b.b r0 = r9.c     // Catch: java.lang.Throwable -> L10c
                long r2 = r0.c     // Catch: java.lang.Throwable -> L10c
                java.lang.Thread.sleep(r2)     // Catch: java.lang.Throwable -> L10c
            L17:
                com.baidu.mobads.openad.b.b r0 = r9.c     // Catch: java.lang.Throwable -> L106
                java.lang.String r0 = r0.f3422a     // Catch: java.lang.Throwable -> L106
                java.lang.String r2 = "mobads.baidu.com"
                int r0 = r0.indexOf(r2)     // Catch: java.lang.Throwable -> L106
                if (r0 <= r7) goto L2d
                com.baidu.mobads.j r0 = com.baidu.mobads.j.a()     // Catch: java.lang.Throwable -> L106
                r2 = 1003(0x3eb, float:1.406E-42)
                r0.a(r2)     // Catch: java.lang.Throwable -> L106
            L2d:
                java.net.URL r0 = new java.net.URL     // Catch: java.lang.Throwable -> L10c
                com.baidu.mobads.openad.b.b r2 = r9.c     // Catch: java.lang.Throwable -> L10c
                java.lang.String r2 = r2.f3422a     // Catch: java.lang.Throwable -> L10c
                r0.<init>(r2)     // Catch: java.lang.Throwable -> L10c
                com.baidu.mobads.utils.XAdSDKFoundationFacade r2 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance()     // Catch: java.lang.Throwable -> L10c
                com.baidu.mobads.interfaces.utils.IXAdURIUitls r2 = r2.getURIUitls()     // Catch: java.lang.Throwable -> L10c
                java.net.HttpURLConnection r4 = r2.getHttpURLConnection(r0)     // Catch: java.lang.Throwable -> L10c
                double r2 = r9.d     // Catch: java.lang.Throwable -> L21f
                int r0 = (int) r2     // Catch: java.lang.Throwable -> L21f
                r4.setConnectTimeout(r0)     // Catch: java.lang.Throwable -> L21f
                double r2 = r9.d     // Catch: java.lang.Throwable -> L21f
                int r0 = (int) r2     // Catch: java.lang.Throwable -> L21f
                r4.setReadTimeout(r0)     // Catch: java.lang.Throwable -> L21f
                r0 = 0
                r4.setUseCaches(r0)     // Catch: java.lang.Throwable -> L21f
                com.baidu.mobads.openad.b.b r0 = r9.c     // Catch: java.lang.Throwable -> L21f
                java.lang.String r0 = r0.f3423b     // Catch: java.lang.Throwable -> L21f
                if (r0 == 0) goto L6c
                com.baidu.mobads.openad.b.b r0 = r9.c     // Catch: java.lang.Throwable -> L21f
                java.lang.String r0 = r0.f3423b     // Catch: java.lang.Throwable -> L21f
                int r0 = r0.length()     // Catch: java.lang.Throwable -> L21f
                if (r0 <= 0) goto L6c
                java.lang.String r0 = "User-Agent"
                com.baidu.mobads.openad.b.b r2 = r9.c     // Catch: java.lang.Throwable -> L21f
                java.lang.String r2 = r2.f3423b     // Catch: java.lang.Throwable -> L21f
                r4.setRequestProperty(r0, r2)     // Catch: java.lang.Throwable -> L21f
            L6c:
                java.lang.String r0 = "Content-type"
                com.baidu.mobads.openad.b.b r2 = r9.c     // Catch: java.lang.Throwable -> L21f
                java.lang.String r2 = r2.d     // Catch: java.lang.Throwable -> L21f
                r4.setRequestProperty(r0, r2)     // Catch: java.lang.Throwable -> L21f
                java.lang.String r0 = "Connection"
                java.lang.String r2 = "keep-alive"
                r4.setRequestProperty(r0, r2)     // Catch: java.lang.Throwable -> L21f
                java.lang.String r0 = "Cache-Control"
                java.lang.String r2 = "no-cache"
                r4.setRequestProperty(r0, r2)     // Catch: java.lang.Throwable -> L21f
                java.lang.String r0 = android.os.Build.VERSION.SDK     // Catch: java.lang.Throwable -> L21f
                int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L21f
                r2 = 8
                if (r0 >= r2) goto L9b
                java.lang.String r0 = "http.keepAlive"
                java.lang.String r2 = "false"
                java.lang.System.setProperty(r0, r2)     // Catch: java.lang.Throwable -> L21f
            L9b:
                com.baidu.mobads.openad.b.b r0 = r9.c     // Catch: java.lang.Throwable -> L21f
                int r0 = r0.e     // Catch: java.lang.Throwable -> L21f
                if (r0 != r6) goto L1ad
                java.lang.String r0 = "GET"
                r4.setRequestMethod(r0)     // Catch: java.lang.Throwable -> L21f
                r4.connect()     // Catch: java.lang.Throwable -> L21f
                int r0 = r4.getResponseCode()     // Catch: java.lang.Throwable -> L21f
                com.baidu.mobads.openad.b.a r2 = com.baidu.mobads.openad.b.a.this     // Catch: java.lang.Throwable -> L21f
                java.lang.Boolean r2 = com.baidu.mobads.openad.b.a.a(r2)     // Catch: java.lang.Throwable -> L21f
                boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> L21f
                if (r2 != 0) goto L189
                r2 = 200(0xc8, float:2.8E-43)
                if (r0 != r2) goto L189
                java.io.InputStream r0 = r4.getInputStream()     // Catch: java.lang.Throwable -> L21f
                java.lang.String r2 = com.baidu.mobads.openad.b.a.a(r0)     // Catch: java.lang.Throwable -> L282
                com.baidu.mobads.openad.b.b r3 = r9.c     // Catch: java.lang.Throwable -> L286
                java.lang.String r3 = r3.f3422a     // Catch: java.lang.Throwable -> L286
                java.lang.String r5 = "mobads.baidu.com"
                int r3 = r3.indexOf(r5)     // Catch: java.lang.Throwable -> L286
                if (r3 <= r7) goto Ldc
                com.baidu.mobads.j r3 = com.baidu.mobads.j.a()     // Catch: java.lang.Throwable -> L286
                r5 = 1004(0x3ec, float:1.407E-42)
                r3.a(r5)     // Catch: java.lang.Throwable -> L286
            Ldc:
                com.baidu.mobads.openad.b.a r3 = com.baidu.mobads.openad.b.a.this     // Catch: java.lang.Throwable -> L282
                com.baidu.mobads.openad.a.d r5 = new com.baidu.mobads.openad.a.d     // Catch: java.lang.Throwable -> L282
                java.lang.String r6 = "URLLoader.Load.Complete"
                com.baidu.mobads.openad.b.b r7 = r9.c     // Catch: java.lang.Throwable -> L282
                java.lang.String r7 = r7.a()     // Catch: java.lang.Throwable -> L282
                r5.<init>(r6, r2, r7)     // Catch: java.lang.Throwable -> L282
                r3.dispatchEvent(r5)     // Catch: java.lang.Throwable -> L282
            Lef:
                if (r0 == 0) goto Lf4
                r0.close()     // Catch: java.lang.Throwable -> L224
            Lf4:
                com.baidu.mobads.openad.b.a r0 = com.baidu.mobads.openad.b.a.this
                com.baidu.mobads.interfaces.utils.IXAdURIUitls r0 = com.baidu.mobads.openad.b.a.d(r0)
                if (r0 == 0) goto L105
                com.baidu.mobads.openad.b.a r0 = com.baidu.mobads.openad.b.a.this
                com.baidu.mobads.interfaces.utils.IXAdURIUitls r0 = com.baidu.mobads.openad.b.a.d(r0)
                r0.closeHttpURLConnection(r4)
            L105:
                return r1
            L106:
                r0 = move-exception
                r0.printStackTrace()     // Catch: java.lang.Throwable -> L10c
                goto L2d
            L10c:
                r0 = move-exception
                r2 = r0
                r3 = r1
                r4 = r1
            L110:
                com.baidu.mobads.openad.b.a r0 = com.baidu.mobads.openad.b.a.this     // Catch: java.lang.Throwable -> L27f
                com.baidu.mobads.interfaces.utils.IXAdLogger r0 = com.baidu.mobads.openad.b.a.b(r0)     // Catch: java.lang.Throwable -> L27f
                java.lang.String r5 = "OAdURLLoader"
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L27f
                r6.<init>()     // Catch: java.lang.Throwable -> L27f
                java.lang.String r7 = "load throwable :"
                java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> L27f
                java.lang.String r7 = r2.getMessage()     // Catch: java.lang.Throwable -> L27f
                java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> L27f
                java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L27f
                r0.d(r5, r6)     // Catch: java.lang.Throwable -> L27f
                com.baidu.mobads.openad.b.a r0 = com.baidu.mobads.openad.b.a.this     // Catch: java.lang.Throwable -> L27f
                java.lang.Boolean r0 = com.baidu.mobads.openad.b.a.a(r0)     // Catch: java.lang.Throwable -> L27f
                boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L27f
                if (r0 != 0) goto L171
                com.baidu.mobads.openad.b.a r0 = com.baidu.mobads.openad.b.a.this     // Catch: java.lang.Throwable -> L27f
                java.util.concurrent.atomic.AtomicBoolean r0 = com.baidu.mobads.openad.b.a.c(r0)     // Catch: java.lang.Throwable -> L27f
                boolean r0 = r0.get()     // Catch: java.lang.Throwable -> L27f
                if (r0 != 0) goto L171
                com.baidu.mobads.openad.b.a r0 = com.baidu.mobads.openad.b.a.this     // Catch: java.lang.Throwable -> L27f
                com.baidu.mobads.openad.a.a r5 = new com.baidu.mobads.openad.a.a     // Catch: java.lang.Throwable -> L27f
                java.lang.String r6 = "URLLoader.Load.Error"
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L27f
                r7.<init>()     // Catch: java.lang.Throwable -> L27f
                java.lang.String r8 = "RuntimeError: "
                java.lang.StringBuilder r7 = r7.append(r8)     // Catch: java.lang.Throwable -> L27f
                java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L27f
                java.lang.StringBuilder r2 = r7.append(r2)     // Catch: java.lang.Throwable -> L27f
                java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L27f
                r5.<init>(r6, r2)     // Catch: java.lang.Throwable -> L27f
                r0.dispatchEvent(r5)     // Catch: java.lang.Throwable -> L27f
            L171:
                if (r3 == 0) goto L176
                r3.close()     // Catch: java.lang.Throwable -> L237
            L176:
                com.baidu.mobads.openad.b.a r0 = com.baidu.mobads.openad.b.a.this
                com.baidu.mobads.interfaces.utils.IXAdURIUitls r0 = com.baidu.mobads.openad.b.a.d(r0)
                if (r0 == 0) goto L105
                com.baidu.mobads.openad.b.a r0 = com.baidu.mobads.openad.b.a.this
                com.baidu.mobads.interfaces.utils.IXAdURIUitls r0 = com.baidu.mobads.openad.b.a.d(r0)
                r0.closeHttpURLConnection(r4)
                goto L105
            L189:
                com.baidu.mobads.openad.b.a r2 = com.baidu.mobads.openad.b.a.this     // Catch: java.lang.Throwable -> L21f
                com.baidu.mobads.openad.a.a r3 = new com.baidu.mobads.openad.a.a     // Catch: java.lang.Throwable -> L21f
                java.lang.String r5 = "URLLoader.Load.Error"
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L21f
                r6.<init>()     // Catch: java.lang.Throwable -> L21f
                java.lang.String r7 = "RequestError: "
                java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> L21f
                java.lang.StringBuilder r0 = r6.append(r0)     // Catch: java.lang.Throwable -> L21f
                java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L21f
                r3.<init>(r5, r0)     // Catch: java.lang.Throwable -> L21f
                r2.dispatchEvent(r3)     // Catch: java.lang.Throwable -> L21f
            L1aa:
                r0 = r1
                goto Lef
            L1ad:
                com.baidu.mobads.openad.b.b r0 = r9.c     // Catch: java.lang.Throwable -> L21f
                int r0 = r0.e     // Catch: java.lang.Throwable -> L21f
                if (r0 != 0) goto L1aa
                java.lang.String r0 = "POST"
                r4.setRequestMethod(r0)     // Catch: java.lang.Throwable -> L21f
                r0 = 1
                r4.setDoInput(r0)     // Catch: java.lang.Throwable -> L21f
                r0 = 1
                r4.setDoOutput(r0)     // Catch: java.lang.Throwable -> L21f
                com.baidu.mobads.openad.b.b r0 = r9.c     // Catch: java.lang.Throwable -> L21f
                android.net.Uri$Builder r0 = r0.b()     // Catch: java.lang.Throwable -> L21f
                if (r0 == 0) goto L1f4
                com.baidu.mobads.openad.b.b r0 = r9.c     // Catch: java.lang.Throwable -> L21f
                android.net.Uri$Builder r0 = r0.b()     // Catch: java.lang.Throwable -> L21f
                android.net.Uri r0 = r0.build()     // Catch: java.lang.Throwable -> L21f
                java.lang.String r0 = r0.getEncodedQuery()     // Catch: java.lang.Throwable -> L21f
                java.io.OutputStream r2 = r4.getOutputStream()     // Catch: java.lang.Throwable -> L21f
                java.io.BufferedWriter r3 = new java.io.BufferedWriter     // Catch: java.lang.Throwable -> L21f
                java.io.OutputStreamWriter r5 = new java.io.OutputStreamWriter     // Catch: java.lang.Throwable -> L21f
                java.lang.String r6 = "UTF-8"
                r5.<init>(r2, r6)     // Catch: java.lang.Throwable -> L21f
                r3.<init>(r5)     // Catch: java.lang.Throwable -> L21f
                r3.write(r0)     // Catch: java.lang.Throwable -> L21f
                r3.flush()     // Catch: java.lang.Throwable -> L21f
                r3.close()     // Catch: java.lang.Throwable -> L21f
                r2.close()     // Catch: java.lang.Throwable -> L21f
            L1f4:
                r4.connect()     // Catch: java.lang.Throwable -> L21f
                r4.getResponseCode()     // Catch: java.lang.Throwable -> L21f
                com.baidu.mobads.openad.b.a r0 = com.baidu.mobads.openad.b.a.this     // Catch: java.lang.Throwable -> L21f
                com.baidu.mobads.interfaces.utils.IXAdLogger r0 = com.baidu.mobads.openad.b.a.b(r0)     // Catch: java.lang.Throwable -> L21f
                java.lang.String r2 = "OAdURLLoader"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L21f
                r3.<init>()     // Catch: java.lang.Throwable -> L21f
                java.lang.String r5 = "Post connect code :"
                java.lang.StringBuilder r3 = r3.append(r5)     // Catch: java.lang.Throwable -> L21f
                int r5 = r4.getResponseCode()     // Catch: java.lang.Throwable -> L21f
                java.lang.StringBuilder r3 = r3.append(r5)     // Catch: java.lang.Throwable -> L21f
                java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L21f
                r0.d(r2, r3)     // Catch: java.lang.Throwable -> L21f
                goto L1aa
            L21f:
                r0 = move-exception
                r2 = r0
                r3 = r1
                goto L110
            L224:
                r0 = move-exception
                com.baidu.mobads.openad.b.a r2 = com.baidu.mobads.openad.b.a.this
                com.baidu.mobads.interfaces.utils.IXAdLogger r2 = com.baidu.mobads.openad.b.a.b(r2)
                java.lang.String r3 = "OAdURLLoader"
                java.lang.String r0 = r0.getMessage()
                r2.d(r3, r0)
                goto Lf4
            L237:
                r0 = move-exception
                com.baidu.mobads.openad.b.a r2 = com.baidu.mobads.openad.b.a.this
                com.baidu.mobads.interfaces.utils.IXAdLogger r2 = com.baidu.mobads.openad.b.a.b(r2)
                java.lang.String r3 = "OAdURLLoader"
                java.lang.String r0 = r0.getMessage()
                r2.d(r3, r0)
                goto L176
            L24a:
                r0 = move-exception
                r2 = r0
                r3 = r1
                r4 = r1
            L24e:
                if (r3 == 0) goto L253
                r3.close()     // Catch: java.lang.Throwable -> L265
            L253:
                com.baidu.mobads.openad.b.a r0 = com.baidu.mobads.openad.b.a.this
                com.baidu.mobads.interfaces.utils.IXAdURIUitls r0 = com.baidu.mobads.openad.b.a.d(r0)
                if (r0 == 0) goto L264
                com.baidu.mobads.openad.b.a r0 = com.baidu.mobads.openad.b.a.this
                com.baidu.mobads.interfaces.utils.IXAdURIUitls r0 = com.baidu.mobads.openad.b.a.d(r0)
                r0.closeHttpURLConnection(r4)
            L264:
                throw r2
            L265:
                r0 = move-exception
                com.baidu.mobads.openad.b.a r1 = com.baidu.mobads.openad.b.a.this
                com.baidu.mobads.interfaces.utils.IXAdLogger r1 = com.baidu.mobads.openad.b.a.b(r1)
                java.lang.String r3 = "OAdURLLoader"
                java.lang.String r0 = r0.getMessage()
                r1.d(r3, r0)
                goto L253
            L277:
                r0 = move-exception
                r2 = r0
                r3 = r1
                goto L24e
            L27b:
                r1 = move-exception
                r2 = r1
                r3 = r0
                goto L24e
            L27f:
                r0 = move-exception
                r2 = r0
                goto L24e
            L282:
                r2 = move-exception
                r3 = r0
                goto L110
            L286:
                r3 = move-exception
                goto Ldc
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.openad.b.a.C0266a.a():java.lang.Object");
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
    }
}
