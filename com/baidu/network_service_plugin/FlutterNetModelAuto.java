package com.baidu.network_service_plugin;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcJsonHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.h0.g0.b.g;
import d.b.h0.g0.b.h;
import d.b.x.b;
import java.util.HashMap;
import java.util.Map;
import protobuf.Error;
/* loaded from: classes2.dex */
public class FlutterNetModelAuto<T extends d.b.h0.g0.b.g, D extends d.b.h0.g0.b.h> implements b.d {

    /* renamed from: a  reason: collision with root package name */
    public Class<D> f9277a;

    /* renamed from: d  reason: collision with root package name */
    public i<T, D> f9280d;

    /* renamed from: e  reason: collision with root package name */
    public j<T, D> f9281e;

    /* renamed from: f  reason: collision with root package name */
    public T f9282f;

    /* renamed from: g  reason: collision with root package name */
    public TbSocketMessage f9283g;

    /* renamed from: h  reason: collision with root package name */
    public String f9284h;
    public int j;
    public int k;
    public String l;
    public final NetModelType m;
    public boolean r;
    public Runnable u;

    /* renamed from: b  reason: collision with root package name */
    public boolean f9278b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f9279c = false;
    public BdUniqueId i = null;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;
    public boolean q = false;
    public int s = -1;
    public boolean t = true;

