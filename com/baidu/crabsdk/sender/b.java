package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import com.baidu.crabsdk.b.p;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class b extends a {

    /* renamed from: c  reason: collision with root package name */
    public static int f4907c = 5;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4908b;

    public b(Context context) {
        super(context);
        this.f4908b = false;
    }

    public static void b(Map<String, Object> map) {
        String str;
        String str2;
        int indexOf;
        String str3 = "Reason:";
        StringBuilder sb = new StringBuilder();
        try {
            String str4 = (String) map.get("time");
            if (str4 == null) {
                return;
            }
            String substring = str4.substring(5);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -d -v time", (String[]) null, new File("/")).getInputStream()), 8192);
            String a2 = p.a();
            int i2 = 0;
            boolean z = true;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return;
                }
                int i3 = i2 + 1;
                if (i2 >= Integer.MAX_VALUE) {
                    return;
                }
                if (z) {
                    if (readLine.compareTo(substring) >= 0) {
                        z = false;
                    } else {
                        i2 = i3;
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
                if (readLine.contains(str3)) {
                    String[] split = readLine.split(str3);
                    str2 = str3;
                    if (split.length == 2) {
                        map.put("reason", split[1].trim());
                        if (split[1].trim().contains("(") && (indexOf = split[1].trim().indexOf("(")) > 0) {
                            map.put("type", split[1].trim().substring(0, indexOf));
                            if (!readLine.contains("ActivityManager") || readLine.contains(a2)) {
                                sb.append(readLine);
                                sb.append("\n");
                            }
                            i2 = i3;
                            str3 = str2;
                        }
                    }
                } else {
                    str2 = str3;
                }
                if (!readLine.contains("ActivityManager")) {
                }
                sb.append(readLine);
                sb.append("\n");
                i2 = i3;
                str3 = str2;
            }
        } catch (Exception e2) {
            e = e2;
            str = "putAnrLogcat error!";
            com.baidu.crabsdk.c.a.a(str, e);
        } catch (OutOfMemoryError e3) {
            e = e3;
            str = "putAnrLogcat oom!";
            com.baidu.crabsdk.c.a.a(str, e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0200, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0201, code lost:
        r1 = "errorOriLine";
        r14 = "errorLine";
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x020a, code lost:
        r8 = "threadList";
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x020c, code lost:
        r15.put(r8, r0.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0210, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0211, code lost:
        r8 = "threadList";
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0215, code lost:
        r8 = "threadList";
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x021b, code lost:
        if (r2.size() <= 0) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x021d, code lost:
        r0 = new java.lang.StringBuilder();
        r2 = r2.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x022a, code lost:
        if (r2.hasNext() == false) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x022c, code lost:
        r0.append((java.lang.String) r2.next());
        r0.append("###");
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x023d, code lost:
        r2 = "traceList";
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x023f, code lost:
        r15.put(r2, r0.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0243, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0244, code lost:
        r2 = "traceList";
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0248, code lost:
        r2 = "traceList";
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x024e, code lost:
        if (r1.size() <= 0) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0250, code lost:
        r0 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0258, code lost:
        if (r0.hasNext() == false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x025a, code lost:
        r1 = (java.lang.String) r0.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0266, code lost:
        if (r1.startsWith("main\n") == false) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0268, code lost:
        r3 = "mainThread";
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x026a, code lost:
        r15.put(r3, r1);
        r0 = r1.split("\n");
        r1 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0273, code lost:
        if (r1 >= r0.length) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x027b, code lost:
        if (d(r0[r1]) == false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x027d, code lost:
        r1 = r0[r1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0280, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0283, code lost:
        r1 = "N/A";
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x028b, code lost:
        if (r1.equals("N/A") == false) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x028d, code lost:
        r18 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0291, code lost:
        if (r0.length <= 1) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0293, code lost:
        r1 = r0[1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0297, code lost:
        r18 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0299, code lost:
        r1 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x029b, code lost:
        r14 = r0.length - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02a0, code lost:
        if (r14 <= 0) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02a8, code lost:
        if (d(r0[r14]) == false) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x02aa, code lost:
        r14 = r0[r14];
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x02ad, code lost:
        r14 = r14 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x02b0, code lost:
        r14 = "N/A";
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x02b5, code lost:
        if (r14.equals("N/A") == false) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x02b8, code lost:
        if (r0.length <= 0) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x02ba, code lost:
        r14 = r0[r0.length - 1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x02c1, code lost:
        r15.put("errorLine", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x02c4, code lost:
        r1 = "errorOriLine";
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x02c6, code lost:
        r15.put(r1, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x02c9, code lost:
        r14 = "errorLine";
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x02cb, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x02cd, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x02ce, code lost:
        r1 = "errorOriLine";
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x02d0, code lost:
        r14 = "errorLine";
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x02d2, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x02d3, code lost:
        r1 = "errorOriLine";
        r14 = "errorLine";
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x02d8, code lost:
        r1 = "errorOriLine";
        r14 = "errorLine";
        r3 = "mainThread";
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x02de, code lost:
        r4.close();
        b(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x02e6, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x02e8, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x02e9, code lost:
        r1 = "errorOriLine";
        r14 = "errorLine";
        r3 = "mainThread";
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x02f0, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x02f1, code lost:
        r1 = "errorOriLine";
        r14 = "errorLine";
        r3 = "mainThread";
        r2 = "traceList";
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x02fa, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x02fb, code lost:
        r1 = "errorOriLine";
        r14 = "errorLine";
        r3 = "mainThread";
        r2 = "traceList";
        r8 = "threadList";
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0305, code lost:
        r11 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x034a, code lost:
        r16 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x034d, code lost:
        if (r4.length > 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x034f, code lost:
        r1 = new java.lang.StringBuilder();
        r19 = r3;
        r17 = r14;
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x035a, code lost:
        if (r14 < r4.length) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x035c, code lost:
        r1.append(r4[r14].toString());
        r1.append("\n");
        r14 = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x036b, code lost:
        r15.put("apiType", "ANR");
        r15.put("errorType", "ANR");
        r15.put("pid", r11);
        r15.put("time", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
        r15.put(r23, r6);
        r15.put(r8, com.baidu.crabsdk.b.s.a());
        r15.put(r2, "读取trace文件失败：\n" + r0.getMessage());
        r15.put(r19, r1.toString());
        r15.put(r17, r4[0].toString());
        r15.put(r16, r4[0].toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a6, code lost:
        r15.put("apiType", "ANR");
        r15.put("errorType", "ANR");
        r15.put("pid", r8);
        r15.put("time", r0);
        r0 = new java.lang.StringBuilder();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b7, code lost:
        if (r6 == null) goto L235;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bf, code lost:
        if (r6.contains("DALVIK THREADS") != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c1, code lost:
        r0.append(r6);
        r0.append("\n");
        r6 = r4.readLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00cc, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00cd, code lost:
        r23 = r3;
        r11 = r8;
        r1 = "errorOriLine";
        r14 = "errorLine";
        r6 = "N/A";
        r3 = "mainThread";
        r2 = "traceList";
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00dc, code lost:
        r6 = r0.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e0, code lost:
        r15.put(r3, r6);
        r2.add(r6);
        r0 = new java.lang.StringBuilder();
        r11 = new java.lang.StringBuilder();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00f2, code lost:
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f3, code lost:
        r6 = r4.readLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00f7, code lost:
        if (r6 == null) goto L224;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f9, code lost:
        r22 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0101, code lost:
        if (r6.contains("----- end ") != false) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0109, code lost:
        r23 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x010d, code lost:
        if (r6.contains("prio") == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0115, code lost:
        if (r6.contains("tid") == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0118, code lost:
        if (r14 <= 1) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x011a, code lost:
        r1.add(r0.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0125, code lost:
        if (r11.length() <= 0) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0127, code lost:
        r2.add(r11.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x012e, code lost:
        r0.setLength(0);
        r11.setLength(0);
        r11.append(r6);
        r11.append("\n");
        r8 = java.util.regex.Pattern.compile("\".*\"").matcher(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0149, code lost:
        if (r8.find() == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x014b, code lost:
        r6 = r8.group().replace("\"", "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0155, code lost:
        r0.append(r6);
        r0.append("\n");
        r8 = r22;
        r3 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0160, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0162, code lost:
        r8 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0168, code lost:
        if (r6.startsWith(r8) == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x016a, code lost:
        r0.append(r6.replace(r8, ""));
        r0.append("\n");
        r14 = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0176, code lost:
        r11.append(r6);
        r11.append("\n");
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x017c, code lost:
        r26 = r8;
        r8 = r22;
        r3 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0184, code lost:
        r23 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0187, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0188, code lost:
        r23 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x018b, code lost:
        r23 = r3;
        r22 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x018f, code lost:
        r6 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0192, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0193, code lost:
        r23 = r3;
        r22 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0197, code lost:
        r1 = "errorOriLine";
        r14 = "errorLine";
        r3 = "mainThread";
        r2 = "traceList";
        r6 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01a2, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01a3, code lost:
        r23 = r3;
        r22 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01e2, code lost:
        if (r1.size() <= 0) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01e4, code lost:
        r0 = new java.lang.StringBuilder();
        r8 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01f1, code lost:
        if (r8.hasNext() == false) goto L210;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01f3, code lost:
        r0.append((java.lang.String) r8.next());
        r0.append("###");
     */
    /* JADX WARN: Removed duplicated region for block: B:194:0x034a A[Catch: Exception -> 0x03c1, TryCatch #21 {Exception -> 0x03c1, blocks: (B:192:0x033c, B:194:0x034a, B:196:0x034f, B:197:0x0359, B:199:0x035c, B:200:0x036b), top: B:247:0x033c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map<String, Object> c(String str) {
        String str2;
        String str3;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        String str4;
        String str5;
        StackTraceElement[] stackTrace;
        String str6;
        String str7;
        String str8 = "  at ";
        String str9 = "anrMsg";
        String str10 = "threadList";
        String str11 = "-----";
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            try {
                try {
                } catch (Exception e2) {
                    e = e2;
                    str3 = "anrMsg";
                    obj2 = "traceList";
                    obj3 = "errorOriLine";
                    obj4 = "errorLine";
                    str4 = "N/A";
                    obj = "mainThread";
                }
            } catch (Exception e3) {
                e = e3;
                str3 = "anrMsg";
                obj = "mainThread";
                obj2 = "traceList";
                obj3 = "errorOriLine";
                obj4 = "errorLine";
                str4 = "N/A";
            }
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
                String readLine = bufferedReader.readLine();
                String a2 = p.a();
                String str12 = "N/A";
                String str13 = str12;
                int i2 = 0;
                while (true) {
                    if (readLine == null) {
                        str3 = str9;
                        str5 = "N/A";
                        break;
                    }
                    try {
                        if (readLine.startsWith(str11) && readLine.endsWith(str11) && readLine.contains(" pid ") && readLine.contains(" at ")) {
                            int i3 = i2 + 1;
                            str7 = str11;
                            if (i3 > f4907c) {
                                bufferedReader.close();
                                return null;
                            }
                            String[] split = readLine.split("----- pid | at | -----$");
                            i2 = i3;
                            str6 = str8;
                            if (split.length >= 3) {
                                str12 = split[1];
                                str13 = split[2];
                            }
                        } else {
                            str6 = str8;
                            str7 = str11;
                        }
                        String str14 = str12;
                        String str15 = str13;
                        try {
                            if (readLine.contains(a2)) {
                                break;
                            }
                            str3 = str9;
                            str12 = str14;
                            String str16 = str6;
                            try {
                                readLine = bufferedReader.readLine();
                                str9 = str3;
                                str11 = str7;
                                str13 = str15;
                                str8 = str16;
                            } catch (Exception e4) {
                                e = e4;
                                obj3 = "errorOriLine";
                                obj4 = "errorLine";
                                str5 = "N/A";
                                obj = "mainThread";
                                obj2 = "traceList";
                                str4 = str12;
                                str10 = "threadList";
                                com.baidu.crabsdk.c.a.a("读取traces.txt文件失败!", e);
                                try {
                                    stackTrace = Looper.getMainLooper().getThread().getStackTrace();
                                    if (stackTrace != null) {
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    str2 = "7.0+封装anr数据失败!";
                                    com.baidu.crabsdk.c.a.a(str2, e);
                                    return hashMap;
                                }
                                return hashMap;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            str3 = str9;
                            str12 = str14;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        str3 = str9;
                    }
                }
            } catch (Exception e8) {
                e = e8;
                str3 = "anrMsg";
                obj3 = "errorOriLine";
                obj4 = "errorLine";
                str4 = "N/A";
                obj = "mainThread";
                obj2 = "traceList";
                str5 = str4;
                com.baidu.crabsdk.c.a.a("读取traces.txt文件失败!", e);
                stackTrace = Looper.getMainLooper().getThread().getStackTrace();
                if (stackTrace != null) {
                }
                return hashMap;
            }
        } catch (OutOfMemoryError e9) {
            e = e9;
            str2 = "内存溢出了！";
            com.baidu.crabsdk.c.a.a(str2, e);
            return hashMap;
        }
    }

    public static boolean d(String str) {
        String[] strArr = {"android.", "java.", "dalvik.", "com.android."};
        for (int i2 = 0; i2 < 4; i2++) {
            if (str.startsWith(strArr[i2])) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0073, code lost:
        com.baidu.crabsdk.c.a.c("===line.contains(tracesWroteLog)===");
        r12 = c(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007e, code lost:
        if (com.baidu.crabsdk.a.P == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0080, code lost:
        com.baidu.crabsdk.a.P.onAnrStarted(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0085, code lost:
        r1 = com.baidu.crabsdk.sender.g.c(r11.f4906a, null, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008c, code lost:
        if (r12 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0092, code lost:
        if (r12.size() != 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0095, code lost:
        r1.putAll(r12);
        com.baidu.crabsdk.sender.g.h(r1);
        com.baidu.crabsdk.sender.i.b(r11.f4906a, com.baidu.crabsdk.sender.i.h(r1));
        com.baidu.crabsdk.sender.h.k();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ab, code lost:
        if (com.baidu.crabsdk.sender.h.a() == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ad, code lost:
        com.baidu.crabsdk.c.a.c("===uploadAnr===");
        com.baidu.crabsdk.sender.k.b(false, r11.f4906a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b8, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:?, code lost:
        return;
     */
    @Override // com.baidu.crabsdk.sender.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(String str) {
        String str2;
        String readLine;
        com.baidu.crabsdk.c.a.c("===readLog()===");
        if (this.f4908b) {
            return;
        }
        this.f4908b = true;
        try {
            com.baidu.crabsdk.c.a.c("===readingTrace===");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
            String str3 = Build.VERSION.SDK_INT >= 27 ? "Wrote stack traces to '[tombstoned]'" : "Wrote stack traces to '/data/anr/traces.txt'";
            long currentTimeMillis = System.currentTimeMillis();
            String format = simpleDateFormat.format(Long.valueOf(currentTimeMillis));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -v time").getInputStream()), 8192);
            while (true) {
                if (System.currentTimeMillis() - currentTimeMillis > StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD || (readLine = bufferedReader.readLine()) == null || readLine.length() < 18) {
                    break;
                } else if (readLine.substring(0, 18).compareTo(format) >= 0 && readLine.contains(str3)) {
                    break;
                }
            }
        } catch (Exception e2) {
            e = e2;
            str2 = "ANR Log";
            com.baidu.crabsdk.c.a.a(str2, e);
            this.f4908b = false;
        } catch (OutOfMemoryError e3) {
            e = e3;
            str2 = "内存溢出了！";
            com.baidu.crabsdk.c.a.a(str2, e);
            this.f4908b = false;
        }
        this.f4908b = false;
    }
}
