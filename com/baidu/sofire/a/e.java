package com.baidu.sofire.a;

import android.content.Context;
import android.os.FileObserver;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.k.p;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes2.dex */
public class e extends FileObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public int c;
    public Context d;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    synchronized (e.class) {
                        if (!com.baidu.sofire.k.a.d(this.a.a)) {
                            e eVar = this.a;
                            String str = eVar.b;
                            String str2 = eVar.a;
                            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                                com.baidu.sofire.k.a.a(new File(str), new File(str2));
                            }
                            com.baidu.sofire.k.a.a(this.a.a, true);
                            c.a(new File(this.a.a));
                            e eVar2 = this.a;
                            c.a(eVar2.d, eVar2.c, new File(this.a.a), new File(this.a.b));
                            com.baidu.sofire.c.a.a(this.a.d).c(this.a.c, -1);
                        }
                    }
                } catch (Throwable unused) {
                    int i = b.a;
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, int i, String str, String str2) {
        super(str, 4095);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        try {
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = context;
        } catch (Throwable th) {
            com.baidu.sofire.k.a.a(th);
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                File file = new File(this.b);
                if (file.exists()) {
                    return file.delete();
                }
                return false;
            } catch (Throwable unused) {
                int i = b.a;
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            if (i == 2 || i == 4 || i == 64 || i == 128 || i == 512 || i == 1024 || i == 2048) {
                try {
                    p.a(this.d).a(new a(this));
                } catch (Throwable unused) {
                    int i2 = b.a;
                }
            }
        }
    }
}
