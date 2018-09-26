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
    private c abX;
    private InterfaceC0094a abZ;
    private TbPageContext mPageContext;
    private b.a aca = new b.a() { // from class: com.baidu.tbadk.BdToken.a.1
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
                a.this.sm();
            }
        }
    };
    private b abY = new b();

    /* renamed from: com.baidu.tbadk.BdToken.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0094a {
        void cV(String str);
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.abY.a(this.aca);
        this.abX = new c(tbPageContext);
        MessageManager.getInstance().registerListener(this.mAppEnterBackgroundListener);
    }

    public void check() {
        String so = so();
        String clipBoardContent = getClipBoardContent();
        if (!ao.isEmpty(so) && !ao.isEmpty(clipBoardContent) && Pattern.compile(so).matcher(clipBoardContent).find()) {
            cU(clipBoardContent);
        } else if (this.abX != null && sn()) {
            this.abX.check();
        }
    }

    public void sm() {
        String clipBoardContent = getClipBoardContent();
        if (!ao.isEmpty(clipBoardContent) && clipBoardContent.contains("^sZqulxTVsT$")) {
            cU(clipBoardContent);
        }
    }

    private boolean sn() {
        String topActivityClassName = UtilHelper.getTopActivityClassName();
        return !ao.isEmpty(topActivityClassName) && topActivityClassName.equals("com.baidu.tieba.tblauncher.MainTabActivity") && TbSingleton.getInstance().isRecommendPage();
    }

    private void cU(String str) {
        this.abY.load(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClipBoard() {
        UtilHelper.clearClipBoard();
    }

    private String getClipBoardContent() {
        return UtilHelper.getClipBoardContent();
    }

    private String so() {
        return new String(Base64.decode(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_baidu_password_re", "XF5bIyRhLXpBLVowLTldezEwfVxe"), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        if (fVar != null && !ao.isEmpty(fVar.getUrl())) {
            ay.AN().a(this.mPageContext, fVar.getTitle(), new String[]{fVar.getUrl()});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(f fVar) {
        if (fVar != null && fVar.sv() != null && !ao.isEmpty(fVar.sv().btntext) && this.abZ != null) {
            this.abZ.cV(fVar.sv().btntext);
        }
    }

    public void onDestroy() {
        if (this.abY != null) {
            this.abY.onDestroy();
        }
        if (this.abX != null) {
            this.abX.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mAppEnterBackgroundListener);
    }

    public void a(InterfaceC0094a interfaceC0094a) {
        this.abZ = interfaceC0094a;
    }
}
