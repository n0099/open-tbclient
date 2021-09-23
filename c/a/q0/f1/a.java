package c.a.q0.f1;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
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
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f13085e;

    /* renamed from: f  reason: collision with root package name */
    public int f13086f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f13087g;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f13088h;

    /* renamed from: i  reason: collision with root package name */
    public List<String> f13089i;

    /* renamed from: c.a.q0.f1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0651a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f13090a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f13091b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f13092c;

        public C0651a(a aVar, View view) {
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
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.bar_select_rule_head_view);
            this.f13090a = tbImageView;
            tbImageView.setDefaultBgResource(R.color.CAM_X0206);
            this.f13091b = (TextView) view.findViewById(R.id.bar_select_rule_title);
            this.f13092c = (TextView) view.findViewById(R.id.bar_select_rule_content);
        }
    }

    /* loaded from: classes3.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f13093a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f13094b;

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
            this.f13093a = (TextView) view.findViewById(R.id.pb_vote_select_rule_title);
            this.f13094b = (TextView) view.findViewById(R.id.pb_vote_select_rule_content);
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
        this.f13086f = 0;
        this.f13085e = context;
        this.f13087g = new ArrayList();
        this.f13088h = new ArrayList();
        this.f13089i = new ArrayList();
    }

    public void a(C0651a c0651a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, c0651a) == null) || c0651a == null) {
            return;
        }
        SkinManager.setViewTextColor(c0651a.f13091b, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(c0651a.f13092c, R.color.CAM_X0109, 1);
    }

    public void b(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null) {
            return;
        }
        SkinManager.setViewTextColor(bVar.f13093a, R.color.CAM_X0105);
        SkinManager.setViewTextColor(bVar.f13094b, R.color.CAM_X0109);
    }

    public void c(List<String> list, List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, list2) == null) {
            this.f13088h.clear();
            this.f13089i.clear();
            if (!ListUtils.isEmpty(list) && !ListUtils.isEmpty(list2)) {
                this.f13088h.addAll(list);
                this.f13089i.addAll(list2);
            }
            notifyDataSetChanged();
        }
    }

    public void d(List<String> list, List<String> list2, List<String> list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, list, list2, list3) == null) {
            this.f13087g.clear();
            if (!ListUtils.isEmpty(list)) {
                this.f13087g.addAll(list);
            }
            c(list2, list3);
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f13086f = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (ListUtils.isEmpty(this.f13088h)) {
                return 0;
            }
            return this.f13088h.size();
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
            int i3 = this.f13086f;
            if (i3 == 0) {
                view = LayoutInflater.from(this.f13085e).inflate(R.layout.pb_vote_select_rule_item, (ViewGroup) null, false);
                b bVar = new b(this, view);
                if (!ListUtils.isEmpty(this.f13088h) && this.f13088h.size() > i2 && !TextUtils.isEmpty(this.f13088h.get(i2))) {
                    bVar.f13093a.setText(this.f13088h.get(i2));
                    bVar.f13093a.setVisibility(0);
                } else {
                    bVar.f13093a.setVisibility(8);
                }
                if (!ListUtils.isEmpty(this.f13089i) && this.f13089i.size() > i2 && !TextUtils.isEmpty(this.f13089i.get(i2))) {
                    bVar.f13094b.setText(this.f13089i.get(i2));
                    bVar.f13094b.setVisibility(0);
                } else {
                    bVar.f13094b.setVisibility(8);
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                view.setLayoutParams(layoutParams);
                b(bVar);
            } else if (i3 == 1) {
                view = LayoutInflater.from(this.f13085e).inflate(R.layout.bar_select_rule_item, (ViewGroup) null, false);
                C0651a c0651a = new C0651a(this, view);
                if (!ListUtils.isEmpty(this.f13087g) && this.f13087g.size() > i2 && !TextUtils.isEmpty(this.f13087g.get(i2))) {
                    c0651a.f13090a.setDefaultResource(R.drawable.transparent_bg);
                    c0651a.f13090a.startLoad(this.f13087g.get(i2), 10, false);
                }
                if (!ListUtils.isEmpty(this.f13088h) && this.f13088h.size() > i2 && !TextUtils.isEmpty(this.f13088h.get(i2))) {
                    c0651a.f13091b.setText(this.f13088h.get(i2));
                    c0651a.f13091b.setVisibility(0);
                } else {
                    c0651a.f13091b.setVisibility(8);
                }
                if (!ListUtils.isEmpty(this.f13089i) && this.f13089i.size() > i2 && !TextUtils.isEmpty(this.f13089i.get(i2))) {
                    c0651a.f13092c.setText(this.f13089i.get(i2));
                    c0651a.f13092c.setVisibility(0);
                } else {
                    c0651a.f13092c.setVisibility(8);
                }
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
                layoutParams2.weight = 1.0f;
                view.setLayoutParams(layoutParams2);
                a(c0651a);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
