package c.a.p0.f4.f.c;

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
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<List<DressItemData>> a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f15075b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.f4.f.a.a f15076c;

    /* renamed from: c.a.p0.f4.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1136a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public BubbleItemView f15077b;

        /* renamed from: c  reason: collision with root package name */
        public BubbleItemView f15078c;

        public C1136a() {
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

    public a(TbPageContext<?> tbPageContext, c.a.p0.f4.f.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15075b = tbPageContext;
        this.f15076c = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public List<DressItemData> getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List<List<DressItemData>> list = this.a;
            if (list == null || list.size() <= 0 || i < 0 || i >= this.a.size()) {
                return null;
            }
            return this.a.get(i);
        }
        return (List) invokeI.objValue;
    }

    public void b(List<List<DressItemData>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.a = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<List<DressItemData>> list = this.a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1136a c1136a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i, view, viewGroup)) == null) {
            List<DressItemData> item = getItem(i);
            if (view != null) {
                c1136a = (C1136a) view.getTag();
            } else {
                view = LayoutInflater.from(this.f15075b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0169, viewGroup, false);
                c1136a = new C1136a();
                c1136a.a = view.findViewById(R.id.obfuscated_res_0x7f0920d2);
                c1136a.f15077b = (BubbleItemView) view.findViewById(R.id.obfuscated_res_0x7f090363);
                c1136a.f15078c = (BubbleItemView) view.findViewById(R.id.obfuscated_res_0x7f090364);
                view.setTag(c1136a);
            }
            if (item != null) {
                if (i == 0) {
                    c1136a.a.setVisibility(0);
                } else {
                    c1136a.a.setVisibility(8);
                }
                c1136a.f15077b.d(item.get(0));
                c1136a.f15077b.setController(this.f15076c);
                c1136a.f15077b.setFromBubbleGroup(false);
                if (item.size() > 1) {
                    c1136a.f15078c.d(item.get(1));
                    c1136a.f15078c.setController(this.f15076c);
                    c1136a.f15078c.setFromBubbleGroup(false);
                } else {
                    c1136a.f15078c.e();
                }
            }
            this.f15075b.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
