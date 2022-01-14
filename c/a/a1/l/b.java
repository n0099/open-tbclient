package c.a.a1.l;

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
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public MediaExtractor f1274b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f1275c;

    /* renamed from: d  reason: collision with root package name */
    public int f1276d;

    /* renamed from: e  reason: collision with root package name */
    public a f1277e;

    /* renamed from: f  reason: collision with root package name */
    public a f1278f;

    /* renamed from: g  reason: collision with root package name */
    public a f1279g;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public MediaFormat a;

        /* renamed from: b  reason: collision with root package name */
        public int f1280b;

        /* renamed from: c  reason: collision with root package name */
        public long f1281c;

        /* renamed from: d  reason: collision with root package name */
        public MediaCodec.BufferInfo f1282d;

        /* renamed from: e  reason: collision with root package name */
        public long f1283e;

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
            this.f1280b = -1;
            this.f1281c = 0L;
            this.f1282d = new MediaCodec.BufferInfo();
            this.f1283e = 0L;
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
        this.f1276d = 512000;
        this.f1277e = new a();
        this.f1278f = new a();
        this.f1279g = new a();
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f1274b.advance() : invokeV.booleanValue;
    }

    public a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1277e : (a) invokeV.objValue;
    }

    public ByteBuffer c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f1275c : (ByteBuffer) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f1274b.getSampleTrackIndex() : invokeV.intValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f1279g.f1281c : invokeV.longValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f1274b.getSampleTrackIndex() : invokeV.intValue;
    }

    public a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f1278f : (a) invokeV.objValue;
    }

    public MediaCodec.BufferInfo h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? i(this.f1275c, 0) : (MediaCodec.BufferInfo) invokeV.objValue;
    }

    public MediaCodec.BufferInfo i(ByteBuffer byteBuffer, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer, i2)) == null) {
            int readSampleData = this.f1274b.readSampleData(byteBuffer, i2);
            if (readSampleData < 0) {
                return null;
            }
            a aVar = this.f1279g;
            aVar.f1282d.size = readSampleData;
            if (aVar == this.f1278f) {
                aVar.f1281c += aVar.f1283e;
            } else {
                aVar.f1281c = this.f1274b.getSampleTime();
            }
            a aVar2 = this.f1279g;
            MediaCodec.BufferInfo bufferInfo = aVar2.f1282d;
            bufferInfo.presentationTimeUs = aVar2.f1281c;
            bufferInfo.offset = 0;
            bufferInfo.flags = this.f1274b.getSampleFlags();
            return this.f1279g.f1282d;
        }
        return (MediaCodec.BufferInfo) invokeLI.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ByteBuffer byteBuffer = this.f1275c;
            if (byteBuffer != null) {
                byteBuffer.clear();
                this.f1275c = null;
            }
            this.f1274b.release();
        }
    }

    public void k(a aVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            a aVar2 = this.f1279g;
            if (aVar2 != null && (i3 = aVar2.f1280b) >= 0) {
                this.f1274b.unselectTrack(i3);
            }
            this.f1279g = aVar;
            if (aVar == null || (i2 = aVar.f1280b) < 0) {
                return;
            }
            this.f1274b.selectTrack(i2);
            a aVar3 = this.f1279g;
            aVar3.a = this.f1274b.getTrackFormat(aVar3.f1280b);
            try {
                this.f1279g.a.getLong("durationUs");
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
            this.f1274b = mediaExtractor;
            mediaExtractor.setDataSource(this.a);
            int trackCount = this.f1274b.getTrackCount();
            for (int i2 = 0; i2 < trackCount; i2++) {
                MediaFormat trackFormat = this.f1274b.getTrackFormat(i2);
                String string = trackFormat.getString("mime");
                if (string.startsWith(FileUtils.VIDEO_FILE_START)) {
                    a aVar = this.f1278f;
                    aVar.a = trackFormat;
                    aVar.f1280b = i2;
                    if (trackFormat.containsKey("max-input-size") && (integer = this.f1278f.a.getInteger("max-input-size")) > 0) {
                        this.f1276d = integer;
                    }
                } else if (string.startsWith("audio/")) {
                    a aVar2 = this.f1277e;
                    aVar2.a = trackFormat;
                    aVar2.f1280b = i2;
                }
            }
            if (this.f1275c == null) {
                this.f1275c = ByteBuffer.allocateDirect(this.f1276d);
            }
            if (this.f1278f.a != null) {
                try {
                    this.f1278f.f1283e = 1000000 / mediaFormat.getInteger("frame-rate");
                } catch (Exception e2) {
                    String str3 = "frameRate:" + e2.getMessage();
                    e2.printStackTrace();
                }
                if (this.f1278f.f1283e <= 0) {
                    k(g());
                    this.f1274b.readSampleData(this.f1275c, 0);
                    if (this.f1274b.getSampleFlags() == 1) {
                        this.f1274b.advance();
                    }
                    this.f1274b.readSampleData(this.f1275c, 0);
                    long sampleTime = this.f1274b.getSampleTime();
                    this.f1274b.advance();
                    this.f1278f.f1283e = Math.abs(this.f1274b.getSampleTime() - sampleTime);
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
