package com.baidu.tbadk.BdToken;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.e;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class d {
    public static final Pattern duW = Pattern.compile("\\$[0-9A-Za-z@_]{5,200}[#$]", 2);
    private long duX;
    private r duY;
    private e duZ;
    private AtomicBoolean dva = new AtomicBoolean(false);
    private e.a dvb = new e.a() { // from class: com.baidu.tbadk.BdToken.d.1
        @Override // com.baidu.tbadk.BdToken.e.a
        public void a(boolean z, v vVar) {
            if (z && vVar != null) {
                d.this.clearClipBoard();
                d.this.cU(vVar.getTitle(), vVar.getUrl());
                d.this.a(vVar);
            }
        }
    };
    private boolean isInit;

    public static final d aLs() {
        return a.dvd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static final d dvd = new d();
    }

    public void Z(Activity activity) {
        if (!this.isInit) {
            Fv();
            registerListener();
            this.duZ = new e();
            this.duZ.a(this.dvb);
            this.duY = new r();
            String clipBoardContent = getClipBoardContent();
            if (!aq.isEmpty(clipBoardContent)) {
                aLs().uq(clipBoardContent);
            } else if (UtilHelper.isActivityStartFromScheme(activity)) {
                com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tbadk.BdToken.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        d.aLs().uq(d.this.getClipBoardContent());
                    }
                }, 4000L);
            } else if (ak.isEmui()) {
                com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tbadk.BdToken.d.3
                    @Override // java.lang.Runnable
                    public void run() {
                        d.aLs().uq(d.this.getClipBoardContent());
                    }
                }, 2000L);
            }
            this.isInit = true;
        }
    }

    private void Fv() {
        com.baidu.tieba.tbadkCore.a.a.a(309626, DecryptCodeSocketRespMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_DECRYPT_CODE, com.baidu.tieba.tbadkCore.a.a.bF(TbConfig.DECRYPT_CODE_URL, 309626));
        tbHttpMessageTask.setResponsedClass(DecryptCodeHttpRespMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_HTTP_DECRYPT_CODE, 309626) { // from class: com.baidu.tbadk.BdToken.d.4
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage responsedMessage) {
                g decryptData;
                d.this.dva.compareAndSet(true, false);
                if (responsedMessage instanceof DecryptCodeHttpRespMsg) {
                    decryptData = ((DecryptCodeHttpRespMsg) responsedMessage).getDecryptData();
                } else if (responsedMessage instanceof DecryptCodeSocketRespMsg) {
                    decryptData = ((DecryptCodeSocketRespMsg) responsedMessage).getDecryptData();
                } else {
                    return;
                }
                if (decryptData != null) {
                    UtilHelper.clearClipBoard();
                    int aLA = decryptData.aLA();
                    if (aLA == 1 || aLA == 0) {
                        if (MessageManager.getInstance().findTask(2921361) != null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921377, decryptData));
                        }
                    } else if (aLA == 2) {
                        d.this.cU(decryptData.getTitle(), decryptData.getUrl());
                    } else if (aLA != 4 && aLA == 3 && !StringUtils.isNull(decryptData.getUrl())) {
                        Uri parse = Uri.parse(decryptData.getUrl());
                        String queryParameter = parse != null ? parse.getQueryParameter("obj_source") : "";
                        String queryParameter2 = parse != null ? parse.getQueryParameter("obj_type") : "";
                        String queryParameter3 = parse != null ? parse.getQueryParameter("tid") : "";
                        String queryParameter4 = parse != null ? parse.getQueryParameter("fname") : "";
                        String queryParameter5 = parse != null ? parse.getQueryParameter("eqid") : "";
                        if (!TextUtils.isEmpty(queryParameter) && !TextUtils.isEmpty(queryParameter2) && queryParameter2.startsWith("tbcm")) {
                            d.this.uv(decryptData.getUrl());
                            TiebaStatic.log(new an("c13390").dh("obj_type", queryParameter2).dh("obj_source", queryParameter).dh("tid", queryParameter3).dh("fname", queryParameter4));
                        } else if (TextUtils.isEmpty(queryParameter) || TextUtils.isEmpty(queryParameter2) || com.baidu.tbadk.core.sharedPref.b.aTX().getInt("need_deal_diversion_jump", 0) != 1) {
                            d.this.uv(decryptData.getUrl());
                            if (!TextUtils.isEmpty(queryParameter3)) {
                                TiebaStatic.log(new an("c13390").dh("obj_type", queryParameter2).dh("obj_source", queryParameter).dh("tid", queryParameter3).dh("fname", queryParameter4).dh("query", queryParameter5));
                            }
                        } else {
                            com.baidu.tbadk.core.sharedPref.b.aTX().putInt("need_deal_diversion_jump", 0);
                            if (MessageManager.getInstance().findTask(2921361) != null) {
                                TiebaStatic.log(new an("c13390").dh("obj_type", queryParameter2).dh("obj_source", queryParameter).dh("tid", queryParameter3).dh("fname", queryParameter4).dh("query", queryParameter5));
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921377, decryptData));
                            }
                        }
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.BdToken.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    d.this.uq(d.this.getClipBoardContent());
                }
            }
        });
    }

    public void uq(String str) {
        ur(str);
        ut(str);
        us(str);
    }

    public void ur(String str) {
        if (!aq.isEmpty(str)) {
            new BdAsyncTask<String, Integer, String>() { // from class: com.baidu.tbadk.BdToken.d.6
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public String doInBackground(String... strArr) {
                    Matcher matcher;
                    if (strArr == null || strArr.length < 1) {
                        return null;
                    }
                    String str2 = strArr[0];
                    if (aq.isEmpty(str2)) {
                        return null;
                    }
                    String aLu = d.this.aLu();
                    if (aq.isEmpty(aLu) || (matcher = Pattern.compile(aLu).matcher(str2)) == null || !matcher.find()) {
                        return null;
                    }
                    return str2;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(String str2) {
                    super.onPostExecute((AnonymousClass6) str2);
                    if (str2 == null) {
                        if (d.this.duY != null && d.this.aLt()) {
                            d.this.duY.check();
                            return;
                        }
                        return;
                    }
                    d.this.uu(str2);
                }
            }.execute(str);
        }
    }

    public void us(String str) {
        if (!aq.isEmpty(str)) {
            new BdAsyncTask<String, Integer, String>() { // from class: com.baidu.tbadk.BdToken.d.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public String doInBackground(String... strArr) {
                    Matcher matcher;
                    if (strArr == null || strArr.length < 1) {
                        return null;
                    }
                    String str2 = strArr[0];
                    if (aq.isEmpty(str2) || (matcher = d.duW.matcher(str2)) == null || !matcher.find()) {
                        return null;
                    }
                    return str2;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(String str2) {
                    super.onPostExecute((AnonymousClass7) str2);
                    if (str2 != null && !d.this.dva.get()) {
                        d.this.dva.compareAndSet(false, true);
                        DecryptCodeReqMsg decryptCodeReqMsg = new DecryptCodeReqMsg();
                        decryptCodeReqMsg.setCode(str2);
                        MessageManager.getInstance().sendMessage(decryptCodeReqMsg);
                    }
                }
            }.execute(str);
        }
    }

    public void ut(String str) {
        if (!aq.isEmpty(str) && str.contains("^sZqulxTVsT$")) {
            uu(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aLt() {
        String topActivityClassName = UtilHelper.getTopActivityClassName();
        return !aq.isEmpty(topActivityClassName) && topActivityClassName.equals("com.baidu.tieba.tblauncher.MainTabActivity") && TbSingleton.getInstance().isRecommendPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uu(String str) {
        this.duZ.load(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClipBoard() {
        UtilHelper.clearClipBoard();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getClipBoardContent() {
        if (System.currentTimeMillis() - this.duX < 2000) {
            return null;
        }
        this.duX = System.currentTimeMillis();
        return UtilHelper.getClipBoardContent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aLu() {
        return new String(Base64.decode(com.baidu.tbadk.core.sharedPref.b.aTX().getString("key_baidu_password_re", "LipcXlsjJGEtekEtWjAtOV9dezUsfVxeezAsMX1bXF4kXXsxfS4q"), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cU(String str, String str2) {
        TbPageContext<?> n;
        if (!aq.isEmpty(str2) && (n = n(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            ba.aUZ().a(n, str, new String[]{str2});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uv(String str) {
        Activity currentActivity;
        Uri parse;
        if (!aq.isEmpty(str) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (parse = Uri.parse(str)) != null) {
            if (str.startsWith(f.dvg)) {
                Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                buildUpon.appendQueryParameter(f.dvz, f.dvJ);
                parse = buildUpon.build();
            }
            UtilHelper.dealOneScheme(currentActivity, parse.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(v vVar) {
        if (vVar != null && vVar.aLS() != null && !aq.isEmpty(vVar.aLS().btntext) && aLt()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921380, vVar.aLS().btntext));
        }
    }

    private TbPageContext n(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }
}
