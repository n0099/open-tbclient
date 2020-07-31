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
import com.baidu.tbadk.core.util.x;
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
    private com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b> dHP;
    private com.baidu.tbadk.BdToken.completeTask.b dHQ;
    protected BdUniqueId mBdUniqueId;
    private final Queue<a> dHO = new LinkedList();
    private boolean isLoading = false;
    private final Handler mHandler = new Handler(this);
    private com.baidu.adp.framework.listener.a dHR = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMPLETE_TASK, 309627) { // from class: com.baidu.tbadk.BdToken.completeTask.d.1
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
                    if (d.this.dHQ == null) {
                        d.this.dHQ = new com.baidu.tbadk.BdToken.completeTask.b();
                    }
                    d.this.dHQ.a(data);
                    d.this.dHQ.show();
                    CompleteTaskReqMsg completeTaskReqMsg = (CompleteTaskReqMsg) responsedMessage.getOrginalMessage().getExtra();
                    if (completeTaskReqMsg.extra instanceof e) {
                        obj = (e) completeTaskReqMsg.extra;
                        com.baidu.tbadk.BdToken.b bVar = ((e) obj).dHX;
                        if (data != null && data.dHM == 1) {
                            bVar.dFe = true;
                        }
                        d.this.r(bVar);
                    } else if (completeTaskReqMsg.extra instanceof C0487d) {
                        obj = (C0487d) completeTaskReqMsg.extra;
                        d.this.vL(((C0487d) obj).data);
                    } else if (completeTaskReqMsg.extra instanceof f) {
                        n.aQD().aQE();
                        obj = null;
                    } else {
                        if (completeTaskReqMsg.extra instanceof c) {
                        }
                        obj = null;
                    }
                    if (obj != null) {
                        d.this.dHO.remove(obj);
                    }
                    d.this.aRo();
                }
            }
        }
    };
    private CustomMessageListener dHS = new CustomMessageListener(2921379) { // from class: com.baidu.tbadk.BdToken.completeTask.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof b)) {
                b bVar = (b) customResponsedMessage.getData();
                d.this.aE(bVar.dHU);
                d.this.aF(bVar.dHV);
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
                aRq();
                return false;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRo() {
        Message obtain = Message.obtain();
        obtain.what = 1;
        this.mHandler.sendMessage(obtain);
    }

    public d(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        aRr();
        registerListeners();
    }

    public void a(com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b> bVar) {
        this.dHP = bVar;
    }

    public void aRp() {
        if (this.dHQ != null) {
            this.dHQ.clearData();
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
        C0487d c0487d;
        if (responsedMessage != null) {
            CompleteTaskReqMsg completeTaskReqMsg = (CompleteTaskReqMsg) responsedMessage.getOrginalMessage().getExtra();
            if (completeTaskReqMsg.extra instanceof e) {
                e eVar = (e) completeTaskReqMsg.extra;
                m(eVar.dHX);
                c0487d = eVar;
            } else if (!(completeTaskReqMsg.extra instanceof C0487d)) {
                c0487d = null;
            } else {
                c0487d = (C0487d) completeTaskReqMsg.extra;
            }
            if (c0487d != null) {
                this.dHO.remove(c0487d);
            }
            aRo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar != null) {
            m(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vL(String str) {
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
                                bVar.kq(com.baidu.adp.lib.f.b.toInt(str2, 0));
                                if (bVar.getActivityId() != 0 && bVar.aPM() != 0) {
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
        if (bVar != null && this.dHP != null) {
            this.dHP.onProgressUpdate(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(List<h> list) {
        if (!x.isEmpty(list)) {
            LinkedList<com.baidu.tbadk.BdToken.b> linkedList = new LinkedList();
            for (h hVar : list) {
                if (hVar != null && hVar.aQA() != null) {
                    com.baidu.tbadk.BdToken.b aQA = hVar.aQA();
                    if (aQA.aPJ()) {
                        aQA.kw(aQA.aQa());
                        m(aQA);
                    } else if (aQA.getActivityId() != 0 && aQA.aPM() != 0) {
                        linkedList.add(aQA);
                    }
                }
            }
            if (!x.isEmpty(linkedList)) {
                HashMap hashMap = new HashMap();
                for (com.baidu.tbadk.BdToken.b bVar : linkedList) {
                    if (bVar != null) {
                        HashSet hashSet = (HashSet) hashMap.get(Integer.valueOf(bVar.getActivityId()));
                        if (hashSet == null) {
                            hashSet = new HashSet();
                            hashMap.put(Integer.valueOf(bVar.getActivityId()), hashSet);
                        }
                        hashSet.add(Integer.valueOf(bVar.aPM()));
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
                        com.baidu.tbadk.BdToken.completeTask.c.a(jSONObject2, bVar2.getActivityId(), bVar2.aPM(), bVar2.getToken());
                    }
                }
                C0487d c0487d = new C0487d(jSONObject.toString());
                c0487d.token = jSONObject2.toString();
                this.dHO.add(c0487d);
                aRo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF(List<com.baidu.tbadk.BdToken.b> list) {
        if (!x.isEmpty(list)) {
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.aPJ()) {
                    bVar.kw(bVar.aQa());
                    m(bVar);
                } else {
                    this.dHO.add(new e(bVar));
                }
            }
            aRo();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0066 -> B:6:0x0007). Please submit an issue!!! */
    private boolean aRq() {
        a peek;
        String str;
        com.baidu.tbadk.BdToken.b bVar;
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!this.isLoading && (peek = this.dHO.peek()) != null) {
            if (peek instanceof e) {
                e eVar = (e) peek;
                if (eVar != null && (bVar = eVar.dHX) != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(String.valueOf(bVar.getActivityId()), String.valueOf(bVar.aPM()));
                    a(jSONObject.toString(), 1, bVar.getToken(), eVar);
                    return true;
                }
                return false;
            }
            if (peek instanceof C0487d) {
                C0487d c0487d = (C0487d) peek;
                if (c0487d != null && (str = c0487d.data) != null) {
                    a(str, 1, c0487d.token, c0487d);
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private void aRr() {
        com.baidu.tieba.tbadkCore.a.a.a(309627, CompleteTaskSocketResMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_COMPLETE_TASK, com.baidu.tieba.tbadkCore.a.a.bC(TbConfig.COMPLETE_TASK_URL, 309627));
        tbHttpMessageTask.setResponsedClass(CompleteTaskHTTPResMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListeners() {
        this.dHR.setTag(getUniqueId());
        this.dHS.setTag(getUniqueId());
        MessageManager.getInstance().registerListener(this.dHR);
        MessageManager.getInstance().registerListener(this.dHS);
    }

    /* loaded from: classes.dex */
    public static class e extends a {
        public com.baidu.tbadk.BdToken.b dHX;

        public e(com.baidu.tbadk.BdToken.b bVar) {
            this.dHX = bVar;
        }
    }

    /* renamed from: com.baidu.tbadk.BdToken.completeTask.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0487d extends a {
        public String data;
        public String token;

        public C0487d(String str) {
            this.data = str;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public List<h> dHU;
        public List<com.baidu.tbadk.BdToken.b> dHV;
        public List<com.baidu.tbadk.BdToken.b> dHW;

        public void c(h hVar) {
            if (this.dHU != null) {
                this.dHU.add(hVar);
            }
        }

        public void s(com.baidu.tbadk.BdToken.b bVar) {
            if (this.dHV != null) {
                this.dHV.add(bVar);
            }
        }

        public void t(com.baidu.tbadk.BdToken.b bVar) {
            if (this.dHW != null) {
                this.dHW.add(bVar);
            }
        }
    }
}
