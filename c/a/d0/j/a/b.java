package c.a.d0.j.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.d0.x.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.basic.AdAppStateManager;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes.dex */
public class b implements c.a.d0.j.g.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.d0.j.d.a a;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f2785e;

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
            this.f2785e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.d0.j.i.a.c(this.f2785e.a.f2803h);
            }
        }
    }

    public b(@NonNull c.a.d0.j.d.a aVar) {
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

    @Override // c.a.d0.j.g.c
    public void a(int i2, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)}) == null) || j2 < 0 || j3 <= 0 || j2 > j3) {
            return;
        }
        this.a.f2804i = (float) d.a(j2, j3);
        this.a.f2798c = AdDownloadStatus.DOWNLOADING;
        c.a.d0.j.a.a.b().d(AdDownloadAction.PROGRESS_UPDATE, this.a);
    }

    @Override // c.a.d0.j.g.c
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.a.m = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.a.f2799d)) {
                c.a.d0.j.d.a aVar = this.a;
                aVar.f2799d = c.a.d0.j.i.a.a(aVar.f2803h);
            }
            AdAppStateManager.instance().register(this.a);
            c.a.d0.j.d.a aVar2 = this.a;
            aVar2.f2798c = AdDownloadStatus.COMPLETED;
            aVar2.f2804i = 1.0f;
            aVar2.f2805j = 1.0f;
            c.a.d0.j.a.a.b().d(AdDownloadAction.COMPLETE, this.a);
            c.a.d0.j.h.b.a().b(this.a);
            c.a.d0.j.e.a.f().i(this.a);
            c.a.d0.j.b.a.a().c(this.a);
            c.a.d0.d0.b.a(new a(this), "ad_auto_install", 3, 1000L);
        }
    }

    @Override // c.a.d0.j.g.c
    public void c(long j2, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j2, file) == null) {
            AdDownloadAction adDownloadAction = this.a.f2798c == AdDownloadStatus.PAUSE ? AdDownloadAction.RESUME : AdDownloadAction.START;
            this.a.l = System.currentTimeMillis();
            c.a.d0.j.d.a aVar = this.a;
            aVar.f2798c = AdDownloadStatus.DOWNLOADING;
            aVar.f2803h = file;
            aVar.o.f2808d = j2;
            c.a.d0.j.a.a.b().d(adDownloadAction, this.a);
            c.a.d0.j.b.a.a().update(this.a);
            c.a.d0.j.b.a.a().c(this.a);
        }
    }

    @Override // c.a.d0.j.g.c
    public void d(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            this.a.f2798c = AdDownloadStatus.PAUSE;
            c.a.d0.j.a.a.b().d(AdDownloadAction.PAUSE, this.a);
            c.a.d0.j.e.a.f().h(this.a, "notify_type_pause");
            c.a.d0.j.b.a.a().c(this.a);
        }
    }

    @Override // c.a.d0.j.g.c
    public void onError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.d0.j.d.a aVar = this.a;
            aVar.f2798c = AdDownloadStatus.NONE;
            aVar.f2804i = 0.0f;
            aVar.f2805j = 0.0f;
            c.a.d0.j.a.a.b().d(AdDownloadAction.FAIL, this.a);
            c.a.d0.j.e.a.f().h(this.a, "notify_type_stop");
            c.a.d0.j.b.a.a().c(this.a);
        }
    }
}
