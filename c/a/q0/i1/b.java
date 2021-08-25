package c.a.q0.i1;

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
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f18916e;

    /* renamed from: f  reason: collision with root package name */
    public final List<d> f18917f;

    /* renamed from: g  reason: collision with root package name */
    public LayoutInflater f18918g;

    /* loaded from: classes3.dex */
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
        this.f18917f = new ArrayList();
        this.f18918g = LayoutInflater.from(tbPageContext.getPageActivity());
    }

    public final void a(C0907b c0907b, View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048576, this, c0907b, view, i2) == null) || c0907b == null || c0907b.f18919a == i2) {
            return;
        }
        SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        SkinManager.setBackgroundColor(c0907b.f18922d, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(c0907b.f18921c, R.color.CAM_X0204);
        SkinManager.setViewTextColor(c0907b.f18920b, R.color.CAM_X0105, 1);
        c0907b.f18919a = i2;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f18917f.clear();
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public d getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f18917f.get(i2) : (d) invokeI.objValue;
    }

    public List<d> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f18917f : (List) invokeV.objValue;
    }

    public void e(String str, List<d> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, list) == null) {
            this.f18916e = str;
            this.f18917f.clear();
            if (list != null) {
                this.f18917f.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f18917f.size() : invokeV.intValue;
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
        C0907b c0907b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, view, viewGroup)) == null) {
            d item = getItem(i2);
            if (item == null) {
                return view;
            }
            if (view != null && (view.getTag() instanceof C0907b)) {
                c0907b = (C0907b) view.getTag();
            } else {
                view = this.f18918g.inflate(R.layout.hot_suggest_item, (ViewGroup) null);
                c0907b = new C0907b(this, null);
                c0907b.f18920b = (TextView) view.findViewById(R.id.name);
                c0907b.f18921c = view.findViewById(R.id.divider_line_top);
                c0907b.f18922d = view.findViewById(R.id.divider_line_bottom);
                view.setTag(c0907b);
            }
            c0907b.f18921c.setVisibility(i2 == 0 ? 0 : 8);
            c0907b.f18920b.setText(StringHelper.highLightText(c.a.p0.r0.b.a(StringHelper.cutStringWithEllipsisNew(item.b(), 18)), this.f18916e, R.color.CAM_X0302));
            a(c0907b, view, TbadkCoreApplication.getInst().getSkinType());
            return view;
        }
        return (View) invokeILL.objValue;
    }

    /* renamed from: c.a.q0.i1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0907b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f18919a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f18920b;

        /* renamed from: c  reason: collision with root package name */
        public View f18921c;

        /* renamed from: d  reason: collision with root package name */
        public View f18922d;

        public C0907b(b bVar) {
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
            this.f18919a = 3;
        }

        public /* synthetic */ C0907b(b bVar, a aVar) {
            this(bVar);
        }
    }
}
