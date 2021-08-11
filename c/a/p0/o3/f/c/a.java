package c.a.p0.o3.f.c;

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
    public List<List<DressItemData>> f23068e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f23069f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.o3.f.a.a f23070g;

    /* renamed from: c.a.p0.o3.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1069a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f23071a;

        /* renamed from: b  reason: collision with root package name */
        public BubbleItemView f23072b;

        /* renamed from: c  reason: collision with root package name */
        public BubbleItemView f23073c;

        public C1069a() {
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

    public a(TbPageContext<?> tbPageContext, c.a.p0.o3.f.a.a aVar) {
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
        this.f23069f = tbPageContext;
        this.f23070g = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public List<DressItemData> getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<List<DressItemData>> list = this.f23068e;
            if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f23068e.size()) {
                return null;
            }
            return this.f23068e.get(i2);
        }
        return (List) invokeI.objValue;
    }

    public void b(List<List<DressItemData>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f23068e = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<List<DressItemData>> list = this.f23068e;
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
        C1069a c1069a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            List<DressItemData> item = getItem(i2);
            if (view != null) {
                c1069a = (C1069a) view.getTag();
            } else {
                view = LayoutInflater.from(this.f23069f.getPageActivity()).inflate(R.layout.bubble_row, viewGroup, false);
                c1069a = new C1069a();
                c1069a.f23071a = view.findViewById(R.id.top_white_line);
                c1069a.f23072b = (BubbleItemView) view.findViewById(R.id.bg_view1);
                c1069a.f23073c = (BubbleItemView) view.findViewById(R.id.bg_view2);
                view.setTag(c1069a);
            }
            if (item != null) {
                if (i2 == 0) {
                    c1069a.f23071a.setVisibility(0);
                } else {
                    c1069a.f23071a.setVisibility(8);
                }
                c1069a.f23072b.fillView(item.get(0));
                c1069a.f23072b.setController(this.f23070g);
                c1069a.f23072b.setFromBubbleGroup(false);
                if (item.size() > 1) {
                    c1069a.f23073c.fillView(item.get(1));
                    c1069a.f23073c.setController(this.f23070g);
                    c1069a.f23073c.setFromBubbleGroup(false);
                } else {
                    c1069a.f23073c.hide();
                }
            }
            this.f23069f.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
