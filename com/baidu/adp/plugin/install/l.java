package com.baidu.adp.plugin.install;

import android.app.ActivityManager;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.o;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.util.Util;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import dalvik.system.DexClassLoader;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.security.cert.CertificateEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
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
public class l {
    private static boolean Dz = false;
    private static boolean DA = false;
    private static boolean DB = false;
    private static boolean DC = false;
    private static boolean DD = false;
    private static Signature[] DE = null;

    public static void onHandleIntent(Intent intent) {
        PluginSetting pluginSetting;
        if (intent == null) {
            com.baidu.adp.plugin.b.a.jk().f("plugin_install", "handle_intent_null", null);
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            com.baidu.adp.plugin.b.a.jk().f("plugin_install", "intent_action_null", null);
            return;
        }
        Dz = intent.getBooleanExtra("is_debug_plugin", false);
        if (action.equals(PluginInstallerService.ACTION_INSTALL)) {
            String stringExtra = intent.getStringExtra("install_src_file");
            String stringExtra2 = intent.getStringExtra("package_name");
            try {
                pluginSetting = (PluginSetting) intent.getSerializableExtra("plugin_setting");
            } catch (Throwable th) {
                pluginSetting = null;
            }
            a(stringExtra, stringExtra2, pluginSetting);
            return;
        }
        com.baidu.adp.plugin.b.a.jk().f("plugin_install", "intent_action_name_not_match", null);
    }

