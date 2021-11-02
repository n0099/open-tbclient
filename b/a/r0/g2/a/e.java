package b.a.r0.g2.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import b.a.e.l.e.n;
import b.a.e.l.e.w;
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
/* loaded from: classes4.dex */
public class e extends b.a.e.l.e.a<b.a.r0.g2.c.d, InterestedForumStyleAForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b.a.r0.g2.f.c m;

    /* loaded from: classes4.dex */
    public class a implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f16736e;

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
            this.f16736e = eVar;
        }

        @Override // b.a.e.l.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof b.a.r0.g2.c.d)) {
                b.a.r0.g2.c.d dVar = (b.a.r0.g2.c.d) nVar;
                dVar.u(!dVar.l());
                InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder = (InterestedForumStyleAForumViewHolder) view.getTag();
                if (interestedForumStyleAForumViewHolder != null) {
                    this.f16736e.p0(interestedForumStyleAForumViewHolder.mInterestedForumSelect, dVar.l());
                }
                if (this.f16736e.m != null) {
                    this.f16736e.m.a();
                }
                if (dVar.l()) {
                    this.f16736e.j0(dVar);
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
        this.f2419e = context;
        this.f2422h = bdUniqueId;
        c0(new a(this));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // b.a.e.l.e.a
    public /* bridge */ /* synthetic */ View Z(int i2, View view, ViewGroup viewGroup, b.a.r0.g2.c.d dVar, InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder) {
        l0(i2, view, viewGroup, dVar, interestedForumStyleAForumViewHolder);
        return view;
    }

    public final void j0(b.a.r0.g2.c.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 4);
            statisticItem.param("fid", dVar.e());
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: k0 */
    public InterestedForumStyleAForumViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            if (b.a.q0.b.d.z()) {
                inflate = LayoutInflater.from(this.f2419e).inflate(R.layout.item_interested_forum_style_a_forum, viewGroup, false);
            } else {
                inflate = b.a.q0.b.d.B() ? LayoutInflater.from(this.f2419e).inflate(R.layout.item_interested_forum_style_b_forum, viewGroup, false) : null;
            }
            return new InterestedForumStyleAForumViewHolder(inflate);
        }
        return (InterestedForumStyleAForumViewHolder) invokeL.objValue;
    }

    public View l0(int i2, View view, ViewGroup viewGroup, b.a.r0.g2.c.d dVar, InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, dVar, interestedForumStyleAForumViewHolder})) == null) {
            if (dVar == null) {
                return view;
            }
            o0(interestedForumStyleAForumViewHolder);
            m0(interestedForumStyleAForumViewHolder, dVar);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void m0(InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder, b.a.r0.g2.c.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, interestedForumStyleAForumViewHolder, dVar) == null) {
            interestedForumStyleAForumViewHolder.mInterestedForumIcon.setShowOval(true);
            interestedForumStyleAForumViewHolder.mInterestedForumIcon.setAutoChangeStyle(true);
            interestedForumStyleAForumViewHolder.mInterestedForumIcon.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            interestedForumStyleAForumViewHolder.mInterestedForumIcon.setStrokeColorResId(R.color.CAM_X0401);
            interestedForumStyleAForumViewHolder.mInterestedForumIcon.setScaleType(ImageView.ScaleType.CENTER_CROP);
            interestedForumStyleAForumViewHolder.mInterestedForumIcon.setPlaceHolder(1);
            interestedForumStyleAForumViewHolder.mInterestedForumIcon.startLoad(dVar.a(), 10, false);
            interestedForumStyleAForumViewHolder.mInterestedForumTitle.setText(dVar.g() + this.f2419e.getString(R.string.forum));
            if (!StringUtils.isNull(dVar.i())) {
                interestedForumStyleAForumViewHolder.mInterestedForumIntroduce.setText(this.f2419e.getString(R.string.interested_forum_introduce, dVar.i()));
            } else {
                interestedForumStyleAForumViewHolder.mInterestedForumIntroduce.setText(this.f2419e.getString(R.string.interested_forum_no_introduce_content));
            }
            interestedForumStyleAForumViewHolder.mInterestedForumAttentionContent.setText(String.format(this.f2419e.getString(R.string.concern), StringHelper.numberUniformFormatExtraWithRoundInt(dVar.h())));
            interestedForumStyleAForumViewHolder.mInterestedForumPbContent.setText(String.format(this.f2419e.getString(R.string.forum_thread_number), StringHelper.numberUniformFormatExtraWithRoundInt(dVar.k())));
            p0(interestedForumStyleAForumViewHolder.mInterestedForumSelect, dVar.l());
        }
    }

    public void n0(b.a.r0.g2.f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.m = cVar;
        }
    }

    public final void o0(InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, interestedForumStyleAForumViewHolder) == null) {
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(interestedForumStyleAForumViewHolder.mInterestedForumTitle);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X06);
            b.a.q0.s.u.c d3 = b.a.q0.s.u.c.d(interestedForumStyleAForumViewHolder.mInterestedForumIntroduce);
            d3.v(R.color.CAM_X0109);
            d3.z(R.dimen.T_X09);
            b.a.q0.s.u.c d4 = b.a.q0.s.u.c.d(interestedForumStyleAForumViewHolder.mInterestedForumAttentionContent);
            d4.v(R.color.CAM_X0109);
            d4.z(R.dimen.T_X09);
            b.a.q0.s.u.c d5 = b.a.q0.s.u.c.d(interestedForumStyleAForumViewHolder.mInterestedForumPbContent);
            d5.v(R.color.CAM_X0109);
            d5.z(R.dimen.T_X09);
            TBSelector.setViewBackgroundColorWithPressedState(interestedForumStyleAForumViewHolder.mInterestedForumRootview, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public final void p0(ImageView imageView, boolean z) {
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
