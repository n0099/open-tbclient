package com.baidu.media.transcoder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDLocation;
import com.baidu.media.transcoder.cyber.MediaTranscoder;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.tieba.u90;
import com.baidu.tieba.x90;
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
/* loaded from: classes3.dex */
public class FFmpegCmdExecutor implements u90.a, u90.b, u90.c, u90.d, u90.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<Integer, Integer> a;
    public final Object b;
    public int c;
    public MediaTranscoder d;
    public b e;
    public ArrayList<String> f;
    public ArrayList<String> g;
    public ArrayList<String> h;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        public static final a g;
        public static final a h;
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
            b = new a("superfast", 1);
            c = new a("veryfast", 2);
            d = new a("faster", 3);
            e = new a(LoginConstants.FAST_LOGIN, 4);
            f = new a("medium", 5);
            g = new a("slow", 6);
            h = new a("slower", 7);
            i = new a("veryslow", 8);
            a aVar = new a("placebo", 9);
            j = aVar;
            k = new a[]{a, b, c, d, e, f, g, h, i, aVar};
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
        this.b = new Object();
        this.c = 4;
        this.e = null;
        HashMap hashMap = new HashMap();
        this.a = hashMap;
        hashMap.put(2, 128);
        this.a.put(4, 8);
        this.a.put(8, Integer.valueOf((int) Cea708Decoder.COMMAND_DF2));
        Map<Integer, Integer> map = this.a;
        Integer valueOf = Integer.valueOf((int) BDLocation.TypeServerDecryptError);
        map.put(16, valueOf);
        this.a.put(32, 194);
        this.a.put(64, valueOf);
        this.a.put(128, 28);
        this.f = new ArrayList<>();
        this.g = new ArrayList<>();
        this.h = new ArrayList<>();
        try {
            MediaTranscoder mediaTranscoder = new MediaTranscoder();
            this.d = mediaTranscoder;
            mediaTranscoder.setOnPreparedListener(this);
            this.d.setOnInfoListener(this);
            this.d.setOnErrorListener(this);
            this.d.setOnCompletionListener(this);
            this.d.setOnTerminalListener(this);
            this.c = 8;
        } catch (Error e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.u90.e
    public void a(u90 u90Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, u90Var) == null) {
        }
    }

    @Override // com.baidu.tieba.u90.a
    public void b(u90 u90Var) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u90Var) == null) || (bVar = this.e) == null) {
            return;
        }
        bVar.onCompletion();
    }

    @Override // com.baidu.tieba.u90.d
    public void c(u90 u90Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, u90Var) == null) {
            synchronized (this.b) {
                f(32);
            }
            b bVar = this.e;
            if (bVar != null) {
                bVar.onInfo(1002, 0, null);
            }
            synchronized (this.b) {
                if (f(64) > 0 && this.d != null) {
                    this.d.start();
                }
            }
        }
    }

    @Override // com.baidu.tieba.u90.b
    public boolean d(u90 u90Var, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, u90Var, i, i2)) == null) {
            synchronized (this.b) {
                f(2);
            }
            b bVar = this.e;
            if (bVar != null) {
                return bVar.onError(i, i2, null);
            }
            return false;
        }
        return invokeLII.booleanValue;
    }

    @Override // com.baidu.tieba.u90.c
    public boolean e(u90 u90Var, int i, int i2, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{u90Var, Integer.valueOf(i), Integer.valueOf(i2), obj})) == null) {
            b bVar = this.e;
            if (bVar != null) {
                return bVar.onInfo(i, i2, obj);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final int f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            int i2 = this.c;
            if (i2 == i) {
                return 0;
            }
            if (i != (this.a.get(Integer.valueOf(i2)).intValue() & i)) {
                return -1;
            }
            this.c = i;
            return 1;
        }
        return invokeI.intValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            k();
            synchronized (this.b) {
                f(4);
                if (this.d != null) {
                    this.d.release();
                    this.d = null;
                }
            }
        }
    }

    public synchronized void h(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            synchronized (this) {
                this.e = bVar;
            }
        }
    }

    public void i(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList) == null) {
            synchronized (this.b) {
                if (this.c != 8) {
                    x90.e("FFmpegCmdExecutor", "setSource() called on an error status:" + this.c);
                } else if (arrayList != null && arrayList.size() > 0) {
                    this.d.a(arrayList);
                }
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this.b) {
                if (f(16) <= 0) {
                    x90.e("FFmpegCmdExecutor", "start() called on an error status:" + this.c);
                } else if (this.d != null) {
                    for (int i = 0; i < this.f.size(); i++) {
                        this.d.setDataSource(this.f.get(i));
                    }
                    for (int i2 = 0; i2 < this.g.size(); i2++) {
                        this.d.setOutputFile(this.g.get(i2));
                    }
                    for (int i3 = 0; i3 < this.h.size(); i3 += 2) {
                        this.d.setOption(this.h.get(i3), this.h.get(i3 + 1));
                    }
                    this.d.prepareAsync();
                }
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this.b) {
                if (f(128) > 0 && this.d != null) {
                    x90.c("FFmpegCmdExecutor", "stop in");
                    this.d.stop();
                    x90.c("FFmpegCmdExecutor", "stop out");
                }
            }
        }
    }
}
