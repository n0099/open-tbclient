package c.a.p0.f1.v2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import c.a.d.f.p.n;
import c.a.p0.f1.a1;
import c.a.p0.f1.x;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsSchoolRecommendItemView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class f extends c.a.p0.h0.c<x> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HListView t;
    public c.a.p0.r1.b.b u;
    public FrsSchoolRecommendItemView v;
    public List<c.a.p0.r1.b.c> w;
    public View.OnClickListener x;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.h() == null) {
                return;
            }
            this.a.h().a(view, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.x = new a(this);
        HListView hListView = new HListView(getContext());
        this.t = hListView;
        hListView.setHeaderDividersEnabled(false);
        this.t.setFooterDividersEnabled(false);
        this.t.setSelector(R.drawable.obfuscated_res_0x7f080d04);
        this.v = new FrsSchoolRecommendItemView(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d034e, (ViewGroup) null), tbPageContext, bdUniqueId);
        c.a.p0.r1.b.b bVar = new c.a.p0.r1.b.b(getContext(), R.layout.obfuscated_res_0x7f0d034e, this.v);
        this.u = bVar;
        bVar.d(this.x);
        this.t.setAdapter((ListAdapter) this.u);
        this.q.addView(this.t);
        this.p.setVisibility(8);
        this.j.setTextSize(0, n.f(tbPageContext.getPageActivity(), R.dimen.obfuscated_res_0x7f0701f9));
    }

    @Override // c.a.p0.h0.c, c.a.p0.h0.b
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i) == null) {
            super.m(tbPageContext, i);
            if (this.t == null || this.u == null) {
                return;
            }
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0109);
            this.u.b(i);
        }
    }

    public final boolean u(List<c.a.p0.r1.b.c> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            if (!ListUtils.isEmpty(this.w) && ListUtils.getCount(this.w) == ListUtils.getCount(list)) {
                for (int i = 0; i < ListUtils.getCount(this.w); i++) {
                    c.a.p0.r1.b.c cVar = (c.a.p0.r1.b.c) ListUtils.getItem(this.w, i);
                    c.a.p0.r1.b.c cVar2 = (c.a.p0.r1.b.c) ListUtils.getItem(list, i);
                    if ((cVar instanceof a1) && (cVar2 instanceof a1) && !((a1) cVar).a.getUserId().equals(((a1) cVar2).a.getUserId())) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.h0.c
    /* renamed from: v */
    public void t(x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, xVar) == null) {
            super.l(xVar);
            if (xVar == null || ListUtils.isEmpty(xVar.getDataList())) {
                return;
            }
            if (StringUtils.isNull(xVar.mGroupTitle)) {
                this.j.setText(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f1074));
            } else {
                this.j.setText(xVar.mGroupTitle);
            }
            if (u(xVar.getDataList())) {
                List<c.a.p0.r1.b.c> dataList = xVar.getDataList();
                this.w = dataList;
                this.u.c(dataList);
                this.u.notifyDataSetChanged();
            }
        }
    }
}
