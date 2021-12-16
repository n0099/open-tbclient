package c.a.s0.d1.y1.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.r0.s.r.d2;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class d extends c.a.s0.d1.k<c.a.s0.v3.z, a> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean x;
    public boolean y;

    /* loaded from: classes7.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f16693b;

        /* renamed from: c  reason: collision with root package name */
        public View f16694c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f16695d;

        /* renamed from: e  reason: collision with root package name */
        public View f16696e;

        /* renamed from: f  reason: collision with root package name */
        public View f16697f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f16698g;

        /* renamed from: h  reason: collision with root package name */
        public View f16699h;

        /* renamed from: i  reason: collision with root package name */
        public View f16700i;

        /* renamed from: j  reason: collision with root package name */
        public View f16701j;

        /* renamed from: k  reason: collision with root package name */
        public List<View> f16702k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16702k = new ArrayList();
            this.f16693b = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.a = view.findViewById(R.id.frs_fortune_bag_item);
            this.f16694c = view.findViewById(R.id.frs_my_service_item);
            this.f16695d = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.f16696e = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.f16697f = view.findViewById(R.id.frs_bawu_center);
            this.f16698g = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.f16699h = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.f16700i = view.findViewById(R.id.official_account_text_divider_service_top);
            this.f16701j = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.f16702k.add(this.f16699h);
            this.f16702k.add(this.f16700i);
            this.f16702k.add(this.f16701j);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.x = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
        this.y = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) || this.p == null) {
            return;
        }
        int id = view.getId();
        int intValue = ((Integer) view.getTag()).intValue();
        if (z(intValue) instanceof d2) {
            d2 d2Var = (d2) z(intValue);
            this.p.a(id, intValue, view, g0(this.q.getListView(), intValue), d2Var);
        }
    }

    public final void t0(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            List<View> list = aVar.f16702k;
            for (View view : list) {
                view.setVisibility(8);
            }
            list.get(0).setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: u0 */
    public a S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new a(LayoutInflater.from(this.f2871e).inflate(R.layout.frs_extra_account_item, (ViewGroup) null)) : (a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.s0.d1.k, c.a.d.m.e.a
    /* renamed from: v0 */
    public View Z(int i2, View view, ViewGroup viewGroup, c.a.s0.v3.z zVar, a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, zVar, aVar})) == null) {
            super.Z(i2, view, viewGroup, zVar, aVar);
            boolean z = true;
            if (zVar.V4()) {
                String T4 = zVar.T4();
                if (T4 != null) {
                    aVar.f16693b.setText(T4);
                } else {
                    FrsViewData frsViewData = this.n;
                    if (frsViewData != null && frsViewData.getForum() != null && this.n.getForum().getName() != null) {
                        TextView textView = aVar.f16693b;
                        Context context = this.f2871e;
                        int i3 = R.string.get_fortune_hint_format;
                        Object[] objArr = new Object[1];
                        FrsViewData frsViewData2 = this.n;
                        objArr[0] = frsViewData2 == null ? "" : frsViewData2.getForum().getName();
                        textView.setText(context.getString(i3, objArr));
                    }
                }
                aVar.a.setTag(Integer.valueOf(i2));
                aVar.a.setOnClickListener(this);
                aVar.a.setVisibility(0);
            } else {
                aVar.a.setVisibility(8);
                aVar.f16699h.setVisibility(8);
            }
            c.a.s0.v3.s U4 = zVar.U4();
            if (U4 != null && U4.b() && !TextUtils.isEmpty(U4.a())) {
                aVar.f16695d.setText(U4.a());
                aVar.f16694c.setTag(Integer.valueOf(i2));
                aVar.f16694c.setOnClickListener(this);
                aVar.f16694c.setVisibility(0);
            } else {
                aVar.f16694c.setVisibility(8);
                aVar.f16700i.setVisibility(8);
            }
            if (this.y) {
                aVar.f16696e.setVisibility(0);
            } else {
                aVar.f16696e.setVisibility(8);
            }
            this.o.getLayoutMode().k(this.r == 1);
            this.o.getLayoutMode().j(view);
            FrsViewData frsViewData3 = this.n;
            z = (frsViewData3 == null || frsViewData3.getUserData() == null || !this.n.getUserData().isBawu()) ? false : false;
            if (z) {
                aVar.f16697f.setVisibility(0);
                SkinManager.setBackgroundResource(aVar.f16697f, R.drawable.frs_top_item_bg);
                aVar.f16696e.setVisibility(0);
                aVar.f16697f.setOnClickListener(this);
                aVar.f16697f.setTag(Integer.valueOf(i2));
            } else {
                aVar.f16697f.setVisibility(8);
                aVar.f16701j.setVisibility(8);
            }
            if (this.x || zVar.V4()) {
                return view;
            }
            if (z) {
                aVar.a.setVisibility(8);
                aVar.f16694c.setVisibility(8);
                t0(aVar);
                return view;
            }
            return new View(this.f2871e);
        }
        return (View) invokeCommon.objValue;
    }
}
