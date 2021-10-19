package c.a.r0.k1;

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
    public String f19651e;

    /* renamed from: f  reason: collision with root package name */
    public final List<d> f19652f;

    /* renamed from: g  reason: collision with root package name */
    public LayoutInflater f19653g;

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
        this.f19652f = new ArrayList();
        this.f19653g = LayoutInflater.from(tbPageContext.getPageActivity());
    }

    public final void a(C0946b c0946b, View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048576, this, c0946b, view, i2) == null) || c0946b == null || c0946b.f19654a == i2) {
            return;
        }
        SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        SkinManager.setBackgroundColor(c0946b.f19657d, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(c0946b.f19656c, R.color.CAM_X0204);
        SkinManager.setViewTextColor(c0946b.f19655b, R.color.CAM_X0105, 1);
        c0946b.f19654a = i2;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f19652f.clear();
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public d getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f19652f.get(i2) : (d) invokeI.objValue;
    }

    public List<d> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19652f : (List) invokeV.objValue;
    }

    public void e(String str, List<d> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, list) == null) {
            this.f19651e = str;
            this.f19652f.clear();
            if (list != null) {
                this.f19652f.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f19652f.size() : invokeV.intValue;
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
        C0946b c0946b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, view, viewGroup)) == null) {
            d item = getItem(i2);
            if (item == null) {
                return view;
            }
            if (view != null && (view.getTag() instanceof C0946b)) {
                c0946b = (C0946b) view.getTag();
            } else {
                view = this.f19653g.inflate(R.layout.hot_suggest_item, (ViewGroup) null);
                c0946b = new C0946b(this, null);
                c0946b.f19655b = (TextView) view.findViewById(R.id.name);
                c0946b.f19656c = view.findViewById(R.id.divider_line_top);
                c0946b.f19657d = view.findViewById(R.id.divider_line_bottom);
                view.setTag(c0946b);
            }
            c0946b.f19656c.setVisibility(i2 == 0 ? 0 : 8);
            c0946b.f19655b.setText(StringHelper.highLightText(c.a.q0.t0.b.a(StringHelper.cutStringWithEllipsisNew(item.b(), 18)), this.f19651e, R.color.CAM_X0302));
            a(c0946b, view, TbadkCoreApplication.getInst().getSkinType());
            return view;
        }
        return (View) invokeILL.objValue;
    }

    /* renamed from: c.a.r0.k1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0946b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f19654a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f19655b;

        /* renamed from: c  reason: collision with root package name */
        public View f19656c;

        /* renamed from: d  reason: collision with root package name */
        public View f19657d;

        public C0946b(b bVar) {
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
            this.f19654a = 3;
        }

        public /* synthetic */ C0946b(b bVar, a aVar) {
            this(bVar);
        }
    }
}
