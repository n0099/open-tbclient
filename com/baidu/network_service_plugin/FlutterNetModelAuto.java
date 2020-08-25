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
/* loaded from: classes14.dex */
public class FlutterNetModelAuto<T extends h, D extends j> implements b.a {
    private String bDO;
    private Runnable bDR;
    private Class<T> bDZ;
    private a<T, D> bEb;
    private b<T, D> bEc;
    protected T bEd;
    private TbSocketMessage bEe;
    private int bEf;
    private int bEg;
    private final NetModelType bEh;
    private String identifier;
    private Class<D> responseDataClass;
    private boolean mNeedCompress = false;
    private boolean bEa = false;
    protected BdUniqueId unique_id = null;
    private boolean isNeedCache = false;
    private boolean bEi = false;
    private boolean bEj = false;
    private boolean bEk = false;
    private boolean isLoading = false;
    private int timeout = -1;
    private boolean bDQ = true;

    /* loaded from: classes14.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO
    }

    /* loaded from: classes14.dex */
    public interface a<T extends h, D extends j> {
        void a(String str, HashMap<String, String> hashMap, MvcHttpResponsedMessage<D> mvcHttpResponsedMessage, MvcHttpMessage<T, D> mvcHttpMessage, MvcNetMessage<T, D> mvcNetMessage);
    }

    /* loaded from: classes14.dex */
    public interface b<T extends h, D extends j> {
        void a(String str, HashMap<String, String> hashMap, SocketResponsedMessage socketResponsedMessage, SocketMessage socketMessage, NetMessage netMessage);
    }

    public FlutterNetModelAuto(String str, NetModelType netModelType) {
        this.identifier = str;
        this.bEh = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TbSocketMessage tbSocketMessage) {
        this.bEe = tbSocketMessage;
    }

