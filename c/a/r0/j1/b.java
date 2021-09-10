package c.a.r0.j1;

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
    public String f19465e;

    /* renamed from: f  reason: collision with root package name */
    public final List<d> f19466f;

    /* renamed from: g  reason: collision with root package name */
    public LayoutInflater f19467g;

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
        this.f19466f = new ArrayList();
        this.f19467g = LayoutInflater.from(tbPageContext.getPageActivity());
    }

    public final void a(C0939b c0939b, View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048576, this, c0939b, view, i2) == null) || c0939b == null || c0939b.f19468a == i2) {
            return;
        }
        SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        SkinManager.setBackgroundColor(c0939b.f19471d, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(c0939b.f19470c, R.color.CAM_X0204);
        SkinManager.setViewTextColor(c0939b.f19469b, R.color.CAM_X0105, 1);
        c0939b.f19468a = i2;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f19466f.clear();
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public d getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f19466f.get(i2) : (d) invokeI.objValue;
    }

    public List<d> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19466f : (List) invokeV.objValue;
    }

    public void e(String str, List<d> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, list) == null) {
            this.f19465e = str;
            this.f19466f.clear();
            if (list != null) {
                this.f19466f.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f19466f.size() : invokeV.intValue;
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
        C0939b c0939b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, view, viewGroup)) == null) {
            d item = getItem(i2);
            if (item == null) {
                return view;
            }
            if (view != null && (view.getTag() instanceof C0939b)) {
                c0939b = (C0939b) view.getTag();
            } else {
                view = this.f19467g.inflate(R.layout.hot_suggest_item, (ViewGroup) null);
                c0939b = new C0939b(this, null);
                c0939b.f19469b = (TextView) view.findViewById(R.id.name);
                c0939b.f19470c = view.findViewById(R.id.divider_line_top);
                c0939b.f19471d = view.findViewById(R.id.divider_line_bottom);
                view.setTag(c0939b);
            }
            c0939b.f19470c.setVisibility(i2 == 0 ? 0 : 8);
            c0939b.f19469b.setText(StringHelper.highLightText(c.a.q0.t0.b.a(StringHelper.cutStringWithEllipsisNew(item.b(), 18)), this.f19465e, R.color.CAM_X0302));
            a(c0939b, view, TbadkCoreApplication.getInst().getSkinType());
            return view;
        }
        return (View) invokeILL.objValue;
    }

    /* renamed from: c.a.r0.j1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0939b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f19468a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f19469b;

        /* renamed from: c  reason: collision with root package name */
        public View f19470c;

        /* renamed from: d  reason: collision with root package name */
        public View f19471d;

        public C0939b(b bVar) {
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
            this.f19468a = 3;
        }

        public /* synthetic */ C0939b(b bVar, a aVar) {
            this(bVar);
        }
    }
}
