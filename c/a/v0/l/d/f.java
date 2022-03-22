package c.a.v0.l.d;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.v0.q.a;
import c.a.v0.r.s;
import c.a.v0.r.x;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
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
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements a.InterfaceC1617a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.InterfaceC1617a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.v0.q.a f21692b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f21693c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f21694d;

        public a(a.InterfaceC1617a interfaceC1617a, c.a.v0.q.a aVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC1617a, aVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = interfaceC1617a;
            this.f21692b = aVar;
            this.f21693c = str;
            this.f21694d = str2;
        }

        @Override // c.a.v0.q.a.InterfaceC1617a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.v0.r.c.e("FFmpegCmdExecutor-modifyAudioProperty", "onCompletion:src:" + this.f21693c + ",:dest:" + this.f21694d);
                a.InterfaceC1617a interfaceC1617a = this.a;
                if (interfaceC1617a != null) {
                    interfaceC1617a.onCompletion();
                }
                c.a.v0.r.c.e("FFmpegCmdExecutor-modifyAudioProperty", "release");
                this.f21692b.release();
            }
        }

        @Override // c.a.v0.q.a.InterfaceC1617a
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onError i = ");
                sb.append(i);
                sb.append(" i1 = ");
                sb.append(i2);
                sb.append(" o ");
                sb.append(obj != null ? obj.toString() : " null ");
                c.a.v0.r.c.e("FFmpegCmdExecutor-modifyAudioProperty", sb.toString());
                a.InterfaceC1617a interfaceC1617a = this.a;
                if (interfaceC1617a != null) {
                    interfaceC1617a.onError(i, i2, obj);
                }
                c.a.v0.r.c.e("FFmpegCmdExecutor-modifyAudioProperty", "release");
                this.f21692b.release();
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // c.a.v0.q.a.InterfaceC1617a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onInfo i = ");
                sb.append(i);
                sb.append(" i1 = ");
                sb.append(i2);
                sb.append(" o ");
                sb.append(obj != null ? obj.toString() : " null ");
                c.a.v0.r.c.j("FFmpegCmdExecutor-modifyAudioProperty", sb.toString());
                a.InterfaceC1617a interfaceC1617a = this.a;
                if (interfaceC1617a != null) {
                    interfaceC1617a.onInfo(i, i2, obj);
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements a.InterfaceC1617a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.InterfaceC1617a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.v0.q.a f21695b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f21696c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f21697d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f21698e;

        public b(a.InterfaceC1617a interfaceC1617a, c.a.v0.q.a aVar, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC1617a, aVar, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = interfaceC1617a;
            this.f21695b = aVar;
            this.f21696c = str;
            this.f21697d = str2;
            this.f21698e = str3;
        }

        @Override // c.a.v0.q.a.InterfaceC1617a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.v0.r.c.e("FFmpegCmdExecutor-mixAudio", "onCompletion:src:" + this.f21696c + "," + this.f21697d + ",:dest:" + this.f21698e);
                a.InterfaceC1617a interfaceC1617a = this.a;
                if (interfaceC1617a != null) {
                    interfaceC1617a.onCompletion();
                }
                c.a.v0.r.c.e("FFmpegCmdExecutor-mixAudio", "release");
                this.f21695b.release();
            }
        }

        @Override // c.a.v0.q.a.InterfaceC1617a
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onError i = ");
                sb.append(i);
                sb.append(" i1 = ");
                sb.append(i2);
                sb.append(" o ");
                sb.append(obj != null ? obj.toString() : " null ");
                c.a.v0.r.c.e("FFmpegCmdExecutor-mixAudio", sb.toString());
                a.InterfaceC1617a interfaceC1617a = this.a;
                if (interfaceC1617a != null) {
                    interfaceC1617a.onError(i, i2, obj);
                }
                c.a.v0.r.c.e("FFmpegCmdExecutor-mixAudio", "release");
                this.f21695b.release();
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // c.a.v0.q.a.InterfaceC1617a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onInfo i = ");
                sb.append(i);
                sb.append(" i1 = ");
                sb.append(i2);
                sb.append(" o ");
                sb.append(obj != null ? obj.toString() : " null ");
                c.a.v0.r.c.e("FFmpegCmdExecutor-mixAudio", sb.toString());
                a.InterfaceC1617a interfaceC1617a = this.a;
                if (interfaceC1617a != null) {
                    interfaceC1617a.onInfo(i, i2, obj);
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements a.InterfaceC1617a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.InterfaceC1617a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.v0.q.a f21699b;

        public c(a.InterfaceC1617a interfaceC1617a, c.a.v0.q.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC1617a, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = interfaceC1617a;
            this.f21699b = aVar;
        }

        @Override // c.a.v0.q.a.InterfaceC1617a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.InterfaceC1617a interfaceC1617a = this.a;
                if (interfaceC1617a != null) {
                    interfaceC1617a.onCompletion();
                }
                this.f21699b.release();
            }
        }

        @Override // c.a.v0.q.a.InterfaceC1617a
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onError i = ");
                sb.append(i);
                sb.append(" i1 = ");
                sb.append(i2);
                sb.append(" o ");
                sb.append(obj != null ? obj.toString() : " null ");
                c.a.v0.r.c.e("FFmpegCmdExecutor-mixAudio", sb.toString());
                a.InterfaceC1617a interfaceC1617a = this.a;
                if (interfaceC1617a != null) {
                    interfaceC1617a.onError(i, i2, obj);
                }
                this.f21699b.release();
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // c.a.v0.q.a.InterfaceC1617a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onInfo i = ");
                sb.append(i);
                sb.append(" i1 = ");
                sb.append(i2);
                sb.append(" o ");
                sb.append(obj != null ? obj.toString() : " null ");
                c.a.v0.r.c.j("FFmpegCmdExecutor-mixAudio", sb.toString());
                a.InterfaceC1617a interfaceC1617a = this.a;
                if (interfaceC1617a != null) {
                    interfaceC1617a.onInfo(i, i2, obj);
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements a.InterfaceC1617a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.InterfaceC1617a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.v0.q.a f21700b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f21701c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f21702d;

        public d(a.InterfaceC1617a interfaceC1617a, c.a.v0.q.a aVar, List list, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC1617a, aVar, list, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = interfaceC1617a;
            this.f21700b = aVar;
            this.f21701c = list;
            this.f21702d = str;
        }

        @Override // c.a.v0.q.a.InterfaceC1617a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.v0.r.c.j("FFmpegCmdExecutor-concat", "onCompletion:inputsize:" + this.f21701c.size() + ",dest:" + this.f21702d);
                a.InterfaceC1617a interfaceC1617a = this.a;
                if (interfaceC1617a != null) {
                    interfaceC1617a.onCompletion();
                }
                this.f21700b.release();
            }
        }

        @Override // c.a.v0.q.a.InterfaceC1617a
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onError i = ");
                sb.append(i);
                sb.append(" i1 = ");
                sb.append(i2);
                sb.append(" o ");
                sb.append(obj != null ? obj.toString() : " null ");
                c.a.v0.r.c.j("FFmpegCmdExecutor-concat", sb.toString());
                a.InterfaceC1617a interfaceC1617a = this.a;
                if (interfaceC1617a != null) {
                    interfaceC1617a.onError(i, i2, obj);
                }
                this.f21700b.release();
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // c.a.v0.q.a.InterfaceC1617a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onInfo i = ");
                sb.append(i);
                sb.append(" i1 = ");
                sb.append(i2);
                sb.append(" o ");
                sb.append(obj != null ? obj.toString() : " null ");
                c.a.v0.r.c.j("FFmpegCmdExecutor-concat", sb.toString());
                a.InterfaceC1617a interfaceC1617a = this.a;
                if (interfaceC1617a != null) {
                    interfaceC1617a.onInfo(i, i2, obj);
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements a.InterfaceC1617a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.InterfaceC1617a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.v0.q.a f21703b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f21704c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f21705d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f21706e;

        public e(a.InterfaceC1617a interfaceC1617a, c.a.v0.q.a aVar, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC1617a, aVar, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = interfaceC1617a;
            this.f21703b = aVar;
            this.f21704c = str;
            this.f21705d = str2;
            this.f21706e = str3;
        }

        @Override // c.a.v0.q.a.InterfaceC1617a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.v0.r.c.e("FFmpegCmdExecutor-muxAudioVideo", "onCompletion:video:" + this.f21704c + ",audio" + this.f21705d + ",:dest:" + this.f21706e);
                a.InterfaceC1617a interfaceC1617a = this.a;
                if (interfaceC1617a != null) {
                    interfaceC1617a.onCompletion();
                }
                c.a.v0.r.c.e("FFmpegCmdExecutor-muxAudioVideo", "release");
                this.f21703b.release();
            }
        }

        @Override // c.a.v0.q.a.InterfaceC1617a
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onError i = ");
                sb.append(i);
                sb.append(" i1 = ");
                sb.append(i2);
                sb.append(" o ");
                sb.append(obj != null ? obj.toString() : " null ");
                c.a.v0.r.c.e("FFmpegCmdExecutor-muxAudioVideo", sb.toString());
                a.InterfaceC1617a interfaceC1617a = this.a;
                if (interfaceC1617a != null) {
                    interfaceC1617a.onError(i, i2, obj);
                }
                c.a.v0.r.c.e("FFmpegCmdExecutor-muxAudioVideo", "release");
                this.f21703b.release();
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // c.a.v0.q.a.InterfaceC1617a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onInfo i = ");
                sb.append(i);
                sb.append(" i1 = ");
                sb.append(i2);
                sb.append(" o ");
                sb.append(obj != null ? obj.toString() : " null ");
                c.a.v0.r.c.e("FFmpegCmdExecutor-muxAudioVideo", sb.toString());
                a.InterfaceC1617a interfaceC1617a = this.a;
                if (interfaceC1617a != null) {
                    interfaceC1617a.onInfo(i, i2, obj);
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* renamed from: c.a.v0.l.d.f$f  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1606f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f21707b;

        /* renamed from: c  reason: collision with root package name */
        public int f21708c;

        /* renamed from: d  reason: collision with root package name */
        public String f21709d;

        /* renamed from: e  reason: collision with root package name */
        public int f21710e;

        public C1606f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 48000;
            this.f21707b = 1;
            this.f21708c = 16;
            this.f21710e = 0;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i = this.f21710e;
                return i == 5 || i == 6 || i == 8 || i == 9;
            }
            return invokeV.booleanValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i = this.f21710e;
                return i == 3 || i == 4 || i == 8 || i == 9;
            }
            return invokeV.booleanValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i = this.f21710e;
                return i == 1 || i == 4 || i == 6 || i == 9;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(995923570, "Lc/a/v0/l/d/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(995923570, "Lc/a/v0/l/d/f;");
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

    public static void b(List<String> list, String str, String str2, a.InterfaceC1617a interfaceC1617a, boolean z, boolean z2) {
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{list, str, str2, interfaceC1617a, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            c.a.v0.q.a aVar = (c.a.v0.q.a) s.a("com.baidu.ugc.api.ffmpeg.MFFmpegCmdExecutor");
            if (c.a.v0.r.h.e(list)) {
                if (interfaceC1617a != null) {
                    interfaceC1617a.onError(-1, -1, "input list null");
                }
            } else if (aVar == null) {
                if (interfaceC1617a != null) {
                    interfaceC1617a.onError(-1, -1, "can not find MFFmpegCmdExecutor");
                }
            } else {
                aVar.setListener(new d(interfaceC1617a, aVar, list, str));
                if (TextUtils.isEmpty(str2)) {
                    file = new File(FileUtils.removeExtention(str) + System.currentTimeMillis() + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION);
                } else {
                    String fileNameWithOutExtention = FileUtils.getFileNameWithOutExtention(str);
                    file = new File(str2 + fileNameWithOutExtention + System.currentTimeMillis() + "concat.txt");
                }
                c.a.v0.r.c.j("FFmpegCmdExecutor-concat", "inputfilename:" + file.getPath());
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
                c.a.v0.r.c.e("FFmpegCmdExecutor-mixAudio", "start");
                aVar.start();
            }
        }
    }

    public static byte[] c(int i, int i2, byte[] bArr) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65539, null, i, i2, bArr)) == null) {
            c.a.v0.r.c.b("convertByteWidth sourceByteWidth = " + i + " outputByteWidth = " + i2);
            if (i == i2) {
                return bArr;
            }
            int length = bArr.length;
            if (i != 1) {
                if (i == 2 && i2 == 1) {
                    int i3 = length / 2;
                    byte[] bArr2 = new byte[i3];
                    for (int i4 = 0; i4 < i3; i4++) {
                        int i5 = i4 * 2;
                        bArr2[i4] = (byte) (h(bArr[i5], bArr[i5 + 1], a) / 256);
                    }
                    return bArr2;
                }
            } else if (i2 == 2) {
                byte[] bArr3 = new byte[length * 2];
                for (int i6 = 0; i6 < length; i6++) {
                    byte[] f2 = f((short) (bArr[i6] * 256), a);
                    int i7 = i6 * 2;
                    bArr3[i7] = f2[0];
                    bArr3[i7 + 1] = f2[1];
                }
                return bArr3;
            }
            return bArr;
        }
        return (byte[]) invokeIIL.objValue;
    }

    public static byte[] d(int i, int i2, int i3, byte[] bArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), bArr})) == null) {
            c.a.v0.r.c.b("convertChannelCount sourceChannelCount = " + i + " outputChannelCount = " + i2);
            if (i == i2) {
                return bArr;
            }
            if (i3 == 1 || i3 == 2) {
                int length = bArr.length;
                int i4 = 0;
                if (i != 1) {
                    if (i == 2 && i2 == 1) {
                        int i5 = length / 2;
                        byte[] bArr2 = new byte[i5];
                        if (i3 == 1) {
                            while (i4 < i5) {
                                int i6 = i4 * 2;
                                bArr2[i4] = (byte) (((short) (bArr[i6] + bArr[i6 + 1])) >> 1);
                                i4 += 2;
                            }
                        } else if (i3 == 2) {
                            for (int i7 = 0; i7 < i5; i7 += 2) {
                                int i8 = i7 * 2;
                                byte[] a2 = a(bArr[i8], bArr[i8 + 1], bArr[i8 + 2], bArr[i8 + 3], a);
                                bArr2[i7] = a2[0];
                                bArr2[i7 + 1] = a2[1];
                            }
                        }
                        return bArr2;
                    }
                } else if (i2 == 2) {
                    byte[] bArr3 = new byte[length * 2];
                    if (i3 == 1) {
                        while (i4 < length) {
                            byte b2 = bArr[i4];
                            int i9 = i4 * 2;
                            bArr3[i9] = b2;
                            bArr3[i9 + 1] = b2;
                            i4++;
                        }
                    } else if (i3 == 2) {
                        while (i4 < length) {
                            byte b3 = bArr[i4];
                            byte b4 = bArr[i4 + 1];
                            int i10 = i4 * 2;
                            bArr3[i10] = b3;
                            bArr3[i10 + 1] = b4;
                            bArr3[i10 + 2] = b3;
                            bArr3[i10 + 3] = b4;
                            i4 += 2;
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
    public static C1606f e(String str) {
        InterceptResult invokeL;
        MediaFormat mediaFormat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            MediaExtractor mediaExtractor = new MediaExtractor();
            try {
                mediaExtractor.setDataSource(str);
                int i = 0;
                while (true) {
                    if (i >= mediaExtractor.getTrackCount()) {
                        mediaFormat = null;
                        break;
                    }
                    mediaFormat = mediaExtractor.getTrackFormat(i);
                    if (mediaFormat.getString("mime").startsWith("audio/")) {
                        mediaExtractor.selectTrack(i);
                        break;
                    }
                    i++;
                }
                if (mediaFormat == null) {
                    mediaExtractor.release();
                    return null;
                }
                C1606f c1606f = new C1606f();
                c1606f.f21709d = mediaFormat.getString("mime");
                c1606f.a = mediaFormat.containsKey("sample-rate") ? mediaFormat.getInteger("sample-rate") : 48000;
                c1606f.f21707b = mediaFormat.containsKey("channel-count") ? mediaFormat.getInteger("channel-count") : 1;
                c1606f.f21708c = mediaFormat.containsKey("bit-width") ? mediaFormat.getInteger("bit-width") : 16;
                mediaExtractor.release();
                return c1606f;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C1606f) invokeL.objValue;
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

    public static boolean i(C1606f... c1606fArr) {
        InterceptResult invokeL;
        C1606f c1606f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, c1606fArr)) == null) {
            if (c1606fArr == null || c1606fArr.length < 2 || (c1606f = c1606fArr[0]) == null) {
                return false;
            }
            boolean z = true;
            for (int i = 1; i < c1606fArr.length; i++) {
                if (c1606f.a != c1606fArr[i].a) {
                    c1606fArr[i].f21710e++;
                    z = false;
                }
                if (c1606f.f21707b != c1606fArr[i].f21707b) {
                    c1606fArr[i].f21710e += 3;
                    z = false;
                }
                if (c1606f.f21708c != c1606fArr[i].f21708c) {
                    c1606fArr[i].f21710e += 5;
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static void j(String str, String str2, String str3, int i, a.InterfaceC1617a interfaceC1617a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, str2, str3, Integer.valueOf(i), interfaceC1617a}) == null) {
            c.a.v0.q.a aVar = (c.a.v0.q.a) s.a("com.baidu.ugc.api.ffmpeg.MFFmpegCmdExecutor");
            if (aVar == null) {
                if (interfaceC1617a != null) {
                    interfaceC1617a.onError(-1, -1, "can not find MFFmpegCmdExecutor");
                    return;
                }
                return;
            }
            c.a.v0.r.c.e("FFmpegCmdExecutor-mixAudio", "new mixAudio");
            aVar.setListener(new b(interfaceC1617a, aVar, str, str2, str3));
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("-i");
            arrayList.add(str);
            arrayList.add("-i");
            arrayList.add(str2);
            arrayList.add("-filter_complex");
            arrayList.add("[0:a] [1:a]amerge=inputs=2[aout]");
            arrayList.add("-map");
            arrayList.add("[aout]");
            if (i > 0) {
                arrayList.add("-ac");
                arrayList.add(String.valueOf(i));
            }
            arrayList.add(str3);
            aVar.setSource(arrayList);
            aVar.start();
        }
    }

    public static void k(List<String> list, String str, int i, a.InterfaceC1617a interfaceC1617a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65547, null, list, str, i, interfaceC1617a) == null) {
            if (c.a.v0.r.h.b(list) == 2) {
                j(list.get(0), list.get(1), str, i, interfaceC1617a);
                return;
            }
            c.a.v0.q.a aVar = (c.a.v0.q.a) s.a("com.baidu.ugc.api.ffmpeg.MFFmpegCmdExecutor");
            if (aVar == null) {
                if (interfaceC1617a != null) {
                    interfaceC1617a.onError(-1, -1, "can not find MFFmpegCmdExecutor");
                    return;
                }
                return;
            }
            aVar.setListener(new c(interfaceC1617a, aVar));
            ArrayList<String> arrayList = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            int i2 = 0;
            for (String str2 : list) {
                arrayList.add("-i");
                arrayList.add(str2);
                sb.append(PreferencesUtil.LEFT_MOUNT);
                sb.append(i2);
                sb.append(":a]volume=1");
                sb.append(PreferencesUtil.LEFT_MOUNT);
                sb.append("a");
                i2++;
                sb.append(i2);
                sb.append("];");
                sb2.append(PreferencesUtil.LEFT_MOUNT);
                sb2.append("a");
                sb2.append(i2);
                sb2.append(PreferencesUtil.RIGHT_MOUNT);
            }
            arrayList.add("-filter_complex");
            arrayList.add(String.format("%s%samix=inputs=%s[aout]", sb.toString(), sb2.toString(), Integer.valueOf(list.size())));
            arrayList.add("-map");
            arrayList.add("[aout]");
            if (i > 0) {
                arrayList.add("-ac");
                arrayList.add(String.valueOf(i));
            }
            arrayList.add(str);
            aVar.setSource(arrayList);
            aVar.start();
        }
    }

    public static void l(String str, String str2, int i, int i2, float f2, int i3, float f3, float f4, boolean z, a.InterfaceC1617a interfaceC1617a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3), Float.valueOf(f3), Float.valueOf(f4), Boolean.valueOf(z), interfaceC1617a}) == null) {
            float f5 = f3 * 1000.0f;
            if (r9 < (f4 * 1000.0f) + f5 || f4 <= 0.0f) {
                f4 = (r9 - f5) / 1000.0f;
            }
            c.a.v0.r.c.c(VLogMultiAudioMixer.TAG, "modifyAudioProperty - duration" + f4);
            c.a.v0.q.a aVar = (c.a.v0.q.a) s.a("com.baidu.ugc.api.ffmpeg.MFFmpegCmdExecutor");
            c.a.v0.r.c.e("FFmpegCmdExecutor-modifyAudioProperty", "MFFmpegCmdExecutor modifyAudioProperty new");
            if (aVar == null) {
                if (interfaceC1617a != null) {
                    interfaceC1617a.onError(-1, -1, "can not find MFFmpegCmdExecutor");
                    return;
                }
                return;
            }
            aVar.setListener(new a(interfaceC1617a, aVar, str, str2));
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("-i");
            arrayList.add(str);
            if (f4 > 0.0f) {
                arrayList.add("-ss");
                arrayList.add(String.valueOf(f3));
                arrayList.add("-t");
                arrayList.add(String.valueOf(f4));
            }
            if (i > 0) {
                arrayList.add("-ar");
                arrayList.add(String.valueOf(i));
            }
            if (i2 > 0) {
                arrayList.add("-ac");
                arrayList.add(String.valueOf(i2));
            }
            if (f2 >= 0.0f) {
                arrayList.add("-af");
                arrayList.add("volume=" + f2);
            }
            arrayList.add("-acodec");
            arrayList.add("aac");
            arrayList.add(str2);
            aVar.setSource(arrayList);
            c.a.v0.r.c.e("FFmpegCmdExecutor-modifyAudioProperty", "start");
            aVar.start();
        }
    }

    public static void m(String str, String str2, String str3, a.InterfaceC1617a interfaceC1617a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65549, null, str, str2, str3, interfaceC1617a) == null) {
            c.a.v0.q.a aVar = (c.a.v0.q.a) s.a("com.baidu.ugc.api.ffmpeg.MFFmpegCmdExecutor");
            if (aVar == null) {
                if (interfaceC1617a != null) {
                    interfaceC1617a.onError(-1, -1, "can not find MFFmpegCmdExecutor");
                    return;
                }
                return;
            }
            aVar.setListener(new e(interfaceC1617a, aVar, str, str2, str3));
            long b2 = x.b(str2);
            long f2 = x.f(str);
            c.a.v0.r.c.j("VideoMuxer", "muxAudioVideo,audioduration:" + b2 + ",videoDuration:" + f2);
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
            c.a.v0.r.c.e("FFmpegCmdExecutor-muxAudioVideo", "start");
            aVar.start();
        }
    }

    public static boolean n(String str, String str2, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65550, null, str, str2, i, i2)) == null) {
            if (i2 == i) {
                return false;
            }
            File file = new File(str);
            File file2 = new File(str2);
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                new h(fileInputStream, fileOutputStream, i, i2, 2, 2, 1, Integer.MAX_VALUE, 0.0d, 0, true);
                fileInputStream.close();
                fileOutputStream.close();
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                c.a.v0.r.c.e("MediaUtils", "resamplefail:" + e2.getMessage());
                return false;
            }
        }
        return invokeLLII.booleanValue;
    }
}
