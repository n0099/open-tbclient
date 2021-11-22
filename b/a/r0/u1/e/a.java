package b.a.r0.u1.e;

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
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.u1.c.a f25499e;

    /* renamed from: f  reason: collision with root package name */
    public SearchLocationActivity f25500f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f25501g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f25502h;

    /* renamed from: b.a.r0.u1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class C1235a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f25503a;

        /* renamed from: b  reason: collision with root package name */
        public View f25504b;

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

        public /* synthetic */ b(a aVar, C1235a c1235a) {
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
        this.f25501g = false;
        this.f25500f = searchLocationActivity;
    }

    public View a(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            NoDataView a2 = NoDataViewFactory.a(this.f25500f.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.a(R.string.text_try_to_chage_location), null);
            this.f25502h = a2;
            a2.onChangeSkinType(this.f25500f.getPageContext(), skinType);
            this.f25502h.setVisibility(0);
            return this.f25502h;
        }
        return (View) invokeL.objValue;
    }

    public b b(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) {
            b bVar = new b(this, null);
            bVar.f25503a = (TextView) view.findViewById(R.id.location_search_address_name);
            bVar.f25504b = view.findViewById(R.id.location_search_line);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f25501g : invokeV.booleanValue;
    }

    public void d(b.a.r0.u1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f25499e = aVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            b.a.r0.u1.c.a aVar = this.f25499e;
            if (aVar != null && aVar.a() != null && !this.f25499e.a().isEmpty()) {
                this.f25501g = true;
                return this.f25499e.a().size();
            }
            this.f25501g = false;
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            b.a.r0.u1.c.a aVar = this.f25499e;
            if (aVar == null || aVar.a() == null || this.f25499e.a().isEmpty()) {
                return null;
            }
            return this.f25499e.a().get(i2);
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
            if (!this.f25501g) {
                return a(viewGroup);
            }
            b bVar = null;
            if (view != null && (view.getTag() instanceof b)) {
                bVar = (b) view.getTag();
            }
            if (bVar == null) {
                view = LayoutInflater.from(this.f25500f.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
                bVar = b(view);
                view.setTag(bVar);
            }
            bVar.f25503a.setText(this.f25499e.a().get(i2).a());
            SkinManager.setBackgroundColor(bVar.f25504b, R.color.CAM_X0204);
            SkinManager.setViewTextColor(bVar.f25503a, R.color.CAM_X0105, 1);
            SkinManager.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
