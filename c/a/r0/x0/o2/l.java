package c.a.r0.x0.o2;

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
    public Activity f27674a;

    /* renamed from: b  reason: collision with root package name */
    public PopupWindow f27675b;

    /* renamed from: c  reason: collision with root package name */
    public View f27676c;

    /* renamed from: d  reason: collision with root package name */
    public FrsViewData f27677d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.x0.n1.e.d f27678e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f27679f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f27680g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f27681h;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f27682e;

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
            this.f27682e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f27682e.f27674a == null || this.f27682e.f27676c == null || this.f27682e.f27675b == null || this.f27682e.f27675b.getContentView() == null) {
                return;
            }
            int g2 = c.a.e.e.p.l.g(this.f27682e.f27674a, R.dimen.ds270);
            this.f27682e.f27675b.getContentView().measure(0, 0);
            c.a.e.e.m.g.l(this.f27682e.f27675b, this.f27682e.f27676c, (-c.a.e.e.p.l.g(this.f27682e.f27674a, R.dimen.ds430)) + (this.f27682e.f27676c.getMeasuredWidth() / 2) + 30, -g2);
            c.a.e.e.m.e.a().postDelayed(this.f27682e.f27680g, 5000L);
            TiebaStatic.log(new StatisticItem("c13016").param("obj_locate", 2));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f27683e;

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
            this.f27683e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27683e.h();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f27684e;

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
            this.f27684e = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f27684e.i();
                if (this.f27684e.f27677d == null || this.f27684e.f27677d.postTopic == null || this.f27684e.f27677d.getForum() == null) {
                    return;
                }
                if ((this.f27684e.f27678e == null || this.f27684e.f27678e.a()) && !WriteActivityConfig.isAsyncWriting()) {
                    WriteActivityConfig.newInstance(this.f27684e.f27674a).setType(9).setForumData(this.f27684e.f27677d.getForum()).setAntiData(this.f27684e.f27677d.getAnti()).setTitle(this.f27684e.f27677d.postTopic.recom_topic).send();
                    TiebaStatic.log(new StatisticItem("c13017").param("obj_locate", 2));
                }
            }
        }
    }

    public l(Activity activity, c.a.r0.x0.n1.e.d dVar) {
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
        this.f27679f = new a(this);
        this.f27680g = new b(this);
        this.f27681h = new c(this);
        this.f27674a = activity;
        this.f27678e = dVar;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.e.e.m.g.c(this.f27675b);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.e.e.m.e.a().removeCallbacks(this.f27679f);
            c.a.e.e.m.e.a().removeCallbacks(this.f27680g);
            h();
        }
    }

    public void j(View view, FrsViewData frsViewData) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, frsViewData) == null) || view == null || frsViewData == null || frsViewData.postTopic == null || (activity = this.f27674a) == null) {
            return;
        }
        this.f27677d = frsViewData;
        this.f27676c = view;
        View inflate = LayoutInflater.from(activity).inflate(R.layout.frs_tips_blue_twice_line_down, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tips)).setText(StringHelper.cutHotTopicShow(frsViewData.postTopic.recom_title, 24, "..."));
        ((TextView) inflate.findViewById(R.id.tips_content)).setText(R.string.topic_join);
        inflate.setOnClickListener(this.f27681h);
        this.f27675b = new PopupWindow(inflate, -2, -2);
        c.a.e.e.m.e.a().removeCallbacks(this.f27679f);
        c.a.e.e.m.e.a().postDelayed(this.f27679f, 100L);
    }
}
