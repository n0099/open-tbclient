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
import d.a.y.f.b;
import d.a.y.f.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class FFmpegCmdExecutor implements b.a, b.InterfaceC1953b, b.c, b.d, b.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<Integer, Integer> f8135a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f8136b;

    /* renamed from: c  reason: collision with root package name */
    public int f8137c;

    /* renamed from: d  reason: collision with root package name */
    public MediaTranscoder f8138d;

    /* renamed from: e  reason: collision with root package name */
    public b f8139e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<String> f8140f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<String> f8141g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<String> f8142h;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f8143a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f8144b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f8145c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f8146d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f8147e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f8148f;

        /* renamed from: g  reason: collision with root package name */
        public static final a f8149g;

        /* renamed from: h  reason: collision with root package name */
        public static final a f8150h;

        /* renamed from: i  reason: collision with root package name */
        public static final a f8151i;
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
            f8143a = new a("ultrafast", 0);
            f8144b = new a("superfast", 1);
            f8145c = new a("veryfast", 2);
            f8146d = new a("faster", 3);
            f8147e = new a(LoginConstants.FAST_LOGIN, 4);
            f8148f = new a("medium", 5);
            f8149g = new a("slow", 6);
            f8150h = new a("slower", 7);
            f8151i = new a("veryslow", 8);
            a aVar = new a("placebo", 9);
            j = aVar;
            k = new a[]{f8143a, f8144b, f8145c, f8146d, f8147e, f8148f, f8149g, f8150h, f8151i, aVar};
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

    /* loaded from: classes2.dex */
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
        this.f8136b = new Object();
        this.f8137c = 4;
        this.f8139e = null;
        HashMap hashMap = new HashMap();
        this.f8135a = hashMap;
        hashMap.put(2, 128);
        this.f8135a.put(4, 8);
        this.f8135a.put(8, Integer.valueOf((int) Opcodes.IFNE));
        this.f8135a.put(16, 162);
        this.f8135a.put(32, 194);
        this.f8135a.put(64, 162);
        this.f8135a.put(128, 28);
        this.f8140f = new ArrayList<>();
        this.f8141g = new ArrayList<>();
        this.f8142h = new ArrayList<>();
        try {
            MediaTranscoder mediaTranscoder = new MediaTranscoder();
            this.f8138d = mediaTranscoder;
            mediaTranscoder.setOnPreparedListener(this);
            this.f8138d.setOnInfoListener(this);
            this.f8138d.setOnErrorListener(this);
            this.f8138d.setOnCompletionListener(this);
            this.f8138d.setOnTerminalListener(this);
            this.f8137c = 8;
        } catch (Error e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // d.a.y.f.b.e
    public void a(d.a.y.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
        }
    }

    @Override // d.a.y.f.b.a
    public void b(d.a.y.f.b bVar) {
        b bVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || (bVar2 = this.f8139e) == null) {
            return;
        }
        bVar2.onCompletion();
    }

    @Override // d.a.y.f.b.d
    public void c(d.a.y.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            synchronized (this.f8136b) {
                f(32);
            }
            b bVar2 = this.f8139e;
            if (bVar2 != null) {
                bVar2.onInfo(1002, 0, null);
            }
            synchronized (this.f8136b) {
                if (f(64) > 0 && this.f8138d != null) {
                    this.f8138d.start();
                }
            }
        }
    }

    @Override // d.a.y.f.b.InterfaceC1953b
    public boolean d(d.a.y.f.b bVar, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bVar, i2, i3)) == null) {
            synchronized (this.f8136b) {
                f(2);
            }
            b bVar2 = this.f8139e;
            if (bVar2 != null) {
                return bVar2.onError(i2, i3, null);
            }
            return false;
        }
        return invokeLII.booleanValue;
    }

    @Override // d.a.y.f.b.c
    public boolean e(d.a.y.f.b bVar, int i2, int i3, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{bVar, Integer.valueOf(i2), Integer.valueOf(i3), obj})) == null) {
            b bVar2 = this.f8139e;
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
            int i3 = this.f8137c;
            if (i3 == i2) {
                return 0;
            }
            if (i2 != (this.f8135a.get(Integer.valueOf(i3)).intValue() & i2)) {
                return -1;
            }
            this.f8137c = i2;
            return 1;
        }
        return invokeI.intValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            k();
            synchronized (this.f8136b) {
                f(4);
                if (this.f8138d != null) {
                    this.f8138d.release();
                    this.f8138d = null;
                }
            }
        }
    }

    public synchronized void h(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            synchronized (this) {
                this.f8139e = bVar;
            }
        }
    }

    public void i(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList) == null) {
            synchronized (this.f8136b) {
                if (this.f8137c != 8) {
                    e.e("FFmpegCmdExecutor", "setSource() called on an error status:" + this.f8137c);
                } else if (arrayList != null && arrayList.size() > 0) {
                    this.f8138d.a(arrayList);
                }
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this.f8136b) {
                if (f(16) <= 0) {
                    e.e("FFmpegCmdExecutor", "start() called on an error status:" + this.f8137c);
                } else if (this.f8138d != null) {
                    for (int i2 = 0; i2 < this.f8140f.size(); i2++) {
                        this.f8138d.setDataSource(this.f8140f.get(i2));
                    }
                    for (int i3 = 0; i3 < this.f8141g.size(); i3++) {
                        this.f8138d.setOutputFile(this.f8141g.get(i3));
                    }
                    for (int i4 = 0; i4 < this.f8142h.size(); i4 += 2) {
                        this.f8138d.setOption(this.f8142h.get(i4), this.f8142h.get(i4 + 1));
                    }
                    this.f8138d.prepareAsync();
                }
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this.f8136b) {
                if (f(128) > 0 && this.f8138d != null) {
                    e.c("FFmpegCmdExecutor", "stop in");
                    this.f8138d.stop();
                    e.c("FFmpegCmdExecutor", "stop out");
                }
            }
        }
    }
}
