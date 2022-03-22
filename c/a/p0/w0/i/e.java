package c.a.p0.w0.i;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import c.a.d.f.m.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public View f19421b;

    /* renamed from: c  reason: collision with root package name */
    public PopupWindow f19422c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f19423d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f19424e;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f19422c == null) {
                return;
            }
            g.c(this.a.f19422c);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f19425b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f19426c;

        public b(e eVar, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19426c = eVar;
            this.a = i;
            this.f19425b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19426c.g(this.a, this.f19425b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.e();
            }
        }
    }

    public e(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19423d = new Handler();
        this.f19424e = new a(this);
        this.a = tbPageContext;
    }

    public void c(LinkedList<VisitedForumData> linkedList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, linkedList, i) == null) {
            if (linkedList != null && linkedList.size() >= 1) {
                int d2 = d(linkedList);
                if (d2 < 0) {
                    c.a.o0.r.j0.b.k().u("key_enter_forum_ufan_recent_visit_tip_show", true);
                    return;
                } else if (c.a.o0.r.j0.b.k().h("key_enter_forum_ufan_recent_visit_tip_show", false)) {
                    return;
                } else {
                    this.f19423d.postDelayed(new b(this, i, d2), 100L);
                    return;
                }
            }
            c.a.o0.r.j0.b.k().u("key_enter_forum_ufan_recent_visit_tip_show", true);
        }
    }

    public final int d(LinkedList<VisitedForumData> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linkedList)) == null) {
            int size = linkedList.size();
            for (int i = 0; i < 3 && i < size; i++) {
                VisitedForumData visitedForumData = linkedList.get(i);
                if (visitedForumData != null && visitedForumData.H()) {
                    return i;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public void e() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (popupWindow = this.f19422c) == null) {
            return;
        }
        g.c(popupWindow);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f19423d.removeCallbacksAndMessages(null);
        }
    }

    public final void g(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            c.a.o0.r.j0.b.k().u("key_enter_forum_ufan_recent_visit_tip_show", true);
            PopupWindow popupWindow = this.f19422c;
            if (popupWindow == null || !popupWindow.isShowing()) {
                if (this.f19421b == null) {
                    View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0280, (ViewGroup) null);
                    this.f19421b = inflate;
                    inflate.setOnClickListener(new c(this));
                }
                if (this.f19422c == null) {
                    PopupWindow popupWindow2 = new PopupWindow(this.f19421b, -2, -2);
                    this.f19422c = popupWindow2;
                    popupWindow2.setOutsideTouchable(true);
                }
                g.m(this.f19422c, this.a.getPageActivity().findViewById(16908290), 51, this.a.getResources().getDimensionPixelSize(R.dimen.tbds44) + (i2 * this.a.getResources().getDimensionPixelSize(R.dimen.tbds220)), i);
                this.f19423d.postDelayed(this.f19424e, 5000L);
            }
        }
    }
}
