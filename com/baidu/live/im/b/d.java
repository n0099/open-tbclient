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
    private CustomMessageListener atE;
    private c.a atT;
    private com.baidu.live.im.view.quick.a atU;
    private String[] atV;
    private List<String> atW;
    private CustomMessageListener atX;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private String mVid;

    @Override // com.baidu.live.view.input.c
    public void a(c.a aVar) {
        this.atT = aVar;
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
        xn();
        xo();
    }

    @Override // com.baidu.live.view.input.c
    public void c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.atU = new com.baidu.live.im.view.quick.a(this.mPageContext.getPageActivity());
        this.atU.a(new a.InterfaceC0089a() { // from class: com.baidu.live.im.b.d.1
            @Override // com.baidu.live.im.view.quick.a.InterfaceC0089a
            public boolean wx() {
                return d.this.atT != null && d.this.atT.wx();
            }

            @Override // com.baidu.live.im.view.quick.a.InterfaceC0089a
            public void xr() {
                if (d.this.atT != null) {
                    d.this.atT.BE();
                }
            }

            @Override // com.baidu.live.im.view.quick.a.InterfaceC0089a
            public void onDismiss() {
                if (d.this.atT != null) {
                    d.this.atT.BF();
                }
            }

            @Override // com.baidu.live.im.view.quick.a.InterfaceC0089a
            public void a(int i, String str, bb bbVar) {
                if (d.this.atT != null && d.this.atT.wx()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (bbVar != null) {
                        imSendMsgData.msgType = (short) 126;
                        imSendMsgData.barrageType = bbVar.type;
                        imSendMsgData.barrageId = bbVar.id;
                        imSendMsgData.price = bbVar.price;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
                }
                d.this.dw(str);
                d.this.atU.dismiss();
                LogManager.getCommonLogger().doClickQuickImListLog(d.this.mVid, String.valueOf(i), str, d.this.mOtherParams);
            }

            @Override // com.baidu.live.im.view.quick.a.InterfaceC0089a
            public boolean xs() {
                return d.this.atT != null && d.this.atT.xs();
            }
        });
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.atU.m(xk());
            t.sL();
        }
    }

    @Override // com.baidu.live.view.input.c
    public void bW(int i) {
        if (this.atU != null && this.atU.isShowing()) {
            this.atU.bW(i);
        }
    }

    @Override // com.baidu.live.view.input.c
    public List<String> xj() {
        QuickImInputData quickImInputData;
        List<String> list;
        if (this.atW == null) {
            this.atW = new ArrayList();
        }
        this.atW.clear();
        com.baidu.live.data.t tVar = com.baidu.live.v.a.zs().awM;
        if (tVar != null && (quickImInputData = tVar.aaM) != null && (list = quickImInputData.sortedTexts) != null && !list.isEmpty()) {
            this.atW.addAll(list);
        }
        if (this.atW.isEmpty()) {
            Collections.addAll(this.atW, xk());
        }
        return this.atW;
    }

    @Override // com.baidu.live.view.input.c
    public void dw(String str) {
        if (!TextUtils.isEmpty(str) && this.atW != null && !this.atW.isEmpty() && this.atW.indexOf(str) > 1) {
            if (this.atW.remove(str)) {
                this.atW.add(1, str);
            }
            com.baidu.live.data.t tVar = com.baidu.live.v.a.zs().awM;
            if (tVar != null) {
                QuickImInputData quickImInputData = tVar.aaM;
                if (quickImInputData == null) {
                    quickImInputData = new QuickImInputData();
                }
                if (quickImInputData.sortedTexts == null) {
                    quickImInputData.sortedTexts = new ArrayList();
                }
                quickImInputData.sortedTexts.clear();
                quickImInputData.sortedTexts.addAll(this.atW);
            }
        }
    }

    @Override // com.baidu.live.view.input.c
    public void sQ() {
        if (this.atU != null) {
            if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
                this.atU.dismiss();
            }
            this.atU = null;
            xp();
            xq();
        }
    }

    @Override // com.baidu.live.view.input.c
    public void release() {
        sQ();
    }

    private String[] xk() {
        if (this.atV == null || this.atV.length == 0) {
            List<String> xl = xl();
            if (xl != null && !xl.isEmpty()) {
                this.atV = (String[]) xl.toArray(new String[xl.size()]);
            } else {
                this.atV = xm();
            }
        }
        return this.atV;
    }

    private List<String> xl() {
        QuickImInputData quickImInputData;
        List<String> list;
        com.baidu.live.data.t tVar = com.baidu.live.v.a.zs().awM;
        if (tVar == null || (quickImInputData = tVar.aaM) == null || (list = quickImInputData.originTexts) == null || list.isEmpty()) {
            return null;
        }
        return list;
    }

    private String[] xm() {
        return new String[]{"66666", "牛批牛批", "赤道以北，主播最美", "全民女神", "哈哈哈哈哈哈", "扎心了", "老铁，走一个", "请开始你的表演"};
    }

    private void xn() {
        if (this.atX == null) {
            this.atX = new CustomMessageListener(2913122) { // from class: com.baidu.live.im.b.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (d.this.atU != null && d.this.atU.isShowing()) {
                        d.this.atU.yo();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.atX);
        }
    }

    private void xo() {
        if (this.atE == null) {
            this.atE = new CustomMessageListener(2913095) { // from class: com.baidu.live.im.b.d.3
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
            MessageManager.getInstance().registerListener(this.atE);
        }
    }

    private void xp() {
        if (this.atX != null) {
            MessageManager.getInstance().unRegisterListener(this.atX);
            this.atX = null;
        }
    }

    private void xq() {
        if (this.atE != null) {
            MessageManager.getInstance().unRegisterListener(this.atE);
        }
    }
}
