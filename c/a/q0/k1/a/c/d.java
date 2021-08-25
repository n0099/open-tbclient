package c.a.q0.k1.a.c;

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
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.q0.k1.a.c.c;
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
/* loaded from: classes3.dex */
public class d extends c.a.e.a.d<InviteFriendListActivity> implements c.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final InviteFriendListActivity f21269e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f21270f;

    /* renamed from: g  reason: collision with root package name */
    public View f21271g;

    /* renamed from: h  reason: collision with root package name */
    public BdListView f21272h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.k1.a.c.c f21273i;

    /* renamed from: j  reason: collision with root package name */
    public NoDataView f21274j;
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

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f21275e;

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
            this.f21275e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(this.f21275e.f21269e.getPageContext().getPageActivity())));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements InviteFriendCandidateList.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f21276a;

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
            this.f21276a = dVar;
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
            View findViewWithTag = this.f21276a.f21272h.findViewWithTag(obj);
            if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                ((TbCheckBox) findViewWithTag).setChecked(false);
            } else if (obj instanceof c.a.p0.t.f.a) {
                this.f21276a.K((c.a.p0.t.f.a) obj);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f21277e;

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
            this.f21277e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f21277e.t != null && this.f21277e.t.getVisibility() == 0) {
                    this.f21277e.y();
                    return;
                }
                l.x(this.f21277e.f21269e.getPageContext().getPageActivity(), this.f21277e.v);
                this.f21277e.f21269e.finish();
            }
        }
    }

    /* renamed from: c.a.q0.k1.a.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0992d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f21278e;

        public View$OnClickListenerC0992d(d dVar) {
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
            this.f21278e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21278e.s.setVisibility(8);
                this.f21278e.u.setVisibility(8);
                this.f21278e.t.setVisibility(0);
                this.f21278e.v.requestFocus();
                l.K(this.f21278e.f21269e.getPageContext().getPageActivity(), this.f21278e.v);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f21279e;

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
            this.f21279e = dVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String charSequence2String;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (charSequence2String = k.charSequence2String(editable, null)) == null) {
                return;
            }
            if (charSequence2String.length() > 0) {
                this.f21279e.w.setVisibility(0);
            } else {
                this.f21279e.w.setVisibility(8);
            }
            this.f21279e.w();
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

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f21280e;

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
            this.f21280e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21280e.v.getText().clear();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f21281e;

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
            this.f21281e = dVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f21281e.x();
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class h implements TbCheckBox.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f21282a;

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
            this.f21282a = dVar;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.b
        public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{tbCheckBox, Boolean.valueOf(z), obj}) == null) {
                this.f21282a.x();
                if (obj == null || !(obj instanceof c.a.p0.t.f.a)) {
                    return;
                }
                if (z) {
                    if (this.f21282a.s() <= this.f21282a.m.getItemLength()) {
                        this.f21282a.f21269e.showToast(String.format(this.f21282a.f21269e.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(this.f21282a.q)));
                        tbCheckBox.setChecked(false);
                        ((c.a.p0.t.f.a) obj).setChecked(false);
                        return;
                    }
                    this.f21282a.o((c.a.p0.t.f.a) obj);
                    return;
                }
                this.f21282a.K((c.a.p0.t.f.a) obj);
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
                super((c.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = 0;
        this.f21269e = inviteFriendListActivity;
        this.r = z;
        A();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f21269e.setContentView(R.layout.invite_friend_list);
            this.f21271g = this.f21269e.findViewById(R.id.root_view);
            z();
            BdListView bdListView = (BdListView) this.f21271g.findViewById(R.id.friend_list);
            this.f21272h = bdListView;
            bdListView.setOnItemClickListener(this.f21269e);
            if (this.r) {
                this.f21274j = NoDataViewFactory.a(this.f21269e.getPageContext().getPageActivity(), this.f21271g, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.f48369a), NoDataViewFactory.e.b(R.string.no_friends, R.string.no_friends_tip), null);
            } else {
                this.f21274j = NoDataViewFactory.a(this.f21269e.getPageContext().getPageActivity(), this.f21271g, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.GIFT, BdListViewHelper.f48369a), NoDataViewFactory.e.b(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.c.a(new NoDataViewFactory.b(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new a(this))));
            }
            this.k = (ProgressBar) this.f21271g.findViewById(R.id.progress);
            InviteFriendCandidateList inviteFriendCandidateList = (InviteFriendCandidateList) this.f21271g.findViewById(R.id.candidate_list);
            this.m = inviteFriendCandidateList;
            inviteFriendCandidateList.n(new b(this));
            this.n = (LinearLayout) this.f21271g.findViewById(R.id.invite_candidate);
            this.l = this.f21271g.findViewById(R.id.invite_candidate_border);
            if (this.r) {
                this.n.setVisibility(8);
                this.l.setVisibility(8);
            }
            p();
            Button button = (Button) this.f21271g.findViewById(R.id.button_send);
            this.o = button;
            button.setOnClickListener(this.f21269e);
            q();
            O();
            L(0);
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

    public void J(List<c.a.p0.t.f.a> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, list, z) == null) {
            if (this.f21273i == null) {
                c.a.q0.k1.a.c.c cVar = new c.a.q0.k1.a.c.c(this.f21269e, this.r);
                this.f21273i = cVar;
                cVar.f(this);
                this.f21273i.d(new h(this));
                this.f21272h.setAdapter((ListAdapter) this.f21273i);
            }
            if (!z && list.isEmpty()) {
                this.f21274j.setVisibility(0);
                this.f21272h.setVisibility(8);
                if (this.r) {
                    return;
                }
                this.n.setVisibility(8);
                return;
            }
            this.f21274j.setVisibility(8);
            this.f21272h.setVisibility(0);
            this.f21273i.e(list);
            this.f21273i.notifyDataSetChanged();
            if (this.r) {
                return;
            }
            this.n.setVisibility(0);
        }
    }

    public void K(c.a.p0.t.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || aVar == null) {
            return;
        }
        this.m.l(aVar);
        L(this.m.getItemLength());
        P();
    }

    public final void L(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.o.setText(String.format(this.f21269e.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i2)));
        }
    }

    public void N(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.q = i2;
            this.m.setMaxCount(i2);
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f21272h.setOnTouchListener(new g(this));
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

    @Override // c.a.q0.k1.a.c.c.b
    public void b(View view, c.a.p0.t.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, view, aVar) == null) || aVar == null) {
            return;
        }
        this.m.h(aVar);
    }

    public void c() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (noDataView = this.f21274j) == null) {
            return;
        }
        noDataView.onActivityStart(this.f21269e.getPageContext());
    }

    public void d() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (noDataView = this.f21274j) == null) {
            return;
        }
        noDataView.onActivityStop();
    }

    public void o(c.a.p0.t.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) || aVar == null) {
            return;
        }
        this.m.e(aVar);
        L(this.m.getItemLength());
        P();
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            int dimensionPixelSize = this.f21269e.getResources().getDimensionPixelSize(R.dimen.ds80) + this.f21269e.getResources().getDimensionPixelSize(R.dimen.ds16) + this.f21269e.getResources().getDimensionPixelSize(R.dimen.ds16);
            View view = new View(this.f21269e.getPageContext().getPageActivity());
            this.p = view;
            view.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
            this.p.setEnabled(false);
            this.f21272h.addFooterView(this.p);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.f21269e.getLayoutMode().k(skinType == 1);
            this.f21269e.getLayoutMode().j(this.f21271g);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.y, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, null);
            this.f21270f.onChangeSkinType(this.f21269e.getPageContext(), skinType);
            this.f21274j.onChangeSkinType(this.f21269e.getPageContext(), skinType);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f21271g : (View) invokeV.objValue;
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
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (inviteFriendListActivity = this.f21269e) == null) {
            return;
        }
        inviteFriendListActivity.refreshWithCurrentData();
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            l.x(this.f21269e.getPageContext().getPageActivity(), this.v);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            l.x(this.f21269e.getPageContext().getPageActivity(), this.v);
            this.t.setVisibility(8);
            this.s.setVisibility(0);
            this.u.setVisibility(0);
            this.v.getText().clear();
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f21271g.findViewById(R.id.view_navigation_bar);
            this.f21270f = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
            if (this.r) {
                this.s = this.f21270f.setTitleText(R.string.invite_contact_title);
            } else {
                this.s = this.f21270f.setTitleText(R.string.invite_friend);
            }
            View addCustomView = this.f21270f.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View$OnClickListenerC0992d(this));
            this.u = addCustomView;
            this.y = (ImageView) addCustomView.findViewById(R.id.new_friend_search);
            View addCustomView2 = this.f21270f.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
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
