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
import com.baidu.adp.lib.util.n;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.util.Util;
import com.baidu.adp.plugin.util.e;
import com.baidu.adp.plugin.util.f;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.pass.biometrics.base.utils.PhoneUtils;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
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
import java.io.Reader;
import java.security.cert.CertificateEncodingException;
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
    private static boolean Iu = false;
    private static Map<String, Boolean> Iv = new HashMap();
    private static boolean Iw = false;
    private static boolean Ix = false;
    private static boolean Iy = false;
    private static boolean Iz = false;
    private static Signature[] IA = null;

    public static void onHandleIntent(Intent intent) {
        PluginSetting pluginSetting = null;
        if (intent == null) {
            com.baidu.adp.plugin.b.a.mc().g("plugin_install", "handle_intent_null", null);
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            com.baidu.adp.plugin.b.a.mc().g("plugin_install", "intent_action_null", null);
            return;
        }
        Iu = intent.getBooleanExtra("is_debug_plugin", false);
        if (action.equals(PluginInstallerService.ACTION_INSTALL)) {
            String stringExtra = intent.getStringExtra("install_src_file");
            String stringExtra2 = intent.getStringExtra(Constants.PACKAGE_NAME);
            try {
                pluginSetting = (PluginSetting) intent.getSerializableExtra("plugin_setting");
            } catch (Throwable th) {
            }
            String str = stringExtra2 + stringExtra;
            if (Iv.containsKey(str) && Iv.get(str).booleanValue()) {
                com.baidu.adp.plugin.b.a.mc().f("plugin_install", "plugin_has_installed", stringExtra2, "pkgName_" + stringExtra2 + "-srcFile_" + stringExtra);
                return;
            } else {
                a(stringExtra, stringExtra2, pluginSetting);
                return;
            }
        }
        com.baidu.adp.plugin.b.a.mc().g("plugin_install", "intent_action_name_not_match", null);
    }

    private static void a(String str, String str2, PluginSetting pluginSetting) {
        if (TextUtils.isEmpty(str)) {
            e(str, str2, "srcfile_empty", "");
            com.baidu.adp.plugin.b.a.mc().g("plugin_install", "srcfile_empty", str2);
        } else if (str.startsWith("assets://")) {
            b(str, str2, pluginSetting);
        } else if (str.startsWith(SkiaImageDecoder.FILE_PREFIX)) {
            c(str, str2, pluginSetting);
        } else {
            e(str, str2, "srcfile_illegal", "");
            com.baidu.adp.plugin.b.a.mc().g("plugin_install", "srcfile_illegal", str2);
        }
    }

    private static void b(String str, String str2, PluginSetting pluginSetting) {
        if (TextUtils.isEmpty(str)) {
            e(str, str2, "do_install", "");
            com.baidu.adp.plugin.b.a.mc().g("plugin_install", "pkgname_null", str2);
            return;
        }
        String substring = str.substring("assets://".length());
        InputStream inputStream = null;
        try {
            inputStream = BdBaseApplication.getInst().getAssets().open(substring);
            if (!Util.p(inputStream.available())) {
                e(str, str2, "rom_size", String.valueOf(Util.ni()));
            } else {
                a(inputStream, str, str2, pluginSetting);
                com.baidu.adp.lib.g.a.g(inputStream);
            }
        } catch (Exception e) {
            BdLog.e(e);
            e(str, str2, "open_assets", "assetsPath-" + substring + "-exp-" + e.getMessage());
            com.baidu.adp.plugin.b.a.mc().g("plugin_install", "open_assets_failed", str2, e.getMessage() + "---" + e.getClass().getName());
        } finally {
            com.baidu.adp.lib.g.a.g(inputStream);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [344=5] */
    private static void c(String str, String str2, PluginSetting pluginSetting) {
        FileInputStream fileInputStream;
        int i;
        int i2;
        if (TextUtils.isEmpty(str)) {
            e(str, str2, "do_install", "");
            com.baidu.adp.plugin.b.a.mc().g("plugin_install", "pkgname_null", str2);
            return;
        }
        String substring = str.substring(SkiaImageDecoder.FILE_PREFIX.length());
        File file = new File(substring);
        String str3 = str2 + str;
        if (Iv.containsKey(str3) && !file.exists() && Iv.get(str3).booleanValue()) {
            com.baidu.adp.plugin.b.a.mc().f("plugin_install", "plugin_has_installed", str2, "pkgName_" + str2 + "-srcFile_" + str);
            Intent intent = new Intent("com.baidu.adp.plugin.installrepeat");
            intent.setPackage(BdBaseApplication.getInst().getPackageName());
            intent.putExtra(Constants.PACKAGE_NAME, str2);
            intent.putExtra("install_src_file", str);
            BdBaseApplication.getInst().sendBroadcast(intent);
        } else if (!file.exists()) {
            e(str, str2, "open_apk", "file_not_exists-apkFilePath_" + substring);
        } else {
            int i3 = 0;
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    int lastIndexOf = substring.lastIndexOf("_");
                    int f = lastIndexOf > 0 ? com.baidu.adp.lib.g.b.f(substring.substring(lastIndexOf + 1), -1) : -1;
                    if (f > 0) {
                        if (f < PluginPackageManager.mr()) {
                            com.baidu.adp.plugin.b.a.mc().f("plugin_install", "low_version_code", str2, " vc=" + String.valueOf(f) + " tiebaVC=" + PluginPackageManager.mr());
                            Intent intent2 = new Intent("com.baidu.adp.plugin.deleted");
                            intent2.setPackage(BdBaseApplication.getInst().getPackageName());
                            intent2.putExtra(Constants.PACKAGE_NAME, str2);
                            intent2.putExtra("install_src_file", str);
                            intent2.putExtra("fail_reason", "low_version_code");
                            intent2.putExtra("version_code", f);
                            BdBaseApplication.getInst().sendBroadcast(intent2);
                            com.baidu.adp.lib.g.a.g(null);
                            return;
                        } else if (pluginSetting != null && f == (i2 = pluginSetting.versionCode)) {
                            com.baidu.adp.plugin.b.a.mc().f("plugin_install", "versionCode_is_equals", pluginSetting.packageName, i2 + " to " + f + "-instapkpath-" + pluginSetting.apkPath + "-md5-" + pluginSetting.md5 + "-size-" + pluginSetting.size + "-newapkfile-" + file + "-size-" + file.length() + "-srcpath-" + str);
                            Intent intent3 = new Intent("com.baidu.adp.plugin.installcancel");
                            intent3.setPackage(BdBaseApplication.getInst().getPackageName());
                            intent3.putExtra(Constants.PACKAGE_NAME, str2);
                            intent3.putExtra("install_src_file", str);
                            intent3.putExtra("install_dest_file", str);
                            intent3.putExtra("version_code", f);
                            BdStatisticsManager.getInstance().save();
                            BdBaseApplication.getInst().sendBroadcast(intent3);
                            com.baidu.adp.lib.g.a.g(null);
                            return;
                        }
                    }
                    try {
                        fileInputStream = new FileInputStream(file);
                        i = 2;
                    } catch (Exception e) {
                        e = e;
                        i3 = 1;
                    }
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                e = e2;
            }
            try {
                if (Util.p(fileInputStream.available())) {
                    i = 3;
                    a(fileInputStream, str, str2, pluginSetting);
                    com.baidu.adp.lib.g.a.g(fileInputStream);
                } else {
                    e(str, str2, "rom_size", String.valueOf(Util.ni()));
                    com.baidu.adp.lib.g.a.g(fileInputStream);
                }
            } catch (Exception e3) {
                e = e3;
                i3 = i;
                fileInputStream2 = fileInputStream;
                BdLog.e(e);
                e(str, str2, "open_apk", e.getMessage());
                com.baidu.adp.plugin.b.a.mc().g("plugin_install", "open_files_failed", str2, e.getMessage() + "---" + e.getClass().getName() + "---step_" + i3);
                com.baidu.adp.lib.g.a.g(fileInputStream2);
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                com.baidu.adp.lib.g.a.g(fileInputStream2);
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [548=4, 661=4] */
    /* JADX WARN: Removed duplicated region for block: B:100:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x010b A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
        String str7;
        String str8;
        ZipFile zipFile;
        ZipEntry entry;
        NamedNodeMap attributes;
        Node namedItem;
        Node namedItem2;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        int lastIndexOf;
        int f;
        int i2;
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Iterator<ActivityManager.RunningAppProcessInfo> it;
        FileInputStream fileInputStream3;
        f i3;
        String d;
        if (inputStream == null || str == null) {
            e(str, str2, "do_install", "");
            com.baidu.adp.plugin.b.a.mc().g("plugin_install", "doinstall_param_null", str2);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(Util.nh(), String.valueOf(System.currentTimeMillis()));
        String b = Util.b(inputStream, file);
        if (!TextUtils.isEmpty(b)) {
            try {
                file.delete();
            } catch (Exception e) {
                BdLog.e(e);
            }
            e(str, str2, "copy_temp_fail", b);
            return null;
        }
        com.baidu.adp.plugin.b.a.mc().a("plugin_copy_file", System.currentTimeMillis() - currentTimeMillis, str2);
        String str9 = null;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        String str10 = null;
        boolean z8 = false;
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
            }
            if (entry == null) {
                try {
                    file.delete();
                } catch (Exception e3) {
                    BdLog.e(e3);
                }
                e(str, str2, "assetsmanifestnull", "avirom-" + Util.ni() + "-filesize-" + length + "-exp-" + ((String) null));
                return null;
            }
            Element documentElement = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(zipFile.getInputStream(entry))).getDocumentElement();
            str6 = documentElement.getAttribute("package");
            int parseInt = Integer.parseInt(documentElement.getAttribute("android:versionCode"));
            String attribute = documentElement.getAttribute("android:versionName");
            try {
                NodeList elementsByTagName = documentElement.getElementsByTagName("meta-data");
                if (elementsByTagName != null) {
                    if (elementsByTagName.getLength() > 0) {
                        for (int i4 = 0; i4 < elementsByTagName.getLength(); i4++) {
                            try {
                                Node item = elementsByTagName.item(i4);
                                if (item != null && (attributes = item.getAttributes()) != null && (namedItem = attributes.getNamedItem("android:name")) != null && namedItem.getNodeValue() != null) {
                                    if (namedItem.getNodeValue().equals("is_inject_classloader")) {
                                        Node namedItem3 = attributes.getNamedItem("android:value");
                                        if (namedItem3 != null && namedItem3.getNodeValue() != null) {
                                            z8 = Boolean.parseBoolean(namedItem3.getNodeValue());
                                        }
                                    } else if (namedItem.getNodeValue().equals("has_res")) {
                                        Node namedItem4 = attributes.getNamedItem("android:value");
                                        if (namedItem4 != null && namedItem4.getNodeValue() != null) {
                                            try {
                                                z5 = Boolean.parseBoolean(namedItem4.getNodeValue());
                                            } catch (Exception e4) {
                                            }
                                        }
                                    } else if (namedItem.getNodeValue().equals("require_load")) {
                                        Node namedItem5 = attributes.getNamedItem("android:value");
                                        if (namedItem5 != null && namedItem5.getNodeValue() != null) {
                                            str9 = namedItem5.getNodeValue();
                                        }
                                    } else if (namedItem.getNodeValue().equals("cmd_range_0")) {
                                        Node namedItem6 = attributes.getNamedItem("android:value");
                                        if (namedItem6 != null && namedItem6.getNodeValue() != null) {
                                            str10 = namedItem6.getNodeValue();
                                        }
                                    } else if (namedItem.getNodeValue().equals("is_third")) {
                                        Node namedItem7 = attributes.getNamedItem("android:value");
                                        if (namedItem7 != null && namedItem7.getNodeValue() != null) {
                                            try {
                                                z6 = Boolean.parseBoolean(namedItem7.getNodeValue());
                                            } catch (Exception e5) {
                                            }
                                        }
                                    } else if (namedItem.getNodeValue().equals("is_patch") && (namedItem2 = attributes.getNamedItem("android:value")) != null && namedItem2.getNodeValue() != null) {
                                        try {
                                            z7 = Boolean.parseBoolean(namedItem2.getNodeValue());
                                        } catch (Exception e6) {
                                        }
                                    }
                                }
                            } catch (Exception e7) {
                                z = z6;
                                z2 = z8;
                                exc = e7;
                                z3 = z5;
                                str3 = str10;
                                i = parseInt;
                                str4 = str9;
                                z4 = z7;
                                str5 = attribute;
                                str6 = null;
                                str7 = exc.getMessage();
                                if (!TextUtils.isEmpty(str6)) {
                                }
                            }
                        }
                    }
                }
                z = z6;
                z2 = z8;
                str7 = null;
                z3 = z5;
                str3 = str10;
                i = parseInt;
                str4 = str9;
                z4 = z7;
                str5 = attribute;
            } catch (Exception e8) {
                z = false;
                z2 = false;
                exc = e8;
                z3 = false;
                str3 = null;
                i = parseInt;
                str4 = null;
                z4 = false;
                str5 = attribute;
            }
            if (!TextUtils.isEmpty(str6)) {
                try {
                    file.delete();
                } catch (Exception e9) {
                    BdLog.e(e9);
                }
                e(str, str2, "getpackageinfo_fail", "avirom-" + Util.ni() + "-filesize-" + length + "-exp-" + str7);
                return null;
            }
            com.baidu.adp.plugin.b.a.mc().B("plugin_xml_parse", str6);
            str8 = null;
        } else {
            str6 = packageArchiveInfo.packageName;
            str4 = Util.b(packageArchiveInfo.applicationInfo);
            z3 = Util.d(packageArchiveInfo.applicationInfo);
            z = Util.e(packageArchiveInfo.applicationInfo);
            str3 = Util.a(packageArchiveInfo.applicationInfo);
            z2 = Util.c(packageArchiveInfo.applicationInfo);
            z4 = Util.f(packageArchiveInfo.applicationInfo);
            str8 = Util.g(packageArchiveInfo.applicationInfo);
            str5 = packageArchiveInfo.versionName;
            i = packageArchiveInfo.versionCode;
        }
        if (!BdBaseApplication.getInst().isDebugMode() && !Iu && (d = d(str6, file.getAbsolutePath(), pluginSetting)) != null) {
            try {
                file.delete();
            } catch (Exception e10) {
                BdLog.e(e10);
            }
            e(str, str6, "signature_not_match", str6 + "_" + d);
            return null;
        } else if (pluginSetting != null && i == (i2 = pluginSetting.versionCode)) {
            if (str.startsWith("assets://")) {
                File file2 = new File(pluginSetting.apkPath);
                boolean exists = file2.exists();
                boolean isFile = file2.isFile();
                long length2 = file2.length();
                InputStream inputStream2 = null;
                try {
                    fileInputStream3 = new FileInputStream(pluginSetting.apkPath);
                    try {
                        try {
                            f i5 = Util.i(fileInputStream3);
                            inputStream2 = BdBaseApplication.getInst().getAssets().open(str.substring("assets://".length()));
                            if (i5.compareTo(Util.i(inputStream2)) != 0) {
                                com.baidu.adp.plugin.b.a.mc().f("plugin_install", "versionequals_apktime_notequals", str6, i5.toString() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i3.toString());
                            }
                            com.baidu.adp.lib.g.a.g(fileInputStream3);
                            com.baidu.adp.lib.g.a.g(inputStream2);
                        } catch (Exception e11) {
                            e = e11;
                            BdLog.e(e);
                            com.baidu.adp.plugin.b.a.mc().f("plugin_install", "versionequals_apktime_error", str6, "exist-" + exists + "-isfile-" + isFile + "-length-" + length2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage());
                            com.baidu.adp.lib.g.a.g(fileInputStream3);
                            com.baidu.adp.lib.g.a.g(inputStream2);
                            file.delete();
                            String str11 = null;
                            activityManager = (ActivityManager) BdBaseApplication.getInst().getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
                            if (activityManager != null) {
                                it = runningAppProcesses.iterator();
                                while (it.hasNext()) {
                                }
                            }
                            com.baidu.adp.plugin.b.a.mc().f("plugin_install", "versionCode_is_equals", pluginSetting.packageName, i2 + " to " + i + "-instapkpath-" + pluginSetting.apkPath + "-md5-" + pluginSetting.md5 + "-size-" + pluginSetting.size + "-newapkfile-" + file + "-size-" + file.length() + "-srcpath-" + str + "-process-" + str11);
                            Intent intent = new Intent("com.baidu.adp.plugin.installcancel");
                            intent.setPackage(BdBaseApplication.getInst().getPackageName());
                            intent.putExtra(Constants.PACKAGE_NAME, str6);
                            intent.putExtra("install_src_file", str);
                            intent.putExtra("install_dest_file", str);
                            intent.putExtra("version_code", i);
                            BdStatisticsManager.getInstance().save();
                            BdBaseApplication.getInst().sendBroadcast(intent);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.g.a.g(fileInputStream3);
                        com.baidu.adp.lib.g.a.g(inputStream2);
                        throw th;
                    }
                } catch (Exception e12) {
                    e = e12;
                    fileInputStream3 = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream3 = null;
                    com.baidu.adp.lib.g.a.g(fileInputStream3);
                    com.baidu.adp.lib.g.a.g(inputStream2);
                    throw th;
                }
            }
            try {
                file.delete();
            } catch (Exception e13) {
                e13.printStackTrace();
            }
            String str112 = null;
            activityManager = (ActivityManager) BdBaseApplication.getInst().getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
            if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                it = runningAppProcesses.iterator();
                while (it.hasNext()) {
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    str112 = (next == null || next.pid != Process.myPid()) ? str112 : next.processName;
                }
            }
            com.baidu.adp.plugin.b.a.mc().f("plugin_install", "versionCode_is_equals", pluginSetting.packageName, i2 + " to " + i + "-instapkpath-" + pluginSetting.apkPath + "-md5-" + pluginSetting.md5 + "-size-" + pluginSetting.size + "-newapkfile-" + file + "-size-" + file.length() + "-srcpath-" + str + "-process-" + str112);
            Intent intent2 = new Intent("com.baidu.adp.plugin.installcancel");
            intent2.setPackage(BdBaseApplication.getInst().getPackageName());
            intent2.putExtra(Constants.PACKAGE_NAME, str6);
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
                    e(str, str6, "filename_packagename_not_match", null);
                    BdLog.e(str + " must be named with it's package name : " + str6 + ".apk");
                    return null;
                }
            }
            String str12 = str6 + "_" + System.currentTimeMillis() + "_" + i;
            File file3 = new File(Util.nh(), str12 + ".apk");
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
                        e(str, str6, "rename_todest_fail", e14.getMessage());
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
                        String b2 = Util.b(fileInputStream2, file3);
                        file.delete();
                        if (!TextUtils.isEmpty(b2)) {
                            e(str, str6, "copy_todest_fail", b2);
                            com.baidu.adp.lib.g.a.g(fileInputStream2);
                            return null;
                        }
                        com.baidu.adp.lib.g.a.g(fileInputStream2);
                    } catch (Exception e16) {
                        e = e16;
                        fileInputStream = fileInputStream2;
                        try {
                            BdLog.e(e);
                            if (file3.exists()) {
                                file3.delete();
                            }
                            e(str, str6, "copy_todest_fail", e != null ? e.getMessage() : null);
                            com.baidu.adp.lib.g.a.g(fileInputStream);
                            return null;
                        } catch (Throwable th4) {
                            th = th4;
                            com.baidu.adp.lib.g.a.g(fileInputStream);
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream = fileInputStream2;
                        com.baidu.adp.lib.g.a.g(fileInputStream);
                        throw th;
                    }
                }
            }
            File file4 = new File(Util.nh(), str12);
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
            f(file3.getAbsolutePath(), file5.getAbsolutePath(), str6);
            com.baidu.adp.plugin.b.a.mc().a("plugin_extract_so", System.currentTimeMillis() - currentTimeMillis2, str6);
            long currentTimeMillis3 = System.currentTimeMillis();
            a(file3.getAbsolutePath(), str6, file4);
            com.baidu.adp.plugin.b.a.mc().a("plugin_extract_dex", System.currentTimeMillis() - currentTimeMillis3, str6);
            Iv.put(str2 + str, true);
            Intent intent3 = new Intent("com.baidu.adp.plugin.installed");
            intent3.setPackage(BdBaseApplication.getInst().getPackageName());
            intent3.putExtra(Constants.PACKAGE_NAME, str6);
            intent3.putExtra("install_src_file", str);
            intent3.putExtra("install_dest_file", file3.getAbsolutePath());
            intent3.putExtra("version_code", i);
            intent3.putExtra("version_name", str5);
            intent3.putExtra("cmd_range", str3);
            intent3.putExtra("require_load", str4);
            intent3.putExtra("has_res", z3);
            intent3.putExtra("is_third", z);
            intent3.putExtra("is_patch", z4);
            intent3.putExtra("replace_method_classes", str8);
            intent3.putExtra("is_inject_classloader", z2);
            BdStatisticsManager.getInstance().save();
            BdBaseApplication.getInst().sendOrderedBroadcast(intent3, null);
            try {
                File[] listFiles = Util.nh().listFiles();
                if (listFiles != null) {
                    for (File file6 : listFiles) {
                        if (file6 != null && file6.isDirectory()) {
                            String name = file6.getName();
                            if (name.startsWith(str6) && !name.equals(str12) && (lastIndexOf = name.lastIndexOf("_")) > 0 && (f = com.baidu.adp.lib.g.b.f(name.substring(lastIndexOf + 1), -1)) > 0 && f == i) {
                                com.baidu.adp.plugin.b.a.mc().B("plugin_repeat_install", str6);
                                StringBuilder sb = new StringBuilder();
                                if (pluginSetting != null) {
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    sb.append(pluginSetting.apkPath);
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    sb.append(pluginSetting.versionCode);
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    sb.append(pluginSetting.tempVersionCode);
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    sb.append(pluginSetting.enable);
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    sb.append(pluginSetting.install_fail_count);
                                }
                                com.baidu.adp.plugin.b.a.mc().f("plugin_install", "plugin_repeat_install", str6, file6.getAbsolutePath() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + file3.getAbsolutePath() + sb.toString());
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

    public static void e(String str, String str2, String str3, String str4) {
        Intent intent = new Intent("com.baidu.adp.plugin.installfail");
        intent.setPackage(BdBaseApplication.getInst().getPackageName());
        intent.putExtra("install_src_file", str);
        intent.putExtra("fail_reason", str3);
        intent.putExtra(Constants.PACKAGE_NAME, str2);
        intent.putExtra("install_comment", str4);
        try {
            BdBaseApplication.getInst().sendBroadcast(intent);
        } catch (Throwable th) {
            com.baidu.adp.plugin.b.a.mc().f("plugin_install", "sendbroadcast_fail", str2, th.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void f(String str, String str2, String str3) {
        ZipFile zipFile;
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = Build.CPU_ABI.toLowerCase();
            String str4 = IXAdSystemUtils.NT_NONE;
            if (Build.VERSION.SDK_INT > 7) {
                try {
                    str4 = ((String) Build.class.getDeclaredField("CPU_ABI2").get(Build.class)).toLowerCase();
                } catch (Throwable th) {
                    str4 = IXAdSystemUtils.NT_NONE;
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
                        } else if (substring.toLowerCase().contains(PassBiometricUtil.CPU_TYPE_X86)) {
                            arrayList2.add(nextElement);
                        } else if (substring.toLowerCase().contains(PassBiometricUtil.CPU_TYPE_ARMEABI_V7A)) {
                            arrayList4.add(nextElement);
                        } else {
                            arrayList.add(nextElement);
                        }
                    }
                }
                if (lowerCase.contains(PassBiometricUtil.CPU_TYPE_X86) || str4.contains(PassBiometricUtil.CPU_TYPE_X86)) {
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
                } else if (lowerCase.contains(PassBiometricUtil.CPU_TYPE_ARMEABI_V7A) || str4.contains(PassBiometricUtil.CPU_TYPE_ARMEABI_V7A) || mb()) {
                    a(arrayList4, arrayList);
                    a(zipFile, str2, arrayList4);
                    if (arrayList4.size() <= 0) {
                        return;
                    }
                } else if (lowerCase.contains(PassBiometricUtil.CPU_TYPE_ARMEABI) || str4.contains(PassBiometricUtil.CPU_TYPE_ARMEABI)) {
                    a(zipFile, str2, arrayList);
                    if (arrayList.size() <= 0) {
                        return;
                    }
                } else {
                    com.baidu.adp.plugin.b.a.mc().bB("plugin_cpuarch_judge_fail");
                    com.baidu.adp.plugin.b.a.mc().f("plugin_install", "cpuarch_judge_fail", str3, lowerCase + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str4);
                    a(zipFile, str2, arrayList);
                    if (arrayList.size() <= 0) {
                        return;
                    }
                }
                File file = new File(str);
                File file2 = new File(file.getParentFile(), file.getName() + "_tmp");
                if (a(zipFile, new File(new File(str2).getParentFile(), "tmp"), file2, str3)) {
                    if (!file2.renameTo(file)) {
                        com.baidu.adp.plugin.b.a.mc().f("plugin_install", "delete_so", str3, "delete so suc but rename fail");
                        try {
                            file2.delete();
                            return;
                        } catch (Exception e2) {
                            return;
                        }
                    }
                    return;
                }
                com.baidu.adp.plugin.b.a.mc().f("plugin_install", "delete_so", str3, "delete so fail");
                try {
                    file2.delete();
                } catch (Exception e3) {
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [928=4, 943=6, 944=5, 946=5, 947=5, 948=5] */
    private static final boolean a(ZipFile zipFile, File file, File file2, String str) {
        ZipOutputStream zipOutputStream;
        OutputStream outputStream;
        ZipOutputStream zipOutputStream2;
        boolean z;
        InputStream inputStream;
        BufferedInputStream bufferedInputStream;
        InputStream inputStream2;
        OutputStream outputStream2 = null;
        ZipOutputStream zipOutputStream3 = null;
        try {
            try {
                file.mkdirs();
                com.baidu.adp.lib.util.f.m(file);
                file2.createNewFile();
                outputStream = new FileOutputStream(file2);
            } catch (Throwable th) {
                th = th;
            }
        } catch (ZipException e) {
            e = e;
        } catch (IOException e2) {
            e = e2;
            zipOutputStream2 = null;
            outputStream = null;
        } catch (Throwable th2) {
            th = th2;
            zipOutputStream = null;
            outputStream = null;
        }
        try {
            zipOutputStream2 = new ZipOutputStream(outputStream);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    try {
                        String name = nextElement.getName();
                        if (name.startsWith(PluginInstallerService.APK_LIB_DIR_PREFIX)) {
                            n.g(null);
                            n.g(null);
                        } else {
                            inputStream = zipFile.getInputStream(nextElement);
                            try {
                                File file3 = new File(file, name);
                                file3.getParentFile().mkdirs();
                                Util.b(inputStream, file3);
                                byte[] bArr = new byte[4096];
                                bufferedInputStream = new BufferedInputStream(new FileInputStream(file3), 4096);
                                try {
                                    ZipEntry zipEntry = new ZipEntry(file3.getAbsolutePath().substring(file.getAbsolutePath().length() + 1));
                                    if (zipEntry.getName().equals("resources.arsc")) {
                                        zipEntry.setMethod(0);
                                        zipEntry.setSize(file3.length());
                                        zipEntry.setCompressedSize(zipEntry.getSize());
                                        zipEntry.setCrc(nextElement.getCrc());
                                    }
                                    zipOutputStream2.putNextEntry(zipEntry);
                                    while (true) {
                                        int read = bufferedInputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        zipOutputStream2.write(bArr, 0, read);
                                    }
                                    bufferedInputStream.close();
                                    zipOutputStream2.flush();
                                    zipOutputStream2.closeEntry();
                                    n.g(inputStream);
                                    n.g(bufferedInputStream);
                                } catch (IOException e3) {
                                    e = e3;
                                    inputStream2 = inputStream;
                                    try {
                                        throw e;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        inputStream = inputStream2;
                                        n.g(inputStream);
                                        n.g(bufferedInputStream);
                                        throw th;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    n.g(inputStream);
                                    n.g(bufferedInputStream);
                                    throw th;
                                }
                            } catch (IOException e4) {
                                e = e4;
                                bufferedInputStream = null;
                                inputStream2 = inputStream;
                            } catch (Throwable th5) {
                                th = th5;
                                bufferedInputStream = null;
                            }
                        }
                    } catch (IOException e5) {
                        e = e5;
                        inputStream2 = null;
                        bufferedInputStream = null;
                    } catch (Throwable th6) {
                        th = th6;
                        inputStream = null;
                        bufferedInputStream = null;
                    }
                }
                z = true;
                n.c(zipOutputStream2);
                n.c(outputStream);
                try {
                    com.baidu.adp.lib.util.f.m(file);
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            } catch (ZipException e7) {
                e = e7;
                zipOutputStream3 = zipOutputStream2;
                outputStream2 = outputStream;
                try {
                    com.baidu.adp.plugin.b.a.mc().f("plugin_install", "delete_so", str, e.getMessage());
                    z = false;
                    n.c(zipOutputStream3);
                    n.c(outputStream2);
                    try {
                        com.baidu.adp.lib.util.f.m(file);
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                    return z;
                } catch (Throwable th7) {
                    th = th7;
                    zipOutputStream = zipOutputStream3;
                    outputStream = outputStream2;
                    n.c(zipOutputStream);
                    n.c(outputStream);
                    try {
                        com.baidu.adp.lib.util.f.m(file);
                    } catch (IOException e9) {
                        e9.printStackTrace();
                    }
                    throw th;
                }
            } catch (IOException e10) {
                e = e10;
                com.baidu.adp.plugin.b.a.mc().f("plugin_install", "delete_so", str, e.getMessage());
                z = false;
                n.c(zipOutputStream2);
                n.c(outputStream);
                try {
                    com.baidu.adp.lib.util.f.m(file);
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
                return z;
            } catch (Throwable th8) {
                th = th8;
                com.baidu.adp.plugin.b.a.mc().f("plugin_install", "delete_so", str, th.getMessage());
                z = false;
                n.c(zipOutputStream2);
                n.c(outputStream);
                try {
                    com.baidu.adp.lib.util.f.m(file);
                } catch (IOException e12) {
                    e12.printStackTrace();
                }
                return z;
            }
        } catch (ZipException e13) {
            e = e13;
            outputStream2 = outputStream;
        } catch (IOException e14) {
            e = e14;
            zipOutputStream2 = null;
        } catch (Throwable th9) {
            th = th9;
            zipOutputStream = null;
            n.c(zipOutputStream);
            n.c(outputStream);
            com.baidu.adp.lib.util.f.m(file);
            throw th;
        }
        return z;
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
                    Util.b(inputStream, new File(str, name.substring(lastIndexOf)));
                } catch (IOException e) {
                    BdLog.e(e);
                } finally {
                    com.baidu.adp.lib.g.a.g(inputStream);
                }
            }
        }
    }

    public static boolean ma() {
        String str;
        if (Ix) {
            return Iw;
        }
        Ix = true;
        String lowerCase = Build.CPU_ABI.toLowerCase();
        if (Build.VERSION.SDK_INT <= 7) {
            str = IXAdSystemUtils.NT_NONE;
        } else {
            try {
                try {
                    str = ((String) Build.class.getDeclaredField("CPU_ABI2").get(Build.class)).toLowerCase();
                } catch (Throwable th) {
                }
            } catch (Throwable th2) {
                str = IXAdSystemUtils.NT_NONE;
            }
        }
        if (lowerCase.contains(PassBiometricUtil.CPU_TYPE_ARMEABI_V7A) || str.contains(PassBiometricUtil.CPU_TYPE_ARMEABI_V7A) || mb()) {
            Iw = true;
        } else if (lowerCase.contains(PassBiometricUtil.CPU_TYPE_ARMEABI) || str.contains(PassBiometricUtil.CPU_TYPE_ARMEABI)) {
            Iw = true;
        }
        return Iw;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1121=4] */
    public static boolean mb() {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        InputStreamReader inputStreamReader2 = null;
        if (Iz) {
            return Iy;
        }
        Iz = true;
        try {
            fileInputStream = new FileInputStream("/proc/cpuinfo");
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
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
                                        String str = trim2.charAt(indexOf) + "";
                                        if (!str.matches("\\d")) {
                                            break;
                                        }
                                        sb.append(str);
                                    }
                                    objArr[0] = "ARM";
                                    objArr[1] = Integer.valueOf(com.baidu.adp.lib.g.b.f(sb.toString(), -1));
                                } else if (trim.compareToIgnoreCase("Features") == 0) {
                                    if (trim2.contains(PhoneUtils.CPUInfo.FEATURE_NEON)) {
                                        objArr[2] = PhoneUtils.CPUInfo.FEATURE_NEON;
                                    }
                                } else if (trim.compareToIgnoreCase("model name") == 0) {
                                    if (trim2.contains("Intel")) {
                                        objArr[0] = "INTEL";
                                        objArr[2] = "atom";
                                    }
                                } else if (trim.compareToIgnoreCase("cpu family") == 0) {
                                    objArr[1] = Integer.valueOf(com.baidu.adp.lib.g.b.f(trim2, -1));
                                }
                            }
                        }
                        Iy = ((Integer) objArr[1]).intValue() == 7;
                        n.b((Reader) bufferedReader);
                        n.b((Reader) inputStreamReader);
                        n.g(fileInputStream);
                    } catch (Exception e) {
                        e = e;
                        inputStreamReader2 = inputStreamReader;
                        fileInputStream2 = fileInputStream;
                        try {
                            BdLog.e(e);
                            n.b((Reader) bufferedReader);
                            n.b((Reader) inputStreamReader2);
                            n.g(fileInputStream2);
                            return Iy;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            inputStreamReader = inputStreamReader2;
                            n.b((Reader) bufferedReader);
                            n.b((Reader) inputStreamReader);
                            n.g(fileInputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        n.b((Reader) bufferedReader);
                        n.b((Reader) inputStreamReader);
                        n.g(fileInputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    bufferedReader = null;
                    inputStreamReader2 = inputStreamReader;
                    fileInputStream2 = fileInputStream;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                }
            } catch (Exception e3) {
                e = e3;
                bufferedReader = null;
                fileInputStream2 = fileInputStream;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                inputStreamReader = null;
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
        return Iy;
    }

    private static void a(String str, String str2, File file) {
        DexClassLoader dexClassLoader;
        if (file != null) {
            File file2 = new File(str);
            if (!file2.exists()) {
                com.baidu.adp.plugin.b.a.mc().f("plugin_install", "dexopt_file_illegal", str2, file2.getAbsolutePath());
            }
            if (file2.length() == 0) {
                com.baidu.adp.plugin.b.a.mc().f("plugin_install", "dexopt_file_empty", str2, file2.getAbsolutePath() + "---" + file2.length());
            }
            try {
                dexClassLoader = new DexClassLoader(str, file.getAbsolutePath(), null, BdBaseApplication.getInst().getClassLoader());
            } catch (Exception e) {
                com.baidu.adp.plugin.b.a.mc().f("plugin_install", "new_dexloader", str2, e.getMessage() + "---" + e.getClass().getName());
                BdLog.e(e);
                dexClassLoader = null;
            }
            if (dexClassLoader != null) {
                try {
                    dexClassLoader.loadClass(str2 + ".Static");
                } catch (ClassNotFoundException e2) {
                    com.baidu.adp.plugin.b.a.mc().f("plugin_install", "loadR", str2, e2.getMessage());
                    BdLog.e(e2);
                } catch (Exception e3) {
                    com.baidu.adp.plugin.b.a.mc().f("plugin_install", "loadR2", str2, e3.getMessage() + "---" + e3.getClass().getName());
                    BdLog.e(e3);
                }
            }
        }
    }

    private static String d(String str, String str2, PluginSetting pluginSetting) {
        Signature[] signatureArr;
        Signature[] cb;
        File file;
        if (IA == null) {
            try {
                IA = BdBaseApplication.getInst().getPackageManager().getPackageInfo(BdBaseApplication.getInst().getPackageName(), 64).signatures;
            } catch (Throwable th) {
                com.baidu.adp.plugin.b.a.mc().f("plugin_install", "getmainsign_frompm_fail", str, th.getMessage());
            }
        }
        try {
            signatureArr = BdBaseApplication.getInst().getPackageManager().getPackageArchiveInfo(str2, 64).signatures;
        } catch (Throwable th2) {
            com.baidu.adp.plugin.b.a.mc().f("plugin_install", "getpluginsign_frompm_fail", str, th2.getMessage());
            signatureArr = null;
        }
        if (signatureArr == null) {
            try {
                cb = e.cb(str2);
            } catch (IOException e) {
                return e.getMessage();
            } catch (CertificateEncodingException e2) {
                return e2.getMessage();
            } catch (Throwable th3) {
                return th3.getMessage();
            }
        } else {
            cb = signatureArr;
        }
        if (cb == null) {
            return "get_newsignatures_null_" + str2;
        }
        Signature[] signatureArr2 = IA;
        if (signatureArr2 == null && (file = new File(BdBaseApplication.getInst().getPackageCodePath())) != null && file.exists()) {
            try {
                signatureArr2 = e.cb(file.getAbsolutePath());
                IA = signatureArr2;
            } catch (IOException e3) {
                return e3.getMessage();
            } catch (CertificateEncodingException e4) {
                return e4.getMessage();
            } catch (Throwable th4) {
                return th4.getMessage();
            }
        }
        int a = Util.a(signatureArr2, cb);
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
        if (cb != null) {
            try {
                for (Signature signature2 : cb) {
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
