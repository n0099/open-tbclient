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
/* loaded from: classes3.dex */
public class x implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SoundPool a;

    /* renamed from: b  reason: collision with root package name */
    public final AudioManager f22449b;

    /* renamed from: c  reason: collision with root package name */
    public final List<p> f22450c;

    public x(Context context, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22450c = new ArrayList();
        if (!bVar.p) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.a = new SoundPool.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(14).setContentType(4).build()).setMaxStreams(bVar.q).build();
            } else {
                this.a = new SoundPool(bVar.q, 3, 0);
            }
            this.f22449b = (AudioManager) context.getSystemService("audio");
            if (context instanceof Activity) {
                ((Activity) context).setVolumeControlStream(3);
                return;
            }
            return;
        }
        this.a = null;
        this.f22449b = null;
    }

    @Override // c.b.b.e
    public c.b.b.k.b a(c.b.b.m.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if (this.a != null) {
                g gVar = (g) aVar;
                if (gVar.t() == Files.FileType.Internal) {
                    try {
                        AssetFileDescriptor u = gVar.u();
                        s sVar = new s(this.a, this.f22449b, this.a.load(u, 1));
                        u.close();
                        return sVar;
                    } catch (IOException e2) {
                        throw new GdxRuntimeException("Error loading audio file: " + aVar + "\nNote: Internal audio files must be placed in the assets directory.", e2);
                    }
                }
                try {
                    return new s(this.a, this.f22449b, this.a.load(gVar.e().getPath(), 1));
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
            synchronized (this.f22450c) {
                this.f22450c.remove(this);
            }
        }
    }

    @Override // c.b.b.q.h
    public void dispose() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a == null) {
            return;
        }
        synchronized (this.f22450c) {
            Iterator it = new ArrayList(this.f22450c).iterator();
            while (it.hasNext()) {
                ((p) it.next()).dispose();
            }
        }
        this.a.release();
    }

    @Override // c.b.b.e
    public c.b.b.k.a f(c.b.b.m.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) {
            if (this.a != null) {
                g gVar = (g) aVar;
                MediaPlayer mediaPlayer = new MediaPlayer();
                if (gVar.t() == Files.FileType.Internal) {
                    try {
                        AssetFileDescriptor u = gVar.u();
                        mediaPlayer.setDataSource(u.getFileDescriptor(), u.getStartOffset(), u.getLength());
                        u.close();
                        mediaPlayer.prepare();
                        p pVar = new p(this, mediaPlayer);
                        synchronized (this.f22450c) {
                            this.f22450c.add(pVar);
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
                    synchronized (this.f22450c) {
                        this.f22450c.add(pVar2);
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.a == null) {
            return;
        }
        synchronized (this.f22450c) {
            for (p pVar : this.f22450c) {
                if (pVar.a()) {
                    pVar.pause();
                    pVar.f22442d = true;
                } else {
                    pVar.f22442d = false;
                }
            }
        }
        this.a.autoPause();
    }

    @Override // c.b.b.l.a.d
    public void resume() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.a == null) {
            return;
        }
        synchronized (this.f22450c) {
            for (int i = 0; i < this.f22450c.size(); i++) {
                if (this.f22450c.get(i).f22442d) {
                    this.f22450c.get(i).f();
                }
            }
        }
        this.a.autoResume();
    }
}
