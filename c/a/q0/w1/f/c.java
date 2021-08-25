package c.a.q0.w1.f;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.q0.w1.f.f;
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
    public List<f.d> f27944e;

    /* renamed from: f  reason: collision with root package name */
    public LayoutInflater f27945f;

    /* renamed from: g  reason: collision with root package name */
    public int f27946g;

    /* renamed from: h  reason: collision with root package name */
    public int f27947h;

    /* renamed from: i  reason: collision with root package name */
    public int f27948i;

    /* renamed from: j  reason: collision with root package name */
    public int f27949j;

    /* loaded from: classes4.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f27950a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f27951b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f27952c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f27953d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f27954e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f27955f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f27956g;

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
            this.f27950a = (RelativeLayout) view.findViewById(R.id.root);
            this.f27951b = (LinearLayout) view.findViewById(R.id.container);
            this.f27952c = (TextView) view.findViewById(R.id.tv_price_money_label);
            this.f27953d = (TextView) view.findViewById(R.id.tv_price_tag);
            this.f27954e = (TextView) view.findViewById(R.id.tv_price_money);
            this.f27955f = (TextView) view.findViewById(R.id.tv_price_sale);
            this.f27956g = (TextView) view.findViewById(R.id.tv_month);
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
        this.f27945f = LayoutInflater.from(tbPageContext.getPageActivity());
        int k = l.k(tbPageContext.getPageActivity());
        this.f27946g = k;
        this.f27947h = (k - tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds120)) / 3;
        this.f27948i = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds360);
        this.f27949j = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public f.d getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (f.d) ListUtils.getItem(this.f27944e, i2) : (f.d) invokeI.objValue;
    }

    public f.d b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            for (int i2 = 0; i2 < this.f27944e.size(); i2++) {
                if (this.f27944e.get(i2).m) {
                    return this.f27944e.get(i2);
                }
            }
            return null;
        }
        return (f.d) invokeV.objValue;
    }

    public final void c(int i2, f.d dVar, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, dVar, aVar) == null) || dVar == null || dVar.f27986j < 0) {
            return;
        }
        aVar.f27956g.setText(f(dVar.f27978b, 7));
        if (TextUtils.isEmpty(dVar.f27979c)) {
            aVar.f27955f.setVisibility(4);
        } else {
            aVar.f27955f.setVisibility(0);
            aVar.f27955f.setText(f(dVar.f27979c, 10));
        }
        TextView textView = aVar.f27954e;
        textView.setText("" + (dVar.f27986j / 100));
        if (TextUtils.isEmpty(dVar.f27984h)) {
            aVar.f27953d.setVisibility(4);
        } else {
            aVar.f27953d.setVisibility(0);
            aVar.f27953d.setText(dVar.f27984h);
        }
        if (i2 == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.f27950a.getLayoutParams();
            layoutParams.width = this.f27947h;
            layoutParams.height = this.f27948i;
            layoutParams.leftMargin = this.f27949j;
            aVar.f27950a.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aVar.f27950a.getLayoutParams();
            layoutParams2.width = this.f27947h;
            layoutParams2.height = this.f27948i;
            layoutParams2.leftMargin = 0;
            aVar.f27950a.setLayoutParams(layoutParams2);
        }
        SkinManager.setViewTextColor(aVar.f27952c, R.color.CAM_X0301);
        SkinManager.setViewTextColor(aVar.f27953d, R.color.CAM_X0101);
        SkinManager.setBackgroundResource(aVar.f27953d, R.drawable.member_price_tag_bg_shape);
        SkinManager.setViewTextColor(aVar.f27954e, R.color.CAM_X0301);
        SkinManager.setViewTextColor(aVar.f27955f, R.color.CAM_X0109);
        SkinManager.setViewTextColor(aVar.f27956g, R.color.CAM_X0105);
        e(dVar, aVar);
    }

    public void d(List<f.d> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f27944e = list;
        }
    }

    public final void e(f.d dVar, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, dVar, aVar) == null) || dVar == null || aVar == null) {
            return;
        }
        if (dVar.m) {
            SkinManager.setBackgroundResource(aVar.f27951b, R.drawable.member_price_bg_shape_s);
        } else {
            SkinManager.setBackgroundResource(aVar.f27951b, R.drawable.member_price_bg_shape_n);
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
        if (!(interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) || dVar == null || this.f27944e == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f27944e.size(); i2++) {
            this.f27944e.get(i2).m = false;
            if (this.f27944e.get(i2).f27977a.equals(dVar.f27977a)) {
                this.f27944e.get(i2).m = true;
            }
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? ListUtils.getCount(this.f27944e) : invokeV.intValue;
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
                view = this.f27945f.inflate(R.layout.member_pay_price_list_item, (ViewGroup) null);
                view.setTag(new a(this, view));
            }
            c(i2, getItem(i2), (a) view.getTag());
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
