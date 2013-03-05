package com.baidu.browser.core.util;

import com.baidu.zeus.NotificationProxy;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class BdCmdExecutor {
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "BdCmdExecutor";

    /* JADX WARN: Removed duplicated region for block: B:49:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized String run(String[] strArr, String str) {
        InputStream inputStream;
        Throwable th;
        String str2;
        StringBuffer stringBuffer;
        InputStream inputStream2 = null;
        try {
            try {
                stringBuffer = new StringBuffer();
                if (str != null) {
                    ProcessBuilder processBuilder = new ProcessBuilder(strArr);
                    processBuilder.directory(new File(str));
                    processBuilder.redirectErrorStream(true);
                    InputStream inputStream3 = processBuilder.start().getInputStream();
                    try {
                        byte[] bArr = new byte[NotificationProxy.MAX_URL_LENGTH];
                        while (inputStream3.read(bArr) != -1) {
                            stringBuffer.append(new String(bArr));
                        }
                        inputStream3.close();
                        inputStream = inputStream3;
                    } catch (Throwable th2) {
                        inputStream = inputStream3;
                        th = th2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e) {
                            }
                        }
                        throw th;
                    }
                } else {
                    inputStream = null;
                }
            } catch (Exception e2) {
            }
        } catch (Throwable th3) {
            inputStream = null;
            th = th3;
        }
        try {
            str2 = stringBuffer.toString();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                }
            }
        } catch (Exception e4) {
            inputStream2 = inputStream;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException e5) {
                }
            }
            str2 = "";
            return str2;
        } catch (Throwable th4) {
            th = th4;
            if (inputStream != null) {
            }
            throw th;
        }
        return str2;
    }
}
