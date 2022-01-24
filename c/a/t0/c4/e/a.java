package c.a.t0.c4.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.BackgroundItemView;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<Object> f15655e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f15656f;

    /* renamed from: g  reason: collision with root package name */
    public d f15657g;

    /* renamed from: c.a.t0.c4.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1000a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public BackgroundItemView f15658b;

        /* renamed from: c  reason: collision with root package name */
        public BackgroundItemView f15659c;

        /* renamed from: d  reason: collision with root package name */
        public BackgroundItemView f15660d;

        /* renamed from: e  reason: collision with root package name */
        public View f15661e;

        public C1000a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
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

    public a(TbPageContext<?> tbPageContext, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15656f = tbPageContext;
        this.f15657g = dVar;
    }

    public void a(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.f15655e = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<Object> list = this.f15655e;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            List<Object> list = this.f15655e;
            if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f15655e.size()) {
                return null;
            }
            return this.f15655e.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (getItem(i2) != null) {
                return i2;
            }
            return -1L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? getItem(i2) instanceof List ? 1 : 0 : invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1000a c1000a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            Object item = getItem(i2);
            if (view != null) {
                c1000a = (C1000a) view.getTag();
            } else if (getItemViewType(i2) == 0) {
                view = LayoutInflater.from(this.f15656f.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
                c1000a = new C1000a();
                c1000a.a = (TextView) view.findViewById(R.id.group_name);
                view.setTag(c1000a);
            } else {
                view = LayoutInflater.from(this.f15656f.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
                c1000a = new C1000a();
                c1000a.f15658b = (BackgroundItemView) view.findViewById(R.id.bg_view1);
                c1000a.f15659c = (BackgroundItemView) view.findViewById(R.id.bg_view2);
                c1000a.f15660d = (BackgroundItemView) view.findViewById(R.id.bg_view3);
                c1000a.f15661e = view.findViewById(R.id.divider_line);
                view.setTag(c1000a);
            }
            if (item != null) {
                if (getItemViewType(i2) == 0) {
                    c1000a.a.setText(item.toString());
                } else {
                    List list = (List) item;
                    c1000a.f15658b.fillView((DressItemData) list.get(0));
                    c1000a.f15658b.setController(this.f15657g);
                    if (list.size() > 2) {
                        c1000a.f15659c.fillView((DressItemData) list.get(1));
                        c1000a.f15660d.fillView((DressItemData) list.get(2));
                        c1000a.f15659c.setController(this.f15657g);
                        c1000a.f15660d.setController(this.f15657g);
                    } else if (list.size() > 1) {
                        c1000a.f15659c.fillView((DressItemData) list.get(1));
                        c1000a.f15659c.setController(this.f15657g);
                        c1000a.f15660d.hide();
                    } else {
                        c1000a.f15659c.hide();
                        c1000a.f15660d.hide();
                    }
                    if (getItem(i2 + 1) instanceof List) {
                        c1000a.f15661e.setVisibility(8);
                    } else {
                        c1000a.f15661e.setVisibility(0);
                    }
                }
            }
            this.f15656f.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }
}
