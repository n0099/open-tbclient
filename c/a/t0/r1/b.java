package c.a.t0.r1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f22424e;

    /* renamed from: f  reason: collision with root package name */
    public final List<d> f22425f;

    /* renamed from: g  reason: collision with root package name */
    public LayoutInflater f22426g;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public b(TbPageContext tbPageContext) {
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
        this.f22425f = new ArrayList();
        this.f22426g = LayoutInflater.from(tbPageContext.getPageActivity());
    }

    public final void a(C1339b c1339b, View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048576, this, c1339b, view, i2) == null) || c1339b == null || c1339b.a == i2) {
            return;
        }
        SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        SkinManager.setBackgroundColor(c1339b.f22429d, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(c1339b.f22428c, R.color.CAM_X0204);
        SkinManager.setViewTextColor(c1339b.f22427b, R.color.CAM_X0105, 1);
        c1339b.a = i2;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f22425f.clear();
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public d getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f22425f.get(i2) : (d) invokeI.objValue;
    }

    public List<d> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f22425f : (List) invokeV.objValue;
    }

    public void e(String str, List<d> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, list) == null) {
            this.f22424e = str;
            this.f22425f.clear();
            if (list != null) {
                this.f22425f.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f22425f.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1339b c1339b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, view, viewGroup)) == null) {
            d item = getItem(i2);
            if (item == null) {
                return view;
            }
            if (view != null && (view.getTag() instanceof C1339b)) {
                c1339b = (C1339b) view.getTag();
            } else {
                view = this.f22426g.inflate(R.layout.hot_suggest_item, (ViewGroup) null);
                c1339b = new C1339b(this, null);
                c1339b.f22427b = (TextView) view.findViewById(R.id.name);
                c1339b.f22428c = view.findViewById(R.id.divider_line_top);
                c1339b.f22429d = view.findViewById(R.id.divider_line_bottom);
                view.setTag(c1339b);
            }
            c1339b.f22428c.setVisibility(i2 == 0 ? 0 : 8);
            c1339b.f22427b.setText(StringHelper.highLightText(c.a.s0.u0.a.a(StringHelper.cutStringWithEllipsisNew(item.b(), 18)), this.f22424e, R.color.CAM_X0302));
            a(c1339b, view, TbadkCoreApplication.getInst().getSkinType());
            return view;
        }
        return (View) invokeILL.objValue;
    }

    /* renamed from: c.a.t0.r1.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1339b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f22427b;

        /* renamed from: c  reason: collision with root package name */
        public View f22428c;

        /* renamed from: d  reason: collision with root package name */
        public View f22429d;

        public C1339b(b bVar) {
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
                    return;
                }
            }
            this.a = 3;
        }

        public /* synthetic */ C1339b(b bVar, a aVar) {
            this(bVar);
        }
    }
}
