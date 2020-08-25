package com.baidu.android.util.io;

import android.os.Build;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.ZipFile;
/* loaded from: classes8.dex */
public class CommentUtils {
    public static String readComment(File file) {
        try {
            if (Build.VERSION.SDK_INT < 19) {
                return null;
            }
            return new ZipFile(file).getComment();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [79=4, 80=4, 82=4, 83=4] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String readApk(File file) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(file, "r");
                try {
                    byte[] bArr = new byte[2];
                    long length = randomAccessFile.length() - bArr.length;
                    randomAccessFile.seek(length);
                    randomAccessFile.readFully(bArr);
                    byte[] bArr2 = new byte[stream2Short(bArr, 0)];
                    randomAccessFile.seek(length - bArr2.length);
                    randomAccessFile.readFully(bArr2);
                    String str = new String(bArr2, "utf-8");
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                            return str;
                        } catch (IOException e) {
                            e.printStackTrace();
                            return str;
                        }
                    }
                    return str;
                } catch (FileNotFoundException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                } catch (IOException e4) {
                    e = e4;
                    e.printStackTrace();
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        randomAccessFile2.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e7) {
            e = e7;
            randomAccessFile = null;
        } catch (IOException e8) {
            e = e8;
            randomAccessFile = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [128=4, 130=4, 131=4, 133=4, 134=4, 136=4, 137=4, 127=4] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009d A[Catch: Exception -> 0x00a6, TryCatch #9 {Exception -> 0x00a6, blocks: (B:43:0x0098, B:45:0x009d, B:47:0x00a2), top: B:71:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a2 A[Catch: Exception -> 0x00a6, TRY_LEAVE, TryCatch #9 {Exception -> 0x00a6, blocks: (B:43:0x0098, B:45:0x009d, B:47:0x00a2), top: B:71:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String writeApk(File file, String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        ZipFile zipFile;
        ByteArrayOutputStream byteArrayOutputStream2;
        ZipFile zipFile2;
        byte[] byteArray;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        RandomAccessFile randomAccessFile3 = null;
        try {
            zipFile = new ZipFile(file);
            try {
                if (zipFile.getComment() != null) {
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                            return "bad";
                        }
                    }
                    if (0 != 0) {
                        byteArrayOutputStream3.close();
                    }
                    if (0 != 0) {
                        randomAccessFile3.close();
                        return "bad";
                    }
                    return "bad";
                }
                byte[] bytes = str.getBytes();
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byteArrayOutputStream.write(bytes);
                    byteArrayOutputStream.write(short2Stream((short) bytes.length));
                    byteArray = byteArrayOutputStream.toByteArray();
                    randomAccessFile = new RandomAccessFile(file, "rw");
                } catch (IOException e2) {
                    e = e2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    zipFile2 = zipFile;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    randomAccessFile.seek(file.length() - 2);
                    randomAccessFile.write(short2Stream((short) byteArray.length));
                    randomAccessFile.write(byteArray);
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            return FrsActivityConfig.GOOD;
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                        return FrsActivityConfig.GOOD;
                    }
                    return FrsActivityConfig.GOOD;
                } catch (IOException e4) {
                    e = e4;
                    randomAccessFile2 = randomAccessFile;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    zipFile2 = zipFile;
                    try {
                        e.printStackTrace();
                        if (zipFile2 != null) {
                            try {
                                zipFile2.close();
                            } catch (Exception e5) {
                                e5.printStackTrace();
                                return "bad";
                            }
                        }
                        if (byteArrayOutputStream2 != null) {
                            byteArrayOutputStream2.close();
                        }
                        if (randomAccessFile2 != null) {
                            randomAccessFile2.close();
                        }
                        return "bad";
                    } catch (Throwable th2) {
                        th = th2;
                        zipFile = zipFile2;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (Exception e6) {
                                e6.printStackTrace();
                                throw th;
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        if (randomAccessFile2 != null) {
                            randomAccessFile2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    randomAccessFile2 = randomAccessFile;
                    if (zipFile != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    if (randomAccessFile2 != null) {
                    }
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
                byteArrayOutputStream2 = null;
                zipFile2 = zipFile;
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
            }
        } catch (IOException e8) {
            e = e8;
            byteArrayOutputStream2 = null;
            zipFile2 = null;
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
            zipFile = null;
        }
    }

    private static byte[] short2Stream(short s) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putShort(s);
        allocate.flip();
        return allocate.array();
    }

    public static short stream2Short(byte[] bArr, int i) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(bArr[i]);
        allocate.put(bArr[i + 1]);
        return allocate.getShort(0);
    }
}
