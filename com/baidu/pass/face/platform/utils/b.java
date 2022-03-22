package com.baidu.pass.face.platform.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.SoundPool;
import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static long a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final String f28122b = "b";

    /* renamed from: e  reason: collision with root package name */
    public static b f28123e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public SoundPool f28124c;

    /* renamed from: d  reason: collision with root package name */
    public SparseIntArray f28125d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1262515951, "Lcom/baidu/pass/face/platform/utils/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1262515951, "Lcom/baidu/pass/face/platform/utils/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28124c = new SoundPool(5, 3, 0);
        this.f28125d = new SparseIntArray();
        a = 0L;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            try {
                if (f28123e != null) {
                    int size = f28123e.f28125d.size();
                    for (int i = 0; i < size; i++) {
                        f28123e.f28124c.unload(f28123e.f28125d.valueAt(i));
                    }
                    f28123e.f28124c.release();
                    f28123e.f28124c = null;
                    f28123e.f28125d.clear();
                    f28123e.f28125d = null;
                    f28123e = null;
                }
                a = 0L;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i) == null) {
            if (f28123e == null) {
                f28123e = new b();
            }
            try {
                int i2 = f28123e.f28125d.get(i);
                if (i2 == 0) {
                    int load = f28123e.f28124c.load(context, i, 1);
                    f28123e.f28125d.put(i, load);
                    f28123e.f28124c.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener(load) { // from class: com.baidu.pass.face.platform.utils.b.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ int a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {Integer.valueOf(load)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.a = load;
                        }

                        @Override // android.media.SoundPool.OnLoadCompleteListener
                        public void onLoadComplete(SoundPool soundPool, int i3, int i4) {
                            Interceptable interceptable2 = $ic;
                            if ((interceptable2 == null || interceptable2.invokeLII(1048576, this, soundPool, i3, i4) == null) && i4 == 0 && this.a == i3) {
                                try {
                                    b.a = System.currentTimeMillis();
                                    b.f28123e.f28124c.play(this.a, 1.0f, 1.0f, 5, 0, 1.0f);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    });
                    return;
                }
                try {
                    f28123e.f28124c.play(i2, 1.0f, 1.0f, 5, 0, 1.0f);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }
}
