package c.a.q0.w3.l;

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
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f28463a;

    /* renamed from: b  reason: collision with root package name */
    public int f28464b;

    /* renamed from: c  reason: collision with root package name */
    public RecordVideoActivity f28465c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressView f28466d;

    /* renamed from: e  reason: collision with root package name */
    public List<b> f28467e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f28468f;

    /* renamed from: g  reason: collision with root package name */
    public long f28469g;

    /* renamed from: h  reason: collision with root package name */
    public int f28470h;

    /* loaded from: classes4.dex */
    public class a implements ProgressView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f28471a;

        /* renamed from: c.a.q0.w3.l.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1326a implements TextureMovieEncoder.OnEncoderStatusUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f28472a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f28473b;

            /* renamed from: c.a.q0.w3.l.i$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class RunnableC1327a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ C1326a f28474e;

                public RunnableC1327a(C1326a c1326a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c1326a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f28474e = c1326a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f28474e.f28473b.f28471a.f28465c == null) {
                        return;
                    }
                    this.f28474e.f28473b.f28471a.f28465c.onRecordDone();
                }
            }

            public C1326a(a aVar, g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f28473b = aVar;
                this.f28472a = gVar;
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
                    c.a.e.e.m.e.a().post(new RunnableC1327a(this));
                    this.f28472a.setOnEncoderStatusUpdateListener(null);
                }
            }
        }

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28471a = iVar;
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void a(int i2) {
            h hVar;
            g q;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f28471a.f28470h = i2;
                if (i2 != 100 || this.f28471a.f28465c == null || (hVar = this.f28471a.f28465c.mPreviewController) == null || (q = hVar.q()) == null) {
                    return;
                }
                if (q instanceof GLVideoPreviewView) {
                    q.setOnEncoderStatusUpdateListener(new C1326a(this, q));
                    this.f28471a.o();
                    return;
                }
                this.f28471a.o();
                if (this.f28471a.f28465c != null) {
                    this.f28471a.f28465c.onRecordDone();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onStatusChange(int i2);
    }

    public i(RecordVideoActivity recordVideoActivity) {
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
        this.f28463a = 1;
        this.f28465c = recordVideoActivity;
        if (recordVideoActivity == null) {
            return;
        }
        ImageView imageView = (ImageView) recordVideoActivity.findViewById(R.id.camera_switch);
        ImageView imageView2 = (ImageView) this.f28465c.findViewById(R.id.flash_switch);
        ProgressView progressView = (ProgressView) this.f28465c.findViewById(R.id.video_progress_view);
        this.f28466d = progressView;
        progressView.setListener(new a(this));
        if (!c.a.q0.w3.l.a.f(true)) {
            imageView2.setVisibility(4);
        }
        if (c.a.q0.w3.l.a.g(recordVideoActivity.getPackageManager())) {
            return;
        }
        imageView.setVisibility(8);
    }

    public void c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            if (this.f28467e == null) {
                this.f28467e = new ArrayList();
            }
            this.f28467e.add(bVar);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ProgressView progressView = this.f28466d;
            if (progressView != null) {
                progressView.setCurrentState(ProgressView.State.DELETE);
            }
            this.f28464b = this.f28466d.getLastProgress();
            h hVar = this.f28465c.mPreviewController;
            if (hVar != null) {
                hVar.h();
            }
        }
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28470h : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f28463a : invokeV.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f28464b : invokeV.intValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f28463a == 6 : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            j jVar = this.f28465c.mMusicController;
            if (jVar != null) {
                return jVar.h();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f28466d.isProgressListEmpty() : invokeV.booleanValue;
    }

    public void l() {
        ProgressView progressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f28468f || (progressView = this.f28466d) == null) {
            return;
        }
        progressView.setCurrentState(ProgressView.State.ROLLBACK);
    }

    public void m(int i2) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f28463a = i2;
            if (i2 == 1) {
                this.f28466d.setVisibility(4);
                this.f28466d.reset();
                this.f28464b = 0;
                File file = new File(c.a.q0.w3.c.f28198f);
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    for (File file2 : listFiles) {
                        if (file2.getPath().startsWith("rec_tmp_")) {
                            file2.delete();
                        }
                    }
                }
            }
            List<b> list = this.f28467e;
            if (list != null) {
                for (b bVar : list) {
                    bVar.onStatusChange(this.f28463a);
                }
            }
        }
    }

    public void n() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f28468f) {
            return;
        }
        ProgressView progressView = this.f28466d;
        if (progressView != null) {
            progressView.setVisibility(0);
            this.f28466d.setCurrentState(ProgressView.State.START);
        }
        if (!this.f28468f) {
            this.f28468f = true;
            this.f28469g = System.currentTimeMillis();
        }
        RecordVideoActivity recordVideoActivity = this.f28465c;
        if (recordVideoActivity == null || (hVar = recordVideoActivity.mPreviewController) == null) {
            return;
        }
        hVar.L();
        j jVar = this.f28465c.mMusicController;
        if (jVar != null) {
            jVar.m(this.f28464b);
        }
    }

    public void o() {
        h hVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.f28468f) {
            ProgressView progressView = this.f28466d;
            if (progressView != null) {
                progressView.setCurrentState(ProgressView.State.PAUSE);
            }
            this.f28468f = false;
            this.f28464b = (int) (this.f28464b + (System.currentTimeMillis() - this.f28469g));
            ProgressView progressView2 = this.f28466d;
            if (progressView2 != null) {
                int lastProgress = progressView2.getLastProgress();
                int i2 = this.f28464b;
                if (lastProgress != i2) {
                    this.f28466d.putProgressList(i2);
                }
            }
            RecordVideoActivity recordVideoActivity = this.f28465c;
            if (recordVideoActivity == null || (hVar = recordVideoActivity.mPreviewController) == null) {
                return;
            }
            hVar.M();
        }
    }
}
