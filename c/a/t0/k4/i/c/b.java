package c.a.t0.k4.i.c;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.t0.k4.i.e.a> f19327e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.k4.i.e.a f19328f;

    /* loaded from: classes7.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f19329b;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19327e = new ArrayList();
    }

    public List<c.a.t0.k4.i.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19327e : (List) invokeV.objValue;
    }

    public void b(c.a.t0.k4.i.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (aVar == null) {
                List<c.a.t0.k4.i.e.a> list = this.f19327e;
                if (list != null) {
                    this.f19328f = list.get(0);
                }
            } else {
                this.f19328f = aVar;
            }
            notifyDataSetChanged();
        }
    }

    public void c(List<c.a.t0.k4.i.e.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || list == null) {
            return;
        }
        this.f19327e = list;
        if (list.size() > 0) {
            this.f19328f = this.f19327e.get(0);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19327e.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (i2 < 0 || i2 >= this.f19327e.size()) {
                return null;
            }
            return this.f19327e.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View view2;
        a aVar;
        c.a.t0.k4.i.e.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                aVar = new a(this);
                view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_filter, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.iv_effect);
                aVar.a = tbImageView;
                tbImageView.setIsRound(true);
                aVar.a.setDrawerType(1);
                aVar.a.setDefaultBgResource(R.color.transparent);
                aVar.a.setBorderWidth(n.f(viewGroup.getContext(), R.dimen.ds4));
                aVar.a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
                aVar.a.setConrers(15);
                TextView textView = (TextView) view2.findViewById(R.id.tv_name);
                aVar.f19329b = textView;
                SkinManager.setViewTextColor(textView, R.color.CAM_X0107);
                aVar.f19329b = (TextView) view2.findViewById(R.id.tv_name);
                view2.setTag(aVar);
            } else {
                view2 = view;
                aVar = (a) view.getTag();
            }
            if (i2 >= 0 && i2 < this.f19327e.size()) {
                c.a.t0.k4.i.e.a aVar3 = this.f19327e.get(i2);
                if (aVar3 != null) {
                    aVar.a.setTag(aVar3);
                    aVar.a.setOnClickListener(this);
                    aVar.a.startLoad(String.valueOf(aVar3.f19379b), 24, false);
                    aVar.f19329b.setText(aVar3.a);
                }
                if (!TextUtils.isEmpty(aVar3.a) && (aVar2 = this.f19328f) != null && TextUtils.equals(aVar3.a, aVar2.a)) {
                    aVar.a.setDrawBorder(true);
                } else {
                    aVar.a.setDrawBorder(false);
                }
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, view) == null) && view.getId() == R.id.iv_effect && (view.getTag() instanceof c.a.t0.k4.i.e.a)) {
            this.f19328f = (c.a.t0.k4.i.e.a) view.getTag();
            notifyDataSetChanged();
        }
    }
}
