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
import com.baidu.adp.lib.util.f;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.n;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.util.Util;
import com.baidu.adp.plugin.util.e;
import com.baidu.android.util.devices.IDevices;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
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
    private static boolean SM = false;
    private static Map<String, Boolean> SO = new HashMap();
    private static String flag = null;
    private static boolean SQ = false;
    private static boolean SR = false;
    private static boolean SS = false;
    private static boolean ST = false;
    private static Signature[] SU = null;

    public static void onHandleIntent(Intent intent) {
        PluginSetting pluginSetting = null;
        if (intent == null) {
            com.baidu.adp.plugin.b.a.pD().g("plugin_install", "handle_intent_null", null);
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            com.baidu.adp.plugin.b.a.pD().g("plugin_install", "intent_action_null", null);
            return;
        }
        SM = intent.getBooleanExtra("is_debug_plugin", false);
        if (action.equals(PluginInstallerService.ACTION_INSTALL)) {
            String stringExtra = intent.getStringExtra("install_src_file");
            String stringExtra2 = intent.getStringExtra("package_name");
            flag = intent.getStringExtra("install_flag");
            if (flag == null) {
                flag = "f" + System.currentTimeMillis();
            }
            com.baidu.adp.plugin.b.a.pD().f("plugin_install", "install_service_start", stringExtra2, flag);
            try {
                pluginSetting = (PluginSetting) intent.getSerializableExtra("plugin_setting");
            } catch (Throwable th) {
            }
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.qv().findPluginSetting(stringExtra2);
            if (findPluginSetting != null && findPluginSetting.installStatus == 0 && findPluginSetting.tempVersionCode == 0) {
                int lastIndexOf = stringExtra.lastIndexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                int i = lastIndexOf > 0 ? com.baidu.adp.lib.f.b.toInt(stringExtra.substring(lastIndexOf + 1), -1) : -1;
                if (findPluginSetting.enable && findPluginSetting.versionCode == i) {
                    com.baidu.adp.plugin.b.a.pD().f("plugin_install", "setting_new_has_installed", stringExtra2, "pkgName_" + stringExtra2 + "-srcFile_" + stringExtra);
                    Intent intent2 = new Intent("com.baidu.adp.plugin.installrepeat");
                    intent2.setPackage(BdBaseApplication.getInst().getPackageName());
                    intent2.putExtra("package_name", stringExtra2);
                    intent2.putExtra("install_src_file", stringExtra);
                    BdBaseApplication.getInst().sendBroadcast(intent2);
                    return;
                }
            }
            String str = stringExtra2 + stringExtra;
            if (SO.containsKey(str) && SO.get(str).booleanValue()) {
                com.baidu.adp.plugin.b.a.pD().f("plugin_install", "plugin_has_installed", stringExtra2, "b_pkgName_" + stringExtra2 + "-srcFile_" + stringExtra);
                Intent intent3 = new Intent("com.baidu.adp.plugin.installrepeat");
                intent3.setPackage(BdBaseApplication.getInst().getPackageName());
                intent3.putExtra("package_name", stringExtra2);
                intent3.putExtra("install_src_file", stringExtra);
                BdBaseApplication.getInst().sendBroadcast(intent3);
                return;
            }
            a(stringExtra, stringExtra2, pluginSetting);
            return;
        }
        com.baidu.adp.plugin.b.a.pD().g("plugin_install", "intent_action_name_not_match", null);
    }

    private static void a(String str, String str2, PluginSetting pluginSetting) {
        if (TextUtils.isEmpty(str)) {
            e(str, str2, "srcfile_empty", "");
            com.baidu.adp.plugin.b.a.pD().g("plugin_install", "srcfile_empty", str2);
        } else if (str.startsWith("assets://")) {
            b(str, str2, pluginSetting);
        } else if (str.startsWith("file://")) {
            c(str, str2, pluginSetting);
        } else {
            e(str, str2, "srcfile_illegal", "");
            com.baidu.adp.plugin.b.a.pD().g("plugin_install", "srcfile_illegal", str2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=4] */
    private static void b(String str, String str2, PluginSetting pluginSetting) {
        InputStream inputStream;
        Exception exc;
        InputStream open;
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            e(str, str2, "do_install", "");
            com.baidu.adp.plugin.b.a.pD().g("plugin_install", "pkgname_null", str2);
            return;
        }
        String substring = str.substring("assets://".length());
        try {
            open = BdBaseApplication.getInst().getAssets().open(substring);
        } catch (Exception e) {
            inputStream = null;
            exc = e;
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            if (Util.O(open.available())) {
                a(open, str, str2, pluginSetting);
                com.baidu.adp.lib.f.a.close(open);
            } else {
                e(str, str2, "rom_size", String.valueOf(Util.qG()));
                com.baidu.adp.lib.f.a.close(open);
            }
        } catch (Exception e2) {
            inputStream = open;
            exc = e2;
            try {
                BdLog.e(exc);
                boolean z2 = true;
                StringBuilder sb = new StringBuilder();
                if (!k.isEmpty(substring) && substring.startsWith("plugins/")) {
                    String substring2 = substring.substring("plugins".length() + 1);
                    try {
                        String[] list = BdBaseApplication.getInst().getAssets().list("plugins");
                        if (!k.isEmpty(substring2) && list != null && list.length > 0) {
                            for (int i = 0; i < list.length; i++) {
                                if (substring2.equals(list[i])) {
                                    break;
                                }
                                sb.append(list[i]);
                            }
                        }
                        z = true;
                        z2 = z;
                    } catch (Exception e3) {
                    }
                }
                if (z2) {
                    e(str, str2, "assets_not_found", sb.toString());
                } else {
                    e(str, str2, "open_assets", "assetsPath-" + substring + "-exp-" + exc.toString());
                }
                com.baidu.adp.plugin.b.a.pD().h("plugin_install", "open_assets_failed", str2, exc.getMessage() + "---" + exc.getClass().getName());
                com.baidu.adp.lib.f.a.close(inputStream);
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.f.a.close(inputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = open;
            com.baidu.adp.lib.f.a.close(inputStream);
            throw th;
        }
    }

    private static void c(String str, String str2, PluginSetting pluginSetting) {
        int i;
        if (TextUtils.isEmpty(str)) {
            e(str, str2, "do_install", "");
            com.baidu.adp.plugin.b.a.pD().g("plugin_install", "pkgname_null", str2);
            return;
        }
        String substring = str.substring("file://".length());
        File file = new File(substring);
        if (!file.exists()) {
            e(str, str2, "apk_not_exist", "file_not_exists-apkFilePath_" + substring);
            com.baidu.adp.plugin.b.a.pD().f("plugin_install", "service_apk_not_exist", str2, flag + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + substring);
            return;
        }
        try {
            int lastIndexOf = substring.lastIndexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            int i2 = lastIndexOf > 0 ? com.baidu.adp.lib.f.b.toInt(substring.substring(lastIndexOf + 1), -1) : -1;
            if (i2 > 0) {
                if (i2 < PluginPackageManager.pS()) {
                    com.baidu.adp.plugin.b.a.pD().f("plugin_install", "low_version_code", str2, " vc=" + String.valueOf(i2) + " tiebaVC=" + PluginPackageManager.pS());
                    Intent intent = new Intent("com.baidu.adp.plugin.deleted");
                    intent.setPackage(BdBaseApplication.getInst().getPackageName());
                    intent.putExtra("package_name", str2);
                    intent.putExtra("install_src_file", str);
                    intent.putExtra("fail_reason", "low_version_code");
                    intent.putExtra("version_code", i2);
                    BdBaseApplication.getInst().sendBroadcast(intent);
                    return;
                } else if (pluginSetting != null && i2 == (i = pluginSetting.versionCode)) {
                    com.baidu.adp.plugin.b.a.pD().f("plugin_install", "versionCode_is_equals", pluginSetting.packageName, i + " to " + i2 + "-instapkpath-" + pluginSetting.apkPath + "-md5-" + pluginSetting.md5 + "-size-" + pluginSetting.size + "-newapkfile-" + file + "-size-" + file.length() + "-srcpath-" + str);
                    Intent intent2 = new Intent("com.baidu.adp.plugin.installcancel");
                    intent2.setPackage(BdBaseApplication.getInst().getPackageName());
                    intent2.putExtra("package_name", str2);
                    intent2.putExtra("install_src_file", str);
                    intent2.putExtra("install_dest_file", str);
                    intent2.putExtra("version_code", i2);
                    BdStatisticsManager.getInstance().save();
                    BdBaseApplication.getInst().sendBroadcast(intent2);
                    return;
                }
            }
            if (!Util.O(file.length())) {
                e(str, str2, "rom_size", String.valueOf(Util.qG()));
            } else {
                a(file, str, str2, pluginSetting);
            }
        } catch (Exception e) {
            BdLog.e(e);
            e(str, str2, "open_apk", e.toString());
            com.baidu.adp.plugin.b.a.pD().h("plugin_install", "open_files_failed", str2, e.getMessage() + "---" + e.getClass().getName() + "---step_0");
        }
    }

    private static String a(InputStream inputStream, String str, String str2, PluginSetting pluginSetting) {
        if (inputStream == null || str == null) {
            e(str, str2, "do_install", "");
            com.baidu.adp.plugin.b.a.pD().g("plugin_install", "doinstall_param_null", str2);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(Util.qF(), String.valueOf(System.currentTimeMillis()));
        Util.a b = Util.b(inputStream, file);
        if (!b.isSuccess) {
            try {
                file.delete();
            } catch (Exception e) {
                BdLog.e(e);
            }
            e(str, str2, "assets_copy_temp_fail", b.error);
            return null;
        }
        com.baidu.adp.plugin.b.a.pD().b("plugin_copy_file", System.currentTimeMillis() - currentTimeMillis, str2);
        return a(null, file, str, str2, pluginSetting);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x00f4 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.InputStream] */
    private static String a(File file, String str, String str2, PluginSetting pluginSetting) {
        Throwable th;
        FileInputStream fileInputStream;
        File file2 = new File(Util.qF(), String.valueOf(System.currentTimeMillis()));
        ?? absolutePath = file.getAbsolutePath();
        long length = file.length();
        try {
            if (file2.exists()) {
                f.deleteQuietly(file2);
            }
            f.copyFile(file, file2);
            if (file2.length() != length) {
                throw new Exception("size_not_match1_" + file2.length() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + length);
            }
        } catch (Exception e) {
            if (file2.exists()) {
                f.deleteQuietly(file2);
            }
            try {
                try {
                    File file3 = new File((String) absolutePath);
                    fileInputStream = new FileInputStream(file3);
                    try {
                        Util.a b = Util.b(fileInputStream, file2);
                        if (!b.isSuccess) {
                            f.deleteQuietly(file2);
                            throw new Exception(b.error);
                        } else if (file2.length() != file3.length()) {
                            throw new Exception("size_not_match2_" + file2.length() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + file3.length());
                        } else {
                            com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        e(str, str2, "file_copy_temp_fail", "filesize_" + length + "-exception_" + e.toString() + "-exception1_" + e.toString());
                        com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.baidu.adp.lib.f.a.close((InputStream) absolutePath);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileInputStream = null;
            } catch (Throwable th3) {
                absolutePath = 0;
                th = th3;
                com.baidu.adp.lib.f.a.close((InputStream) absolutePath);
                throw th;
            }
        }
        return a(file, file2, str, str2, pluginSetting);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [649=4, 769=4] */
    /* JADX WARN: Removed duplicated region for block: B:100:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x00ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(File file, File file2, String str, String str2, PluginSetting pluginSetting) {
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
        int i2;
        int i3;
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Iterator<ActivityManager.RunningAppProcessInfo> it;
        FileInputStream fileInputStream3;
        com.baidu.adp.plugin.util.f g;
        Util.a C;
        if (file2 == null || !file2.exists() || file2.length() <= 0) {
            e(str, str2, "tempfile_not_exist", file2 == null ? "null" : file2.exists() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + file2.length());
            return null;
        }
        String str9 = null;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        String str10 = null;
        boolean z8 = false;
        long length = file2.length();
        PackageInfo packageArchiveInfo = BdBaseApplication.getInst().getPackageManager().getPackageArchiveInfo(file2.getAbsolutePath(), 128);
        if (packageArchiveInfo == null || packageArchiveInfo.applicationInfo == null || packageArchiveInfo.packageName == null || packageArchiveInfo.versionCode == 0) {
            try {
                zipFile = new ZipFile(file2, 1);
                entry = zipFile.getEntry("assets/AndroidManifest.xml");
            } catch (Exception e) {
                z = false;
                z2 = false;
                exc = e;
                z3 = false;
                str3 = null;
                i = 0;
                str4 = null;
                z4 = false;
                str5 = null;
            }
            if (entry == null) {
                try {
                    file2.delete();
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
                e(str, str2, "assetsmanifestnull", "avirom-" + Util.qG() + "-filesize-" + length + "-exp-" + ((String) null));
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
                                            } catch (Exception e3) {
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
                                            } catch (Exception e4) {
                                            }
                                        }
                                    } else if (namedItem.getNodeValue().equals("is_patch") && (namedItem2 = attributes.getNamedItem("android:value")) != null && namedItem2.getNodeValue() != null) {
                                        try {
                                            z7 = Boolean.parseBoolean(namedItem2.getNodeValue());
                                        } catch (Exception e5) {
                                        }
                                    }
                                }
                            } catch (Exception e6) {
                                z = z6;
                                z2 = z8;
                                exc = e6;
                                z3 = z5;
                                str3 = str10;
                                i = parseInt;
                                str4 = str9;
                                z4 = z7;
                                str5 = attribute;
                                str6 = null;
                                str7 = exc.toString();
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
            } catch (Exception e7) {
                z = false;
                z2 = false;
                exc = e7;
                z3 = false;
                str3 = null;
                i = parseInt;
                str4 = null;
                z4 = false;
                str5 = attribute;
            }
            if (!TextUtils.isEmpty(str6)) {
                try {
                    file2.delete();
                } catch (Exception e8) {
                    BdLog.e(e8);
                }
                e(str, str2, "getpackageinfo_fail", "avirom-" + Util.qG() + "-filesize-" + length + "-exp-" + str7);
                return null;
            }
            com.baidu.adp.plugin.b.a.pD().E("plugin_xml_parse", str6);
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
        if (!BdBaseApplication.getInst().isDebugMode() && !SM) {
            if (!C(str6, file2.getAbsolutePath()).isSuccess) {
                boolean z9 = false;
                if (pluginSetting != null && str.startsWith("file://")) {
                    z9 = a(file2, pluginSetting.tempMd5, (byte[]) null);
                }
                if (!z9) {
                    boolean a2 = a(file, pluginSetting.tempMd5, (byte[]) null);
                    try {
                        file2.delete();
                    } catch (Exception e9) {
                        BdLog.e(e9);
                    }
                    e(str, str6, "signature_not_match", str6 + "-SourceMd5_" + a2 + "-tmpSize_" + length + "-error_" + C.error + "-step_" + C.step);
                    return null;
                }
            }
        }
        if (pluginSetting != null && i == (i3 = pluginSetting.versionCode)) {
            if (str.startsWith("assets://")) {
                File file3 = new File(pluginSetting.apkPath);
                boolean exists = file3.exists();
                boolean isFile = file3.isFile();
                long length2 = file3.length();
                InputStream inputStream = null;
                try {
                    fileInputStream3 = new FileInputStream(pluginSetting.apkPath);
                    try {
                        try {
                            com.baidu.adp.plugin.util.f g2 = Util.g(fileInputStream3);
                            inputStream = BdBaseApplication.getInst().getAssets().open(str.substring("assets://".length()));
                            if (g2.compareTo(Util.g(inputStream)) != 0) {
                                com.baidu.adp.plugin.b.a.pD().f("plugin_install", "versionequals_apktime_notequals", str6, g2.toString() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + g.toString());
                            }
                            com.baidu.adp.lib.f.a.close((InputStream) fileInputStream3);
                            com.baidu.adp.lib.f.a.close(inputStream);
                        } catch (Exception e10) {
                            e = e10;
                            BdLog.e(e);
                            com.baidu.adp.plugin.b.a.pD().f("plugin_install", "versionequals_apktime_error", str6, "exist-" + exists + "-isfile-" + isFile + "-length-" + length2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage());
                            com.baidu.adp.lib.f.a.close((InputStream) fileInputStream3);
                            com.baidu.adp.lib.f.a.close(inputStream);
                            file2.delete();
                            String str11 = null;
                            activityManager = (ActivityManager) BdBaseApplication.getInst().getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
                            if (activityManager != null) {
                                it = runningAppProcesses.iterator();
                                while (it.hasNext()) {
                                }
                            }
                            com.baidu.adp.plugin.b.a.pD().f("plugin_install", "versionCode_is_equals", pluginSetting.packageName, i3 + " to " + i + "-instapkpath-" + pluginSetting.apkPath + "-md5-" + pluginSetting.md5 + "-size-" + pluginSetting.size + "-newapkfile-" + file2 + "-size-" + file2.length() + "-srcpath-" + str + "-process-" + str11);
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
                        com.baidu.adp.lib.f.a.close((InputStream) fileInputStream3);
                        com.baidu.adp.lib.f.a.close(inputStream);
                        throw th;
                    }
                } catch (Exception e11) {
                    e = e11;
                    fileInputStream3 = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream3 = null;
                    com.baidu.adp.lib.f.a.close((InputStream) fileInputStream3);
                    com.baidu.adp.lib.f.a.close(inputStream);
                    throw th;
                }
            }
            try {
                file2.delete();
            } catch (Exception e12) {
                e12.printStackTrace();
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
            com.baidu.adp.plugin.b.a.pD().f("plugin_install", "versionCode_is_equals", pluginSetting.packageName, i3 + " to " + i + "-instapkpath-" + pluginSetting.apkPath + "-md5-" + pluginSetting.md5 + "-size-" + pluginSetting.size + "-newapkfile-" + file2 + "-size-" + file2.length() + "-srcpath-" + str + "-process-" + str112);
            Intent intent2 = new Intent("com.baidu.adp.plugin.installcancel");
            intent2.setPackage(BdBaseApplication.getInst().getPackageName());
            intent2.putExtra("package_name", str6);
            intent2.putExtra("install_src_file", str);
            intent2.putExtra("install_dest_file", str);
            intent2.putExtra("version_code", i);
            BdStatisticsManager.getInstance().save();
            BdBaseApplication.getInst().sendBroadcast(intent2);
            return null;
        }
        if (str.startsWith("assets://")) {
            if (!str6.equals(str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk")))) {
                f.deleteQuietly(file2);
                e(str, str6, "filename_packagename_not_match", null);
                BdLog.e(str + " must be named with it's package name : " + str6 + ".apk");
                return null;
            }
        }
        String str12 = str6 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + System.currentTimeMillis() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i;
        File file4 = new File(Util.qF(), str12 + ".apk");
        if (!file2.equals(file4)) {
            if (file2.getParent().equals(file4.getParent())) {
                try {
                    if (!file2.renameTo(file4)) {
                        throw new Exception("rename return fail");
                    }
                    if (!file4.exists() || file4.length() == 0) {
                        throw new Exception("rename fail");
                    }
                } catch (Exception e13) {
                    try {
                        file4.delete();
                        f.copyFile(file2, file4);
                        file2.delete();
                    } catch (IOException e14) {
                        if (file2.exists()) {
                            f.deleteQuietly(file2);
                        }
                        BdLog.e(e14);
                        e(str, str6, "rename_todest_fail", e13.getMessage());
                        return null;
                    }
                }
            } else {
                try {
                    fileInputStream = new FileInputStream(file2);
                } catch (Exception e15) {
                    e = e15;
                    fileInputStream2 = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                }
                try {
                    Util.a b = Util.b(fileInputStream, file4);
                    file2.delete();
                    if (!b.isSuccess) {
                        e(str, str6, "copy_todest_fail", b.error);
                        com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                        return null;
                    }
                    com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                } catch (Exception e16) {
                    e = e16;
                    fileInputStream2 = fileInputStream;
                    try {
                        BdLog.e(e);
                        if (file4.exists()) {
                            f.deleteQuietly(file4);
                        }
                        e(str, str6, "copy_todest_fail", e != null ? e.getMessage() : null);
                        com.baidu.adp.lib.f.a.close((InputStream) fileInputStream2);
                        return null;
                    } catch (Throwable th4) {
                        th = th4;
                        fileInputStream = fileInputStream2;
                        com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                    throw th;
                }
            }
        }
        File file5 = new File(Util.qF(), str12);
        try {
            file5.mkdir();
        } catch (Exception e17) {
            BdLog.e(e17);
        }
        File file6 = new File(file5, "lib");
        try {
            file6.mkdir();
        } catch (Exception e18) {
            BdLog.e(e18);
        }
        long currentTimeMillis = System.currentTimeMillis();
        f(file4.getAbsolutePath(), file6.getAbsolutePath(), str6);
        com.baidu.adp.plugin.b.a.pD().b("plugin_extract_so", System.currentTimeMillis() - currentTimeMillis, str6);
        long currentTimeMillis2 = System.currentTimeMillis();
        a(file4.getAbsolutePath(), str6, file5);
        com.baidu.adp.plugin.b.a.pD().b("plugin_extract_dex", System.currentTimeMillis() - currentTimeMillis2, str6);
        SO.put(str2 + str, true);
        Intent intent3 = new Intent("com.baidu.adp.plugin.installed");
        intent3.setPackage(BdBaseApplication.getInst().getPackageName());
        intent3.putExtra("package_name", str6);
        intent3.putExtra("install_src_file", str);
        intent3.putExtra("install_dest_file", file4.getAbsolutePath());
        intent3.putExtra("version_code", i);
        intent3.putExtra(SharedPrefConfig.VERSION_NAME, str5);
        intent3.putExtra("cmd_range", str3);
        intent3.putExtra("require_load", str4);
        intent3.putExtra("has_res", z3);
        intent3.putExtra("is_third", z);
        intent3.putExtra("is_patch", z4);
        intent3.putExtra("replace_method_classes", str8);
        intent3.putExtra("is_inject_classloader", z2);
        intent3.putExtra("install_flag", flag);
        BdStatisticsManager.getInstance().save();
        BdBaseApplication.getInst().sendOrderedBroadcast(intent3, null);
        try {
            File[] listFiles = Util.qF().listFiles();
            if (listFiles != null) {
                for (File file7 : listFiles) {
                    if (file7 != null && file7.isDirectory()) {
                        String name = file7.getName();
                        if (name.startsWith(str6) && !name.equals(str12) && (lastIndexOf = name.lastIndexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) > 0 && (i2 = com.baidu.adp.lib.f.b.toInt(name.substring(lastIndexOf + 1), -1)) > 0 && i2 == i) {
                            com.baidu.adp.plugin.b.a.pD().E("plugin_repeat_install", str6);
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
                            com.baidu.adp.plugin.b.a.pD().f("plugin_install", "plugin_repeat_install", str6, file7.getAbsolutePath() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + file4.getAbsolutePath() + sb.toString());
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [886=4] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean a(File file, String str, byte[] bArr) {
        FileInputStream fileInputStream;
        if (file == null || !file.exists() || file.length() <= 0) {
            return false;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    String a2 = Util.a(fileInputStream, bArr);
                    boolean equalsIgnoreCase = a2.equalsIgnoreCase(str);
                    com.baidu.adp.plugin.b.a.pD().f("plugin_install", "install_chack_md5", "", "result_" + equalsIgnoreCase + "-tempMd5_" + a2 + "-check_" + str + "-size_" + file.length() + "-file_" + file.getAbsolutePath());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            return equalsIgnoreCase;
                        } catch (IOException e) {
                            BdLog.d(e.getMessage());
                            return equalsIgnoreCase;
                        }
                    }
                    return equalsIgnoreCase;
                } catch (Exception e2) {
                    e = e2;
                    BdLog.d(e.getMessage());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            BdLog.d(e3.getMessage());
                        }
                    }
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                        BdLog.d(e4.getMessage());
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            throw th;
        }
    }

    public static void e(String str, String str2, String str3, String str4) {
        Intent intent = new Intent("com.baidu.adp.plugin.installfail");
        intent.setPackage(BdBaseApplication.getInst().getPackageName());
        intent.putExtra("install_src_file", str);
        intent.putExtra("fail_reason", str3);
        intent.putExtra("package_name", str2);
        intent.putExtra("install_comment", str4);
        intent.putExtra("install_flag", flag);
        try {
            BdBaseApplication.getInst().sendBroadcast(intent);
        } catch (Throwable th) {
            com.baidu.adp.plugin.b.a.pD().f("plugin_install", "sendbroadcast_fail", str2, th.getMessage());
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
                }
                if (lowerCase.contains("x86") || str4.contains("x86")) {
                    b(arrayList2, arrayList);
                    a(zipFile, str2, arrayList2);
                    if (arrayList2.size() <= 0) {
                        return;
                    }
                } else if (lowerCase.contains(IDevices.ABI_MIPS) || str4.contains(IDevices.ABI_MIPS)) {
                    b(arrayList3, arrayList);
                    a(zipFile, str2, arrayList3);
                    if (arrayList3.size() <= 0) {
                        return;
                    }
                } else if (lowerCase.contains("armeabi-v7a") || str4.contains("armeabi-v7a") || pC()) {
                    b(arrayList4, arrayList);
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
                    com.baidu.adp.plugin.b.a.pD().log("plugin_cpuarch_judge_fail");
                    com.baidu.adp.plugin.b.a.pD().f("plugin_install", "cpuarch_judge_fail", str3, lowerCase + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str4);
                    a(zipFile, str2, arrayList);
                    if (arrayList.size() <= 0) {
                        return;
                    }
                }
                File file = new File(str);
                File file2 = new File(file.getParentFile(), file.getName() + "_tmp");
                if (a(zipFile, new File(new File(str2).getParentFile(), "tmp"), file2, str3)) {
                    if (!file2.renameTo(file)) {
                        com.baidu.adp.plugin.b.a.pD().f("plugin_install", "delete_so", str3, "delete so suc but rename fail");
                        try {
                            file2.delete();
                            return;
                        } catch (Exception e2) {
                            return;
                        }
                    }
                    return;
                }
                com.baidu.adp.plugin.b.a.pD().f("plugin_install", "delete_so", str3, "delete so fail");
                try {
                    file2.delete();
                } catch (Exception e3) {
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1075=4, 1090=6, 1091=5, 1093=5, 1094=5, 1095=5] */
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
                f.deleteDirectory(file);
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
                            n.close((InputStream) null);
                            n.close((InputStream) null);
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
                                    n.close(inputStream);
                                    n.close((InputStream) bufferedInputStream);
                                } catch (IOException e3) {
                                    e = e3;
                                    inputStream2 = inputStream;
                                    try {
                                        throw e;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        inputStream = inputStream2;
                                        n.close(inputStream);
                                        n.close((InputStream) bufferedInputStream);
                                        throw th;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    n.close(inputStream);
                                    n.close((InputStream) bufferedInputStream);
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
                n.close((OutputStream) zipOutputStream2);
                n.close(outputStream);
                try {
                    f.deleteDirectory(file);
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            } catch (ZipException e7) {
                e = e7;
                zipOutputStream3 = zipOutputStream2;
                outputStream2 = outputStream;
                try {
                    com.baidu.adp.plugin.b.a.pD().f("plugin_install", "delete_so", str, e.getMessage());
                    z = false;
                    n.close((OutputStream) zipOutputStream3);
                    n.close(outputStream2);
                    try {
                        f.deleteDirectory(file);
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                    return z;
                } catch (Throwable th7) {
                    th = th7;
                    zipOutputStream = zipOutputStream3;
                    outputStream = outputStream2;
                    n.close((OutputStream) zipOutputStream);
                    n.close(outputStream);
                    try {
                        f.deleteDirectory(file);
                    } catch (IOException e9) {
                        e9.printStackTrace();
                    }
                    throw th;
                }
            } catch (IOException e10) {
                e = e10;
                com.baidu.adp.plugin.b.a.pD().f("plugin_install", "delete_so", str, e.getMessage());
                z = false;
                n.close((OutputStream) zipOutputStream2);
                n.close(outputStream);
                try {
                    f.deleteDirectory(file);
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
                return z;
            } catch (Throwable th8) {
                th = th8;
                com.baidu.adp.plugin.b.a.pD().f("plugin_install", "delete_so", str, th.getMessage());
                z = false;
                n.close((OutputStream) zipOutputStream2);
                n.close(outputStream);
                try {
                    f.deleteDirectory(file);
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
            n.close((OutputStream) zipOutputStream);
            n.close(outputStream);
            f.deleteDirectory(file);
            throw th;
        }
        return z;
    }

    private static void b(ArrayList<ZipEntry> arrayList, ArrayList<ZipEntry> arrayList2) {
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
                    com.baidu.adp.lib.f.a.close(inputStream);
                }
            }
        }
    }

    public static boolean pB() {
        String str;
        if (SR) {
            return SQ;
        }
        SR = true;
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
        if (lowerCase.contains("armeabi-v7a") || str.contains("armeabi-v7a") || pC()) {
            SQ = true;
        } else if (lowerCase.contains("armeabi") || str.contains("armeabi")) {
            SQ = true;
        }
        return SQ;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1268=4] */
    public static boolean pC() {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        InputStreamReader inputStreamReader2 = null;
        if (ST) {
            return SS;
        }
        ST = true;
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
                                    objArr[1] = Integer.valueOf(com.baidu.adp.lib.f.b.toInt(sb.toString(), -1));
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
                                    objArr[1] = Integer.valueOf(com.baidu.adp.lib.f.b.toInt(trim2, -1));
                                }
                            }
                        }
                        SS = ((Integer) objArr[1]).intValue() == 7;
                        n.close((Reader) bufferedReader);
                        n.close((Reader) inputStreamReader);
                        n.close((InputStream) fileInputStream);
                    } catch (Exception e) {
                        e = e;
                        inputStreamReader2 = inputStreamReader;
                        fileInputStream2 = fileInputStream;
                        try {
                            BdLog.e(e);
                            n.close((Reader) bufferedReader);
                            n.close((Reader) inputStreamReader2);
                            n.close((InputStream) fileInputStream2);
                            return SS;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            inputStreamReader = inputStreamReader2;
                            n.close((Reader) bufferedReader);
                            n.close((Reader) inputStreamReader);
                            n.close((InputStream) fileInputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        n.close((Reader) bufferedReader);
                        n.close((Reader) inputStreamReader);
                        n.close((InputStream) fileInputStream);
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
        return SS;
    }

    private static void a(String str, String str2, File file) {
        DexClassLoader dexClassLoader;
        if (file != null) {
            File file2 = new File(str);
            if (!file2.exists()) {
                com.baidu.adp.plugin.b.a.pD().f("plugin_install", "dexopt_file_illegal", str2, file2.getAbsolutePath());
            }
            if (file2.length() == 0) {
                com.baidu.adp.plugin.b.a.pD().f("plugin_install", "dexopt_file_empty", str2, file2.getAbsolutePath() + "---" + file2.length());
            }
            try {
                dexClassLoader = new DexClassLoader(str, file.getAbsolutePath(), null, BdBaseApplication.getInst().getClassLoader());
            } catch (Exception e) {
                com.baidu.adp.plugin.b.a.pD().f("plugin_install", "new_dexloader", str2, e.getMessage() + "---" + e.getClass().getName());
                BdLog.e(e);
                dexClassLoader = null;
            }
            if (dexClassLoader != null) {
                try {
                    dexClassLoader.loadClass(str2 + ".Static");
                } catch (ClassNotFoundException e2) {
                    com.baidu.adp.plugin.b.a.pD().f("plugin_install", "loadR", str2, e2.getMessage());
                    BdLog.e(e2);
                } catch (Exception e3) {
                    com.baidu.adp.plugin.b.a.pD().f("plugin_install", "loadR2", str2, e3.getMessage() + "---" + e3.getClass().getName());
                    BdLog.e(e3);
                }
            }
        }
    }

    private static Util.a C(String str, String str2) {
        Signature[] signatureArr;
        Signature[] signatureArr2;
        File file;
        Util.a aVar = new Util.a();
        if (SU == null) {
            try {
                SU = BdBaseApplication.getInst().getPackageManager().getPackageInfo(BdBaseApplication.getInst().getPackageName(), 64).signatures;
            } catch (Throwable th) {
                com.baidu.adp.plugin.b.a.pD().f("plugin_install", "getmainsign_frompm_fail", str, th.getMessage());
            }
        }
        try {
            signatureArr = BdBaseApplication.getInst().getPackageManager().getPackageArchiveInfo(str2, 64).signatures;
        } catch (Throwable th2) {
            com.baidu.adp.plugin.b.a.pD().f("plugin_install", "getpluginsign_frompm_fail", str, th2.getMessage());
            signatureArr = null;
        }
        if (signatureArr == null) {
            try {
                Signature[] a2 = e.a(str2, aVar);
                if (a2 != null) {
                    com.baidu.adp.plugin.b.a.pD().f("plugin_install", "collectCertificates_ok", str, null);
                }
                signatureArr2 = a2;
            } catch (Throwable th3) {
                aVar.error += "-exception_" + th3.toString();
                return aVar;
            }
        } else {
            signatureArr2 = signatureArr;
        }
        if (signatureArr2 == null) {
            aVar.error = "get_newsignatures_null_" + str2;
            return aVar;
        }
        Signature[] signatureArr3 = SU;
        if (signatureArr3 == null && (file = new File(BdBaseApplication.getInst().getPackageCodePath())) != null && file.exists()) {
            try {
                signatureArr3 = e.a(file.getAbsolutePath(), aVar);
                SU = signatureArr3;
            } catch (Throwable th4) {
                aVar.error += "-exception_" + th4.toString();
                return aVar;
            }
        }
        int a3 = Util.a(signatureArr3, signatureArr2);
        if (a3 == 0) {
            aVar.isSuccess = true;
            return aVar;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("mainsign");
        if (signatureArr3 != null) {
            try {
                for (Signature signature : signatureArr3) {
                    if (signature != null) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        sb.append(signature.toCharsString());
                    }
                }
            } catch (Throwable th5) {
                sb.append(th5.getMessage());
            }
        }
        sb.append("_pluginsign");
        if (signatureArr2 != null) {
            try {
                for (Signature signature2 : signatureArr2) {
                    if (signature2 != null) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        sb.append(signature2.toCharsString());
                    }
                }
            } catch (Throwable th6) {
                sb.append(th6.getMessage());
            }
        }
        aVar.error = "compare_signatures_fail_" + a3 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + sb.toString();
        return aVar;
    }
}
