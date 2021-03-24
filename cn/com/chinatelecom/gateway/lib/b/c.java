package cn.com.chinatelecom.gateway.lib.b;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class c {
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x003e */
    /* JADX DEBUG: Multi-variable search result rejected for r5v14, resolved type: java.io.InputStreamReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v6, resolved type: java.io.InputStreamReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v7, resolved type: java.io.InputStreamReader */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:69:0x005c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        Throwable th;
        InputStreamReader inputStreamReader;
        File c2 = c(context);
        StringBuilder sb = new StringBuilder();
        if (c2 == null || !c2.exists()) {
            return "";
        }
        try {
            fileInputStream = new FileInputStream(c2);
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                sb.append(readLine);
                            } else {
                                try {
                                    break;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                th.printStackTrace();
                            } finally {
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                if (inputStreamReader != 0) {
                                    try {
                                        inputStreamReader.close();
                                    } catch (Exception e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception e5) {
                                        e5.printStackTrace();
                                    }
                                }
                            }
                        }
                    }
                    bufferedReader.close();
                    try {
                        inputStreamReader.close();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                } catch (Throwable th3) {
                    bufferedReader = null;
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                th = th;
                inputStreamReader = bufferedReader;
                th.printStackTrace();
            }
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
            bufferedReader = null;
        }
        return sb.toString();
    }

    public static void a(Context context, String str) {
        File c2 = c(context);
        if (c2 == null || !c2.exists()) {
            a(b(context), str);
        } else {
            a(c2, str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(File file, String str) {
        FileWriter fileWriter;
        Exception e2;
        Throwable th;
        BufferedWriter bufferedWriter;
        if (file == null || !file.exists()) {
            return;
        }
        BufferedWriter bufferedWriter2 = null;
        try {
            fileWriter = new FileWriter(file, false);
            try {
                bufferedWriter = new BufferedWriter(fileWriter);
            } catch (Exception e3) {
                e2 = e3;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedWriter2 != null) {
                }
                if (fileWriter != null) {
                }
                throw th;
            }
            try {
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                bufferedWriter.write(str);
                bufferedWriter.flush();
                try {
                    bufferedWriter.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            } catch (Exception e5) {
                e2 = e5;
                bufferedWriter2 = bufferedWriter;
                try {
                    e2.printStackTrace();
                    if (bufferedWriter2 != null) {
                        try {
                            bufferedWriter2.close();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (fileWriter == null) {
                        return;
                    }
                    fileWriter.close();
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    if (bufferedWriter2 != null) {
                        try {
                            bufferedWriter2.close();
                        } catch (Exception e7) {
                            e7.printStackTrace();
                        }
                    }
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (Exception e8) {
                            e8.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedWriter2 = bufferedWriter;
                th = th;
                if (bufferedWriter2 != null) {
                }
                if (fileWriter != null) {
                }
                throw th;
            }
        } catch (Exception e9) {
            e2 = e9;
            fileWriter = null;
        } catch (Throwable th5) {
            th = th5;
            fileWriter = null;
        }
        try {
            fileWriter.close();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static File b(Context context) {
        if (context != null) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(context.getFilesDir());
                sb.append("/eAccount/Log/");
                File file = new File(sb.toString());
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, "ipa_ol.ds");
                if (file2.exists()) {
                    file2.delete();
                }
                file2.createNewFile();
                return file2;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static File c(Context context) {
        if (context != null) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(context.getFilesDir());
                sb.append("/eAccount/Log/");
                File file = new File(sb.toString());
                if (file.exists()) {
                    File file2 = new File(file, "ipa_ol.ds");
                    if (file2.exists()) {
                        return file2;
                    }
                    return null;
                }
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
}
