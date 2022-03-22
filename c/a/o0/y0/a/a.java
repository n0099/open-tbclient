package c.a.o0.y0.a;

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
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<c.a.o0.y0.a.b> a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f11597b;

    /* renamed from: c  reason: collision with root package name */
    public int f11598c;

    /* renamed from: d  reason: collision with root package name */
    public int f11599d;

    /* renamed from: e  reason: collision with root package name */
    public int f11600e;

    /* renamed from: f  reason: collision with root package name */
    public int f11601f;

    /* renamed from: g  reason: collision with root package name */
    public int f11602g;

    /* renamed from: h  reason: collision with root package name */
    public int f11603h;
    public int i;

    /* renamed from: c.a.o0.y0.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C0871a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f11604b;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(a aVar, C0871a c0871a) {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f11597b = null;
        this.f11598c = -1;
        this.f11603h = 0;
        this.i = 0;
        this.f11597b = tbPageContext;
        this.a = new ArrayList<>();
        this.f11599d = SkinManager.getColor(R.color.common_color_10043);
        this.f11600e = SkinManager.getColor(R.color.CAM_X0302);
        this.f11601f = n.f(tbPageContext.getPageActivity(), R.dimen.obfuscated_res_0x7f070198);
        this.f11602g = n.f(this.f11597b.getPageActivity(), R.dimen.obfuscated_res_0x7f070224);
        this.f11603h = n.f(this.f11597b.getPageActivity(), R.dimen.obfuscated_res_0x7f070215);
    }

    public int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            int i2 = i / 4;
            if (i2 == 0) {
                return 1;
            }
            return i2 == this.i - 1 ? 2 : 3;
        }
        return invokeI.intValue;
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.f11598c = i;
        }
    }

    public void c(ArrayList<c.a.o0.y0.a.b> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.a = arrayList;
            if (arrayList != null) {
                if (arrayList.size() % 4 == 0) {
                    this.i = arrayList.size() / 4;
                } else {
                    this.i = (arrayList.size() / 4) + 1;
                }
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList<c.a.o0.y0.a.b> arrayList = this.a;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            ArrayList<c.a.o0.y0.a.b> arrayList = this.a;
            if (arrayList == null || i >= arrayList.size()) {
                return null;
            }
            return this.a.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? i == this.f11598c ? 1 : 0 : invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view, viewGroup)) == null) {
            int itemViewType = getItemViewType(i);
            if (view == null) {
                view = LayoutInflater.from(this.f11597b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d072f, viewGroup, false);
                bVar = new b(this, null);
                bVar.a = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f09182a);
                bVar.f11604b = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f091827);
            } else {
                bVar = (b) view.getTag();
            }
            if (a(i) == 1) {
                bVar.a.setPadding(0, this.f11603h, 0, 0);
            } else if (a(i) == 2) {
                bVar.a.setPadding(0, 0, 0, this.f11603h);
            } else {
                bVar.a.setPadding(0, 0, 0, 0);
            }
            bVar.f11604b.setDrawerType(0);
            bVar.f11604b.setBorderSurroundContent(true);
            bVar.f11604b.setDrawBorder(true);
            if (itemViewType == 0) {
                bVar.f11604b.setBorderColor(this.f11599d);
                bVar.f11604b.setBorderWidth(this.f11601f);
            } else {
                bVar.f11604b.setBorderColor(this.f11600e);
                bVar.f11604b.setBorderWidth(this.f11602g);
            }
            bVar.f11604b.setDefaultResource(R.drawable.obfuscated_res_0x7f081200);
            bVar.f11604b.J(this.a.get(i).a(), 10, false);
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
