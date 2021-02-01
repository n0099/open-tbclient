package com.baidu.android.util.io;

import android.os.Build;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.yy.mediaframework.stat.VideoDataStatistic;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.ZipFile;
@Deprecated
/* loaded from: classes5.dex */
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [130=4, 131=4, 133=4, 134=4, 136=4, 137=4, 139=4, 140=4] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a8 A[Catch: Exception -> 0x00b1, TryCatch #11 {Exception -> 0x00b1, blocks: (B:45:0x00a3, B:47:0x00a8, B:49:0x00ad), top: B:74:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ad A[Catch: Exception -> 0x00b1, TRY_LEAVE, TryCatch #11 {Exception -> 0x00b1, blocks: (B:45:0x00a3, B:47:0x00a8, B:49:0x00ad), top: B:74:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String writeApk(File file, String str) {
        RandomAccessFile randomAccessFile;
        ByteArrayOutputStream byteArrayOutputStream;
        ZipFile zipFile;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        RandomAccessFile randomAccessFile2 = null;
        try {
            zipFile = new ZipFile(file);
            try {
                if ((Build.VERSION.SDK_INT >= 19 ? zipFile.getComment() : "") != null) {
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                            return "bad";
                        }
                    }
                    if (0 != 0) {
                        byteArrayOutputStream2.close();
                    }
                    if (0 != 0) {
                        randomAccessFile2.close();
                        return "bad";
                    }
                    return "bad";
                }
                byte[] bytes = str.getBytes();
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byteArrayOutputStream.write(bytes);
                    byteArrayOutputStream.write(short2Stream((short) bytes.length));
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    randomAccessFile = new RandomAccessFile(file, VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
                    try {
                        try {
                            randomAccessFile.seek(file.length() - 2);
                            randomAccessFile.write(short2Stream((short) byteArray.length));
                            randomAccessFile.write(byteArray);
                            if (zipFile != null) {
                                try {
                                    zipFile.close();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
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
                        } catch (IOException e3) {
                            e = e3;
                            e.printStackTrace();
                            if (zipFile != null) {
                                try {
                                    zipFile.close();
                                } catch (Exception e4) {
                                    e4.printStackTrace();
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
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (Exception e5) {
                                e5.printStackTrace();
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
                } catch (IOException e6) {
                    e = e6;
                    randomAccessFile = null;
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile = null;
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
                byteArrayOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                byteArrayOutputStream = null;
            }
        } catch (IOException e8) {
            e = e8;
            randomAccessFile = null;
            byteArrayOutputStream = null;
            zipFile = null;
        } catch (Throwable th4) {
            th = th4;
            randomAccessFile = null;
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
