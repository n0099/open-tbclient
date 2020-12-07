package com.baidu.android.util.io;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.baidu.android.imsdk.retrieve.Constants;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes6.dex */
public final class AssetUtils {
    private static final boolean DEBUG = false;
    private static final String TAG = "AssetUtils";

    private AssetUtils() {
    }

    public static boolean exists(Context context, String str) {
        boolean z = false;
        if (context != null && !TextUtils.isEmpty(str)) {
            InputStream inputStream = null;
            try {
                InputStream open = context.getAssets().open(str, 0);
                z = true;
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e2) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return z;
    }

    public static boolean extractFolderFromAsset(AssetManager assetManager, String str, String str2) {
        String[] list;
        boolean z = false;
        try {
            for (String str3 : assetManager.list(str)) {
                if (!TextUtils.isEmpty(str3)) {
                    String str4 = str + File.separator + str3;
                    String[] list2 = assetManager.list(str4);
                    if (list2 == null || list2.length == 0) {
                        z = extractFileFromAsset(assetManager, str4, str2 + File.separator + str3);
                    } else {
                        z = extractFolderFromAsset(assetManager, str4, str2 + File.separator + str3);
                    }
                    if (!z) {
                        break;
                    }
                }
            }
        } catch (IOException e) {
        }
        return z;
    }

    public static boolean extractFileFromAsset(AssetManager assetManager, String str, String str2) {
        boolean z = false;
        try {
            z = StreamUtils.streamToFile(assetManager.open(str, 0), new File(str2));
            if (!z) {
                new File(str2).delete();
            }
        } catch (IOException e) {
        }
        return z;
    }

    @Deprecated
    public static String loadAssetsFile(Context context, String str) {
        return loadFile(context, str);
    }

    public static String loadFile(Context context, String str) {
        InputStream inputStream;
        Throwable th;
        String str2 = null;
        try {
            inputStream = context.getAssets().open(str);
            if (inputStream != null) {
                try {
                    str2 = StreamUtils.streamToString(inputStream);
                    Closeables.closeSafely(inputStream);
                } catch (IOException e) {
                    Closeables.closeSafely(inputStream);
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    Closeables.closeSafely(inputStream);
                    throw th;
                }
            } else {
                Closeables.closeSafely(inputStream);
            }
        } catch (IOException e2) {
            inputStream = null;
        } catch (Throwable th3) {
            inputStream = null;
            th = th3;
        }
        return str2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [251=4] */
    public static boolean unzipFileFromAsset(String str, String str2, Context context) {
        ZipInputStream zipInputStream;
        InputStream inputStream;
        InputStream inputStream2;
        BufferedOutputStream bufferedOutputStream;
        ZipInputStream zipInputStream2 = null;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            inputStream = context.getApplicationContext().getAssets().open(str);
            try {
                zipInputStream = new ZipInputStream(inputStream);
            } catch (IOException e) {
                inputStream2 = inputStream;
            } catch (Throwable th) {
                th = th;
                zipInputStream = null;
            }
            try {
                byte[] bArr = new byte[1024];
                BufferedOutputStream bufferedOutputStream2 = null;
                while (true) {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        Closeables.closeSafely(inputStream);
                        Closeables.closeSafely(zipInputStream);
                        return true;
                    } else if (!nextEntry.getName().contains(Constants.PATH_PARENT)) {
                        File file2 = new File(str2 + File.separator + nextEntry.getName());
                        if (nextEntry.isDirectory()) {
                            if (!file2.exists()) {
                                file2.mkdir();
                            }
                        } else if (file2.exists()) {
                            continue;
                        } else {
                            FileUtils.createFileSafely(file2);
                            try {
                                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2), 2048);
                                while (true) {
                                    try {
                                        int read = zipInputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        bufferedOutputStream.write(bArr, 0, read);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        Closeables.closeSafely(bufferedOutputStream);
                                        throw th;
                                    }
                                }
                                Closeables.closeSafely(bufferedOutputStream);
                                bufferedOutputStream2 = bufferedOutputStream;
                            } catch (Throwable th3) {
                                th = th3;
                                bufferedOutputStream = bufferedOutputStream2;
                            }
                        }
                    }
                }
            } catch (IOException e2) {
                zipInputStream2 = zipInputStream;
                inputStream2 = inputStream;
                Closeables.closeSafely(inputStream2);
                Closeables.closeSafely(zipInputStream2);
                return false;
            } catch (Throwable th4) {
                th = th4;
                Closeables.closeSafely(inputStream);
                Closeables.closeSafely(zipInputStream);
                throw th;
            }
        } catch (IOException e3) {
            inputStream2 = null;
        } catch (Throwable th5) {
            th = th5;
            zipInputStream = null;
            inputStream = null;
        }
    }

    public static String readAsset(Context context, String str) {
        InputStream inputStream;
        Throwable th;
        String str2 = null;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                inputStream = context.getAssets().open(str);
            } catch (IOException e) {
                inputStream = null;
            } catch (Throwable th2) {
                inputStream = null;
                th = th2;
            }
            try {
                str2 = FileUtils.readInputStream(inputStream);
                Closeables.closeSafely(inputStream);
            } catch (IOException e2) {
                Closeables.closeSafely(inputStream);
                return str2;
            } catch (Throwable th3) {
                th = th3;
                Closeables.closeSafely(inputStream);
                throw th;
            }
        }
        return str2;
    }
}
