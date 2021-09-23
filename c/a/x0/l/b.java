package c.a.x0.l;

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
    public String f30931a;

    /* renamed from: b  reason: collision with root package name */
    public MediaExtractor f30932b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f30933c;

    /* renamed from: d  reason: collision with root package name */
    public int f30934d;

    /* renamed from: e  reason: collision with root package name */
    public a f30935e;

    /* renamed from: f  reason: collision with root package name */
    public a f30936f;

    /* renamed from: g  reason: collision with root package name */
    public a f30937g;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public MediaFormat f30938a;

        /* renamed from: b  reason: collision with root package name */
        public int f30939b;

        /* renamed from: c  reason: collision with root package name */
        public long f30940c;

        /* renamed from: d  reason: collision with root package name */
        public MediaCodec.BufferInfo f30941d;

        /* renamed from: e  reason: collision with root package name */
        public long f30942e;

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
            this.f30938a = null;
            this.f30939b = -1;
            this.f30940c = 0L;
            this.f30941d = new MediaCodec.BufferInfo();
            this.f30942e = 0L;
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
        this.f30934d = 512000;
        this.f30935e = new a();
        this.f30936f = new a();
        this.f30937g = new a();
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f30932b.advance() : invokeV.booleanValue;
    }

    public a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f30935e : (a) invokeV.objValue;
    }

    public ByteBuffer c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30933c : (ByteBuffer) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f30932b.getSampleTrackIndex() : invokeV.intValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f30937g.f30940c : invokeV.longValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f30932b.getSampleTrackIndex() : invokeV.intValue;
    }

    public a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f30936f : (a) invokeV.objValue;
    }

    public MediaCodec.BufferInfo h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? i(this.f30933c, 0) : (MediaCodec.BufferInfo) invokeV.objValue;
    }

    public MediaCodec.BufferInfo i(ByteBuffer byteBuffer, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer, i2)) == null) {
            int readSampleData = this.f30932b.readSampleData(byteBuffer, i2);
            if (readSampleData < 0) {
                return null;
            }
            a aVar = this.f30937g;
            aVar.f30941d.size = readSampleData;
            if (aVar == this.f30936f) {
                aVar.f30940c += aVar.f30942e;
            } else {
                aVar.f30940c = this.f30932b.getSampleTime();
            }
            a aVar2 = this.f30937g;
            MediaCodec.BufferInfo bufferInfo = aVar2.f30941d;
            bufferInfo.presentationTimeUs = aVar2.f30940c;
            bufferInfo.offset = 0;
            bufferInfo.flags = this.f30932b.getSampleFlags();
            return this.f30937g.f30941d;
        }
        return (MediaCodec.BufferInfo) invokeLI.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ByteBuffer byteBuffer = this.f30933c;
            if (byteBuffer != null) {
                byteBuffer.clear();
                this.f30933c = null;
            }
            this.f30932b.release();
        }
    }

    public void k(a aVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            a aVar2 = this.f30937g;
            if (aVar2 != null && (i3 = aVar2.f30939b) >= 0) {
                this.f30932b.unselectTrack(i3);
            }
            this.f30937g = aVar;
            if (aVar == null || (i2 = aVar.f30939b) < 0) {
                return;
            }
            this.f30932b.selectTrack(i2);
            a aVar3 = this.f30937g;
            aVar3.f30938a = this.f30932b.getTrackFormat(aVar3.f30939b);
            try {
                this.f30937g.f30938a.getLong("durationUs");
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
            this.f30931a = str;
            FileUtils.VIDEO_FILE_START.equals(str2);
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.f30932b = mediaExtractor;
            mediaExtractor.setDataSource(this.f30931a);
            int trackCount = this.f30932b.getTrackCount();
            for (int i2 = 0; i2 < trackCount; i2++) {
                MediaFormat trackFormat = this.f30932b.getTrackFormat(i2);
                String string = trackFormat.getString("mime");
                if (string.startsWith(FileUtils.VIDEO_FILE_START)) {
                    a aVar = this.f30936f;
                    aVar.f30938a = trackFormat;
                    aVar.f30939b = i2;
                    if (trackFormat.containsKey("max-input-size") && (integer = this.f30936f.f30938a.getInteger("max-input-size")) > 0) {
                        this.f30934d = integer;
                    }
                } else if (string.startsWith("audio/")) {
                    a aVar2 = this.f30935e;
                    aVar2.f30938a = trackFormat;
                    aVar2.f30939b = i2;
                }
            }
            if (this.f30933c == null) {
                this.f30933c = ByteBuffer.allocateDirect(this.f30934d);
            }
            if (this.f30936f.f30938a != null) {
                try {
                    this.f30936f.f30942e = 1000000 / mediaFormat.getInteger("frame-rate");
                } catch (Exception e2) {
                    String str3 = "frameRate:" + e2.getMessage();
                    e2.printStackTrace();
                }
                if (this.f30936f.f30942e <= 0) {
                    k(g());
                    this.f30932b.readSampleData(this.f30933c, 0);
                    if (this.f30932b.getSampleFlags() == 1) {
                        this.f30932b.advance();
                    }
                    this.f30932b.readSampleData(this.f30933c, 0);
                    long sampleTime = this.f30932b.getSampleTime();
                    this.f30932b.advance();
                    this.f30936f.f30942e = Math.abs(this.f30932b.getSampleTime() - sampleTime);
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
