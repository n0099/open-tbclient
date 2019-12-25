package com.baidu.swan.pms.b.b;

import android.os.Build;
import android.os.StatFs;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes9.dex */
class c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static File Re() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_mini_zip");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean p(String str, long j) {
        boolean z = false;
        if (str != null) {
            try {
                StatFs statFs = new StatFs(str);
                if (Build.VERSION.SDK_INT >= 18) {
                    z = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong() > j;
                } else {
                    z = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()) > j;
                }
            } catch (Throwable th) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.d("Mini-Pm-Download", com.baidu.swan.pms.d.aqG().getProcessName() + ": path exception or no space left." + th.toString());
                }
            }
        }
        return z;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION, IF, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION, IF, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION, IF, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION, IF, MOVE_EXCEPTION] complete} */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(InputStream inputStream, OutputStream outputStream, long j) {
        try {
            try {
                boolean b = b(inputStream, outputStream, j);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                        return b;
                    } catch (IOException e2) {
                        return b;
                    }
                }
                return b;
            } catch (IOException e3) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("Mini-Pm-Download", "safeCopyStream: " + e3.getMessage());
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e5) {
                    }
                }
                return false;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e7) {
                }
            }
            throw th;
        }
    }

    private static boolean b(InputStream inputStream, OutputStream outputStream, long j) throws IOException {
        byte[] bArr = new byte[32768];
        int length = bArr.length;
        long j2 = 0;
        int i = 0;
        while (i != -1) {
            if (j > 0) {
                if (j2 >= j) {
                    break;
                } else if (length + j2 > j) {
                    length = (int) (j - j2);
                }
            }
            i = inputStream.read(bArr, 0, length);
            if (i > 0) {
                outputStream.write(bArr, 0, i);
                j2 += i;
            }
        }
        return j2 == j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(String str, long j, String str2) {
        if (q(str, j)) {
            String md5 = str != null ? com.baidu.swan.pms.f.a.toMd5(new File(str), true) : null;
            if (str2 == null || md5 == null) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.d("Mini-Pm-Download", "md5 校验失败 server:" + str2 + ",local" + md5);
                    return false;
                }
                return false;
            }
            String upperCase = str2.toUpperCase();
            if (upperCase.equals(md5)) {
                return true;
            }
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.d("Mini-Pm-Download", "md5 校验失败 server:" + upperCase + ",local" + md5);
                return false;
            }
            return false;
        }
        return false;
    }

    private static boolean q(String str, long j) {
        File file = new File(str);
        if (!file.exists()) {
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.d("Mini-Pm-Download", "文件长度校验失败");
                return false;
            }
            return false;
        } else if (file.length() != j) {
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.d("Mini-Pm-Download", "文件长度校验失败 ,file length not match:server=" + j + "local=" + file.length());
                return false;
            }
            return false;
        } else {
            return true;
        }
    }
}
