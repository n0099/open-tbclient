package com.baidu.adp.plugin.install;

import android.app.IntentService;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.os.StatFs;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.util.Util;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
/* loaded from: classes.dex */
public class PluginInstallerService extends IntentService {
    public static final String ACTION_INSTALL = "com.baidu.adp.plugin.action.install";
    public static final String ACTION_UNINSTALL = "com.baidu.adp.plugin.action.uninstall";
    public static final String APK_LIB_SUFFIX = ".so";
    public static final String APK_LIB_DIR_PREFIX = "lib/";
    public static int APK_LIB_CPUABI_OFFSITE = APK_LIB_DIR_PREFIX.length();

    public PluginInstallerService() {
        super(PluginInstallerService.class.getSimpleName());
    }

    public PluginInstallerService(String str) {
        super(str);
    }

    @Override // android.app.IntentService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.IntentService, android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }

    @Override // android.app.IntentService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        String action;
        if (intent != null && (action = intent.getAction()) != null && action.equals(ACTION_INSTALL)) {
            handleInstall(intent.getStringExtra("install_src_file"), intent.getStringExtra("package_name"));
        }
    }

    private void handleInstall(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            setInstallFail(str, str2, "srcfile_empty", "");
            com.baidu.adp.plugin.b.a.hU().g("plugin_install", "srcfile_empty", str2);
        } else if (str.startsWith("assets://")) {
            installBuildinApk(str, str2);
        } else if (str.startsWith("file://")) {
            installAPKFile(str, str2);
        } else {
            setInstallFail(str, str2, "srcfile_illegal", "");
            com.baidu.adp.plugin.b.a.hU().g("plugin_install", "srcfile_illegal", str2);
        }
    }

    private void installBuildinApk(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            InputStream inputStream = null;
            try {
                inputStream = getAssets().open(str.substring("assets://".length()));
                doInstall(inputStream, str, str2);
            } catch (Exception e) {
                BdLog.e(e);
                setInstallFail(str, str2, "open_assets", "");
                com.baidu.adp.plugin.b.a.hU().c("plugin_install", "open_assets_failed", str2, String.valueOf(e.getMessage()) + "---" + e.getClass().getName());
            } finally {
                com.baidu.adp.lib.g.a.d(inputStream);
            }
        }
    }

    private void installAPKFile(String str, String str2) {
        FileInputStream fileInputStream;
        if (!TextUtils.isEmpty(str)) {
            try {
                fileInputStream = new FileInputStream(new File(str.substring("file://".length())));
                try {
                    try {
                        doInstall(fileInputStream, str, str2);
                        com.baidu.adp.lib.g.a.d(fileInputStream);
                    } catch (Exception e) {
                        e = e;
                        BdLog.e(e);
                        setInstallFail(str, str2, "open_apk", "");
                        com.baidu.adp.plugin.b.a.hU().c("plugin_install", "open_files_failed", str2, String.valueOf(e.getMessage()) + "---" + e.getClass().getName());
                        com.baidu.adp.lib.g.a.d(fileInputStream);
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.g.a.d(fileInputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                com.baidu.adp.lib.g.a.d(fileInputStream);
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [316=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:101:0x0342 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0188  */
    /* JADX WARN: Type inference failed for: r4v16, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v19, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String doInstall(InputStream inputStream, String str, String str2) {
        String str3;
        String str4;
        String str5;
        boolean z;
        int i;
        int i2;
        String str6;
        boolean z2;
        String str7;
        String str8;
        String str9;
        NamedNodeMap attributes;
        Node namedItem;
        Node namedItem2;
        FileInputStream fileInputStream;
        if (inputStream == null || str == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(Util.iE(), String.valueOf(System.currentTimeMillis()));
        String b = Util.b(inputStream, file);
        if (!TextUtils.isEmpty(b)) {
            try {
                file.delete();
            } catch (Exception e) {
                BdLog.e(e);
            }
            setInstallFail(str, str2, "copy_temp_fail", b);
            return null;
        }
        com.baidu.adp.plugin.b.a.hU().a("plugin_copy_file", System.currentTimeMillis() - currentTimeMillis, str2);
        String str10 = null;
        String str11 = null;
        boolean z3 = false;
        int i3 = 0;
        PackageInfo packageArchiveInfo = getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 128);
        if (packageArchiveInfo == null || packageArchiveInfo.applicationInfo == null || packageArchiveInfo.applicationInfo.metaData == null) {
            try {
                ZipFile zipFile = new ZipFile(file, 1);
                Element documentElement = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(zipFile.getInputStream(zipFile.getEntry("assets/AndroidManifest.xml")))).getDocumentElement();
                String attribute = documentElement.getAttribute("package");
                i3 = Integer.parseInt(documentElement.getAttribute("android:versionCode"));
                String attribute2 = documentElement.getAttribute("android:versionName");
                try {
                    NodeList elementsByTagName = documentElement.getElementsByTagName("meta-data");
                    for (int i4 = 0; i4 < elementsByTagName.getLength(); i4++) {
                        try {
                            Node item = elementsByTagName.item(i4);
                            if (item != null && (attributes = item.getAttributes()) != null && (namedItem = attributes.getNamedItem("android:name")) != null && namedItem.getNodeValue() != null) {
                                if (namedItem.getNodeValue().equals("is_inject_classloader")) {
                                    Node namedItem3 = attributes.getNamedItem("android:value");
                                    if (namedItem3 != null && namedItem3.getNodeValue() != null) {
                                        z3 = Boolean.parseBoolean(namedItem3.getNodeValue());
                                    }
                                } else if (namedItem.getNodeValue().equals("require_load")) {
                                    Node namedItem4 = attributes.getNamedItem("android:value");
                                    if (namedItem4 != null && namedItem4.getNodeValue() != null) {
                                        str10 = namedItem4.getNodeValue();
                                    }
                                } else if (namedItem.getNodeValue().equals("cmd_range_0") && (namedItem2 = attributes.getNamedItem("android:value")) != null && namedItem2.getNodeValue() != null) {
                                    str11 = namedItem2.getNodeValue();
                                }
                            }
                        } catch (Exception e2) {
                            str3 = str11;
                            str4 = attribute2;
                            str5 = str10;
                            z = z3;
                            i = i3;
                            i2 = i;
                            str6 = str4;
                            z2 = z;
                            str7 = str3;
                            str8 = str5;
                            str9 = null;
                            if (!TextUtils.isEmpty(str9)) {
                            }
                        }
                    }
                    i2 = i3;
                    str6 = attribute2;
                    z2 = z3;
                    str7 = str11;
                    str8 = str10;
                    str9 = attribute;
                } catch (Exception e3) {
                    str3 = null;
                    str4 = attribute2;
                    str5 = null;
                    z = false;
                    i = i3;
                }
            } catch (Exception e4) {
                int i5 = i3;
                str3 = null;
                str4 = null;
                str5 = null;
                z = false;
                i = i5;
            }
            if (!TextUtils.isEmpty(str9)) {
                try {
                    file.delete();
                } catch (Exception e5) {
                    BdLog.e(e5);
                }
                setInstallFail(str, str2, "getpackageinfo_fail", "avirom-" + getAvailableRomSize() + "-filesize-" + file.length());
                return null;
            }
            com.baidu.adp.lib.stats.f.es().eventStat(BdBaseApplication.getInst().getApp(), "plugin_xml_parse", null, 1, new Object[0]);
        } else {
            str9 = packageArchiveInfo.packageName;
            str8 = Util.b(packageArchiveInfo.applicationInfo);
            str7 = Util.a(packageArchiveInfo.applicationInfo);
            z2 = Util.c(packageArchiveInfo.applicationInfo);
            str6 = packageArchiveInfo.versionName;
            i2 = packageArchiveInfo.versionCode;
        }
        if (str.startsWith("assets://")) {
            if (!str9.equals(str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk")))) {
                file.delete();
                setInstallFail(str, str9, "filename_packagename_not_match", null);
                BdLog.e(String.valueOf(str) + " must be named with it's package name : " + str9 + ".apk");
                return null;
            }
        }
        String str12 = String.valueOf(str9) + "-" + System.currentTimeMillis();
        File file2 = new File(Util.iE(), String.valueOf(str12) + ".apk");
        ?? equals = file.getParent().equals(file2.getParent());
        if (equals != 0) {
            file.renameTo(file2);
        } else {
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        String b2 = Util.b(fileInputStream, file2);
                        file.delete();
                        if (!TextUtils.isEmpty(b2)) {
                            setInstallFail(str, str9, "copy_todest_fail", null);
                            com.baidu.adp.lib.g.a.d(fileInputStream);
                            return null;
                        }
                        com.baidu.adp.lib.g.a.d(fileInputStream);
                    } catch (Exception e6) {
                        e = e6;
                        BdLog.e(e);
                        if (file2.exists()) {
                            file2.delete();
                        }
                        setInstallFail(str, str9, "copy_todest_fail", null);
                        com.baidu.adp.lib.g.a.d(fileInputStream);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.g.a.d(equals);
                    throw th;
                }
            } catch (Exception e7) {
                e = e7;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                equals = 0;
                com.baidu.adp.lib.g.a.d(equals);
                throw th;
            }
        }
        File file3 = new File(Util.iE(), str12);
        try {
            file3.mkdir();
        } catch (Exception e8) {
            BdLog.e(e8);
        }
        File file4 = new File(file3, "lib");
        try {
            file4.mkdir();
        } catch (Exception e9) {
            BdLog.e(e9);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        installNativeLibrary(file2.getAbsolutePath(), file4.getAbsolutePath());
        com.baidu.adp.plugin.b.a.hU().a("plugin_extract_so", System.currentTimeMillis() - currentTimeMillis2, str9);
        long currentTimeMillis3 = System.currentTimeMillis();
        installDex(file2.getAbsolutePath(), str9, file3);
        com.baidu.adp.plugin.b.a.hU().a("plugin_extract_dex", System.currentTimeMillis() - currentTimeMillis3, str9);
        Intent intent = new Intent("com.baidu.adp.plugin.installed");
        intent.setPackage(getPackageName());
        intent.putExtra("package_name", str9);
        intent.putExtra("install_src_file", str);
        intent.putExtra("install_dest_file", file2.getAbsolutePath());
        intent.putExtra("version_code", i2);
        intent.putExtra("version_name", str6);
        intent.putExtra("cmd_range", str7);
        intent.putExtra("require_load", str8);
        intent.putExtra("is_inject_classloader", z2);
        sendBroadcast(intent);
        return str9;
    }

    private void setInstallFail(String str, String str2, String str3, String str4) {
        Intent intent = new Intent("com.baidu.adp.plugin.installfail");
        intent.setPackage(getPackageName());
        intent.putExtra("install_src_file", str);
        intent.putExtra("fail_reason", str3);
        intent.putExtra("package_name", str2);
        intent.putExtra("install_comment", str4);
        sendBroadcast(intent);
    }

    private static void installNativeLibrary(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = Build.CPU_ABI.toLowerCase();
            ZipFile zipFile = null;
            try {
                zipFile = new ZipFile(str);
            } catch (IOException e) {
                BdLog.e(e);
            }
            if (zipFile != null) {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    String name = nextElement.getName();
                    if (name.startsWith(APK_LIB_DIR_PREFIX) && name.endsWith(APK_LIB_SUFFIX)) {
                        String substring = name.substring(APK_LIB_CPUABI_OFFSITE, name.lastIndexOf("/"));
                        if (substring.toLowerCase().contains("mips")) {
                            arrayList3.add(nextElement);
                        } else if (substring.toLowerCase().contains("x86")) {
                            arrayList2.add(nextElement);
                        } else {
                            arrayList.add(nextElement);
                        }
                    }
                }
                if (lowerCase.contains("x86")) {
                    mergeSo(arrayList2, arrayList);
                    extractSo(zipFile, str2, arrayList2);
                } else if (lowerCase.contains("mips")) {
                    mergeSo(arrayList3, arrayList);
                    extractSo(zipFile, str2, arrayList3);
                } else {
                    extractSo(zipFile, str2, arrayList);
                }
            }
        }
    }

    private static void mergeSo(ArrayList<ZipEntry> arrayList, ArrayList<ZipEntry> arrayList2) {
        if (arrayList != null && arrayList2 != null) {
            Iterator<ZipEntry> it = arrayList2.iterator();
            while (it.hasNext()) {
                ZipEntry next = it.next();
                if (!containsSo(arrayList, next)) {
                    arrayList.add(next);
                }
            }
        }
    }

    private static boolean containsSo(ArrayList<ZipEntry> arrayList, ZipEntry zipEntry) {
        if (arrayList == null || zipEntry == null) {
            return false;
        }
        String name = zipEntry.getName();
        Iterator<ZipEntry> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private static void extractSo(ZipFile zipFile, String str, ArrayList<ZipEntry> arrayList) {
        if (zipFile != null && arrayList != null && arrayList.size() != 0) {
            Iterator<ZipEntry> it = arrayList.iterator();
            while (it.hasNext()) {
                ZipEntry next = it.next();
                InputStream inputStream = null;
                try {
                    String name = next.getName();
                    int lastIndexOf = name.lastIndexOf("/");
                    inputStream = zipFile.getInputStream(next);
                    Util.b(inputStream, new File(str, name.substring(lastIndexOf)));
                } catch (IOException e) {
                    BdLog.e(e);
                } finally {
                    com.baidu.adp.lib.g.a.d(inputStream);
                }
            }
        }
    }

    private void installDex(String str, String str2, File file) {
        DexClassLoader dexClassLoader;
        if (file != null) {
            try {
                dexClassLoader = new DexClassLoader(str, file.getAbsolutePath(), null, getClassLoader());
            } catch (Exception e) {
                com.baidu.adp.plugin.b.a.hU().c("plugin_install", "new_dexloader", str2, String.valueOf(e.getMessage()) + "---" + e.getClass().getName());
                BdLog.e(e);
                dexClassLoader = null;
            }
            if (dexClassLoader != null) {
                try {
                    dexClassLoader.loadClass(String.valueOf(str2) + ".Static");
                } catch (ClassNotFoundException e2) {
                    com.baidu.adp.plugin.b.a.hU().c("plugin_install", "loadR", str2, e2.getMessage());
                    BdLog.e(e2);
                } catch (Exception e3) {
                    com.baidu.adp.plugin.b.a.hU().c("plugin_install", "loadR2", str2, String.valueOf(e3.getMessage()) + "---" + e3.getClass().getName());
                    BdLog.e(e3);
                }
            }
        }
    }

    private boolean verifySignature(String str, String str2) {
        Signature[] bw = com.baidu.adp.plugin.util.f.bw(str2);
        if (bw == null) {
            return false;
        }
        File aX = c.aX(str);
        if (aX == null || !aX.exists()) {
            return true;
        }
        Signature[] bw2 = com.baidu.adp.plugin.util.f.bw(aX.getAbsolutePath());
        return bw2 != null && Util.a(bw2, bw) == 0;
    }

    private static long getAvailableRomSize() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Exception e) {
            BdLog.e(e);
            return 0L;
        }
    }
}
