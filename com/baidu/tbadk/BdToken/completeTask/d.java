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
    private com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b> bAT;
    private com.baidu.tbadk.BdToken.completeTask.b bAU;
    protected BdUniqueId mBdUniqueId;
    private final Queue<a> mQueue = new LinkedList();
    private boolean isLoading = false;
    private final Handler mHandler = new Handler(this);
    private com.baidu.adp.framework.listener.a bAV = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMPLETE_TASK, 309627) { // from class: com.baidu.tbadk.BdToken.completeTask.d.1
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
                    if (d.this.bAU == null) {
                        d.this.bAU = new com.baidu.tbadk.BdToken.completeTask.b();
                    }
                    d.this.bAU.a(data);
                    d.this.bAU.show();
                    CompleteTaskReqMsg completeTaskReqMsg = (CompleteTaskReqMsg) responsedMessage.getOrginalMessage().getExtra();
                    if (completeTaskReqMsg.extra instanceof e) {
                        obj = (e) completeTaskReqMsg.extra;
                        com.baidu.tbadk.BdToken.b bVar = ((e) obj).bBb;
                        if (data != null && data.bAR == 1) {
                            bVar.byT = true;
                        }
                        d.this.r(bVar);
                    } else if (completeTaskReqMsg.extra instanceof C0245d) {
                        obj = (C0245d) completeTaskReqMsg.extra;
                        d.this.lw(((C0245d) obj).data);
                    } else if (completeTaskReqMsg.extra instanceof f) {
                        n.ZJ().ZK();
                        obj = null;
                    } else {
                        if (completeTaskReqMsg.extra instanceof c) {
                        }
                        obj = null;
                    }
                    if (obj != null) {
                        d.this.mQueue.remove(obj);
                    }
                    d.this.aac();
                }
            }
        }
    };
    private CustomMessageListener bAW = new CustomMessageListener(2921379) { // from class: com.baidu.tbadk.BdToken.completeTask.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof b)) {
                b bVar = (b) customResponsedMessage.getData();
                d.this.M(bVar.bAY);
                d.this.N(bVar.bAZ);
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
                aae();
                return false;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aac() {
        Message obtain = Message.obtain();
        obtain.what = 1;
        this.mHandler.sendMessage(obtain);
    }

    public d(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        aaf();
        aag();
    }

    public void a(com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b> bVar) {
        this.bAT = bVar;
    }

    public void aad() {
        if (this.bAU != null) {
            this.bAU.clearData();
        }
    }

    public void a(String str, int i, Object obj) {
        if (j.kc()) {
            this.isLoading = true;
            CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(i);
            completeTaskReqMsg.setTag(this.mBdUniqueId);
            completeTaskReqMsg.completeId = str;
            completeTaskReqMsg.extra = obj;
            completeTaskReqMsg.setNetType(NetMessage.NetType.HTTP);
            MessageManager.getInstance().sendMessage(completeTaskReqMsg);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.BdToken.completeTask.d$e */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void c(ResponsedMessage<?> responsedMessage) {
        C0245d c0245d;
        if (responsedMessage != null) {
            CompleteTaskReqMsg completeTaskReqMsg = (CompleteTaskReqMsg) responsedMessage.getOrginalMessage().getExtra();
            if (completeTaskReqMsg.extra instanceof e) {
                e eVar = (e) completeTaskReqMsg.extra;
                m(eVar.bBb);
                c0245d = eVar;
            } else if (!(completeTaskReqMsg.extra instanceof C0245d)) {
                c0245d = null;
            } else {
                c0245d = (C0245d) completeTaskReqMsg.extra;
            }
            if (c0245d != null) {
                this.mQueue.remove(c0245d);
            }
            aac();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar != null) {
            m(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lw(String str) {
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
                                bVar.setActivityId(com.baidu.adp.lib.g.b.f(next, 0));
                                bVar.gh(com.baidu.adp.lib.g.b.f(str2, 0));
                                if (bVar.getActivityId() != 0 && bVar.YU() != 0) {
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
        if (bVar != null && this.bAT != null) {
            this.bAT.onProgressUpdate(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(List<h> list) {
        if (!v.aa(list)) {
            HashMap hashMap = new HashMap();
            for (h hVar : list) {
                if (hVar != null && hVar.ZG() != null) {
                    com.baidu.tbadk.BdToken.b ZG = hVar.ZG();
                    if (ZG.YR()) {
                        ZG.gn(ZG.Zi());
                        m(ZG);
                    } else if (ZG.getActivityId() != 0 && ZG.YU() != 0) {
                        HashSet hashSet = (HashSet) hashMap.get(Integer.valueOf(ZG.YU()));
                        if (hashSet == null) {
                            hashSet = new HashSet();
                            hashMap.put(Integer.valueOf(ZG.getActivityId()), hashSet);
                        }
                        hashSet.add(Integer.valueOf(ZG.YU()));
                    }
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
            if (jSONObject != null) {
                this.mQueue.add(new C0245d(jSONObject.toString()));
                aac();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(List<com.baidu.tbadk.BdToken.b> list) {
        if (!v.aa(list)) {
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.YR()) {
                    bVar.gn(bVar.Zi());
                    m(bVar);
                } else {
                    this.mQueue.add(new e(bVar));
                }
            }
            aac();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0060 -> B:6:0x0007). Please submit an issue!!! */
    private boolean aae() {
        a peek;
        String str;
        com.baidu.tbadk.BdToken.b bVar;
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!this.isLoading && (peek = this.mQueue.peek()) != null) {
            if (peek instanceof e) {
                e eVar = (e) peek;
                if (eVar != null && (bVar = eVar.bBb) != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(String.valueOf(bVar.getActivityId()), String.valueOf(bVar.YU()));
                    a(jSONObject.toString(), 1, eVar);
                    return true;
                }
                return false;
            }
            if (peek instanceof C0245d) {
                C0245d c0245d = (C0245d) peek;
                if (c0245d != null && (str = c0245d.data) != null) {
                    a(str, 1, c0245d);
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private void aaf() {
        com.baidu.tieba.tbadkCore.a.a.a(309627, CompleteTaskSocketResMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_COMPLETE_TASK, com.baidu.tieba.tbadkCore.a.a.bq(TbConfig.COMPLETE_TASK_URL, 309627));
        tbHttpMessageTask.setResponsedClass(CompleteTaskHTTPResMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void aag() {
        this.bAV.setTag(getUniqueId());
        this.bAW.setTag(getUniqueId());
        MessageManager.getInstance().registerListener(this.bAV);
        MessageManager.getInstance().registerListener(this.bAW);
    }

    /* loaded from: classes.dex */
    public static class e extends a {
        public com.baidu.tbadk.BdToken.b bBb;

        public e(com.baidu.tbadk.BdToken.b bVar) {
            this.bBb = bVar;
        }
    }

    /* renamed from: com.baidu.tbadk.BdToken.completeTask.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0245d extends a {
        public String data;

        public C0245d(String str) {
            this.data = str;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public List<h> bAY;
        public List<com.baidu.tbadk.BdToken.b> bAZ;
        public List<com.baidu.tbadk.BdToken.b> bBa;

        public void c(h hVar) {
            if (this.bAY != null) {
                this.bAY.add(hVar);
            }
        }

        public void s(com.baidu.tbadk.BdToken.b bVar) {
            if (this.bAZ != null) {
                this.bAZ.add(bVar);
            }
        }

        public void t(com.baidu.tbadk.BdToken.b bVar) {
            if (this.bBa != null) {
                this.bBa.add(bVar);
            }
        }
    }
}
