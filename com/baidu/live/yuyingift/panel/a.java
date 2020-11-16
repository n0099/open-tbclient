package com.baidu.live.yuyingift.panel;

import android.content.Context;
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
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.b.ab;
import com.baidu.live.data.AlaLiveGiftUIInfo;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.bs;
import com.baidu.live.data.w;
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
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.yuyingift.container.AlaGiftTabView;
import com.baidu.live.yuyingift.panel.e;
import com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private com.baidu.live.yuyingift.a.d bPJ;
    private AlaGiftTabView.a bPK;
    private InterfaceC0237a bPL;
    private com.baidu.live.personmanager.b bPM;
    private com.baidu.live.personmanager.a bPN;
    private com.baidu.live.noble.b.b bPO;
    private CustomMessageListener bcA;
    private CustomMessageListener bcB;
    private NobleUserInfo bcD;
    private int bcx;
    private CustomMessageListener bcy;
    private CustomMessageListener bcz;
    private TbPageContext mContext;
    private Handler mHandler;

    /* renamed from: com.baidu.live.yuyingift.panel.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0237a {
        k Hm();

        GiftPanelSelectMicrophoneSendView.i WQ();

        void WR();

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
        this.bPL = interfaceC0237a;
        this.bPK = aVar;
        registerListener();
        this.mHandler = new Handler();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.panel.a.1
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913087));
            }
        }, 300L);
        IX();
        if (this.bPL != null && this.bPJ != null && this.bPJ.aZN != null) {
            this.bPL.a(this.bPJ.aZN);
        }
        WX();
        IY();
        IZ();
        WY();
    }

    private void WX() {
        this.bPM = new com.baidu.live.personmanager.b(this.mContext);
        this.bPN = new com.baidu.live.personmanager.a(this.mContext.getPageActivity());
    }

    public void d(final AlaWheatInfoData alaWheatInfoData) {
        w WE = com.baidu.live.al.b.Wy().WE();
        if (alaWheatInfoData != null && WE != null) {
            this.bPM.a(new b.a() { // from class: com.baidu.live.yuyingift.panel.a.4
                @Override // com.baidu.live.personmanager.b.a
                public void b(PersonUserData personUserData) {
                    if (personUserData != null && a.this.bPL != null) {
                        a.this.bPL.a(personUserData, alaWheatInfoData);
                    }
                }

                @Override // com.baidu.live.personmanager.b.a
                public void b(bs bsVar) {
                }

                @Override // com.baidu.live.personmanager.b.a
                public void c(bs bsVar) {
                }

                @Override // com.baidu.live.personmanager.b.a
                public void onFail(String str) {
                    if (a.this.mContext != null) {
                        a.this.mContext.showToast(str);
                    }
                }
            });
            p(alaWheatInfoData.uk, String.valueOf(WE.mLiveInfo.live_id), String.valueOf(WE.mLiveInfo.group_id), alaWheatInfoData.userName);
        }
    }

    private void WY() {
        if (this.bPL != null) {
            this.bPL.a(com.baidu.live.al.b.Wy().WB(), com.baidu.live.al.b.Wy().WA(), this.bPJ.bOO);
        }
    }

    public boolean IR() {
        return this.bPJ != null && this.bPJ.aZO;
    }

    public void IS() {
        if (this.bcD != null && !TextUtils.isEmpty(this.bcD.detailUrl)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            nobleDetailInfo.url = this.bcD.detailUrl;
            if (this.bcD.user != null) {
                nobleDetailInfo.roleId = this.bcD.user.id;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501031, nobleDetailInfo));
            if (this.bPL != null) {
                this.bPL.onClose();
            }
        }
    }

    public void hu(String str) {
        UrlManager.getInstance().dealOneLink(this.mContext, new String[]{str});
    }

    public void release() {
        this.bPL = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bPO != null) {
            this.bPO.release();
        }
        if (this.bPM != null) {
            this.bPM.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2501048);
        MessageManager.getInstance().unRegisterListener(this.bcy);
        MessageManager.getInstance().unRegisterListener(this.bcz);
        MessageManager.getInstance().unRegisterListener(this.bcA);
        MessageManager.getInstance().unRegisterListener(this.bcB);
    }

    private void k(Intent intent) {
        this.bPJ = new com.baidu.live.yuyingift.a.d();
        if (intent != null) {
            this.bcx = intent.getIntExtra("custom_tab_id", 1);
            this.bPJ.mUserName = intent.getStringExtra("user_name");
            this.bPJ.mUserId = intent.getStringExtra("user_id");
            this.bPJ.mLiveId = intent.getStringExtra("live_Id");
            this.bPJ.mRoomId = intent.getStringExtra("room_id");
            this.bPJ.aZH = intent.getStringExtra("feed_id");
            this.bPJ.aZI = intent.getIntExtra("is_block", 0);
            this.bPJ.aZJ = intent.getStringExtra("scene");
            this.bPJ.mAppId = intent.getStringExtra("app_id");
            this.bPJ.aZK = intent.getBooleanExtra("can_graffiti", true);
            this.bPJ.aYo = intent.getIntExtra("custom_category_id", -1);
            this.bPJ.aYp = intent.getIntExtra("custom_gift_id", -1);
            this.bPJ.aWq = intent.getBooleanExtra("new_gift_t_dou_strategy", false);
            this.bPJ.aWo = intent.getIntExtra("user_level", -1);
            this.bPJ.aXK = intent.getBooleanExtra("isJoinGuardClub", false);
            this.bPJ.isNewUser = intent.getBooleanExtra("is_new_user", false);
            this.bPJ.aYq = intent.getIntExtra("guard_club_join_amount", 1000);
            this.bPJ.aYB = intent.getBooleanExtra("is_redpkg_unable", false);
            this.bPJ.aZM = intent.getIntExtra("page_from", -1);
            this.bPJ.aWw = intent.getBooleanExtra("throne_enabled", false);
            this.bPJ.aZO = intent.getBooleanExtra("noble_enabled", false);
            if (intent.getStringArrayExtra(ab.aDf) != null) {
                this.bPJ.bOO = intent.getStringArrayExtra(ab.aDf);
            }
            String stringExtra = intent.getStringExtra("bg_info");
            if (!TextUtils.isEmpty(stringExtra)) {
                AlaLiveGiftUIInfo alaLiveGiftUIInfo = new AlaLiveGiftUIInfo();
                alaLiveGiftUIInfo.parserJson(stringExtra);
                this.bPJ.aZN = alaLiveGiftUIInfo;
            }
            String stringExtra2 = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.bPJ.mOtherParams = stringExtra2;
        }
    }

    private void registerListener() {
        IT();
        IU();
        IV();
        IW();
        WZ();
    }

    private void WZ() {
        MessageManager.getInstance().unRegisterTask(2501048);
        CustomMessageTask customMessageTask = new CustomMessageTask(2501048, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.live.yuyingift.panel.a.5
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<InterfaceC0237a> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2501048, a.this.bPL);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void p(String str, String str2, String str3, String str4) {
        if (this.bPM != null) {
            this.bPM.b(null, str, str2, str3, "", str4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xa() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            w WE = com.baidu.live.al.b.Wy().WE();
            if (WE != null && WE.aHZ != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, WE.aHZ.croom_id);
            }
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "giftpanel");
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "follow").setContentExt(jSONObject));
    }

    private void IT() {
        this.bcy = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyingift.panel.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bPL != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.this.bPL.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bcy);
    }

    public void Xb() {
        com.baidu.live.al.b.Wy().a(new com.baidu.live.al.a() { // from class: com.baidu.live.yuyingift.panel.a.7
            @Override // com.baidu.live.al.a
            public void Wx() {
                List<AlaWheatInfoData> WB = com.baidu.live.al.b.Wy().WB();
                List<AlaWheatInfoData> WA = com.baidu.live.al.b.Wy().WA();
                if (a.this.bPL != null) {
                    a.this.bPL.a(WB, WA, a.this.bPJ.bOO);
                }
            }
        });
    }

    public void a(AlaWheatInfoData alaWheatInfoData, boolean z) {
        if (alaWheatInfoData != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mContext.getPageActivity());
            } else if (TextUtils.equals(alaWheatInfoData.uk, ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()))) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), a.h.ala_cannot_follow_myself);
            } else {
                this.bPN.p(alaWheatInfoData.uk, com.baidu.live.al.b.Wy().getCustomRoomId(), com.baidu.live.al.b.Wy().WF());
                this.bPN.a(new a.InterfaceC0193a() { // from class: com.baidu.live.yuyingift.panel.a.8
                    @Override // com.baidu.live.personmanager.a.InterfaceC0193a
                    public void Ob() {
                        if (a.this.mContext != null) {
                            a.this.mContext.showToast(a.this.mContext.getString(a.h.sdk_attention_success_toast));
                        }
                        if (a.this.bPL != null) {
                            a.this.bPL.WR();
                        }
                        a.this.Xa();
                    }

                    @Override // com.baidu.live.personmanager.a.InterfaceC0193a
                    public void t(int i, String str) {
                        if (a.this.mContext != null) {
                            a.this.mContext.showToast(str);
                        }
                    }
                });
            }
        }
    }

    public void a(PersonUserData personUserData, AlaWheatInfoData alaWheatInfoData, Intent intent) {
        w WE = com.baidu.live.al.b.Wy().WE();
        if (WE != null && WE.mLiveInfo != null) {
            YuyinAlaPersonCardActivityConfig yuyinAlaPersonCardActivityConfig = new YuyinAlaPersonCardActivityConfig((Context) this.mContext.getPageActivity(), "", alaWheatInfoData.uk, alaWheatInfoData.userName, alaWheatInfoData.portrait, alaWheatInfoData.sex, 0, (String) null, (String) null, personUserData.user_info.send_count, personUserData.user_info.fans_count, personUserData.user_info.follow_count, personUserData.relation_info.follow_status, String.valueOf(WE.mLiveInfo.group_id), String.valueOf(WE.mLiveInfo.live_id), false, (String) null, (String) null, alaWheatInfoData.userName, (String) null, "");
            yuyinAlaPersonCardActivityConfig.cacheReEnterGiftPanel(intent);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, yuyinAlaPersonCardActivityConfig));
        }
    }

    private void IU() {
        this.bcz = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.yuyingift.panel.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.IY();
            }
        };
        MessageManager.getInstance().registerListener(this.bcz);
    }

    private void IV() {
        this.bcA = new CustomMessageListener(2913024) { // from class: com.baidu.live.yuyingift.panel.a.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bPL != null) {
                    a.this.bPL.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bcA);
    }

    private void IW() {
        this.bcB = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.live.yuyingift.panel.a.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.IY();
            }
        };
        MessageManager.getInstance().registerListener(this.bcB);
    }

    private void IX() {
        int i;
        e.a aVar = new e.a() { // from class: com.baidu.live.yuyingift.panel.a.2
            @Override // com.baidu.live.yuyingift.panel.e.a
            public k Hm() {
                if (a.this.bPL != null) {
                    return a.this.bPL.Hm();
                }
                return null;
            }
        };
        b gw = b.gw(0);
        gw.setPageContext(this.mContext);
        gw.a(aVar);
        gw.b(this.bPK);
        gw.a(this.bPJ);
        b gw2 = b.gw(1);
        gw2.setPageContext(this.mContext);
        gw2.a(aVar);
        gw2.b(this.bPK);
        gw2.a(this.bPJ);
        switch (this.bcx) {
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
        if (this.bPL != null) {
            this.bPL.a(i, gw, gw2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IY() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
            httpMessage.addParam("tbs", TbadkCoreApplication.getCurrentTbs());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void IZ() {
        CustomResponsedMessage runTask;
        if (IR()) {
            if (this.bPO == null && (runTask = MessageManager.getInstance().runTask(2501035, com.baidu.live.noble.b.b.class, this.mContext.getPageActivity())) != null && runTask.getData() != null) {
                this.bPO = (com.baidu.live.noble.b.b) runTask.getData();
            }
            if (this.bPO != null) {
                this.bPO.a(new b.a() { // from class: com.baidu.live.yuyingift.panel.a.3
                    @Override // com.baidu.live.noble.b.b.a
                    public void a(NobleUserInfo nobleUserInfo) {
                        a.this.bcD = nobleUserInfo;
                        if (a.this.bPL != null) {
                            a.this.bPL.a(nobleUserInfo != null ? nobleUserInfo.tip : null);
                        }
                    }
                });
                this.bPO.aA(com.baidu.live.al.b.Wy().getCustomRoomId(), com.baidu.live.al.b.Wy().WC());
            }
        }
    }
}
