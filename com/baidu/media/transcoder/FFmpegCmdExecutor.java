package com.baidu.media.transcoder;

import androidx.core.view.InputDeviceCompat;
import c.a.b0.a.b;
import c.a.b0.a.e;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.media.transcoder.cyber.MediaTranscoder;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class FFmpegCmdExecutor implements b.a, b.InterfaceC0011b, b.c, b.d, b.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<Integer, Integer> a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f36363b;

    /* renamed from: c  reason: collision with root package name */
    public int f36364c;

    /* renamed from: d  reason: collision with root package name */
    public MediaTranscoder f36365d;

    /* renamed from: e  reason: collision with root package name */
    public b f36366e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<String> f36367f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<String> f36368g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<String> f36369h;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f36370b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f36371c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f36372d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f36373e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f36374f;

        /* renamed from: g  reason: collision with root package name */
        public static final a f36375g;

        /* renamed from: h  reason: collision with root package name */
        public static final a f36376h;

        /* renamed from: i  reason: collision with root package name */
        public static final a f36377i;

        /* renamed from: j  reason: collision with root package name */
        public static final a f36378j;
        public static final /* synthetic */ a[] k;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(315542863, "Lcom/baidu/media/transcoder/FFmpegCmdExecutor$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(315542863, "Lcom/baidu/media/transcoder/FFmpegCmdExecutor$a;");
                    return;
                }
            }
            a = new a("ultrafast", 0);
            f36370b = new a("superfast", 1);
            f36371c = new a("veryfast", 2);
            f36372d = new a("faster", 3);
            f36373e = new a(LoginConstants.FAST_LOGIN, 4);
            f36374f = new a("medium", 5);
            f36375g = new a("slow", 6);
            f36376h = new a("slower", 7);
            f36377i = new a("veryslow", 8);
            a aVar = new a("placebo", 9);
            f36378j = aVar;
            k = new a[]{a, f36370b, f36371c, f36372d, f36373e, f36374f, f36375g, f36376h, f36377i, aVar};
        }

        public a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (a) Enum.valueOf(a.class, str) : (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (a[]) k.clone() : (a[]) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
        void onCompletion();

        boolean onError(int i2, int i3, Object obj);

        boolean onInfo(int i2, int i3, Object obj);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(550048428, "Lcom/baidu/media/transcoder/FFmpegCmdExecutor;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(550048428, "Lcom/baidu/media/transcoder/FFmpegCmdExecutor;");
        }
    }

    public FFmpegCmdExecutor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f36363b = new Object();
        this.f36364c = 4;
        this.f36366e = null;
        HashMap hashMap = new HashMap();
        this.a = hashMap;
        hashMap.put(2, 128);
        this.a.put(4, 8);
        this.a.put(8, Integer.valueOf((int) Opcodes.IFNE));
        this.a.put(16, 162);
        this.a.put(32, 194);
        this.a.put(64, 162);
        this.a.put(128, 28);
        this.f36367f = new ArrayList<>();
        this.f36368g = new ArrayList<>();
        this.f36369h = new ArrayList<>();
        try {
            MediaTranscoder mediaTranscoder = new MediaTranscoder();
            this.f36365d = mediaTranscoder;
            mediaTranscoder.setOnPreparedListener(this);
            this.f36365d.setOnInfoListener(this);
            this.f36365d.setOnErrorListener(this);
            this.f36365d.setOnCompletionListener(this);
            this.f36365d.setOnTerminalListener(this);
            this.f36364c = 8;
        } catch (Error e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // c.a.b0.a.b.e
    public void a(c.a.b0.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
        }
    }

    @Override // c.a.b0.a.b.a
    public void b(c.a.b0.a.b bVar) {
        b bVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || (bVar2 = this.f36366e) == null) {
            return;
        }
        bVar2.onCompletion();
    }

    @Override // c.a.b0.a.b.d
    public void c(c.a.b0.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            synchronized (this.f36363b) {
                f(32);
            }
            b bVar2 = this.f36366e;
            if (bVar2 != null) {
                bVar2.onInfo(1002, 0, null);
            }
            synchronized (this.f36363b) {
                if (f(64) > 0 && this.f36365d != null) {
                    this.f36365d.start();
                }
            }
        }
    }

    @Override // c.a.b0.a.b.InterfaceC0011b
    public boolean d(c.a.b0.a.b bVar, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bVar, i2, i3)) == null) {
            synchronized (this.f36363b) {
                f(2);
            }
            b bVar2 = this.f36366e;
            if (bVar2 != null) {
                return bVar2.onError(i2, i3, null);
            }
            return false;
        }
        return invokeLII.booleanValue;
    }

    @Override // c.a.b0.a.b.c
    public boolean e(c.a.b0.a.b bVar, int i2, int i3, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{bVar, Integer.valueOf(i2), Integer.valueOf(i3), obj})) == null) {
            b bVar2 = this.f36366e;
            if (bVar2 != null) {
                return bVar2.onInfo(i2, i3, obj);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final int f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            int i3 = this.f36364c;
            if (i3 == i2) {
                return 0;
            }
            if (i2 != (this.a.get(Integer.valueOf(i3)).intValue() & i2)) {
                return -1;
            }
            this.f36364c = i2;
            return 1;
        }
        return invokeI.intValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            k();
            synchronized (this.f36363b) {
                f(4);
                if (this.f36365d != null) {
                    this.f36365d.release();
                    this.f36365d = null;
                }
            }
        }
    }

    public synchronized void h(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            synchronized (this) {
                this.f36366e = bVar;
            }
        }
    }

    public void i(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList) == null) {
            synchronized (this.f36363b) {
                if (this.f36364c != 8) {
                    e.e("FFmpegCmdExecutor", "setSource() called on an error status:" + this.f36364c);
                } else if (arrayList != null && arrayList.size() > 0) {
                    this.f36365d.a(arrayList);
                }
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this.f36363b) {
                if (f(16) <= 0) {
                    e.e("FFmpegCmdExecutor", "start() called on an error status:" + this.f36364c);
                } else if (this.f36365d != null) {
                    for (int i2 = 0; i2 < this.f36367f.size(); i2++) {
                        this.f36365d.setDataSource(this.f36367f.get(i2));
                    }
                    for (int i3 = 0; i3 < this.f36368g.size(); i3++) {
                        this.f36365d.setOutputFile(this.f36368g.get(i3));
                    }
                    for (int i4 = 0; i4 < this.f36369h.size(); i4 += 2) {
                        this.f36365d.setOption(this.f36369h.get(i4), this.f36369h.get(i4 + 1));
                    }
                    this.f36365d.prepareAsync();
                }
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this.f36363b) {
                if (f(128) > 0 && this.f36365d != null) {
                    e.c("FFmpegCmdExecutor", "stop in");
                    this.f36365d.stop();
                    e.c("FFmpegCmdExecutor", "stop out");
                }
            }
        }
    }
}
