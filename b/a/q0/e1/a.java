package b.a.q0.e1;

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
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f12955e;

    /* renamed from: f  reason: collision with root package name */
    public int f12956f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f12957g;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f12958h;

    /* renamed from: i  reason: collision with root package name */
    public List<String> f12959i;

    /* renamed from: b.a.q0.e1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0678a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f12960a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f12961b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f12962c;

        public C0678a(a aVar, View view) {
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
            this.f12960a = tbImageView;
            tbImageView.setDefaultBgResource(R.color.CAM_X0206);
            this.f12961b = (TextView) view.findViewById(R.id.bar_select_rule_title);
            this.f12962c = (TextView) view.findViewById(R.id.bar_select_rule_content);
        }
    }

    /* loaded from: classes4.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f12963a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f12964b;

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
            this.f12963a = (TextView) view.findViewById(R.id.pb_vote_select_rule_title);
            this.f12964b = (TextView) view.findViewById(R.id.pb_vote_select_rule_content);
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
        this.f12956f = 0;
        this.f12955e = context;
        this.f12957g = new ArrayList();
        this.f12958h = new ArrayList();
        this.f12959i = new ArrayList();
    }

    public void a(C0678a c0678a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, c0678a) == null) || c0678a == null) {
            return;
        }
        SkinManager.setViewTextColor(c0678a.f12961b, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(c0678a.f12962c, R.color.CAM_X0109, 1);
    }

    public void b(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null) {
            return;
        }
        SkinManager.setViewTextColor(bVar.f12963a, R.color.CAM_X0105);
        SkinManager.setViewTextColor(bVar.f12964b, R.color.CAM_X0109);
    }

    public void c(List<String> list, List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, list2) == null) {
            this.f12958h.clear();
            this.f12959i.clear();
            if (!ListUtils.isEmpty(list) && !ListUtils.isEmpty(list2)) {
                this.f12958h.addAll(list);
                this.f12959i.addAll(list2);
            }
            notifyDataSetChanged();
        }
    }

    public void d(List<String> list, List<String> list2, List<String> list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, list, list2, list3) == null) {
            this.f12957g.clear();
            if (!ListUtils.isEmpty(list)) {
                this.f12957g.addAll(list);
            }
            c(list2, list3);
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f12956f = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (ListUtils.isEmpty(this.f12958h)) {
                return 0;
            }
            return this.f12958h.size();
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
            int i3 = this.f12956f;
            if (i3 == 0) {
                view = LayoutInflater.from(this.f12955e).inflate(R.layout.pb_vote_select_rule_item, (ViewGroup) null, false);
                b bVar = new b(this, view);
                if (!ListUtils.isEmpty(this.f12958h) && this.f12958h.size() > i2 && !TextUtils.isEmpty(this.f12958h.get(i2))) {
                    bVar.f12963a.setText(this.f12958h.get(i2));
                    bVar.f12963a.setVisibility(0);
                } else {
                    bVar.f12963a.setVisibility(8);
                }
                if (!ListUtils.isEmpty(this.f12959i) && this.f12959i.size() > i2 && !TextUtils.isEmpty(this.f12959i.get(i2))) {
                    bVar.f12964b.setText(this.f12959i.get(i2));
                    bVar.f12964b.setVisibility(0);
                } else {
                    bVar.f12964b.setVisibility(8);
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                view.setLayoutParams(layoutParams);
                b(bVar);
            } else if (i3 == 1) {
                view = LayoutInflater.from(this.f12955e).inflate(R.layout.bar_select_rule_item, (ViewGroup) null, false);
                C0678a c0678a = new C0678a(this, view);
                if (!ListUtils.isEmpty(this.f12957g) && this.f12957g.size() > i2 && !TextUtils.isEmpty(this.f12957g.get(i2))) {
                    c0678a.f12960a.setDefaultResource(R.drawable.transparent_bg);
                    c0678a.f12960a.startLoad(this.f12957g.get(i2), 10, false);
                }
                if (!ListUtils.isEmpty(this.f12958h) && this.f12958h.size() > i2 && !TextUtils.isEmpty(this.f12958h.get(i2))) {
                    c0678a.f12961b.setText(this.f12958h.get(i2));
                    c0678a.f12961b.setVisibility(0);
                } else {
                    c0678a.f12961b.setVisibility(8);
                }
                if (!ListUtils.isEmpty(this.f12959i) && this.f12959i.size() > i2 && !TextUtils.isEmpty(this.f12959i.get(i2))) {
                    c0678a.f12962c.setText(this.f12959i.get(i2));
                    c0678a.f12962c.setVisibility(0);
                } else {
                    c0678a.f12962c.setVisibility(8);
                }
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
                layoutParams2.weight = 1.0f;
                view.setLayoutParams(layoutParams2);
                a(c0678a);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
