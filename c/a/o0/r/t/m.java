package c.a.o0.r.t;

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
/* loaded from: classes2.dex */
public class m extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<n> a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f11079b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f11080c;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f11081b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f11082c;

        public b(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(m mVar, a aVar) {
            this(mVar);
        }
    }

    public m(TbPageContext<?> tbPageContext) {
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
        this.f11080c = false;
        this.f11079b = tbPageContext;
        this.a = new ArrayList<>();
    }

    public final boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            ArrayList<n> arrayList = this.a;
            return arrayList != null && i == arrayList.size() - 1;
        }
        return invokeI.booleanValue;
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f11080c = z;
        }
    }

    public void c(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.a = arrayList;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? this.a.get(i) : invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view, viewGroup)) == null) {
            n nVar = this.a.get(i);
            if (nVar == null) {
                return null;
            }
            if (view == null) {
                view = LayoutInflater.from(this.f11079b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0238, viewGroup, false);
                bVar = new b(this, null);
                bVar.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091f50);
                bVar.f11081b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091f34);
                bVar.f11082c = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f09060b);
            } else {
                bVar = (b) view.getTag();
            }
            bVar.a.setText(nVar.c());
            if (StringUtils.isNull(nVar.a())) {
                bVar.f11081b.setVisibility(8);
            } else {
                bVar.f11081b.setText(nVar.a());
                bVar.f11081b.setVisibility(0);
            }
            if (nVar.d()) {
                bVar.f11082c.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f08081e, WebPManager.ResourceStateType.NORMAL));
                bVar.f11082c.setVisibility(0);
            } else if (this.f11080c) {
                WebPManager.setPureDrawable(bVar.f11082c, R.drawable.obfuscated_res_0x7f08099b, R.color.CAM_X0111, WebPManager.ResourceStateType.NORMAL);
                bVar.f11082c.setVisibility(0);
            } else {
                bVar.f11082c.setVisibility(4);
            }
            if (a(i)) {
                SkinManager.setBackgroundResource(view, R.drawable.dialog_single_button_bg_selector);
            } else {
                SkinManager.setBackgroundResource(view, R.drawable.dialg_alert_btn_bg);
            }
            view.setTag(bVar);
            this.f11079b.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.f11079b.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
