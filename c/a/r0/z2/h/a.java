package c.a.r0.z2.h;

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
import c.a.q0.r.r.e2;
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
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.jvbao.ReportThemeActivity;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f25714e;

    /* renamed from: f  reason: collision with root package name */
    public ReportThemeActivity f25715f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f25716g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f25717h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<String> f25718i;

    /* renamed from: j  reason: collision with root package name */
    public int f25719j;

    /* renamed from: c.a.r0.z2.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1567a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f25720e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e2 f25721f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f25722g;

        public View$OnClickListenerC1567a(a aVar, int i2, e2 e2Var) {
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
            this.f25722g = aVar;
            this.f25720e = i2;
            this.f25721f = e2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f25720e == 40) {
                    this.f25722g.i(this.f25721f);
                } else {
                    this.f25722g.h(this.f25721f);
                }
                TiebaStatic.log(new StatisticItem("c14575").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f25721f.U()).param("fname", this.f25721f.b0()).param("tid", this.f25721f.w1()));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25723e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f25724f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e2 f25725g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f25726h;

        /* renamed from: c.a.r0.z2.h.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1568a extends Thread {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f25727e;

            public C1568a(b bVar) {
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
                this.f25727e = bVar;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Message message = new Message();
                    message.what = 1;
                    if (this.f25727e.f25726h.f25719j > this.f25727e.f25726h.f25718i.size()) {
                        message.arg1 = this.f25727e.f25726h.f25719j;
                        this.f25727e.f25726h.f25719j = 0;
                    } else {
                        message.arg1 = this.f25727e.f25726h.f25718i.size();
                    }
                    this.f25727e.f25726h.f25715f.handler.sendMessage(message);
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
            this.f25726h = aVar;
            this.f25723e = cVar;
            this.f25724f = str;
            this.f25725g = e2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                view.setTag(Boolean.valueOf(!((Boolean) view.getTag()).booleanValue()));
                if (((Boolean) view.getTag()).booleanValue()) {
                    if (this.f25726h.f25718i.size() < 10) {
                        this.f25723e.f25731e.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324_select, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                        this.f25726h.f25718i.add(this.f25724f);
                        TiebaStatic.log(new StatisticItem("c14574").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f25725g.U()).param("fname", this.f25725g.b0()).param("tid", this.f25725g.w1()));
                    } else {
                        a aVar = this.f25726h;
                        aVar.f25719j = aVar.f25718i.size() + 1;
                    }
                } else {
                    this.f25723e.f25731e.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                    this.f25726h.f25718i.remove(this.f25724f);
                }
                new C1568a(this).start();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f25728b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f25729c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f25730d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f25731e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f25732f;

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

        public /* synthetic */ c(a aVar, View$OnClickListenerC1567a view$OnClickListenerC1567a) {
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
        this.f25717h = null;
        this.f25718i = null;
        this.f25719j = 0;
        this.f25715f = reportThemeActivity;
        this.f25714e = reportThemeActivity.getPageContext().getContext();
        this.f25716g = arrayList;
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
            if (nVar instanceof c.a.r0.f0.d0.b) {
                View inflate = LayoutInflater.from(this.f25714e).inflate(R.layout.report_theme_item, (ViewGroup) null);
                cVar.a = inflate;
                cVar.f25728b = (LinearLayout) inflate.findViewById(R.id.list_item);
                cVar.f25729c = (TbImageView) cVar.a.findViewById(R.id.coverView);
                cVar.f25730d = (TextView) cVar.a.findViewById(R.id.titleView);
                cVar.f25731e = (ImageView) cVar.a.findViewById(R.id.checkbox);
                cVar.f25732f = (LinearLayout) cVar.a.findViewById(R.id.checkboxContainer);
                c.a.q0.r.v.c.d(cVar.a).k(R.color.CAM_X0101);
                c.a.q0.r.v.c d2 = c.a.q0.r.v.c.d(cVar.f25728b);
                d2.n(R.string.J_X05);
                d2.f(R.color.CAM_X0206);
                c.a.q0.r.v.c d3 = c.a.q0.r.v.c.d(cVar.f25730d);
                d3.v(R.color.CAM_X0107);
                d3.z(R.dimen.T_X07);
                e2 threadData = ((c.a.r0.f0.d0.b) nVar).getThreadData();
                String w1 = threadData.w1();
                cVar.f25730d.setText(threadData.getTitle());
                if (threadData != null) {
                    if (threadData.A1 && (str = threadData.z1.f38790c) != null) {
                        cVar.f25729c.startLoad(str, 33, false);
                    } else if (threadData.v2() && threadData.u1().thumbnail_url != null) {
                        cVar.f25729c.startLoad(threadData.u1().thumbnail_url, 33, false);
                    } else if (threadData.d0 == 0 && threadData.G0().size() != 0) {
                        cVar.f25729c.startLoad(threadData.G0().get(0).small_pic_url, 33, false);
                    } else {
                        cVar.f25729c.startLoad(String.valueOf((int) R.drawable.icon_empty_coverimg), 24, false);
                    }
                }
                cVar.f25728b.setOnClickListener(new View$OnClickListenerC1567a(this, threadData.s1(), threadData));
                this.f25718i = this.f25715f.getReportThemeList();
                boolean z = false;
                for (int i2 = 0; i2 < this.f25718i.size(); i2++) {
                    if (w1.equals(this.f25718i.get(i2))) {
                        z = true;
                    }
                }
                cVar.f25732f.setTag(Boolean.valueOf(z));
                if (((Boolean) cVar.f25732f.getTag()).booleanValue()) {
                    cVar.f25731e.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324_select, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                } else {
                    cVar.f25731e.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                }
                cVar.f25732f.setOnClickListener(new b(this, cVar, w1, threadData));
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
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f25716g.get(i2) : (n) invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList<n> arrayList = this.f25716g;
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
            if (this.f25717h == null) {
                this.f25717h = viewGroup;
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
        VideoRecommentPlayActivityConfig videoRecommentPlayActivityConfig = new VideoRecommentPlayActivityConfig(this.f25714e, arrayList, null, null);
        videoRecommentPlayActivityConfig.setParamIsVertail(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoRecommentPlayActivityConfig));
    }

    public void j(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, arrayList) == null) {
            this.f25716g = arrayList;
        }
    }
}
