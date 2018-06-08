package com.baidu.tbadk.BdToken;

import android.util.Base64;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BdToken.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class a {
    private c ZP;
    private TbPageContext mPageContext;
    private b.a ZR = new b.a() { // from class: com.baidu.tbadk.BdToken.a.1
        @Override // com.baidu.tbadk.BdToken.b.a
        public void a(boolean z, f fVar) {
            if (z && fVar != null && !ao.isEmpty(fVar.getUrl())) {
                a.this.clearClipBoard();
                a.this.a(fVar);
            }
        }
    };
    private CustomMessageListener mAppEnterBackgroundListener = new CustomMessageListener(2001011) { // from class: com.baidu.tbadk.BdToken.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                a.this.check();
            }
        }
    };
    private b ZQ = new b();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.ZQ.a(this.ZR);
        this.ZP = new c(tbPageContext);
        MessageManager.getInstance().registerListener(this.mAppEnterBackgroundListener);
    }

    public void check() {
        String rB = rB();
        String clipBoardContent = getClipBoardContent();
        if (!ao.isEmpty(rB) && !ao.isEmpty(clipBoardContent) && Pattern.compile(rB).matcher(clipBoardContent).find()) {
            cF(clipBoardContent);
        } else if (this.ZP != null && rA()) {
            this.ZP.check();
        }
    }

    private boolean rA() {
        String topActivityClassName = UtilHelper.getTopActivityClassName();
        return !ao.isEmpty(topActivityClassName) && topActivityClassName.equals("com.baidu.tieba.tblauncher.MainTabActivity") && TbSingleton.getInstance().isRecommendPage();
    }

    private void cF(String str) {
        this.ZQ.load(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClipBoard() {
        UtilHelper.clearClipBoard();
    }

    private String getClipBoardContent() {
        return UtilHelper.getClipBoardContent();
    }

    private String rB() {
        return new String(Base64.decode(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_baidu_password_re", "XF5bIyRhLXpBLVowLTldezEwfVxe"), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        if (fVar != null) {
            ay.zG().a(this.mPageContext, fVar.getTitle(), new String[]{fVar.getUrl()});
        }
    }

    public void onDestroy() {
        if (this.ZQ != null) {
            this.ZQ.onDestroy();
        }
        if (this.ZP != null) {
            this.ZP.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mAppEnterBackgroundListener);
    }
}
