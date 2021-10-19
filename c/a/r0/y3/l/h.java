package c.a.r0.y3.l;

import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.GLVideoPreviewView;
import com.baidu.tieba.video.record.ProgressView;
import com.baidu.tieba.video.record.RecordVideoActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.encoder.TextureMovieEncoder;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f29346a;

    /* renamed from: b  reason: collision with root package name */
    public int f29347b;

    /* renamed from: c  reason: collision with root package name */
    public RecordVideoActivity f29348c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressView f29349d;

    /* renamed from: e  reason: collision with root package name */
    public List<b> f29350e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f29351f;

    /* renamed from: g  reason: collision with root package name */
    public long f29352g;

    /* renamed from: h  reason: collision with root package name */
    public int f29353h;

    /* loaded from: classes4.dex */
    public class a implements ProgressView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f29354a;

        /* renamed from: c.a.r0.y3.l.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1370a implements TextureMovieEncoder.OnEncoderStatusUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f29355a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f29356b;

            /* renamed from: c.a.r0.y3.l.h$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class RunnableC1371a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ C1370a f29357e;

                public RunnableC1371a(C1370a c1370a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c1370a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f29357e = c1370a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f29357e.f29356b.f29354a.f29348c == null) {
                        return;
                    }
                    this.f29357e.f29356b.f29354a.f29348c.onRecordDone();
                }
            }

            public C1370a(a aVar, f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f29356b = aVar;
                this.f29355a = fVar;
            }

            @Override // com.faceunity.encoder.TextureMovieEncoder.OnEncoderStatusUpdateListener
            public void onStartSuccess() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.faceunity.encoder.TextureMovieEncoder.OnEncoderStatusUpdateListener
            public void onStopSuccess() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    c.a.e.e.m.e.a().post(new RunnableC1371a(this));
                    this.f29355a.setOnEncoderStatusUpdateListener(null);
                }
            }
        }

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29354a = hVar;
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void a(int i2) {
            g gVar;
            f q;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f29354a.f29353h = i2;
                if (i2 != 100 || this.f29354a.f29348c == null || (gVar = this.f29354a.f29348c.mPreviewController) == null || (q = gVar.q()) == null) {
                    return;
                }
                if (q instanceof GLVideoPreviewView) {
                    q.setOnEncoderStatusUpdateListener(new C1370a(this, q));
                    this.f29354a.o();
                    return;
                }
                this.f29354a.o();
                if (this.f29354a.f29348c != null) {
                    this.f29354a.f29348c.onRecordDone();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onStatusChange(int i2);
    }

    public h(RecordVideoActivity recordVideoActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {recordVideoActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29346a = 1;
        this.f29348c = recordVideoActivity;
        if (recordVideoActivity == null) {
            return;
        }
        ImageView imageView = (ImageView) recordVideoActivity.findViewById(R.id.camera_switch);
        ImageView imageView2 = (ImageView) this.f29348c.findViewById(R.id.flash_switch);
        ProgressView progressView = (ProgressView) this.f29348c.findViewById(R.id.video_progress_view);
        this.f29349d = progressView;
        progressView.setListener(new a(this));
        if (!c.a.r0.y3.l.a.f(true)) {
            imageView2.setVisibility(4);
        }
        if (c.a.r0.y3.l.a.g(recordVideoActivity.getPackageManager())) {
            return;
        }
        imageView.setVisibility(8);
    }

    public void c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            if (this.f29350e == null) {
                this.f29350e = new ArrayList();
            }
            this.f29350e.add(bVar);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ProgressView progressView = this.f29349d;
            if (progressView != null) {
                progressView.setCurrentState(ProgressView.State.DELETE);
            }
            this.f29347b = this.f29349d.getLastProgress();
            g gVar = this.f29348c.mPreviewController;
            if (gVar != null) {
                gVar.h();
            }
        }
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f29353h : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f29346a : invokeV.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f29347b : invokeV.intValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f29346a == 6 : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            i iVar = this.f29348c.mMusicController;
            if (iVar != null) {
                return iVar.h();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int f2 = f();
            return f2 == 2 || f2 == 7;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f29349d.isProgressListEmpty() : invokeV.booleanValue;
    }

    public void l() {
        ProgressView progressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f29351f || (progressView = this.f29349d) == null) {
            return;
        }
        progressView.setCurrentState(ProgressView.State.ROLLBACK);
    }

    public void m(int i2) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f29346a = i2;
            if (i2 == 1) {
                this.f29349d.setVisibility(4);
                this.f29349d.reset();
                this.f29347b = 0;
                File file = new File(c.a.r0.y3.c.f29081f);
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    for (File file2 : listFiles) {
                        if (file2.getPath().startsWith("rec_tmp_")) {
                            file2.delete();
                        }
                    }
                }
            }
            List<b> list = this.f29350e;
            if (list != null) {
                for (b bVar : list) {
                    bVar.onStatusChange(this.f29346a);
                }
            }
        }
    }

    public void n() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f29351f) {
            return;
        }
        ProgressView progressView = this.f29349d;
        if (progressView != null) {
            progressView.setVisibility(0);
            this.f29349d.setCurrentState(ProgressView.State.START);
        }
        if (!this.f29351f) {
            this.f29351f = true;
            this.f29352g = System.currentTimeMillis();
        }
        RecordVideoActivity recordVideoActivity = this.f29348c;
        if (recordVideoActivity == null || (gVar = recordVideoActivity.mPreviewController) == null) {
            return;
        }
        gVar.L();
        i iVar = this.f29348c.mMusicController;
        if (iVar != null) {
            iVar.m(this.f29347b);
        }
    }

    public void o() {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.f29351f) {
            ProgressView progressView = this.f29349d;
            if (progressView != null) {
                progressView.setCurrentState(ProgressView.State.PAUSE);
            }
            this.f29351f = false;
            this.f29347b = (int) (this.f29347b + (System.currentTimeMillis() - this.f29352g));
            ProgressView progressView2 = this.f29349d;
            if (progressView2 != null) {
                int lastProgress = progressView2.getLastProgress();
                int i2 = this.f29347b;
                if (lastProgress != i2) {
                    this.f29349d.putProgressList(i2);
                }
            }
            RecordVideoActivity recordVideoActivity = this.f29348c;
            if (recordVideoActivity == null || (gVar = recordVideoActivity.mPreviewController) == null) {
                return;
            }
            gVar.M();
        }
    }
}
