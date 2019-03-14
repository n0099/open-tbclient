package cn.jiguang.d.c;

import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.constants.MeizuConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes3.dex */
public class o {
    private static o lY;
    private String[] a = null;
    private j[] lX = null;
    private int c = -1;

    static {
        o oVar = new o();
        synchronized (o.class) {
            lY = oVar;
        }
    }

    public o() {
        if (c() || d()) {
            return;
        }
        if (this.a == null || this.lX == null) {
            String property = System.getProperty("os.name");
            String property2 = System.getProperty("java.vendor");
            if (property.indexOf("Windows") == -1) {
                if (property.indexOf("NetWare") != -1) {
                    b("sys:/etc/resolv.cfg");
                } else if (property2.indexOf("Android") != -1) {
                    e();
                } else {
                    b("/etc/resolv.conf");
                }
            } else if (property.indexOf("95") == -1 && property.indexOf("98") == -1 && property.indexOf("ME") == -1) {
                try {
                    Process exec = Runtime.getRuntime().exec("ipconfig /all");
                    a(exec.getInputStream());
                    exec.destroy();
                } catch (Exception e) {
                }
            } else {
                try {
                    Runtime.getRuntime().exec("winipcfg /all /batch winipcfg.out").waitFor();
                    a(new FileInputStream(new File("winipcfg.out")));
                    new File("winipcfg.out").delete();
                } catch (Exception e2) {
                }
            }
        }
    }

    private static int a(String str) {
        int parseInt;
        try {
            parseInt = Integer.parseInt(str.substring(6));
        } catch (NumberFormatException e) {
        }
        if (parseInt >= 0) {
            return parseInt;
        }
        return -1;
    }

