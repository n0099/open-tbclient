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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class a {
    private c Zx;
    private TbPageContext mPageContext;
    private b.a Zz = new b.a() { // from class: com.baidu.tbadk.BdToken.a.1
        @Override // com.baidu.tbadk.BdToken.b.a
        public void a(boolean z, f fVar) {
            if (z && fVar != null && !ap.isEmpty(fVar.getUrl())) {
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
                a.this.rh();
            }
        }
    };
    private b Zy = new b();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.Zy.a(this.Zz);
        this.Zx = new c(tbPageContext);
        MessageManager.getInstance().registerListener(this.mAppEnterBackgroundListener);
    }

    public void check() {
        String rj = rj();
        String clipBoardContent = getClipBoardContent();
        if (!ap.isEmpty(rj) && !ap.isEmpty(clipBoardContent) && Pattern.compile(rj).matcher(clipBoardContent).find()) {
            cE(clipBoardContent);
        } else if (this.Zx != null && ri()) {
            this.Zx.check();
        }
    }

    public void rh() {
        String clipBoardContent = getClipBoardContent();
        if (!ap.isEmpty(clipBoardContent) && clipBoardContent.contains("^sZqulxTVsT$")) {
            cE(clipBoardContent);
        }
    }

    private boolean ri() {
        String topActivityClassName = UtilHelper.getTopActivityClassName();
        return !ap.isEmpty(topActivityClassName) && topActivityClassName.equals("com.baidu.tieba.tblauncher.MainTabActivity") && TbSingleton.getInstance().isRecommendPage();
    }

    private void cE(String str) {
        this.Zy.load(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClipBoard() {
        UtilHelper.clearClipBoard();
    }

    private String getClipBoardContent() {
        return UtilHelper.getClipBoardContent();
    }

    private String rj() {
        return new String(Base64.decode(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_baidu_password_re", "XF5bIyRhLXpBLVowLTldezEwfVxe"), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        if (fVar != null) {
            az.zI().a(this.mPageContext, fVar.getTitle(), new String[]{fVar.getUrl()});
        }
    }

    public void onDestroy() {
        if (this.Zy != null) {
            this.Zy.onDestroy();
        }
        if (this.Zx != null) {
            this.Zx.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.mAppEnterBackgroundListener);
    }
}
