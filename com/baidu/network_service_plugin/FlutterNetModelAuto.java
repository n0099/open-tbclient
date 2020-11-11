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
/* loaded from: classes16.dex */
public class FlutterNetModelAuto<T extends h, D extends j> implements b.a {
    private String caI;
    private Runnable caL;
    private Class<T> caT;
    private a<T, D> caV;
    private b<T, D> caW;
    protected T caX;
    private TbSocketMessage caY;
    private int caZ;
    private int cba;
    private final NetModelType cbb;
    private String identifier;
    private Class<D> responseDataClass;
    private boolean mNeedCompress = false;
    private boolean caU = false;
    protected BdUniqueId unique_id = null;
    private boolean isNeedCache = false;
    private boolean cbc = false;
    private boolean cbd = false;
    private boolean cbe = false;
    private boolean isLoading = false;
    private int timeout = -1;
    private boolean caK = true;

    /* loaded from: classes16.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO
    }

    /* loaded from: classes16.dex */
    public interface a<T extends h, D extends j> {
        void a(String str, HashMap<String, String> hashMap, MvcHttpResponsedMessage<D> mvcHttpResponsedMessage, MvcHttpMessage<T, D> mvcHttpMessage, MvcNetMessage<T, D> mvcNetMessage);
    }

    /* loaded from: classes16.dex */
    public interface b<T extends h, D extends j> {
        void a(String str, HashMap<String, String> hashMap, SocketResponsedMessage socketResponsedMessage, SocketMessage socketMessage, NetMessage netMessage);
    }

    public FlutterNetModelAuto(String str, NetModelType netModelType) {
        this.identifier = str;
        this.cbb = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TbSocketMessage tbSocketMessage) {
        this.caY = tbSocketMessage;
    }

