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
/* loaded from: classes8.dex */
public class FlutterNetModelAuto<T extends h, D extends j> implements b.a {
    private final NetModelType byA;
    private String byg;
    private Runnable byj;
    private Class<T> bys;
    private a<T, D> byu;
    private b<T, D> byv;
    protected T byw;
    private TbSocketMessage byx;
    private int byy;
    private int byz;
    private String identifier;
    private Class<D> responseDataClass;
    private boolean mNeedCompress = false;
    private boolean byt = false;
    protected BdUniqueId unique_id = null;
    private boolean isNeedCache = false;
    private boolean byB = false;
    private boolean byC = false;
    private boolean byD = false;
    private boolean isLoading = false;
    private int timeout = -1;
    private boolean byi = true;

    /* loaded from: classes8.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO
    }

    /* loaded from: classes8.dex */
    public interface a<T extends h, D extends j> {
        void a(String str, HashMap<String, String> hashMap, MvcHttpResponsedMessage<D> mvcHttpResponsedMessage, MvcHttpMessage<T, D> mvcHttpMessage, MvcNetMessage<T, D> mvcNetMessage);
    }

    /* loaded from: classes8.dex */
    public interface b<T extends h, D extends j> {
        void a(String str, HashMap<String, String> hashMap, SocketResponsedMessage socketResponsedMessage, SocketMessage socketMessage, NetMessage netMessage);
    }

    public FlutterNetModelAuto(String str, NetModelType netModelType) {
        this.identifier = str;
        this.byA = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TbSocketMessage tbSocketMessage) {
        this.byx = tbSocketMessage;
    }

