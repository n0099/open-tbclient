package b.a.r0.r3.e;

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
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<Object> f23105e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f23106f;

    /* renamed from: g  reason: collision with root package name */
    public d f23107g;

    /* renamed from: b.a.r0.r3.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1132a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f23108a;

        /* renamed from: b  reason: collision with root package name */
        public BackgroundItemView f23109b;

        /* renamed from: c  reason: collision with root package name */
        public BackgroundItemView f23110c;

        /* renamed from: d  reason: collision with root package name */
        public BackgroundItemView f23111d;

        /* renamed from: e  reason: collision with root package name */
        public View f23112e;

        public C1132a() {
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
        this.f23106f = tbPageContext;
        this.f23107g = dVar;
    }

    public void a(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.f23105e = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<Object> list = this.f23105e;
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
            List<Object> list = this.f23105e;
            if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f23105e.size()) {
                return null;
            }
            return this.f23105e.get(i2);
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
        C1132a c1132a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            Object item = getItem(i2);
            if (view != null) {
                c1132a = (C1132a) view.getTag();
            } else if (getItemViewType(i2) == 0) {
                view = LayoutInflater.from(this.f23106f.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
                c1132a = new C1132a();
                c1132a.f23108a = (TextView) view.findViewById(R.id.group_name);
                view.setTag(c1132a);
            } else {
                view = LayoutInflater.from(this.f23106f.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
                c1132a = new C1132a();
                c1132a.f23109b = (BackgroundItemView) view.findViewById(R.id.bg_view1);
                c1132a.f23110c = (BackgroundItemView) view.findViewById(R.id.bg_view2);
                c1132a.f23111d = (BackgroundItemView) view.findViewById(R.id.bg_view3);
                c1132a.f23112e = view.findViewById(R.id.divider_line);
                view.setTag(c1132a);
            }
            if (item != null) {
                if (getItemViewType(i2) == 0) {
                    c1132a.f23108a.setText(item.toString());
                } else {
                    List list = (List) item;
                    c1132a.f23109b.fillView((DressItemData) list.get(0));
                    c1132a.f23109b.setController(this.f23107g);
                    if (list.size() > 2) {
                        c1132a.f23110c.fillView((DressItemData) list.get(1));
                        c1132a.f23111d.fillView((DressItemData) list.get(2));
                        c1132a.f23110c.setController(this.f23107g);
                        c1132a.f23111d.setController(this.f23107g);
                    } else if (list.size() > 1) {
                        c1132a.f23110c.fillView((DressItemData) list.get(1));
                        c1132a.f23110c.setController(this.f23107g);
                        c1132a.f23111d.hide();
                    } else {
                        c1132a.f23110c.hide();
                        c1132a.f23111d.hide();
                    }
                    if (getItem(i2 + 1) instanceof List) {
                        c1132a.f23112e.setVisibility(8);
                    } else {
                        c1132a.f23112e.setVisibility(0);
                    }
                }
            }
            this.f23106f.getLayoutMode().j(view);
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