    protected Class<D> getResponseDataClass() {
        return this.responseDataClass;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(Class<T> cls) {
        this.caT = cls;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setResponseDataClass(Class<D> cls) {
        this.responseDataClass = cls;
    }

    public int aax() {
        return this.caZ;
    }

    public int aay() {
        return this.cba;
    }

    public void gJ(int i) {
        this.cba = i;
    }

    public void gK(int i) {
        this.caZ = i;
    }

    public String aar() {
        return this.caI;
    }

    public void jr(String str) {
        this.caI = str;
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

    public void dG(boolean z) {
        this.caU = z;
    }

    public boolean aaz() {
        return this.caU;
    }

    public Runnable aaw() {
        if (this.caL == null) {
            this.caL = new Runnable() { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (AnonymousClass2.cbf[FlutterNetModelAuto.this.cbb.ordinal()]) {
                        case 1:
                            FlutterNetModelAuto.this.aa(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            return;
                        case 2:
                            FlutterNetModelAuto.this.ab(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            return;
                        case 3:
                            FlutterNetModelAuto.this.Z(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            return;
                        default:
                            return;
                    }
                }
            };
        }
        return this.caL;
    }

    public boolean loadData() {
        if (this.caW == null && this.caV == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.caK = l.isNetOk();
        if (this.timeout >= 10) {
            e.mY().postDelayed(aaw(), this.timeout * 1000);
        }
        switch (this.cbb) {
            case TYPE_AUTO:
                if (!this.caK) {
                    e.mY().post(new Runnable() { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.3
                        @Override // java.lang.Runnable
                        public void run() {
                            FlutterNetModelAuto.this.aa(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                aaE();
                aaG();
                aaA();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.caX, aay(), aax());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                HashMap<String, String> bBz = this.caX.bBz();
                if (bBz != null) {
                    for (Map.Entry<String, String> entry : bBz.entrySet()) {
                        mvcNetMessage.getHttpMessage().addHeader(entry.getKey(), entry.getValue());
                    }
                }
                MessageManager.getInstance().sendMessage(mvcNetMessage);
                return true;
            case TYPE_SOCKET:
                if (!this.caK) {
                    e.mY().post(new Runnable() { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.5
                        @Override // java.lang.Runnable
                        public void run() {
                            FlutterNetModelAuto.this.ab(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                aaG();
                aaA();
                if (this.caX != null) {
                    MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.caX, aax());
                    mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                    mvcSocketMessage.setNeedCache(isNeedCache());
                    mvcSocketMessage.setTag(this.unique_id);
                    MessageManager.getInstance().sendMessage(mvcSocketMessage);
                }
                if (this.caY != null) {
                    MessageManager.getInstance().sendMessage(this.caY);
                }
                return true;
            case TYPE_HTTP:
                if (!this.caK) {
                    e.mY().post(new Runnable() { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.4
                        @Override // java.lang.Runnable
                        public void run() {
                            FlutterNetModelAuto.this.Z(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                aaF();
                aaA();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.caX, aay());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> bBy = this.caX.bBy();
                if (bBy != null) {
                    for (Map.Entry<String, Object> entry2 : bBy.entrySet()) {
                        mvcHttpMessage.addParam(entry2.getKey(), entry2.getValue());
                    }
                }
                HashMap<String, String> bBz2 = this.caX.bBz();
                if (bBz2 != null) {
                    for (Map.Entry<String, String> entry3 : bBz2.entrySet()) {
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

    private void aaA() {
        if (!this.cbe) {
            switch (this.cbb) {
                case TYPE_AUTO:
                    com.baidu.adp.framework.listener.a aVar = new com.baidu.adp.framework.listener.a(aay(), aax()) { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.6
                        @Override // com.baidu.adp.framework.listener.a
                        public void onMessage(ResponsedMessage<?> responsedMessage) {
                            FlutterNetModelAuto.this.isLoading = false;
                            if (FlutterNetModelAuto.this.caL != null) {
                                e.mY().removeCallbacks(FlutterNetModelAuto.this.caL);
                            }
                            if (responsedMessage instanceof MvcProtobufHttpResponsedMessage) {
                                MvcNetMessage<T, D> mvcNetMessage = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (FlutterNetModelAuto.this.caV != null) {
                                    HashMap<String, String> hashMap = new HashMap<>();
                                    hashMap.put("server", FlutterNetModelAuto.this.aar());
                                    hashMap.put("api", FlutterNetModelAuto.this.aay() + "");
                                    hashMap.put("state", responsedMessage.getError() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + responsedMessage.getErrorString());
                                    FlutterNetModelAuto.this.caV.a(FlutterNetModelAuto.this.identifier, hashMap, (MvcProtobufHttpResponsedMessage) responsedMessage, null, mvcNetMessage);
                                }
                            } else if (responsedMessage instanceof SocketResponsedMessage) {
                                MvcNetMessage mvcNetMessage2 = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (FlutterNetModelAuto.this.caW != null) {
                                    HashMap<String, String> hashMap2 = new HashMap<>();
                                    hashMap2.put("api", FlutterNetModelAuto.this.aax() + "");
                                    hashMap2.put("state", responsedMessage.getError() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + responsedMessage.getErrorString());
                                    FlutterNetModelAuto.this.caW.a(FlutterNetModelAuto.this.identifier, hashMap2, (SocketResponsedMessage) responsedMessage, null, mvcNetMessage2);
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
                    com.baidu.adp.framework.listener.c cVar = new com.baidu.adp.framework.listener.c(aax()) { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.11
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                            FlutterNetModelAuto.this.isLoading = false;
                            if (FlutterNetModelAuto.this.caL != null) {
                                e.mY().removeCallbacks(FlutterNetModelAuto.this.caL);
                            }
                            if (socketResponsedMessage instanceof MvcSocketResponsedMessage) {
                                if (socketResponsedMessage.getOrginalMessage() instanceof MvcSocketMessage) {
                                    if (FlutterNetModelAuto.this.caW != null) {
                                        HashMap<String, String> hashMap = new HashMap<>();
                                        hashMap.put("api", FlutterNetModelAuto.this.aax() + "");
                                        hashMap.put("state", socketResponsedMessage.getError() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + socketResponsedMessage.getErrorString());
                                        FlutterNetModelAuto.this.caW.a(FlutterNetModelAuto.this.identifier, hashMap, socketResponsedMessage, (SocketMessage) socketResponsedMessage.getOrginalMessage(), null);
                                    }
                                } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                                    throw new RuntimeException("mvc netmodel SocketListener socketResponsedMessage originaMessage error");
                                }
                            } else if ((socketResponsedMessage instanceof SocketResponsedMessage) && FlutterNetModelAuto.this.caW != null) {
                                HashMap<String, String> hashMap2 = new HashMap<>();
                                hashMap2.put("api", FlutterNetModelAuto.this.aax() + "");
                                hashMap2.put("state", socketResponsedMessage.getError() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + socketResponsedMessage.getErrorString());
                                FlutterNetModelAuto.this.caW.a(FlutterNetModelAuto.this.identifier, hashMap2, socketResponsedMessage, (SocketMessage) socketResponsedMessage.getOrginalMessage(), null);
                            }
                        }
                    };
                    cVar.setTag(getUniqueId());
                    MessageManager.getInstance().registerListener(cVar);
                    break;
                case TYPE_HTTP:
                    HttpMessageListener httpMessageListener = new HttpMessageListener(aay(), true) { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.7
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                            FlutterNetModelAuto.this.isLoading = false;
                            if (FlutterNetModelAuto.this.caL != null) {
                                e.mY().removeCallbacks(FlutterNetModelAuto.this.caL);
                            }
                            if (httpResponsedMessage instanceof MvcJsonHttpResponsedMessage) {
                                if (httpResponsedMessage.getOrginalMessage() instanceof MvcHttpMessage) {
                                    if (FlutterNetModelAuto.this.caV != null) {
                                        HashMap<String, String> hashMap = new HashMap<>();
                                        hashMap.put("server", FlutterNetModelAuto.this.aar());
                                        hashMap.put("api", FlutterNetModelAuto.this.aay() + "");
                                        hashMap.put("state", httpResponsedMessage.getError() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + httpResponsedMessage.getErrorString());
                                        FlutterNetModelAuto.this.caV.a(FlutterNetModelAuto.this.identifier, hashMap, (MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
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
            this.cbe = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> aaB() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> aaC() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> aaD() {
        return MvcSocketResponsedMessage.class;
    }

    private void aaE() {
        if (!this.cbc && MessageManager.getInstance().findTask(aay()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(aay(), aar() + "?cmd=" + aax());
            tbHttpMessageTask.setResponsedClass(aaB());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(aay());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.cbc = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void aaF() {
        if (!this.cbc && MessageManager.getInstance().findTask(aay()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(aay(), aar());
            tbHttpMessageTask.setResponsedClass(aaC());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(aay());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.cbc = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void aaG() {
        if (!this.cbd && MessageManager.getInstance().findTask(aax()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(aax());
            bVar.setResponsedClass(aaD());
            bVar.setNeedCompress(getNeedCompress());
            if (aaz()) {
                bVar.setParallel(TiebaIMConfig.getParallel());
            }
            a(bVar);
            MessageManager.getInstance().unRegisterTask(aax());
            MessageManager.getInstance().registerTask(bVar);
            this.cbd = true;
        }
    }

    protected void a(com.baidu.tbadk.task.b bVar) {
    }

    @Override // com.baidu.network_service_plugin.b.a
    public boolean cancelLoadData() {
        this.isLoading = false;
        MessageManager.getInstance().removeMessage(aax(), this.unique_id);
        MessageManager.getInstance().removeMessage(aay(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.caX, aay(), aax());
        if (this.caW != null) {
            MvcSocketResponsedMessage mvcSocketResponsedMessage = new MvcSocketResponsedMessage(aax()) { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.8
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("api", aax() + "");
            this.caW.a(this.identifier, hashMap, mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.caV != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(aay()) { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.9
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("api", aay() + "");
            this.caV.a(this.identifier, hashMap2, mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(int i, String str) {
        if (this.caV != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.caX, aay());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(aay());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("api", aay() + "");
            this.caV.a(this.identifier, hashMap, mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(int i, String str) {
        MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.caX, aax());
        MvcSocketResponsedMessage mvcSocketResponsedMessage = new MvcSocketResponsedMessage(aax()) { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.10
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("api", aax() + "");
        this.caW.a(this.identifier, hashMap, mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    public void a(a<T, D> aVar) {
        this.caV = aVar;
    }

    public void a(b<T, D> bVar) {
        this.caW = bVar;
    }
}
