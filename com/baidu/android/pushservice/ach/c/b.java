package com.baidu.android.pushservice.ach.c;

import android.content.Context;
import android.graphics.Region;
import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.ach.c.c;
import com.baidu.android.pushservice.ach.c.d;
import com.baidu.protect.sdk.Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.baidu.android.pushservice.ach.c.d a;
    public boolean b;
    public int c;
    public final com.baidu.android.pushservice.ach.c.c d;
    public Region e;
    public final Handler f;
    public final Runnable g;
    public d h;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15874, this, null);
            }
        }
    }

    /* renamed from: com.baidu.android.pushservice.ach.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0024b implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C0024b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.android.pushservice.ach.c.d.b
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15873, this, Boolean.valueOf(z), Integer.valueOf(i));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.android.pushservice.ach.c.c.b
        public void a(int i, Region region) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, region) == null) {
                Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15876, this, Integer.valueOf(i), region);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(int i);

        void a(boolean z, int i);
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new com.baidu.android.pushservice.ach.c.d();
        this.b = false;
        this.c = 0;
        this.d = new com.baidu.android.pushservice.ach.c.c();
        this.f = new Handler(Looper.getMainLooper());
        this.g = new a(this);
    }

    public static /* synthetic */ Region a(b bVar) {
        return (Region) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15902, null, bVar);
    }

    public static /* synthetic */ Region a(b bVar, Region region) {
        return (Region) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15901, null, bVar, region);
    }

    public static /* synthetic */ d b(b bVar) {
        return (d) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15903, null, bVar);
    }

    public static /* synthetic */ Runnable e(b bVar) {
        return (Runnable) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15900, null, bVar);
    }

    public static /* synthetic */ Handler f(b bVar) {
        return (Handler) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15899, null, bVar);
    }

    public void a(Context context, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, dVar) == null) {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15894, this, context, dVar);
        }
    }

    public final void a(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, z) == null) {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15893, this, context, str, Boolean.valueOf(z));
        }
    }
}
