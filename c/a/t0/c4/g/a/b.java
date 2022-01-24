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
    public int f15747e;

    /* renamed from: f  reason: collision with root package name */
    public int f15748f;

    /* renamed from: g  reason: collision with root package name */
    public List<Object> f15749g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<?> f15750h;

    /* renamed from: i  reason: collision with root package name */
    public PersonalCardItemView.b f15751i;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PersonalCardItemView a;

        /* renamed from: b  reason: collision with root package name */
        public PersonalCardItemView f15752b;

        /* renamed from: c  reason: collision with root package name */
        public PersonalCardItemView f15753c;

        /* renamed from: d  reason: collision with root package name */
        public View f15754d;

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
    public static class C1003b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        public C1003b() {
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
        this.f15747e = 0;
        this.f15748f = 0;
        this.f15750h = tbPageContext;
        this.f15747e = n.f(tbPageContext.getPageActivity(), R.dimen.ds28);
        this.f15748f = n.f(tbPageContext.getPageActivity(), R.dimen.ds20);
    }

    public void a(PersonalCardItemView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f15751i = bVar;
        }
    }

    public void b(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f15749g = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<Object> list = this.f15749g;
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
            List<Object> list = this.f15749g;
            if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f15749g.size()) {
                return null;
            }
            return this.f15749g.get(i2);
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
        C1003b c1003b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            int itemViewType = getItemViewType(i2);
            Object item = getItem(i2);
            if (itemViewType == 0) {
                if (view != null && (view.getTag() instanceof C1003b)) {
                    c1003b = (C1003b) view.getTag();
                } else {
                    c1003b = new C1003b();
                    view = LayoutInflater.from(this.f15750h.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
                    TextView textView = (TextView) view.findViewById(R.id.group_name);
                    c1003b.a = textView;
                    textView.setPadding(0, this.f15747e, 0, this.f15748f);
                    view.setTag(c1003b);
                }
                if (item != null) {
                    c1003b.a.setText(item.toString());
                }
            } else if (itemViewType == 1) {
                if (view != null && (view.getTag() instanceof a)) {
                    aVar = (a) view.getTag();
                } else {
                    a aVar2 = new a();
                    View inflate = LayoutInflater.from(this.f15750h.getPageActivity()).inflate(R.layout.category_card_list_item, viewGroup, false);
                    aVar2.a = (PersonalCardItemView) inflate.findViewById(R.id.card1);
                    aVar2.f15752b = (PersonalCardItemView) inflate.findViewById(R.id.card2);
                    aVar2.f15753c = (PersonalCardItemView) inflate.findViewById(R.id.card3);
                    aVar2.f15754d = inflate.findViewById(R.id.divider_line);
                    aVar2.a.setCardViewController(this.f15751i);
                    aVar2.f15752b.setCardViewController(this.f15751i);
                    aVar2.f15753c.setCardViewController(this.f15751i);
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
                        aVar.f15752b.setVisibility(8);
                        aVar.f15753c.setVisibility(8);
                    } else if (size == 2) {
                        aVar.a.fillData((c.a.t0.c4.a) list.get(0));
                        aVar.f15752b.fillData((c.a.t0.c4.a) list.get(1));
                        aVar.a.setVisibility(0);
                        aVar.f15752b.setVisibility(0);
                        aVar.f15753c.setVisibility(8);
                    } else if (size != 3) {
                        view.setVisibility(8);
                    } else {
                        aVar.a.fillData((c.a.t0.c4.a) list.get(0));
                        aVar.f15752b.fillData((c.a.t0.c4.a) list.get(1));
                        aVar.f15753c.fillData((c.a.t0.c4.a) list.get(2));
                        aVar.a.setVisibility(0);
                        aVar.f15752b.setVisibility(0);
                        aVar.f15753c.setVisibility(0);
                    }
                    if (getItem(i2 + 1) instanceof List) {
                        aVar.f15754d.setVisibility(8);
                    } else {
                        aVar.f15754d.setVisibility(0);
                    }
                }
            }
            this.f15750h.getLayoutMode().j(view);
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
