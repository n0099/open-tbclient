package b.a.r0.c4.l.c.d;

import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import java.util.List;
/* loaded from: classes4.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f15555a;

    /* renamed from: b  reason: collision with root package name */
    public int f15556b;

    /* renamed from: c  reason: collision with root package name */
    public int f15557c;

    /* renamed from: d  reason: collision with root package name */
    public int f15558d;

    /* renamed from: e  reason: collision with root package name */
    public List<MediaSegment> f15559e;

    /* renamed from: f  reason: collision with root package name */
    public List<MultiMediaData> f15560f;

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
