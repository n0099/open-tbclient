package com.baidu.pass.face.platform.utils;

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
/* loaded from: classes2.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static long a = 0;
    public static final String b = "b";
    public static b e;
    public transient /* synthetic */ FieldHolder $fh;
    public SoundPool c;
    public SparseIntArray d;

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
        this.c = new SoundPool(5, 3, 0);
        this.d = new SparseIntArray();
        a = 0L;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            try {
                if (e != null) {
                    int size = e.d.size();
                    for (int i = 0; i < size; i++) {
                        e.c.unload(e.d.valueAt(i));
                    }
                    e.c.release();
                    e.c = null;
                    e.d.clear();
                    e.d = null;
                    e = null;
                }
                a = 0L;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i) == null) {
            if (e == null) {
                e = new b();
            }
            try {
                int i2 = e.d.get(i);
                if (i2 == 0) {
                    int load = e.c.load(context, i, 1);
                    e.d.put(i, load);
                    e.c.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener(load) { // from class: com.baidu.pass.face.platform.utils.b.1
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
                                    b.e.c.play(this.a, 1.0f, 1.0f, 5, 0, 1.0f);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    });
                    return;
                }
                try {
                    e.c.play(i2, 1.0f, 1.0f, 5, 0, 1.0f);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }
}
