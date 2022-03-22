package c.a.p0.f4.e;

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
    public List<Object> a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f15012b;

    /* renamed from: c  reason: collision with root package name */
    public d f15013c;

    /* renamed from: c.a.p0.f4.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1134a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public BackgroundItemView f15014b;

        /* renamed from: c  reason: collision with root package name */
        public BackgroundItemView f15015c;

        /* renamed from: d  reason: collision with root package name */
        public BackgroundItemView f15016d;

        /* renamed from: e  reason: collision with root package name */
        public View f15017e;

        public C1134a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15012b = tbPageContext;
        this.f15013c = dVar;
    }

    public void a(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.a = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<Object> list = this.a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            List<Object> list = this.a;
            if (list == null || list.size() <= 0 || i < 0 || i >= this.a.size()) {
                return null;
            }
            return this.a.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (getItem(i) != null) {
                return i;
            }
            return -1L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? getItem(i) instanceof List ? 1 : 0 : invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1134a c1134a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i, view, viewGroup)) == null) {
            Object item = getItem(i);
            if (view != null) {
                c1134a = (C1134a) view.getTag();
            } else if (getItemViewType(i) == 0) {
                view = LayoutInflater.from(this.f15012b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d012e, viewGroup, false);
                c1134a = new C1134a();
                c1134a.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090cf7);
                view.setTag(c1134a);
            } else {
                view = LayoutInflater.from(this.f15012b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0134, viewGroup, false);
                c1134a = new C1134a();
                c1134a.f15014b = (BackgroundItemView) view.findViewById(R.id.obfuscated_res_0x7f090363);
                c1134a.f15015c = (BackgroundItemView) view.findViewById(R.id.obfuscated_res_0x7f090364);
                c1134a.f15016d = (BackgroundItemView) view.findViewById(R.id.obfuscated_res_0x7f090365);
                c1134a.f15017e = view.findViewById(R.id.obfuscated_res_0x7f0907f4);
                view.setTag(c1134a);
            }
            if (item != null) {
                if (getItemViewType(i) == 0) {
                    c1134a.a.setText(item.toString());
                } else {
                    List list = (List) item;
                    c1134a.f15014b.e((DressItemData) list.get(0));
                    c1134a.f15014b.setController(this.f15013c);
                    if (list.size() > 2) {
                        c1134a.f15015c.e((DressItemData) list.get(1));
                        c1134a.f15016d.e((DressItemData) list.get(2));
                        c1134a.f15015c.setController(this.f15013c);
                        c1134a.f15016d.setController(this.f15013c);
                    } else if (list.size() > 1) {
                        c1134a.f15015c.e((DressItemData) list.get(1));
                        c1134a.f15015c.setController(this.f15013c);
                        c1134a.f15016d.f();
                    } else {
                        c1134a.f15015c.f();
                        c1134a.f15016d.f();
                    }
                    if (getItem(i + 1) instanceof List) {
                        c1134a.f15017e.setVisibility(8);
                    } else {
                        c1134a.f15017e.setVisibility(0);
                    }
                }
            }
            this.f15012b.getLayoutMode().j(view);
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
