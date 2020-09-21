package com.baidu.q.a.c;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
/* loaded from: classes25.dex */
class f {
    public static boolean b(String str, File file, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return a(new ByteArrayInputStream(str.getBytes()), file, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [57=4] */
    private static boolean a(InputStream inputStream, File file, boolean z) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file, z);
            try {
                r0 = copyStream(inputStream, fileOutputStream) != 0;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                    }
                }
            } catch (FileNotFoundException e2) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
                return r0;
            } catch (Throwable th) {
                th = th;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e5) {
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
        return r0;
    }

    private static long copyStream(InputStream inputStream, OutputStream outputStream) {
        if (inputStream == null || outputStream == null) {
            return 0L;
        }
        try {
            byte[] bArr = new byte[3072];
            long j = 0;
            while (true) {
                int read = inputStream.read(bArr);
                if (read > 0) {
                    outputStream.write(bArr, 0, read);
                    j += read;
                } else {
                    outputStream.flush();
                    return j;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [114=4] */
    public static String readFileData(File file) {
        FileInputStream fileInputStream;
        String str = null;
        try {
            fileInputStream = new FileInputStream(file);
            if (fileInputStream != null) {
                try {
                    str = readInputStream(fileInputStream);
                } catch (FileNotFoundException e) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    return str;
                } catch (Throwable th) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    return str;
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                }
            }
        } catch (FileNotFoundException e5) {
            fileInputStream = null;
        } catch (Throwable th2) {
            fileInputStream = null;
        }
        return str;
    }

    private static String readInputStream(@NonNull FileInputStream fileInputStream) {
        if (fileInputStream == null) {
            throw new NullPointerException("inputStream should not be null");
        }
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return sb.toString();
                }
                sb.append(readLine);
            }
        } catch (IOException e) {
            return sb.toString();
        } catch (Throwable th) {
            return sb.toString();
        }
    }
}