    private static void a(String str, String str2, PluginSetting pluginSetting) {
        if (TextUtils.isEmpty(str)) {
            d(str, str2, "srcfile_empty", "");
            com.baidu.adp.plugin.b.a.jk().f("plugin_install", "srcfile_empty", str2);
        } else if (str.startsWith("assets://")) {
            b(str, str2, pluginSetting);
        } else if (str.startsWith(SkiaImageDecoder.FILE_PREFIX)) {
            c(str, str2, pluginSetting);
        } else {
            d(str, str2, "srcfile_illegal", "");
            com.baidu.adp.plugin.b.a.jk().f("plugin_install", "srcfile_illegal", str2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [207=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0024 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.baidu.adp.plugin.b.a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x00a7 -> B:19:0x0018). Please submit an issue!!! */
    private static void b(String str, String str2, PluginSetting pluginSetting) {
        if (TextUtils.isEmpty(str)) {
            d(str, str2, "do_install", "");
            com.baidu.adp.plugin.b.a.jk().f("plugin_install", "pkgname_null", str2);
            return;
        }
        String substring = str.substring("assets://".length());
        InputStream inputStream = null;
        try {
            inputStream = BdBaseApplication.getInst().getAssets().open(substring);
            if (Util.k(inputStream.available())) {
                a(inputStream, str, str2, pluginSetting);
                com.baidu.adp.lib.g.a.j(inputStream);
                substring = substring;
            } else {
                d(str, str2, "rom_size", String.valueOf(Util.km()));
            }
        } catch (Exception e) {
            BdLog.e(e);
            d(str, str2, "open_assets", "assetsPath-" + substring + "-exp-" + e.getMessage());
            com.baidu.adp.plugin.b.a jk = com.baidu.adp.plugin.b.a.jk();
            jk.f("plugin_install", "open_assets_failed", str2, String.valueOf(e.getMessage()) + "---" + e.getClass().getName());
        } finally {
            com.baidu.adp.lib.g.a.j(inputStream);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [297=6] */
    private static void c(String str, String str2, PluginSetting pluginSetting) {
        FileInputStream fileInputStream;
        int i;
        if (TextUtils.isEmpty(str)) {
            d(str, str2, "do_install", "");
            com.baidu.adp.plugin.b.a.jk().f("plugin_install", "pkgname_null", str2);
            return;
        }
        String substring = str.substring(SkiaImageDecoder.FILE_PREFIX.length());
        File file = new File(substring);
        FileInputStream fileInputStream2 = null;
        try {
            try {
                int lastIndexOf = substring.lastIndexOf("_");
                int g = lastIndexOf > 0 ? com.baidu.adp.lib.g.b.g(substring.substring(lastIndexOf + 1), -1) : -1;
                if (g > 0) {
                    if (g < PluginPackageManager.jw()) {
                        com.baidu.adp.plugin.b.a.jk().e("plugin_install", "low_version_code", str2, " vc=" + String.valueOf(g) + " tiebaVC=" + PluginPackageManager.jw());
                        Intent intent = new Intent("com.baidu.adp.plugin.deleted");
                        intent.setPackage(BdBaseApplication.getInst().getPackageName());
                        intent.putExtra("package_name", str2);
                        intent.putExtra("install_src_file", str);
                        intent.putExtra("fail_reason", "low_version_code");
                        intent.putExtra("version_code", g);
                        BdBaseApplication.getInst().sendBroadcast(intent);
                        com.baidu.adp.lib.g.a.j(null);
                        return;
                    } else if (pluginSetting != null && g == (i = pluginSetting.versionCode)) {
                        com.baidu.adp.plugin.b.a.jk().e("plugin_install", "versionCode_is_equals", pluginSetting.packageName, String.valueOf(i) + " to " + g + "-instapkpath-" + pluginSetting.apkPath + "-md5-" + pluginSetting.md5 + "-size-" + pluginSetting.size + "-newapkfile-" + file + "-size-" + file.length() + "-srcpath-" + str);
                        Intent intent2 = new Intent("com.baidu.adp.plugin.installcancel");
                        intent2.setPackage(BdBaseApplication.getInst().getPackageName());
                        intent2.putExtra("package_name", str2);
                        intent2.putExtra("install_src_file", str);
                        intent2.putExtra("install_dest_file", str);
                        intent2.putExtra("version_code", g);
                        BdStatisticsManager.getInstance().save();
                        BdBaseApplication.getInst().sendBroadcast(intent2);
                        com.baidu.adp.lib.g.a.j(null);
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
            if (Util.k(fileInputStream.available())) {
                a(fileInputStream, str, str2, pluginSetting);
                com.baidu.adp.lib.g.a.j(fileInputStream);
            } else {
                d(str, str2, "rom_size", String.valueOf(Util.km()));
                com.baidu.adp.lib.g.a.j(fileInputStream);
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream2 = fileInputStream;
            BdLog.e(e);
            d(str, str2, "open_apk", e.getMessage());
            com.baidu.adp.plugin.b.a.jk().f("plugin_install", "open_files_failed", str2, String.valueOf(e.getMessage()) + "---" + e.getClass().getName());
            com.baidu.adp.lib.g.a.j(fileInputStream2);
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            com.baidu.adp.lib.g.a.j(fileInputStream2);
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [614=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:233:0x07c0 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x04d1  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0101 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v14, types: [android.content.Intent] */
    /* JADX WARN: Type inference failed for: r2v25, types: [com.baidu.adp.base.BdBaseApplication] */
    /* JADX WARN: Type inference failed for: r5v17, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v25, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(InputStream inputStream, String str, String str2, PluginSetting pluginSetting) {
        boolean z;
        boolean z2;
        Exception exc;
        boolean z3;
        String str3;
        int i;
        String str4;
        boolean z4;
        String str5;
        String str6;
        String message;
        boolean z5;
        String str7;
        ZipFile zipFile;
        ZipEntry entry;
        NodeList elementsByTagName;
        NamedNodeMap attributes;
        Node namedItem;
        Node namedItem2;
        ?? r5;
        int lastIndexOf;
        int g;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        int i2;
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        FileInputStream fileInputStream3;
        com.baidu.adp.plugin.util.i l;
        String d;
        if (inputStream == null || str == null) {
            d(str, str2, "do_install", "");
            com.baidu.adp.plugin.b.a.jk().f("plugin_install", "doinstall_param_null", str2);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(Util.kl(), String.valueOf(System.currentTimeMillis()));
        String a = Util.a(inputStream, file);
        if (!TextUtils.isEmpty(a)) {
            try {
                file.delete();
            } catch (Exception e) {
                BdLog.e(e);
            }
            d(str, str2, "copy_temp_fail", a);
            return null;
        }
        com.baidu.adp.plugin.b.a.jk().a("plugin_copy_file", System.currentTimeMillis() - currentTimeMillis, str2);
        String str8 = null;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        String str9 = null;
        boolean z9 = false;
        long length = file.length();
        PackageInfo packageArchiveInfo = BdBaseApplication.getInst().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 128);
        if (packageArchiveInfo == null || packageArchiveInfo.applicationInfo == null || packageArchiveInfo.packageName == null || packageArchiveInfo.versionCode == 0) {
            try {
                zipFile = new ZipFile(file, 1);
                entry = zipFile.getEntry("assets/AndroidManifest.xml");
            } catch (Exception e2) {
                z = false;
                z2 = false;
                exc = e2;
                z3 = false;
                str3 = null;
                i = 0;
                str4 = null;
                z4 = false;
                str5 = null;
                str6 = null;
                message = exc.getMessage();
                z5 = z2;
                if (!TextUtils.isEmpty(str6)) {
                }
            }
            if (entry == null) {
                try {
                    file.delete();
                } catch (Exception e3) {
                    BdLog.e(e3);
                }
                d(str, str2, "assetsmanifestnull", "avirom-" + Util.km() + "-filesize-" + length + "-exp-" + ((String) null));
                return null;
            }
            Element documentElement = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(zipFile.getInputStream(entry))).getDocumentElement();
            str6 = documentElement.getAttribute("package");
            int parseInt = Integer.parseInt(documentElement.getAttribute("android:versionCode"));
            String attribute = documentElement.getAttribute("android:versionName");
            try {
                elementsByTagName = documentElement.getElementsByTagName("meta-data");
            } catch (Exception e4) {
                z = false;
                z2 = false;
                exc = e4;
                z3 = false;
                str3 = null;
                i = parseInt;
                str4 = null;
                z4 = false;
                str5 = attribute;
            }
            if (elementsByTagName != null) {
                if (elementsByTagName.getLength() > 0) {
                    for (int i3 = 0; i3 < elementsByTagName.getLength(); i3++) {
                        try {
                            Node item = elementsByTagName.item(i3);
                            if (item != null && (attributes = item.getAttributes()) != null && (namedItem = attributes.getNamedItem("android:name")) != null && namedItem.getNodeValue() != null) {
                                if (namedItem.getNodeValue().equals("is_inject_classloader")) {
                                    Node namedItem3 = attributes.getNamedItem("android:value");
                                    if (namedItem3 != null && namedItem3.getNodeValue() != null) {
                                        z9 = Boolean.parseBoolean(namedItem3.getNodeValue());
                                    }
                                } else if (namedItem.getNodeValue().equals("has_res")) {
                                    Node namedItem4 = attributes.getNamedItem("android:value");
                                    if (namedItem4 != null && namedItem4.getNodeValue() != null) {
                                        try {
                                            z6 = Boolean.parseBoolean(namedItem4.getNodeValue());
                                        } catch (Exception e5) {
                                        }
                                    }
                                } else if (namedItem.getNodeValue().equals("require_load")) {
                                    Node namedItem5 = attributes.getNamedItem("android:value");
                                    if (namedItem5 != null && namedItem5.getNodeValue() != null) {
                                        str8 = namedItem5.getNodeValue();
                                    }
                                } else if (namedItem.getNodeValue().equals("cmd_range_0")) {
                                    Node namedItem6 = attributes.getNamedItem("android:value");
                                    if (namedItem6 != null && namedItem6.getNodeValue() != null) {
                                        str9 = namedItem6.getNodeValue();
                                    }
                                } else if (namedItem.getNodeValue().equals("is_third")) {
                                    Node namedItem7 = attributes.getNamedItem("android:value");
                                    if (namedItem7 != null && namedItem7.getNodeValue() != null) {
                                        try {
                                            z7 = Boolean.parseBoolean(namedItem7.getNodeValue());
                                        } catch (Exception e6) {
                                        }
                                    }
                                } else if (namedItem.getNodeValue().equals("is_patch") && (namedItem2 = attributes.getNamedItem("android:value")) != null && namedItem2.getNodeValue() != null) {
                                    try {
                                        z8 = Boolean.parseBoolean(namedItem2.getNodeValue());
                                    } catch (Exception e7) {
                                    }
                                }
                            }
                        } catch (Exception e8) {
                            z = z7;
                            z2 = z9;
                            exc = e8;
                            z3 = z6;
                            str3 = str9;
                            i = parseInt;
                            str4 = str8;
                            z4 = z8;
                            str5 = attribute;
                            str6 = null;
                            message = exc.getMessage();
                            z5 = z2;
                            if (!TextUtils.isEmpty(str6)) {
                            }
                        }
                    }
                    z = z7;
                    z5 = z9;
                    message = null;
                    z3 = z6;
                    str3 = str9;
                    i = parseInt;
                    str4 = str8;
                    z4 = z8;
                    str5 = attribute;
                    if (!TextUtils.isEmpty(str6)) {
                        try {
                            file.delete();
                        } catch (Exception e9) {
                            BdLog.e(e9);
                        }
                        d(str, str2, "getpackageinfo_fail", "avirom-" + Util.km() + "-filesize-" + length + "-exp-" + message);
                        return null;
                    }
                    com.baidu.adp.plugin.b.a.jk().B("plugin_xml_parse", str6);
                    str7 = null;
                    r5 = z5;
                }
            }
            z = false;
            z5 = false;
            message = null;
            z3 = false;
            str3 = null;
            i = parseInt;
            str4 = null;
            z4 = false;
            str5 = attribute;
            if (!TextUtils.isEmpty(str6)) {
            }
        } else {
            str6 = packageArchiveInfo.packageName;
            str4 = Util.b(packageArchiveInfo.applicationInfo);
            z3 = Util.d(packageArchiveInfo.applicationInfo);
            z = Util.e(packageArchiveInfo.applicationInfo);
            str3 = Util.a(packageArchiveInfo.applicationInfo);
            boolean c = Util.c(packageArchiveInfo.applicationInfo);
            z4 = Util.f(packageArchiveInfo.applicationInfo);
            str7 = Util.g(packageArchiveInfo.applicationInfo);
            str5 = packageArchiveInfo.versionName;
            i = packageArchiveInfo.versionCode;
            r5 = c;
        }
        if (!BdBaseApplication.getInst().isDebugMode() && !Dz && (d = d(str6, file.getAbsolutePath(), pluginSetting)) != null) {
            try {
                file.delete();
            } catch (Exception e10) {
                BdLog.e(e10);
            }
            d(str, str6, "signature_not_match", String.valueOf(str6) + "_" + d);
            return null;
        } else if (pluginSetting != null && i == (i2 = pluginSetting.versionCode)) {
            if (str.startsWith("assets://")) {
                File file2 = new File(pluginSetting.apkPath);
                boolean exists = file2.exists();
                boolean isFile = file2.isFile();
                long length2 = file2.length();
                InputStream inputStream2 = null;
                try {
                    try {
                        fileInputStream3 = new FileInputStream(pluginSetting.apkPath);
                        try {
                            com.baidu.adp.plugin.util.i l2 = Util.l(fileInputStream3);
                            inputStream2 = BdBaseApplication.getInst().getAssets().open(str.substring("assets://".length()));
                            if (l2.compareTo(Util.l(inputStream2)) != 0) {
                                com.baidu.adp.plugin.b.a.jk().e("plugin_install", "versionequals_apktime_notequals", str6, String.valueOf(l2.toString()) + "-" + l.toString());
                            }
                            com.baidu.adp.lib.g.a.j(fileInputStream3);
                            com.baidu.adp.lib.g.a.j(inputStream2);
                        } catch (Exception e11) {
                            e = e11;
                            BdLog.e(e);
                            com.baidu.adp.plugin.b.a.jk().e("plugin_install", "versionequals_apktime_error", str6, "exist-" + exists + "-isfile-" + isFile + "-length-" + length2 + "-" + e.getMessage());
                            com.baidu.adp.lib.g.a.j(fileInputStream3);
                            com.baidu.adp.lib.g.a.j(inputStream2);
                            file.delete();
                            String str10 = null;
                            activityManager = (ActivityManager) BdBaseApplication.getInst().getSystemService("activity");
                            if (activityManager != null) {
                                while (r5.hasNext()) {
                                }
                            }
                            com.baidu.adp.plugin.b.a.jk().e("plugin_install", "versionCode_is_equals", pluginSetting.packageName, String.valueOf(i2) + " to " + i + "-instapkpath-" + pluginSetting.apkPath + "-md5-" + pluginSetting.md5 + "-size-" + pluginSetting.size + "-newapkfile-" + file + "-size-" + file.length() + "-srcpath-" + str + "-process-" + str10);
                            Intent intent = new Intent("com.baidu.adp.plugin.installcancel");
                            intent.setPackage(BdBaseApplication.getInst().getPackageName());
                            intent.putExtra("package_name", str6);
                            intent.putExtra("install_src_file", str);
                            intent.putExtra("install_dest_file", str);
                            intent.putExtra("version_code", i);
                            BdStatisticsManager.getInstance().save();
                            BdBaseApplication.getInst().sendBroadcast(intent);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.g.a.j(r5);
                        com.baidu.adp.lib.g.a.j(null);
                        throw th;
                    }
                } catch (Exception e12) {
                    e = e12;
                    fileInputStream3 = null;
                } catch (Throwable th2) {
                    th = th2;
                    r5 = 0;
                    com.baidu.adp.lib.g.a.j(r5);
                    com.baidu.adp.lib.g.a.j(null);
                    throw th;
                }
            }
            try {
                file.delete();
            } catch (Exception e13) {
                e13.printStackTrace();
            }
            String str102 = null;
            activityManager = (ActivityManager) BdBaseApplication.getInst().getSystemService("activity");
            if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo != null && runningAppProcessInfo.pid == Process.myPid()) {
                        str102 = runningAppProcessInfo.processName;
                    }
                }
            }
            com.baidu.adp.plugin.b.a.jk().e("plugin_install", "versionCode_is_equals", pluginSetting.packageName, String.valueOf(i2) + " to " + i + "-instapkpath-" + pluginSetting.apkPath + "-md5-" + pluginSetting.md5 + "-size-" + pluginSetting.size + "-newapkfile-" + file + "-size-" + file.length() + "-srcpath-" + str + "-process-" + str102);
            Intent intent2 = new Intent("com.baidu.adp.plugin.installcancel");
            intent2.setPackage(BdBaseApplication.getInst().getPackageName());
            intent2.putExtra("package_name", str6);
            intent2.putExtra("install_src_file", str);
            intent2.putExtra("install_dest_file", str);
            intent2.putExtra("version_code", i);
            BdStatisticsManager.getInstance().save();
            BdBaseApplication.getInst().sendBroadcast(intent2);
            return null;
        } else {
            if (str.startsWith("assets://")) {
                if (!str6.equals(str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk")))) {
                    file.delete();
                    d(str, str6, "filename_packagename_not_match", null);
                    BdLog.e(String.valueOf(str) + " must be named with it's package name : " + str6 + ".apk");
                    return null;
                }
            }
            String str11 = String.valueOf(str6) + "_" + System.currentTimeMillis() + "_" + i;
            File file3 = new File(Util.kl(), String.valueOf(str11) + ".apk");
            if (!file.equals(file3)) {
                if (file.getParent().equals(file3.getParent())) {
                    try {
                        if (!file.renameTo(file3)) {
                            throw new Exception("rename return fail");
                        }
                        if (!file3.exists() || file3.length() == 0) {
                            throw new Exception("rename fail");
                        }
                    } catch (Exception e14) {
                        BdLog.e(e14);
                        if (file.exists()) {
                            file.delete();
                        }
                        d(str, str6, "rename_todest_fail", e14.getMessage());
                        return null;
                    }
                } else {
                    try {
                        fileInputStream2 = new FileInputStream(file);
                    } catch (Exception e15) {
                        e = e15;
                        fileInputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = null;
                    }
                    try {
                        String a2 = Util.a(fileInputStream2, file3);
                        file.delete();
                        if (!TextUtils.isEmpty(a2)) {
                            d(str, str6, "copy_todest_fail", a2);
                            com.baidu.adp.lib.g.a.j(fileInputStream2);
                            return null;
                        }
                        com.baidu.adp.lib.g.a.j(fileInputStream2);
                    } catch (Exception e16) {
                        e = e16;
                        fileInputStream = fileInputStream2;
                        try {
                            BdLog.e(e);
                            if (file3.exists()) {
                                file3.delete();
                            }
                            d(str, str6, "copy_todest_fail", e != null ? e.getMessage() : null);
                            com.baidu.adp.lib.g.a.j(fileInputStream);
                            return null;
                        } catch (Throwable th4) {
                            th = th4;
                            com.baidu.adp.lib.g.a.j(fileInputStream);
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream = fileInputStream2;
                        com.baidu.adp.lib.g.a.j(fileInputStream);
                        throw th;
                    }
                }
            }
            File file4 = new File(Util.kl(), str11);
            try {
                file4.mkdir();
            } catch (Exception e17) {
                BdLog.e(e17);
            }
            File file5 = new File(file4, Plugin.SO_LIB_DIR_NAME);
            try {
                file5.mkdir();
            } catch (Exception e18) {
                BdLog.e(e18);
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            c(file3.getAbsolutePath(), file5.getAbsolutePath(), str6);
            com.baidu.adp.plugin.b.a.jk().a("plugin_extract_so", System.currentTimeMillis() - currentTimeMillis2, str6);
            long currentTimeMillis3 = System.currentTimeMillis();
            a(file3.getAbsolutePath(), str6, file4);
            com.baidu.adp.plugin.b.a.jk().a("plugin_extract_dex", System.currentTimeMillis() - currentTimeMillis3, str6);
            ?? intent3 = new Intent("com.baidu.adp.plugin.installed");
            intent3.setPackage(BdBaseApplication.getInst().getPackageName());
            intent3.putExtra("package_name", str6);
            intent3.putExtra("install_src_file", str);
            intent3.putExtra("install_dest_file", file3.getAbsolutePath());
            intent3.putExtra("version_code", i);
            intent3.putExtra("version_name", str5);
            intent3.putExtra("cmd_range", str3);
            intent3.putExtra("require_load", str4);
            intent3.putExtra("has_res", z3);
            intent3.putExtra("is_third", z);
            intent3.putExtra("is_patch", z4);
            intent3.putExtra("replace_method_classes", str7);
            intent3.putExtra("is_inject_classloader", r5);
            BdStatisticsManager.getInstance().save();
            BdBaseApplication.getInst().sendBroadcast(intent3);
            try {
                File[] listFiles = Util.kl().listFiles();
                if (listFiles != null) {
                    for (File file6 : listFiles) {
                        if (file6 != null && file6.isDirectory()) {
                            String name = file6.getName();
                            if (name.startsWith(str6) && !name.equals(str11) && (lastIndexOf = name.lastIndexOf("_")) > 0 && (g = com.baidu.adp.lib.g.b.g(name.substring(lastIndexOf + 1), -1)) > 0 && g == i) {
                                com.baidu.adp.plugin.b.a.jk().B("plugin_repeat_install", str6);
                                StringBuilder sb = new StringBuilder();
                                if (pluginSetting != null) {
                                    sb.append("-");
                                    sb.append(pluginSetting.apkPath);
                                    sb.append("-");
                                    sb.append(pluginSetting.versionCode);
                                    sb.append("-");
                                    sb.append(pluginSetting.tempVersionCode);
                                    sb.append("-");
                                    sb.append(pluginSetting.enable);
                                    sb.append("-");
                                    sb.append(pluginSetting.install_fail_count);
                                }
                                com.baidu.adp.plugin.b.a.jk().e("plugin_install", "plugin_repeat_install", str6, String.valueOf(file6.getAbsolutePath()) + "-" + file3.getAbsolutePath() + sb.toString());
                                return str6;
                            }
                        }
                    }
                    return str6;
                }
                return str6;
            } catch (Throwable th6) {
                return str6;
            }
        }
    }

    public static void d(String str, String str2, String str3, String str4) {
        Intent intent = new Intent("com.baidu.adp.plugin.installfail");
        intent.setPackage(BdBaseApplication.getInst().getPackageName());
        intent.putExtra("install_src_file", str);
        intent.putExtra("fail_reason", str3);
        intent.putExtra("package_name", str2);
        intent.putExtra("install_comment", str4);
        try {
            BdBaseApplication.getInst().sendBroadcast(intent);
        } catch (Throwable th) {
            com.baidu.adp.plugin.b.a.jk().e("plugin_install", "sendbroadcast_fail", str2, th.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void c(String str, String str2, String str3) {
        ZipFile zipFile;
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = Build.CPU_ABI.toLowerCase();
            String str4 = "none";
            if (Build.VERSION.SDK_INT > 7) {
                try {
                    str4 = ((String) Build.class.getDeclaredField("CPU_ABI2").get(Build.class)).toLowerCase();
                } catch (Throwable th) {
                    str4 = "none";
                    zipFile = null;
                    zipFile = new ZipFile(str);
                    if (zipFile == null) {
                    }
                }
            }
            zipFile = null;
            try {
                zipFile = new ZipFile(str);
            } catch (IOException e) {
                BdLog.e(e);
            }
            if (zipFile == null) {
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
                if (lowerCase.contains("x86") || str4.contains("x86")) {
                    a(arrayList2, arrayList);
                    a(zipFile, str2, arrayList2);
                    if (arrayList2.size() <= 0) {
                        return;
                    }
                } else if (lowerCase.contains("mips") || str4.contains("mips")) {
                    a(arrayList3, arrayList);
                    a(zipFile, str2, arrayList3);
                    if (arrayList3.size() <= 0) {
                        return;
                    }
                } else if (lowerCase.contains("armeabi-v7a") || str4.contains("armeabi-v7a") || jj()) {
                    a(arrayList4, arrayList);
                    a(zipFile, str2, arrayList4);
                    if (arrayList4.size() <= 0) {
                        return;
                    }
                } else if (lowerCase.contains("armeabi") || str4.contains("armeabi")) {
                    a(zipFile, str2, arrayList);
                    if (arrayList.size() <= 0) {
                        return;
                    }
                } else {
                    com.baidu.adp.plugin.b.a.jk().aV("plugin_cpuarch_judge_fail");
                    com.baidu.adp.plugin.b.a.jk().e("plugin_install", "cpuarch_judge_fail", str3, String.valueOf(lowerCase) + "-" + str4);
                    a(zipFile, str2, arrayList);
                    if (arrayList.size() <= 0) {
                        return;
                    }
                }
                File file = new File(str);
                File file2 = new File(file.getParentFile(), String.valueOf(file.getName()) + "_tmp");
                if (a(zipFile, new File(new File(str2).getParentFile(), "tmp"), file2, str3)) {
                    if (!file2.renameTo(file)) {
                        com.baidu.adp.plugin.b.a.jk().e("plugin_install", "delete_so", str3, "delete so suc but rename fail");
                        try {
                            file2.delete();
                            return;
                        } catch (Exception e2) {
                            return;
                        }
                    }
                    return;
                }
                com.baidu.adp.plugin.b.a.jk().e("plugin_install", "delete_so", str3, "delete so fail");
                try {
                    file2.delete();
                } catch (Exception e3) {
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [896=5, 897=5, 892=5, 893=5, 895=5] */
    private static final boolean a(ZipFile zipFile, File file, File file2, String str) {
        ZipOutputStream zipOutputStream;
        OutputStream outputStream;
        ZipOutputStream zipOutputStream2;
        InputStream inputStream;
        BufferedInputStream bufferedInputStream;
        InputStream inputStream2;
        File file3;
        byte[] bArr;
        OutputStream outputStream2 = null;
        ZipOutputStream zipOutputStream3 = null;
        try {
            try {
                file.mkdirs();
                com.baidu.adp.lib.util.e.i(file);
                file2.createNewFile();
                outputStream = new FileOutputStream(file2);
            } catch (Throwable th) {
                th = th;
            }
            try {
                zipOutputStream = new ZipOutputStream(outputStream);
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile.entries();
                    while (entries.hasMoreElements()) {
                        ZipEntry nextElement = entries.nextElement();
                        try {
                            String name = nextElement.getName();
                            if (name.startsWith(PluginInstallerService.APK_LIB_DIR_PREFIX)) {
                                o.j(null);
                                o.j(null);
                            } else {
                                inputStream = zipFile.getInputStream(nextElement);
                                try {
                                    file3 = new File(file, name);
                                    file3.getParentFile().mkdirs();
                                    Util.a(inputStream, file3);
                                    bArr = new byte[4096];
                                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file3), 4096);
                                } catch (IOException e) {
                                    e = e;
                                    bufferedInputStream = null;
                                    inputStream2 = inputStream;
                                } catch (Throwable th2) {
                                    th = th2;
                                    bufferedInputStream = null;
                                }
                                try {
                                    ZipEntry zipEntry = new ZipEntry(file3.getAbsolutePath().substring(file.getAbsolutePath().length() + 1));
                                    if (zipEntry.getName().equals("resources.arsc")) {
                                        zipEntry.setMethod(0);
                                        zipEntry.setSize(file3.length());
                                        zipEntry.setCompressedSize(zipEntry.getSize());
                                        zipEntry.setCrc(nextElement.getCrc());
                                    }
                                    zipOutputStream.putNextEntry(zipEntry);
                                    while (true) {
                                        int read = bufferedInputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        zipOutputStream.write(bArr, 0, read);
                                    }
                                    bufferedInputStream.close();
                                    zipOutputStream.flush();
                                    zipOutputStream.closeEntry();
                                    o.j(inputStream);
                                    o.j(bufferedInputStream);
                                } catch (IOException e2) {
                                    e = e2;
                                    inputStream2 = inputStream;
                                    try {
                                        throw e;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        inputStream = inputStream2;
                                        o.j(inputStream);
                                        o.j(bufferedInputStream);
                                        throw th;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    o.j(inputStream);
                                    o.j(bufferedInputStream);
                                    throw th;
                                }
                            }
                        } catch (IOException e3) {
                            e = e3;
                            inputStream2 = null;
                            bufferedInputStream = null;
                        } catch (Throwable th5) {
                            th = th5;
                            inputStream = null;
                            bufferedInputStream = null;
                        }
                    }
                    o.d(zipOutputStream);
                    o.d(outputStream);
                    try {
                        com.baidu.adp.lib.util.e.i(file);
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    return true;
                } catch (ZipException e5) {
                    e = e5;
                    zipOutputStream3 = zipOutputStream;
                    outputStream2 = outputStream;
                    try {
                        com.baidu.adp.plugin.b.a.jk().e("plugin_install", "delete_so", str, e.getMessage());
                        o.d(zipOutputStream3);
                        o.d(outputStream2);
                        try {
                            com.baidu.adp.lib.util.e.i(file);
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                        return false;
                    } catch (Throwable th6) {
                        th = th6;
                        zipOutputStream2 = zipOutputStream3;
                        outputStream = outputStream2;
                        o.d(zipOutputStream2);
                        o.d(outputStream);
                        try {
                            com.baidu.adp.lib.util.e.i(file);
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                        throw th;
                    }
                } catch (IOException e8) {
                    e = e8;
                    com.baidu.adp.plugin.b.a.jk().e("plugin_install", "delete_so", str, e.getMessage());
                    o.d(zipOutputStream);
                    o.d(outputStream);
                    try {
                        com.baidu.adp.lib.util.e.i(file);
                    } catch (IOException e9) {
                        e9.printStackTrace();
                    }
                    return false;
                } catch (Throwable th7) {
                    th = th7;
                    com.baidu.adp.plugin.b.a.jk().e("plugin_install", "delete_so", str, th.getMessage());
                    o.d(zipOutputStream);
                    o.d(outputStream);
                    try {
                        com.baidu.adp.lib.util.e.i(file);
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                    return false;
                }
            } catch (ZipException e11) {
                e = e11;
                outputStream2 = outputStream;
            } catch (IOException e12) {
                e = e12;
                zipOutputStream = null;
            } catch (Throwable th8) {
                th = th8;
                zipOutputStream2 = null;
                o.d(zipOutputStream2);
                o.d(outputStream);
                com.baidu.adp.lib.util.e.i(file);
                throw th;
            }
        } catch (ZipException e13) {
            e = e13;
        } catch (IOException e14) {
            e = e14;
            zipOutputStream = null;
            outputStream = null;
        } catch (Throwable th9) {
            th = th9;
            zipOutputStream = null;
            outputStream = null;
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
                    com.baidu.adp.lib.g.a.j(inputStream);
                }
            }
        }
    }

    public static boolean ji() {
        String str;
        if (DB) {
            return DA;
        }
        DB = true;
        String lowerCase = Build.CPU_ABI.toLowerCase();
        if (Build.VERSION.SDK_INT <= 7) {
            str = "none";
        } else {
            try {
                try {
                    str = ((String) Build.class.getDeclaredField("CPU_ABI2").get(Build.class)).toLowerCase();
                } catch (Throwable th) {
                }
            } catch (Throwable th2) {
                str = "none";
            }
        }
        if (lowerCase.contains("armeabi-v7a") || str.contains("armeabi-v7a") || jj()) {
            DA = true;
        } else if (lowerCase.contains("armeabi") || str.contains("armeabi")) {
            DA = true;
        }
        return DA;
    }

    public static boolean jj() {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        InputStreamReader inputStreamReader2 = null;
        if (DD) {
            return DC;
        }
        DD = true;
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
                DC = ((Integer) objArr[1]).intValue() == 7;
                o.a(bufferedReader);
                o.a(inputStreamReader);
                o.j(fileInputStream);
            } catch (Exception e3) {
                e = e3;
                inputStreamReader2 = inputStreamReader;
                fileInputStream2 = fileInputStream;
                try {
                    BdLog.e(e);
                    o.a(bufferedReader);
                    o.a(inputStreamReader2);
                    o.j(fileInputStream2);
                    return DC;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = fileInputStream2;
                    inputStreamReader = inputStreamReader2;
                    o.a(bufferedReader);
                    o.a(inputStreamReader);
                    o.j(fileInputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                o.a(bufferedReader);
                o.a(inputStreamReader);
                o.j(fileInputStream);
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
        return DC;
    }

    private static void a(String str, String str2, File file) {
        DexClassLoader dexClassLoader;
        if (file != null) {
            File file2 = new File(str);
            if (!file2.exists()) {
                com.baidu.adp.plugin.b.a.jk().e("plugin_install", "dexopt_file_illegal", str2, file2.getAbsolutePath());
            }
            if (file2.length() == 0) {
                com.baidu.adp.plugin.b.a.jk().e("plugin_install", "dexopt_file_empty", str2, String.valueOf(file2.getAbsolutePath()) + "---" + file2.length());
            }
            try {
                dexClassLoader = new DexClassLoader(str, file.getAbsolutePath(), null, BdBaseApplication.getInst().getClassLoader());
            } catch (Exception e) {
                com.baidu.adp.plugin.b.a.jk().e("plugin_install", "new_dexloader", str2, String.valueOf(e.getMessage()) + "---" + e.getClass().getName());
                BdLog.e(e);
                dexClassLoader = null;
            }
            if (dexClassLoader != null) {
                try {
                    dexClassLoader.loadClass(String.valueOf(str2) + ".Static");
                } catch (ClassNotFoundException e2) {
                    com.baidu.adp.plugin.b.a.jk().e("plugin_install", "loadR", str2, e2.getMessage());
                    BdLog.e(e2);
                } catch (Exception e3) {
                    com.baidu.adp.plugin.b.a.jk().e("plugin_install", "loadR2", str2, String.valueOf(e3.getMessage()) + "---" + e3.getClass().getName());
                    BdLog.e(e3);
                }
            }
        }
    }

    private static String d(String str, String str2, PluginSetting pluginSetting) {
        Signature[] signatureArr;
        Signature[] bv;
        File file;
        if (DE == null) {
            try {
                DE = BdBaseApplication.getInst().getPackageManager().getPackageInfo(BdBaseApplication.getInst().getPackageName(), 64).signatures;
            } catch (Throwable th) {
                com.baidu.adp.plugin.b.a.jk().e("plugin_install", "getmainsign_frompm_fail", str, th.getMessage());
            }
        }
        try {
            signatureArr = BdBaseApplication.getInst().getPackageManager().getPackageArchiveInfo(str2, 64).signatures;
        } catch (Throwable th2) {
            com.baidu.adp.plugin.b.a.jk().e("plugin_install", "getpluginsign_frompm_fail", str, th2.getMessage());
            signatureArr = null;
        }
        if (signatureArr == null) {
            try {
                bv = com.baidu.adp.plugin.util.h.bv(str2);
            } catch (IOException e) {
                return e.getMessage();
            } catch (CertificateEncodingException e2) {
                return e2.getMessage();
            } catch (Throwable th3) {
                return th3.getMessage();
            }
        } else {
            bv = signatureArr;
        }
        if (bv == null) {
            return "get_newsignatures_null_" + str2;
        }
        Signature[] signatureArr2 = DE;
        if (signatureArr2 == null && (file = new File(BdBaseApplication.getInst().getPackageCodePath())) != null && file.exists()) {
            try {
                signatureArr2 = com.baidu.adp.plugin.util.h.bv(file.getAbsolutePath());
                DE = signatureArr2;
            } catch (IOException e3) {
                return e3.getMessage();
            } catch (CertificateEncodingException e4) {
                return e4.getMessage();
            } catch (Throwable th4) {
                return th4.getMessage();
            }
        }
        int a = Util.a(signatureArr2, bv);
        if (a == 0) {
            return null;
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
        if (bv != null) {
            try {
                for (Signature signature2 : bv) {
                    if (signature2 != null) {
                        sb.append("_");
                        sb.append(signature2.toCharsString());
                    }
                }
            } catch (Throwable th6) {
                sb.append(th6.getMessage());
            }
        }
        return "compare_signatures_fail_" + a + "_" + sb.toString();
    }
}
