package com.baidu.media.transcoder;

import androidx.core.view.InputDeviceCompat;
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
import d.a.b0.f.b;
import d.a.b0.f.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class FFmpegCmdExecutor implements b.a, b.InterfaceC0581b, b.c, b.d, b.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<Integer, Integer> f8118a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f8119b;

    /* renamed from: c  reason: collision with root package name */
    public int f8120c;

    /* renamed from: d  reason: collision with root package name */
    public MediaTranscoder f8121d;

    /* renamed from: e  reason: collision with root package name */
    public b f8122e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<String> f8123f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<String> f8124g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<String> f8125h;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f8126a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f8127b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f8128c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f8129d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f8130e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f8131f;

        /* renamed from: g  reason: collision with root package name */
        public static final a f8132g;

        /* renamed from: h  reason: collision with root package name */
        public static final a f8133h;

        /* renamed from: i  reason: collision with root package name */
        public static final a f8134i;
        public static final a j;
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
            f8126a = new a("ultrafast", 0);
            f8127b = new a("superfast", 1);
            f8128c = new a("veryfast", 2);
            f8129d = new a("faster", 3);
            f8130e = new a(LoginConstants.FAST_LOGIN, 4);
            f8131f = new a("medium", 5);
            f8132g = new a("slow", 6);
            f8133h = new a("slower", 7);
            f8134i = new a("veryslow", 8);
            a aVar = new a("placebo", 9);
            j = aVar;
            k = new a[]{f8126a, f8127b, f8128c, f8129d, f8130e, f8131f, f8132g, f8133h, f8134i, aVar};
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

    /* loaded from: classes3.dex */
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
        this.f8119b = new Object();
        this.f8120c = 4;
        this.f8122e = null;
        HashMap hashMap = new HashMap();
        this.f8118a = hashMap;
        hashMap.put(2, 128);
        this.f8118a.put(4, 8);
        this.f8118a.put(8, Integer.valueOf((int) Opcodes.IFNE));
        this.f8118a.put(16, 162);
        this.f8118a.put(32, 194);
        this.f8118a.put(64, 162);
        this.f8118a.put(128, 28);
        this.f8123f = new ArrayList<>();
        this.f8124g = new ArrayList<>();
        this.f8125h = new ArrayList<>();
        try {
            MediaTranscoder mediaTranscoder = new MediaTranscoder();
            this.f8121d = mediaTranscoder;
            mediaTranscoder.setOnPreparedListener(this);
            this.f8121d.setOnInfoListener(this);
            this.f8121d.setOnErrorListener(this);
            this.f8121d.setOnCompletionListener(this);
            this.f8121d.setOnTerminalListener(this);
            this.f8120c = 8;
        } catch (Error e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // d.a.b0.f.b.e
    public void a(d.a.b0.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
        }
    }

    @Override // d.a.b0.f.b.a
    public void b(d.a.b0.f.b bVar) {
        b bVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || (bVar2 = this.f8122e) == null) {
            return;
        }
        bVar2.onCompletion();
    }

    @Override // d.a.b0.f.b.d
    public void c(d.a.b0.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            synchronized (this.f8119b) {
                f(32);
            }
            b bVar2 = this.f8122e;
            if (bVar2 != null) {
                bVar2.onInfo(1002, 0, null);
            }
            synchronized (this.f8119b) {
                if (f(64) > 0 && this.f8121d != null) {
                    this.f8121d.start();
                }
            }
        }
    }

    @Override // d.a.b0.f.b.InterfaceC0581b
    public boolean d(d.a.b0.f.b bVar, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bVar, i2, i3)) == null) {
            synchronized (this.f8119b) {
                f(2);
            }
            b bVar2 = this.f8122e;
            if (bVar2 != null) {
                return bVar2.onError(i2, i3, null);
            }
            return false;
        }
        return invokeLII.booleanValue;
    }

    @Override // d.a.b0.f.b.c
    public boolean e(d.a.b0.f.b bVar, int i2, int i3, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{bVar, Integer.valueOf(i2), Integer.valueOf(i3), obj})) == null) {
            b bVar2 = this.f8122e;
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
            int i3 = this.f8120c;
            if (i3 == i2) {
                return 0;
            }
            if (i2 != (this.f8118a.get(Integer.valueOf(i3)).intValue() & i2)) {
                return -1;
            }
            this.f8120c = i2;
            return 1;
        }
        return invokeI.intValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            k();
            synchronized (this.f8119b) {
                f(4);
                if (this.f8121d != null) {
                    this.f8121d.release();
                    this.f8121d = null;
                }
            }
        }
    }

    public synchronized void h(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            synchronized (this) {
                this.f8122e = bVar;
            }
        }
    }

    public void i(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList) == null) {
            synchronized (this.f8119b) {
                if (this.f8120c != 8) {
                    e.e("FFmpegCmdExecutor", "setSource() called on an error status:" + this.f8120c);
                } else if (arrayList != null && arrayList.size() > 0) {
                    this.f8121d.a(arrayList);
                }
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this.f8119b) {
                if (f(16) <= 0) {
                    e.e("FFmpegCmdExecutor", "start() called on an error status:" + this.f8120c);
                } else if (this.f8121d != null) {
                    for (int i2 = 0; i2 < this.f8123f.size(); i2++) {
                        this.f8121d.setDataSource(this.f8123f.get(i2));
                    }
                    for (int i3 = 0; i3 < this.f8124g.size(); i3++) {
                        this.f8121d.setOutputFile(this.f8124g.get(i3));
                    }
                    for (int i4 = 0; i4 < this.f8125h.size(); i4 += 2) {
                        this.f8121d.setOption(this.f8125h.get(i4), this.f8125h.get(i4 + 1));
                    }
                    this.f8121d.prepareAsync();
                }
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this.f8119b) {
                if (f(128) > 0 && this.f8121d != null) {
                    e.c("FFmpegCmdExecutor", "stop in");
                    this.f8121d.stop();
                    e.c("FFmpegCmdExecutor", "stop out");
                }
            }
        }
    }
}
