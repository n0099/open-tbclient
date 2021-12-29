package c.a.t0.c4.g.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.card.category.PersonalCardItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f16006e;

    /* renamed from: f  reason: collision with root package name */
    public int f16007f;

    /* renamed from: g  reason: collision with root package name */
    public List<Object> f16008g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<?> f16009h;

    /* renamed from: i  reason: collision with root package name */
    public PersonalCardItemView.b f16010i;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PersonalCardItemView a;

        /* renamed from: b  reason: collision with root package name */
        public PersonalCardItemView f16011b;

        /* renamed from: c  reason: collision with root package name */
        public PersonalCardItemView f16012c;

        /* renamed from: d  reason: collision with root package name */
        public View f16013d;

        public a() {
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

    /* renamed from: c.a.t0.c4.g.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0986b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        public C0986b() {
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

    public b(TbPageContext<?> tbPageContext) {
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
        this.f16006e = 0;
        this.f16007f = 0;
        this.f16009h = tbPageContext;
        this.f16006e = n.f(tbPageContext.getPageActivity(), R.dimen.ds28);
        this.f16007f = n.f(tbPageContext.getPageActivity(), R.dimen.ds20);
    }

    public void a(PersonalCardItemView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f16010i = bVar;
        }
    }

    public void b(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f16008g = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<Object> list = this.f16008g;
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            List<Object> list = this.f16008g;
            if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f16008g.size()) {
                return null;
            }
            return this.f16008g.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? getItem(i2) instanceof List ? 1 : 0 : invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        C0986b c0986b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            int itemViewType = getItemViewType(i2);
            Object item = getItem(i2);
            if (itemViewType == 0) {
                if (view != null && (view.getTag() instanceof C0986b)) {
                    c0986b = (C0986b) view.getTag();
                } else {
                    c0986b = new C0986b();
                    view = LayoutInflater.from(this.f16009h.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
                    TextView textView = (TextView) view.findViewById(R.id.group_name);
                    c0986b.a = textView;
                    textView.setPadding(0, this.f16006e, 0, this.f16007f);
                    view.setTag(c0986b);
                }
                if (item != null) {
                    c0986b.a.setText(item.toString());
                }
            } else if (itemViewType == 1) {
                if (view != null && (view.getTag() instanceof a)) {
                    aVar = (a) view.getTag();
                } else {
                    a aVar2 = new a();
                    View inflate = LayoutInflater.from(this.f16009h.getPageActivity()).inflate(R.layout.category_card_list_item, viewGroup, false);
                    aVar2.a = (PersonalCardItemView) inflate.findViewById(R.id.card1);
                    aVar2.f16011b = (PersonalCardItemView) inflate.findViewById(R.id.card2);
                    aVar2.f16012c = (PersonalCardItemView) inflate.findViewById(R.id.card3);
                    aVar2.f16013d = inflate.findViewById(R.id.divider_line);
                    aVar2.a.setCardViewController(this.f16010i);
                    aVar2.f16011b.setCardViewController(this.f16010i);
                    aVar2.f16012c.setCardViewController(this.f16010i);
                    inflate.setTag(aVar2);
                    aVar = aVar2;
                    view = inflate;
                }
                if (item != null) {
                    List list = (List) item;
                    int size = list.size();
                    if (size == 1) {
                        aVar.a.fillData((c.a.t0.c4.a) list.get(0));
                        aVar.a.setVisibility(0);
                        aVar.f16011b.setVisibility(8);
                        aVar.f16012c.setVisibility(8);
                    } else if (size == 2) {
                        aVar.a.fillData((c.a.t0.c4.a) list.get(0));
                        aVar.f16011b.fillData((c.a.t0.c4.a) list.get(1));
                        aVar.a.setVisibility(0);
                        aVar.f16011b.setVisibility(0);
                        aVar.f16012c.setVisibility(8);
                    } else if (size != 3) {
                        view.setVisibility(8);
                    } else {
                        aVar.a.fillData((c.a.t0.c4.a) list.get(0));
                        aVar.f16011b.fillData((c.a.t0.c4.a) list.get(1));
                        aVar.f16012c.fillData((c.a.t0.c4.a) list.get(2));
                        aVar.a.setVisibility(0);
                        aVar.f16011b.setVisibility(0);
                        aVar.f16012c.setVisibility(0);
                    }
                    if (getItem(i2 + 1) instanceof List) {
                        aVar.f16013d.setVisibility(8);
                    } else {
                        aVar.f16013d.setVisibility(0);
                    }
                }
            }
            this.f16009h.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }
}
