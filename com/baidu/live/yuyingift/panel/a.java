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
import com.baidu.live.data.br;
import com.baidu.live.data.w;
import com.baidu.live.gift.l;
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
    private com.baidu.live.yuyingift.a.d bLL;
    private AlaGiftTabView.a bLM;
    private InterfaceC0227a bLN;
    private com.baidu.live.personmanager.b bLO;
    private com.baidu.live.personmanager.a bLP;
    private com.baidu.live.noble.b.b bLQ;
    private int bcP;
    private CustomMessageListener bcQ;
    private CustomMessageListener bcR;
    private CustomMessageListener bcS;
    private CustomMessageListener bcT;
    private NobleUserInfo bcV;
    private TbPageContext mContext;
    private Handler mHandler;

    /* renamed from: com.baidu.live.yuyingift.panel.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0227a {
        l Hu();

        GiftPanelSelectMicrophoneSendView.i Va();

        void Vb();

        void a(int i, SupportXFragment... supportXFragmentArr);

        void a(AlaLiveGiftUIInfo alaLiveGiftUIInfo);

        void a(PersonUserData personUserData, AlaWheatInfoData alaWheatInfoData);

        void a(NobleUserInfo.a aVar);

        void a(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, String str);

        void onClose();
    }

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void init(Intent intent) {
        k(intent);
    }

    public void a(InterfaceC0227a interfaceC0227a, AlaGiftTabView.a aVar) {
        this.bLN = interfaceC0227a;
        this.bLM = aVar;
        registerListener();
        this.mHandler = new Handler();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.panel.a.1
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913087));
            }
        }, 300L);
        Jf();
        if (this.bLN != null && this.bLL != null && this.bLL.bag != null) {
            this.bLN.a(this.bLL.bag);
        }
        Vh();
        Jg();
        Jh();
        Vi();
    }

    private void Vh() {
        this.bLO = new com.baidu.live.personmanager.b(this.mContext);
        this.bLP = new com.baidu.live.personmanager.a(this.mContext.getPageActivity());
    }

    public void d(final AlaWheatInfoData alaWheatInfoData) {
        w UO = com.baidu.live.aj.b.UH().UO();
        if (alaWheatInfoData != null && UO != null) {
            this.bLO.a(new b.a() { // from class: com.baidu.live.yuyingift.panel.a.4
                @Override // com.baidu.live.personmanager.b.a
                public void b(PersonUserData personUserData) {
                    if (personUserData != null && a.this.bLN != null) {
                        a.this.bLN.a(personUserData, alaWheatInfoData);
                    }
                }

                @Override // com.baidu.live.personmanager.b.a
                public void b(br brVar) {
                }

                @Override // com.baidu.live.personmanager.b.a
                public void c(br brVar) {
                }

                @Override // com.baidu.live.personmanager.b.a
                public void onFail(String str) {
                    if (a.this.mContext != null) {
                        a.this.mContext.showToast(str);
                    }
                }
            });
            p(alaWheatInfoData.uk, String.valueOf(UO.mLiveInfo.live_id), String.valueOf(UO.mLiveInfo.group_id), alaWheatInfoData.userName);
        }
    }

    private void Vi() {
        if (this.bLN != null) {
            this.bLN.a(com.baidu.live.aj.b.UH().UL(), com.baidu.live.aj.b.UH().UK(), this.bLL.bKQ);
        }
    }

    public boolean IZ() {
        return this.bLL != null && this.bLL.bah;
    }

    public void Ja() {
        if (this.bcV != null && !TextUtils.isEmpty(this.bcV.detailUrl)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            nobleDetailInfo.url = this.bcV.detailUrl;
            if (this.bcV.user != null) {
                nobleDetailInfo.roleId = this.bcV.user.id;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501031, nobleDetailInfo));
            if (this.bLN != null) {
                this.bLN.onClose();
            }
        }
    }

    public void ht(String str) {
        UrlManager.getInstance().dealOneLink(this.mContext, new String[]{str});
    }

    public void release() {
        this.bLN = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bLQ != null) {
            this.bLQ.release();
        }
        if (this.bLO != null) {
            this.bLO.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2501048);
        MessageManager.getInstance().unRegisterListener(this.bcQ);
        MessageManager.getInstance().unRegisterListener(this.bcR);
        MessageManager.getInstance().unRegisterListener(this.bcS);
        MessageManager.getInstance().unRegisterListener(this.bcT);
    }

    private void k(Intent intent) {
        this.bLL = new com.baidu.live.yuyingift.a.d();
        if (intent != null) {
            this.bcP = intent.getIntExtra("custom_tab_id", 1);
            this.bLL.mUserName = intent.getStringExtra("user_name");
            this.bLL.mUserId = intent.getStringExtra("user_id");
            this.bLL.mLiveId = intent.getStringExtra("live_Id");
            this.bLL.mRoomId = intent.getStringExtra("room_id");
            this.bLL.baa = intent.getStringExtra("feed_id");
            this.bLL.bab = intent.getIntExtra("is_block", 0);
            this.bLL.bac = intent.getStringExtra("scene");
            this.bLL.mAppId = intent.getStringExtra("app_id");
            this.bLL.bad = intent.getBooleanExtra("can_graffiti", true);
            this.bLL.aYH = intent.getIntExtra("custom_category_id", -1);
            this.bLL.aYI = intent.getIntExtra("custom_gift_id", -1);
            this.bLL.aWJ = intent.getBooleanExtra("new_gift_t_dou_strategy", false);
            this.bLL.aWH = intent.getIntExtra("user_level", -1);
            this.bLL.aYd = intent.getBooleanExtra("isJoinGuardClub", false);
            this.bLL.isNewUser = intent.getBooleanExtra("is_new_user", false);
            this.bLL.aYJ = intent.getIntExtra("guard_club_join_amount", 1000);
            this.bLL.aYU = intent.getBooleanExtra("is_redpkg_unable", false);
            this.bLL.baf = intent.getIntExtra("page_from", -1);
            this.bLL.aWP = intent.getBooleanExtra("throne_enabled", false);
            this.bLL.bah = intent.getBooleanExtra("noble_enabled", false);
            if (intent.getSerializableExtra(ab.aEa) != null) {
                this.bLL.bKQ = (String) intent.getSerializableExtra(ab.aEa);
            }
            String stringExtra = intent.getStringExtra("bg_info");
            if (!TextUtils.isEmpty(stringExtra)) {
                AlaLiveGiftUIInfo alaLiveGiftUIInfo = new AlaLiveGiftUIInfo();
                alaLiveGiftUIInfo.parserJson(stringExtra);
                this.bLL.bag = alaLiveGiftUIInfo;
            }
            String stringExtra2 = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.bLL.mOtherParams = stringExtra2;
        }
    }

    private void registerListener() {
        Jb();
        Jc();
        Jd();
        Je();
        Vj();
    }

    private void Vj() {
        MessageManager.getInstance().unRegisterTask(2501048);
        CustomMessageTask customMessageTask = new CustomMessageTask(2501048, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.live.yuyingift.panel.a.5
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<InterfaceC0227a> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2501048, a.this.bLN);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void p(String str, String str2, String str3, String str4) {
        if (this.bLO != null) {
            this.bLO.b(null, str, str2, str3, "", str4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vk() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            w UO = com.baidu.live.aj.b.UH().UO();
            if (UO != null && UO.aIS != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, UO.aIS.croom_id);
            }
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "giftpanel");
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "follow").setContentExt(jSONObject));
    }

    private void Jb() {
        this.bcQ = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyingift.panel.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bLN != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.this.bLN.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bcQ);
    }

    public void Vl() {
        com.baidu.live.aj.b.UH().a(new com.baidu.live.aj.a() { // from class: com.baidu.live.yuyingift.panel.a.7
            @Override // com.baidu.live.aj.a
            public void UG() {
                List<AlaWheatInfoData> UL = com.baidu.live.aj.b.UH().UL();
                List<AlaWheatInfoData> UK = com.baidu.live.aj.b.UH().UK();
                if (a.this.bLN != null) {
                    a.this.bLN.a(UL, UK, a.this.bLL.bKQ);
                }
            }
        });
    }

    public void a(AlaWheatInfoData alaWheatInfoData, boolean z) {
        if (alaWheatInfoData != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.mContext.getPageActivity());
            } else if (TextUtils.equals(alaWheatInfoData.uk, ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()))) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), a.i.ala_cannot_follow_myself);
            } else {
                this.bLP.p(alaWheatInfoData.uk, com.baidu.live.aj.b.UH().getCustomRoomId(), com.baidu.live.aj.b.UH().UP());
                this.bLP.a(new a.InterfaceC0193a() { // from class: com.baidu.live.yuyingift.panel.a.8
                    @Override // com.baidu.live.personmanager.a.InterfaceC0193a
                    public void Ok() {
                        if (a.this.mContext != null) {
                            a.this.mContext.showToast(a.this.mContext.getString(a.i.sdk_attention_success_toast));
                        }
                        if (a.this.bLN != null) {
                            a.this.bLN.Vb();
                        }
                        a.this.Vk();
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
        w UO = com.baidu.live.aj.b.UH().UO();
        if (UO != null && UO.mLiveInfo != null) {
            YuyinAlaPersonCardActivityConfig yuyinAlaPersonCardActivityConfig = new YuyinAlaPersonCardActivityConfig((Context) this.mContext.getPageActivity(), "", alaWheatInfoData.uk, alaWheatInfoData.userName, alaWheatInfoData.portrait, alaWheatInfoData.sex, 0, (String) null, (String) null, personUserData.user_info.send_count, personUserData.user_info.fans_count, personUserData.user_info.follow_count, personUserData.relation_info.follow_status, String.valueOf(UO.mLiveInfo.group_id), String.valueOf(UO.mLiveInfo.live_id), false, (String) null, (String) null, alaWheatInfoData.userName, (String) null, "");
            yuyinAlaPersonCardActivityConfig.cacheReEnterGiftPanel(intent);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, yuyinAlaPersonCardActivityConfig));
        }
    }

    private void Jc() {
        this.bcR = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.yuyingift.panel.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.Jg();
            }
        };
        MessageManager.getInstance().registerListener(this.bcR);
    }

    private void Jd() {
        this.bcS = new CustomMessageListener(2913024) { // from class: com.baidu.live.yuyingift.panel.a.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bLN != null) {
                    a.this.bLN.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bcS);
    }

    private void Je() {
        this.bcT = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.live.yuyingift.panel.a.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.Jg();
            }
        };
        MessageManager.getInstance().registerListener(this.bcT);
    }

    private void Jf() {
        int i;
        e.a aVar = new e.a() { // from class: com.baidu.live.yuyingift.panel.a.2
            @Override // com.baidu.live.yuyingift.panel.e.a
            public l Hu() {
                if (a.this.bLN != null) {
                    return a.this.bLN.Hu();
                }
                return null;
            }
        };
        b gq = b.gq(0);
        gq.setPageContext(this.mContext);
        gq.a(aVar);
        gq.b(this.bLM);
        gq.a(this.bLL);
        b gq2 = b.gq(1);
        gq2.setPageContext(this.mContext);
        gq2.a(aVar);
        gq2.b(this.bLM);
        gq2.a(this.bLL);
        switch (this.bcP) {
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
        if (this.bLN != null) {
            this.bLN.a(i, gq, gq2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jg() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
            httpMessage.addParam("tbs", TbadkCoreApplication.getCurrentTbs());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void Jh() {
        CustomResponsedMessage runTask;
        if (IZ()) {
            if (this.bLQ == null && (runTask = MessageManager.getInstance().runTask(2501035, com.baidu.live.noble.b.b.class, this.mContext.getPageActivity())) != null && runTask.getData() != null) {
                this.bLQ = (com.baidu.live.noble.b.b) runTask.getData();
            }
            if (this.bLQ != null) {
                this.bLQ.a(new b.a() { // from class: com.baidu.live.yuyingift.panel.a.3
                    @Override // com.baidu.live.noble.b.b.a
                    public void a(NobleUserInfo nobleUserInfo) {
                        a.this.bcV = nobleUserInfo;
                        if (a.this.bLN != null) {
                            a.this.bLN.a(nobleUserInfo != null ? nobleUserInfo.tip : null);
                        }
                    }
                });
                this.bLQ.aA(com.baidu.live.aj.b.UH().getCustomRoomId(), com.baidu.live.aj.b.UH().UM());
            }
        }
    }
}
