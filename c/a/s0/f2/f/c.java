package c.a.s0.f2.f;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.s0.f2.f.f;
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
/* loaded from: classes7.dex */
public class c extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<f.d> f17508e;

    /* renamed from: f  reason: collision with root package name */
    public LayoutInflater f17509f;

    /* renamed from: g  reason: collision with root package name */
    public int f17510g;

    /* renamed from: h  reason: collision with root package name */
    public int f17511h;

    /* renamed from: i  reason: collision with root package name */
    public int f17512i;

    /* renamed from: j  reason: collision with root package name */
    public int f17513j;

    /* loaded from: classes7.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RelativeLayout a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f17514b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17515c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f17516d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f17517e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f17518f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f17519g;

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
            this.a = (RelativeLayout) view.findViewById(R.id.root);
            this.f17514b = (LinearLayout) view.findViewById(R.id.container);
            this.f17515c = (TextView) view.findViewById(R.id.tv_price_money_label);
            this.f17516d = (TextView) view.findViewById(R.id.tv_price_tag);
            this.f17517e = (TextView) view.findViewById(R.id.tv_price_money);
            this.f17518f = (TextView) view.findViewById(R.id.tv_price_sale);
            this.f17519g = (TextView) view.findViewById(R.id.tv_month);
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
        this.f17509f = LayoutInflater.from(tbPageContext.getPageActivity());
        int k2 = m.k(tbPageContext.getPageActivity());
        this.f17510g = k2;
        this.f17511h = (k2 - tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds120)) / 3;
        this.f17512i = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds360);
        this.f17513j = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public f.d getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (f.d) ListUtils.getItem(this.f17508e, i2) : (f.d) invokeI.objValue;
    }

    public f.d b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            for (int i2 = 0; i2 < this.f17508e.size(); i2++) {
                if (this.f17508e.get(i2).m) {
                    return this.f17508e.get(i2);
                }
            }
            return null;
        }
        return (f.d) invokeV.objValue;
    }

    public final void c(int i2, f.d dVar, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, dVar, aVar) == null) || dVar == null || dVar.f17542j < 0) {
            return;
        }
        aVar.f17519g.setText(f(dVar.f17534b, 7));
        if (TextUtils.isEmpty(dVar.f17535c)) {
            aVar.f17518f.setVisibility(4);
        } else {
            aVar.f17518f.setVisibility(0);
            aVar.f17518f.setText(f(dVar.f17535c, 10));
        }
        TextView textView = aVar.f17517e;
        textView.setText("" + (dVar.f17542j / 100));
        if (TextUtils.isEmpty(dVar.f17540h)) {
            aVar.f17516d.setVisibility(4);
        } else {
            aVar.f17516d.setVisibility(0);
            aVar.f17516d.setText(dVar.f17540h);
        }
        if (i2 == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.a.getLayoutParams();
            layoutParams.width = this.f17511h;
            layoutParams.height = this.f17512i;
            layoutParams.leftMargin = this.f17513j;
            aVar.a.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aVar.a.getLayoutParams();
            layoutParams2.width = this.f17511h;
            layoutParams2.height = this.f17512i;
            layoutParams2.leftMargin = 0;
            aVar.a.setLayoutParams(layoutParams2);
        }
        SkinManager.setViewTextColor(aVar.f17515c, R.color.CAM_X0301);
        SkinManager.setViewTextColor(aVar.f17516d, R.color.CAM_X0101);
        SkinManager.setBackgroundResource(aVar.f17516d, R.drawable.member_price_tag_bg_shape);
        SkinManager.setViewTextColor(aVar.f17517e, R.color.CAM_X0301);
        SkinManager.setViewTextColor(aVar.f17518f, R.color.CAM_X0109);
        SkinManager.setViewTextColor(aVar.f17519g, R.color.CAM_X0105);
        e(dVar, aVar);
    }

    public void d(List<f.d> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f17508e = list;
        }
    }

    public final void e(f.d dVar, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, dVar, aVar) == null) || dVar == null || aVar == null) {
            return;
        }
        if (dVar.m) {
            SkinManager.setBackgroundResource(aVar.f17514b, R.drawable.member_price_bg_shape_s);
        } else {
            SkinManager.setBackgroundResource(aVar.f17514b, R.drawable.member_price_bg_shape_n);
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
        if (!(interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) || dVar == null || this.f17508e == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f17508e.size(); i2++) {
            this.f17508e.get(i2).m = false;
            if (this.f17508e.get(i2).a.equals(dVar.a)) {
                this.f17508e.get(i2).m = true;
            }
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? ListUtils.getCount(this.f17508e) : invokeV.intValue;
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
                view = this.f17509f.inflate(R.layout.member_pay_price_list_item, (ViewGroup) null);
                view.setTag(new a(this, view));
            }
            c(i2, getItem(i2), (a) view.getTag());
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
