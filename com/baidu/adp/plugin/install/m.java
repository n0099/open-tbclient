package com.baidu.adp.plugin.install;

import android.app.ActivityManager;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.o;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.util.Util;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import dalvik.system.DexClassLoader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
/* loaded from: classes.dex */
public class m {
    private static boolean CW = false;
    private static boolean CX = false;

    public static void onHandleIntent(Intent intent) {
        if (intent == null) {
            com.baidu.adp.plugin.b.a.lF().g("plugin_install", "handle_intent_null", null);
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            com.baidu.adp.plugin.b.a.lF().g("plugin_install", "intent_action_null", null);
        } else if (action.equals(PluginInstallerService.ACTION_INSTALL)) {
            D(intent.getStringExtra("install_src_file"), intent.getStringExtra("package_name"));
        } else {
            com.baidu.adp.plugin.b.a.lF().g("plugin_install", "intent_action_name_not_match", null);
        }
    }

    private static void D(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            c(str, str2, "srcfile_empty", "");
            com.baidu.adp.plugin.b.a.lF().g("plugin_install", "srcfile_empty", str2);
        } else if (str.startsWith("assets://")) {
            E(str, str2);
        } else if (str.startsWith(SkiaImageDecoder.FILE_PREFIX)) {
            F(str, str2);
        } else {
            c(str, str2, "srcfile_illegal", "");
            com.baidu.adp.plugin.b.a.lF().g("plugin_install", "srcfile_illegal", str2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [189=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0024 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.baidu.adp.plugin.b.a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x00a7 -> B:19:0x0018). Please submit an issue!!! */
    private static void E(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            c(str, str2, "do_install", "");
            com.baidu.adp.plugin.b.a.lF().g("plugin_install", "pkgname_null", str2);
            return;
        }
        String substring = str.substring("assets://".length());
        InputStream inputStream = null;
        try {
            inputStream = BdBaseApplication.getInst().getAssets().open(substring);
            if (Util.j(inputStream.available())) {
                a(inputStream, str, str2);
                com.baidu.adp.lib.g.a.d(inputStream);
                substring = substring;
            } else {
                c(str, str2, "rom_size", String.valueOf(Util.mx()));
            }
        } catch (Exception e) {
            BdLog.e(e);
            c(str, str2, "open_assets", "assetsPath-" + substring + "-exp-" + e.getMessage());
            com.baidu.adp.plugin.b.a lF = com.baidu.adp.plugin.b.a.lF();
            lF.e("plugin_install", "open_assets_failed", str2, String.valueOf(e.getMessage()) + "---" + e.getClass().getName());
        } finally {
            com.baidu.adp.lib.g.a.d(inputStream);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=6] */
    private static void F(String str, String str2) {
        FileInputStream fileInputStream;
        PluginSetting bn;
        String str3;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        FileInputStream fileInputStream2 = null;
        if (TextUtils.isEmpty(str)) {
            c(str, str2, "do_install", "");
            com.baidu.adp.plugin.b.a.lF().g("plugin_install", "pkgname_null", str2);
            return;
        }
        String substring = str.substring(SkiaImageDecoder.FILE_PREFIX.length());
        File file = new File(substring);
        try {
            try {
                int lastIndexOf = substring.lastIndexOf("_");
                int g = lastIndexOf > 0 ? com.baidu.adp.lib.g.b.g(substring.substring(lastIndexOf + 1), -1) : -1;
                if (g > 0 && (bn = PluginPackageManager.lR().bn(str2)) != null) {
                    int i = bn.versionCode;
                    if (g < i) {
                        c(str, str2, "versionCode_is_low", String.valueOf(i) + " to " + g);
                        com.baidu.adp.lib.g.a.d(null);
                        return;
                    } else if (g == i) {
                        ActivityManager activityManager = (ActivityManager) BdBaseApplication.getInst().getSystemService("activity");
                        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                            str3 = null;
                        } else {
                            String str4 = null;
                            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                                if (runningAppProcessInfo != null && runningAppProcessInfo.pid == Process.myPid()) {
                                    str4 = runningAppProcessInfo.processName;
                                }
                            }
                            str3 = str4;
                        }
                        com.baidu.adp.plugin.b.a.lF().d("plugin_install", "versionCode_is_equals", bn.packageName, String.valueOf(i) + " to " + g + "-instapkpath-" + bn.apkPath + "-md5-" + bn.md5 + "-size-" + bn.size + "-newapkfile-" + file + "-size-" + file.length() + "-srcpath-" + str + "-process-" + str3);
                        Intent intent = new Intent("com.baidu.adp.plugin.installcancel");
                        intent.setPackage(BdBaseApplication.getInst().getPackageName());
                        intent.putExtra("package_name", str2);
                        intent.putExtra("install_src_file", str);
                        intent.putExtra("install_dest_file", str);
                        intent.putExtra("version_code", g);
                        com.baidu.adp.lib.stats.a.hi().save();
                        BdBaseApplication.getInst().sendBroadcast(intent);
                        com.baidu.adp.lib.g.a.d(null);
                        return;
                    }
                }
                fileInputStream = new FileInputStream(file);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (Util.j(fileInputStream.available())) {
                a(fileInputStream, str, str2);
                com.baidu.adp.lib.g.a.d(fileInputStream);
            } else {
                c(str, str2, "rom_size", String.valueOf(Util.mx()));
                com.baidu.adp.lib.g.a.d(fileInputStream);
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream2 = fileInputStream;
            BdLog.e(e);
            c(str, str2, "open_apk", e.getMessage());
            com.baidu.adp.plugin.b.a.lF().e("plugin_install", "open_files_failed", str2, String.valueOf(e.getMessage()) + "---" + e.getClass().getName());
            com.baidu.adp.lib.g.a.d(fileInputStream2);
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            com.baidu.adp.lib.g.a.d(fileInputStream2);
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [590=4] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x00ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0219  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(InputStream inputStream, String str, String str2) {
        String str3;
        int i;
        boolean z;
        String str4;
        String str5;
        boolean z2;
        Exception exc;
        String str6;
        String message;
        ZipFile zipFile;
        ZipEntry entry;
        NodeList elementsByTagName;
        NamedNodeMap attributes;
        Node namedItem;
        Node namedItem2;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        FileInputStream fileInputStream3;
        com.baidu.adp.plugin.util.g f;
        com.baidu.adp.plugin.util.g f2;
        if (inputStream == null || str == null) {
            c(str, str2, "do_install", "");
            com.baidu.adp.plugin.b.a.lF().g("plugin_install", "doinstall_param_null", str2);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(Util.mw(), String.valueOf(System.currentTimeMillis()));
        String a = Util.a(inputStream, file);
        if (!TextUtils.isEmpty(a)) {
            try {
                file.delete();
            } catch (Exception e) {
                BdLog.e(e);
            }
            c(str, str2, "copy_temp_fail", a);
            return null;
        }
        com.baidu.adp.plugin.b.a.lF().a("plugin_copy_file", System.currentTimeMillis() - currentTimeMillis, str2);
        String str7 = null;
        boolean z3 = false;
        String str8 = null;
        boolean z4 = false;
        long length = file.length();
        PackageInfo packageArchiveInfo = BdBaseApplication.getInst().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 128);
        if (packageArchiveInfo == null || packageArchiveInfo.applicationInfo == null || packageArchiveInfo.packageName == null || packageArchiveInfo.versionCode == 0) {
            try {
                zipFile = new ZipFile(file, 1);
                entry = zipFile.getEntry("assets/AndroidManifest.xml");
            } catch (Exception e2) {
                str3 = null;
                i = 0;
                z = false;
                str4 = null;
                str5 = null;
                z2 = false;
                exc = e2;
            }
            if (entry == null) {
                try {
                    file.delete();
                } catch (Exception e3) {
                    BdLog.e(e3);
                }
                c(str, str2, "assetsmanifestnull", "avirom-" + Util.mx() + "-filesize-" + length + "-exp-" + ((String) null));
                return null;
            }
            Element documentElement = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(zipFile.getInputStream(entry))).getDocumentElement();
            str6 = documentElement.getAttribute("package");
            int parseInt = Integer.parseInt(documentElement.getAttribute("android:versionCode"));
            String attribute = documentElement.getAttribute("android:versionName");
            try {
                elementsByTagName = documentElement.getElementsByTagName("meta-data");
            } catch (Exception e4) {
                str3 = null;
                i = parseInt;
                z = false;
                str4 = attribute;
                str5 = null;
                z2 = false;
                exc = e4;
            }
            if (elementsByTagName != null) {
                if (elementsByTagName.getLength() > 0) {
                    for (int i2 = 0; i2 < elementsByTagName.getLength(); i2++) {
                        try {
                            Node item = elementsByTagName.item(i2);
                            if (item != null && (attributes = item.getAttributes()) != null && (namedItem = attributes.getNamedItem("android:name")) != null && namedItem.getNodeValue() != null) {
                                if (namedItem.getNodeValue().equals("is_inject_classloader")) {
                                    Node namedItem3 = attributes.getNamedItem("android:value");
                                    if (namedItem3 != null && namedItem3.getNodeValue() != null) {
                                        z4 = Boolean.parseBoolean(namedItem3.getNodeValue());
                                    }
                                } else if (namedItem.getNodeValue().equals("has_res")) {
                                    Node namedItem4 = attributes.getNamedItem("android:value");
                                    if (namedItem4 != null && namedItem4.getNodeValue() != null) {
                                        try {
                                            z3 = Boolean.parseBoolean(namedItem4.getNodeValue());
                                        } catch (Exception e5) {
                                        }
                                    }
                                } else if (namedItem.getNodeValue().equals("require_load")) {
                                    Node namedItem5 = attributes.getNamedItem("android:value");
                                    if (namedItem5 != null && namedItem5.getNodeValue() != null) {
                                        str7 = namedItem5.getNodeValue();
                                    }
                                } else if (namedItem.getNodeValue().equals("cmd_range_0") && (namedItem2 = attributes.getNamedItem("android:value")) != null && namedItem2.getNodeValue() != null) {
                                    str8 = namedItem2.getNodeValue();
                                }
                            }
                        } catch (Exception e6) {
                            str3 = str8;
                            i = parseInt;
                            z = z3;
                            str4 = attribute;
                            str5 = str7;
                            z2 = z4;
                            exc = e6;
                            str6 = null;
                            message = exc.getMessage();
                            if (TextUtils.isEmpty(str6)) {
                            }
                        }
                    }
                    str3 = str8;
                    i = parseInt;
                    z = z3;
                    str4 = attribute;
                    str5 = str7;
                    z2 = z4;
                    message = null;
                    if (TextUtils.isEmpty(str6)) {
                        try {
                            file.delete();
                        } catch (Exception e7) {
                            BdLog.e(e7);
                        }
                        c(str, str2, "getpackageinfo_fail", "avirom-" + Util.mx() + "-filesize-" + length + "-exp-" + message);
                        return null;
                    }
                    com.baidu.adp.plugin.b.a.lF().I("plugin_xml_parse", str6);
                }
            }
            str3 = null;
            i = parseInt;
            z = false;
            str4 = attribute;
            str5 = null;
            z2 = false;
            message = null;
            if (TextUtils.isEmpty(str6)) {
            }
        } else {
            str6 = packageArchiveInfo.packageName;
            str5 = Util.b(packageArchiveInfo.applicationInfo);
            z = Util.d(packageArchiveInfo.applicationInfo);
            str3 = Util.a(packageArchiveInfo.applicationInfo);
            z2 = Util.c(packageArchiveInfo.applicationInfo);
            str4 = packageArchiveInfo.versionName;
            i = packageArchiveInfo.versionCode;
        }
        PluginSetting bn = PluginPackageManager.lR().bn(str6);
        if (bn != null) {
            int i3 = bn.versionCode;
            if (i < i3) {
                try {
                    file.delete();
                } catch (Exception e8) {
                    e8.printStackTrace();
                }
                c(str, str6, "versionCode_is_low", String.valueOf(i3) + " to " + i);
                return null;
            } else if (i == i3) {
                if (str.startsWith("assets://")) {
                    File file2 = new File(bn.apkPath);
                    boolean exists = file2.exists();
                    boolean isFile = file2.isFile();
                    long length2 = file2.length();
                    try {
                        fileInputStream3 = new FileInputStream(bn.apkPath);
                        try {
                            try {
                                if (Util.f(fileInputStream3).compareTo(Util.f(BdBaseApplication.getInst().getAssets().open(str.substring("assets://".length())))) != 0) {
                                    com.baidu.adp.plugin.b.a.lF().d("plugin_install", "versionequals_apktime_notequals", str6, String.valueOf(f.toString()) + "-" + f2.toString());
                                }
                                com.baidu.adp.lib.g.a.d(fileInputStream3);
                            } catch (Exception e9) {
                                e = e9;
                                BdLog.e(e);
                                com.baidu.adp.plugin.b.a.lF().d("plugin_install", "versionequals_apktime_error", str6, "exist-" + exists + "-isfile-" + isFile + "-length-" + length2 + "-" + e.getMessage());
                                com.baidu.adp.lib.g.a.d(fileInputStream3);
                                file.delete();
                                String str9 = null;
                                activityManager = (ActivityManager) BdBaseApplication.getInst().getSystemService("activity");
                                if (activityManager != null) {
                                    while (r5.hasNext()) {
                                    }
                                }
                                com.baidu.adp.plugin.b.a.lF().d("plugin_install", "versionCode_is_equals", bn.packageName, String.valueOf(i3) + " to " + i + "-instapkpath-" + bn.apkPath + "-md5-" + bn.md5 + "-size-" + bn.size + "-newapkfile-" + file + "-size-" + file.length() + "-srcpath-" + str + "-process-" + str9);
                                Intent intent = new Intent("com.baidu.adp.plugin.installcancel");
                                intent.setPackage(BdBaseApplication.getInst().getPackageName());
                                intent.putExtra("package_name", str6);
                                intent.putExtra("install_src_file", str);
                                intent.putExtra("install_dest_file", str);
                                intent.putExtra("version_code", i);
                                com.baidu.adp.lib.stats.a.hi().save();
                                BdBaseApplication.getInst().sendBroadcast(intent);
                                return null;
                            }
                        } catch (Throwable th) {
                            th = th;
                            com.baidu.adp.lib.g.a.d(fileInputStream3);
                            throw th;
                        }
                    } catch (Exception e10) {
                        e = e10;
                        fileInputStream3 = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream3 = null;
                        com.baidu.adp.lib.g.a.d(fileInputStream3);
                        throw th;
                    }
                }
                try {
                    file.delete();
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                String str92 = null;
                activityManager = (ActivityManager) BdBaseApplication.getInst().getSystemService("activity");
                if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo != null && runningAppProcessInfo.pid == Process.myPid()) {
                            str92 = runningAppProcessInfo.processName;
                        }
                    }
                }
                com.baidu.adp.plugin.b.a.lF().d("plugin_install", "versionCode_is_equals", bn.packageName, String.valueOf(i3) + " to " + i + "-instapkpath-" + bn.apkPath + "-md5-" + bn.md5 + "-size-" + bn.size + "-newapkfile-" + file + "-size-" + file.length() + "-srcpath-" + str + "-process-" + str92);
                Intent intent2 = new Intent("com.baidu.adp.plugin.installcancel");
                intent2.setPackage(BdBaseApplication.getInst().getPackageName());
                intent2.putExtra("package_name", str6);
                intent2.putExtra("install_src_file", str);
                intent2.putExtra("install_dest_file", str);
                intent2.putExtra("version_code", i);
                com.baidu.adp.lib.stats.a.hi().save();
                BdBaseApplication.getInst().sendBroadcast(intent2);
                return null;
            }
        }
        if (str.startsWith("assets://")) {
            if (!str6.equals(str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk")))) {
                file.delete();
                c(str, str6, "filename_packagename_not_match", null);
                BdLog.e(String.valueOf(str) + " must be named with it's package name : " + str6 + ".apk");
                return null;
            }
        }
        String str10 = String.valueOf(str6) + "_" + System.currentTimeMillis() + "_" + i;
        File file3 = new File(Util.mw(), String.valueOf(str10) + ".apk");
        if (!file.equals(file3)) {
            if (file.getParent().equals(file3.getParent())) {
                try {
                    if (!file.renameTo(file3)) {
                        throw new Exception("rename return fail");
                    }
                    if (!file3.exists() || file3.length() == 0) {
                        throw new Exception("rename fail");
                    }
                } catch (Exception e12) {
                    BdLog.e(e12);
                    if (file.exists()) {
                        file.delete();
                    }
                    c(str, str6, "rename_todest_fail", e12.getMessage());
                    return null;
                }
            } else {
                try {
                    fileInputStream2 = new FileInputStream(file);
                } catch (Exception e13) {
                    e = e13;
                    fileInputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                }
                try {
                    String a2 = Util.a(fileInputStream2, file3);
                    file.delete();
                    if (!TextUtils.isEmpty(a2)) {
                        c(str, str6, "copy_todest_fail", a2);
                        com.baidu.adp.lib.g.a.d(fileInputStream2);
                        return null;
                    }
                    com.baidu.adp.lib.g.a.d(fileInputStream2);
                } catch (Exception e14) {
                    e = e14;
                    fileInputStream = fileInputStream2;
                    try {
                        BdLog.e(e);
                        if (file3.exists()) {
                            file3.delete();
                        }
                        c(str, str6, "copy_todest_fail", e != null ? e.getMessage() : null);
                        com.baidu.adp.lib.g.a.d(fileInputStream);
                        return null;
                    } catch (Throwable th4) {
                        th = th4;
                        com.baidu.adp.lib.g.a.d(fileInputStream);
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = fileInputStream2;
                    com.baidu.adp.lib.g.a.d(fileInputStream);
                    throw th;
                }
            }
        }
        File file4 = new File(Util.mw(), str10);
        try {
            file4.mkdir();
        } catch (Exception e15) {
            BdLog.e(e15);
        }
        File file5 = new File(file4, "lib");
        try {
            file5.mkdir();
        } catch (Exception e16) {
            BdLog.e(e16);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        G(file3.getAbsolutePath(), file5.getAbsolutePath());
        com.baidu.adp.plugin.b.a.lF().a("plugin_extract_so", System.currentTimeMillis() - currentTimeMillis2, str6);
        long currentTimeMillis3 = System.currentTimeMillis();
        a(file3.getAbsolutePath(), str6, file4);
        com.baidu.adp.plugin.b.a.lF().a("plugin_extract_dex", System.currentTimeMillis() - currentTimeMillis3, str6);
        Intent intent3 = new Intent("com.baidu.adp.plugin.installed");
        intent3.setPackage(BdBaseApplication.getInst().getPackageName());
        intent3.putExtra("package_name", str6);
        intent3.putExtra("install_src_file", str);
        intent3.putExtra("install_dest_file", file3.getAbsolutePath());
        intent3.putExtra("version_code", i);
        intent3.putExtra("version_name", str4);
        intent3.putExtra("cmd_range", str3);
        intent3.putExtra("require_load", str5);
        intent3.putExtra("has_res", z);
        intent3.putExtra("is_inject_classloader", z2);
        com.baidu.adp.lib.stats.a.hi().save();
        BdBaseApplication.getInst().sendBroadcast(intent3);
        return str6;
    }

    public static void c(String str, String str2, String str3, String str4) {
        Intent intent = new Intent("com.baidu.adp.plugin.installfail");
        intent.setPackage(BdBaseApplication.getInst().getPackageName());
        intent.putExtra("install_src_file", str);
        intent.putExtra("fail_reason", str3);
        intent.putExtra("package_name", str2);
        intent.putExtra("install_comment", str4);
        BdBaseApplication.getInst().sendBroadcast(intent);
    }

    private static void G(String str, String str2) {
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
                ArrayList arrayList4 = new ArrayList();
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    String name = nextElement.getName();
                    if (name.startsWith(PluginInstallerService.APK_LIB_DIR_PREFIX) && name.endsWith(PluginInstallerService.APK_LIB_SUFFIX)) {
                        String substring = name.substring(PluginInstallerService.APK_LIB_CPUABI_OFFSITE, name.lastIndexOf("/"));
                        if (substring.toLowerCase().contains("mips")) {
                            arrayList3.add(nextElement);
                        } else if (substring.toLowerCase().contains("x86")) {
                            arrayList2.add(nextElement);
                        } else if (substring.toLowerCase().contains("armeabi-v7a")) {
                            arrayList4.add(nextElement);
                        } else {
                            arrayList.add(nextElement);
                        }
                    }
                }
                if (lowerCase.contains("x86")) {
                    a(arrayList2, arrayList);
                    a(zipFile, str2, arrayList2);
                } else if (lowerCase.contains("mips")) {
                    a(arrayList3, arrayList);
                    a(zipFile, str2, arrayList3);
                } else if (lE()) {
                    a(arrayList4, arrayList);
                    a(zipFile, str2, arrayList4);
                } else {
                    a(zipFile, str2, arrayList);
                }
            }
        }
    }

    private static void a(ArrayList<ZipEntry> arrayList, ArrayList<ZipEntry> arrayList2) {
        if (arrayList != null && arrayList2 != null) {
            Iterator<ZipEntry> it = arrayList2.iterator();
            while (it.hasNext()) {
                ZipEntry next = it.next();
                if (!a(arrayList, next)) {
                    arrayList.add(next);
                }
            }
        }
    }

    private static boolean a(ArrayList<ZipEntry> arrayList, ZipEntry zipEntry) {
        if (arrayList == null || zipEntry == null) {
            return false;
        }
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
        return false;
    }

    private static void a(ZipFile zipFile, String str, ArrayList<ZipEntry> arrayList) {
        if (zipFile != null && arrayList != null && arrayList.size() != 0) {
            Iterator<ZipEntry> it = arrayList.iterator();
            while (it.hasNext()) {
                ZipEntry next = it.next();
                InputStream inputStream = null;
                try {
                    String name = next.getName();
                    int lastIndexOf = name.lastIndexOf("/");
                    inputStream = zipFile.getInputStream(next);
                    Util.a(inputStream, new File(str, name.substring(lastIndexOf)));
                } catch (IOException e) {
                    BdLog.e(e);
                } finally {
                    com.baidu.adp.lib.g.a.d(inputStream);
                }
            }
        }
    }

    public static boolean lE() {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        InputStreamReader inputStreamReader2 = null;
        if (CX) {
            return CW;
        }
        CX = true;
        try {
            fileInputStream = new FileInputStream("/proc/cpuinfo");
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                } catch (Exception e) {
                    e = e;
                    bufferedReader = null;
                    inputStreamReader2 = inputStreamReader;
                    fileInputStream2 = fileInputStream;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = null;
                }
            } catch (Exception e2) {
                e = e2;
                bufferedReader = null;
                fileInputStream2 = fileInputStream;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
                inputStreamReader = null;
            }
            try {
                Object[] objArr = {-1, -1, -1};
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.split(":");
                    if (split.length == 2) {
                        String trim = split[0].trim();
                        String trim2 = split[1].trim();
                        if (trim.compareTo("Processor") == 0) {
                            StringBuilder sb = new StringBuilder();
                            for (int indexOf = trim2.indexOf("ARMv") + 4; indexOf < trim2.length(); indexOf++) {
                                String sb2 = new StringBuilder(String.valueOf(trim2.charAt(indexOf))).toString();
                                if (!sb2.matches("\\d")) {
                                    break;
                                }
                                sb.append(sb2);
                            }
                            objArr[0] = "ARM";
                            objArr[1] = Integer.valueOf(com.baidu.adp.lib.g.b.g(sb.toString(), -1));
                        } else if (trim.compareToIgnoreCase("Features") == 0) {
                            if (trim2.contains("neon")) {
                                objArr[2] = "neon";
                            }
                        } else if (trim.compareToIgnoreCase("model name") == 0) {
                            if (trim2.contains("Intel")) {
                                objArr[0] = "INTEL";
                                objArr[2] = "atom";
                            }
                        } else if (trim.compareToIgnoreCase("cpu family") == 0) {
                            objArr[1] = Integer.valueOf(com.baidu.adp.lib.g.b.g(trim2, -1));
                        }
                    }
                }
                CW = ((Integer) objArr[1]).intValue() == 7;
                o.a(bufferedReader);
                o.a(inputStreamReader);
                o.d(fileInputStream);
            } catch (Exception e3) {
                e = e3;
                inputStreamReader2 = inputStreamReader;
                fileInputStream2 = fileInputStream;
                try {
                    BdLog.e(e);
                    o.a(bufferedReader);
                    o.a(inputStreamReader2);
                    o.d(fileInputStream2);
                    return CW;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = fileInputStream2;
                    inputStreamReader = inputStreamReader2;
                    o.a(bufferedReader);
                    o.a(inputStreamReader);
                    o.d(fileInputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                o.a(bufferedReader);
                o.a(inputStreamReader);
                o.d(fileInputStream);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            bufferedReader = null;
            fileInputStream2 = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            inputStreamReader = null;
            fileInputStream = null;
        }
        return CW;
    }

    private static void a(String str, String str2, File file) {
        DexClassLoader dexClassLoader;
        if (file != null) {
            File file2 = new File(str);
            if (!file2.exists()) {
                com.baidu.adp.plugin.b.a.lF().d("plugin_install", "dexopt_file_illegal", str2, file2.getAbsolutePath());
            }
            if (file2.length() == 0) {
                com.baidu.adp.plugin.b.a.lF().d("plugin_install", "dexopt_file_empty", str2, String.valueOf(file2.getAbsolutePath()) + "---" + file2.length());
            }
            try {
                dexClassLoader = new DexClassLoader(str, file.getAbsolutePath(), null, BdBaseApplication.getInst().getClassLoader());
            } catch (Exception e) {
                com.baidu.adp.plugin.b.a.lF().d("plugin_install", "new_dexloader", str2, String.valueOf(e.getMessage()) + "---" + e.getClass().getName());
                BdLog.e(e);
                dexClassLoader = null;
            }
            if (dexClassLoader != null) {
                try {
                    dexClassLoader.loadClass(String.valueOf(str2) + ".Static");
                } catch (ClassNotFoundException e2) {
                    com.baidu.adp.plugin.b.a.lF().d("plugin_install", "loadR", str2, e2.getMessage());
                    BdLog.e(e2);
                } catch (Exception e3) {
                    com.baidu.adp.plugin.b.a.lF().d("plugin_install", "loadR2", str2, String.valueOf(e3.getMessage()) + "---" + e3.getClass().getName());
                    BdLog.e(e3);
                }
            }
        }
    }
}
