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
/* loaded from: classes10.dex */
public class a {
    private int bck;
    private CustomMessageListener bhY;
    private CustomMessageListener bhZ;
    private CustomMessageListener bia;
    private CustomMessageListener bib;
    private NobleUserInfo bie;
    private com.baidu.live.yuyingift.a.d cbF;
    private AlaGiftTabView.a cbG;
    private InterfaceC0244a cbH;
    private com.baidu.live.personmanager.b cbI;
    private com.baidu.live.personmanager.a cbJ;
    private com.baidu.live.noble.b.b cbK;
    private CustomMessageListener cbL = new CustomMessageListener(2501074) { // from class: com.baidu.live.yuyingift.panel.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() == 2501074) {
                List<AlaWheatInfoData> Yq = com.baidu.live.ao.a.Ym().Yq();
                List<AlaWheatInfoData> Yp = com.baidu.live.ao.a.Ym().Yp();
                if (a.this.cbH != null) {
                    a.this.cbH.a(Yq, Yp, a.this.cbF.caG);
                }
            }
        }
    };
    private TbPageContext mContext;
    private Handler mHandler;

    /* renamed from: com.baidu.live.yuyingift.panel.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0244a {
        k Gd();

        GiftPanelSelectMicrophoneSendView.d YF();

        void YG();

        void YO();

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

    public void a(InterfaceC0244a interfaceC0244a, AlaGiftTabView.a aVar) {
        this.cbH = interfaceC0244a;
        this.cbG = aVar;
        registerListener();
        this.mHandler = new Handler();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.panel.a.1
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913087));
            }
        }, 300L);
        HW();
        if (this.cbH != null && this.cbF != null && this.cbF.beR != null) {
            this.cbH.a(this.cbF.beR);
        }
        Zc();
        HX();
        HY();
        Zd();
    }

    private void Zc() {
        this.cbI = new com.baidu.live.personmanager.b(this.mContext);
        this.cbJ = new com.baidu.live.personmanager.a(this.mContext.getPageActivity());
    }

    public void d(final AlaWheatInfoData alaWheatInfoData) {
        ab Yt = com.baidu.live.ao.a.Ym().Yt();
        if (alaWheatInfoData != null && Yt != null) {
            this.cbI.a(new b.a() { // from class: com.baidu.live.yuyingift.panel.a.3
                @Override // com.baidu.live.personmanager.b.a
                public void b(PersonUserData personUserData) {
                    if (personUserData != null && a.this.cbH != null) {
                        a.this.cbH.a(personUserData, alaWheatInfoData);
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
            p(alaWheatInfoData.uk, String.valueOf(Yt.mLiveInfo.live_id), String.valueOf(Yt.mLiveInfo.group_id), alaWheatInfoData.userName);
        }
    }

    private void Zd() {
        if (this.cbH != null) {
            this.cbH.a(com.baidu.live.ao.a.Ym().Yq(), com.baidu.live.ao.a.Ym().Yp(), this.cbF.caG);
        }
    }

    public boolean HQ() {
        return this.cbF != null && this.cbF.beS;
    }

    public void HR() {
        if (this.bie != null && !TextUtils.isEmpty(this.bie.detailUrl)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            nobleDetailInfo.url = this.bie.detailUrl;
            if (this.bie.user != null) {
                nobleDetailInfo.roleId = this.bie.user.id;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501031, nobleDetailInfo));
            if (this.cbH != null) {
                this.cbH.onClose();
            }
        }
    }

    public void gV(String str) {
        UrlManager.getInstance().dealOneLink(this.mContext, new String[]{str});
    }

    public void release() {
        this.cbH = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.cbK != null) {
            this.cbK.release();
        }
        if (this.cbI != null) {
            this.cbI.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.bhY);
        MessageManager.getInstance().unRegisterListener(this.bhZ);
        MessageManager.getInstance().unRegisterListener(this.bia);
        MessageManager.getInstance().unRegisterListener(this.bib);
        MessageManager.getInstance().unRegisterListener(this.cbL);
    }

    private void k(Intent intent) {
        this.cbF = new com.baidu.live.yuyingift.a.d();
        if (intent != null) {
            this.bck = intent.getIntExtra("custom_tab_id", 1);
            this.cbF.mUserName = intent.getStringExtra("user_name");
            this.cbF.mUserId = intent.getStringExtra("user_id");
            this.cbF.mLiveId = intent.getStringExtra("live_Id");
            this.cbF.mRoomId = intent.getStringExtra("room_id");
            this.cbF.beL = intent.getStringExtra("feed_id");
            this.cbF.beM = intent.getIntExtra("is_block", 0);
            this.cbF.beN = intent.getStringExtra("scene");
            this.cbF.mAppId = intent.getStringExtra("app_id");
            this.cbF.beO = intent.getBooleanExtra("can_graffiti", true);
            this.cbF.bdk = intent.getIntExtra("custom_category_id", -1);
            this.cbF.bdl = intent.getIntExtra("custom_gift_id", -1);
            this.cbF.bbg = intent.getBooleanExtra("new_gift_t_dou_strategy", false);
            this.cbF.bbe = intent.getIntExtra(IntentConfig.USER_LEVEL, -1);
            this.cbF.bcC = intent.getBooleanExtra("isJoinGuardClub", false);
            this.cbF.isNewUser = intent.getBooleanExtra("is_new_user", false);
            this.cbF.bdm = intent.getIntExtra("guard_club_join_amount", 1000);
            this.cbF.bdy = intent.getBooleanExtra("is_redpkg_unable", false);
            this.cbF.beQ = intent.getIntExtra("page_from", -1);
            this.cbF.bbm = intent.getBooleanExtra("throne_enabled", false);
            this.cbF.beS = intent.getBooleanExtra("noble_enabled", false);
            if (intent.getStringArrayExtra(ac.aEu) != null) {
                this.cbF.caG = intent.getStringArrayExtra(ac.aEu);
            }
            String stringExtra = intent.getStringExtra("bg_info");
            if (!TextUtils.isEmpty(stringExtra)) {
                AlaLiveGiftUIInfo alaLiveGiftUIInfo = new AlaLiveGiftUIInfo();
                alaLiveGiftUIInfo.parserJson(stringExtra);
                this.cbF.beR = alaLiveGiftUIInfo;
            }
            String stringExtra2 = intent.getStringExtra(com.baidu.live.tbadk.core.frameworkdata.IntentConfig.OTHER_PARAMS);
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.cbF.mOtherParams = stringExtra2;
        }
    }

    private void registerListener() {
        HS();
        HT();
        HU();
        HV();
    }

    public void p(String str, String str2, String str3, String str4) {
        if (this.cbI != null) {
            this.cbI.c(null, str, str2, str3, "", str4);
        }
    }

    private void HS() {
        this.bhY = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyingift.panel.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.cbH != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.this.cbH.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bhY);
    }

    public void Ze() {
        MessageManager.getInstance().registerListener(this.cbL);
    }

    public void a(AlaWheatInfoData alaWheatInfoData, boolean z) {
        if (alaWheatInfoData != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mContext.getPageActivity());
            } else if (TextUtils.equals(alaWheatInfoData.uk, ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()))) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), a.h.ala_cannot_follow_myself);
            } else {
                this.cbJ.u(alaWheatInfoData.uk, com.baidu.live.ao.a.Ym().getCustomRoomId(), com.baidu.live.ao.a.Ym().Yu());
                this.cbJ.a(new a.InterfaceC0199a() { // from class: com.baidu.live.yuyingift.panel.a.6
                    @Override // com.baidu.live.personmanager.a.InterfaceC0199a
                    public void Pi() {
                        if (a.this.mContext != null) {
                            a.this.mContext.showToast(a.this.mContext.getString(a.h.sdk_attention_success_toast));
                        }
                        if (a.this.cbH != null) {
                            a.this.cbH.YO();
                            a.this.cbH.YG();
                        }
                    }

                    @Override // com.baidu.live.personmanager.a.InterfaceC0199a
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
        ab Yt = com.baidu.live.ao.a.Ym().Yt();
        if (Yt != null && Yt.mLiveInfo != null) {
            YuyinAlaPersonCardActivityConfig yuyinAlaPersonCardActivityConfig = new YuyinAlaPersonCardActivityConfig(this.mContext.getPageActivity(), "", alaWheatInfoData.uk, alaWheatInfoData.userName, alaWheatInfoData.portrait, alaWheatInfoData.sex, 0, null, null, personUserData.user_info.send_count, personUserData.user_info.fans_count, personUserData.user_info.follow_count, personUserData.relation_info.follow_status, String.valueOf(Yt.mLiveInfo.group_id), String.valueOf(Yt.mLiveInfo.live_id), false, null, null, alaWheatInfoData.userName, null, "");
            yuyinAlaPersonCardActivityConfig.cacheReEnterGiftPanel(intent);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, yuyinAlaPersonCardActivityConfig));
        }
    }

    private void HT() {
        this.bhZ = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.yuyingift.panel.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.HX();
            }
        };
        MessageManager.getInstance().registerListener(this.bhZ);
    }

    private void HU() {
        this.bia = new CustomMessageListener(2913024) { // from class: com.baidu.live.yuyingift.panel.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.cbH != null) {
                    a.this.cbH.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bia);
    }

    private void HV() {
        this.bib = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.live.yuyingift.panel.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.HX();
            }
        };
        MessageManager.getInstance().registerListener(this.bib);
    }

    private void HW() {
        int i;
        e.a aVar = new e.a() { // from class: com.baidu.live.yuyingift.panel.a.10
            @Override // com.baidu.live.yuyingift.panel.e.a
            public k Gd() {
                if (a.this.cbH != null) {
                    return a.this.cbH.Gd();
                }
                return null;
            }
        };
        b a2 = b.a(this.cbH, 0);
        a2.setPageContext(this.mContext);
        a2.a(aVar);
        a2.b(this.cbG);
        a2.a(this.cbF);
        b a3 = b.a(this.cbH, 1);
        a3.setPageContext(this.mContext);
        a3.a(aVar);
        a3.b(this.cbG);
        a3.a(this.cbF);
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
        if (this.cbH != null) {
            this.cbH.a(i, a2, a3);
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
            if (this.cbK == null && (runTask = MessageManager.getInstance().runTask(2501035, com.baidu.live.noble.b.b.class, this.mContext.getPageActivity())) != null && runTask.getData() != null) {
                this.cbK = (com.baidu.live.noble.b.b) runTask.getData();
            }
            if (this.cbK != null) {
                this.cbK.a(new b.a() { // from class: com.baidu.live.yuyingift.panel.a.2
                    @Override // com.baidu.live.noble.b.b.a
                    public void a(NobleUserInfo nobleUserInfo) {
                        a.this.bie = nobleUserInfo;
                        if (a.this.cbH != null) {
                            a.this.cbH.a(nobleUserInfo != null ? nobleUserInfo.tip : null);
                        }
                    }
                });
                this.cbK.aB(com.baidu.live.ao.a.Ym().getCustomRoomId(), com.baidu.live.ao.a.Ym().Yr());
            }
        }
    }
}
