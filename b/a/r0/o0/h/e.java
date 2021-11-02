package b.a.r0.o0.h;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import b.a.e.e.m.g;
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
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f21655a;

    /* renamed from: b  reason: collision with root package name */
    public View f21656b;

    /* renamed from: c  reason: collision with root package name */
    public PopupWindow f21657c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f21658d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f21659e;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f21660e;

        public a(e eVar) {
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
            this.f21660e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21660e.f21657c == null) {
                return;
            }
            g.c(this.f21660e.f21657c);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f21661e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f21662f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f21663g;

        public b(e eVar, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21663g = eVar;
            this.f21661e = i2;
            this.f21662f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21663g.g(this.f21661e, this.f21662f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f21664e;

        public c(e eVar) {
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
            this.f21664e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21664e.e();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21658d = new Handler();
        this.f21659e = new a(this);
        this.f21655a = tbPageContext;
    }

    public void c(LinkedList<VisitedForumData> linkedList, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, linkedList, i2) == null) {
            if (linkedList != null && linkedList.size() >= 1) {
                int d2 = d(linkedList);
                if (d2 < 0) {
                    b.a.q0.s.e0.b.j().t("key_enter_forum_ufan_recent_visit_tip_show", true);
                    return;
                } else if (b.a.q0.s.e0.b.j().g("key_enter_forum_ufan_recent_visit_tip_show", false)) {
                    return;
                } else {
                    this.f21658d.postDelayed(new b(this, i2, d2), 100L);
                    return;
                }
            }
            b.a.q0.s.e0.b.j().t("key_enter_forum_ufan_recent_visit_tip_show", true);
        }
    }

    public final int d(LinkedList<VisitedForumData> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linkedList)) == null) {
            int size = linkedList.size();
            for (int i2 = 0; i2 < 3 && i2 < size; i2++) {
                VisitedForumData visitedForumData = linkedList.get(i2);
                if (visitedForumData != null && visitedForumData.F()) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public void e() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (popupWindow = this.f21657c) == null) {
            return;
        }
        g.c(popupWindow);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f21658d.removeCallbacksAndMessages(null);
        }
    }

    public final void g(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            b.a.q0.s.e0.b.j().t("key_enter_forum_ufan_recent_visit_tip_show", true);
            PopupWindow popupWindow = this.f21657c;
            if (popupWindow == null || !popupWindow.isShowing()) {
                if (this.f21656b == null) {
                    View inflate = LayoutInflater.from(this.f21655a.getPageActivity()).inflate(R.layout.enter_forum_ufan_item_tip, (ViewGroup) null);
                    this.f21656b = inflate;
                    inflate.setOnClickListener(new c(this));
                }
                if (this.f21657c == null) {
                    PopupWindow popupWindow2 = new PopupWindow(this.f21656b, -2, -2);
                    this.f21657c = popupWindow2;
                    popupWindow2.setOutsideTouchable(true);
                }
                g.m(this.f21657c, this.f21655a.getPageActivity().findViewById(16908290), 51, this.f21655a.getResources().getDimensionPixelSize(R.dimen.tbds44) + (i3 * this.f21655a.getResources().getDimensionPixelSize(R.dimen.tbds220)), i2);
                this.f21658d.postDelayed(this.f21659e, 5000L);
            }
        }
    }
}
