package b.a.r0.r3.e;

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
/* loaded from: classes5.dex */
public class e extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<List<DressItemData>> f23129e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f23130f;

    /* renamed from: g  reason: collision with root package name */
    public d f23131g;

    /* loaded from: classes5.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f23132a;

        /* renamed from: b  reason: collision with root package name */
        public BackgroundItemView f23133b;

        /* renamed from: c  reason: collision with root package name */
        public BackgroundItemView f23134c;

        /* renamed from: d  reason: collision with root package name */
        public BackgroundItemView f23135d;

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
        this.f23130f = tbPageContext;
        this.f23131g = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public List<DressItemData> getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<List<DressItemData>> list = this.f23129e;
            if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f23129e.size()) {
                return null;
            }
            return this.f23129e.get(i2);
        }
        return (List) invokeI.objValue;
    }

    public void b(List<List<DressItemData>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f23129e = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<List<DressItemData>> list = this.f23129e;
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
                view = LayoutInflater.from(this.f23130f.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
                aVar = new a(this);
                aVar.f23132a = view.findViewById(R.id.top_white_line);
                aVar.f23133b = (BackgroundItemView) view.findViewById(R.id.bg_view1);
                aVar.f23134c = (BackgroundItemView) view.findViewById(R.id.bg_view2);
                aVar.f23135d = (BackgroundItemView) view.findViewById(R.id.bg_view3);
                view.setTag(aVar);
            }
            if (item != null) {
                if (i2 == 0) {
                    aVar.f23132a.setVisibility(0);
                } else {
                    aVar.f23132a.setVisibility(8);
                }
                aVar.f23133b.fillView(item.get(0));
                aVar.f23133b.setController(this.f23131g);
                if (item.size() > 2) {
                    aVar.f23134c.fillView(item.get(1));
                    aVar.f23135d.fillView(item.get(2));
                    aVar.f23134c.setController(this.f23131g);
                    aVar.f23135d.setController(this.f23131g);
                } else if (item.size() > 1) {
                    aVar.f23134c.fillView(item.get(1));
                    aVar.f23134c.setController(this.f23131g);
                    aVar.f23135d.hide();
                } else {
                    aVar.f23134c.hide();
                    aVar.f23135d.hide();
                }
            }
            this.f23130f.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
