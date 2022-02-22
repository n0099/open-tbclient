package c.a.u0.f4.e;

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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<Object> f17735e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f17736f;

    /* renamed from: g  reason: collision with root package name */
    public d f17737g;

    /* renamed from: c.a.u0.f4.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1110a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public BackgroundItemView f17738b;

        /* renamed from: c  reason: collision with root package name */
        public BackgroundItemView f17739c;

        /* renamed from: d  reason: collision with root package name */
        public BackgroundItemView f17740d;

        /* renamed from: e  reason: collision with root package name */
        public View f17741e;

        public C1110a() {
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
        this.f17736f = tbPageContext;
        this.f17737g = dVar;
    }

    public void a(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.f17735e = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<Object> list = this.f17735e;
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
            List<Object> list = this.f17735e;
            if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f17735e.size()) {
                return null;
            }
            return this.f17735e.get(i2);
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
        C1110a c1110a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            Object item = getItem(i2);
            if (view != null) {
                c1110a = (C1110a) view.getTag();
            } else if (getItemViewType(i2) == 0) {
                view = LayoutInflater.from(this.f17736f.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
                c1110a = new C1110a();
                c1110a.a = (TextView) view.findViewById(R.id.group_name);
                view.setTag(c1110a);
            } else {
                view = LayoutInflater.from(this.f17736f.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
                c1110a = new C1110a();
                c1110a.f17738b = (BackgroundItemView) view.findViewById(R.id.bg_view1);
                c1110a.f17739c = (BackgroundItemView) view.findViewById(R.id.bg_view2);
                c1110a.f17740d = (BackgroundItemView) view.findViewById(R.id.bg_view3);
                c1110a.f17741e = view.findViewById(R.id.divider_line);
                view.setTag(c1110a);
            }
            if (item != null) {
                if (getItemViewType(i2) == 0) {
                    c1110a.a.setText(item.toString());
                } else {
                    List list = (List) item;
                    c1110a.f17738b.fillView((DressItemData) list.get(0));
                    c1110a.f17738b.setController(this.f17737g);
                    if (list.size() > 2) {
                        c1110a.f17739c.fillView((DressItemData) list.get(1));
                        c1110a.f17740d.fillView((DressItemData) list.get(2));
                        c1110a.f17739c.setController(this.f17737g);
                        c1110a.f17740d.setController(this.f17737g);
                    } else if (list.size() > 1) {
                        c1110a.f17739c.fillView((DressItemData) list.get(1));
                        c1110a.f17739c.setController(this.f17737g);
                        c1110a.f17740d.hide();
                    } else {
                        c1110a.f17739c.hide();
                        c1110a.f17740d.hide();
                    }
                    if (getItem(i2 + 1) instanceof List) {
                        c1110a.f17741e.setVisibility(8);
                    } else {
                        c1110a.f17741e.setVisibility(0);
                    }
                }
            }
            this.f17736f.getLayoutMode().j(view);
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
