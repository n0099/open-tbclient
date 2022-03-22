package c.a.p0.s2.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.d.o.e.w;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
/* loaded from: classes2.dex */
public class e extends c.a.d.o.e.a<c.a.p0.s2.c.d, InterestedForumStyleAForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.s2.f.c i;

    /* loaded from: classes2.dex */
    public class a implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // c.a.d.o.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nVar instanceof c.a.p0.s2.c.d)) {
                c.a.p0.s2.c.d dVar = (c.a.p0.s2.c.d) nVar;
                dVar.u(!dVar.k());
                InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder = (InterestedForumStyleAForumViewHolder) view.getTag();
                if (interestedForumStyleAForumViewHolder != null) {
                    this.a.i0(interestedForumStyleAForumViewHolder.f34792h, dVar.k());
                }
                if (this.a.i != null) {
                    this.a.i.a();
                }
                if (dVar.k()) {
                    this.a.c0(dVar);
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
    public /* bridge */ /* synthetic */ View S(int i, View view, ViewGroup viewGroup, c.a.p0.s2.c.d dVar, InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder) {
        e0(i, view, viewGroup, dVar, interestedForumStyleAForumViewHolder);
        return view;
    }

    public final void c0(c.a.p0.s2.c.d dVar) {
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
    @Override // c.a.d.o.e.a
    /* renamed from: d0 */
    public InterestedForumStyleAForumViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            if (UbsABTestHelper.isInterestGuideStyleA()) {
                inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0400, viewGroup, false);
            } else {
                inflate = UbsABTestHelper.isInterestGuideStyleB() ? LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0403, viewGroup, false) : null;
            }
            return new InterestedForumStyleAForumViewHolder(inflate);
        }
        return (InterestedForumStyleAForumViewHolder) invokeL.objValue;
    }

    public View e0(int i, View view, ViewGroup viewGroup, c.a.p0.s2.c.d dVar, InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view, viewGroup, dVar, interestedForumStyleAForumViewHolder})) == null) {
            if (dVar == null) {
                return view;
            }
            h0(interestedForumStyleAForumViewHolder);
            f0(interestedForumStyleAForumViewHolder, dVar);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void f0(InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder, c.a.p0.s2.c.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, interestedForumStyleAForumViewHolder, dVar) == null) {
            interestedForumStyleAForumViewHolder.f34786b.setShowOval(true);
            interestedForumStyleAForumViewHolder.f34786b.setAutoChangeStyle(true);
            interestedForumStyleAForumViewHolder.f34786b.setStrokeWith(c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            interestedForumStyleAForumViewHolder.f34786b.setStrokeColorResId(R.color.CAM_X0401);
            interestedForumStyleAForumViewHolder.f34786b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            interestedForumStyleAForumViewHolder.f34786b.setPlaceHolder(1);
            interestedForumStyleAForumViewHolder.f34786b.J(dVar.a(), 10, false);
            interestedForumStyleAForumViewHolder.f34787c.setText(dVar.f() + this.a.getString(R.string.obfuscated_res_0x7f0f063c));
            if (!StringUtils.isNull(dVar.i())) {
                interestedForumStyleAForumViewHolder.f34788d.setText(this.a.getString(R.string.obfuscated_res_0x7f0f091a, dVar.i()));
            } else {
                interestedForumStyleAForumViewHolder.f34788d.setText(this.a.getString(R.string.obfuscated_res_0x7f0f091e));
            }
            interestedForumStyleAForumViewHolder.f34789e.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f040e), StringHelper.numberUniformFormatExtraWithRoundInt(dVar.g())));
            interestedForumStyleAForumViewHolder.f34790f.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f06a6), StringHelper.numberUniformFormatExtraWithRoundInt(dVar.j())));
            i0(interestedForumStyleAForumViewHolder.f34792h, dVar.k());
        }
    }

    public void g0(c.a.p0.s2.f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.i = cVar;
        }
    }

    public final void h0(InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, interestedForumStyleAForumViewHolder) == null) {
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(interestedForumStyleAForumViewHolder.f34787c);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X06);
            c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(interestedForumStyleAForumViewHolder.f34788d);
            d3.v(R.color.CAM_X0109);
            d3.z(R.dimen.T_X09);
            c.a.o0.r.v.c d4 = c.a.o0.r.v.c.d(interestedForumStyleAForumViewHolder.f34789e);
            d4.v(R.color.CAM_X0109);
            d4.z(R.dimen.T_X09);
            c.a.o0.r.v.c d5 = c.a.o0.r.v.c.d(interestedForumStyleAForumViewHolder.f34790f);
            d5.v(R.color.CAM_X0109);
            d5.z(R.dimen.T_X09);
            TBSelector.setViewBackgroundColorWithPressedState(interestedForumStyleAForumViewHolder.a, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public final void i0(ImageView imageView, boolean z) {
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
