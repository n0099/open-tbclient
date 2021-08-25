package c.a.q0.i2.k.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbImageAlaRecommendVH;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class v extends m<w, PbImageAlaRecommendVH> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId s;
    public c.a.q0.i2.h.e t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(c.a.q0.i2.o.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, w.u);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bdUniqueId};
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
        this.s = bdUniqueId;
    }

    @Override // c.a.q0.i2.k.e.m, c.a.e.l.e.a
    public /* bridge */ /* synthetic */ View a0(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        k0(i2, view, viewGroup, (w) obj, (PbImageAlaRecommendVH) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: j0 */
    public PbImageAlaRecommendVH U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PbImageAlaRecommendVH(LayoutInflater.from(this.f2966e).inflate(R.layout.pb_image_ala_recomment_layout, viewGroup, false), this.m.getPageContext(), this.s) : (PbImageAlaRecommendVH) invokeL.objValue;
    }

    public View k0(int i2, View view, ViewGroup viewGroup, w wVar, PbImageAlaRecommendVH pbImageAlaRecommendVH) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, wVar, pbImageAlaRecommendVH})) == null) {
            super.a0(i2, view, viewGroup, wVar, pbImageAlaRecommendVH);
            if (pbImageAlaRecommendVH != null) {
                pbImageAlaRecommendVH.bindDataToView(wVar);
                pbImageAlaRecommendVH.sendDisplayStatistic(this.t);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void l0(c.a.q0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.t = eVar;
        }
    }
}
