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
import com.baidu.tbadk.core.util.v;
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
    private com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b> cFu;
    private com.baidu.tbadk.BdToken.completeTask.b cFv;
    protected BdUniqueId mBdUniqueId;
    private final Queue<a> cFt = new LinkedList();
    private boolean isLoading = false;
    private final Handler mHandler = new Handler(this);
    private com.baidu.adp.framework.listener.a cFw = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMPLETE_TASK, 309627) { // from class: com.baidu.tbadk.BdToken.completeTask.d.1
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
                    if (d.this.cFv == null) {
                        d.this.cFv = new com.baidu.tbadk.BdToken.completeTask.b();
                    }
                    d.this.cFv.a(data);
                    d.this.cFv.show();
                    CompleteTaskReqMsg completeTaskReqMsg = (CompleteTaskReqMsg) responsedMessage.getOrginalMessage().getExtra();
                    if (completeTaskReqMsg.extra instanceof e) {
                        obj = (e) completeTaskReqMsg.extra;
                        com.baidu.tbadk.BdToken.b bVar = ((e) obj).cFC;
                        if (data != null && data.cFr == 1) {
                            bVar.cDt = true;
                        }
                        d.this.r(bVar);
                    } else if (completeTaskReqMsg.extra instanceof C0362d) {
                        obj = (C0362d) completeTaskReqMsg.extra;
                        d.this.rq(((C0362d) obj).data);
                    } else if (completeTaskReqMsg.extra instanceof f) {
                        n.avI().avJ();
                        obj = null;
                    } else {
                        if (completeTaskReqMsg.extra instanceof c) {
                        }
                        obj = null;
                    }
                    if (obj != null) {
                        d.this.cFt.remove(obj);
                    }
                    d.this.awb();
                }
            }
        }
    };
    private CustomMessageListener cFx = new CustomMessageListener(2921379) { // from class: com.baidu.tbadk.BdToken.completeTask.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof b)) {
                b bVar = (b) customResponsedMessage.getData();
                d.this.aq(bVar.cFz);
                d.this.ar(bVar.cFA);
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
                awd();
                return false;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awb() {
        Message obtain = Message.obtain();
        obtain.what = 1;
        this.mHandler.sendMessage(obtain);
    }

    public d(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        awe();
        registerListeners();
    }

    public void a(com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b> bVar) {
        this.cFu = bVar;
    }

    public void awc() {
        if (this.cFv != null) {
            this.cFv.clearData();
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
        C0362d c0362d;
        if (responsedMessage != null) {
            CompleteTaskReqMsg completeTaskReqMsg = (CompleteTaskReqMsg) responsedMessage.getOrginalMessage().getExtra();
            if (completeTaskReqMsg.extra instanceof e) {
                e eVar = (e) completeTaskReqMsg.extra;
                m(eVar.cFC);
                c0362d = eVar;
            } else if (!(completeTaskReqMsg.extra instanceof C0362d)) {
                c0362d = null;
            } else {
                c0362d = (C0362d) completeTaskReqMsg.extra;
            }
            if (c0362d != null) {
                this.cFt.remove(c0362d);
            }
            awb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar != null) {
            m(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rq(String str) {
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
                                bVar.iM(com.baidu.adp.lib.f.b.toInt(str2, 0));
                                if (bVar.getActivityId() != 0 && bVar.auT() != 0) {
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
        if (bVar != null && this.cFu != null) {
            this.cFu.onProgressUpdate(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(List<h> list) {
        if (!v.isEmpty(list)) {
            LinkedList<com.baidu.tbadk.BdToken.b> linkedList = new LinkedList();
            for (h hVar : list) {
                if (hVar != null && hVar.avF() != null) {
                    com.baidu.tbadk.BdToken.b avF = hVar.avF();
                    if (avF.auQ()) {
                        avF.iS(avF.avh());
                        m(avF);
                    } else if (avF.getActivityId() != 0 && avF.auT() != 0) {
                        linkedList.add(avF);
                    }
                }
            }
            if (!v.isEmpty(linkedList)) {
                HashMap hashMap = new HashMap();
                for (com.baidu.tbadk.BdToken.b bVar : linkedList) {
                    if (bVar != null) {
                        HashSet hashSet = (HashSet) hashMap.get(Integer.valueOf(bVar.getActivityId()));
                        if (hashSet == null) {
                            hashSet = new HashSet();
                            hashMap.put(Integer.valueOf(bVar.getActivityId()), hashSet);
                        }
                        hashSet.add(Integer.valueOf(bVar.auT()));
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
                        com.baidu.tbadk.BdToken.completeTask.c.a(jSONObject2, bVar2.getActivityId(), bVar2.auT(), bVar2.getToken());
                    }
                }
                C0362d c0362d = new C0362d(jSONObject.toString());
                c0362d.token = jSONObject2.toString();
                this.cFt.add(c0362d);
                awb();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(List<com.baidu.tbadk.BdToken.b> list) {
        if (!v.isEmpty(list)) {
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.auQ()) {
                    bVar.iS(bVar.avh());
                    m(bVar);
                } else {
                    this.cFt.add(new e(bVar));
                }
            }
            awb();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0066 -> B:6:0x0007). Please submit an issue!!! */
    private boolean awd() {
        a peek;
        String str;
        com.baidu.tbadk.BdToken.b bVar;
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!this.isLoading && (peek = this.cFt.peek()) != null) {
            if (peek instanceof e) {
                e eVar = (e) peek;
                if (eVar != null && (bVar = eVar.cFC) != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(String.valueOf(bVar.getActivityId()), String.valueOf(bVar.auT()));
                    a(jSONObject.toString(), 1, bVar.getToken(), eVar);
                    return true;
                }
                return false;
            }
            if (peek instanceof C0362d) {
                C0362d c0362d = (C0362d) peek;
                if (c0362d != null && (str = c0362d.data) != null) {
                    a(str, 1, c0362d.token, c0362d);
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private void awe() {
        com.baidu.tieba.tbadkCore.a.a.a(309627, CompleteTaskSocketResMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_COMPLETE_TASK, com.baidu.tieba.tbadkCore.a.a.bv(TbConfig.COMPLETE_TASK_URL, 309627));
        tbHttpMessageTask.setResponsedClass(CompleteTaskHTTPResMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListeners() {
        this.cFw.setTag(getUniqueId());
        this.cFx.setTag(getUniqueId());
        MessageManager.getInstance().registerListener(this.cFw);
        MessageManager.getInstance().registerListener(this.cFx);
    }

    /* loaded from: classes.dex */
    public static class e extends a {
        public com.baidu.tbadk.BdToken.b cFC;

        public e(com.baidu.tbadk.BdToken.b bVar) {
            this.cFC = bVar;
        }
    }

    /* renamed from: com.baidu.tbadk.BdToken.completeTask.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0362d extends a {
        public String data;
        public String token;

        public C0362d(String str) {
            this.data = str;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public List<com.baidu.tbadk.BdToken.b> cFA;
        public List<com.baidu.tbadk.BdToken.b> cFB;
        public List<h> cFz;

        public void c(h hVar) {
            if (this.cFz != null) {
                this.cFz.add(hVar);
            }
        }

        public void s(com.baidu.tbadk.BdToken.b bVar) {
            if (this.cFA != null) {
                this.cFA.add(bVar);
            }
        }

        public void t(com.baidu.tbadk.BdToken.b bVar) {
            if (this.cFB != null) {
                this.cFB.add(bVar);
            }
        }
    }
}
