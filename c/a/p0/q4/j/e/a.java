package c.a.p0.q4.j.e;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.d.f.m.e;
import c.a.p0.q4.j.a;
import c.a.p0.q4.j.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.InsertGalleryAsyncTask;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.muxer.VideoMuxer;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f17762b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.q4.j.b f17763c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.q4.j.d.b f17764d;

    /* renamed from: e  reason: collision with root package name */
    public int f17765e;

    /* renamed from: f  reason: collision with root package name */
    public c f17766f;

    /* renamed from: g  reason: collision with root package name */
    public InsertGalleryAsyncTask f17767g;

    /* renamed from: h  reason: collision with root package name */
    public VideoMuxer f17768h;
    public c.b i;

    /* renamed from: c.a.p0.q4.j.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1334a implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.p0.q4.j.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C1335a extends a.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ C1334a f17769b;

            public C1335a(C1334a c1334a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1334a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f17769b = c1334a;
            }

            @Override // c.a.v0.e.b
            public void b(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                    this.f17769b.a.o(3, i);
                }
            }

            @Override // c.a.v0.e.b
            public void e(String str) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || this.f17769b.a.f17763c == null) {
                    return;
                }
                this.f17769b.a.f17763c.onError(-1, str);
            }

            @Override // c.a.p0.q4.j.a.d
            public void g(String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                    this.f17769b.a.o(3, 100);
                    if (this.f17769b.a.f17763c != null) {
                        c.a.p0.q4.j.b bVar = this.f17769b.a.f17763c;
                        String e2 = this.f17769b.a.f17764d.e();
                        bVar.onMuxerSucess(str, str2, e2, this.f17769b.a.f17764d.d() + "");
                    }
                }
            }
        }

        /* renamed from: c.a.p0.q4.j.e.a$a$b */
        /* loaded from: classes2.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ C1334a a;

            public b(C1334a c1334a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1334a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = c1334a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a.f17763c == null) {
                    return;
                }
                this.a.a.f17763c.onFinish();
            }
        }

        public C1334a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.p0.q4.j.c.b
        public void a(boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
                if (z) {
                    this.a.a = str;
                    this.a.o(2, 100);
                    this.a.f17768h = c.a.p0.q4.j.a.p(TbadkCoreApplication.getInst().getCurrentPageContext(TbadkCoreApplication.getInst()), this.a.a, this.a.f17764d.c(), new C1335a(this));
                } else if (this.a.f17763c != null) {
                    this.a.f17763c.onError(-1, this.a.f17762b.getString(R.string.obfuscated_res_0x7f0f11da));
                    e.a().postDelayed(new b(this), 2000L);
                }
            }
        }

        @Override // c.a.p0.q4.j.c.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
                this.a.o(2, (i * 100) / i2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends InsertGalleryAsyncTask.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f17770b;

        public b(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17770b = aVar;
            this.a = str;
        }

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.a
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                this.f17770b.f17763c.onError(i, str);
            }
        }

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.a
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f17770b.o(1, 100);
                this.f17770b.n(this.a, str);
                a aVar = this.f17770b;
                aVar.l(aVar.f17764d.f());
            }
        }
    }

    public a(@NonNull TbPageContext tbPageContext, c.a.p0.q4.j.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new C1334a(this);
        this.f17762b = tbPageContext;
        this.f17763c = bVar;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            InsertGalleryAsyncTask insertGalleryAsyncTask = this.f17767g;
            if (insertGalleryAsyncTask != null) {
                insertGalleryAsyncTask.cancel();
            }
            c cVar = this.f17766f;
            if (cVar != null) {
                cVar.cancel();
            }
            VideoMuxer videoMuxer = this.f17768h;
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
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f17763c == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.f17763c.onError(-1, this.f17762b.getString(R.string.obfuscated_res_0x7f0f11d0));
            return;
        }
        if (str.startsWith("http")) {
            str2 = str;
        } else {
            str2 = TbConfig.getPhotoSmallAddress() + str;
        }
        InsertGalleryAsyncTask insertGalleryAsyncTask = new InsertGalleryAsyncTask(this.f17762b.getPageActivity(), str2, new b(this, str));
        this.f17767g = insertGalleryAsyncTask;
        insertGalleryAsyncTask.setFrom(3);
        this.f17767g.setCareHeaderContentLength(false);
        this.f17767g.setRenameGif(true);
        this.f17767g.execute(new String[0]);
    }

    public void l(String str) {
        c.a.p0.q4.j.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (TextUtils.isEmpty(str) && (bVar = this.f17763c) != null) {
                bVar.onError(-1, this.f17762b.getString(R.string.obfuscated_res_0x7f0f11d6));
                return;
            }
            c cVar = new c(j(), str, this.i);
            this.f17766f = cVar;
            cVar.execute(new Void[0]);
        }
    }

    public void m(c.a.p0.q4.j.d.b bVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f17764d = bVar;
            Iterator<c.a.p0.q4.j.d.a> it = bVar.c().iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = null;
                    break;
                }
                c.a.p0.q4.j.d.a next = it.next();
                if (next != null && next.f17750b == 2) {
                    str = next.a;
                    break;
                }
            }
            if (!TextUtils.isEmpty(str)) {
                k(str);
            } else {
                l(this.f17764d.f());
            }
        }
    }

    public final void n(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            for (int i = 0; i < this.f17764d.c().size(); i++) {
                c.a.p0.q4.j.d.a aVar = this.f17764d.c().get(i);
                if (aVar != null && aVar.f17750b == 2 && str.equals(aVar.a)) {
                    aVar.a = str2;
                    this.f17764d.c().set(i, aVar);
                    return;
                }
            }
        }
    }

    public final synchronized void o(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) {
            synchronized (this) {
                try {
                    if (i == 1) {
                        this.f17765e = (int) (i2 * 0.1d);
                    } else if (i == 2) {
                        this.f17765e = ((int) (i2 * 0.4d)) + 10;
                    } else if (i == 3) {
                        this.f17765e = ((int) (i2 * 0.5d)) + 50;
                    }
                    if (this.f17763c != null) {
                        this.f17763c.onUpdateProgress(this.f17765e);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
