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
import com.baidu.live.gift.k;
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
    private com.baidu.live.gift.a.d bef;
    private AlaGiftTabView.a beh;
    private a bei;
    private int bej;
    private CustomMessageListener bek;
    private CustomMessageListener bel;
    private CustomMessageListener bem;
    private CustomMessageListener ben;
    private com.baidu.live.noble.b.a beo;
    private NobleUserInfo bep;
    private com.baidu.live.t.a beq;
    private TbPageContext mContext;
    private Handler mHandler;

    /* loaded from: classes4.dex */
    public interface a {
        k HV();

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
        if (this.beq != null) {
            this.beq.resume();
        }
    }

    public void onPause() {
        if (this.beq != null) {
            this.beq.pause();
        }
    }

    public void a(a aVar, AlaGiftTabView.a aVar2) {
        this.bei = aVar;
        this.beh = aVar2;
        registerListener();
        this.mHandler = new Handler();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913087));
            }
        }, 300L);
        JG();
        if (this.bei != null && this.bef != null && this.bef.bbz != null) {
            this.bei.a(this.bef.bbz);
        }
        JH();
        JI();
    }

    public boolean JA() {
        return this.bef != null && this.bef.bbA;
    }

    public void JB() {
        if (this.bep != null && !TextUtils.isEmpty(this.bep.detailUrl)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            nobleDetailInfo.url = this.bep.detailUrl;
            if (this.bep.user != null) {
                nobleDetailInfo.roleId = this.bep.user.id;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
            if (this.bei != null) {
                this.bei.onClose();
            }
        }
    }

    public void hA(String str) {
        UrlManager.getInstance().dealOneLink(this.mContext, new String[]{str});
    }

    public void q(int i, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        if (!TextUtils.isEmpty(str)) {
            if (this.bef != null) {
                str5 = this.bef.bbs;
                str4 = this.bef.mUserId;
                str3 = this.bef.mRoomId;
                str2 = this.bef.mLiveId;
            } else {
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
            }
            String a2 = com.baidu.live.utils.b.a(i, str, this.bef != null && this.bef.aTh, str5, str4, str3, str2, this.bef != null ? this.bef.bbB : null);
            if (i == 2) {
                this.beq = new com.baidu.live.t.c(this.mContext.getPageActivity());
                this.beq.hT(a2);
                return;
            }
            SchemeUtils.openScheme(a2);
        }
    }

    public void release() {
        this.bei = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.beo != null) {
            this.beo.release();
        }
        if (this.beq != null) {
            this.beq.release();
        }
        MessageManager.getInstance().unRegisterListener(this.bek);
        MessageManager.getInstance().unRegisterListener(this.bel);
        MessageManager.getInstance().unRegisterListener(this.bem);
        MessageManager.getInstance().unRegisterListener(this.ben);
    }

    private void k(Intent intent) {
        this.bef = new com.baidu.live.gift.a.d();
        if (intent != null) {
            this.bej = intent.getIntExtra("custom_tab_id", 1);
            this.bef.bbs = intent.getStringExtra("login_user_id");
            this.bef.mUserName = intent.getStringExtra("user_name");
            this.bef.mUserId = intent.getStringExtra("user_id");
            this.bef.mLiveId = intent.getStringExtra("live_Id");
            this.bef.mRoomId = intent.getStringExtra("room_id");
            this.bef.bbt = intent.getStringExtra("feed_id");
            this.bef.bbu = intent.getIntExtra("is_block", 0);
            this.bef.bbv = intent.getStringExtra("scene");
            this.bef.mAppId = intent.getStringExtra("app_id");
            this.bef.bbw = intent.getBooleanExtra("can_graffiti", true);
            this.bef.aZZ = intent.getIntExtra("custom_category_id", -1);
            this.bef.baa = intent.getIntExtra("custom_gift_id", -1);
            this.bef.aYb = intent.getBooleanExtra("new_gift_t_dou_strategy", false);
            this.bef.aXZ = intent.getIntExtra("user_level", -1);
            this.bef.aZv = intent.getBooleanExtra("isJoinGuardClub", false);
            this.bef.isNewUser = intent.getBooleanExtra("is_new_user", false);
            this.bef.bab = intent.getIntExtra("guard_club_join_amount", 1000);
            this.bef.bam = intent.getBooleanExtra("is_redpkg_unable", false);
            this.bef.bby = intent.getIntExtra("page_from", -1);
            this.bef.aYh = intent.getBooleanExtra("throne_enabled", false);
            this.bef.bbA = intent.getBooleanExtra("noble_enabled", false);
            this.bef.bbB = intent.getStringExtra("active_params");
            String stringExtra = intent.getStringExtra("bg_info");
            if (!TextUtils.isEmpty(stringExtra)) {
                AlaLiveGiftUIInfo alaLiveGiftUIInfo = new AlaLiveGiftUIInfo();
                alaLiveGiftUIInfo.parserJson(stringExtra);
                this.bef.bbz = alaLiveGiftUIInfo;
            }
            String stringExtra2 = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.bef.mOtherParams = stringExtra2;
        }
    }

    private void registerListener() {
        JC();
        JD();
        JE();
        JF();
    }

    private void JC() {
        this.bek = new CustomMessageListener(2913097) { // from class: com.baidu.live.gift.panel.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.bei != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    b.this.bei.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bek);
    }

    private void JD() {
        this.bel = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.gift.panel.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.JH();
            }
        };
        MessageManager.getInstance().registerListener(this.bel);
    }

    private void JE() {
        this.bem = new CustomMessageListener(2913024) { // from class: com.baidu.live.gift.panel.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.bei != null) {
                    b.this.bei.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bem);
    }

    private void JF() {
        this.ben = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.live.gift.panel.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.JH();
            }
        };
        MessageManager.getInstance().registerListener(this.ben);
    }

    private void JG() {
        int i;
        f.a aVar = new f.a() { // from class: com.baidu.live.gift.panel.b.6
            @Override // com.baidu.live.gift.panel.f.a
            public k HV() {
                if (b.this.bei != null) {
                    return b.this.bei.HV();
                }
                return null;
            }
        };
        c ez = c.ez(0);
        ez.setPageContext(this.mContext);
        ez.a(aVar);
        ez.b(this.beh);
        ez.a(this.bef);
        c ez2 = c.ez(1);
        ez2.setPageContext(this.mContext);
        ez2.a(aVar);
        ez2.b(this.beh);
        ez2.a(this.bef);
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
        if (this.bei != null) {
            this.bei.a(i, ez, ez2);
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
            if (this.beo == null && (runTask = MessageManager.getInstance().runTask(2913198, com.baidu.live.noble.b.a.class, this.mContext.getPageActivity())) != null && runTask.getData() != null) {
                this.beo = (com.baidu.live.noble.b.a) runTask.getData();
            }
            if (this.beo != null) {
                this.beo.a(new a.InterfaceC0193a() { // from class: com.baidu.live.gift.panel.b.7
                    @Override // com.baidu.live.noble.b.a.InterfaceC0193a
                    public void a(NobleUserInfo nobleUserInfo) {
                        b.this.bep = nobleUserInfo;
                        if (b.this.bei != null) {
                            b.this.bei.a(nobleUserInfo != null ? nobleUserInfo.tip : null);
                        }
                    }
                });
                this.beo.Ow();
            }
        }
    }
}
