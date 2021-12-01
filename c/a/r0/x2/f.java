package c.a.r0.x2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f25386b;

    /* renamed from: c  reason: collision with root package name */
    public MediaController.MediaPlayerControl f25387c;

    /* renamed from: d  reason: collision with root package name */
    public b f25388d;

    /* renamed from: e  reason: collision with root package name */
    public d f25389e;

    /* renamed from: f  reason: collision with root package name */
    public c f25390f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f25391g;

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f fVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message != null && message.what == 1 && this.a.f25387c != null && this.a.f25387c.isPlaying()) {
                int currentPosition = this.a.f25387c.getCurrentPosition();
                int duration = this.a.f25387c.getDuration();
                if (currentPosition < this.a.f25386b) {
                    if (this.a.f25388d != null) {
                        this.a.f25388d.a();
                    }
                } else if (currentPosition == this.a.f25386b && this.a.f25389e != null) {
                    this.a.f25389e.a();
                }
                if (this.a.f25390f != null) {
                    this.a.f25390f.onProgressUpdated(duration, currentPosition);
                }
                this.a.f25386b = currentPosition;
                this.a.h();
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes7.dex */
    public interface c {
        void onProgressUpdated(int i2, int i3);
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a();
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 1000;
        this.f25386b = 0;
        this.f25391g = new a(this, Looper.getMainLooper());
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f25391g.removeMessages(1);
            Handler handler = this.f25391g;
            handler.sendMessageDelayed(handler.obtainMessage(1), this.a);
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f25388d = bVar;
        }
    }

    public void j(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f25390f = cVar;
        }
    }

    public void k(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            this.f25389e = dVar;
        }
    }

    public void l(MediaController.MediaPlayerControl mediaPlayerControl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mediaPlayerControl) == null) {
            this.f25387c = mediaPlayerControl;
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f25386b = 0;
            h();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f25391g.removeMessages(1);
        }
    }
}
