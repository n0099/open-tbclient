package b.a.r0.g2.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b.a.e.m.e.n;
import b.a.e.m.e.w;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.viewholder.InterestedForumStyleAMoreViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class f extends b.a.e.m.e.a<b.a.r0.g2.c.e, InterestedForumStyleAMoreViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b.a.r0.g2.f.b m;
    public b.a.r0.g2.f.c n;

    /* loaded from: classes4.dex */
    public class a implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f18251e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18251e = fVar;
        }

        @Override // b.a.e.m.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof b.a.r0.g2.c.e)) {
                b.a.r0.g2.c.e eVar = (b.a.r0.g2.c.e) nVar;
                if (this.f18251e.m != null) {
                    this.f18251e.m.d(eVar.a(), eVar.d(), i2);
                }
                if (this.f18251e.n != null) {
                    this.f18251e.n.a();
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
        this.f2421e = context;
        this.f2424h = bdUniqueId;
        c0(new a(this));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // b.a.e.m.e.a
    public /* bridge */ /* synthetic */ View Z(int i2, View view, ViewGroup viewGroup, b.a.r0.g2.c.e eVar, InterestedForumStyleAMoreViewHolder interestedForumStyleAMoreViewHolder) {
        j0(i2, view, viewGroup, eVar, interestedForumStyleAMoreViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: i0 */
    public InterestedForumStyleAMoreViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            if (b.a.q0.b.d.z()) {
                inflate = LayoutInflater.from(this.f2421e).inflate(R.layout.item_interested_forum_style_a_more, viewGroup, false);
            } else {
                inflate = b.a.q0.b.d.B() ? LayoutInflater.from(this.f2421e).inflate(R.layout.item_interested_forum_style_b_more, viewGroup, false) : null;
            }
            return new InterestedForumStyleAMoreViewHolder(inflate);
        }
        return (InterestedForumStyleAMoreViewHolder) invokeL.objValue;
    }

    public View j0(int i2, View view, ViewGroup viewGroup, b.a.r0.g2.c.e eVar, InterestedForumStyleAMoreViewHolder interestedForumStyleAMoreViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, eVar, interestedForumStyleAMoreViewHolder})) == null) {
            n0(interestedForumStyleAMoreViewHolder);
            k0(interestedForumStyleAMoreViewHolder, eVar);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void k0(InterestedForumStyleAMoreViewHolder interestedForumStyleAMoreViewHolder, b.a.r0.g2.c.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, interestedForumStyleAMoreViewHolder, eVar) == null) {
            interestedForumStyleAMoreViewHolder.mInterestedMoreTitle.setText(this.f2421e.getResources().getString(R.string.interested_forum_more_hint));
            if (b.a.q0.b.d.z()) {
                if (eVar.e()) {
                    interestedForumStyleAMoreViewHolder.mInterestedMoreTitleLl.setVisibility(0);
                } else {
                    interestedForumStyleAMoreViewHolder.mInterestedMoreTitleLl.setVisibility(8);
                }
            } else if (b.a.q0.b.d.B()) {
                if (eVar.e()) {
                    interestedForumStyleAMoreViewHolder.mInterestedMoreTitleLl.setVisibility(0);
                    interestedForumStyleAMoreViewHolder.mInterestedMoreTitleInstead.setVisibility(8);
                    return;
                }
                interestedForumStyleAMoreViewHolder.mInterestedMoreTitleLl.setVisibility(8);
                interestedForumStyleAMoreViewHolder.mInterestedMoreTitleInstead.setVisibility(0);
            }
        }
    }

    public void l0(b.a.r0.g2.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.m = bVar;
        }
    }

    public void m0(b.a.r0.g2.f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.n = cVar;
        }
    }

    public final void n0(InterestedForumStyleAMoreViewHolder interestedForumStyleAMoreViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, interestedForumStyleAMoreViewHolder) == null) {
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(interestedForumStyleAMoreViewHolder.mInterestedMoreTitle);
            d2.v(R.color.CAM_X0302);
            d2.z(R.dimen.T_X07);
            if (b.a.q0.b.d.z()) {
                b.a.q0.s.u.c.d(interestedForumStyleAMoreViewHolder.mInterestedMoreDivide).f(R.color.CAM_X0206);
            } else if (b.a.q0.b.d.B()) {
                b.a.q0.s.u.c d3 = b.a.q0.s.u.c.d(interestedForumStyleAMoreViewHolder.mInterestedMoreTitleLl);
                d3.n(R.string.J_X17);
                d3.f(R.color.CAM_X0201);
                b.a.q0.s.u.c d4 = b.a.q0.s.u.c.d(interestedForumStyleAMoreViewHolder.mInterestedMoreTitleInstead);
                d4.n(R.string.J_X17);
                d4.f(R.color.CAM_X0201);
            }
        }
    }
}
