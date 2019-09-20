package com.baidu.tbadk.BdToken;

import android.app.Activity;
import android.net.Uri;
import android.util.Base64;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.e;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class d {
    public static final Pattern bzs = Pattern.compile("\\$[0-9A-Za-z@]{5,50}[#$]", 2);
    private r bzt;
    private e bzu;
    private AtomicBoolean bzv;
    private e.a bzw;

    public static final d Zu() {
        return a.bzy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static final d bzy = new d();
    }

    private d() {
        this.bzv = new AtomicBoolean(false);
        this.bzw = new e.a() { // from class: com.baidu.tbadk.BdToken.d.1
            @Override // com.baidu.tbadk.BdToken.e.a
            public void a(boolean z, v vVar) {
                if (z && vVar != null) {
                    d.this.clearClipBoard();
                    d.this.bw(vVar.getTitle(), vVar.getUrl());
                    d.this.a(vVar);
                }
            }
        };
        registerTask();
        registerListener();
        this.bzu = new e();
        this.bzu.a(this.bzw);
        this.bzt = new r();
    }

    private void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(309626, DecryptCodeSocketRespMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_DECRYPT_CODE, com.baidu.tieba.tbadkCore.a.a.bq(TbConfig.DECRYPT_CODE_URL, 309626));
        tbHttpMessageTask.setResponsedClass(DecryptCodeHttpRespMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_HTTP_DECRYPT_CODE, 309626) { // from class: com.baidu.tbadk.BdToken.d.2
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage responsedMessage) {
                g decryptData;
                d.this.bzv.compareAndSet(true, false);
                if (responsedMessage instanceof DecryptCodeHttpRespMsg) {
                    decryptData = ((DecryptCodeHttpRespMsg) responsedMessage).getDecryptData();
                } else if (responsedMessage instanceof DecryptCodeSocketRespMsg) {
                    decryptData = ((DecryptCodeSocketRespMsg) responsedMessage).getDecryptData();
                } else {
                    return;
                }
                if (decryptData != null) {
                    UtilHelper.clearClipBoard();
                    int ZF = decryptData.ZF();
                    if (ZF == 1 || ZF == 0) {
                        if (MessageManager.getInstance().findTask(2921361) != null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921377, decryptData));
                        }
                    } else if (ZF == 2) {
                        d.this.bw(decryptData.getTitle(), decryptData.getUrl());
                    } else if (ZF != 4 && ZF == 3 && !StringUtils.isNull(decryptData.getUrl())) {
                        Uri parse = Uri.parse(decryptData.getUrl());
                        if (parse == null || parse.getQueryParameter(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE) == null || parse.getQueryParameter("obj_type") == null || !parse.getQueryParameter("obj_type").equals("wise")) {
                            d.this.ls(decryptData.getUrl());
                        } else if (com.baidu.tbadk.core.sharedPref.b.ahU().getInt("need_deal_diversion_jump", 0) == 1) {
                            com.baidu.tbadk.core.sharedPref.b.ahU().putInt("need_deal_diversion_jump", 0);
                            if (MessageManager.getInstance().findTask(2921361) != null) {
                                TiebaStatic.log(new an("c13390").bT("obj_type", parse.getQueryParameter("obj_type")).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, parse.getQueryParameter(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE)));
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921377, decryptData));
                            }
                        }
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001011) { // from class: com.baidu.tbadk.BdToken.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    d.this.check();
                    d.this.Zw();
                    d.this.Zv();
                }
            }
        });
    }

    public void check() {
        String clipBoardContent = getClipBoardContent();
        if (!aq.isEmpty(clipBoardContent)) {
            new BdAsyncTask<String, Integer, String>() { // from class: com.baidu.tbadk.BdToken.d.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public String doInBackground(String... strArr) {
                    Matcher matcher;
                    if (strArr == null || strArr.length < 1) {
                        return null;
                    }
                    String str = strArr[0];
                    if (aq.isEmpty(str)) {
                        return null;
                    }
                    String Zy = d.this.Zy();
                    if (aq.isEmpty(Zy) || (matcher = Pattern.compile(Zy).matcher(str)) == null || !matcher.find()) {
                        return null;
                    }
                    return str;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(String str) {
                    super.onPostExecute((AnonymousClass4) str);
                    if (str == null) {
                        if (d.this.bzt != null && d.this.Zx()) {
                            d.this.bzt.check();
                            return;
                        }
                        return;
                    }
                    d.this.lr(str);
                }
            }.execute(clipBoardContent);
        }
    }

    public void Zv() {
        String clipBoardContent = getClipBoardContent();
        if (!aq.isEmpty(clipBoardContent)) {
            new BdAsyncTask<String, Integer, String>() { // from class: com.baidu.tbadk.BdToken.d.5
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public String doInBackground(String... strArr) {
                    Matcher matcher;
                    if (strArr == null || strArr.length < 1) {
                        return null;
                    }
                    String str = strArr[0];
                    if (aq.isEmpty(str) || (matcher = d.bzs.matcher(str)) == null || !matcher.find()) {
                        return null;
                    }
                    return str;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(String str) {
                    super.onPostExecute((AnonymousClass5) str);
                    if (str != null && !d.this.bzv.get()) {
                        d.this.bzv.compareAndSet(false, true);
                        DecryptCodeReqMsg decryptCodeReqMsg = new DecryptCodeReqMsg();
                        decryptCodeReqMsg.setCode(str);
                        MessageManager.getInstance().sendMessage(decryptCodeReqMsg);
                    }
                }
            }.execute(clipBoardContent);
        }
    }

    public void Zw() {
        String clipBoardContent = getClipBoardContent();
        if (!aq.isEmpty(clipBoardContent) && clipBoardContent.contains("^sZqulxTVsT$")) {
            lr(clipBoardContent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Zx() {
        String topActivityClassName = UtilHelper.getTopActivityClassName();
        return !aq.isEmpty(topActivityClassName) && topActivityClassName.equals("com.baidu.tieba.tblauncher.MainTabActivity") && TbSingleton.getInstance().isRecommendPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lr(String str) {
        this.bzu.load(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClipBoard() {
        UtilHelper.clearClipBoard();
    }

    private String getClipBoardContent() {
        return UtilHelper.getClipBoardContent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Zy() {
        return new String(Base64.decode(com.baidu.tbadk.core.sharedPref.b.ahU().getString("key_baidu_password_re", "JTVDJTVFJTVCJTIzJTI0YS16QS1aMC05JTVEJTdCMTAlN0QlNUMlNUUlN0IwJTJDMSU3RCU1QiU1QyU1RSUyNCU1RCU3QjElN0Q="), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bw(String str, String str2) {
        TbPageContext<?> Y;
        if (!aq.isEmpty(str2) && (Y = Y(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            ba.ajK().a(Y, str, new String[]{str2});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ls(String str) {
        Activity currentActivity;
        Uri parse;
        if (!aq.isEmpty(str) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (parse = Uri.parse(str)) != null) {
            if (str.startsWith(f.bzB)) {
                Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                buildUpon.appendQueryParameter(f.bzL, f.bzP);
                parse = buildUpon.build();
            }
            UtilHelper.dealOneScheme(currentActivity, parse.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(v vVar) {
        if (vVar != null && vVar.ZX() != null && !aq.isEmpty(vVar.ZX().btntext) && Zx()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921380, vVar.ZX().btntext));
        }
    }

    private TbPageContext Y(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }
}
