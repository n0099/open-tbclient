package c.a.r0.h4.l;

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
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f18134b;

    /* renamed from: c  reason: collision with root package name */
    public RecordVideoActivity f18135c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressView f18136d;

    /* renamed from: e  reason: collision with root package name */
    public List<b> f18137e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f18138f;

    /* renamed from: g  reason: collision with root package name */
    public long f18139g;

    /* renamed from: h  reason: collision with root package name */
    public int f18140h;

    /* loaded from: classes6.dex */
    public class a implements ProgressView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        /* renamed from: c.a.r0.h4.l.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C1070a implements TextureMovieEncoder.OnEncoderStatusUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f18141b;

            /* renamed from: c.a.r0.h4.l.h$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC1071a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ C1070a f18142e;

                public RunnableC1071a(C1070a c1070a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c1070a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f18142e = c1070a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f18142e.f18141b.a.f18135c == null) {
                        return;
                    }
                    this.f18142e.f18141b.a.f18135c.onRecordDone();
                }
            }

            public C1070a(a aVar, f fVar) {
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
                this.f18141b = aVar;
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
                    c.a.d.f.m.e.a().post(new RunnableC1071a(this));
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
                this.a.f18140h = i2;
                if (i2 != 100 || this.a.f18135c == null || (gVar = this.a.f18135c.mPreviewController) == null || (q = gVar.q()) == null) {
                    return;
                }
                if (q instanceof GLVideoPreviewView) {
                    q.setOnEncoderStatusUpdateListener(new C1070a(this, q));
                    this.a.o();
                    return;
                }
                this.a.o();
                if (this.a.f18135c != null) {
                    this.a.f18135c.onRecordDone();
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
        this.a = 1;
        this.f18135c = recordVideoActivity;
        if (recordVideoActivity == null) {
            return;
        }
        ImageView imageView = (ImageView) recordVideoActivity.findViewById(R.id.camera_switch);
        ImageView imageView2 = (ImageView) this.f18135c.findViewById(R.id.flash_switch);
        ProgressView progressView = (ProgressView) this.f18135c.findViewById(R.id.video_progress_view);
        this.f18136d = progressView;
        progressView.setListener(new a(this));
        if (!c.a.r0.h4.l.a.f(true)) {
            imageView2.setVisibility(4);
        }
        if (c.a.r0.h4.l.a.g(recordVideoActivity.getPackageManager())) {
            return;
        }
        imageView.setVisibility(8);
    }

    public void c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            if (this.f18137e == null) {
                this.f18137e = new ArrayList();
            }
            this.f18137e.add(bVar);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ProgressView progressView = this.f18136d;
            if (progressView != null) {
                progressView.setCurrentState(ProgressView.State.DELETE);
            }
            this.f18134b = this.f18136d.getLastProgress();
            g gVar = this.f18135c.mPreviewController;
            if (gVar != null) {
                gVar.h();
            }
        }
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18140h : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : invokeV.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f18134b : invokeV.intValue;
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
            i iVar = this.f18135c.mMusicController;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f18136d.isProgressListEmpty() : invokeV.booleanValue;
    }

    public void l() {
        ProgressView progressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f18138f || (progressView = this.f18136d) == null) {
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
                this.f18136d.setVisibility(4);
                this.f18136d.reset();
                this.f18134b = 0;
                File file = new File(c.a.r0.h4.c.f17912f);
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    for (File file2 : listFiles) {
                        if (file2.getPath().startsWith("rec_tmp_")) {
                            file2.delete();
                        }
                    }
                }
            }
            List<b> list = this.f18137e;
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
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f18138f) {
            return;
        }
        ProgressView progressView = this.f18136d;
        if (progressView != null) {
            progressView.setVisibility(0);
            this.f18136d.setCurrentState(ProgressView.State.START);
        }
        if (!this.f18138f) {
            this.f18138f = true;
            this.f18139g = System.currentTimeMillis();
        }
        RecordVideoActivity recordVideoActivity = this.f18135c;
        if (recordVideoActivity == null || (gVar = recordVideoActivity.mPreviewController) == null) {
            return;
        }
        gVar.L();
        i iVar = this.f18135c.mMusicController;
        if (iVar != null) {
            iVar.m(this.f18134b);
        }
    }

    public void o() {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.f18138f) {
            ProgressView progressView = this.f18136d;
            if (progressView != null) {
                progressView.setCurrentState(ProgressView.State.PAUSE);
            }
            this.f18138f = false;
            this.f18134b = (int) (this.f18134b + (System.currentTimeMillis() - this.f18139g));
            ProgressView progressView2 = this.f18136d;
            if (progressView2 != null) {
                int lastProgress = progressView2.getLastProgress();
                int i2 = this.f18134b;
                if (lastProgress != i2) {
                    this.f18136d.putProgressList(i2);
                }
            }
            RecordVideoActivity recordVideoActivity = this.f18135c;
            if (recordVideoActivity == null || (gVar = recordVideoActivity.mPreviewController) == null) {
                return;
            }
            gVar.M();
        }
    }
}
