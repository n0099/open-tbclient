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
    public String f30978a;

    /* renamed from: b  reason: collision with root package name */
    public MediaExtractor f30979b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f30980c;

    /* renamed from: d  reason: collision with root package name */
    public int f30981d;

    /* renamed from: e  reason: collision with root package name */
    public a f30982e;

    /* renamed from: f  reason: collision with root package name */
    public a f30983f;

    /* renamed from: g  reason: collision with root package name */
    public a f30984g;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public MediaFormat f30985a;

        /* renamed from: b  reason: collision with root package name */
        public int f30986b;

        /* renamed from: c  reason: collision with root package name */
        public long f30987c;

        /* renamed from: d  reason: collision with root package name */
        public MediaCodec.BufferInfo f30988d;

        /* renamed from: e  reason: collision with root package name */
        public long f30989e;

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
            this.f30985a = null;
            this.f30986b = -1;
            this.f30987c = 0L;
            this.f30988d = new MediaCodec.BufferInfo();
            this.f30989e = 0L;
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
        this.f30981d = 512000;
        this.f30982e = new a();
        this.f30983f = new a();
        this.f30984g = new a();
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f30979b.advance() : invokeV.booleanValue;
    }

    public a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f30982e : (a) invokeV.objValue;
    }

    public ByteBuffer c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30980c : (ByteBuffer) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f30979b.getSampleTrackIndex() : invokeV.intValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f30984g.f30987c : invokeV.longValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f30979b.getSampleTrackIndex() : invokeV.intValue;
    }

    public a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f30983f : (a) invokeV.objValue;
    }

    public MediaCodec.BufferInfo h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? i(this.f30980c, 0) : (MediaCodec.BufferInfo) invokeV.objValue;
    }

    public MediaCodec.BufferInfo i(ByteBuffer byteBuffer, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer, i2)) == null) {
            int readSampleData = this.f30979b.readSampleData(byteBuffer, i2);
            if (readSampleData < 0) {
                return null;
            }
            a aVar = this.f30984g;
            aVar.f30988d.size = readSampleData;
            if (aVar == this.f30983f) {
                aVar.f30987c += aVar.f30989e;
            } else {
                aVar.f30987c = this.f30979b.getSampleTime();
            }
            a aVar2 = this.f30984g;
            MediaCodec.BufferInfo bufferInfo = aVar2.f30988d;
            bufferInfo.presentationTimeUs = aVar2.f30987c;
            bufferInfo.offset = 0;
            bufferInfo.flags = this.f30979b.getSampleFlags();
            return this.f30984g.f30988d;
        }
        return (MediaCodec.BufferInfo) invokeLI.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ByteBuffer byteBuffer = this.f30980c;
            if (byteBuffer != null) {
                byteBuffer.clear();
                this.f30980c = null;
            }
            this.f30979b.release();
        }
    }

    public void k(a aVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            a aVar2 = this.f30984g;
            if (aVar2 != null && (i3 = aVar2.f30986b) >= 0) {
                this.f30979b.unselectTrack(i3);
            }
            this.f30984g = aVar;
            if (aVar == null || (i2 = aVar.f30986b) < 0) {
                return;
            }
            this.f30979b.selectTrack(i2);
            a aVar3 = this.f30984g;
            aVar3.f30985a = this.f30979b.getTrackFormat(aVar3.f30986b);
            try {
                this.f30984g.f30985a.getLong("durationUs");
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
            this.f30978a = str;
            FileUtils.VIDEO_FILE_START.equals(str2);
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.f30979b = mediaExtractor;
            mediaExtractor.setDataSource(this.f30978a);
            int trackCount = this.f30979b.getTrackCount();
            for (int i2 = 0; i2 < trackCount; i2++) {
                MediaFormat trackFormat = this.f30979b.getTrackFormat(i2);
                String string = trackFormat.getString("mime");
                if (string.startsWith(FileUtils.VIDEO_FILE_START)) {
                    a aVar = this.f30983f;
                    aVar.f30985a = trackFormat;
                    aVar.f30986b = i2;
                    if (trackFormat.containsKey("max-input-size") && (integer = this.f30983f.f30985a.getInteger("max-input-size")) > 0) {
                        this.f30981d = integer;
                    }
                } else if (string.startsWith("audio/")) {
                    a aVar2 = this.f30982e;
                    aVar2.f30985a = trackFormat;
                    aVar2.f30986b = i2;
                }
            }
            if (this.f30980c == null) {
                this.f30980c = ByteBuffer.allocateDirect(this.f30981d);
            }
            if (this.f30983f.f30985a != null) {
                try {
                    this.f30983f.f30989e = 1000000 / mediaFormat.getInteger("frame-rate");
                } catch (Exception e2) {
                    String str3 = "frameRate:" + e2.getMessage();
                    e2.printStackTrace();
                }
                if (this.f30983f.f30989e <= 0) {
                    k(g());
                    this.f30979b.readSampleData(this.f30980c, 0);
                    if (this.f30979b.getSampleFlags() == 1) {
                        this.f30979b.advance();
                    }
                    this.f30979b.readSampleData(this.f30980c, 0);
                    long sampleTime = this.f30979b.getSampleTime();
                    this.f30979b.advance();
                    this.f30983f.f30989e = Math.abs(this.f30979b.getSampleTime() - sampleTime);
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
