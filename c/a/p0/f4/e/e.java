package c.a.p0.f4.e;

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
/* loaded from: classes2.dex */
public class e extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<List<DressItemData>> a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f15029b;

    /* renamed from: c  reason: collision with root package name */
    public d f15030c;

    /* loaded from: classes2.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public BackgroundItemView f15031b;

        /* renamed from: c  reason: collision with root package name */
        public BackgroundItemView f15032c;

        /* renamed from: d  reason: collision with root package name */
        public BackgroundItemView f15033d;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
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

    public e(TbPageContext<?> tbPageContext, d dVar) {
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
        this.f15029b = tbPageContext;
        this.f15030c = dVar;
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
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i, view, viewGroup)) == null) {
            List<DressItemData> item = getItem(i);
            if (view != null) {
                aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.f15029b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0134, viewGroup, false);
                aVar = new a(this);
                aVar.a = view.findViewById(R.id.obfuscated_res_0x7f0920d2);
                aVar.f15031b = (BackgroundItemView) view.findViewById(R.id.obfuscated_res_0x7f090363);
                aVar.f15032c = (BackgroundItemView) view.findViewById(R.id.obfuscated_res_0x7f090364);
                aVar.f15033d = (BackgroundItemView) view.findViewById(R.id.obfuscated_res_0x7f090365);
                view.setTag(aVar);
            }
            if (item != null) {
                if (i == 0) {
                    aVar.a.setVisibility(0);
                } else {
                    aVar.a.setVisibility(8);
                }
                aVar.f15031b.e(item.get(0));
                aVar.f15031b.setController(this.f15030c);
                if (item.size() > 2) {
                    aVar.f15032c.e(item.get(1));
                    aVar.f15033d.e(item.get(2));
                    aVar.f15032c.setController(this.f15030c);
                    aVar.f15033d.setController(this.f15030c);
                } else if (item.size() > 1) {
                    aVar.f15032c.e(item.get(1));
                    aVar.f15032c.setController(this.f15030c);
                    aVar.f15033d.f();
                } else {
                    aVar.f15032c.f();
                    aVar.f15033d.f();
                }
            }
            this.f15029b.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
