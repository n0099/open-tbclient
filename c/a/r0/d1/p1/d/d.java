package c.a.r0.d1.p1.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.q0.r.r.e2;
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
/* loaded from: classes2.dex */
public class d extends c.a.r0.d1.k<c.a.r0.y3.a0, a> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean x;
    public boolean y;

    /* loaded from: classes2.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f15952b;

        /* renamed from: c  reason: collision with root package name */
        public View f15953c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15954d;

        /* renamed from: e  reason: collision with root package name */
        public View f15955e;

        /* renamed from: f  reason: collision with root package name */
        public View f15956f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f15957g;

        /* renamed from: h  reason: collision with root package name */
        public View f15958h;

        /* renamed from: i  reason: collision with root package name */
        public View f15959i;

        /* renamed from: j  reason: collision with root package name */
        public View f15960j;
        public List<View> k;

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
            this.k = new ArrayList();
            this.f15952b = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.a = view.findViewById(R.id.frs_fortune_bag_item);
            this.f15953c = view.findViewById(R.id.frs_my_service_item);
            this.f15954d = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.f15955e = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.f15956f = view.findViewById(R.id.frs_bawu_center);
            this.f15957g = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.f15958h = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.f15959i = view.findViewById(R.id.official_account_text_divider_service_top);
            this.f15960j = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.k.add(this.f15958h);
            this.k.add(this.f15959i);
            this.k.add(this.f15960j);
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

    public final void m0(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            List<View> list = aVar.k;
            for (View view : list) {
                view.setVisibility(8);
            }
            list.get(0).setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: n0 */
    public a M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) ? new a(LayoutInflater.from(this.f3076e).inflate(R.layout.frs_extra_account_item, (ViewGroup) null)) : (a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.d1.k, c.a.d.o.e.a
    /* renamed from: o0 */
    public View S(int i2, View view, ViewGroup viewGroup, c.a.r0.y3.a0 a0Var, a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, a0Var, aVar})) == null) {
            super.S(i2, view, viewGroup, a0Var, aVar);
            boolean z = true;
            if (a0Var.W4()) {
                String U4 = a0Var.U4();
                if (U4 != null) {
                    aVar.f15952b.setText(U4);
                } else {
                    FrsViewData frsViewData = this.n;
                    if (frsViewData != null && frsViewData.getForum() != null && this.n.getForum().getName() != null) {
                        TextView textView = aVar.f15952b;
                        Context context = this.f3076e;
                        Object[] objArr = new Object[1];
                        FrsViewData frsViewData2 = this.n;
                        objArr[0] = frsViewData2 == null ? "" : frsViewData2.getForum().getName();
                        textView.setText(context.getString(R.string.get_fortune_hint_format, objArr));
                    }
                }
                aVar.a.setTag(Integer.valueOf(i2));
                aVar.a.setOnClickListener(this);
                aVar.a.setVisibility(0);
            } else {
                aVar.a.setVisibility(8);
                aVar.f15958h.setVisibility(8);
            }
            c.a.r0.y3.t V4 = a0Var.V4();
            if (V4 != null && V4.b() && !TextUtils.isEmpty(V4.a())) {
                aVar.f15954d.setText(V4.a());
                aVar.f15953c.setTag(Integer.valueOf(i2));
                aVar.f15953c.setOnClickListener(this);
                aVar.f15953c.setVisibility(0);
            } else {
                aVar.f15953c.setVisibility(8);
                aVar.f15959i.setVisibility(8);
            }
            if (this.y) {
                aVar.f15955e.setVisibility(0);
            } else {
                aVar.f15955e.setVisibility(8);
            }
            this.o.getLayoutMode().k(this.r == 1);
            this.o.getLayoutMode().j(view);
            FrsViewData frsViewData3 = this.n;
            z = (frsViewData3 == null || frsViewData3.getUserData() == null || !this.n.getUserData().isBawu()) ? false : false;
            if (z) {
                aVar.f15956f.setVisibility(0);
                SkinManager.setBackgroundResource(aVar.f15956f, R.drawable.frs_top_item_bg);
                aVar.f15955e.setVisibility(0);
                aVar.f15956f.setOnClickListener(this);
                aVar.f15956f.setTag(Integer.valueOf(i2));
            } else {
                aVar.f15956f.setVisibility(8);
                aVar.f15960j.setVisibility(8);
            }
            if (this.x || a0Var.W4()) {
                return view;
            }
            if (z) {
                aVar.a.setVisibility(8);
                aVar.f15953c.setVisibility(8);
                m0(aVar);
                return view;
            }
            return new View(this.f3076e);
        }
        return (View) invokeCommon.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view) == null) || this.p == null) {
            return;
        }
        int id = view.getId();
        int intValue = ((Integer) view.getTag()).intValue();
        if (z(intValue) instanceof e2) {
            e2 e2Var = (e2) z(intValue);
            this.p.a(id, intValue, view, Z(this.q.getListView(), intValue), e2Var);
        }
    }
}
