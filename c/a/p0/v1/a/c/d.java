package c.a.p0.v1.a.c;

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
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.p0.v1.a.c.c;
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
/* loaded from: classes2.dex */
public class d extends c.a.d.a.d<InviteFriendListActivity> implements c.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final InviteFriendListActivity a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f19073b;

    /* renamed from: c  reason: collision with root package name */
    public View f19074c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f19075d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.v1.a.c.c f19076e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f19077f;

    /* renamed from: g  reason: collision with root package name */
    public ProgressBar f19078g;

    /* renamed from: h  reason: collision with root package name */
    public View f19079h;
    public InviteFriendCandidateList i;
    public LinearLayout j;
    public Button k;
    public View l;
    public int m;
    public boolean n;
    public TextView o;
    public View p;
    public View q;
    public EditText r;
    public TextView s;
    public TextWatcher t;
    public ImageView u;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(this.a.a.getPageContext().getPageActivity())));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements InviteFriendCandidateList.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
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
            View findViewWithTag = this.a.f19075d.findViewWithTag(obj);
            if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                ((TbCheckBox) findViewWithTag).setChecked(false);
            } else if (obj instanceof c.a.o0.s.f.a) {
                this.a.G((c.a.o0.s.f.a) obj);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.p != null && this.a.p.getVisibility() == 0) {
                    this.a.A();
                    return;
                }
                n.w(this.a.a.getPageContext().getPageActivity(), this.a.r);
                this.a.a.finish();
            }
        }
    }

    /* renamed from: c.a.p0.v1.a.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1443d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public View$OnClickListenerC1443d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.o.setVisibility(8);
                this.a.q.setVisibility(8);
                this.a.p.setVisibility(0);
                this.a.r.requestFocus();
                n.L(this.a.a.getPageContext().getPageActivity(), this.a.r);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String charSequence2String;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (charSequence2String = m.charSequence2String(editable, null)) == null) {
                return;
            }
            if (charSequence2String.length() > 0) {
                this.a.s.setVisibility(0);
            } else {
                this.a.s.setVisibility(8);
            }
            this.a.y();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public f(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.r.getText().clear();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public g(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.a.z();
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class h implements TbCheckBox.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.b
        public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{tbCheckBox, Boolean.valueOf(z), obj}) == null) {
                this.a.z();
                if (obj == null || !(obj instanceof c.a.o0.s.f.a)) {
                    return;
                }
                if (z) {
                    if (this.a.u() <= this.a.i.getItemLength()) {
                        this.a.a.showToast(String.format(this.a.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0937), Integer.valueOf(this.a.m)));
                        tbCheckBox.setChecked(false);
                        ((c.a.o0.s.f.a) obj).setChecked(false);
                        return;
                    }
                    this.a.q((c.a.o0.s.f.a) obj);
                    return;
                }
                this.a.G((c.a.o0.s.f.a) obj);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = 0;
        this.a = inviteFriendListActivity;
        this.n = z;
        C();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            n.w(this.a.getPageContext().getPageActivity(), this.r);
            this.p.setVisibility(8);
            this.o.setVisibility(0);
            this.q.setVisibility(0);
            this.r.getText().clear();
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f19074c.findViewById(R.id.obfuscated_res_0x7f0923cf);
            this.f19073b = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
            if (this.n) {
                this.o = this.f19073b.setTitleText(R.string.obfuscated_res_0x7f0f0934);
            } else {
                this.o = this.f19073b.setTitleText(R.string.obfuscated_res_0x7f0f0935);
            }
            View addCustomView = this.f19073b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d007d, new View$OnClickListenerC1443d(this));
            this.q = addCustomView;
            this.u = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f091549);
            View addCustomView2 = this.f19073b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.obfuscated_res_0x7f0d05e5, (View.OnClickListener) null);
            this.p = addCustomView2;
            addCustomView2.setVisibility(8);
            EditText editText = (EditText) this.p.findViewById(R.id.obfuscated_res_0x7f090912);
            this.r = editText;
            if (editText.getParent() != null) {
                ((View) this.r.getParent()).setFocusable(true);
                ((View) this.r.getParent()).setFocusableInTouchMode(true);
            }
            e eVar = new e(this);
            this.t = eVar;
            this.r.addTextChangedListener(eVar);
            TextView textView = (TextView) this.p.findViewById(R.id.obfuscated_res_0x7f090913);
            this.s = textView;
            textView.setOnClickListener(new f(this));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.setContentView(R.layout.obfuscated_res_0x7f0d03f6);
            this.f19074c = this.a.findViewById(R.id.obfuscated_res_0x7f091aee);
            B();
            BdListView bdListView = (BdListView) this.f19074c.findViewById(R.id.obfuscated_res_0x7f090ab6);
            this.f19075d = bdListView;
            bdListView.setOnItemClickListener(this.a);
            if (this.n) {
                this.f19077f = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.f19074c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.a), NoDataViewFactory.e.b(R.string.obfuscated_res_0x7f0f0c3a, R.string.obfuscated_res_0x7f0f0c3b), null);
            } else {
                this.f19077f = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.f19074c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.GIFT, BdListViewHelper.a), NoDataViewFactory.e.b(R.string.obfuscated_res_0x7f0f0c29, R.string.obfuscated_res_0x7f0f0c2a), NoDataViewFactory.c.a(new NoDataViewFactory.b(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0610), new a(this))));
            }
            this.f19078g = (ProgressBar) this.f19074c.findViewById(R.id.obfuscated_res_0x7f091929);
            InviteFriendCandidateList inviteFriendCandidateList = (InviteFriendCandidateList) this.f19074c.findViewById(R.id.obfuscated_res_0x7f09049c);
            this.i = inviteFriendCandidateList;
            inviteFriendCandidateList.n(new b(this));
            this.j = (LinearLayout) this.f19074c.findViewById(R.id.obfuscated_res_0x7f090f53);
            this.f19079h = this.f19074c.findViewById(R.id.obfuscated_res_0x7f090f54);
            if (this.n) {
                this.j.setVisibility(8);
                this.f19079h.setVisibility(8);
            }
            r();
            Button button = (Button) this.f19074c.findViewById(R.id.obfuscated_res_0x7f09045f);
            this.k = button;
            button.setOnClickListener(this.a);
            s();
            K();
            H(0);
        }
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View view = this.p;
            return view != null && view.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.r.removeTextChangedListener(this.t);
        }
    }

    public void F(List<c.a.o0.s.f.a> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, list, z) == null) {
            if (this.f19076e == null) {
                c.a.p0.v1.a.c.c cVar = new c.a.p0.v1.a.c.c(this.a, this.n);
                this.f19076e = cVar;
                cVar.f(this);
                this.f19076e.d(new h(this));
                this.f19075d.setAdapter((ListAdapter) this.f19076e);
            }
            if (!z && list.isEmpty()) {
                this.f19077f.setVisibility(0);
                this.f19075d.setVisibility(8);
                if (this.n) {
                    return;
                }
                this.j.setVisibility(8);
                return;
            }
            this.f19077f.setVisibility(8);
            this.f19075d.setVisibility(0);
            this.f19076e.e(list);
            this.f19076e.notifyDataSetChanged();
            if (this.n) {
                return;
            }
            this.j.setVisibility(0);
        }
    }

    public void G(c.a.o0.s.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) || aVar == null) {
            return;
        }
        this.i.l(aVar);
        H(this.i.getItemLength());
        L();
    }

    public final void H(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.k.setText(String.format(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0936), Integer.valueOf(i)));
        }
    }

    public void I(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.m = i;
            this.i.setMaxCount(i);
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f19075d.setOnTouchListener(new g(this));
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.i.getItemLength() > 0) {
                this.k.setEnabled(true);
            } else {
                this.k.setEnabled(false);
            }
        }
    }

    @Override // c.a.p0.v1.a.c.c.b
    public void b(View view, c.a.o0.s.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, view, aVar) == null) || aVar == null) {
            return;
        }
        this.i.h(aVar);
    }

    public void c() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (noDataView = this.f19077f) == null) {
            return;
        }
        noDataView.d(this.a.getPageContext());
    }

    public void d() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (noDataView = this.f19077f) == null) {
            return;
        }
        noDataView.e();
    }

    public void q(c.a.o0.s.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) || aVar == null) {
            return;
        }
        this.i.e(aVar);
        H(this.i.getItemLength());
        L();
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070275) + this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be) + this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be);
            View view = new View(this.a.getPageContext().getPageActivity());
            this.l = view;
            view.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
            this.l.setEnabled(false);
            this.f19075d.addFooterView(this.l);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.a.getLayoutMode().k(skinType == 1);
            this.a.getLayoutMode().j(this.f19074c);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.u, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, null);
            this.f19073b.onChangeSkinType(this.a.getPageContext(), skinType);
            this.f19077f.f(this.a.getPageContext(), skinType);
            SkinManager.setBackgroundResource(this.l, R.drawable.invite_friend_list_item_bg_color);
            this.l.setEnabled(false);
        }
    }

    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.i.g() : (String) invokeV.objValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.m : invokeV.intValue;
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.k.getId() : invokeV.intValue;
    }

    public View w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f19074c : (View) invokeV.objValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            Editable text = this.r.getText();
            return text != null ? text.toString() : "";
        }
        return (String) invokeV.objValue;
    }

    public final void y() {
        InviteFriendListActivity inviteFriendListActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (inviteFriendListActivity = this.a) == null) {
            return;
        }
        inviteFriendListActivity.refreshWithCurrentData();
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            n.w(this.a.getPageContext().getPageActivity(), this.r);
        }
    }
}
