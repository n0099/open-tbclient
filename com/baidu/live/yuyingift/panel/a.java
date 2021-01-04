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
import com.baidu.live.data.bv;
import com.baidu.live.data.x;
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
    private int bcr;
    private CustomMessageListener bih;
    private CustomMessageListener bii;
    private CustomMessageListener bij;
    private CustomMessageListener bik;
    private NobleUserInfo bim;
    private com.baidu.live.yuyingift.a.d caO;
    private AlaGiftTabView.a caP;
    private InterfaceC0246a caQ;
    private com.baidu.live.personmanager.b caR;
    private com.baidu.live.personmanager.a caS;
    private com.baidu.live.noble.b.b caT;
    private CustomMessageListener caU = new CustomMessageListener(2501074) { // from class: com.baidu.live.yuyingift.panel.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() == 2501074) {
                List<AlaWheatInfoData> aap = com.baidu.live.aq.a.aam().aap();
                List<AlaWheatInfoData> aao = com.baidu.live.aq.a.aam().aao();
                if (a.this.caQ != null) {
                    a.this.caQ.a(aap, aao, a.this.caO.bZQ);
                }
            }
        }
    };
    private TbPageContext mContext;
    private Handler mHandler;

    /* renamed from: com.baidu.live.yuyingift.panel.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0246a {
        k IF();

        void a(int i, SupportXFragment... supportXFragmentArr);

        void a(AlaLiveGiftUIInfo alaLiveGiftUIInfo);

        void a(PersonUserData personUserData, AlaWheatInfoData alaWheatInfoData);

        void a(NobleUserInfo.a aVar);

        void a(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, String[] strArr);

        GiftPanelSelectMicrophoneSendView.d aaE();

        void aaF();

        void aaN();

        void onClose();
    }

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void init(Intent intent) {
        k(intent);
    }

    public void a(InterfaceC0246a interfaceC0246a, AlaGiftTabView.a aVar) {
        this.caQ = interfaceC0246a;
        this.caP = aVar;
        registerListener();
        this.mHandler = new Handler();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.panel.a.1
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913087));
            }
        }, 300L);
        Ky();
        if (this.caQ != null && this.caO != null && this.caO.beY != null) {
            this.caQ.a(this.caO.beY);
        }
        abb();
        Kz();
        KA();
        abc();
    }

    private void abb() {
        this.caR = new com.baidu.live.personmanager.b(this.mContext);
        this.caS = new com.baidu.live.personmanager.a(this.mContext.getPageActivity());
    }

    public void d(final AlaWheatInfoData alaWheatInfoData) {
        x aas = com.baidu.live.aq.a.aam().aas();
        if (alaWheatInfoData != null && aas != null) {
            this.caR.a(new b.a() { // from class: com.baidu.live.yuyingift.panel.a.3
                @Override // com.baidu.live.personmanager.b.a
                public void b(PersonUserData personUserData) {
                    if (personUserData != null && a.this.caQ != null) {
                        a.this.caQ.a(personUserData, alaWheatInfoData);
                    }
                }

                @Override // com.baidu.live.personmanager.b.a
                public void b(bv bvVar) {
                }

                @Override // com.baidu.live.personmanager.b.a
                public void c(bv bvVar) {
                }

                @Override // com.baidu.live.personmanager.b.a
                public void onFail(String str) {
                    if (a.this.mContext != null) {
                        a.this.mContext.showToast(str);
                    }
                }
            });
            p(alaWheatInfoData.uk, String.valueOf(aas.mLiveInfo.live_id), String.valueOf(aas.mLiveInfo.group_id), alaWheatInfoData.userName);
        }
    }

    private void abc() {
        if (this.caQ != null) {
            this.caQ.a(com.baidu.live.aq.a.aam().aap(), com.baidu.live.aq.a.aam().aao(), this.caO.bZQ);
        }
    }

    public boolean Ks() {
        return this.caO != null && this.caO.beZ;
    }

    public void Kt() {
        if (this.bim != null && !TextUtils.isEmpty(this.bim.detailUrl)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            nobleDetailInfo.url = this.bim.detailUrl;
            if (this.bim.user != null) {
                nobleDetailInfo.roleId = this.bim.user.id;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501031, nobleDetailInfo));
            if (this.caQ != null) {
                this.caQ.onClose();
            }
        }
    }

    public void hD(String str) {
        UrlManager.getInstance().dealOneLink(this.mContext, new String[]{str});
    }

    public void release() {
        this.caQ = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.caT != null) {
            this.caT.release();
        }
        if (this.caR != null) {
            this.caR.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.bih);
        MessageManager.getInstance().unRegisterListener(this.bii);
        MessageManager.getInstance().unRegisterListener(this.bij);
        MessageManager.getInstance().unRegisterListener(this.bik);
        MessageManager.getInstance().unRegisterListener(this.caU);
    }

    private void k(Intent intent) {
        this.caO = new com.baidu.live.yuyingift.a.d();
        if (intent != null) {
            this.bcr = intent.getIntExtra("custom_tab_id", 1);
            this.caO.mUserName = intent.getStringExtra("user_name");
            this.caO.mUserId = intent.getStringExtra("user_id");
            this.caO.mLiveId = intent.getStringExtra("live_Id");
            this.caO.mRoomId = intent.getStringExtra("room_id");
            this.caO.beS = intent.getStringExtra("feed_id");
            this.caO.beT = intent.getIntExtra("is_block", 0);
            this.caO.beU = intent.getStringExtra("scene");
            this.caO.mAppId = intent.getStringExtra("app_id");
            this.caO.beV = intent.getBooleanExtra("can_graffiti", true);
            this.caO.bdr = intent.getIntExtra("custom_category_id", -1);
            this.caO.bds = intent.getIntExtra("custom_gift_id", -1);
            this.caO.bbn = intent.getBooleanExtra("new_gift_t_dou_strategy", false);
            this.caO.bbl = intent.getIntExtra(IntentConfig.USER_LEVEL, -1);
            this.caO.bcJ = intent.getBooleanExtra("isJoinGuardClub", false);
            this.caO.isNewUser = intent.getBooleanExtra("is_new_user", false);
            this.caO.bdt = intent.getIntExtra("guard_club_join_amount", 1000);
            this.caO.bdF = intent.getBooleanExtra("is_redpkg_unable", false);
            this.caO.beX = intent.getIntExtra("page_from", -1);
            this.caO.bbt = intent.getBooleanExtra("throne_enabled", false);
            this.caO.beZ = intent.getBooleanExtra("noble_enabled", false);
            if (intent.getStringArrayExtra(ac.aGc) != null) {
                this.caO.bZQ = intent.getStringArrayExtra(ac.aGc);
            }
            String stringExtra = intent.getStringExtra("bg_info");
            if (!TextUtils.isEmpty(stringExtra)) {
                AlaLiveGiftUIInfo alaLiveGiftUIInfo = new AlaLiveGiftUIInfo();
                alaLiveGiftUIInfo.parserJson(stringExtra);
                this.caO.beY = alaLiveGiftUIInfo;
            }
            String stringExtra2 = intent.getStringExtra(com.baidu.live.tbadk.core.frameworkdata.IntentConfig.OTHER_PARAMS);
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.caO.mOtherParams = stringExtra2;
        }
    }

    private void registerListener() {
        Ku();
        Kv();
        Kw();
        Kx();
    }

    public void p(String str, String str2, String str3, String str4) {
        if (this.caR != null) {
            this.caR.c(null, str, str2, str3, "", str4);
        }
    }

    private void Ku() {
        this.bih = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyingift.panel.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.caQ != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.this.caQ.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bih);
    }

    public void abd() {
        MessageManager.getInstance().registerListener(this.caU);
    }

    public void a(AlaWheatInfoData alaWheatInfoData, boolean z) {
        if (alaWheatInfoData != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mContext.getPageActivity());
            } else if (TextUtils.equals(alaWheatInfoData.uk, ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()))) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), a.h.ala_cannot_follow_myself);
            } else {
                this.caS.u(alaWheatInfoData.uk, com.baidu.live.aq.a.aam().getCustomRoomId(), com.baidu.live.aq.a.aam().aat());
                this.caS.a(new a.InterfaceC0201a() { // from class: com.baidu.live.yuyingift.panel.a.6
                    @Override // com.baidu.live.personmanager.a.InterfaceC0201a
                    public void Ry() {
                        if (a.this.mContext != null) {
                            a.this.mContext.showToast(a.this.mContext.getString(a.h.sdk_attention_success_toast));
                        }
                        if (a.this.caQ != null) {
                            a.this.caQ.aaN();
                            a.this.caQ.aaF();
                        }
                    }

                    @Override // com.baidu.live.personmanager.a.InterfaceC0201a
                    public void v(int i, String str) {
                        if (a.this.mContext != null) {
                            a.this.mContext.showToast(str);
                        }
                    }
                });
            }
        }
    }

    public void a(PersonUserData personUserData, AlaWheatInfoData alaWheatInfoData, Intent intent) {
        x aas = com.baidu.live.aq.a.aam().aas();
        if (aas != null && aas.mLiveInfo != null) {
            YuyinAlaPersonCardActivityConfig yuyinAlaPersonCardActivityConfig = new YuyinAlaPersonCardActivityConfig(this.mContext.getPageActivity(), "", alaWheatInfoData.uk, alaWheatInfoData.userName, alaWheatInfoData.portrait, alaWheatInfoData.sex, 0, null, null, personUserData.user_info.send_count, personUserData.user_info.fans_count, personUserData.user_info.follow_count, personUserData.relation_info.follow_status, String.valueOf(aas.mLiveInfo.group_id), String.valueOf(aas.mLiveInfo.live_id), false, null, null, alaWheatInfoData.userName, null, "");
            yuyinAlaPersonCardActivityConfig.cacheReEnterGiftPanel(intent);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, yuyinAlaPersonCardActivityConfig));
        }
    }

    private void Kv() {
        this.bii = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.yuyingift.panel.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.Kz();
            }
        };
        MessageManager.getInstance().registerListener(this.bii);
    }

    private void Kw() {
        this.bij = new CustomMessageListener(2913024) { // from class: com.baidu.live.yuyingift.panel.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.caQ != null) {
                    a.this.caQ.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bij);
    }

    private void Kx() {
        this.bik = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.live.yuyingift.panel.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.Kz();
            }
        };
        MessageManager.getInstance().registerListener(this.bik);
    }

    private void Ky() {
        int i;
        e.a aVar = new e.a() { // from class: com.baidu.live.yuyingift.panel.a.10
            @Override // com.baidu.live.yuyingift.panel.e.a
            public k IF() {
                if (a.this.caQ != null) {
                    return a.this.caQ.IF();
                }
                return null;
            }
        };
        b a2 = b.a(this.caQ, 0);
        a2.setPageContext(this.mContext);
        a2.a(aVar);
        a2.b(this.caP);
        a2.a(this.caO);
        b a3 = b.a(this.caQ, 1);
        a3.setPageContext(this.mContext);
        a3.a(aVar);
        a3.b(this.caP);
        a3.a(this.caO);
        switch (this.bcr) {
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
        if (this.caQ != null) {
            this.caQ.a(i, a2, a3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kz() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
            httpMessage.addParam("tbs", TbadkCoreApplication.getCurrentTbs());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void KA() {
        CustomResponsedMessage runTask;
        if (Ks()) {
            if (this.caT == null && (runTask = MessageManager.getInstance().runTask(2501035, com.baidu.live.noble.b.b.class, this.mContext.getPageActivity())) != null && runTask.getData() != null) {
                this.caT = (com.baidu.live.noble.b.b) runTask.getData();
            }
            if (this.caT != null) {
                this.caT.a(new b.a() { // from class: com.baidu.live.yuyingift.panel.a.2
                    @Override // com.baidu.live.noble.b.b.a
                    public void a(NobleUserInfo nobleUserInfo) {
                        a.this.bim = nobleUserInfo;
                        if (a.this.caQ != null) {
                            a.this.caQ.a(nobleUserInfo != null ? nobleUserInfo.tip : null);
                        }
                    }
                });
                this.caT.aC(com.baidu.live.aq.a.aam().getCustomRoomId(), com.baidu.live.aq.a.aam().aaq());
            }
        }
    }
}