    private void a(InputStream inputStream) {
        int intValue = Integer.getInteger("org.xbill.DNS.windows.parse.buffer", 8192).intValue();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, intValue);
        bufferedInputStream.mark(intValue);
        a(bufferedInputStream, (Locale) null);
        if (this.a == null) {
            try {
                bufferedInputStream.reset();
                a(bufferedInputStream, new Locale("", ""));
            } catch (IOException e) {
            }
        }
    }

    private void a(InputStream inputStream, Locale locale) {
        boolean z;
        boolean z2;
        String str = o.class.getPackage().getName() + ".windows.DNSServer";
        ResourceBundle bundle = locale != null ? ResourceBundle.getBundle(str, locale) : ResourceBundle.getBundle(str);
        String string = bundle.getString("host_name");
        String string2 = bundle.getString("primary_dns_suffix");
        String string3 = bundle.getString("dns_suffix");
        String string4 = bundle.getString("dns_servers");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            boolean z3 = false;
            boolean z4 = false;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    a(arrayList, arrayList2);
                    return;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                if (stringTokenizer.hasMoreTokens()) {
                    String nextToken = stringTokenizer.nextToken();
                    if (readLine.indexOf(Config.TRACE_TODAY_VISIT_SPLIT) != -1) {
                        z = false;
                        z2 = false;
                    } else {
                        boolean z5 = z4;
                        z = z3;
                        z2 = z5;
                    }
                    if (readLine.indexOf(string) != -1) {
                        while (stringTokenizer.hasMoreTokens()) {
                            nextToken = stringTokenizer.nextToken();
                        }
                        try {
                            if (j.a(nextToken, (j) null).b() != 1) {
                                c(nextToken, arrayList2);
                                boolean z6 = z2;
                                z3 = z;
                                z4 = z6;
                            }
                        } catch (s e) {
                            boolean z7 = z2;
                            z3 = z;
                            z4 = z7;
                        }
                    } else if (readLine.indexOf(string2) != -1) {
                        while (stringTokenizer.hasMoreTokens()) {
                            nextToken = stringTokenizer.nextToken();
                        }
                        if (!nextToken.equals(Config.TRACE_TODAY_VISIT_SPLIT)) {
                            c(nextToken, arrayList2);
                            z3 = z;
                            z4 = true;
                        }
                    } else if (z2 || readLine.indexOf(string3) != -1) {
                        while (stringTokenizer.hasMoreTokens()) {
                            nextToken = stringTokenizer.nextToken();
                        }
                        if (!nextToken.equals(Config.TRACE_TODAY_VISIT_SPLIT)) {
                            c(nextToken, arrayList2);
                            z3 = z;
                            z4 = true;
                        }
                    } else {
                        if (z || readLine.indexOf(string4) != -1) {
                            while (stringTokenizer.hasMoreTokens()) {
                                nextToken = stringTokenizer.nextToken();
                            }
                            if (!nextToken.equals(Config.TRACE_TODAY_VISIT_SPLIT)) {
                                a(nextToken, arrayList);
                                z = true;
                            }
                        }
                        boolean z8 = z2;
                        z3 = z;
                        z4 = z8;
                    }
                    boolean z9 = z2;
                    z3 = z;
                    z4 = z9;
                } else {
                    z3 = false;
                    z4 = false;
                }
            }
        } catch (IOException e2) {
        }
    }

    private static void a(String str, List list) {
        if (list.contains(str)) {
            return;
        }
        list.add(str);
    }

    private void a(List list, List list2) {
        if (this.a == null && list.size() > 0) {
            this.a = (String[]) list.toArray(new String[0]);
        }
        if (this.lX != null || list2.size() <= 0) {
            return;
        }
        this.lX = (j[]) list2.toArray(new j[0]);
    }

    private void b(String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
            ArrayList arrayList = new ArrayList(0);
            ArrayList arrayList2 = new ArrayList(0);
            int i = -1;
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (readLine.startsWith("nameserver")) {
                        StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                        stringTokenizer.nextToken();
                        a(stringTokenizer.nextToken(), arrayList);
                    } else if (readLine.startsWith(ClientCookie.DOMAIN_ATTR)) {
                        StringTokenizer stringTokenizer2 = new StringTokenizer(readLine);
                        stringTokenizer2.nextToken();
                        if (stringTokenizer2.hasMoreTokens() && arrayList2.isEmpty()) {
                            c(stringTokenizer2.nextToken(), arrayList2);
                        }
                    } else if (readLine.startsWith("search")) {
                        if (!arrayList2.isEmpty()) {
                            arrayList2.clear();
                        }
                        StringTokenizer stringTokenizer3 = new StringTokenizer(readLine);
                        stringTokenizer3.nextToken();
                        while (stringTokenizer3.hasMoreTokens()) {
                            c(stringTokenizer3.nextToken(), arrayList2);
                        }
                    } else if (readLine.startsWith("options")) {
                        StringTokenizer stringTokenizer4 = new StringTokenizer(readLine);
                        stringTokenizer4.nextToken();
                        while (stringTokenizer4.hasMoreTokens()) {
                            String nextToken = stringTokenizer4.nextToken();
                            if (nextToken.startsWith("ndots:")) {
                                i = a(nextToken);
                            }
                        }
                    }
                } catch (IOException e) {
                }
            }
            bufferedReader.close();
            a(arrayList, arrayList2);
            if (this.c >= 0 || i <= 0) {
                return;
            }
            this.c = i;
        } catch (FileNotFoundException e2) {
        }
    }

    public static synchronized o bS() {
        o oVar;
        synchronized (o.class) {
            oVar = lY;
        }
        return oVar;
    }

    private static void c(String str, List list) {
        try {
            j a = j.a(str, j.a);
            if (list.contains(a)) {
                return;
            }
            list.add(a);
        } catch (s e) {
        }
    }

    private boolean c() {
        ArrayList arrayList = new ArrayList(0);
        ArrayList arrayList2 = new ArrayList(0);
        String property = System.getProperty("dns.server");
        if (property != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(property, Constants.ACCEPT_TIME_SEPARATOR_SP);
            while (stringTokenizer.hasMoreTokens()) {
                a(stringTokenizer.nextToken(), arrayList);
            }
        }
        String property2 = System.getProperty("dns.search");
        if (property2 != null) {
            StringTokenizer stringTokenizer2 = new StringTokenizer(property2, Constants.ACCEPT_TIME_SEPARATOR_SP);
            while (stringTokenizer2.hasMoreTokens()) {
                c(stringTokenizer2.nextToken(), arrayList2);
            }
        }
        a(arrayList, arrayList2);
        return (this.a == null || this.lX == null) ? false : true;
    }

    private boolean d() {
        ArrayList arrayList = new ArrayList(0);
        ArrayList arrayList2 = new ArrayList(0);
        try {
            Class<?>[] clsArr = new Class[0];
            Object[] objArr = new Object[0];
            Class<?> cls = Class.forName("sun.net.dns.ResolverConfiguration");
            Object invoke = cls.getDeclaredMethod("open", clsArr).invoke(null, objArr);
            List<String> list = (List) cls.getMethod("nameservers", clsArr).invoke(invoke, objArr);
            List<String> list2 = (List) cls.getMethod("searchlist", clsArr).invoke(invoke, objArr);
            if (list.size() == 0) {
                return false;
            }
            if (list.size() > 0) {
                for (String str : list) {
                    a(str, arrayList);
                }
            }
            if (list2.size() > 0) {
                for (String str2 : list2) {
                    c(str2, arrayList2);
                }
            }
            a(arrayList, arrayList2);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void e() {
        ArrayList arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        try {
            Method method = Class.forName(MeizuConstants.CLS_NAME_SYSTEM_PROPERTIES).getMethod("get", String.class);
            String[] strArr = {"net.dns1", "net.dns2", "net.dns3", "net.dns4"};
            for (int i = 0; i < 4; i++) {
                String str = (String) method.invoke(null, strArr[i]);
                if (str != null && ((str.matches("^\\d+(\\.\\d+){3}$") || str.matches("^[0-9a-f]+(:[0-9a-f]*)+:[0-9a-f]+$")) && !arrayList.contains(str))) {
                    arrayList.add(str);
                }
            }
        } catch (Exception e) {
        }
        a(arrayList, arrayList2);
    }

    public final String[] a() {
        return this.a;
    }
}
