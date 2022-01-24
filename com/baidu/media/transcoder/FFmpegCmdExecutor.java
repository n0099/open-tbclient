package com.baidu.media.transcoder;

import androidx.core.view.InputDeviceCompat;
import c.a.a0.a.b;
import c.a.a0.a.e;
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
public class FFmpegCmdExecutor implements b.a, b.InterfaceC0009b, b.c, b.d, b.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<Integer, Integer> a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f36157b;

    /* renamed from: c  reason: collision with root package name */
    public int f36158c;

    /* renamed from: d  reason: collision with root package name */
    public MediaTranscoder f36159d;

    /* renamed from: e  reason: collision with root package name */
    public b f36160e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<String> f36161f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<String> f36162g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<String> f36163h;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f36164b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f36165c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f36166d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f36167e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f36168f;

        /* renamed from: g  reason: collision with root package name */
        public static final a f36169g;

        /* renamed from: h  reason: collision with root package name */
        public static final a f36170h;

        /* renamed from: i  reason: collision with root package name */
        public static final a f36171i;

        /* renamed from: j  reason: collision with root package name */
        public static final a f36172j;
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
            f36164b = new a("superfast", 1);
            f36165c = new a("veryfast", 2);
            f36166d = new a("faster", 3);
            f36167e = new a(LoginConstants.FAST_LOGIN, 4);
            f36168f = new a("medium", 5);
            f36169g = new a("slow", 6);
            f36170h = new a("slower", 7);
            f36171i = new a("veryslow", 8);
            a aVar = new a("placebo", 9);
            f36172j = aVar;
            k = new a[]{a, f36164b, f36165c, f36166d, f36167e, f36168f, f36169g, f36170h, f36171i, aVar};
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
        this.f36157b = new Object();
        this.f36158c = 4;
        this.f36160e = null;
        HashMap hashMap = new HashMap();
        this.a = hashMap;
        hashMap.put(2, 128);
        this.a.put(4, 8);
        this.a.put(8, Integer.valueOf((int) Opcodes.IFNE));
        this.a.put(16, 162);
        this.a.put(32, 194);
        this.a.put(64, 162);
        this.a.put(128, 28);
        this.f36161f = new ArrayList<>();
        this.f36162g = new ArrayList<>();
        this.f36163h = new ArrayList<>();
        try {
            MediaTranscoder mediaTranscoder = new MediaTranscoder();
            this.f36159d = mediaTranscoder;
            mediaTranscoder.setOnPreparedListener(this);
            this.f36159d.setOnInfoListener(this);
            this.f36159d.setOnErrorListener(this);
            this.f36159d.setOnCompletionListener(this);
            this.f36159d.setOnTerminalListener(this);
            this.f36158c = 8;
        } catch (Error e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // c.a.a0.a.b.e
    public void a(c.a.a0.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
        }
    }

    @Override // c.a.a0.a.b.a
    public void b(c.a.a0.a.b bVar) {
        b bVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || (bVar2 = this.f36160e) == null) {
            return;
        }
        bVar2.onCompletion();
    }

    @Override // c.a.a0.a.b.d
    public void c(c.a.a0.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            synchronized (this.f36157b) {
                f(32);
            }
            b bVar2 = this.f36160e;
            if (bVar2 != null) {
                bVar2.onInfo(1002, 0, null);
            }
            synchronized (this.f36157b) {
                if (f(64) > 0 && this.f36159d != null) {
                    this.f36159d.start();
                }
            }
        }
    }

    @Override // c.a.a0.a.b.InterfaceC0009b
    public boolean d(c.a.a0.a.b bVar, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bVar, i2, i3)) == null) {
            synchronized (this.f36157b) {
                f(2);
            }
            b bVar2 = this.f36160e;
            if (bVar2 != null) {
                return bVar2.onError(i2, i3, null);
            }
            return false;
        }
        return invokeLII.booleanValue;
    }

    @Override // c.a.a0.a.b.c
    public boolean e(c.a.a0.a.b bVar, int i2, int i3, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{bVar, Integer.valueOf(i2), Integer.valueOf(i3), obj})) == null) {
            b bVar2 = this.f36160e;
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
            int i3 = this.f36158c;
            if (i3 == i2) {
                return 0;
            }
            if (i2 != (this.a.get(Integer.valueOf(i3)).intValue() & i2)) {
                return -1;
            }
            this.f36158c = i2;
            return 1;
        }
        return invokeI.intValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            k();
            synchronized (this.f36157b) {
                f(4);
                if (this.f36159d != null) {
                    this.f36159d.release();
                    this.f36159d = null;
                }
            }
        }
    }

    public synchronized void h(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            synchronized (this) {
                this.f36160e = bVar;
            }
        }
    }

    public void i(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList) == null) {
            synchronized (this.f36157b) {
                if (this.f36158c != 8) {
                    e.e("FFmpegCmdExecutor", "setSource() called on an error status:" + this.f36158c);
                } else if (arrayList != null && arrayList.size() > 0) {
                    this.f36159d.a(arrayList);
                }
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this.f36157b) {
                if (f(16) <= 0) {
                    e.e("FFmpegCmdExecutor", "start() called on an error status:" + this.f36158c);
                } else if (this.f36159d != null) {
                    for (int i2 = 0; i2 < this.f36161f.size(); i2++) {
                        this.f36159d.setDataSource(this.f36161f.get(i2));
                    }
                    for (int i3 = 0; i3 < this.f36162g.size(); i3++) {
                        this.f36159d.setOutputFile(this.f36162g.get(i3));
                    }
                    for (int i4 = 0; i4 < this.f36163h.size(); i4 += 2) {
                        this.f36159d.setOption(this.f36163h.get(i4), this.f36163h.get(i4 + 1));
                    }
                    this.f36159d.prepareAsync();
                }
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this.f36157b) {
                if (f(128) > 0 && this.f36159d != null) {
                    e.c("FFmpegCmdExecutor", "stop in");
                    this.f36159d.stop();
                    e.c("FFmpegCmdExecutor", "stop out");
                }
            }
        }
    }
}
