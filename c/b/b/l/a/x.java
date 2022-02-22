package c.b.b.l.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes9.dex */
public class x implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final SoundPool f27296e;

    /* renamed from: f  reason: collision with root package name */
    public final AudioManager f27297f;

    /* renamed from: g  reason: collision with root package name */
    public final List<p> f27298g;

    public x(Context context, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27298g = new ArrayList();
        if (!bVar.p) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.f27296e = new SoundPool.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(14).setContentType(4).build()).setMaxStreams(bVar.q).build();
            } else {
                this.f27296e = new SoundPool(bVar.q, 3, 0);
            }
            this.f27297f = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            if (context instanceof Activity) {
                ((Activity) context).setVolumeControlStream(3);
                return;
            }
            return;
        }
        this.f27296e = null;
        this.f27297f = null;
    }

    @Override // c.b.b.e
    public c.b.b.k.b a(c.b.b.m.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if (this.f27296e != null) {
                g gVar = (g) aVar;
                if (gVar.t() == Files.FileType.Internal) {
                    try {
                        AssetFileDescriptor u = gVar.u();
                        s sVar = new s(this.f27296e, this.f27297f, this.f27296e.load(u, 1));
                        u.close();
                        return sVar;
                    } catch (IOException e2) {
                        throw new GdxRuntimeException("Error loading audio file: " + aVar + "\nNote: Internal audio files must be placed in the assets directory.", e2);
                    }
                }
                try {
                    return new s(this.f27296e, this.f27297f, this.f27296e.load(gVar.e().getPath(), 1));
                } catch (Exception e3) {
                    throw new GdxRuntimeException("Error loading audio file: " + aVar, e3);
                }
            }
            throw new GdxRuntimeException("Android audio is not enabled by the application config.");
        }
        return (c.b.b.k.b) invokeL.objValue;
    }

    @Override // c.b.b.l.a.d
    public void d(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar) == null) {
            synchronized (this.f27298g) {
                this.f27298g.remove(this);
            }
        }
    }

    @Override // c.b.b.q.h
    public void dispose() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f27296e == null) {
            return;
        }
        synchronized (this.f27298g) {
            Iterator it = new ArrayList(this.f27298g).iterator();
            while (it.hasNext()) {
                ((p) it.next()).dispose();
            }
        }
        this.f27296e.release();
    }

    @Override // c.b.b.e
    public c.b.b.k.a f(c.b.b.m.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) {
            if (this.f27296e != null) {
                g gVar = (g) aVar;
                MediaPlayer mediaPlayer = new MediaPlayer();
                if (gVar.t() == Files.FileType.Internal) {
                    try {
                        AssetFileDescriptor u = gVar.u();
                        mediaPlayer.setDataSource(u.getFileDescriptor(), u.getStartOffset(), u.getLength());
                        u.close();
                        mediaPlayer.prepare();
                        p pVar = new p(this, mediaPlayer);
                        synchronized (this.f27298g) {
                            this.f27298g.add(pVar);
                        }
                        return pVar;
                    } catch (Exception e2) {
                        throw new GdxRuntimeException("Error loading audio file: " + aVar + "\nNote: Internal audio files must be placed in the assets directory.", e2);
                    }
                }
                try {
                    mediaPlayer.setDataSource(gVar.e().getPath());
                    mediaPlayer.prepare();
                    p pVar2 = new p(this, mediaPlayer);
                    synchronized (this.f27298g) {
                        this.f27298g.add(pVar2);
                    }
                    return pVar2;
                } catch (Exception e3) {
                    throw new GdxRuntimeException("Error loading audio file: " + aVar, e3);
                }
            }
            throw new GdxRuntimeException("Android audio is not enabled by the application config.");
        }
        return (c.b.b.k.a) invokeL.objValue;
    }

    @Override // c.b.b.l.a.d
    public void pause() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f27296e == null) {
            return;
        }
        synchronized (this.f27298g) {
            for (p pVar : this.f27298g) {
                if (pVar.a()) {
                    pVar.pause();
                    pVar.f27286h = true;
                } else {
                    pVar.f27286h = false;
                }
            }
        }
        this.f27296e.autoPause();
    }

    @Override // c.b.b.l.a.d
    public void resume() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f27296e == null) {
            return;
        }
        synchronized (this.f27298g) {
            for (int i2 = 0; i2 < this.f27298g.size(); i2++) {
                if (this.f27298g.get(i2).f27286h) {
                    this.f27298g.get(i2).f();
                }
            }
        }
        this.f27296e.autoResume();
    }
}
