package c.a.r0.t1.e;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.location.selectpoi.SelectLocationActivity;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<Object> f25000e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<SelectLocationActivity> f25001f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f25002g;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.r0.t1.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1161b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f25003a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f25004b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f25005c;

        public C1161b() {
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

        public /* synthetic */ C1161b(a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f25006a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f25007b;

        /* renamed from: c  reason: collision with root package name */
        public View f25008c;

        public c() {
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

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public b(TbPageContext<SelectLocationActivity> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25001f = tbPageContext;
        LocationData b2 = c.a.r0.j3.n0.b.a().b();
        this.f25002g = !c.a.r0.j3.n0.b.a().d();
        if (b2 == null) {
            return;
        }
        this.f25000e = c(b2.getPoi_info(), b2.getFormatted_address());
    }

    public final View a(View view, int i2, boolean z) {
        InterceptResult invokeCommon;
        C1161b c1161b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            Object item = getItem(i2);
            if (item instanceof LocationData.NearByAddressData) {
                LocationData.NearByAddressData nearByAddressData = (LocationData.NearByAddressData) item;
                if (view != null && (view.getTag() instanceof c)) {
                    c1161b = (C1161b) view.getTag();
                } else {
                    view = LayoutInflater.from(this.f25001f.getPageActivity()).inflate(R.layout.select_location_address_item, (ViewGroup) null);
                    c1161b = new C1161b(null);
                    c1161b.f25003a = (TextView) view.findViewById(R.id.select_location_name);
                    c1161b.f25004b = (TextView) view.findViewById(R.id.select_location_address);
                    c1161b.f25005c = (ImageView) view.findViewById(R.id.select_location_tick);
                    view.setTag(c1161b);
                }
                c1161b.f25004b.setText(nearByAddressData.getAddr());
                if (this.f25002g && i2 == 1) {
                    c1161b.f25005c.setVisibility(0);
                    c1161b.f25005c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_chx__site_ok24, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL_PRESS));
                    if (TextUtils.isEmpty(nearByAddressData.getAddr())) {
                        c1161b.f25004b.setText(R.string.select_location_current);
                    }
                } else {
                    c1161b.f25005c.setVisibility(4);
                }
                c1161b.f25003a.setText(nearByAddressData.getName());
                this.f25001f.getLayoutMode().k(z);
                this.f25001f.getLayoutMode().j(view);
                SkinManager.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
                return view;
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final View b(View view, int i2, boolean z) {
        InterceptResult invokeCommon;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            Object item = getItem(i2);
            if (item instanceof String) {
                String str = (String) item;
                if (view != null && (view.getTag() instanceof c)) {
                    cVar = (c) view.getTag();
                } else {
                    view = LayoutInflater.from(this.f25001f.getPageActivity()).inflate(R.layout.select_location_nolocation_item, (ViewGroup) null);
                    cVar = new c(null);
                    cVar.f25006a = (TextView) view.findViewById(R.id.select_location_title);
                    cVar.f25007b = (ImageView) view.findViewById(R.id.select_location_tick);
                    cVar.f25008c = view.findViewById(R.id.select_location_line);
                    view.setTag(cVar);
                }
                if (i2 == 0 && !this.f25002g) {
                    cVar.f25007b.setVisibility(0);
                    cVar.f25007b.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_chx__site_ok24, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL_PRESS));
                } else {
                    cVar.f25007b.setVisibility(4);
                }
                cVar.f25006a.setText(str);
                SkinManager.setBackgroundColor(cVar.f25008c, R.color.CAM_X0204);
                SkinManager.setViewTextColor(cVar.f25006a, R.color.CAM_X0302, 1);
                SkinManager.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
                return view;
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final ArrayList<Object> c(List<LocationData.NearByAddressData> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, str)) == null) {
            LocationData.NearByAddressData nearByAddressData = null;
            if (list == null || list.size() <= 0) {
                return null;
            }
            ArrayList<Object> arrayList = new ArrayList<>();
            for (LocationData.NearByAddressData nearByAddressData2 : list) {
                if (nearByAddressData2 != null && !TextUtils.isEmpty(nearByAddressData2.getName())) {
                    if (TextUtils.equals(nearByAddressData2.getName(), str)) {
                        nearByAddressData = nearByAddressData2;
                    } else {
                        arrayList.add(nearByAddressData2);
                    }
                }
            }
            if (nearByAddressData != null) {
                arrayList.add(0, nearByAddressData);
            } else {
                LocationData.NearByAddressData nearByAddressData3 = new LocationData.NearByAddressData();
                nearByAddressData3.setName(str);
                arrayList.add(0, nearByAddressData3);
            }
            TbPageContext<SelectLocationActivity> tbPageContext = this.f25001f;
            if (tbPageContext != null) {
                arrayList.add(0, tbPageContext.getString(R.string.select_position_no_location));
            }
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList<Object> arrayList = this.f25000e;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            ArrayList<Object> arrayList = this.f25000e;
            if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
                return null;
            }
            return this.f25000e.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            Object item = getItem(i2);
            if (item instanceof String) {
                return 0;
            }
            return item instanceof LocationData.NearByAddressData ? 1 : 2;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            int itemViewType = getItemViewType(i2);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    return null;
                }
                return a(view, i2, z);
            }
            return b(view, i2, z);
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }
}
