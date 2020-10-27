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
    private com.baidu.live.gift.a.d bcM;
    private AlaGiftTabView.a bcN;
    private a bcO;
    private int bcP;
    private CustomMessageListener bcQ;
    private CustomMessageListener bcR;
    private CustomMessageListener bcS;
    private CustomMessageListener bcT;
    private com.baidu.live.noble.b.a bcU;
    private NobleUserInfo bcV;
    private com.baidu.live.s.a bcW;
    private TbPageContext mContext;
    private Handler mHandler;

    /* loaded from: classes4.dex */
    public interface a {
        l Hu();

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
        if (this.bcW != null) {
            this.bcW.resume();
        }
    }

    public void onPause() {
        if (this.bcW != null) {
            this.bcW.pause();
        }
    }

    public void a(a aVar, AlaGiftTabView.a aVar2) {
        this.bcO = aVar;
        this.bcN = aVar2;
        registerListener();
        this.mHandler = new Handler();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913087));
            }
        }, 300L);
        Jf();
        if (this.bcO != null && this.bcM != null && this.bcM.bag != null) {
            this.bcO.a(this.bcM.bag);
        }
        Jg();
        Jh();
    }

    public boolean IZ() {
        return this.bcM != null && this.bcM.bah;
    }

    public void Ja() {
        if (this.bcV != null && !TextUtils.isEmpty(this.bcV.detailUrl)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            nobleDetailInfo.url = this.bcV.detailUrl;
            if (this.bcV.user != null) {
                nobleDetailInfo.roleId = this.bcV.user.id;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
            if (this.bcO != null) {
                this.bcO.onClose();
            }
        }
    }

    public void ht(String str) {
        UrlManager.getInstance().dealOneLink(this.mContext, new String[]{str});
    }

    public void q(int i, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        if (!TextUtils.isEmpty(str)) {
            if (this.bcM != null) {
                str5 = this.bcM.aZZ;
                str4 = this.bcM.mUserId;
                str3 = this.bcM.mRoomId;
                str2 = this.bcM.mLiveId;
            } else {
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
            }
            String a2 = com.baidu.live.utils.b.a(i, str, this.bcM != null && this.bcM.aRP, str5, str4, str3, str2, this.bcM != null ? this.bcM.bai : null);
            if (i == 2) {
                this.bcW = new com.baidu.live.s.c(this.mContext.getPageActivity());
                this.bcW.hM(a2);
                return;
            }
            SchemeUtils.openScheme(a2);
        }
    }

    public void release() {
        this.bcO = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bcU != null) {
            this.bcU.release();
        }
        if (this.bcW != null) {
            this.bcW.release();
        }
        MessageManager.getInstance().unRegisterListener(this.bcQ);
        MessageManager.getInstance().unRegisterListener(this.bcR);
        MessageManager.getInstance().unRegisterListener(this.bcS);
        MessageManager.getInstance().unRegisterListener(this.bcT);
    }

    private void k(Intent intent) {
        this.bcM = new com.baidu.live.gift.a.d();
        if (intent != null) {
            this.bcP = intent.getIntExtra("custom_tab_id", 1);
            this.bcM.aZZ = intent.getStringExtra("login_user_id");
            this.bcM.mUserName = intent.getStringExtra("user_name");
            this.bcM.mUserId = intent.getStringExtra("user_id");
            this.bcM.mLiveId = intent.getStringExtra("live_Id");
            this.bcM.mRoomId = intent.getStringExtra("room_id");
            this.bcM.baa = intent.getStringExtra("feed_id");
            this.bcM.bab = intent.getIntExtra("is_block", 0);
            this.bcM.bac = intent.getStringExtra("scene");
            this.bcM.mAppId = intent.getStringExtra("app_id");
            this.bcM.bad = intent.getBooleanExtra("can_graffiti", true);
            this.bcM.aYH = intent.getIntExtra("custom_category_id", -1);
            this.bcM.aYI = intent.getIntExtra("custom_gift_id", -1);
            this.bcM.aWJ = intent.getBooleanExtra("new_gift_t_dou_strategy", false);
            this.bcM.aWH = intent.getIntExtra("user_level", -1);
            this.bcM.aYd = intent.getBooleanExtra("isJoinGuardClub", false);
            this.bcM.isNewUser = intent.getBooleanExtra("is_new_user", false);
            this.bcM.aYJ = intent.getIntExtra("guard_club_join_amount", 1000);
            this.bcM.aYU = intent.getBooleanExtra("is_redpkg_unable", false);
            this.bcM.baf = intent.getIntExtra("page_from", -1);
            this.bcM.aWP = intent.getBooleanExtra("throne_enabled", false);
            this.bcM.bah = intent.getBooleanExtra("noble_enabled", false);
            this.bcM.bai = intent.getStringExtra("active_params");
            String stringExtra = intent.getStringExtra("bg_info");
            if (!TextUtils.isEmpty(stringExtra)) {
                AlaLiveGiftUIInfo alaLiveGiftUIInfo = new AlaLiveGiftUIInfo();
                alaLiveGiftUIInfo.parserJson(stringExtra);
                this.bcM.bag = alaLiveGiftUIInfo;
            }
            String stringExtra2 = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.bcM.mOtherParams = stringExtra2;
        }
    }

    private void registerListener() {
        Jb();
        Jc();
        Jd();
        Je();
    }

    private void Jb() {
        this.bcQ = new CustomMessageListener(2913097) { // from class: com.baidu.live.gift.panel.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.bcO != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    b.this.bcO.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bcQ);
    }

    private void Jc() {
        this.bcR = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.gift.panel.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.Jg();
            }
        };
        MessageManager.getInstance().registerListener(this.bcR);
    }

    private void Jd() {
        this.bcS = new CustomMessageListener(2913024) { // from class: com.baidu.live.gift.panel.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.bcO != null) {
                    b.this.bcO.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bcS);
    }

    private void Je() {
        this.bcT = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.live.gift.panel.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.Jg();
            }
        };
        MessageManager.getInstance().registerListener(this.bcT);
    }

    private void Jf() {
        int i;
        f.a aVar = new f.a() { // from class: com.baidu.live.gift.panel.b.6
            @Override // com.baidu.live.gift.panel.f.a
            public l Hu() {
                if (b.this.bcO != null) {
                    return b.this.bcO.Hu();
                }
                return null;
            }
        };
        c ez = c.ez(0);
        ez.setPageContext(this.mContext);
        ez.a(aVar);
        ez.b(this.bcN);
        ez.a(this.bcM);
        c ez2 = c.ez(1);
        ez2.setPageContext(this.mContext);
        ez2.a(aVar);
        ez2.b(this.bcN);
        ez2.a(this.bcM);
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
        if (this.bcO != null) {
            this.bcO.a(i, ez, ez2);
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
            if (this.bcU == null && (runTask = MessageManager.getInstance().runTask(2913198, com.baidu.live.noble.b.a.class, this.mContext.getPageActivity())) != null && runTask.getData() != null) {
                this.bcU = (com.baidu.live.noble.b.a) runTask.getData();
            }
            if (this.bcU != null) {
                this.bcU.a(new a.InterfaceC0191a() { // from class: com.baidu.live.gift.panel.b.7
                    @Override // com.baidu.live.noble.b.a.InterfaceC0191a
                    public void a(NobleUserInfo nobleUserInfo) {
                        b.this.bcV = nobleUserInfo;
                        if (b.this.bcO != null) {
                            b.this.bcO.a(nobleUserInfo != null ? nobleUserInfo.tip : null);
                        }
                    }
                });
                this.bcU.NW();
            }
        }
    }
}
