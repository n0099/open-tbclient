package c.a.d.i.g;

import android.app.ActivityManager;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.g;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.d.i.k.e;
import c.a.d.i.k.f;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.util.Util;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.util.devices.IDevices;
import com.baidu.nps.utils.Constant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kuaishou.weapon.un.w0;
import dalvik.system.DexClassLoader;
import io.flutter.embedding.android.FlutterActivityAndFragmentDelegate;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, Boolean> f2777b;

    /* renamed from: c  reason: collision with root package name */
    public static String f2778c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f2779d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f2780e;

    /* renamed from: f  reason: collision with root package name */
    public static Signature[] f2781f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-416869802, "Lc/a/d/i/g/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-416869802, "Lc/a/d/i/g/d;");
                return;
            }
        }
        f2777b = new HashMap();
        f2778c = null;
        f2779d = false;
        f2780e = false;
        f2781f = null;
    }

    public static boolean a(File file, String str, byte[] bArr) {
        InterceptResult invokeLLL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, file, str, bArr)) == null) {
            if (file == null || !file.exists() || file.length() <= 0) {
                return false;
            }
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                e = e2;
            }
            try {
                String u = Util.u(fileInputStream, bArr);
                boolean equalsIgnoreCase = u.equalsIgnoreCase(str);
                c.a.d.i.h.a.b().m("plugin_install", "install_chack_md5", "", "result_" + equalsIgnoreCase + "-tempMd5_" + u + "-check_" + str + "-size_" + file.length() + "-file_" + file.getAbsolutePath());
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                    BdLog.d(e3.getMessage());
                }
                return equalsIgnoreCase;
            } catch (Exception e4) {
                e = e4;
                fileInputStream2 = fileInputStream;
                BdLog.d(e.getMessage());
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e5) {
                        BdLog.d(e5.getMessage());
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e6) {
                        BdLog.d(e6.getMessage());
                    }
                }
                throw th;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static boolean b(ArrayList<ZipEntry> arrayList, ZipEntry zipEntry) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, arrayList, zipEntry)) == null) {
            if (arrayList != null && zipEntry != null) {
                String name = zipEntry.getName();
                if (TextUtils.isEmpty(name)) {
                    return false;
                }
                String substring = name.substring(name.lastIndexOf("/"));
                Iterator<ZipEntry> it = arrayList.iterator();
                while (it.hasNext()) {
                    ZipEntry next = it.next();
                    if (!TextUtils.isEmpty(next.getName()) && next.getName().endsWith(substring)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0196: MOVE  (r4 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:112:0x0194 */
    public static final boolean c(ZipFile zipFile, File file, File file2, String str) {
        InterceptResult invokeLLLL;
        FileOutputStream fileOutputStream;
        ZipOutputStream zipOutputStream;
        FileOutputStream fileOutputStream2;
        ZipOutputStream zipOutputStream2;
        Throwable th;
        ZipOutputStream zipOutputStream3;
        FileOutputStream fileOutputStream3;
        InputStream inputStream;
        BufferedInputStream bufferedInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLL = interceptable.invokeLLLL(65539, null, zipFile, file, file2, str)) != null) {
            return invokeLLLL.booleanValue;
        }
        InputStream inputStream2 = null;
        try {
            try {
                file.mkdirs();
                g.m(file);
                file2.createNewFile();
                fileOutputStream2 = new FileOutputStream(file2);
            } catch (Throwable th2) {
                th = th2;
                zipOutputStream3 = null;
                fileOutputStream = fileOutputStream3;
                n.f(zipOutputStream3);
                n.f(fileOutputStream);
                try {
                    g.m(file);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                throw th;
            }
        } catch (ZipException e3) {
            e = e3;
            zipOutputStream2 = null;
            fileOutputStream2 = null;
        } catch (IOException e4) {
            e = e4;
            zipOutputStream = null;
            fileOutputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
        try {
            zipOutputStream3 = new ZipOutputStream(fileOutputStream2);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    try {
                        String name = nextElement.getName();
                        if (name.startsWith(PluginInstallerService.APK_LIB_DIR_PREFIX)) {
                            n.e(inputStream2);
                            n.e(inputStream2);
                        } else {
                            InputStream inputStream3 = zipFile.getInputStream(nextElement);
                            try {
                            } catch (IOException e5) {
                                e = e5;
                            } catch (Throwable th4) {
                                th = th4;
                            }
                            try {
                                File file3 = new File(file, name);
                                file3.getParentFile().mkdirs();
                                Util.b(inputStream3, file3);
                                byte[] bArr = new byte[4096];
                                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file3), 4096);
                                try {
                                    ZipEntry zipEntry = new ZipEntry(file3.getAbsolutePath().substring(file.getAbsolutePath().length() + 1));
                                    if (zipEntry.getName().equals("resources.arsc")) {
                                        zipEntry.setMethod(0);
                                        zipEntry.setSize(file3.length());
                                        zipEntry.setCompressedSize(zipEntry.getSize());
                                        zipEntry.setCrc(nextElement.getCrc());
                                    }
                                    zipOutputStream3.putNextEntry(zipEntry);
                                    while (true) {
                                        int read = bufferedInputStream2.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        zipOutputStream3.write(bArr, 0, read);
                                    }
                                    bufferedInputStream2.close();
                                    zipOutputStream3.flush();
                                    zipOutputStream3.closeEntry();
                                    try {
                                        n.e(inputStream3);
                                        n.e(bufferedInputStream2);
                                        inputStream2 = null;
                                    } catch (ZipException e6) {
                                        e = e6;
                                        zipOutputStream2 = zipOutputStream3;
                                        c.a.d.i.h.a.b().m("plugin_install", "delete_so", str, e.getMessage());
                                        n.f(zipOutputStream2);
                                        n.f(fileOutputStream2);
                                        try {
                                            g.m(file);
                                            return false;
                                        } catch (IOException e7) {
                                            e7.printStackTrace();
                                            return false;
                                        }
                                    } catch (IOException e8) {
                                        e = e8;
                                        zipOutputStream = zipOutputStream3;
                                        c.a.d.i.h.a.b().m("plugin_install", "delete_so", str, e.getMessage());
                                        n.f(zipOutputStream);
                                        n.f(fileOutputStream2);
                                        try {
                                            g.m(file);
                                            return false;
                                        } catch (IOException e9) {
                                            e9.printStackTrace();
                                            return false;
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        fileOutputStream = fileOutputStream2;
                                        try {
                                            c.a.d.i.h.a.b().m("plugin_install", "delete_so", str, th.getMessage());
                                            n.f(zipOutputStream3);
                                            n.f(fileOutputStream);
                                            try {
                                                g.m(file);
                                                return false;
                                            } catch (IOException e10) {
                                                e10.printStackTrace();
                                                return false;
                                            }
                                        } catch (Throwable th6) {
                                            th = th6;
                                            n.f(zipOutputStream3);
                                            n.f(fileOutputStream);
                                            g.m(file);
                                            throw th;
                                        }
                                    }
                                } catch (IOException e11) {
                                    e = e11;
                                    bufferedInputStream = bufferedInputStream2;
                                    inputStream = inputStream3;
                                    try {
                                        throw e;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        n.e(inputStream);
                                        n.e(bufferedInputStream);
                                        throw th;
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                    bufferedInputStream = bufferedInputStream2;
                                    inputStream = inputStream3;
                                    n.e(inputStream);
                                    n.e(bufferedInputStream);
                                    throw th;
                                }
                            } catch (IOException e12) {
                                e = e12;
                                inputStream = inputStream3;
                                bufferedInputStream = null;
                                throw e;
                            } catch (Throwable th9) {
                                th = th9;
                                inputStream = inputStream3;
                                bufferedInputStream = null;
                                n.e(inputStream);
                                n.e(bufferedInputStream);
                                throw th;
                            }
                        }
                    } catch (IOException e13) {
                        e = e13;
                        inputStream = null;
                    } catch (Throwable th10) {
                        th = th10;
                        inputStream = null;
                    }
                }
                n.f(zipOutputStream3);
                n.f(fileOutputStream2);
                try {
                    g.m(file);
                } catch (IOException e14) {
                    e14.printStackTrace();
                }
                return true;
            } catch (ZipException e15) {
                e = e15;
            } catch (IOException e16) {
                e = e16;
            } catch (Throwable th11) {
                th = th11;
            }
        } catch (ZipException e17) {
            e = e17;
            zipOutputStream2 = null;
        } catch (IOException e18) {
            e = e18;
            zipOutputStream = null;
        } catch (Throwable th12) {
            th = th12;
            fileOutputStream = fileOutputStream2;
            zipOutputStream3 = null;
            c.a.d.i.h.a.b().m("plugin_install", "delete_so", str, th.getMessage());
            n.f(zipOutputStream3);
            n.f(fileOutputStream);
            g.m(file);
            return false;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:177:0x0408 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:336:0x03ad */
    /* JADX WARN: Can't wrap try/catch for region: R(21:17|18|(1:235)(2:22|(4:(1:233)(1:27)|(5:29|30|31|32|33)|38|(15:121|(2:123|(2:125|126))(1:232)|127|(3:129|130|(3:132|133|(2:135|(2:140|141)(1:139))(2:142|143))(5:155|156|157|158|(6:160|161|162|163|164|165)(1:175)))|187|188|189|190|191|192|193|194|195|(2:197|(1:(1:223)(5:199|(2:203|(2:207|(3:218|219|220)(1:212)))|221|222|220)))(0)|224)(8:42|(15:44|45|46|47|48|49|50|51|52|53|54|56|57|(1:59)(4:89|90|91|92)|60)(1:120)|62|63|64|(1:85)(3:68|(4:71|(3:76|77|78)|79|69)|82)|83|84)))|234|38|(1:40)|121|(0)(0)|127|(0)|187|188|189|190|191|192|193|194|195|(0)(0)|224) */
    /* JADX WARN: Can't wrap try/catch for region: R(6:9|(1:377)(2:13|(2:15|(21:17|18|(1:235)(2:22|(4:(1:233)(1:27)|(5:29|30|31|32|33)|38|(15:121|(2:123|(2:125|126))(1:232)|127|(3:129|130|(3:132|133|(2:135|(2:140|141)(1:139))(2:142|143))(5:155|156|157|158|(6:160|161|162|163|164|165)(1:175)))|187|188|189|190|191|192|193|194|195|(2:197|(1:(1:223)(5:199|(2:203|(2:207|(3:218|219|220)(1:212)))|221|222|220)))(0)|224)(8:42|(15:44|45|46|47|48|49|50|51|52|53|54|56|57|(1:59)(4:89|90|91|92)|60)(1:120)|62|63|64|(1:85)(3:68|(4:71|(3:76|77|78)|79|69)|82)|83|84)))|234|38|(1:40)|121|(0)(0)|127|(0)|187|188|189|190|191|192|193|194|195|(0)(0)|224)))|236|237|238|(5:363|364|365|366|367)(11:240|241|242|243|244|245|(2:247|(7:249|(8:253|(1:348)(2:257|(8:261|262|263|264|(2:266|(1:270))(2:274|(2:276|(2:280|281))(2:284|(3:286|(1:292)(1:290)|291)(6:293|294|295|296|(2:298|(2:302|303))(2:306|(2:308|(3:312|313|315))(2:319|(2:325|326)))|273)))|271|272|273))|347|271|272|273|250|251)|349|350|351|334|(4:337|338|339|340)(22:336|18|(1:20)|235|234|38|(0)|121|(0)(0)|127|(0)|187|188|189|190|191|192|193|194|195|(0)(0)|224)))|356|351|334|(0)(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0275, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0277, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0278, code lost:
        r21 = "_";
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x027a, code lost:
        r32 = "has_res";
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x0672, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x0673, code lost:
        com.baidu.adp.lib.util.BdLog.e(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x0682, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x0683, code lost:
        com.baidu.adp.lib.util.BdLog.e(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x0786, code lost:
        c.a.d.i.h.a.b().i("plugin_repeat_install", r5);
        r0 = new java.lang.StringBuilder();
        r6 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x0796, code lost:
        if (r41 == null) goto L216;
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x0798, code lost:
        r0.append(r6);
        r0.append(r41.apkPath);
        r0.append(r6);
        r0.append(r41.versionCode);
        r0.append(r6);
        r0.append(r41.tempVersionCode);
        r0.append(r6);
        r0.append(r41.enable);
        r0.append(r6);
        r0.append(r41.install_fail_count);
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x07c0, code lost:
        c.a.d.i.h.a.b().m(r37, "plugin_repeat_install", r5, r3.getAbsolutePath() + r6 + r14.getAbsolutePath() + r0.toString());
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0492  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0566  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x05a4  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x05ea  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0751 A[Catch: all -> 0x0800, TryCatch #20 {all -> 0x0800, blocks: (B:276:0x0747, B:278:0x0751, B:280:0x0755, B:282:0x0759, B:284:0x075f, B:286:0x0769, B:288:0x076f, B:290:0x0777, B:293:0x0786, B:295:0x0798, B:296:0x07c0), top: B:364:0x0747 }] */
    /* JADX WARN: Removed duplicated region for block: B:362:0x029f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v20, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d(File file, File file2, String str, String str2, PluginSetting pluginSetting) {
        InterceptResult invokeLLLLL;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String str8;
        boolean z5;
        String str9;
        String str10;
        String str11;
        int i2;
        String str12;
        boolean z6;
        InputStream inputStream;
        boolean z7;
        boolean z8;
        boolean z9;
        String str13;
        String str14;
        String str15;
        int i3;
        String attribute;
        NodeList elementsByTagName;
        int i4;
        NodeList nodeList;
        NamedNodeMap attributes;
        Node namedItem;
        boolean z10;
        boolean z11;
        String str16;
        File file3;
        String str17;
        File file4;
        File[] listFiles;
        String str18;
        String str19;
        int e2;
        ?? r10;
        String str20;
        FileInputStream fileInputStream;
        int i5;
        int i6;
        String str21;
        String str22;
        String str23;
        String str24;
        ActivityManager activityManager;
        String str25;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        InputStream inputStream2;
        InputStream inputStream3;
        InputStream inputStream4;
        f t;
        f t2;
        Util.a q;
        byte[] bArr;
        boolean z12;
        ApplicationInfo applicationInfo;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLLL = interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, file, file2, str, str2, pluginSetting)) != null) {
            return (String) invokeLLLLL.objValue;
        }
        if (file2 != null && file2.exists() && file2.length() > 0) {
            long length = file2.length();
            PackageInfo packageArchiveInfo = BdBaseApplication.getInst().getPackageManager().getPackageArchiveInfo(file2.getAbsolutePath(), 128);
            String str26 = "has_res";
            if (packageArchiveInfo == null || (applicationInfo = packageArchiveInfo.applicationInfo) == null) {
                str3 = "copy_todest_fail";
            } else {
                str3 = "copy_todest_fail";
                String str27 = packageArchiveInfo.packageName;
                if (str27 != null) {
                    str4 = str27;
                    if (packageArchiveInfo.versionCode != 0) {
                        String k2 = Util.k(applicationInfo);
                        boolean l = Util.l(packageArchiveInfo.applicationInfo);
                        boolean r = Util.r(packageArchiveInfo.applicationInfo);
                        String d2 = Util.d(packageArchiveInfo.applicationInfo);
                        boolean n = Util.n(packageArchiveInfo.applicationInfo);
                        boolean o = Util.o(packageArchiveInfo.applicationInfo);
                        String j2 = Util.j(packageArchiveInfo.applicationInfo);
                        String str28 = packageArchiveInfo.versionName;
                        i3 = packageArchiveInfo.versionCode;
                        z6 = n;
                        str5 = "has_res";
                        str14 = j2;
                        z8 = r;
                        inputStream = d2;
                        z9 = o;
                        str13 = str28;
                        str15 = str4;
                        str4 = "_";
                        z7 = l;
                        str12 = k2;
                        if (!BdBaseApplication.getInst().isDebugMode() || a) {
                            z10 = z9;
                        } else {
                            z10 = z9;
                            if (!q(str15, file2.getAbsolutePath()).a) {
                                if (pluginSetting == null || !str.startsWith("file://")) {
                                    z11 = z8;
                                    str16 = "is_third";
                                    bArr = null;
                                    file3 = file2;
                                    z12 = false;
                                } else {
                                    z11 = z8;
                                    str16 = "is_third";
                                    bArr = null;
                                    file3 = file2;
                                    z12 = a(file3, pluginSetting.tempMd5, null);
                                }
                                if (!z12) {
                                    boolean a2 = a(file, pluginSetting.tempMd5, bArr);
                                    try {
                                        file2.delete();
                                    } catch (Exception e3) {
                                        BdLog.e(e3);
                                    }
                                    p(str, str15, "signature_not_match", str15 + "-SourceMd5_" + a2 + "-tmpSize_" + length + "-error_" + q.f32120b + "-step_" + q.f32121c);
                                    return null;
                                }
                                ?? r7 = "version_code";
                                boolean z13 = z7;
                                String str29 = str12;
                                if (pluginSetting == null && i3 == (i5 = pluginSetting.versionCode)) {
                                    if (str.startsWith("assets://")) {
                                        File file5 = new File(pluginSetting.apkPath);
                                        boolean exists = file5.exists();
                                        boolean isFile = file5.isFile();
                                        str22 = "install_dest_file";
                                        str23 = "install_src_file";
                                        long length2 = file5.length();
                                        try {
                                            try {
                                                inputStream = new FileInputStream(pluginSetting.apkPath);
                                            } catch (Throwable th) {
                                                th = th;
                                                inputStream3 = inputStream;
                                                inputStream2 = r7;
                                            }
                                            try {
                                                try {
                                                    t = Util.t(inputStream);
                                                    str21 = "version_code";
                                                } catch (Exception e4) {
                                                    e = e4;
                                                    i6 = i3;
                                                    str21 = "version_code";
                                                }
                                                try {
                                                    str24 = "package_name";
                                                    try {
                                                        inputStream4 = BdBaseApplication.getInst().getAssets().open(str.substring(9));
                                                        try {
                                                            if (t.compareTo(Util.t(inputStream4)) == 0) {
                                                                i6 = i3;
                                                                r7 = inputStream4;
                                                            } else {
                                                                i6 = i3;
                                                                try {
                                                                    c.a.d.i.h.a.b().m("plugin_install", "versionequals_apktime_notequals", str15, t.toString() + "-" + t2.toString());
                                                                    r7 = inputStream4;
                                                                } catch (Exception e5) {
                                                                    e = e5;
                                                                    BdLog.e(e);
                                                                    c.a.d.i.h.a.b().m("plugin_install", "versionequals_apktime_error", str15, "exist-" + exists + "-isfile-" + isFile + "-length-" + length2 + "-" + e.getMessage());
                                                                    r7 = inputStream4;
                                                                    c.a.d.f.m.a.c(inputStream);
                                                                    c.a.d.f.m.a.c(r7);
                                                                    file2.delete();
                                                                    activityManager = (ActivityManager) BdBaseApplication.getInst().getSystemService("activity");
                                                                    if (activityManager != null) {
                                                                    }
                                                                    str25 = null;
                                                                    c.a.d.i.h.a b2 = c.a.d.i.h.a.b();
                                                                    String str30 = pluginSetting.packageName;
                                                                    StringBuilder sb = new StringBuilder();
                                                                    sb.append(i5);
                                                                    sb.append(" to ");
                                                                    int i7 = i6;
                                                                    sb.append(i7);
                                                                    sb.append("-instapkpath-");
                                                                    sb.append(pluginSetting.apkPath);
                                                                    sb.append("-md5-");
                                                                    sb.append(pluginSetting.md5);
                                                                    sb.append("-size-");
                                                                    sb.append(pluginSetting.size);
                                                                    sb.append("-newapkfile-");
                                                                    sb.append(file2);
                                                                    sb.append("-size-");
                                                                    sb.append(file2.length());
                                                                    sb.append("-srcpath-");
                                                                    sb.append(str);
                                                                    sb.append("-process-");
                                                                    sb.append(str25);
                                                                    b2.m("plugin_install", "versionCode_is_equals", str30, sb.toString());
                                                                    Intent intent = new Intent("com.baidu.adp.plugin.installcancel");
                                                                    intent.setPackage(BdBaseApplication.getInst().getPackageName());
                                                                    intent.putExtra(str24, str15);
                                                                    intent.putExtra(str23, str);
                                                                    intent.putExtra(str22, str);
                                                                    intent.putExtra(str21, i7);
                                                                    BdStatisticsManager.getInstance().save();
                                                                    BdBaseApplication.getInst().sendBroadcast(intent);
                                                                    return null;
                                                                }
                                                            }
                                                        } catch (Exception e6) {
                                                            e = e6;
                                                            i6 = i3;
                                                        }
                                                    } catch (Exception e7) {
                                                        e = e7;
                                                        i6 = i3;
                                                        inputStream4 = null;
                                                        BdLog.e(e);
                                                        c.a.d.i.h.a.b().m("plugin_install", "versionequals_apktime_error", str15, "exist-" + exists + "-isfile-" + isFile + "-length-" + length2 + "-" + e.getMessage());
                                                        r7 = inputStream4;
                                                        c.a.d.f.m.a.c(inputStream);
                                                        c.a.d.f.m.a.c(r7);
                                                        file2.delete();
                                                        activityManager = (ActivityManager) BdBaseApplication.getInst().getSystemService("activity");
                                                        if (activityManager != null) {
                                                        }
                                                        str25 = null;
                                                        c.a.d.i.h.a b22 = c.a.d.i.h.a.b();
                                                        String str302 = pluginSetting.packageName;
                                                        StringBuilder sb2 = new StringBuilder();
                                                        sb2.append(i5);
                                                        sb2.append(" to ");
                                                        int i72 = i6;
                                                        sb2.append(i72);
                                                        sb2.append("-instapkpath-");
                                                        sb2.append(pluginSetting.apkPath);
                                                        sb2.append("-md5-");
                                                        sb2.append(pluginSetting.md5);
                                                        sb2.append("-size-");
                                                        sb2.append(pluginSetting.size);
                                                        sb2.append("-newapkfile-");
                                                        sb2.append(file2);
                                                        sb2.append("-size-");
                                                        sb2.append(file2.length());
                                                        sb2.append("-srcpath-");
                                                        sb2.append(str);
                                                        sb2.append("-process-");
                                                        sb2.append(str25);
                                                        b22.m("plugin_install", "versionCode_is_equals", str302, sb2.toString());
                                                        Intent intent2 = new Intent("com.baidu.adp.plugin.installcancel");
                                                        intent2.setPackage(BdBaseApplication.getInst().getPackageName());
                                                        intent2.putExtra(str24, str15);
                                                        intent2.putExtra(str23, str);
                                                        intent2.putExtra(str22, str);
                                                        intent2.putExtra(str21, i72);
                                                        BdStatisticsManager.getInstance().save();
                                                        BdBaseApplication.getInst().sendBroadcast(intent2);
                                                        return null;
                                                    }
                                                } catch (Exception e8) {
                                                    e = e8;
                                                    i6 = i3;
                                                    str24 = "package_name";
                                                    inputStream4 = null;
                                                    BdLog.e(e);
                                                    c.a.d.i.h.a.b().m("plugin_install", "versionequals_apktime_error", str15, "exist-" + exists + "-isfile-" + isFile + "-length-" + length2 + "-" + e.getMessage());
                                                    r7 = inputStream4;
                                                    c.a.d.f.m.a.c(inputStream);
                                                    c.a.d.f.m.a.c(r7);
                                                    file2.delete();
                                                    activityManager = (ActivityManager) BdBaseApplication.getInst().getSystemService("activity");
                                                    if (activityManager != null) {
                                                    }
                                                    str25 = null;
                                                    c.a.d.i.h.a b222 = c.a.d.i.h.a.b();
                                                    String str3022 = pluginSetting.packageName;
                                                    StringBuilder sb22 = new StringBuilder();
                                                    sb22.append(i5);
                                                    sb22.append(" to ");
                                                    int i722 = i6;
                                                    sb22.append(i722);
                                                    sb22.append("-instapkpath-");
                                                    sb22.append(pluginSetting.apkPath);
                                                    sb22.append("-md5-");
                                                    sb22.append(pluginSetting.md5);
                                                    sb22.append("-size-");
                                                    sb22.append(pluginSetting.size);
                                                    sb22.append("-newapkfile-");
                                                    sb22.append(file2);
                                                    sb22.append("-size-");
                                                    sb22.append(file2.length());
                                                    sb22.append("-srcpath-");
                                                    sb22.append(str);
                                                    sb22.append("-process-");
                                                    sb22.append(str25);
                                                    b222.m("plugin_install", "versionCode_is_equals", str3022, sb22.toString());
                                                    Intent intent22 = new Intent("com.baidu.adp.plugin.installcancel");
                                                    intent22.setPackage(BdBaseApplication.getInst().getPackageName());
                                                    intent22.putExtra(str24, str15);
                                                    intent22.putExtra(str23, str);
                                                    intent22.putExtra(str22, str);
                                                    intent22.putExtra(str21, i722);
                                                    BdStatisticsManager.getInstance().save();
                                                    BdBaseApplication.getInst().sendBroadcast(intent22);
                                                    return null;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                inputStream3 = inputStream;
                                                inputStream2 = null;
                                                c.a.d.f.m.a.c(inputStream3);
                                                c.a.d.f.m.a.c(inputStream2);
                                                throw th;
                                            }
                                        } catch (Exception e9) {
                                            e = e9;
                                            i6 = i3;
                                            str21 = "version_code";
                                            str24 = "package_name";
                                            inputStream4 = null;
                                            inputStream = null;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            inputStream2 = null;
                                            inputStream3 = null;
                                        }
                                        c.a.d.f.m.a.c(inputStream);
                                        c.a.d.f.m.a.c(r7);
                                    } else {
                                        i6 = i3;
                                        str21 = "version_code";
                                        str22 = "install_dest_file";
                                        str23 = "install_src_file";
                                        str24 = "package_name";
                                    }
                                    try {
                                        file2.delete();
                                    } catch (Exception e10) {
                                        e10.printStackTrace();
                                    }
                                    activityManager = (ActivityManager) BdBaseApplication.getInst().getSystemService("activity");
                                    if (activityManager != null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                                        str25 = null;
                                    } else {
                                        str25 = null;
                                        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                                            if (runningAppProcessInfo != null && runningAppProcessInfo.pid == Process.myPid()) {
                                                str25 = runningAppProcessInfo.processName;
                                            }
                                        }
                                    }
                                    c.a.d.i.h.a b2222 = c.a.d.i.h.a.b();
                                    String str30222 = pluginSetting.packageName;
                                    StringBuilder sb222 = new StringBuilder();
                                    sb222.append(i5);
                                    sb222.append(" to ");
                                    int i7222 = i6;
                                    sb222.append(i7222);
                                    sb222.append("-instapkpath-");
                                    sb222.append(pluginSetting.apkPath);
                                    sb222.append("-md5-");
                                    sb222.append(pluginSetting.md5);
                                    sb222.append("-size-");
                                    sb222.append(pluginSetting.size);
                                    sb222.append("-newapkfile-");
                                    sb222.append(file2);
                                    sb222.append("-size-");
                                    sb222.append(file2.length());
                                    sb222.append("-srcpath-");
                                    sb222.append(str);
                                    sb222.append("-process-");
                                    sb222.append(str25);
                                    b2222.m("plugin_install", "versionCode_is_equals", str30222, sb222.toString());
                                    Intent intent222 = new Intent("com.baidu.adp.plugin.installcancel");
                                    intent222.setPackage(BdBaseApplication.getInst().getPackageName());
                                    intent222.putExtra(str24, str15);
                                    intent222.putExtra(str23, str);
                                    intent222.putExtra(str22, str);
                                    intent222.putExtra(str21, i7222);
                                    BdStatisticsManager.getInstance().save();
                                    BdBaseApplication.getInst().sendBroadcast(intent222);
                                    return null;
                                }
                                int i8 = i3;
                                if (str.startsWith("assets://")) {
                                    str17 = "plugin_install";
                                    if (!str15.equals(str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(Constant.FILE.SUFFIX.BUNDLE_SUFFIX)))) {
                                        g.n(file2);
                                        p(str, str15, "filename_packagename_not_match", null);
                                        BdLog.e(str + " must be named with it's package name : " + str15 + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
                                        return null;
                                    }
                                } else {
                                    str17 = "plugin_install";
                                }
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(str15);
                                String str31 = str4;
                                sb3.append(str31);
                                String str32 = inputStream;
                                sb3.append(System.currentTimeMillis());
                                sb3.append(str31);
                                sb3.append(i8);
                                String sb4 = sb3.toString();
                                String str33 = "-";
                                file4 = new File(Util.i(), sb4 + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
                                if (!file3.equals(file4)) {
                                    String parent = file2.getParent();
                                    String parent2 = file4.getParent();
                                    try {
                                        if (parent.equals(parent2)) {
                                            try {
                                                if (file3.renameTo(file4)) {
                                                    if (!file4.exists() || file4.length() == 0) {
                                                        throw new Exception("rename fail");
                                                    }
                                                } else {
                                                    throw new Exception("rename return fail");
                                                }
                                            } catch (Exception e11) {
                                                try {
                                                    file4.delete();
                                                    g.f(file3, file4);
                                                    file2.delete();
                                                } catch (IOException e12) {
                                                    if (file2.exists()) {
                                                        g.n(file2);
                                                    }
                                                    BdLog.e(e12);
                                                    p(str, str15, "rename_todest_fail", e11.getMessage());
                                                    return null;
                                                }
                                            }
                                        } else {
                                            try {
                                                fileInputStream = new FileInputStream(file3);
                                                try {
                                                    Util.a b3 = Util.b(fileInputStream, file4);
                                                    file2.delete();
                                                    if (!b3.a) {
                                                        str20 = str3;
                                                        try {
                                                            p(str, str15, str20, b3.f32120b);
                                                            c.a.d.f.m.a.c(fileInputStream);
                                                            return null;
                                                        } catch (Exception e13) {
                                                            e = e13;
                                                            BdLog.e(e);
                                                            if (file4.exists()) {
                                                                g.n(file4);
                                                            }
                                                            p(str, str15, str20, e.getMessage());
                                                            c.a.d.f.m.a.c(fileInputStream);
                                                            return null;
                                                        }
                                                    }
                                                    c.a.d.f.m.a.c(fileInputStream);
                                                } catch (Exception e14) {
                                                    e = e14;
                                                    str20 = str3;
                                                }
                                            } catch (Exception e15) {
                                                e = e15;
                                                str20 = str3;
                                                fileInputStream = null;
                                            } catch (Throwable th4) {
                                                th = th4;
                                                r10 = 0;
                                                c.a.d.f.m.a.c(r10);
                                                throw th;
                                            }
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        r10 = parent2;
                                    }
                                }
                                File file6 = new File(Util.i(), sb4);
                                file6.mkdir();
                                File file7 = new File(file6, "lib");
                                file7.mkdir();
                                long currentTimeMillis = System.currentTimeMillis();
                                j(file4.getAbsolutePath(), file7.getAbsolutePath(), str15);
                                String str34 = str31;
                                c.a.d.i.h.a.b().l("plugin_extract_so", System.currentTimeMillis() - currentTimeMillis, str15);
                                long currentTimeMillis2 = System.currentTimeMillis();
                                i(file4.getAbsolutePath(), str15, file6);
                                c.a.d.i.h.a.b().l("plugin_extract_dex", System.currentTimeMillis() - currentTimeMillis2, str15);
                                f2777b.put(str2 + str, Boolean.TRUE);
                                Intent intent3 = new Intent("com.baidu.adp.plugin.installed");
                                intent3.setPackage(BdBaseApplication.getInst().getPackageName());
                                intent3.putExtra("package_name", str15);
                                intent3.putExtra("install_src_file", str);
                                intent3.putExtra("install_dest_file", file4.getAbsolutePath());
                                intent3.putExtra("version_code", i8);
                                intent3.putExtra("version_name", str13);
                                intent3.putExtra("cmd_range", str32);
                                intent3.putExtra("require_load", str29);
                                intent3.putExtra(str5, z13);
                                intent3.putExtra(str16, z11);
                                intent3.putExtra("is_patch", z10);
                                intent3.putExtra("replace_method_classes", str14);
                                intent3.putExtra("is_inject_classloader", z6);
                                intent3.putExtra("install_flag", f2778c);
                                BdStatisticsManager.getInstance().save();
                                BdBaseApplication.getInst().sendOrderedBroadcast(intent3, null);
                                listFiles = Util.i().listFiles();
                                if (listFiles != null) {
                                    int length3 = listFiles.length;
                                    int i9 = 0;
                                    while (true) {
                                        if (i9 >= length3) {
                                            break;
                                        }
                                        File file8 = listFiles[i9];
                                        if (file8 != null && file8.isDirectory()) {
                                            String name = file8.getName();
                                            if (name.startsWith(str15) && !name.equals(sb4)) {
                                                str19 = str34;
                                                int lastIndexOf = name.lastIndexOf(str19);
                                                if (lastIndexOf > 0 && (e2 = c.a.d.f.m.b.e(name.substring(lastIndexOf + 1), -1)) > 0 && e2 == i8) {
                                                    break;
                                                }
                                                str18 = str17;
                                                i9++;
                                                str17 = str18;
                                                str33 = str33;
                                                str34 = str19;
                                            }
                                        }
                                        str18 = str17;
                                        str19 = str34;
                                        i9++;
                                        str17 = str18;
                                        str33 = str33;
                                        str34 = str19;
                                    }
                                }
                                return str15;
                            }
                        }
                        z11 = z8;
                        str16 = "is_third";
                        file3 = file2;
                        ?? r72 = "version_code";
                        boolean z132 = z7;
                        String str292 = str12;
                        if (pluginSetting == null) {
                        }
                        int i82 = i3;
                        if (str.startsWith("assets://")) {
                        }
                        StringBuilder sb32 = new StringBuilder();
                        sb32.append(str15);
                        String str312 = str4;
                        sb32.append(str312);
                        String str322 = inputStream;
                        sb32.append(System.currentTimeMillis());
                        sb32.append(str312);
                        sb32.append(i82);
                        String sb42 = sb32.toString();
                        String str332 = "-";
                        file4 = new File(Util.i(), sb42 + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
                        if (!file3.equals(file4)) {
                        }
                        File file62 = new File(Util.i(), sb42);
                        file62.mkdir();
                        File file72 = new File(file62, "lib");
                        file72.mkdir();
                        long currentTimeMillis3 = System.currentTimeMillis();
                        j(file4.getAbsolutePath(), file72.getAbsolutePath(), str15);
                        String str342 = str312;
                        c.a.d.i.h.a.b().l("plugin_extract_so", System.currentTimeMillis() - currentTimeMillis3, str15);
                        long currentTimeMillis22 = System.currentTimeMillis();
                        i(file4.getAbsolutePath(), str15, file62);
                        c.a.d.i.h.a.b().l("plugin_extract_dex", System.currentTimeMillis() - currentTimeMillis22, str15);
                        f2777b.put(str2 + str, Boolean.TRUE);
                        Intent intent32 = new Intent("com.baidu.adp.plugin.installed");
                        intent32.setPackage(BdBaseApplication.getInst().getPackageName());
                        intent32.putExtra("package_name", str15);
                        intent32.putExtra("install_src_file", str);
                        intent32.putExtra("install_dest_file", file4.getAbsolutePath());
                        intent32.putExtra("version_code", i82);
                        intent32.putExtra("version_name", str13);
                        intent32.putExtra("cmd_range", str322);
                        intent32.putExtra("require_load", str292);
                        intent32.putExtra(str5, z132);
                        intent32.putExtra(str16, z11);
                        intent32.putExtra("is_patch", z10);
                        intent32.putExtra("replace_method_classes", str14);
                        intent32.putExtra("is_inject_classloader", z6);
                        intent32.putExtra("install_flag", f2778c);
                        BdStatisticsManager.getInstance().save();
                        BdBaseApplication.getInst().sendOrderedBroadcast(intent32, null);
                        listFiles = Util.i().listFiles();
                        if (listFiles != null) {
                        }
                        return str15;
                    }
                }
            }
            ZipFile zipFile = new ZipFile(file2, 1);
            ZipEntry entry = zipFile.getEntry("assets/AndroidManifest.xml");
            if (entry == null) {
                try {
                    file2.delete();
                } catch (Exception e16) {
                    BdLog.e(e16);
                }
                p(str, str2, "assetsmanifestnull", "avirom-" + Util.c() + "-filesize-" + length + "-exp-" + ((String) null));
                return null;
            }
            str4 = "_";
            Element documentElement = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(zipFile.getInputStream(entry))).getDocumentElement();
            String attribute2 = documentElement.getAttribute("package");
            int i10 = Integer.parseInt(documentElement.getAttribute("android:versionCode"));
            try {
                attribute = documentElement.getAttribute("android:versionName");
                try {
                    elementsByTagName = documentElement.getElementsByTagName("meta-data");
                } catch (Exception e17) {
                    e = e17;
                    str8 = attribute;
                    str5 = "has_res";
                    str6 = null;
                    str7 = null;
                    z = false;
                    z2 = false;
                    z3 = false;
                    z4 = false;
                }
            } catch (Exception e18) {
                e = e18;
                str5 = "has_res";
                str6 = null;
                str7 = null;
                z = false;
                z2 = false;
                z3 = false;
                z4 = false;
                str8 = null;
                str10 = str7;
                z5 = z4;
                str11 = null;
                int i11 = i10;
                str9 = e.toString();
                i2 = i11;
                if (TextUtils.isEmpty(str11)) {
                }
            }
            if (elementsByTagName != null) {
                if (elementsByTagName.getLength() > 0) {
                    i4 = i10;
                    int i12 = 0;
                    str6 = null;
                    str7 = null;
                    z = false;
                    z2 = false;
                    z3 = false;
                    z4 = false;
                    while (i12 < elementsByTagName.getLength()) {
                        try {
                            Node item = elementsByTagName.item(i12);
                            if (item == null || (attributes = item.getAttributes()) == null) {
                                nodeList = elementsByTagName;
                            } else {
                                nodeList = elementsByTagName;
                                Node namedItem2 = attributes.getNamedItem("android:name");
                                if (namedItem2 != null && namedItem2.getNodeValue() != null) {
                                    str8 = attribute;
                                    try {
                                        if (namedItem2.getNodeValue().equals("is_inject_classloader")) {
                                            Node namedItem3 = attributes.getNamedItem("android:value");
                                            if (namedItem3 != null && namedItem3.getNodeValue() != null) {
                                                z4 = Boolean.parseBoolean(namedItem3.getNodeValue());
                                            }
                                        } else if (namedItem2.getNodeValue().equals(str26)) {
                                            Node namedItem4 = attributes.getNamedItem("android:value");
                                            if (namedItem4 != null && namedItem4.getNodeValue() != null) {
                                                try {
                                                    z = Boolean.parseBoolean(namedItem4.getNodeValue());
                                                } catch (Exception unused) {
                                                }
                                            }
                                        } else if (namedItem2.getNodeValue().equals("require_load")) {
                                            Node namedItem5 = attributes.getNamedItem("android:value");
                                            str7 = (namedItem5 == null || namedItem5.getNodeValue() == null) ? str7 : namedItem5.getNodeValue();
                                        } else {
                                            str5 = str26;
                                            try {
                                                if (namedItem2.getNodeValue().equals("cmd_range_0")) {
                                                    Node namedItem6 = attributes.getNamedItem("android:value");
                                                    if (namedItem6 != null && namedItem6.getNodeValue() != null) {
                                                        str6 = namedItem6.getNodeValue();
                                                    }
                                                } else if (namedItem2.getNodeValue().equals("is_third")) {
                                                    Node namedItem7 = attributes.getNamedItem("android:value");
                                                    if (namedItem7 != null && namedItem7.getNodeValue() != null) {
                                                        try {
                                                            z2 = Boolean.parseBoolean(namedItem7.getNodeValue());
                                                        } catch (Exception unused2) {
                                                        }
                                                    }
                                                } else if (namedItem2.getNodeValue().equals("is_patch") && (namedItem = attributes.getNamedItem("android:value")) != null && namedItem.getNodeValue() != null) {
                                                    z3 = Boolean.parseBoolean(namedItem.getNodeValue());
                                                }
                                                i12++;
                                                elementsByTagName = nodeList;
                                                attribute = str8;
                                                str26 = str5;
                                            } catch (Exception e19) {
                                                e = e19;
                                                i10 = i4;
                                                str10 = str7;
                                                z5 = z4;
                                                str11 = null;
                                                int i112 = i10;
                                                str9 = e.toString();
                                                i2 = i112;
                                                if (TextUtils.isEmpty(str11)) {
                                                }
                                            }
                                        }
                                        str5 = str26;
                                        i12++;
                                        elementsByTagName = nodeList;
                                        attribute = str8;
                                        str26 = str5;
                                    } catch (Exception e20) {
                                        e = e20;
                                        str5 = str26;
                                        i10 = i4;
                                        str10 = str7;
                                        z5 = z4;
                                        str11 = null;
                                        int i1122 = i10;
                                        str9 = e.toString();
                                        i2 = i1122;
                                        if (TextUtils.isEmpty(str11)) {
                                        }
                                    }
                                }
                            }
                            str8 = attribute;
                            str5 = str26;
                            i12++;
                            elementsByTagName = nodeList;
                            attribute = str8;
                            str26 = str5;
                        } catch (Exception e21) {
                            e = e21;
                            str8 = attribute;
                        }
                    }
                    str8 = attribute;
                    str5 = str26;
                    str11 = attribute2;
                    str10 = str7;
                    z5 = z4;
                    i2 = i4;
                    str9 = null;
                    if (TextUtils.isEmpty(str11)) {
                        try {
                            file2.delete();
                        } catch (Exception e22) {
                            BdLog.e(e22);
                        }
                        p(str, str2, "getpackageinfo_fail", "avirom-" + Util.c() + "-filesize-" + length + "-exp-" + str9);
                        return null;
                    }
                    c.a.d.i.h.a.b().i("plugin_xml_parse", str11);
                    str12 = str10;
                    z6 = z5;
                    inputStream = str6;
                    z7 = z;
                    z8 = z2;
                    z9 = z3;
                    str13 = str8;
                    str14 = null;
                    str15 = str11;
                    i3 = i2;
                    if (BdBaseApplication.getInst().isDebugMode()) {
                    }
                    z10 = z9;
                    z11 = z8;
                    str16 = "is_third";
                    file3 = file2;
                    ?? r722 = "version_code";
                    boolean z1322 = z7;
                    String str2922 = str12;
                    if (pluginSetting == null) {
                    }
                    int i822 = i3;
                    if (str.startsWith("assets://")) {
                    }
                    StringBuilder sb322 = new StringBuilder();
                    sb322.append(str15);
                    String str3122 = str4;
                    sb322.append(str3122);
                    String str3222 = inputStream;
                    sb322.append(System.currentTimeMillis());
                    sb322.append(str3122);
                    sb322.append(i822);
                    String sb422 = sb322.toString();
                    String str3322 = "-";
                    file4 = new File(Util.i(), sb422 + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
                    if (!file3.equals(file4)) {
                    }
                    File file622 = new File(Util.i(), sb422);
                    file622.mkdir();
                    File file722 = new File(file622, "lib");
                    file722.mkdir();
                    long currentTimeMillis32 = System.currentTimeMillis();
                    j(file4.getAbsolutePath(), file722.getAbsolutePath(), str15);
                    String str3422 = str3122;
                    c.a.d.i.h.a.b().l("plugin_extract_so", System.currentTimeMillis() - currentTimeMillis32, str15);
                    long currentTimeMillis222 = System.currentTimeMillis();
                    i(file4.getAbsolutePath(), str15, file622);
                    c.a.d.i.h.a.b().l("plugin_extract_dex", System.currentTimeMillis() - currentTimeMillis222, str15);
                    f2777b.put(str2 + str, Boolean.TRUE);
                    Intent intent322 = new Intent("com.baidu.adp.plugin.installed");
                    intent322.setPackage(BdBaseApplication.getInst().getPackageName());
                    intent322.putExtra("package_name", str15);
                    intent322.putExtra("install_src_file", str);
                    intent322.putExtra("install_dest_file", file4.getAbsolutePath());
                    intent322.putExtra("version_code", i822);
                    intent322.putExtra("version_name", str13);
                    intent322.putExtra("cmd_range", str3222);
                    intent322.putExtra("require_load", str2922);
                    intent322.putExtra(str5, z1322);
                    intent322.putExtra(str16, z11);
                    intent322.putExtra("is_patch", z10);
                    intent322.putExtra("replace_method_classes", str14);
                    intent322.putExtra("is_inject_classloader", z6);
                    intent322.putExtra("install_flag", f2778c);
                    BdStatisticsManager.getInstance().save();
                    BdBaseApplication.getInst().sendOrderedBroadcast(intent322, null);
                    listFiles = Util.i().listFiles();
                    if (listFiles != null) {
                    }
                    return str15;
                }
            }
            i4 = i10;
            str8 = attribute;
            str5 = "has_res";
            str6 = null;
            str7 = null;
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
            str11 = attribute2;
            str10 = str7;
            z5 = z4;
            i2 = i4;
            str9 = null;
            if (TextUtils.isEmpty(str11)) {
            }
        } else {
            p(str, str2, "tempfile_not_exist", file2 == null ? StringUtil.NULL_STRING : file2.exists() + "_" + file2.length());
            return null;
        }
    }

    public static void e(ZipFile zipFile, String str, ArrayList<ZipEntry> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65541, null, zipFile, str, arrayList) == null) || zipFile == null || arrayList == null || arrayList.size() == 0) {
            return;
        }
        Iterator<ZipEntry> it = arrayList.iterator();
        while (it.hasNext()) {
            ZipEntry next = it.next();
            InputStream inputStream = null;
            try {
                try {
                    String name = next.getName();
                    int lastIndexOf = name.lastIndexOf("/");
                    inputStream = zipFile.getInputStream(next);
                    Util.b(inputStream, new File(str, name.substring(lastIndexOf)));
                } catch (IOException e2) {
                    BdLog.e(e2);
                }
            } finally {
                c.a.d.f.m.a.c(inputStream);
            }
        }
    }

    public static void f(String str, String str2, PluginSetting pluginSetting) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, str, str2, pluginSetting) == null) {
            if (TextUtils.isEmpty(str)) {
                p(str, str2, "srcfile_empty", "");
                c.a.d.i.h.a.b().o("plugin_install", "srcfile_empty", str2);
            } else if (str.startsWith("assets://")) {
                h(str, str2, pluginSetting);
            } else if (str.startsWith("file://")) {
                g(str, str2, pluginSetting);
            } else {
                p(str, str2, "srcfile_illegal", "");
                c.a.d.i.h.a.b().o("plugin_install", "srcfile_illegal", str2);
            }
        }
    }

    public static void g(String str, String str2, PluginSetting pluginSetting) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLL(65543, null, str, str2, pluginSetting) != null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            p(str, str2, "do_install", "");
            c.a.d.i.h.a.b().o("plugin_install", "pkgname_null", str2);
            return;
        }
        String substring = str.substring(7);
        File file = new File(substring);
        if (!file.exists()) {
            p(str, str2, "apk_not_exist", "file_not_exists-apkFilePath_" + substring);
            c.a.d.i.h.a b2 = c.a.d.i.h.a.b();
            b2.m("plugin_install", "service_apk_not_exist", str2, f2778c + "_" + substring);
            return;
        }
        int i3 = 0;
        try {
            int lastIndexOf = substring.lastIndexOf("_");
            int e2 = lastIndexOf > 0 ? c.a.d.f.m.b.e(substring.substring(lastIndexOf + 1), -1) : -1;
            if (e2 > 0) {
                if (e2 < PluginPackageManager.t()) {
                    c.a.d.i.h.a b3 = c.a.d.i.h.a.b();
                    b3.m("plugin_install", "low_version_code", str2, " vc=" + String.valueOf(e2) + " tiebaVC=" + PluginPackageManager.t());
                    Intent intent = new Intent("com.baidu.adp.plugin.deleted");
                    intent.setPackage(BdBaseApplication.getInst().getPackageName());
                    intent.putExtra("package_name", str2);
                    intent.putExtra("install_src_file", str);
                    intent.putExtra("fail_reason", "low_version_code");
                    intent.putExtra("version_code", e2);
                    BdBaseApplication.getInst().sendBroadcast(intent);
                    return;
                } else if (pluginSetting != null && e2 == (i2 = pluginSetting.versionCode)) {
                    c.a.d.i.h.a b4 = c.a.d.i.h.a.b();
                    String str3 = pluginSetting.packageName;
                    b4.m("plugin_install", "versionCode_is_equals", str3, i2 + " to " + e2 + "-instapkpath-" + pluginSetting.apkPath + "-md5-" + pluginSetting.md5 + "-size-" + pluginSetting.size + "-newapkfile-" + file + "-size-" + file.length() + "-srcpath-" + str);
                    Intent intent2 = new Intent("com.baidu.adp.plugin.installcancel");
                    intent2.setPackage(BdBaseApplication.getInst().getPackageName());
                    intent2.putExtra("package_name", str2);
                    intent2.putExtra("install_src_file", str);
                    intent2.putExtra("install_dest_file", str);
                    intent2.putExtra("version_code", e2);
                    BdStatisticsManager.getInstance().save();
                    BdBaseApplication.getInst().sendBroadcast(intent2);
                    return;
                }
            }
            try {
                if (!Util.q(file.length())) {
                    p(str, str2, "rom_size", String.valueOf(Util.c()));
                } else {
                    l(file, str, str2, pluginSetting);
                }
            } catch (Exception e3) {
                e = e3;
                i3 = 1;
                BdLog.e(e);
                p(str, str2, "open_apk", e.toString());
                c.a.d.i.h.a b5 = c.a.d.i.h.a.b();
                b5.p("plugin_install", "open_files_failed", str2, e.getMessage() + "---" + e.getClass().getName() + "---step_" + i3);
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    public static void h(String str, String str2, PluginSetting pluginSetting) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, str, str2, pluginSetting) == null) {
            if (TextUtils.isEmpty(str)) {
                p(str, str2, "do_install", "");
                c.a.d.i.h.a.b().o("plugin_install", "pkgname_null", str2);
                return;
            }
            String substring = str.substring(9);
            InputStream inputStream = null;
            try {
                try {
                    inputStream = BdBaseApplication.getInst().getAssets().open(substring);
                } catch (Exception e2) {
                    BdLog.e(e2);
                    StringBuilder sb = new StringBuilder();
                    boolean z = true;
                    if (!l.isEmpty(substring) && substring.startsWith("plugins/")) {
                        String substring2 = substring.substring(8);
                        try {
                            String[] list = BdBaseApplication.getInst().getAssets().list(FlutterActivityAndFragmentDelegate.PLUGINS_RESTORATION_BUNDLE_KEY);
                            if (!l.isEmpty(substring2) && list != null && list.length > 0) {
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= list.length) {
                                        break;
                                    } else if (substring2.equals(list[i2])) {
                                        z = false;
                                        break;
                                    } else {
                                        sb.append(list[i2]);
                                        i2++;
                                    }
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                    if (z) {
                        p(str, str2, "assets_not_found", sb.toString());
                    } else {
                        p(str, str2, "open_assets", "assetsPath-" + substring + "-exp-" + e2.toString());
                    }
                    c.a.d.i.h.a b2 = c.a.d.i.h.a.b();
                    b2.p("plugin_install", "open_assets_failed", str2, e2.getMessage() + "---" + e2.getClass().getName());
                }
                if (!Util.q(inputStream.available())) {
                    p(str, str2, "rom_size", String.valueOf(Util.c()));
                } else {
                    m(inputStream, str, str2, pluginSetting);
                }
            } finally {
                c.a.d.f.m.a.c(null);
            }
        }
    }

    public static void i(String str, String str2, File file) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65545, null, str, str2, file) == null) || file == null) {
            return;
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            c.a.d.i.h.a.b().m("plugin_install", "dexopt_file_illegal", str2, file2.getAbsolutePath());
        }
        if (file2.length() == 0) {
            c.a.d.i.h.a b2 = c.a.d.i.h.a.b();
            b2.m("plugin_install", "dexopt_file_empty", str2, file2.getAbsolutePath() + "---" + file2.length());
        }
        DexClassLoader dexClassLoader = null;
        try {
            dexClassLoader = new DexClassLoader(str, file.getAbsolutePath(), null, BdBaseApplication.getInst().getClassLoader());
        } catch (Exception e2) {
            c.a.d.i.h.a b3 = c.a.d.i.h.a.b();
            b3.m("plugin_install", "new_dexloader", str2, e2.getMessage() + "---" + e2.getClass().getName());
            BdLog.e(e2);
        }
        if (dexClassLoader != null) {
            try {
                dexClassLoader.loadClass(str2 + ".Static");
            } catch (ClassNotFoundException e3) {
                c.a.d.i.h.a.b().m("plugin_install", "loadR", str2, e3.getMessage());
                BdLog.e(e3);
            } catch (Exception e4) {
                c.a.d.i.h.a b4 = c.a.d.i.h.a.b();
                b4.m("plugin_install", "loadR2", str2, e4.getMessage() + "---" + e4.getClass().getName());
                BdLog.e(e4);
            }
        }
    }

    public static void j(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65546, null, str, str2, str3) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        String lowerCase = Build.CPU_ABI.toLowerCase();
        String str4 = "none";
        if (Build.VERSION.SDK_INT > 7) {
            try {
                String str5 = (String) Build.class.getDeclaredField("CPU_ABI2").get(Build.class);
                try {
                    str4 = str5.toLowerCase();
                } catch (Throwable unused) {
                    str4 = str5;
                }
            } catch (Throwable unused2) {
            }
        }
        String str6 = str4;
        ZipFile zipFile = null;
        try {
            zipFile = new ZipFile(str);
        } catch (IOException e2) {
            BdLog.e(e2);
        }
        if (zipFile == null) {
            return;
        }
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        while (entries.hasMoreElements()) {
            ZipEntry nextElement = entries.nextElement();
            String name = nextElement.getName();
            Enumeration<? extends ZipEntry> enumeration = entries;
            if (name.startsWith(PluginInstallerService.APK_LIB_DIR_PREFIX) && name.endsWith(".so")) {
                String substring = name.substring(PluginInstallerService.APK_LIB_CPUABI_OFFSITE, name.lastIndexOf("/"));
                if (substring.toLowerCase().contains(IDevices.ABI_MIPS)) {
                    arrayList3.add(nextElement);
                } else if (substring.toLowerCase().contains("x86")) {
                    arrayList2.add(nextElement);
                } else if (substring.toLowerCase().contains("armeabi-v7a")) {
                    arrayList4.add(nextElement);
                } else {
                    arrayList.add(nextElement);
                }
            }
            entries = enumeration;
        }
        if (!lowerCase.contains("x86") && !str6.contains("x86")) {
            if (!lowerCase.contains(IDevices.ABI_MIPS) && !str6.contains(IDevices.ABI_MIPS)) {
                if (!lowerCase.contains("armeabi-v7a") && !str6.contains("armeabi-v7a") && !k()) {
                    if (!lowerCase.contains("armeabi") && !str6.contains("armeabi")) {
                        c.a.d.i.h.a.b().g("plugin_cpuarch_judge_fail");
                        c.a.d.i.h.a b2 = c.a.d.i.h.a.b();
                        b2.m("plugin_install", "cpuarch_judge_fail", str3, lowerCase + "-" + str6);
                        e(zipFile, str2, arrayList);
                        if (arrayList.size() <= 0) {
                            return;
                        }
                    } else {
                        e(zipFile, str2, arrayList);
                        if (arrayList.size() <= 0) {
                            return;
                        }
                    }
                } else {
                    n(arrayList4, arrayList);
                    e(zipFile, str2, arrayList4);
                    if (arrayList4.size() <= 0) {
                        return;
                    }
                }
            } else {
                n(arrayList3, arrayList);
                e(zipFile, str2, arrayList3);
                if (arrayList3.size() <= 0) {
                    return;
                }
            }
        } else {
            n(arrayList2, arrayList);
            e(zipFile, str2, arrayList2);
            if (arrayList2.size() <= 0) {
                return;
            }
        }
        File file = new File(str);
        File parentFile = file.getParentFile();
        File file2 = new File(parentFile, file.getName() + "_tmp");
        try {
            if (c(zipFile, new File(new File(str2).getParentFile(), "tmp"), file2, str3)) {
                if (file2.renameTo(file)) {
                    return;
                }
                c.a.d.i.h.a.b().m("plugin_install", "delete_so", str3, "delete so suc but rename fail");
                file2.delete();
            } else {
                c.a.d.i.h.a.b().m("plugin_install", "delete_so", str3, "delete so fail");
                file2.delete();
            }
        } catch (Exception unused3) {
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:53:0x0109 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:67:0x0127 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:74:0x0011 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public static boolean k() {
        InterceptResult invokeV;
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f2780e) {
                return f2779d;
            }
            boolean z = true;
            f2780e = true;
            BufferedReader bufferedReader2 = 0;
            try {
                try {
                    fileInputStream = new FileInputStream("/proc/cpuinfo");
                    try {
                        inputStreamReader = new InputStreamReader(fileInputStream);
                        try {
                            bufferedReader = new BufferedReader(inputStreamReader);
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        inputStreamReader = null;
                    } catch (Throwable th) {
                        th = th;
                        inputStreamReader = null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e4) {
                e = e4;
                fileInputStream = null;
                inputStreamReader = null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                inputStreamReader = null;
            }
            try {
                int i2 = 2;
                Object[] objArr = {-1, -1, -1};
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.split(":");
                    if (split.length == i2) {
                        String trim = split[0].trim();
                        String trim2 = split[z ? 1 : 0].trim();
                        if (trim.compareTo("Processor") == 0) {
                            StringBuilder sb = new StringBuilder();
                            for (int indexOf = trim2.indexOf("ARMv") + 4; indexOf < trim2.length(); indexOf++) {
                                String str = trim2.charAt(indexOf) + "";
                                if (!str.matches("\\d")) {
                                    break;
                                }
                                sb.append(str);
                            }
                            objArr[0] = w0.j1;
                            objArr[1] = Integer.valueOf(c.a.d.f.m.b.e(sb.toString(), -1));
                        } else if (trim.compareToIgnoreCase("Features") == 0) {
                            if (trim2.contains("neon")) {
                                objArr[2] = "neon";
                            }
                        } else {
                            if (trim.compareToIgnoreCase("model name") == 0) {
                                if (trim2.contains(w0.o1)) {
                                    objArr[0] = "INTEL";
                                    i2 = 2;
                                    objArr[2] = "atom";
                                }
                            } else {
                                i2 = 2;
                                if (trim.compareToIgnoreCase("cpu family") == 0) {
                                    objArr[1] = Integer.valueOf(c.a.d.f.m.b.e(trim2, -1));
                                }
                            }
                            z = true;
                        }
                        z = true;
                        i2 = 2;
                    }
                }
                int intValue = ((Integer) objArr[z ? 1 : 0]).intValue();
                bufferedReader2 = 7;
                if (intValue != 7) {
                    z = false;
                }
                f2779d = z;
                n.g(bufferedReader);
            } catch (Exception e5) {
                e = e5;
                bufferedReader2 = bufferedReader;
                BdLog.e(e);
                n.g(bufferedReader2);
                bufferedReader2 = bufferedReader2;
                n.g(inputStreamReader);
                n.e(fileInputStream);
                return f2779d;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader2 = bufferedReader;
                n.g(bufferedReader2);
                n.g(inputStreamReader);
                n.e(fileInputStream);
                throw th;
            }
            n.g(inputStreamReader);
            n.e(fileInputStream);
            return f2779d;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x00c2 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r10v2 */
    public static String l(File file, String str, String str2, PluginSetting pluginSetting) {
        InterceptResult invokeLLLL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, file, str, str2, pluginSetting)) == null) {
            File file2 = new File(Util.i(), String.valueOf(System.currentTimeMillis()));
            String absolutePath = file.getAbsolutePath();
            long length = file.length();
            try {
                if (file2.exists()) {
                    g.n(file2);
                }
                g.f(file, file2);
                if (file2.length() != length) {
                    throw new Exception("size_not_match1_" + file2.length() + "_" + length);
                }
            } catch (Exception e2) {
                if (file2.exists()) {
                    g.n(file2);
                }
                ?? r10 = 0;
                try {
                    try {
                        File file3 = new File(absolutePath);
                        fileInputStream = new FileInputStream(file3);
                        try {
                            Util.a b2 = Util.b(fileInputStream, file2);
                            if (b2.a) {
                                if (file2.length() == file3.length()) {
                                    c.a.d.f.m.a.c(fileInputStream);
                                } else {
                                    throw new Exception("size_not_match2_" + file2.length() + "_" + file3.length());
                                }
                            } else {
                                g.n(file2);
                                throw new Exception(b2.f32120b);
                            }
                        } catch (Exception e3) {
                            e = e3;
                            p(str, str2, "file_copy_temp_fail", "filesize_" + length + "-exception_" + e2.toString() + "-exception1_" + e.toString());
                            c.a.d.f.m.a.c(fileInputStream);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        r10 = absolutePath;
                        c.a.d.f.m.a.c(r10);
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    c.a.d.f.m.a.c(r10);
                    throw th;
                }
            }
            return d(file, file2, str, str2, pluginSetting);
        }
        return (String) invokeLLLL.objValue;
    }

    public static String m(InputStream inputStream, String str, String str2, PluginSetting pluginSetting) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, inputStream, str, str2, pluginSetting)) == null) {
            if (inputStream != null && str != null) {
                long currentTimeMillis = System.currentTimeMillis();
                File file = new File(Util.i(), String.valueOf(System.currentTimeMillis()));
                Util.a b2 = Util.b(inputStream, file);
                if (!b2.a) {
                    try {
                        file.delete();
                    } catch (Exception e2) {
                        BdLog.e(e2);
                    }
                    p(str, str2, "assets_copy_temp_fail", b2.f32120b);
                    return null;
                }
                c.a.d.i.h.a.b().l("plugin_copy_file", System.currentTimeMillis() - currentTimeMillis, str2);
                return d(null, file, str, str2, pluginSetting);
            }
            p(str, str2, "do_install", "");
            c.a.d.i.h.a.b().o("plugin_install", "doinstall_param_null", str2);
            return null;
        }
        return (String) invokeLLLL.objValue;
    }

    public static void n(ArrayList<ZipEntry> arrayList, ArrayList<ZipEntry> arrayList2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65550, null, arrayList, arrayList2) == null) || arrayList == null || arrayList2 == null) {
            return;
        }
        Iterator<ZipEntry> it = arrayList2.iterator();
        while (it.hasNext()) {
            ZipEntry next = it.next();
            if (!b(arrayList, next)) {
                arrayList.add(next);
            }
        }
    }

    public static void o(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, intent) == null) {
            PluginSetting pluginSetting = null;
            if (intent == null) {
                c.a.d.i.h.a.b().o("plugin_install", "handle_intent_null", null);
                return;
            }
            String action = intent.getAction();
            if (action == null) {
                c.a.d.i.h.a.b().o("plugin_install", "intent_action_null", null);
                return;
            }
            a = intent.getBooleanExtra("is_debug_plugin", false);
            if (action.equals(PluginInstallerService.ACTION_INSTALL)) {
                String stringExtra = intent.getStringExtra("install_src_file");
                String stringExtra2 = intent.getStringExtra("package_name");
                String stringExtra3 = intent.getStringExtra("install_flag");
                f2778c = stringExtra3;
                if (stringExtra3 == null) {
                    f2778c = "f" + System.currentTimeMillis();
                }
                c.a.d.i.h.a.b().m("plugin_install", "install_service_start", stringExtra2, f2778c);
                try {
                    pluginSetting = (PluginSetting) intent.getSerializableExtra("plugin_setting");
                } catch (Throwable unused) {
                }
                PluginSetting h2 = c.a.d.i.j.f.c.j().h(stringExtra2);
                if (h2 != null && h2.installStatus == 0 && h2.tempVersionCode == 0) {
                    int lastIndexOf = stringExtra.lastIndexOf("_");
                    int e2 = lastIndexOf > 0 ? c.a.d.f.m.b.e(stringExtra.substring(lastIndexOf + 1), -1) : -1;
                    if (h2.enable && h2.versionCode == e2) {
                        c.a.d.i.h.a.b().m("plugin_install", "setting_new_has_installed", stringExtra2, "pkgName_" + stringExtra2 + "-srcFile_" + stringExtra);
                        Intent intent2 = new Intent("com.baidu.adp.plugin.installrepeat");
                        intent2.setPackage(BdBaseApplication.getInst().getPackageName());
                        intent2.putExtra("package_name", stringExtra2);
                        intent2.putExtra("install_src_file", stringExtra);
                        BdBaseApplication.getInst().sendBroadcast(intent2);
                        return;
                    }
                }
                String str = stringExtra2 + stringExtra;
                if (f2777b.containsKey(str) && f2777b.get(str).booleanValue()) {
                    c.a.d.i.h.a.b().m("plugin_install", "plugin_has_installed", stringExtra2, "b_pkgName_" + stringExtra2 + "-srcFile_" + stringExtra);
                    Intent intent3 = new Intent("com.baidu.adp.plugin.installrepeat");
                    intent3.setPackage(BdBaseApplication.getInst().getPackageName());
                    intent3.putExtra("package_name", stringExtra2);
                    intent3.putExtra("install_src_file", stringExtra);
                    BdBaseApplication.getInst().sendBroadcast(intent3);
                    return;
                }
                f(stringExtra, stringExtra2, pluginSetting);
                return;
            }
            c.a.d.i.h.a.b().o("plugin_install", "intent_action_name_not_match", null);
        }
    }

    public static void p(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65552, null, str, str2, str3, str4) == null) {
            Intent intent = new Intent("com.baidu.adp.plugin.installfail");
            intent.setPackage(BdBaseApplication.getInst().getPackageName());
            intent.putExtra("install_src_file", str);
            intent.putExtra("fail_reason", str3);
            intent.putExtra("package_name", str2);
            intent.putExtra("install_comment", str4);
            intent.putExtra("install_flag", f2778c);
            try {
                BdBaseApplication.getInst().sendBroadcast(intent);
            } catch (Throwable th) {
                c.a.d.i.h.a.b().m("plugin_install", "sendbroadcast_fail", str2, th.getMessage());
            }
        }
    }

    public static Util.a q(String str, String str2) {
        InterceptResult invokeLL;
        Signature[] signatureArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, str, str2)) == null) {
            Util.a aVar = new Util.a();
            if (f2781f == null) {
                try {
                    f2781f = BdBaseApplication.getInst().getPackageManager().getPackageInfo(BdBaseApplication.getInst().getPackageName(), 64).signatures;
                } catch (Throwable th) {
                    c.a.d.i.h.a.b().m("plugin_install", "getmainsign_frompm_fail", str, th.getMessage());
                }
            }
            try {
                signatureArr = BdBaseApplication.getInst().getPackageManager().getPackageArchiveInfo(str2, 64).signatures;
            } catch (Throwable th2) {
                c.a.d.i.h.a.b().m("plugin_install", "getpluginsign_frompm_fail", str, th2.getMessage());
                signatureArr = null;
            }
            if (signatureArr == null) {
                try {
                    signatureArr = e.a(str2, aVar);
                    if (signatureArr != null) {
                        c.a.d.i.h.a.b().m("plugin_install", "collectCertificates_ok", str, null);
                    }
                } catch (Throwable th3) {
                    aVar.f32120b += "-exception_" + th3.toString();
                    return aVar;
                }
            }
            if (signatureArr == null) {
                aVar.f32120b = "get_newsignatures_null_" + str2;
                return aVar;
            }
            Signature[] signatureArr2 = f2781f;
            if (signatureArr2 == null) {
                File file = new File(BdBaseApplication.getInst().getPackageCodePath());
                if (file.exists()) {
                    try {
                        signatureArr2 = e.a(file.getAbsolutePath(), aVar);
                        f2781f = signatureArr2;
                    } catch (Throwable th4) {
                        aVar.f32120b += "-exception_" + th4.toString();
                        return aVar;
                    }
                }
            }
            int a2 = Util.a(signatureArr2, signatureArr);
            if (a2 == 0) {
                aVar.a = true;
                return aVar;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("mainsign");
            if (signatureArr2 != null) {
                try {
                    for (Signature signature : signatureArr2) {
                        if (signature != null) {
                            sb.append("_");
                            sb.append(signature.toCharsString());
                        }
                    }
                } catch (Throwable th5) {
                    sb.append(th5.getMessage());
                }
            }
            sb.append("_pluginsign");
            if (signatureArr != null) {
                try {
                    for (Signature signature2 : signatureArr) {
                        if (signature2 != null) {
                            sb.append("_");
                            sb.append(signature2.toCharsString());
                        }
                    }
                } catch (Throwable th6) {
                    sb.append(th6.getMessage());
                }
            }
            aVar.f32120b = "compare_signatures_fail_" + a2 + "_" + sb.toString();
            return aVar;
        }
        return (Util.a) invokeLL.objValue;
    }
}
