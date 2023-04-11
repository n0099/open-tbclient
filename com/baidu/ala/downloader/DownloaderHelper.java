package com.baidu.ala.downloader;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.AlaSharedPrefHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ji;
import com.baidu.tieba.pi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.i1;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes.dex */
public class DownloaderHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DownloaderHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean checkDirFiles(String str, ArrayList<String> arrayList) {
        InterceptResult invokeLL;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, arrayList)) == null) {
            if (!existFile(str)) {
                return true;
            }
            if (!isDirectory(str)) {
                FileHelper.deleteFileOrDir(new File(str));
                return true;
            } else if (arrayList == null || arrayList.size() <= 0 || (listFiles = new File(str).listFiles()) == null || listFiles.length == 0) {
                return true;
            } else {
                for (int i = 0; i < listFiles.length; i++) {
                    if (!listFiles[i].isDirectory() && !arrayList.contains(getFileMd5(listFiles[i]))) {
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static void saveAllFileMd5ToSharePreference(String str, String str2) {
        File[] listFiles;
        String fileMd5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65543, null, str, str2) != null) || StringUtils.isNull(str2) || (listFiles = new File(str2).listFiles()) == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (File file : listFiles) {
            if (file != null && !file.isDirectory() && (fileMd5 = getFileMd5(file)) != null) {
                jSONArray.put(fileMd5);
            }
        }
        AlaSharedPrefHelper.getInstance().putString(str, jSONArray.toString());
    }

    public static void cleanDir(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, file) == null) {
            try {
                if (file.exists() && file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    int length = listFiles.length;
                    for (int i = 0; i < length; i++) {
                        if (listFiles[i].isFile()) {
                            listFiles[i].delete();
                        } else {
                            cleanDir(listFiles[i]);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static boolean existFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                return new File(str).exists();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String getFileMd5(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, file)) == null) {
            String b = pi.b(FileHelper.GetStreamFromFile(file));
            if (!StringUtils.isNull(b)) {
                return b.toLowerCase();
            }
            return b;
        }
        return (String) invokeL.objValue;
    }

    public static boolean isDirectory(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                return new File(str).isDirectory();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static ArrayList<String> getAllFileMd5Set(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            ArrayList<String> arrayList = null;
            String string = AlaSharedPrefHelper.getInstance().getString(str, null);
            if (string == null) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(string);
                ArrayList<String> arrayList2 = new ArrayList<>();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        String str2 = (String) jSONArray.opt(i);
                        if (str2 != null) {
                            arrayList2.add(str2);
                        }
                    } catch (JSONException e) {
                        e = e;
                        arrayList = arrayList2;
                        e.printStackTrace();
                        return arrayList;
                    }
                }
                return arrayList2;
            } catch (JSONException e2) {
                e = e2;
            }
        } else {
            return (ArrayList) invokeL.objValue;
        }
    }

    public static String saveFile(String str, String str2, InputStream inputStream) {
        InterceptResult invokeLLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, str, str2, inputStream)) == null) {
            OutputStream outputStream = null;
            if (inputStream == null || StringUtils.isNull(str2) || str2.contains(i1.j)) {
                return null;
            }
            try {
                String[] split = str2.split("/");
                if (split.length > 1) {
                    str2 = split[split.length - 1];
                } else {
                    str2 = split[0];
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!existFile(str)) {
                new File(str).mkdirs();
            }
            File file = new File(str + "/" + str2);
            String parent = file.getParent();
            boolean isNull = StringUtils.isNull(parent);
            String str3 = parent;
            if (!isNull) {
                File file2 = new File(parent);
                boolean exists = file2.exists();
                str3 = exists;
                if (!exists) {
                    file2.mkdirs();
                    str3 = exists;
                }
            }
            try {
                try {
                    if (file.exists() && !file.delete()) {
                        ji.f(null);
                        return null;
                    } else if (!file.createNewFile()) {
                        ji.f(null);
                        return null;
                    } else {
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read != -1) {
                                    fileOutputStream.write(bArr, 0, read);
                                } else {
                                    fileOutputStream.flush();
                                    String path = file.getPath();
                                    ji.f(fileOutputStream);
                                    return path;
                                }
                            }
                        } catch (IOException e2) {
                            e = e2;
                            BdLog.e(e.getMessage());
                            TiebaStatic.file(e, "FileHelper.saveFile " + str + "/" + str2);
                            ji.f(fileOutputStream);
                            return null;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    outputStream = str3;
                    ji.f(outputStream);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                ji.f(outputStream);
                throw th;
            }
        } else {
            return (String) invokeLLL.objValue;
        }
    }

    public static boolean unZipFile(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, str2)) == null) {
            ZipInputStream zipInputStream = null;
            try {
                try {
                    ZipInputStream zipInputStream2 = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
                    while (true) {
                        try {
                            ZipEntry nextEntry = zipInputStream2.getNextEntry();
                            if (nextEntry != null) {
                                if (!nextEntry.isDirectory()) {
                                    saveFile(str2, nextEntry.getName(), zipInputStream2);
                                }
                            } else {
                                zipInputStream2.close();
                                FileHelper.deleteFile(new File(str));
                                ji.e(zipInputStream2);
                                return true;
                            }
                        } catch (FileNotFoundException e) {
                            e = e;
                            zipInputStream = zipInputStream2;
                            e.printStackTrace();
                            ji.e(zipInputStream);
                            return false;
                        } catch (IOException e2) {
                            e = e2;
                            zipInputStream = zipInputStream2;
                            e.printStackTrace();
                            ji.e(zipInputStream);
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            zipInputStream = zipInputStream2;
                            ji.e(zipInputStream);
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (FileNotFoundException e3) {
                e = e3;
            } catch (IOException e4) {
                e = e4;
            }
        } else {
            return invokeLL.booleanValue;
        }
    }
}
