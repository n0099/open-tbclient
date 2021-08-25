package c.a.q0.o3.f.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<List<DressItemData>> f23400e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f23401f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.o3.f.a.a f23402g;

    /* renamed from: c.a.q0.o3.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1080a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f23403a;

        /* renamed from: b  reason: collision with root package name */
        public BubbleItemView f23404b;

        /* renamed from: c  reason: collision with root package name */
        public BubbleItemView f23405c;

        public C1080a() {
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

    public a(TbPageContext<?> tbPageContext, c.a.q0.o3.f.a.a aVar) {
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
        this.f23401f = tbPageContext;
        this.f23402g = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public List<DressItemData> getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<List<DressItemData>> list = this.f23400e;
            if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f23400e.size()) {
                return null;
            }
            return this.f23400e.get(i2);
        }
        return (List) invokeI.objValue;
    }

    public void b(List<List<DressItemData>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f23400e = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<List<DressItemData>> list = this.f23400e;
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
        C1080a c1080a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            List<DressItemData> item = getItem(i2);
            if (view != null) {
                c1080a = (C1080a) view.getTag();
            } else {
                view = LayoutInflater.from(this.f23401f.getPageActivity()).inflate(R.layout.bubble_row, viewGroup, false);
                c1080a = new C1080a();
                c1080a.f23403a = view.findViewById(R.id.top_white_line);
                c1080a.f23404b = (BubbleItemView) view.findViewById(R.id.bg_view1);
                c1080a.f23405c = (BubbleItemView) view.findViewById(R.id.bg_view2);
                view.setTag(c1080a);
            }
            if (item != null) {
                if (i2 == 0) {
                    c1080a.f23403a.setVisibility(0);
                } else {
                    c1080a.f23403a.setVisibility(8);
                }
                c1080a.f23404b.fillView(item.get(0));
                c1080a.f23404b.setController(this.f23402g);
                c1080a.f23404b.setFromBubbleGroup(false);
                if (item.size() > 1) {
                    c1080a.f23405c.fillView(item.get(1));
                    c1080a.f23405c.setController(this.f23402g);
                    c1080a.f23405c.setFromBubbleGroup(false);
                } else {
                    c1080a.f23405c.hide();
                }
            }
            this.f23401f.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