    protected Class<D> getResponseDataClass() {
        return this.responseDataClass;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(Class<T> cls) {
        this.bDZ = cls;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setResponseDataClass(Class<D> cls) {
        this.responseDataClass = cls;
    }

    public int TA() {
        return this.bEf;
    }

    public int TB() {
        return this.bEg;
    }

    public void fL(int i) {
        this.bEg = i;
    }

    public void fM(int i) {
        this.bEf = i;
    }

    public String Tu() {
        return this.bDO;
    }

    public void hQ(String str) {
        this.bDO = str;
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

    public void df(boolean z) {
        this.bEa = z;
    }

    public boolean TC() {
        return this.bEa;
    }

    public Runnable Tz() {
        if (this.bDR == null) {
            this.bDR = new Runnable() { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (AnonymousClass2.bEl[FlutterNetModelAuto.this.bEh.ordinal()]) {
                        case 1:
                            FlutterNetModelAuto.this.I(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            return;
                        case 2:
                            FlutterNetModelAuto.this.J(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            return;
                        case 3:
                            FlutterNetModelAuto.this.H(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            return;
                        default:
                            return;
                    }
                }
            };
        }
        return this.bDR;
    }

    public boolean loadData() {
        if (this.bEc == null && this.bEb == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.bDQ = l.isNetOk();
        if (this.timeout >= 10) {
            e.mS().postDelayed(Tz(), this.timeout * 1000);
        }
        switch (this.bEh) {
            case TYPE_AUTO:
                if (!this.bDQ) {
                    e.mS().post(new Runnable() { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.3
                        @Override // java.lang.Runnable
                        public void run() {
                            FlutterNetModelAuto.this.I(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                TH();
                TJ();
                TD();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.bEd, TB(), TA());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                HashMap<String, String> bts = this.bEd.bts();
                if (bts != null) {
                    for (Map.Entry<String, String> entry : bts.entrySet()) {
                        mvcNetMessage.getHttpMessage().addHeader(entry.getKey(), entry.getValue());
                    }
                }
                MessageManager.getInstance().sendMessage(mvcNetMessage);
                return true;
            case TYPE_SOCKET:
                if (!this.bDQ) {
                    e.mS().post(new Runnable() { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.5
                        @Override // java.lang.Runnable
                        public void run() {
                            FlutterNetModelAuto.this.J(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                TJ();
                TD();
                if (this.bEd != null) {
                    MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.bEd, TA());
                    mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                    mvcSocketMessage.setNeedCache(isNeedCache());
                    mvcSocketMessage.setTag(this.unique_id);
                    MessageManager.getInstance().sendMessage(mvcSocketMessage);
                }
                if (this.bEe != null) {
                    MessageManager.getInstance().sendMessage(this.bEe);
                }
                return true;
            case TYPE_HTTP:
                if (!this.bDQ) {
                    e.mS().post(new Runnable() { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.4
                        @Override // java.lang.Runnable
                        public void run() {
                            FlutterNetModelAuto.this.H(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                TI();
                TD();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.bEd, TB());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> btr = this.bEd.btr();
                if (btr != null) {
                    for (Map.Entry<String, Object> entry2 : btr.entrySet()) {
                        mvcHttpMessage.addParam(entry2.getKey(), entry2.getValue());
                    }
                }
                HashMap<String, String> bts2 = this.bEd.bts();
                if (bts2 != null) {
                    for (Map.Entry<String, String> entry3 : bts2.entrySet()) {
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

    private void TD() {
        if (!this.bEk) {
            switch (this.bEh) {
                case TYPE_AUTO:
                    com.baidu.adp.framework.listener.a aVar = new com.baidu.adp.framework.listener.a(TB(), TA()) { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.6
                        @Override // com.baidu.adp.framework.listener.a
                        public void onMessage(ResponsedMessage<?> responsedMessage) {
                            FlutterNetModelAuto.this.isLoading = false;
                            if (FlutterNetModelAuto.this.bDR != null) {
                                e.mS().removeCallbacks(FlutterNetModelAuto.this.bDR);
                            }
                            if (responsedMessage instanceof MvcProtobufHttpResponsedMessage) {
                                MvcNetMessage<T, D> mvcNetMessage = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (FlutterNetModelAuto.this.bEb != null) {
                                    HashMap<String, String> hashMap = new HashMap<>();
                                    hashMap.put("server", FlutterNetModelAuto.this.Tu());
                                    hashMap.put("api", FlutterNetModelAuto.this.TB() + "");
                                    hashMap.put("state", responsedMessage.getError() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + responsedMessage.getErrorString());
                                    FlutterNetModelAuto.this.bEb.a(FlutterNetModelAuto.this.identifier, hashMap, (MvcProtobufHttpResponsedMessage) responsedMessage, null, mvcNetMessage);
                                }
                            } else if (responsedMessage instanceof SocketResponsedMessage) {
                                MvcNetMessage mvcNetMessage2 = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (FlutterNetModelAuto.this.bEc != null) {
                                    HashMap<String, String> hashMap2 = new HashMap<>();
                                    hashMap2.put("api", FlutterNetModelAuto.this.TA() + "");
                                    hashMap2.put("state", responsedMessage.getError() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + responsedMessage.getErrorString());
                                    FlutterNetModelAuto.this.bEc.a(FlutterNetModelAuto.this.identifier, hashMap2, (SocketResponsedMessage) responsedMessage, null, mvcNetMessage2);
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
                    com.baidu.adp.framework.listener.c cVar = new com.baidu.adp.framework.listener.c(TA()) { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.11
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                            FlutterNetModelAuto.this.isLoading = false;
                            if (FlutterNetModelAuto.this.bDR != null) {
                                e.mS().removeCallbacks(FlutterNetModelAuto.this.bDR);
                            }
                            if (socketResponsedMessage instanceof MvcSocketResponsedMessage) {
                                if (socketResponsedMessage.getOrginalMessage() instanceof MvcSocketMessage) {
                                    if (FlutterNetModelAuto.this.bEc != null) {
                                        HashMap<String, String> hashMap = new HashMap<>();
                                        hashMap.put("api", FlutterNetModelAuto.this.TA() + "");
                                        hashMap.put("state", socketResponsedMessage.getError() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + socketResponsedMessage.getErrorString());
                                        FlutterNetModelAuto.this.bEc.a(FlutterNetModelAuto.this.identifier, hashMap, socketResponsedMessage, (SocketMessage) socketResponsedMessage.getOrginalMessage(), null);
                                    }
                                } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                                    throw new RuntimeException("mvc netmodel SocketListener socketResponsedMessage originaMessage error");
                                }
                            } else if ((socketResponsedMessage instanceof SocketResponsedMessage) && FlutterNetModelAuto.this.bEc != null) {
                                HashMap<String, String> hashMap2 = new HashMap<>();
                                hashMap2.put("api", FlutterNetModelAuto.this.TA() + "");
                                hashMap2.put("state", socketResponsedMessage.getError() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + socketResponsedMessage.getErrorString());
                                FlutterNetModelAuto.this.bEc.a(FlutterNetModelAuto.this.identifier, hashMap2, socketResponsedMessage, (SocketMessage) socketResponsedMessage.getOrginalMessage(), null);
                            }
                        }
                    };
                    cVar.setTag(getUniqueId());
                    MessageManager.getInstance().registerListener(cVar);
                    break;
                case TYPE_HTTP:
                    HttpMessageListener httpMessageListener = new HttpMessageListener(TB(), true) { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.7
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                            FlutterNetModelAuto.this.isLoading = false;
                            if (FlutterNetModelAuto.this.bDR != null) {
                                e.mS().removeCallbacks(FlutterNetModelAuto.this.bDR);
                            }
                            if (httpResponsedMessage instanceof MvcJsonHttpResponsedMessage) {
                                if (httpResponsedMessage.getOrginalMessage() instanceof MvcHttpMessage) {
                                    if (FlutterNetModelAuto.this.bEb != null) {
                                        HashMap<String, String> hashMap = new HashMap<>();
                                        hashMap.put("server", FlutterNetModelAuto.this.Tu());
                                        hashMap.put("api", FlutterNetModelAuto.this.TB() + "");
                                        hashMap.put("state", httpResponsedMessage.getError() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + httpResponsedMessage.getErrorString());
                                        FlutterNetModelAuto.this.bEb.a(FlutterNetModelAuto.this.identifier, hashMap, (MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
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
            this.bEk = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> TE() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> TF() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> TG() {
        return MvcSocketResponsedMessage.class;
    }

    private void TH() {
        if (!this.bEi && MessageManager.getInstance().findTask(TB()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(TB(), Tu() + "?cmd=" + TA());
            tbHttpMessageTask.setResponsedClass(TE());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(TB());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.bEi = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void TI() {
        if (!this.bEi && MessageManager.getInstance().findTask(TB()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(TB(), Tu());
            tbHttpMessageTask.setResponsedClass(TF());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(TB());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.bEi = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void TJ() {
        if (!this.bEj && MessageManager.getInstance().findTask(TA()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(TA());
            bVar.setResponsedClass(TG());
            bVar.setNeedCompress(getNeedCompress());
            if (TC()) {
                bVar.setParallel(TiebaIMConfig.getParallel());
            }
            a(bVar);
            MessageManager.getInstance().unRegisterTask(TA());
            MessageManager.getInstance().registerTask(bVar);
            this.bEj = true;
        }
    }

    protected void a(com.baidu.tbadk.task.b bVar) {
    }

    @Override // com.baidu.network_service_plugin.b.a
    public boolean cancelLoadData() {
        this.isLoading = false;
        MessageManager.getInstance().removeMessage(TA(), this.unique_id);
        MessageManager.getInstance().removeMessage(TB(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.bEd, TB(), TA());
        if (this.bEc != null) {
            MvcSocketResponsedMessage mvcSocketResponsedMessage = new MvcSocketResponsedMessage(TA()) { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.8
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("api", TA() + "");
            this.bEc.a(this.identifier, hashMap, mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.bEb != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(TB()) { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.9
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("api", TB() + "");
            this.bEb.a(this.identifier, hashMap2, mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(int i, String str) {
        if (this.bEb != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.bEd, TB());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(TB());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("api", TB() + "");
            this.bEb.a(this.identifier, hashMap, mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(int i, String str) {
        MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.bEd, TA());
        MvcSocketResponsedMessage mvcSocketResponsedMessage = new MvcSocketResponsedMessage(TA()) { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.10
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("api", TA() + "");
        this.bEc.a(this.identifier, hashMap, mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    public void a(a<T, D> aVar) {
        this.bEb = aVar;
    }

    public void a(b<T, D> bVar) {
        this.bEc = bVar;
    }
}
