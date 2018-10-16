package com.baidu.searchbox.ng.ai.apps.core;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.account.AiAppAccount;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel;
import java.util.List;
/* loaded from: classes2.dex */
public class AiAppsCoreUtils {
    private static final String BDUSS = "BDUSS";
    private static final boolean DEBUG = false;
    private static final String DELETED = "deleted";
    private static final String URL_PREFIX = "http://www.";
    private static String FUNC_NAME_BOX_SESSION = "Box_Session";
    private static String FUNC_NAME_SETSESSION = "Set_Session";
    private static String FUNC_NAME_CLEARSESSION_SETSESSION = "Clear_Set_Session";

    public static void syncBdussCookie(Context context) {
        String str;
        String buildBDUSSCookie;
        if (context != null) {
            AiAppAccount account = AiApp.get() != null ? AiApp.get().getAccount() : null;
            if (account == null) {
                str = FUNC_NAME_CLEARSESSION_SETSESSION;
            } else {
                str = FUNC_NAME_SETSESSION;
            }
            String bduss = account != null ? account.getBduss(context) : null;
            List<String> authorizedDomains = AiAppsRuntime.getAiAppAccountRuntime().getAuthorizedDomains(context.getApplicationContext());
            if (authorizedDomains != null) {
                for (String str2 : authorizedDomains) {
                    if (TextUtils.isEmpty(bduss)) {
                        buildBDUSSCookie = AiAppsRuntime.getAiAppAccountRuntime().getAccountCookieStr(str2, BDUSS, DELETED, 0L);
                    } else {
                        buildBDUSSCookie = AiAppsRuntime.getAiAppAccountRuntime().buildBDUSSCookie(str2, bduss);
                    }
                    AiAppsRuntime.getAiAppAccountRuntime().setCookieManualWithBdussOperate(URL_PREFIX + str2, buildBDUSSCookie, false, str);
                }
            }
        }
    }

    public static boolean isEnableRemoteDebug() {
        return AiAppsRuntime.getConfigRuntime().isRemoteDebug();
    }

    public static void copyFileUsingFileChannels(File file, File file2) throws IOException {
        FileChannel fileChannel;
        FileChannel channel;
        FileChannel channel2;
        FileChannel fileChannel2 = null;
        try {
            channel = new FileInputStream(file).getChannel();
            try {
                channel2 = new FileOutputStream(file2).getChannel();
            } catch (Throwable th) {
                th = th;
                fileChannel2 = channel;
                fileChannel = null;
            }
        } catch (Throwable th2) {
            th = th2;
            fileChannel = null;
        }
        try {
            channel2.transferFrom(channel, 0L, channel.size());
            if (channel != null) {
                channel.close();
            }
            if (channel2 != null) {
                channel2.close();
            }
        } catch (Throwable th3) {
            fileChannel2 = channel;
            fileChannel = channel2;
            th = th3;
            if (fileChannel2 != null) {
                fileChannel2.close();
            }
            if (fileChannel != null) {
                fileChannel.close();
            }
            throw th;
        }
    }

    public static void restFile(String str) {
        insertBeforeFile(str, null, null, true);
    }

    public static void insertBeforeFile(String str, String str2, String str3) {
        insertBeforeFile(str, str2, str3, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [200=5, 202=4, 203=4, 209=4, 211=4, 212=4, 219=4, 221=4, 222=4] */
    /* JADX WARN: Removed duplicated region for block: B:100:0x011a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0124 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x011f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void insertBeforeFile(String str, String str2, String str3, boolean z) {
        BufferedReader bufferedReader;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader2;
        FileInputStream fileInputStream2;
        BufferedWriter bufferedWriter = null;
        InputStream inputStream = null;
        BufferedReader bufferedReader3 = null;
        BufferedWriter bufferedWriter2 = null;
        try {
            File file = new File(str);
            String absolutePath = file.getParentFile().getAbsolutePath();
            String name = file.getName();
            File file2 = new File(absolutePath + File.separator + name + ".tmp");
            File file3 = new File(absolutePath + File.separator + name + ".bak");
            if (z) {
                if (file3.exists()) {
                    file3.renameTo(file);
                }
                if (0 != 0) {
                    try {
                        bufferedReader3.close();
                    } catch (IOException e) {
                    }
                }
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                    }
                }
                if (0 != 0) {
                    try {
                        bufferedWriter2.close();
                        return;
                    } catch (IOException e3) {
                        return;
                    }
                }
                return;
            }
            fileInputStream = new FileInputStream(file);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                try {
                    if (file3.exists()) {
                        copyFileUsingFileChannels(file3, file);
                    } else {
                        copyFileUsingFileChannels(file, file3);
                    }
                    BufferedWriter bufferedWriter3 = new BufferedWriter(new FileWriter(file2));
                    boolean z2 = false;
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            if (readLine.contains(str2)) {
                                bufferedWriter3.write(str3 + "\n");
                                z2 = true;
                            }
                            bufferedWriter3.write(readLine + "\n");
                        } catch (Exception e4) {
                            e = e4;
                            bufferedWriter = bufferedWriter3;
                            bufferedReader2 = bufferedReader;
                            fileInputStream2 = fileInputStream;
                            try {
                                e.printStackTrace();
                                if (bufferedReader2 != null) {
                                    try {
                                        bufferedReader2.close();
                                    } catch (IOException e5) {
                                    }
                                }
                                if (fileInputStream2 != null) {
                                    try {
                                        fileInputStream2.close();
                                    } catch (IOException e6) {
                                    }
                                }
                                if (bufferedWriter != null) {
                                    try {
                                        bufferedWriter.close();
                                        return;
                                    } catch (IOException e7) {
                                        return;
                                    }
                                }
                                return;
                            } catch (Throwable th) {
                                th = th;
                                fileInputStream = fileInputStream2;
                                bufferedReader = bufferedReader2;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e8) {
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e9) {
                                    }
                                }
                                if (bufferedWriter != null) {
                                    try {
                                        bufferedWriter.close();
                                    } catch (IOException e10) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedWriter = bufferedWriter3;
                            if (bufferedReader != null) {
                            }
                            if (fileInputStream != null) {
                            }
                            if (bufferedWriter != null) {
                            }
                            throw th;
                        }
                    }
                    bufferedWriter3.flush();
                    if (z2) {
                        file2.renameTo(file);
                    } else {
                        file2.delete();
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e11) {
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e12) {
                        }
                    }
                    if (bufferedWriter3 != null) {
                        try {
                            bufferedWriter3.close();
                        } catch (IOException e13) {
                        }
                    }
                } catch (Exception e14) {
                    e = e14;
                    bufferedReader2 = bufferedReader;
                    fileInputStream2 = fileInputStream;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e15) {
                e = e15;
                bufferedReader2 = null;
                fileInputStream2 = fileInputStream;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
        } catch (Exception e16) {
            e = e16;
            bufferedReader2 = null;
            fileInputStream2 = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            fileInputStream = null;
        }
    }
}
