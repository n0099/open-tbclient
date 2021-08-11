package c.a.v0.l;

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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f30337a;

    /* renamed from: b  reason: collision with root package name */
    public MediaExtractor f30338b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f30339c;

    /* renamed from: d  reason: collision with root package name */
    public int f30340d;

    /* renamed from: e  reason: collision with root package name */
    public a f30341e;

    /* renamed from: f  reason: collision with root package name */
    public a f30342f;

    /* renamed from: g  reason: collision with root package name */
    public a f30343g;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public MediaFormat f30344a;

        /* renamed from: b  reason: collision with root package name */
        public int f30345b;

        /* renamed from: c  reason: collision with root package name */
        public long f30346c;

        /* renamed from: d  reason: collision with root package name */
        public MediaCodec.BufferInfo f30347d;

        /* renamed from: e  reason: collision with root package name */
        public long f30348e;

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
            this.f30344a = null;
            this.f30345b = -1;
            this.f30346c = 0L;
            this.f30347d = new MediaCodec.BufferInfo();
            this.f30348e = 0L;
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
        this.f30340d = 512000;
        this.f30341e = new a();
        this.f30342f = new a();
        this.f30343g = new a();
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f30338b.advance() : invokeV.booleanValue;
    }

    public a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f30341e : (a) invokeV.objValue;
    }

    public ByteBuffer c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30339c : (ByteBuffer) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f30338b.getSampleTrackIndex() : invokeV.intValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f30343g.f30346c : invokeV.longValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f30338b.getSampleTrackIndex() : invokeV.intValue;
    }

    public a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f30342f : (a) invokeV.objValue;
    }

    public MediaCodec.BufferInfo h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? i(this.f30339c, 0) : (MediaCodec.BufferInfo) invokeV.objValue;
    }

    public MediaCodec.BufferInfo i(ByteBuffer byteBuffer, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer, i2)) == null) {
            int readSampleData = this.f30338b.readSampleData(byteBuffer, i2);
            if (readSampleData < 0) {
                return null;
            }
            a aVar = this.f30343g;
            aVar.f30347d.size = readSampleData;
            if (aVar == this.f30342f) {
                aVar.f30346c += aVar.f30348e;
            } else {
                aVar.f30346c = this.f30338b.getSampleTime();
            }
            a aVar2 = this.f30343g;
            MediaCodec.BufferInfo bufferInfo = aVar2.f30347d;
            bufferInfo.presentationTimeUs = aVar2.f30346c;
            bufferInfo.offset = 0;
            bufferInfo.flags = this.f30338b.getSampleFlags();
            return this.f30343g.f30347d;
        }
        return (MediaCodec.BufferInfo) invokeLI.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ByteBuffer byteBuffer = this.f30339c;
            if (byteBuffer != null) {
                byteBuffer.clear();
                this.f30339c = null;
            }
            this.f30338b.release();
        }
    }

    public void k(a aVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            a aVar2 = this.f30343g;
            if (aVar2 != null && (i3 = aVar2.f30345b) >= 0) {
                this.f30338b.unselectTrack(i3);
            }
            this.f30343g = aVar;
            if (aVar == null || (i2 = aVar.f30345b) < 0) {
                return;
            }
            this.f30338b.selectTrack(i2);
            a aVar3 = this.f30343g;
            aVar3.f30344a = this.f30338b.getTrackFormat(aVar3.f30345b);
            try {
                this.f30343g.f30344a.getLong("durationUs");
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
            this.f30337a = str;
            FileUtils.VIDEO_FILE_START.equals(str2);
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.f30338b = mediaExtractor;
            mediaExtractor.setDataSource(this.f30337a);
            int trackCount = this.f30338b.getTrackCount();
            for (int i2 = 0; i2 < trackCount; i2++) {
                MediaFormat trackFormat = this.f30338b.getTrackFormat(i2);
                String string = trackFormat.getString("mime");
                if (string.startsWith(FileUtils.VIDEO_FILE_START)) {
                    a aVar = this.f30342f;
                    aVar.f30344a = trackFormat;
                    aVar.f30345b = i2;
                    if (trackFormat.containsKey("max-input-size") && (integer = this.f30342f.f30344a.getInteger("max-input-size")) > 0) {
                        this.f30340d = integer;
                    }
                } else if (string.startsWith("audio/")) {
                    a aVar2 = this.f30341e;
                    aVar2.f30344a = trackFormat;
                    aVar2.f30345b = i2;
                }
            }
            if (this.f30339c == null) {
                this.f30339c = ByteBuffer.allocateDirect(this.f30340d);
            }
            if (this.f30342f.f30344a != null) {
                try {
                    this.f30342f.f30348e = 1000000 / mediaFormat.getInteger("frame-rate");
                } catch (Exception e2) {
                    String str3 = "frameRate:" + e2.getMessage();
                    e2.printStackTrace();
                }
                if (this.f30342f.f30348e <= 0) {
                    k(g());
                    this.f30338b.readSampleData(this.f30339c, 0);
                    if (this.f30338b.getSampleFlags() == 1) {
                        this.f30338b.advance();
                    }
                    this.f30338b.readSampleData(this.f30339c, 0);
                    long sampleTime = this.f30338b.getSampleTime();
                    this.f30338b.advance();
                    this.f30342f.f30348e = Math.abs(this.f30338b.getSampleTime() - sampleTime);
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
