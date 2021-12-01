package c.a.x0.l.d;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.x0.s.a;
import c.a.x0.t.s;
import c.a.x0.t.x;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.rtc.record.MediaEncodeParams;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer;
import com.baidu.ugc.utils.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements a.InterfaceC1545a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.InterfaceC1545a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.x0.s.a f27012b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f27013c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f27014d;

        public a(a.InterfaceC1545a interfaceC1545a, c.a.x0.s.a aVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC1545a, aVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = interfaceC1545a;
            this.f27012b = aVar;
            this.f27013c = str;
            this.f27014d = str2;
        }

        @Override // c.a.x0.s.a.InterfaceC1545a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.x0.t.c.e("FFmpegCmdExecutor-modifyAudioProperty", "onCompletion:src:" + this.f27013c + ",:dest:" + this.f27014d);
                a.InterfaceC1545a interfaceC1545a = this.a;
                if (interfaceC1545a != null) {
                    interfaceC1545a.onCompletion();
                }
                c.a.x0.t.c.e("FFmpegCmdExecutor-modifyAudioProperty", "release");
                this.f27012b.release();
            }
        }

        @Override // c.a.x0.s.a.InterfaceC1545a
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onError i = ");
                sb.append(i2);
                sb.append(" i1 = ");
                sb.append(i3);
                sb.append(" o ");
                sb.append(obj != null ? obj.toString() : " null ");
                c.a.x0.t.c.e("FFmpegCmdExecutor-modifyAudioProperty", sb.toString());
                a.InterfaceC1545a interfaceC1545a = this.a;
                if (interfaceC1545a != null) {
                    interfaceC1545a.onError(i2, i3, obj);
                }
                c.a.x0.t.c.e("FFmpegCmdExecutor-modifyAudioProperty", "release");
                this.f27012b.release();
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // c.a.x0.s.a.InterfaceC1545a
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onInfo i = ");
                sb.append(i2);
                sb.append(" i1 = ");
                sb.append(i3);
                sb.append(" o ");
                sb.append(obj != null ? obj.toString() : " null ");
                c.a.x0.t.c.j("FFmpegCmdExecutor-modifyAudioProperty", sb.toString());
                a.InterfaceC1545a interfaceC1545a = this.a;
                if (interfaceC1545a != null) {
                    interfaceC1545a.onInfo(i2, i3, obj);
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements a.InterfaceC1545a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.InterfaceC1545a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.x0.s.a f27015b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f27016c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f27017d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f27018e;

        public b(a.InterfaceC1545a interfaceC1545a, c.a.x0.s.a aVar, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC1545a, aVar, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = interfaceC1545a;
            this.f27015b = aVar;
            this.f27016c = str;
            this.f27017d = str2;
            this.f27018e = str3;
        }

        @Override // c.a.x0.s.a.InterfaceC1545a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.x0.t.c.e("FFmpegCmdExecutor-mixAudio", "onCompletion:src:" + this.f27016c + "," + this.f27017d + ",:dest:" + this.f27018e);
                a.InterfaceC1545a interfaceC1545a = this.a;
                if (interfaceC1545a != null) {
                    interfaceC1545a.onCompletion();
                }
                c.a.x0.t.c.e("FFmpegCmdExecutor-mixAudio", "release");
                this.f27015b.release();
            }
        }

        @Override // c.a.x0.s.a.InterfaceC1545a
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onError i = ");
                sb.append(i2);
                sb.append(" i1 = ");
                sb.append(i3);
                sb.append(" o ");
                sb.append(obj != null ? obj.toString() : " null ");
                c.a.x0.t.c.e("FFmpegCmdExecutor-mixAudio", sb.toString());
                a.InterfaceC1545a interfaceC1545a = this.a;
                if (interfaceC1545a != null) {
                    interfaceC1545a.onError(i2, i3, obj);
                }
                c.a.x0.t.c.e("FFmpegCmdExecutor-mixAudio", "release");
                this.f27015b.release();
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // c.a.x0.s.a.InterfaceC1545a
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onInfo i = ");
                sb.append(i2);
                sb.append(" i1 = ");
                sb.append(i3);
                sb.append(" o ");
                sb.append(obj != null ? obj.toString() : " null ");
                c.a.x0.t.c.e("FFmpegCmdExecutor-mixAudio", sb.toString());
                a.InterfaceC1545a interfaceC1545a = this.a;
                if (interfaceC1545a != null) {
                    interfaceC1545a.onInfo(i2, i3, obj);
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements a.InterfaceC1545a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.InterfaceC1545a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.x0.s.a f27019b;

        public c(a.InterfaceC1545a interfaceC1545a, c.a.x0.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC1545a, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = interfaceC1545a;
            this.f27019b = aVar;
        }

        @Override // c.a.x0.s.a.InterfaceC1545a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.InterfaceC1545a interfaceC1545a = this.a;
                if (interfaceC1545a != null) {
                    interfaceC1545a.onCompletion();
                }
                this.f27019b.release();
            }
        }

        @Override // c.a.x0.s.a.InterfaceC1545a
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onError i = ");
                sb.append(i2);
                sb.append(" i1 = ");
                sb.append(i3);
                sb.append(" o ");
                sb.append(obj != null ? obj.toString() : " null ");
                c.a.x0.t.c.e("FFmpegCmdExecutor-mixAudio", sb.toString());
                a.InterfaceC1545a interfaceC1545a = this.a;
                if (interfaceC1545a != null) {
                    interfaceC1545a.onError(i2, i3, obj);
                }
                this.f27019b.release();
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // c.a.x0.s.a.InterfaceC1545a
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onInfo i = ");
                sb.append(i2);
                sb.append(" i1 = ");
                sb.append(i3);
                sb.append(" o ");
                sb.append(obj != null ? obj.toString() : " null ");
                c.a.x0.t.c.j("FFmpegCmdExecutor-mixAudio", sb.toString());
                a.InterfaceC1545a interfaceC1545a = this.a;
                if (interfaceC1545a != null) {
                    interfaceC1545a.onInfo(i2, i3, obj);
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements a.InterfaceC1545a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.InterfaceC1545a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.x0.s.a f27020b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f27021c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f27022d;

        public d(a.InterfaceC1545a interfaceC1545a, c.a.x0.s.a aVar, List list, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC1545a, aVar, list, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = interfaceC1545a;
            this.f27020b = aVar;
            this.f27021c = list;
            this.f27022d = str;
        }

        @Override // c.a.x0.s.a.InterfaceC1545a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.x0.t.c.j("FFmpegCmdExecutor-concat", "onCompletion:inputsize:" + this.f27021c.size() + ",dest:" + this.f27022d);
                a.InterfaceC1545a interfaceC1545a = this.a;
                if (interfaceC1545a != null) {
                    interfaceC1545a.onCompletion();
                }
                this.f27020b.release();
            }
        }

        @Override // c.a.x0.s.a.InterfaceC1545a
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onError i = ");
                sb.append(i2);
                sb.append(" i1 = ");
                sb.append(i3);
                sb.append(" o ");
                sb.append(obj != null ? obj.toString() : " null ");
                c.a.x0.t.c.j("FFmpegCmdExecutor-concat", sb.toString());
                a.InterfaceC1545a interfaceC1545a = this.a;
                if (interfaceC1545a != null) {
                    interfaceC1545a.onError(i2, i3, obj);
                }
                this.f27020b.release();
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // c.a.x0.s.a.InterfaceC1545a
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onInfo i = ");
                sb.append(i2);
                sb.append(" i1 = ");
                sb.append(i3);
                sb.append(" o ");
                sb.append(obj != null ? obj.toString() : " null ");
                c.a.x0.t.c.j("FFmpegCmdExecutor-concat", sb.toString());
                a.InterfaceC1545a interfaceC1545a = this.a;
                if (interfaceC1545a != null) {
                    interfaceC1545a.onInfo(i2, i3, obj);
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements a.InterfaceC1545a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.InterfaceC1545a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.x0.s.a f27023b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f27024c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f27025d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f27026e;

        public e(a.InterfaceC1545a interfaceC1545a, c.a.x0.s.a aVar, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC1545a, aVar, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = interfaceC1545a;
            this.f27023b = aVar;
            this.f27024c = str;
            this.f27025d = str2;
            this.f27026e = str3;
        }

        @Override // c.a.x0.s.a.InterfaceC1545a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.x0.t.c.e("FFmpegCmdExecutor-muxAudioVideo", "onCompletion:video:" + this.f27024c + ",audio" + this.f27025d + ",:dest:" + this.f27026e);
                a.InterfaceC1545a interfaceC1545a = this.a;
                if (interfaceC1545a != null) {
                    interfaceC1545a.onCompletion();
                }
                c.a.x0.t.c.e("FFmpegCmdExecutor-muxAudioVideo", "release");
                this.f27023b.release();
            }
        }

        @Override // c.a.x0.s.a.InterfaceC1545a
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onError i = ");
                sb.append(i2);
                sb.append(" i1 = ");
                sb.append(i3);
                sb.append(" o ");
                sb.append(obj != null ? obj.toString() : " null ");
                c.a.x0.t.c.e("FFmpegCmdExecutor-muxAudioVideo", sb.toString());
                a.InterfaceC1545a interfaceC1545a = this.a;
                if (interfaceC1545a != null) {
                    interfaceC1545a.onError(i2, i3, obj);
                }
                c.a.x0.t.c.e("FFmpegCmdExecutor-muxAudioVideo", "release");
                this.f27023b.release();
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // c.a.x0.s.a.InterfaceC1545a
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onInfo i = ");
                sb.append(i2);
                sb.append(" i1 = ");
                sb.append(i3);
                sb.append(" o ");
                sb.append(obj != null ? obj.toString() : " null ");
                c.a.x0.t.c.e("FFmpegCmdExecutor-muxAudioVideo", sb.toString());
                a.InterfaceC1545a interfaceC1545a = this.a;
                if (interfaceC1545a != null) {
                    interfaceC1545a.onInfo(i2, i3, obj);
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* renamed from: c.a.x0.l.d.f$f  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1534f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f27027b;

        /* renamed from: c  reason: collision with root package name */
        public int f27028c;

        /* renamed from: d  reason: collision with root package name */
        public String f27029d;

        /* renamed from: e  reason: collision with root package name */
        public int f27030e;

        public C1534f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = MediaEncodeParams.AUDIO_SAMPLE_RATE;
            this.f27027b = 1;
            this.f27028c = 16;
            this.f27030e = 0;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = this.f27030e;
                return i2 == 5 || i2 == 6 || i2 == 8 || i2 == 9;
            }
            return invokeV.booleanValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i2 = this.f27030e;
                return i2 == 3 || i2 == 4 || i2 == 8 || i2 == 9;
            }
            return invokeV.booleanValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i2 = this.f27030e;
                return i2 == 1 || i2 == 4 || i2 == 6 || i2 == 9;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1675981940, "Lc/a/x0/l/d/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1675981940, "Lc/a/x0/l/d/f;");
                return;
            }
        }
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            a = true;
        } else {
            a = false;
        }
    }

    public static byte[] a(byte b2, byte b3, byte b4, byte b5, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Byte.valueOf(b2), Byte.valueOf(b3), Byte.valueOf(b4), Byte.valueOf(b5), Boolean.valueOf(z)})) == null) ? f((short) ((h(b2, b3, z) / 2) + (h(b4, b5, z) / 2)), z) : (byte[]) invokeCommon.objValue;
    }

    public static void b(List<String> list, String str, String str2, a.InterfaceC1545a interfaceC1545a, boolean z, boolean z2) {
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{list, str, str2, interfaceC1545a, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            c.a.x0.s.a aVar = (c.a.x0.s.a) s.a("com.baidu.ugc.api.ffmpeg.MFFmpegCmdExecutor");
            if (c.a.x0.t.h.e(list)) {
                if (interfaceC1545a != null) {
                    interfaceC1545a.onError(-1, -1, "input list null");
                }
            } else if (aVar == null) {
                if (interfaceC1545a != null) {
                    interfaceC1545a.onError(-1, -1, "can not find MFFmpegCmdExecutor");
                }
            } else {
                aVar.setListener(new d(interfaceC1545a, aVar, list, str));
                if (TextUtils.isEmpty(str2)) {
                    file = new File(FileUtils.removeExtention(str) + System.currentTimeMillis() + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION);
                } else {
                    String fileNameWithOutExtention = FileUtils.getFileNameWithOutExtention(str);
                    file = new File(str2 + fileNameWithOutExtention + System.currentTimeMillis() + "concat.txt");
                }
                c.a.x0.t.c.j("FFmpegCmdExecutor-concat", "inputfilename:" + file.getPath());
                StringBuilder sb = new StringBuilder();
                for (String str3 : list) {
                    sb.append("file '");
                    sb.append(str3);
                    sb.append("'\n");
                }
                FileUtils.writeFile(file, sb.toString(), false);
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add("-f");
                arrayList.add("concat");
                arrayList.add("-safe");
                arrayList.add("0");
                arrayList.add("-i");
                arrayList.add(file.getPath());
                if (!z) {
                    arrayList.add("-vn");
                }
                arrayList.add("-c");
                if (z2) {
                    arrayList.add("aac");
                } else {
                    arrayList.add("copy");
                }
                arrayList.add(str);
                aVar.setSource(arrayList);
                c.a.x0.t.c.e("FFmpegCmdExecutor-mixAudio", "start");
                aVar.start();
            }
        }
    }

    public static byte[] c(int i2, int i3, byte[] bArr) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65539, null, i2, i3, bArr)) == null) {
            c.a.x0.t.c.b("convertByteWidth sourceByteWidth = " + i2 + " outputByteWidth = " + i3);
            if (i2 == i3) {
                return bArr;
            }
            int length = bArr.length;
            if (i2 != 1) {
                if (i2 == 2 && i3 == 1) {
                    int i4 = length / 2;
                    byte[] bArr2 = new byte[i4];
                    for (int i5 = 0; i5 < i4; i5++) {
                        int i6 = i5 * 2;
                        bArr2[i5] = (byte) (h(bArr[i6], bArr[i6 + 1], a) / 256);
                    }
                    return bArr2;
                }
            } else if (i3 == 2) {
                byte[] bArr3 = new byte[length * 2];
                for (int i7 = 0; i7 < length; i7++) {
                    byte[] f2 = f((short) (bArr[i7] * 256), a);
                    int i8 = i7 * 2;
                    bArr3[i8] = f2[0];
                    bArr3[i8 + 1] = f2[1];
                }
                return bArr3;
            }
            return bArr;
        }
        return (byte[]) invokeIIL.objValue;
    }

    public static byte[] d(int i2, int i3, int i4, byte[] bArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bArr})) == null) {
            c.a.x0.t.c.b("convertChannelCount sourceChannelCount = " + i2 + " outputChannelCount = " + i3);
            if (i2 == i3) {
                return bArr;
            }
            if (i4 == 1 || i4 == 2) {
                int length = bArr.length;
                int i5 = 0;
                if (i2 != 1) {
                    if (i2 == 2 && i3 == 1) {
                        int i6 = length / 2;
                        byte[] bArr2 = new byte[i6];
                        if (i4 == 1) {
                            while (i5 < i6) {
                                int i7 = i5 * 2;
                                bArr2[i5] = (byte) (((short) (bArr[i7] + bArr[i7 + 1])) >> 1);
                                i5 += 2;
                            }
                        } else if (i4 == 2) {
                            for (int i8 = 0; i8 < i6; i8 += 2) {
                                int i9 = i8 * 2;
                                byte[] a2 = a(bArr[i9], bArr[i9 + 1], bArr[i9 + 2], bArr[i9 + 3], a);
                                bArr2[i8] = a2[0];
                                bArr2[i8 + 1] = a2[1];
                            }
                        }
                        return bArr2;
                    }
                } else if (i3 == 2) {
                    byte[] bArr3 = new byte[length * 2];
                    if (i4 == 1) {
                        while (i5 < length) {
                            byte b2 = bArr[i5];
                            int i10 = i5 * 2;
                            bArr3[i10] = b2;
                            bArr3[i10 + 1] = b2;
                            i5++;
                        }
                    } else if (i4 == 2) {
                        while (i5 < length) {
                            byte b3 = bArr[i5];
                            byte b4 = bArr[i5 + 1];
                            int i11 = i5 * 2;
                            bArr3[i11] = b3;
                            bArr3[i11 + 1] = b4;
                            bArr3[i11 + 2] = b3;
                            bArr3[i11 + 3] = b4;
                            i5 += 2;
                        }
                    }
                    return bArr3;
                }
                return bArr;
            }
            return bArr;
        }
        return (byte[]) invokeCommon.objValue;
    }

    @TargetApi(16)
    public static C1534f e(String str) {
        InterceptResult invokeL;
        MediaFormat mediaFormat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            MediaExtractor mediaExtractor = new MediaExtractor();
            try {
                mediaExtractor.setDataSource(str);
                int i2 = 0;
                while (true) {
                    if (i2 >= mediaExtractor.getTrackCount()) {
                        mediaFormat = null;
                        break;
                    }
                    mediaFormat = mediaExtractor.getTrackFormat(i2);
                    if (mediaFormat.getString("mime").startsWith("audio/")) {
                        mediaExtractor.selectTrack(i2);
                        break;
                    }
                    i2++;
                }
                if (mediaFormat == null) {
                    mediaExtractor.release();
                    return null;
                }
                C1534f c1534f = new C1534f();
                c1534f.f27029d = mediaFormat.getString("mime");
                c1534f.a = mediaFormat.containsKey("sample-rate") ? mediaFormat.getInteger("sample-rate") : MediaEncodeParams.AUDIO_SAMPLE_RATE;
                c1534f.f27027b = mediaFormat.containsKey("channel-count") ? mediaFormat.getInteger("channel-count") : 1;
                c1534f.f27028c = mediaFormat.containsKey("bit-width") ? mediaFormat.getInteger("bit-width") : 16;
                mediaExtractor.release();
                return c1534f;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C1534f) invokeL.objValue;
    }

    public static byte[] f(short s, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Short.valueOf(s), Boolean.valueOf(z)})) == null) {
            byte[] bArr = new byte[2];
            if (z) {
                bArr[1] = (byte) (s & 255);
                bArr[0] = (byte) (((short) (s >> 8)) & 255);
            } else {
                bArr[0] = (byte) (s & 255);
                bArr[1] = (byte) (((short) (s >> 8)) & 255);
            }
            return bArr;
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static int g(MediaFormat mediaFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, mediaFormat)) == null) {
            String string = mediaFormat.getString("mime");
            if (string.startsWith(com.sina.weibo.sdk.utils.FileUtils.VIDEO_FILE_START)) {
                return 1;
            }
            return string.startsWith("audio/") ? 2 : 0;
        }
        return invokeL.intValue;
    }

    public static short h(byte b2, byte b3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Byte.valueOf(b2), Byte.valueOf(b3), Boolean.valueOf(z)})) == null) {
            return (short) (z ? ((short) (((short) ((b2 & 255) | 0)) << 8)) | (b3 & 255) : (b2 & 255) | ((short) (((short) ((b3 & 255) | 0)) << 8)));
        }
        return invokeCommon.shortValue;
    }

    public static boolean i(C1534f... c1534fArr) {
        InterceptResult invokeL;
        C1534f c1534f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, c1534fArr)) == null) {
            if (c1534fArr == null || c1534fArr.length < 2 || (c1534f = c1534fArr[0]) == null) {
                return false;
            }
            boolean z = true;
            for (int i2 = 1; i2 < c1534fArr.length; i2++) {
                if (c1534f.a != c1534fArr[i2].a) {
                    c1534fArr[i2].f27030e++;
                    z = false;
                }
                if (c1534f.f27027b != c1534fArr[i2].f27027b) {
                    c1534fArr[i2].f27030e += 3;
                    z = false;
                }
                if (c1534f.f27028c != c1534fArr[i2].f27028c) {
                    c1534fArr[i2].f27030e += 5;
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static void j(String str, String str2, String str3, int i2, a.InterfaceC1545a interfaceC1545a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, str2, str3, Integer.valueOf(i2), interfaceC1545a}) == null) {
            c.a.x0.s.a aVar = (c.a.x0.s.a) s.a("com.baidu.ugc.api.ffmpeg.MFFmpegCmdExecutor");
            if (aVar == null) {
                if (interfaceC1545a != null) {
                    interfaceC1545a.onError(-1, -1, "can not find MFFmpegCmdExecutor");
                    return;
                }
                return;
            }
            c.a.x0.t.c.e("FFmpegCmdExecutor-mixAudio", "new mixAudio");
            aVar.setListener(new b(interfaceC1545a, aVar, str, str2, str3));
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("-i");
            arrayList.add(str);
            arrayList.add("-i");
            arrayList.add(str2);
            arrayList.add("-filter_complex");
            arrayList.add("[0:a] [1:a]amerge=inputs=2[aout]");
            arrayList.add("-map");
            arrayList.add("[aout]");
            if (i2 > 0) {
                arrayList.add("-ac");
                arrayList.add(String.valueOf(i2));
            }
            arrayList.add(str3);
            aVar.setSource(arrayList);
            aVar.start();
        }
    }

    public static void k(List<String> list, String str, int i2, a.InterfaceC1545a interfaceC1545a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65547, null, list, str, i2, interfaceC1545a) == null) {
            if (c.a.x0.t.h.b(list) == 2) {
                j(list.get(0), list.get(1), str, i2, interfaceC1545a);
                return;
            }
            c.a.x0.s.a aVar = (c.a.x0.s.a) s.a("com.baidu.ugc.api.ffmpeg.MFFmpegCmdExecutor");
            if (aVar == null) {
                if (interfaceC1545a != null) {
                    interfaceC1545a.onError(-1, -1, "can not find MFFmpegCmdExecutor");
                    return;
                }
                return;
            }
            aVar.setListener(new c(interfaceC1545a, aVar));
            ArrayList<String> arrayList = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            int i3 = 0;
            for (String str2 : list) {
                arrayList.add("-i");
                arrayList.add(str2);
                sb.append(PreferencesUtil.LEFT_MOUNT);
                sb.append(i3);
                sb.append(":a]volume=1");
                sb.append(PreferencesUtil.LEFT_MOUNT);
                sb.append("a");
                i3++;
                sb.append(i3);
                sb.append("];");
                sb2.append(PreferencesUtil.LEFT_MOUNT);
                sb2.append("a");
                sb2.append(i3);
                sb2.append(PreferencesUtil.RIGHT_MOUNT);
            }
            arrayList.add("-filter_complex");
            arrayList.add(String.format("%s%samix=inputs=%s[aout]", sb.toString(), sb2.toString(), Integer.valueOf(list.size())));
            arrayList.add("-map");
            arrayList.add("[aout]");
            if (i2 > 0) {
                arrayList.add("-ac");
                arrayList.add(String.valueOf(i2));
            }
            arrayList.add(str);
            aVar.setSource(arrayList);
            aVar.start();
        }
    }

    public static void l(String str, String str2, int i2, int i3, float f2, int i4, float f3, float f4, boolean z, a.InterfaceC1545a interfaceC1545a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4), Float.valueOf(f3), Float.valueOf(f4), Boolean.valueOf(z), interfaceC1545a}) == null) {
            float f5 = f3 * 1000.0f;
            if (r9 < (f4 * 1000.0f) + f5 || f4 <= 0.0f) {
                f4 = (r9 - f5) / 1000.0f;
            }
            c.a.x0.t.c.c(VLogMultiAudioMixer.TAG, "modifyAudioProperty - duration" + f4);
            c.a.x0.s.a aVar = (c.a.x0.s.a) s.a("com.baidu.ugc.api.ffmpeg.MFFmpegCmdExecutor");
            c.a.x0.t.c.e("FFmpegCmdExecutor-modifyAudioProperty", "MFFmpegCmdExecutor modifyAudioProperty new");
            if (aVar == null) {
                if (interfaceC1545a != null) {
                    interfaceC1545a.onError(-1, -1, "can not find MFFmpegCmdExecutor");
                    return;
                }
                return;
            }
            aVar.setListener(new a(interfaceC1545a, aVar, str, str2));
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("-i");
            arrayList.add(str);
            if (f4 > 0.0f) {
                arrayList.add("-ss");
                arrayList.add(String.valueOf(f3));
                arrayList.add("-t");
                arrayList.add(String.valueOf(f4));
            }
            if (i2 > 0) {
                arrayList.add("-ar");
                arrayList.add(String.valueOf(i2));
            }
            if (i3 > 0) {
                arrayList.add("-ac");
                arrayList.add(String.valueOf(i3));
            }
            if (f2 >= 0.0f) {
                arrayList.add("-af");
                arrayList.add("volume=" + f2);
            }
            arrayList.add("-acodec");
            arrayList.add("aac");
            arrayList.add(str2);
            aVar.setSource(arrayList);
            c.a.x0.t.c.e("FFmpegCmdExecutor-modifyAudioProperty", "start");
            aVar.start();
        }
    }

    public static void m(String str, String str2, String str3, a.InterfaceC1545a interfaceC1545a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65549, null, str, str2, str3, interfaceC1545a) == null) {
            c.a.x0.s.a aVar = (c.a.x0.s.a) s.a("com.baidu.ugc.api.ffmpeg.MFFmpegCmdExecutor");
            if (aVar == null) {
                if (interfaceC1545a != null) {
                    interfaceC1545a.onError(-1, -1, "can not find MFFmpegCmdExecutor");
                    return;
                }
                return;
            }
            aVar.setListener(new e(interfaceC1545a, aVar, str, str2, str3));
            long b2 = x.b(str2);
            long f2 = x.f(str);
            c.a.x0.t.c.j("VideoMuxer", "muxAudioVideo,audioduration:" + b2 + ",videoDuration:" + f2);
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("-i");
            arrayList.add(str);
            arrayList.add("-i");
            arrayList.add(str2);
            if (Math.abs(f2 - b2) >= 100 && b2 <= f2) {
                arrayList.add("-filter_complex");
                arrayList.add("[1:a]aloop=loop=-1:size=2e+09[aout]");
                arrayList.add("-map");
                arrayList.add("0:v");
                arrayList.add("-map");
                arrayList.add("[aout]");
                arrayList.add("-c:v");
                arrayList.add("copy");
            } else {
                arrayList.add("-c");
                arrayList.add("copy");
                arrayList.add("-map");
                arrayList.add("0:v");
                arrayList.add("-map");
                arrayList.add("1:a");
            }
            arrayList.add("-shortest");
            arrayList.add(str3);
            aVar.setSource(arrayList);
            c.a.x0.t.c.e("FFmpegCmdExecutor-muxAudioVideo", "start");
            aVar.start();
        }
    }

    public static boolean n(String str, String str2, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65550, null, str, str2, i2, i3)) == null) {
            if (i3 == i2) {
                return false;
            }
            File file = new File(str);
            File file2 = new File(str2);
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                new h(fileInputStream, fileOutputStream, i2, i3, 2, 2, 1, Integer.MAX_VALUE, 0.0d, 0, true);
                fileInputStream.close();
                fileOutputStream.close();
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                c.a.x0.t.c.e("MediaUtils", "resamplefail:" + e2.getMessage());
                return false;
            }
        }
        return invokeLLII.booleanValue;
    }
}
