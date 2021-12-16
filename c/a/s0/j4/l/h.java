package c.a.s0.j4.l;

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
/* loaded from: classes7.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f18783b;

    /* renamed from: c  reason: collision with root package name */
    public RecordVideoActivity f18784c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressView f18785d;

    /* renamed from: e  reason: collision with root package name */
    public List<b> f18786e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f18787f;

    /* renamed from: g  reason: collision with root package name */
    public long f18788g;

    /* renamed from: h  reason: collision with root package name */
    public int f18789h;

    /* loaded from: classes7.dex */
    public class a implements ProgressView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        /* renamed from: c.a.s0.j4.l.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1127a implements TextureMovieEncoder.OnEncoderStatusUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f18790b;

            /* renamed from: c.a.s0.j4.l.h$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class RunnableC1128a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ C1127a f18791e;

                public RunnableC1128a(C1127a c1127a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c1127a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f18791e = c1127a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f18791e.f18790b.a.f18784c == null) {
                        return;
                    }
                    this.f18791e.f18790b.a.f18784c.onRecordDone();
                }
            }

            public C1127a(a aVar, f fVar) {
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
                this.f18790b = aVar;
                this.a = fVar;
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
                    c.a.d.f.m.e.a().post(new RunnableC1128a(this));
                    this.a.setOnEncoderStatusUpdateListener(null);
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
            this.a = hVar;
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void a(int i2) {
            g gVar;
            f q;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.a.f18789h = i2;
                if (i2 != 100 || this.a.f18784c == null || (gVar = this.a.f18784c.mPreviewController) == null || (q = gVar.q()) == null) {
                    return;
                }
                if (q instanceof GLVideoPreviewView) {
                    q.setOnEncoderStatusUpdateListener(new C1127a(this, q));
                    this.a.o();
                    return;
                }
                this.a.o();
                if (this.a.f18784c != null) {
                    this.a.f18784c.onRecordDone();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
        this.a = 1;
        this.f18784c = recordVideoActivity;
        if (recordVideoActivity == null) {
            return;
        }
        ImageView imageView = (ImageView) recordVideoActivity.findViewById(R.id.camera_switch);
        ImageView imageView2 = (ImageView) this.f18784c.findViewById(R.id.flash_switch);
        ProgressView progressView = (ProgressView) this.f18784c.findViewById(R.id.video_progress_view);
        this.f18785d = progressView;
        progressView.setListener(new a(this));
        if (!c.a.s0.j4.l.a.f(true)) {
            imageView2.setVisibility(4);
        }
        if (c.a.s0.j4.l.a.g(recordVideoActivity.getPackageManager())) {
            return;
        }
        imageView.setVisibility(8);
    }

    public void c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            if (this.f18786e == null) {
                this.f18786e = new ArrayList();
            }
            this.f18786e.add(bVar);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ProgressView progressView = this.f18785d;
            if (progressView != null) {
                progressView.setCurrentState(ProgressView.State.DELETE);
            }
            this.f18783b = this.f18785d.getLastProgress();
            g gVar = this.f18784c.mPreviewController;
            if (gVar != null) {
                gVar.h();
            }
        }
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18789h : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : invokeV.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f18783b : invokeV.intValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a == 6 : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            i iVar = this.f18784c.mMusicController;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f18785d.isProgressListEmpty() : invokeV.booleanValue;
    }

    public void l() {
        ProgressView progressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f18787f || (progressView = this.f18785d) == null) {
            return;
        }
        progressView.setCurrentState(ProgressView.State.ROLLBACK);
    }

    public void m(int i2) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.a = i2;
            if (i2 == 1) {
                this.f18785d.setVisibility(4);
                this.f18785d.reset();
                this.f18783b = 0;
                File file = new File(c.a.s0.j4.c.f18561f);
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    for (File file2 : listFiles) {
                        if (file2.getPath().startsWith("rec_tmp_")) {
                            file2.delete();
                        }
                    }
                }
            }
            List<b> list = this.f18786e;
            if (list != null) {
                for (b bVar : list) {
                    bVar.onStatusChange(this.a);
                }
            }
        }
    }

    public void n() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f18787f) {
            return;
        }
        ProgressView progressView = this.f18785d;
        if (progressView != null) {
            progressView.setVisibility(0);
            this.f18785d.setCurrentState(ProgressView.State.START);
        }
        if (!this.f18787f) {
            this.f18787f = true;
            this.f18788g = System.currentTimeMillis();
        }
        RecordVideoActivity recordVideoActivity = this.f18784c;
        if (recordVideoActivity == null || (gVar = recordVideoActivity.mPreviewController) == null) {
            return;
        }
        gVar.L();
        i iVar = this.f18784c.mMusicController;
        if (iVar != null) {
            iVar.m(this.f18783b);
        }
    }

    public void o() {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.f18787f) {
            ProgressView progressView = this.f18785d;
            if (progressView != null) {
                progressView.setCurrentState(ProgressView.State.PAUSE);
            }
            this.f18787f = false;
            this.f18783b = (int) (this.f18783b + (System.currentTimeMillis() - this.f18788g));
            ProgressView progressView2 = this.f18785d;
            if (progressView2 != null) {
                int lastProgress = progressView2.getLastProgress();
                int i2 = this.f18783b;
                if (lastProgress != i2) {
                    this.f18785d.putProgressList(i2);
                }
            }
            RecordVideoActivity recordVideoActivity = this.f18784c;
            if (recordVideoActivity == null || (gVar = recordVideoActivity.mPreviewController) == null) {
                return;
            }
            gVar.M();
        }
    }
}
