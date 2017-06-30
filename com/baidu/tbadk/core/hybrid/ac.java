package com.baidu.tbadk.core.hybrid;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes.dex */
public class ac {
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [64=4, 65=5, 66=4, 78=4, 59=4, 60=4, 61=4] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(File file, String str) {
        ZipFile zipFile;
        boolean z;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        InputStream inputStream2;
        FileOutputStream fileOutputStream2;
        ZipFile zipFile2 = null;
        r3 = null;
        FileOutputStream fileOutputStream3 = null;
        File file2 = new File(str);
        if (file2.exists() || file2.mkdirs()) {
            boolean z2 = true;
            try {
                zipFile = new ZipFile(file);
            } catch (Exception e) {
                e = e;
            } catch (Throwable th) {
                th = th;
                zipFile = null;
            }
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    InputStream inputStream3 = null;
                    OutputStream outputStream = null;
                    try {
                        ZipEntry nextElement = entries.nextElement();
                        File file3 = new File(str, nextElement.getName());
                        if (nextElement.isDirectory()) {
                            file3.mkdirs();
                            if (0 != 0) {
                                try {
                                    inputStream3.close();
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
                                fileOutputStream2 = new FileOutputStream(file3);
                            } catch (Exception e4) {
                                e = e4;
                                fileOutputStream = null;
                                inputStream2 = inputStream;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    fileOutputStream2.write(bArr, 0, read);
                                }
                                fileOutputStream2.flush();
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                    }
                                }
                            } catch (Exception e7) {
                                e = e7;
                                fileOutputStream = fileOutputStream2;
                                inputStream2 = inputStream;
                                try {
                                    e.printStackTrace();
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (IOException e8) {
                                            e8.printStackTrace();
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                            z2 = false;
                                        } catch (IOException e9) {
                                            e9.printStackTrace();
                                            z2 = false;
                                        }
                                    } else {
                                        z2 = false;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    fileOutputStream3 = fileOutputStream;
                                    inputStream = inputStream2;
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e10) {
                                            e10.printStackTrace();
                                        }
                                    }
                                    if (fileOutputStream3 != null) {
                                        try {
                                            fileOutputStream3.close();
                                        } catch (IOException e11) {
                                            e11.printStackTrace();
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                fileOutputStream3 = fileOutputStream2;
                                if (inputStream != null) {
                                }
                                if (fileOutputStream3 != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Exception e12) {
                        e = e12;
                        fileOutputStream = null;
                        inputStream2 = null;
                    } catch (Throwable th5) {
                        th = th5;
                        inputStream = null;
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
                            z = false;
                        } catch (IOException e14) {
                            e14.printStackTrace();
                            z = false;
                        }
                    } else {
                        z = false;
                    }
                    return z;
                } catch (Throwable th6) {
                    th = th6;
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
            } catch (Throwable th7) {
                th = th7;
                if (zipFile != null) {
                }
                throw th;
            }
            if (zipFile != null) {
                try {
                    zipFile.close();
                    z = z2;
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
                return z;
            }
            z = z2;
            return z;
        }
        return false;
    }
}
