package com.baidu.crabsdk.lite.a;

import android.os.Process;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: java.lang.StringBuilder */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    public static String a(String str) {
        InterceptResult invokeL;
        ?? myPid;
        FileReader fileReader;
        Exception e2;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    try {
                        fileReader = new FileReader("/proc/" + ((int) myPid) + "/stat");
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader2 = Process.myPid();
                    }
                } catch (Exception e3) {
                    fileReader = null;
                    e2 = e3;
                    bufferedReader = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileReader = null;
                }
                try {
                    bufferedReader = new BufferedReader(fileReader, 8192);
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                            sb.append("\n");
                        } catch (Exception e4) {
                            e2 = e4;
                            com.baidu.crabsdk.lite.b.a.e(str, "getMyAppCPUStat fail.", e2);
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                            return sb.toString();
                        }
                    }
                    bufferedReader.close();
                    fileReader.close();
                    bufferedReader.close();
                    fileReader.close();
                } catch (Exception e5) {
                    e2 = e5;
                    bufferedReader = null;
                } catch (Throwable th3) {
                    th = th3;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                            throw th;
                        }
                    }
                    if (fileReader != null) {
                        fileReader.close();
                    }
                    throw th;
                }
            } catch (IOException e7) {
                e7.printStackTrace();
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
