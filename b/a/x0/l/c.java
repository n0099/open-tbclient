package b.a.x0.l;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.IOException;
import java.util.List;
@TargetApi(18)
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<String> f29692a;

    /* renamed from: b  reason: collision with root package name */
    public String f29693b;

    /* renamed from: c  reason: collision with root package name */
    public MediaMuxer f29694c;

    /* renamed from: d  reason: collision with root package name */
    public int f29695d;

    /* renamed from: e  reason: collision with root package name */
    public int f29696e;

    /* renamed from: f  reason: collision with root package name */
    public MediaFormat f29697f;

    /* renamed from: g  reason: collision with root package name */
    public MediaFormat f29698g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.x0.p.a f29699h;

    public c(List<String> list, String str, b.a.x0.p.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b.a.x0.t.c.e("VideoComposer", list.size() + " composer to " + str);
        this.f29692a = list;
        this.f29693b = str;
        this.f29699h = aVar;
    }

    public final long a(long j, String str) throws IOException {
        InterceptResult invokeJL;
        int i2;
        int i3;
        b bVar;
        int i4;
        b bVar2;
        int i5;
        b bVar3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, str)) == null) {
            String str3 = "VideoComposer";
            b.a.x0.t.c.e("VideoComposer", j + " compose " + str);
            b bVar4 = new b();
            bVar4.m(str, FileUtils.VIDEO_FILE_START);
            int d2 = bVar4.d();
            b bVar5 = null;
            if (d2 < 0) {
                bVar4.j();
                bVar4 = null;
            } else {
                bVar4.l(this.f29696e);
            }
            b bVar6 = new b();
            bVar6.m(str, "audio/");
            int d3 = bVar6.d();
            if (d3 < 0) {
                bVar6.j();
            } else {
                bVar6.l(this.f29695d);
                bVar5 = bVar6;
            }
            boolean z = bVar4 == null;
            boolean z2 = bVar5 == null;
            long j2 = 0;
            long j3 = 0;
            while (true) {
                if (z && z2) {
                    break;
                }
                if (!z2 && (z || bVar5.e() - bVar4.e() <= 50000)) {
                    i2 = this.f29695d;
                    i4 = d3;
                    i3 = i4;
                    bVar = bVar5;
                } else {
                    i2 = this.f29696e;
                    i3 = d3;
                    bVar = bVar4;
                    i4 = d2;
                }
                MediaCodec.BufferInfo h2 = bVar.h();
                if (h2 == null) {
                    i5 = d2;
                    b bVar7 = bVar;
                    if (bVar7 == bVar4) {
                        j2 = bVar4.e();
                        d3 = i3;
                        d2 = i5;
                        z = true;
                    } else if (bVar7 == bVar5) {
                        j3 = bVar5.e();
                        d3 = i3;
                        d2 = i5;
                        z2 = true;
                    } else {
                        bVar2 = bVar4;
                        bVar3 = bVar5;
                        str2 = str3;
                    }
                } else {
                    bVar2 = bVar4;
                    i5 = d2;
                    b bVar8 = bVar;
                    if (bVar8.f() != i4) {
                        StringBuilder sb = new StringBuilder();
                        bVar3 = bVar5;
                        sb.append("WEIRD: got sample from track ");
                        sb.append(bVar8.f());
                        sb.append(", expected ");
                        sb.append(i4);
                        b.a.x0.t.c.e(str3, sb.toString());
                    } else {
                        bVar3 = bVar5;
                    }
                    str2 = str3;
                    h2.presentationTimeUs += j;
                    this.f29694c.writeSampleData(i2, bVar8.c(), h2);
                    bVar8.a();
                }
                str3 = str2;
                d3 = i3;
                d2 = i5;
                bVar4 = bVar2;
                bVar5 = bVar3;
            }
            long max = j + Math.max(j2, j3) + 10000;
            b.a.x0.p.a aVar = this.f29699h;
            if (aVar != null) {
                aVar.c(max);
            }
            b.a.x0.t.c.e(str3, "finish one file, ptsOffset " + max);
            if (bVar4 != null) {
                bVar4.j();
            }
            if (bVar5 != null) {
                bVar5.j();
            }
            return max;
        }
        return invokeJL.longValue;
    }

    public boolean b(StringBuilder sb) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sb)) == null) {
            boolean z = false;
            boolean z2 = false;
            for (String str : this.f29692a) {
                try {
                    b bVar = new b();
                    try {
                        bVar.m(str, FileUtils.VIDEO_FILE_START);
                        if (!z) {
                            MediaFormat mediaFormat = bVar.g().f29687a;
                            this.f29698g = mediaFormat;
                            if (mediaFormat == null) {
                                b.a.x0.t.c.e("VideoComposer", "No video track found in " + str);
                            } else {
                                z = true;
                            }
                        }
                        if (!z2) {
                            MediaFormat mediaFormat2 = bVar.b().f29687a;
                            this.f29697f = mediaFormat2;
                            if (mediaFormat2 == null) {
                                b.a.x0.t.c.e("VideoComposer", "No audio track found in " + str);
                            } else {
                                z2 = true;
                            }
                        }
                    } catch (Exception e2) {
                        b.a.x0.t.c.e("VideoComposer", e2.getMessage());
                        e2.printStackTrace();
                    }
                    bVar.j();
                    if (z && z2) {
                        break;
                    }
                } catch (Exception e3) {
                    if (sb != null) {
                        sb.append("VideoSplicer codec 录制视频拼接过程中发生异常:" + e3.getMessage());
                    }
                    e3.printStackTrace();
                    return false;
                }
            }
            MediaMuxer mediaMuxer = new MediaMuxer(this.f29693b, 0);
            this.f29694c = mediaMuxer;
            if (z) {
                this.f29696e = mediaMuxer.addTrack(this.f29698g);
            }
            if (z2) {
                this.f29695d = this.f29694c.addTrack(this.f29697f);
            }
            this.f29694c.start();
            long j = 0;
            for (String str2 : this.f29692a) {
                j = a(j, str2);
            }
            if (this.f29694c != null) {
                try {
                    this.f29694c.stop();
                    this.f29694c.release();
                } catch (Exception unused) {
                    b.a.x0.t.c.e("VideoComposer", "Muxer close error. No data was written");
                }
                this.f29694c = null;
            }
            b.a.x0.t.c.j("VideoComposer", "video join finished");
            return true;
        }
        return invokeL.booleanValue;
    }
}
