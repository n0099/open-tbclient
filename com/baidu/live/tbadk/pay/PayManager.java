package com.baidu.live.tbadk.pay;

import android.os.Build;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.core.util.UrlManager;
/* loaded from: classes6.dex */
public class PayManager {
    private static PayManager instance = null;
    private WalletSwan mWalletSwan;

    private PayManager() {
    }

    public static synchronized PayManager getInstance() {
        PayManager payManager;
        synchronized (PayManager.class) {
            if (instance == null) {
                instance = new PayManager();
            }
            payManager = instance;
        }
        return payManager;
    }

    public boolean isWalletOk() {
        return TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_MY_WALLET) && TbadkCoreApplication.getInst().isWalletShouldOpen() && Build.VERSION.SDK_INT >= 8 && isWalletClassloadedSucc();
    }

    private boolean isWalletClassloadedSucc() {
        try {
            Class.forName("com.baidu.wallet.api.BaiduWallet");
            return true;
        } catch (ClassNotFoundException e) {
            BdLog.e(e);
            return false;
        }
    }

    public void doPayH5(String str, TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
    }

    public void doPayByWallet(IntentConfig intentConfig) {
        if (intentConfig == null) {
            showToast(a.i.sdk_plugin_pay_error);
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, intentConfig));
    }

    private void showToast(int i) {
        BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), i);
    }

    public void setWalletPay(WalletSwan walletSwan) {
        this.mWalletSwan = walletSwan;
    }

    public WalletSwan getWalletSwan() {
        return this.mWalletSwan;
    }
}
