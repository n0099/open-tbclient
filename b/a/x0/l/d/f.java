package b.a.x0.l.d;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.x0.s.a;
import b.a.x0.t.s;
import b.a.x0.t.x;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes6.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f29710a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements a.InterfaceC1439a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC1439a f29711a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.x0.s.a f29712b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f29713c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f29714d;

        public a(a.InterfaceC1439a interfaceC1439a, b.a.x0.s.a aVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC1439a, aVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29711a = interfaceC1439a;
            this.f29712b = aVar;
            this.f29713c = str;
            this.f29714d = str2;
        }

        @Override // b.a.x0.s.a.InterfaceC1439a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.x0.t.c.e("FFmpegCmdExecutor-modifyAudioProperty", "onCompletion:src:" + this.f29713c + ",:dest:" + this.f29714d);
                a.InterfaceC1439a interfaceC1439a = this.f29711a;
                if (interfaceC1439a != null) {
                    interfaceC1439a.onCompletion();
                }
                b.a.x0.t.c.e("FFmpegCmdExecutor-modifyAudioProperty", "release");
                this.f29712b.release();
            }
        }

        @Override // b.a.x0.s.a.InterfaceC1439a
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
                b.a.x0.t.c.e("FFmpegCmdExecutor-modifyAudioProperty", sb.toString());
                a.InterfaceC1439a interfaceC1439a = this.f29711a;
                if (interfaceC1439a != null) {
                    interfaceC1439a.onError(i2, i3, obj);
                }
                b.a.x0.t.c.e("FFmpegCmdExecutor-modifyAudioProperty", "release");
                this.f29712b.release();
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // b.a.x0.s.a.InterfaceC1439a
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
                b.a.x0.t.c.j("FFmpegCmdExecutor-modifyAudioProperty", sb.toString());
                a.InterfaceC1439a interfaceC1439a = this.f29711a;
                if (interfaceC1439a != null) {
                    interfaceC1439a.onInfo(i2, i3, obj);
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements a.InterfaceC1439a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC1439a f29715a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.x0.s.a f29716b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f29717c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f29718d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f29719e;

        public b(a.InterfaceC1439a interfaceC1439a, b.a.x0.s.a aVar, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC1439a, aVar, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29715a = interfaceC1439a;
            this.f29716b = aVar;
            this.f29717c = str;
            this.f29718d = str2;
            this.f29719e = str3;
        }

        @Override // b.a.x0.s.a.InterfaceC1439a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.x0.t.c.e("FFmpegCmdExecutor-mixAudio", "onCompletion:src:" + this.f29717c + "," + this.f29718d + ",:dest:" + this.f29719e);
                a.InterfaceC1439a interfaceC1439a = this.f29715a;
                if (interfaceC1439a != null) {
                    interfaceC1439a.onCompletion();
                }
                b.a.x0.t.c.e("FFmpegCmdExecutor-mixAudio", "release");
                this.f29716b.release();
            }
        }

        @Override // b.a.x0.s.a.InterfaceC1439a
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
                b.a.x0.t.c.e("FFmpegCmdExecutor-mixAudio", sb.toString());
                a.InterfaceC1439a interfaceC1439a = this.f29715a;
                if (interfaceC1439a != null) {
                    interfaceC1439a.onError(i2, i3, obj);
                }
                b.a.x0.t.c.e("FFmpegCmdExecutor-mixAudio", "release");
                this.f29716b.release();
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // b.a.x0.s.a.InterfaceC1439a
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
                b.a.x0.t.c.e("FFmpegCmdExecutor-mixAudio", sb.toString());
                a.InterfaceC1439a interfaceC1439a = this.f29715a;
                if (interfaceC1439a != null) {
                    interfaceC1439a.onInfo(i2, i3, obj);
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements a.InterfaceC1439a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC1439a f29720a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.x0.s.a f29721b;

        public c(a.InterfaceC1439a interfaceC1439a, b.a.x0.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC1439a, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29720a = interfaceC1439a;
            this.f29721b = aVar;
        }

        @Override // b.a.x0.s.a.InterfaceC1439a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.InterfaceC1439a interfaceC1439a = this.f29720a;
                if (interfaceC1439a != null) {
                    interfaceC1439a.onCompletion();
                }
                this.f29721b.release();
            }
        }

        @Override // b.a.x0.s.a.InterfaceC1439a
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
                b.a.x0.t.c.e("FFmpegCmdExecutor-mixAudio", sb.toString());
                a.InterfaceC1439a interfaceC1439a = this.f29720a;
                if (interfaceC1439a != null) {
                    interfaceC1439a.onError(i2, i3, obj);
                }
                this.f29721b.release();
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // b.a.x0.s.a.InterfaceC1439a
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
                b.a.x0.t.c.j("FFmpegCmdExecutor-mixAudio", sb.toString());
                a.InterfaceC1439a interfaceC1439a = this.f29720a;
                if (interfaceC1439a != null) {
                    interfaceC1439a.onInfo(i2, i3, obj);
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements a.InterfaceC1439a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC1439a f29722a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.x0.s.a f29723b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f29724c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f29725d;

        public d(a.InterfaceC1439a interfaceC1439a, b.a.x0.s.a aVar, List list, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC1439a, aVar, list, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29722a = interfaceC1439a;
            this.f29723b = aVar;
            this.f29724c = list;
            this.f29725d = str;
        }

        @Override // b.a.x0.s.a.InterfaceC1439a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.x0.t.c.j("FFmpegCmdExecutor-concat", "onCompletion:inputsize:" + this.f29724c.size() + ",dest:" + this.f29725d);
                a.InterfaceC1439a interfaceC1439a = this.f29722a;
                if (interfaceC1439a != null) {
                    interfaceC1439a.onCompletion();
                }
                this.f29723b.release();
            }
        }

        @Override // b.a.x0.s.a.InterfaceC1439a
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
                b.a.x0.t.c.j("FFmpegCmdExecutor-concat", sb.toString());
                a.InterfaceC1439a interfaceC1439a = this.f29722a;
                if (interfaceC1439a != null) {
                    interfaceC1439a.onError(i2, i3, obj);
                }
                this.f29723b.release();
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // b.a.x0.s.a.InterfaceC1439a
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
                b.a.x0.t.c.j("FFmpegCmdExecutor-concat", sb.toString());
                a.InterfaceC1439a interfaceC1439a = this.f29722a;
                if (interfaceC1439a != null) {
                    interfaceC1439a.onInfo(i2, i3, obj);
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements a.InterfaceC1439a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC1439a f29726a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.x0.s.a f29727b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f29728c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f29729d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f29730e;

        public e(a.InterfaceC1439a interfaceC1439a, b.a.x0.s.a aVar, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC1439a, aVar, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29726a = interfaceC1439a;
            this.f29727b = aVar;
            this.f29728c = str;
            this.f29729d = str2;
            this.f29730e = str3;
        }

        @Override // b.a.x0.s.a.InterfaceC1439a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.x0.t.c.e("FFmpegCmdExecutor-muxAudioVideo", "onCompletion:video:" + this.f29728c + ",audio" + this.f29729d + ",:dest:" + this.f29730e);
                a.InterfaceC1439a interfaceC1439a = this.f29726a;
                if (interfaceC1439a != null) {
                    interfaceC1439a.onCompletion();
                }
                b.a.x0.t.c.e("FFmpegCmdExecutor-muxAudioVideo", "release");
                this.f29727b.release();
            }
        }

        @Override // b.a.x0.s.a.InterfaceC1439a
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
                b.a.x0.t.c.e("FFmpegCmdExecutor-muxAudioVideo", sb.toString());
                a.InterfaceC1439a interfaceC1439a = this.f29726a;
                if (interfaceC1439a != null) {
                    interfaceC1439a.onError(i2, i3, obj);
                }
                b.a.x0.t.c.e("FFmpegCmdExecutor-muxAudioVideo", "release");
                this.f29727b.release();
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // b.a.x0.s.a.InterfaceC1439a
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
                b.a.x0.t.c.e("FFmpegCmdExecutor-muxAudioVideo", sb.toString());
                a.InterfaceC1439a interfaceC1439a = this.f29726a;
                if (interfaceC1439a != null) {
                    interfaceC1439a.onInfo(i2, i3, obj);
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* renamed from: b.a.x0.l.d.f$f  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1428f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f29731a;

        /* renamed from: b  reason: collision with root package name */
        public int f29732b;

        /* renamed from: c  reason: collision with root package name */
        public int f29733c;

        /* renamed from: d  reason: collision with root package name */
        public String f29734d;

        /* renamed from: e  reason: collision with root package name */
        public int f29735e;

        public C1428f() {
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
            this.f29731a = MediaEncodeParams.AUDIO_SAMPLE_RATE;
            this.f29732b = 1;
            this.f29733c = 16;
            this.f29735e = 0;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = this.f29735e;
                return i2 == 5 || i2 == 6 || i2 == 8 || i2 == 9;
            }
            return invokeV.booleanValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i2 = this.f29735e;
                return i2 == 3 || i2 == 4 || i2 == 8 || i2 == 9;
            }
            return invokeV.booleanValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i2 = this.f29735e;
                return i2 == 1 || i2 == 4 || i2 == 6 || i2 == 9;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1969384947, "Lb/a/x0/l/d/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1969384947, "Lb/a/x0/l/d/f;");
                return;
            }
        }
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            f29710a = true;
        } else {
            f29710a = false;
        }
    }

    public static byte[] a(byte b2, byte b3, byte b4, byte b5, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Byte.valueOf(b2), Byte.valueOf(b3), Byte.valueOf(b4), Byte.valueOf(b5), Boolean.valueOf(z)})) == null) ? f((short) ((h(b2, b3, z) / 2) + (h(b4, b5, z) / 2)), z) : (byte[]) invokeCommon.objValue;
    }

    public static void b(List<String> list, String str, String str2, a.InterfaceC1439a interfaceC1439a, boolean z, boolean z2) {
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{list, str, str2, interfaceC1439a, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            b.a.x0.s.a aVar = (b.a.x0.s.a) s.a("com.baidu.ugc.api.ffmpeg.MFFmpegCmdExecutor");
            if (b.a.x0.t.h.e(list)) {
                if (interfaceC1439a != null) {
                    interfaceC1439a.onError(-1, -1, "input list null");
                }
            } else if (aVar == null) {
                if (interfaceC1439a != null) {
                    interfaceC1439a.onError(-1, -1, "can not find MFFmpegCmdExecutor");
                }
            } else {
                aVar.setListener(new d(interfaceC1439a, aVar, list, str));
                if (TextUtils.isEmpty(str2)) {
                    file = new File(FileUtils.removeExtention(str) + System.currentTimeMillis() + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION);
                } else {
                    String fileNameWithOutExtention = FileUtils.getFileNameWithOutExtention(str);
                    file = new File(str2 + fileNameWithOutExtention + System.currentTimeMillis() + "concat.txt");
                }
                b.a.x0.t.c.j("FFmpegCmdExecutor-concat", "inputfilename:" + file.getPath());
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
                b.a.x0.t.c.e("FFmpegCmdExecutor-mixAudio", "start");
                aVar.start();
            }
        }
    }

    public static byte[] c(int i2, int i3, byte[] bArr) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65539, null, i2, i3, bArr)) == null) {
            b.a.x0.t.c.b("convertByteWidth sourceByteWidth = " + i2 + " outputByteWidth = " + i3);
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
                        bArr2[i5] = (byte) (h(bArr[i6], bArr[i6 + 1], f29710a) / 256);
                    }
                    return bArr2;
                }
            } else if (i3 == 2) {
                byte[] bArr3 = new byte[length * 2];
                for (int i7 = 0; i7 < length; i7++) {
                    byte[] f2 = f((short) (bArr[i7] * 256), f29710a);
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
            b.a.x0.t.c.b("convertChannelCount sourceChannelCount = " + i2 + " outputChannelCount = " + i3);
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
                                byte[] a2 = a(bArr[i9], bArr[i9 + 1], bArr[i9 + 2], bArr[i9 + 3], f29710a);
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
    public static C1428f e(String str) {
        InterceptResult invokeL;
        MediaFormat mediaFormat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
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
                C1428f c1428f = new C1428f();
                c1428f.f29734d = mediaFormat.getString("mime");
                c1428f.f29731a = mediaFormat.containsKey("sample-rate") ? mediaFormat.getInteger("sample-rate") : MediaEncodeParams.AUDIO_SAMPLE_RATE;
                c1428f.f29732b = mediaFormat.containsKey("channel-count") ? mediaFormat.getInteger("channel-count") : 1;
                c1428f.f29733c = mediaFormat.containsKey("bit-width") ? mediaFormat.getInteger("bit-width") : 16;
                mediaExtractor.release();
                return c1428f;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C1428f) invokeL.objValue;
    }

    public static byte[] f(short s, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{Short.valueOf(s), Boolean.valueOf(z)})) == null) {
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

    public static boolean i(C1428f... c1428fArr) {
        InterceptResult invokeL;
        C1428f c1428f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, c1428fArr)) == null) {
            if (c1428fArr == null || c1428fArr.length < 2 || (c1428f = c1428fArr[0]) == null) {
                return false;
            }
            boolean z = true;
            for (int i2 = 1; i2 < c1428fArr.length; i2++) {
                if (c1428f.f29731a != c1428fArr[i2].f29731a) {
                    c1428fArr[i2].f29735e++;
                    z = false;
                }
                if (c1428f.f29732b != c1428fArr[i2].f29732b) {
                    c1428fArr[i2].f29735e += 3;
                    z = false;
                }
                if (c1428f.f29733c != c1428fArr[i2].f29733c) {
                    c1428fArr[i2].f29735e += 5;
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static void j(String str, String str2, String str3, int i2, a.InterfaceC1439a interfaceC1439a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, str2, str3, Integer.valueOf(i2), interfaceC1439a}) == null) {
            b.a.x0.s.a aVar = (b.a.x0.s.a) s.a("com.baidu.ugc.api.ffmpeg.MFFmpegCmdExecutor");
            if (aVar == null) {
                if (interfaceC1439a != null) {
                    interfaceC1439a.onError(-1, -1, "can not find MFFmpegCmdExecutor");
                    return;
                }
                return;
            }
            b.a.x0.t.c.e("FFmpegCmdExecutor-mixAudio", "new mixAudio");
            aVar.setListener(new b(interfaceC1439a, aVar, str, str2, str3));
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

    public static void k(List<String> list, String str, int i2, a.InterfaceC1439a interfaceC1439a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65547, null, list, str, i2, interfaceC1439a) == null) {
            if (b.a.x0.t.h.b(list) == 2) {
                j(list.get(0), list.get(1), str, i2, interfaceC1439a);
                return;
            }
            b.a.x0.s.a aVar = (b.a.x0.s.a) s.a("com.baidu.ugc.api.ffmpeg.MFFmpegCmdExecutor");
            if (aVar == null) {
                if (interfaceC1439a != null) {
                    interfaceC1439a.onError(-1, -1, "can not find MFFmpegCmdExecutor");
                    return;
                }
                return;
            }
            aVar.setListener(new c(interfaceC1439a, aVar));
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

    public static void l(String str, String str2, int i2, int i3, float f2, int i4, float f3, float f4, boolean z, a.InterfaceC1439a interfaceC1439a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4), Float.valueOf(f3), Float.valueOf(f4), Boolean.valueOf(z), interfaceC1439a}) == null) {
            float f5 = f3 * 1000.0f;
            if (r9 < (f4 * 1000.0f) + f5 || f4 <= 0.0f) {
                f4 = (r9 - f5) / 1000.0f;
            }
            b.a.x0.t.c.c(VLogMultiAudioMixer.TAG, "modifyAudioProperty - duration" + f4);
            b.a.x0.s.a aVar = (b.a.x0.s.a) s.a("com.baidu.ugc.api.ffmpeg.MFFmpegCmdExecutor");
            b.a.x0.t.c.e("FFmpegCmdExecutor-modifyAudioProperty", "MFFmpegCmdExecutor modifyAudioProperty new");
            if (aVar == null) {
                if (interfaceC1439a != null) {
                    interfaceC1439a.onError(-1, -1, "can not find MFFmpegCmdExecutor");
                    return;
                }
                return;
            }
            aVar.setListener(new a(interfaceC1439a, aVar, str, str2));
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
            b.a.x0.t.c.e("FFmpegCmdExecutor-modifyAudioProperty", "start");
            aVar.start();
        }
    }

    public static void m(String str, String str2, String str3, a.InterfaceC1439a interfaceC1439a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65549, null, str, str2, str3, interfaceC1439a) == null) {
            b.a.x0.s.a aVar = (b.a.x0.s.a) s.a("com.baidu.ugc.api.ffmpeg.MFFmpegCmdExecutor");
            if (aVar == null) {
                if (interfaceC1439a != null) {
                    interfaceC1439a.onError(-1, -1, "can not find MFFmpegCmdExecutor");
                    return;
                }
                return;
            }
            aVar.setListener(new e(interfaceC1439a, aVar, str, str2, str3));
            long b2 = x.b(str2);
            long f2 = x.f(str);
            b.a.x0.t.c.j("VideoMuxer", "muxAudioVideo,audioduration:" + b2 + ",videoDuration:" + f2);
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
            b.a.x0.t.c.e("FFmpegCmdExecutor-muxAudioVideo", "start");
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
                b.a.x0.t.c.e("MediaUtils", "resamplefail:" + e2.getMessage());
                return false;
            }
        }
        return invokeLLII.booleanValue;
    }
}
