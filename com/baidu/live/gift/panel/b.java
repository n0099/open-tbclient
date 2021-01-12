package com.baidu.live.gift.panel;

import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.data.AlaLiveGiftUIInfo;
import com.baidu.live.gift.container.AlaGiftTabView;
import com.baidu.live.gift.k;
import com.baidu.live.gift.panel.f;
import com.baidu.live.noble.b.a;
import com.baidu.live.noble.data.NobleDetailInfo;
import com.baidu.live.noble.data.NobleUserInfo;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.fragment.SupportXFragment;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.scheme.SchemeUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes10.dex */
public class b {
    private int aXD;
    private AlaGiftTabView.a bbz;
    private com.baidu.live.gift.a.e bdm;
    private a bdn;
    private CustomMessageListener bdo;
    private CustomMessageListener bdp;
    private CustomMessageListener bdq;
    private CustomMessageListener bdr;
    private com.baidu.live.noble.b.a bds;
    private NobleUserInfo bdt;
    private com.baidu.live.x.a bdu;
    private TbPageContext mContext;
    private Handler mHandler;

    /* loaded from: classes10.dex */
    public interface a {
        k EK();

        void a(int i, SupportXFragment... supportXFragmentArr);

        void a(AlaLiveGiftUIInfo alaLiveGiftUIInfo);

        void a(NobleUserInfo.a aVar);

        void onClose();
    }

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void init(Intent intent) {
        k(intent);
    }

    public void onResume() {
        if (this.bdu != null) {
            this.bdu.resume();
        }
    }

    public void onPause() {
        if (this.bdu != null) {
            this.bdu.pause();
        }
    }

