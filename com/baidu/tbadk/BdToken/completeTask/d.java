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
    private com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b> bzy;
    private com.baidu.tbadk.BdToken.completeTask.b bzz;
    protected BdUniqueId mBdUniqueId;
    private final Queue<a> mQueue = new LinkedList();
    private boolean isLoading = false;
    private final Handler mHandler = new Handler(this);
    private com.baidu.adp.framework.listener.a bzA = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMPLETE_TASK, 309627) { // from class: com.baidu.tbadk.BdToken.completeTask.d.1
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
                    if (d.this.bzz == null) {
                        d.this.bzz = new com.baidu.tbadk.BdToken.completeTask.b();
                    }
                    d.this.bzz.a(data);
                    d.this.bzz.show();
                    CompleteTaskReqMsg completeTaskReqMsg = (CompleteTaskReqMsg) responsedMessage.getOrginalMessage().getExtra();
                    if (completeTaskReqMsg.extra instanceof C0234d) {
                        obj = (C0234d) completeTaskReqMsg.extra;
                        com.baidu.tbadk.BdToken.b bVar = ((C0234d) obj).bzG;
                        if (data != null && data.bzw == 1) {
                            bVar.bxE = true;
                        }
                        d.this.q(bVar);
                    } else if (completeTaskReqMsg.extra instanceof c) {
                        obj = (c) completeTaskReqMsg.extra;
                        d.this.ln(((c) obj).data);
                    } else {
                        if (completeTaskReqMsg.extra instanceof e) {
                            n.YJ().YK();
                        }
                        obj = null;
                    }
                    if (obj != null) {
                        d.this.mQueue.remove(obj);
                    }
                    d.this.YZ();
                }
            }
        }
    };
    private CustomMessageListener bzB = new CustomMessageListener(2921379) { // from class: com.baidu.tbadk.BdToken.completeTask.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof b)) {
                b bVar = (b) customResponsedMessage.getData();
                d.this.M(bVar.bzD);
                d.this.N(bVar.bzE);
            }
        }
    };

    /* loaded from: classes.dex */
    public static abstract class a {
    }

    /* loaded from: classes.dex */
    public static class e extends a {
    }

    public BdUniqueId getUniqueId() {
        return this.mBdUniqueId;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                Zb();
                return false;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YZ() {
        Message obtain = Message.obtain();
        obtain.what = 1;
        this.mHandler.sendMessage(obtain);
    }

    public d(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        Zc();
        Zd();
    }

    public void a(com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b> bVar) {
        this.bzy = bVar;
    }

    public void Za() {
        if (this.bzz != null) {
            this.bzz.clearData();
        }
    }

    public void a(String str, int i, Object obj) {
        if (j.jS()) {
            this.isLoading = true;
            CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(i);
            completeTaskReqMsg.setTag(this.mBdUniqueId);
            completeTaskReqMsg.completeId = str;
            completeTaskReqMsg.extra = obj;
            completeTaskReqMsg.setNetType(NetMessage.NetType.HTTP);
            MessageManager.getInstance().sendMessage(completeTaskReqMsg);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.BdToken.completeTask.d$d */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void c(ResponsedMessage<?> responsedMessage) {
        c cVar;
        if (responsedMessage != null) {
            CompleteTaskReqMsg completeTaskReqMsg = (CompleteTaskReqMsg) responsedMessage.getOrginalMessage().getExtra();
            if (completeTaskReqMsg.extra instanceof C0234d) {
                C0234d c0234d = (C0234d) completeTaskReqMsg.extra;
                m(c0234d.bzG);
                cVar = c0234d;
            } else if (!(completeTaskReqMsg.extra instanceof c)) {
                cVar = null;
            } else {
                cVar = (c) completeTaskReqMsg.extra;
            }
            if (cVar != null) {
                this.mQueue.remove(cVar);
            }
            YZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar != null) {
            m(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ln(String str) {
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
                                bVar.gc(com.baidu.adp.lib.g.b.f(str2, 0));
                                if (bVar.getActivityId() != 0 && bVar.XU() != 0) {
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
        if (bVar != null && this.bzy != null) {
            this.bzy.onProgressUpdate(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(List<h> list) {
        if (!v.aa(list)) {
            HashMap hashMap = new HashMap();
            for (h hVar : list) {
                if (hVar != null && hVar.YG() != null) {
                    com.baidu.tbadk.BdToken.b YG = hVar.YG();
                    if (YG.XR()) {
                        YG.gi(YG.Yi());
                        m(YG);
                    } else if (YG.getActivityId() != 0 && YG.XU() != 0) {
                        HashSet hashSet = (HashSet) hashMap.get(Integer.valueOf(YG.XU()));
                        if (hashSet == null) {
                            hashSet = new HashSet();
                            hashMap.put(Integer.valueOf(YG.getActivityId()), hashSet);
                        }
                        hashSet.add(Integer.valueOf(YG.XU()));
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
                this.mQueue.add(new c(jSONObject.toString()));
                YZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(List<com.baidu.tbadk.BdToken.b> list) {
        if (!v.aa(list)) {
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.XR()) {
                    bVar.gi(bVar.Yi());
                    m(bVar);
                } else {
                    this.mQueue.add(new C0234d(bVar));
                }
            }
            YZ();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0060 -> B:6:0x0007). Please submit an issue!!! */
    private boolean Zb() {
        a peek;
        String str;
        com.baidu.tbadk.BdToken.b bVar;
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!this.isLoading && (peek = this.mQueue.peek()) != null) {
            if (peek instanceof C0234d) {
                C0234d c0234d = (C0234d) peek;
                if (c0234d != null && (bVar = c0234d.bzG) != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(String.valueOf(bVar.getActivityId()), String.valueOf(bVar.XU()));
                    a(jSONObject.toString(), 1, c0234d);
                    return true;
                }
                return false;
            }
            if (peek instanceof c) {
                c cVar = (c) peek;
                if (cVar != null && (str = cVar.data) != null) {
                    a(str, 1, cVar);
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private void Zc() {
        com.baidu.tieba.tbadkCore.a.a.a(309627, CompleteTaskSocketResMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_COMPLETE_TASK, com.baidu.tieba.tbadkCore.a.a.bn(TbConfig.COMPLETE_TASK_URL, 309627));
        tbHttpMessageTask.setResponsedClass(CompleteTaskHTTPResMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void Zd() {
        this.bzA.setTag(getUniqueId());
        this.bzB.setTag(getUniqueId());
        MessageManager.getInstance().registerListener(this.bzA);
        MessageManager.getInstance().registerListener(this.bzB);
    }

    /* renamed from: com.baidu.tbadk.BdToken.completeTask.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0234d extends a {
        public com.baidu.tbadk.BdToken.b bzG;

        public C0234d(com.baidu.tbadk.BdToken.b bVar) {
            this.bzG = bVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends a {
        public String data;

        public c(String str) {
            this.data = str;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public List<h> bzD;
        public List<com.baidu.tbadk.BdToken.b> bzE;
        public List<com.baidu.tbadk.BdToken.b> bzF;

        public void c(h hVar) {
            if (this.bzD != null) {
                this.bzD.add(hVar);
            }
        }

        public void r(com.baidu.tbadk.BdToken.b bVar) {
            if (this.bzE != null) {
                this.bzE.add(bVar);
            }
        }

        public void s(com.baidu.tbadk.BdToken.b bVar) {
            if (this.bzF != null) {
                this.bzF.add(bVar);
            }
        }
    }
}
