package com.baidu.adp.lib.debug.a;

import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class d extends a implements Runnable {
    private String mPackageName;

    public d(Context context) {
        this.mPackageName = null;
        this.mPackageName = context.getPackageName();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [47=5, 48=5, 50=5, 51=5] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0089 A[Catch: Exception -> 0x008d, TRY_LEAVE, TryCatch #2 {Exception -> 0x008d, blocks: (B:43:0x0084, B:45:0x0089), top: B:72:0x0084 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0099 A[Catch: Exception -> 0x009f, TRY_LEAVE, TryCatch #0 {Exception -> 0x009f, blocks: (B:52:0x0094, B:54:0x0099), top: B:70:0x0094 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x00ae -> B:76:0x007f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String cK() {
        BufferedReader bufferedReader;
        Process process;
        Process process2 = null;
        try {
            process = Runtime.getRuntime().exec("top -n 1");
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            if (process != null) {
                                try {
                                    process.destroy();
                                } catch (Exception e) {
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                        } else if (readLine.endsWith(this.mPackageName)) {
                            String[] split = readLine.split("\\s+");
                            if (split[2].contains("%")) {
                                String trim = split[2].trim();
                                if (process != null) {
                                    try {
                                        process.destroy();
                                    } catch (Exception e2) {
                                        return trim;
                                    }
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                    return trim;
                                }
                                return trim;
                            }
                            for (int i = 0; i < split.length; i++) {
                                if (split[i].contains("%")) {
                                    String trim2 = split[i].trim();
                                    if (process != null) {
                                        try {
                                            process.destroy();
                                        } catch (Exception e3) {
                                            return trim2;
                                        }
                                    }
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                        return trim2;
                                    }
                                    return trim2;
                                }
                            }
                            continue;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        process2 = process;
                        try {
                            e.printStackTrace();
                            if (process2 != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            return "null";
                        } catch (Throwable th) {
                            th = th;
                            process = process2;
                            if (process != null) {
                                try {
                                    process.destroy();
                                } catch (Exception e5) {
                                    throw th;
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (process != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        throw th;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                bufferedReader = null;
                process2 = process;
                e.printStackTrace();
                if (process2 != null) {
                    try {
                        process2.destroy();
                    } catch (Exception e7) {
                    }
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return "null";
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (process != null) {
                }
                if (bufferedReader != null) {
                }
                throw th;
            }
        } catch (Exception e8) {
            e = e8;
            bufferedReader = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            process = null;
        }
        return "null";
    }

    @Override // java.lang.Runnable
    public void run() {
        super.start();
        while (true) {
            try {
                com.baidu.adp.lib.debug.d.M(cK());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!cJ()) {
                return;
            }
            Thread.sleep(500L);
        }
    }
}
