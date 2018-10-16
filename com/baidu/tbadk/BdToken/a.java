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
    private c agX;
    private InterfaceC0118a agZ;
    private TbPageContext mPageContext;
    private b.a aha = new b.a() { // from class: com.baidu.tbadk.BdToken.a.1
        @Override // com.baidu.tbadk.BdToken.b.a
        public void a(boolean z, f fVar) {
            if (z && fVar != null) {
                a.this.clearClipBoard();
                a.this.a(fVar);
                a.this.b(fVar);
            }
        }
    };
    private CustomMessageListener mAppEnterBackgroundListener = new CustomMessageListener(2001011) { // from class: com.baidu.tbadk.BdToken.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                a.this.check();
                a.this.ux();
                a.this.uw();
            }
        }
    };
    private b agY = new b();

    /* renamed from: com.baidu.tbadk.BdToken.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0118a {
        void dm(String str);
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.agY.a(this.aha);
        this.agX = new c(tbPageContext);
        MessageManager.getInstance().registerListener(this.mAppEnterBackgroundListener);
    }

    public void check() {
        String uz = uz();
        String clipBoardContent = getClipBoardContent();
        if (!ao.isEmpty(uz) && !ao.isEmpty(clipBoardContent) && Pattern.compile(uz).matcher(clipBoardContent).find()) {
            dl(clipBoardContent);
        } else if (this.agX != null && uy()) {
            this.agX.check();
        }
    }

    public void uw() {
        if (MessageManager.getInstance().findTask(2921361) != null) {
            String clipBoardContent = getClipBoardContent();
            if (Pattern.compile("^\\$[0-9A-Za-z]{5,}\\$$").matcher(clipBoardContent).matches()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921377, clipBoardContent));
                clearClipBoard();
            }
        }
    }

    public void ux() {
        String clipBoardContent = getClipBoardContent();
        if (!ao.isEmpty(clipBoardContent) && clipBoardContent.contains("^sZqulxTVsT$")) {
            dl(clipBoardContent);
        }
    }

    private boolean uy() {
        String topActivityClassName = UtilHelper.getTopActivityClassName();
        return !ao.isEmpty(topActivityClassName) && topActivityClassName.equals("com.baidu.tieba.tblauncher.MainTabActivity") && TbSingleton.getInstance().isRecommendPage();
    }

    private void dl(String str) {
        this.agY.load(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClipBoard() {
        UtilHelper.clearClipBoard();
    }

    private String getClipBoardContent() {
        return UtilHelper.getClipBoardContent();
    }

    private String uz() {
        return new String(Base64.decode(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_baidu_password_re", "XF5bIyRhLXpBLVowLTldezEwfVxe"), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        if (fVar != null && !ao.isEmpty(fVar.getUrl())) {
            ay.CU().a(this.mPageContext, fVar.getTitle(), new String[]{fVar.getUrl()});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(f fVar) {
        if (fVar != null && fVar.uG() != null && !ao.isEmpty(fVar.uG().btntext) && this.agZ != null) {
            this.agZ.dm(fVar.uG().btntext);
        }
    }

    public void onDestroy() {
        if (this.agY != null) {
            this.agY.onDestroy();
        }
        if (this.agX != null) {
            this.agX.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mAppEnterBackgroundListener);
    }

    public void a(InterfaceC0118a interfaceC0118a) {
        this.agZ = interfaceC0118a;
    }
}
