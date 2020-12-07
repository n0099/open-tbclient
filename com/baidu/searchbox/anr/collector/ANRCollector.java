package com.baidu.searchbox.anr.collector;

import android.os.Looper;
import com.baidu.searchbox.anr.impl.ANRMonitor;
import com.baidu.searchbox.anr.utils.Utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes20.dex */
public class ANRCollector {
    private static final String DEFAULT_TRACE_PATH = "/data/anr/traces.txt";

    public static String getAllStackTrace() {
        if (!new File(DEFAULT_TRACE_PATH).canRead()) {
            return ThreadCollector.getAllThreadStacks();
        }
        return getAllTraceFromFile(DEFAULT_TRACE_PATH);
    }

    public static String getMainThreadStackTrace() {
        if (!new File(DEFAULT_TRACE_PATH).canRead()) {
            return ThreadCollector.getThreadStack(Looper.getMainLooper().getThread());
        }
        return getMainTraceFromFile(DEFAULT_TRACE_PATH);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [113=6, 115=5, 116=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:56:0x00c9 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String getAllTraceFromFile(String str) {
        BufferedReader bufferedReader;
        String readLine;
        String readLine2;
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        File file = new File(str);
        ?? exists = file.exists();
        if (exists == 0) {
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
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                    return sb2;
                                } catch (IOException e) {
                                    return sb2;
                                }
                            }
                            return sb2;
                        } else if (readLine3.contains("----- pid ") && (readLine = bufferedReader.readLine()) != null && readLine.equals(str2)) {
                            sb.append(readLine3).append("\n").append(readLine).append("\n");
                            do {
                                readLine2 = bufferedReader.readLine();
                                if (readLine2 == null) {
                                    String sb3 = sb.toString();
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                            return sb3;
                                        } catch (IOException e2) {
                                            return sb3;
                                        }
                                    }
                                    return sb3;
                                }
                                sb.append(readLine2).append("\n");
                            } while (!readLine2.contains("----- end "));
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e3) {
                                }
                            }
                        }
                    }
                } catch (IOException e4) {
                    e = e4;
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e5) {
                        }
                    }
                    return sb.toString();
                }
            } catch (Throwable th) {
                th = th;
                if (exists != 0) {
                    try {
                        exists.close();
                    } catch (IOException e6) {
                    }
                }
                throw th;
            }
        } catch (IOException e7) {
            e = e7;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            exists = 0;
            if (exists != 0) {
            }
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [192=7, 194=6, 195=5] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:75:0x0107 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String getMainTraceFromFile(String str) {
        BufferedReader bufferedReader;
        String readLine;
        String readLine2;
        String readLine3;
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        File file = new File(str);
        ?? exists = file.exists();
        if (exists == 0) {
            return "";
        }
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                try {
                    String str2 = "Cmd line: " + Utils.getCurrentProcessName();
                    while (true) {
                        String readLine4 = bufferedReader.readLine();
                        if (readLine4 == null) {
                            String sb2 = sb.toString();
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                    return sb2;
                                } catch (IOException e) {
                                    return sb2;
                                }
                            }
                            return sb2;
                        } else if (readLine4.contains("----- pid ") && (readLine = bufferedReader.readLine()) != null && readLine.equals(str2)) {
                            String[] split = readLine4.split("----- pid | at | -----$");
                            if (split.length >= 3) {
                                ANRMonitor.sANRTimeStamp = split[2];
                            }
                            do {
                                readLine2 = bufferedReader.readLine();
                                if (readLine2 == null || "\"main\" prio=".contains("----- end ")) {
                                    String sb3 = sb.toString();
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                            return sb3;
                                        } catch (IOException e2) {
                                            return sb3;
                                        }
                                    }
                                    return sb3;
                                }
                            } while (!readLine2.contains("\"main\" prio="));
                            sb.append(readLine2).append("\n");
                            do {
                                readLine3 = bufferedReader.readLine();
                                if (readLine3 == null) {
                                    String sb4 = sb.toString();
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                            return sb4;
                                        } catch (IOException e3) {
                                            return sb4;
                                        }
                                    }
                                    return sb4;
                                } else if (readLine3.startsWith("  at ")) {
                                    sb.append(readLine3.replace("  at ", "")).append("\n");
                                }
                            } while (!readLine3.equals(""));
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e4) {
                                }
                            }
                        }
                    }
                } catch (IOException e5) {
                    e = e5;
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e6) {
                        }
                    }
                    return sb.toString();
                }
            } catch (Throwable th) {
                th = th;
                if (exists != 0) {
                    try {
                        exists.close();
                    } catch (IOException e7) {
                    }
                }
                throw th;
            }
        } catch (IOException e8) {
            e = e8;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            exists = 0;
            if (exists != 0) {
            }
            throw th;
        }
    }
}
