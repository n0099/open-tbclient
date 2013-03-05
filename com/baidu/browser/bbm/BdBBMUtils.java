package com.baidu.browser.bbm;

import com.baidu.browser.core.util.BdLog;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.browser.webpool.BdWebPoolView;
import com.baidu.zeus.NotificationProxy;
import com.baidu.zeus.PlumCore;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.zip.Deflater;
/* loaded from: classes.dex */
public final class BdBBMUtils {
    private BdBBMUtils() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [64=5, 65=5, 54=5, 56=5, 57=5, 58=5, 61=5, 63=5] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String readLineFromFile(File file) {
        BufferedReader bufferedReader;
        FileReader fileReader;
        Throwable th;
        String str = null;
        try {
            try {
                fileReader = new FileReader(file);
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                bufferedReader = new BufferedReader(fileReader);
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                    } else {
                        str = Pattern.compile("\\s*|\t|\r|\n").matcher(readLine).replaceAll("");
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                    }
                } catch (IOException e5) {
                    e = e5;
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e9) {
                            e9.printStackTrace();
                        }
                    }
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                    return str;
                }
            } catch (IOException e11) {
                e = e11;
                bufferedReader = null;
            } catch (Exception e12) {
                e = e12;
                bufferedReader = null;
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e13) {
                        e13.printStackTrace();
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e14) {
                        e14.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e15) {
            e = e15;
            bufferedReader = null;
            fileReader = null;
        } catch (Exception e16) {
            e = e16;
            bufferedReader = null;
            fileReader = null;
        } catch (Throwable th4) {
            bufferedReader = null;
            fileReader = null;
            th = th4;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean saveString2File(File file, String str) {
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(str);
            bufferedWriter.flush();
            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (SecurityException e2) {
            e2.printStackTrace();
            return false;
        } catch (Exception e3) {
            e3.printStackTrace();
            return false;
        }
    }

    static byte[] longTypeToBytes(long j) {
        byte[] bArr = {(byte) (255 & j), (byte) ((65280 & j) >> 8)};
        if (bArr[0] < 0) {
            bArr[0] = (byte) (bArr[0] + BdWebPoolView.PAGE_MAGNITUDE_UNDEFINE);
        }
        if (bArr[1] < 0) {
            bArr[1] = (byte) (bArr[1] + BdWebPoolView.PAGE_MAGNITUDE_UNDEFINE);
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] intToBytes(int i) {
        return new byte[]{(byte) i, (byte) (i >> 8), (byte) (i >> 16), (byte) (i >> 24)};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] shortToBytes(short s) {
        byte[] bArr = {(byte) s, (byte) (s >> 8)};
        if (bArr[0] < 0) {
            bArr[0] = (byte) (bArr[0] + BdWebPoolView.PAGE_MAGNITUDE_UNDEFINE);
        }
        if (bArr[1] < 0) {
            bArr[1] = (byte) (bArr[1] + BdWebPoolView.PAGE_MAGNITUDE_UNDEFINE);
        }
        return bArr;
    }

    static final void writeShortTypeInfoCommon(short s, String str, ByteArrayOutputStream byteArrayOutputStream) {
        if (str == null) {
            str = "";
        }
        try {
            byteArrayOutputStream.write(shortToBytes(s));
            byte[] bytes = str.getBytes(BdUtil.UTF8);
            byteArrayOutputStream.write(intToBytes(bytes.length));
            byteArrayOutputStream.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static final byte[] seal(byte[] bArr) {
        int length = bArr.length;
        try {
            Deflater deflater = new Deflater();
            deflater.setStrategy(0);
            deflater.setInput(bArr);
            deflater.finish();
            byte[] bArr2 = null;
            System.gc();
            byte[] bArr3 = new byte[NotificationProxy.MAX_URL_LENGTH];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(length & 255);
            byteArrayOutputStream.write((length >> 8) & 255);
            byteArrayOutputStream.write((length >> 16) & 255);
            byteArrayOutputStream.write((length >> 24) & 255);
            while (!deflater.finished()) {
                byteArrayOutputStream.write(bArr3, 0, deflater.deflate(bArr3));
            }
            deflater.end();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception e) {
            return null;
        }
    }

    static final byte[] EncodeUserInfo(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            int length = bArr.length;
            byteArrayOutputStream.write(length & 255);
            byteArrayOutputStream.write((length >> 8) & 255);
            byteArrayOutputStream.write((length >> 16) & 255);
            byteArrayOutputStream.write((length >> 24) & 255);
            for (int i = 1; i <= 28; i++) {
                byteArrayOutputStream.write(0);
            }
            byteArrayOutputStream.write(bArr);
            int PlRsaGetBufferNeed = (PlumCore.PlRsaGetBufferNeed(length) - length) - 32;
            for (int i2 = 0; i2 < PlRsaGetBufferNeed; i2++) {
                byteArrayOutputStream.write(0);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (byteArray != null) {
                PlumCore.PlRsaEncoder(byteArray);
                return byteArray;
            }
            return byteArray;
        } catch (Exception e) {
            return null;
        } catch (UnsatisfiedLinkError e2) {
            BdLog.e("callLibrary's method error.", e2);
            return null;
        }
    }
}
