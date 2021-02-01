package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public final class b extends a {
    private static int aqu = 5;
    private boolean aqt;

    public b(Context context) {
        super(context);
        this.aqt = false;
    }

    private static void a(Map<String, Object> map) {
        int indexOf;
        StringBuilder sb = new StringBuilder();
        try {
            String str = (String) map.get("time");
            if (str == null) {
                return;
            }
            String substring = str.substring(5);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -d -v time", (String[]) null, new File("/")).getInputStream()), 8192);
            String J = com.baidu.crabsdk.b.p.J();
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
                        map.put(TiebaInitialize.LogFields.REASON, split[1].trim());
                        if (split[1].trim().contains("(") && (indexOf = split[1].trim().indexOf("(")) > 0) {
                            map.put("type", split[1].trim().substring(0, indexOf));
                        }
                    }
                }
                if (readLine.contains("ActivityManager") || readLine.contains(J)) {
                    sb.append(readLine).append("\n");
                }
                i = i2;
            }
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("putAnrLogcat error!", e);
        } catch (OutOfMemoryError e2) {
            com.baidu.crabsdk.c.a.a("putAnrLogcat oom!", e2);
        }
    }

    private static Map<String, Object> dR(String str) {
        String str2;
        String str3;
        HashMap hashMap = new HashMap();
        String str4 = "N/A";
        String str5 = "N/A";
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
            String readLine = bufferedReader.readLine();
            String J = com.baidu.crabsdk.b.p.J();
            while (true) {
                if (readLine == null) {
                    break;
                }
                if (readLine.startsWith("-----") && readLine.endsWith("-----") && readLine.contains(" pid ") && readLine.contains(" at ")) {
                    i++;
                    if (i > aqu) {
                        bufferedReader.close();
                        return null;
                    }
                    String[] split = readLine.split("----- pid | at | -----$");
                    if (split.length >= 3) {
                        str4 = split[1];
                        str5 = split[2];
                    }
                }
                if (readLine.contains(J)) {
                    hashMap.put("apiType", "ANR");
                    hashMap.put("errorType", "ANR");
                    hashMap.put("pid", str4);
                    hashMap.put("time", str5);
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
                    String str6 = (String) it3.next();
                    if (str6.startsWith("main\n")) {
                        hashMap.put("mainThread", str6);
                        String[] split2 = str6.split("\n");
                        int i3 = 1;
                        while (true) {
                            if (i3 >= split2.length) {
                                str2 = "N/A";
                                break;
                            } else if (g(split2[i3])) {
                                str2 = split2[i3];
                                break;
                            } else {
                                i3++;
                            }
                        }
                        String str7 = (!str2.equals("N/A") || split2.length <= 1) ? str2 : split2[1];
                        int length = split2.length - 1;
                        while (true) {
                            if (length <= 0) {
                                str3 = "N/A";
                                break;
                            } else if (g(split2[length])) {
                                str3 = split2[length];
                                break;
                            } else {
                                length--;
                            }
                        }
                        if (str3.equals("N/A") && split2.length > 0) {
                            str3 = split2[split2.length - 1];
                        }
                        hashMap.put("errorLine", str7);
                        hashMap.put("errorOriLine", str3);
                    }
                }
            }
            bufferedReader.close();
            a(hashMap);
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("读取traces.txt文件失败!", e);
            try {
                StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
                if (stackTrace != null && stackTrace.length > 0) {
                    StringBuilder sb7 = new StringBuilder();
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        sb7.append(stackTraceElement.toString()).append("\n");
                    }
                    hashMap.put("apiType", "ANR");
                    hashMap.put("errorType", "ANR");
                    hashMap.put("pid", "N/A");
                    hashMap.put("time", Long.valueOf(System.currentTimeMillis()));
                    hashMap.put("anrMsg", "N/A");
                    hashMap.put("threadList", com.baidu.crabsdk.b.s.Q());
                    hashMap.put("traceList", "读取trace文件失败：\n" + e.getMessage());
                    hashMap.put("mainThread", sb7.toString());
                    hashMap.put("errorLine", stackTrace[0].toString());
                    hashMap.put("errorOriLine", stackTrace[0].toString());
                }
            } catch (Exception e2) {
                com.baidu.crabsdk.c.a.a("7.0+封装anr数据失败!", e2);
            }
        } catch (OutOfMemoryError e3) {
            com.baidu.crabsdk.c.a.a("内存溢出了！", e3);
        }
        return hashMap;
    }

    private static boolean g(String str) {
        String[] strArr = {"android.", "java.", "dalvik.", "com.android."};
        for (int i = 0; i < 4; i++) {
            if (str.startsWith(strArr[i])) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0080, code lost:
        com.baidu.crabsdk.c.a.v("===line.contains(tracesWroteLog)===");
        r0 = dR(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x008c, code lost:
        if (com.baidu.crabsdk.a.P == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008e, code lost:
        com.baidu.crabsdk.a.P.onAnrStarted(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0093, code lost:
        r1 = com.baidu.crabsdk.sender.g.a(r13.aqs, (java.lang.Throwable) null, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009b, code lost:
        if (r0 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a1, code lost:
        if (r0.size() == 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a3, code lost:
        r1.putAll(r0);
        com.baidu.crabsdk.sender.g.b(r1);
        com.baidu.crabsdk.sender.i.a(r13.aqs, com.baidu.crabsdk.sender.i.e(r1));
        com.baidu.crabsdk.sender.h.ag();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b9, code lost:
        if (com.baidu.crabsdk.sender.h.uv() == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00bb, code lost:
        com.baidu.crabsdk.c.a.v("===uploadAnr===");
        com.baidu.crabsdk.sender.k.a(false, r13.aqs);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:?, code lost:
        return;
     */
    @Override // com.baidu.crabsdk.sender.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(String str) {
        String readLine;
        com.baidu.crabsdk.c.a.v("===readLog()===");
        if (this.aqt) {
            return;
        }
        this.aqt = true;
        try {
            com.baidu.crabsdk.c.a.v("===readingTrace===");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
            String str2 = Build.VERSION.SDK_INT >= 27 ? "Wrote stack traces to '[tombstoned]'" : "Wrote stack traces to '/data/anr/traces.txt'";
            long currentTimeMillis = System.currentTimeMillis();
            String format = simpleDateFormat.format(Long.valueOf(currentTimeMillis));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -v time").getInputStream()), 8192);
            while (true) {
                if (System.currentTimeMillis() - currentTimeMillis > 30000 || (readLine = bufferedReader.readLine()) == null || readLine.length() < "MM-dd HH:mm:ss.SSS".length()) {
                    break;
                } else if (readLine.substring(0, "MM-dd HH:mm:ss.SSS".length()).compareTo(format) >= 0 && readLine.contains(str2)) {
                    break;
                }
            }
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("ANR Log", e);
        } catch (OutOfMemoryError e2) {
            com.baidu.crabsdk.c.a.a("内存溢出了！", e2);
        }
        this.aqt = false;
    }
}
