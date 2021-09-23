package c.a.r0.w0.n1.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.q0.s.q.d2;
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
public class d extends c.a.r0.w0.k<c.a.r0.j3.y, a> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean x;
    public boolean y;

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f27191a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f27192b;

        /* renamed from: c  reason: collision with root package name */
        public View f27193c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f27194d;

        /* renamed from: e  reason: collision with root package name */
        public View f27195e;

        /* renamed from: f  reason: collision with root package name */
        public View f27196f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f27197g;

        /* renamed from: h  reason: collision with root package name */
        public View f27198h;

        /* renamed from: i  reason: collision with root package name */
        public View f27199i;

        /* renamed from: j  reason: collision with root package name */
        public View f27200j;
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
            this.f27192b = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.f27191a = view.findViewById(R.id.frs_fortune_bag_item);
            this.f27193c = view.findViewById(R.id.frs_my_service_item);
            this.f27194d = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.f27195e = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.f27196f = view.findViewById(R.id.frs_bawu_center);
            this.f27197g = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.f27198h = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.f27199i = view.findViewById(R.id.official_account_text_divider_service_top);
            this.f27200j = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.k.add(this.f27198h);
            this.k.add(this.f27199i);
            this.k.add(this.f27200j);
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
            this.p.a(id, intValue, view, h0(this.q.getListView(), intValue), d2Var);
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new a(LayoutInflater.from(this.f2958e).inflate(R.layout.frs_extra_account_item, (ViewGroup) null)) : (a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.w0.k, c.a.e.l.e.a
    /* renamed from: w0 */
    public View a0(int i2, View view, ViewGroup viewGroup, c.a.r0.j3.y yVar, a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, yVar, aVar})) == null) {
            super.a0(i2, view, viewGroup, yVar, aVar);
            boolean z = true;
            if (yVar.P4()) {
                String N4 = yVar.N4();
                if (N4 != null) {
                    aVar.f27192b.setText(N4);
                } else {
                    FrsViewData frsViewData = this.n;
                    if (frsViewData != null && frsViewData.getForum() != null && this.n.getForum().getName() != null) {
                        TextView textView = aVar.f27192b;
                        Context context = this.f2958e;
                        int i3 = R.string.get_fortune_hint_format;
                        Object[] objArr = new Object[1];
                        FrsViewData frsViewData2 = this.n;
                        objArr[0] = frsViewData2 == null ? "" : frsViewData2.getForum().getName();
                        textView.setText(context.getString(i3, objArr));
                    }
                }
                aVar.f27191a.setTag(Integer.valueOf(i2));
                aVar.f27191a.setOnClickListener(this);
                aVar.f27191a.setVisibility(0);
            } else {
                aVar.f27191a.setVisibility(8);
                aVar.f27198h.setVisibility(8);
            }
            c.a.r0.j3.s O4 = yVar.O4();
            if (O4 != null && O4.b() && !TextUtils.isEmpty(O4.a())) {
                aVar.f27194d.setText(O4.a());
                aVar.f27193c.setTag(Integer.valueOf(i2));
                aVar.f27193c.setOnClickListener(this);
                aVar.f27193c.setVisibility(0);
            } else {
                aVar.f27193c.setVisibility(8);
                aVar.f27199i.setVisibility(8);
            }
            if (this.y) {
                aVar.f27195e.setVisibility(0);
            } else {
                aVar.f27195e.setVisibility(8);
            }
            this.o.getLayoutMode().k(this.r == 1);
            this.o.getLayoutMode().j(view);
            FrsViewData frsViewData3 = this.n;
            z = (frsViewData3 == null || frsViewData3.getUserData() == null || !this.n.getUserData().isBawu()) ? false : false;
            if (z) {
                aVar.f27196f.setVisibility(0);
                SkinManager.setBackgroundResource(aVar.f27196f, R.drawable.frs_top_item_bg);
                aVar.f27195e.setVisibility(0);
                aVar.f27196f.setOnClickListener(this);
                aVar.f27196f.setTag(Integer.valueOf(i2));
            } else {
                aVar.f27196f.setVisibility(8);
                aVar.f27200j.setVisibility(8);
            }
            if (this.x || yVar.P4()) {
                return view;
            }
            if (z) {
                aVar.f27191a.setVisibility(8);
                aVar.f27193c.setVisibility(8);
                u0(aVar);
                return view;
            }
            return new View(this.f2958e);
        }
        return (View) invokeCommon.objValue;
    }
}
