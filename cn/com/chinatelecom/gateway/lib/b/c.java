package cn.com.chinatelecom.gateway.lib.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x0042 */
    /* JADX DEBUG: Multi-variable search result rejected for r5v14, resolved type: java.io.InputStreamReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v6, resolved type: java.io.InputStreamReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v7, resolved type: java.io.InputStreamReader */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        Throwable th;
        InputStreamReader inputStreamReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            File c2 = c(context);
            StringBuilder sb = new StringBuilder();
            if (c2 == null || !c2.exists()) {
                return "";
            }
            try {
                fileInputStream = new FileInputStream(c2);
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream);
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine != null) {
                                    sb.append(readLine);
                                } else {
                                    try {
                                        break;
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    th.printStackTrace();
                                } finally {
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (Exception e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                    if (inputStreamReader != 0) {
                                        try {
                                            inputStreamReader.close();
                                        } catch (Exception e4) {
                                            e4.printStackTrace();
                                        }
                                    }
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (Exception e5) {
                                            e5.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                        bufferedReader.close();
                        try {
                            inputStreamReader.close();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    } catch (Throwable th3) {
                        bufferedReader = null;
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = null;
                    th = th;
                    inputStreamReader = bufferedReader;
                    th.printStackTrace();
                }
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
                bufferedReader = null;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, str) == null) {
            File c2 = c(context);
            if (c2 == null || !c2.exists()) {
                a(b(context), str);
            } else {
                a(c2, str);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x005c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(File file, String str) {
        FileWriter fileWriter;
        Exception e2;
        Throwable th;
        BufferedWriter bufferedWriter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, file, str) == null) && file != null && file.exists()) {
            BufferedWriter bufferedWriter2 = null;
            try {
                fileWriter = new FileWriter(file, false);
            } catch (Exception e3) {
                e2 = e3;
                fileWriter = null;
            } catch (Throwable th2) {
                th = th2;
                fileWriter = null;
            }
            try {
                bufferedWriter = new BufferedWriter(fileWriter);
            } catch (Exception e4) {
                e2 = e4;
            } catch (Throwable th3) {
                th = th3;
                if (bufferedWriter2 != null) {
                }
                if (fileWriter != null) {
                }
                throw th;
            }
            try {
                try {
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                    bufferedWriter.write(str);
                    bufferedWriter.flush();
                    try {
                        bufferedWriter.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                } catch (Exception e6) {
                    e2 = e6;
                    bufferedWriter2 = bufferedWriter;
                    try {
                        e2.printStackTrace();
                        if (bufferedWriter2 != null) {
                            try {
                                bufferedWriter2.close();
                            } catch (Exception e7) {
                                e7.printStackTrace();
                            }
                        }
                        if (fileWriter == null) {
                            return;
                        }
                        fileWriter.close();
                    } catch (Throwable th4) {
                        th = th4;
                        th = th;
                        if (bufferedWriter2 != null) {
                            try {
                                bufferedWriter2.close();
                            } catch (Exception e8) {
                                e8.printStackTrace();
                            }
                        }
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (Exception e9) {
                                e9.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    bufferedWriter2 = bufferedWriter;
                    th = th;
                    if (bufferedWriter2 != null) {
                    }
                    if (fileWriter != null) {
                    }
                    throw th;
                }
                fileWriter.close();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public static File b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (context != null) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(context.getFilesDir());
                    sb.append("/eAccount/Log/");
                    File file = new File(sb.toString());
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    File file2 = new File(file, "ipa_ol.ds");
                    if (file2.exists()) {
                        file2.delete();
                    }
                    file2.createNewFile();
                    return file2;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    public static File c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (context != null) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(context.getFilesDir());
                    sb.append("/eAccount/Log/");
                    File file = new File(sb.toString());
                    if (file.exists()) {
                        File file2 = new File(file, "ipa_ol.ds");
                        if (file2.exists()) {
                            return file2;
                        }
                        return null;
                    }
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }
        return (File) invokeL.objValue;
    }
}
