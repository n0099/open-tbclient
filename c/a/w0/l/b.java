package c.a.w0.l;

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
    public String f30678a;

    /* renamed from: b  reason: collision with root package name */
    public MediaExtractor f30679b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f30680c;

    /* renamed from: d  reason: collision with root package name */
    public int f30681d;

    /* renamed from: e  reason: collision with root package name */
    public a f30682e;

    /* renamed from: f  reason: collision with root package name */
    public a f30683f;

    /* renamed from: g  reason: collision with root package name */
    public a f30684g;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public MediaFormat f30685a;

        /* renamed from: b  reason: collision with root package name */
        public int f30686b;

        /* renamed from: c  reason: collision with root package name */
        public long f30687c;

        /* renamed from: d  reason: collision with root package name */
        public MediaCodec.BufferInfo f30688d;

        /* renamed from: e  reason: collision with root package name */
        public long f30689e;

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
            this.f30685a = null;
            this.f30686b = -1;
            this.f30687c = 0L;
            this.f30688d = new MediaCodec.BufferInfo();
            this.f30689e = 0L;
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
        this.f30681d = 512000;
        this.f30682e = new a();
        this.f30683f = new a();
        this.f30684g = new a();
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f30679b.advance() : invokeV.booleanValue;
    }

    public a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f30682e : (a) invokeV.objValue;
    }

    public ByteBuffer c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30680c : (ByteBuffer) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f30679b.getSampleTrackIndex() : invokeV.intValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f30684g.f30687c : invokeV.longValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f30679b.getSampleTrackIndex() : invokeV.intValue;
    }

    public a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f30683f : (a) invokeV.objValue;
    }

    public MediaCodec.BufferInfo h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? i(this.f30680c, 0) : (MediaCodec.BufferInfo) invokeV.objValue;
    }

    public MediaCodec.BufferInfo i(ByteBuffer byteBuffer, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer, i2)) == null) {
            int readSampleData = this.f30679b.readSampleData(byteBuffer, i2);
            if (readSampleData < 0) {
                return null;
            }
            a aVar = this.f30684g;
            aVar.f30688d.size = readSampleData;
            if (aVar == this.f30683f) {
                aVar.f30687c += aVar.f30689e;
            } else {
                aVar.f30687c = this.f30679b.getSampleTime();
            }
            a aVar2 = this.f30684g;
            MediaCodec.BufferInfo bufferInfo = aVar2.f30688d;
            bufferInfo.presentationTimeUs = aVar2.f30687c;
            bufferInfo.offset = 0;
            bufferInfo.flags = this.f30679b.getSampleFlags();
            return this.f30684g.f30688d;
        }
        return (MediaCodec.BufferInfo) invokeLI.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ByteBuffer byteBuffer = this.f30680c;
            if (byteBuffer != null) {
                byteBuffer.clear();
                this.f30680c = null;
            }
            this.f30679b.release();
        }
    }

    public void k(a aVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            a aVar2 = this.f30684g;
            if (aVar2 != null && (i3 = aVar2.f30686b) >= 0) {
                this.f30679b.unselectTrack(i3);
            }
            this.f30684g = aVar;
            if (aVar == null || (i2 = aVar.f30686b) < 0) {
                return;
            }
            this.f30679b.selectTrack(i2);
            a aVar3 = this.f30684g;
            aVar3.f30685a = this.f30679b.getTrackFormat(aVar3.f30686b);
            try {
                this.f30684g.f30685a.getLong("durationUs");
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
            this.f30678a = str;
            FileUtils.VIDEO_FILE_START.equals(str2);
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.f30679b = mediaExtractor;
            mediaExtractor.setDataSource(this.f30678a);
            int trackCount = this.f30679b.getTrackCount();
            for (int i2 = 0; i2 < trackCount; i2++) {
                MediaFormat trackFormat = this.f30679b.getTrackFormat(i2);
                String string = trackFormat.getString("mime");
                if (string.startsWith(FileUtils.VIDEO_FILE_START)) {
                    a aVar = this.f30683f;
                    aVar.f30685a = trackFormat;
                    aVar.f30686b = i2;
                    if (trackFormat.containsKey("max-input-size") && (integer = this.f30683f.f30685a.getInteger("max-input-size")) > 0) {
                        this.f30681d = integer;
                    }
                } else if (string.startsWith("audio/")) {
                    a aVar2 = this.f30682e;
                    aVar2.f30685a = trackFormat;
                    aVar2.f30686b = i2;
                }
            }
            if (this.f30680c == null) {
                this.f30680c = ByteBuffer.allocateDirect(this.f30681d);
            }
            if (this.f30683f.f30685a != null) {
                try {
                    this.f30683f.f30689e = 1000000 / mediaFormat.getInteger("frame-rate");
                } catch (Exception e2) {
                    String str3 = "frameRate:" + e2.getMessage();
                    e2.printStackTrace();
                }
                if (this.f30683f.f30689e <= 0) {
                    k(g());
                    this.f30679b.readSampleData(this.f30680c, 0);
                    if (this.f30679b.getSampleFlags() == 1) {
                        this.f30679b.advance();
                    }
                    this.f30679b.readSampleData(this.f30680c, 0);
                    long sampleTime = this.f30679b.getSampleTime();
                    this.f30679b.advance();
                    this.f30683f.f30689e = Math.abs(this.f30679b.getSampleTime() - sampleTime);
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
