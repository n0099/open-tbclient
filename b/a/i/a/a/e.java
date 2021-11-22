package b.a.i.a.a;

import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.q.g;
import b.a.e.f.q.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.voice.service.MediaService;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class e implements b.a.r0.m3.r0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.e.f.q.f f3034a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f3035b;

    /* renamed from: c  reason: collision with root package name */
    public String f3036c;

    /* renamed from: d  reason: collision with root package name */
    public g f3037d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f3038e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f3039f;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f3040e;

        public a(e eVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3040e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.q0.s.h0.a.a(b.a.q0.s.h0.a.b(this.f3040e));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f3041e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f3042f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f3043g;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f3044e;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f3044e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    e eVar = this.f3044e.f3043g;
                    eVar.f3034a.onShowErr(4, eVar.f3039f.getString(R.string.voice_error_file_md5));
                    h.f2078a = 1;
                }
            }
        }

        /* renamed from: b.a.i.a.a.e$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0072b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f3045e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f3046f;

            public RunnableC0072b(b bVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f3046f = bVar;
                this.f3045e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    h.f2078a = 1;
                    b bVar = this.f3046f;
                    bVar.f3043g.f3034a.onSendVoice(this.f3045e, bVar.f3042f);
                }
            }
        }

        public b(e eVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3043g = eVar;
            this.f3041e = str;
            this.f3042f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = b.a.q0.s.h0.b.b.c(b.a.q0.s.h0.a.d(this.f3041e)).f13876a;
                if (this.f3043g.f3035b != null) {
                    this.f3043g.f3035b.removeCallbacks(this.f3043g.f3038e);
                    if (StringUtils.isNull(str)) {
                        this.f3043g.f3035b.post(new a(this));
                    } else {
                        this.f3043g.f3035b.post(new RunnableC0072b(this, str));
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f3047e;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3047e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.a.e.f.q.f fVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (fVar = this.f3047e.f3034a) != null && h.f2078a == 2) {
                fVar.onStopingRecorder();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f3048a;

        public d(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3048a = eVar;
        }

        @Override // b.a.e.f.q.g
        public void a(int i2) {
            b.a.e.f.q.f fVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (fVar = this.f3048a.f3034a) == null) {
                return;
            }
            fVar.onShowRecordTime(i2 / 1000);
        }

        @Override // b.a.e.f.q.e
        public void b(int i2) {
            b.a.e.f.q.f fVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (fVar = this.f3048a.f3034a) == null) {
                return;
            }
            fVar.onShowRecording(i2);
        }

        @Override // b.a.e.f.q.e
        public void c(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2) == null) {
                this.f3048a.n();
                h.f2078a = 1;
                if (this.f3048a.f3036c != null && str != null) {
                    e eVar = this.f3048a;
                    b.a.e.f.q.f fVar = eVar.f3034a;
                    if (fVar == null) {
                        return;
                    }
                    if (i2 > 1000) {
                        if (!str.endsWith(eVar.f3036c)) {
                            FieldBuilder fieldBuilder = new FieldBuilder();
                            fieldBuilder.append("file", str);
                            fieldBuilder.append("dur", Integer.valueOf(i2));
                            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", fieldBuilder.toString());
                            return;
                        }
                        e eVar2 = this.f3048a;
                        eVar2.l(eVar2.f3036c, (int) Math.round((i2 * 1.0d) / 1000.0d));
                        this.f3048a.f3036c = null;
                        return;
                    }
                    fVar.onShowErr(2, h.a(R.string.voice_record_short_tip));
                    FieldBuilder fieldBuilder2 = new FieldBuilder();
                    fieldBuilder2.append("file", str);
                    fieldBuilder2.append("dur", Integer.valueOf(i2));
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_LEN, "voice too short", fieldBuilder2.toString());
                    return;
                }
                FieldBuilder fieldBuilder3 = new FieldBuilder();
                fieldBuilder3.append("file", str);
                fieldBuilder3.append("dur", Integer.valueOf(i2));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", fieldBuilder3.toString());
            }
        }

        @Override // b.a.e.f.q.g
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                h.f2078a = 1;
            }
        }

        @Override // b.a.e.f.q.e
        public void error(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) {
                this.f3048a.n();
                TiebaStatic.voiceError(i2, "RecoreCallback.error: " + str, "");
                e eVar = this.f3048a;
                if (eVar.f3034a == null) {
                    h.f2078a = 1;
                } else if (i2 == 7) {
                    if (eVar.f3036c == null) {
                        TiebaStatic.voiceError(i2, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
                        return;
                    }
                    e eVar2 = this.f3048a;
                    eVar2.l(eVar2.f3036c, b.a.e.f.q.d.f2077a / 1000);
                    this.f3048a.f3036c = null;
                    e eVar3 = this.f3048a;
                    eVar3.f3034a.onShowErr(3, eVar3.f3039f.getString(R.string.voice_record_timeout_tip));
                } else {
                    h.f2078a = 1;
                    if (i2 == 8) {
                        i2 = 2;
                    }
                    this.f3048a.f3034a.onShowErr(i2, str);
                    TiebaStatic.voiceError(i2, "RecoreCallback.err: " + str, "");
                }
            }
        }

        public /* synthetic */ d(e eVar, a aVar) {
            this(eVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-651047361, "Lb/a/i/a/a/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-651047361, "Lb/a/i/a/a/e;");
                return;
            }
        }
        h.f2078a = 1;
    }

    public e() {
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
        this.f3036c = null;
        this.f3037d = null;
        this.f3038e = new c(this);
        this.f3035b = new Handler();
    }

    public static e m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? new e() : (e) invokeV.objValue;
    }

    @Override // b.a.r0.m3.r0.a
    public void a(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) {
            this.f3039f = tbPageContext;
        }
    }

    @Override // b.a.r0.m3.r0.a
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            stopRecord();
            p(false);
            b.a.e.f.q.f fVar = this.f3034a;
            if (fVar != null) {
                fVar.onDeletedVoice(str);
            }
            Handler handler = this.f3035b;
            if (handler == null) {
                return;
            }
            handler.postDelayed(new a(this, str), 200L);
        }
    }

    @Override // b.a.r0.m3.r0.a
    public boolean c(b.a.e.f.q.f fVar, int i2) {
        InterceptResult invokeLI;
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, fVar, i2)) == null) {
            if (fVar == null || (tbPageContext = this.f3039f) == null || !PermissionUtil.checkWriteExternalStorage(tbPageContext.getPageActivity())) {
                return false;
            }
            this.f3034a = fVar;
            if (!FileHelper.checkSD()) {
                String sdErrorString = FileHelper.getSdErrorString();
                if (sdErrorString == null) {
                    sdErrorString = h.a(R.string.voice_error_sdcard);
                }
                this.f3034a.onShowErr(0, sdErrorString);
                return false;
            }
            p(true);
            String e2 = b.a.q0.s.h0.a.e();
            this.f3036c = e2;
            String c2 = b.a.q0.s.h0.a.c(e2);
            if (this.f3037d == null) {
                this.f3037d = new d(this, null);
            }
            b.a.i.a.a.a.g();
            n();
            boolean f2 = b.a.i.a.a.a.f(c2, i2, this.f3037d);
            if (f2) {
                this.f3034a.onStartedRecorder(true);
                h.f2078a = 2;
            } else {
                h.f2078a = 1;
                b.a.i.a.a.a.g();
                FieldBuilder fieldBuilder = new FieldBuilder();
                fieldBuilder.append("voiceType", Integer.valueOf(i2));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", fieldBuilder.toString());
                this.f3034a.onStartedRecorder(false);
            }
            return f2;
        }
        return invokeLI.booleanValue;
    }

    @Override // b.a.r0.m3.r0.a
    public void cancelRecord() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.a.i.a.a.a.e();
        }
    }

    @Override // b.a.r0.m3.r0.a
    public void d(b.a.e.f.q.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            this.f3034a = fVar;
        }
    }

    @Override // b.a.r0.m3.r0.a
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h.f2078a == 1 : invokeV.booleanValue;
    }

    public final void l(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, str, i2) == null) || str == null || i2 < 1) {
            return;
        }
        h.f2078a = 3;
        new Thread(new b(this, str, i2)).start();
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            o();
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001273, Boolean.valueOf(z)));
        }
    }

    @Override // b.a.r0.m3.r0.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            stopRecord();
            TbPageContext<?> tbPageContext = this.f3039f;
            if (tbPageContext != null && tbPageContext.getPageActivity() != null) {
                MediaService.stopMy(this.f3039f.getPageActivity());
            }
            Handler handler = this.f3035b;
            if (handler != null) {
                handler.removeCallbacks(this.f3038e);
            }
            this.f3039f = null;
            this.f3034a = null;
            this.f3035b = null;
        }
    }

    @Override // b.a.r0.m3.r0.a
    public void stopRecord() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            b.a.i.a.a.a.g();
            Handler handler = this.f3035b;
            if (handler != null) {
                handler.postDelayed(this.f3038e, 100L);
            }
            n();
        }
    }
}
