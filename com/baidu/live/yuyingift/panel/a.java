package com.baidu.live.yuyingift.panel;

import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.d.ac;
import com.baidu.live.data.AlaLiveGiftUIInfo;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.ab;
import com.baidu.live.data.ca;
import com.baidu.live.gift.k;
import com.baidu.live.noble.b.b;
import com.baidu.live.noble.data.NobleDetailInfo;
import com.baidu.live.noble.data.NobleUserInfo;
import com.baidu.live.personmanager.a;
import com.baidu.live.personmanager.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.fragment.SupportXFragment;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.yuyingift.container.AlaGiftTabView;
import com.baidu.live.yuyingift.panel.e;
import com.baidu.live.yuyingift.widget.wheatlist.GiftPanelSelectMicrophoneSendView;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private int baK;
    private CustomMessageListener bgA;
    private CustomMessageListener bgB;
    private NobleUserInfo bgD;
    private CustomMessageListener bgy;
    private CustomMessageListener bgz;
    private com.baidu.live.yuyingift.a.d cae;
    private AlaGiftTabView.a caf;
    private InterfaceC0238a cag;
    private com.baidu.live.personmanager.b cah;
    private com.baidu.live.personmanager.a cai;
    private com.baidu.live.noble.b.b caj;
    private CustomMessageListener cak = new CustomMessageListener(2501074) { // from class: com.baidu.live.yuyingift.panel.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() == 2501074) {
                List<AlaWheatInfoData> Yn = com.baidu.live.ao.a.Yj().Yn();
                List<AlaWheatInfoData> Ym = com.baidu.live.ao.a.Yj().Ym();
                if (a.this.cag != null) {
                    a.this.cag.a(Yn, Ym, a.this.cae.bZg);
                }
            }
        }
    };
    private TbPageContext mContext;
    private Handler mHandler;

    /* renamed from: com.baidu.live.yuyingift.panel.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0238a {
        k Ga();

        GiftPanelSelectMicrophoneSendView.d YC();

        void YD();

        void YL();

        void a(int i, SupportXFragment... supportXFragmentArr);

        void a(AlaLiveGiftUIInfo alaLiveGiftUIInfo);

        void a(PersonUserData personUserData, AlaWheatInfoData alaWheatInfoData);

        void a(NobleUserInfo.a aVar);

        void a(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, String[] strArr);

        void onClose();
    }

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void init(Intent intent) {
        k(intent);
    }

    public void a(InterfaceC0238a interfaceC0238a, AlaGiftTabView.a aVar) {
        this.cag = interfaceC0238a;
        this.caf = aVar;
        registerListener();
        this.mHandler = new Handler();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.panel.a.1
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913087));
            }
        }, 300L);
        HT();
        if (this.cag != null && this.cae != null && this.cae.bdp != null) {
            this.cag.a(this.cae.bdp);
        }
        YZ();
        HU();
        HV();
        Za();
    }

    private void YZ() {
        this.cah = new com.baidu.live.personmanager.b(this.mContext);
        this.cai = new com.baidu.live.personmanager.a(this.mContext.getPageActivity());
    }

    public void d(final AlaWheatInfoData alaWheatInfoData) {
        ab Yq = com.baidu.live.ao.a.Yj().Yq();
        if (alaWheatInfoData != null && Yq != null) {
            this.cah.a(new b.a() { // from class: com.baidu.live.yuyingift.panel.a.3
                @Override // com.baidu.live.personmanager.b.a
                public void b(PersonUserData personUserData) {
                    if (personUserData != null && a.this.cag != null) {
                        a.this.cag.a(personUserData, alaWheatInfoData);
                    }
                }

                @Override // com.baidu.live.personmanager.b.a
                public void b(ca caVar) {
                }

                @Override // com.baidu.live.personmanager.b.a
                public void c(ca caVar) {
                }

                @Override // com.baidu.live.personmanager.b.a
                public void onFail(String str) {
                    if (a.this.mContext != null) {
                        a.this.mContext.showToast(str);
                    }
                }
            });
            p(alaWheatInfoData.uk, String.valueOf(Yq.mLiveInfo.live_id), String.valueOf(Yq.mLiveInfo.group_id), alaWheatInfoData.userName);
        }
    }

    private void Za() {
        if (this.cag != null) {
            this.cag.a(com.baidu.live.ao.a.Yj().Yn(), com.baidu.live.ao.a.Yj().Ym(), this.cae.bZg);
        }
    }

    public boolean HN() {
        return this.cae != null && this.cae.bdq;
    }

    public void HO() {
        if (this.bgD != null && !TextUtils.isEmpty(this.bgD.detailUrl)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            nobleDetailInfo.url = this.bgD.detailUrl;
            if (this.bgD.user != null) {
                nobleDetailInfo.roleId = this.bgD.user.id;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501031, nobleDetailInfo));
            if (this.cag != null) {
                this.cag.onClose();
            }
        }
    }

    public void gP(String str) {
        UrlManager.getInstance().dealOneLink(this.mContext, new String[]{str});
    }

    public void release() {
        this.cag = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.caj != null) {
            this.caj.release();
        }
        if (this.cah != null) {
            this.cah.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.bgy);
        MessageManager.getInstance().unRegisterListener(this.bgz);
        MessageManager.getInstance().unRegisterListener(this.bgA);
        MessageManager.getInstance().unRegisterListener(this.bgB);
        MessageManager.getInstance().unRegisterListener(this.cak);
    }

    private void k(Intent intent) {
        this.cae = new com.baidu.live.yuyingift.a.d();
        if (intent != null) {
            this.baK = intent.getIntExtra("custom_tab_id", 1);
            this.cae.mUserName = intent.getStringExtra("user_name");
            this.cae.mUserId = intent.getStringExtra("user_id");
            this.cae.mLiveId = intent.getStringExtra("live_Id");
            this.cae.mRoomId = intent.getStringExtra("room_id");
            this.cae.bdj = intent.getStringExtra("feed_id");
            this.cae.bdk = intent.getIntExtra("is_block", 0);
            this.cae.bdl = intent.getStringExtra("scene");
            this.cae.mAppId = intent.getStringExtra("app_id");
            this.cae.bdm = intent.getBooleanExtra("can_graffiti", true);
            this.cae.bbK = intent.getIntExtra("custom_category_id", -1);
            this.cae.bbL = intent.getIntExtra("custom_gift_id", -1);
            this.cae.aZF = intent.getBooleanExtra("new_gift_t_dou_strategy", false);
            this.cae.aZD = intent.getIntExtra(IntentConfig.USER_LEVEL, -1);
            this.cae.bbc = intent.getBooleanExtra("isJoinGuardClub", false);
            this.cae.isNewUser = intent.getBooleanExtra("is_new_user", false);
            this.cae.bbM = intent.getIntExtra("guard_club_join_amount", 1000);
            this.cae.bbY = intent.getBooleanExtra("is_redpkg_unable", false);
            this.cae.bdo = intent.getIntExtra("page_from", -1);
            this.cae.aZL = intent.getBooleanExtra("throne_enabled", false);
            this.cae.bdq = intent.getBooleanExtra("noble_enabled", false);
            if (intent.getStringArrayExtra(ac.aCU) != null) {
                this.cae.bZg = intent.getStringArrayExtra(ac.aCU);
            }
            String stringExtra = intent.getStringExtra("bg_info");
            if (!TextUtils.isEmpty(stringExtra)) {
                AlaLiveGiftUIInfo alaLiveGiftUIInfo = new AlaLiveGiftUIInfo();
                alaLiveGiftUIInfo.parserJson(stringExtra);
                this.cae.bdp = alaLiveGiftUIInfo;
            }
            String stringExtra2 = intent.getStringExtra(com.baidu.live.tbadk.core.frameworkdata.IntentConfig.OTHER_PARAMS);
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.cae.mOtherParams = stringExtra2;
        }
    }

    private void registerListener() {
        HP();
        HQ();
        HR();
        HS();
    }

    public void p(String str, String str2, String str3, String str4) {
        if (this.cah != null) {
            this.cah.c(null, str, str2, str3, "", str4);
        }
    }

    private void HP() {
        this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyingift.panel.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.cag != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.this.cag.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bgy);
    }

    public void Zb() {
        MessageManager.getInstance().registerListener(this.cak);
    }

    public void a(AlaWheatInfoData alaWheatInfoData, boolean z) {
        if (alaWheatInfoData != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mContext.getPageActivity());
            } else if (TextUtils.equals(alaWheatInfoData.uk, ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()))) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), a.h.ala_cannot_follow_myself);
            } else {
                this.cai.u(alaWheatInfoData.uk, com.baidu.live.ao.a.Yj().getCustomRoomId(), com.baidu.live.ao.a.Yj().Yr());
                this.cai.a(new a.InterfaceC0193a() { // from class: com.baidu.live.yuyingift.panel.a.6
                    @Override // com.baidu.live.personmanager.a.InterfaceC0193a
                    public void Pf() {
                        if (a.this.mContext != null) {
                            a.this.mContext.showToast(a.this.mContext.getString(a.h.sdk_attention_success_toast));
                        }
                        if (a.this.cag != null) {
                            a.this.cag.YL();
                            a.this.cag.YD();
                        }
                    }

                    @Override // com.baidu.live.personmanager.a.InterfaceC0193a
                    public void A(int i, String str) {
                        if (a.this.mContext != null) {
                            a.this.mContext.showToast(str);
                        }
                    }
                });
            }
        }
    }

    public void a(PersonUserData personUserData, AlaWheatInfoData alaWheatInfoData, Intent intent) {
        ab Yq = com.baidu.live.ao.a.Yj().Yq();
        if (Yq != null && Yq.mLiveInfo != null) {
            YuyinAlaPersonCardActivityConfig yuyinAlaPersonCardActivityConfig = new YuyinAlaPersonCardActivityConfig(this.mContext.getPageActivity(), "", alaWheatInfoData.uk, alaWheatInfoData.userName, alaWheatInfoData.portrait, alaWheatInfoData.sex, 0, null, null, personUserData.user_info.send_count, personUserData.user_info.fans_count, personUserData.user_info.follow_count, personUserData.relation_info.follow_status, String.valueOf(Yq.mLiveInfo.group_id), String.valueOf(Yq.mLiveInfo.live_id), false, null, null, alaWheatInfoData.userName, null, "");
            yuyinAlaPersonCardActivityConfig.cacheReEnterGiftPanel(intent);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, yuyinAlaPersonCardActivityConfig));
        }
    }

    private void HQ() {
        this.bgz = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.yuyingift.panel.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.HU();
            }
        };
        MessageManager.getInstance().registerListener(this.bgz);
    }

    private void HR() {
        this.bgA = new CustomMessageListener(2913024) { // from class: com.baidu.live.yuyingift.panel.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.cag != null) {
                    a.this.cag.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bgA);
    }

    private void HS() {
        this.bgB = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.live.yuyingift.panel.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.HU();
            }
        };
        MessageManager.getInstance().registerListener(this.bgB);
    }

    private void HT() {
        int i;
        e.a aVar = new e.a() { // from class: com.baidu.live.yuyingift.panel.a.10
            @Override // com.baidu.live.yuyingift.panel.e.a
            public k Ga() {
                if (a.this.cag != null) {
                    return a.this.cag.Ga();
                }
                return null;
            }
        };
        b a2 = b.a(this.cag, 0);
        a2.setPageContext(this.mContext);
        a2.a(aVar);
        a2.b(this.caf);
        a2.a(this.cae);
        b a3 = b.a(this.cag, 1);
        a3.setPageContext(this.mContext);
        a3.a(aVar);
        a3.b(this.caf);
        a3.a(this.cae);
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
        if (this.cag != null) {
            this.cag.a(i, a2, a3);
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
            if (this.caj == null && (runTask = MessageManager.getInstance().runTask(2501035, com.baidu.live.noble.b.b.class, this.mContext.getPageActivity())) != null && runTask.getData() != null) {
                this.caj = (com.baidu.live.noble.b.b) runTask.getData();
            }
            if (this.caj != null) {
                this.caj.a(new b.a() { // from class: com.baidu.live.yuyingift.panel.a.2
                    @Override // com.baidu.live.noble.b.b.a
                    public void a(NobleUserInfo nobleUserInfo) {
                        a.this.bgD = nobleUserInfo;
                        if (a.this.cag != null) {
                            a.this.cag.a(nobleUserInfo != null ? nobleUserInfo.tip : null);
                        }
                    }
                });
                this.caj.aB(com.baidu.live.ao.a.Yj().getCustomRoomId(), com.baidu.live.ao.a.Yj().Yo());
            }
        }
    }
}
