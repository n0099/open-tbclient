package c.a.i.a.a;

import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.q.g;
import c.a.e.e.q.h;
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
public class e implements c.a.q0.i3.q0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.e.e.q.f f3510a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f3511b;

    /* renamed from: c  reason: collision with root package name */
    public String f3512c;

    /* renamed from: d  reason: collision with root package name */
    public g f3513d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f3514e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f3515f;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f3516e;

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
            this.f3516e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.s.g0.a.a(c.a.p0.s.g0.a.b(this.f3516e));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f3517e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f3518f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f3519g;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f3520e;

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
                this.f3520e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    e eVar = this.f3520e.f3519g;
                    eVar.f3510a.onShowErr(4, eVar.f3515f.getString(R.string.voice_error_file_md5));
                    h.f2606a = 1;
                }
            }
        }

        /* renamed from: c.a.i.a.a.e$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0075b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f3521e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f3522f;

            public RunnableC0075b(b bVar, String str) {
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
                this.f3522f = bVar;
                this.f3521e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    h.f2606a = 1;
                    b bVar = this.f3522f;
                    bVar.f3519g.f3510a.onSendVoice(this.f3521e, bVar.f3518f);
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
            this.f3519g = eVar;
            this.f3517e = str;
            this.f3518f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = c.a.p0.s.g0.b.b.c(c.a.p0.s.g0.a.d(this.f3517e)).f14001a;
                if (this.f3519g.f3511b != null) {
                    this.f3519g.f3511b.removeCallbacks(this.f3519g.f3514e);
                    if (StringUtils.isNull(str)) {
                        this.f3519g.f3511b.post(new a(this));
                    } else {
                        this.f3519g.f3511b.post(new RunnableC0075b(this, str));
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
        public final /* synthetic */ e f3523e;

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
            this.f3523e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.e.e.q.f fVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (fVar = this.f3523e.f3510a) != null && h.f2606a == 2) {
                fVar.onStopingRecorder();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f3524a;

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
            this.f3524a = eVar;
        }

        @Override // c.a.e.e.q.g
        public void a(int i2) {
            c.a.e.e.q.f fVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (fVar = this.f3524a.f3510a) == null) {
                return;
            }
            fVar.onShowRecordTime(i2 / 1000);
        }

        @Override // c.a.e.e.q.e
        public void b(int i2) {
            c.a.e.e.q.f fVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (fVar = this.f3524a.f3510a) == null) {
                return;
            }
            fVar.onShowRecording(i2);
        }

        @Override // c.a.e.e.q.e
        public void c(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2) == null) {
                this.f3524a.o();
                h.f2606a = 1;
                if (this.f3524a.f3512c != null && str != null) {
                    e eVar = this.f3524a;
                    c.a.e.e.q.f fVar = eVar.f3510a;
                    if (fVar == null) {
                        return;
                    }
                    if (i2 > 1000) {
                        if (!str.endsWith(eVar.f3512c)) {
                            FieldBuilder fieldBuilder = new FieldBuilder();
                            fieldBuilder.append("file", str);
                            fieldBuilder.append("dur", Integer.valueOf(i2));
                            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", fieldBuilder.toString());
                            return;
                        }
                        e eVar2 = this.f3524a;
                        eVar2.m(eVar2.f3512c, (int) Math.round((i2 * 1.0d) / 1000.0d));
                        this.f3524a.f3512c = null;
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

        @Override // c.a.e.e.q.g
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                h.f2606a = 1;
            }
        }

        @Override // c.a.e.e.q.e
        public void error(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) {
                this.f3524a.o();
                TiebaStatic.voiceError(i2, "RecoreCallback.error: " + str, "");
                e eVar = this.f3524a;
                if (eVar.f3510a == null) {
                    h.f2606a = 1;
                } else if (i2 == 7) {
                    if (eVar.f3512c == null) {
                        TiebaStatic.voiceError(i2, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
                        return;
                    }
                    e eVar2 = this.f3524a;
                    eVar2.m(eVar2.f3512c, c.a.e.e.q.d.f2605a / 1000);
                    this.f3524a.f3512c = null;
                    e eVar3 = this.f3524a;
                    eVar3.f3510a.onShowErr(3, eVar3.f3515f.getString(R.string.voice_record_timeout_tip));
                } else {
                    h.f2606a = 1;
                    if (i2 == 8) {
                        i2 = 2;
                    }
                    this.f3524a.f3510a.onShowErr(i2, str);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-521964642, "Lc/a/i/a/a/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-521964642, "Lc/a/i/a/a/e;");
                return;
            }
        }
        h.f2606a = 1;
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
        this.f3512c = null;
        this.f3513d = null;
        this.f3514e = new c(this);
        this.f3511b = new Handler();
    }

    public static e n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? new e() : (e) invokeV.objValue;
    }

    @Override // c.a.q0.i3.q0.a
    public void a(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) {
            this.f3515f = tbPageContext;
        }
    }

    @Override // c.a.q0.i3.q0.a
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            stopRecord();
            q(false);
            c.a.e.e.q.f fVar = this.f3510a;
            if (fVar != null) {
                fVar.onDeletedVoice(str);
            }
            Handler handler = this.f3511b;
            if (handler == null) {
                return;
            }
            handler.postDelayed(new a(this, str), 200L);
        }
    }

    @Override // c.a.q0.i3.q0.a
    public boolean c(c.a.e.e.q.f fVar, int i2) {
        InterceptResult invokeLI;
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, fVar, i2)) == null) {
            if (fVar == null || (tbPageContext = this.f3515f) == null || !PermissionUtil.checkWriteExternalStorage(tbPageContext.getPageActivity())) {
                return false;
            }
            this.f3510a = fVar;
            if (!FileHelper.checkSD()) {
                String sdErrorString = FileHelper.getSdErrorString();
                if (sdErrorString == null) {
                    sdErrorString = h.a(R.string.voice_error_sdcard);
                }
                this.f3510a.onShowErr(0, sdErrorString);
                return false;
            }
            q(true);
            String e2 = c.a.p0.s.g0.a.e();
            this.f3512c = e2;
            String c2 = c.a.p0.s.g0.a.c(e2);
            if (this.f3513d == null) {
                this.f3513d = new d(this, null);
            }
            c.a.i.a.a.a.g();
            o();
            boolean f2 = c.a.i.a.a.a.f(c2, i2, this.f3513d);
            if (f2) {
                this.f3510a.onStartedRecorder(true);
                h.f2606a = 2;
            } else {
                h.f2606a = 1;
                c.a.i.a.a.a.g();
                FieldBuilder fieldBuilder = new FieldBuilder();
                fieldBuilder.append("voiceType", Integer.valueOf(i2));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", fieldBuilder.toString());
                this.f3510a.onStartedRecorder(false);
            }
            return f2;
        }
        return invokeLI.booleanValue;
    }

    @Override // c.a.q0.i3.q0.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.i.a.a.a.e();
        }
    }

    @Override // c.a.q0.i3.q0.a
    public void e(c.a.e.e.q.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            this.f3510a = fVar;
        }
    }

    @Override // c.a.q0.i3.q0.a
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h.f2606a == 1 : invokeV.booleanValue;
    }

    public final void m(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, str, i2) == null) || str == null || i2 < 1) {
            return;
        }
        h.f2606a = 3;
        new Thread(new b(this, str, i2)).start();
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            p();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001273, Boolean.valueOf(z)));
        }
    }

    @Override // c.a.q0.i3.q0.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            stopRecord();
            TbPageContext<?> tbPageContext = this.f3515f;
            if (tbPageContext != null && tbPageContext.getPageActivity() != null) {
                MediaService.stopMy(this.f3515f.getPageActivity());
            }
            Handler handler = this.f3511b;
            if (handler != null) {
                handler.removeCallbacks(this.f3514e);
            }
            this.f3515f = null;
            this.f3510a = null;
            this.f3511b = null;
        }
    }

    @Override // c.a.q0.i3.q0.a
    public void stopRecord() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.i.a.a.a.g();
            Handler handler = this.f3511b;
            if (handler != null) {
                handler.postDelayed(this.f3514e, 100L);
            }
            o();
        }
    }
}
