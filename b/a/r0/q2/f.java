package b.a.r0.q2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f24352a;

    /* renamed from: b  reason: collision with root package name */
    public int f24353b;

    /* renamed from: c  reason: collision with root package name */
    public MediaController.MediaPlayerControl f24354c;

    /* renamed from: d  reason: collision with root package name */
    public b f24355d;

    /* renamed from: e  reason: collision with root package name */
    public d f24356e;

    /* renamed from: f  reason: collision with root package name */
    public c f24357f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f24358g;

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f24359a;

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
            this.f24359a = fVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message != null && message.what == 1 && this.f24359a.f24354c != null && this.f24359a.f24354c.isPlaying()) {
                int currentPosition = this.f24359a.f24354c.getCurrentPosition();
                int duration = this.f24359a.f24354c.getDuration();
                if (currentPosition < this.f24359a.f24353b) {
                    if (this.f24359a.f24355d != null) {
                        this.f24359a.f24355d.a();
                    }
                } else if (currentPosition == this.f24359a.f24353b && this.f24359a.f24356e != null) {
                    this.f24359a.f24356e.a();
                }
                if (this.f24359a.f24357f != null) {
                    this.f24359a.f24357f.onProgressUpdated(duration, currentPosition);
                }
                this.f24359a.f24353b = currentPosition;
                this.f24359a.h();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes5.dex */
    public interface c {
        void onProgressUpdated(int i2, int i3);
    }

    /* loaded from: classes5.dex */
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
        this.f24352a = 1000;
        this.f24353b = 0;
        this.f24358g = new a(this, Looper.getMainLooper());
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f24358g.removeMessages(1);
            Handler handler = this.f24358g;
            handler.sendMessageDelayed(handler.obtainMessage(1), this.f24352a);
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f24355d = bVar;
        }
    }

    public void j(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f24357f = cVar;
        }
    }

    public void k(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            this.f24356e = dVar;
        }
    }

    public void l(MediaController.MediaPlayerControl mediaPlayerControl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mediaPlayerControl) == null) {
            this.f24354c = mediaPlayerControl;
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f24353b = 0;
            h();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f24358g.removeMessages(1);
        }
    }
}
