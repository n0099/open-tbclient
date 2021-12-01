package c.a.r0.n1.l.c;

import android.text.SpannableString;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.d.l;
import c.a.d.f.p.j;
import c.a.d.m.e.n;
import c.a.q0.d1.i0;
import c.a.q0.d1.l0;
import c.a.q0.d1.q;
import c.a.q0.s.q.d2;
import c.a.r0.g0.f0.k;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.video.message.VideoTabHttpResMessage;
import com.baidu.tieba.homepage.video.message.VideoTabRequestMessage;
import com.baidu.tieba.homepage.video.message.VideoTabSocketResMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.RecomVideo.DataRes;
import tbclient.RecomVideo.ThreadPersonalized;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public f f20745b;

    /* renamed from: c  reason: collision with root package name */
    public List<n> f20746c;

    /* renamed from: d  reason: collision with root package name */
    public List<ThreadInfo> f20747d;

    /* renamed from: e  reason: collision with root package name */
    public List<ThreadPersonalized> f20748e;

    /* renamed from: f  reason: collision with root package name */
    public DataRes.Builder f20749f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f20750g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f20751h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.d.c.g.a f20752i;

    /* loaded from: classes6.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.f20750g = false;
                this.a.f20751h = false;
                if (responsedMessage != null) {
                    this.a.g(responsedMessage);
                } else if (this.a.f20745b != null) {
                    this.a.f20745b.b(-1, "", false);
                }
            }
        }
    }

    /* renamed from: c.a.r0.n1.l.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1228b extends i0<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1228b(b bVar) {
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
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.i0
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            byte[] bArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.q0.s.r.a.f();
                l<byte[]> e2 = c.a.q0.s.r.a.e("tb.video_tab", TbadkCoreApplication.getCurrentAccount());
                if (e2 != null && (bArr = e2.get(TbadkCoreApplication.getCurrentAccount())) != null && bArr.length != 0) {
                    try {
                        return (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                    } catch (IOException e3) {
                        BdLog.e(e3);
                    }
                }
                return null;
            }
            return (DataRes) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements q<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public c(b bVar) {
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
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.q
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) || dataRes == null) {
                return;
            }
            this.a.f20749f = new DataRes.Builder(dataRes);
            int count = ListUtils.getCount(dataRes.thread_list);
            if (count > 0) {
                this.a.i(dataRes, false);
                if (this.a.f20745b != null) {
                    this.a.f20745b.a(count, false, true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends c.a.q0.f1.n.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.g0.f0.b l;
        public final /* synthetic */ d2 m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(b bVar, int i2, String str, c.a.r0.g0.f0.b bVar2, d2 d2Var) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2), str, bVar2, d2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = bVar2;
            this.m = d2Var;
        }

        @Override // c.a.q0.f1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.r0.n1.l.d.a.e(this.l);
                PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(view.getContext(), d(), null);
                personInfoActivityConfig.setIsVideoThread(this.m.t1() != null);
                personInfoActivityConfig.setVideoPersonFrom("home");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends i0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DataRes.Builder a;

        public e(b bVar, DataRes.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, builder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = builder;
        }

        @Override // c.a.q0.d1.i0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes.Builder builder = new DataRes.Builder(this.a.build(true));
                c.a.q0.s.r.a.f();
                try {
                    c.a.q0.s.r.a.e("tb.video_tab", TbadkCoreApplication.getCurrentAccount()).g(TbadkCoreApplication.getCurrentAccount(), builder.build(true).toByteArray());
                    return null;
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface f {
        void a(int i2, boolean z, boolean z2);

        void b(int i2, String str, boolean z);
    }

    public b(TbPageContext tbPageContext, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20751h = true;
        this.f20752i = new a(this, CmdConfigHttp.CMD_VIDEO_TAB, 309648);
        this.a = tbPageContext;
        this.f20745b = fVar;
        this.f20746c = new LinkedList();
        this.f20747d = new LinkedList();
        this.f20748e = new LinkedList();
        c.a.q0.z0.b bVar = new c.a.q0.z0.b(309648);
        bVar.setResponsedClass(VideoTabSocketResMessage.class);
        bVar.g(true);
        MessageManager.getInstance().registerTask(bVar);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_TAB, c.a.r0.t3.f0.a.a(TbConfig.URL_VIDEO_TAB, 309648));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(VideoTabHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public final void g(ResponsedMessage<?> responsedMessage) {
        DataRes dataRes;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
            if (responsedMessage instanceof VideoTabSocketResMessage) {
                dataRes = ((VideoTabSocketResMessage) responsedMessage).mResultData;
            } else {
                dataRes = responsedMessage instanceof VideoTabHttpResMessage ? ((VideoTabHttpResMessage) responsedMessage).mResultData : null;
            }
            boolean z = responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof VideoTabRequestMessage) && ((VideoTabRequestMessage) responsedMessage.getOrginalMessage().getExtra()).load_type == 2;
            if (dataRes == null || ListUtils.getCount(dataRes.thread_list) <= 0) {
                i2 = 0;
            } else {
                i2 = ListUtils.getCount(dataRes.thread_list);
                i(dataRes, z);
                if (!ListUtils.isEmpty(dataRes.thread_list)) {
                    t(z);
                }
            }
            if (this.f20745b != null) {
                if (responsedMessage.getError() != 0) {
                    this.f20745b.b(responsedMessage.getError(), responsedMessage.getErrorString(), z);
                } else {
                    this.f20745b.a(i2, z, false);
                }
            }
        }
    }

    public List<n> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20746c : (List) invokeV.objValue;
    }

    public final void i(DataRes dataRes, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, dataRes, z) == null) {
            m(dataRes.thread_list, !z);
            n(dataRes.thread_personalized, !z);
            List<n> s = s();
            this.f20746c = s;
            c.a.r0.n1.l.c.a.b(this.f20748e, s);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f20750g) {
            return;
        }
        this.f20750g = true;
        if (this.f20751h) {
            k();
            this.f20751h = false;
        }
        VideoTabRequestMessage videoTabRequestMessage = new VideoTabRequestMessage();
        videoTabRequestMessage.new_net_type = j.I();
        videoTabRequestMessage.load_type = 1;
        videoTabRequestMessage.page_thread_count = 12;
        videoTabRequestMessage.setNetType(NetMessage.NetType.HTTP);
        this.a.sendMessage(videoTabRequestMessage);
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            l0.b(new C1228b(this), new c(this));
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f20750g) {
            return;
        }
        this.f20750g = true;
        VideoTabRequestMessage videoTabRequestMessage = new VideoTabRequestMessage();
        videoTabRequestMessage.new_net_type = j.I();
        videoTabRequestMessage.load_type = 2;
        videoTabRequestMessage.page_thread_count = 12;
        videoTabRequestMessage.setNetType(NetMessage.NetType.HTTP);
        this.a.sendMessage(videoTabRequestMessage);
    }

    public final void m(List<ThreadInfo> list, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048582, this, list, z) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (z) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(list);
            linkedList.addAll(this.f20747d);
            this.f20747d.clear();
            this.f20747d.addAll(linkedList);
            return;
        }
        this.f20747d.addAll(list);
    }

    public final void n(List<ThreadPersonalized> list, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048583, this, list, z) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (z) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(list);
            linkedList.addAll(this.f20748e);
            this.f20748e.clear();
            this.f20748e.addAll(linkedList);
            return;
        }
        this.f20748e.addAll(list);
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f20752i);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            MessageManager.getInstance().registerListener(this.f20752i);
        }
    }

    public void q(String str) {
        DataRes.Builder builder;
        Long l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || (builder = this.f20749f) == null || ListUtils.isEmpty(builder.thread_list)) {
            return;
        }
        long g2 = c.a.d.f.m.b.g(str, 0L);
        for (int i2 = 0; i2 < this.f20749f.thread_list.size(); i2++) {
            ThreadInfo threadInfo = this.f20749f.thread_list.get(i2);
            if (threadInfo != null && (l = threadInfo.tid) != null && l.longValue() == g2) {
                this.f20749f.thread_list.remove(i2);
                v(this.f20749f);
                return;
            }
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || ListUtils.isEmpty(this.f20746c)) {
            return;
        }
        Iterator<n> it = this.f20746c.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof c.a.r0.g0.f0.b) {
                c.a.r0.g0.f0.b bVar = (c.a.r0.g0.f0.b) next;
                if (bVar.getThreadData() != null && bVar.getThreadData().v1() != null && bVar.getThreadData().v1().equals(str)) {
                    it.remove();
                }
            }
        }
    }

    public final List<n> s() {
        InterceptResult invokeV;
        k g2;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            LinkedList linkedList = new LinkedList();
            if (ListUtils.isEmpty(this.f20747d)) {
                return linkedList;
            }
            char c2 = 0;
            int i2 = 0;
            for (ThreadInfo threadInfo : this.f20747d) {
                d2 d2Var2 = new d2();
                d2Var2.c3(threadInfo);
                d2Var2.d2 = true;
                if (c.a.r0.g0.f0.l.T(d2Var2)) {
                    k g3 = c.a.r0.n1.h.k.e.g(d2Var2);
                    if (g3 != null && (d2Var = g3.f17245e) != null && d2Var.Z() != null && !StringUtils.isNull(g3.f17245e.Z().f13108b) && !g3.f17245e.M2()) {
                        g3.l = d2Var2.v1();
                        g3.position = i2;
                        c.a.r0.n1.h.k.e.r(g3);
                        linkedList.add(g3);
                    } else {
                        k g4 = c.a.r0.n1.h.k.e.g(d2Var2);
                        if (g4 != null) {
                            g4.l = d2Var2.v1();
                            g4.position = i2;
                            c.a.r0.n1.h.k.e.t(g4);
                        }
                        if (g4 != null && g4.isValid()) {
                            linkedList.add(g4);
                        }
                    }
                    int[] h0 = d2Var2.h0();
                    c.a.r0.g0.f0.b e2 = c.a.r0.n1.h.k.e.e(d2Var2);
                    if (e2 != null) {
                        e2.l = d2Var2.v1();
                        e2.position = i2;
                        if (e2 instanceof k) {
                            if (d2Var2.Q1()) {
                                c.a.r0.n1.h.k.e.u(e2);
                            } else if (d2Var2.h3() == 1) {
                                c.a.r0.n1.h.k.e.w(e2);
                                e2.o = h0[c2];
                                e2.p = h0[1];
                            } else if (d2Var2.h3() >= 2) {
                                c.a.r0.n1.h.k.e.v(e2);
                            } else {
                                c.a.r0.n1.h.k.e.x(e2);
                            }
                        } else if (e2 instanceof c.a.r0.g0.f0.l) {
                            c.a.r0.n1.h.k.e.y(e2);
                        }
                    }
                    if (e2 != null && e2.isValid()) {
                        if (!d2Var2.G2() && d2Var2.J() != null && d2Var2.Z() != null && !StringUtils.isNull(d2Var2.Z().f13108b)) {
                            String string = TbadkCoreApplication.getInst().getString(R.string.at_username);
                            Object[] objArr = new Object[1];
                            objArr[c2] = d2Var2.J().getName_show();
                            String format = String.format(string, objArr);
                            SpannableString spannableString = new SpannableString(format);
                            spannableString.setSpan(new d(this, 16, d2Var2.J().getUserId(), e2, d2Var2), 0, format.length() - 1, 33);
                            e2.f17245e.K1(spannableString);
                        }
                        linkedList.add(e2);
                    }
                    if (d2Var2.showCardEnterFourm() && (g2 = c.a.r0.n1.h.k.e.g(d2Var2)) != null) {
                        g2.l = d2Var2.v1();
                        g2.position = i2;
                        c.a.r0.n1.h.k.e.q(g2);
                        if (k.Y(d2Var2)) {
                            g2.N("1");
                        } else if (c.a.r0.g0.f0.l.T(d2Var2)) {
                            g2.N("2");
                        }
                        if (d2Var2.showCardEnterFourm() && !StringUtils.isNull(d2Var2.a0())) {
                            linkedList.add(g2);
                        } else if (!StringUtils.isNull(d2Var2.a0())) {
                            linkedList.add(g2);
                        }
                    }
                    if (threadInfo.top_agree_post != null) {
                        k g5 = c.a.r0.n1.h.k.e.g(d2Var2);
                        if (g5 != null) {
                            g5.l = d2Var2.v1();
                            g5.position = i2;
                            c.a.r0.n1.h.k.e.s(g5);
                        }
                        if (g5 != null && g5.isValid()) {
                            linkedList.add(g5);
                        }
                    }
                    k g6 = c.a.r0.n1.h.k.e.g(d2Var2);
                    if (g6 != null) {
                        g6.l = d2Var2.v1();
                        g6.position = i2;
                        c.a.r0.n1.h.k.e.p(g6);
                    }
                    if (g6 != null && g6.isValid()) {
                        linkedList.add(g6);
                    }
                    i2++;
                }
                c2 = 0;
            }
            c.a.q0.b.f.a.d(linkedList);
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            DataRes.Builder builder = new DataRes.Builder();
            if (ListUtils.getCount(this.f20747d) < 12) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f20747d);
                builder.thread_list = arrayList;
                u(builder, false);
            } else if (z) {
                List<ThreadInfo> list = this.f20747d;
                builder.thread_list = list.subList(list.size() - 12, this.f20747d.size());
                u(builder, true);
            } else {
                builder.thread_list = this.f20747d.subList(0, 12);
                u(builder, false);
            }
            this.f20749f = builder;
            v(builder);
        }
    }

    public final void u(DataRes.Builder builder, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048590, this, builder, z) == null) || builder == null) {
            return;
        }
        if (ListUtils.getCount(this.f20748e) < 12) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.f20748e);
            builder.thread_personalized = linkedList;
        } else if (z) {
            List<ThreadPersonalized> list = this.f20748e;
            builder.thread_personalized = list.subList(list.size() - 12, this.f20748e.size());
        } else {
            builder.thread_personalized = this.f20748e.subList(0, 12);
        }
    }

    public final void v(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, builder) == null) {
            l0.b(new e(this, builder), null);
        }
    }
}
