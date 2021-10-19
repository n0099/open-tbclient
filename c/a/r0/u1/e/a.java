package c.a.r0.u1.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.location.selectpoi.SearchLocationActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.u1.c.a f25169e;

    /* renamed from: f  reason: collision with root package name */
    public SearchLocationActivity f25170f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f25171g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f25172h;

    /* renamed from: c.a.r0.u1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C1169a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f25173a;

        /* renamed from: b  reason: collision with root package name */
        public View f25174b;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(a aVar, C1169a c1169a) {
            this(aVar);
        }
    }

    public a(SearchLocationActivity searchLocationActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {searchLocationActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25171g = false;
        this.f25170f = searchLocationActivity;
    }

    public View a(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            NoDataView a2 = NoDataViewFactory.a(this.f25170f.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.a(R.string.text_try_to_chage_location), null);
            this.f25172h = a2;
            a2.onChangeSkinType(this.f25170f.getPageContext(), skinType);
            this.f25172h.setVisibility(0);
            return this.f25172h;
        }
        return (View) invokeL.objValue;
    }

    public b b(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) {
            b bVar = new b(this, null);
            bVar.f25173a = (TextView) view.findViewById(R.id.location_search_address_name);
            bVar.f25174b = view.findViewById(R.id.location_search_line);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f25171g : invokeV.booleanValue;
    }

    public void d(c.a.r0.u1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f25169e = aVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.r0.u1.c.a aVar = this.f25169e;
            if (aVar != null && aVar.a() != null && !this.f25169e.a().isEmpty()) {
                this.f25171g = true;
                return this.f25169e.a().size();
            }
            this.f25171g = false;
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            c.a.r0.u1.c.a aVar = this.f25169e;
            if (aVar == null || aVar.a() == null || this.f25169e.a().isEmpty()) {
                return null;
            }
            return this.f25169e.a().get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (!this.f25171g) {
                return a(viewGroup);
            }
            b bVar = null;
            if (view != null && (view.getTag() instanceof b)) {
                bVar = (b) view.getTag();
            }
            if (bVar == null) {
                view = LayoutInflater.from(this.f25170f.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
                bVar = b(view);
                view.setTag(bVar);
            }
            bVar.f25173a.setText(this.f25169e.a().get(i2).a());
            SkinManager.setBackgroundColor(bVar.f25174b, R.color.CAM_X0204);
            SkinManager.setViewTextColor(bVar.f25173a, R.color.CAM_X0105, 1);
            SkinManager.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
