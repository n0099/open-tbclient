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
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
/* loaded from: classes4.dex */
public class b {
    private CustomMessageListener aQA;
    private CustomMessageListener aQB;
    private CustomMessageListener aQC;
    private com.baidu.live.noble.b.a aQD;
    private NobleUserInfo aQE;
    private com.baidu.live.gift.a.d aQv;
    private AlaGiftTabView.a aQw;
    private a aQx;
    private int aQy;
    private CustomMessageListener aQz;
    private TbPageContext mContext;
    private Handler mHandler;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, SupportXFragment... supportXFragmentArr);

        void a(AlaLiveGiftUIInfo alaLiveGiftUIInfo);

        void a(NobleUserInfo.a aVar);

        void onClose();

        l zZ();
    }

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void init(Intent intent) {
        k(intent);
    }

    public void a(a aVar, AlaGiftTabView.a aVar2) {
        this.aQx = aVar;
        this.aQw = aVar2;
        registerListener();
        this.mHandler = new Handler();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913087));
            }
        }, 300L);
        BL();
        if (this.aQx != null && this.aQv != null && this.aQv.aNV != null) {
            this.aQx.a(this.aQv.aNV);
        }
        BM();
        BN();
    }

    public boolean BF() {
        return this.aQv != null && this.aQv.aNW;
    }

    public void BG() {
        if (this.aQE != null && !TextUtils.isEmpty(this.aQE.detailUrl)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            nobleDetailInfo.url = this.aQE.detailUrl;
            if (this.aQE.user != null) {
                nobleDetailInfo.roleId = this.aQE.user.id;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
            if (this.aQx != null) {
                this.aQx.onClose();
            }
        }
    }

    public void fp(String str) {
        UrlManager.getInstance().dealOneLink(this.mContext, new String[]{str});
    }

    public void release() {
        this.aQx = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aQD != null) {
            this.aQD.release();
        }
        MessageManager.getInstance().unRegisterListener(this.aQz);
        MessageManager.getInstance().unRegisterListener(this.aQA);
        MessageManager.getInstance().unRegisterListener(this.aQB);
        MessageManager.getInstance().unRegisterListener(this.aQC);
    }

    private void k(Intent intent) {
        this.aQv = new com.baidu.live.gift.a.d();
        if (intent != null) {
            this.aQy = intent.getIntExtra("custom_tab_id", 1);
            this.aQv.mUserName = intent.getStringExtra("user_name");
            this.aQv.mUserId = intent.getStringExtra("user_id");
            this.aQv.mLiveId = intent.getStringExtra("live_Id");
            this.aQv.mRoomId = intent.getStringExtra("room_id");
            this.aQv.aNP = intent.getStringExtra("feed_id");
            this.aQv.aNQ = intent.getIntExtra("is_block", 0);
            this.aQv.aNR = intent.getStringExtra(FaceBaseDTO.KEY_BUSINESS_SCENE);
            this.aQv.mAppId = intent.getStringExtra("app_id");
            this.aQv.aNS = intent.getBooleanExtra("can_graffiti", true);
            this.aQv.aMJ = intent.getIntExtra("custom_category_id", -1);
            this.aQv.aMK = intent.getIntExtra("custom_gift_id", -1);
            this.aQv.aKM = intent.getBooleanExtra("new_gift_t_dou_strategy", false);
            this.aQv.aKK = intent.getIntExtra("user_level", -1);
            this.aQv.aMf = intent.getBooleanExtra("isJoinGuardClub", false);
            this.aQv.isNewUser = intent.getBooleanExtra("is_new_user", false);
            this.aQv.aML = intent.getIntExtra("guard_club_join_amount", 1000);
            this.aQv.aMW = intent.getBooleanExtra("is_redpkg_unable", false);
            this.aQv.aNU = intent.getIntExtra(VideoPlayActivityConfig.PAGE_FROM, -1);
            this.aQv.aKT = intent.getBooleanExtra("throne_enabled", false);
            this.aQv.aNW = intent.getBooleanExtra("noble_enabled", false);
            String stringExtra = intent.getStringExtra("bg_info");
            if (!TextUtils.isEmpty(stringExtra)) {
                AlaLiveGiftUIInfo alaLiveGiftUIInfo = new AlaLiveGiftUIInfo();
                alaLiveGiftUIInfo.parserJson(stringExtra);
                this.aQv.aNV = alaLiveGiftUIInfo;
            }
            String stringExtra2 = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.aQv.mOtherParams = stringExtra2;
        }
    }

    private void registerListener() {
        BH();
        BI();
        BJ();
        BK();
    }

    private void BH() {
        this.aQz = new CustomMessageListener(2913097) { // from class: com.baidu.live.gift.panel.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.aQx != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    b.this.aQx.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aQz);
    }

    private void BI() {
        this.aQA = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.gift.panel.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.BM();
            }
        };
        MessageManager.getInstance().registerListener(this.aQA);
    }

    private void BJ() {
        this.aQB = new CustomMessageListener(2913024) { // from class: com.baidu.live.gift.panel.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.aQx != null) {
                    b.this.aQx.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aQB);
    }

    private void BK() {
        this.aQC = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.live.gift.panel.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.BM();
            }
        };
        MessageManager.getInstance().registerListener(this.aQC);
    }

    private void BL() {
        int i;
        f.a aVar = new f.a() { // from class: com.baidu.live.gift.panel.b.6
            @Override // com.baidu.live.gift.panel.f.a
            public l zZ() {
                if (b.this.aQx != null) {
                    return b.this.aQx.zZ();
                }
                return null;
            }
        };
        c cz = c.cz(0);
        cz.setPageContext(this.mContext);
        cz.a(aVar);
        cz.b(this.aQw);
        cz.a(this.aQv);
        c cz2 = c.cz(1);
        cz2.setPageContext(this.mContext);
        cz2.a(aVar);
        cz2.b(this.aQw);
        cz2.a(this.aQv);
        switch (this.aQy) {
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
        if (this.aQx != null) {
            this.aQx.a(i, cz, cz2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BM() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
            httpMessage.addParam("tbs", TbadkCoreApplication.getCurrentTbs());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void BN() {
        CustomResponsedMessage runTask;
        if (BF()) {
            if (this.aQD == null && (runTask = MessageManager.getInstance().runTask(2913198, com.baidu.live.noble.b.a.class, this.mContext.getPageActivity())) != null && runTask.getData() != null) {
                this.aQD = (com.baidu.live.noble.b.a) runTask.getData();
            }
            if (this.aQD != null) {
                this.aQD.a(new a.InterfaceC0173a() { // from class: com.baidu.live.gift.panel.b.7
                    @Override // com.baidu.live.noble.b.a.InterfaceC0173a
                    public void a(NobleUserInfo nobleUserInfo) {
                        b.this.aQE = nobleUserInfo;
                        if (b.this.aQx != null) {
                            b.this.aQx.a(nobleUserInfo != null ? nobleUserInfo.tip : null);
                        }
                    }
                });
                this.aQD.Gc();
            }
        }
    }
}
