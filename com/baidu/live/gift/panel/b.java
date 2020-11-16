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
    private CustomMessageListener bcA;
    private CustomMessageListener bcB;
    private com.baidu.live.noble.b.a bcC;
    private NobleUserInfo bcD;
    private com.baidu.live.t.a bcE;
    private com.baidu.live.gift.a.d bcu;
    private AlaGiftTabView.a bcv;
    private a bcw;
    private int bcx;
    private CustomMessageListener bcy;
    private CustomMessageListener bcz;
    private TbPageContext mContext;
    private Handler mHandler;

    /* loaded from: classes4.dex */
    public interface a {
        k Hm();

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
        if (this.bcE != null) {
            this.bcE.resume();
        }
    }

    public void onPause() {
        if (this.bcE != null) {
            this.bcE.pause();
        }
    }

    public void a(a aVar, AlaGiftTabView.a aVar2) {
        this.bcw = aVar;
        this.bcv = aVar2;
        registerListener();
        this.mHandler = new Handler();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913087));
            }
        }, 300L);
        IX();
        if (this.bcw != null && this.bcu != null && this.bcu.aZN != null) {
            this.bcw.a(this.bcu.aZN);
        }
        IY();
        IZ();
    }

    public boolean IR() {
        return this.bcu != null && this.bcu.aZO;
    }

    public void IS() {
        if (this.bcD != null && !TextUtils.isEmpty(this.bcD.detailUrl)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            nobleDetailInfo.url = this.bcD.detailUrl;
            if (this.bcD.user != null) {
                nobleDetailInfo.roleId = this.bcD.user.id;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
            if (this.bcw != null) {
                this.bcw.onClose();
            }
        }
    }

    public void hu(String str) {
        UrlManager.getInstance().dealOneLink(this.mContext, new String[]{str});
    }

    public void q(int i, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        if (!TextUtils.isEmpty(str)) {
            if (this.bcu != null) {
                str5 = this.bcu.aZG;
                str4 = this.bcu.mUserId;
                str3 = this.bcu.mRoomId;
                str2 = this.bcu.mLiveId;
            } else {
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
            }
            String a2 = com.baidu.live.utils.b.a(i, str, this.bcu != null && this.bcu.aRw, str5, str4, str3, str2, this.bcu != null ? this.bcu.aZP : null);
            if (i == 2) {
                this.bcE = new com.baidu.live.t.c(this.mContext.getPageActivity());
                this.bcE.hN(a2);
                return;
            }
            SchemeUtils.openScheme(a2);
        }
    }

    public void release() {
        this.bcw = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bcC != null) {
            this.bcC.release();
        }
        if (this.bcE != null) {
            this.bcE.release();
        }
        MessageManager.getInstance().unRegisterListener(this.bcy);
        MessageManager.getInstance().unRegisterListener(this.bcz);
        MessageManager.getInstance().unRegisterListener(this.bcA);
        MessageManager.getInstance().unRegisterListener(this.bcB);
    }

    private void k(Intent intent) {
        this.bcu = new com.baidu.live.gift.a.d();
        if (intent != null) {
            this.bcx = intent.getIntExtra("custom_tab_id", 1);
            this.bcu.aZG = intent.getStringExtra("login_user_id");
            this.bcu.mUserName = intent.getStringExtra("user_name");
            this.bcu.mUserId = intent.getStringExtra("user_id");
            this.bcu.mLiveId = intent.getStringExtra("live_Id");
            this.bcu.mRoomId = intent.getStringExtra("room_id");
            this.bcu.aZH = intent.getStringExtra("feed_id");
            this.bcu.aZI = intent.getIntExtra("is_block", 0);
            this.bcu.aZJ = intent.getStringExtra("scene");
            this.bcu.mAppId = intent.getStringExtra("app_id");
            this.bcu.aZK = intent.getBooleanExtra("can_graffiti", true);
            this.bcu.aYo = intent.getIntExtra("custom_category_id", -1);
            this.bcu.aYp = intent.getIntExtra("custom_gift_id", -1);
            this.bcu.aWq = intent.getBooleanExtra("new_gift_t_dou_strategy", false);
            this.bcu.aWo = intent.getIntExtra("user_level", -1);
            this.bcu.aXK = intent.getBooleanExtra("isJoinGuardClub", false);
            this.bcu.isNewUser = intent.getBooleanExtra("is_new_user", false);
            this.bcu.aYq = intent.getIntExtra("guard_club_join_amount", 1000);
            this.bcu.aYB = intent.getBooleanExtra("is_redpkg_unable", false);
            this.bcu.aZM = intent.getIntExtra("page_from", -1);
            this.bcu.aWw = intent.getBooleanExtra("throne_enabled", false);
            this.bcu.aZO = intent.getBooleanExtra("noble_enabled", false);
            this.bcu.aZP = intent.getStringExtra("active_params");
            String stringExtra = intent.getStringExtra("bg_info");
            if (!TextUtils.isEmpty(stringExtra)) {
                AlaLiveGiftUIInfo alaLiveGiftUIInfo = new AlaLiveGiftUIInfo();
                alaLiveGiftUIInfo.parserJson(stringExtra);
                this.bcu.aZN = alaLiveGiftUIInfo;
            }
            String stringExtra2 = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.bcu.mOtherParams = stringExtra2;
        }
    }

    private void registerListener() {
        IT();
        IU();
        IV();
        IW();
    }

    private void IT() {
        this.bcy = new CustomMessageListener(2913097) { // from class: com.baidu.live.gift.panel.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.bcw != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    b.this.bcw.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bcy);
    }

    private void IU() {
        this.bcz = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.gift.panel.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.IY();
            }
        };
        MessageManager.getInstance().registerListener(this.bcz);
    }

    private void IV() {
        this.bcA = new CustomMessageListener(2913024) { // from class: com.baidu.live.gift.panel.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.bcw != null) {
                    b.this.bcw.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bcA);
    }

    private void IW() {
        this.bcB = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.live.gift.panel.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.IY();
            }
        };
        MessageManager.getInstance().registerListener(this.bcB);
    }

    private void IX() {
        int i;
        f.a aVar = new f.a() { // from class: com.baidu.live.gift.panel.b.6
            @Override // com.baidu.live.gift.panel.f.a
            public k Hm() {
                if (b.this.bcw != null) {
                    return b.this.bcw.Hm();
                }
                return null;
            }
        };
        c ev = c.ev(0);
        ev.setPageContext(this.mContext);
        ev.a(aVar);
        ev.b(this.bcv);
        ev.a(this.bcu);
        c ev2 = c.ev(1);
        ev2.setPageContext(this.mContext);
        ev2.a(aVar);
        ev2.b(this.bcv);
        ev2.a(this.bcu);
        switch (this.bcx) {
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
        if (this.bcw != null) {
            this.bcw.a(i, ev, ev2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IY() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
            httpMessage.addParam("tbs", TbadkCoreApplication.getCurrentTbs());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void IZ() {
        CustomResponsedMessage runTask;
        if (IR()) {
            if (this.bcC == null && (runTask = MessageManager.getInstance().runTask(2913198, com.baidu.live.noble.b.a.class, this.mContext.getPageActivity())) != null && runTask.getData() != null) {
                this.bcC = (com.baidu.live.noble.b.a) runTask.getData();
            }
            if (this.bcC != null) {
                this.bcC.a(new a.InterfaceC0191a() { // from class: com.baidu.live.gift.panel.b.7
                    @Override // com.baidu.live.noble.b.a.InterfaceC0191a
                    public void a(NobleUserInfo nobleUserInfo) {
                        b.this.bcD = nobleUserInfo;
                        if (b.this.bcw != null) {
                            b.this.bcw.a(nobleUserInfo != null ? nobleUserInfo.tip : null);
                        }
                    }
                });
                this.bcC.NN();
            }
        }
    }
}
