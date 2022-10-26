package com.baidu.ar.statistic;

import android.content.Context;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
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
/* loaded from: classes.dex */
public class d extends ArrayList {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean sM;
    public int wA;
    public int wB;
    public WeakReference wn;
    public String wz;

    public d(Context context, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.wn = new WeakReference(context);
        this.sM = false;
        this.wA = i;
        this.wz = str;
        this.wB = i2;
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
        Exception e;
        a aG;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || this.wB <= 0 || (context = (Context) this.wn.get()) == null || !context.getFileStreamPath(this.wz).exists()) {
            return;
        }
        try {
            fileInputStream = context.openFileInput(this.wz);
        } catch (Exception e2) {
            closeable = null;
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            closeable = null;
            th = th2;
            fileInputStream = null;
        }
        try {
            closeable = new Scanner(fileInputStream, IMAudioTransRequest.CHARSET);
            while (closeable.hasNextLine()) {
                try {
                    try {
                        String nextLine = closeable.nextLine();
                        if (nextLine != null && !nextLine.isEmpty() && (aG = a.aG(nextLine)) != null) {
                            add(aG);
                        }
                    } catch (Exception e3) {
                        e = e3;
                        e.printStackTrace();
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
        } catch (Exception e4) {
            closeable = null;
            e = e4;
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

    public void S(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || i <= 0) {
            return;
        }
        a[] aVarArr = new a[i];
        for (int i2 = 0; i2 < i; i2++) {
            aVarArr[i2] = (a) get(i2);
        }
        removeRange(0, i);
        a.a(aVarArr);
    }

    public void flush() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.wB <= 0 || (context = (Context) this.wn.get()) == null) {
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
                    for (int i = 0; i < size; i++) {
                        fileOutputStream.write((a.b((a) get(i)) + "\n").getBytes(IMAudioTransRequest.CHARSET));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
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
