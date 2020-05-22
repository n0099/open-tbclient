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
/* loaded from: classes3.dex */
public class b {
    private CustomMessageListener aMA;
    private CustomMessageListener aMB;
    private CustomMessageListener aMC;
    private CustomMessageListener aMD;
    private com.baidu.live.noble.b.a aME;
    private NobleUserInfo aMF;
    private com.baidu.live.gift.a.d aMw;
    private AlaGiftTabView.a aMx;
    private a aMy;
    private int aMz;
    private TbPageContext mContext;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, SupportXFragment... supportXFragmentArr);

        void a(AlaLiveGiftUIInfo alaLiveGiftUIInfo);

        void a(NobleUserInfo.a aVar);

        void onClose();

        l yX();
    }

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void init(Intent intent) {
        k(intent);
    }

    public void a(a aVar, AlaGiftTabView.a aVar2) {
        this.aMy = aVar;
        this.aMx = aVar2;
        registerListener();
        this.mHandler = new Handler();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913087));
            }
        }, 300L);
        AJ();
        if (this.aMy != null && this.aMw != null && this.aMw.aJU != null) {
            this.aMy.a(this.aMw.aJU);
        }
        AK();
        AL();
    }

    public boolean AD() {
        return this.aMw != null && this.aMw.aJV;
    }

    public void AE() {
        if (this.aMF != null && !TextUtils.isEmpty(this.aMF.detailUrl)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            nobleDetailInfo.url = this.aMF.detailUrl;
            if (this.aMF.user != null) {
                nobleDetailInfo.roleId = this.aMF.user.id;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
            if (this.aMy != null) {
                this.aMy.onClose();
            }
        }
    }

    public void fk(String str) {
        UrlManager.getInstance().dealOneLink(this.mContext, new String[]{str});
    }

    public void release() {
        this.aMy = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aME != null) {
            this.aME.release();
        }
        MessageManager.getInstance().unRegisterListener(this.aMA);
        MessageManager.getInstance().unRegisterListener(this.aMB);
        MessageManager.getInstance().unRegisterListener(this.aMC);
        MessageManager.getInstance().unRegisterListener(this.aMD);
    }

    private void k(Intent intent) {
        this.aMw = new com.baidu.live.gift.a.d();
        if (intent != null) {
            this.aMz = intent.getIntExtra("custom_tab_id", 1);
            this.aMw.mUserName = intent.getStringExtra("user_name");
            this.aMw.mUserId = intent.getStringExtra("user_id");
            this.aMw.mLiveId = intent.getStringExtra("live_Id");
            this.aMw.mRoomId = intent.getStringExtra("room_id");
            this.aMw.aJO = intent.getStringExtra("feed_id");
            this.aMw.aJP = intent.getIntExtra("is_block", 0);
            this.aMw.aJQ = intent.getStringExtra(FaceBaseDTO.KEY_BUSINESS_SCENE);
            this.aMw.mAppId = intent.getStringExtra("app_id");
            this.aMw.aJR = intent.getBooleanExtra("can_graffiti", true);
            this.aMw.aIJ = intent.getIntExtra("custom_category_id", -1);
            this.aMw.aIK = intent.getIntExtra("custom_gift_id", -1);
            this.aMw.aGS = intent.getBooleanExtra("new_gift_t_dou_strategy", false);
            this.aMw.aGQ = intent.getIntExtra("user_level", -1);
            this.aMw.aIf = intent.getBooleanExtra("isJoinGuardClub", false);
            this.aMw.isNewUser = intent.getBooleanExtra("is_new_user", false);
            this.aMw.aIL = intent.getIntExtra("guard_club_join_amount", 1000);
            this.aMw.aIU = intent.getBooleanExtra("is_redpkg_unable", false);
            this.aMw.aJT = intent.getIntExtra(VideoPlayActivityConfig.PAGE_FROM, -1);
            this.aMw.aGZ = intent.getBooleanExtra("throne_enabled", false);
            this.aMw.aJV = intent.getBooleanExtra("noble_enabled", false);
            String stringExtra = intent.getStringExtra("bg_info");
            if (!TextUtils.isEmpty(stringExtra)) {
                AlaLiveGiftUIInfo alaLiveGiftUIInfo = new AlaLiveGiftUIInfo();
                alaLiveGiftUIInfo.parserJson(stringExtra);
                this.aMw.aJU = alaLiveGiftUIInfo;
            }
            String stringExtra2 = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.aMw.mOtherParams = stringExtra2;
        }
    }

    private void registerListener() {
        AF();
        AG();
        AH();
        AI();
    }

    private void AF() {
        this.aMA = new CustomMessageListener(2913097) { // from class: com.baidu.live.gift.panel.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.aMy != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    b.this.aMy.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aMA);
    }

    private void AG() {
        this.aMB = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.gift.panel.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.AK();
            }
        };
        MessageManager.getInstance().registerListener(this.aMB);
    }

    private void AH() {
        this.aMC = new CustomMessageListener(2913024) { // from class: com.baidu.live.gift.panel.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.aMy != null) {
                    b.this.aMy.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aMC);
    }

    private void AI() {
        this.aMD = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.live.gift.panel.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.AK();
            }
        };
        MessageManager.getInstance().registerListener(this.aMD);
    }

    private void AJ() {
        int i;
        f.a aVar = new f.a() { // from class: com.baidu.live.gift.panel.b.6
            @Override // com.baidu.live.gift.panel.f.a
            public l yX() {
                if (b.this.aMy != null) {
                    return b.this.aMy.yX();
                }
                return null;
            }
        };
        c cl = c.cl(0);
        cl.setPageContext(this.mContext);
        cl.a(aVar);
        cl.b(this.aMx);
        cl.a(this.aMw);
        c cl2 = c.cl(1);
        cl2.setPageContext(this.mContext);
        cl2.a(aVar);
        cl2.b(this.aMx);
        cl2.a(this.aMw);
        switch (this.aMz) {
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
        if (this.aMy != null) {
            this.aMy.a(i, cl, cl2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AK() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
            httpMessage.addParam("tbs", TbadkCoreApplication.getCurrentTbs());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void AL() {
        CustomResponsedMessage runTask;
        if (AD()) {
            if (this.aME == null && (runTask = MessageManager.getInstance().runTask(2913198, com.baidu.live.noble.b.a.class, this.mContext.getPageActivity())) != null && runTask.getData() != null) {
                this.aME = (com.baidu.live.noble.b.a) runTask.getData();
            }
            if (this.aME != null) {
                this.aME.a(new a.InterfaceC0171a() { // from class: com.baidu.live.gift.panel.b.7
                    @Override // com.baidu.live.noble.b.a.InterfaceC0171a
                    public void a(NobleUserInfo nobleUserInfo) {
                        b.this.aMF = nobleUserInfo;
                        if (b.this.aMy != null) {
                            b.this.aMy.a(nobleUserInfo != null ? nobleUserInfo.tip : null);
                        }
                    }
                });
                this.aME.Fz();
            }
        }
    }
}
