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
    private com.baidu.live.yuyingift.a.d bRt;
    private AlaGiftTabView.a bRu;
    private InterfaceC0239a bRv;
    private com.baidu.live.personmanager.b bRw;
    private com.baidu.live.personmanager.a bRx;
    private com.baidu.live.noble.b.b bRy;
    private int bej;
    private CustomMessageListener bek;
    private CustomMessageListener bel;
    private CustomMessageListener bem;
    private CustomMessageListener ben;
    private NobleUserInfo bep;
    private TbPageContext mContext;
    private Handler mHandler;

    /* renamed from: com.baidu.live.yuyingift.panel.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0239a {
        k HV();

        void XA();

        GiftPanelSelectMicrophoneSendView.i Xz();

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

    public void a(InterfaceC0239a interfaceC0239a, AlaGiftTabView.a aVar) {
        this.bRv = interfaceC0239a;
        this.bRu = aVar;
        registerListener();
        this.mHandler = new Handler();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.panel.a.1
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913087));
            }
        }, 300L);
        JG();
        if (this.bRv != null && this.bRt != null && this.bRt.bbz != null) {
            this.bRv.a(this.bRt.bbz);
        }
        XG();
        JH();
        JI();
        XH();
    }

    private void XG() {
        this.bRw = new com.baidu.live.personmanager.b(this.mContext);
        this.bRx = new com.baidu.live.personmanager.a(this.mContext.getPageActivity());
    }

    public void d(final AlaWheatInfoData alaWheatInfoData) {
        w Xn = com.baidu.live.al.b.Xh().Xn();
        if (alaWheatInfoData != null && Xn != null) {
            this.bRw.a(new b.a() { // from class: com.baidu.live.yuyingift.panel.a.4
                @Override // com.baidu.live.personmanager.b.a
                public void b(PersonUserData personUserData) {
                    if (personUserData != null && a.this.bRv != null) {
                        a.this.bRv.a(personUserData, alaWheatInfoData);
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
            p(alaWheatInfoData.uk, String.valueOf(Xn.mLiveInfo.live_id), String.valueOf(Xn.mLiveInfo.group_id), alaWheatInfoData.userName);
        }
    }

    private void XH() {
        if (this.bRv != null) {
            this.bRv.a(com.baidu.live.al.b.Xh().Xk(), com.baidu.live.al.b.Xh().Xj(), this.bRt.bQy);
        }
    }

    public boolean JA() {
        return this.bRt != null && this.bRt.bbA;
    }

    public void JB() {
        if (this.bep != null && !TextUtils.isEmpty(this.bep.detailUrl)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            nobleDetailInfo.url = this.bep.detailUrl;
            if (this.bep.user != null) {
                nobleDetailInfo.roleId = this.bep.user.id;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501031, nobleDetailInfo));
            if (this.bRv != null) {
                this.bRv.onClose();
            }
        }
    }

    public void hA(String str) {
        UrlManager.getInstance().dealOneLink(this.mContext, new String[]{str});
    }

    public void release() {
        this.bRv = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bRy != null) {
            this.bRy.release();
        }
        if (this.bRw != null) {
            this.bRw.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2501048);
        MessageManager.getInstance().unRegisterListener(this.bek);
        MessageManager.getInstance().unRegisterListener(this.bel);
        MessageManager.getInstance().unRegisterListener(this.bem);
        MessageManager.getInstance().unRegisterListener(this.ben);
    }

    private void k(Intent intent) {
        this.bRt = new com.baidu.live.yuyingift.a.d();
        if (intent != null) {
            this.bej = intent.getIntExtra("custom_tab_id", 1);
            this.bRt.mUserName = intent.getStringExtra("user_name");
            this.bRt.mUserId = intent.getStringExtra("user_id");
            this.bRt.mLiveId = intent.getStringExtra("live_Id");
            this.bRt.mRoomId = intent.getStringExtra("room_id");
            this.bRt.bbt = intent.getStringExtra("feed_id");
            this.bRt.bbu = intent.getIntExtra("is_block", 0);
            this.bRt.bbv = intent.getStringExtra("scene");
            this.bRt.mAppId = intent.getStringExtra("app_id");
            this.bRt.bbw = intent.getBooleanExtra("can_graffiti", true);
            this.bRt.aZZ = intent.getIntExtra("custom_category_id", -1);
            this.bRt.baa = intent.getIntExtra("custom_gift_id", -1);
            this.bRt.aYb = intent.getBooleanExtra("new_gift_t_dou_strategy", false);
            this.bRt.aXZ = intent.getIntExtra("user_level", -1);
            this.bRt.aZv = intent.getBooleanExtra("isJoinGuardClub", false);
            this.bRt.isNewUser = intent.getBooleanExtra("is_new_user", false);
            this.bRt.bab = intent.getIntExtra("guard_club_join_amount", 1000);
            this.bRt.bam = intent.getBooleanExtra("is_redpkg_unable", false);
            this.bRt.bby = intent.getIntExtra("page_from", -1);
            this.bRt.aYh = intent.getBooleanExtra("throne_enabled", false);
            this.bRt.bbA = intent.getBooleanExtra("noble_enabled", false);
            if (intent.getStringArrayExtra(ab.aEQ) != null) {
                this.bRt.bQy = intent.getStringArrayExtra(ab.aEQ);
            }
            String stringExtra = intent.getStringExtra("bg_info");
            if (!TextUtils.isEmpty(stringExtra)) {
                AlaLiveGiftUIInfo alaLiveGiftUIInfo = new AlaLiveGiftUIInfo();
                alaLiveGiftUIInfo.parserJson(stringExtra);
                this.bRt.bbz = alaLiveGiftUIInfo;
            }
            String stringExtra2 = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.bRt.mOtherParams = stringExtra2;
        }
    }

    private void registerListener() {
        JC();
        JD();
        JE();
        JF();
        XI();
    }

    private void XI() {
        MessageManager.getInstance().unRegisterTask(2501048);
        CustomMessageTask customMessageTask = new CustomMessageTask(2501048, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.live.yuyingift.panel.a.5
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<InterfaceC0239a> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2501048, a.this.bRv);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void p(String str, String str2, String str3, String str4) {
        if (this.bRw != null) {
            this.bRw.b(null, str, str2, str3, "", str4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XJ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            w Xn = com.baidu.live.al.b.Xh().Xn();
            if (Xn != null && Xn.aJK != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Xn.aJK.croom_id);
            }
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "giftpanel");
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "follow").setContentExt(jSONObject));
    }

    private void JC() {
        this.bek = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyingift.panel.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bRv != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.this.bRv.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bek);
    }

    public void XK() {
        com.baidu.live.al.b.Xh().a(new com.baidu.live.al.a() { // from class: com.baidu.live.yuyingift.panel.a.7
            @Override // com.baidu.live.al.a
            public void Xg() {
                List<AlaWheatInfoData> Xk = com.baidu.live.al.b.Xh().Xk();
                List<AlaWheatInfoData> Xj = com.baidu.live.al.b.Xh().Xj();
                if (a.this.bRv != null) {
                    a.this.bRv.a(Xk, Xj, a.this.bRt.bQy);
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
                this.bRx.p(alaWheatInfoData.uk, com.baidu.live.al.b.Xh().getCustomRoomId(), com.baidu.live.al.b.Xh().Xo());
                this.bRx.a(new a.InterfaceC0195a() { // from class: com.baidu.live.yuyingift.panel.a.8
                    @Override // com.baidu.live.personmanager.a.InterfaceC0195a
                    public void OK() {
                        if (a.this.mContext != null) {
                            a.this.mContext.showToast(a.this.mContext.getString(a.h.sdk_attention_success_toast));
                        }
                        if (a.this.bRv != null) {
                            a.this.bRv.XA();
                        }
                        a.this.XJ();
                    }

                    @Override // com.baidu.live.personmanager.a.InterfaceC0195a
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
        w Xn = com.baidu.live.al.b.Xh().Xn();
        if (Xn != null && Xn.mLiveInfo != null) {
            YuyinAlaPersonCardActivityConfig yuyinAlaPersonCardActivityConfig = new YuyinAlaPersonCardActivityConfig((Context) this.mContext.getPageActivity(), "", alaWheatInfoData.uk, alaWheatInfoData.userName, alaWheatInfoData.portrait, alaWheatInfoData.sex, 0, (String) null, (String) null, personUserData.user_info.send_count, personUserData.user_info.fans_count, personUserData.user_info.follow_count, personUserData.relation_info.follow_status, String.valueOf(Xn.mLiveInfo.group_id), String.valueOf(Xn.mLiveInfo.live_id), false, (String) null, (String) null, alaWheatInfoData.userName, (String) null, "");
            yuyinAlaPersonCardActivityConfig.cacheReEnterGiftPanel(intent);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, yuyinAlaPersonCardActivityConfig));
        }
    }

    private void JD() {
        this.bel = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.yuyingift.panel.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.JH();
            }
        };
        MessageManager.getInstance().registerListener(this.bel);
    }

    private void JE() {
        this.bem = new CustomMessageListener(2913024) { // from class: com.baidu.live.yuyingift.panel.a.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bRv != null) {
                    a.this.bRv.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bem);
    }

    private void JF() {
        this.ben = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.live.yuyingift.panel.a.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.JH();
            }
        };
        MessageManager.getInstance().registerListener(this.ben);
    }

    private void JG() {
        int i;
        e.a aVar = new e.a() { // from class: com.baidu.live.yuyingift.panel.a.2
            @Override // com.baidu.live.yuyingift.panel.e.a
            public k HV() {
                if (a.this.bRv != null) {
                    return a.this.bRv.HV();
                }
                return null;
            }
        };
        b gA = b.gA(0);
        gA.setPageContext(this.mContext);
        gA.a(aVar);
        gA.b(this.bRu);
        gA.a(this.bRt);
        b gA2 = b.gA(1);
        gA2.setPageContext(this.mContext);
        gA2.a(aVar);
        gA2.b(this.bRu);
        gA2.a(this.bRt);
        switch (this.bej) {
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
        if (this.bRv != null) {
            this.bRv.a(i, gA, gA2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JH() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
            httpMessage.addParam("tbs", TbadkCoreApplication.getCurrentTbs());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void JI() {
        CustomResponsedMessage runTask;
        if (JA()) {
            if (this.bRy == null && (runTask = MessageManager.getInstance().runTask(2501035, com.baidu.live.noble.b.b.class, this.mContext.getPageActivity())) != null && runTask.getData() != null) {
                this.bRy = (com.baidu.live.noble.b.b) runTask.getData();
            }
            if (this.bRy != null) {
                this.bRy.a(new b.a() { // from class: com.baidu.live.yuyingift.panel.a.3
                    @Override // com.baidu.live.noble.b.b.a
                    public void a(NobleUserInfo nobleUserInfo) {
                        a.this.bep = nobleUserInfo;
                        if (a.this.bRv != null) {
                            a.this.bRv.a(nobleUserInfo != null ? nobleUserInfo.tip : null);
                        }
                    }
                });
                this.bRy.aB(com.baidu.live.al.b.Xh().getCustomRoomId(), com.baidu.live.al.b.Xh().Xl());
            }
        }
    }
}
