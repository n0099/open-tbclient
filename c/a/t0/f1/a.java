package c.a.t0.f1;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.u0.a4.f;
import c.a.u0.a4.g;
import c.a.u0.a4.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f12874e;

    /* renamed from: f  reason: collision with root package name */
    public int f12875f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f12876g;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f12877h;

    /* renamed from: i  reason: collision with root package name */
    public List<String> f12878i;

    /* renamed from: c.a.t0.f1.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0853a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f12879b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f12880c;

        public C0853a(a aVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            TbImageView tbImageView = (TbImageView) view.findViewById(g.bar_select_rule_head_view);
            this.a = tbImageView;
            tbImageView.setDefaultBgResource(c.a.u0.a4.d.CAM_X0206);
            this.f12879b = (TextView) view.findViewById(g.bar_select_rule_title);
            this.f12880c = (TextView) view.findViewById(g.bar_select_rule_content);
        }
    }

    /* loaded from: classes6.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f12881b;

        public b(a aVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (TextView) view.findViewById(g.pb_vote_select_rule_title);
            this.f12881b = (TextView) view.findViewById(g.pb_vote_select_rule_content);
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12875f = 0;
        this.f12874e = context;
        this.f12876g = new ArrayList();
        this.f12877h = new ArrayList();
        this.f12878i = new ArrayList();
    }

    public void a(C0853a c0853a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, c0853a) == null) || c0853a == null) {
            return;
        }
        SkinManager.setViewTextColor(c0853a.f12879b, c.a.u0.a4.d.CAM_X0105, 1);
        SkinManager.setViewTextColor(c0853a.f12880c, c.a.u0.a4.d.CAM_X0109, 1);
    }

    public void b(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null) {
            return;
        }
        SkinManager.setViewTextColor(bVar.a, c.a.u0.a4.d.CAM_X0105);
        SkinManager.setViewTextColor(bVar.f12881b, c.a.u0.a4.d.CAM_X0109);
    }

    public void c(List<String> list, List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, list2) == null) {
            this.f12877h.clear();
            this.f12878i.clear();
            if (!ListUtils.isEmpty(list) && !ListUtils.isEmpty(list2)) {
                this.f12877h.addAll(list);
                this.f12878i.addAll(list2);
            }
            notifyDataSetChanged();
        }
    }

    public void d(List<String> list, List<String> list2, List<String> list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, list, list2, list3) == null) {
            this.f12876g.clear();
            if (!ListUtils.isEmpty(list)) {
                this.f12876g.addAll(list);
            }
            c(list2, list3);
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f12875f = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (ListUtils.isEmpty(this.f12877h)) {
                return 0;
            }
            return this.f12877h.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? super.getItemViewType(i2) : invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i2, view, viewGroup)) == null) {
            int i3 = this.f12875f;
            if (i3 == 0) {
                view = LayoutInflater.from(this.f12874e).inflate(h.pb_vote_select_rule_item, (ViewGroup) null, false);
                b bVar = new b(this, view);
                if (!ListUtils.isEmpty(this.f12877h) && this.f12877h.size() > i2 && !TextUtils.isEmpty(this.f12877h.get(i2))) {
                    bVar.a.setText(this.f12877h.get(i2));
                    bVar.a.setVisibility(0);
                } else {
                    bVar.a.setVisibility(8);
                }
                if (!ListUtils.isEmpty(this.f12878i) && this.f12878i.size() > i2 && !TextUtils.isEmpty(this.f12878i.get(i2))) {
                    bVar.f12881b.setText(this.f12878i.get(i2));
                    bVar.f12881b.setVisibility(0);
                } else {
                    bVar.f12881b.setVisibility(8);
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                view.setLayoutParams(layoutParams);
                b(bVar);
            } else if (i3 == 1) {
                view = LayoutInflater.from(this.f12874e).inflate(h.bar_select_rule_item, (ViewGroup) null, false);
                C0853a c0853a = new C0853a(this, view);
                if (!ListUtils.isEmpty(this.f12876g) && this.f12876g.size() > i2 && !TextUtils.isEmpty(this.f12876g.get(i2))) {
                    c0853a.a.setDefaultResource(f.transparent_bg);
                    c0853a.a.startLoad(this.f12876g.get(i2), 10, false);
                }
                if (!ListUtils.isEmpty(this.f12877h) && this.f12877h.size() > i2 && !TextUtils.isEmpty(this.f12877h.get(i2))) {
                    c0853a.f12879b.setText(this.f12877h.get(i2));
                    c0853a.f12879b.setVisibility(0);
                } else {
                    c0853a.f12879b.setVisibility(8);
                }
                if (!ListUtils.isEmpty(this.f12878i) && this.f12878i.size() > i2 && !TextUtils.isEmpty(this.f12878i.get(i2))) {
                    c0853a.f12880c.setText(this.f12878i.get(i2));
                    c0853a.f12880c.setVisibility(0);
                } else {
                    c0853a.f12880c.setVisibility(8);
                }
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
                layoutParams2.weight = 1.0f;
                view.setLayoutParams(layoutParams2);
                a(c0853a);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
