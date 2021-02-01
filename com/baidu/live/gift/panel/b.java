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
/* loaded from: classes11.dex */
public class b {
    private int baK;
    private AlaGiftTabView.a beG;
    private CustomMessageListener bgA;
    private CustomMessageListener bgB;
    private com.baidu.live.noble.b.a bgC;
    private NobleUserInfo bgD;
    private com.baidu.live.an.a bgE;
    private com.baidu.live.gift.a.e bgw;
    private a bgx;
    private CustomMessageListener bgy;
    private CustomMessageListener bgz;
    private TbPageContext mContext;
    private Handler mHandler;

    /* loaded from: classes11.dex */
    public interface a {
        k Ga();

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
        if (this.bgE != null) {
            this.bgE.resume();
        }
    }

    public void onPause() {
        if (this.bgE != null) {
            this.bgE.pause();
        }
    }

    public void a(a aVar, AlaGiftTabView.a aVar2) {
        this.bgx = aVar;
        this.beG = aVar2;
        registerListener();
        this.mHandler = new Handler();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913087));
            }
        }, 300L);
        HT();
        if (this.bgx != null && this.bgw != null && this.bgw.bdp != null) {
            this.bgx.a(this.bgw.bdp);
        }
        HU();
        HV();
    }

    public boolean HN() {
        return this.bgw != null && this.bgw.bdq;
    }

    public void HO() {
        if (this.bgD != null && !TextUtils.isEmpty(this.bgD.detailUrl)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            nobleDetailInfo.url = this.bgD.detailUrl;
            if (this.bgD.user != null) {
                nobleDetailInfo.roleId = this.bgD.user.id;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
            if (this.bgx != null) {
                this.bgx.onClose();
            }
        }
    }

    public void gP(String str) {
        UrlManager.getInstance().dealOneLink(this.mContext, new String[]{str});
    }

    public void u(int i, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        if (!TextUtils.isEmpty(str)) {
            if (this.bgw != null) {
                if (i == 2) {
                    str6 = ExtraParamsManager.getEncryptionUserId(this.bgw.bdi);
                    str7 = ExtraParamsManager.getEncryptionUserId(this.bgw.mUserId);
                } else {
                    str6 = this.bgw.bdi;
                    str7 = this.bgw.mUserId;
                }
                str3 = this.bgw.mRoomId;
                str2 = this.bgw.mLiveId;
                str4 = str7;
                str5 = str6;
            } else {
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
            }
            String a2 = com.baidu.live.utils.b.a(i, str, this.bgw != null && this.bgw.aUi, str5, str4, str3, str2, this.bgw != null ? this.bgw.bdr : null);
            if (i == 2) {
                this.bgE = new com.baidu.live.an.a(this.mContext.getPageActivity());
                com.baidu.live.an.c cVar = new com.baidu.live.an.c();
                cVar.url = a2;
                this.bgE.a(cVar);
                return;
            }
            SchemeUtils.openScheme(a2);
        }
    }

    public void release() {
        this.bgx = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bgC != null) {
            this.bgC.release();
        }
        if (this.bgE != null) {
            this.bgE.release();
        }
        MessageManager.getInstance().unRegisterListener(this.bgy);
        MessageManager.getInstance().unRegisterListener(this.bgz);
        MessageManager.getInstance().unRegisterListener(this.bgA);
        MessageManager.getInstance().unRegisterListener(this.bgB);
    }

    private void k(Intent intent) {
        this.bgw = new com.baidu.live.gift.a.e();
        if (intent != null) {
            this.baK = intent.getIntExtra("custom_tab_id", 1);
            this.bgw.bdi = intent.getStringExtra("login_user_id");
            this.bgw.mUserName = intent.getStringExtra("user_name");
            this.bgw.mUserId = intent.getStringExtra("user_id");
            this.bgw.mLiveId = intent.getStringExtra("live_Id");
            this.bgw.mRoomId = intent.getStringExtra("room_id");
            this.bgw.bdj = intent.getStringExtra("feed_id");
            this.bgw.bdk = intent.getIntExtra("is_block", 0);
            this.bgw.bdl = intent.getStringExtra("scene");
            this.bgw.mAppId = intent.getStringExtra("app_id");
            this.bgw.bdm = intent.getBooleanExtra("can_graffiti", true);
            this.bgw.bbK = intent.getIntExtra("custom_category_id", -1);
            this.bgw.bbL = intent.getIntExtra("custom_gift_id", -1);
            this.bgw.aZF = intent.getBooleanExtra("new_gift_t_dou_strategy", false);
            this.bgw.aZD = intent.getIntExtra(IntentConfig.USER_LEVEL, -1);
            this.bgw.bbc = intent.getBooleanExtra("isJoinGuardClub", false);
            this.bgw.isNewUser = intent.getBooleanExtra("is_new_user", false);
            this.bgw.bbM = intent.getIntExtra("guard_club_join_amount", 1000);
            this.bgw.bbY = intent.getBooleanExtra("is_redpkg_unable", false);
            this.bgw.bdo = intent.getIntExtra("page_from", -1);
            this.bgw.aZL = intent.getBooleanExtra("throne_enabled", false);
            this.bgw.bdq = intent.getBooleanExtra("noble_enabled", false);
            this.bgw.bdr = intent.getStringExtra("active_params");
            String stringExtra = intent.getStringExtra("bg_info");
            if (!TextUtils.isEmpty(stringExtra)) {
                AlaLiveGiftUIInfo alaLiveGiftUIInfo = new AlaLiveGiftUIInfo();
                alaLiveGiftUIInfo.parserJson(stringExtra);
                this.bgw.bdp = alaLiveGiftUIInfo;
            }
            String stringExtra2 = intent.getStringExtra(com.baidu.live.tbadk.core.frameworkdata.IntentConfig.OTHER_PARAMS);
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.bgw.mOtherParams = stringExtra2;
        }
    }

    private void registerListener() {
        HP();
        HQ();
        HR();
        HS();
    }

    private void HP() {
        this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.live.gift.panel.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.bgx != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    b.this.bgx.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bgy);
    }

    private void HQ() {
        this.bgz = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.gift.panel.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.HU();
            }
        };
        MessageManager.getInstance().registerListener(this.bgz);
    }

    private void HR() {
        this.bgA = new CustomMessageListener(2913024) { // from class: com.baidu.live.gift.panel.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.bgx != null) {
                    b.this.bgx.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bgA);
    }

    private void HS() {
        this.bgB = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.live.gift.panel.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.HU();
            }
        };
        MessageManager.getInstance().registerListener(this.bgB);
    }

    private void HT() {
        int i;
        f.a aVar = new f.a() { // from class: com.baidu.live.gift.panel.b.6
            @Override // com.baidu.live.gift.panel.f.a
            public k Ga() {
                if (b.this.bgx != null) {
                    return b.this.bgx.Ga();
                }
                return null;
            }
        };
        c m19do = c.m19do(0);
        m19do.setPageContext(this.mContext);
        m19do.a(aVar);
        m19do.b(this.beG);
        m19do.a(this.bgw);
        c m19do2 = c.m19do(1);
        m19do2.setPageContext(this.mContext);
        m19do2.a(aVar);
        m19do2.b(this.beG);
        m19do2.a(this.bgw);
        switch (this.baK) {
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
        if (this.bgx != null) {
            this.bgx.a(i, m19do, m19do2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HU() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
            httpMessage.addParam("tbs", TbadkCoreApplication.getCurrentTbs());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void HV() {
        CustomResponsedMessage runTask;
        if (HN()) {
            if (this.bgC == null && (runTask = MessageManager.getInstance().runTask(2913198, com.baidu.live.noble.b.a.class, this.mContext.getPageActivity())) != null && runTask.getData() != null) {
                this.bgC = (com.baidu.live.noble.b.a) runTask.getData();
            }
            if (this.bgC != null) {
                this.bgC.a(new a.InterfaceC0189a() { // from class: com.baidu.live.gift.panel.b.7
                    @Override // com.baidu.live.noble.b.a.InterfaceC0189a
                    public void a(NobleUserInfo nobleUserInfo) {
                        b.this.bgD = nobleUserInfo;
                        if (b.this.bgx != null) {
                            b.this.bgx.a(nobleUserInfo != null ? nobleUserInfo.tip : null);
                        }
                    }
                });
                this.bgC.ON();
            }
        }
    }
}
