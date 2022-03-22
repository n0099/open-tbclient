package c.a.p0.j2.f;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.p0.j2.f.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
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
    public List<f.d> a;

    /* renamed from: b  reason: collision with root package name */
    public LayoutInflater f15722b;

    /* renamed from: c  reason: collision with root package name */
    public int f15723c;

    /* renamed from: d  reason: collision with root package name */
    public int f15724d;

    /* renamed from: e  reason: collision with root package name */
    public int f15725e;

    /* renamed from: f  reason: collision with root package name */
    public int f15726f;

    /* loaded from: classes2.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RelativeLayout a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f15727b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f15728c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15729d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f15730e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f15731f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f15732g;

        public a(c cVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f091ad7);
            this.f15727b = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f0906c9);
            this.f15728c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0921f9);
            this.f15729d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0921fb);
            this.f15730e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0921f8);
            this.f15731f = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0921fa);
            this.f15732g = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0921d4);
        }
    }

    public c(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15722b = LayoutInflater.from(tbPageContext.getPageActivity());
        int k = n.k(tbPageContext.getPageActivity());
        this.f15723c = k;
        this.f15724d = (k - tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds120)) / 3;
        this.f15725e = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds360);
        this.f15726f = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public f.d getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? (f.d) ListUtils.getItem(this.a, i) : (f.d) invokeI.objValue;
    }

    public f.d b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            for (int i = 0; i < this.a.size(); i++) {
                if (this.a.get(i).m) {
                    return this.a.get(i);
                }
            }
            return null;
        }
        return (f.d) invokeV.objValue;
    }

    public final void c(int i, f.d dVar, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, dVar, aVar) == null) || dVar == null || dVar.j < 0) {
            return;
        }
        aVar.f15732g.setText(f(dVar.f15746b, 7));
        if (TextUtils.isEmpty(dVar.f15747c)) {
            aVar.f15731f.setVisibility(4);
        } else {
            aVar.f15731f.setVisibility(0);
            aVar.f15731f.setText(f(dVar.f15747c, 10));
        }
        TextView textView = aVar.f15730e;
        textView.setText("" + (dVar.j / 100));
        if (TextUtils.isEmpty(dVar.f15752h)) {
            aVar.f15729d.setVisibility(4);
        } else {
            aVar.f15729d.setVisibility(0);
            aVar.f15729d.setText(dVar.f15752h);
        }
        if (i == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.a.getLayoutParams();
            layoutParams.width = this.f15724d;
            layoutParams.height = this.f15725e;
            layoutParams.leftMargin = this.f15726f;
            aVar.a.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aVar.a.getLayoutParams();
            layoutParams2.width = this.f15724d;
            layoutParams2.height = this.f15725e;
            layoutParams2.leftMargin = 0;
            aVar.a.setLayoutParams(layoutParams2);
        }
        SkinManager.setViewTextColor(aVar.f15728c, (int) R.color.CAM_X0301);
        SkinManager.setViewTextColor(aVar.f15729d, (int) R.color.CAM_X0101);
        SkinManager.setBackgroundResource(aVar.f15729d, R.drawable.member_price_tag_bg_shape);
        SkinManager.setViewTextColor(aVar.f15730e, (int) R.color.CAM_X0301);
        SkinManager.setViewTextColor(aVar.f15731f, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(aVar.f15732g, (int) R.color.CAM_X0105);
        e(dVar, aVar);
    }

    public void d(List<f.d> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.a = list;
        }
    }

    public final void e(f.d dVar, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, dVar, aVar) == null) || dVar == null || aVar == null) {
            return;
        }
        if (dVar.m) {
            SkinManager.setBackgroundResource(aVar.f15727b, R.drawable.member_price_bg_shape_s);
        } else {
            SkinManager.setBackgroundResource(aVar.f15727b, R.drawable.member_price_bg_shape_n);
        }
    }

    public final String f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i)) == null) {
            if (str.length() > i) {
                return str.substring(0, i - 1) + StringHelper.STRING_MORE;
            }
            return str;
        }
        return (String) invokeLI.objValue;
    }

    public void g(f.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) || dVar == null || this.a == null) {
            return;
        }
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).m = false;
            if (this.a.get(i).a.equals(dVar.a)) {
                this.a.get(i).m = true;
            }
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? ListUtils.getCount(this.a) : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i, view, viewGroup)) == null) {
            if (view == null) {
                view = this.f15722b.inflate(R.layout.obfuscated_res_0x7f0d0545, (ViewGroup) null);
                view.setTag(new a(this, view));
            }
            c(i, getItem(i), (a) view.getTag());
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
