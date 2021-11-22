package com.baidu.media.transcoder;

import androidx.core.view.InputDeviceCompat;
import b.a.z.a.b;
import b.a.z.a.e;
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
/* loaded from: classes7.dex */
public class FFmpegCmdExecutor implements b.a, b.InterfaceC1485b, b.c, b.d, b.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<Integer, Integer> f41289a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f41290b;

    /* renamed from: c  reason: collision with root package name */
    public int f41291c;

    /* renamed from: d  reason: collision with root package name */
    public MediaTranscoder f41292d;

    /* renamed from: e  reason: collision with root package name */
    public b f41293e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<String> f41294f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<String> f41295g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<String> f41296h;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f41297a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f41298b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f41299c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f41300d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f41301e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f41302f;

        /* renamed from: g  reason: collision with root package name */
        public static final a f41303g;

        /* renamed from: h  reason: collision with root package name */
        public static final a f41304h;

        /* renamed from: i  reason: collision with root package name */
        public static final a f41305i;
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
            f41297a = new a("ultrafast", 0);
            f41298b = new a("superfast", 1);
            f41299c = new a("veryfast", 2);
            f41300d = new a("faster", 3);
            f41301e = new a(LoginConstants.FAST_LOGIN, 4);
            f41302f = new a("medium", 5);
            f41303g = new a("slow", 6);
            f41304h = new a("slower", 7);
            f41305i = new a("veryslow", 8);
            a aVar = new a("placebo", 9);
            j = aVar;
            k = new a[]{f41297a, f41298b, f41299c, f41300d, f41301e, f41302f, f41303g, f41304h, f41305i, aVar};
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

    /* loaded from: classes7.dex */
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
        this.f41290b = new Object();
        this.f41291c = 4;
        this.f41293e = null;
        HashMap hashMap = new HashMap();
        this.f41289a = hashMap;
        hashMap.put(2, 128);
        this.f41289a.put(4, 8);
        this.f41289a.put(8, Integer.valueOf((int) Opcodes.IFNE));
        this.f41289a.put(16, 162);
        this.f41289a.put(32, 194);
        this.f41289a.put(64, 162);
        this.f41289a.put(128, 28);
        this.f41294f = new ArrayList<>();
        this.f41295g = new ArrayList<>();
        this.f41296h = new ArrayList<>();
        try {
            MediaTranscoder mediaTranscoder = new MediaTranscoder();
            this.f41292d = mediaTranscoder;
            mediaTranscoder.setOnPreparedListener(this);
            this.f41292d.setOnInfoListener(this);
            this.f41292d.setOnErrorListener(this);
            this.f41292d.setOnCompletionListener(this);
            this.f41292d.setOnTerminalListener(this);
            this.f41291c = 8;
        } catch (Error e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // b.a.z.a.b.e
    public void a(b.a.z.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
        }
    }

    @Override // b.a.z.a.b.a
    public void b(b.a.z.a.b bVar) {
        b bVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || (bVar2 = this.f41293e) == null) {
            return;
        }
        bVar2.onCompletion();
    }

    @Override // b.a.z.a.b.d
    public void c(b.a.z.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            synchronized (this.f41290b) {
                f(32);
            }
            b bVar2 = this.f41293e;
            if (bVar2 != null) {
                bVar2.onInfo(1002, 0, null);
            }
            synchronized (this.f41290b) {
                if (f(64) > 0 && this.f41292d != null) {
                    this.f41292d.start();
                }
            }
        }
    }

    @Override // b.a.z.a.b.InterfaceC1485b
    public boolean d(b.a.z.a.b bVar, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bVar, i2, i3)) == null) {
            synchronized (this.f41290b) {
                f(2);
            }
            b bVar2 = this.f41293e;
            if (bVar2 != null) {
                return bVar2.onError(i2, i3, null);
            }
            return false;
        }
        return invokeLII.booleanValue;
    }

    @Override // b.a.z.a.b.c
    public boolean e(b.a.z.a.b bVar, int i2, int i3, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{bVar, Integer.valueOf(i2), Integer.valueOf(i3), obj})) == null) {
            b bVar2 = this.f41293e;
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
            int i3 = this.f41291c;
            if (i3 == i2) {
                return 0;
            }
            if (i2 != (this.f41289a.get(Integer.valueOf(i3)).intValue() & i2)) {
                return -1;
            }
            this.f41291c = i2;
            return 1;
        }
        return invokeI.intValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            k();
            synchronized (this.f41290b) {
                f(4);
                if (this.f41292d != null) {
                    this.f41292d.release();
                    this.f41292d = null;
                }
            }
        }
    }

    public synchronized void h(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            synchronized (this) {
                this.f41293e = bVar;
            }
        }
    }

    public void i(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList) == null) {
            synchronized (this.f41290b) {
                if (this.f41291c != 8) {
                    e.e("FFmpegCmdExecutor", "setSource() called on an error status:" + this.f41291c);
                } else if (arrayList != null && arrayList.size() > 0) {
                    this.f41292d.a(arrayList);
                }
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this.f41290b) {
                if (f(16) <= 0) {
                    e.e("FFmpegCmdExecutor", "start() called on an error status:" + this.f41291c);
                } else if (this.f41292d != null) {
                    for (int i2 = 0; i2 < this.f41294f.size(); i2++) {
                        this.f41292d.setDataSource(this.f41294f.get(i2));
                    }
                    for (int i3 = 0; i3 < this.f41295g.size(); i3++) {
                        this.f41292d.setOutputFile(this.f41295g.get(i3));
                    }
                    for (int i4 = 0; i4 < this.f41296h.size(); i4 += 2) {
                        this.f41292d.setOption(this.f41296h.get(i4), this.f41296h.get(i4 + 1));
                    }
                    this.f41292d.prepareAsync();
                }
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this.f41290b) {
                if (f(128) > 0 && this.f41292d != null) {
                    e.c("FFmpegCmdExecutor", "stop in");
                    this.f41292d.stop();
                    e.c("FFmpegCmdExecutor", "stop out");
                }
            }
        }
    }
}
