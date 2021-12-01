package c.i.b.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.audio.AudioProcessor;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class f implements u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final c.i.b.a.z.a<c.i.b.a.z.c> f30065b;

    /* renamed from: c  reason: collision with root package name */
    public final int f30066c;

    /* renamed from: d  reason: collision with root package name */
    public final long f30067d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(Context context, @Nullable c.i.b.a.z.a<c.i.b.a.z.c> aVar) {
        this(context, aVar, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (c.i.b.a.z.a) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.i.b.a.u
    public r[] a(Handler handler, c.i.b.a.j0.e eVar, c.i.b.a.x.d dVar, c.i.b.a.e0.j jVar, c.i.b.a.c0.d dVar2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, handler, eVar, dVar, jVar, dVar2)) == null) {
            ArrayList<r> arrayList = new ArrayList<>();
            g(this.a, this.f30065b, this.f30067d, handler, eVar, this.f30066c, arrayList);
            c(this.a, this.f30065b, b(), handler, dVar, this.f30066c, arrayList);
            f(this.a, jVar, handler.getLooper(), this.f30066c, arrayList);
            d(this.a, dVar2, handler.getLooper(), this.f30066c, arrayList);
            e(this.a, handler, this.f30066c, arrayList);
            return (r[]) arrayList.toArray(new r[arrayList.size()]);
        }
        return (r[]) invokeLLLLL.objValue;
    }

    public AudioProcessor[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new AudioProcessor[0] : (AudioProcessor[]) invokeV.objValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:7|(1:9)|10|11|12|13|(2:14|15)|16|17|18|(2:19|20)|(2:22|23)) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(Context context, @Nullable c.i.b.a.z.a<c.i.b.a.z.c> aVar, AudioProcessor[] audioProcessorArr, Handler handler, c.i.b.a.x.d dVar, int i2, ArrayList<r> arrayList) {
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, aVar, audioProcessorArr, handler, dVar, Integer.valueOf(i2), arrayList}) != null) {
            return;
        }
        arrayList.add(new c.i.b.a.x.g(c.i.b.a.b0.b.a, aVar, true, handler, dVar, c.i.b.a.x.c.a(context), audioProcessorArr));
        if (i2 == 0) {
            return;
        }
        int size = arrayList.size();
        if (i2 == 2) {
            size--;
        }
        try {
            try {
                i3 = size + 1;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        } catch (ClassNotFoundException unused) {
        }
        try {
            try {
                arrayList.add(size, (r) Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(Handler.class, c.i.b.a.x.d.class, AudioProcessor[].class).newInstance(handler, dVar, audioProcessorArr));
            } catch (ClassNotFoundException unused2) {
                size = i3;
                i3 = size;
                i4 = i3 + 1;
                arrayList.add(i3, (r) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, c.i.b.a.x.d.class, AudioProcessor[].class).newInstance(handler, dVar, audioProcessorArr));
                arrayList.add(i4, (r) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, c.i.b.a.x.d.class, AudioProcessor[].class).newInstance(handler, dVar, audioProcessorArr));
            }
            i4 = i3 + 1;
            try {
                arrayList.add(i3, (r) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, c.i.b.a.x.d.class, AudioProcessor[].class).newInstance(handler, dVar, audioProcessorArr));
            } catch (ClassNotFoundException unused3) {
                i3 = i4;
                i4 = i3;
                arrayList.add(i4, (r) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, c.i.b.a.x.d.class, AudioProcessor[].class).newInstance(handler, dVar, audioProcessorArr));
            }
            try {
                arrayList.add(i4, (r) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, c.i.b.a.x.d.class, AudioProcessor[].class).newInstance(handler, dVar, audioProcessorArr));
            } catch (ClassNotFoundException unused4) {
            } catch (Exception e3) {
                throw new RuntimeException(e3);
            }
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    public void d(Context context, c.i.b.a.c0.d dVar, Looper looper, int i2, ArrayList<r> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, dVar, looper, Integer.valueOf(i2), arrayList}) == null) {
            arrayList.add(new c.i.b.a.c0.e(dVar, looper));
        }
    }

    public void e(Context context, Handler handler, int i2, ArrayList<r> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048580, this, context, handler, i2, arrayList) == null) {
        }
    }

    public void f(Context context, c.i.b.a.e0.j jVar, Looper looper, int i2, ArrayList<r> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, jVar, looper, Integer.valueOf(i2), arrayList}) == null) {
            arrayList.add(new c.i.b.a.e0.k(jVar, looper));
        }
    }

    public void g(Context context, @Nullable c.i.b.a.z.a<c.i.b.a.z.c> aVar, long j2, Handler handler, c.i.b.a.j0.e eVar, int i2, ArrayList<r> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(1048582, this, new Object[]{context, aVar, Long.valueOf(j2), handler, eVar, Integer.valueOf(i2), arrayList}) != null) {
            return;
        }
        arrayList.add(new c.i.b.a.j0.c(context, c.i.b.a.b0.b.a, j2, aVar, false, handler, eVar, 50));
        if (i2 == 0) {
            return;
        }
        int size = arrayList.size();
        if (i2 == 2) {
            size--;
        }
        try {
            arrayList.add(size, (r) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(Boolean.TYPE, Long.TYPE, Handler.class, c.i.b.a.j0.e.class, Integer.TYPE).newInstance(Boolean.TRUE, Long.valueOf(j2), handler, eVar, 50));
        } catch (ClassNotFoundException unused) {
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(Context context, @Nullable c.i.b.a.z.a<c.i.b.a.z.c> aVar, int i2) {
        this(context, aVar, i2, 5000L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r8;
            Object[] objArr = {context, aVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (c.i.b.a.z.a) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Long) objArr2[3]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public f(Context context, @Nullable c.i.b.a.z.a<c.i.b.a.z.c> aVar, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, Integer.valueOf(i2), Long.valueOf(j2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = context;
        this.f30065b = aVar;
        this.f30066c = i2;
        this.f30067d = j2;
    }
}
