package b.a.r0.x0.z2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import b.a.r0.x0.d1;
import b.a.r0.x0.f1;
import b.a.r0.x0.g1;
import b.a.r0.x0.i1;
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
/* loaded from: classes6.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Activity f28523a;

    /* renamed from: b  reason: collision with root package name */
    public PopupWindow f28524b;

    /* renamed from: c  reason: collision with root package name */
    public View f28525c;

    /* renamed from: d  reason: collision with root package name */
    public FrsViewData f28526d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.x0.y1.e.d f28527e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f28528f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f28529g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f28530h;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f28531e;

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
            this.f28531e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f28531e.f28523a == null || this.f28531e.f28525c == null || this.f28531e.f28524b == null || this.f28531e.f28524b.getContentView() == null) {
                return;
            }
            int g2 = b.a.e.f.p.l.g(this.f28531e.f28523a, d1.ds270);
            this.f28531e.f28524b.getContentView().measure(0, 0);
            b.a.e.f.m.g.l(this.f28531e.f28524b, this.f28531e.f28525c, (-b.a.e.f.p.l.g(this.f28531e.f28523a, d1.ds430)) + (this.f28531e.f28525c.getMeasuredWidth() / 2) + 30, -g2);
            b.a.e.f.m.e.a().postDelayed(this.f28531e.f28529g, 5000L);
            TiebaStatic.log(new StatisticItem("c13016").param("obj_locate", 2));
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f28532e;

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
            this.f28532e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f28532e.h();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f28533e;

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
            this.f28533e = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f28533e.i();
                if (this.f28533e.f28526d == null || this.f28533e.f28526d.postTopic == null || this.f28533e.f28526d.getForum() == null) {
                    return;
                }
                if ((this.f28533e.f28527e == null || this.f28533e.f28527e.a()) && !WriteActivityConfig.isAsyncWriting()) {
                    WriteActivityConfig.newInstance(this.f28533e.f28523a).setType(9).setForumData(this.f28533e.f28526d.getForum()).setAntiData(this.f28533e.f28526d.getAnti()).setTitle(this.f28533e.f28526d.postTopic.recom_topic).send();
                    TiebaStatic.log(new StatisticItem("c13017").param("obj_locate", 2));
                }
            }
        }
    }

    public l(Activity activity, b.a.r0.x0.y1.e.d dVar) {
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
        this.f28528f = new a(this);
        this.f28529g = new b(this);
        this.f28530h = new c(this);
        this.f28523a = activity;
        this.f28527e = dVar;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b.a.e.f.m.g.c(this.f28524b);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.a.e.f.m.e.a().removeCallbacks(this.f28528f);
            b.a.e.f.m.e.a().removeCallbacks(this.f28529g);
            h();
        }
    }

    public void j(View view, FrsViewData frsViewData) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, frsViewData) == null) || view == null || frsViewData == null || frsViewData.postTopic == null || (activity = this.f28523a) == null) {
            return;
        }
        this.f28526d = frsViewData;
        this.f28525c = view;
        View inflate = LayoutInflater.from(activity).inflate(g1.frs_tips_blue_twice_line_down, (ViewGroup) null);
        ((TextView) inflate.findViewById(f1.tips)).setText(StringHelper.cutHotTopicShow(frsViewData.postTopic.recom_title, 24, "..."));
        ((TextView) inflate.findViewById(f1.tips_content)).setText(i1.topic_join);
        inflate.setOnClickListener(this.f28530h);
        this.f28524b = new PopupWindow(inflate, -2, -2);
        b.a.e.f.m.e.a().removeCallbacks(this.f28528f);
        b.a.e.f.m.e.a().postDelayed(this.f28528f, 100L);
    }
}
