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
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public MediaExtractor f26989b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f26990c;

    /* renamed from: d  reason: collision with root package name */
    public int f26991d;

    /* renamed from: e  reason: collision with root package name */
    public a f26992e;

    /* renamed from: f  reason: collision with root package name */
    public a f26993f;

    /* renamed from: g  reason: collision with root package name */
    public a f26994g;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public MediaFormat a;

        /* renamed from: b  reason: collision with root package name */
        public int f26995b;

        /* renamed from: c  reason: collision with root package name */
        public long f26996c;

        /* renamed from: d  reason: collision with root package name */
        public MediaCodec.BufferInfo f26997d;

        /* renamed from: e  reason: collision with root package name */
        public long f26998e;

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
            this.f26995b = -1;
            this.f26996c = 0L;
            this.f26997d = new MediaCodec.BufferInfo();
            this.f26998e = 0L;
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
        this.f26991d = 512000;
        this.f26992e = new a();
        this.f26993f = new a();
        this.f26994g = new a();
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f26989b.advance() : invokeV.booleanValue;
    }

    public a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f26992e : (a) invokeV.objValue;
    }

    public ByteBuffer c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f26990c : (ByteBuffer) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f26989b.getSampleTrackIndex() : invokeV.intValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f26994g.f26996c : invokeV.longValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f26989b.getSampleTrackIndex() : invokeV.intValue;
    }

    public a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f26993f : (a) invokeV.objValue;
    }

    public MediaCodec.BufferInfo h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? i(this.f26990c, 0) : (MediaCodec.BufferInfo) invokeV.objValue;
    }

    public MediaCodec.BufferInfo i(ByteBuffer byteBuffer, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer, i2)) == null) {
            int readSampleData = this.f26989b.readSampleData(byteBuffer, i2);
            if (readSampleData < 0) {
                return null;
            }
            a aVar = this.f26994g;
            aVar.f26997d.size = readSampleData;
            if (aVar == this.f26993f) {
                aVar.f26996c += aVar.f26998e;
            } else {
                aVar.f26996c = this.f26989b.getSampleTime();
            }
            a aVar2 = this.f26994g;
            MediaCodec.BufferInfo bufferInfo = aVar2.f26997d;
            bufferInfo.presentationTimeUs = aVar2.f26996c;
            bufferInfo.offset = 0;
            bufferInfo.flags = this.f26989b.getSampleFlags();
            return this.f26994g.f26997d;
        }
        return (MediaCodec.BufferInfo) invokeLI.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ByteBuffer byteBuffer = this.f26990c;
            if (byteBuffer != null) {
                byteBuffer.clear();
                this.f26990c = null;
            }
            this.f26989b.release();
        }
    }

    public void k(a aVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            a aVar2 = this.f26994g;
            if (aVar2 != null && (i3 = aVar2.f26995b) >= 0) {
                this.f26989b.unselectTrack(i3);
            }
            this.f26994g = aVar;
            if (aVar == null || (i2 = aVar.f26995b) < 0) {
                return;
            }
            this.f26989b.selectTrack(i2);
            a aVar3 = this.f26994g;
            aVar3.a = this.f26989b.getTrackFormat(aVar3.f26995b);
            try {
                this.f26994g.a.getLong("durationUs");
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
            this.f26989b = mediaExtractor;
            mediaExtractor.setDataSource(this.a);
            int trackCount = this.f26989b.getTrackCount();
            for (int i2 = 0; i2 < trackCount; i2++) {
                MediaFormat trackFormat = this.f26989b.getTrackFormat(i2);
                String string = trackFormat.getString("mime");
                if (string.startsWith(FileUtils.VIDEO_FILE_START)) {
                    a aVar = this.f26993f;
                    aVar.a = trackFormat;
                    aVar.f26995b = i2;
                    if (trackFormat.containsKey("max-input-size") && (integer = this.f26993f.a.getInteger("max-input-size")) > 0) {
                        this.f26991d = integer;
                    }
                } else if (string.startsWith("audio/")) {
                    a aVar2 = this.f26992e;
                    aVar2.a = trackFormat;
                    aVar2.f26995b = i2;
                }
            }
            if (this.f26990c == null) {
                this.f26990c = ByteBuffer.allocateDirect(this.f26991d);
            }
            if (this.f26993f.a != null) {
                try {
                    this.f26993f.f26998e = 1000000 / mediaFormat.getInteger("frame-rate");
                } catch (Exception e2) {
                    String str3 = "frameRate:" + e2.getMessage();
                    e2.printStackTrace();
                }
                if (this.f26993f.f26998e <= 0) {
                    k(g());
                    this.f26989b.readSampleData(this.f26990c, 0);
                    if (this.f26989b.getSampleFlags() == 1) {
                        this.f26989b.advance();
                    }
                    this.f26989b.readSampleData(this.f26990c, 0);
                    long sampleTime = this.f26989b.getSampleTime();
                    this.f26989b.advance();
                    this.f26993f.f26998e = Math.abs(this.f26989b.getSampleTime() - sampleTime);
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
