package b.a.r0.w.f.g.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import b.a.r0.w.f.h.d.f;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.view.SpecialLiveDoubleViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e extends b.a.e.m.e.a<b.a.r0.w.f.h.b.b, SpecialLiveDoubleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public b.a.r0.w.f.g.e.a.b n;
    public f o;
    public int p;
    public long q;
    public String r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), b.a.r0.w.f.h.b.b.f26408g);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = 0L;
        this.r = "";
        this.m = tbPageContext;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.r = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: g0 */
    public SpecialLiveDoubleViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            b.a.r0.w.f.g.e.a.b bVar = new b.a.r0.w.f.g.e.a.b(this.m, viewGroup);
            this.n = bVar;
            f fVar = this.o;
            if (fVar != null) {
                bVar.q(fVar);
            }
            return new SpecialLiveDoubleViewHolder(this.n);
        }
        return (SpecialLiveDoubleViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: h0 */
    public View Z(int i2, View view, ViewGroup viewGroup, b.a.r0.w.f.h.b.b bVar, SpecialLiveDoubleViewHolder specialLiveDoubleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, specialLiveDoubleViewHolder})) == null) {
            specialLiveDoubleViewHolder.mView.p(bVar, this.p, this.q, this.r);
            return specialLiveDoubleViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void i0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.q = j;
        }
    }

    public void j0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.p = i2;
        }
    }

    public void k0(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            this.o = fVar;
            b.a.r0.w.f.g.e.a.b bVar = this.n;
            if (bVar != null) {
                bVar.q(fVar);
            }
        }
    }
}
