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
import com.baidu.live.tbadk.scheme.SchemeUtils;
/* loaded from: classes4.dex */
public class b {
    private a bbA;
    private int bbB;
    private CustomMessageListener bbC;
    private CustomMessageListener bbD;
    private CustomMessageListener bbE;
    private CustomMessageListener bbF;
    private com.baidu.live.noble.b.a bbG;
    private NobleUserInfo bbH;
    private com.baidu.live.r.a bbI;
    private com.baidu.live.gift.a.d bby;
    private AlaGiftTabView.a bbz;
    private TbPageContext mContext;
    private Handler mHandler;

    /* loaded from: classes4.dex */
    public interface a {
        l GY();

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

    public void onResume() {
        if (this.bbI != null) {
            this.bbI.resume();
        }
    }

    public void onPause() {
        if (this.bbI != null) {
            this.bbI.pause();
        }
    }

    public void a(a aVar, AlaGiftTabView.a aVar2) {
        this.bbA = aVar;
        this.bbz = aVar2;
        registerListener();
        this.mHandler = new Handler();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913087));
            }
        }, 300L);
        IM();
        if (this.bbA != null && this.bby != null && this.bby.aYJ != null) {
            this.bbA.a(this.bby.aYJ);
        }
        IN();
        IO();
    }

    public boolean IG() {
        return this.bby != null && this.bby.aYK;
    }

    public void IH() {
        if (this.bbH != null && !TextUtils.isEmpty(this.bbH.detailUrl)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            nobleDetailInfo.url = this.bbH.detailUrl;
            if (this.bbH.user != null) {
                nobleDetailInfo.roleId = this.bbH.user.id;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
            if (this.bbA != null) {
                this.bbA.onClose();
            }
        }
    }

    public void hl(String str) {
        UrlManager.getInstance().dealOneLink(this.mContext, new String[]{str});
    }

    public void q(int i, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        if (!TextUtils.isEmpty(str)) {
            if (this.bby != null) {
                str5 = this.bby.aYC;
                str4 = this.bby.mUserId;
                str3 = this.bby.mRoomId;
                str2 = this.bby.mLiveId;
            } else {
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
            }
            String a2 = com.baidu.live.utils.b.a(i, str, this.bby != null && this.bby.aYB, str5, str4, str3, str2, this.bby != null ? this.bby.aYL : null);
            if (i == 2) {
                this.bbI = new com.baidu.live.r.c(this.mContext.getPageActivity());
                this.bbI.hE(a2);
                return;
            }
            SchemeUtils.openScheme(a2);
        }
    }

    public void release() {
        this.bbA = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bbG != null) {
            this.bbG.release();
        }
        if (this.bbI != null) {
            this.bbI.release();
        }
        MessageManager.getInstance().unRegisterListener(this.bbC);
        MessageManager.getInstance().unRegisterListener(this.bbD);
        MessageManager.getInstance().unRegisterListener(this.bbE);
        MessageManager.getInstance().unRegisterListener(this.bbF);
    }

    private void k(Intent intent) {
        this.bby = new com.baidu.live.gift.a.d();
        if (intent != null) {
            this.bbB = intent.getIntExtra("custom_tab_id", 1);
            this.bby.aYC = intent.getStringExtra("login_user_id");
            this.bby.mUserName = intent.getStringExtra("user_name");
            this.bby.mUserId = intent.getStringExtra("user_id");
            this.bby.mLiveId = intent.getStringExtra("live_Id");
            this.bby.mRoomId = intent.getStringExtra("room_id");
            this.bby.aYD = intent.getStringExtra("feed_id");
            this.bby.aYE = intent.getIntExtra("is_block", 0);
            this.bby.aYF = intent.getStringExtra("scene");
            this.bby.mAppId = intent.getStringExtra("app_id");
            this.bby.aYG = intent.getBooleanExtra("can_graffiti", true);
            this.bby.aXm = intent.getIntExtra("custom_category_id", -1);
            this.bby.aXn = intent.getIntExtra("custom_gift_id", -1);
            this.bby.aVo = intent.getBooleanExtra("new_gift_t_dou_strategy", false);
            this.bby.aVm = intent.getIntExtra("user_level", -1);
            this.bby.aWI = intent.getBooleanExtra("isJoinGuardClub", false);
            this.bby.isNewUser = intent.getBooleanExtra("is_new_user", false);
            this.bby.aXo = intent.getIntExtra("guard_club_join_amount", 1000);
            this.bby.aXz = intent.getBooleanExtra("is_redpkg_unable", false);
            this.bby.aYI = intent.getIntExtra("page_from", -1);
            this.bby.aVu = intent.getBooleanExtra("throne_enabled", false);
            this.bby.aYK = intent.getBooleanExtra("noble_enabled", false);
            this.bby.aYL = intent.getStringExtra("active_params");
            String stringExtra = intent.getStringExtra("bg_info");
            if (!TextUtils.isEmpty(stringExtra)) {
                AlaLiveGiftUIInfo alaLiveGiftUIInfo = new AlaLiveGiftUIInfo();
                alaLiveGiftUIInfo.parserJson(stringExtra);
                this.bby.aYJ = alaLiveGiftUIInfo;
            }
            String stringExtra2 = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.bby.mOtherParams = stringExtra2;
        }
    }

    private void registerListener() {
        II();
        IJ();
        IK();
        IL();
    }

    private void II() {
        this.bbC = new CustomMessageListener(2913097) { // from class: com.baidu.live.gift.panel.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.bbA != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    b.this.bbA.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bbC);
    }

    private void IJ() {
        this.bbD = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.gift.panel.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.IN();
            }
        };
        MessageManager.getInstance().registerListener(this.bbD);
    }

    private void IK() {
        this.bbE = new CustomMessageListener(2913024) { // from class: com.baidu.live.gift.panel.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.bbA != null) {
                    b.this.bbA.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bbE);
    }

    private void IL() {
        this.bbF = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.live.gift.panel.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.IN();
            }
        };
        MessageManager.getInstance().registerListener(this.bbF);
    }

    private void IM() {
        int i;
        f.a aVar = new f.a() { // from class: com.baidu.live.gift.panel.b.6
            @Override // com.baidu.live.gift.panel.f.a
            public l GY() {
                if (b.this.bbA != null) {
                    return b.this.bbA.GY();
                }
                return null;
            }
        };
        c ey = c.ey(0);
        ey.setPageContext(this.mContext);
        ey.a(aVar);
        ey.b(this.bbz);
        ey.a(this.bby);
        c ey2 = c.ey(1);
        ey2.setPageContext(this.mContext);
        ey2.a(aVar);
        ey2.b(this.bbz);
        ey2.a(this.bby);
        switch (this.bbB) {
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
        if (this.bbA != null) {
            this.bbA.a(i, ey, ey2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IN() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
            httpMessage.addParam("tbs", TbadkCoreApplication.getCurrentTbs());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void IO() {
        CustomResponsedMessage runTask;
        if (IG()) {
            if (this.bbG == null && (runTask = MessageManager.getInstance().runTask(2913198, com.baidu.live.noble.b.a.class, this.mContext.getPageActivity())) != null && runTask.getData() != null) {
                this.bbG = (com.baidu.live.noble.b.a) runTask.getData();
            }
            if (this.bbG != null) {
                this.bbG.a(new a.InterfaceC0190a() { // from class: com.baidu.live.gift.panel.b.7
                    @Override // com.baidu.live.noble.b.a.InterfaceC0190a
                    public void a(NobleUserInfo nobleUserInfo) {
                        b.this.bbH = nobleUserInfo;
                        if (b.this.bbA != null) {
                            b.this.bbA.a(nobleUserInfo != null ? nobleUserInfo.tip : null);
                        }
                    }
                });
                this.bbG.Ny();
            }
        }
    }
}
