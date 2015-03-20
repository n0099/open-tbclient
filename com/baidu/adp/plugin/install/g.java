package com.baidu.adp.plugin.install;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.util.Util;
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
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
/* loaded from: classes.dex */
public class g {
    private static boolean Di = false;
    private static boolean Dj = false;

    public static void onHandleIntent(Intent intent) {
        if (intent == null) {
            com.baidu.adp.plugin.b.a.lh().g("plugin_install", "handle_intent_null", null);
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            com.baidu.adp.plugin.b.a.lh().g("plugin_install", "intent_action_null", null);
        } else if (action.equals(PluginInstallerService.ACTION_INSTALL)) {
            E(intent.getStringExtra("install_src_file"), intent.getStringExtra("package_name"));
        } else {
            com.baidu.adp.plugin.b.a.lh().g("plugin_install", "intent_action_name_not_match", null);
        }
    }

    private static void E(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            c(str, str2, "srcfile_empty", "");
            com.baidu.adp.plugin.b.a.lh().g("plugin_install", "srcfile_empty", str2);
            return;
        }
        long lW = Util.lW();
        if (lW > 0 && lW < 31457280) {
            c(str, str2, "rom_size", String.valueOf(lW));
            com.baidu.adp.plugin.b.a.lh().be("plugin_rom_small");
        } else if (str.startsWith("assets://")) {
            F(str, str2);
        } else if (str.startsWith("file://")) {
            G(str, str2);
        } else {
            c(str, str2, "srcfile_illegal", "");
            com.baidu.adp.plugin.b.a.lh().g("plugin_install", "srcfile_illegal", str2);
        }
    }

    private static void F(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.adp.plugin.b.a.lh().g("plugin_install", "pkgname_null", str2);
            return;
        }
        String substring = str.substring("assets://".length());
        InputStream inputStream = null;
        try {
            inputStream = BdBaseApplication.getInst().getAssets().open(substring);
            a(inputStream, str, str2);
        } catch (Exception e) {
            BdLog.e(e);
            c(str, str2, "open_assets", "assetsPath-" + substring + "-exp-" + e.getMessage());
            com.baidu.adp.plugin.b.a.lh().d("plugin_install", "open_assets_failed", str2, String.valueOf(e.getMessage()) + "---" + e.getClass().getName());
        } finally {
            com.baidu.adp.lib.g.a.d(inputStream);
        }
    }

    private static void G(String str, String str2) {
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(str)) {
            c(str, str2, "do_install", "");
            com.baidu.adp.plugin.b.a.lh().g("plugin_install", "pkgname_null", str2);
            return;
        }
        try {
            fileInputStream = new FileInputStream(new File(str.substring("file://".length())));
            try {
                try {
                    a(fileInputStream, str, str2);
                    com.baidu.adp.lib.g.a.d(fileInputStream);
                } catch (Exception e) {
                    e = e;
                    BdLog.e(e);
                    c(str, str2, "open_apk", "");
                    com.baidu.adp.plugin.b.a.lh().d("plugin_install", "open_files_failed", str2, String.valueOf(e.getMessage()) + "---" + e.getClass().getName());
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [319=4] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x00ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(InputStream inputStream, String str, String str2) {
        boolean z;
        Exception exc;
        String str3;
        String str4;
        int i;
        String str5;
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
        if (inputStream == null || str == null) {
            c(str, str2, "do_install", "");
            com.baidu.adp.plugin.b.a.lh().g("plugin_install", "doinstall_param_null", str2);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(Util.lV(), String.valueOf(System.currentTimeMillis()));
        String b = Util.b(inputStream, file);
        if (!TextUtils.isEmpty(b)) {
            try {
                file.delete();
            } catch (Exception e) {
                BdLog.e(e);
            }
            c(str, str2, "copy_temp_fail", b);
            return null;
        }
        com.baidu.adp.plugin.b.a.lh().a("plugin_copy_file", System.currentTimeMillis() - currentTimeMillis, str2);
        String str7 = null;
        String str8 = null;
        boolean z2 = false;
        long length = file.length();
        PackageInfo packageArchiveInfo = BdBaseApplication.getInst().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 128);
        if (packageArchiveInfo == null || packageArchiveInfo.applicationInfo == null || packageArchiveInfo.packageName == null) {
            try {
                zipFile = new ZipFile(file, 1);
                entry = zipFile.getEntry("assets/AndroidManifest.xml");
            } catch (Exception e2) {
                z = false;
                exc = e2;
                str3 = null;
                str4 = null;
                i = 0;
                str5 = null;
                str6 = null;
                message = exc.getMessage();
                if (!TextUtils.isEmpty(str6)) {
                }
            }
            if (entry == null) {
                try {
                    file.delete();
                } catch (Exception e3) {
                    BdLog.e(e3);
                }
                c(str, str2, "assetsmanifestnull", "avirom-" + Util.lW() + "-filesize-" + length + "-exp-" + ((String) null));
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
                exc = e4;
                str3 = null;
                str4 = attribute;
                i = parseInt;
                str5 = null;
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
                                        z2 = Boolean.parseBoolean(namedItem3.getNodeValue());
                                    }
                                } else if (namedItem.getNodeValue().equals("require_load")) {
                                    Node namedItem4 = attributes.getNamedItem("android:value");
                                    if (namedItem4 != null && namedItem4.getNodeValue() != null) {
                                        str7 = namedItem4.getNodeValue();
                                    }
                                } else if (namedItem.getNodeValue().equals("cmd_range_0") && (namedItem2 = attributes.getNamedItem("android:value")) != null && namedItem2.getNodeValue() != null) {
                                    str8 = namedItem2.getNodeValue();
                                }
                            }
                        } catch (Exception e5) {
                            z = z2;
                            exc = e5;
                            str3 = str7;
                            str4 = attribute;
                            String str9 = str8;
                            i = parseInt;
                            str5 = str9;
                            str6 = null;
                            message = exc.getMessage();
                            if (!TextUtils.isEmpty(str6)) {
                            }
                        }
                    }
                    z = z2;
                    message = null;
                    str3 = str7;
                    str4 = attribute;
                    String str10 = str8;
                    i = parseInt;
                    str5 = str10;
                    if (!TextUtils.isEmpty(str6)) {
                        try {
                            file.delete();
                        } catch (Exception e6) {
                            BdLog.e(e6);
                        }
                        c(str, str2, "getpackageinfo_fail", "avirom-" + Util.lW() + "-filesize-" + length + "-exp-" + message);
                        return null;
                    }
                    com.baidu.adp.plugin.b.a.lh().be("plugin_xml_parse");
                }
            }
            z = false;
            message = null;
            str3 = null;
            str4 = attribute;
            i = parseInt;
            str5 = null;
            if (!TextUtils.isEmpty(str6)) {
            }
        } else {
            str6 = packageArchiveInfo.packageName;
            str3 = Util.b(packageArchiveInfo.applicationInfo);
            str5 = Util.a(packageArchiveInfo.applicationInfo);
            z = Util.c(packageArchiveInfo.applicationInfo);
            str4 = packageArchiveInfo.versionName;
            i = packageArchiveInfo.versionCode;
        }
        if (str.startsWith("assets://")) {
            if (!str6.equals(str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk")))) {
                file.delete();
                c(str, str6, "filename_packagename_not_match", null);
                BdLog.e(String.valueOf(str) + " must be named with it's package name : " + str6 + ".apk");
                return null;
            }
        }
        String str11 = String.valueOf(str6) + "-" + System.currentTimeMillis();
        File file2 = new File(Util.lV(), String.valueOf(str11) + ".apk");
        if (file.getParent().equals(file2.getParent())) {
            try {
                file.renameTo(file2);
            } catch (Exception e7) {
                BdLog.e(e7);
                if (file.exists()) {
                    file.delete();
                }
                c(str, str6, "rename_todest_fail", null);
                return null;
            }
        } else {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    String b2 = Util.b(fileInputStream, file2);
                    file.delete();
                    if (!TextUtils.isEmpty(b2)) {
                        c(str, str6, "copy_todest_fail", null);
                        com.baidu.adp.lib.g.a.d(fileInputStream);
                        return null;
                    }
                    com.baidu.adp.lib.g.a.d(fileInputStream);
                } catch (Exception e8) {
                    e = e8;
                    fileInputStream2 = fileInputStream;
                    try {
                        BdLog.e(e);
                        if (file2.exists()) {
                            file2.delete();
                        }
                        c(str, str6, "copy_todest_fail", null);
                        com.baidu.adp.lib.g.a.d(fileInputStream2);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        com.baidu.adp.lib.g.a.d(fileInputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.baidu.adp.lib.g.a.d(fileInputStream);
                    throw th;
                }
            } catch (Exception e9) {
                e = e9;
                fileInputStream2 = null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
            }
        }
        File file3 = new File(Util.lV(), str11);
        try {
            file3.mkdir();
        } catch (Exception e10) {
            BdLog.e(e10);
        }
        File file4 = new File(file3, "lib");
        try {
            file4.mkdir();
        } catch (Exception e11) {
            BdLog.e(e11);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        H(file2.getAbsolutePath(), file4.getAbsolutePath());
        com.baidu.adp.plugin.b.a.lh().a("plugin_extract_so", System.currentTimeMillis() - currentTimeMillis2, str6);
        long currentTimeMillis3 = System.currentTimeMillis();
        a(file2.getAbsolutePath(), str6, file3);
        com.baidu.adp.plugin.b.a.lh().a("plugin_extract_dex", System.currentTimeMillis() - currentTimeMillis3, str6);
        Intent intent = new Intent("com.baidu.adp.plugin.installed");
        intent.setPackage(BdBaseApplication.getInst().getPackageName());
        intent.putExtra("package_name", str6);
        intent.putExtra("install_src_file", str);
        intent.putExtra("install_dest_file", file2.getAbsolutePath());
        intent.putExtra("version_code", i);
        intent.putExtra("version_name", str4);
        intent.putExtra("cmd_range", str5);
        intent.putExtra("require_load", str3);
        intent.putExtra("is_inject_classloader", z);
        com.baidu.adp.lib.stats.f.hP().save();
        BdBaseApplication.getInst().sendBroadcast(intent);
        return str6;
    }

    private static void c(String str, String str2, String str3, String str4) {
        Intent intent = new Intent("com.baidu.adp.plugin.installfail");
        intent.setPackage(BdBaseApplication.getInst().getPackageName());
        intent.putExtra("install_src_file", str);
        intent.putExtra("fail_reason", str3);
        intent.putExtra("package_name", str2);
        intent.putExtra("install_comment", str4);
        BdBaseApplication.getInst().sendBroadcast(intent);
    }

    private static void H(String str, String str2) {
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
                } else if (lg()) {
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
                    Util.b(inputStream, new File(str, name.substring(lastIndexOf)));
                } catch (IOException e) {
                    BdLog.e(e);
                } finally {
                    com.baidu.adp.lib.g.a.d(inputStream);
                }
            }
        }
    }

    public static boolean lg() {
        if (Dj) {
            return Di;
        }
        Dj = true;
        try {
            FileInputStream fileInputStream = new FileInputStream("/proc/cpuinfo");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
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
                        String str = "";
                        for (int indexOf = trim2.indexOf("ARMv") + 4; indexOf < trim2.length(); indexOf++) {
                            String sb = new StringBuilder(String.valueOf(trim2.charAt(indexOf))).toString();
                            if (!sb.matches("\\d")) {
                                break;
                            }
                            str = String.valueOf(str) + sb;
                        }
                        objArr[0] = "ARM";
                        objArr[1] = Integer.valueOf(Integer.parseInt(str));
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
                        objArr[1] = Integer.valueOf(Integer.parseInt(trim2));
                    }
                }
            }
            Di = ((Integer) objArr[1]).intValue() == 7;
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
        } catch (Exception e) {
            BdLog.e(e);
        }
        return Di;
    }

    private static void a(String str, String str2, File file) {
        DexClassLoader dexClassLoader;
        if (file != null) {
            try {
                dexClassLoader = new DexClassLoader(str, file.getAbsolutePath(), null, BdBaseApplication.getInst().getClassLoader());
            } catch (Exception e) {
                com.baidu.adp.plugin.b.a.lh().d("plugin_install", "new_dexloader", str2, String.valueOf(e.getMessage()) + "---" + e.getClass().getName());
                BdLog.e(e);
                dexClassLoader = null;
            }
            if (dexClassLoader != null) {
                try {
                    dexClassLoader.loadClass(String.valueOf(str2) + ".Static");
                } catch (ClassNotFoundException e2) {
                    com.baidu.adp.plugin.b.a.lh().d("plugin_install", "loadR", str2, e2.getMessage());
                    BdLog.e(e2);
                } catch (Exception e3) {
                    com.baidu.adp.plugin.b.a.lh().d("plugin_install", "loadR2", str2, String.valueOf(e3.getMessage()) + "---" + e3.getClass().getName());
                    BdLog.e(e3);
                }
            }
        }
    }
}
