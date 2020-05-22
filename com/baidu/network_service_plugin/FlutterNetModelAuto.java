package com.baidu.network_service_plugin;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.network_service_plugin.b;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.mvc.b.j;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcJsonHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import java.util.HashMap;
import java.util.Map;
import protobuf.Error;
/* loaded from: classes6.dex */
public class FlutterNetModelAuto<T extends h, D extends j> implements b.a {
    private String bsX;
    private Runnable bta;
    private Class<T> btj;
    private a<T, D> btl;
    private b<T, D> btm;
    protected T btn;
    private TbSocketMessage bto;
    private int btp;
    private int btq;
    private final NetModelType btr;
    private String identifier;
    private Class<D> responseDataClass;
    private boolean mNeedCompress = false;
    private boolean btk = false;
    protected BdUniqueId unique_id = null;
    private boolean isNeedCache = false;
    private boolean bts = false;
    private boolean btt = false;
    private boolean btu = false;
    private boolean isLoading = false;
    private int timeout = -1;
    private boolean bsZ = true;

    /* loaded from: classes6.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO
    }

    /* loaded from: classes6.dex */
    public interface a<T extends h, D extends j> {
        void a(String str, HashMap<String, String> hashMap, MvcHttpResponsedMessage<D> mvcHttpResponsedMessage, MvcHttpMessage<T, D> mvcHttpMessage, MvcNetMessage<T, D> mvcNetMessage);
    }

    /* loaded from: classes6.dex */
    public interface b<T extends h, D extends j> {
        void a(String str, HashMap<String, String> hashMap, SocketResponsedMessage socketResponsedMessage, SocketMessage socketMessage, NetMessage netMessage);
    }

    public FlutterNetModelAuto(String str, NetModelType netModelType) {
        this.identifier = str;
        this.btr = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TbSocketMessage tbSocketMessage) {
        this.bto = tbSocketMessage;
    }

