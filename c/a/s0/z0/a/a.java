package c.a.s0.z0.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c.a.s0.z0.a.b> f14433e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f14434f;

    /* renamed from: g  reason: collision with root package name */
    public int f14435g;

    /* renamed from: h  reason: collision with root package name */
    public int f14436h;

    /* renamed from: i  reason: collision with root package name */
    public int f14437i;

    /* renamed from: j  reason: collision with root package name */
    public int f14438j;
    public int k;
    public int l;
    public int m;

    /* renamed from: c.a.s0.z0.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class C0922a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f14439b;

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

        public /* synthetic */ b(a aVar, C0922a c0922a) {
            this(aVar);
        }
    }

    public a(TbPageContext<?> tbPageContext) {
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
        this.f14433e = null;
        this.f14434f = null;
        this.f14435g = -1;
        this.l = 0;
        this.m = 0;
        this.f14434f = tbPageContext;
        this.f14433e = new ArrayList<>();
        this.f14436h = SkinManager.getColor(R.color.common_color_10043);
        this.f14437i = SkinManager.getColor(R.color.CAM_X0302);
        this.f14438j = n.f(tbPageContext.getPageActivity(), R.dimen.ds1);
        this.k = n.f(this.f14434f.getPageActivity(), R.dimen.ds4);
        this.l = n.f(this.f14434f.getPageActivity(), R.dimen.ds36);
    }

    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int i3 = i2 / 4;
            if (i3 == 0) {
                return 1;
            }
            return i3 == this.m - 1 ? 2 : 3;
        }
        return invokeI.intValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f14435g = i2;
        }
    }

    public void c(ArrayList<c.a.s0.z0.a.b> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.f14433e = arrayList;
            if (arrayList != null) {
                if (arrayList.size() % 4 == 0) {
                    this.m = arrayList.size() / 4;
                } else {
                    this.m = (arrayList.size() / 4) + 1;
                }
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList<c.a.s0.z0.a.b> arrayList = this.f14433e;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            ArrayList<c.a.s0.z0.a.b> arrayList = this.f14433e;
            if (arrayList == null || i2 >= arrayList.size()) {
                return null;
            }
            return this.f14433e.get(i2);
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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? i2 == this.f14435g ? 1 : 0 : invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            int itemViewType = getItemViewType(i2);
            if (view == null) {
                view = LayoutInflater.from(this.f14434f.getPageActivity()).inflate(R.layout.recommend_system_photo_item, viewGroup, false);
                bVar = new b(this, null);
                bVar.a = (LinearLayout) view.findViewById(R.id.photo_container);
                bVar.f14439b = (TbImageView) view.findViewById(R.id.photo);
            } else {
                bVar = (b) view.getTag();
            }
            if (a(i2) == 1) {
                bVar.a.setPadding(0, this.l, 0, 0);
            } else if (a(i2) == 2) {
                bVar.a.setPadding(0, 0, 0, this.l);
            } else {
                bVar.a.setPadding(0, 0, 0, 0);
            }
            bVar.f14439b.setDrawerType(0);
            bVar.f14439b.setBorderSurroundContent(true);
            bVar.f14439b.setDrawBorder(true);
            if (itemViewType == 0) {
                bVar.f14439b.setBorderColor(this.f14436h);
                bVar.f14439b.setBorderWidth(this.f14438j);
            } else {
                bVar.f14439b.setBorderColor(this.f14437i);
                bVar.f14439b.setBorderWidth(this.k);
            }
            bVar.f14439b.setDefaultResource(R.drawable.transparent_bg);
            bVar.f14439b.startLoad(this.f14433e.get(i2).a(), 10, false);
            view.setTag(bVar);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }
}
