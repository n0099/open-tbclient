package c.a.v0.l;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.util.Log;
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
    public MediaExtractor f21669b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f21670c;

    /* renamed from: d  reason: collision with root package name */
    public int f21671d;

    /* renamed from: e  reason: collision with root package name */
    public a f21672e;

    /* renamed from: f  reason: collision with root package name */
    public a f21673f;

    /* renamed from: g  reason: collision with root package name */
    public a f21674g;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public MediaFormat a;

        /* renamed from: b  reason: collision with root package name */
        public int f21675b;

        /* renamed from: c  reason: collision with root package name */
        public long f21676c;

        /* renamed from: d  reason: collision with root package name */
        public MediaCodec.BufferInfo f21677d;

        /* renamed from: e  reason: collision with root package name */
        public long f21678e;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.f21675b = -1;
            this.f21676c = 0L;
            this.f21677d = new MediaCodec.BufferInfo();
            this.f21678e = 0L;
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21671d = 512000;
        this.f21672e = new a();
        this.f21673f = new a();
        this.f21674g = new a();
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21669b.advance() : invokeV.booleanValue;
    }

    public a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f21672e : (a) invokeV.objValue;
    }

    public ByteBuffer c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21670c : (ByteBuffer) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f21669b.getSampleTrackIndex() : invokeV.intValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f21674g.f21676c : invokeV.longValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f21669b.getSampleTrackIndex() : invokeV.intValue;
    }

    public a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f21673f : (a) invokeV.objValue;
    }

    public MediaCodec.BufferInfo h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? i(this.f21670c, 0) : (MediaCodec.BufferInfo) invokeV.objValue;
    }

    public MediaCodec.BufferInfo i(ByteBuffer byteBuffer, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer, i)) == null) {
            int readSampleData = this.f21669b.readSampleData(byteBuffer, i);
            if (readSampleData < 0) {
                return null;
            }
            a aVar = this.f21674g;
            aVar.f21677d.size = readSampleData;
            if (aVar == this.f21673f) {
                aVar.f21676c += aVar.f21678e;
            } else {
                aVar.f21676c = this.f21669b.getSampleTime();
            }
            a aVar2 = this.f21674g;
            MediaCodec.BufferInfo bufferInfo = aVar2.f21677d;
            bufferInfo.presentationTimeUs = aVar2.f21676c;
            bufferInfo.offset = 0;
            bufferInfo.flags = this.f21669b.getSampleFlags();
            return this.f21674g.f21677d;
        }
        return (MediaCodec.BufferInfo) invokeLI.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ByteBuffer byteBuffer = this.f21670c;
            if (byteBuffer != null) {
                byteBuffer.clear();
                this.f21670c = null;
            }
            this.f21669b.release();
        }
    }

    public void k(a aVar) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            a aVar2 = this.f21674g;
            if (aVar2 != null && (i2 = aVar2.f21675b) >= 0) {
                this.f21669b.unselectTrack(i2);
            }
            this.f21674g = aVar;
            if (aVar == null || (i = aVar.f21675b) < 0) {
                return;
            }
            this.f21669b.selectTrack(i);
            a aVar3 = this.f21674g;
            aVar3.a = this.f21669b.getTrackFormat(aVar3.f21675b);
            try {
                this.f21674g.a.getLong("durationUs");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
        }
    }

    public void m(String str, String str2) throws IOException {
        int integer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) {
            this.a = str;
            FileUtils.VIDEO_FILE_START.equals(str2);
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.f21669b = mediaExtractor;
            mediaExtractor.setDataSource(this.a);
            int trackCount = this.f21669b.getTrackCount();
            for (int i = 0; i < trackCount; i++) {
                MediaFormat trackFormat = this.f21669b.getTrackFormat(i);
                String string = trackFormat.getString("mime");
                if (string.startsWith(FileUtils.VIDEO_FILE_START)) {
                    a aVar = this.f21673f;
                    aVar.a = trackFormat;
                    aVar.f21675b = i;
                    if (trackFormat.containsKey("max-input-size") && (integer = this.f21673f.a.getInteger("max-input-size")) > 0) {
                        this.f21671d = integer;
                    }
                } else if (string.startsWith("audio/")) {
                    a aVar2 = this.f21672e;
                    aVar2.a = trackFormat;
                    aVar2.f21675b = i;
                }
            }
            if (this.f21670c == null) {
                this.f21670c = ByteBuffer.allocateDirect(this.f21671d);
            }
            MediaFormat mediaFormat = this.f21673f.a;
            if (mediaFormat != null) {
                try {
                    this.f21673f.f21678e = 1000000 / mediaFormat.getInteger("frame-rate");
                } catch (Exception e2) {
                    Log.e("VideoExtractor", "frameRate:" + e2.getMessage());
                    e2.printStackTrace();
                }
                if (this.f21673f.f21678e <= 0) {
                    k(g());
                    this.f21669b.readSampleData(this.f21670c, 0);
                    if (this.f21669b.getSampleFlags() == 1) {
                        this.f21669b.advance();
                    }
                    this.f21669b.readSampleData(this.f21670c, 0);
                    long sampleTime = this.f21669b.getSampleTime();
                    this.f21669b.advance();
                    this.f21673f.f21678e = Math.abs(this.f21669b.getSampleTime() - sampleTime);
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
