package com.baidu.searchbox.anr.collector;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.searchbox.anr.impl.ANRMonitor;
import com.baidu.searchbox.anr.utils.Utils;
import com.baidu.searchbox.aperf.param.ThreadCollector;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes3.dex */
public class ANRCollector {
    public static final String DEFAULT_TRACE_PATH = "/data/anr/traces.txt";

    public static String getAllStackTrace() {
        if (!new File("/data/anr/traces.txt").canRead()) {
            return ThreadCollector.getAllThreadStacks();
        }
        return getAllTraceFromFile("/data/anr/traces.txt");
    }

    public static String getMainThreadStackTrace() {
        String str;
        if (new File("/data/anr/traces.txt").canRead()) {
            str = getMainTraceFromFile("/data/anr/traces.txt");
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return ThreadCollector.getThreadStack(Looper.getMainLooper().getThread());
        }
        return str;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x009f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getAllTraceFromFile(String str) {
        Throwable th;
        BufferedReader bufferedReader;
        IOException e;
        String readLine;
        String readLine2;
        ?? r1 = "";
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        File file = new File(str);
        if (!file.exists()) {
            return "";
        }
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                try {
                    String str2 = "Cmd line: " + Utils.getCurrentProcessName();
                    while (true) {
                        String readLine3 = bufferedReader.readLine();
                        if (readLine3 == null) {
                            String sb2 = sb.toString();
                            try {
                                bufferedReader.close();
                            } catch (IOException unused) {
                            }
                            return sb2;
                        } else if (readLine3.contains("----- pid ") && (readLine = bufferedReader.readLine()) != null && readLine.equals(str2)) {
                            sb.append(readLine3);
                            sb.append("\n");
                            sb.append(readLine);
                            sb.append("\n");
                            do {
                                readLine2 = bufferedReader.readLine();
                                if (readLine2 == null) {
                                    String sb3 = sb.toString();
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException unused2) {
                                    }
                                    return sb3;
                                }
                                sb.append(readLine2);
                                sb.append("\n");
                            } while (!readLine2.contains("----- end "));
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return sb.toString();
                }
            } catch (Throwable th2) {
                th = th2;
                if (r1 != 0) {
                    try {
                        r1.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (IOException e3) {
            bufferedReader = null;
            e = e3;
        } catch (Throwable th3) {
            r1 = 0;
            th = th3;
            if (r1 != 0) {
            }
            throw th;
        }
        try {
            bufferedReader.close();
        } catch (IOException unused4) {
            return sb.toString();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x00d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getMainTraceFromFile(String str) {
        Throwable th;
        BufferedReader bufferedReader;
        IOException e;
        String readLine;
        String readLine2;
        String readLine3;
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        File file = new File(str);
        if (!file.exists()) {
            return "";
        }
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                try {
                    String str2 = "Cmd line: " + Utils.getCurrentProcessName();
                    while (true) {
                        String readLine4 = bufferedReader.readLine();
                        if (readLine4 == null) {
                            String sb2 = sb.toString();
                            try {
                                bufferedReader.close();
                            } catch (IOException unused) {
                            }
                            return sb2;
                        } else if (readLine4.contains("----- pid ") && (readLine = bufferedReader.readLine()) != null && readLine.equals(str2)) {
                            String[] split = readLine4.split("----- pid | at | -----$");
                            if (split.length >= 3) {
                                ANRMonitor.sANRTimeStamp = split[2];
                            }
                            do {
                                readLine2 = bufferedReader.readLine();
                                if (readLine2 != null && !readLine2.contains("----- end ")) {
                                }
                                String sb3 = sb.toString();
                                try {
                                    bufferedReader.close();
                                } catch (IOException unused2) {
                                }
                                return sb3;
                            } while (!readLine2.contains("\"main\" prio="));
                            sb.append(readLine2);
                            sb.append("\n");
                            do {
                                readLine3 = bufferedReader.readLine();
                                if (readLine3 == null) {
                                    String sb4 = sb.toString();
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException unused3) {
                                    }
                                    return sb4;
                                } else if (readLine3.startsWith("  at ")) {
                                    sb.append(readLine3.replace("  at ", ""));
                                    sb.append("\n");
                                }
                            } while (!readLine3.equals(""));
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return sb.toString();
                }
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (IOException e3) {
            bufferedReader = null;
            e = e3;
        } catch (Throwable th3) {
            th = th3;
            if (0 != 0) {
            }
            throw th;
        }
        try {
            bufferedReader.close();
        } catch (IOException unused5) {
            return sb.toString();
        }
    }
}
