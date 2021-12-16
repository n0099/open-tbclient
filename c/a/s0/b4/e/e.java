package c.a.s0.b4.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
public class e extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<List<DressItemData>> f15182e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f15183f;

    /* renamed from: g  reason: collision with root package name */
    public d f15184g;

    /* loaded from: classes7.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public BackgroundItemView f15185b;

        /* renamed from: c  reason: collision with root package name */
        public BackgroundItemView f15186c;

        /* renamed from: d  reason: collision with root package name */
        public BackgroundItemView f15187d;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
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

    public e(TbPageContext<?> tbPageContext, d dVar) {
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
        this.f15183f = tbPageContext;
        this.f15184g = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public List<DressItemData> getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<List<DressItemData>> list = this.f15182e;
            if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f15182e.size()) {
                return null;
            }
            return this.f15182e.get(i2);
        }
        return (List) invokeI.objValue;
    }

    public void b(List<List<DressItemData>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f15182e = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<List<DressItemData>> list = this.f15182e;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            List<DressItemData> item = getItem(i2);
            if (view != null) {
                aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.f15183f.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
                aVar = new a(this);
                aVar.a = view.findViewById(R.id.top_white_line);
                aVar.f15185b = (BackgroundItemView) view.findViewById(R.id.bg_view1);
                aVar.f15186c = (BackgroundItemView) view.findViewById(R.id.bg_view2);
                aVar.f15187d = (BackgroundItemView) view.findViewById(R.id.bg_view3);
                view.setTag(aVar);
            }
            if (item != null) {
                if (i2 == 0) {
                    aVar.a.setVisibility(0);
                } else {
                    aVar.a.setVisibility(8);
                }
                aVar.f15185b.fillView(item.get(0));
                aVar.f15185b.setController(this.f15184g);
                if (item.size() > 2) {
                    aVar.f15186c.fillView(item.get(1));
                    aVar.f15187d.fillView(item.get(2));
                    aVar.f15186c.setController(this.f15184g);
                    aVar.f15187d.setController(this.f15184g);
                } else if (item.size() > 1) {
                    aVar.f15186c.fillView(item.get(1));
                    aVar.f15186c.setController(this.f15184g);
                    aVar.f15187d.hide();
                } else {
                    aVar.f15186c.hide();
                    aVar.f15187d.hide();
                }
            }
            this.f15183f.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
