package c.a.r0.x0.w1.e;

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
import c.a.e.e.p.l;
import c.a.e.l.e.n;
import c.a.q0.d1.m0;
import c.a.q0.s.s.a;
import c.a.r0.k2.i.c;
import c.a.r0.x0.w1.a;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsGameSubPbActivity f28147a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f28148b;

    /* renamed from: c  reason: collision with root package name */
    public View f28149c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.x0.w1.d.e f28150d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f28151e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f28152f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f28153g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f28154h;

    /* renamed from: i  reason: collision with root package name */
    public EditText f28155i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f28156j;
    public TextView k;
    public TextView l;
    public ProgressBar m;
    public View n;
    public c.a.r0.x0.w1.c o;
    public c.a.r0.x0.w1.b p;
    public View.OnClickListener q;
    public ViewTreeObserver.OnGlobalLayoutListener r;
    public c.a.r0.x0.w1.d.b s;
    public List<n> t;
    public String u;
    public String v;
    public long w;
    public boolean x;
    public boolean y;
    public c.a.r0.k2.i.c z;

    /* renamed from: c.a.r0.x0.w1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1324a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28157e;

        public RunnableC1324a(a aVar) {
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
            this.f28157e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f28157e.f28155i.requestFocus();
                l.x(this.f28157e.f28147a.getPageContext().getPageActivity(), this.f28157e.f28155i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28158e;

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
            this.f28158e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f28158e.f28155i.requestFocus();
                l.K(this.f28158e.f28147a.getPageContext().getPageActivity(), this.f28158e.f28155i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f28159a;

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
            this.f28159a = aVar;
        }

        @Override // c.a.r0.k2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.r0.k2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.r0.k2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                this.f28159a.s(false);
                this.f28159a.N(view);
                this.f28159a.s(true);
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28160e;

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
            this.f28160e = aVar;
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
            l.x(this.f28160e.f28147a.getPageContext().getPageActivity(), this.f28160e.f28155i);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28161e;

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
            this.f28161e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                a aVar = this.f28161e;
                aVar.p(aVar.f28155i.getText().toString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements a.InterfaceC1321a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f28162a;

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
            this.f28162a = aVar;
        }

        @Override // c.a.r0.x0.w1.a.InterfaceC1321a
        public void a(c.a.r0.x0.w1.d.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) || dVar == null) {
                return;
            }
            this.f28162a.M(dVar);
        }

        @Override // c.a.r0.x0.w1.a.InterfaceC1321a
        public void b(c.a.r0.x0.w1.d.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f28162a.f28147a.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.f28143g).longValue(), String.valueOf(this.f28162a.w).equals(dVar.f28143g), false)));
            }
        }

        @Override // c.a.r0.x0.w1.a.InterfaceC1321a
        public void c(c.a.r0.x0.w1.d.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
                if (this.f28162a.o != null) {
                    this.f28162a.o.i();
                }
                if (dVar == null) {
                    this.f28162a.t(null);
                    this.f28162a.J();
                    return;
                }
                this.f28162a.t(dVar.f28144h);
                this.f28162a.v = dVar.f28143g;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28163e;

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
            this.f28163e = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                this.f28163e.f28147a.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int r = l.r(this.f28163e.f28147a.getPageContext().getPageActivity());
                int[] p = l.p(this.f28163e.f28147a.getPageContext().getPageActivity());
                if (p[1] - rect.bottom > p[1] / 4 && !this.f28163e.x) {
                    this.f28163e.x = true;
                    this.f28163e.F(true);
                } else if (p[1] - rect.height() == r && this.f28163e.x) {
                    this.f28163e.x = false;
                    this.f28163e.F(false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.s.a f28164e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.x0.w1.d.d f28165f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f28166g;

        public h(a aVar, c.a.q0.s.s.a aVar2, c.a.r0.x0.w1.d.d dVar) {
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
            this.f28166g = aVar;
            this.f28164e = aVar2;
            this.f28165f = dVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f28164e.dismiss();
                this.f28166g.r(this.f28165f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.s.a f28167e;

        public i(a aVar, c.a.q0.s.s.a aVar2) {
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
            this.f28167e = aVar2;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f28167e.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f28168e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f28169f;

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
            this.f28169f = aVar;
            this.f28168e = i2;
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
                    this.f28169f.f28156j.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (StringUtils.isNull(charSequence2)) {
                        return;
                    }
                    int b2 = m0.b(charSequence2);
                    int i5 = this.f28168e;
                    if (b2 > i5) {
                        String j2 = m0.j(charSequence2, 0, i5 - 1);
                        this.f28169f.f28155i.setText(j2);
                        this.f28169f.f28155i.setSelection(this.f28169f.f28155i.getText().length());
                        UtilHelper.showToast(this.f28169f.f28147a.getPageContext().getPageActivity().getApplication(), this.f28169f.f28147a.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(j2.length())));
                        return;
                    }
                    return;
                }
                this.f28169f.J();
                this.f28169f.f28156j.setEnabled(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f28170e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f28171f;

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
            this.f28171f = aVar;
            this.f28170e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f28171f.f28151e.setEnabled(this.f28170e);
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
        this.z = new c.a.r0.k2.i.c(new c(this));
        this.f28147a = frsGameSubPbActivity;
        this.q = onClickListener;
        this.u = str;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.f28148b = relativeLayout;
        BdTypeListView bdTypeListView = (BdTypeListView) relativeLayout.findViewById(R.id.new_sub_pb_list);
        this.f28151e = bdTypeListView;
        bdTypeListView.setOnTouchListener(this.z);
        this.f28151e.setOnScrollListener(new d(this));
        this.f28150d = new c.a.r0.x0.w1.d.e(this.f28147a.getPageContext());
        this.f28149c = BdListViewHelper.d(this.f28147a.getActivity(), this.f28151e, BdListViewHelper.HeadType.DEFAULT);
        TextView textView = (TextView) this.f28148b.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.k = textView;
        textView.setOnClickListener(this.q);
        this.l = (TextView) this.f28148b.findViewById(R.id.no_reply_list_view);
        this.f28153g = (FrameLayout) this.f28148b.findViewById(R.id.bottom_view);
        this.f28154h = (LinearLayout) this.f28148b.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.f28155i = (EditText) this.f28148b.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        TextView textView2 = (TextView) this.f28148b.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.f28156j = textView2;
        textView2.setOnClickListener(new e(this));
        this.m = (ProgressBar) this.f28148b.findViewById(R.id.progressBar);
        C();
        c.a.r0.x0.w1.b bVar = new c.a.r0.x0.w1.b(this.f28147a.getPageContext(), this.f28151e);
        this.p = bVar;
        bVar.b(new f(this));
        K(140);
        B();
        D(TbadkCoreApplication.getInst().getSkinType());
        this.t = new ArrayList();
        this.w = c.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public void A(boolean z, String str, c.a.r0.x0.w1.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, dVar}) == null) {
            if (z) {
                BdToast.d(this.f28147a.getPageContext().getPageActivity(), this.f28147a.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).q();
                this.t.remove(dVar);
                this.p.c(this.t);
                G(this.y);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                str = this.f28147a.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
            }
            BdToast.d(this.f28147a.getPageContext().getPageActivity(), str, 1).q();
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.r = new g(this);
            this.f28147a.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.r);
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f28148b.findViewById(R.id.view_navigation_bar);
            this.f28152f = navigationBar;
            this.n = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            ImageView backImageView = this.f28152f.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
                int g2 = l.g(this.f28147a.getPageContext().getPageActivity(), R.dimen.ds30);
                layoutParams.height = g2;
                layoutParams.width = g2;
                backImageView.setLayoutParams(layoutParams);
            }
            View view = this.n;
            if (view != null && (view.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.n.getLayoutParams();
                layoutParams2.width = -2;
                layoutParams2.height = -1;
                this.n.setPadding(l.g(this.f28147a.getPageContext().getPageActivity(), R.dimen.ds32), this.n.getPaddingTop(), this.n.getPaddingRight(), this.n.getPaddingBottom());
                this.n.setLayoutParams(layoutParams2);
            }
            if (this.f28152f.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f28152f.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public void D(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f28147a.getLayoutMode().k(i2 == 1);
            this.f28147a.getLayoutMode().j(this.f28148b);
            SkinManager.setBackgroundColor(this.f28148b, R.color.CAM_X0201);
            this.f28152f.onChangeSkinType(this.f28147a.getPageContext(), i2);
            this.f28150d.d(i2);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0110);
            this.k.setAlpha(0.95f);
            SkinManager.setBackgroundResource(this.k, R.drawable.pb_ecomm_comment_bg);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0109);
            SkinManager.setBackgroundResource(this.f28154h, R.drawable.pb_ecomm_comment_bg);
            SkinManager.setViewTextColor(this.f28155i, R.color.CAM_X0106);
            this.f28155i.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            SkinManager.setViewTextColor(this.f28156j, R.color.game_sub_pb_send_txt_color);
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.r == null) {
            return;
        }
        this.f28147a.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.r);
    }

    public final void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                Rect rect = new Rect();
                this.f28154h.getWindowVisibleDisplayFrame(rect);
                int e2 = (l.p(this.f28147a.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.e(this.f28147a.getPageContext().getPageActivity(), 48.0f) : 0);
                FrameLayout frameLayout = this.f28153g;
                frameLayout.scrollTo(frameLayout.getScrollX(), e2);
                return;
            }
            this.f28153g.setScrollY(0);
        }
    }

    public final void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (ListUtils.isEmpty(this.t)) {
                this.f28151e.setNextPage(null);
                this.l.setVisibility(0);
            } else {
                this.f28151e.setNextPage(this.f28150d);
                this.l.setVisibility(8);
                if (z) {
                    this.f28150d.O();
                } else {
                    this.f28150d.f();
                }
            }
            L();
        }
    }

    public void H(c.a.r0.x0.w1.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            this.o = cVar;
        }
    }

    public void I(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pVar) == null) {
            this.f28151e.setOnSrollToBottomListener(pVar);
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.r0.x0.w1.d.b bVar = this.s;
            this.v = bVar != null ? bVar.f28136e : null;
        }
    }

    public final void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f28155i.addTextChangedListener(new j(this, i2));
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (!ListUtils.isEmpty(this.t)) {
                this.f28152f.setCenterTextTitle(String.format(this.f28147a.getResources().getString(R.string.subpb_floor_reply_count), StringHelper.numFormatOver10000(this.t.size())));
            } else {
                this.f28152f.setCenterTextTitle(this.f28147a.getResources().getString(R.string.reply));
            }
        }
    }

    public final void M(c.a.r0.x0.w1.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dVar) == null) {
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f28147a.getPageContext().getPageActivity());
            aVar.setTitle((String) null);
            aVar.setMessageId(R.string.del_all_post_confirm);
            aVar.setCanceledOnTouchOutside(true);
            aVar.setPositiveButton(R.string.dialog_ok, new h(this, aVar, dVar));
            aVar.setNegativeButton(R.string.dialog_cancel, new i(this, aVar));
            aVar.create(this.f28147a.getPageContext()).show();
        }
    }

    public void N(View view) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, view) == null) || this.f28149c == null || (navigationBar = this.f28152f) == null) {
            return;
        }
        if (navigationBar.isNavigationBarExcludeStatusbarVisible()) {
            this.f28152f.showNavigationBarExcludeStatusbar(false);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.f28149c.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
            } else {
                BdTypeListView bdTypeListView = this.f28151e;
                if (bdTypeListView != null) {
                    bdTypeListView.removeHeaderView(this.f28149c);
                }
            }
            this.f28152f.setVisibility(8);
            return;
        }
        this.f28152f.showNavigationBarExcludeStatusbar(true);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.f28149c.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f28147a.getActivity(), R.dimen.ds98)));
        } else {
            BdTypeListView bdTypeListView2 = this.f28151e;
            if (bdTypeListView2 != null) {
                bdTypeListView2.addHeaderView(this.f28149c, 0);
            }
        }
        this.f28152f.setVisibility(0);
    }

    public void O(boolean z, c.a.r0.x0.w1.d.b bVar, List<n> list) {
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
            this.f28151e.setNextPage(this.f28150d);
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
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (view = this.f28149c) == null || view.getLayoutParams() == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f28149c.getLayoutParams();
        if (z) {
            q();
            layoutParams.height = l.g(this.f28147a.getPageContext().getPageActivity(), R.dimen.ds98);
        } else {
            layoutParams.height = l.g(this.f28147a.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
        }
        this.f28149c.setLayoutParams(layoutParams);
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
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.f28152f.getBackImageView() == null) {
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f28152f.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public final void r(c.a.r0.x0.w1.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, dVar) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_SUB_COMMENT);
            httpMessage.addParam("user_id", this.w);
            httpMessage.addParam("main_tower_id", dVar.f28142f);
            httpMessage.addParam("id", dVar.f28141e);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void s(boolean z) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (bdTypeListView = this.f28151e) == null) {
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
            this.f28154h.setVisibility(0);
            this.f28155i.post(new b(this));
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String format = String.format(this.f28147a.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.f28155i.setText(format);
            this.f28155i.setSelection(format.length());
        }
    }

    public ListView u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f28151e : (ListView) invokeV.objValue;
    }

    public NavigationBar v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f28152f : (NavigationBar) invokeV.objValue;
    }

    public TextView w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.k : (TextView) invokeV.objValue;
    }

    public View x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f28148b : (View) invokeV.objValue;
    }

    public View y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f28149c : (View) invokeV.objValue;
    }

    public void z(boolean z, String str, c.a.r0.x0.w1.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Boolean.valueOf(z), str, dVar}) == null) {
            Q(8);
            if (z && dVar != null) {
                BdToast.d(this.f28147a.getPageContext().getPageActivity(), this.f28147a.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).q();
                this.f28155i.setText((CharSequence) null);
                this.t.add(dVar);
                this.p.c(this.t);
                G(this.y);
                this.f28155i.post(new RunnableC1324a(this));
                return;
            }
            if (TextUtils.isEmpty(str)) {
                str = this.f28147a.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
            }
            BdToast.d(this.f28147a.getPageContext().getPageActivity(), str, 1).q();
        }
    }
}
