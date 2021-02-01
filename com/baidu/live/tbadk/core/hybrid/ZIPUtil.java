package com.baidu.live.tbadk.core.hybrid;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes11.dex */
public class ZIPUtil {
    public static boolean unZipFiles(String str, String str2) {
        return unZipFiles(new File(str), str2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [64=4, 65=4, 66=4, 59=5, 60=4, 61=4] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean unZipFiles(File file, String str) {
        ZipFile zipFile;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        FileOutputStream fileOutputStream2;
        boolean z;
        ZipEntry nextElement;
        File file2;
        ZipFile zipFile2 = null;
        File file3 = new File(str);
        if (file3.exists() || file3.mkdirs()) {
            boolean z2 = true;
            try {
                zipFile = new ZipFile(file);
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile.entries();
                    while (entries.hasMoreElements()) {
                        InputStream inputStream2 = null;
                        OutputStream outputStream = null;
                        try {
                            nextElement = entries.nextElement();
                            file2 = new File(str, nextElement.getName());
                        } catch (Exception e) {
                            e = e;
                            fileOutputStream2 = null;
                            inputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = null;
                            inputStream = null;
                        }
                        if (nextElement.isDirectory()) {
                            file2.mkdirs();
                            if (0 != 0) {
                                try {
                                    inputStream2.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            if (0 != 0) {
                                try {
                                    outputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                        } else {
                            inputStream = zipFile.getInputStream(nextElement);
                            try {
                                fileOutputStream = new FileOutputStream(file2);
                            } catch (Exception e4) {
                                e = e4;
                                fileOutputStream2 = null;
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream = null;
                            }
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                fileOutputStream.flush();
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                        z = z2;
                                    }
                                }
                                z = z2;
                            } catch (Exception e7) {
                                e = e7;
                                fileOutputStream2 = fileOutputStream;
                                try {
                                    e.printStackTrace();
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e8) {
                                            e8.printStackTrace();
                                        }
                                    }
                                    if (fileOutputStream2 != null) {
                                        try {
                                            fileOutputStream2.close();
                                        } catch (IOException e9) {
                                            e9.printStackTrace();
                                            z = false;
                                        }
                                    }
                                    z = false;
                                    z2 = z;
                                } catch (Throwable th3) {
                                    th = th3;
                                    fileOutputStream = fileOutputStream2;
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e10) {
                                            e10.printStackTrace();
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e11) {
                                            e11.printStackTrace();
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                if (inputStream != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                throw th;
                            }
                            z2 = z;
                        }
                    }
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                } catch (Exception e13) {
                    e = e13;
                    zipFile2 = zipFile;
                    try {
                        e.printStackTrace();
                        if (zipFile2 != null) {
                            try {
                                zipFile2.close();
                            } catch (IOException e14) {
                                e14.printStackTrace();
                                z2 = false;
                            }
                        }
                        z2 = false;
                        return z2;
                    } catch (Throwable th5) {
                        th = th5;
                        zipFile = zipFile2;
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException e15) {
                                e15.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (zipFile != null) {
                    }
                    throw th;
                }
            } catch (Exception e16) {
                e = e16;
            } catch (Throwable th7) {
                th = th7;
                zipFile = null;
            }
            return z2;
        }
        return false;
    }
}
