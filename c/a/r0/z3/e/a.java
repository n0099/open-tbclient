package c.a.r0.z3.e;

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
    public List<Object> f25929e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f25930f;

    /* renamed from: g  reason: collision with root package name */
    public d f25931g;

    /* renamed from: c.a.r0.z3.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1492a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public BackgroundItemView f25932b;

        /* renamed from: c  reason: collision with root package name */
        public BackgroundItemView f25933c;

        /* renamed from: d  reason: collision with root package name */
        public BackgroundItemView f25934d;

        /* renamed from: e  reason: collision with root package name */
        public View f25935e;

        public C1492a() {
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
        this.f25930f = tbPageContext;
        this.f25931g = dVar;
    }

    public void a(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.f25929e = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<Object> list = this.f25929e;
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
            List<Object> list = this.f25929e;
            if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f25929e.size()) {
                return null;
            }
            return this.f25929e.get(i2);
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
        C1492a c1492a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            Object item = getItem(i2);
            if (view != null) {
                c1492a = (C1492a) view.getTag();
            } else if (getItemViewType(i2) == 0) {
                view = LayoutInflater.from(this.f25930f.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
                c1492a = new C1492a();
                c1492a.a = (TextView) view.findViewById(R.id.group_name);
                view.setTag(c1492a);
            } else {
                view = LayoutInflater.from(this.f25930f.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
                c1492a = new C1492a();
                c1492a.f25932b = (BackgroundItemView) view.findViewById(R.id.bg_view1);
                c1492a.f25933c = (BackgroundItemView) view.findViewById(R.id.bg_view2);
                c1492a.f25934d = (BackgroundItemView) view.findViewById(R.id.bg_view3);
                c1492a.f25935e = view.findViewById(R.id.divider_line);
                view.setTag(c1492a);
            }
            if (item != null) {
                if (getItemViewType(i2) == 0) {
                    c1492a.a.setText(item.toString());
                } else {
                    List list = (List) item;
                    c1492a.f25932b.fillView((DressItemData) list.get(0));
                    c1492a.f25932b.setController(this.f25931g);
                    if (list.size() > 2) {
                        c1492a.f25933c.fillView((DressItemData) list.get(1));
                        c1492a.f25934d.fillView((DressItemData) list.get(2));
                        c1492a.f25933c.setController(this.f25931g);
                        c1492a.f25934d.setController(this.f25931g);
                    } else if (list.size() > 1) {
                        c1492a.f25933c.fillView((DressItemData) list.get(1));
                        c1492a.f25933c.setController(this.f25931g);
                        c1492a.f25934d.hide();
                    } else {
                        c1492a.f25933c.hide();
                        c1492a.f25934d.hide();
                    }
                    if (getItem(i2 + 1) instanceof List) {
                        c1492a.f25935e.setVisibility(8);
                    } else {
                        c1492a.f25935e.setVisibility(0);
                    }
                }
            }
            this.f25930f.getLayoutMode().j(view);
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
