package c.a.q0.v0.n2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Activity f26809a;

    /* renamed from: b  reason: collision with root package name */
    public PopupWindow f26810b;

    /* renamed from: c  reason: collision with root package name */
    public View f26811c;

    /* renamed from: d  reason: collision with root package name */
    public FrsViewData f26812d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.v0.m1.e.d f26813e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f26814f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f26815g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f26816h;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f26817e;

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
            this.f26817e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f26817e.f26809a == null || this.f26817e.f26811c == null || this.f26817e.f26810b == null || this.f26817e.f26810b.getContentView() == null) {
                return;
            }
            int g2 = c.a.e.e.p.l.g(this.f26817e.f26809a, R.dimen.ds270);
            this.f26817e.f26810b.getContentView().measure(0, 0);
            c.a.e.e.m.g.l(this.f26817e.f26810b, this.f26817e.f26811c, (-c.a.e.e.p.l.g(this.f26817e.f26809a, R.dimen.ds430)) + (this.f26817e.f26811c.getMeasuredWidth() / 2) + 30, -g2);
            c.a.e.e.m.e.a().postDelayed(this.f26817e.f26815g, 5000L);
            TiebaStatic.log(new StatisticItem("c13016").param("obj_locate", 2));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f26818e;

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
            this.f26818e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26818e.h();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f26819e;

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
            this.f26819e = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f26819e.i();
                if (this.f26819e.f26812d == null || this.f26819e.f26812d.postTopic == null || this.f26819e.f26812d.getForum() == null) {
                    return;
                }
                if ((this.f26819e.f26813e == null || this.f26819e.f26813e.a()) && !WriteActivityConfig.isAsyncWriting()) {
                    WriteActivityConfig.newInstance(this.f26819e.f26809a).setType(9).setForumData(this.f26819e.f26812d.getForum()).setAntiData(this.f26819e.f26812d.getAnti()).setTitle(this.f26819e.f26812d.postTopic.recom_topic).send();
                    TiebaStatic.log(new StatisticItem("c13017").param("obj_locate", 2));
                }
            }
        }
    }

    public l(Activity activity, c.a.q0.v0.m1.e.d dVar) {
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
        this.f26814f = new a(this);
        this.f26815g = new b(this);
        this.f26816h = new c(this);
        this.f26809a = activity;
        this.f26813e = dVar;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.e.e.m.g.c(this.f26810b);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.e.e.m.e.a().removeCallbacks(this.f26814f);
            c.a.e.e.m.e.a().removeCallbacks(this.f26815g);
            h();
        }
    }

    public void j(View view, FrsViewData frsViewData) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, frsViewData) == null) || view == null || frsViewData == null || frsViewData.postTopic == null || (activity = this.f26809a) == null) {
            return;
        }
        this.f26812d = frsViewData;
        this.f26811c = view;
        View inflate = LayoutInflater.from(activity).inflate(R.layout.frs_tips_blue_twice_line_down, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tips)).setText(StringHelper.cutHotTopicShow(frsViewData.postTopic.recom_title, 24, "..."));
        ((TextView) inflate.findViewById(R.id.tips_content)).setText(R.string.topic_join);
        inflate.setOnClickListener(this.f26816h);
        this.f26810b = new PopupWindow(inflate, -2, -2);
        c.a.e.e.m.e.a().removeCallbacks(this.f26814f);
        c.a.e.e.m.e.a().postDelayed(this.f26814f, 100L);
    }
}
