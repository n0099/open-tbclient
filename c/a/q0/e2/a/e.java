package c.a.q0.e2.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.e.l.e.n;
import c.a.e.l.e.w;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.viewholder.InterestedForumStyleAForumViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class e extends c.a.e.l.e.a<c.a.q0.e2.c.d, InterestedForumStyleAForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.q0.e2.f.c m;

    /* loaded from: classes3.dex */
    public class a implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f16982e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16982e = eVar;
        }

        @Override // c.a.e.l.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof c.a.q0.e2.c.d)) {
                c.a.q0.e2.c.d dVar = (c.a.q0.e2.c.d) nVar;
                dVar.u(!dVar.l());
                InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder = (InterestedForumStyleAForumViewHolder) view.getTag();
                if (interestedForumStyleAForumViewHolder != null) {
                    this.f16982e.q0(interestedForumStyleAForumViewHolder.mInterestedForumSelect, dVar.l());
                }
                if (this.f16982e.m != null) {
                    this.f16982e.m.a();
                }
                if (dVar.l()) {
                    this.f16982e.k0(dVar);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, BdUniqueId bdUniqueId) {
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
        this.f2966e = context;
        this.f2969h = bdUniqueId;
        d0(new a(this));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.e.l.e.a
    public /* bridge */ /* synthetic */ View a0(int i2, View view, ViewGroup viewGroup, c.a.q0.e2.c.d dVar, InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder) {
        m0(i2, view, viewGroup, dVar, interestedForumStyleAForumViewHolder);
        return view;
    }

    public final void k0(c.a.q0.e2.c.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 4);
            statisticItem.param("fid", dVar.d());
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: l0 */
    public InterestedForumStyleAForumViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            if (c.a.p0.b.d.J()) {
                inflate = LayoutInflater.from(this.f2966e).inflate(R.layout.item_interested_forum_style_a_forum, viewGroup, false);
            } else {
                inflate = c.a.p0.b.d.L() ? LayoutInflater.from(this.f2966e).inflate(R.layout.item_interested_forum_style_b_forum, viewGroup, false) : null;
            }
            return new InterestedForumStyleAForumViewHolder(inflate);
        }
        return (InterestedForumStyleAForumViewHolder) invokeL.objValue;
    }

    public View m0(int i2, View view, ViewGroup viewGroup, c.a.q0.e2.c.d dVar, InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, dVar, interestedForumStyleAForumViewHolder})) == null) {
            if (dVar == null) {
                return view;
            }
            p0(interestedForumStyleAForumViewHolder);
            n0(interestedForumStyleAForumViewHolder, dVar);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void n0(InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder, c.a.q0.e2.c.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, interestedForumStyleAForumViewHolder, dVar) == null) {
            interestedForumStyleAForumViewHolder.mInterestedForumIcon.setShowOval(true);
            interestedForumStyleAForumViewHolder.mInterestedForumIcon.setAutoChangeStyle(true);
            interestedForumStyleAForumViewHolder.mInterestedForumIcon.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            interestedForumStyleAForumViewHolder.mInterestedForumIcon.setStrokeColorResId(R.color.CAM_X0401);
            interestedForumStyleAForumViewHolder.mInterestedForumIcon.setScaleType(ImageView.ScaleType.CENTER_CROP);
            interestedForumStyleAForumViewHolder.mInterestedForumIcon.setPlaceHolder(1);
            interestedForumStyleAForumViewHolder.mInterestedForumIcon.startLoad(dVar.b(), 10, false);
            interestedForumStyleAForumViewHolder.mInterestedForumTitle.setText(dVar.g() + this.f2966e.getString(R.string.forum));
            if (!StringUtils.isNull(dVar.i())) {
                interestedForumStyleAForumViewHolder.mInterestedForumIntroduce.setText(this.f2966e.getString(R.string.interested_forum_introduce, dVar.i()));
            } else {
                interestedForumStyleAForumViewHolder.mInterestedForumIntroduce.setText(this.f2966e.getString(R.string.interested_forum_no_introduce_content));
            }
            interestedForumStyleAForumViewHolder.mInterestedForumAttentionContent.setText(String.format(this.f2966e.getString(R.string.concern), StringHelper.numberUniformFormatExtraWithRoundInt(dVar.h())));
            interestedForumStyleAForumViewHolder.mInterestedForumPbContent.setText(String.format(this.f2966e.getString(R.string.forum_thread_number), StringHelper.numberUniformFormatExtraWithRoundInt(dVar.k())));
            q0(interestedForumStyleAForumViewHolder.mInterestedForumSelect, dVar.l());
        }
    }

    public void o0(c.a.q0.e2.f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.m = cVar;
        }
    }

    public final void p0(InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, interestedForumStyleAForumViewHolder) == null) {
            c.a.p0.s.u.c d2 = c.a.p0.s.u.c.d(interestedForumStyleAForumViewHolder.mInterestedForumTitle);
            d2.u(R.color.CAM_X0105);
            d2.y(R.dimen.T_X06);
            c.a.p0.s.u.c d3 = c.a.p0.s.u.c.d(interestedForumStyleAForumViewHolder.mInterestedForumIntroduce);
            d3.u(R.color.CAM_X0109);
            d3.y(R.dimen.T_X09);
            c.a.p0.s.u.c d4 = c.a.p0.s.u.c.d(interestedForumStyleAForumViewHolder.mInterestedForumAttentionContent);
            d4.u(R.color.CAM_X0109);
            d4.y(R.dimen.T_X09);
            c.a.p0.s.u.c d5 = c.a.p0.s.u.c.d(interestedForumStyleAForumViewHolder.mInterestedForumPbContent);
            d5.u(R.color.CAM_X0109);
            d5.y(R.dimen.T_X09);
            TBSelector.setViewBackgroundColorWithPressedState(interestedForumStyleAForumViewHolder.mInterestedForumRootview, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public final void q0(ImageView imageView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, imageView, z) == null) {
            if (z) {
                SkinManager.setImageResource(imageView, R.drawable.icon_interest_checked);
            } else {
                SkinManager.setImageResource(imageView, R.drawable.icon_interest_unchecked);
            }
        }
    }
}
