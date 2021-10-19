package c.a.r0.c4.l.c.d;

import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import java.util.List;
/* loaded from: classes3.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f16545a;

    /* renamed from: b  reason: collision with root package name */
    public int f16546b;

    /* renamed from: c  reason: collision with root package name */
    public int f16547c;

    /* renamed from: d  reason: collision with root package name */
    public int f16548d;

    /* renamed from: e  reason: collision with root package name */
    public List<MediaSegment> f16549e;

    /* renamed from: f  reason: collision with root package name */
    public List<MultiMediaData> f16550f;

    public o() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
