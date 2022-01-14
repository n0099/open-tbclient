package c.a.t0.r3.g;

import androidx.annotation.NonNull;
import c.a.d.f.p.n;
import c.a.t0.r3.g.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class e implements f.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final c.a.t0.r3.b.b a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final c.a.t0.r3.b.c f21899b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final b f21900c;

    public e(@NonNull c.a.t0.r3.b.b bVar, @NonNull c.a.t0.r3.b.c cVar, @NonNull b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, cVar, bVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bVar;
        this.f21899b = cVar;
        this.f21900c = bVar2;
    }

    @Override // c.a.t0.r3.g.f.g
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 2).param("obj_type", this.f21900c.c() == n.i(this.a.getActivity()) ? 4 : 3));
            this.f21899b.a();
        }
    }

    @Override // c.a.t0.r3.g.f.g
    public void onError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f21899b.a();
        }
    }
}
