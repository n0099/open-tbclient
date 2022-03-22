package c.a.p0.b3.h;

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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public ReportThemeActivity f12762b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<n> f12763c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f12764d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<String> f12765e;

    /* renamed from: f  reason: collision with root package name */
    public int f12766f;

    /* renamed from: c.a.p0.b3.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC0959a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ThreadData f12767b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f12768c;

        public View$OnClickListenerC0959a(a aVar, int i, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i), threadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12768c = aVar;
            this.a = i;
            this.f12767b = threadData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a == 40) {
                    this.f12768c.i(this.f12767b);
                } else {
                    this.f12768c.h(this.f12767b);
                }
                TiebaStatic.log(new StatisticItem("c14575").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f12767b.getFid()).param("fname", this.f12767b.getForum_name()).param("tid", this.f12767b.getTid()));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f12769b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ThreadData f12770c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f12771d;

        /* renamed from: c.a.p0.b3.h.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0960a extends Thread {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public C0960a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Message message = new Message();
                    message.what = 1;
                    if (this.a.f12771d.f12766f > this.a.f12771d.f12765e.size()) {
                        message.arg1 = this.a.f12771d.f12766f;
                        this.a.f12771d.f12766f = 0;
                    } else {
                        message.arg1 = this.a.f12771d.f12765e.size();
                    }
                    this.a.f12771d.f12762b.handler.sendMessage(message);
                }
            }
        }

        public b(a aVar, c cVar, String str, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar, str, threadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12771d = aVar;
            this.a = cVar;
            this.f12769b = str;
            this.f12770c = threadData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                view.setTag(Boolean.valueOf(!((Boolean) view.getTag()).booleanValue()));
                if (((Boolean) view.getTag()).booleanValue()) {
                    if (this.f12771d.f12765e.size() < 10) {
                        this.a.f12775e.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080998, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                        this.f12771d.f12765e.add(this.f12769b);
                        TiebaStatic.log(new StatisticItem("c14574").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f12770c.getFid()).param("fname", this.f12770c.getForum_name()).param("tid", this.f12770c.getTid()));
                    } else {
                        a aVar = this.f12771d;
                        aVar.f12766f = aVar.f12765e.size() + 1;
                    }
                } else {
                    this.a.f12775e.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080997, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                    this.f12771d.f12765e.remove(this.f12769b);
                }
                new C0960a(this).start();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f12772b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f12773c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f12774d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f12775e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f12776f;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ c(a aVar, View$OnClickListenerC0959a view$OnClickListenerC0959a) {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12764d = null;
        this.f12765e = null;
        this.f12766f = 0;
        this.f12762b = reportThemeActivity;
        this.a = reportThemeActivity.getPageContext().getContext();
        this.f12763c = arrayList;
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
            if (nVar instanceof c.a.p0.h0.e0.b) {
                View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d073c, (ViewGroup) null);
                cVar.a = inflate;
                cVar.f12772b = (LinearLayout) inflate.findViewById(R.id.list_item);
                cVar.f12773c = (TbImageView) cVar.a.findViewById(R.id.obfuscated_res_0x7f090707);
                cVar.f12774d = (TextView) cVar.a.findViewById(R.id.obfuscated_res_0x7f092032);
                cVar.f12775e = (ImageView) cVar.a.findViewById(R.id.obfuscated_res_0x7f090605);
                cVar.f12776f = (LinearLayout) cVar.a.findViewById(R.id.obfuscated_res_0x7f090606);
                c.a.o0.r.v.c.d(cVar.a).k(R.color.CAM_X0101);
                c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(cVar.f12772b);
                d2.n(R.string.J_X05);
                d2.f(R.color.CAM_X0206);
                c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(cVar.f12774d);
                d3.v(R.color.CAM_X0107);
                d3.z(R.dimen.T_X07);
                ThreadData threadData = ((c.a.p0.h0.e0.b) nVar).getThreadData();
                String tid = threadData.getTid();
                cVar.f12774d.setText(threadData.getTitle());
                if (threadData != null) {
                    if (threadData.isShareThread && (str = threadData.originalThreadData.f29823c) != null) {
                        cVar.f12773c.J(str, 33, false);
                    } else if (threadData.isRealVideoThread() && threadData.getThreadVideoInfo().thumbnail_url != null) {
                        cVar.f12773c.J(threadData.getThreadVideoInfo().thumbnail_url, 33, false);
                    } else if (threadData.threadType == 0 && threadData.getMedias().size() != 0) {
                        cVar.f12773c.J(threadData.getMedias().get(0).small_pic_url, 33, false);
                    } else {
                        cVar.f12773c.J(String.valueOf((int) R.drawable.obfuscated_res_0x7f080700), 24, false);
                    }
                }
                cVar.f12772b.setOnClickListener(new View$OnClickListenerC0959a(this, threadData.getThreadType(), threadData));
                this.f12765e = this.f12762b.getReportThemeList();
                boolean z = false;
                for (int i = 0; i < this.f12765e.size(); i++) {
                    if (tid.equals(this.f12765e.get(i))) {
                        z = true;
                    }
                }
                cVar.f12776f.setTag(Boolean.valueOf(z));
                if (((Boolean) cVar.f12776f.getTag()).booleanValue()) {
                    cVar.f12775e.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080998, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                } else {
                    cVar.f12775e.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080997, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                }
                cVar.f12776f.setOnClickListener(new b(this, cVar, tid, threadData));
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: g */
    public n getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? this.f12763c.get(i) : (n) invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList<n> arrayList = this.f12763c;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view, viewGroup)) == null) {
            if (this.f12764d == null) {
                this.f12764d = viewGroup;
            }
            n item = getItem(i);
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

    public void h(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, threadData) == null) || threadData == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(TbadkCoreApplication.getInst().getContext()).createNormalCfg(threadData.getTid(), null, null)));
    }

    public void i(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, threadData) == null) || threadData == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        videoItemData.thread_id = threadData.getTid();
        arrayList.add(videoItemData);
        VideoRecommentPlayActivityConfig videoRecommentPlayActivityConfig = new VideoRecommentPlayActivityConfig(this.a, arrayList, null, null);
        videoRecommentPlayActivityConfig.setParamIsVertail(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoRecommentPlayActivityConfig));
    }

    public void j(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, arrayList) == null) {
            this.f12763c = arrayList;
        }
    }
}
