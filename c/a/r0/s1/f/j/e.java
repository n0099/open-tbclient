package c.a.r0.s1.f.j;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity;
import com.baidu.tieba.im.chat.officialBar.OfficialBarTipListAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class e extends c.a.d.a.d<OfficialBarTipActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdListView a;

    /* renamed from: b  reason: collision with root package name */
    public OfficialBarTipListAdapter f21742b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f21743c;

    /* renamed from: d  reason: collision with root package name */
    public NoDataView f21744d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f21745e;

    /* renamed from: f  reason: collision with root package name */
    public OfficialBarTipActivity f21746f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f21747g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21748h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f21749i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f21750j;
    public boolean k;
    public TextView l;
    public View m;
    public TextView n;
    public TextView o;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OfficialBarTipActivity f21751e;

        public a(e eVar, OfficialBarTipActivity officialBarTipActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, officialBarTipActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21751e = officialBarTipActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21751e.finish();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OfficialBarTipActivity f21752e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f21753f;

        public b(e eVar, OfficialBarTipActivity officialBarTipActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, officialBarTipActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21753f = eVar;
            this.f21752e = officialBarTipActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!this.f21753f.f21748h) {
                    if (this.f21753f.f21746f.hasNoRead()) {
                        this.f21753f.n.setVisibility(0);
                    }
                    this.f21753f.n(this.f21752e, true);
                    return;
                }
                this.f21753f.n(this.f21752e, false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OfficialBarTipActivity f21754e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f21755f;

        public c(e eVar, OfficialBarTipActivity officialBarTipActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, officialBarTipActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21755f = eVar;
            this.f21754e = officialBarTipActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21754e.deleteSelectedDatas();
                this.f21755f.n(this.f21754e, false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f21756e;

        public d(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21756e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!this.f21756e.k) {
                    this.f21756e.p(true);
                } else {
                    this.f21756e.p(false);
                }
            }
        }
    }

    /* renamed from: c.a.r0.s1.f.j.e$e  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1355e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OfficialBarTipActivity f21757e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f21758f;

        public View$OnClickListenerC1355e(e eVar, OfficialBarTipActivity officialBarTipActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, officialBarTipActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21758f = eVar;
            this.f21757e = officialBarTipActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21758f.f21746f.setAllRead();
                this.f21758f.n(this.f21757e, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {officialBarTipActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21748h = false;
        this.f21749i = null;
        this.k = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.f21746f = officialBarTipActivity;
        k(officialBarTipActivity);
        l(officialBarTipActivity);
        j(officialBarTipActivity);
    }

    public OfficialBarTipListAdapter h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21742b : (OfficialBarTipListAdapter) invokeV.objValue;
    }

    public BdListView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (BdListView) invokeV.objValue;
    }

    public final void j(OfficialBarTipActivity officialBarTipActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, officialBarTipActivity) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
            this.f21749i = relativeLayout;
            TextView textView = (TextView) relativeLayout.findViewById(R.id.delete_txt);
            this.l = textView;
            textView.setOnClickListener(new c(this, officialBarTipActivity));
            this.f21750j = (TextView) this.f21749i.findViewById(R.id.select_all_txt);
            int f2 = n.f(this.f21746f.getPageContext().getPageActivity(), R.dimen.ds40);
            Drawable drawable = SkinManager.getDrawable(R.drawable.btn_bgb_choice_n);
            drawable.setBounds(0, 0, f2, f2);
            this.f21750j.setText(this.f21746f.getPageContext().getString(R.string.select_all));
            this.f21750j.setCompoundDrawables(drawable, null, null, null);
            this.f21750j.setOnClickListener(new d(this));
        }
    }

    public final void k(OfficialBarTipActivity officialBarTipActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, officialBarTipActivity) == null) {
            NavigationBar navigationBar = (NavigationBar) officialBarTipActivity.findViewById(R.id.view_navigation_bar);
            this.f21743c = navigationBar;
            navigationBar.setCenterTextTitle(officialBarTipActivity.getPageContext().getString(R.string.subscribe_forum_list));
            this.f21743c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this, officialBarTipActivity));
            this.f21743c.showBottomLine();
            ViewGroup viewGroup = (ViewGroup) officialBarTipActivity.findViewById(R.id.root_view);
            this.f21747g = viewGroup;
            this.f21745e = (NoNetworkView) viewGroup.findViewById(R.id.no_network_view);
            View inflate = LayoutInflater.from(this.f21746f.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
            this.m = inflate;
            inflate.setVisibility(8);
            TextView textView = (TextView) this.m.findViewById(R.id.all_read);
            this.n = textView;
            textView.setVisibility(8);
            TextView textView2 = (TextView) this.m.findViewById(R.id.edit);
            this.o = textView2;
            textView2.setVisibility(0);
            this.m = this.f21743c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.m, (View.OnClickListener) null);
            this.o.setOnClickListener(new b(this, officialBarTipActivity));
        }
    }

    public final void l(OfficialBarTipActivity officialBarTipActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, officialBarTipActivity) == null) {
            this.a = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
            OfficialBarTipListAdapter officialBarTipListAdapter = new OfficialBarTipListAdapter(officialBarTipActivity);
            this.f21742b = officialBarTipListAdapter;
            this.a.setAdapter((ListAdapter) officialBarTipListAdapter);
            this.f21744d = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.f21747g, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.a(R.string.official_message_activity_no_data), null);
        }
    }

    public void m(List<ImMessageCenterShowItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f21742b.n(list);
            if (list == null || list.size() > 0) {
                return;
            }
            this.o.setVisibility(8);
        }
    }

    public final void n(OfficialBarTipActivity officialBarTipActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, officialBarTipActivity, z) == null) {
            if (z) {
                this.f21749i.setVisibility(0);
                this.f21742b.o(true);
                this.f21742b.notifyDataSetChanged();
                if (officialBarTipActivity.hasSelectedData()) {
                    o(true);
                } else {
                    o(false);
                }
                this.o.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
                this.n.setOnClickListener(new View$OnClickListenerC1355e(this, officialBarTipActivity));
                this.f21748h = true;
                return;
            }
            this.f21749i.setVisibility(8);
            this.n.setVisibility(8);
            this.f21742b.o(false);
            this.f21742b.notifyDataSetChanged();
            this.o.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
            this.f21748h = false;
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                this.l.setAlpha(1.0f);
                this.l.setEnabled(true);
                return;
            }
            this.l.setAlpha(0.3f);
            this.l.setEnabled(false);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f21746f.getLayoutMode().k(i2 == 1);
            this.f21746f.getLayoutMode().j(this.f21747g);
            this.f21743c.onChangeSkinType(this.f21746f.getPageContext(), i2);
            SkinManager.setNavbarTitleColor(this.o, R.color.navi_op_text, R.color.navi_op_text_skin);
            SkinManager.setNavbarTitleColor(this.n, R.color.navi_op_text, R.color.navi_op_text_skin);
            NoDataView noDataView = this.f21744d;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.f21746f.getPageContext(), i2);
            }
            NoNetworkView noNetworkView = this.f21745e;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.f21746f.getPageContext(), i2);
            }
            this.f21742b.notifyDataSetChanged();
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            int f2 = n.f(this.f21746f.getPageContext().getPageActivity(), R.dimen.ds40);
            if (z) {
                Drawable drawable = SkinManager.getDrawable(R.drawable.btn_bgb_choice_s);
                drawable.setBounds(0, 0, f2, f2);
                this.f21750j.setText(this.f21746f.getPageContext().getString(R.string.cancel_select_all));
                this.f21750j.setCompoundDrawables(drawable, null, null, null);
                o(true);
                this.k = true;
                this.f21746f.updateEditStatus(true);
                return;
            }
            Drawable drawable2 = SkinManager.getDrawable(R.drawable.btn_bgb_choice_n);
            drawable2.setBounds(0, 0, f2, f2);
            this.f21750j.setText(this.f21746f.getPageContext().getString(R.string.select_all));
            this.f21750j.setCompoundDrawables(drawable2, null, null, null);
            o(false);
            this.k = false;
            this.f21746f.updateEditStatus(false);
        }
    }
}
