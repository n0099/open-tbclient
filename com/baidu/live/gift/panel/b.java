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
    private int bck;
    private AlaGiftTabView.a bgi;
    private com.baidu.live.gift.a.e bhW;
    private a bhX;
    private CustomMessageListener bhY;
    private CustomMessageListener bhZ;
    private CustomMessageListener bia;
    private CustomMessageListener bib;
    private com.baidu.live.noble.b.a bic;
    private NobleUserInfo bie;
    private com.baidu.live.an.a bif;
    private TbPageContext mContext;
    private Handler mHandler;

    /* loaded from: classes10.dex */
    public interface a {
        k Gd();

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
        if (this.bif != null) {
            this.bif.resume();
        }
    }

    public void onPause() {
        if (this.bif != null) {
            this.bif.pause();
        }
    }

    public void a(a aVar, AlaGiftTabView.a aVar2) {
        this.bhX = aVar;
        this.bgi = aVar2;
        registerListener();
        this.mHandler = new Handler();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913087));
            }
        }, 300L);
        HW();
        if (this.bhX != null && this.bhW != null && this.bhW.beR != null) {
            this.bhX.a(this.bhW.beR);
        }
        HX();
        HY();
    }

    public boolean HQ() {
        return this.bhW != null && this.bhW.beS;
    }

    public void HR() {
        if (this.bie != null && !TextUtils.isEmpty(this.bie.detailUrl)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            nobleDetailInfo.url = this.bie.detailUrl;
            if (this.bie.user != null) {
                nobleDetailInfo.roleId = this.bie.user.id;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
            if (this.bhX != null) {
                this.bhX.onClose();
            }
        }
    }

    public void gV(String str) {
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
            if (this.bhW != null) {
                if (i == 2) {
                    str6 = ExtraParamsManager.getEncryptionUserId(this.bhW.beK);
                    str7 = ExtraParamsManager.getEncryptionUserId(this.bhW.mUserId);
                } else {
                    str6 = this.bhW.beK;
                    str7 = this.bhW.mUserId;
                }
                str3 = this.bhW.mRoomId;
                str2 = this.bhW.mLiveId;
                str4 = str7;
                str5 = str6;
            } else {
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
            }
            String a2 = com.baidu.live.utils.b.a(i, str, this.bhW != null && this.bhW.aVI, str5, str4, str3, str2, this.bhW != null ? this.bhW.beT : null);
            if (i == 2) {
                this.bif = new com.baidu.live.an.a(this.mContext.getPageActivity());
                com.baidu.live.an.c cVar = new com.baidu.live.an.c();
                cVar.url = a2;
                this.bif.a(cVar);
                return;
            }
            SchemeUtils.openScheme(a2);
        }
    }

    public void release() {
        this.bhX = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bic != null) {
            this.bic.release();
        }
        if (this.bif != null) {
            this.bif.release();
        }
        MessageManager.getInstance().unRegisterListener(this.bhY);
        MessageManager.getInstance().unRegisterListener(this.bhZ);
        MessageManager.getInstance().unRegisterListener(this.bia);
        MessageManager.getInstance().unRegisterListener(this.bib);
    }

    private void k(Intent intent) {
        this.bhW = new com.baidu.live.gift.a.e();
        if (intent != null) {
            this.bck = intent.getIntExtra("custom_tab_id", 1);
            this.bhW.beK = intent.getStringExtra("login_user_id");
            this.bhW.mUserName = intent.getStringExtra("user_name");
            this.bhW.mUserId = intent.getStringExtra("user_id");
            this.bhW.mLiveId = intent.getStringExtra("live_Id");
            this.bhW.mRoomId = intent.getStringExtra("room_id");
            this.bhW.beL = intent.getStringExtra("feed_id");
            this.bhW.beM = intent.getIntExtra("is_block", 0);
            this.bhW.beN = intent.getStringExtra("scene");
            this.bhW.mAppId = intent.getStringExtra("app_id");
            this.bhW.beO = intent.getBooleanExtra("can_graffiti", true);
            this.bhW.bdk = intent.getIntExtra("custom_category_id", -1);
            this.bhW.bdl = intent.getIntExtra("custom_gift_id", -1);
            this.bhW.bbg = intent.getBooleanExtra("new_gift_t_dou_strategy", false);
            this.bhW.bbe = intent.getIntExtra(IntentConfig.USER_LEVEL, -1);
            this.bhW.bcC = intent.getBooleanExtra("isJoinGuardClub", false);
            this.bhW.isNewUser = intent.getBooleanExtra("is_new_user", false);
            this.bhW.bdm = intent.getIntExtra("guard_club_join_amount", 1000);
            this.bhW.bdy = intent.getBooleanExtra("is_redpkg_unable", false);
            this.bhW.beQ = intent.getIntExtra("page_from", -1);
            this.bhW.bbm = intent.getBooleanExtra("throne_enabled", false);
            this.bhW.beS = intent.getBooleanExtra("noble_enabled", false);
            this.bhW.beT = intent.getStringExtra("active_params");
            String stringExtra = intent.getStringExtra("bg_info");
            if (!TextUtils.isEmpty(stringExtra)) {
                AlaLiveGiftUIInfo alaLiveGiftUIInfo = new AlaLiveGiftUIInfo();
                alaLiveGiftUIInfo.parserJson(stringExtra);
                this.bhW.beR = alaLiveGiftUIInfo;
            }
            String stringExtra2 = intent.getStringExtra(com.baidu.live.tbadk.core.frameworkdata.IntentConfig.OTHER_PARAMS);
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.bhW.mOtherParams = stringExtra2;
        }
    }

    private void registerListener() {
        HS();
        HT();
        HU();
        HV();
    }

    private void HS() {
        this.bhY = new CustomMessageListener(2913097) { // from class: com.baidu.live.gift.panel.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.bhX != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    b.this.bhX.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bhY);
    }

    private void HT() {
        this.bhZ = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.gift.panel.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.HX();
            }
        };
        MessageManager.getInstance().registerListener(this.bhZ);
    }

    private void HU() {
        this.bia = new CustomMessageListener(2913024) { // from class: com.baidu.live.gift.panel.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.bhX != null) {
                    b.this.bhX.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bia);
    }

    private void HV() {
        this.bib = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.live.gift.panel.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.HX();
            }
        };
        MessageManager.getInstance().registerListener(this.bib);
    }

    private void HW() {
        int i;
        f.a aVar = new f.a() { // from class: com.baidu.live.gift.panel.b.6
            @Override // com.baidu.live.gift.panel.f.a
            public k Gd() {
                if (b.this.bhX != null) {
                    return b.this.bhX.Gd();
                }
                return null;
            }
        };
        c dp = c.dp(0);
        dp.setPageContext(this.mContext);
        dp.a(aVar);
        dp.b(this.bgi);
        dp.a(this.bhW);
        c dp2 = c.dp(1);
        dp2.setPageContext(this.mContext);
        dp2.a(aVar);
        dp2.b(this.bgi);
        dp2.a(this.bhW);
        switch (this.bck) {
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
        if (this.bhX != null) {
            this.bhX.a(i, dp, dp2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HX() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
            httpMessage.addParam("tbs", TbadkCoreApplication.getCurrentTbs());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void HY() {
        CustomResponsedMessage runTask;
        if (HQ()) {
            if (this.bic == null && (runTask = MessageManager.getInstance().runTask(2913198, com.baidu.live.noble.b.a.class, this.mContext.getPageActivity())) != null && runTask.getData() != null) {
                this.bic = (com.baidu.live.noble.b.a) runTask.getData();
            }
            if (this.bic != null) {
                this.bic.a(new a.InterfaceC0195a() { // from class: com.baidu.live.gift.panel.b.7
                    @Override // com.baidu.live.noble.b.a.InterfaceC0195a
                    public void a(NobleUserInfo nobleUserInfo) {
                        b.this.bie = nobleUserInfo;
                        if (b.this.bhX != null) {
                            b.this.bhX.a(nobleUserInfo != null ? nobleUserInfo.tip : null);
                        }
                    }
                });
                this.bic.OQ();
            }
        }
    }
}
