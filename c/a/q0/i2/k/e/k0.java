package c.a.q0.i2.k.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class k0 extends m<c.a.q0.i2.h.o, PbReplyTitleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener s;
    public SortSwitchButton.f t;
    public BdUniqueId u;
    public BdUniqueId v;
    public boolean w;
    public c.a.q0.i2.h.e x;
    public View y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(c.a.q0.i2.o.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
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
        this.w = false;
        this.u = BdUniqueId.gen();
        this.v = BdUniqueId.gen();
    }

    @Override // c.a.q0.i2.k.e.m, c.a.e.l.e.a
    public /* bridge */ /* synthetic */ View a0(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        m0(i2, view, viewGroup, (c.a.q0.i2.h.o) obj, (PbReplyTitleViewHolder) viewHolder);
        return view;
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.s = onClickListener;
        }
    }

    public final void j0() {
        c.a.q0.i2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (eVar = this.x) == null || eVar.O() == null || this.x.h() == null) {
            return;
        }
        c.a.q0.i2.h.e eVar2 = this.x;
        if (eVar2.f19070i && !this.w) {
            this.w = true;
            boolean isLike = eVar2.h().getIsLike();
            TiebaStatic.log(new StatisticItem("common_exp").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_id", this.x.h().getForumId()).param("thread_type", this.x.O().m1()).param("tid", this.x.O().f0()));
            if (isLike) {
                return;
            }
            TiebaStatic.log(new StatisticItem("common_exp").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_id", this.x.h().getForumId()).param("thread_type", this.x.O().m1()).param("tid", this.x.O().f0()));
        }
    }

    public View k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.y : (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: l0 */
    public PbReplyTitleViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.f2966e).inflate(R.layout.pb_reply_title_layout, viewGroup, false);
            this.y = inflate;
            PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.m.getPageContext(), inflate);
            PbFragment pbFragment = this.n;
            if (pbFragment != null) {
                pbReplyTitleViewHolder.setSortButtonId(pbFragment.sortSwitchId);
            }
            pbReplyTitleViewHolder.isSticky = false;
            pbReplyTitleViewHolder.setPbCommonOnclickListener(this.s);
            pbReplyTitleViewHolder.setOnSwitchChangeListener(this.t);
            if (K() == c.a.q0.i2.h.o.l) {
                pbReplyTitleViewHolder.registerListener(this.u);
            } else if (K() == c.a.q0.i2.h.o.m) {
                pbReplyTitleViewHolder.registerGodReplyTitleListener(this.v);
            }
            return pbReplyTitleViewHolder;
        }
        return (PbReplyTitleViewHolder) invokeL.objValue;
    }

    public View m0(int i2, View view, ViewGroup viewGroup, c.a.q0.i2.h.o oVar, PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), view, viewGroup, oVar, pbReplyTitleViewHolder})) == null) {
            super.a0(i2, view, viewGroup, oVar, pbReplyTitleViewHolder);
            if (pbReplyTitleViewHolder != null) {
                j0();
                oVar.k = this.x.f19067f;
                pbReplyTitleViewHolder.bindDataToView(oVar);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void n0(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            this.t = fVar;
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.w = false;
            MessageManager.getInstance().unRegisterListener(this.u);
            MessageManager.getInstance().unRegisterListener(this.v);
        }
    }

    public void t(c.a.q0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) {
            this.x = eVar;
        }
    }
}
