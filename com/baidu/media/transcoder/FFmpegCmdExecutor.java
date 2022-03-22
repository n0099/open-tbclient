package com.baidu.media.transcoder;

import androidx.core.view.InputDeviceCompat;
import c.a.y.a.b;
import c.a.y.a.e;
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
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class FFmpegCmdExecutor implements b.a, b.InterfaceC1632b, b.c, b.d, b.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<Integer, Integer> a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f26942b;

    /* renamed from: c  reason: collision with root package name */
    public int f26943c;

    /* renamed from: d  reason: collision with root package name */
    public MediaTranscoder f26944d;

    /* renamed from: e  reason: collision with root package name */
    public b f26945e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<String> f26946f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<String> f26947g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<String> f26948h;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f26949b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f26950c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f26951d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f26952e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f26953f;

        /* renamed from: g  reason: collision with root package name */
        public static final a f26954g;

        /* renamed from: h  reason: collision with root package name */
        public static final a f26955h;
        public static final a i;
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
            a = new a("ultrafast", 0);
            f26949b = new a("superfast", 1);
            f26950c = new a("veryfast", 2);
            f26951d = new a("faster", 3);
            f26952e = new a(LoginConstants.FAST_LOGIN, 4);
            f26953f = new a("medium", 5);
            f26954g = new a("slow", 6);
            f26955h = new a("slower", 7);
            i = new a("veryslow", 8);
            a aVar = new a("placebo", 9);
            j = aVar;
            k = new a[]{a, f26949b, f26950c, f26951d, f26952e, f26953f, f26954g, f26955h, i, aVar};
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

    /* loaded from: classes4.dex */
    public interface b {
        void onCompletion();

        boolean onError(int i, int i2, Object obj);

        boolean onInfo(int i, int i2, Object obj);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f26942b = new Object();
        this.f26943c = 4;
        this.f26945e = null;
        HashMap hashMap = new HashMap();
        this.a = hashMap;
        hashMap.put(2, 128);
        this.a.put(4, 8);
        this.a.put(8, Integer.valueOf((int) Cea708Decoder.COMMAND_DF2));
        this.a.put(16, 162);
        this.a.put(32, 194);
        this.a.put(64, 162);
        this.a.put(128, 28);
        this.f26946f = new ArrayList<>();
        this.f26947g = new ArrayList<>();
        this.f26948h = new ArrayList<>();
        try {
            MediaTranscoder mediaTranscoder = new MediaTranscoder();
            this.f26944d = mediaTranscoder;
            mediaTranscoder.setOnPreparedListener(this);
            this.f26944d.setOnInfoListener(this);
            this.f26944d.setOnErrorListener(this);
            this.f26944d.setOnCompletionListener(this);
            this.f26944d.setOnTerminalListener(this);
            this.f26943c = 8;
        } catch (Error e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // c.a.y.a.b.e
    public void a(c.a.y.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
        }
    }

    @Override // c.a.y.a.b.a
    public void b(c.a.y.a.b bVar) {
        b bVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || (bVar2 = this.f26945e) == null) {
            return;
        }
        bVar2.onCompletion();
    }

    @Override // c.a.y.a.b.d
    public void c(c.a.y.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            synchronized (this.f26942b) {
                f(32);
            }
            b bVar2 = this.f26945e;
            if (bVar2 != null) {
                bVar2.onInfo(1002, 0, null);
            }
            synchronized (this.f26942b) {
                if (f(64) > 0 && this.f26944d != null) {
                    this.f26944d.start();
                }
            }
        }
    }

    @Override // c.a.y.a.b.InterfaceC1632b
    public boolean d(c.a.y.a.b bVar, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bVar, i, i2)) == null) {
            synchronized (this.f26942b) {
                f(2);
            }
            b bVar2 = this.f26945e;
            if (bVar2 != null) {
                return bVar2.onError(i, i2, null);
            }
            return false;
        }
        return invokeLII.booleanValue;
    }

    @Override // c.a.y.a.b.c
    public boolean e(c.a.y.a.b bVar, int i, int i2, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{bVar, Integer.valueOf(i), Integer.valueOf(i2), obj})) == null) {
            b bVar2 = this.f26945e;
            if (bVar2 != null) {
                return bVar2.onInfo(i, i2, obj);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final int f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            int i2 = this.f26943c;
            if (i2 == i) {
                return 0;
            }
            if (i != (this.a.get(Integer.valueOf(i2)).intValue() & i)) {
                return -1;
            }
            this.f26943c = i;
            return 1;
        }
        return invokeI.intValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            k();
            synchronized (this.f26942b) {
                f(4);
                if (this.f26944d != null) {
                    this.f26944d.release();
                    this.f26944d = null;
                }
            }
        }
    }

    public synchronized void h(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            synchronized (this) {
                this.f26945e = bVar;
            }
        }
    }

    public void i(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList) == null) {
            synchronized (this.f26942b) {
                if (this.f26943c != 8) {
                    e.e("FFmpegCmdExecutor", "setSource() called on an error status:" + this.f26943c);
                } else if (arrayList != null && arrayList.size() > 0) {
                    this.f26944d.a(arrayList);
                }
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this.f26942b) {
                if (f(16) <= 0) {
                    e.e("FFmpegCmdExecutor", "start() called on an error status:" + this.f26943c);
                } else if (this.f26944d != null) {
                    for (int i = 0; i < this.f26946f.size(); i++) {
                        this.f26944d.setDataSource(this.f26946f.get(i));
                    }
                    for (int i2 = 0; i2 < this.f26947g.size(); i2++) {
                        this.f26944d.setOutputFile(this.f26947g.get(i2));
                    }
                    for (int i3 = 0; i3 < this.f26948h.size(); i3 += 2) {
                        this.f26944d.setOption(this.f26948h.get(i3), this.f26948h.get(i3 + 1));
                    }
                    this.f26944d.prepareAsync();
                }
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this.f26942b) {
                if (f(128) > 0 && this.f26944d != null) {
                    e.c("FFmpegCmdExecutor", "stop in");
                    this.f26944d.stop();
                    e.c("FFmpegCmdExecutor", "stop out");
                }
            }
        }
    }
}