    /* loaded from: classes2.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f9285a;

        static {
            int[] iArr = new int[NetModelType.values().length];
            f9285a = iArr;
            try {
                iArr[NetModelType.TYPE_AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9285a[NetModelType.TYPE_SOCKET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9285a[NetModelType.TYPE_HTTP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = a.f9285a[FlutterNetModelAuto.this.m.ordinal()];
            if (i == 1) {
                FlutterNetModelAuto.this.C(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
            } else if (i == 2) {
                FlutterNetModelAuto.this.D(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
            } else if (i != 3) {
            } else {
                FlutterNetModelAuto.this.B(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FlutterNetModelAuto.this.C(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FlutterNetModelAuto.this.B(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FlutterNetModelAuto.this.D(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
        }
    }

    /* loaded from: classes2.dex */
    public class f extends d.b.b.c.g.a {
        public f(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            FlutterNetModelAuto.this.r = false;
            if (FlutterNetModelAuto.this.u != null) {
                d.b.b.e.m.e.a().removeCallbacks(FlutterNetModelAuto.this.u);
            }
            if (responsedMessage instanceof MvcProtobufHttpResponsedMessage) {
                MvcNetMessage<T, D> mvcNetMessage = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                if (FlutterNetModelAuto.this.f9280d != null) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("server", FlutterNetModelAuto.this.r());
                    hashMap.put(RetrieveTaskManager.KEY, FlutterNetModelAuto.this.o() + "");
                    hashMap.put("state", responsedMessage.getError() + "_" + responsedMessage.getErrorString());
                    FlutterNetModelAuto.this.f9280d.a(FlutterNetModelAuto.this.f9284h, hashMap, (MvcProtobufHttpResponsedMessage) responsedMessage, null, mvcNetMessage);
                }
            } else if (responsedMessage instanceof SocketResponsedMessage) {
                MvcNetMessage<T, D> mvcNetMessage2 = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                if (FlutterNetModelAuto.this.f9281e != null) {
                    HashMap<String, String> hashMap2 = new HashMap<>();
                    hashMap2.put(RetrieveTaskManager.KEY, FlutterNetModelAuto.this.v() + "");
                    hashMap2.put("state", responsedMessage.getError() + "_" + responsedMessage.getErrorString());
                    FlutterNetModelAuto.this.f9281e.a(FlutterNetModelAuto.this.f9284h, hashMap2, (SocketResponsedMessage) responsedMessage, null, mvcNetMessage2);
                }
            } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                throw new RuntimeException("mvc netmodel NetListener responsedMessage error");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g extends HttpMessageListener {
        public g(int i, boolean z) {
            super(i, z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            FlutterNetModelAuto.this.r = false;
            if (FlutterNetModelAuto.this.u != null) {
                d.b.b.e.m.e.a().removeCallbacks(FlutterNetModelAuto.this.u);
            }
            if (httpResponsedMessage instanceof MvcJsonHttpResponsedMessage) {
                if (httpResponsedMessage.getOrginalMessage() instanceof MvcHttpMessage) {
                    if (FlutterNetModelAuto.this.f9280d != null) {
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put("server", FlutterNetModelAuto.this.r());
                        hashMap.put(RetrieveTaskManager.KEY, FlutterNetModelAuto.this.o() + "");
                        hashMap.put("state", httpResponsedMessage.getError() + "_" + httpResponsedMessage.getErrorString());
                        FlutterNetModelAuto.this.f9280d.a(FlutterNetModelAuto.this.f9284h, hashMap, (MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
                    }
                } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new RuntimeException("mvc netmodel HttpListener jsonHttpResponsedMessage originaMessage error");
                }
            } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                throw new RuntimeException("mvc netmodel HttpListener jsonHttpResponsedMessage error");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h extends d.b.b.c.g.c {
        public h(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            FlutterNetModelAuto.this.r = false;
            if (FlutterNetModelAuto.this.u != null) {
                d.b.b.e.m.e.a().removeCallbacks(FlutterNetModelAuto.this.u);
            }
            if (socketResponsedMessage instanceof MvcSocketResponsedMessage) {
                if (socketResponsedMessage.getOrginalMessage() instanceof MvcSocketMessage) {
                    if (FlutterNetModelAuto.this.f9281e != null) {
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put(RetrieveTaskManager.KEY, FlutterNetModelAuto.this.v() + "");
                        hashMap.put("state", socketResponsedMessage.getError() + "_" + socketResponsedMessage.getErrorString());
                        FlutterNetModelAuto.this.f9281e.a(FlutterNetModelAuto.this.f9284h, hashMap, socketResponsedMessage, (SocketMessage) socketResponsedMessage.getOrginalMessage(), null);
                    }
                } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new RuntimeException("mvc netmodel SocketListener socketResponsedMessage originaMessage error");
                }
            } else if (!(socketResponsedMessage instanceof SocketResponsedMessage) || FlutterNetModelAuto.this.f9281e == null) {
            } else {
                HashMap<String, String> hashMap2 = new HashMap<>();
                hashMap2.put(RetrieveTaskManager.KEY, FlutterNetModelAuto.this.v() + "");
                hashMap2.put("state", socketResponsedMessage.getError() + "_" + socketResponsedMessage.getErrorString());
                FlutterNetModelAuto.this.f9281e.a(FlutterNetModelAuto.this.f9284h, hashMap2, socketResponsedMessage, (SocketMessage) socketResponsedMessage.getOrginalMessage(), null);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface i<T extends d.b.h0.g0.b.g, D extends d.b.h0.g0.b.h> {
        void a(String str, HashMap<String, String> hashMap, MvcHttpResponsedMessage<D> mvcHttpResponsedMessage, MvcHttpMessage<T, D> mvcHttpMessage, MvcNetMessage<T, D> mvcNetMessage);
    }

    /* loaded from: classes2.dex */
    public interface j<T extends d.b.h0.g0.b.g, D extends d.b.h0.g0.b.h> {
        void a(String str, HashMap<String, String> hashMap, SocketResponsedMessage socketResponsedMessage, SocketMessage socketMessage, NetMessage netMessage);
    }

    public FlutterNetModelAuto(String str, NetModelType netModelType) {
        this.f9284h = str;
        this.m = netModelType;
    }

    public boolean A() {
        if (this.f9281e == null && this.f9280d == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.t = l.C();
        if (this.s >= 10) {
            d.b.b.e.m.e.a().postDelayed(x(), this.s * 1000);
        }
        int i2 = a.f9285a[this.m.ordinal()];
        if (i2 == 1) {
            if (!this.t) {
                d.b.b.e.m.e.a().post(new c());
                return false;
            }
            l();
            n();
            m();
            MvcNetMessage mvcNetMessage = new MvcNetMessage(this.f9282f, o(), v());
            mvcNetMessage.setNeedCache(z());
            mvcNetMessage.setResponseDataClass(u());
            mvcNetMessage.setTag(this.i);
            HashMap<String, String> p = this.f9282f.p();
            if (p != null) {
                for (Map.Entry<String, String> entry : p.entrySet()) {
                    mvcNetMessage.getHttpMessage().addHeader(entry.getKey(), entry.getValue());
                }
            }
            MessageManager.getInstance().sendMessage(mvcNetMessage);
            return true;
        } else if (i2 == 2) {
            if (!this.t) {
                d.b.b.e.m.e.a().post(new e());
                return false;
            }
            n();
            m();
            if (this.f9282f != null) {
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.f9282f, v());
                mvcSocketMessage.setResponseDataClass(u());
                mvcSocketMessage.setNeedCache(z());
                mvcSocketMessage.setTag(this.i);
                MessageManager.getInstance().sendMessage(mvcSocketMessage);
            }
            if (this.f9283g != null) {
                MessageManager.getInstance().sendMessage(this.f9283g);
            }
            return true;
        } else if (i2 != 3) {
            return false;
        } else {
            if (!this.t) {
                d.b.b.e.m.e.a().post(new d());
                return false;
            }
            k();
            m();
            MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.f9282f, o());
            mvcHttpMessage.setResponseDataClass(u());
            HashMap<String, Object> k = this.f9282f.k();
            if (k != null) {
                for (Map.Entry<String, Object> entry2 : k.entrySet()) {
                    mvcHttpMessage.addParam(entry2.getKey(), entry2.getValue());
                }
            }
            HashMap<String, String> p2 = this.f9282f.p();
            if (p2 != null) {
                for (Map.Entry<String, String> entry3 : p2.entrySet()) {
                    mvcHttpMessage.addHeader(entry3.getKey(), entry3.getValue());
                }
            }
            mvcHttpMessage.setNeedCache(z());
            mvcHttpMessage.setTag(this.i);
            MessageManager.getInstance().sendMessage(mvcHttpMessage);
            return true;
        }
    }

    public final void B(int i2, String str) {
        if (this.f9280d != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.f9282f, o());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(o());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i2);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(RetrieveTaskManager.KEY, o() + "");
            this.f9280d.a(this.f9284h, hashMap, mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    public final void C(int i2, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.f9282f, o(), v());
        if (this.f9281e != null) {
            MvcSocketResponsedMessage mvcSocketResponsedMessage = new MvcSocketResponsedMessage(v()) { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.8
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                public Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i2);
            mvcSocketResponsedMessage.setErrorString(str);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(RetrieveTaskManager.KEY, v() + "");
            this.f9281e.a(this.f9284h, hashMap, mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.f9280d != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(o()) { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.9
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                public Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i2);
            mvcHttpResponsedMessage.setErrorString(str);
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put(RetrieveTaskManager.KEY, o() + "");
            this.f9280d.a(this.f9284h, hashMap2, mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    public final void D(int i2, String str) {
        MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.f9282f, v());
        MvcSocketResponsedMessage mvcSocketResponsedMessage = new MvcSocketResponsedMessage(v()) { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.10
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            public Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i2);
        mvcSocketResponsedMessage.setErrorString(str);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(RetrieveTaskManager.KEY, v() + "");
        this.f9281e.a(this.f9284h, hashMap, mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    public void E(TbHttpMessageTask tbHttpMessageTask) {
    }

    public void F(TbHttpMessageTask tbHttpMessageTask) {
    }

    public void G(d.b.h0.v0.b bVar) {
    }

    public void H(i<T, D> iVar) {
        this.f9280d = iVar;
    }

    public void I(int i2) {
        this.k = i2;
    }

    public void J(String str) {
        this.l = str;
    }

    public void K(boolean z) {
        this.f9278b = z;
    }

    public void L(boolean z) {
        this.f9279c = z;
    }

    public void M(Class<T> cls) {
    }

    public void N(Class<D> cls) {
        this.f9277a = cls;
    }

    public void O(j<T, D> jVar) {
        this.f9281e = jVar;
    }

    public void P(int i2) {
        this.j = i2;
    }

    public void Q(TbSocketMessage tbSocketMessage) {
        this.f9283g = tbSocketMessage;
    }

    public void R(BdUniqueId bdUniqueId) {
        this.i = bdUniqueId;
    }

    @Override // d.b.x.b.d
    public boolean a() {
        MessageManager.getInstance().removeMessage(v(), this.i);
        MessageManager.getInstance().removeMessage(o(), this.i);
        return true;
    }

    public final void k() {
        if (this.o || MessageManager.getInstance().findTask(o()) != null) {
            return;
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(o(), r());
        tbHttpMessageTask.setResponsedClass(p());
        E(tbHttpMessageTask);
        MessageManager.getInstance().unRegisterTask(o());
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.o = true;
    }

    public final void l() {
        if (this.o || MessageManager.getInstance().findTask(o()) != null) {
            return;
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(o(), r() + "?cmd=" + v());
        tbHttpMessageTask.setResponsedClass(q());
        F(tbHttpMessageTask);
        MessageManager.getInstance().unRegisterTask(o());
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.o = true;
    }

    public final void m() {
        if (this.q) {
            return;
        }
        int i2 = a.f9285a[this.m.ordinal()];
        if (i2 == 1) {
            f fVar = new f(o(), v());
            fVar.getHttpMessageListener().setSelfListener(true);
            fVar.getSocketMessageListener().setSelfListener(true);
            fVar.setTag(y());
            MessageManager.getInstance().registerListener(fVar);
        } else if (i2 == 2) {
            h hVar = new h(v());
            hVar.setTag(y());
            MessageManager.getInstance().registerListener(hVar);
        } else if (i2 == 3) {
            g gVar = new g(o(), true);
            gVar.setTag(y());
            MessageManager.getInstance().registerListener(gVar);
        }
        this.q = true;
    }

    public final void n() {
        if (this.p || MessageManager.getInstance().findTask(v()) != null) {
            return;
        }
        d.b.h0.v0.b bVar = new d.b.h0.v0.b(v());
        bVar.setResponsedClass(w());
        bVar.h(s());
        if (t()) {
            bVar.setParallel(TiebaIMConfig.getParallel());
        }
        G(bVar);
        MessageManager.getInstance().unRegisterTask(v());
        MessageManager.getInstance().registerTask(bVar);
        this.p = true;
    }

    public int o() {
        return this.k;
    }

    public Class<? extends MvcJsonHttpResponsedMessage> p() {
        return MvcJsonHttpResponsedMessage.class;
    }

    public Class<? extends MvcProtobufHttpResponsedMessage> q() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    public String r() {
        return this.l;
    }

    public boolean s() {
        return this.f9278b;
    }

    public boolean t() {
        return this.f9279c;
    }

    public Class<D> u() {
        return this.f9277a;
    }

    public int v() {
        return this.j;
    }

    public Class<? extends MvcSocketResponsedMessage> w() {
        return MvcSocketResponsedMessage.class;
    }

    public Runnable x() {
        if (this.u == null) {
            this.u = new b();
        }
        return this.u;
    }

    public BdUniqueId y() {
        return this.i;
    }

    public boolean z() {
        return this.n;
    }
}
