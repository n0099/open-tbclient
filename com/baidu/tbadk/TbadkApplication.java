package com.baidu.tbadk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.android.common.util.CommonParam;
import com.baidu.bdcvf.CertVerifier;
import com.baidu.tbadk.core.b.u;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.LimitList;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.coreExtra.d.x;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.message.ResponsedPingMessage;
import com.baidu.tbadk.editortool.ac;
import com.baidu.tbadk.editortool.w;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class TbadkApplication extends com.baidu.adp.a.b {
    protected Boolean e;
    protected static TbadkApplication b = null;
    protected static boolean c = false;
    protected static String l = null;
    protected static AccountData n = null;
    protected static String o = null;
    private static Intent P = null;
    private static String V = "armcv";
    protected int a = 0;
    protected int d = 0;
    protected long f = 0;
    protected AtomicBoolean g = null;
    protected LimitList h = null;
    protected boolean i = true;
    protected int j = 0;
    protected long k = 0;
    protected String m = null;
    protected String p = null;
    protected boolean q = true;
    private int G = 3;
    private HashMap<Class<?>, Class<?>> H = new HashMap<>();
    public ArrayList<a> r = null;
    private Hashtable<String, Integer> I = null;
    public boolean s = true;
    public int t = 0;
    public boolean u = true;
    public boolean v = true;
    public boolean w = true;
    public boolean x = true;
    public int y = 0;
    public boolean z = false;
    public boolean A = true;
    public boolean B = false;
    public String C = "23:00";
    public String D = "09:00";
    private boolean J = false;
    private boolean K = true;
    private int L = 0;
    private long M = -1;
    private int N = 1;
    private int O = 0;
    private Handler Q = new Handler();
    protected boolean E = false;
    public Handler F = new Handler(new o(this));
    private ExecutorService R = null;
    private boolean S = false;
    private boolean T = false;
    private boolean U = false;
    private int W = -1;
    private int X = -1;
    private String Y = null;
    private boolean Z = false;

    public final void f() {
        this.M = System.currentTimeMillis();
    }

    public final void g() {
        this.M = -1L;
    }

    public final void h() {
        if (this.M > 0) {
            this.M = System.currentTimeMillis() - this.M;
            if (this.M > 0) {
                new ax("startup_time", String.valueOf(this.M));
            }
            com.baidu.adp.lib.util.f.a(getClass().getName(), "sendLaunchTime=", String.valueOf(this.M));
        }
        this.M = -1L;
    }

    public static void a(Intent intent) {
        P = intent;
    }

    public static Intent i() {
        return P;
    }

    public final void a(a aVar) {
        if (this.r != null) {
            int size = this.r.size();
            for (int i = 0; i < size; i++) {
                try {
                    this.r.get(i).releaseResouce();
                } catch (Exception e) {
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "addRemoteActivity", e.getMessage());
                }
            }
            if (aVar != null) {
                this.r.add(aVar);
            }
        }
    }

    public final void a(Class<?> cls, Class<?> cls2) {
        if (!this.H.containsKey(cls)) {
            this.H.put(cls, cls2);
        }
    }

    public final Class<?> a(Class<?> cls) {
        if (this.H != null) {
            return this.H.get(cls);
        }
        return null;
    }

    public final void b(a aVar) {
        if (this.r != null) {
            this.r.remove(aVar);
        }
    }

    public static TbadkApplication j() {
        return b;
    }

    @Override // com.baidu.adp.a.b, android.app.Application
    public void onCreate() {
        AccountData c2;
        String str = null;
        super.onCreate();
        b = this;
        if (!d()) {
            CertVerifier.getInstance().verify(this, new q(this));
        }
        this.h = new LimitList(50);
        this.m = b("cuid", (String) null);
        if (this.m == null || this.m.length() < 0) {
            this.m = CommonParam.getCUID(this);
            com.baidu.adp.lib.util.f.d("----cuid:" + this.m);
            a("cuid", this.m);
        }
        com.baidu.tbadk.core.data.n.a(this);
        String b2 = b("client_id", (String) null);
        if (b2 != null) {
            int indexOf = b2.indexOf("\t");
            if (indexOf == -1) {
                aK();
            } else if (com.baidu.tbadk.core.data.n.c().equals(b2.substring(0, indexOf))) {
                str = b2.substring(indexOf + 1);
            } else {
                aK();
            }
        } else {
            str = b2;
        }
        com.baidu.adp.lib.util.f.a("TiebaApplication", "readClientId", str);
        o = str;
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService("phone");
        if (telephonyManager != null) {
            this.p = telephonyManager.getDeviceId();
        }
        if (this.p == null) {
            this.p = "000000000000000";
        }
        aI();
        aM();
        s.a();
        this.W = s.a("faceshop_version", -1);
        s.a();
        this.N = s.a("new_abstract_state", 0);
        s.a();
        this.J = s.a("gpu_open", aN());
        s.a();
        this.K = s.a("permoted_message", true);
        s.a();
        this.L = s.a("webview_crash_count", 0);
        com.baidu.tbadk.coreExtra.d.m.a().c();
        com.baidu.tbadk.coreExtra.d.q.a().b();
        com.baidu.tbadk.c.c a = a(1001, (Class<? extends SocketResponsedMessage>) ResponseOnlineMessage.class, false);
        a.c(true);
        a.a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        a.b(-3);
        com.baidu.tbadk.c.c a2 = a(1003, (Class<? extends SocketResponsedMessage>) ResponsedPingMessage.class, false);
        a2.c(true);
        a2.a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        a2.b(-3);
        com.baidu.tbadk.message.websockt.c.a().a(1001);
        com.baidu.adp.framework.c.a().a(new com.baidu.tbadk.coreExtra.d.p());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("Content-Type", "application/octet-stream"));
        arrayList.add(new BasicNameValuePair("cuid", y()));
        com.baidu.adp.framework.e.c.a().a(x.a);
        com.baidu.adp.framework.e.c.a().b("im_version=2.1");
        com.baidu.adp.framework.e.c.a().a(arrayList);
        com.baidu.adp.framework.e.c.a().a(new com.baidu.tbadk.a.c());
        com.baidu.adp.framework.e.c.a().a(new com.baidu.tbadk.a.d());
        com.baidu.adp.framework.e.c.a().a(new com.baidu.tbadk.a.b());
        com.baidu.adp.framework.e.c.a().h();
        com.baidu.adp.framework.e.c.a();
        com.baidu.adp.framework.e.c.a(false, "TiebaImApplication init");
        TbFaceManager.a().a(this, new w());
        ac.a().b();
        s.a();
        this.G = s.a("font_size", 2);
        try {
            com.baidu.adp.lib.c.a.a().a(b, "tieba");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (m()) {
            try {
                registerReceiver(new com.baidu.tbadk.core.service.a(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            } catch (Exception e2) {
                com.baidu.adp.lib.util.f.b(e2.getMessage());
            }
        }
        aH();
        com.baidu.tbadk.core.frameworkData.b.a();
        if (m()) {
            try {
                if (b.getDatabasePath("baidu_tieba.db").exists() && (c2 = com.baidu.tbadk.core.a.o.c()) != null) {
                    a(c2, b);
                }
            } catch (Exception e3) {
                com.baidu.adp.lib.util.f.b(e3.getMessage());
            }
        }
        CustomMessageTask customMessageTask = new CustomMessageTask(2001001, new p(this));
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2005003, new u(b)));
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2005005, new u(b)));
    }

    public final void a(int i) {
        this.N = i;
        s.a();
        s.b("new_abstract_state", i);
    }

    public final int k() {
        return this.N;
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        e();
        super.onLowMemory();
    }

    @Override // com.baidu.adp.a.b
    public final void e() {
        int b2 = com.baidu.tbadk.imageManager.e.a().b();
        int max = (int) Math.max(b2 * 0.8d, com.baidu.tbadk.core.data.n.i());
        if (max < b2) {
            if (com.baidu.adp.lib.util.f.a()) {
                com.baidu.adp.lib.util.f.c(TbadkApplication.class.getName(), "onAppMemoryLow", "trim pic cache to size:" + max);
            }
            com.baidu.tbadk.imageManager.e.a().a(max);
        }
    }

    private static com.baidu.tbadk.c.c a(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        com.baidu.tbadk.c.c cVar = new com.baidu.tbadk.c.c(i);
        cVar.a(cls);
        cVar.b(false);
        com.baidu.adp.framework.c.a().a(cVar);
        return cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void aH() {
        boolean z;
        int i;
        AssetManager assets;
        InputStream inputStream;
        s.a();
        this.O = s.a("voice_headset_mode", 0);
        s.a();
        if (s.a("webp_failure_count", -1) == -1) {
            if (Build.VERSION.SDK_INT >= 14 && (assets = b.c().getAssets()) != null) {
                try {
                    inputStream = assets.open("webp_test/test.webp");
                } catch (IOException e) {
                    e.printStackTrace();
                    inputStream = null;
                }
                if (inputStream != null) {
                    if (BitmapFactory.decodeStream(inputStream) == null) {
                        com.baidu.adp.lib.util.f.b("Failed to decode the webp.");
                        z = false;
                    } else {
                        com.baidu.adp.lib.util.f.b("Decoded the webp.");
                        z = true;
                    }
                    if (z) {
                        com.baidu.adp.lib.util.f.d("I'm not capable of webp.");
                        i = 6;
                        this.E = false;
                    } else {
                        com.baidu.adp.lib.util.f.d("Proudly I'm capable of webp.");
                        this.E = true;
                        i = 0;
                    }
                    s.a();
                    s.b("webp_failure_count", i);
                    s.a();
                    s.b("capable_of_webp_format", this.E);
                    return;
                }
            }
            z = false;
            if (z) {
            }
            s.a();
            s.b("webp_failure_count", i);
            s.a();
            s.b("capable_of_webp_format", this.E);
            return;
        }
        s.a();
        this.E = s.a("capable_of_webp_format", false);
    }

    private void aI() {
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = getPackageManager().getApplicationInfo(getPackageName(), 128);
            com.baidu.tbadk.core.data.n.a(com.baidu.adp.lib.f.b.a(String.valueOf(applicationInfo.metaData.get("versionType")), 3));
        } catch (Exception e) {
            com.baidu.tbadk.core.data.n.a(3);
            com.baidu.adp.lib.util.f.b(getClass().getName(), "InitVersion", e.getMessage());
        }
        try {
            if (com.baidu.tbadk.core.data.n.e() == 2) {
                com.baidu.tbadk.core.data.n.a(String.valueOf(applicationInfo.metaData.get("grayVersion")));
                return;
            }
            com.baidu.tbadk.core.data.n.a(getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
            if (com.baidu.tbadk.core.data.n.e() == 1) {
                com.baidu.tbadk.core.data.n.b(String.valueOf(applicationInfo.metaData.get("subVersion")));
            }
        } catch (Exception e2) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "InitVersion", e2.getMessage());
        }
    }

    public final int l() {
        return this.a;
    }

    public final void b(int i) {
        this.a = i;
    }

    public static void a(boolean z) {
        c = true;
    }

    public final boolean m() {
        boolean z = false;
        if (this.e != null) {
            return this.e.booleanValue();
        }
        ActivityManager activityManager = (ActivityManager) getSystemService("activity");
        if (activityManager != null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            int myPid = Process.myPid();
            if (runningAppProcesses != null) {
                this.e = Boolean.TRUE;
                int i = 0;
                while (true) {
                    if (i >= runningAppProcesses.size()) {
                        break;
                    } else if (runningAppProcesses.get(i).pid != myPid) {
                        i++;
                    } else {
                        String str = runningAppProcesses.get(i).processName;
                        if (str != null && (str.equalsIgnoreCase("com.baidu.tieba:pushservice_v1") || str.equalsIgnoreCase("com.baidu.tieba:remote") || str.equalsIgnoreCase("com.baidu.tieba:bdservice_v1"))) {
                            this.e = Boolean.FALSE;
                        }
                    }
                }
            }
            z = true;
            return z;
        }
        return true;
    }

    public final void n() {
        this.d++;
        aJ();
    }

    public final void o() {
        this.d--;
        aJ();
    }

    private void aJ() {
        if (m()) {
            if (this.d < 0) {
                this.d = 0;
            }
            if (this.f == 0 && this.d > 0) {
                this.f = System.nanoTime();
            }
            com.baidu.adp.lib.util.f.a(getClass().getName(), "mResumeNum = ", String.valueOf(this.d));
            this.F.removeMessages(4);
            if (this.d == 0 && this.f > 0) {
                this.F.sendMessageDelayed(this.F.obtainMessage(4), 60000L);
            }
            this.F.removeMessages(5);
            if (this.d == 0) {
                p();
            } else if (this.g == null || this.g.get()) {
                this.F.sendMessageDelayed(this.F.obtainMessage(5, Boolean.FALSE), 1000L);
            }
        }
    }

    public final void p() {
        this.F.sendMessageDelayed(this.F.obtainMessage(5, Boolean.TRUE), 1000L);
    }

    public final boolean q() {
        if (this.g == null) {
            return true;
        }
        return this.g.get();
    }

    public final void r() {
        if (this.g == null) {
            this.g = new AtomicBoolean(false);
        }
        if (!this.g.get()) {
            this.g.set(true);
            com.baidu.adp.framework.c.a().a(new BackgroundSwitchMessage(true));
            be.a(null);
            TiebaStatic.a();
        }
    }

    public final int s() {
        return this.j;
    }

    public final void t() {
        this.j = 0;
    }

    public final void u() {
        if (this.g == null) {
            this.g = new AtomicBoolean(true);
        }
        if (this.g.get()) {
            this.g.set(false);
            this.j++;
            if (System.currentTimeMillis() - this.k > 3600000 || this.k == 0) {
                this.k = System.currentTimeMillis();
                new com.baidu.tbadk.core.util.u().start();
            }
            com.baidu.adp.framework.c.a().a(new BackgroundSwitchMessage(false));
        }
    }

    public final LimitList v() {
        return this.h;
    }

    public final void w() {
        if (this.h != null) {
            this.h.clear();
        }
    }

    public final boolean x() {
        return this.i;
    }

    public final void b(boolean z) {
        this.i = z;
    }

    public static synchronized String y() {
        String str;
        synchronized (TbadkApplication.class) {
            if (l == null) {
                String str2 = b.m;
                String packageName = b.b().getPackageName();
                l = String.valueOf(str2) + "|" + packageName + com.baidu.tbadk.core.data.n.c();
            }
            str = l;
        }
        return str;
    }

    public final String z() {
        return this.m;
    }

    private static void a(String str, String str2) {
        com.baidu.tbadk.core.sharedPref.b.a().b(str, str2);
    }

    private static String b(String str, String str2) {
        return com.baidu.tbadk.core.sharedPref.b.a().a(str, str2);
    }

    private static boolean a(String str, boolean z) {
        return com.baidu.tbadk.core.sharedPref.b.a().a(str, true);
    }

    private static int a(String str, int i) {
        return com.baidu.tbadk.core.sharedPref.b.a().a(str, 1);
    }

    private static void b(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.a().b(str, i);
    }

    public final void a(String str) {
        if (str != null && str.length() > 0) {
            synchronized (this) {
                if (n != null) {
                    n.setTbs(str);
                }
            }
        }
    }

    public static String A() {
        if (n != null) {
            return n.getTbs();
        }
        return null;
    }

    public static String B() {
        return o;
    }

    private static void aK() {
        com.baidu.tbadk.core.sharedPref.b.a().a("client_id");
    }

    public static void b(String str) {
        if (str != null && str.length() > 0) {
            com.baidu.tbadk.core.sharedPref.b.a().b("client_id", String.valueOf(com.baidu.tbadk.core.data.n.c()) + "\t" + str);
        }
    }

    public static void c(String str) {
        o = str;
    }

    public final String C() {
        return this.p;
    }

    public static String D() {
        if (n != null) {
            return n.getBDUSS();
        }
        return null;
    }

    private void r(String str) {
        if (str != null && str.length() > 0 && m()) {
            a("from_id", str);
        }
    }

    private String aL() {
        String str = null;
        try {
            File d = com.baidu.tbadk.core.util.w.d("from.dat");
            if (d == null) {
                return null;
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(d));
            str = bufferedReader.readLine();
            bufferedReader.close();
            return str;
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "getFromByFile", e.getMessage());
            TiebaStatic.a(e, "TiebaApplication.getFromByFile");
            return str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void aM() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                String b2 = b("from_id", (String) null);
                bufferedReader = new BufferedReader(new InputStreamReader(getResources().getAssets().open("channel"), "gbk"));
                try {
                    String readLine = bufferedReader.readLine();
                    com.baidu.tbadk.core.data.n.d(readLine);
                    if (b2 == null) {
                        String aL = aL();
                        if (aL != null && aL.length() > 0) {
                            com.baidu.tbadk.core.data.n.c(aL);
                            r(aL);
                        } else if (readLine != null && readLine.length() > 0) {
                            com.baidu.tbadk.core.data.n.c(readLine);
                            r(readLine);
                            if (readLine != null && readLine.length() > 0) {
                                try {
                                    File f = com.baidu.tbadk.core.util.w.f("from.dat");
                                    if (f != null) {
                                        FileWriter fileWriter = new FileWriter(f);
                                        fileWriter.append((CharSequence) readLine);
                                        fileWriter.flush();
                                        fileWriter.close();
                                    }
                                } catch (Exception e) {
                                    com.baidu.adp.lib.util.f.b(getClass().getName(), "saveFromToFile", e.getMessage());
                                    TiebaStatic.a(e, "TiebaApplication.saveFromToFile");
                                }
                            }
                        }
                    } else {
                        com.baidu.tbadk.core.data.n.c(b2);
                    }
                    try {
                        bufferedReader.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Exception e3) {
                    e = e3;
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "InitFrom", e.getMessage());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    com.baidu.adp.lib.util.f.a(getClass().getName(), "InitFrom", "from = " + com.baidu.tbadk.core.data.n.j());
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
        com.baidu.adp.lib.util.f.a(getClass().getName(), "InitFrom", "from = " + com.baidu.tbadk.core.data.n.j());
    }

    public static String E() {
        if (n != null) {
            return n.getID();
        }
        return null;
    }

    public static boolean F() {
        String E = E();
        return E != null && E.length() > 0;
    }

    public final boolean G() {
        return this.q;
    }

    public final int H() {
        return a("networkcore_type", 1);
    }

    public final void c(int i) {
        ap.a(i);
        b("networkcore_type", i);
    }

    public static String I() {
        return com.baidu.tbadk.core.data.n.j();
    }

    public static void J() {
        com.baidu.tbadk.core.sharedPref.b.a().a("account_share");
    }

    public final String K() {
        return b("account_share", (String) null);
    }

    public final void d(String str) {
        a("account_share", str);
    }

    public final int L() {
        return this.G;
    }

    public final void d(int i) {
        if (this.G != i) {
            this.G = i;
            s.a();
            s.b("font_size", i);
        }
    }

    public static void a(AccountData accountData, Context context) {
        String str;
        String str2 = null;
        boolean z = false;
        if (accountData == null && n != null) {
            z = true;
        } else if (n == null && accountData != null) {
            z = true;
        } else if (n != null && accountData != null && !TextUtils.equals(n.getAccount(), accountData.getAccount())) {
            z = true;
        }
        n = accountData;
        if (context != null) {
            TbadkApplication tbadkApplication = b;
            if (a("push_service", true)) {
                UtilHelper.a(context);
            } else {
                UtilHelper.b(context);
            }
            TbadkApplication tbadkApplication2 = b;
            if (a("moplus_service", true)) {
                UtilHelper.c(context);
            }
        }
        if (accountData != null) {
            str2 = accountData.getID();
            str = accountData.getAccount();
        } else {
            str = null;
        }
        Intent intent = new Intent();
        intent.setAction("adp.bdstatisticsmanager2.account_changed");
        intent.putExtra("intent_data_userid", str2);
        intent.putExtra("intent_data_username", str);
        intent.putExtra("intent_data_bduss", D());
        b.b().sendStickyBroadcast(intent);
        if (z && accountData != null) {
            TbadkApplication tbadkApplication3 = b;
            TbadkApplication tbadkApplication4 = b;
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2005006));
        }
    }

    public static void M() {
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2005007));
    }

    public final void c(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.a().b("push_service", z);
    }

    public static AccountData N() {
        return n;
    }

    public static String O() {
        if (n != null) {
            return n.getAccount();
        }
        return null;
    }

    public final int P() {
        return a("keepalive_wifi", 1);
    }

    public final void e(int i) {
        b("keepalive_wifi", i);
    }

    public final int Q() {
        return a("keepalive_nonwifi", 1);
    }

    public final void f(int i) {
        b("keepalive_nonwifi", i);
    }

    public final void e(String str) {
        a("push_channel_id", str);
    }

    public final String R() {
        return b("push_channel_userId", "");
    }

    public final void f(String str) {
        a("push_channel_userId", str);
    }

    public final String S() {
        return b("push_channel_id", "");
    }

    public final boolean T() {
        if (com.baidu.tbadk.core.util.x.a("/package.cur/" + com.baidu.tbadk.core.data.n.c())) {
            return false;
        }
        g(com.baidu.tbadk.core.util.x.d("/package.cur"));
        return true;
    }

    public static void U() {
        com.baidu.tbadk.core.util.x.c("/package.cur");
        com.baidu.tbadk.core.util.x.b("/package.cur/" + com.baidu.tbadk.core.data.n.c());
    }

    public static void g(String str) {
        if (!bc.c(str) && !"null".equals(str)) {
            com.baidu.tbadk.core.util.x.c("/package.last");
            com.baidu.tbadk.core.util.x.b("/package.last/" + str);
        }
    }

    public static void h(String str) {
        com.baidu.tbadk.core.data.n.c(str);
    }

    public final void a(int i, int i2, String str) {
        if (this.R == null) {
            this.R = Executors.newSingleThreadExecutor();
        }
        com.baidu.adp.lib.util.f.a(getClass().getName(), "pv_addImagePv", "img_num=" + i + " img_total" + i2);
        com.baidu.tbadk.d.b bVar = new com.baidu.tbadk.d.b(i, i2);
        bVar.a(str);
        this.R.execute(bVar);
    }

    public final boolean V() {
        return this.O == 1;
    }

    public final void d(boolean z) {
        int i = z ? 1 : 0;
        if (this.O != i) {
            this.O = i;
            s.a();
            s.b("voice_headset_mode", i);
        }
    }

    public static void i(String str) {
        s.a();
        s.a("location_lat", str);
    }

    public static String W() {
        s.a();
        return s.b("location_lat", "");
    }

    public static void j(String str) {
        s.a();
        s.a("location_lng", str);
    }

    public static boolean X() {
        s.a();
        return s.a("location_shared", false);
    }

    public static void e(boolean z) {
        s.a();
        s.b("location_shared", z);
    }

    public static String Y() {
        s.a();
        return s.b("location_lng", "");
    }

    public static void k(String str) {
        s.a();
        s.a("location_pos", str);
    }

    public static int[] Z() {
        int[] iArr = new int[0];
        try {
            s.a();
            String b2 = s.b("socket_heartbeat_strategy", "");
            if (b2 != null && !TextUtils.isEmpty(b2)) {
                String[] split = b2.split(",");
                iArr = new int[split.length];
                for (int i = 0; i < split.length; i++) {
                    iArr[i] = Integer.valueOf(split[i]).intValue();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iArr;
    }

    public static int[] aa() {
        int[] iArr = new int[0];
        try {
            s.a();
            String b2 = s.b("socket_getmsg_strategy", "");
            if (b2 != null && !TextUtils.isEmpty(b2)) {
                String[] split = b2.split(",");
                iArr = new int[split.length];
                for (int i = 0; i < split.length; i++) {
                    iArr[i] = Integer.valueOf(split[i]).intValue();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iArr;
    }

    public static int[] ab() {
        String[] split;
        s.a();
        String b2 = s.b("socket_time_out", (String) null);
        if (b2 == null || (split = b2.split("\\|")) == null || split.length != 3) {
            return null;
        }
        int[] iArr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            iArr[i] = 0;
            try {
                iArr[i] = Integer.valueOf(split[i]).intValue();
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(e.getMessage());
            }
        }
        return iArr;
    }

    public final boolean ac() {
        return this.S;
    }

    public final boolean ad() {
        return this.T;
    }

    public final void f(boolean z) {
        this.S = z;
    }

    public final void g(boolean z) {
        this.T = z;
    }

    public final boolean ae() {
        return this.U;
    }

    public final void h(boolean z) {
        this.U = z;
        this.Q.post(new r(this, z));
    }

    public static boolean af() {
        s.a();
        return s.a("group_notify", true);
    }

    public final boolean ag() {
        return this.s;
    }

    public static void i(boolean z) {
        s.a();
        s.b("group_notify", z);
    }

    public static void l(String str) {
        V = str;
    }

    public static String ah() {
        return V;
    }

    public final boolean m(String str) {
        return (this.I == null || str == null || !this.I.containsKey(str)) ? false : true;
    }

    public final void n(String str) {
        if (!m(str) && this.I != null && str != null) {
            this.I.put(str, 1);
            new com.baidu.tbadk.coreExtra.c.a(1, str).start();
        }
    }

    public final void o(String str) {
        if (m(str) && this.I != null && str != null) {
            this.I.remove(str);
            new com.baidu.tbadk.coreExtra.c.a(2, str).start();
        }
    }

    public final int ai() {
        return this.t;
    }

    public final boolean aj() {
        return this.v;
    }

    public final boolean ak() {
        return this.w;
    }

    public final boolean al() {
        return this.x;
    }

    public final boolean am() {
        return this.u;
    }

    public final int an() {
        return this.y;
    }

    public final void ao() {
        this.I = new Hashtable<>();
        new com.baidu.tbadk.coreExtra.c.a(this.I).start();
    }

    public final int ap() {
        return this.W;
    }

    public final void g(int i) {
        this.W = i;
        s.a();
        s.b("faceshop_version", this.W);
    }

    public final void h(int i) {
        this.X = i;
    }

    public final boolean aq() {
        return this.z;
    }

    public final boolean ar() {
        return this.A;
    }

    public final boolean as() {
        return this.B;
    }

    public final String at() {
        return this.C;
    }

    public final String au() {
        return this.D;
    }

    public final int av() {
        return this.X;
    }

    public final boolean aw() {
        return this.E;
    }

    public final void ax() {
        s.a();
        int a = s.a("webp_failure_count", 0) + 1;
        if (a > 5) {
            this.E = false;
            s.a();
            s.b("capable_of_webp_format", false);
            return;
        }
        s.a();
        s.b("webp_failure_count", a);
    }

    public static void p(String str) {
        s.a();
        s.a("install_other_app_file_name", str);
    }

    public static String ay() {
        s.a();
        return s.b("install_other_app_file_name", (String) null);
    }

    public final void j(boolean z) {
        s.a();
        s.b("gpu_open", z);
        this.J = z;
    }

    public final boolean az() {
        return this.J;
    }

    private static boolean aN() {
        boolean z = false;
        String trim = Build.MODEL.trim();
        if (trim == null) {
            return true;
        }
        String[] strArr = {"M040", "M032", "M031", "M030", "HUAWEI C8813", "ZTE U970", "MediaPad 10 FHD", "GT-I9000", "DOEASY E930", "H8205", "GT-N7108", "GT-N7102", "GT-N719", "GT-N7100", "galaxy nexus", " ZTE U808", "UMI_X1", "nexus s", "AMOI N820", "JY-G", "XT885", "U701T", "Lenovo A750", "ZTE U807", "vivo S11t", "Droid Bionic", "MORAL_N01", "XT910", "GT-S7562", "Lenovo A798t", "vivo E5", "U705T", "HUAWEI T8951", "ME865", "HUAWEI P1XL", "KPT A9PLUS", "vivo Y11", "T9200", "XT928", "HUAWEI Y500-T00", "BBK Y3t", "Lenovo K860", "vivo X1", "HUAWEI T8833", "Lenovo A789", "ZTE U960E"};
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i < length) {
                if (strArr[i].equalsIgnoreCase(trim)) {
                    break;
                }
                i++;
            } else {
                z = true;
                break;
            }
        }
        if (com.baidu.adp.lib.util.f.a()) {
            com.baidu.adp.lib.util.f.d("device:[" + trim + "], default GPU on:" + z);
        }
        return z;
    }

    public static void a(long j) {
        s.a();
        s.b("update_notify_time", j);
    }

    public static long aA() {
        s.a();
        return s.a("update_notify_time", 0L);
    }

    public static boolean aB() {
        if (b.Z) {
            TbadkApplication tbadkApplication = b;
            Long valueOf = Long.valueOf(aA());
            Long valueOf2 = Long.valueOf(new Date().getTime());
            TbadkApplication tbadkApplication2 = b;
            a(valueOf2.longValue());
            return valueOf2.longValue() - valueOf.longValue() > 86400000;
        }
        return false;
    }

    public final void q(String str) {
        this.Y = str;
    }

    public final String aC() {
        return this.Y;
    }

    public final void k(boolean z) {
        this.Z = z;
        b.sendBroadcast(new Intent(com.baidu.tbadk.core.data.n.z()));
    }

    public static long aD() {
        s.a();
        return s.a("last_notify_sound_time", 0L);
    }

    public static void b(long j) {
        s.a();
        s.b("last_notify_sound_time", j);
    }

    public final void l(boolean z) {
        this.K = z;
        s.a();
        s.b("permoted_message", z);
    }

    public final boolean aE() {
        return this.K;
    }

    public final int aF() {
        return this.L;
    }

    public final void i(int i) {
        this.L = i;
        s.a();
        s.b("webview_crash_count", i);
    }

    public static boolean aG() {
        return b.t > 0;
    }
}
