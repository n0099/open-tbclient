package c.a.r0.d4.f.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.bubble.all.BubbleItemView;
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
    public List<Object> f16983e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f16984f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.d4.f.a.a f16985g;

    /* renamed from: c.a.r0.d4.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1078a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public BubbleItemView f16986b;

        /* renamed from: c  reason: collision with root package name */
        public BubbleItemView f16987c;

        /* renamed from: d  reason: collision with root package name */
        public View f16988d;

        public C1078a() {
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

    public a(TbPageContext<?> tbPageContext, c.a.r0.d4.f.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16984f = tbPageContext;
        this.f16985g = aVar;
    }

    public void a(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.f16983e = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<Object> list = this.f16983e;
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
            List<Object> list = this.f16983e;
            if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f16983e.size()) {
                return null;
            }
            return this.f16983e.get(i2);
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
        C1078a c1078a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            Object item = getItem(i2);
            if (view != null) {
                c1078a = (C1078a) view.getTag();
            } else if (getItemViewType(i2) == 0) {
                view = LayoutInflater.from(this.f16984f.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
                c1078a = new C1078a();
                c1078a.a = (TextView) view.findViewById(R.id.group_name);
                view.setTag(c1078a);
            } else {
                view = LayoutInflater.from(this.f16984f.getPageActivity()).inflate(R.layout.bubble_row, viewGroup, false);
                c1078a = new C1078a();
                c1078a.f16986b = (BubbleItemView) view.findViewById(R.id.bg_view1);
                c1078a.f16987c = (BubbleItemView) view.findViewById(R.id.bg_view2);
                c1078a.f16988d = view.findViewById(R.id.divider_line);
                view.setTag(c1078a);
            }
            if (item != null) {
                if (getItemViewType(i2) == 0) {
                    c1078a.a.setText(item.toString());
                } else {
                    List list = (List) item;
                    c1078a.f16986b.fillView((DressItemData) list.get(0));
                    c1078a.f16986b.setController(this.f16985g);
                    c1078a.f16986b.setFromBubbleGroup(true);
                    if (list.size() > 1) {
                        c1078a.f16987c.fillView((DressItemData) list.get(1));
                        c1078a.f16987c.setController(this.f16985g);
                        c1078a.f16987c.setFromBubbleGroup(true);
                    } else {
                        c1078a.f16987c.hide();
                    }
                    if (getItem(i2 + 1) instanceof List) {
                        c1078a.f16988d.setVisibility(8);
                    } else {
                        c1078a.f16988d.setVisibility(0);
                    }
                }
            }
            this.f16984f.getLayoutMode().j(view);
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
