package c.a.u0.h2.f;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.u0.h2.f.f;
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
/* loaded from: classes8.dex */
public class c extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<f.d> f18480e;

    /* renamed from: f  reason: collision with root package name */
    public LayoutInflater f18481f;

    /* renamed from: g  reason: collision with root package name */
    public int f18482g;

    /* renamed from: h  reason: collision with root package name */
    public int f18483h;

    /* renamed from: i  reason: collision with root package name */
    public int f18484i;

    /* renamed from: j  reason: collision with root package name */
    public int f18485j;

    /* loaded from: classes8.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RelativeLayout a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f18486b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f18487c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f18488d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f18489e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f18490f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f18491g;

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
            this.f18486b = (LinearLayout) view.findViewById(R.id.container);
            this.f18487c = (TextView) view.findViewById(R.id.tv_price_money_label);
            this.f18488d = (TextView) view.findViewById(R.id.tv_price_tag);
            this.f18489e = (TextView) view.findViewById(R.id.tv_price_money);
            this.f18490f = (TextView) view.findViewById(R.id.tv_price_sale);
            this.f18491g = (TextView) view.findViewById(R.id.tv_month);
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
        this.f18481f = LayoutInflater.from(tbPageContext.getPageActivity());
        int k = n.k(tbPageContext.getPageActivity());
        this.f18482g = k;
        this.f18483h = (k - tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds120)) / 3;
        this.f18484i = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds360);
        this.f18485j = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public f.d getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (f.d) ListUtils.getItem(this.f18480e, i2) : (f.d) invokeI.objValue;
    }

    public f.d b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            for (int i2 = 0; i2 < this.f18480e.size(); i2++) {
                if (this.f18480e.get(i2).m) {
                    return this.f18480e.get(i2);
                }
            }
            return null;
        }
        return (f.d) invokeV.objValue;
    }

    public final void c(int i2, f.d dVar, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, dVar, aVar) == null) || dVar == null || dVar.f18514j < 0) {
            return;
        }
        aVar.f18491g.setText(f(dVar.f18506b, 7));
        if (TextUtils.isEmpty(dVar.f18507c)) {
            aVar.f18490f.setVisibility(4);
        } else {
            aVar.f18490f.setVisibility(0);
            aVar.f18490f.setText(f(dVar.f18507c, 10));
        }
        TextView textView = aVar.f18489e;
        textView.setText("" + (dVar.f18514j / 100));
        if (TextUtils.isEmpty(dVar.f18512h)) {
            aVar.f18488d.setVisibility(4);
        } else {
            aVar.f18488d.setVisibility(0);
            aVar.f18488d.setText(dVar.f18512h);
        }
        if (i2 == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.a.getLayoutParams();
            layoutParams.width = this.f18483h;
            layoutParams.height = this.f18484i;
            layoutParams.leftMargin = this.f18485j;
            aVar.a.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aVar.a.getLayoutParams();
            layoutParams2.width = this.f18483h;
            layoutParams2.height = this.f18484i;
            layoutParams2.leftMargin = 0;
            aVar.a.setLayoutParams(layoutParams2);
        }
        SkinManager.setViewTextColor(aVar.f18487c, R.color.CAM_X0301);
        SkinManager.setViewTextColor(aVar.f18488d, R.color.CAM_X0101);
        SkinManager.setBackgroundResource(aVar.f18488d, R.drawable.member_price_tag_bg_shape);
        SkinManager.setViewTextColor(aVar.f18489e, R.color.CAM_X0301);
        SkinManager.setViewTextColor(aVar.f18490f, R.color.CAM_X0109);
        SkinManager.setViewTextColor(aVar.f18491g, R.color.CAM_X0105);
        e(dVar, aVar);
    }

    public void d(List<f.d> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f18480e = list;
        }
    }

    public final void e(f.d dVar, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, dVar, aVar) == null) || dVar == null || aVar == null) {
            return;
        }
        if (dVar.m) {
            SkinManager.setBackgroundResource(aVar.f18486b, R.drawable.member_price_bg_shape_s);
        } else {
            SkinManager.setBackgroundResource(aVar.f18486b, R.drawable.member_price_bg_shape_n);
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
        if (!(interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) || dVar == null || this.f18480e == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f18480e.size(); i2++) {
            this.f18480e.get(i2).m = false;
            if (this.f18480e.get(i2).a.equals(dVar.a)) {
                this.f18480e.get(i2).m = true;
            }
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? ListUtils.getCount(this.f18480e) : invokeV.intValue;
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
                view = this.f18481f.inflate(R.layout.member_pay_price_list_item, (ViewGroup) null);
                view.setTag(new a(this, view));
            }
            c(i2, getItem(i2), (a) view.getTag());
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