    protected Class<D> getResponseDataClass() {
        return this.responseDataClass;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(Class<T> cls) {
        this.bys = cls;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setResponseDataClass(Class<D> cls) {
        this.responseDataClass = cls;
    }

    public int NG() {
        return this.byy;
    }

    public int NH() {
        return this.byz;
    }

    public void dP(int i) {
        this.byz = i;
    }

    public void dQ(int i) {
        this.byy = i;
    }

    public String NA() {
        return this.byg;
    }

    public void gw(String str) {
        this.byg = str;
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

    public void cX(boolean z) {
        this.byt = z;
    }

    public boolean NI() {
        return this.byt;
    }

    public Runnable NF() {
        if (this.byj == null) {
            this.byj = new Runnable() { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (AnonymousClass2.byE[FlutterNetModelAuto.this.byA.ordinal()]) {
                        case 1:
                            FlutterNetModelAuto.this.J(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            return;
                        case 2:
                            FlutterNetModelAuto.this.K(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            return;
                        case 3:
                            FlutterNetModelAuto.this.I(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            return;
                        default:
                            return;
                    }
                }
            };
        }
        return this.byj;
    }

    public boolean loadData() {
        if (this.byv == null && this.byu == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.byi = l.isNetOk();
        if (this.timeout >= 10) {
            e.lt().postDelayed(NF(), this.timeout * 1000);
        }
        switch (this.byA) {
            case TYPE_AUTO:
                if (!this.byi) {
                    e.lt().post(new Runnable() { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.3
                        @Override // java.lang.Runnable
                        public void run() {
                            FlutterNetModelAuto.this.J(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                NN();
                NP();
                NJ();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.byw, NH(), NG());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                HashMap<String, String> bkG = this.byw.bkG();
                if (bkG != null) {
                    for (Map.Entry<String, String> entry : bkG.entrySet()) {
                        mvcNetMessage.getHttpMessage().addHeader(entry.getKey(), entry.getValue());
                    }
                }
                MessageManager.getInstance().sendMessage(mvcNetMessage);
                return true;
            case TYPE_SOCKET:
                if (!this.byi) {
                    e.lt().post(new Runnable() { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.5
                        @Override // java.lang.Runnable
                        public void run() {
                            FlutterNetModelAuto.this.K(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                NP();
                NJ();
                if (this.byw != null) {
                    MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.byw, NG());
                    mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                    mvcSocketMessage.setNeedCache(isNeedCache());
                    mvcSocketMessage.setTag(this.unique_id);
                    MessageManager.getInstance().sendMessage(mvcSocketMessage);
                }
                if (this.byx != null) {
                    MessageManager.getInstance().sendMessage(this.byx);
                }
                return true;
            case TYPE_HTTP:
                if (!this.byi) {
                    e.lt().post(new Runnable() { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.4
                        @Override // java.lang.Runnable
                        public void run() {
                            FlutterNetModelAuto.this.I(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                NO();
                NJ();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.byw, NH());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> bkF = this.byw.bkF();
                if (bkF != null) {
                    for (Map.Entry<String, Object> entry2 : bkF.entrySet()) {
                        mvcHttpMessage.addParam(entry2.getKey(), entry2.getValue());
                    }
                }
                HashMap<String, String> bkG2 = this.byw.bkG();
                if (bkG2 != null) {
                    for (Map.Entry<String, String> entry3 : bkG2.entrySet()) {
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

    private void NJ() {
        if (!this.byD) {
            switch (this.byA) {
                case TYPE_AUTO:
                    com.baidu.adp.framework.listener.a aVar = new com.baidu.adp.framework.listener.a(NH(), NG()) { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.6
                        @Override // com.baidu.adp.framework.listener.a
                        public void onMessage(ResponsedMessage<?> responsedMessage) {
                            FlutterNetModelAuto.this.isLoading = false;
                            if (FlutterNetModelAuto.this.byj != null) {
                                e.lt().removeCallbacks(FlutterNetModelAuto.this.byj);
                            }
                            if (responsedMessage instanceof MvcProtobufHttpResponsedMessage) {
                                MvcNetMessage<T, D> mvcNetMessage = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (FlutterNetModelAuto.this.byu != null) {
                                    HashMap<String, String> hashMap = new HashMap<>();
                                    hashMap.put("server", FlutterNetModelAuto.this.NA());
                                    hashMap.put("api", FlutterNetModelAuto.this.NH() + "");
                                    hashMap.put("state", responsedMessage.getError() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + responsedMessage.getErrorString());
                                    FlutterNetModelAuto.this.byu.a(FlutterNetModelAuto.this.identifier, hashMap, (MvcProtobufHttpResponsedMessage) responsedMessage, null, mvcNetMessage);
                                }
                            } else if (responsedMessage instanceof SocketResponsedMessage) {
                                MvcNetMessage mvcNetMessage2 = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (FlutterNetModelAuto.this.byv != null) {
                                    HashMap<String, String> hashMap2 = new HashMap<>();
                                    hashMap2.put("api", FlutterNetModelAuto.this.NG() + "");
                                    hashMap2.put("state", responsedMessage.getError() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + responsedMessage.getErrorString());
                                    FlutterNetModelAuto.this.byv.a(FlutterNetModelAuto.this.identifier, hashMap2, (SocketResponsedMessage) responsedMessage, null, mvcNetMessage2);
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
                    com.baidu.adp.framework.listener.c cVar = new com.baidu.adp.framework.listener.c(NG()) { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.11
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                            FlutterNetModelAuto.this.isLoading = false;
                            if (FlutterNetModelAuto.this.byj != null) {
                                e.lt().removeCallbacks(FlutterNetModelAuto.this.byj);
                            }
                            if (socketResponsedMessage instanceof MvcSocketResponsedMessage) {
                                if (socketResponsedMessage.getOrginalMessage() instanceof MvcSocketMessage) {
                                    if (FlutterNetModelAuto.this.byv != null) {
                                        HashMap<String, String> hashMap = new HashMap<>();
                                        hashMap.put("api", FlutterNetModelAuto.this.NG() + "");
                                        hashMap.put("state", socketResponsedMessage.getError() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + socketResponsedMessage.getErrorString());
                                        FlutterNetModelAuto.this.byv.a(FlutterNetModelAuto.this.identifier, hashMap, socketResponsedMessage, (SocketMessage) socketResponsedMessage.getOrginalMessage(), null);
                                    }
                                } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                                    throw new RuntimeException("mvc netmodel SocketListener socketResponsedMessage originaMessage error");
                                }
                            } else if ((socketResponsedMessage instanceof SocketResponsedMessage) && FlutterNetModelAuto.this.byv != null) {
                                HashMap<String, String> hashMap2 = new HashMap<>();
                                hashMap2.put("api", FlutterNetModelAuto.this.NG() + "");
                                hashMap2.put("state", socketResponsedMessage.getError() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + socketResponsedMessage.getErrorString());
                                FlutterNetModelAuto.this.byv.a(FlutterNetModelAuto.this.identifier, hashMap2, socketResponsedMessage, (SocketMessage) socketResponsedMessage.getOrginalMessage(), null);
                            }
                        }
                    };
                    cVar.setTag(getUniqueId());
                    MessageManager.getInstance().registerListener(cVar);
                    break;
                case TYPE_HTTP:
                    HttpMessageListener httpMessageListener = new HttpMessageListener(NH(), true) { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.7
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                            FlutterNetModelAuto.this.isLoading = false;
                            if (FlutterNetModelAuto.this.byj != null) {
                                e.lt().removeCallbacks(FlutterNetModelAuto.this.byj);
                            }
                            if (httpResponsedMessage instanceof MvcJsonHttpResponsedMessage) {
                                if (httpResponsedMessage.getOrginalMessage() instanceof MvcHttpMessage) {
                                    if (FlutterNetModelAuto.this.byu != null) {
                                        HashMap<String, String> hashMap = new HashMap<>();
                                        hashMap.put("server", FlutterNetModelAuto.this.NA());
                                        hashMap.put("api", FlutterNetModelAuto.this.NH() + "");
                                        hashMap.put("state", httpResponsedMessage.getError() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + httpResponsedMessage.getErrorString());
                                        FlutterNetModelAuto.this.byu.a(FlutterNetModelAuto.this.identifier, hashMap, (MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
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
            this.byD = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> NK() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> NL() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> NM() {
        return MvcSocketResponsedMessage.class;
    }

    private void NN() {
        if (!this.byB && MessageManager.getInstance().findTask(NH()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(NH(), NA() + "?cmd=" + NG());
            tbHttpMessageTask.setResponsedClass(NK());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(NH());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.byB = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void NO() {
        if (!this.byB && MessageManager.getInstance().findTask(NH()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(NH(), NA());
            tbHttpMessageTask.setResponsedClass(NL());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(NH());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.byB = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void NP() {
        if (!this.byC && MessageManager.getInstance().findTask(NG()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(NG());
            bVar.setResponsedClass(NM());
            bVar.setNeedCompress(getNeedCompress());
            if (NI()) {
                bVar.setParallel(TiebaIMConfig.getParallel());
            }
            a(bVar);
            MessageManager.getInstance().unRegisterTask(NG());
            MessageManager.getInstance().registerTask(bVar);
            this.byC = true;
        }
    }

    protected void a(com.baidu.tbadk.task.b bVar) {
    }

    @Override // com.baidu.network_service_plugin.b.a
    public boolean cancelLoadData() {
        this.isLoading = false;
        MessageManager.getInstance().removeMessage(NG(), this.unique_id);
        MessageManager.getInstance().removeMessage(NH(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.byw, NH(), NG());
        if (this.byv != null) {
            MvcSocketResponsedMessage mvcSocketResponsedMessage = new MvcSocketResponsedMessage(NG()) { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.8
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("api", NG() + "");
            this.byv.a(this.identifier, hashMap, mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.byu != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(NH()) { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.9
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("api", NH() + "");
            this.byu.a(this.identifier, hashMap2, mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i, String str) {
        if (this.byu != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.byw, NH());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(NH());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("api", NH() + "");
            this.byu.a(this.identifier, hashMap, mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(int i, String str) {
        MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.byw, NG());
        MvcSocketResponsedMessage mvcSocketResponsedMessage = new MvcSocketResponsedMessage(NG()) { // from class: com.baidu.network_service_plugin.FlutterNetModelAuto.10
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("api", NG() + "");
        this.byv.a(this.identifier, hashMap, mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    public void a(a<T, D> aVar) {
        this.byu = aVar;
    }

    public void a(b<T, D> bVar) {
        this.byv = bVar;
    }
}
