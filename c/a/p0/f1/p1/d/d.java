package c.a.p0.f1.p1.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
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
public class d extends c.a.p0.f1.k<c.a.p0.a4.a0, a> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean t;
    public boolean u;

    /* loaded from: classes2.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f14323b;

        /* renamed from: c  reason: collision with root package name */
        public View f14324c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14325d;

        /* renamed from: e  reason: collision with root package name */
        public View f14326e;

        /* renamed from: f  reason: collision with root package name */
        public View f14327f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f14328g;

        /* renamed from: h  reason: collision with root package name */
        public View f14329h;
        public View i;
        public View j;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = new ArrayList();
            this.f14323b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090aec);
            this.a = view.findViewById(R.id.obfuscated_res_0x7f090aee);
            this.f14324c = view.findViewById(R.id.obfuscated_res_0x7f090b96);
            this.f14325d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090b94);
            this.f14326e = view.findViewById(R.id.obfuscated_res_0x7f090b75);
            this.f14327f = view.findViewById(R.id.obfuscated_res_0x7f090ac9);
            this.f14328g = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090aca);
            this.f14329h = view.findViewById(R.id.obfuscated_res_0x7f0915e6);
            this.i = view.findViewById(R.id.obfuscated_res_0x7f0915e7);
            this.j = view.findViewById(R.id.obfuscated_res_0x7f0915e5);
            this.k.add(this.f14329h);
            this.k.add(this.i);
            this.k.add(this.j);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
        this.u = z;
    }

    public final void l0(a aVar) {
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
    /* renamed from: m0 */
    public a M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) ? new a(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d030c, (ViewGroup) null)) : (a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.f1.k, c.a.d.o.e.a
    /* renamed from: n0 */
    public View S(int i, View view, ViewGroup viewGroup, c.a.p0.a4.a0 a0Var, a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view, viewGroup, a0Var, aVar})) == null) {
            super.S(i, view, viewGroup, a0Var, aVar);
            boolean z = true;
            if (a0Var.i()) {
                String e2 = a0Var.e();
                if (e2 != null) {
                    aVar.f14323b.setText(e2);
                } else {
                    FrsViewData frsViewData = this.j;
                    if (frsViewData != null && frsViewData.getForum() != null && this.j.getForum().getName() != null) {
                        TextView textView = aVar.f14323b;
                        Context context = this.a;
                        Object[] objArr = new Object[1];
                        FrsViewData frsViewData2 = this.j;
                        objArr[0] = frsViewData2 == null ? "" : frsViewData2.getForum().getName();
                        textView.setText(context.getString(R.string.obfuscated_res_0x7f0f0787, objArr));
                    }
                }
                aVar.a.setTag(Integer.valueOf(i));
                aVar.a.setOnClickListener(this);
                aVar.a.setVisibility(0);
            } else {
                aVar.a.setVisibility(8);
                aVar.f14329h.setVisibility(8);
            }
            c.a.p0.a4.t g2 = a0Var.g();
            if (g2 != null && g2.b() && !TextUtils.isEmpty(g2.a())) {
                aVar.f14325d.setText(g2.a());
                aVar.f14324c.setTag(Integer.valueOf(i));
                aVar.f14324c.setOnClickListener(this);
                aVar.f14324c.setVisibility(0);
            } else {
                aVar.f14324c.setVisibility(8);
                aVar.i.setVisibility(8);
            }
            if (this.u) {
                aVar.f14326e.setVisibility(0);
            } else {
                aVar.f14326e.setVisibility(8);
            }
            this.k.getLayoutMode().k(this.n == 1);
            this.k.getLayoutMode().j(view);
            FrsViewData frsViewData3 = this.j;
            z = (frsViewData3 == null || frsViewData3.getUserData() == null || !this.j.getUserData().isBawu()) ? false : false;
            if (z) {
                aVar.f14327f.setVisibility(0);
                SkinManager.setBackgroundResource(aVar.f14327f, R.drawable.frs_top_item_bg);
                aVar.f14326e.setVisibility(0);
                aVar.f14327f.setOnClickListener(this);
                aVar.f14327f.setTag(Integer.valueOf(i));
            } else {
                aVar.f14327f.setVisibility(8);
                aVar.j.setVisibility(8);
            }
            if (this.t || a0Var.i()) {
                return view;
            }
            if (z) {
                aVar.a.setVisibility(8);
                aVar.f14324c.setVisibility(8);
                l0(aVar);
                return view;
            }
            return new View(this.a);
        }
        return (View) invokeCommon.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view) == null) || this.l == null) {
            return;
        }
        int id = view.getId();
        int intValue = ((Integer) view.getTag()).intValue();
        if (z(intValue) instanceof ThreadData) {
            ThreadData threadData = (ThreadData) z(intValue);
            this.l.a(id, intValue, view, Z(this.m.getListView(), intValue), threadData);
        }
    }
}
