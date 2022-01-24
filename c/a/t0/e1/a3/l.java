package c.a.t0.e1.a3;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import c.a.t0.e1.d1;
import c.a.t0.e1.f1;
import c.a.t0.e1.g1;
import c.a.t0.e1.i1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;

    /* renamed from: b  reason: collision with root package name */
    public PopupWindow f16109b;

    /* renamed from: c  reason: collision with root package name */
    public View f16110c;

    /* renamed from: d  reason: collision with root package name */
    public FrsViewData f16111d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.t0.e1.z1.e.d f16112e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f16113f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f16114g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f16115h;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f16116e;

        public a(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16116e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f16116e.a == null || this.f16116e.f16110c == null || this.f16116e.f16109b == null || this.f16116e.f16109b.getContentView() == null) {
                return;
            }
            int f2 = c.a.d.f.p.n.f(this.f16116e.a, d1.ds270);
            this.f16116e.f16109b.getContentView().measure(0, 0);
            c.a.d.f.m.g.l(this.f16116e.f16109b, this.f16116e.f16110c, (-c.a.d.f.p.n.f(this.f16116e.a, d1.ds430)) + (this.f16116e.f16110c.getMeasuredWidth() / 2) + 30, -f2);
            c.a.d.f.m.e.a().postDelayed(this.f16116e.f16114g, 5000L);
            TiebaStatic.log(new StatisticItem("c13016").param("obj_locate", 2));
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f16117e;

        public b(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16117e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16117e.h();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f16118e;

        public c(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16118e = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16118e.i();
                if (this.f16118e.f16111d == null || this.f16118e.f16111d.postTopic == null || this.f16118e.f16111d.getForum() == null) {
                    return;
                }
                if ((this.f16118e.f16112e == null || this.f16118e.f16112e.a()) && !WriteActivityConfig.isAsyncWriting()) {
                    WriteActivityConfig.newInstance(this.f16118e.a).setType(9).setForumData(this.f16118e.f16111d.getForum()).setAntiData(this.f16118e.f16111d.getAnti()).setTitle(this.f16118e.f16111d.postTopic.recom_topic).send();
                    TiebaStatic.log(new StatisticItem("c13017").param("obj_locate", 2));
                }
            }
        }
    }

    public l(Activity activity, c.a.t0.e1.z1.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16113f = new a(this);
        this.f16114g = new b(this);
        this.f16115h = new c(this);
        this.a = activity;
        this.f16112e = dVar;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.d.f.m.g.c(this.f16109b);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.f16113f);
            c.a.d.f.m.e.a().removeCallbacks(this.f16114g);
            h();
        }
    }

    public void j(View view, FrsViewData frsViewData) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, frsViewData) == null) || view == null || frsViewData == null || frsViewData.postTopic == null || (activity = this.a) == null) {
            return;
        }
        this.f16111d = frsViewData;
        this.f16110c = view;
        View inflate = LayoutInflater.from(activity).inflate(g1.frs_tips_blue_twice_line_down, (ViewGroup) null);
        ((TextView) inflate.findViewById(f1.tips)).setText(StringHelper.cutHotTopicShow(frsViewData.postTopic.recom_title, 24, "..."));
        ((TextView) inflate.findViewById(f1.tips_content)).setText(i1.topic_join);
        inflate.setOnClickListener(this.f16115h);
        this.f16109b = new PopupWindow(inflate, -2, -2);
        c.a.d.f.m.e.a().removeCallbacks(this.f16113f);
        c.a.d.f.m.e.a().postDelayed(this.f16113f, 100L);
    }
}
