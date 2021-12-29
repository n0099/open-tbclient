package c.a.t0.s1.j;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.d;
import c.a.d.a.f;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.groupUpdates.UpdatesActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class c extends d<UpdatesActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public View f22759b;

    /* renamed from: c  reason: collision with root package name */
    public UpdatesActivity f22760c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f22761d;

    /* renamed from: e  reason: collision with root package name */
    public a f22762e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f22763f;

    /* renamed from: g  reason: collision with root package name */
    public Button f22764g;

    /* renamed from: h  reason: collision with root package name */
    public Button f22765h;

    /* renamed from: i  reason: collision with root package name */
    public Button f22766i;

    /* renamed from: j  reason: collision with root package name */
    public NavigationBar f22767j;

    /* renamed from: k  reason: collision with root package name */
    public View f22768k;
    public View l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {updatesActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22760c = updatesActivity;
        k();
        a aVar = new a(this.f22760c);
        this.f22762e = aVar;
        this.f22761d.setAdapter((ListAdapter) aVar);
        this.f22761d.setOnScrollListener(this.f22760c);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f22764g.setVisibility(0);
            this.f22759b.setVisibility(0);
            this.f22765h.setVisibility(8);
            this.f22768k.setVisibility(8);
            n(0);
            l();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f22764g.setVisibility(8);
            this.f22759b.setVisibility(8);
            this.f22765h.setVisibility(0);
            this.f22768k.setVisibility(0);
            l();
        }
    }

    @Override // c.a.d.a.d
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.destroy();
            a aVar = this.f22762e;
            if (aVar != null) {
                aVar.a();
                this.f22762e = null;
            }
            this.f22760c = null;
        }
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f22759b : (View) invokeV.objValue;
    }

    public Button f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f22765h : (Button) invokeV.objValue;
    }

    public Button g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f22766i : (Button) invokeV.objValue;
    }

    public Button h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f22764g : (Button) invokeV.objValue;
    }

    public a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f22762e : (a) invokeV.objValue;
    }

    public BdListView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f22761d : (BdListView) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            View inflate = View.inflate(this.f22760c.getPageContext().getPageActivity(), R.layout.updates_activity, null);
            this.a = inflate;
            this.f22760c.setContentView(inflate);
            NavigationBar navigationBar = (NavigationBar) this.f22760c.findViewById(R.id.view_navigation_bar);
            this.f22767j = navigationBar;
            this.f22759b = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f22767j.setTitleText(this.f22760c.getPageContext().getString(R.string.updates_activity_title));
            this.f22768k = this.f22767j.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
            this.l = this.f22767j.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
            Button button = (Button) this.f22768k.findViewById(R.id.btn_delete);
            this.f22766i = button;
            button.setOnClickListener(this.f22760c);
            this.f22759b.setOnClickListener(this.f22760c);
            this.f22761d = (BdListView) this.a.findViewById(R.id.updates_list);
            this.f22763f = (ProgressBar) this.a.findViewById(R.id.pro_load);
            Button button2 = (Button) this.l.findViewById(R.id.btn_edit);
            this.f22764g = button2;
            button2.setOnClickListener(this.f22760c);
            Button button3 = (Button) this.l.findViewById(R.id.btn_cancel);
            this.f22765h = button3;
            button3.setOnClickListener(this.f22760c);
            n(0);
            o(false);
        }
    }

    public void l() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (aVar = this.f22762e) == null) {
            return;
        }
        aVar.notifyDataSetChanged();
    }

    public void m(List<UpdatesItemData> list) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, list) == null) || (aVar = this.f22762e) == null) {
            return;
        }
        aVar.c(list);
    }

    public void n(int i2) {
        Button button;
        UpdatesActivity updatesActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (button = this.f22766i) == null || (updatesActivity = this.f22760c) == null) {
            return;
        }
        button.setText(String.format(updatesActivity.getPageContext().getString(R.string.del_count), Integer.valueOf(i2)));
        if (i2 == 0) {
            this.f22766i.setEnabled(false);
        } else {
            this.f22766i.setEnabled(true);
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f22763f.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f22760c.getLayoutMode().k(i2 == 1);
            this.f22760c.getLayoutMode().j(this.a);
            this.f22767j.onChangeSkinType(this.f22760c.getPageContext(), i2);
            SkinManager.setBackgroundResource(this.f22766i, R.drawable.btn_delete_groupupdates);
        }
    }
}
