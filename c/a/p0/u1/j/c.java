package c.a.p0.u1.j;

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
/* loaded from: classes2.dex */
public class c extends d<UpdatesActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public View f18818b;

    /* renamed from: c  reason: collision with root package name */
    public UpdatesActivity f18819c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f18820d;

    /* renamed from: e  reason: collision with root package name */
    public a f18821e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f18822f;

    /* renamed from: g  reason: collision with root package name */
    public Button f18823g;

    /* renamed from: h  reason: collision with root package name */
    public Button f18824h;
    public Button i;
    public NavigationBar j;
    public View k;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18819c = updatesActivity;
        m();
        a aVar = new a(this.f18819c);
        this.f18821e = aVar;
        this.f18820d.setAdapter((ListAdapter) aVar);
        this.f18820d.setOnScrollListener(this.f18819c);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f18823g.setVisibility(0);
            this.f18818b.setVisibility(0);
            this.f18824h.setVisibility(8);
            this.k.setVisibility(8);
            p(0);
            n();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f18823g.setVisibility(8);
            this.f18818b.setVisibility(8);
            this.f18824h.setVisibility(0);
            this.k.setVisibility(0);
            n();
        }
    }

    @Override // c.a.d.a.d
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.destroy();
            a aVar = this.f18821e;
            if (aVar != null) {
                aVar.a();
                this.f18821e = null;
            }
            this.f18819c = null;
        }
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f18818b : (View) invokeV.objValue;
    }

    public Button h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f18824h : (Button) invokeV.objValue;
    }

    public Button i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.i : (Button) invokeV.objValue;
    }

    public Button j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f18823g : (Button) invokeV.objValue;
    }

    public a k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f18821e : (a) invokeV.objValue;
    }

    public BdListView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f18820d : (BdListView) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            View inflate = View.inflate(this.f18819c.getPageContext().getPageActivity(), R.layout.obfuscated_res_0x7f0d085e, null);
            this.a = inflate;
            this.f18819c.setContentView(inflate);
            NavigationBar navigationBar = (NavigationBar) this.f18819c.findViewById(R.id.obfuscated_res_0x7f0923cf);
            this.j = navigationBar;
            this.f18818b = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.j.setTitleText(this.f18819c.getPageContext().getString(R.string.obfuscated_res_0x7f0f148d));
            this.k = this.j.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.obfuscated_res_0x7f0d085f, (View.OnClickListener) null);
            this.l = this.j.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d0860, (View.OnClickListener) null);
            Button button = (Button) this.k.findViewById(R.id.obfuscated_res_0x7f090411);
            this.i = button;
            button.setOnClickListener(this.f18819c);
            this.f18818b.setOnClickListener(this.f18819c);
            this.f18820d = (BdListView) this.a.findViewById(R.id.obfuscated_res_0x7f092287);
            this.f18822f = (ProgressBar) this.a.findViewById(R.id.obfuscated_res_0x7f091914);
            Button button2 = (Button) this.l.findViewById(R.id.obfuscated_res_0x7f090412);
            this.f18823g = button2;
            button2.setOnClickListener(this.f18819c);
            Button button3 = (Button) this.l.findViewById(R.id.obfuscated_res_0x7f090409);
            this.f18824h = button3;
            button3.setOnClickListener(this.f18819c);
            p(0);
            q(false);
        }
    }

    public void n() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (aVar = this.f18821e) == null) {
            return;
        }
        aVar.notifyDataSetChanged();
    }

    public void o(List<UpdatesItemData> list) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, list) == null) || (aVar = this.f18821e) == null) {
            return;
        }
        aVar.c(list);
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.f18819c.getLayoutMode().k(i == 1);
            this.f18819c.getLayoutMode().j(this.a);
            this.j.onChangeSkinType(this.f18819c.getPageContext(), i);
            SkinManager.setBackgroundResource(this.i, R.drawable.btn_delete_groupupdates);
        }
    }

    public void p(int i) {
        Button button;
        UpdatesActivity updatesActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i) == null) || (button = this.i) == null || (updatesActivity = this.f18819c) == null) {
            return;
        }
        button.setText(String.format(updatesActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0484), Integer.valueOf(i)));
        if (i == 0) {
            this.i.setEnabled(false);
        } else {
            this.i.setEnabled(true);
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f18822f.setVisibility(z ? 0 : 8);
        }
    }
}
