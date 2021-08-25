package c.a.q0.a3.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import c.a.e.e.p.k;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends BaseAdapter implements BdSwitchView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f15580e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<OfficialAccountPushInfo> f15581f;

    /* renamed from: g  reason: collision with root package name */
    public BdSwitchView.b f15582g;

    /* renamed from: c.a.q0.a3.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0732a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public MsgSettingItemView f15583a;

        public C0732a(a aVar) {
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
    }

    public a(TbPageContext tbPageContext) {
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
        this.f15580e = tbPageContext;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
        BdSwitchView.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, switchState) == null) || (bVar = this.f15582g) == null) {
            return;
        }
        bVar.OnSwitchStateChange(view, switchState);
    }

    public void a(ArrayList<OfficialAccountPushInfo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
            this.f15581f = arrayList;
        }
    }

    public void b(BdSwitchView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f15582g = bVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList<OfficialAccountPushInfo> arrayList = this.f15581f;
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
            ArrayList<OfficialAccountPushInfo> arrayList = this.f15581f;
            if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
                return null;
            }
            return this.f15581f.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (getItem(i2) != null) {
                return i2;
            }
            return -1L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C0732a c0732a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f15580e.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
                c0732a = new C0732a(this);
                c0732a.f15583a = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
                view.setTag(c0732a);
            } else {
                c0732a = (C0732a) view.getTag();
            }
            OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i2);
            if (k.isEmpty(officialAccountPushInfo.name)) {
                c0732a.f15583a.setVisibility(8);
            } else {
                c0732a.f15583a.setVisibility(0);
                c0732a.f15583a.setText(officialAccountPushInfo.name);
                if (officialAccountPushInfo.is_on == 1) {
                    c0732a.f15583a.getSwitchView().turnOnNoCallback();
                } else {
                    c0732a.f15583a.getSwitchView().turnOffNoCallback();
                }
                c0732a.f15583a.setLineVisibility(true);
                c0732a.f15583a.onChangeSkinType(this.f15580e, TbadkCoreApplication.getInst().getSkinType());
                c0732a.f15583a.getSwitchView().setOnSwitchStateChangeListener(this);
                c0732a.f15583a.getSwitchView().setTag(officialAccountPushInfo);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
