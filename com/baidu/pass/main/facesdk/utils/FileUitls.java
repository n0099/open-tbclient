package com.baidu.pass.main.facesdk.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class FileUitls {
    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException: Cannot read field "wordsInUse" because "set" is null
        	at java.base/java.util.BitSet.or(BitSet.java:943)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:732)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:811)
        	at jadx.core.dex.visitors.regions.IfMakerHelper.restructureIf(IfMakerHelper.java:88)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:706)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public static boolean assetOpen(android.content.Context r2, java.lang.String r3) {
        /*
            r0 = 0
            if (r2 == 0) goto L12
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            if (r1 == 0) goto La
            goto L12
        La:
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch: java.lang.Exception -> L12
            r2.open(r3)     // Catch: java.lang.Exception -> L12
            r0 = 1
        L12:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.pass.main.facesdk.utils.FileUitls.assetOpen(android.content.Context, java.lang.String):boolean");
    }

    public static void deleteLicense(Context context, String str) {
        File file = new File(context.getFilesDir().getParent() + "/" + str);
        if (file.exists()) {
            file.delete();
        }
        File dir = context.getDir(str, 0);
        if (dir == null || !dir.exists()) {
            return;
        }
        dir.delete();
    }

    public static boolean fileIsExists(String str) {
        try {
            if (new File(str).exists()) {
                return true;
            }
            Log.i("wtf", "file_state->file not exits");
            return false;
        } catch (Exception e2) {
            Log.i("wtf", "file_state->" + e2.getMessage());
            return false;
        }
    }

    public static File getBatchFaceDirectory(String str) {
        File sDRootFile = getSDRootFile();
        if (sDRootFile == null || !sDRootFile.exists()) {
            return null;
        }
        File file = new File(sDRootFile, str);
        if (file.exists()) {
            return file;
        }
        file.mkdirs();
        return file;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:13:0x001e */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0034 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap getBitmap(Context context, String str) {
        InputStream inputStream;
        ?? r0 = 0;
        try {
            try {
                inputStream = context.getResources().getAssets().open(str);
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    return decodeStream;
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                r0 = context;
                if (r0 != 0) {
                    try {
                        r0.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (r0 != 0) {
            }
            throw th;
        }
    }

    public static byte[] getByteArrayFromAssets(Context context, String str) {
        byte[] bArr = null;
        try {
            InputStream open = context.getAssets().open(str);
            bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            return bArr;
        } catch (IOException e2) {
            Log.e("zq", "e-->" + e2.getMessage());
            e2.printStackTrace();
            return bArr;
        }
    }

    public static File getFaceDirectory() {
        File sDRootFile = getSDRootFile();
        if (sDRootFile == null || !sDRootFile.exists()) {
            return null;
        }
        File file = new File(sDRootFile, "faces");
        if (file.exists()) {
            return file;
        }
        file.mkdirs();
        return file;
    }

    /* JADX DEBUG: Null dom frontier in handler: FileNotFoundException -> 0x0038 */
    /* JADX DEBUG: Null dom frontier in handler: IOException -> 0x0020 */
    /* JADX DEBUG: Null dom frontier in handler: IOException -> 0x002f */
    /* JADX DEBUG: Null dom frontier in handler: IOException -> 0x0030 */
    /* JADX DEBUG: Null dom frontier in handler: IOException -> 0x0063 */
    /* JADX DEBUG: Null dom frontier in handler: IOException -> 0x0069 */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
        if (r3 == null) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:
        if (r3 == null) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
        if (r3 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0056, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0060, code lost:
        if (r3 == null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0063, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] getModelContent(Context context, String str) {
        byte[] bArr = new byte[0];
        File file = new File(str);
        FileInputStream fileInputStream = null;
        if (file.exists()) {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    bArr = new byte[fileInputStream2.available()];
                    fileInputStream2.read(bArr);
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused) {
                    }
                    fileInputStream = fileInputStream2;
                } catch (FileNotFoundException unused2) {
                    fileInputStream = fileInputStream2;
                } catch (IOException unused3) {
                    fileInputStream = fileInputStream2;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused5) {
            } catch (IOException unused6) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
        try {
            if (bArr.length > 0) {
                return bArr;
            }
            try {
                fileInputStream = context.getResources().getAssets().open(str);
                bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } catch (Throwable th3) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException unused7) {
                }
            }
            throw th3;
        }
    }

    public static String getSDPath() {
        File externalStorageDirectory = Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory() : null;
        if (externalStorageDirectory != null) {
            return externalStorageDirectory.toString();
        }
        return null;
    }

    public static File getSDRootFile() {
        if (isSdCardAvailable()) {
            return Environment.getExternalStorageDirectory();
        }
        return null;
    }

    public static boolean isSdCardAvailable() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static String readFile(String str) {
        File file = new File(str);
        String str2 = "";
        if (file.isDirectory()) {
            Log.d("TestFile", "The File doesn't not exist.");
        } else {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    str2 = readLine;
                }
                fileInputStream.close();
            } catch (FileNotFoundException unused) {
                Log.d("TestFile", "The File doesn't not exist.");
            } catch (IOException e2) {
                Log.d("TestFile", e2.getMessage());
            }
        }
        return str2;
    }

    public static ArrayList<String> readLicense(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        File file = new File(str);
        if (file.isDirectory()) {
            Log.d("TestFile", "The File doesn't not exist.");
        } else {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    arrayList.add(readLine);
                }
                fileInputStream.close();
            } catch (FileNotFoundException unused) {
                Log.d("TestFile", "The File doesn't not exist.");
            } catch (IOException e2) {
                Log.d("TestFile", e2.getMessage());
            }
        }
        return arrayList;
    }

    public static boolean saveFile(File file, Bitmap bitmap) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            try {
                fileOutputStream.close();
                return true;
            } catch (Exception e3) {
                e3.printStackTrace();
                return true;
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                    return false;
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return false;
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }
}
