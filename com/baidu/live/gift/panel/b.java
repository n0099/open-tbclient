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
    private com.baidu.live.gift.a.d aPc;
    private AlaGiftTabView.a aPd;
    private a aPe;
    private int aPf;
    private CustomMessageListener aPg;
    private CustomMessageListener aPh;
    private CustomMessageListener aPi;
    private CustomMessageListener aPj;
    private com.baidu.live.noble.b.a aPk;
    private NobleUserInfo aPl;
    private TbPageContext mContext;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, SupportXFragment... supportXFragmentArr);

        void a(AlaLiveGiftUIInfo alaLiveGiftUIInfo);

        void a(NobleUserInfo.a aVar);

        void onClose();

        l zx();
    }

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void init(Intent intent) {
        k(intent);
    }

    public void a(a aVar, AlaGiftTabView.a aVar2) {
        this.aPe = aVar;
        this.aPd = aVar2;
        registerListener();
        this.mHandler = new Handler();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913087));
            }
        }, 300L);
        Bj();
        if (this.aPe != null && this.aPc != null && this.aPc.aMA != null) {
            this.aPe.a(this.aPc.aMA);
        }
        Bk();
        Bl();
    }

    public boolean Bd() {
        return this.aPc != null && this.aPc.aMB;
    }

    public void Be() {
        if (this.aPl != null && !TextUtils.isEmpty(this.aPl.detailUrl)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            nobleDetailInfo.url = this.aPl.detailUrl;
            if (this.aPl.user != null) {
                nobleDetailInfo.roleId = this.aPl.user.id;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
            if (this.aPe != null) {
                this.aPe.onClose();
            }
        }
    }

    public void fq(String str) {
        UrlManager.getInstance().dealOneLink(this.mContext, new String[]{str});
    }

    public void release() {
        this.aPe = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aPk != null) {
            this.aPk.release();
        }
        MessageManager.getInstance().unRegisterListener(this.aPg);
        MessageManager.getInstance().unRegisterListener(this.aPh);
        MessageManager.getInstance().unRegisterListener(this.aPi);
        MessageManager.getInstance().unRegisterListener(this.aPj);
    }

    private void k(Intent intent) {
        this.aPc = new com.baidu.live.gift.a.d();
        if (intent != null) {
            this.aPf = intent.getIntExtra("custom_tab_id", 1);
            this.aPc.mUserName = intent.getStringExtra("user_name");
            this.aPc.mUserId = intent.getStringExtra("user_id");
            this.aPc.mLiveId = intent.getStringExtra("live_Id");
            this.aPc.mRoomId = intent.getStringExtra("room_id");
            this.aPc.aMu = intent.getStringExtra("feed_id");
            this.aPc.aMv = intent.getIntExtra("is_block", 0);
            this.aPc.aMw = intent.getStringExtra(FaceBaseDTO.KEY_BUSINESS_SCENE);
            this.aPc.mAppId = intent.getStringExtra("app_id");
            this.aPc.aMx = intent.getBooleanExtra("can_graffiti", true);
            this.aPc.aLn = intent.getIntExtra("custom_category_id", -1);
            this.aPc.aLo = intent.getIntExtra("custom_gift_id", -1);
            this.aPc.aJq = intent.getBooleanExtra("new_gift_t_dou_strategy", false);
            this.aPc.aJo = intent.getIntExtra("user_level", -1);
            this.aPc.aKJ = intent.getBooleanExtra("isJoinGuardClub", false);
            this.aPc.isNewUser = intent.getBooleanExtra("is_new_user", false);
            this.aPc.aLp = intent.getIntExtra("guard_club_join_amount", 1000);
            this.aPc.aLA = intent.getBooleanExtra("is_redpkg_unable", false);
            this.aPc.aMz = intent.getIntExtra(VideoPlayActivityConfig.PAGE_FROM, -1);
            this.aPc.aJx = intent.getBooleanExtra("throne_enabled", false);
            this.aPc.aMB = intent.getBooleanExtra("noble_enabled", false);
            String stringExtra = intent.getStringExtra("bg_info");
            if (!TextUtils.isEmpty(stringExtra)) {
                AlaLiveGiftUIInfo alaLiveGiftUIInfo = new AlaLiveGiftUIInfo();
                alaLiveGiftUIInfo.parserJson(stringExtra);
                this.aPc.aMA = alaLiveGiftUIInfo;
            }
            String stringExtra2 = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.aPc.mOtherParams = stringExtra2;
        }
    }

    private void registerListener() {
        Bf();
        Bg();
        Bh();
        Bi();
    }

    private void Bf() {
        this.aPg = new CustomMessageListener(2913097) { // from class: com.baidu.live.gift.panel.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.aPe != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    b.this.aPe.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aPg);
    }

    private void Bg() {
        this.aPh = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.gift.panel.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.Bk();
            }
        };
        MessageManager.getInstance().registerListener(this.aPh);
    }

    private void Bh() {
        this.aPi = new CustomMessageListener(2913024) { // from class: com.baidu.live.gift.panel.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.aPe != null) {
                    b.this.aPe.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aPi);
    }

    private void Bi() {
        this.aPj = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.live.gift.panel.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.Bk();
            }
        };
        MessageManager.getInstance().registerListener(this.aPj);
    }

    private void Bj() {
        int i;
        f.a aVar = new f.a() { // from class: com.baidu.live.gift.panel.b.6
            @Override // com.baidu.live.gift.panel.f.a
            public l zx() {
                if (b.this.aPe != null) {
                    return b.this.aPe.zx();
                }
                return null;
            }
        };
        c ct = c.ct(0);
        ct.setPageContext(this.mContext);
        ct.a(aVar);
        ct.b(this.aPd);
        ct.a(this.aPc);
        c ct2 = c.ct(1);
        ct2.setPageContext(this.mContext);
        ct2.a(aVar);
        ct2.b(this.aPd);
        ct2.a(this.aPc);
        switch (this.aPf) {
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
        if (this.aPe != null) {
            this.aPe.a(i, ct, ct2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bk() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
            httpMessage.addParam("tbs", TbadkCoreApplication.getCurrentTbs());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void Bl() {
        CustomResponsedMessage runTask;
        if (Bd()) {
            if (this.aPk == null && (runTask = MessageManager.getInstance().runTask(2913198, com.baidu.live.noble.b.a.class, this.mContext.getPageActivity())) != null && runTask.getData() != null) {
                this.aPk = (com.baidu.live.noble.b.a) runTask.getData();
            }
            if (this.aPk != null) {
                this.aPk.a(new a.InterfaceC0173a() { // from class: com.baidu.live.gift.panel.b.7
                    @Override // com.baidu.live.noble.b.a.InterfaceC0173a
                    public void a(NobleUserInfo nobleUserInfo) {
                        b.this.aPl = nobleUserInfo;
                        if (b.this.aPe != null) {
                            b.this.aPe.a(nobleUserInfo != null ? nobleUserInfo.tip : null);
                        }
                    }
                });
                this.aPk.Gi();
            }
        }
    }
}