    protected Class<D> getResponseDataClass() {
        return this.responseDataClass;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(Class<T> cls) {
        this.btj = cls;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setResponseDataClass(Class<D> cls) {
        this.responseDataClass = cls;
    }

    public int Ms() {
        return this.btp;
    }

    public int Mt() {
        return this.btq;
    }

    public void dC(int i) {
        this.btq = i;
    }

    public void dD(int i) {
        this.btp = i;
    }

    public String Mm() {
        return this.bsX;
    }

    public void go(String str) {
        this.bsX = str;
    }

    protected boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.unique_id = bdUniqueId;
    }

    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public void setNeedCompress(boolean z) {
        this.mNeedCompress = z;
    }

    public boolean getNeedCompress() {
        return this.mNeedCompress;
    }

    public void cQ(boolean z) {
        this.btk = z;
    }

    public boolean Mu() {
        return this.btk;
    }

    public Runnable Mr() {
        if (this.bta == null) {
            this.bta = new Runnable() { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (AnonymousClass2.btv[FlutterNetModelAuto.this.btr.ordinal()]) {
                        case 1:
                            FlutterNetModelAuto.this.H(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            return;
                        case 2:
                            FlutterNetModelAuto.this.I(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            return;
                        case 3:
                            FlutterNetModelAuto.this.G(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            return;
                        default:
                            return;
                    }
                }
            };
        }
        return this.bta;
    }

    public boolean loadData() {
        if (this.btm == null && this.btl == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.bsZ = l.isNetOk();
        if (this.timeout >= 10) {
            e.ld().postDelayed(Mr(), this.timeout * 1000);
        }
        switch (this.btr) {
            case TYPE_AUTO:
                if (!this.bsZ) {
                    e.ld().post(new Runnable() { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.3
                        @Override // java.lang.Runnable
                        public void run() {
                            FlutterNetModelAuto.this.H(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                Mz();
                MB();
                Mv();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.btn, Mt(), Ms());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                HashMap<String, String> beP = this.btn.beP();
                if (beP != null) {
                    for (Map.Entry<String, String> entry : beP.entrySet()) {
                        mvcNetMessage.getHttpMessage().addHeader(entry.getKey(), entry.getValue());
                    }
                }
                MessageManager.getInstance().sendMessage(mvcNetMessage);
                return true;
            case TYPE_SOCKET:
                if (!this.bsZ) {
                    e.ld().post(new Runnable() { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.5
                        @Override // java.lang.Runnable
                        public void run() {
                            FlutterNetModelAuto.this.I(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                MB();
                Mv();
                if (this.btn != null) {
                    MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.btn, Ms());
                    mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                    mvcSocketMessage.setNeedCache(isNeedCache());
                    mvcSocketMessage.setTag(this.unique_id);
                    MessageManager.getInstance().sendMessage(mvcSocketMessage);
                }
                if (this.bto != null) {
                    MessageManager.getInstance().sendMessage(this.bto);
                }
                return true;
            case TYPE_HTTP:
                if (!this.bsZ) {
                    e.ld().post(new Runnable() { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.4
                        @Override // java.lang.Runnable
                        public void run() {
                            FlutterNetModelAuto.this.G(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                MA();
                Mv();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.btn, Mt());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> beO = this.btn.beO();
                if (beO != null) {
                    for (Map.Entry<String, Object> entry2 : beO.entrySet()) {
                        mvcHttpMessage.addParam(entry2.getKey(), entry2.getValue());
                    }
                }
                HashMap<String, String> beP2 = this.btn.beP();
                if (beP2 != null) {
                    for (Map.Entry<String, String> entry3 : beP2.entrySet()) {
                        mvcHttpMessage.addHeader(entry3.getKey(), entry3.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                MessageManager.getInstance().sendMessage(mvcHttpMessage);
                return true;
            default:
                return false;
        }
    }

    private void Mv() {
        if (!this.btu) {
            switch (this.btr) {
                case TYPE_AUTO:
                    com.baidu.adp.framework.listener.a aVar = new com.baidu.adp.framework.listener.a(Mt(), Ms()) { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.6
                        @Override // com.baidu.adp.framework.listener.a
                        public void onMessage(ResponsedMessage<?> responsedMessage) {
                            FlutterNetModelAuto.this.isLoading = false;
                            if (FlutterNetModelAuto.this.bta != null) {
                                e.ld().removeCallbacks(FlutterNetModelAuto.this.bta);
                            }
                            if (responsedMessage instanceof MvcProtobufHttpResponsedMessage) {
                                MvcNetMessage<T, D> mvcNetMessage = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (FlutterNetModelAuto.this.btl != null) {
                                    HashMap<String, String> hashMap = new HashMap<>();
                                    hashMap.put("server", FlutterNetModelAuto.this.Mm());
                                    hashMap.put("api", FlutterNetModelAuto.this.Mt() + "");
                                    hashMap.put("state", responsedMessage.getError() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + responsedMessage.getErrorString());
                                    FlutterNetModelAuto.this.btl.a(FlutterNetModelAuto.this.identifier, hashMap, (MvcProtobufHttpResponsedMessage) responsedMessage, null, mvcNetMessage);
                                }
                            } else if (responsedMessage instanceof SocketResponsedMessage) {
                                MvcNetMessage mvcNetMessage2 = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (FlutterNetModelAuto.this.btm != null) {
                                    HashMap<String, String> hashMap2 = new HashMap<>();
                                    hashMap2.put("api", FlutterNetModelAuto.this.Ms() + "");
                                    hashMap2.put("state", responsedMessage.getError() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + responsedMessage.getErrorString());
                                    FlutterNetModelAuto.this.btm.a(FlutterNetModelAuto.this.identifier, hashMap2, (SocketResponsedMessage) responsedMessage, null, mvcNetMessage2);
                                }
                            } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                                throw new RuntimeException("mvc netmodel NetListener responsedMessage error");
                            }
                        }
                    };
                    aVar.getHttpMessageListener().setSelfListener(true);
                    aVar.getSocketMessageListener().setSelfListener(true);
                    aVar.setTag(getUniqueId());
                    MessageManager.getInstance().registerListener(aVar);
                    break;
                case TYPE_SOCKET:
                    com.baidu.adp.framework.listener.c cVar = new com.baidu.adp.framework.listener.c(Ms()) { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.11
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                            FlutterNetModelAuto.this.isLoading = false;
                            if (FlutterNetModelAuto.this.bta != null) {
                                e.ld().removeCallbacks(FlutterNetModelAuto.this.bta);
                            }
                            if (socketResponsedMessage instanceof MvcSocketResponsedMessage) {
                                if (socketResponsedMessage.getOrginalMessage() instanceof MvcSocketMessage) {
                                    if (FlutterNetModelAuto.this.btm != null) {
                                        HashMap<String, String> hashMap = new HashMap<>();
                                        hashMap.put("api", FlutterNetModelAuto.this.Ms() + "");
                                        hashMap.put("state", socketResponsedMessage.getError() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + socketResponsedMessage.getErrorString());
                                        FlutterNetModelAuto.this.btm.a(FlutterNetModelAuto.this.identifier, hashMap, socketResponsedMessage, (SocketMessage) socketResponsedMessage.getOrginalMessage(), null);
                                    }
                                } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                                    throw new RuntimeException("mvc netmodel SocketListener socketResponsedMessage originaMessage error");
                                }
                            } else if ((socketResponsedMessage instanceof SocketResponsedMessage) && FlutterNetModelAuto.this.btm != null) {
                                HashMap<String, String> hashMap2 = new HashMap<>();
                                hashMap2.put("api", FlutterNetModelAuto.this.Ms() + "");
                                hashMap2.put("state", socketResponsedMessage.getError() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + socketResponsedMessage.getErrorString());
                                FlutterNetModelAuto.this.btm.a(FlutterNetModelAuto.this.identifier, hashMap2, socketResponsedMessage, (SocketMessage) socketResponsedMessage.getOrginalMessage(), null);
                            }
                        }
                    };
                    cVar.setTag(getUniqueId());
                    MessageManager.getInstance().registerListener(cVar);
                    break;
                case TYPE_HTTP:
                    HttpMessageListener httpMessageListener = new HttpMessageListener(Mt(), true) { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.7
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                            FlutterNetModelAuto.this.isLoading = false;
                            if (FlutterNetModelAuto.this.bta != null) {
                                e.ld().removeCallbacks(FlutterNetModelAuto.this.bta);
                            }
                            if (httpResponsedMessage instanceof MvcJsonHttpResponsedMessage) {
                                if (httpResponsedMessage.getOrginalMessage() instanceof MvcHttpMessage) {
                                    if (FlutterNetModelAuto.this.btl != null) {
                                        HashMap<String, String> hashMap = new HashMap<>();
                                        hashMap.put("server", FlutterNetModelAuto.this.Mm());
                                        hashMap.put("api", FlutterNetModelAuto.this.Mt() + "");
                                        hashMap.put("state", httpResponsedMessage.getError() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + httpResponsedMessage.getErrorString());
                                        FlutterNetModelAuto.this.btl.a(FlutterNetModelAuto.this.identifier, hashMap, (MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
                                    }
                                } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                                    throw new RuntimeException("mvc netmodel HttpListener jsonHttpResponsedMessage originaMessage error");
                                }
                            } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                                throw new RuntimeException("mvc netmodel HttpListener jsonHttpResponsedMessage error");
                            }
                        }
                    };
                    httpMessageListener.setTag(getUniqueId());
                    MessageManager.getInstance().registerListener(httpMessageListener);
                    break;
            }
            this.btu = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> Mw() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> Mx() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> My() {
        return MvcSocketResponsedMessage.class;
    }

    private void Mz() {
        if (!this.bts && MessageManager.getInstance().findTask(Mt()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(Mt(), Mm() + "?cmd=" + Ms());
            tbHttpMessageTask.setResponsedClass(Mw());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(Mt());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.bts = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void MA() {
        if (!this.bts && MessageManager.getInstance().findTask(Mt()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(Mt(), Mm());
            tbHttpMessageTask.setResponsedClass(Mx());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(Mt());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.bts = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void MB() {
        if (!this.btt && MessageManager.getInstance().findTask(Ms()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(Ms());
            bVar.setResponsedClass(My());
            bVar.setNeedCompress(getNeedCompress());
            if (Mu()) {
                bVar.setParallel(TiebaIMConfig.getParallel());
            }
            a(bVar);
            MessageManager.getInstance().unRegisterTask(Ms());
            MessageManager.getInstance().registerTask(bVar);
            this.btt = true;
        }
    }

    protected void a(com.baidu.tbadk.task.b bVar) {
    }

    @Override // com.baidu.network_service_plugin.b.a
    public boolean cancelLoadData() {
        this.isLoading = false;
        MessageManager.getInstance().removeMessage(Ms(), this.unique_id);
        MessageManager.getInstance().removeMessage(Mt(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.btn, Mt(), Ms());
        if (this.btm != null) {
            MvcSocketResponsedMessage mvcSocketResponsedMessage = new MvcSocketResponsedMessage(Ms()) { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.8
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("api", Ms() + "");
            this.btm.a(this.identifier, hashMap, mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.btl != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(Mt()) { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.9
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("api", Mt() + "");
            this.btl.a(this.identifier, hashMap2, mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(int i, String str) {
        if (this.btl != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.btn, Mt());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(Mt());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("api", Mt() + "");
            this.btl.a(this.identifier, hashMap, mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i, String str) {
        MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.btn, Ms());
        MvcSocketResponsedMessage mvcSocketResponsedMessage = new MvcSocketResponsedMessage(Ms()) { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.10
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("api", Ms() + "");
        this.btm.a(this.identifier, hashMap, mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    public void a(a<T, D> aVar) {
        this.btl = aVar;
    }

    public void a(b<T, D> bVar) {
        this.btm = bVar;
    }
}
