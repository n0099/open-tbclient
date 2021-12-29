package c.a.t0.o2.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a.d.n.e.n;
import c.a.d.n.e.w;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.viewholder.InterestedForumStyleATitleViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class g extends c.a.d.n.e.a<c.a.t0.o2.c.f, InterestedForumStyleATitleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.d.n.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) != null) || !(nVar instanceof c.a.t0.o2.c.f)) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context, BdUniqueId bdUniqueId) {
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
        this.f3299e = context;
        this.f3302h = bdUniqueId;
        V(new a(this));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.d.n.e.a
    public /* bridge */ /* synthetic */ View S(int i2, View view, ViewGroup viewGroup, c.a.t0.o2.c.f fVar, InterestedForumStyleATitleViewHolder interestedForumStyleATitleViewHolder) {
        a0(i2, view, viewGroup, fVar, interestedForumStyleATitleViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: Z */
    public InterestedForumStyleATitleViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            if (c.a.s0.b.d.D()) {
                inflate = LayoutInflater.from(this.f3299e).inflate(R.layout.item_interested_forum_style_a_title, viewGroup, false);
            } else {
                inflate = c.a.s0.b.d.F() ? LayoutInflater.from(this.f3299e).inflate(R.layout.item_interested_forum_style_b_title, viewGroup, false) : null;
            }
            return new InterestedForumStyleATitleViewHolder(inflate);
        }
        return (InterestedForumStyleATitleViewHolder) invokeL.objValue;
    }

    public View a0(int i2, View view, ViewGroup viewGroup, c.a.t0.o2.c.f fVar, InterestedForumStyleATitleViewHolder interestedForumStyleATitleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, fVar, interestedForumStyleATitleViewHolder})) == null) {
            if (fVar == null) {
                return view;
            }
            c0(interestedForumStyleATitleViewHolder);
            b0(interestedForumStyleATitleViewHolder, fVar);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void b0(InterestedForumStyleATitleViewHolder interestedForumStyleATitleViewHolder, c.a.t0.o2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, interestedForumStyleATitleViewHolder, fVar) == null) {
            interestedForumStyleATitleViewHolder.mInterestedTitleIcon.setDefaultResource(R.drawable.icon_interested_title_default);
            interestedForumStyleATitleViewHolder.mInterestedTitleIcon.startLoad(fVar.a(), 10, false);
            interestedForumStyleATitleViewHolder.mInterestedTitleContent.setText(fVar.d());
        }
    }

    public final void c0(InterestedForumStyleATitleViewHolder interestedForumStyleATitleViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, interestedForumStyleATitleViewHolder) == null) {
            c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(interestedForumStyleATitleViewHolder.mInterestedTitleContent);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X06);
            d2.A(R.string.F_X02);
            if (c.a.s0.b.d.F()) {
                c.a.s0.s.u.c d3 = c.a.s0.s.u.c.d(interestedForumStyleATitleViewHolder.mInterestedTitleRootview);
                d3.n(R.string.J_X14);
                d3.f(R.color.CAM_X0201);
            }
        }
    }
}
