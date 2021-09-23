package c.a.r0.f2.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a.e.l.e.n;
import c.a.e.l.e.w;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.viewholder.InterestedForumStyleAMoreViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class f extends c.a.e.l.e.a<c.a.r0.f2.c.e, InterestedForumStyleAMoreViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.f2.f.b m;
    public c.a.r0.f2.f.c n;

    /* loaded from: classes3.dex */
    public class a implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f17607e;

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
            this.f17607e = fVar;
        }

        @Override // c.a.e.l.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof c.a.r0.f2.c.e)) {
                c.a.r0.f2.c.e eVar = (c.a.r0.f2.c.e) nVar;
                if (this.f17607e.m != null) {
                    this.f17607e.m.d(eVar.b(), eVar.c(), i2);
                }
                if (this.f17607e.n != null) {
                    this.f17607e.n.a();
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
        this.f2958e = context;
        this.f2961h = bdUniqueId;
        d0(new a(this));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.e.l.e.a
    public /* bridge */ /* synthetic */ View a0(int i2, View view, ViewGroup viewGroup, c.a.r0.f2.c.e eVar, InterestedForumStyleAMoreViewHolder interestedForumStyleAMoreViewHolder) {
        k0(i2, view, viewGroup, eVar, interestedForumStyleAMoreViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: j0 */
    public InterestedForumStyleAMoreViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            if (c.a.q0.b.d.z()) {
                inflate = LayoutInflater.from(this.f2958e).inflate(R.layout.item_interested_forum_style_a_more, viewGroup, false);
            } else {
                inflate = c.a.q0.b.d.B() ? LayoutInflater.from(this.f2958e).inflate(R.layout.item_interested_forum_style_b_more, viewGroup, false) : null;
            }
            return new InterestedForumStyleAMoreViewHolder(inflate);
        }
        return (InterestedForumStyleAMoreViewHolder) invokeL.objValue;
    }

    public View k0(int i2, View view, ViewGroup viewGroup, c.a.r0.f2.c.e eVar, InterestedForumStyleAMoreViewHolder interestedForumStyleAMoreViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, eVar, interestedForumStyleAMoreViewHolder})) == null) {
            o0(interestedForumStyleAMoreViewHolder);
            l0(interestedForumStyleAMoreViewHolder, eVar);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void l0(InterestedForumStyleAMoreViewHolder interestedForumStyleAMoreViewHolder, c.a.r0.f2.c.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, interestedForumStyleAMoreViewHolder, eVar) == null) {
            interestedForumStyleAMoreViewHolder.mInterestedMoreTitle.setText(this.f2958e.getResources().getString(R.string.interested_forum_more_hint));
            if (c.a.q0.b.d.z()) {
                if (eVar.d()) {
                    interestedForumStyleAMoreViewHolder.mInterestedMoreTitleLl.setVisibility(0);
                } else {
                    interestedForumStyleAMoreViewHolder.mInterestedMoreTitleLl.setVisibility(8);
                }
            } else if (c.a.q0.b.d.B()) {
                if (eVar.d()) {
                    interestedForumStyleAMoreViewHolder.mInterestedMoreTitleLl.setVisibility(0);
                    interestedForumStyleAMoreViewHolder.mInterestedMoreTitleInstead.setVisibility(8);
                    return;
                }
                interestedForumStyleAMoreViewHolder.mInterestedMoreTitleLl.setVisibility(8);
                interestedForumStyleAMoreViewHolder.mInterestedMoreTitleInstead.setVisibility(0);
            }
        }
    }

    public void m0(c.a.r0.f2.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.m = bVar;
        }
    }

    public void n0(c.a.r0.f2.f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.n = cVar;
        }
    }

    public final void o0(InterestedForumStyleAMoreViewHolder interestedForumStyleAMoreViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, interestedForumStyleAMoreViewHolder) == null) {
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(interestedForumStyleAMoreViewHolder.mInterestedMoreTitle);
            d2.w(R.color.CAM_X0302);
            d2.A(R.dimen.T_X07);
            if (c.a.q0.b.d.z()) {
                c.a.q0.s.u.c.d(interestedForumStyleAMoreViewHolder.mInterestedMoreDivide).f(R.color.CAM_X0206);
            } else if (c.a.q0.b.d.B()) {
                c.a.q0.s.u.c d3 = c.a.q0.s.u.c.d(interestedForumStyleAMoreViewHolder.mInterestedMoreTitleLl);
                d3.o(R.string.J_X17);
                d3.f(R.color.CAM_X0201);
                c.a.q0.s.u.c d4 = c.a.q0.s.u.c.d(interestedForumStyleAMoreViewHolder.mInterestedMoreTitleInstead);
                d4.o(R.string.J_X17);
                d4.f(R.color.CAM_X0201);
            }
        }
    }
}
