package com.baidu.android.pushservice.l;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static InputStream a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    return new FileInputStream(file);
                }
            } catch (Exception unused) {
            }
            return null;
        }
        return (InputStream) invokeLL.objValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? "jir+1ZLxLfyJruezRaR4wLCgEojRyGYh54krWLP2sWFrL0CrXtTfFgrcUSBeIbKroOI6bdY1dorK1LyQ7Din+l7MA2dlXZBDEqjTXbgzO8FvHjgeyFO1Bx8RQJ6a05Y8LLxM7LueE/X6S/7V6PWMf46udarwOBUQTJZtGRf7/ELeXgHgcnwc7i4puIZgGhQ1kTnZX/LRxYTcx3E4E0bPHwj4eK6IbznWO7LHwavWRzO8g8PKZs1Wye8ptPsGHx4SfctylDzUX7pZ4G3px29medW1m/HegWpMnwHJZI9b7ngr87ketcut+W5+9nzEMYNIjfFfXquurEvQqHJrgX0AdVhRjp8eXJtIC6A0Nd/kl1OvSlzpjFGQcQOT2AVlKYo3Rver4c9RbqiWIx+QErllz1JiNAzTsWXmI1vFt9i0XyZh1fl1+3C5IJUAmEpUftADLPv5VurFOlTOgtBbKqcjVAcEa3zQbZNhSYJyS7iZZ5LK/nkeI13lw13lr5hWah8KAcrgxT/lEnMUACIx1zB8jRMCGtShQ+MzCqimguW8Kw6n6z4qg8Iwp58o1VVkA7v2AiVC8dR4RB3aG5YoCMrnEh7O9gMx7vLJqjrud73Vr94vzsJtzgQcUCXGFLQyJZAQbd/fT2gFR+2dXiJ97fc4QW0HbwuR046t4cFfCeKhSnwQOkTTo2tFgmvKVBGJudBdlIATXvHJLJ9V4+c6373A2ycNyPLXdxiXBITzda+/nuegotGpG6CdupRiIKvGNaHmD6sCfkkruqY3paBePH9IJt23MyoRR+wofH9iKTusIVJD3FQ/5rCcnLJdMTI0XxSCz1wbWeaYXaGoUL2PYmhqNoJMgjXJm6YIRz6fXPmR9o1LWzaLdi9Mu23YAb1z+KGI8ccCizjDlTLnmD/xfKiz3YJrwC+gOvGZM1vvypVs6RyjIS5r0BfE//j/IfBxldF3adRxK8NgNOJFysv5DUw1qvCdFreDZRZYqns9QBz8E68CQ/6oKQupmy9cdZd+Sjx65iT9qYBdXWdWzGuLPTToSxEr3nd9GLk5g4XmUKJrLLd+tInYPgmIekX8lBRRdr1xkBeb1H2Ks+Gr9RlVXW/PoO7Y7N4biq3hjlueoOPnWi8ZC15XHAwSREJhydxe4MJqz4AvE0aYzImco8HCXBAo9O1ID2fCQD61Z1T3Ao/vT6UNt9SKRBP787bZpmZyZZTYsI1p/aJrGPmFQZpmy72uEKCoURpX3nVVjGpq9Aav2AZ8MyA5vsVnoAVd50WYNgraRxhH7eCa5vCU3Gy4Sw3LXqDO/VIyn9Mtk5mDMp3cBzuGpyzjLWLYLXDE5sWicDeAmyiVopclMh7nmJHkzWftCo2CW9QYo5OCfVnt6bz88zVU7IItOiKIzW5CBGezI/NyBxhBk8r3vRKQ2kYn/pSEUfMHhap1KkFrizWdDtFGpHq9hNbHzR9TDKoP6badv4ApRIUtGjqKFnbwDeZxX8VLkXk5PV8Wj4cb6d0l/OjWk+PCMq+NB0i+Whsp/VhsjRoB7GGcrVwpSpodCmjn47pudqaGLAWtDF4u4LS/nBrd73abO7H0F8TQglv8Tx3KA1oDeTTvbu4l2S4VygKel1uykA==" : (String) invokeV.objValue;
    }

    public static boolean a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Throwable th;
        FileWriter fileWriter;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65538, null, context, str, str2)) != null) {
            return invokeLLL.booleanValue;
        }
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            fileWriter = new FileWriter(str, false);
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter);
                try {
                    bufferedWriter2.write(str2);
                    com.baidu.android.pushservice.q.c.a(context, bufferedWriter2, fileWriter);
                    return true;
                } catch (Exception unused) {
                    bufferedWriter = bufferedWriter2;
                    com.baidu.android.pushservice.q.c.a(context, bufferedWriter, fileWriter);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedWriter = bufferedWriter2;
                    com.baidu.android.pushservice.q.c.a(context, bufferedWriter, fileWriter);
                    throw th;
                }
            } catch (Exception unused2) {
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception unused3) {
            fileWriter = null;
        } catch (Throwable th4) {
            th = th4;
            fileWriter = null;
        }
    }

    public static String b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            InputStream a = a(context, str);
            if (a == null) {
                return a();
            }
            StringBuilder sb = new StringBuilder();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(a, "utf-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    } catch (IOException unused) {
                        com.baidu.android.pushservice.q.c.a(context, bufferedReader);
                    } catch (Throwable th) {
                        com.baidu.android.pushservice.q.c.a(context, bufferedReader);
                        throw th;
                    }
                }
                com.baidu.android.pushservice.q.c.a(context, bufferedReader);
                com.baidu.android.pushservice.q.c.a(context, a);
            } catch (UnsupportedEncodingException unused2) {
                com.baidu.android.pushservice.q.c.a(context, a);
            } catch (Throwable th2) {
                com.baidu.android.pushservice.q.c.a(context, a);
                throw th2;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
