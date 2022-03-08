package c.a.r0.d1.v2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import c.a.d.f.p.n;
import c.a.r0.d1.a1;
import c.a.r0.d1.x;
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
public class d extends c.a.r0.f0.c<x> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<c.a.r0.p1.b.c> A;
    public View.OnClickListener B;
    public HListView x;
    public c.a.r0.p1.b.b y;
    public FrsSchoolRecommendItemView z;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f16619e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16619e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f16619e.g() == null) {
                return;
            }
            this.f16619e.g().a(view, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.B = new a(this);
        HListView hListView = new HListView(getContext());
        this.x = hListView;
        hListView.setHeaderDividersEnabled(false);
        this.x.setFooterDividersEnabled(false);
        this.x.setSelector(R.drawable.list_selector_transparent);
        this.z = new FrsSchoolRecommendItemView(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        c.a.r0.p1.b.b bVar = new c.a.r0.p1.b.b(getContext(), R.layout.frs_school_recommend_user, this.z);
        this.y = bVar;
        bVar.d(this.B);
        this.x.setAdapter((ListAdapter) this.y);
        this.u.addView(this.x);
        this.t.setVisibility(8);
        this.n.setTextSize(0, n.f(tbPageContext.getPageActivity(), R.dimen.ds28));
    }

    @Override // c.a.r0.f0.c, c.a.r0.f0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) {
            super.l(tbPageContext, i2);
            if (this.x == null || this.y == null) {
                return;
            }
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
            this.y.b(i2);
        }
    }

    public final boolean t(List<c.a.r0.p1.b.c> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            if (!ListUtils.isEmpty(this.A) && ListUtils.getCount(this.A) == ListUtils.getCount(list)) {
                for (int i2 = 0; i2 < ListUtils.getCount(this.A); i2++) {
                    c.a.r0.p1.b.c cVar = (c.a.r0.p1.b.c) ListUtils.getItem(this.A, i2);
                    c.a.r0.p1.b.c cVar2 = (c.a.r0.p1.b.c) ListUtils.getItem(list, i2);
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
    @Override // c.a.r0.f0.c
    /* renamed from: u */
    public void s(x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, xVar) == null) {
            super.k(xVar);
            if (xVar == null || ListUtils.isEmpty(xVar.getDataList())) {
                return;
            }
            if (StringUtils.isNull(xVar.mGroupTitle)) {
                this.n.setText(getContext().getResources().getString(R.string.school_recommend));
            } else {
                this.n.setText(xVar.mGroupTitle);
            }
            if (t(xVar.getDataList())) {
                List<c.a.r0.p1.b.c> dataList = xVar.getDataList();
                this.A = dataList;
                this.y.c(dataList);
                this.y.notifyDataSetChanged();
            }
        }
    }
}
