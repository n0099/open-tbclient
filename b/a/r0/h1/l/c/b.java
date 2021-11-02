package b.a.r0.h1.l.c;

import android.text.SpannableString;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.d.l;
import b.a.e.e.p.j;
import b.a.e.l.e.n;
import b.a.q0.d1.i0;
import b.a.q0.d1.l0;
import b.a.q0.d1.q;
import b.a.q0.s.q.d2;
import b.a.r0.b0.e0.k;
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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f17691a;

    /* renamed from: b  reason: collision with root package name */
    public f f17692b;

    /* renamed from: c  reason: collision with root package name */
    public List<n> f17693c;

    /* renamed from: d  reason: collision with root package name */
    public List<ThreadInfo> f17694d;

    /* renamed from: e  reason: collision with root package name */
    public List<ThreadPersonalized> f17695e;

    /* renamed from: f  reason: collision with root package name */
    public DataRes.Builder f17696f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f17697g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f17698h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.e.c.g.a f17699i;

    /* loaded from: classes4.dex */
    public class a extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f17700a;

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
            this.f17700a = bVar;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f17700a.f17697g = false;
                this.f17700a.f17698h = false;
                if (responsedMessage != null) {
                    this.f17700a.g(responsedMessage);
                } else if (this.f17700a.f17692b != null) {
                    this.f17700a.f17692b.b(-1, "", false);
                }
            }
        }
    }

    /* renamed from: b.a.r0.h1.l.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0901b extends i0<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0901b(b bVar) {
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
        @Override // b.a.q0.d1.i0
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            byte[] bArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b.a.q0.s.r.a.f();
                l<byte[]> e2 = b.a.q0.s.r.a.e("tb.video_tab", TbadkCoreApplication.getCurrentAccount());
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

    /* loaded from: classes4.dex */
    public class c implements q<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f17701a;

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
            this.f17701a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.d1.q
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) || dataRes == null) {
                return;
            }
            this.f17701a.f17696f = new DataRes.Builder(dataRes);
            int count = ListUtils.getCount(dataRes.thread_list);
            if (count > 0) {
                this.f17701a.i(dataRes, false);
                if (this.f17701a.f17692b != null) {
                    this.f17701a.f17692b.a(count, false, true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends b.a.q0.f1.n.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b.a.r0.b0.e0.b l;
        public final /* synthetic */ d2 m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(b bVar, int i2, String str, b.a.r0.b0.e0.b bVar2, d2 d2Var) {
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

        @Override // b.a.q0.f1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b.a.r0.h1.l.d.a.e(this.l);
                PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(view.getContext(), d(), null);
                personInfoActivityConfig.setIsVideoThread(this.m.q1() != null);
                personInfoActivityConfig.setVideoPersonFrom("home");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends i0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataRes.Builder f17702a;

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
            this.f17702a = builder;
        }

        @Override // b.a.q0.d1.i0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes.Builder builder = new DataRes.Builder(this.f17702a.build(true));
                b.a.q0.s.r.a.f();
                try {
                    b.a.q0.s.r.a.e("tb.video_tab", TbadkCoreApplication.getCurrentAccount()).g(TbadkCoreApplication.getCurrentAccount(), builder.build(true).toByteArray());
                    return null;
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
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
        this.f17698h = true;
        this.f17699i = new a(this, CmdConfigHttp.CMD_VIDEO_TAB, 309648);
        this.f17691a = tbPageContext;
        this.f17692b = fVar;
        this.f17693c = new LinkedList();
        this.f17694d = new LinkedList();
        this.f17695e = new LinkedList();
        b.a.q0.z0.b bVar = new b.a.q0.z0.b(309648);
        bVar.setResponsedClass(VideoTabSocketResMessage.class);
        bVar.g(true);
        MessageManager.getInstance().registerTask(bVar);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_TAB, b.a.r0.l3.f0.a.a(TbConfig.URL_VIDEO_TAB, 309648));
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
            if (this.f17692b != null) {
                if (responsedMessage.getError() != 0) {
                    this.f17692b.b(responsedMessage.getError(), responsedMessage.getErrorString(), z);
                } else {
                    this.f17692b.a(i2, z, false);
                }
            }
        }
    }

    public List<n> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f17693c : (List) invokeV.objValue;
    }

    public final void i(DataRes dataRes, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, dataRes, z) == null) {
            m(dataRes.thread_list, !z);
            n(dataRes.thread_personalized, !z);
            List<n> s = s();
            this.f17693c = s;
            b.a.r0.h1.l.c.a.b(this.f17695e, s);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f17697g) {
            return;
        }
        this.f17697g = true;
        if (this.f17698h) {
            k();
            this.f17698h = false;
        }
        VideoTabRequestMessage videoTabRequestMessage = new VideoTabRequestMessage();
        videoTabRequestMessage.new_net_type = j.I();
        videoTabRequestMessage.load_type = 1;
        videoTabRequestMessage.page_thread_count = 12;
        videoTabRequestMessage.setNetType(NetMessage.NetType.HTTP);
        this.f17691a.sendMessage(videoTabRequestMessage);
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            l0.b(new C0901b(this), new c(this));
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f17697g) {
            return;
        }
        this.f17697g = true;
        VideoTabRequestMessage videoTabRequestMessage = new VideoTabRequestMessage();
        videoTabRequestMessage.new_net_type = j.I();
        videoTabRequestMessage.load_type = 2;
        videoTabRequestMessage.page_thread_count = 12;
        videoTabRequestMessage.setNetType(NetMessage.NetType.HTTP);
        this.f17691a.sendMessage(videoTabRequestMessage);
    }

    public final void m(List<ThreadInfo> list, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048582, this, list, z) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (z) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(list);
            linkedList.addAll(this.f17694d);
            this.f17694d.clear();
            this.f17694d.addAll(linkedList);
            return;
        }
        this.f17694d.addAll(list);
    }

    public final void n(List<ThreadPersonalized> list, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048583, this, list, z) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (z) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(list);
            linkedList.addAll(this.f17695e);
            this.f17695e.clear();
            this.f17695e.addAll(linkedList);
            return;
        }
        this.f17695e.addAll(list);
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f17699i);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            MessageManager.getInstance().registerListener(this.f17699i);
        }
    }

    public void q(String str) {
        DataRes.Builder builder;
        Long l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || (builder = this.f17696f) == null || ListUtils.isEmpty(builder.thread_list)) {
            return;
        }
        long g2 = b.a.e.e.m.b.g(str, 0L);
        for (int i2 = 0; i2 < this.f17696f.thread_list.size(); i2++) {
            ThreadInfo threadInfo = this.f17696f.thread_list.get(i2);
            if (threadInfo != null && (l = threadInfo.tid) != null && l.longValue() == g2) {
                this.f17696f.thread_list.remove(i2);
                v(this.f17696f);
                return;
            }
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || ListUtils.isEmpty(this.f17693c)) {
            return;
        }
        Iterator<n> it = this.f17693c.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof b.a.r0.b0.e0.b) {
                b.a.r0.b0.e0.b bVar = (b.a.r0.b0.e0.b) next;
                if (bVar.getThreadData() != null && bVar.getThreadData().s1() != null && bVar.getThreadData().s1().equals(str)) {
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
            if (ListUtils.isEmpty(this.f17694d)) {
                return linkedList;
            }
            char c2 = 0;
            int i2 = 0;
            for (ThreadInfo threadInfo : this.f17694d) {
                d2 d2Var2 = new d2();
                d2Var2.Y2(threadInfo);
                d2Var2.c2 = true;
                if (b.a.r0.b0.e0.l.T(d2Var2)) {
                    k g3 = b.a.r0.h1.h.k.e.g(d2Var2);
                    if (g3 != null && (d2Var = g3.f14748e) != null && d2Var.Y() != null && !StringUtils.isNull(g3.f14748e.Y().f13506b) && !g3.f14748e.I2()) {
                        g3.l = d2Var2.s1();
                        g3.position = i2;
                        b.a.r0.h1.h.k.e.r(g3);
                        linkedList.add(g3);
                    } else {
                        k g4 = b.a.r0.h1.h.k.e.g(d2Var2);
                        if (g4 != null) {
                            g4.l = d2Var2.s1();
                            g4.position = i2;
                            b.a.r0.h1.h.k.e.t(g4);
                        }
                        if (g4 != null && g4.isValid()) {
                            linkedList.add(g4);
                        }
                    }
                    int[] g0 = d2Var2.g0();
                    b.a.r0.b0.e0.b e2 = b.a.r0.h1.h.k.e.e(d2Var2);
                    if (e2 != null) {
                        e2.l = d2Var2.s1();
                        e2.position = i2;
                        if (e2 instanceof k) {
                            if (d2Var2.N1()) {
                                b.a.r0.h1.h.k.e.u(e2);
                            } else if (d2Var2.d3() == 1) {
                                b.a.r0.h1.h.k.e.w(e2);
                                e2.o = g0[c2];
                                e2.p = g0[1];
                            } else if (d2Var2.d3() >= 2) {
                                b.a.r0.h1.h.k.e.v(e2);
                            } else {
                                b.a.r0.h1.h.k.e.x(e2);
                            }
                        } else if (e2 instanceof b.a.r0.b0.e0.l) {
                            b.a.r0.h1.h.k.e.y(e2);
                        }
                    }
                    if (e2 != null && e2.isValid()) {
                        if (!d2Var2.D2() && d2Var2.J() != null && d2Var2.Y() != null && !StringUtils.isNull(d2Var2.Y().f13506b)) {
                            String string = TbadkCoreApplication.getInst().getString(R.string.at_username);
                            Object[] objArr = new Object[1];
                            objArr[c2] = d2Var2.J().getName_show();
                            String format = String.format(string, objArr);
                            SpannableString spannableString = new SpannableString(format);
                            spannableString.setSpan(new d(this, 16, d2Var2.J().getUserId(), e2, d2Var2), 0, format.length() - 1, 33);
                            e2.f14748e.H1(spannableString);
                        }
                        linkedList.add(e2);
                    }
                    if (d2Var2.showCardEnterFourm() && (g2 = b.a.r0.h1.h.k.e.g(d2Var2)) != null) {
                        g2.l = d2Var2.s1();
                        g2.position = i2;
                        b.a.r0.h1.h.k.e.q(g2);
                        if (k.Y(d2Var2)) {
                            g2.N("1");
                        } else if (b.a.r0.b0.e0.l.T(d2Var2)) {
                            g2.N("2");
                        }
                        if (d2Var2.showCardEnterFourm() && !StringUtils.isNull(d2Var2.Z())) {
                            linkedList.add(g2);
                        } else if (!StringUtils.isNull(d2Var2.Z())) {
                            linkedList.add(g2);
                        }
                    }
                    if (threadInfo.top_agree_post != null) {
                        k g5 = b.a.r0.h1.h.k.e.g(d2Var2);
                        if (g5 != null) {
                            g5.l = d2Var2.s1();
                            g5.position = i2;
                            b.a.r0.h1.h.k.e.s(g5);
                        }
                        if (g5 != null && g5.isValid()) {
                            linkedList.add(g5);
                        }
                    }
                    k g6 = b.a.r0.h1.h.k.e.g(d2Var2);
                    if (g6 != null) {
                        g6.l = d2Var2.s1();
                        g6.position = i2;
                        b.a.r0.h1.h.k.e.p(g6);
                    }
                    if (g6 != null && g6.isValid()) {
                        linkedList.add(g6);
                    }
                    i2++;
                }
                c2 = 0;
            }
            b.a.q0.b.f.a.d(linkedList);
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            DataRes.Builder builder = new DataRes.Builder();
            if (ListUtils.getCount(this.f17694d) < 12) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f17694d);
                builder.thread_list = arrayList;
                u(builder, false);
            } else if (z) {
                List<ThreadInfo> list = this.f17694d;
                builder.thread_list = list.subList(list.size() - 12, this.f17694d.size());
                u(builder, true);
            } else {
                builder.thread_list = this.f17694d.subList(0, 12);
                u(builder, false);
            }
            this.f17696f = builder;
            v(builder);
        }
    }

    public final void u(DataRes.Builder builder, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048590, this, builder, z) == null) || builder == null) {
            return;
        }
        if (ListUtils.getCount(this.f17695e) < 12) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.f17695e);
            builder.thread_personalized = linkedList;
        } else if (z) {
            List<ThreadPersonalized> list = this.f17695e;
            builder.thread_personalized = list.subList(list.size() - 12, this.f17695e.size());
        } else {
            builder.thread_personalized = this.f17695e.subList(0, 12);
        }
    }

    public final void v(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, builder) == null) {
            l0.b(new e(this, builder), null);
        }
    }
}
