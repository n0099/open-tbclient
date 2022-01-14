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
    public List<Object> f15507e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f15508f;

    /* renamed from: g  reason: collision with root package name */
    public d f15509g;

    /* renamed from: c.a.t0.c4.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0996a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public BackgroundItemView f15510b;

        /* renamed from: c  reason: collision with root package name */
        public BackgroundItemView f15511c;

        /* renamed from: d  reason: collision with root package name */
        public BackgroundItemView f15512d;

        /* renamed from: e  reason: collision with root package name */
        public View f15513e;

        public C0996a() {
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
        this.f15508f = tbPageContext;
        this.f15509g = dVar;
    }

    public void a(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.f15507e = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<Object> list = this.f15507e;
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
            List<Object> list = this.f15507e;
            if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f15507e.size()) {
                return null;
            }
            return this.f15507e.get(i2);
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
        C0996a c0996a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            Object item = getItem(i2);
            if (view != null) {
                c0996a = (C0996a) view.getTag();
            } else if (getItemViewType(i2) == 0) {
                view = LayoutInflater.from(this.f15508f.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
                c0996a = new C0996a();
                c0996a.a = (TextView) view.findViewById(R.id.group_name);
                view.setTag(c0996a);
            } else {
                view = LayoutInflater.from(this.f15508f.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
                c0996a = new C0996a();
                c0996a.f15510b = (BackgroundItemView) view.findViewById(R.id.bg_view1);
                c0996a.f15511c = (BackgroundItemView) view.findViewById(R.id.bg_view2);
                c0996a.f15512d = (BackgroundItemView) view.findViewById(R.id.bg_view3);
                c0996a.f15513e = view.findViewById(R.id.divider_line);
                view.setTag(c0996a);
            }
            if (item != null) {
                if (getItemViewType(i2) == 0) {
                    c0996a.a.setText(item.toString());
                } else {
                    List list = (List) item;
                    c0996a.f15510b.fillView((DressItemData) list.get(0));
                    c0996a.f15510b.setController(this.f15509g);
                    if (list.size() > 2) {
                        c0996a.f15511c.fillView((DressItemData) list.get(1));
                        c0996a.f15512d.fillView((DressItemData) list.get(2));
                        c0996a.f15511c.setController(this.f15509g);
                        c0996a.f15512d.setController(this.f15509g);
                    } else if (list.size() > 1) {
                        c0996a.f15511c.fillView((DressItemData) list.get(1));
                        c0996a.f15511c.setController(this.f15509g);
                        c0996a.f15512d.hide();
                    } else {
                        c0996a.f15511c.hide();
                        c0996a.f15512d.hide();
                    }
                    if (getItem(i2 + 1) instanceof List) {
                        c0996a.f15513e.setVisibility(8);
                    } else {
                        c0996a.f15513e.setVisibility(0);
                    }
                }
            }
            this.f15508f.getLayoutMode().j(view);
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
