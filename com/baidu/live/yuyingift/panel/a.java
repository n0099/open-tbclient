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
import com.baidu.live.d.ac;
import com.baidu.live.data.AlaLiveGiftUIInfo;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.bt;
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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private com.baidu.live.yuyingift.a.d bUT;
    private AlaGiftTabView.a bUU;
    private InterfaceC0246a bUV;
    private com.baidu.live.personmanager.b bUW;
    private com.baidu.live.personmanager.a bUX;
    private com.baidu.live.noble.b.b bUY;
    private int baK;
    private CustomMessageListener bgA;
    private CustomMessageListener bgB;
    private NobleUserInfo bgD;
    private CustomMessageListener bgy;
    private CustomMessageListener bgz;
    private TbPageContext mContext;
    private Handler mHandler;

    /* renamed from: com.baidu.live.yuyingift.panel.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0246a {
        k Jd();

        GiftPanelSelectMicrophoneSendView.i Zp();

        void Zq();

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

    public void a(InterfaceC0246a interfaceC0246a, AlaGiftTabView.a aVar) {
        this.bUV = interfaceC0246a;
        this.bUU = aVar;
        registerListener();
        this.mHandler = new Handler();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.panel.a.1
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913087));
            }
        }, 300L);
        KY();
        if (this.bUV != null && this.bUT != null && this.bUT.bdn != null) {
            this.bUV.a(this.bUT.bdn);
        }
        Zw();
        KZ();
        La();
        Zx();
    }

    private void Zw() {
        this.bUW = new com.baidu.live.personmanager.b(this.mContext);
        this.bUX = new com.baidu.live.personmanager.a(this.mContext.getPageActivity());
    }

    public void d(final AlaWheatInfoData alaWheatInfoData) {
        w Zd = com.baidu.live.ap.b.YX().Zd();
        if (alaWheatInfoData != null && Zd != null) {
            this.bUW.a(new b.a() { // from class: com.baidu.live.yuyingift.panel.a.4
                @Override // com.baidu.live.personmanager.b.a
                public void b(PersonUserData personUserData) {
                    if (personUserData != null && a.this.bUV != null) {
                        a.this.bUV.a(personUserData, alaWheatInfoData);
                    }
                }

                @Override // com.baidu.live.personmanager.b.a
                public void b(bt btVar) {
                }

                @Override // com.baidu.live.personmanager.b.a
                public void c(bt btVar) {
                }

                @Override // com.baidu.live.personmanager.b.a
                public void onFail(String str) {
                    if (a.this.mContext != null) {
                        a.this.mContext.showToast(str);
                    }
                }
            });
            p(alaWheatInfoData.uk, String.valueOf(Zd.mLiveInfo.live_id), String.valueOf(Zd.mLiveInfo.group_id), alaWheatInfoData.userName);
        }
    }

    private void Zx() {
        if (this.bUV != null) {
            this.bUV.a(com.baidu.live.ap.b.YX().Za(), com.baidu.live.ap.b.YX().YZ(), this.bUT.bTY);
        }
    }

    public boolean KS() {
        return this.bUT != null && this.bUT.bdo;
    }

    public void KT() {
        if (this.bgD != null && !TextUtils.isEmpty(this.bgD.detailUrl)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            nobleDetailInfo.url = this.bgD.detailUrl;
            if (this.bgD.user != null) {
                nobleDetailInfo.roleId = this.bgD.user.id;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501031, nobleDetailInfo));
            if (this.bUV != null) {
                this.bUV.onClose();
            }
        }
    }

    public void hS(String str) {
        UrlManager.getInstance().dealOneLink(this.mContext, new String[]{str});
    }

    public void release() {
        this.bUV = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bUY != null) {
            this.bUY.release();
        }
        if (this.bUW != null) {
            this.bUW.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2501048);
        MessageManager.getInstance().unRegisterListener(this.bgy);
        MessageManager.getInstance().unRegisterListener(this.bgz);
        MessageManager.getInstance().unRegisterListener(this.bgA);
        MessageManager.getInstance().unRegisterListener(this.bgB);
    }

    private void k(Intent intent) {
        this.bUT = new com.baidu.live.yuyingift.a.d();
        if (intent != null) {
            this.baK = intent.getIntExtra("custom_tab_id", 1);
            this.bUT.mUserName = intent.getStringExtra("user_name");
            this.bUT.mUserId = intent.getStringExtra("user_id");
            this.bUT.mLiveId = intent.getStringExtra("live_Id");
            this.bUT.mRoomId = intent.getStringExtra("room_id");
            this.bUT.bdh = intent.getStringExtra("feed_id");
            this.bUT.bdi = intent.getIntExtra("is_block", 0);
            this.bUT.bdj = intent.getStringExtra("scene");
            this.bUT.mAppId = intent.getStringExtra("app_id");
            this.bUT.bdk = intent.getBooleanExtra("can_graffiti", true);
            this.bUT.bbJ = intent.getIntExtra("custom_category_id", -1);
            this.bUT.bbK = intent.getIntExtra("custom_gift_id", -1);
            this.bUT.aZG = intent.getBooleanExtra("new_gift_t_dou_strategy", false);
            this.bUT.aZE = intent.getIntExtra(IntentConfig.USER_LEVEL, -1);
            this.bUT.bbc = intent.getBooleanExtra("isJoinGuardClub", false);
            this.bUT.isNewUser = intent.getBooleanExtra("is_new_user", false);
            this.bUT.bbL = intent.getIntExtra("guard_club_join_amount", 1000);
            this.bUT.bbX = intent.getBooleanExtra("is_redpkg_unable", false);
            this.bUT.bdm = intent.getIntExtra("page_from", -1);
            this.bUT.aZM = intent.getBooleanExtra("throne_enabled", false);
            this.bUT.bdo = intent.getBooleanExtra("noble_enabled", false);
            if (intent.getStringArrayExtra(ac.aFL) != null) {
                this.bUT.bTY = intent.getStringArrayExtra(ac.aFL);
            }
            String stringExtra = intent.getStringExtra("bg_info");
            if (!TextUtils.isEmpty(stringExtra)) {
                AlaLiveGiftUIInfo alaLiveGiftUIInfo = new AlaLiveGiftUIInfo();
                alaLiveGiftUIInfo.parserJson(stringExtra);
                this.bUT.bdn = alaLiveGiftUIInfo;
            }
            String stringExtra2 = intent.getStringExtra(com.baidu.live.tbadk.core.frameworkdata.IntentConfig.OTHER_PARAMS);
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.bUT.mOtherParams = stringExtra2;
        }
    }

    private void registerListener() {
        KU();
        KV();
        KW();
        KX();
        Zy();
    }

    private void Zy() {
        MessageManager.getInstance().unRegisterTask(2501048);
        CustomMessageTask customMessageTask = new CustomMessageTask(2501048, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.live.yuyingift.panel.a.5
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<InterfaceC0246a> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2501048, a.this.bUV);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void p(String str, String str2, String str3, String str4) {
        if (this.bUW != null) {
            this.bUW.b(null, str, str2, str3, "", str4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zz() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            w Zd = com.baidu.live.ap.b.YX().Zd();
            if (Zd != null && Zd.aKL != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Zd.aKL.croom_id);
            }
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "giftpanel");
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "follow").setContentExt(jSONObject));
    }

    private void KU() {
        this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyingift.panel.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bUV != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.this.bUV.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bgy);
    }

    public void ZA() {
        com.baidu.live.ap.b.YX().a(new com.baidu.live.ap.a() { // from class: com.baidu.live.yuyingift.panel.a.7
            @Override // com.baidu.live.ap.a
            public void YW() {
                List<AlaWheatInfoData> Za = com.baidu.live.ap.b.YX().Za();
                List<AlaWheatInfoData> YZ = com.baidu.live.ap.b.YX().YZ();
                if (a.this.bUV != null) {
                    a.this.bUV.a(Za, YZ, a.this.bUT.bTY);
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
                this.bUX.s(alaWheatInfoData.uk, com.baidu.live.ap.b.YX().getCustomRoomId(), com.baidu.live.ap.b.YX().Ze());
                this.bUX.a(new a.InterfaceC0203a() { // from class: com.baidu.live.yuyingift.panel.a.8
                    @Override // com.baidu.live.personmanager.a.InterfaceC0203a
                    public void Qu() {
                        if (a.this.mContext != null) {
                            a.this.mContext.showToast(a.this.mContext.getString(a.h.sdk_attention_success_toast));
                        }
                        if (a.this.bUV != null) {
                            a.this.bUV.Zq();
                        }
                        a.this.Zz();
                    }

                    @Override // com.baidu.live.personmanager.a.InterfaceC0203a
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
        w Zd = com.baidu.live.ap.b.YX().Zd();
        if (Zd != null && Zd.mLiveInfo != null) {
            YuyinAlaPersonCardActivityConfig yuyinAlaPersonCardActivityConfig = new YuyinAlaPersonCardActivityConfig((Context) this.mContext.getPageActivity(), "", alaWheatInfoData.uk, alaWheatInfoData.userName, alaWheatInfoData.portrait, alaWheatInfoData.sex, 0, (String) null, (String) null, personUserData.user_info.send_count, personUserData.user_info.fans_count, personUserData.user_info.follow_count, personUserData.relation_info.follow_status, String.valueOf(Zd.mLiveInfo.group_id), String.valueOf(Zd.mLiveInfo.live_id), false, (String) null, (String) null, alaWheatInfoData.userName, (String) null, "");
            yuyinAlaPersonCardActivityConfig.cacheReEnterGiftPanel(intent);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, yuyinAlaPersonCardActivityConfig));
        }
    }

    private void KV() {
        this.bgz = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.yuyingift.panel.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.KZ();
            }
        };
        MessageManager.getInstance().registerListener(this.bgz);
    }

    private void KW() {
        this.bgA = new CustomMessageListener(2913024) { // from class: com.baidu.live.yuyingift.panel.a.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bUV != null) {
                    a.this.bUV.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bgA);
    }

    private void KX() {
        this.bgB = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.live.yuyingift.panel.a.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.KZ();
            }
        };
        MessageManager.getInstance().registerListener(this.bgB);
    }

    private void KY() {
        int i;
        e.a aVar = new e.a() { // from class: com.baidu.live.yuyingift.panel.a.2
            @Override // com.baidu.live.yuyingift.panel.e.a
            public k Jd() {
                if (a.this.bUV != null) {
                    return a.this.bUV.Jd();
                }
                return null;
            }
        };
        b gU = b.gU(0);
        gU.setPageContext(this.mContext);
        gU.a(aVar);
        gU.b(this.bUU);
        gU.a(this.bUT);
        b gU2 = b.gU(1);
        gU2.setPageContext(this.mContext);
        gU2.a(aVar);
        gU2.b(this.bUU);
        gU2.a(this.bUT);
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
        if (this.bUV != null) {
            this.bUV.a(i, gU, gU2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KZ() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
            httpMessage.addParam("tbs", TbadkCoreApplication.getCurrentTbs());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void La() {
        CustomResponsedMessage runTask;
        if (KS()) {
            if (this.bUY == null && (runTask = MessageManager.getInstance().runTask(2501035, com.baidu.live.noble.b.b.class, this.mContext.getPageActivity())) != null && runTask.getData() != null) {
                this.bUY = (com.baidu.live.noble.b.b) runTask.getData();
            }
            if (this.bUY != null) {
                this.bUY.a(new b.a() { // from class: com.baidu.live.yuyingift.panel.a.3
                    @Override // com.baidu.live.noble.b.b.a
                    public void a(NobleUserInfo nobleUserInfo) {
                        a.this.bgD = nobleUserInfo;
                        if (a.this.bUV != null) {
                            a.this.bUV.a(nobleUserInfo != null ? nobleUserInfo.tip : null);
                        }
                    }
                });
                this.bUY.aE(com.baidu.live.ap.b.YX().getCustomRoomId(), com.baidu.live.ap.b.YX().Zb());
            }
        }
    }
}
