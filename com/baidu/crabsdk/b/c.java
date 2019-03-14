package com.baidu.crabsdk.b;

import android.content.Context;
import android.os.Looper;
import com.baidu.appsearchlib.Info;
import com.baidu.sapi2.base.network.Apn;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public final class c {
    private static Context mContext;
    private static String abD = "data/anr/traces.txt";
    private static int aU = 5;
    private static Thread abE = null;

    private static void a(Map<String, Object> map) {
        int indexOf;
        StringBuilder sb = new StringBuilder();
        try {
            String str = (String) map.get(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            if (str == null) {
                return;
            }
            String substring = str.substring(5);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -d -v time", (String[]) null, new File("/")).getInputStream()), 8192);
            String G = o.G();
            boolean z = true;
            int i = 0;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return;
                }
                int i2 = i + 1;
                if (i >= Integer.MAX_VALUE) {
                    return;
                }
                if (z) {
                    if (readLine.compareTo(substring) >= 0) {
                        z = false;
                    } else {
                        i = i2;
                    }
                }
                if (readLine.contains("Input event dispatching timed out")) {
                    map.put("type", "Input event dispatching timed out");
                }
                if (readLine.contains("Timeout executing service")) {
                    map.put("type", "Timeout executing service");
                }
                if (readLine.contains("Activity pause timed out")) {
                    map.put("type", "Activity pause timed out");
                }
                if (readLine.contains("Reason:")) {
                    String[] split = readLine.split("Reason:");
                    if (split.length == 2) {
                        map.put("reason", split[1].trim());
                        if (split[1].trim().contains("(") && (indexOf = split[1].trim().indexOf("(")) > 0) {
                            map.put("type", split[1].trim().substring(0, indexOf));
                        }
                    }
                }
                if (readLine.contains("ActivityManager") || readLine.contains(G)) {
                    sb.append(readLine).append("\n");
                }
                i = i2;
            }
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.f("putAnrLogcat error!", e);
        } catch (OutOfMemoryError e2) {
            com.baidu.crabsdk.c.a.f("putAnrLogcat oom!", e2);
        }
    }

    private static boolean a(String str) {
        String[] strArr = {"android.", "java.", "dalvik.", "com.android."};
        for (int i = 0; i < 4; i++) {
            if (str.startsWith(strArr[i])) {
                return false;
            }
        }
        return true;
    }

    public static void d(Context context) {
        com.baidu.crabsdk.c.a.cv("init AnrCollector");
        com.baidu.crabsdk.c.a.cv("===Anr init!===");
        mContext = context;
        if (com.baidu.crabsdk.sender.e.se()) {
            com.baidu.crabsdk.c.a.cv("===Anr watchThread start!===");
            try {
                com.baidu.crabsdk.sender.a aVar = new com.baidu.crabsdk.sender.a(context);
                abE = aVar;
                aVar.start();
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.cy("Anr watchThread start failed !!");
            }
        }
    }

    public static Thread rR() {
        return abE;
    }

    public static Map<String, Object> t() {
        String str;
        String str2;
        HashMap hashMap = new HashMap();
        String str3 = Apn.APN_UNKNOWN;
        String str4 = Apn.APN_UNKNOWN;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(abD)));
            String readLine = bufferedReader.readLine();
            String G = o.G();
            while (true) {
                if (readLine == null) {
                    break;
                }
                if (readLine.startsWith("-----") && readLine.endsWith("-----") && readLine.contains(" pid ") && readLine.contains(" at ")) {
                    i++;
                    if (i > aU) {
                        bufferedReader.close();
                        return null;
                    }
                    String[] split = readLine.split("----- pid | at | -----$");
                    if (split.length >= 3) {
                        str3 = split[1];
                        str4 = split[2];
                    }
                }
                if (readLine.contains(G)) {
                    hashMap.put("apiType", "ANR");
                    hashMap.put("errorType", "ANR");
                    hashMap.put(Info.kBaiduPIDKey, str3);
                    hashMap.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, str4);
                    StringBuilder sb = new StringBuilder();
                    while (readLine != null && !readLine.contains("DALVIK THREADS")) {
                        sb.append(readLine).append("\n");
                        readLine = bufferedReader.readLine();
                    }
                    String sb2 = sb.toString();
                    hashMap.put("anrMsg", sb2);
                    arrayList2.add(sb2);
                    StringBuilder sb3 = new StringBuilder();
                    StringBuilder sb4 = new StringBuilder();
                    int i2 = 0;
                    while (true) {
                        String readLine2 = bufferedReader.readLine();
                        if (readLine2 == null || readLine2.contains("----- end ")) {
                            break;
                        } else if (readLine2.contains("prio") && readLine2.contains("tid")) {
                            if (i2 > 1) {
                                arrayList.add(sb3.toString());
                            }
                            if (sb4.length() > 0) {
                                arrayList2.add(sb4.toString());
                            }
                            sb3.setLength(0);
                            sb4.setLength(0);
                            i2 = 0;
                            sb4.append(readLine2).append("\n");
                            Matcher matcher = Pattern.compile("\".*\"").matcher(readLine2);
                            if (matcher.find()) {
                                readLine2 = matcher.group().replace("\"", "");
                            }
                            sb3.append(readLine2).append("\n");
                        } else {
                            if (readLine2.startsWith("  at ")) {
                                sb3.append(readLine2.replace("  at ", "")).append("\n");
                                i2++;
                            }
                            sb4.append(readLine2).append("\n");
                        }
                    }
                } else {
                    readLine = bufferedReader.readLine();
                }
            }
            if (arrayList.size() > 0) {
                StringBuilder sb5 = new StringBuilder();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    sb5.append((String) it.next()).append("###");
                }
                hashMap.put("threadList", sb5.toString());
            }
            if (arrayList2.size() > 0) {
                StringBuilder sb6 = new StringBuilder();
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    sb6.append((String) it2.next()).append("###");
                }
                hashMap.put("traceList", sb6.toString());
            }
            if (arrayList.size() > 0) {
                Iterator it3 = arrayList.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    String str5 = (String) it3.next();
                    if (str5.startsWith("main\n")) {
                        hashMap.put("mainThread", str5);
                        String[] split2 = str5.split("\n");
                        int i3 = 1;
                        while (true) {
                            if (i3 >= split2.length) {
                                str = Apn.APN_UNKNOWN;
                                break;
                            } else if (a(split2[i3])) {
                                str = split2[i3];
                                break;
                            } else {
                                i3++;
                            }
                        }
                        String str6 = (!str.equals(Apn.APN_UNKNOWN) || split2.length <= 1) ? str : split2[1];
                        int length = split2.length - 1;
                        while (true) {
                            if (length <= 0) {
                                str2 = Apn.APN_UNKNOWN;
                                break;
                            } else if (a(split2[length])) {
                                str2 = split2[length];
                                break;
                            } else {
                                length--;
                            }
                        }
                        if (str2.equals(Apn.APN_UNKNOWN) && split2.length > 0) {
                            str2 = split2[split2.length - 1];
                        }
                        hashMap.put("errorLine", str6);
                        hashMap.put("errorOriLine", str2);
                    }
                }
            }
            bufferedReader.close();
            a(hashMap);
        } catch (IOException e) {
            com.baidu.crabsdk.c.a.f("读取traces.txt文件失败!", e);
            try {
                StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
                if (stackTrace != null && stackTrace.length > 0) {
                    StringBuilder sb7 = new StringBuilder();
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        sb7.append(stackTraceElement.toString()).append("\n");
                    }
                    hashMap.put("apiType", "ANR");
                    hashMap.put("errorType", "ANR");
                    hashMap.put(Info.kBaiduPIDKey, Apn.APN_UNKNOWN);
                    hashMap.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, Long.valueOf(System.currentTimeMillis()));
                    hashMap.put("anrMsg", Apn.APN_UNKNOWN);
                    hashMap.put("threadList", r.M());
                    hashMap.put("traceList", "由于系统原因，Android7.0以上无权限读取\"data/anr/...\"\n\n" + sb7.toString());
                    hashMap.put("mainThread", sb7.toString());
                    hashMap.put("errorLine", stackTrace[0].toString());
                    hashMap.put("errorOriLine", stackTrace[0].toString());
                }
            } catch (Exception e2) {
                com.baidu.crabsdk.c.a.f("7.0+封装anr数据失败!", e2);
            }
        } catch (Exception e3) {
            com.baidu.crabsdk.c.a.f("封装anr数据失败!", e3);
        } catch (OutOfMemoryError e4) {
            com.baidu.crabsdk.c.a.f("内存溢出了！", e4);
        }
        return hashMap;
    }
}
