package c.a.t0.s.t;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class k extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<l> f14087e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f14088f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14089g;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f14090b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f14091c;

        public b(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(k kVar, a aVar) {
            this(kVar);
        }
    }

    public k(TbPageContext<?> tbPageContext) {
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
        this.f14089g = false;
        this.f14088f = tbPageContext;
        this.f14087e = new ArrayList<>();
    }

    public final boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            ArrayList<l> arrayList = this.f14087e;
            return arrayList != null && i2 == arrayList.size() - 1;
        }
        return invokeI.booleanValue;
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f14089g = z;
        }
    }

    public void c(ArrayList<l> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.f14087e = arrayList;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f14087e.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.f14087e.get(i2) : invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            l lVar = this.f14087e.get(i2);
            if (lVar == null) {
                return null;
            }
            if (view == null) {
                view = LayoutInflater.from(this.f14088f.getPageActivity()).inflate(c.a.u0.a4.h.dialog_rich_bdlist_item, viewGroup, false);
                bVar = new b(this, null);
                bVar.a = (TextView) view.findViewById(c.a.u0.a4.g.text_tip);
                bVar.f14090b = (TextView) view.findViewById(c.a.u0.a4.g.text_desc);
                bVar.f14091c = (ImageView) view.findViewById(c.a.u0.a4.g.checked_icon);
            } else {
                bVar = (b) view.getTag();
            }
            bVar.a.setText(lVar.c());
            if (StringUtils.isNull(lVar.a())) {
                bVar.f14090b.setVisibility(8);
            } else {
                bVar.f14090b.setText(lVar.a());
                bVar.f14090b.setVisibility(0);
            }
            if (lVar.d()) {
                bVar.f14091c.setImageDrawable(WebPManager.getMaskDrawable(c.a.u0.a4.f.icon_mask_set_list_ok_selection26, WebPManager.ResourceStateType.NORMAL));
                bVar.f14091c.setVisibility(0);
            } else if (this.f14089g) {
                WebPManager.setPureDrawable(bVar.f14091c, c.a.u0.a4.f.icon_pure_stroke_n, c.a.u0.a4.d.CAM_X0111, WebPManager.ResourceStateType.NORMAL);
                bVar.f14091c.setVisibility(0);
            } else {
                bVar.f14091c.setVisibility(4);
            }
            if (a(i2)) {
                SkinManager.setBackgroundResource(view, c.a.u0.a4.f.dialog_single_button_bg_selector);
            } else {
                SkinManager.setBackgroundResource(view, c.a.u0.a4.f.dialg_alert_btn_bg);
            }
            view.setTag(bVar);
            this.f14088f.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.f14088f.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
