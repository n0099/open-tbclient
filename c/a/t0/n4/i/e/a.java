package c.a.t0.n4.i.e;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.d.f.m.e;
import c.a.s0.e1.v;
import c.a.t0.n4.i.a;
import c.a.t0.n4.i.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.muxer.VideoMuxer;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f20430b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.t0.n4.i.b f20431c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.t0.n4.i.d.b f20432d;

    /* renamed from: e  reason: collision with root package name */
    public int f20433e;

    /* renamed from: f  reason: collision with root package name */
    public c f20434f;

    /* renamed from: g  reason: collision with root package name */
    public v f20435g;

    /* renamed from: h  reason: collision with root package name */
    public VideoMuxer f20436h;

    /* renamed from: i  reason: collision with root package name */
    public c.b f20437i;

    /* renamed from: c.a.t0.n4.i.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1231a implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.t0.n4.i.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1232a extends a.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ C1231a f20438b;

            public C1232a(C1231a c1231a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1231a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f20438b = c1231a;
            }

            @Override // c.a.a1.e.b
            public void b(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                    this.f20438b.a.o(3, i2);
                }
            }

            @Override // c.a.a1.e.b
            public void e(String str) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || this.f20438b.a.f20431c == null) {
                    return;
                }
                this.f20438b.a.f20431c.onError(-1, str);
            }

            @Override // c.a.t0.n4.i.a.d
            public void g(String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                    this.f20438b.a.o(3, 100);
                    if (this.f20438b.a.f20431c != null) {
                        c.a.t0.n4.i.b bVar = this.f20438b.a.f20431c;
                        String e2 = this.f20438b.a.f20432d.e();
                        bVar.onMuxerSucess(str, str2, e2, this.f20438b.a.f20432d.d() + "");
                    }
                }
            }
        }

        /* renamed from: c.a.t0.n4.i.e.a$a$b */
        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1231a f20439e;

            public b(C1231a c1231a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1231a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f20439e = c1231a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f20439e.a.f20431c == null) {
                    return;
                }
                this.f20439e.a.f20431c.onFinish();
            }
        }

        public C1231a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.t0.n4.i.c.b
        public void a(boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
                if (z) {
                    this.a.a = str;
                    this.a.o(2, 100);
                    this.a.f20436h = c.a.t0.n4.i.a.p(TbadkCoreApplication.getInst().getCurrentPageContext(TbadkCoreApplication.getInst()), this.a.a, this.a.f20432d.c(), new C1232a(this));
                } else if (this.a.f20431c != null) {
                    this.a.f20431c.onError(-1, this.a.f20430b.getString(R.string.sticker_video_download_error));
                    e.a().postDelayed(new b(this), 2000L);
                }
            }
        }

        @Override // c.a.t0.n4.i.c.b
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                this.a.o(2, (i2 * 100) / i3);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends v.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f20440b;

        public b(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20440b = aVar;
            this.a = str;
        }

        @Override // c.a.s0.e1.v.a
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f20440b.f20431c.onError(i2, str);
            }
        }

        @Override // c.a.s0.e1.v.a
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f20440b.o(1, 100);
                this.f20440b.n(this.a, str);
                a aVar = this.f20440b;
                aVar.l(aVar.f20432d.f());
            }
        }
    }

    public a(@NonNull TbPageContext tbPageContext, c.a.t0.n4.i.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20437i = new C1231a(this);
        this.f20430b = tbPageContext;
        this.f20431c = bVar;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            v vVar = this.f20435g;
            if (vVar != null) {
                vVar.cancel();
            }
            c cVar = this.f20434f;
            if (cVar != null) {
                cVar.cancel();
            }
            VideoMuxer videoMuxer = this.f20436h;
            if (videoMuxer != null) {
                videoMuxer.interruptProcess();
            }
        }
    }

    public final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/anniver";
        }
        return (String) invokeV.objValue;
    }

    public void k(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f20431c == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.f20431c.onError(-1, this.f20430b.getString(R.string.sticker_maxure_image_download_error));
            return;
        }
        if (str.startsWith("http")) {
            str2 = str;
        } else {
            str2 = TbConfig.getPhotoSmallAddress() + str;
        }
        v vVar = new v(this.f20430b.getPageActivity(), str2, new b(this, str));
        this.f20435g = vVar;
        vVar.p(3);
        this.f20435g.o(false);
        this.f20435g.q(true);
        this.f20435g.execute(new String[0]);
    }

    public void l(String str) {
        c.a.t0.n4.i.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (TextUtils.isEmpty(str) && (bVar = this.f20431c) != null) {
                bVar.onError(-1, this.f20430b.getString(R.string.sticker_maxure_video_download_error));
                return;
            }
            c cVar = new c(j(), str, this.f20437i);
            this.f20434f = cVar;
            cVar.execute(new Void[0]);
        }
    }

    public void m(c.a.t0.n4.i.d.b bVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f20432d = bVar;
            Iterator<c.a.t0.n4.i.d.a> it = bVar.c().iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = null;
                    break;
                }
                c.a.t0.n4.i.d.a next = it.next();
                if (next != null && next.f20415b == 2) {
                    str = next.a;
                    break;
                }
            }
            if (!TextUtils.isEmpty(str)) {
                k(str);
            } else {
                l(this.f20432d.f());
            }
        }
    }

    public final void n(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            for (int i2 = 0; i2 < this.f20432d.c().size(); i2++) {
                c.a.t0.n4.i.d.a aVar = this.f20432d.c().get(i2);
                if (aVar != null && aVar.f20415b == 2 && str.equals(aVar.a)) {
                    aVar.a = str2;
                    this.f20432d.c().set(i2, aVar);
                    return;
                }
            }
        }
    }

    public final synchronized void o(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
            synchronized (this) {
                try {
                    if (i2 == 1) {
                        this.f20433e = (int) (i3 * 0.1d);
                    } else if (i2 == 2) {
                        this.f20433e = ((int) (i3 * 0.4d)) + 10;
                    } else if (i2 == 3) {
                        this.f20433e = ((int) (i3 * 0.5d)) + 50;
                    }
                    if (this.f20431c != null) {
                        this.f20431c.onUpdateProgress(this.f20433e);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
