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
    private c ahK;
    private InterfaceC0142a ahM;
    private TbPageContext mPageContext;
    private b.a ahN = new b.a() { // from class: com.baidu.tbadk.BdToken.a.1
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
                a.this.uH();
                a.this.uG();
            }
        }
    };
    private b ahL = new b();

    /* renamed from: com.baidu.tbadk.BdToken.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0142a {
        void dm(String str);
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.ahL.a(this.ahN);
        this.ahK = new c(tbPageContext);
        MessageManager.getInstance().registerListener(this.mAppEnterBackgroundListener);
    }

    public void check() {
        String uJ = uJ();
        String clipBoardContent = getClipBoardContent();
        if (!ao.isEmpty(uJ) && !ao.isEmpty(clipBoardContent) && Pattern.compile(uJ).matcher(clipBoardContent).find()) {
            dl(clipBoardContent);
        } else if (this.ahK != null && uI()) {
            this.ahK.check();
        }
    }

    public void uG() {
        if (MessageManager.getInstance().findTask(2921361) != null) {
            String clipBoardContent = getClipBoardContent();
            if (Pattern.compile("^\\$[0-9A-Za-z]{5,}\\$$").matcher(clipBoardContent).matches()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921377, clipBoardContent));
                clearClipBoard();
            }
        }
    }

    public void uH() {
        String clipBoardContent = getClipBoardContent();
        if (!ao.isEmpty(clipBoardContent) && clipBoardContent.contains("^sZqulxTVsT$")) {
            dl(clipBoardContent);
        }
    }

    private boolean uI() {
        String topActivityClassName = UtilHelper.getTopActivityClassName();
        return !ao.isEmpty(topActivityClassName) && topActivityClassName.equals("com.baidu.tieba.tblauncher.MainTabActivity") && TbSingleton.getInstance().isRecommendPage();
    }

    private void dl(String str) {
        this.ahL.load(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClipBoard() {
        UtilHelper.clearClipBoard();
    }

    private String getClipBoardContent() {
        return UtilHelper.getClipBoardContent();
    }

    private String uJ() {
        return new String(Base64.decode(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_baidu_password_re", "KFxeWyMkYS16QS1aMC05XXsxMH1cXikqKFxec1pxdWx4VFZzVFwkKSo="), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        if (fVar != null && !ao.isEmpty(fVar.getUrl())) {
            ay.Db().a(this.mPageContext, fVar.getTitle(), new String[]{fVar.getUrl()});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(f fVar) {
        if (fVar != null && fVar.uQ() != null && !ao.isEmpty(fVar.uQ().btntext) && this.ahM != null) {
            this.ahM.dm(fVar.uQ().btntext);
        }
    }

    public void onDestroy() {
        if (this.ahL != null) {
            this.ahL.onDestroy();
        }
        if (this.ahK != null) {
            this.ahK.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mAppEnterBackgroundListener);
    }

    public void a(InterfaceC0142a interfaceC0142a) {
        this.ahM = interfaceC0142a;
    }
}
