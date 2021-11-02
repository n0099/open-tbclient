package b.a.x0.l;

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
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f29680a;

    /* renamed from: b  reason: collision with root package name */
    public MediaExtractor f29681b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f29682c;

    /* renamed from: d  reason: collision with root package name */
    public int f29683d;

    /* renamed from: e  reason: collision with root package name */
    public a f29684e;

    /* renamed from: f  reason: collision with root package name */
    public a f29685f;

    /* renamed from: g  reason: collision with root package name */
    public a f29686g;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public MediaFormat f29687a;

        /* renamed from: b  reason: collision with root package name */
        public int f29688b;

        /* renamed from: c  reason: collision with root package name */
        public long f29689c;

        /* renamed from: d  reason: collision with root package name */
        public MediaCodec.BufferInfo f29690d;

        /* renamed from: e  reason: collision with root package name */
        public long f29691e;

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
            this.f29687a = null;
            this.f29688b = -1;
            this.f29689c = 0L;
            this.f29690d = new MediaCodec.BufferInfo();
            this.f29691e = 0L;
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
        this.f29683d = 512000;
        this.f29684e = new a();
        this.f29685f = new a();
        this.f29686g = new a();
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f29681b.advance() : invokeV.booleanValue;
    }

    public a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f29684e : (a) invokeV.objValue;
    }

    public ByteBuffer c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f29682c : (ByteBuffer) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f29681b.getSampleTrackIndex() : invokeV.intValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f29686g.f29689c : invokeV.longValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f29681b.getSampleTrackIndex() : invokeV.intValue;
    }

    public a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f29685f : (a) invokeV.objValue;
    }

    public MediaCodec.BufferInfo h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? i(this.f29682c, 0) : (MediaCodec.BufferInfo) invokeV.objValue;
    }

    public MediaCodec.BufferInfo i(ByteBuffer byteBuffer, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer, i2)) == null) {
            int readSampleData = this.f29681b.readSampleData(byteBuffer, i2);
            if (readSampleData < 0) {
                return null;
            }
            a aVar = this.f29686g;
            aVar.f29690d.size = readSampleData;
            if (aVar == this.f29685f) {
                aVar.f29689c += aVar.f29691e;
            } else {
                aVar.f29689c = this.f29681b.getSampleTime();
            }
            a aVar2 = this.f29686g;
            MediaCodec.BufferInfo bufferInfo = aVar2.f29690d;
            bufferInfo.presentationTimeUs = aVar2.f29689c;
            bufferInfo.offset = 0;
            bufferInfo.flags = this.f29681b.getSampleFlags();
            return this.f29686g.f29690d;
        }
        return (MediaCodec.BufferInfo) invokeLI.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ByteBuffer byteBuffer = this.f29682c;
            if (byteBuffer != null) {
                byteBuffer.clear();
                this.f29682c = null;
            }
            this.f29681b.release();
        }
    }

    public void k(a aVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            a aVar2 = this.f29686g;
            if (aVar2 != null && (i3 = aVar2.f29688b) >= 0) {
                this.f29681b.unselectTrack(i3);
            }
            this.f29686g = aVar;
            if (aVar == null || (i2 = aVar.f29688b) < 0) {
                return;
            }
            this.f29681b.selectTrack(i2);
            a aVar3 = this.f29686g;
            aVar3.f29687a = this.f29681b.getTrackFormat(aVar3.f29688b);
            try {
                this.f29686g.f29687a.getLong("durationUs");
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
            this.f29680a = str;
            FileUtils.VIDEO_FILE_START.equals(str2);
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.f29681b = mediaExtractor;
            mediaExtractor.setDataSource(this.f29680a);
            int trackCount = this.f29681b.getTrackCount();
            for (int i2 = 0; i2 < trackCount; i2++) {
                MediaFormat trackFormat = this.f29681b.getTrackFormat(i2);
                String string = trackFormat.getString("mime");
                if (string.startsWith(FileUtils.VIDEO_FILE_START)) {
                    a aVar = this.f29685f;
                    aVar.f29687a = trackFormat;
                    aVar.f29688b = i2;
                    if (trackFormat.containsKey("max-input-size") && (integer = this.f29685f.f29687a.getInteger("max-input-size")) > 0) {
                        this.f29683d = integer;
                    }
                } else if (string.startsWith("audio/")) {
                    a aVar2 = this.f29684e;
                    aVar2.f29687a = trackFormat;
                    aVar2.f29688b = i2;
                }
            }
            if (this.f29682c == null) {
                this.f29682c = ByteBuffer.allocateDirect(this.f29683d);
            }
            if (this.f29685f.f29687a != null) {
                try {
                    this.f29685f.f29691e = 1000000 / mediaFormat.getInteger("frame-rate");
                } catch (Exception e2) {
                    String str3 = "frameRate:" + e2.getMessage();
                    e2.printStackTrace();
                }
                if (this.f29685f.f29691e <= 0) {
                    k(g());
                    this.f29681b.readSampleData(this.f29682c, 0);
                    if (this.f29681b.getSampleFlags() == 1) {
                        this.f29681b.advance();
                    }
                    this.f29681b.readSampleData(this.f29682c, 0);
                    long sampleTime = this.f29681b.getSampleTime();
                    this.f29681b.advance();
                    this.f29685f.f29691e = Math.abs(this.f29681b.getSampleTime() - sampleTime);
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
