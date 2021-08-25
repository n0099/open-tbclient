package c.a.q0.v0.m1.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.p0.s.q.c2;
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
/* loaded from: classes4.dex */
public class d extends c.a.q0.v0.k<c.a.q0.i3.x, a> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean x;
    public boolean y;

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f26503a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f26504b;

        /* renamed from: c  reason: collision with root package name */
        public View f26505c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f26506d;

        /* renamed from: e  reason: collision with root package name */
        public View f26507e;

        /* renamed from: f  reason: collision with root package name */
        public View f26508f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f26509g;

        /* renamed from: h  reason: collision with root package name */
        public View f26510h;

        /* renamed from: i  reason: collision with root package name */
        public View f26511i;

        /* renamed from: j  reason: collision with root package name */
        public View f26512j;
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
            this.f26504b = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.f26503a = view.findViewById(R.id.frs_fortune_bag_item);
            this.f26505c = view.findViewById(R.id.frs_my_service_item);
            this.f26506d = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.f26507e = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.f26508f = view.findViewById(R.id.frs_bawu_center);
            this.f26509g = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.f26510h = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.f26511i = view.findViewById(R.id.official_account_text_divider_service_top);
            this.f26512j = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.k.add(this.f26510h);
            this.k.add(this.f26511i);
            this.k.add(this.f26512j);
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
        if (z(intValue) instanceof c2) {
            c2 c2Var = (c2) z(intValue);
            this.p.a(id, intValue, view, h0(this.q.getListView(), intValue), c2Var);
        }
    }

    public final void u0(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            List<View> list = aVar.k;
            for (View view : list) {
                view.setVisibility(8);
            }
            list.get(0).setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: v0 */
    public a U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new a(LayoutInflater.from(this.f2966e).inflate(R.layout.frs_extra_account_item, (ViewGroup) null)) : (a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.v0.k, c.a.e.l.e.a
    /* renamed from: w0 */
    public View a0(int i2, View view, ViewGroup viewGroup, c.a.q0.i3.x xVar, a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, xVar, aVar})) == null) {
            super.a0(i2, view, viewGroup, xVar, aVar);
            boolean z = true;
            if (xVar.F4()) {
                String D4 = xVar.D4();
                if (D4 != null) {
                    aVar.f26504b.setText(D4);
                } else {
                    FrsViewData frsViewData = this.n;
                    if (frsViewData != null && frsViewData.getForum() != null && this.n.getForum().getName() != null) {
                        TextView textView = aVar.f26504b;
                        Context context = this.f2966e;
                        int i3 = R.string.get_fortune_hint_format;
                        Object[] objArr = new Object[1];
                        FrsViewData frsViewData2 = this.n;
                        objArr[0] = frsViewData2 == null ? "" : frsViewData2.getForum().getName();
                        textView.setText(context.getString(i3, objArr));
                    }
                }
                aVar.f26503a.setTag(Integer.valueOf(i2));
                aVar.f26503a.setOnClickListener(this);
                aVar.f26503a.setVisibility(0);
            } else {
                aVar.f26503a.setVisibility(8);
                aVar.f26510h.setVisibility(8);
            }
            c.a.q0.i3.r E4 = xVar.E4();
            if (E4 != null && E4.b() && !TextUtils.isEmpty(E4.a())) {
                aVar.f26506d.setText(E4.a());
                aVar.f26505c.setTag(Integer.valueOf(i2));
                aVar.f26505c.setOnClickListener(this);
                aVar.f26505c.setVisibility(0);
            } else {
                aVar.f26505c.setVisibility(8);
                aVar.f26511i.setVisibility(8);
            }
            if (this.y) {
                aVar.f26507e.setVisibility(0);
            } else {
                aVar.f26507e.setVisibility(8);
            }
            this.o.getLayoutMode().k(this.r == 1);
            this.o.getLayoutMode().j(view);
            FrsViewData frsViewData3 = this.n;
            z = (frsViewData3 == null || frsViewData3.getUserData() == null || !this.n.getUserData().isBawu()) ? false : false;
            if (z) {
                aVar.f26508f.setVisibility(0);
                SkinManager.setBackgroundResource(aVar.f26508f, R.drawable.frs_top_item_bg);
                aVar.f26507e.setVisibility(0);
                aVar.f26508f.setOnClickListener(this);
                aVar.f26508f.setTag(Integer.valueOf(i2));
            } else {
                aVar.f26508f.setVisibility(8);
                aVar.f26512j.setVisibility(8);
            }
            if (this.x || xVar.F4()) {
                return view;
            }
            if (z) {
                aVar.f26503a.setVisibility(8);
                aVar.f26505c.setVisibility(8);
                u0(aVar);
                return view;
            }
            return new View(this.f2966e);
        }
        return (View) invokeCommon.objValue;
    }
}
