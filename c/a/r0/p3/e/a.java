package c.a.r0.p3.e;

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
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<Object> f23912e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f23913f;

    /* renamed from: g  reason: collision with root package name */
    public d f23914g;

    /* renamed from: c.a.r0.p3.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1111a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f23915a;

        /* renamed from: b  reason: collision with root package name */
        public BackgroundItemView f23916b;

        /* renamed from: c  reason: collision with root package name */
        public BackgroundItemView f23917c;

        /* renamed from: d  reason: collision with root package name */
        public BackgroundItemView f23918d;

        /* renamed from: e  reason: collision with root package name */
        public View f23919e;

        public C1111a() {
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
        this.f23913f = tbPageContext;
        this.f23914g = dVar;
    }

    public void a(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.f23912e = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<Object> list = this.f23912e;
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
            List<Object> list = this.f23912e;
            if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f23912e.size()) {
                return null;
            }
            return this.f23912e.get(i2);
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
        C1111a c1111a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            Object item = getItem(i2);
            if (view != null) {
                c1111a = (C1111a) view.getTag();
            } else if (getItemViewType(i2) == 0) {
                view = LayoutInflater.from(this.f23913f.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
                c1111a = new C1111a();
                c1111a.f23915a = (TextView) view.findViewById(R.id.group_name);
                view.setTag(c1111a);
            } else {
                view = LayoutInflater.from(this.f23913f.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
                c1111a = new C1111a();
                c1111a.f23916b = (BackgroundItemView) view.findViewById(R.id.bg_view1);
                c1111a.f23917c = (BackgroundItemView) view.findViewById(R.id.bg_view2);
                c1111a.f23918d = (BackgroundItemView) view.findViewById(R.id.bg_view3);
                c1111a.f23919e = view.findViewById(R.id.divider_line);
                view.setTag(c1111a);
            }
            if (item != null) {
                if (getItemViewType(i2) == 0) {
                    c1111a.f23915a.setText(item.toString());
                } else {
                    List list = (List) item;
                    c1111a.f23916b.fillView((DressItemData) list.get(0));
                    c1111a.f23916b.setController(this.f23914g);
                    if (list.size() > 2) {
                        c1111a.f23917c.fillView((DressItemData) list.get(1));
                        c1111a.f23918d.fillView((DressItemData) list.get(2));
                        c1111a.f23917c.setController(this.f23914g);
                        c1111a.f23918d.setController(this.f23914g);
                    } else if (list.size() > 1) {
                        c1111a.f23917c.fillView((DressItemData) list.get(1));
                        c1111a.f23917c.setController(this.f23914g);
                        c1111a.f23918d.hide();
                    } else {
                        c1111a.f23917c.hide();
                        c1111a.f23918d.hide();
                    }
                    if (getItem(i2 + 1) instanceof List) {
                        c1111a.f23919e.setVisibility(8);
                    } else {
                        c1111a.f23919e.setVisibility(0);
                    }
                }
            }
            this.f23913f.getLayoutMode().j(view);
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
