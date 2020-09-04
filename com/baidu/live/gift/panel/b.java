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
    private com.baidu.live.gift.a.d aVL;
    private AlaGiftTabView.a aVM;
    private a aVN;
    private int aVO;
    private CustomMessageListener aVP;
    private CustomMessageListener aVQ;
    private CustomMessageListener aVR;
    private CustomMessageListener aVS;
    private com.baidu.live.noble.b.a aVT;
    private NobleUserInfo aVU;
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
        this.aVN = aVar;
        this.aVM = aVar2;
        registerListener();
        this.mHandler = new Handler();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913087));
            }
        }, 300L);
        Ho();
        if (this.aVN != null && this.aVL != null && this.aVL.aTk != null) {
            this.aVN.a(this.aVL.aTk);
        }
        Hp();
        Hq();
    }

    public boolean Hi() {
        return this.aVL != null && this.aVL.aTl;
    }

    public void Hj() {
        if (this.aVU != null && !TextUtils.isEmpty(this.aVU.detailUrl)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            nobleDetailInfo.url = this.aVU.detailUrl;
            if (this.aVU.user != null) {
                nobleDetailInfo.roleId = this.aVU.user.id;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
            if (this.aVN != null) {
                this.aVN.onClose();
            }
        }
    }

    public void gL(String str) {
        UrlManager.getInstance().dealOneLink(this.mContext, new String[]{str});
    }

    public void release() {
        this.aVN = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aVT != null) {
            this.aVT.release();
        }
        MessageManager.getInstance().unRegisterListener(this.aVP);
        MessageManager.getInstance().unRegisterListener(this.aVQ);
        MessageManager.getInstance().unRegisterListener(this.aVR);
        MessageManager.getInstance().unRegisterListener(this.aVS);
    }

    private void k(Intent intent) {
        this.aVL = new com.baidu.live.gift.a.d();
        if (intent != null) {
            this.aVO = intent.getIntExtra("custom_tab_id", 1);
            this.aVL.mUserName = intent.getStringExtra("user_name");
            this.aVL.mUserId = intent.getStringExtra("user_id");
            this.aVL.mLiveId = intent.getStringExtra("live_Id");
            this.aVL.mRoomId = intent.getStringExtra("room_id");
            this.aVL.aTe = intent.getStringExtra("feed_id");
            this.aVL.aTf = intent.getIntExtra("is_block", 0);
            this.aVL.aTg = intent.getStringExtra("scene");
            this.aVL.mAppId = intent.getStringExtra("app_id");
            this.aVL.aTh = intent.getBooleanExtra("can_graffiti", true);
            this.aVL.aRY = intent.getIntExtra("custom_category_id", -1);
            this.aVL.aRZ = intent.getIntExtra("custom_gift_id", -1);
            this.aVL.aQb = intent.getBooleanExtra("new_gift_t_dou_strategy", false);
            this.aVL.aPZ = intent.getIntExtra("user_level", -1);
            this.aVL.aRu = intent.getBooleanExtra("isJoinGuardClub", false);
            this.aVL.isNewUser = intent.getBooleanExtra("is_new_user", false);
            this.aVL.aSa = intent.getIntExtra("guard_club_join_amount", 1000);
            this.aVL.aSl = intent.getBooleanExtra("is_redpkg_unable", false);
            this.aVL.aTj = intent.getIntExtra("page_from", -1);
            this.aVL.aQi = intent.getBooleanExtra("throne_enabled", false);
            this.aVL.aTl = intent.getBooleanExtra("noble_enabled", false);
            String stringExtra = intent.getStringExtra("bg_info");
            if (!TextUtils.isEmpty(stringExtra)) {
                AlaLiveGiftUIInfo alaLiveGiftUIInfo = new AlaLiveGiftUIInfo();
                alaLiveGiftUIInfo.parserJson(stringExtra);
                this.aVL.aTk = alaLiveGiftUIInfo;
            }
            String stringExtra2 = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.aVL.mOtherParams = stringExtra2;
        }
    }

    private void registerListener() {
        Hk();
        Hl();
        Hm();
        Hn();
    }

    private void Hk() {
        this.aVP = new CustomMessageListener(2913097) { // from class: com.baidu.live.gift.panel.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.aVN != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    b.this.aVN.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aVP);
    }

    private void Hl() {
        this.aVQ = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.gift.panel.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.Hp();
            }
        };
        MessageManager.getInstance().registerListener(this.aVQ);
    }

    private void Hm() {
        this.aVR = new CustomMessageListener(2913024) { // from class: com.baidu.live.gift.panel.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.aVN != null) {
                    b.this.aVN.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aVR);
    }

    private void Hn() {
        this.aVS = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.live.gift.panel.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.Hp();
            }
        };
        MessageManager.getInstance().registerListener(this.aVS);
    }

    private void Ho() {
        int i;
        f.a aVar = new f.a() { // from class: com.baidu.live.gift.panel.b.6
            @Override // com.baidu.live.gift.panel.f.a
            public l FC() {
                if (b.this.aVN != null) {
                    return b.this.aVN.FC();
                }
                return null;
            }
        };
        c ep = c.ep(0);
        ep.setPageContext(this.mContext);
        ep.a(aVar);
        ep.b(this.aVM);
        ep.a(this.aVL);
        c ep2 = c.ep(1);
        ep2.setPageContext(this.mContext);
        ep2.a(aVar);
        ep2.b(this.aVM);
        ep2.a(this.aVL);
        switch (this.aVO) {
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
        if (this.aVN != null) {
            this.aVN.a(i, ep, ep2);
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
            if (this.aVT == null && (runTask = MessageManager.getInstance().runTask(2913198, com.baidu.live.noble.b.a.class, this.mContext.getPageActivity())) != null && runTask.getData() != null) {
                this.aVT = (com.baidu.live.noble.b.a) runTask.getData();
            }
            if (this.aVT != null) {
                this.aVT.a(new a.InterfaceC0181a() { // from class: com.baidu.live.gift.panel.b.7
                    @Override // com.baidu.live.noble.b.a.InterfaceC0181a
                    public void a(NobleUserInfo nobleUserInfo) {
                        b.this.aVU = nobleUserInfo;
                        if (b.this.aVN != null) {
                            b.this.aVN.a(nobleUserInfo != null ? nobleUserInfo.tip : null);
                        }
                    }
                });
                this.aVT.LQ();
            }
        }
    }
}
