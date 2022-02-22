package c.a.u0.z2.h;

import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.t0.s.r.e2;
import c.a.u0.a3.d;
import c.a.u0.a3.e;
import c.a.u0.a3.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.personPolymeric.jvbao.ReportThemeActivity;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f26052e;

    /* renamed from: f  reason: collision with root package name */
    public ReportThemeActivity f26053f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f26054g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f26055h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<String> f26056i;

    /* renamed from: j  reason: collision with root package name */
    public int f26057j;

    /* renamed from: c.a.u0.z2.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1575a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f26058e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e2 f26059f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f26060g;

        public View$OnClickListenerC1575a(a aVar, int i2, e2 e2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), e2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26060g = aVar;
            this.f26058e = i2;
            this.f26059f = e2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f26058e == 40) {
                    this.f26060g.i(this.f26059f);
                } else {
                    this.f26060g.h(this.f26059f);
                }
                TiebaStatic.log(new StatisticItem("c14575").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f26059f.U()).param("fname", this.f26059f.b0()).param("tid", this.f26059f.w1()));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f26061e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f26062f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e2 f26063g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f26064h;

        /* renamed from: c.a.u0.z2.h.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C1576a extends Thread {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f26065e;

            public C1576a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f26065e = bVar;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Message message = new Message();
                    message.what = 1;
                    if (this.f26065e.f26064h.f26057j > this.f26065e.f26064h.f26056i.size()) {
                        message.arg1 = this.f26065e.f26064h.f26057j;
                        this.f26065e.f26064h.f26057j = 0;
                    } else {
                        message.arg1 = this.f26065e.f26064h.f26056i.size();
                    }
                    this.f26065e.f26064h.f26053f.handler.sendMessage(message);
                }
            }
        }

        public b(a aVar, c cVar, String str, e2 e2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar, str, e2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26064h = aVar;
            this.f26061e = cVar;
            this.f26062f = str;
            this.f26063g = e2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                view.setTag(Boolean.valueOf(!((Boolean) view.getTag()).booleanValue()));
                if (((Boolean) view.getTag()).booleanValue()) {
                    if (this.f26064h.f26056i.size() < 10) {
                        this.f26061e.f26069e.setImageDrawable(WebPManager.getPureDrawable(c.a.u0.a3.c.icon_pure_strok324_select, SkinManager.getColor(c.a.u0.a3.a.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                        this.f26064h.f26056i.add(this.f26062f);
                        TiebaStatic.log(new StatisticItem("c14574").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f26063g.U()).param("fname", this.f26063g.b0()).param("tid", this.f26063g.w1()));
                    } else {
                        a aVar = this.f26064h;
                        aVar.f26057j = aVar.f26056i.size() + 1;
                    }
                } else {
                    this.f26061e.f26069e.setImageDrawable(WebPManager.getPureDrawable(c.a.u0.a3.c.icon_pure_strok324, SkinManager.getColor(c.a.u0.a3.a.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                    this.f26064h.f26056i.remove(this.f26062f);
                }
                new C1576a(this).start();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f26066b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f26067c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f26068d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f26069e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f26070f;

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
                }
            }
        }

        public /* synthetic */ c(a aVar, View$OnClickListenerC1575a view$OnClickListenerC1575a) {
            this(aVar);
        }
    }

    public a(ReportThemeActivity reportThemeActivity, ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {reportThemeActivity, arrayList};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26055h = null;
        this.f26056i = null;
        this.f26057j = 0;
        this.f26053f = reportThemeActivity;
        this.f26052e = reportThemeActivity.getPageContext().getContext();
        this.f26054g = arrayList;
    }

    public final c e(Object obj, n nVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, nVar)) == null) {
            if (obj == null) {
                return f(nVar);
            }
            return (c) obj;
        }
        return (c) invokeLL.objValue;
    }

    public final c f(n nVar) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nVar)) == null) {
            c cVar = new c(this, null);
            if (nVar instanceof c.a.u0.g0.d0.b) {
                View inflate = LayoutInflater.from(this.f26052e).inflate(e.report_theme_item, (ViewGroup) null);
                cVar.a = inflate;
                cVar.f26066b = (LinearLayout) inflate.findViewById(d.list_item);
                cVar.f26067c = (TbImageView) cVar.a.findViewById(d.coverView);
                cVar.f26068d = (TextView) cVar.a.findViewById(d.titleView);
                cVar.f26069e = (ImageView) cVar.a.findViewById(d.checkbox);
                cVar.f26070f = (LinearLayout) cVar.a.findViewById(d.checkboxContainer);
                c.a.t0.s.v.c.d(cVar.a).k(c.a.u0.a3.a.CAM_X0101);
                c.a.t0.s.v.c d2 = c.a.t0.s.v.c.d(cVar.f26066b);
                d2.n(g.J_X05);
                d2.f(c.a.u0.a3.a.CAM_X0206);
                c.a.t0.s.v.c d3 = c.a.t0.s.v.c.d(cVar.f26068d);
                d3.v(c.a.u0.a3.a.CAM_X0107);
                d3.z(c.a.u0.a3.b.T_X07);
                e2 threadData = ((c.a.u0.g0.d0.b) nVar).getThreadData();
                String w1 = threadData.w1();
                cVar.f26068d.setText(threadData.getTitle());
                if (threadData != null) {
                    if (threadData.A1 && (str = threadData.z1.f40386c) != null) {
                        cVar.f26067c.startLoad(str, 33, false);
                    } else if (threadData.v2() && threadData.u1().thumbnail_url != null) {
                        cVar.f26067c.startLoad(threadData.u1().thumbnail_url, 33, false);
                    } else if (threadData.d0 == 0 && threadData.G0().size() != 0) {
                        cVar.f26067c.startLoad(threadData.G0().get(0).small_pic_url, 33, false);
                    } else {
                        cVar.f26067c.startLoad(String.valueOf(c.a.u0.a3.c.icon_empty_coverimg), 24, false);
                    }
                }
                cVar.f26066b.setOnClickListener(new View$OnClickListenerC1575a(this, threadData.s1(), threadData));
                this.f26056i = this.f26053f.getReportThemeList();
                boolean z = false;
                for (int i2 = 0; i2 < this.f26056i.size(); i2++) {
                    if (w1.equals(this.f26056i.get(i2))) {
                        z = true;
                    }
                }
                cVar.f26070f.setTag(Boolean.valueOf(z));
                if (((Boolean) cVar.f26070f.getTag()).booleanValue()) {
                    cVar.f26069e.setImageDrawable(WebPManager.getPureDrawable(c.a.u0.a3.c.icon_pure_strok324_select, SkinManager.getColor(c.a.u0.a3.a.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                } else {
                    cVar.f26069e.setImageDrawable(WebPManager.getPureDrawable(c.a.u0.a3.c.icon_pure_strok324, SkinManager.getColor(c.a.u0.a3.a.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                }
                cVar.f26070f.setOnClickListener(new b(this, cVar, w1, threadData));
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: g */
    public n getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f26054g.get(i2) : (n) invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList<n> arrayList = this.f26054g;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (this.f26055h == null) {
                this.f26055h = viewGroup;
            }
            n item = getItem(i2);
            if (item != null) {
                cVar = e(view != null ? view.getTag() : null, item);
            } else {
                cVar = null;
            }
            if (cVar != null) {
                return cVar.a;
            }
            return null;
        }
        return (View) invokeILL.objValue;
    }

    public void h(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, e2Var) == null) || e2Var == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(TbadkCoreApplication.getInst().getContext()).createNormalCfg(e2Var.w1(), null, null)));
    }

    public void i(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, e2Var) == null) || e2Var == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        videoItemData.thread_id = e2Var.w1();
        arrayList.add(videoItemData);
        VideoRecommentPlayActivityConfig videoRecommentPlayActivityConfig = new VideoRecommentPlayActivityConfig(this.f26052e, arrayList, null, null);
        videoRecommentPlayActivityConfig.setParamIsVertail(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoRecommentPlayActivityConfig));
    }

    public void j(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, arrayList) == null) {
            this.f26054g = arrayList;
        }
    }
}
