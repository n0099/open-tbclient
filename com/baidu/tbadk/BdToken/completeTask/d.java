package com.baidu.tbadk.BdToken.completeTask;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.BdToken.h;
import com.baidu.tbadk.BdToken.n;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d implements Handler.Callback {
    private com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b> dTk;
    private com.baidu.tbadk.BdToken.completeTask.b dTl;
    protected BdUniqueId mBdUniqueId;
    private final Queue<a> dTj = new LinkedList();
    private boolean isLoading = false;
    private final Handler mHandler = new Handler(this);
    private com.baidu.adp.framework.listener.a dTm = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMPLETE_TASK, 309627) { // from class: com.baidu.tbadk.BdToken.completeTask.d.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            com.baidu.tbadk.BdToken.completeTask.a data;
            Object obj;
            d.this.isLoading = false;
            if (responsedMessage != null) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    d.this.c(responsedMessage);
                    return;
                }
                if (responsedMessage instanceof CompleteTaskHTTPResMsg) {
                    data = ((CompleteTaskHTTPResMsg) responsedMessage).getData();
                } else {
                    data = responsedMessage instanceof CompleteTaskSocketResMsg ? ((CompleteTaskSocketResMsg) responsedMessage).getData() : null;
                }
                if (data != null) {
                    if (d.this.dTl == null) {
                        d.this.dTl = new com.baidu.tbadk.BdToken.completeTask.b();
                    }
                    d.this.dTl.a(data);
                    d.this.dTl.show();
                    CompleteTaskReqMsg completeTaskReqMsg = (CompleteTaskReqMsg) responsedMessage.getOrginalMessage().getExtra();
                    if (completeTaskReqMsg.extra instanceof e) {
                        obj = (e) completeTaskReqMsg.extra;
                        com.baidu.tbadk.BdToken.b bVar = ((e) obj).dTs;
                        if (data != null && data.dTh == 1) {
                            bVar.dQt = true;
                        }
                        d.this.r(bVar);
                    } else if (completeTaskReqMsg.extra instanceof C0528d) {
                        obj = (C0528d) completeTaskReqMsg.extra;
                        d.this.yr(((C0528d) obj).data);
                    } else if (completeTaskReqMsg.extra instanceof f) {
                        n.aZG().aZH();
                        obj = null;
                    } else {
                        if (completeTaskReqMsg.extra instanceof c) {
                        }
                        obj = null;
                    }
                    if (obj != null) {
                        d.this.dTj.remove(obj);
                    }
                    d.this.bau();
                }
            }
        }
    };
    private CustomMessageListener dTn = new CustomMessageListener(2921379) { // from class: com.baidu.tbadk.BdToken.completeTask.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof b)) {
                b bVar = (b) customResponsedMessage.getData();
                d.this.aI(bVar.dTp);
                d.this.aJ(bVar.dTq);
            }
        }
    };

    /* loaded from: classes.dex */
    public static abstract class a {
    }

    /* loaded from: classes.dex */
    public static class c extends a {
    }

    /* loaded from: classes.dex */
    public static class f extends a {
    }

    public BdUniqueId getUniqueId() {
        return this.mBdUniqueId;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                baw();
                return false;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bau() {
        Message obtain = Message.obtain();
        obtain.what = 1;
        this.mHandler.sendMessage(obtain);
    }

    public d(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        bax();
        registerListeners();
    }

    public void a(com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b> bVar) {
        this.dTk = bVar;
    }

    public void bav() {
        if (this.dTl != null) {
            this.dTl.clearData();
        }
    }

    public void a(String str, int i, String str2, Object obj) {
        if (j.isNetWorkAvailable()) {
            this.isLoading = true;
            CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(i);
            completeTaskReqMsg.setTag(this.mBdUniqueId);
            completeTaskReqMsg.completeId = str;
            completeTaskReqMsg.setToken(str2);
            completeTaskReqMsg.extra = obj;
            completeTaskReqMsg.setNetType(NetMessage.NetType.HTTP);
            MessageManager.getInstance().sendMessage(completeTaskReqMsg);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.BdToken.completeTask.d$e */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void c(ResponsedMessage<?> responsedMessage) {
        C0528d c0528d;
        if (responsedMessage != null) {
            CompleteTaskReqMsg completeTaskReqMsg = (CompleteTaskReqMsg) responsedMessage.getOrginalMessage().getExtra();
            if (completeTaskReqMsg.extra instanceof e) {
                e eVar = (e) completeTaskReqMsg.extra;
                m(eVar.dTs);
                c0528d = eVar;
            } else if (!(completeTaskReqMsg.extra instanceof C0528d)) {
                c0528d = null;
            } else {
                c0528d = (C0528d) completeTaskReqMsg.extra;
            }
            if (c0528d != null) {
                this.dTj.remove(c0528d);
            }
            bau();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar != null) {
            m(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yr(String str) {
        JSONObject jSONObject;
        String[] split;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e2) {
                e2.printStackTrace();
                jSONObject = null;
            }
            if (jSONObject != null) {
                LinkedList<com.baidu.tbadk.BdToken.b> linkedList = new LinkedList();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        String string = jSONObject.getString(next);
                        if (string != null && (split = string.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null) {
                            for (String str2 : split) {
                                com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
                                bVar.setActivityId(com.baidu.adp.lib.f.b.toInt(next, 0));
                                bVar.mH(com.baidu.adp.lib.f.b.toInt(str2, 0));
                                if (bVar.getActivityId() != 0 && bVar.aYO() != 0) {
                                    linkedList.add(bVar);
                                }
                            }
                        }
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
                for (com.baidu.tbadk.BdToken.b bVar2 : linkedList) {
                    m(bVar2);
                }
            }
        }
    }

    private void m(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar != null && this.dTk != null) {
            this.dTk.onProgressUpdate(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(List<h> list) {
        if (!y.isEmpty(list)) {
            LinkedList<com.baidu.tbadk.BdToken.b> linkedList = new LinkedList();
            for (h hVar : list) {
                if (hVar != null && hVar.aZD() != null) {
                    com.baidu.tbadk.BdToken.b aZD = hVar.aZD();
                    if (aZD.aYL()) {
                        aZD.mN(aZD.aZc());
                        m(aZD);
                    } else if (aZD.getActivityId() != 0 && aZD.aYO() != 0) {
                        linkedList.add(aZD);
                    }
                }
            }
            if (!y.isEmpty(linkedList)) {
                HashMap hashMap = new HashMap();
                for (com.baidu.tbadk.BdToken.b bVar : linkedList) {
                    if (bVar != null) {
                        HashSet hashSet = (HashSet) hashMap.get(Integer.valueOf(bVar.getActivityId()));
                        if (hashSet == null) {
                            hashSet = new HashSet();
                            hashMap.put(Integer.valueOf(bVar.getActivityId()), hashSet);
                        }
                        hashSet.add(Integer.valueOf(bVar.aYO()));
                    }
                }
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : hashMap.entrySet()) {
                    StringBuilder sb = new StringBuilder();
                    Iterator it = ((HashSet) entry.getValue()).iterator();
                    while (it.hasNext()) {
                        sb.append(it.next() + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    try {
                        jSONObject.put(String.valueOf(entry.getKey()), sb);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                JSONObject jSONObject2 = new JSONObject();
                for (com.baidu.tbadk.BdToken.b bVar2 : linkedList) {
                    if (bVar2 != null) {
                        com.baidu.tbadk.BdToken.completeTask.c.a(jSONObject2, bVar2.getActivityId(), bVar2.aYO(), bVar2.getToken());
                    }
                }
                C0528d c0528d = new C0528d(jSONObject.toString());
                c0528d.token = jSONObject2.toString();
                this.dTj.add(c0528d);
                bau();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(List<com.baidu.tbadk.BdToken.b> list) {
        if (!y.isEmpty(list)) {
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.aYL()) {
                    bVar.mN(bVar.aZc());
                    m(bVar);
                } else {
                    this.dTj.add(new e(bVar));
                }
            }
            bau();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0066 -> B:6:0x0007). Please submit an issue!!! */
    private boolean baw() {
        a peek;
        String str;
        com.baidu.tbadk.BdToken.b bVar;
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!this.isLoading && (peek = this.dTj.peek()) != null) {
            if (peek instanceof e) {
                e eVar = (e) peek;
                if (eVar != null && (bVar = eVar.dTs) != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(String.valueOf(bVar.getActivityId()), String.valueOf(bVar.aYO()));
                    a(jSONObject.toString(), 1, bVar.getToken(), eVar);
                    return true;
                }
                return false;
            }
            if (peek instanceof C0528d) {
                C0528d c0528d = (C0528d) peek;
                if (c0528d != null && (str = c0528d.data) != null) {
                    a(str, 1, c0528d.token, c0528d);
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private void bax() {
        com.baidu.tieba.tbadkCore.a.a.a(309627, CompleteTaskSocketResMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_COMPLETE_TASK, com.baidu.tieba.tbadkCore.a.a.bH(TbConfig.COMPLETE_TASK_URL, 309627));
        tbHttpMessageTask.setResponsedClass(CompleteTaskHTTPResMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListeners() {
        this.dTm.setTag(getUniqueId());
        this.dTn.setTag(getUniqueId());
        MessageManager.getInstance().registerListener(this.dTm);
        MessageManager.getInstance().registerListener(this.dTn);
    }

    /* loaded from: classes.dex */
    public static class e extends a {
        public com.baidu.tbadk.BdToken.b dTs;

        public e(com.baidu.tbadk.BdToken.b bVar) {
            this.dTs = bVar;
        }
    }

    /* renamed from: com.baidu.tbadk.BdToken.completeTask.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0528d extends a {
        public String data;
        public String token;

        public C0528d(String str) {
            this.data = str;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public List<h> dTp;
        public List<com.baidu.tbadk.BdToken.b> dTq;
        public List<com.baidu.tbadk.BdToken.b> dTr;

        public void c(h hVar) {
            if (this.dTp != null) {
                this.dTp.add(hVar);
            }
        }

        public void s(com.baidu.tbadk.BdToken.b bVar) {
            if (this.dTq != null) {
                this.dTq.add(bVar);
            }
        }

        public void t(com.baidu.tbadk.BdToken.b bVar) {
            if (this.dTr != null) {
                this.dTr.add(bVar);
            }
        }
    }
}
