package b.a.r0.y1.g;

import android.view.View;
import android.widget.ListAdapter;
import b.a.e.a.f;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberprivilege.MemberPrivilegeActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class d extends b.a.e.a.d<MemberPrivilegeActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public MemberPrivilegeActivity f29143a;

    /* renamed from: b  reason: collision with root package name */
    public View f29144b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f29145c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f29146d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f29147e;

    /* renamed from: f  reason: collision with root package name */
    public c f29148f;

    /* loaded from: classes6.dex */
    public class a implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f29149e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29149e = dVar;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                this.f29149e.f29143a.requestMemberPrivilegeData();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(MemberPrivilegeActivity memberPrivilegeActivity) {
        super(memberPrivilegeActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {memberPrivilegeActivity};
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
        this.f29143a = memberPrivilegeActivity;
        f();
    }

    public c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f29148f : (c) invokeV.objValue;
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f29144b : (View) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f29143a.setContentView(R.layout.memberprivilege_activity);
            View findViewById = this.f29143a.findViewById(R.id.root);
            this.f29144b = findViewById;
            NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.navigationbar);
            this.f29145c = navigationBar;
            navigationBar.setTitleText(R.string.member_center);
            this.f29145c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            NoNetworkView noNetworkView = (NoNetworkView) this.f29144b.findViewById(R.id.nonetworkview);
            this.f29146d = noNetworkView;
            noNetworkView.addNetworkChangeListener(new a(this));
            this.f29147e = (BdListView) this.f29144b.findViewById(R.id.listview);
            c cVar = new c(this.f29143a);
            this.f29148f = cVar;
            this.f29147e.setAdapter((ListAdapter) cVar);
            this.f29147e.setOnItemClickListener(this.f29143a);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f29143a.getLayoutMode().k(i2 == 1);
            this.f29143a.getLayoutMode().j(this.f29144b);
            this.f29145c.onChangeSkinType(this.f29143a.getPageContext(), i2);
            this.f29146d.onChangeSkinType(this.f29143a.getPageContext(), i2);
        }
    }
}
