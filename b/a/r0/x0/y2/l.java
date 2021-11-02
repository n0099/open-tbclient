package b.a.r0.x0.y2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import b.a.r0.x0.c1;
import b.a.r0.x0.e1;
import b.a.r0.x0.f1;
import b.a.r0.x0.h1;
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
/* loaded from: classes5.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Activity f26928a;

    /* renamed from: b  reason: collision with root package name */
    public PopupWindow f26929b;

    /* renamed from: c  reason: collision with root package name */
    public View f26930c;

    /* renamed from: d  reason: collision with root package name */
    public FrsViewData f26931d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.x0.x1.e.d f26932e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f26933f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f26934g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f26935h;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f26936e;

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
            this.f26936e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f26936e.f26928a == null || this.f26936e.f26930c == null || this.f26936e.f26929b == null || this.f26936e.f26929b.getContentView() == null) {
                return;
            }
            int g2 = b.a.e.e.p.l.g(this.f26936e.f26928a, c1.ds270);
            this.f26936e.f26929b.getContentView().measure(0, 0);
            b.a.e.e.m.g.l(this.f26936e.f26929b, this.f26936e.f26930c, (-b.a.e.e.p.l.g(this.f26936e.f26928a, c1.ds430)) + (this.f26936e.f26930c.getMeasuredWidth() / 2) + 30, -g2);
            b.a.e.e.m.e.a().postDelayed(this.f26936e.f26934g, 5000L);
            TiebaStatic.log(new StatisticItem("c13016").param("obj_locate", 2));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f26937e;

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
            this.f26937e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26937e.h();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f26938e;

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
            this.f26938e = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f26938e.i();
                if (this.f26938e.f26931d == null || this.f26938e.f26931d.postTopic == null || this.f26938e.f26931d.getForum() == null) {
                    return;
                }
                if ((this.f26938e.f26932e == null || this.f26938e.f26932e.a()) && !WriteActivityConfig.isAsyncWriting()) {
                    WriteActivityConfig.newInstance(this.f26938e.f26928a).setType(9).setForumData(this.f26938e.f26931d.getForum()).setAntiData(this.f26938e.f26931d.getAnti()).setTitle(this.f26938e.f26931d.postTopic.recom_topic).send();
                    TiebaStatic.log(new StatisticItem("c13017").param("obj_locate", 2));
                }
            }
        }
    }

    public l(Activity activity, b.a.r0.x0.x1.e.d dVar) {
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
        this.f26933f = new a(this);
        this.f26934g = new b(this);
        this.f26935h = new c(this);
        this.f26928a = activity;
        this.f26932e = dVar;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b.a.e.e.m.g.c(this.f26929b);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.a.e.e.m.e.a().removeCallbacks(this.f26933f);
            b.a.e.e.m.e.a().removeCallbacks(this.f26934g);
            h();
        }
    }

    public void j(View view, FrsViewData frsViewData) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, frsViewData) == null) || view == null || frsViewData == null || frsViewData.postTopic == null || (activity = this.f26928a) == null) {
            return;
        }
        this.f26931d = frsViewData;
        this.f26930c = view;
        View inflate = LayoutInflater.from(activity).inflate(f1.frs_tips_blue_twice_line_down, (ViewGroup) null);
        ((TextView) inflate.findViewById(e1.tips)).setText(StringHelper.cutHotTopicShow(frsViewData.postTopic.recom_title, 24, "..."));
        ((TextView) inflate.findViewById(e1.tips_content)).setText(h1.topic_join);
        inflate.setOnClickListener(this.f26935h);
        this.f26929b = new PopupWindow(inflate, -2, -2);
        b.a.e.e.m.e.a().removeCallbacks(this.f26933f);
        b.a.e.e.m.e.a().postDelayed(this.f26933f, 100L);
    }
}
