package com.baidu.tbadk.core.hybrid;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
/* loaded from: classes.dex */
public class r {
    public static boolean unZipFiles(String str, String str2) {
        return unZipFiles(new File(str), str2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [64=5, 65=4, 66=4, 69=4, 70=4, 71=4] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean unZipFiles(File file, String str) {
        ZipFile zipFile;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        InputStream inputStream2;
        boolean z;
        ZipEntry nextElement;
        File file2;
        FileOutputStream fileOutputStream2;
        ZipFile zipFile2 = null;
        r3 = null;
        FileOutputStream fileOutputStream3 = null;
        File file3 = new File(str);
        if (file3.exists() || file3.mkdirs()) {
            boolean z2 = true;
            try {
                zipFile = new ZipFile(file);
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile.entries();
                    while (entries.hasMoreElements()) {
                        InputStream inputStream3 = null;
                        OutputStream outputStream = null;
                        try {
                            nextElement = entries.nextElement();
                            file2 = new File(str, nextElement.getName());
                        } catch (Exception e) {
                            e = e;
                            fileOutputStream = null;
                            inputStream2 = null;
                        } catch (Throwable th) {
                            th = th;
                            inputStream = null;
                        }
                        if (nextElement.isDirectory()) {
                            file2.mkdirs();
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
                                fileOutputStream2 = new FileOutputStream(file2);
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
                                        z = z2;
                                    }
                                }
                                z = z2;
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
                                        } catch (IOException e9) {
                                            e9.printStackTrace();
                                            z = false;
                                        }
                                    }
                                    z = false;
                                    z2 = z;
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [124=5] */
    public static boolean dG(String str, String str2) {
        ZipOutputStream zipOutputStream;
        try {
            try {
                zipOutputStream = new ZipOutputStream(new FileOutputStream(str2));
                try {
                    File file = new File(str);
                    if (!file.exists()) {
                        com.baidu.adp.lib.util.n.close((OutputStream) zipOutputStream);
                        return false;
                    }
                    a(file.getParent(), file.getName(), zipOutputStream);
                    zipOutputStream.finish();
                    zipOutputStream.close();
                    com.baidu.adp.lib.util.n.close((OutputStream) zipOutputStream);
                    return true;
                } catch (FileNotFoundException e) {
                    e = e;
                    e.printStackTrace();
                    com.baidu.adp.lib.util.n.close((OutputStream) zipOutputStream);
                    return false;
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    com.baidu.adp.lib.util.n.close((OutputStream) zipOutputStream);
                    return false;
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    com.baidu.adp.lib.util.n.close((OutputStream) zipOutputStream);
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.adp.lib.util.n.close((OutputStream) zipOutputStream);
                throw th;
            }
        } catch (FileNotFoundException e4) {
            e = e4;
            zipOutputStream = null;
        } catch (IOException e5) {
            e = e5;
            zipOutputStream = null;
        } catch (Exception e6) {
            e = e6;
            zipOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            zipOutputStream = null;
            com.baidu.adp.lib.util.n.close((OutputStream) zipOutputStream);
            throw th;
        }
    }

    private static void a(String str, String str2, ZipOutputStream zipOutputStream) throws Exception {
        if (zipOutputStream != null) {
            File file = new File(str, str2);
            if (file.exists()) {
                if (file.isFile()) {
                    ZipEntry zipEntry = new ZipEntry(str2);
                    FileInputStream fileInputStream = new FileInputStream(file);
                    zipOutputStream.putNextEntry(zipEntry);
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read != -1) {
                            zipOutputStream.write(bArr, 0, read);
                        } else {
                            zipOutputStream.closeEntry();
                            return;
                        }
                    }
                } else if (file.isDirectory()) {
                    String[] list = file.list();
                    if (list.length <= 0) {
                        zipOutputStream.putNextEntry(new ZipEntry(str2 + File.separator));
                        zipOutputStream.closeEntry();
                    }
                    for (int i = 0; i < list.length; i++) {
                        a(str, str2 + File.separator + list[i], zipOutputStream);
                    }
                }
            }
        }
    }
}
