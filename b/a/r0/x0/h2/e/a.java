package b.a.r0.x0.h2.e;

import android.graphics.Rect;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.l;
import b.a.e.m.e.n;
import b.a.q0.c1.m0;
import b.a.q0.s.s.a;
import b.a.r0.k2.s.c;
import b.a.r0.x0.h2.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity;
import com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsGameSubPbActivity f27387a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f27388b;

    /* renamed from: c  reason: collision with root package name */
    public View f27389c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.x0.h2.d.e f27390d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f27391e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f27392f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f27393g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f27394h;

    /* renamed from: i  reason: collision with root package name */
    public EditText f27395i;
    public TextView j;
    public TextView k;
    public TextView l;
    public ProgressBar m;
    public View n;
    public b.a.r0.x0.h2.c o;
    public b.a.r0.x0.h2.b p;
    public View.OnClickListener q;
    public ViewTreeObserver.OnGlobalLayoutListener r;
    public b.a.r0.x0.h2.d.b s;
    public List<n> t;
    public String u;
    public String v;
    public long w;
    public boolean x;
    public boolean y;
    public b.a.r0.k2.s.c z;

    /* renamed from: b.a.r0.x0.h2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC1345a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27396e;

        public RunnableC1345a(a aVar) {
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
                    return;
                }
            }
            this.f27396e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27396e.f27395i.requestFocus();
                l.x(this.f27396e.f27387a.getPageContext().getPageActivity(), this.f27396e.f27395i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27397e;

        public b(a aVar) {
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
                    return;
                }
            }
            this.f27397e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27397e.f27395i.requestFocus();
                l.K(this.f27397e.f27387a.getPageContext().getPageActivity(), this.f27397e.f27395i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f27398a;

        public c(a aVar) {
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
                    return;
                }
            }
            this.f27398a = aVar;
        }

        @Override // b.a.r0.k2.s.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // b.a.r0.k2.s.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // b.a.r0.k2.s.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                this.f27398a.s(false);
                this.f27398a.N(view);
                this.f27398a.s(true);
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27399e;

        public d(a aVar) {
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
                    return;
                }
            }
            this.f27399e = aVar;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) || i2 == 0) {
                return;
            }
            l.x(this.f27399e.f27387a.getPageContext().getPageActivity(), this.f27399e.f27395i);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27400e;

        public e(a aVar) {
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
                    return;
                }
            }
            this.f27400e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                a aVar = this.f27400e;
                aVar.p(aVar.f27395i.getText().toString());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements a.InterfaceC1342a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f27401a;

        public f(a aVar) {
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
                    return;
                }
            }
            this.f27401a = aVar;
        }

        @Override // b.a.r0.x0.h2.a.InterfaceC1342a
        public void a(b.a.r0.x0.h2.d.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) || dVar == null) {
                return;
            }
            this.f27401a.M(dVar);
        }

        @Override // b.a.r0.x0.h2.a.InterfaceC1342a
        public void b(b.a.r0.x0.h2.d.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f27401a.f27387a.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.f27384g).longValue(), String.valueOf(this.f27401a.w).equals(dVar.f27384g), false)));
            }
        }

        @Override // b.a.r0.x0.h2.a.InterfaceC1342a
        public void c(b.a.r0.x0.h2.d.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
                if (this.f27401a.o != null) {
                    this.f27401a.o.i();
                }
                if (dVar == null) {
                    this.f27401a.t(null);
                    this.f27401a.J();
                    return;
                }
                this.f27401a.t(dVar.f27385h);
                this.f27401a.v = dVar.f27384g;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27402e;

        public g(a aVar) {
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
                    return;
                }
            }
            this.f27402e = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                this.f27402e.f27387a.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int r = l.r(this.f27402e.f27387a.getPageContext().getPageActivity());
                int[] p = l.p(this.f27402e.f27387a.getPageContext().getPageActivity());
                if (p[1] - rect.bottom > p[1] / 4 && !this.f27402e.x) {
                    this.f27402e.x = true;
                    this.f27402e.F(true);
                } else if (p[1] - rect.height() == r && this.f27402e.x) {
                    this.f27402e.x = false;
                    this.f27402e.F(false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f27403e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.x0.h2.d.d f27404f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f27405g;

        public h(a aVar, b.a.q0.s.s.a aVar2, b.a.r0.x0.h2.d.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27405g = aVar;
            this.f27403e = aVar2;
            this.f27404f = dVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f27403e.dismiss();
                this.f27405g.r(this.f27404f);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f27406e;

        public i(a aVar, b.a.q0.s.s.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27406e = aVar2;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f27406e.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f27407e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f27408f;

        public j(a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27408f = aVar;
            this.f27407e = i2;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            }
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
                if (!TextUtils.isEmpty(charSequence)) {
                    this.f27408f.j.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (StringUtils.isNull(charSequence2)) {
                        return;
                    }
                    int b2 = m0.b(charSequence2);
                    int i5 = this.f27407e;
                    if (b2 > i5) {
                        String j = m0.j(charSequence2, 0, i5 - 1);
                        this.f27408f.f27395i.setText(j);
                        this.f27408f.f27395i.setSelection(this.f27408f.f27395i.getText().length());
                        UtilHelper.showToast(this.f27408f.f27387a.getPageContext().getPageActivity().getApplication(), this.f27408f.f27387a.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(j.length())));
                        return;
                    }
                    return;
                }
                this.f27408f.J();
                this.f27408f.j.setEnabled(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f27409e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f27410f;

        public k(a aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27410f = aVar;
            this.f27409e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27410f.f27391e.setEnabled(this.f27409e);
            }
        }
    }

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsGameSubPbActivity, onClickListener, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.z = new b.a.r0.k2.s.c(new c(this));
        this.f27387a = frsGameSubPbActivity;
        this.q = onClickListener;
        this.u = str;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.f27388b = relativeLayout;
        BdTypeListView bdTypeListView = (BdTypeListView) relativeLayout.findViewById(R.id.new_sub_pb_list);
        this.f27391e = bdTypeListView;
        bdTypeListView.setOnTouchListener(this.z);
        this.f27391e.setOnScrollListener(new d(this));
        this.f27390d = new b.a.r0.x0.h2.d.e(this.f27387a.getPageContext());
        this.f27389c = BdListViewHelper.d(this.f27387a.getActivity(), this.f27391e, BdListViewHelper.HeadType.DEFAULT);
        TextView textView = (TextView) this.f27388b.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.k = textView;
        textView.setOnClickListener(this.q);
        this.l = (TextView) this.f27388b.findViewById(R.id.no_reply_list_view);
        this.f27393g = (FrameLayout) this.f27388b.findViewById(R.id.bottom_view);
        this.f27394h = (LinearLayout) this.f27388b.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.f27395i = (EditText) this.f27388b.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        TextView textView2 = (TextView) this.f27388b.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.j = textView2;
        textView2.setOnClickListener(new e(this));
        this.m = (ProgressBar) this.f27388b.findViewById(R.id.progressBar);
        C();
        b.a.r0.x0.h2.b bVar = new b.a.r0.x0.h2.b(this.f27387a.getPageContext(), this.f27391e);
        this.p = bVar;
        bVar.b(new f(this));
        K(PbFullScreenEditorActivity.REPLY_MAX_SIZE);
        B();
        D(TbadkCoreApplication.getInst().getSkinType());
        this.t = new ArrayList();
        this.w = b.a.e.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public void A(boolean z, String str, b.a.r0.x0.h2.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, dVar}) == null) {
            if (z) {
                BdToast.d(this.f27387a.getPageContext().getPageActivity(), this.f27387a.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).q();
                this.t.remove(dVar);
                this.p.c(this.t);
                G(this.y);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                str = this.f27387a.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
            }
            BdToast.d(this.f27387a.getPageContext().getPageActivity(), str, 1).q();
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.r = new g(this);
            this.f27387a.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.r);
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f27388b.findViewById(R.id.view_navigation_bar);
            this.f27392f = navigationBar;
            this.n = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            ImageView backImageView = this.f27392f.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
                int g2 = l.g(this.f27387a.getPageContext().getPageActivity(), R.dimen.ds30);
                layoutParams.height = g2;
                layoutParams.width = g2;
                backImageView.setLayoutParams(layoutParams);
            }
            View view = this.n;
            if (view != null && (view.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.n.getLayoutParams();
                layoutParams2.width = -2;
                layoutParams2.height = -1;
                this.n.setPadding(l.g(this.f27387a.getPageContext().getPageActivity(), R.dimen.ds32), this.n.getPaddingTop(), this.n.getPaddingRight(), this.n.getPaddingBottom());
                this.n.setLayoutParams(layoutParams2);
            }
            if (this.f27392f.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f27392f.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public void D(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f27387a.getLayoutMode().k(i2 == 1);
            this.f27387a.getLayoutMode().j(this.f27388b);
            SkinManager.setBackgroundColor(this.f27388b, R.color.CAM_X0201);
            this.f27392f.onChangeSkinType(this.f27387a.getPageContext(), i2);
            this.f27390d.d(i2);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0110);
            this.k.setAlpha(0.95f);
            SkinManager.setBackgroundResource(this.k, R.drawable.pb_ecomm_comment_bg);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0109);
            SkinManager.setBackgroundResource(this.f27394h, R.drawable.pb_ecomm_comment_bg);
            SkinManager.setViewTextColor(this.f27395i, R.color.CAM_X0106);
            this.f27395i.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            SkinManager.setViewTextColor(this.j, R.color.game_sub_pb_send_txt_color);
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.r == null) {
            return;
        }
        this.f27387a.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.r);
    }

    public final void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                Rect rect = new Rect();
                this.f27394h.getWindowVisibleDisplayFrame(rect);
                int e2 = (l.p(this.f27387a.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.e(this.f27387a.getPageContext().getPageActivity(), 48.0f) : 0);
                FrameLayout frameLayout = this.f27393g;
                frameLayout.scrollTo(frameLayout.getScrollX(), e2);
                return;
            }
            this.f27393g.setScrollY(0);
        }
    }

    public final void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (ListUtils.isEmpty(this.t)) {
                this.f27391e.setNextPage(null);
                this.l.setVisibility(0);
            } else {
                this.f27391e.setNextPage(this.f27390d);
                this.l.setVisibility(8);
                if (z) {
                    this.f27390d.Q();
                } else {
                    this.f27390d.f();
                }
            }
            L();
        }
    }

    public void H(b.a.r0.x0.h2.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            this.o = cVar;
        }
    }

    public void I(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pVar) == null) {
            this.f27391e.setOnSrollToBottomListener(pVar);
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            b.a.r0.x0.h2.d.b bVar = this.s;
            this.v = bVar != null ? bVar.f27377e : null;
        }
    }

    public final void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f27395i.addTextChangedListener(new j(this, i2));
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (!ListUtils.isEmpty(this.t)) {
                this.f27392f.setCenterTextTitle(String.format(this.f27387a.getResources().getString(R.string.subpb_floor_reply_count), StringHelper.numFormatOver10000(this.t.size())));
            } else {
                this.f27392f.setCenterTextTitle(this.f27387a.getResources().getString(R.string.reply));
            }
        }
    }

    public final void M(b.a.r0.x0.h2.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dVar) == null) {
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f27387a.getPageContext().getPageActivity());
            aVar.setTitle((String) null);
            aVar.setMessageId(R.string.del_all_post_confirm);
            aVar.setCanceledOnTouchOutside(true);
            aVar.setPositiveButton(R.string.dialog_ok, new h(this, aVar, dVar));
            aVar.setNegativeButton(R.string.dialog_cancel, new i(this, aVar));
            aVar.create(this.f27387a.getPageContext()).show();
        }
    }

    public void N(View view) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, view) == null) || this.f27389c == null || (navigationBar = this.f27392f) == null) {
            return;
        }
        if (navigationBar.isNavigationBarExcludeStatusbarVisible()) {
            this.f27392f.showNavigationBarExcludeStatusbar(false);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.f27389c.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
            } else {
                BdTypeListView bdTypeListView = this.f27391e;
                if (bdTypeListView != null) {
                    bdTypeListView.removeHeaderView(this.f27389c);
                }
            }
            this.f27392f.setVisibility(8);
            return;
        }
        this.f27392f.showNavigationBarExcludeStatusbar(true);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.f27389c.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f27387a.getActivity(), R.dimen.ds98)));
        } else {
            BdTypeListView bdTypeListView2 = this.f27391e;
            if (bdTypeListView2 != null) {
                bdTypeListView2.addHeaderView(this.f27389c, 0);
            }
        }
        this.f27392f.setVisibility(0);
    }

    public void O(boolean z, b.a.r0.x0.h2.d.b bVar, List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), bVar, list}) == null) {
            this.y = z;
            this.s = bVar;
            J();
            if (ListUtils.isEmpty(list)) {
                G(z);
                return;
            }
            this.t.clear();
            this.t.addAll(list);
            this.l.setVisibility(8);
            this.f27391e.setNextPage(this.f27390d);
            this.p.c(list);
            q();
            this.k.setVisibility(0);
            this.k.setText(R.string.say_your_point);
            G(z);
        }
    }

    public void P(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (view = this.f27389c) == null || view.getLayoutParams() == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f27389c.getLayoutParams();
        if (z) {
            q();
            layoutParams.height = l.g(this.f27387a.getPageContext().getPageActivity(), R.dimen.ds98);
        } else {
            layoutParams.height = l.g(this.f27387a.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
        }
        this.f27389c.setLayoutParams(layoutParams);
    }

    public void Q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.m.setVisibility(i2);
        }
    }

    public final void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            Q(0);
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_SUB_COMMENT);
            httpMessage.addParam("user_id", this.w);
            httpMessage.addParam("reply_user_id", this.v);
            httpMessage.addParam("content", str);
            httpMessage.addParam("main_tower_id", this.u);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.f27392f.getBackImageView() == null) {
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f27392f.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public final void r(b.a.r0.x0.h2.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, dVar) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_SUB_COMMENT);
            httpMessage.addParam("user_id", this.w);
            httpMessage.addParam("main_tower_id", dVar.f27383f);
            httpMessage.addParam("id", dVar.f27382e);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void s(boolean z) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (bdTypeListView = this.f27391e) == null) {
            return;
        }
        if (!z) {
            bdTypeListView.setEnabled(z);
        } else {
            bdTypeListView.postDelayed(new k(this, z), 10L);
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.k.setVisibility(8);
            this.f27394h.setVisibility(0);
            this.f27395i.post(new b(this));
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String format = String.format(this.f27387a.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.f27395i.setText(format);
            this.f27395i.setSelection(format.length());
        }
    }

    public ListView u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f27391e : (ListView) invokeV.objValue;
    }

    public NavigationBar v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f27392f : (NavigationBar) invokeV.objValue;
    }

    public TextView w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.k : (TextView) invokeV.objValue;
    }

    public View x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f27388b : (View) invokeV.objValue;
    }

    public View y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f27389c : (View) invokeV.objValue;
    }

    public void z(boolean z, String str, b.a.r0.x0.h2.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Boolean.valueOf(z), str, dVar}) == null) {
            Q(8);
            if (z && dVar != null) {
                BdToast.d(this.f27387a.getPageContext().getPageActivity(), this.f27387a.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).q();
                this.f27395i.setText((CharSequence) null);
                this.t.add(dVar);
                this.p.c(this.t);
                G(this.y);
                this.f27395i.post(new RunnableC1345a(this));
                return;
            }
            if (TextUtils.isEmpty(str)) {
                str = this.f27387a.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
            }
            BdToast.d(this.f27387a.getPageContext().getPageActivity(), str, 1).q();
        }
    }
}
