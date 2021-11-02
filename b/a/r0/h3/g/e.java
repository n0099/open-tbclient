package b.a.r0.h3.g;

import androidx.annotation.NonNull;
import b.a.e.e.p.l;
import b.a.r0.h3.g.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class e implements f.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final b.a.r0.h3.b.c f17791a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final b.a.r0.h3.b.d f17792b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final b f17793c;

    public e(@NonNull b.a.r0.h3.b.c cVar, @NonNull b.a.r0.h3.b.d dVar, @NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, dVar, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17791a = cVar;
        this.f17792b = dVar;
        this.f17793c = bVar;
    }

    @Override // b.a.r0.h3.g.f.g
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 2).param("obj_type", this.f17793c.c() == l.i(this.f17791a.getActivity()) ? 4 : 3));
            this.f17792b.a();
        }
    }

    @Override // b.a.r0.h3.g.f.g
    public void onError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f17792b.a();
        }
    }
}
