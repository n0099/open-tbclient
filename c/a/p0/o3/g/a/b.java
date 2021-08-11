package c.a.p0.o3.g.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import c.a.e.e.p.l;
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
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f23084e;

    /* renamed from: f  reason: collision with root package name */
    public int f23085f;

    /* renamed from: g  reason: collision with root package name */
    public List<Object> f23086g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<?> f23087h;

    /* renamed from: i  reason: collision with root package name */
    public PersonalCardItemView.b f23088i;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public PersonalCardItemView f23089a;

        /* renamed from: b  reason: collision with root package name */
        public PersonalCardItemView f23090b;

        /* renamed from: c  reason: collision with root package name */
        public PersonalCardItemView f23091c;

        /* renamed from: d  reason: collision with root package name */
        public View f23092d;

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

    /* renamed from: c.a.p0.o3.g.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1070b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f23093a;

        public C1070b() {
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
        this.f23084e = 0;
        this.f23085f = 0;
        this.f23087h = tbPageContext;
        this.f23084e = l.g(tbPageContext.getPageActivity(), R.dimen.ds28);
        this.f23085f = l.g(tbPageContext.getPageActivity(), R.dimen.ds20);
    }

    public void a(PersonalCardItemView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f23088i = bVar;
        }
    }

    public void b(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f23086g = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<Object> list = this.f23086g;
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
            List<Object> list = this.f23086g;
            if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f23086g.size()) {
                return null;
            }
            return this.f23086g.get(i2);
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
        C1070b c1070b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            int itemViewType = getItemViewType(i2);
            Object item = getItem(i2);
            if (itemViewType == 0) {
                if (view != null && (view.getTag() instanceof C1070b)) {
                    c1070b = (C1070b) view.getTag();
                } else {
                    c1070b = new C1070b();
                    view = LayoutInflater.from(this.f23087h.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
                    TextView textView = (TextView) view.findViewById(R.id.group_name);
                    c1070b.f23093a = textView;
                    textView.setPadding(0, this.f23084e, 0, this.f23085f);
                    view.setTag(c1070b);
                }
                if (item != null) {
                    c1070b.f23093a.setText(item.toString());
                }
            } else if (itemViewType == 1) {
                if (view != null && (view.getTag() instanceof a)) {
                    aVar = (a) view.getTag();
                } else {
                    a aVar2 = new a();
                    View inflate = LayoutInflater.from(this.f23087h.getPageActivity()).inflate(R.layout.category_card_list_item, viewGroup, false);
                    aVar2.f23089a = (PersonalCardItemView) inflate.findViewById(R.id.card1);
                    aVar2.f23090b = (PersonalCardItemView) inflate.findViewById(R.id.card2);
                    aVar2.f23091c = (PersonalCardItemView) inflate.findViewById(R.id.card3);
                    aVar2.f23092d = inflate.findViewById(R.id.divider_line);
                    aVar2.f23089a.setCardViewController(this.f23088i);
                    aVar2.f23090b.setCardViewController(this.f23088i);
                    aVar2.f23091c.setCardViewController(this.f23088i);
                    inflate.setTag(aVar2);
                    aVar = aVar2;
                    view = inflate;
                }
                if (item != null) {
                    List list = (List) item;
                    int size = list.size();
                    if (size == 1) {
                        aVar.f23089a.fillData((c.a.p0.o3.a) list.get(0));
                        aVar.f23089a.setVisibility(0);
                        aVar.f23090b.setVisibility(8);
                        aVar.f23091c.setVisibility(8);
                    } else if (size == 2) {
                        aVar.f23089a.fillData((c.a.p0.o3.a) list.get(0));
                        aVar.f23090b.fillData((c.a.p0.o3.a) list.get(1));
                        aVar.f23089a.setVisibility(0);
                        aVar.f23090b.setVisibility(0);
                        aVar.f23091c.setVisibility(8);
                    } else if (size != 3) {
                        view.setVisibility(8);
                    } else {
                        aVar.f23089a.fillData((c.a.p0.o3.a) list.get(0));
                        aVar.f23090b.fillData((c.a.p0.o3.a) list.get(1));
                        aVar.f23091c.fillData((c.a.p0.o3.a) list.get(2));
                        aVar.f23089a.setVisibility(0);
                        aVar.f23090b.setVisibility(0);
                        aVar.f23091c.setVisibility(0);
                    }
                    if (getItem(i2 + 1) instanceof List) {
                        aVar.f23092d.setVisibility(8);
                    } else {
                        aVar.f23092d.setVisibility(0);
                    }
                }
            }
            this.f23087h.getLayoutMode().j(view);
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
