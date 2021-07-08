package com.baidu.pass.main.facesdk.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public FileUitls() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

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
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public static boolean assetOpen(android.content.Context r4, java.lang.String r5) {
        /*
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.pass.main.facesdk.utils.FileUitls.$ic
            if (r0 != 0) goto L17
        L4:
            r0 = 0
            if (r4 == 0) goto L16
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 == 0) goto Le
            goto L16
        Le:
            android.content.res.AssetManager r4 = r4.getAssets()     // Catch: java.lang.Exception -> L16
            r4.open(r5)     // Catch: java.lang.Exception -> L16
            r0 = 1
        L16:
            return r0
        L17:
            r1 = r0
            r2 = 65537(0x10001, float:9.1837E-41)
            r3 = 0
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r1.invokeLL(r2, r3, r4, r5)
            if (r0 == 0) goto L4
            boolean r1 = r0.booleanValue
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.pass.main.facesdk.utils.FileUitls.assetOpen(android.content.Context, java.lang.String):boolean");
    }

    public static void deleteLicense(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, str) == null) {
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
    }

    public static boolean fileIsExists(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
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
        return invokeL.booleanValue;
    }

    public static File getBatchFaceDirectory(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
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
        return (File) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap getBitmap(Context context, String str) {
        InterceptResult invokeLL;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, str)) != null) {
            return (Bitmap) invokeLL.objValue;
        }
        InputStream inputStream2 = null;
        try {
            inputStream = context.getResources().getAssets().open(str);
            try {
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
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
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
            if (inputStream2 != null) {
            }
            throw th;
        }
    }

    public static byte[] getByteArrayFromAssets(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str)) == null) {
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
        return (byte[]) invokeLL.objValue;
    }

    public static File getFaceDirectory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
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
        return (File) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
        if (r3 == null) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003c, code lost:
        if (r3 == null) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0058, code lost:
        if (r3 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005a, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0064, code lost:
        if (r3 == null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0067, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] getModelContent(Context context, String str) {
        InterceptResult invokeLL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65544, null, context, str)) != null) {
            return (byte[]) invokeLL.objValue;
        }
        byte[] bArr = new byte[0];
        File file = new File(str);
        FileInputStream fileInputStream2 = null;
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (FileNotFoundException unused) {
            } catch (IOException unused2) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                try {
                    fileInputStream.close();
                } catch (IOException unused3) {
                }
                fileInputStream2 = fileInputStream;
            } catch (FileNotFoundException unused4) {
                fileInputStream2 = fileInputStream;
            } catch (IOException unused5) {
                fileInputStream2 = fileInputStream;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused6) {
                    }
                }
                throw th;
            }
        }
        if (bArr.length > 0) {
            return bArr;
        }
        try {
            try {
                fileInputStream2 = context.getResources().getAssets().open(str);
                bArr = new byte[fileInputStream2.available()];
                fileInputStream2.read(bArr);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } catch (Throwable th3) {
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException unused7) {
                }
            }
            throw th3;
        }
    }

    public static String getSDPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            File externalStorageDirectory = Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory() : null;
            if (externalStorageDirectory != null) {
                return externalStorageDirectory.toString();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static File getSDRootFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (isSdCardAvailable()) {
                return Environment.getExternalStorageDirectory();
            }
            return null;
        }
        return (File) invokeV.objValue;
    }

    public static boolean isSdCardAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? Environment.getExternalStorageState().equals("mounted") : invokeV.booleanValue;
    }

    public static String readFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static ArrayList<String> readLicense(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
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
        return (ArrayList) invokeL.objValue;
    }

    public static boolean saveFile(File file, Bitmap bitmap) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, file, bitmap)) == null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                e = e2;
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
        return invokeLL.booleanValue;
    }
}
