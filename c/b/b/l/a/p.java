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
/* loaded from: classes9.dex */
public class p implements c.b.b.k.a, MediaPlayer.OnCompletionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final d f27887e;

    /* renamed from: f  reason: collision with root package name */
    public MediaPlayer f27888f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f27889g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f27890h;

    /* renamed from: i  reason: collision with root package name */
    public a.InterfaceC1595a f27891i;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ p f27892e;

        public a(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27892e = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p pVar = this.f27892e;
                pVar.f27891i.a(pVar);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27889g = true;
        this.f27890h = false;
        this.f27887e = dVar;
        this.f27888f = mediaPlayer;
        this.f27891i = null;
        mediaPlayer.setOnCompletionListener(this);
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            MediaPlayer mediaPlayer = this.f27888f;
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (mediaPlayer = this.f27888f) == null) {
            return;
        }
        try {
            try {
                mediaPlayer.release();
            } finally {
                this.f27888f = null;
                this.f27891i = null;
                this.f27887e.d(this);
            }
        } catch (Throwable unused) {
            c.b.b.f.a.log("AndroidMusic", "error while disposing AndroidMusic instance, non-fatal");
        }
    }

    public void f() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (mediaPlayer = this.f27888f) == null) {
            return;
        }
        try {
            if (mediaPlayer.isPlaying()) {
                return;
            }
            try {
                if (!this.f27889g) {
                    this.f27888f.prepare();
                    this.f27889g = true;
                }
                this.f27888f.start();
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
        if (!(interceptable == null || interceptable.invokeL(1048579, this, mediaPlayer) == null) || this.f27891i == null) {
            return;
        }
        c.b.b.f.a.postRunnable(new a(this));
    }

    public void pause() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (mediaPlayer = this.f27888f) == null) {
            return;
        }
        try {
            if (mediaPlayer.isPlaying()) {
                this.f27888f.pause();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f27890h = false;
    }
}
