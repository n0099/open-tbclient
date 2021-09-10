package c.a.r0.x1.f;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.r0.x1.f.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<f.d> f28631e;

    /* renamed from: f  reason: collision with root package name */
    public LayoutInflater f28632f;

    /* renamed from: g  reason: collision with root package name */
    public int f28633g;

    /* renamed from: h  reason: collision with root package name */
    public int f28634h;

    /* renamed from: i  reason: collision with root package name */
    public int f28635i;

    /* renamed from: j  reason: collision with root package name */
    public int f28636j;

    /* loaded from: classes4.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f28637a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f28638b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f28639c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f28640d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f28641e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f28642f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f28643g;

        public a(c cVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28637a = (RelativeLayout) view.findViewById(R.id.root);
            this.f28638b = (LinearLayout) view.findViewById(R.id.container);
            this.f28639c = (TextView) view.findViewById(R.id.tv_price_money_label);
            this.f28640d = (TextView) view.findViewById(R.id.tv_price_tag);
            this.f28641e = (TextView) view.findViewById(R.id.tv_price_money);
            this.f28642f = (TextView) view.findViewById(R.id.tv_price_sale);
            this.f28643g = (TextView) view.findViewById(R.id.tv_month);
        }
    }

    public c(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28632f = LayoutInflater.from(tbPageContext.getPageActivity());
        int k = l.k(tbPageContext.getPageActivity());
        this.f28633g = k;
        this.f28634h = (k - tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds120)) / 3;
        this.f28635i = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds360);
        this.f28636j = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public f.d getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (f.d) ListUtils.getItem(this.f28631e, i2) : (f.d) invokeI.objValue;
    }

    public f.d b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            for (int i2 = 0; i2 < this.f28631e.size(); i2++) {
                if (this.f28631e.get(i2).m) {
                    return this.f28631e.get(i2);
                }
            }
            return null;
        }
        return (f.d) invokeV.objValue;
    }

    public final void c(int i2, f.d dVar, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, dVar, aVar) == null) || dVar == null || dVar.f28673j < 0) {
            return;
        }
        aVar.f28643g.setText(f(dVar.f28665b, 7));
        if (TextUtils.isEmpty(dVar.f28666c)) {
            aVar.f28642f.setVisibility(4);
        } else {
            aVar.f28642f.setVisibility(0);
            aVar.f28642f.setText(f(dVar.f28666c, 10));
        }
        TextView textView = aVar.f28641e;
        textView.setText("" + (dVar.f28673j / 100));
        if (TextUtils.isEmpty(dVar.f28671h)) {
            aVar.f28640d.setVisibility(4);
        } else {
            aVar.f28640d.setVisibility(0);
            aVar.f28640d.setText(dVar.f28671h);
        }
        if (i2 == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.f28637a.getLayoutParams();
            layoutParams.width = this.f28634h;
            layoutParams.height = this.f28635i;
            layoutParams.leftMargin = this.f28636j;
            aVar.f28637a.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aVar.f28637a.getLayoutParams();
            layoutParams2.width = this.f28634h;
            layoutParams2.height = this.f28635i;
            layoutParams2.leftMargin = 0;
            aVar.f28637a.setLayoutParams(layoutParams2);
        }
        SkinManager.setViewTextColor(aVar.f28639c, R.color.CAM_X0301);
        SkinManager.setViewTextColor(aVar.f28640d, R.color.CAM_X0101);
        SkinManager.setBackgroundResource(aVar.f28640d, R.drawable.member_price_tag_bg_shape);
        SkinManager.setViewTextColor(aVar.f28641e, R.color.CAM_X0301);
        SkinManager.setViewTextColor(aVar.f28642f, R.color.CAM_X0109);
        SkinManager.setViewTextColor(aVar.f28643g, R.color.CAM_X0105);
        e(dVar, aVar);
    }

    public void d(List<f.d> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f28631e = list;
        }
    }

    public final void e(f.d dVar, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, dVar, aVar) == null) || dVar == null || aVar == null) {
            return;
        }
        if (dVar.m) {
            SkinManager.setBackgroundResource(aVar.f28638b, R.drawable.member_price_bg_shape_s);
        } else {
            SkinManager.setBackgroundResource(aVar.f28638b, R.drawable.member_price_bg_shape_n);
        }
    }

    public final String f(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i2)) == null) {
            if (str.length() > i2) {
                return str.substring(0, i2 - 1) + "...";
            }
            return str;
        }
        return (String) invokeLI.objValue;
    }

    public void g(f.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) || dVar == null || this.f28631e == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f28631e.size(); i2++) {
            this.f28631e.get(i2).m = false;
            if (this.f28631e.get(i2).f28664a.equals(dVar.f28664a)) {
                this.f28631e.get(i2).m = true;
            }
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? ListUtils.getCount(this.f28631e) : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = this.f28632f.inflate(R.layout.member_pay_price_list_item, (ViewGroup) null);
                view.setTag(new a(this, view));
            }
            c(i2, getItem(i2), (a) view.getTag());
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
