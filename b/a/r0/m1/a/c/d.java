package b.a.r0.m1.a.c;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.k;
import b.a.e.e.p.l;
import b.a.r0.m1.a.c.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends b.a.e.a.d<InviteFriendListActivity> implements c.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final InviteFriendListActivity f20958e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f20959f;

    /* renamed from: g  reason: collision with root package name */
    public View f20960g;

    /* renamed from: h  reason: collision with root package name */
    public BdListView f20961h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.r0.m1.a.c.c f20962i;
    public NoDataView j;
    public ProgressBar k;
    public View l;
    public InviteFriendCandidateList m;
    public LinearLayout n;
    public Button o;
    public View p;
    public int q;
    public boolean r;
    public TextView s;
    public View t;
    public View u;
    public EditText v;
    public TextView w;
    public TextWatcher x;
    public ImageView y;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f20963e;

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
            this.f20963e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(this.f20963e.f20958e.getPageContext().getPageActivity())));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements InviteFriendCandidateList.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f20964a;

        public b(d dVar) {
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
            this.f20964a = dVar;
        }

        @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.b
        public void a(View view, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, obj) == null) || obj == null) {
                return;
            }
            if (obj instanceof TbCheckBox.c) {
                ((TbCheckBox.c) obj).setChecked(false);
            }
            View findViewWithTag = this.f20964a.f20961h.findViewWithTag(obj);
            if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                ((TbCheckBox) findViewWithTag).setChecked(false);
            } else if (obj instanceof b.a.q0.t.f.a) {
                this.f20964a.J((b.a.q0.t.f.a) obj);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f20965e;

        public c(d dVar) {
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
            this.f20965e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f20965e.t != null && this.f20965e.t.getVisibility() == 0) {
                    this.f20965e.y();
                    return;
                }
                l.x(this.f20965e.f20958e.getPageContext().getPageActivity(), this.f20965e.v);
                this.f20965e.f20958e.finish();
            }
        }
    }

    /* renamed from: b.a.r0.m1.a.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1028d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f20966e;

        public View$OnClickListenerC1028d(d dVar) {
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
            this.f20966e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20966e.s.setVisibility(8);
                this.f20966e.u.setVisibility(8);
                this.f20966e.t.setVisibility(0);
                this.f20966e.v.requestFocus();
                l.K(this.f20966e.f20958e.getPageContext().getPageActivity(), this.f20966e.v);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f20967e;

        public e(d dVar) {
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
            this.f20967e = dVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String charSequence2String;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (charSequence2String = k.charSequence2String(editable, null)) == null) {
                return;
            }
            if (charSequence2String.length() > 0) {
                this.f20967e.w.setVisibility(0);
            } else {
                this.f20967e.w.setVisibility(8);
            }
            this.f20967e.w();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f20968e;

        public f(d dVar) {
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
            this.f20968e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20968e.v.getText().clear();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f20969e;

        public g(d dVar) {
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
            this.f20969e = dVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f20969e.x();
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class h implements TbCheckBox.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f20970a;

        public h(d dVar) {
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
            this.f20970a = dVar;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.b
        public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{tbCheckBox, Boolean.valueOf(z), obj}) == null) {
                this.f20970a.x();
                if (obj == null || !(obj instanceof b.a.q0.t.f.a)) {
                    return;
                }
                if (z) {
                    if (this.f20970a.s() <= this.f20970a.m.getItemLength()) {
                        this.f20970a.f20958e.showToast(String.format(this.f20970a.f20958e.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(this.f20970a.q)));
                        tbCheckBox.setChecked(false);
                        ((b.a.q0.t.f.a) obj).setChecked(false);
                        return;
                    }
                    this.f20970a.o((b.a.q0.t.f.a) obj);
                    return;
                }
                this.f20970a.J((b.a.q0.t.f.a) obj);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inviteFriendListActivity, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = 0;
        this.f20958e = inviteFriendListActivity;
        this.r = z;
        A();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f20958e.setContentView(R.layout.invite_friend_list);
            this.f20960g = this.f20958e.findViewById(R.id.root_view);
            z();
            BdListView bdListView = (BdListView) this.f20960g.findViewById(R.id.friend_list);
            this.f20961h = bdListView;
            bdListView.setOnItemClickListener(this.f20958e);
            if (this.r) {
                this.j = NoDataViewFactory.a(this.f20958e.getPageContext().getPageActivity(), this.f20960g, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.f46057a), NoDataViewFactory.e.b(R.string.no_friends, R.string.no_friends_tip), null);
            } else {
                this.j = NoDataViewFactory.a(this.f20958e.getPageContext().getPageActivity(), this.f20960g, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.GIFT, BdListViewHelper.f46057a), NoDataViewFactory.e.b(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.c.a(new NoDataViewFactory.b(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new a(this))));
            }
            this.k = (ProgressBar) this.f20960g.findViewById(R.id.progress);
            InviteFriendCandidateList inviteFriendCandidateList = (InviteFriendCandidateList) this.f20960g.findViewById(R.id.candidate_list);
            this.m = inviteFriendCandidateList;
            inviteFriendCandidateList.n(new b(this));
            this.n = (LinearLayout) this.f20960g.findViewById(R.id.invite_candidate);
            this.l = this.f20960g.findViewById(R.id.invite_candidate_border);
            if (this.r) {
                this.n.setVisibility(8);
                this.l.setVisibility(8);
            }
            p();
            Button button = (Button) this.f20960g.findViewById(R.id.button_send);
            this.o = button;
            button.setOnClickListener(this.f20958e);
            q();
            O();
            K(0);
        }
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View view = this.t;
            return view != null && view.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.v.removeTextChangedListener(this.x);
        }
    }

    public void I(List<b.a.q0.t.f.a> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, list, z) == null) {
            if (this.f20962i == null) {
                b.a.r0.m1.a.c.c cVar = new b.a.r0.m1.a.c.c(this.f20958e, this.r);
                this.f20962i = cVar;
                cVar.f(this);
                this.f20962i.d(new h(this));
                this.f20961h.setAdapter((ListAdapter) this.f20962i);
            }
            if (!z && list.isEmpty()) {
                this.j.setVisibility(0);
                this.f20961h.setVisibility(8);
                if (this.r) {
                    return;
                }
                this.n.setVisibility(8);
                return;
            }
            this.j.setVisibility(8);
            this.f20961h.setVisibility(0);
            this.f20962i.e(list);
            this.f20962i.notifyDataSetChanged();
            if (this.r) {
                return;
            }
            this.n.setVisibility(0);
        }
    }

    public void J(b.a.q0.t.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || aVar == null) {
            return;
        }
        this.m.l(aVar);
        K(this.m.getItemLength());
        P();
    }

    public final void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.o.setText(String.format(this.f20958e.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i2)));
        }
    }

    public void M(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.q = i2;
            this.m.setMaxCount(i2);
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f20961h.setOnTouchListener(new g(this));
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.m.getItemLength() > 0) {
                this.o.setEnabled(true);
            } else {
                this.o.setEnabled(false);
            }
        }
    }

    @Override // b.a.r0.m1.a.c.c.b
    public void b(View view, b.a.q0.t.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, view, aVar) == null) || aVar == null) {
            return;
        }
        this.m.h(aVar);
    }

    public void c() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (noDataView = this.j) == null) {
            return;
        }
        noDataView.onActivityStart(this.f20958e.getPageContext());
    }

    public void d() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (noDataView = this.j) == null) {
            return;
        }
        noDataView.onActivityStop();
    }

    public void o(b.a.q0.t.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) || aVar == null) {
            return;
        }
        this.m.e(aVar);
        K(this.m.getItemLength());
        P();
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            int dimensionPixelSize = this.f20958e.getResources().getDimensionPixelSize(R.dimen.ds80) + this.f20958e.getResources().getDimensionPixelSize(R.dimen.ds16) + this.f20958e.getResources().getDimensionPixelSize(R.dimen.ds16);
            View view = new View(this.f20958e.getPageContext().getPageActivity());
            this.p = view;
            view.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
            this.p.setEnabled(false);
            this.f20961h.addFooterView(this.p);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.f20958e.getLayoutMode().k(skinType == 1);
            this.f20958e.getLayoutMode().j(this.f20960g);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.y, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, null);
            this.f20959f.onChangeSkinType(this.f20958e.getPageContext(), skinType);
            this.j.onChangeSkinType(this.f20958e.getPageContext(), skinType);
            SkinManager.setBackgroundResource(this.p, R.drawable.invite_friend_list_item_bg_color);
            this.p.setEnabled(false);
        }
    }

    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.m.g() : (String) invokeV.objValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.q : invokeV.intValue;
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.o.getId() : invokeV.intValue;
    }

    public View u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f20960g : (View) invokeV.objValue;
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            Editable text = this.v.getText();
            return text != null ? text.toString() : "";
        }
        return (String) invokeV.objValue;
    }

    public final void w() {
        InviteFriendListActivity inviteFriendListActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (inviteFriendListActivity = this.f20958e) == null) {
            return;
        }
        inviteFriendListActivity.refreshWithCurrentData();
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            l.x(this.f20958e.getPageContext().getPageActivity(), this.v);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            l.x(this.f20958e.getPageContext().getPageActivity(), this.v);
            this.t.setVisibility(8);
            this.s.setVisibility(0);
            this.u.setVisibility(0);
            this.v.getText().clear();
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f20960g.findViewById(R.id.view_navigation_bar);
            this.f20959f = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
            if (this.r) {
                this.s = this.f20959f.setTitleText(R.string.invite_contact_title);
            } else {
                this.s = this.f20959f.setTitleText(R.string.invite_friend);
            }
            View addCustomView = this.f20959f.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View$OnClickListenerC1028d(this));
            this.u = addCustomView;
            this.y = (ImageView) addCustomView.findViewById(R.id.new_friend_search);
            View addCustomView2 = this.f20959f.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
            this.t = addCustomView2;
            addCustomView2.setVisibility(8);
            EditText editText = (EditText) this.t.findViewById(R.id.search_bar_edit);
            this.v = editText;
            if (editText.getParent() != null) {
                ((View) this.v.getParent()).setFocusable(true);
                ((View) this.v.getParent()).setFocusableInTouchMode(true);
            }
            e eVar = new e(this);
            this.x = eVar;
            this.v.addTextChangedListener(eVar);
            TextView textView = (TextView) this.t.findViewById(R.id.search_bar_delete_button);
            this.w = textView;
            textView.setOnClickListener(new f(this));
        }
    }
}
