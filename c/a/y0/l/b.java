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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public MediaExtractor f26760b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f26761c;

    /* renamed from: d  reason: collision with root package name */
    public int f26762d;

    /* renamed from: e  reason: collision with root package name */
    public a f26763e;

    /* renamed from: f  reason: collision with root package name */
    public a f26764f;

    /* renamed from: g  reason: collision with root package name */
    public a f26765g;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public MediaFormat a;

        /* renamed from: b  reason: collision with root package name */
        public int f26766b;

        /* renamed from: c  reason: collision with root package name */
        public long f26767c;

        /* renamed from: d  reason: collision with root package name */
        public MediaCodec.BufferInfo f26768d;

        /* renamed from: e  reason: collision with root package name */
        public long f26769e;

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
            this.f26766b = -1;
            this.f26767c = 0L;
            this.f26768d = new MediaCodec.BufferInfo();
            this.f26769e = 0L;
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
        this.f26762d = 512000;
        this.f26763e = new a();
        this.f26764f = new a();
        this.f26765g = new a();
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f26760b.advance() : invokeV.booleanValue;
    }

    public a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f26763e : (a) invokeV.objValue;
    }

    public ByteBuffer c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f26761c : (ByteBuffer) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f26760b.getSampleTrackIndex() : invokeV.intValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f26765g.f26767c : invokeV.longValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f26760b.getSampleTrackIndex() : invokeV.intValue;
    }

    public a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f26764f : (a) invokeV.objValue;
    }

    public MediaCodec.BufferInfo h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? i(this.f26761c, 0) : (MediaCodec.BufferInfo) invokeV.objValue;
    }

    public MediaCodec.BufferInfo i(ByteBuffer byteBuffer, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer, i2)) == null) {
            int readSampleData = this.f26760b.readSampleData(byteBuffer, i2);
            if (readSampleData < 0) {
                return null;
            }
            a aVar = this.f26765g;
            aVar.f26768d.size = readSampleData;
            if (aVar == this.f26764f) {
                aVar.f26767c += aVar.f26769e;
            } else {
                aVar.f26767c = this.f26760b.getSampleTime();
            }
            a aVar2 = this.f26765g;
            MediaCodec.BufferInfo bufferInfo = aVar2.f26768d;
            bufferInfo.presentationTimeUs = aVar2.f26767c;
            bufferInfo.offset = 0;
            bufferInfo.flags = this.f26760b.getSampleFlags();
            return this.f26765g.f26768d;
        }
        return (MediaCodec.BufferInfo) invokeLI.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ByteBuffer byteBuffer = this.f26761c;
            if (byteBuffer != null) {
                byteBuffer.clear();
                this.f26761c = null;
            }
            this.f26760b.release();
        }
    }

    public void k(a aVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            a aVar2 = this.f26765g;
            if (aVar2 != null && (i3 = aVar2.f26766b) >= 0) {
                this.f26760b.unselectTrack(i3);
            }
            this.f26765g = aVar;
            if (aVar == null || (i2 = aVar.f26766b) < 0) {
                return;
            }
            this.f26760b.selectTrack(i2);
            a aVar3 = this.f26765g;
            aVar3.a = this.f26760b.getTrackFormat(aVar3.f26766b);
            try {
                this.f26765g.a.getLong("durationUs");
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
            this.f26760b = mediaExtractor;
            mediaExtractor.setDataSource(this.a);
            int trackCount = this.f26760b.getTrackCount();
            for (int i2 = 0; i2 < trackCount; i2++) {
                MediaFormat trackFormat = this.f26760b.getTrackFormat(i2);
                String string = trackFormat.getString("mime");
                if (string.startsWith(FileUtils.VIDEO_FILE_START)) {
                    a aVar = this.f26764f;
                    aVar.a = trackFormat;
                    aVar.f26766b = i2;
                    if (trackFormat.containsKey("max-input-size") && (integer = this.f26764f.a.getInteger("max-input-size")) > 0) {
                        this.f26762d = integer;
                    }
                } else if (string.startsWith("audio/")) {
                    a aVar2 = this.f26763e;
                    aVar2.a = trackFormat;
                    aVar2.f26766b = i2;
                }
            }
            if (this.f26761c == null) {
                this.f26761c = ByteBuffer.allocateDirect(this.f26762d);
            }
            if (this.f26764f.a != null) {
                try {
                    this.f26764f.f26769e = 1000000 / mediaFormat.getInteger("frame-rate");
                } catch (Exception e2) {
                    String str3 = "frameRate:" + e2.getMessage();
                    e2.printStackTrace();
                }
                if (this.f26764f.f26769e <= 0) {
                    k(g());
                    this.f26760b.readSampleData(this.f26761c, 0);
                    if (this.f26760b.getSampleFlags() == 1) {
                        this.f26760b.advance();
                    }
                    this.f26760b.readSampleData(this.f26761c, 0);
                    long sampleTime = this.f26760b.getSampleTime();
                    this.f26760b.advance();
                    this.f26764f.f26769e = Math.abs(this.f26760b.getSampleTime() - sampleTime);
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