    public void a(a aVar, AlaGiftTabView.a aVar2) {
        this.bdn = aVar;
        this.bbz = aVar2;
        registerListener();
        this.mHandler = new Handler();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913087));
            }
        }, 300L);
        GD();
        if (this.bdn != null && this.bdm != null && this.bdm.bai != null) {
            this.bdn.a(this.bdm.bai);
        }
        GE();
        GF();
    }

    public boolean Gx() {
        return this.bdm != null && this.bdm.baj;
    }

    public void Gy() {
        if (this.bdt != null && !TextUtils.isEmpty(this.bdt.detailUrl)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            nobleDetailInfo.url = this.bdt.detailUrl;
            if (this.bdt.user != null) {
                nobleDetailInfo.roleId = this.bdt.user.id;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
            if (this.bdn != null) {
                this.bdn.onClose();
            }
        }
    }

    public void gr(String str) {
        UrlManager.getInstance().dealOneLink(this.mContext, new String[]{str});
    }

    public void r(int i, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        if (!TextUtils.isEmpty(str)) {
            if (this.bdm != null) {
                if (i == 2) {
                    str6 = ExtraParamsManager.getEncryptionUserId(this.bdm.bab);
                    str7 = ExtraParamsManager.getEncryptionUserId(this.bdm.mUserId);
                } else {
                    str6 = this.bdm.bab;
                    str7 = this.bdm.mUserId;
                }
                str3 = this.bdm.mRoomId;
                str2 = this.bdm.mLiveId;
                str4 = str7;
                str5 = str6;
            } else {
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
            }
            String a2 = com.baidu.live.utils.b.a(i, str, this.bdm != null && this.bdm.aRd, str5, str4, str3, str2, this.bdm != null ? this.bdm.bak : null);
            if (i == 2) {
                this.bdu = new com.baidu.live.x.c(this.mContext.getPageActivity());
                this.bdu.gT(a2);
                return;
            }
            SchemeUtils.openScheme(a2);
        }
    }

    public void release() {
        this.bdn = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bds != null) {
            this.bds.release();
        }
        if (this.bdu != null) {
            this.bdu.release();
        }
        MessageManager.getInstance().unRegisterListener(this.bdo);
        MessageManager.getInstance().unRegisterListener(this.bdp);
        MessageManager.getInstance().unRegisterListener(this.bdq);
        MessageManager.getInstance().unRegisterListener(this.bdr);
    }

    private void k(Intent intent) {
        this.bdm = new com.baidu.live.gift.a.e();
        if (intent != null) {
            this.aXD = intent.getIntExtra("custom_tab_id", 1);
            this.bdm.bab = intent.getStringExtra("login_user_id");
            this.bdm.mUserName = intent.getStringExtra("user_name");
            this.bdm.mUserId = intent.getStringExtra("user_id");
            this.bdm.mLiveId = intent.getStringExtra("live_Id");
            this.bdm.mRoomId = intent.getStringExtra("room_id");
            this.bdm.bac = intent.getStringExtra("feed_id");
            this.bdm.bad = intent.getIntExtra("is_block", 0);
            this.bdm.bae = intent.getStringExtra("scene");
            this.bdm.mAppId = intent.getStringExtra("app_id");
            this.bdm.baf = intent.getBooleanExtra("can_graffiti", true);
            this.bdm.aYD = intent.getIntExtra("custom_category_id", -1);
            this.bdm.aYE = intent.getIntExtra("custom_gift_id", -1);
            this.bdm.aWz = intent.getBooleanExtra("new_gift_t_dou_strategy", false);
            this.bdm.aWx = intent.getIntExtra(IntentConfig.USER_LEVEL, -1);
            this.bdm.aXV = intent.getBooleanExtra("isJoinGuardClub", false);
            this.bdm.isNewUser = intent.getBooleanExtra("is_new_user", false);
            this.bdm.aYF = intent.getIntExtra("guard_club_join_amount", 1000);
            this.bdm.aYR = intent.getBooleanExtra("is_redpkg_unable", false);
            this.bdm.bah = intent.getIntExtra("page_from", -1);
            this.bdm.aWF = intent.getBooleanExtra("throne_enabled", false);
            this.bdm.baj = intent.getBooleanExtra("noble_enabled", false);
            this.bdm.bak = intent.getStringExtra("active_params");
            String stringExtra = intent.getStringExtra("bg_info");
            if (!TextUtils.isEmpty(stringExtra)) {
                AlaLiveGiftUIInfo alaLiveGiftUIInfo = new AlaLiveGiftUIInfo();
                alaLiveGiftUIInfo.parserJson(stringExtra);
                this.bdm.bai = alaLiveGiftUIInfo;
            }
            String stringExtra2 = intent.getStringExtra(com.baidu.live.tbadk.core.frameworkdata.IntentConfig.OTHER_PARAMS);
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.bdm.mOtherParams = stringExtra2;
        }
    }

    private void registerListener() {
        Gz();
        GA();
        GB();
        GC();
    }

    private void Gz() {
        this.bdo = new CustomMessageListener(2913097) { // from class: com.baidu.live.gift.panel.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.bdn != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    b.this.bdn.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bdo);
    }

    private void GA() {
        this.bdp = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.gift.panel.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.GE();
            }
        };
        MessageManager.getInstance().registerListener(this.bdp);
    }

    private void GB() {
        this.bdq = new CustomMessageListener(2913024) { // from class: com.baidu.live.gift.panel.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.bdn != null) {
                    b.this.bdn.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bdq);
    }

    private void GC() {
        this.bdr = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.live.gift.panel.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.GE();
            }
        };
        MessageManager.getInstance().registerListener(this.bdr);
    }

    private void GD() {
        int i;
        f.a aVar = new f.a() { // from class: com.baidu.live.gift.panel.b.6
            @Override // com.baidu.live.gift.panel.f.a
            public k EK() {
                if (b.this.bdn != null) {
                    return b.this.bdn.EK();
                }
                return null;
            }
        };
        c dj = c.dj(0);
        dj.setPageContext(this.mContext);
        dj.a(aVar);
        dj.b(this.bbz);
        dj.a(this.bdm);
        c dj2 = c.dj(1);
        dj2.setPageContext(this.mContext);
        dj2.a(aVar);
        dj2.b(this.bbz);
        dj2.a(this.bdm);
        switch (this.aXD) {
            case 1:
                i = 0;
                break;
            case 2:
                i = 1;
                break;
            default:
                i = 0;
                break;
        }
        if (this.bdn != null) {
            this.bdn.a(i, dj, dj2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GE() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
            httpMessage.addParam("tbs", TbadkCoreApplication.getCurrentTbs());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void GF() {
        CustomResponsedMessage runTask;
        if (Gx()) {
            if (this.bds == null && (runTask = MessageManager.getInstance().runTask(2913198, com.baidu.live.noble.b.a.class, this.mContext.getPageActivity())) != null && runTask.getData() != null) {
                this.bds = (com.baidu.live.noble.b.a) runTask.getData();
            }
            if (this.bds != null) {
                this.bds.a(new a.InterfaceC0188a() { // from class: com.baidu.live.gift.panel.b.7
                    @Override // com.baidu.live.noble.b.a.InterfaceC0188a
                    public void a(NobleUserInfo nobleUserInfo) {
                        b.this.bdt = nobleUserInfo;
                        if (b.this.bdn != null) {
                            b.this.bdn.a(nobleUserInfo != null ? nobleUserInfo.tip : null);
                        }
                    }
                });
                this.bds.No();
            }
        }
    }
}
