package b.a.r0.z3.l;

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
/* loaded from: classes6.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f28543a;

    /* renamed from: b  reason: collision with root package name */
    public int f28544b;

    /* renamed from: c  reason: collision with root package name */
    public RecordVideoActivity f28545c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressView f28546d;

    /* renamed from: e  reason: collision with root package name */
    public List<b> f28547e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f28548f;

    /* renamed from: g  reason: collision with root package name */
    public long f28549g;

    /* renamed from: h  reason: collision with root package name */
    public int f28550h;

    /* loaded from: classes6.dex */
    public class a implements ProgressView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f28551a;

        /* renamed from: b.a.r0.z3.l.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C1388a implements TextureMovieEncoder.OnEncoderStatusUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f28552a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f28553b;

            /* renamed from: b.a.r0.z3.l.h$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC1389a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ C1388a f28554e;

                public RunnableC1389a(C1388a c1388a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c1388a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f28554e = c1388a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f28554e.f28553b.f28551a.f28545c == null) {
                        return;
                    }
                    this.f28554e.f28553b.f28551a.f28545c.onRecordDone();
                }
            }

            public C1388a(a aVar, f fVar) {
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
                this.f28553b = aVar;
                this.f28552a = fVar;
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
                    b.a.e.e.m.e.a().post(new RunnableC1389a(this));
                    this.f28552a.setOnEncoderStatusUpdateListener(null);
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
            this.f28551a = hVar;
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void a(int i2) {
            g gVar;
            f q;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f28551a.f28550h = i2;
                if (i2 != 100 || this.f28551a.f28545c == null || (gVar = this.f28551a.f28545c.mPreviewController) == null || (q = gVar.q()) == null) {
                    return;
                }
                if (q instanceof GLVideoPreviewView) {
                    q.setOnEncoderStatusUpdateListener(new C1388a(this, q));
                    this.f28551a.o();
                    return;
                }
                this.f28551a.o();
                if (this.f28551a.f28545c != null) {
                    this.f28551a.f28545c.onRecordDone();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
        this.f28543a = 1;
        this.f28545c = recordVideoActivity;
        if (recordVideoActivity == null) {
            return;
        }
        ImageView imageView = (ImageView) recordVideoActivity.findViewById(R.id.camera_switch);
        ImageView imageView2 = (ImageView) this.f28545c.findViewById(R.id.flash_switch);
        ProgressView progressView = (ProgressView) this.f28545c.findViewById(R.id.video_progress_view);
        this.f28546d = progressView;
        progressView.setListener(new a(this));
        if (!b.a.r0.z3.l.a.f(true)) {
            imageView2.setVisibility(4);
        }
        if (b.a.r0.z3.l.a.g(recordVideoActivity.getPackageManager())) {
            return;
        }
        imageView.setVisibility(8);
    }

    public void c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            if (this.f28547e == null) {
                this.f28547e = new ArrayList();
            }
            this.f28547e.add(bVar);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ProgressView progressView = this.f28546d;
            if (progressView != null) {
                progressView.setCurrentState(ProgressView.State.DELETE);
            }
            this.f28544b = this.f28546d.getLastProgress();
            g gVar = this.f28545c.mPreviewController;
            if (gVar != null) {
                gVar.h();
            }
        }
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28550h : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f28543a : invokeV.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f28544b : invokeV.intValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f28543a == 6 : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            i iVar = this.f28545c.mMusicController;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f28546d.isProgressListEmpty() : invokeV.booleanValue;
    }

    public void l() {
        ProgressView progressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f28548f || (progressView = this.f28546d) == null) {
            return;
        }
        progressView.setCurrentState(ProgressView.State.ROLLBACK);
    }

    public void m(int i2) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f28543a = i2;
            if (i2 == 1) {
                this.f28546d.setVisibility(4);
                this.f28546d.reset();
                this.f28544b = 0;
                File file = new File(b.a.r0.z3.c.f28286f);
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    for (File file2 : listFiles) {
                        if (file2.getPath().startsWith("rec_tmp_")) {
                            file2.delete();
                        }
                    }
                }
            }
            List<b> list = this.f28547e;
            if (list != null) {
                for (b bVar : list) {
                    bVar.onStatusChange(this.f28543a);
                }
            }
        }
    }

    public void n() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f28548f) {
            return;
        }
        ProgressView progressView = this.f28546d;
        if (progressView != null) {
            progressView.setVisibility(0);
            this.f28546d.setCurrentState(ProgressView.State.START);
        }
        if (!this.f28548f) {
            this.f28548f = true;
            this.f28549g = System.currentTimeMillis();
        }
        RecordVideoActivity recordVideoActivity = this.f28545c;
        if (recordVideoActivity == null || (gVar = recordVideoActivity.mPreviewController) == null) {
            return;
        }
        gVar.L();
        i iVar = this.f28545c.mMusicController;
        if (iVar != null) {
            iVar.m(this.f28544b);
        }
    }

    public void o() {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.f28548f) {
            ProgressView progressView = this.f28546d;
            if (progressView != null) {
                progressView.setCurrentState(ProgressView.State.PAUSE);
            }
            this.f28548f = false;
            this.f28544b = (int) (this.f28544b + (System.currentTimeMillis() - this.f28549g));
            ProgressView progressView2 = this.f28546d;
            if (progressView2 != null) {
                int lastProgress = progressView2.getLastProgress();
                int i2 = this.f28544b;
                if (lastProgress != i2) {
                    this.f28546d.putProgressList(i2);
                }
            }
            RecordVideoActivity recordVideoActivity = this.f28545c;
            if (recordVideoActivity == null || (gVar = recordVideoActivity.mPreviewController) == null) {
                return;
            }
            gVar.M();
        }
    }
}
