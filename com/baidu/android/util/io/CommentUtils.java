package com.baidu.android.util.io;

import android.os.Build;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.ZipFile;
@Deprecated
/* loaded from: classes.dex */
public class CommentUtils {
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0058: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:32:0x0058 */
    /* JADX WARN: Removed duplicated region for block: B:45:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String readApk(File file) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        RandomAccessFile randomAccessFile3 = null;
        try {
            try {
                try {
                    randomAccessFile = new RandomAccessFile(file, r.f7772a);
                    try {
                        byte[] bArr = new byte[2];
                        long length = randomAccessFile.length() - 2;
                        randomAccessFile.seek(length);
                        randomAccessFile.readFully(bArr);
                        int stream2Short = stream2Short(bArr, 0);
                        byte[] bArr2 = new byte[stream2Short];
                        randomAccessFile.seek(length - stream2Short);
                        randomAccessFile.readFully(bArr2);
                        String str = new String(bArr2, "utf-8");
                        try {
                            randomAccessFile.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        return str;
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        e.printStackTrace();
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        return null;
                    } catch (IOException e4) {
                        e = e4;
                        e.printStackTrace();
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile3 = randomAccessFile2;
                    if (randomAccessFile3 != null) {
                        try {
                            randomAccessFile3.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e6) {
                e = e6;
                randomAccessFile = null;
            } catch (IOException e7) {
                e = e7;
                randomAccessFile = null;
            } catch (Throwable th2) {
                th = th2;
                if (randomAccessFile3 != null) {
                }
                throw th;
            }
        } catch (IOException e8) {
            e8.printStackTrace();
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0035: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:29:0x0035 */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String readComment(File file) {
        ZipFile zipFile;
        ZipFile zipFile2;
        String str;
        ZipFile zipFile3 = null;
        try {
            try {
                if (Build.VERSION.SDK_INT >= 19) {
                    zipFile = new ZipFile(file);
                    try {
                        str = zipFile.getComment();
                        zipFile3 = zipFile;
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                                return null;
                            } catch (Exception e3) {
                                e3.printStackTrace();
                                return null;
                            }
                        }
                        return null;
                    }
                } else {
                    str = null;
                }
                if (zipFile3 != null) {
                    try {
                        zipFile3.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                return str;
            } catch (Throwable th) {
                th = th;
                zipFile3 = zipFile2;
                if (zipFile3 != null) {
                    try {
                        zipFile3.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            zipFile = null;
        } catch (Throwable th2) {
            th = th2;
            if (zipFile3 != null) {
            }
            throw th;
        }
    }

    public static byte[] short2Stream(short s) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putShort(s);
        allocate.flip();
        return allocate.array();
    }

    public static short stream2Short(byte[] bArr, int i2) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(bArr[i2]);
        allocate.put(bArr[i2 + 1]);
        return allocate.getShort(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00a6 A[Catch: Exception -> 0x00a2, TryCatch #11 {Exception -> 0x00a2, blocks: (B:53:0x009e, B:57:0x00a6, B:59:0x00ab), top: B:69:0x009e }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ab A[Catch: Exception -> 0x00a2, TRY_LEAVE, TryCatch #11 {Exception -> 0x00a2, blocks: (B:53:0x009e, B:57:0x00a6, B:59:0x00ab), top: B:69:0x009e }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String writeApk(File file, String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        RandomAccessFile randomAccessFile;
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(file);
            try {
                if ((Build.VERSION.SDK_INT >= 19 ? zipFile2.getComment() : "") != null) {
                    try {
                        zipFile2.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    return "bad";
                }
                byte[] bytes = str.getBytes();
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byteArrayOutputStream.write(bytes);
                    byteArrayOutputStream.write(short2Stream((short) bytes.length));
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    try {
                        randomAccessFile.seek(file.length() - 2);
                        randomAccessFile.write(short2Stream((short) byteArray.length));
                        randomAccessFile.write(byteArray);
                        try {
                            zipFile2.close();
                            byteArrayOutputStream.close();
                            randomAccessFile.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        return FrsActivityConfig.GOOD;
                    } catch (IOException e4) {
                        e = e4;
                        zipFile = zipFile2;
                        try {
                            e.printStackTrace();
                            if (zipFile != null) {
                                try {
                                    zipFile.close();
                                } catch (Exception e5) {
                                    e5.printStackTrace();
                                    return "bad";
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                            return "bad";
                        } catch (Throwable th) {
                            th = th;
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
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        zipFile = zipFile2;
                        if (zipFile != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        if (randomAccessFile != null) {
                        }
                        throw th;
                    }
                } catch (IOException e7) {
                    e = e7;
                    randomAccessFile = null;
                } catch (Throwable th3) {
                    th = th3;
                    randomAccessFile = null;
                }
            } catch (IOException e8) {
                e = e8;
                byteArrayOutputStream = null;
                randomAccessFile = null;
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
                randomAccessFile = null;
            }
        } catch (IOException e9) {
            e = e9;
            byteArrayOutputStream = null;
            randomAccessFile = null;
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
            randomAccessFile = null;
        }
    }
}
