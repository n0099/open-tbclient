package c.a.t0.n3.m;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import c.a.d.f.p.m;
import c.a.t0.n3.e;
import c.a.t0.n3.f;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class a extends BaseAdapter implements BdSwitchView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f19860e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<OfficialAccountPushInfo> f19861f;

    /* renamed from: g  reason: collision with root package name */
    public BdSwitchView.b f19862g;

    /* renamed from: c.a.t0.n3.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1232a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public MsgSettingItemView a;

        public C1232a(a aVar) {
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
        this.f19860e = tbPageContext;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
        BdSwitchView.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, switchState) == null) || (bVar = this.f19862g) == null) {
            return;
        }
        bVar.OnSwitchStateChange(view, switchState);
    }

    public void a(ArrayList<OfficialAccountPushInfo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
            this.f19861f = arrayList;
        }
    }

    public void b(BdSwitchView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f19862g = bVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList<OfficialAccountPushInfo> arrayList = this.f19861f;
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
            ArrayList<OfficialAccountPushInfo> arrayList = this.f19861f;
            if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
                return null;
            }
            return this.f19861f.get(i2);
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
        C1232a c1232a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f19860e.getPageActivity()).inflate(f.official_account_push_item, viewGroup, false);
                c1232a = new C1232a(this);
                c1232a.a = (MsgSettingItemView) view.findViewById(e.item_official_account_push);
                view.setTag(c1232a);
            } else {
                c1232a = (C1232a) view.getTag();
            }
            OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i2);
            if (m.isEmpty(officialAccountPushInfo.name)) {
                c1232a.a.setVisibility(8);
            } else {
                c1232a.a.setVisibility(0);
                c1232a.a.setText(officialAccountPushInfo.name);
                if (officialAccountPushInfo.is_on == 1) {
                    c1232a.a.getSwitchView().turnOnNoCallback();
                } else {
                    c1232a.a.getSwitchView().turnOffNoCallback();
                }
                c1232a.a.setLineVisibility(true);
                c1232a.a.onChangeSkinType(this.f19860e, TbadkCoreApplication.getInst().getSkinType());
                c1232a.a.getSwitchView().setOnSwitchStateChangeListener(this);
                c1232a.a.getSwitchView().setTag(officialAccountPushInfo);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
