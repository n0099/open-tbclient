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
/* loaded from: classes15.dex */
public class FlutterNetModelAuto<T extends h, D extends j> implements b.a {
    private Runnable cmC;
    private Class<T> cmL;
    private a<T, D> cmN;
    private b<T, D> cmO;
    protected T cmP;
    private TbSocketMessage cmQ;
    private int cmR;
    private int cmS;
    private final NetModelType cmT;
    private String cmz;
    private String identifier;
    private Class<D> responseDataClass;
    private boolean mNeedCompress = false;
    private boolean cmM = false;
    protected BdUniqueId unique_id = null;
    private boolean isNeedCache = false;
    private boolean cmU = false;
    private boolean cmV = false;
    private boolean cmW = false;
    private boolean isLoading = false;
    private int timeout = -1;
    private boolean cmB = true;

    /* loaded from: classes15.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO
    }

    /* loaded from: classes15.dex */
    public interface a<T extends h, D extends j> {
        void a(String str, HashMap<String, String> hashMap, MvcHttpResponsedMessage<D> mvcHttpResponsedMessage, MvcHttpMessage<T, D> mvcHttpMessage, MvcNetMessage<T, D> mvcNetMessage);
    }

    /* loaded from: classes15.dex */
    public interface b<T extends h, D extends j> {
        void a(String str, HashMap<String, String> hashMap, SocketResponsedMessage socketResponsedMessage, SocketMessage socketMessage, NetMessage netMessage);
    }

    public FlutterNetModelAuto(String str, NetModelType netModelType) {
        this.identifier = str;
        this.cmT = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TbSocketMessage tbSocketMessage) {
        this.cmQ = tbSocketMessage;
    }

