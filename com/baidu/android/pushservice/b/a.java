package com.baidu.android.pushservice.b;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? "G/+OcJyTftFli2wqcD/suPV1zFgkQcIfIqUzGhkKDOM3Lskevp1nJYavBVoe8ZQOMn9/qzM/GLGCvIjSQ5cNjEn3sMv4Ic6GIOO/DM7/PIGF/OCo7BHThVw+un/dBwDiqx2QEiOyPljpJf8dFyW6Kxmc6Yq8mtS/fuHjdR3qhR+zJ32YaJxQxMGxU/0WX/lTeIEfe8tcm78vvusWRKQD2O+9XVHx6fiIt3gqK6/Abm38Km0hnydqvoPsHG1vf7H1UMjtB1KKlqwnY2IWmQP8bczdlA+emLg6dQxglyBxXPU0/lx+QY6RklgpQhNGWLjJlzQfGqltBd3T+Dwt0GH3jlJS3iLjY4zNfTHMsg+GgpGPU3jUKW4iD2e/ipeqCK5EsSzDs5x53PyXY4/l6js6gKyHTRmTmJxJPel/dlHdI2/tsBADE3em/yHDpIlSpLt4+J2iyucuUaz0trSdxAGxw02Ys1c27Z8b9W2BO0sW8skWnn0sXn18M7+xDGJW/nf1mTiGg64tbGdPApLXV5Hhod2Y33p58AyhPs6ufXK/CaXKdIuRXn+Ayl7hEc1BdjTESisrtArpYg2vGs6gKHgLE7BVdyz6tEB0FlCXQmOFzo09TRs8g5hqE95G5Sr4gsdcsigFBfxI0KDMCwDpbIPBWhkfks8Ev6l9V8Tby9i/VTFq3NRsSPsD+3toi3pwjKjPxtj9rZQDgsqcBEkARa/gxvKu/be7xhnJrzTmff6wnzxn2IZ3U3w34l0S8EMeZ4bwa8Macv7CgihzfzzFPIwE0VoAOoUSNggPEIQwSZ1iWSmRG87X92fkVoV5nx1IHyoDyK2LWZkgBPilF2L+dnfvd6JEkh4bJe1cpp7dHdQ+N8kBwYeFzEpDa1ir7lqdhriMXSWWL6QOnv2TPh2/nyEh7vNeS+4zhclSoeE+zcCD5IiMOKAsBUZrS9Xs0Xs+3yHeXhBWCk/1PpVdzam732JZxJNHC0Vu5WZpVq6JsMpZSrn+3qi54gXM0hRi8qOcsAQgykA6SdhN4/KCXZbRZ8IzadZGBqI5qnLSZih1tN8WE0wtGT4iB2d8cq2BYHmZmjmhDYe+gJvaW4vLaJGBmGJgErwPlQmsZLp1XcFx5eeKn7xfUFhRu77lPq9aSQQMHUWzLjVUefF5smXexXutQP7jXzbwV/IA8ycHPS3VQeuTydMEjrwVE4dm3dpWlao/70w+gUi2jcAQI0i07ZAT99CtkclKLtC9xeqdVbcI4PL+oCXJZHVcZss4hR4G2ZA2Xk1cEHN2MYbsFI4mZ+vkuSHLTOUaDwFhVAs1rGWtkJMkN7Kz+4T6Y8psHY++//FIHQTswc7x9tFUYNe+ZakAgGI682aojgiqJub9vrm8J2pQ5HlfGGwn/39uE5R3uwCLEMmaG+dzkMLSfV2IKCvv4ssx4DGz9MVv9OM+2/2KTs6RpRu60MyQFghiWbnw8nJYObZkRZlLFjlFAYz3XX/MBeTn+VBDyMJIt1oI7cdZ0R5sv4Y=" : (String) invokeV.objValue;
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            InputStream b2 = b(context, str);
            if (b2 == null) {
                return a();
            }
            StringBuilder sb = new StringBuilder();
            try {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(b2, "utf-8"));
                    while (true) {
                        try {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                            } catch (IOException e2) {
                                new b.c(context).a(Log.getStackTraceString(e2)).a();
                                com.baidu.android.pushservice.e.c.a(context, bufferedReader);
                            }
                        } catch (Throwable th) {
                            com.baidu.android.pushservice.e.c.a(context, bufferedReader);
                            throw th;
                        }
                    }
                    com.baidu.android.pushservice.e.c.a(context, bufferedReader);
                    com.baidu.android.pushservice.e.c.a(context, b2);
                } catch (UnsupportedEncodingException e3) {
                    new b.c(context).a(Log.getStackTraceString(e3)).a();
                    com.baidu.android.pushservice.e.c.a(context, b2);
                }
                return sb.toString();
            } catch (Throwable th2) {
                com.baidu.android.pushservice.e.c.a(context, b2);
                throw th2;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65538, null, context, str, str2)) != null) {
            return invokeLLL.booleanValue;
        }
        BufferedWriter bufferedWriter2 = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            fileWriter = new FileWriter(str, false);
            try {
                try {
                    bufferedWriter = new BufferedWriter(fileWriter);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                bufferedWriter.write(str2);
                com.baidu.android.pushservice.e.c.a(context, bufferedWriter, fileWriter);
                return true;
            } catch (Exception e3) {
                bufferedWriter2 = bufferedWriter;
                e = e3;
                new b.c(context).a(Log.getStackTraceString(e)).a();
                com.baidu.android.pushservice.e.c.a(context, bufferedWriter2, fileWriter);
                return false;
            } catch (Throwable th2) {
                bufferedWriter2 = bufferedWriter;
                th = th2;
                com.baidu.android.pushservice.e.c.a(context, bufferedWriter2, fileWriter);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            fileWriter = null;
        } catch (Throwable th3) {
            th = th3;
            fileWriter = null;
        }
    }

    public static InputStream b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    return new FileInputStream(file);
                }
                return null;
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
                return null;
            }
        }
        return (InputStream) invokeLL.objValue;
    }
}
