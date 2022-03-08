package c.a.r0.d4.e;

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
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<Object> f16921e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f16922f;

    /* renamed from: g  reason: collision with root package name */
    public d f16923g;

    /* renamed from: c.a.r0.d4.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1077a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public BackgroundItemView f16924b;

        /* renamed from: c  reason: collision with root package name */
        public BackgroundItemView f16925c;

        /* renamed from: d  reason: collision with root package name */
        public BackgroundItemView f16926d;

        /* renamed from: e  reason: collision with root package name */
        public View f16927e;

        public C1077a() {
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
        this.f16922f = tbPageContext;
        this.f16923g = dVar;
    }

    public void a(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.f16921e = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<Object> list = this.f16921e;
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
            List<Object> list = this.f16921e;
            if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f16921e.size()) {
                return null;
            }
            return this.f16921e.get(i2);
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
        C1077a c1077a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            Object item = getItem(i2);
            if (view != null) {
                c1077a = (C1077a) view.getTag();
            } else if (getItemViewType(i2) == 0) {
                view = LayoutInflater.from(this.f16922f.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
                c1077a = new C1077a();
                c1077a.a = (TextView) view.findViewById(R.id.group_name);
                view.setTag(c1077a);
            } else {
                view = LayoutInflater.from(this.f16922f.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
                c1077a = new C1077a();
                c1077a.f16924b = (BackgroundItemView) view.findViewById(R.id.bg_view1);
                c1077a.f16925c = (BackgroundItemView) view.findViewById(R.id.bg_view2);
                c1077a.f16926d = (BackgroundItemView) view.findViewById(R.id.bg_view3);
                c1077a.f16927e = view.findViewById(R.id.divider_line);
                view.setTag(c1077a);
            }
            if (item != null) {
                if (getItemViewType(i2) == 0) {
                    c1077a.a.setText(item.toString());
                } else {
                    List list = (List) item;
                    c1077a.f16924b.fillView((DressItemData) list.get(0));
                    c1077a.f16924b.setController(this.f16923g);
                    if (list.size() > 2) {
                        c1077a.f16925c.fillView((DressItemData) list.get(1));
                        c1077a.f16926d.fillView((DressItemData) list.get(2));
                        c1077a.f16925c.setController(this.f16923g);
                        c1077a.f16926d.setController(this.f16923g);
                    } else if (list.size() > 1) {
                        c1077a.f16925c.fillView((DressItemData) list.get(1));
                        c1077a.f16925c.setController(this.f16923g);
                        c1077a.f16926d.hide();
                    } else {
                        c1077a.f16925c.hide();
                        c1077a.f16926d.hide();
                    }
                    if (getItem(i2 + 1) instanceof List) {
                        c1077a.f16927e.setVisibility(8);
                    } else {
                        c1077a.f16927e.setVisibility(0);
                    }
                }
            }
            this.f16922f.getLayoutMode().j(view);
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