    protected Class<D> getResponseDataClass() {
        return this.responseDataClass;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(Class<T> cls) {
        this.cmL = cls;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setResponseDataClass(Class<D> cls) {
        this.responseDataClass = cls;
    }

    public int aeS() {
        return this.cmR;
    }

    public int aeT() {
        return this.cmS;
    }

    public void hc(int i) {
        this.cmS = i;
    }

    public void hd(int i) {
        this.cmR = i;
    }

    public String aeM() {
        return this.cmz;
    }

    public void jO(String str) {
        this.cmz = str;
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

    public void ef(boolean z) {
        this.cmM = z;
    }

    public boolean aeU() {
        return this.cmM;
    }

    public Runnable aeR() {
        if (this.cmC == null) {
            this.cmC = new Runnable() { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (AnonymousClass2.cmX[FlutterNetModelAuto.this.cmT.ordinal()]) {
                        case 1:
                            FlutterNetModelAuto.this.ac(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            return;
                        case 2:
                            FlutterNetModelAuto.this.ad(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            return;
                        case 3:
                            FlutterNetModelAuto.this.ab(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            return;
                        default:
                            return;
                    }
                }
            };
        }
        return this.cmC;
    }

    public boolean loadData() {
        if (this.cmO == null && this.cmN == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.cmB = l.isNetOk();
        if (this.timeout >= 10) {
            e.mB().postDelayed(aeR(), this.timeout * 1000);
        }
        switch (this.cmT) {
            case TYPE_AUTO:
                if (!this.cmB) {
                    e.mB().post(new Runnable() { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.3
                        @Override // java.lang.Runnable
                        public void run() {
                            FlutterNetModelAuto.this.ac(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                aeZ();
                afb();
                aeV();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.cmP, aeT(), aeS());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                HashMap<String, String> bGL = this.cmP.bGL();
                if (bGL != null) {
                    for (Map.Entry<String, String> entry : bGL.entrySet()) {
                        mvcNetMessage.getHttpMessage().addHeader(entry.getKey(), entry.getValue());
                    }
                }
                MessageManager.getInstance().sendMessage(mvcNetMessage);
                return true;
            case TYPE_SOCKET:
                if (!this.cmB) {
                    e.mB().post(new Runnable() { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.5
                        @Override // java.lang.Runnable
                        public void run() {
                            FlutterNetModelAuto.this.ad(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                afb();
                aeV();
                if (this.cmP != null) {
                    MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.cmP, aeS());
                    mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                    mvcSocketMessage.setNeedCache(isNeedCache());
                    mvcSocketMessage.setTag(this.unique_id);
                    MessageManager.getInstance().sendMessage(mvcSocketMessage);
                }
                if (this.cmQ != null) {
                    MessageManager.getInstance().sendMessage(this.cmQ);
                }
                return true;
            case TYPE_HTTP:
                if (!this.cmB) {
                    e.mB().post(new Runnable() { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.4
                        @Override // java.lang.Runnable
                        public void run() {
                            FlutterNetModelAuto.this.ab(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                afa();
                aeV();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.cmP, aeT());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> bGK = this.cmP.bGK();
                if (bGK != null) {
                    for (Map.Entry<String, Object> entry2 : bGK.entrySet()) {
                        mvcHttpMessage.addParam(entry2.getKey(), entry2.getValue());
                    }
                }
                HashMap<String, String> bGL2 = this.cmP.bGL();
                if (bGL2 != null) {
                    for (Map.Entry<String, String> entry3 : bGL2.entrySet()) {
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

    private void aeV() {
        if (!this.cmW) {
            switch (this.cmT) {
                case TYPE_AUTO:
                    com.baidu.adp.framework.listener.a aVar = new com.baidu.adp.framework.listener.a(aeT(), aeS()) { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.6
                        @Override // com.baidu.adp.framework.listener.a
                        public void onMessage(ResponsedMessage<?> responsedMessage) {
                            FlutterNetModelAuto.this.isLoading = false;
                            if (FlutterNetModelAuto.this.cmC != null) {
                                e.mB().removeCallbacks(FlutterNetModelAuto.this.cmC);
                            }
                            if (responsedMessage instanceof MvcProtobufHttpResponsedMessage) {
                                MvcNetMessage<T, D> mvcNetMessage = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (FlutterNetModelAuto.this.cmN != null) {
                                    HashMap<String, String> hashMap = new HashMap<>();
                                    hashMap.put("server", FlutterNetModelAuto.this.aeM());
                                    hashMap.put("api", FlutterNetModelAuto.this.aeT() + "");
                                    hashMap.put("state", responsedMessage.getError() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + responsedMessage.getErrorString());
                                    FlutterNetModelAuto.this.cmN.a(FlutterNetModelAuto.this.identifier, hashMap, (MvcProtobufHttpResponsedMessage) responsedMessage, null, mvcNetMessage);
                                }
                            } else if (responsedMessage instanceof SocketResponsedMessage) {
                                MvcNetMessage mvcNetMessage2 = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (FlutterNetModelAuto.this.cmO != null) {
                                    HashMap<String, String> hashMap2 = new HashMap<>();
                                    hashMap2.put("api", FlutterNetModelAuto.this.aeS() + "");
                                    hashMap2.put("state", responsedMessage.getError() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + responsedMessage.getErrorString());
                                    FlutterNetModelAuto.this.cmO.a(FlutterNetModelAuto.this.identifier, hashMap2, (SocketResponsedMessage) responsedMessage, null, mvcNetMessage2);
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
                    com.baidu.adp.framework.listener.c cVar = new com.baidu.adp.framework.listener.c(aeS()) { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.11
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                            FlutterNetModelAuto.this.isLoading = false;
                            if (FlutterNetModelAuto.this.cmC != null) {
                                e.mB().removeCallbacks(FlutterNetModelAuto.this.cmC);
                            }
                            if (socketResponsedMessage instanceof MvcSocketResponsedMessage) {
                                if (socketResponsedMessage.getOrginalMessage() instanceof MvcSocketMessage) {
                                    if (FlutterNetModelAuto.this.cmO != null) {
                                        HashMap<String, String> hashMap = new HashMap<>();
                                        hashMap.put("api", FlutterNetModelAuto.this.aeS() + "");
                                        hashMap.put("state", socketResponsedMessage.getError() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + socketResponsedMessage.getErrorString());
                                        FlutterNetModelAuto.this.cmO.a(FlutterNetModelAuto.this.identifier, hashMap, socketResponsedMessage, (SocketMessage) socketResponsedMessage.getOrginalMessage(), null);
                                    }
                                } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                                    throw new RuntimeException("mvc netmodel SocketListener socketResponsedMessage originaMessage error");
                                }
                            } else if ((socketResponsedMessage instanceof SocketResponsedMessage) && FlutterNetModelAuto.this.cmO != null) {
                                HashMap<String, String> hashMap2 = new HashMap<>();
                                hashMap2.put("api", FlutterNetModelAuto.this.aeS() + "");
                                hashMap2.put("state", socketResponsedMessage.getError() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + socketResponsedMessage.getErrorString());
                                FlutterNetModelAuto.this.cmO.a(FlutterNetModelAuto.this.identifier, hashMap2, socketResponsedMessage, (SocketMessage) socketResponsedMessage.getOrginalMessage(), null);
                            }
                        }
                    };
                    cVar.setTag(getUniqueId());
                    MessageManager.getInstance().registerListener(cVar);
                    break;
                case TYPE_HTTP:
                    HttpMessageListener httpMessageListener = new HttpMessageListener(aeT(), true) { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.7
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                            FlutterNetModelAuto.this.isLoading = false;
                            if (FlutterNetModelAuto.this.cmC != null) {
                                e.mB().removeCallbacks(FlutterNetModelAuto.this.cmC);
                            }
                            if (httpResponsedMessage instanceof MvcJsonHttpResponsedMessage) {
                                if (httpResponsedMessage.getOrginalMessage() instanceof MvcHttpMessage) {
                                    if (FlutterNetModelAuto.this.cmN != null) {
                                        HashMap<String, String> hashMap = new HashMap<>();
                                        hashMap.put("server", FlutterNetModelAuto.this.aeM());
                                        hashMap.put("api", FlutterNetModelAuto.this.aeT() + "");
                                        hashMap.put("state", httpResponsedMessage.getError() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + httpResponsedMessage.getErrorString());
                                        FlutterNetModelAuto.this.cmN.a(FlutterNetModelAuto.this.identifier, hashMap, (MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
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
            this.cmW = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> aeW() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> aeX() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> aeY() {
        return MvcSocketResponsedMessage.class;
    }

    private void aeZ() {
        if (!this.cmU && MessageManager.getInstance().findTask(aeT()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(aeT(), aeM() + "?cmd=" + aeS());
            tbHttpMessageTask.setResponsedClass(aeW());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(aeT());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.cmU = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void afa() {
        if (!this.cmU && MessageManager.getInstance().findTask(aeT()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(aeT(), aeM());
            tbHttpMessageTask.setResponsedClass(aeX());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(aeT());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.cmU = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void afb() {
        if (!this.cmV && MessageManager.getInstance().findTask(aeS()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(aeS());
            bVar.setResponsedClass(aeY());
            bVar.setNeedCompress(getNeedCompress());
            if (aeU()) {
                bVar.setParallel(TiebaIMConfig.getParallel());
            }
            a(bVar);
            MessageManager.getInstance().unRegisterTask(aeS());
            MessageManager.getInstance().registerTask(bVar);
            this.cmV = true;
        }
    }

    protected void a(com.baidu.tbadk.task.b bVar) {
    }

    @Override // com.baidu.network_service_plugin.b.a
    public boolean cancelLoadData() {
        this.isLoading = false;
        MessageManager.getInstance().removeMessage(aeS(), this.unique_id);
        MessageManager.getInstance().removeMessage(aeT(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.cmP, aeT(), aeS());
        if (this.cmO != null) {
            MvcSocketResponsedMessage mvcSocketResponsedMessage = new MvcSocketResponsedMessage(aeS()) { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.8
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("api", aeS() + "");
            this.cmO.a(this.identifier, hashMap, mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.cmN != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(aeT()) { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.9
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("api", aeT() + "");
            this.cmN.a(this.identifier, hashMap2, mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(int i, String str) {
        if (this.cmN != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.cmP, aeT());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(aeT());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("api", aeT() + "");
            this.cmN.a(this.identifier, hashMap, mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(int i, String str) {
        MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.cmP, aeS());
        MvcSocketResponsedMessage mvcSocketResponsedMessage = new MvcSocketResponsedMessage(aeS()) { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.10
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("api", aeS() + "");
        this.cmO.a(this.identifier, hashMap, mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    public void a(a<T, D> aVar) {
        this.cmN = aVar;
    }

    public void a(b<T, D> bVar) {
        this.cmO = bVar;
    }
}
