package com.baidu.sofire.b;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.k.t;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.i1;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public static i g;
    public static Application h;
    public static List<Integer> i;
    public static List<Integer> j;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public boolean b;
    public Map<String, ApkInfo> c;
    public Map<String, ApkInfo> d;
    public Map<Integer, ApkInfo> e;
    public Map<String, MyReceiver> f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2073990990, "Lcom/baidu/sofire/b/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2073990990, "Lcom/baidu/sofire/b/i;");
                return;
            }
        }
        i = new ArrayList();
        j = new ArrayList();
    }

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap();
        this.f = new HashMap();
    }

    public List<ApkInfo> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            try {
                ArrayList arrayList = new ArrayList();
                for (String str : this.d.keySet()) {
                    arrayList.add(this.d.get(str));
                }
                return arrayList;
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
                try {
                    return new ArrayList();
                } catch (Throwable unused2) {
                    int i3 = com.baidu.sofire.a.b.a;
                    return null;
                }
            }
        }
        return (List) invokeV.objValue;
    }

    public static synchronized i a(Context context) {
        InterceptResult invokeL;
        i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (i.class) {
                if (g == null) {
                    h = (Application) context.getApplicationContext();
                    g = new i();
                }
                iVar = g;
            }
            return iVar;
        }
        return (i) invokeL.objValue;
    }

    public ApkInfo b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            try {
                return this.d.get(str);
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
                return null;
            }
        }
        return (ApkInfo) invokeL.objValue;
    }

    public static String a(IntentFilter intentFilter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, intentFilter)) == null) {
            if (intentFilter == null) {
                return "";
            }
            try {
                StringBuilder sb = new StringBuilder();
                int countActions = intentFilter.countActions();
                if (countActions > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < countActions; i2++) {
                        String action = intentFilter.getAction(i2);
                        if (!TextUtils.isEmpty(action)) {
                            arrayList.add(action);
                        }
                    }
                    if (arrayList.size() > 0) {
                        Collections.sort(arrayList);
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            sb.append((String) it.next());
                        }
                    } else {
                        sb.append("_");
                    }
                } else {
                    sb.append("_");
                }
                int countCategories = intentFilter.countCategories();
                if (countCategories > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i3 = 0; i3 < countCategories; i3++) {
                        String category = intentFilter.getCategory(i3);
                        if (!TextUtils.isEmpty(category)) {
                            arrayList2.add(category);
                        }
                    }
                    if (arrayList2.size() > 0) {
                        Collections.sort(arrayList2);
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            sb.append((String) it2.next());
                        }
                    } else {
                        sb.append("_");
                    }
                } else {
                    sb.append("_");
                }
                if (intentFilter.countDataTypes() > 0) {
                    ArrayList arrayList3 = new ArrayList();
                    for (int i4 = 0; i4 < countCategories; i4++) {
                        String dataType = intentFilter.getDataType(i4);
                        if (!TextUtils.isEmpty(dataType)) {
                            arrayList3.add(dataType);
                        }
                    }
                    if (arrayList3.size() > 0) {
                        Collections.sort(arrayList3);
                        Iterator it3 = arrayList3.iterator();
                        while (it3.hasNext()) {
                            sb.append((String) it3.next());
                        }
                    } else {
                        sb.append("_");
                    }
                } else {
                    sb.append("_");
                }
                int countDataSchemes = intentFilter.countDataSchemes();
                if (countDataSchemes > 0) {
                    ArrayList arrayList4 = new ArrayList();
                    for (int i5 = 0; i5 < countDataSchemes; i5++) {
                        String dataScheme = intentFilter.getDataScheme(i5);
                        if (!TextUtils.isEmpty(dataScheme)) {
                            arrayList4.add(dataScheme);
                        }
                    }
                    if (arrayList4.size() > 0) {
                        Collections.sort(arrayList4);
                        Iterator it4 = arrayList4.iterator();
                        while (it4.hasNext()) {
                            sb.append((String) it4.next());
                        }
                    } else {
                        sb.append("_");
                    }
                } else {
                    sb.append("_");
                }
                return sb.toString();
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            try {
                File file = new File(str);
                if (file.exists() && !file.isDirectory()) {
                    file.delete();
                }
                if (!file.exists()) {
                    file.mkdirs();
                    return true;
                }
                return true;
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final PackageInfo a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(PushConstants.URI_PACKAGE_NAME, str);
                jSONObject.put("m", str2);
                jSONArray.put(jSONObject);
                JSONArray jSONArray2 = new JSONArray(com.baidu.sofire.a.a.a(h, com.baidu.sofire.k.b.b() + "p/1/pdl", jSONArray.toString(), false, true));
                if (jSONArray2.length() <= 0) {
                    return null;
                }
                JSONObject optJSONObject = jSONArray2.optJSONObject(0);
                PackageInfo packageInfo = new PackageInfo();
                packageInfo.packageName = optJSONObject.optString("p");
                packageInfo.versionName = optJSONObject.optString("v");
                ApplicationInfo applicationInfo = new ApplicationInfo();
                String optString = optJSONObject.optString("n");
                applicationInfo.className = optString;
                if (!TextUtils.isEmpty(optString) && applicationInfo.className.startsWith(".")) {
                    applicationInfo.className = packageInfo.packageName + applicationInfo.className;
                }
                applicationInfo.theme = optJSONObject.optInt("t");
                packageInfo.applicationInfo = applicationInfo;
                JSONArray optJSONArray = optJSONObject.optJSONArray("a");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                        if (jSONObject2 != null) {
                            ActivityInfo activityInfo = new ActivityInfo();
                            String optString2 = jSONObject2.optString("n");
                            activityInfo.name = optString2;
                            if (!TextUtils.isEmpty(optString2) && activityInfo.name.startsWith(".")) {
                                activityInfo.name = packageInfo.packageName + activityInfo.name;
                            }
                            activityInfo.packageName = packageInfo.packageName;
                            activityInfo.theme = jSONObject2.optInt("t");
                            activityInfo.labelRes = jSONObject2.optInt("l");
                            if (!TextUtils.isEmpty(activityInfo.name)) {
                                arrayList.add(activityInfo);
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        packageInfo.activities = (ActivityInfo[]) arrayList.toArray(new ActivityInfo[arrayList.size()]);
                    }
                }
                return packageInfo;
            } catch (Throwable unused) {
                int i3 = com.baidu.sofire.a.b.a;
                return null;
            }
        }
        return (PackageInfo) invokeLL.objValue;
    }

    public ApkInfo a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            try {
                return this.e.get(Integer.valueOf(i2));
            } catch (Throwable unused) {
                int i3 = com.baidu.sofire.a.b.a;
                return null;
            }
        }
        return (ApkInfo) invokeI.objValue;
    }

    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            List<Integer> list = i;
            if (list != null && list.contains(Integer.valueOf(i2))) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[SGET, INVOKE, SGET] complete} */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:141:0x02cb */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:255:0x0222 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:256:0x022c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:257:0x02c2 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:258:0x02c8 */
    /* JADX WARN: Can't wrap try/catch for region: R(11:82|83|(1:126)(5:88|(1:90)(2:94|(1:96)(2:97|(1:99)))|91|92|93)|100|101|(4:106|107|108|(5:110|111|112|113|93)(2:114|(1:116)))|123|111|112|113|93) */
    /* JADX WARN: Can't wrap try/catch for region: R(8:23|(1:224)(11:30|31|32|33|34|35|36|(4:38|39|40|(3:43|(1:45)|46)(1:42))|214|215|59)|47|48|(4:53|54|55|(3:57|58|59)(2:60|(1:62)))|214|215|59) */
    /* JADX WARN: Can't wrap try/catch for region: R(9:7|(1:303)(1:11)|(4:12|13|14|(6:15|16|17|(4:21|(3:225|226|227)(8:23|(1:224)(11:30|31|32|33|34|35|36|(4:38|39|40|(3:43|(1:45)|46)(1:42))|214|215|59)|47|48|(4:53|54|55|(3:57|58|59)(2:60|(1:62)))|214|215|59)|18|19)|230|231))|(2:235|(7:237|(3:241|(3:244|(1:246)(3:247|248|249)|242)|250)|251|252|253|254|(4:76|(3:77|78|(2:80|(2:127|128)(11:82|83|(1:126)(5:88|(1:90)(2:94|(1:96)(2:97|(1:99)))|91|92|93)|100|101|(4:106|107|108|(5:110|111|112|113|93)(2:114|(1:116)))|123|111|112|113|93))(7:133|134|135|136|(2:140|(2:142|(3:143|144|(2:146|(2:176|177)(5:148|(1:173)(2:154|(4:169|170|171|164)(3:156|157|(2:159|(1:161)(3:165|166|167))(1:168)))|162|163|164))(5:180|181|182|183|185))))|194|195))|129|130)(1:205)))|257|252|253|254|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0219, code lost:
        r10 = false;
        r20 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x02c5, code lost:
        if (r10 != null) goto L206;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x02cb, code lost:
        if (r10 != null) goto L206;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x02cd, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x02d1, code lost:
        r10 = true;
        r20 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x02d2, code lost:
        r0 = com.baidu.sofire.a.b.a;
        r20 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02d5, code lost:
        r10 = true;
        r20 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0392, code lost:
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0179, code lost:
        r9 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0486 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:277:0x02bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v2 */
    /* JADX WARN: Type inference failed for: r20v3 */
    /* JADX WARN: Type inference failed for: r20v38 */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARN: Type inference failed for: r20v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String a(ApkInfo apkInfo, String str, boolean z) throws Throwable {
        ?? r20;
        String str2;
        String str3;
        ?? r202;
        String str4;
        ZipFile zipFile;
        ZipFile zipFile2;
        ZipFile zipFile3;
        String str5;
        boolean z2;
        String str6;
        String str7;
        String str8;
        String str9;
        HashMap hashMap;
        String str10;
        String str11;
        String str12;
        String str13;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r20 = 1048578;
            r202 = 1048578;
            InterceptResult invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, apkInfo, str, z);
            if (invokeLLZ != null) {
                return (String) invokeLLZ.objValue;
            }
        }
        String str14 = "lib/";
        String str15 = "";
        if (apkInfo == null) {
            return "";
        }
        if (!z || TextUtils.isEmpty(apkInfo.versionName)) {
            str2 = "";
        } else {
            str2 = apkInfo.versionName.replace(".", "");
        }
        try {
            try {
                try {
                    zipFile2 = new ZipFile(apkInfo.pkgPath);
                } catch (Throwable th) {
                    th = th;
                    zipFile3 = null;
                    if (zipFile3 != null) {
                    }
                    throw th;
                }
            } catch (FileNotFoundException e) {
                String message = e.getMessage();
                File parentFile = new File(apkInfo.pkgPath).getParentFile();
                try {
                    if (parentFile.exists()) {
                        File file = new File(parentFile, apkInfo.key + "." + apkInfo.versionName + ".b");
                        if (file.exists()) {
                            File file2 = new File(apkInfo.pkgPath);
                            com.baidu.sofire.a.a.a(file, file2);
                            com.baidu.sofire.k.b.a(apkInfo.pkgPath, true);
                            com.baidu.sofire.a.c.a(file2);
                            com.baidu.sofire.a.c.a(apkInfo.hostContext, apkInfo.key, file2, file);
                            if (file2.exists()) {
                                try {
                                    zipFile2 = new ZipFile(apkInfo.pkgPath);
                                } catch (Throwable th2) {
                                    throw new FileNotFoundException(message + "--" + th2.getMessage());
                                }
                            } else {
                                throw new FileNotFoundException(message + "--file not exists after copy");
                            }
                        } else {
                            throw new FileNotFoundException(message + "--backupFile not exists");
                        }
                    } else {
                        throw new FileNotFoundException(message + "--backupDir not exists");
                    }
                } catch (EOFException unused) {
                    str4 = str3;
                    zipFile = null;
                    str5 = r202;
                } catch (ZipException unused2) {
                    str4 = str3;
                    zipFile = null;
                    str5 = r20;
                }
            }
            zipFile = zipFile2;
            try {
                try {
                    hashMap = new HashMap();
                    Enumeration<? extends ZipEntry> entries = zipFile.entries();
                    String str16 = "";
                    while (entries.hasMoreElements()) {
                        try {
                            ZipEntry nextElement = entries.nextElement();
                            Enumeration<? extends ZipEntry> enumeration = entries;
                            String name = nextElement.getName();
                            if (name.contains(IStringUtil.TOP_PATH)) {
                                try {
                                    zipFile.close();
                                } catch (Throwable unused3) {
                                    int i2 = com.baidu.sofire.a.b.a;
                                }
                                return str15;
                            }
                            if (!TextUtils.isEmpty(name) && name.startsWith(str14) && !nextElement.isDirectory() && z) {
                                str3 = str15;
                                try {
                                    String[] split = name.split("/");
                                    str11 = str16;
                                    try {
                                        str10 = str14;
                                        if (split.length == 3) {
                                            try {
                                                String str17 = split[1];
                                                if (!TextUtils.isEmpty(str17)) {
                                                    List list = (List) hashMap.get(str17);
                                                    if (list == null) {
                                                        list = new ArrayList();
                                                        hashMap.put(str17, list);
                                                    }
                                                    list.add(nextElement);
                                                }
                                            } catch (EOFException unused4) {
                                                str4 = str11;
                                                str5 = str10;
                                            } catch (ZipException unused5) {
                                                str4 = str11;
                                                str5 = str10;
                                            }
                                        }
                                        entries = enumeration;
                                        str15 = str3;
                                        str16 = str11;
                                        str14 = str10;
                                    } catch (EOFException unused6) {
                                        str10 = str14;
                                    } catch (ZipException unused7) {
                                        str10 = str14;
                                    }
                                } catch (EOFException unused8) {
                                    str10 = str14;
                                    str11 = str16;
                                    str4 = str11;
                                    str5 = str10;
                                } catch (ZipException unused9) {
                                    str10 = str14;
                                    str11 = str16;
                                    str4 = str11;
                                    str5 = str10;
                                }
                            } else {
                                str10 = str14;
                                str3 = str15;
                                str11 = str16;
                            }
                            if (name.endsWith(".dex") && !nextElement.isDirectory() && !z) {
                                String str18 = apkInfo.dataDir;
                                a(str18);
                                File file3 = new File(str18, apkInfo.key + "." + apkInfo.versionName + ".dex");
                                try {
                                } catch (Throwable unused10) {
                                    if (file3 != null && file3.exists()) {
                                        file3.delete();
                                    }
                                    entries = enumeration;
                                    str15 = str3;
                                    str16 = str11;
                                    str14 = str10;
                                }
                                if (a(zipFile, nextElement, file3)) {
                                    str16 = file3.getAbsolutePath();
                                    entries = enumeration;
                                    str15 = str3;
                                    str14 = str10;
                                } else if (file3.exists()) {
                                    file3.delete();
                                }
                            }
                            entries = enumeration;
                            str15 = str3;
                            str16 = str11;
                            str14 = str10;
                        } catch (EOFException unused11) {
                            str10 = str14;
                            str3 = str15;
                        } catch (ZipException unused12) {
                            str10 = str14;
                            str3 = str15;
                        }
                    }
                    str12 = str14;
                    str3 = str15;
                    str13 = str16;
                } catch (Throwable th3) {
                    th = th3;
                    zipFile3 = zipFile;
                    if (zipFile3 != null) {
                        try {
                            zipFile3.close();
                        } catch (Throwable unused13) {
                            int i3 = com.baidu.sofire.a.b.a;
                        }
                    }
                    throw th;
                }
            } catch (EOFException unused14) {
                str5 = "lib/";
                str3 = "";
                str4 = str3;
            } catch (ZipException unused15) {
                str5 = "lib/";
                str3 = "";
                str4 = str3;
            }
        } catch (EOFException unused16) {
            r202 = "lib/";
            str3 = "";
            str4 = str3;
            zipFile = null;
            str5 = r202;
        } catch (ZipException unused17) {
            r20 = "lib/";
            str3 = "";
            str4 = str3;
            zipFile = null;
            str5 = r20;
        }
        if (z && hashMap.size() > 0) {
            String a = com.baidu.sofire.k.a.a(apkInfo.hostContext, hashMap.keySet());
            if (!TextUtils.isEmpty(a)) {
                File file4 = new File(str, a);
                a(file4.getAbsolutePath());
                List<ZipEntry> list2 = (List) hashMap.get(a);
                if (list2 != null && list2.size() > 0) {
                    for (ZipEntry zipEntry : list2) {
                        String name2 = zipEntry.getName();
                        String substring = name2.substring(name2.lastIndexOf("/") + 1);
                        if (!a(zipFile, zipEntry, new File(file4, substring.replace(".so", str2 + ".so")))) {
                            throw new RuntimeException("UnZip so failed.Report space left.");
                        }
                    }
                }
                str4 = file4.getAbsolutePath();
                zipFile.close();
                z2 = false;
                String str19 = str12;
                if (!z2) {
                    ArrayList arrayList = new ArrayList();
                    ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(apkInfo.pkgPath));
                    String str20 = str3;
                    String str21 = str19;
                    while (true) {
                        try {
                            ZipEntry nextEntry = zipInputStream.getNextEntry();
                            if (nextEntry != null) {
                                String name3 = nextEntry.getName();
                                if (name3.contains(IStringUtil.TOP_PATH)) {
                                    try {
                                        zipInputStream.close();
                                        break;
                                    } catch (Throwable unused18) {
                                        int i4 = com.baidu.sofire.a.b.a;
                                    }
                                } else {
                                    String str22 = str21;
                                    if (name3.startsWith(str22) && !nextEntry.isDirectory() && z) {
                                        String[] split2 = name3.split("/");
                                        str7 = str20;
                                        str8 = str2;
                                        if (split2.length != 3) {
                                            zipInputStream.closeEntry();
                                        } else {
                                            String str23 = split2[1];
                                            if (TextUtils.isEmpty(str23)) {
                                                zipInputStream.closeEntry();
                                            } else if (!arrayList.contains(str23)) {
                                                arrayList.add(str23);
                                            }
                                        }
                                        str9 = str22;
                                        str20 = str7;
                                        str2 = str8;
                                        str21 = str9;
                                    } else {
                                        str7 = str20;
                                        str8 = str2;
                                    }
                                    if (name3.endsWith(".dex") && !nextEntry.isDirectory() && !z) {
                                        String str24 = apkInfo.dataDir;
                                        a(str24);
                                        File file5 = new File(str24, apkInfo.key + "." + apkInfo.versionName + ".dex");
                                        try {
                                            file5.delete();
                                            file5.createNewFile();
                                        } catch (Throwable unused19) {
                                            if (file5 != null && file5.exists()) {
                                                file5.delete();
                                            }
                                            str20 = str7;
                                            zipInputStream.closeEntry();
                                            str9 = str22;
                                            str2 = str8;
                                            str21 = str9;
                                        }
                                        if (a(file5, zipInputStream)) {
                                            str20 = file5.getAbsolutePath();
                                            zipInputStream.closeEntry();
                                            str9 = str22;
                                            str2 = str8;
                                            str21 = str9;
                                        } else if (file5.exists()) {
                                            file5.delete();
                                        }
                                    }
                                    str20 = str7;
                                    zipInputStream.closeEntry();
                                    str9 = str22;
                                    str2 = str8;
                                    str21 = str9;
                                }
                            } else {
                                String str25 = str20;
                                String str26 = str2;
                                String str27 = str21;
                                if (z && arrayList.size() > 0) {
                                    String a2 = com.baidu.sofire.k.a.a(apkInfo.hostContext, arrayList);
                                    if (!TextUtils.isEmpty(a2)) {
                                        File file6 = new File(str, a2);
                                        a(file6.getAbsolutePath());
                                        ZipInputStream zipInputStream2 = new ZipInputStream(new FileInputStream(apkInfo.pkgPath));
                                        while (true) {
                                            try {
                                                ZipEntry nextEntry2 = zipInputStream2.getNextEntry();
                                                if (nextEntry2 != null) {
                                                    String name4 = nextEntry2.getName();
                                                    if (name4.contains(IStringUtil.TOP_PATH)) {
                                                        try {
                                                            zipInputStream2.close();
                                                            break;
                                                        } catch (Throwable unused20) {
                                                            int i5 = com.baidu.sofire.a.b.a;
                                                        }
                                                    } else {
                                                        if (name4.startsWith(str27) && name4.endsWith(".so") && !nextEntry2.isDirectory()) {
                                                            String[] split3 = name4.split("/");
                                                            if (split3.length != 3) {
                                                                zipInputStream2.closeEntry();
                                                            } else if (a2.equals(split3[1])) {
                                                                String substring2 = name4.substring(name4.lastIndexOf("/") + 1);
                                                                StringBuilder sb = new StringBuilder();
                                                                str6 = str26;
                                                                sb.append(str6);
                                                                sb.append(".so");
                                                                File file7 = new File(file6, substring2.replace(".so", sb.toString()));
                                                                file7.delete();
                                                                file7.createNewFile();
                                                                if (!a(file7, zipInputStream2)) {
                                                                    throw new RuntimeException("Stream UnZip so failed.Report space left.");
                                                                }
                                                            } else {
                                                                str6 = str26;
                                                            }
                                                        } else {
                                                            str6 = str26;
                                                        }
                                                        zipInputStream2.closeEntry();
                                                        str26 = str6;
                                                    }
                                                } else {
                                                    String absolutePath = file6.getAbsolutePath();
                                                    try {
                                                        zipInputStream2.close();
                                                        return absolutePath;
                                                    } catch (Throwable unused21) {
                                                        int i6 = com.baidu.sofire.a.b.a;
                                                        return absolutePath;
                                                    }
                                                }
                                            } finally {
                                                try {
                                                    zipInputStream2.close();
                                                } catch (Throwable unused22) {
                                                    int i7 = com.baidu.sofire.a.b.a;
                                                }
                                            }
                                        }
                                    }
                                }
                                return str25;
                            }
                        } finally {
                            try {
                                zipInputStream.close();
                            } catch (Throwable unused23) {
                                int i8 = com.baidu.sofire.a.b.a;
                            }
                        }
                    }
                    return str3;
                }
                return str4;
            }
        }
        str4 = str13;
        zipFile.close();
        z2 = false;
        String str192 = str12;
        if (!z2) {
        }
    }

    public synchronized void a(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (z) {
                    List<Integer> list = i;
                    if (list != null && !list.contains(Integer.valueOf(i2))) {
                        i.add(Integer.valueOf(i2));
                    }
                } else {
                    List<Integer> list2 = i;
                    if (list2 != null && list2.contains(Integer.valueOf(i2))) {
                        i.remove(Integer.valueOf(i2));
                    }
                }
            }
        }
    }

    public synchronized void a(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jVar) == null) {
            synchronized (this) {
                try {
                } catch (Throwable unused) {
                    int i2 = com.baidu.sofire.a.b.a;
                }
                if (jVar.d == null) {
                    return;
                }
                ApkInfo apkInfo = this.d.get(jVar.a);
                if (apkInfo != null) {
                    if (apkInfo.intentFilters == null) {
                        apkInfo.intentFilters = new ArrayList();
                    }
                    for (int i3 = 0; i3 < apkInfo.intentFilters.size(); i3++) {
                        if (jVar.a(apkInfo.intentFilters.get(i3))) {
                            return;
                        }
                    }
                    apkInfo.intentFilters.add(jVar);
                    String a = a(jVar.d);
                    if (!TextUtils.isEmpty(a) && !a.equals("____")) {
                        if (!this.f.keySet().contains(a)) {
                            MyReceiver myReceiver = new MyReceiver();
                            if (!com.baidu.sofire.k.b.a(h, myReceiver, jVar.d)) {
                                try {
                                    Thread.sleep(3000L);
                                } catch (InterruptedException unused2) {
                                    int i4 = com.baidu.sofire.a.b.a;
                                }
                                com.baidu.sofire.k.b.a(h, myReceiver, jVar.d);
                            }
                            this.f.put(a, myReceiver);
                        }
                    }
                }
            }
        }
    }

    public final void a(ApkInfo apkInfo, String str, String str2) throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, apkInfo, str, str2) == null) {
            h.getFilesDir();
            String a = a(apkInfo, str, true);
            String property = System.getProperty("java.library.path");
            int i2 = Build.VERSION.SDK_INT;
            String str3 = "";
            property = (i2 >= 25 || TextUtils.isEmpty(property)) ? "" : "";
            if (!TextUtils.isEmpty(a)) {
                if (!TextUtils.isEmpty(property)) {
                    a = a + ":" + property;
                }
            } else {
                a = property;
            }
            apkInfo.libPath = a;
            ClassLoader classLoader = i.class.getClassLoader();
            try {
                try {
                    try {
                        File file = new File(str2, "apkDex");
                        String absolutePath = file.getAbsolutePath();
                        com.baidu.sofire.k.b.d(absolutePath);
                        a(absolutePath);
                        if (i2 == 21 || i2 == 22) {
                            long freeSpace = file.getFreeSpace();
                            File file2 = new File(apkInfo.pkgPath);
                            if (file2.exists() && file2.isFile()) {
                                long length = file2.length();
                                String str4 = "V5 freeSpace=" + freeSpace + ",fileSize=" + length;
                                int i3 = com.baidu.sofire.a.b.a;
                                if (freeSpace < length * 2) {
                                    throw new Exception("Have no space to load plugin.");
                                }
                            }
                        }
                        h hVar = new h(apkInfo.pkgPath, absolutePath, a, classLoader);
                        apkInfo.classLoader = hVar;
                        Class<?> loadClass = hVar.loadClass(com.baidu.sofire.k.b.b(apkInfo.es));
                        if (loadClass == null || TextUtils.isEmpty(loadClass.getName())) {
                            throw new Exception("class ForHostApp.ENGINE_IMPL_CLASS_FULL_PATH loaded is null");
                        }
                    } catch (Throwable unused) {
                        com.baidu.sofire.k.b.d(apkInfo.dataDir);
                        Application application = h;
                        if (application != null) {
                            com.baidu.sofire.k.b.d(application.getFileStreamPath(apkInfo.packageName).getAbsolutePath());
                        }
                        throw new RuntimeException("can't load EngineImpl by both dexFile:" + str3 + " and ZipFile:" + apkInfo.pkgPath);
                    }
                } catch (Throwable unused2) {
                    int i4 = com.baidu.sofire.a.b.a;
                    throw new RuntimeException("can't load EngineImpl by both dexFile:" + str3 + " and ZipFile:" + apkInfo.pkgPath);
                }
            } catch (Throwable unused3) {
                com.baidu.sofire.k.b.d(new File(str2, "apkDex").getAbsolutePath());
                String absolutePath2 = new File(str2, "dexDex").getAbsolutePath();
                com.baidu.sofire.k.b.d(absolutePath2);
                a(absolutePath2);
                str3 = a(apkInfo, str, false);
                h hVar2 = new h(str3, absolutePath2, a, classLoader);
                apkInfo.classLoader = hVar2;
                Class<?> loadClass2 = hVar2.loadClass(com.baidu.sofire.k.b.b(apkInfo.es));
                File file3 = new File(str3);
                if (file3.exists()) {
                    file3.delete();
                }
                if (loadClass2 != null && !TextUtils.isEmpty(loadClass2.getName())) {
                    return;
                }
                throw new Exception("class ForHostApp.ENGINE_IMPL_CLASS_FULL_PATH loaded is null");
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                String a = com.baidu.sofire.a.b.a(new Throwable());
                for (ApkInfo apkInfo : b()) {
                    if (TextUtils.isEmpty(apkInfo.es)) {
                        if (a.contains("com.baidu.sofire.engine.EngineImpl")) {
                            return true;
                        }
                    } else if (a.contains(com.baidu.sofire.k.b.b(apkInfo.es))) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final boolean a(int i2, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Pair pair;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), str, str2, str3})) == null) {
            String str4 = i2 + str;
            Map<String, String> map = U.sRealtimeMd5Map;
            if (map != null) {
                String str5 = map.get(str4);
                if (!TextUtils.isEmpty(str5)) {
                    str2 = str5;
                }
            }
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                File file = new File(str3);
                if (!com.baidu.sofire.k.b.a(file)) {
                    pair = new Pair(Boolean.FALSE, "");
                } else {
                    String a = com.baidu.sofire.k.j.a(file);
                    if (TextUtils.isEmpty(a)) {
                        pair = new Pair(Boolean.FALSE, "");
                    } else if (!a.equalsIgnoreCase(str2)) {
                        pair = new Pair(Boolean.FALSE, a);
                    } else {
                        pair = new Pair(Boolean.TRUE, "");
                    }
                }
            } else {
                pair = new Pair(Boolean.FALSE, "");
            }
            if (!((Boolean) pair.first).booleanValue()) {
                HashMap hashMap = new HashMap();
                hashMap.put("0", 3);
                hashMap.put("1", Integer.valueOf(i2));
                hashMap.put("2", str);
                hashMap.put("3", Base64.encodeToString(((String) pair.second).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                com.baidu.sofire.k.b.a(h.getApplicationContext(), "1003117", (Map<String, Object>) hashMap, false);
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean a(ApkInfo apkInfo, String str) {
        InterceptResult invokeLL;
        Field[] declaredFields;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, apkInfo, str)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return true;
                }
                Application application = (Application) apkInfo.classLoader.loadClass(str).newInstance();
                Application application2 = h;
                if (application2 != null && application != null) {
                    for (Class<Application> cls = Application.class; cls != null && cls != Object.class; cls = cls.getSuperclass()) {
                        for (Field field : cls.getDeclaredFields()) {
                            field.setAccessible(true);
                            field.set(application, field.get(application2));
                        }
                    }
                }
                Application application3 = h;
                Class<?> cls2 = application3.getClass();
                for (Class<Application> cls3 = Application.class; cls3 != null; cls3 = cls3.getSuperclass()) {
                    Field declaredField = cls3.getDeclaredField("mBase");
                    declaredField.setAccessible(true);
                    if (declaredField.getType().isAssignableFrom(cls2)) {
                        declaredField.set(application, application3);
                    }
                }
                application.onCreate();
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public boolean a(ApkInfo apkInfo, boolean z) {
        InterceptResult invokeLZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048585, this, apkInfo, z)) == null) {
            System.currentTimeMillis();
            this.b = z;
            this.a = apkInfo.versionName;
            synchronized (this) {
                if (!TextUtils.isEmpty(apkInfo.pkgPath)) {
                    ApkInfo apkInfo2 = this.c.get(apkInfo.pkgPath);
                    if (apkInfo2 != null) {
                        if (apkInfo2.versionName.equals(apkInfo.versionName)) {
                            return true;
                        }
                        c(apkInfo.pkgPath);
                    }
                    if (!com.baidu.sofire.k.b.a(new File(apkInfo.pkgPath))) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("0", 1);
                        hashMap.put("1", Integer.valueOf(apkInfo.key));
                        hashMap.put("2", apkInfo.versionName);
                        com.baidu.sofire.k.b.a(h.getApplicationContext(), "1003117", (Map<String, Object>) hashMap, false);
                        return false;
                    }
                    apkInfo.hostContext = h;
                    if (apkInfo.apkParseSuc == 1) {
                        try {
                            if (!TextUtils.isEmpty(apkInfo.packageName) && !TextUtils.isEmpty(apkInfo.pkgPath)) {
                                if (a(apkInfo.key, apkInfo.versionName, apkInfo.apkMD5, apkInfo.pkgPath)) {
                                    apkInfo.dataDir = new File(h.getFilesDir(), "sofire_tmp").getCanonicalPath() + i1.j + apkInfo.key;
                                    String str = apkInfo.dataDir + "/dex";
                                    String str2 = (apkInfo.dataDir + "/lib/" + this.a) + "/" + t.a();
                                    a(str);
                                    com.baidu.sofire.k.b.a(str, false);
                                    a(str2);
                                    a(apkInfo, str2, str);
                                    this.c.put(apkInfo.pkgPath, apkInfo);
                                    this.d.put(apkInfo.packageName, apkInfo);
                                    this.e.put(Integer.valueOf(apkInfo.key), apkInfo);
                                    a(apkInfo, apkInfo.className);
                                }
                            } else {
                                throw new RuntimeException("packageName or pkgPath miss");
                            }
                        } catch (Throwable unused) {
                            c(apkInfo.pkgPath);
                            int i2 = com.baidu.sofire.a.b.a;
                            z2 = true;
                        }
                    }
                    z2 = false;
                    if (apkInfo.apkParseSuc != 1 || z2) {
                        PackageInfo packageInfo = apkInfo.cloudPkgInfo;
                        if ((packageInfo == null || TextUtils.isEmpty(packageInfo.packageName) || TextUtils.isEmpty(packageInfo.versionName)) && (((packageInfo = h.getPackageManager().getPackageArchiveInfo(apkInfo.pkgPath, 1)) == null || TextUtils.isEmpty(packageInfo.packageName) || TextUtils.isEmpty(packageInfo.versionName)) && ((packageInfo = a(apkInfo.packageName, apkInfo.apkMD5)) == null || TextUtils.isEmpty(packageInfo.packageName) || TextUtils.isEmpty(packageInfo.versionName)))) {
                            throw new Exception("requestCloudPackageInfo failed");
                        }
                        if (!TextUtils.isEmpty(packageInfo.packageName) && packageInfo.packageName.startsWith("com.baidu.sofire")) {
                            if (a(apkInfo.key, packageInfo.versionName, apkInfo.apkMD5, apkInfo.pkgPath)) {
                                apkInfo.packageName = packageInfo.packageName;
                                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                                apkInfo.className = applicationInfo.className;
                                apkInfo.versionName = packageInfo.versionName;
                                apkInfo.applicationTheme = applicationInfo.theme;
                                apkInfo.dataDir = new File(h.getFilesDir(), "sofire_tmp").getCanonicalPath() + i1.j + apkInfo.key;
                                String str3 = apkInfo.dataDir + "/dex";
                                String str4 = (apkInfo.dataDir + "/lib/" + this.a) + "/" + t.a();
                                a(str3);
                                com.baidu.sofire.k.b.a(str3, false);
                                a(str4);
                                a(apkInfo, str4, str3);
                                this.c.put(apkInfo.pkgPath, apkInfo);
                                this.d.put(apkInfo.packageName, apkInfo);
                                this.e.put(Integer.valueOf(apkInfo.key), apkInfo);
                                a(apkInfo, packageInfo.applicationInfo.className);
                            }
                        } else {
                            throw new Exception("package name check failed");
                        }
                    }
                    return true;
                }
                return false;
            }
        }
        return invokeLZ.booleanValue;
    }

    public final boolean a(File file, ZipInputStream zipInputStream) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, file, zipInputStream)) == null) {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable unused) {
                fileOutputStream = null;
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = zipInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                com.baidu.sofire.k.b.a(file.getAbsolutePath(), true);
                try {
                    fileOutputStream.close();
                } catch (Throwable unused2) {
                    int i2 = com.baidu.sofire.a.b.a;
                }
                return true;
            } catch (Throwable unused3) {
                try {
                    int i3 = com.baidu.sofire.a.b.a;
                    return false;
                } finally {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused4) {
                            int i4 = com.baidu.sofire.a.b.a;
                        }
                    }
                }
            }
        }
        return invokeLL.booleanValue;
    }

    public final boolean a(ZipFile zipFile, ZipEntry zipEntry, File file) {
        InterceptResult invokeLLL;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, zipFile, zipEntry, file)) == null) {
            FileOutputStream fileOutputStream = null;
            try {
                inputStream = zipFile.getInputStream(zipEntry);
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            fileOutputStream2.write(bArr, 0, read);
                        }
                        fileOutputStream2.flush();
                        com.baidu.sofire.k.b.a(file.getAbsolutePath(), true);
                        try {
                            inputStream.close();
                        } catch (Throwable unused) {
                            int i2 = com.baidu.sofire.a.b.a;
                        }
                        try {
                            fileOutputStream2.close();
                        } catch (Throwable unused2) {
                            int i3 = com.baidu.sofire.a.b.a;
                        }
                        return true;
                    } catch (Throwable unused3) {
                        fileOutputStream = fileOutputStream2;
                        try {
                            int i4 = com.baidu.sofire.a.b.a;
                            return false;
                        } finally {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable unused4) {
                                    int i5 = com.baidu.sofire.a.b.a;
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable unused5) {
                                    int i6 = com.baidu.sofire.a.b.a;
                                }
                            }
                        }
                    }
                } catch (Throwable unused6) {
                }
            } catch (Throwable unused7) {
                inputStream = null;
            }
        } else {
            return invokeLLL.booleanValue;
        }
    }

    public synchronized void b(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jVar) == null) {
            synchronized (this) {
                try {
                } catch (Throwable unused) {
                    int i2 = com.baidu.sofire.a.b.a;
                }
                if (jVar.d == null) {
                    return;
                }
                ApkInfo apkInfo = this.d.get(jVar.a);
                if (apkInfo != null && apkInfo.intentFilters != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < apkInfo.intentFilters.size(); i3++) {
                        if (jVar.a(apkInfo.intentFilters.get(i3))) {
                            arrayList.add(Integer.valueOf(i3));
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        int intValue = ((Integer) it.next()).intValue();
                        List<j> list = apkInfo.intentFilters;
                        if (list != null) {
                            list.remove(intValue);
                        }
                    }
                    List<j> list2 = apkInfo.intentFilters;
                    if (list2 != null && list2.size() == 0) {
                        apkInfo.intentFilters = null;
                    }
                }
                String a = a(jVar.d);
                if (TextUtils.isEmpty(a)) {
                    return;
                }
                for (ApkInfo apkInfo2 : b()) {
                    List<j> list3 = apkInfo2.intentFilters;
                    if (list3 != null && list3.size() > 0) {
                        for (j jVar2 : apkInfo2.intentFilters) {
                            String a2 = a(jVar2.d);
                            if (!TextUtils.isEmpty(a2) && a2.equals(a)) {
                                return;
                            }
                        }
                        continue;
                    }
                }
                h.unregisterReceiver(this.f.get(a));
                this.f.remove(a);
            }
        }
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            ApkInfo apkInfo = this.c.get(str);
            if (apkInfo != null) {
                this.c.remove(str);
                this.d.remove(apkInfo.packageName);
                this.e.remove(Integer.valueOf(apkInfo.key));
                com.baidu.sofire.d.b.a(apkInfo.packageName);
                com.baidu.sofire.k.b.d(apkInfo.dataDir);
                Application application = h;
                if (application != null) {
                    com.baidu.sofire.k.b.d(application.getFileStreamPath(apkInfo.packageName).getAbsolutePath());
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            ApkInfo apkInfo = this.d.get(str);
            if (apkInfo != null) {
                this.c.remove(apkInfo.pkgPath);
                this.d.remove(str);
                this.e.remove(Integer.valueOf(apkInfo.key));
                com.baidu.sofire.d.b.a(str);
                com.baidu.sofire.k.b.d(apkInfo.dataDir);
                Application application = h;
                if (application != null) {
                    com.baidu.sofire.k.b.d(application.getFileStreamPath(apkInfo.packageName).getAbsolutePath());
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            try {
                ApkInfo apkInfo = this.d.get(str);
                if (apkInfo == null) {
                    return false;
                }
                Class<?> a = ((h) apkInfo.classLoader).a(com.baidu.sofire.k.b.b(apkInfo.es));
                Object invoke = a.getDeclaredMethod("getInstance", Context.class).invoke(a, h);
                if (invoke != null) {
                    com.baidu.sofire.k.b.a(invoke, "unload", (Class<?>[]) null, new Object[0]);
                }
                this.c.remove(apkInfo.pkgPath);
                this.d.remove(str);
                this.e.remove(Integer.valueOf(apkInfo.key));
                return true;
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
