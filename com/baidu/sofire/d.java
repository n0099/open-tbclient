package com.baidu.sofire;

import android.content.Context;
import android.os.FileObserver;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.utility.z;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes10.dex */
public class d extends FileObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f39741b;

    /* renamed from: c  reason: collision with root package name */
    public int f39742c;

    /* renamed from: d  reason: collision with root package name */
    public Context f39743d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, int i2, String str, String str2) {
        super(str, 4095);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        try {
            this.a = str;
            this.f39741b = str2;
            this.f39742c = i2;
            this.f39743d = context;
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
    }

    @Override // android.os.FileObserver
    public void onEvent(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            if (i2 == 2 || i2 == 4 || i2 == 64 || i2 == 128 || i2 == 512 || i2 == 1024 || i2 == 2048) {
                try {
                    z.a(this.f39743d).a(new Runnable(this) { // from class: com.baidu.sofire.d.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ d a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.a = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                try {
                                    synchronized (d.class) {
                                        if (!com.baidu.sofire.utility.c.c(this.a.a)) {
                                            com.baidu.sofire.utility.c.a(this.a.f39741b, this.a.a);
                                            com.baidu.sofire.utility.c.a(this.a.a, true);
                                            c.a(new File(this.a.a));
                                            c.a(this.a.f39743d, this.a.f39742c, new File(this.a.a), new File(this.a.f39741b));
                                            com.baidu.sofire.a.a.a(this.a.f39743d).b(this.a.f39742c, -1);
                                        }
                                    }
                                } catch (Throwable unused) {
                                    com.baidu.sofire.utility.c.a();
                                }
                            }
                        }
                    });
                } catch (Throwable unused) {
                    com.baidu.sofire.utility.c.a();
                }
            }
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                File file = new File(this.f39741b);
                if (file.exists()) {
                    return file.delete();
                }
                return false;
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
