package c.a.q0.i2.k.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbListAlaRecommendVH;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class x extends m<y, PbListAlaRecommendVH> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.q0.i2.h.e s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(c.a.q0.i2.o.b bVar) {
        super(bVar, y.s);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.q0.i2.o.b) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: j0 */
    public PbListAlaRecommendVH U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PbListAlaRecommendVH(LayoutInflater.from(this.f2966e).inflate(R.layout.pb_list_ala_recomment_layout, (ViewGroup) null), this.m.getPbActivity()) : (PbListAlaRecommendVH) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.i2.k.e.m, c.a.e.l.e.a
    /* renamed from: k0 */
    public View a0(int i2, View view, ViewGroup viewGroup, y yVar, PbListAlaRecommendVH pbListAlaRecommendVH) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, yVar, pbListAlaRecommendVH})) == null) {
            super.a0(i2, view, viewGroup, yVar, pbListAlaRecommendVH);
            if (yVar == null) {
                return null;
            }
            pbListAlaRecommendVH.bindData(yVar);
            pbListAlaRecommendVH.sendDisplayStatistic(this.s);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void l0(c.a.q0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.s = eVar;
        }
    }
}
