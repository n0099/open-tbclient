package com.baidu.ar.statistic;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes6.dex */
public class d extends ArrayList<a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean sM;
    public int wA;
    public int wB;
    public WeakReference<Context> wn;
    public String wz;

    public d(Context context, String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.wn = new WeakReference<>(context);
        this.sM = false;
        this.wA = i2;
        this.wz = str;
        this.wB = i3;
    }

    private void a(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }

    private void gm() {
        Context context;
        Closeable closeable;
        Throwable th;
        FileInputStream fileInputStream;
        Exception e2;
        a aG;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || this.wB <= 0 || (context = this.wn.get()) == null || !context.getFileStreamPath(this.wz).exists()) {
            return;
        }
        try {
            fileInputStream = context.openFileInput(this.wz);
        } catch (Exception e3) {
            closeable = null;
            e2 = e3;
            fileInputStream = null;
        } catch (Throwable th2) {
            closeable = null;
            th = th2;
            fileInputStream = null;
        }
        try {
            closeable = new Scanner(fileInputStream, "utf-8");
            while (closeable.hasNextLine()) {
                try {
                    try {
                        String nextLine = closeable.nextLine();
                        if (nextLine != null && !nextLine.isEmpty() && (aG = a.aG(nextLine)) != null) {
                            add(aG);
                        }
                    } catch (Exception e4) {
                        e2 = e4;
                        e2.printStackTrace();
                        a(fileInputStream);
                        a(closeable);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    a(fileInputStream);
                    a(closeable);
                    throw th;
                }
            }
        } catch (Exception e5) {
            closeable = null;
            e2 = e5;
        } catch (Throwable th4) {
            closeable = null;
            th = th4;
            a(fileInputStream);
            a(closeable);
            throw th;
        }
        a(fileInputStream);
        a(closeable);
    }

    public void S(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || i2 <= 0) {
            return;
        }
        a[] aVarArr = new a[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            aVarArr[i3] = get(i3);
        }
        removeRange(0, i2);
        a.a(aVarArr);
    }

    public void flush() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.wB <= 0 || (context = this.wn.get()) == null) {
            return;
        }
        int size = size();
        FileOutputStream fileOutputStream = null;
        try {
            try {
                fileOutputStream = context.openFileOutput(this.wz, 0);
                if (size > 0) {
                    if (size > this.wB) {
                        size = this.wB;
                    }
                    for (int i2 = 0; i2 < size; i2++) {
                        fileOutputStream.write((a.b((a) get(i2)) + StringUtils.LF).getBytes("utf-8"));
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            a(fileOutputStream);
        }
    }

    public void gl() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.sM) {
            return;
        }
        gm();
        this.sM = true;
    }

    public void k(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || size() >= this.wA) {
            return;
        }
        add(aVar);
    }
}
