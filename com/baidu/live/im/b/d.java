package com.baidu.live.im.b;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.QuickImInputData;
import com.baidu.live.data.bb;
import com.baidu.live.data.m;
import com.baidu.live.gift.t;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.view.quick.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.view.input.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public class d implements com.baidu.live.view.input.c {
    private c.a atJ;
    private com.baidu.live.im.view.quick.a atK;
    private String[] atL;
    private List<String> atM;
    private CustomMessageListener atN;
    private CustomMessageListener atu;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private String mVid;

    @Override // com.baidu.live.view.input.c
    public void a(c.a aVar) {
        this.atJ = aVar;
    }

    @Override // com.baidu.live.view.input.c
    public void a(m mVar, String str) {
        this.mVid = "";
        if (mVar != null && mVar.mLiveInfo != null && mVar.mLiveInfo.feed_id != null) {
            this.mVid = mVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        xi();
        xj();
    }

    @Override // com.baidu.live.view.input.c
    public void c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.atK = new com.baidu.live.im.view.quick.a(this.mPageContext.getPageActivity());
        this.atK.a(new a.InterfaceC0089a() { // from class: com.baidu.live.im.b.d.1
            @Override // com.baidu.live.im.view.quick.a.InterfaceC0089a
            public boolean ws() {
                return d.this.atJ != null && d.this.atJ.ws();
            }

            @Override // com.baidu.live.im.view.quick.a.InterfaceC0089a
            public void xm() {
                if (d.this.atJ != null) {
                    d.this.atJ.Bx();
                }
            }

            @Override // com.baidu.live.im.view.quick.a.InterfaceC0089a
            public void onDismiss() {
                if (d.this.atJ != null) {
                    d.this.atJ.By();
                }
            }

            @Override // com.baidu.live.im.view.quick.a.InterfaceC0089a
            public void a(int i, String str, bb bbVar) {
                if (d.this.atJ != null && d.this.atJ.ws()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (bbVar != null) {
                        imSendMsgData.msgType = (short) 126;
                        imSendMsgData.barrageType = bbVar.type;
                        imSendMsgData.barrageId = bbVar.id;
                        imSendMsgData.price = bbVar.price;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
                }
                d.this.dx(str);
                d.this.atK.dismiss();
                LogManager.getCommonLogger().doClickQuickImListLog(d.this.mVid, String.valueOf(i), str, d.this.mOtherParams);
            }

            @Override // com.baidu.live.im.view.quick.a.InterfaceC0089a
            public boolean xn() {
                return d.this.atJ != null && d.this.atJ.xn();
            }
        });
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.atK.m(xf());
            t.sG();
        }
    }

    @Override // com.baidu.live.view.input.c
    public void bW(int i) {
        if (this.atK != null && this.atK.isShowing()) {
            this.atK.bW(i);
        }
    }

    @Override // com.baidu.live.view.input.c
    public List<String> xe() {
        QuickImInputData quickImInputData;
        List<String> list;
        if (this.atM == null) {
            this.atM = new ArrayList();
        }
        this.atM.clear();
        com.baidu.live.data.t tVar = com.baidu.live.v.a.zl().awC;
        if (tVar != null && (quickImInputData = tVar.aaC) != null && (list = quickImInputData.sortedTexts) != null && !list.isEmpty()) {
            this.atM.addAll(list);
        }
        if (this.atM.isEmpty()) {
            Collections.addAll(this.atM, xf());
        }
        return this.atM;
    }

    @Override // com.baidu.live.view.input.c
    public void dx(String str) {
        if (!TextUtils.isEmpty(str) && this.atM != null && !this.atM.isEmpty() && this.atM.indexOf(str) > 1) {
            if (this.atM.remove(str)) {
                this.atM.add(1, str);
            }
            com.baidu.live.data.t tVar = com.baidu.live.v.a.zl().awC;
            if (tVar != null) {
                QuickImInputData quickImInputData = tVar.aaC;
                if (quickImInputData == null) {
                    quickImInputData = new QuickImInputData();
                }
                if (quickImInputData.sortedTexts == null) {
                    quickImInputData.sortedTexts = new ArrayList();
                }
                quickImInputData.sortedTexts.clear();
                quickImInputData.sortedTexts.addAll(this.atM);
            }
        }
    }

    @Override // com.baidu.live.view.input.c
    public void sL() {
        if (this.atK != null) {
            if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
                this.atK.dismiss();
            }
            this.atK = null;
            xk();
            xl();
        }
    }

    @Override // com.baidu.live.view.input.c
    public void release() {
        sL();
    }

    private String[] xf() {
        if (this.atL == null || this.atL.length == 0) {
            List<String> xg = xg();
            if (xg != null && !xg.isEmpty()) {
                this.atL = (String[]) xg.toArray(new String[xg.size()]);
            } else {
                this.atL = xh();
            }
        }
        return this.atL;
    }

    private List<String> xg() {
        QuickImInputData quickImInputData;
        List<String> list;
        com.baidu.live.data.t tVar = com.baidu.live.v.a.zl().awC;
        if (tVar == null || (quickImInputData = tVar.aaC) == null || (list = quickImInputData.originTexts) == null || list.isEmpty()) {
            return null;
        }
        return list;
    }

    private String[] xh() {
        return new String[]{"66666", "牛批牛批", "赤道以北，主播最美", "全民女神", "哈哈哈哈哈哈", "扎心了", "老铁，走一个", "请开始你的表演"};
    }

    private void xi() {
        if (this.atN == null) {
            this.atN = new CustomMessageListener(2913122) { // from class: com.baidu.live.im.b.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (d.this.atK != null && d.this.atK.isShowing()) {
                        d.this.atK.yj();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.atN);
        }
    }

    private void xj() {
        if (this.atu == null) {
            this.atu = new CustomMessageListener(2913095) { // from class: com.baidu.live.im.b.d.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                        String str = (String) customResponsedMessage.getData();
                        if (str == null) {
                            str = "";
                        }
                        d.this.mOtherParams = str;
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.atu);
        }
    }

    private void xk() {
        if (this.atN != null) {
            MessageManager.getInstance().unRegisterListener(this.atN);
            this.atN = null;
        }
    }

    private void xl() {
        if (this.atu != null) {
            MessageManager.getInstance().unRegisterListener(this.atu);
        }
    }
}
