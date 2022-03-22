package c.b.b.l.a;

import android.media.MediaPlayer;
import c.b.b.k.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes3.dex */
public class p implements c.b.b.k.a, MediaPlayer.OnCompletionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final d a;

    /* renamed from: b  reason: collision with root package name */
    public MediaPlayer f22440b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f22441c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22442d;

    /* renamed from: e  reason: collision with root package name */
    public a.InterfaceC1643a f22443e;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p a;

        public a(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p pVar = this.a;
                pVar.f22443e.a(pVar);
            }
        }
    }

    public p(d dVar, MediaPlayer mediaPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, mediaPlayer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22441c = true;
        this.f22442d = false;
        this.a = dVar;
        this.f22440b = mediaPlayer;
        this.f22443e = null;
        mediaPlayer.setOnCompletionListener(this);
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            MediaPlayer mediaPlayer = this.f22440b;
            if (mediaPlayer == null) {
                return false;
            }
            try {
                return mediaPlayer.isPlaying();
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.media.MediaPlayer, c.b.b.k.a$a] */
    @Override // c.b.b.q.h
    public void dispose() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (mediaPlayer = this.f22440b) == null) {
            return;
        }
        try {
            try {
                mediaPlayer.release();
            } finally {
                this.f22440b = null;
                this.f22443e = null;
                this.a.d(this);
            }
        } catch (Throwable unused) {
            c.b.b.f.a.log("AndroidMusic", "error while disposing AndroidMusic instance, non-fatal");
        }
    }

    public void f() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (mediaPlayer = this.f22440b) == null) {
            return;
        }
        try {
            if (mediaPlayer.isPlaying()) {
                return;
            }
            try {
                if (!this.f22441c) {
                    this.f22440b.prepare();
                    this.f22441c = true;
                }
                this.f22440b.start();
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (IllegalStateException e3) {
                e3.printStackTrace();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, mediaPlayer) == null) || this.f22443e == null) {
            return;
        }
        c.b.b.f.a.postRunnable(new a(this));
    }

    public void pause() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (mediaPlayer = this.f22440b) == null) {
            return;
        }
        try {
            if (mediaPlayer.isPlaying()) {
                this.f22440b.pause();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f22442d = false;
    }
}
