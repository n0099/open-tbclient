package c.a.a0.j.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.a0.x.d;
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
public class b implements c.a.a0.j.g.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.a0.j.d.a a;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.a0.j.i.a.c(this.a.a.f1251h);
            }
        }
    }

    public b(@NonNull c.a.a0.j.d.a aVar) {
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

    @Override // c.a.a0.j.g.c
    public void a(int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) == null) || j < 0 || j2 <= 0 || j > j2) {
            return;
        }
        this.a.i = (float) d.a(j, j2);
        this.a.f1246c = AdDownloadStatus.DOWNLOADING;
        c.a.a0.j.a.a.b().d(AdDownloadAction.PROGRESS_UPDATE, this.a);
    }

    @Override // c.a.a0.j.g.c
    public void b(long j, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, file) == null) {
            AdDownloadAction adDownloadAction = this.a.f1246c == AdDownloadStatus.PAUSE ? AdDownloadAction.RESUME : AdDownloadAction.START;
            this.a.l = System.currentTimeMillis();
            c.a.a0.j.d.a aVar = this.a;
            aVar.f1246c = AdDownloadStatus.DOWNLOADING;
            aVar.f1251h = file;
            aVar.o.f1254d = j;
            c.a.a0.j.a.a.b().d(adDownloadAction, this.a);
            c.a.a0.j.b.a.a().update(this.a);
            c.a.a0.j.b.a.a().c(this.a);
        }
    }

    @Override // c.a.a0.j.g.c
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.f1246c = AdDownloadStatus.PAUSE;
            c.a.a0.j.a.a.b().d(AdDownloadAction.PAUSE, this.a);
            c.a.a0.j.e.a.f().h(this.a, "notify_type_pause");
            c.a.a0.j.b.a.a().c(this.a);
        }
    }

    @Override // c.a.a0.j.g.c
    public void onError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.a0.j.d.a aVar = this.a;
            aVar.f1246c = AdDownloadStatus.NONE;
            aVar.i = 0.0f;
            aVar.j = 0.0f;
            c.a.a0.j.a.a.b().d(AdDownloadAction.FAIL, this.a);
            c.a.a0.j.e.a.f().h(this.a, "notify_type_stop");
            c.a.a0.j.b.a.a().c(this.a);
        }
    }

    @Override // c.a.a0.j.g.c
    public void onSuccess(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.a.m = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.a.f1247d)) {
                c.a.a0.j.d.a aVar = this.a;
                aVar.f1247d = c.a.a0.j.i.a.a(aVar.f1251h);
            }
            AdAppStateManager.instance().register(this.a);
            c.a.a0.j.d.a aVar2 = this.a;
            aVar2.f1246c = AdDownloadStatus.COMPLETED;
            aVar2.i = 1.0f;
            aVar2.j = 1.0f;
            c.a.a0.j.a.a.b().d(AdDownloadAction.COMPLETE, this.a);
            c.a.a0.j.h.b.a().b(this.a);
            c.a.a0.j.e.a.f().i(this.a);
            c.a.a0.j.b.a.a().c(this.a);
            c.a.a0.d0.b.a(new a(this), "ad_auto_install", 3, 1000L);
        }
    }
}
