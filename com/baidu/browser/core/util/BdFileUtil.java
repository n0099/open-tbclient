package com.baidu.browser.core.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import com.baidu.zeus.bouncycastle.DERTags;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public class BdFileUtil {
    public static boolean hasSDCard() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    public static String getSDPath() {
        return Environment.getExternalStorageDirectory().getPath();
    }

    public static String getFilesPath(Context context) {
        return context.getFilesDir().getPath();
    }

    public static boolean isFileExist(String str) {
        return new File(String.valueOf(getSDPath()) + "//" + str).exists();
    }

    public static File createSDDir(String str) {
        File file = new File(String.valueOf(getSDPath()) + "//" + str);
        file.mkdir();
        return file;
    }

    public static File createSDFile(String str) {
        File file = new File(String.valueOf(getSDPath()) + "//" + str);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    public static boolean deleteSDFile(String str) {
        File file = new File(String.valueOf(getSDPath()) + "//" + str);
        if (file == null || !file.exists() || file.isDirectory()) {
            return false;
        }
        return file.delete();
    }

    public String readTextFileFromSD(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(String.valueOf(getSDPath()) + "//" + str));
            while (true) {
                int read = fileInputStream.read();
                if (read == -1) {
                    break;
                }
                stringBuffer.append((char) read);
            }
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            BdLog.e("FileNotFoundException");
        } catch (IOException e2) {
            BdLog.e("IOException");
        }
        return stringBuffer.toString();
    }

    public static boolean deleteFile(String str) {
        return new File(str).delete();
    }

    public static Bitmap readBitmapFile(String str) {
        Bitmap bitmap = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            bitmap = BitmapFactory.decodeStream(fileInputStream);
            fileInputStream.close();
            return bitmap;
        } catch (FileNotFoundException e) {
            BdLog.e("FileNotFoundException");
            return bitmap;
        } catch (IOException e2) {
            BdLog.e("IOException");
            return bitmap;
        }
    }

    public static boolean writeStringFileToSD(String str, String str2) {
        try {
            File file = new File(String.valueOf(getSDPath()) + "//" + str);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(str2.getBytes());
            fileOutputStream.close();
            return true;
        } catch (FileNotFoundException e) {
            BdLog.e("FileNotFoundException");
            return false;
        } catch (IOException e2) {
            BdLog.e("IOException");
            return false;
        }
    }

    public static boolean writeJPEGBitmapFileToSD(String str, Bitmap bitmap) {
        if (bitmap == null || str == null) {
            return false;
        }
        try {
            File file = new File(String.valueOf(getSDPath()) + "//" + str);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            byteArrayOutputStream.flush();
            fileOutputStream.flush();
            byteArrayOutputStream.close();
            fileOutputStream.close();
            return true;
        } catch (Exception e) {
            BdLog.e("writeJPEGBitmapFileToSD fail");
            return false;
        }
    }

    public static byte[] readPrivateFile(Context context, String str) {
        byte[] bArr = null;
        try {
            FileInputStream openFileInput = context.openFileInput(str);
            if (openFileInput.available() > 0) {
                byte[] bArr2 = new byte[openFileInput.available()];
                try {
                    openFileInput.read(bArr2);
                    bArr = bArr2;
                } catch (FileNotFoundException e) {
                    bArr = bArr2;
                    e = e;
                    e.printStackTrace();
                    return bArr;
                } catch (IOException e2) {
                    bArr = bArr2;
                    e = e2;
                    e.printStackTrace();
                    return bArr;
                }
            }
            openFileInput.close();
        } catch (FileNotFoundException e3) {
            e = e3;
        } catch (IOException e4) {
            e = e4;
        }
        return bArr;
    }

    public static void writePrivateFile(Context context, byte[] bArr, String str) {
        try {
            FileOutputStream openFileOutput = context.openFileOutput(str, 0);
            openFileOutput.write(bArr);
            openFileOutput.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [262=5, 264=5, 265=5, 266=5] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x0048 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0057 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:49:0x0002 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v14, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    public static int readPrivateFileToInt(String str, String str2) {
        FileInputStream fileInputStream;
        int i = 0;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(String.valueOf(str) + "/" + str2);
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e) {
            fileInputStream = null;
        } catch (IOException e2) {
            e = e2;
        } catch (Exception e3) {
            e = e3;
        }
        try {
            byte[] bArr = new byte[4];
            int read = fileInputStream.read(bArr);
            byte[] bArr2 = new byte[read];
            System.arraycopy(bArr, 0, bArr2, 0, read);
            String str3 = new String(bArr2);
            i = Integer.parseInt(str3);
            fileInputStream2 = str3;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                    fileInputStream2 = str3;
                } catch (IOException e4) {
                    e4.printStackTrace();
                    fileInputStream2 = str3;
                }
            }
        } catch (FileNotFoundException e5) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            return i;
        } catch (IOException e7) {
            fileInputStream2 = fileInputStream;
            e = e7;
            e.printStackTrace();
            fileInputStream2 = fileInputStream2;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                    fileInputStream2 = fileInputStream2;
                } catch (IOException e8) {
                    e8.printStackTrace();
                    fileInputStream2 = fileInputStream2;
                }
            }
            return i;
        } catch (Exception e9) {
            fileInputStream2 = fileInputStream;
            e = e9;
            e.printStackTrace();
            fileInputStream2 = fileInputStream2;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                    fileInputStream2 = fileInputStream2;
                } catch (IOException e10) {
                    e10.printStackTrace();
                    fileInputStream2 = fileInputStream2;
                }
            }
            return i;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
            }
            throw th;
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [289=5, 291=5, 292=5, 293=5] */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0077: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:41:0x0077 */
    /* JADX WARN: Removed duplicated region for block: B:57:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String readPrivateFile(String str, String str2) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileInputStream fileInputStream3;
        FileInputStream fileInputStream4 = null;
        try {
            try {
                fileInputStream = new FileInputStream(String.valueOf(str) + "/" + str2);
                try {
                    byte[] bArr = new byte[DERTags.TAGGED];
                    int read = fileInputStream.read(bArr);
                    byte[] bArr2 = new byte[read];
                    System.arraycopy(bArr, 0, bArr2, 0, read);
                    String str3 = new String(bArr2);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            return str3;
                        } catch (IOException e) {
                            e.printStackTrace();
                            return str3;
                        }
                    }
                    return str3;
                } catch (FileNotFoundException e2) {
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                } catch (IOException e4) {
                    e = e4;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    return null;
                } catch (Exception e6) {
                    e = e6;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream4 = fileInputStream3;
                if (fileInputStream4 != null) {
                    try {
                        fileInputStream4.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e9) {
            fileInputStream2 = null;
        } catch (IOException e10) {
            e = e10;
            fileInputStream = null;
        } catch (Exception e11) {
            e = e11;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (fileInputStream4 != null) {
            }
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [314=4, 316=4, 317=4, 318=4] */
    public static void writePrivateFile(byte[] bArr, String str, String str2) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(String.valueOf(str) + "/" + str2);
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                    } catch (IOException e4) {
                        e = e4;
                        fileOutputStream2 = fileOutputStream;
                        e.printStackTrace();
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e7) {
                e = e7;
                fileOutputStream = null;
            } catch (IOException e8) {
                e = e8;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
        }
    }

    public static boolean copyFile(String str, String str2) {
        boolean z = false;
        try {
            if (!new File(str).exists()) {
                return false;
            }
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            byte[] bArr = new byte[1444];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    fileOutputStream.close();
                    z = true;
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return z;
        }
    }
}
