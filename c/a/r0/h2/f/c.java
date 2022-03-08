package c.a.r0.h2.f;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.r0.h2.f.f;
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
/* loaded from: classes2.dex */
public class c extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<f.d> f17940e;

    /* renamed from: f  reason: collision with root package name */
    public LayoutInflater f17941f;

    /* renamed from: g  reason: collision with root package name */
    public int f17942g;

    /* renamed from: h  reason: collision with root package name */
    public int f17943h;

    /* renamed from: i  reason: collision with root package name */
    public int f17944i;

    /* renamed from: j  reason: collision with root package name */
    public int f17945j;

    /* loaded from: classes2.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RelativeLayout a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f17946b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17947c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f17948d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f17949e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f17950f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f17951g;

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
            this.f17946b = (LinearLayout) view.findViewById(R.id.container);
            this.f17947c = (TextView) view.findViewById(R.id.tv_price_money_label);
            this.f17948d = (TextView) view.findViewById(R.id.tv_price_tag);
            this.f17949e = (TextView) view.findViewById(R.id.tv_price_money);
            this.f17950f = (TextView) view.findViewById(R.id.tv_price_sale);
            this.f17951g = (TextView) view.findViewById(R.id.tv_month);
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
        this.f17941f = LayoutInflater.from(tbPageContext.getPageActivity());
        int k = n.k(tbPageContext.getPageActivity());
        this.f17942g = k;
        this.f17943h = (k - tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds120)) / 3;
        this.f17944i = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds360);
        this.f17945j = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public f.d getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (f.d) ListUtils.getItem(this.f17940e, i2) : (f.d) invokeI.objValue;
    }

    public f.d b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            for (int i2 = 0; i2 < this.f17940e.size(); i2++) {
                if (this.f17940e.get(i2).m) {
                    return this.f17940e.get(i2);
                }
            }
            return null;
        }
        return (f.d) invokeV.objValue;
    }

    public final void c(int i2, f.d dVar, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, dVar, aVar) == null) || dVar == null || dVar.f17974j < 0) {
            return;
        }
        aVar.f17951g.setText(f(dVar.f17966b, 7));
        if (TextUtils.isEmpty(dVar.f17967c)) {
            aVar.f17950f.setVisibility(4);
        } else {
            aVar.f17950f.setVisibility(0);
            aVar.f17950f.setText(f(dVar.f17967c, 10));
        }
        TextView textView = aVar.f17949e;
        textView.setText("" + (dVar.f17974j / 100));
        if (TextUtils.isEmpty(dVar.f17972h)) {
            aVar.f17948d.setVisibility(4);
        } else {
            aVar.f17948d.setVisibility(0);
            aVar.f17948d.setText(dVar.f17972h);
        }
        if (i2 == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.a.getLayoutParams();
            layoutParams.width = this.f17943h;
            layoutParams.height = this.f17944i;
            layoutParams.leftMargin = this.f17945j;
            aVar.a.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aVar.a.getLayoutParams();
            layoutParams2.width = this.f17943h;
            layoutParams2.height = this.f17944i;
            layoutParams2.leftMargin = 0;
            aVar.a.setLayoutParams(layoutParams2);
        }
        SkinManager.setViewTextColor(aVar.f17947c, (int) R.color.CAM_X0301);
        SkinManager.setViewTextColor(aVar.f17948d, (int) R.color.CAM_X0101);
        SkinManager.setBackgroundResource(aVar.f17948d, R.drawable.member_price_tag_bg_shape);
        SkinManager.setViewTextColor(aVar.f17949e, (int) R.color.CAM_X0301);
        SkinManager.setViewTextColor(aVar.f17950f, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(aVar.f17951g, (int) R.color.CAM_X0105);
        e(dVar, aVar);
    }

    public void d(List<f.d> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f17940e = list;
        }
    }

    public final void e(f.d dVar, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, dVar, aVar) == null) || dVar == null || aVar == null) {
            return;
        }
        if (dVar.m) {
            SkinManager.setBackgroundResource(aVar.f17946b, R.drawable.member_price_bg_shape_s);
        } else {
            SkinManager.setBackgroundResource(aVar.f17946b, R.drawable.member_price_bg_shape_n);
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
        if (!(interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) || dVar == null || this.f17940e == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f17940e.size(); i2++) {
            this.f17940e.get(i2).m = false;
            if (this.f17940e.get(i2).a.equals(dVar.a)) {
                this.f17940e.get(i2).m = true;
            }
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? ListUtils.getCount(this.f17940e) : invokeV.intValue;
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
                view = this.f17941f.inflate(R.layout.member_pay_price_list_item, (ViewGroup) null);
                view.setTag(new a(this, view));
            }
            c(i2, getItem(i2), (a) view.getTag());
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
