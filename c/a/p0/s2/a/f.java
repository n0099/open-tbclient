package c.a.p0.s2.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a.d.o.e.n;
import c.a.d.o.e.w;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.viewholder.InterestedForumStyleAMoreViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class f extends c.a.d.o.e.a<c.a.p0.s2.c.e, InterestedForumStyleAMoreViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.s2.f.b i;
    public c.a.p0.s2.f.c j;

    /* loaded from: classes2.dex */
    public class a implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // c.a.d.o.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nVar instanceof c.a.p0.s2.c.e)) {
                c.a.p0.s2.c.e eVar = (c.a.p0.s2.c.e) nVar;
                if (this.a.i != null) {
                    this.a.i.d(eVar.a(), eVar.b(), i);
                }
                if (this.a.j != null) {
                    this.a.j.a();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.f2570d = bdUniqueId;
        V(new a(this));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.d.o.e.a
    public /* bridge */ /* synthetic */ View S(int i, View view, ViewGroup viewGroup, c.a.p0.s2.c.e eVar, InterestedForumStyleAMoreViewHolder interestedForumStyleAMoreViewHolder) {
        c0(i, view, viewGroup, eVar, interestedForumStyleAMoreViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: b0 */
    public InterestedForumStyleAMoreViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            if (UbsABTestHelper.isInterestGuideStyleA()) {
                inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0401, viewGroup, false);
            } else {
                inflate = UbsABTestHelper.isInterestGuideStyleB() ? LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0404, viewGroup, false) : null;
            }
            return new InterestedForumStyleAMoreViewHolder(inflate);
        }
        return (InterestedForumStyleAMoreViewHolder) invokeL.objValue;
    }

    public View c0(int i, View view, ViewGroup viewGroup, c.a.p0.s2.c.e eVar, InterestedForumStyleAMoreViewHolder interestedForumStyleAMoreViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view, viewGroup, eVar, interestedForumStyleAMoreViewHolder})) == null) {
            g0(interestedForumStyleAMoreViewHolder);
            d0(interestedForumStyleAMoreViewHolder, eVar);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void d0(InterestedForumStyleAMoreViewHolder interestedForumStyleAMoreViewHolder, c.a.p0.s2.c.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, interestedForumStyleAMoreViewHolder, eVar) == null) {
            interestedForumStyleAMoreViewHolder.f34794c.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f091d));
            if (UbsABTestHelper.isInterestGuideStyleA()) {
                if (eVar.e()) {
                    interestedForumStyleAMoreViewHolder.f34793b.setVisibility(0);
                } else {
                    interestedForumStyleAMoreViewHolder.f34793b.setVisibility(8);
                }
            } else if (UbsABTestHelper.isInterestGuideStyleB()) {
                if (eVar.e()) {
                    interestedForumStyleAMoreViewHolder.f34793b.setVisibility(0);
                    interestedForumStyleAMoreViewHolder.f34796e.setVisibility(8);
                    return;
                }
                interestedForumStyleAMoreViewHolder.f34793b.setVisibility(8);
                interestedForumStyleAMoreViewHolder.f34796e.setVisibility(0);
            }
        }
    }

    public void e0(c.a.p0.s2.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.i = bVar;
        }
    }

    public void f0(c.a.p0.s2.f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.j = cVar;
        }
    }

    public final void g0(InterestedForumStyleAMoreViewHolder interestedForumStyleAMoreViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, interestedForumStyleAMoreViewHolder) == null) {
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(interestedForumStyleAMoreViewHolder.f34794c);
            d2.v(R.color.CAM_X0302);
            d2.z(R.dimen.T_X07);
            if (UbsABTestHelper.isInterestGuideStyleA()) {
                c.a.o0.r.v.c.d(interestedForumStyleAMoreViewHolder.f34795d).f(R.color.CAM_X0206);
            } else if (UbsABTestHelper.isInterestGuideStyleB()) {
                c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(interestedForumStyleAMoreViewHolder.f34793b);
                d3.n(R.string.J_X17);
                d3.f(R.color.CAM_X0201);
                c.a.o0.r.v.c d4 = c.a.o0.r.v.c.d(interestedForumStyleAMoreViewHolder.f34796e);
                d4.n(R.string.J_X17);
                d4.f(R.color.CAM_X0201);
            }
        }
    }
}
