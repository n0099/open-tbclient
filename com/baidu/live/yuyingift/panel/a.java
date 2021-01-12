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
/* loaded from: classes10.dex */
public class a {
    private int aXD;
    private com.baidu.live.yuyingift.a.d bWc;
    private AlaGiftTabView.a bWd;
    private InterfaceC0237a bWe;
    private com.baidu.live.personmanager.b bWf;
    private com.baidu.live.personmanager.a bWg;
    private com.baidu.live.noble.b.b bWh;
    private CustomMessageListener bWi = new CustomMessageListener(2501074) { // from class: com.baidu.live.yuyingift.panel.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() == 2501074) {
                List<AlaWheatInfoData> Wx = com.baidu.live.aq.a.Wu().Wx();
                List<AlaWheatInfoData> Ww = com.baidu.live.aq.a.Wu().Ww();
                if (a.this.bWe != null) {
                    a.this.bWe.a(Wx, Ww, a.this.bWc.bVe);
                }
            }
        }
    };
    private CustomMessageListener bdo;
    private CustomMessageListener bdp;
    private CustomMessageListener bdq;
    private CustomMessageListener bdr;
    private NobleUserInfo bdt;
    private TbPageContext mContext;
    private Handler mHandler;

    /* renamed from: com.baidu.live.yuyingift.panel.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0237a {
        k EK();

        GiftPanelSelectMicrophoneSendView.d WM();

        void WN();

        void WV();

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

    public void a(InterfaceC0237a interfaceC0237a, AlaGiftTabView.a aVar) {
        this.bWe = interfaceC0237a;
        this.bWd = aVar;
        registerListener();
        this.mHandler = new Handler();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.panel.a.1
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913087));
            }
        }, 300L);
        GD();
        if (this.bWe != null && this.bWc != null && this.bWc.bai != null) {
            this.bWe.a(this.bWc.bai);
        }
        Xj();
        GE();
        GF();
        Xk();
    }

    private void Xj() {
        this.bWf = new com.baidu.live.personmanager.b(this.mContext);
        this.bWg = new com.baidu.live.personmanager.a(this.mContext.getPageActivity());
    }

    public void d(final AlaWheatInfoData alaWheatInfoData) {
        x WA = com.baidu.live.aq.a.Wu().WA();
        if (alaWheatInfoData != null && WA != null) {
            this.bWf.a(new b.a() { // from class: com.baidu.live.yuyingift.panel.a.3
                @Override // com.baidu.live.personmanager.b.a
                public void b(PersonUserData personUserData) {
                    if (personUserData != null && a.this.bWe != null) {
                        a.this.bWe.a(personUserData, alaWheatInfoData);
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
            p(alaWheatInfoData.uk, String.valueOf(WA.mLiveInfo.live_id), String.valueOf(WA.mLiveInfo.group_id), alaWheatInfoData.userName);
        }
    }

    private void Xk() {
        if (this.bWe != null) {
            this.bWe.a(com.baidu.live.aq.a.Wu().Wx(), com.baidu.live.aq.a.Wu().Ww(), this.bWc.bVe);
        }
    }

    public boolean Gx() {
        return this.bWc != null && this.bWc.baj;
    }

    public void Gy() {
        if (this.bdt != null && !TextUtils.isEmpty(this.bdt.detailUrl)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            nobleDetailInfo.url = this.bdt.detailUrl;
            if (this.bdt.user != null) {
                nobleDetailInfo.roleId = this.bdt.user.id;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501031, nobleDetailInfo));
            if (this.bWe != null) {
                this.bWe.onClose();
            }
        }
    }

    public void gr(String str) {
        UrlManager.getInstance().dealOneLink(this.mContext, new String[]{str});
    }

    public void release() {
        this.bWe = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bWh != null) {
            this.bWh.release();
        }
        if (this.bWf != null) {
            this.bWf.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.bdo);
        MessageManager.getInstance().unRegisterListener(this.bdp);
        MessageManager.getInstance().unRegisterListener(this.bdq);
        MessageManager.getInstance().unRegisterListener(this.bdr);
        MessageManager.getInstance().unRegisterListener(this.bWi);
    }

    private void k(Intent intent) {
        this.bWc = new com.baidu.live.yuyingift.a.d();
        if (intent != null) {
            this.aXD = intent.getIntExtra("custom_tab_id", 1);
            this.bWc.mUserName = intent.getStringExtra("user_name");
            this.bWc.mUserId = intent.getStringExtra("user_id");
            this.bWc.mLiveId = intent.getStringExtra("live_Id");
            this.bWc.mRoomId = intent.getStringExtra("room_id");
            this.bWc.bac = intent.getStringExtra("feed_id");
            this.bWc.bad = intent.getIntExtra("is_block", 0);
            this.bWc.bae = intent.getStringExtra("scene");
            this.bWc.mAppId = intent.getStringExtra("app_id");
            this.bWc.baf = intent.getBooleanExtra("can_graffiti", true);
            this.bWc.aYD = intent.getIntExtra("custom_category_id", -1);
            this.bWc.aYE = intent.getIntExtra("custom_gift_id", -1);
            this.bWc.aWz = intent.getBooleanExtra("new_gift_t_dou_strategy", false);
            this.bWc.aWx = intent.getIntExtra(IntentConfig.USER_LEVEL, -1);
            this.bWc.aXV = intent.getBooleanExtra("isJoinGuardClub", false);
            this.bWc.isNewUser = intent.getBooleanExtra("is_new_user", false);
            this.bWc.aYF = intent.getIntExtra("guard_club_join_amount", 1000);
            this.bWc.aYR = intent.getBooleanExtra("is_redpkg_unable", false);
            this.bWc.bah = intent.getIntExtra("page_from", -1);
            this.bWc.aWF = intent.getBooleanExtra("throne_enabled", false);
            this.bWc.baj = intent.getBooleanExtra("noble_enabled", false);
            if (intent.getStringArrayExtra(ac.aBp) != null) {
                this.bWc.bVe = intent.getStringArrayExtra(ac.aBp);
            }
            String stringExtra = intent.getStringExtra("bg_info");
            if (!TextUtils.isEmpty(stringExtra)) {
                AlaLiveGiftUIInfo alaLiveGiftUIInfo = new AlaLiveGiftUIInfo();
                alaLiveGiftUIInfo.parserJson(stringExtra);
                this.bWc.bai = alaLiveGiftUIInfo;
            }
            String stringExtra2 = intent.getStringExtra(com.baidu.live.tbadk.core.frameworkdata.IntentConfig.OTHER_PARAMS);
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.bWc.mOtherParams = stringExtra2;
        }
    }

    private void registerListener() {
        Gz();
        GA();
        GB();
        GC();
    }

    public void p(String str, String str2, String str3, String str4) {
        if (this.bWf != null) {
            this.bWf.c(null, str, str2, str3, "", str4);
        }
    }

    private void Gz() {
        this.bdo = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyingift.panel.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bWe != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.this.bWe.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bdo);
    }

    public void Xl() {
        MessageManager.getInstance().registerListener(this.bWi);
    }

    public void a(AlaWheatInfoData alaWheatInfoData, boolean z) {
        if (alaWheatInfoData != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mContext.getPageActivity());
            } else if (TextUtils.equals(alaWheatInfoData.uk, ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()))) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), a.h.ala_cannot_follow_myself);
            } else {
                this.bWg.t(alaWheatInfoData.uk, com.baidu.live.aq.a.Wu().getCustomRoomId(), com.baidu.live.aq.a.Wu().WB());
                this.bWg.a(new a.InterfaceC0192a() { // from class: com.baidu.live.yuyingift.panel.a.6
                    @Override // com.baidu.live.personmanager.a.InterfaceC0192a
                    public void ND() {
                        if (a.this.mContext != null) {
                            a.this.mContext.showToast(a.this.mContext.getString(a.h.sdk_attention_success_toast));
                        }
                        if (a.this.bWe != null) {
                            a.this.bWe.WV();
                            a.this.bWe.WN();
                        }
                    }

                    @Override // com.baidu.live.personmanager.a.InterfaceC0192a
                    public void w(int i, String str) {
                        if (a.this.mContext != null) {
                            a.this.mContext.showToast(str);
                        }
                    }
                });
            }
        }
    }

    public void a(PersonUserData personUserData, AlaWheatInfoData alaWheatInfoData, Intent intent) {
        x WA = com.baidu.live.aq.a.Wu().WA();
        if (WA != null && WA.mLiveInfo != null) {
            YuyinAlaPersonCardActivityConfig yuyinAlaPersonCardActivityConfig = new YuyinAlaPersonCardActivityConfig(this.mContext.getPageActivity(), "", alaWheatInfoData.uk, alaWheatInfoData.userName, alaWheatInfoData.portrait, alaWheatInfoData.sex, 0, null, null, personUserData.user_info.send_count, personUserData.user_info.fans_count, personUserData.user_info.follow_count, personUserData.relation_info.follow_status, String.valueOf(WA.mLiveInfo.group_id), String.valueOf(WA.mLiveInfo.live_id), false, null, null, alaWheatInfoData.userName, null, "");
            yuyinAlaPersonCardActivityConfig.cacheReEnterGiftPanel(intent);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, yuyinAlaPersonCardActivityConfig));
        }
    }

    private void GA() {
        this.bdp = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.yuyingift.panel.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.GE();
            }
        };
        MessageManager.getInstance().registerListener(this.bdp);
    }

    private void GB() {
        this.bdq = new CustomMessageListener(2913024) { // from class: com.baidu.live.yuyingift.panel.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bWe != null) {
                    a.this.bWe.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bdq);
    }

    private void GC() {
        this.bdr = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.live.yuyingift.panel.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.GE();
            }
        };
        MessageManager.getInstance().registerListener(this.bdr);
    }

    private void GD() {
        int i;
        e.a aVar = new e.a() { // from class: com.baidu.live.yuyingift.panel.a.10
            @Override // com.baidu.live.yuyingift.panel.e.a
            public k EK() {
                if (a.this.bWe != null) {
                    return a.this.bWe.EK();
                }
                return null;
            }
        };
        b a2 = b.a(this.bWe, 0);
        a2.setPageContext(this.mContext);
        a2.a(aVar);
        a2.b(this.bWd);
        a2.a(this.bWc);
        b a3 = b.a(this.bWe, 1);
        a3.setPageContext(this.mContext);
        a3.a(aVar);
        a3.b(this.bWd);
        a3.a(this.bWc);
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
        if (this.bWe != null) {
            this.bWe.a(i, a2, a3);
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
            if (this.bWh == null && (runTask = MessageManager.getInstance().runTask(2501035, com.baidu.live.noble.b.b.class, this.mContext.getPageActivity())) != null && runTask.getData() != null) {
                this.bWh = (com.baidu.live.noble.b.b) runTask.getData();
            }
            if (this.bWh != null) {
                this.bWh.a(new b.a() { // from class: com.baidu.live.yuyingift.panel.a.2
                    @Override // com.baidu.live.noble.b.b.a
                    public void a(NobleUserInfo nobleUserInfo) {
                        a.this.bdt = nobleUserInfo;
                        if (a.this.bWe != null) {
                            a.this.bWe.a(nobleUserInfo != null ? nobleUserInfo.tip : null);
                        }
                    }
                });
                this.bWh.aB(com.baidu.live.aq.a.Wu().getCustomRoomId(), com.baidu.live.aq.a.Wu().Wy());
            }
        }
    }
}
