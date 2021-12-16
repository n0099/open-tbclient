package c.a.r0.s.t;

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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class j extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<k> f13568e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f13569f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13570g;

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
        public TextView f13571b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f13572c;

        public b(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(j jVar, a aVar) {
            this(jVar);
        }
    }

    public j(TbPageContext<?> tbPageContext) {
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
        this.f13570g = false;
        this.f13569f = tbPageContext;
        this.f13568e = new ArrayList<>();
    }

    public final boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            ArrayList<k> arrayList = this.f13568e;
            return arrayList != null && i2 == arrayList.size() - 1;
        }
        return invokeI.booleanValue;
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f13570g = z;
        }
    }

    public void c(ArrayList<k> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.f13568e = arrayList;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13568e.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.f13568e.get(i2) : invokeI.objValue;
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
            k kVar = this.f13568e.get(i2);
            if (kVar == null) {
                return null;
            }
            if (view == null) {
                view = LayoutInflater.from(this.f13569f.getPageActivity()).inflate(R.layout.dialog_rich_bdlist_item, viewGroup, false);
                bVar = new b(this, null);
                bVar.a = (TextView) view.findViewById(R.id.text_tip);
                bVar.f13571b = (TextView) view.findViewById(R.id.text_desc);
                bVar.f13572c = (ImageView) view.findViewById(R.id.checked_icon);
            } else {
                bVar = (b) view.getTag();
            }
            bVar.a.setText(kVar.c());
            if (StringUtils.isNull(kVar.a())) {
                bVar.f13571b.setVisibility(8);
            } else {
                bVar.f13571b.setText(kVar.a());
                bVar.f13571b.setVisibility(0);
            }
            if (kVar.d()) {
                bVar.f13572c.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_set_list_ok_selection26, WebPManager.ResourceStateType.NORMAL));
                bVar.f13572c.setVisibility(0);
            } else if (this.f13570g) {
                WebPManager.setPureDrawable(bVar.f13572c, R.drawable.icon_pure_stroke_n, R.color.CAM_X0111, WebPManager.ResourceStateType.NORMAL);
                bVar.f13572c.setVisibility(0);
            } else {
                bVar.f13572c.setVisibility(4);
            }
            if (a(i2)) {
                SkinManager.setBackgroundResource(view, R.drawable.dialog_single_button_bg_selector);
            } else {
                SkinManager.setBackgroundResource(view, R.drawable.dialg_alert_btn_bg);
            }
            view.setTag(bVar);
            this.f13569f.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.f13569f.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
