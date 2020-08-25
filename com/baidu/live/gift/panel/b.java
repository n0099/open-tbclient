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
import com.baidu.live.gift.l;
import com.baidu.live.gift.panel.f;
import com.baidu.live.noble.b.a;
import com.baidu.live.noble.data.NobleDetailInfo;
import com.baidu.live.noble.data.NobleUserInfo;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.fragment.SupportXFragment;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.core.util.UrlManager;
/* loaded from: classes7.dex */
public class b {
    private com.baidu.live.gift.a.d aVJ;
    private AlaGiftTabView.a aVK;
    private a aVL;
    private int aVM;
    private CustomMessageListener aVN;
    private CustomMessageListener aVO;
    private CustomMessageListener aVP;
    private CustomMessageListener aVQ;
    private com.baidu.live.noble.b.a aVR;
    private NobleUserInfo aVS;
    private TbPageContext mContext;
    private Handler mHandler;

    /* loaded from: classes7.dex */
    public interface a {
        l FC();

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

    public void a(a aVar, AlaGiftTabView.a aVar2) {
        this.aVL = aVar;
        this.aVK = aVar2;
        registerListener();
        this.mHandler = new Handler();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913087));
            }
        }, 300L);
        Ho();
        if (this.aVL != null && this.aVJ != null && this.aVJ.aTi != null) {
            this.aVL.a(this.aVJ.aTi);
        }
        Hp();
        Hq();
    }

    public boolean Hi() {
        return this.aVJ != null && this.aVJ.aTj;
    }

    public void Hj() {
        if (this.aVS != null && !TextUtils.isEmpty(this.aVS.detailUrl)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            nobleDetailInfo.url = this.aVS.detailUrl;
            if (this.aVS.user != null) {
                nobleDetailInfo.roleId = this.aVS.user.id;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
            if (this.aVL != null) {
                this.aVL.onClose();
            }
        }
    }

    public void gK(String str) {
        UrlManager.getInstance().dealOneLink(this.mContext, new String[]{str});
    }

    public void release() {
        this.aVL = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aVR != null) {
            this.aVR.release();
        }
        MessageManager.getInstance().unRegisterListener(this.aVN);
        MessageManager.getInstance().unRegisterListener(this.aVO);
        MessageManager.getInstance().unRegisterListener(this.aVP);
        MessageManager.getInstance().unRegisterListener(this.aVQ);
    }

    private void k(Intent intent) {
        this.aVJ = new com.baidu.live.gift.a.d();
        if (intent != null) {
            this.aVM = intent.getIntExtra("custom_tab_id", 1);
            this.aVJ.mUserName = intent.getStringExtra("user_name");
            this.aVJ.mUserId = intent.getStringExtra("user_id");
            this.aVJ.mLiveId = intent.getStringExtra("live_Id");
            this.aVJ.mRoomId = intent.getStringExtra("room_id");
            this.aVJ.aTc = intent.getStringExtra("feed_id");
            this.aVJ.aTd = intent.getIntExtra("is_block", 0);
            this.aVJ.aTe = intent.getStringExtra("scene");
            this.aVJ.mAppId = intent.getStringExtra("app_id");
            this.aVJ.aTf = intent.getBooleanExtra("can_graffiti", true);
            this.aVJ.aRW = intent.getIntExtra("custom_category_id", -1);
            this.aVJ.aRX = intent.getIntExtra("custom_gift_id", -1);
            this.aVJ.aPZ = intent.getBooleanExtra("new_gift_t_dou_strategy", false);
            this.aVJ.aPX = intent.getIntExtra("user_level", -1);
            this.aVJ.aRs = intent.getBooleanExtra("isJoinGuardClub", false);
            this.aVJ.isNewUser = intent.getBooleanExtra("is_new_user", false);
            this.aVJ.aRY = intent.getIntExtra("guard_club_join_amount", 1000);
            this.aVJ.aSj = intent.getBooleanExtra("is_redpkg_unable", false);
            this.aVJ.aTh = intent.getIntExtra("page_from", -1);
            this.aVJ.aQg = intent.getBooleanExtra("throne_enabled", false);
            this.aVJ.aTj = intent.getBooleanExtra("noble_enabled", false);
            String stringExtra = intent.getStringExtra("bg_info");
            if (!TextUtils.isEmpty(stringExtra)) {
                AlaLiveGiftUIInfo alaLiveGiftUIInfo = new AlaLiveGiftUIInfo();
                alaLiveGiftUIInfo.parserJson(stringExtra);
                this.aVJ.aTi = alaLiveGiftUIInfo;
            }
            String stringExtra2 = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.aVJ.mOtherParams = stringExtra2;
        }
    }

    private void registerListener() {
        Hk();
        Hl();
        Hm();
        Hn();
    }

    private void Hk() {
        this.aVN = new CustomMessageListener(2913097) { // from class: com.baidu.live.gift.panel.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.aVL != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    b.this.aVL.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aVN);
    }

    private void Hl() {
        this.aVO = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.gift.panel.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.Hp();
            }
        };
        MessageManager.getInstance().registerListener(this.aVO);
    }

    private void Hm() {
        this.aVP = new CustomMessageListener(2913024) { // from class: com.baidu.live.gift.panel.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.aVL != null) {
                    b.this.aVL.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aVP);
    }

    private void Hn() {
        this.aVQ = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.live.gift.panel.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.Hp();
            }
        };
        MessageManager.getInstance().registerListener(this.aVQ);
    }

    private void Ho() {
        int i;
        f.a aVar = new f.a() { // from class: com.baidu.live.gift.panel.b.6
            @Override // com.baidu.live.gift.panel.f.a
            public l FC() {
                if (b.this.aVL != null) {
                    return b.this.aVL.FC();
                }
                return null;
            }
        };
        c ep = c.ep(0);
        ep.setPageContext(this.mContext);
        ep.a(aVar);
        ep.b(this.aVK);
        ep.a(this.aVJ);
        c ep2 = c.ep(1);
        ep2.setPageContext(this.mContext);
        ep2.a(aVar);
        ep2.b(this.aVK);
        ep2.a(this.aVJ);
        switch (this.aVM) {
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
        if (this.aVL != null) {
            this.aVL.a(i, ep, ep2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hp() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
            httpMessage.addParam("tbs", TbadkCoreApplication.getCurrentTbs());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void Hq() {
        CustomResponsedMessage runTask;
        if (Hi()) {
            if (this.aVR == null && (runTask = MessageManager.getInstance().runTask(2913198, com.baidu.live.noble.b.a.class, this.mContext.getPageActivity())) != null && runTask.getData() != null) {
                this.aVR = (com.baidu.live.noble.b.a) runTask.getData();
            }
            if (this.aVR != null) {
                this.aVR.a(new a.InterfaceC0181a() { // from class: com.baidu.live.gift.panel.b.7
                    @Override // com.baidu.live.noble.b.a.InterfaceC0181a
                    public void a(NobleUserInfo nobleUserInfo) {
                        b.this.aVS = nobleUserInfo;
                        if (b.this.aVL != null) {
                            b.this.aVL.a(nobleUserInfo != null ? nobleUserInfo.tip : null);
                        }
                    }
                });
                this.aVR.LQ();
            }
        }
    }
}
