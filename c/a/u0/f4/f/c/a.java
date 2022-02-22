package c.a.u0.f4.f.c;

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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<List<DressItemData>> f17814e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f17815f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.u0.f4.f.a.a f17816g;

    /* renamed from: c.a.u0.f4.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1112a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public BubbleItemView f17817b;

        /* renamed from: c  reason: collision with root package name */
        public BubbleItemView f17818c;

        public C1112a() {
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

    public a(TbPageContext<?> tbPageContext, c.a.u0.f4.f.a.a aVar) {
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
        this.f17815f = tbPageContext;
        this.f17816g = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public List<DressItemData> getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<List<DressItemData>> list = this.f17814e;
            if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f17814e.size()) {
                return null;
            }
            return this.f17814e.get(i2);
        }
        return (List) invokeI.objValue;
    }

    public void b(List<List<DressItemData>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f17814e = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<List<DressItemData>> list = this.f17814e;
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
        C1112a c1112a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            List<DressItemData> item = getItem(i2);
            if (view != null) {
                c1112a = (C1112a) view.getTag();
            } else {
                view = LayoutInflater.from(this.f17815f.getPageActivity()).inflate(R.layout.bubble_row, viewGroup, false);
                c1112a = new C1112a();
                c1112a.a = view.findViewById(R.id.top_white_line);
                c1112a.f17817b = (BubbleItemView) view.findViewById(R.id.bg_view1);
                c1112a.f17818c = (BubbleItemView) view.findViewById(R.id.bg_view2);
                view.setTag(c1112a);
            }
            if (item != null) {
                if (i2 == 0) {
                    c1112a.a.setVisibility(0);
                } else {
                    c1112a.a.setVisibility(8);
                }
                c1112a.f17817b.fillView(item.get(0));
                c1112a.f17817b.setController(this.f17816g);
                c1112a.f17817b.setFromBubbleGroup(false);
                if (item.size() > 1) {
                    c1112a.f17818c.fillView(item.get(1));
                    c1112a.f17818c.setController(this.f17816g);
                    c1112a.f17818c.setFromBubbleGroup(false);
                } else {
                    c1112a.f17818c.hide();
                }
            }
            this.f17815f.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
