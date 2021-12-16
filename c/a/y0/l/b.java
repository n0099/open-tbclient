package c.a.y0.l;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
@RequiresApi(api = 16)
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public MediaExtractor f27382b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f27383c;

    /* renamed from: d  reason: collision with root package name */
    public int f27384d;

    /* renamed from: e  reason: collision with root package name */
    public a f27385e;

    /* renamed from: f  reason: collision with root package name */
    public a f27386f;

    /* renamed from: g  reason: collision with root package name */
    public a f27387g;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public MediaFormat a;

        /* renamed from: b  reason: collision with root package name */
        public int f27388b;

        /* renamed from: c  reason: collision with root package name */
        public long f27389c;

        /* renamed from: d  reason: collision with root package name */
        public MediaCodec.BufferInfo f27390d;

        /* renamed from: e  reason: collision with root package name */
        public long f27391e;

        public a() {
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
            this.a = null;
            this.f27388b = -1;
            this.f27389c = 0L;
            this.f27390d = new MediaCodec.BufferInfo();
            this.f27391e = 0L;
        }
    }

    public b() {
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
        this.f27384d = 512000;
        this.f27385e = new a();
        this.f27386f = new a();
        this.f27387g = new a();
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f27382b.advance() : invokeV.booleanValue;
    }

    public a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27385e : (a) invokeV.objValue;
    }

    public ByteBuffer c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27383c : (ByteBuffer) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f27382b.getSampleTrackIndex() : invokeV.intValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f27387g.f27389c : invokeV.longValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f27382b.getSampleTrackIndex() : invokeV.intValue;
    }

    public a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f27386f : (a) invokeV.objValue;
    }

    public MediaCodec.BufferInfo h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? i(this.f27383c, 0) : (MediaCodec.BufferInfo) invokeV.objValue;
    }

    public MediaCodec.BufferInfo i(ByteBuffer byteBuffer, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer, i2)) == null) {
            int readSampleData = this.f27382b.readSampleData(byteBuffer, i2);
            if (readSampleData < 0) {
                return null;
            }
            a aVar = this.f27387g;
            aVar.f27390d.size = readSampleData;
            if (aVar == this.f27386f) {
                aVar.f27389c += aVar.f27391e;
            } else {
                aVar.f27389c = this.f27382b.getSampleTime();
            }
            a aVar2 = this.f27387g;
            MediaCodec.BufferInfo bufferInfo = aVar2.f27390d;
            bufferInfo.presentationTimeUs = aVar2.f27389c;
            bufferInfo.offset = 0;
            bufferInfo.flags = this.f27382b.getSampleFlags();
            return this.f27387g.f27390d;
        }
        return (MediaCodec.BufferInfo) invokeLI.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ByteBuffer byteBuffer = this.f27383c;
            if (byteBuffer != null) {
                byteBuffer.clear();
                this.f27383c = null;
            }
            this.f27382b.release();
        }
    }

    public void k(a aVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            a aVar2 = this.f27387g;
            if (aVar2 != null && (i3 = aVar2.f27388b) >= 0) {
                this.f27382b.unselectTrack(i3);
            }
            this.f27387g = aVar;
            if (aVar == null || (i2 = aVar.f27388b) < 0) {
                return;
            }
            this.f27382b.selectTrack(i2);
            a aVar3 = this.f27387g;
            aVar3.a = this.f27382b.getTrackFormat(aVar3.f27388b);
            try {
                this.f27387g.a.getLong("durationUs");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
        }
    }

    public void m(String str, String str2) throws IOException {
        MediaFormat mediaFormat;
        int integer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) {
            this.a = str;
            FileUtils.VIDEO_FILE_START.equals(str2);
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.f27382b = mediaExtractor;
            mediaExtractor.setDataSource(this.a);
            int trackCount = this.f27382b.getTrackCount();
            for (int i2 = 0; i2 < trackCount; i2++) {
                MediaFormat trackFormat = this.f27382b.getTrackFormat(i2);
                String string = trackFormat.getString("mime");
                if (string.startsWith(FileUtils.VIDEO_FILE_START)) {
                    a aVar = this.f27386f;
                    aVar.a = trackFormat;
                    aVar.f27388b = i2;
                    if (trackFormat.containsKey("max-input-size") && (integer = this.f27386f.a.getInteger("max-input-size")) > 0) {
                        this.f27384d = integer;
                    }
                } else if (string.startsWith("audio/")) {
                    a aVar2 = this.f27385e;
                    aVar2.a = trackFormat;
                    aVar2.f27388b = i2;
                }
            }
            if (this.f27383c == null) {
                this.f27383c = ByteBuffer.allocateDirect(this.f27384d);
            }
            if (this.f27386f.a != null) {
                try {
                    this.f27386f.f27391e = 1000000 / mediaFormat.getInteger("frame-rate");
                } catch (Exception e2) {
                    String str3 = "frameRate:" + e2.getMessage();
                    e2.printStackTrace();
                }
                if (this.f27386f.f27391e <= 0) {
                    k(g());
                    this.f27382b.readSampleData(this.f27383c, 0);
                    if (this.f27382b.getSampleFlags() == 1) {
                        this.f27382b.advance();
                    }
                    this.f27382b.readSampleData(this.f27383c, 0);
                    long sampleTime = this.f27382b.getSampleTime();
                    this.f27382b.advance();
                    this.f27386f.f27391e = Math.abs(this.f27382b.getSampleTime() - sampleTime);
                }
            }
            if (FileUtils.VIDEO_FILE_START.equals(str2)) {
                k(g());
            } else if ("audio/".equals(str2)) {
                k(b());
            }
        }
    }
}
