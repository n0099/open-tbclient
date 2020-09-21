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
    private com.baidu.live.gift.a.d aYe;
    private AlaGiftTabView.a aYf;
    private a aYg;
    private int aYh;
    private CustomMessageListener aYi;
    private CustomMessageListener aYj;
    private CustomMessageListener aYk;
    private CustomMessageListener aYl;
    private com.baidu.live.noble.b.a aYm;
    private NobleUserInfo aYn;
    private com.baidu.live.r.a aYo;
    private TbPageContext mContext;
    private Handler mHandler;

    /* loaded from: classes4.dex */
    public interface a {
        l Gc();

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
        if (this.aYo != null) {
            this.aYo.resume();
        }
    }

    public void onPause() {
        if (this.aYo != null) {
            this.aYo.pause();
        }
    }

    public void a(a aVar, AlaGiftTabView.a aVar2) {
        this.aYg = aVar;
        this.aYf = aVar2;
        registerListener();
        this.mHandler = new Handler();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913087));
            }
        }, 300L);
        HP();
        if (this.aYg != null && this.aYe != null && this.aYe.aVy != null) {
            this.aYg.a(this.aYe.aVy);
        }
        HQ();
        HR();
    }

    public boolean HJ() {
        return this.aYe != null && this.aYe.aVz;
    }

    public void HK() {
        if (this.aYn != null && !TextUtils.isEmpty(this.aYn.detailUrl)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            nobleDetailInfo.url = this.aYn.detailUrl;
            if (this.aYn.user != null) {
                nobleDetailInfo.roleId = this.aYn.user.id;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
            if (this.aYg != null) {
                this.aYg.onClose();
            }
        }
    }

    public void gX(String str) {
        UrlManager.getInstance().dealOneLink(this.mContext, new String[]{str});
    }

    public void o(int i, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        if (!TextUtils.isEmpty(str)) {
            if (this.aYe != null) {
                str5 = this.aYe.aVr;
                str4 = this.aYe.mUserId;
                str3 = this.aYe.mRoomId;
                str2 = this.aYe.mLiveId;
            } else {
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
            }
            String a2 = com.baidu.live.utils.b.a(i, str, this.aYe != null && this.aYe.aVq, str5, str4, str3, str2, this.aYe != null ? this.aYe.aVA : null);
            if (i == 2) {
                this.aYo = new com.baidu.live.r.c(this.mContext.getPageActivity());
                this.aYo.hn(a2);
                return;
            }
            SchemeUtils.openScheme(a2);
        }
    }

    public void release() {
        this.aYg = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aYm != null) {
            this.aYm.release();
        }
        if (this.aYo != null) {
            this.aYo.release();
        }
        MessageManager.getInstance().unRegisterListener(this.aYi);
        MessageManager.getInstance().unRegisterListener(this.aYj);
        MessageManager.getInstance().unRegisterListener(this.aYk);
        MessageManager.getInstance().unRegisterListener(this.aYl);
    }

    private void k(Intent intent) {
        this.aYe = new com.baidu.live.gift.a.d();
        if (intent != null) {
            this.aYh = intent.getIntExtra("custom_tab_id", 1);
            this.aYe.aVr = intent.getStringExtra("login_user_id");
            this.aYe.mUserName = intent.getStringExtra("user_name");
            this.aYe.mUserId = intent.getStringExtra("user_id");
            this.aYe.mLiveId = intent.getStringExtra("live_Id");
            this.aYe.mRoomId = intent.getStringExtra("room_id");
            this.aYe.aVs = intent.getStringExtra("feed_id");
            this.aYe.aVt = intent.getIntExtra("is_block", 0);
            this.aYe.aVu = intent.getStringExtra("scene");
            this.aYe.mAppId = intent.getStringExtra("app_id");
            this.aYe.aVv = intent.getBooleanExtra("can_graffiti", true);
            this.aYe.aUb = intent.getIntExtra("custom_category_id", -1);
            this.aYe.aUc = intent.getIntExtra("custom_gift_id", -1);
            this.aYe.aSd = intent.getBooleanExtra("new_gift_t_dou_strategy", false);
            this.aYe.aSb = intent.getIntExtra("user_level", -1);
            this.aYe.aTx = intent.getBooleanExtra("isJoinGuardClub", false);
            this.aYe.isNewUser = intent.getBooleanExtra("is_new_user", false);
            this.aYe.aUd = intent.getIntExtra("guard_club_join_amount", 1000);
            this.aYe.aUo = intent.getBooleanExtra("is_redpkg_unable", false);
            this.aYe.aVx = intent.getIntExtra("page_from", -1);
            this.aYe.aSj = intent.getBooleanExtra("throne_enabled", false);
            this.aYe.aVz = intent.getBooleanExtra("noble_enabled", false);
            this.aYe.aVA = intent.getStringExtra("active_params");
            String stringExtra = intent.getStringExtra("bg_info");
            if (!TextUtils.isEmpty(stringExtra)) {
                AlaLiveGiftUIInfo alaLiveGiftUIInfo = new AlaLiveGiftUIInfo();
                alaLiveGiftUIInfo.parserJson(stringExtra);
                this.aYe.aVy = alaLiveGiftUIInfo;
            }
            String stringExtra2 = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.aYe.mOtherParams = stringExtra2;
        }
    }

    private void registerListener() {
        HL();
        HM();
        HN();
        HO();
    }

    private void HL() {
        this.aYi = new CustomMessageListener(2913097) { // from class: com.baidu.live.gift.panel.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.aYg != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    b.this.aYg.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aYi);
    }

    private void HM() {
        this.aYj = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.gift.panel.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.HQ();
            }
        };
        MessageManager.getInstance().registerListener(this.aYj);
    }

    private void HN() {
        this.aYk = new CustomMessageListener(2913024) { // from class: com.baidu.live.gift.panel.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.aYg != null) {
                    b.this.aYg.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aYk);
    }

    private void HO() {
        this.aYl = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.live.gift.panel.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.HQ();
            }
        };
        MessageManager.getInstance().registerListener(this.aYl);
    }

    private void HP() {
        int i;
        f.a aVar = new f.a() { // from class: com.baidu.live.gift.panel.b.6
            @Override // com.baidu.live.gift.panel.f.a
            public l Gc() {
                if (b.this.aYg != null) {
                    return b.this.aYg.Gc();
                }
                return null;
            }
        };
        c et = c.et(0);
        et.setPageContext(this.mContext);
        et.a(aVar);
        et.b(this.aYf);
        et.a(this.aYe);
        c et2 = c.et(1);
        et2.setPageContext(this.mContext);
        et2.a(aVar);
        et2.b(this.aYf);
        et2.a(this.aYe);
        switch (this.aYh) {
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
        if (this.aYg != null) {
            this.aYg.a(i, et, et2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HQ() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
            httpMessage.addParam("tbs", TbadkCoreApplication.getCurrentTbs());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void HR() {
        CustomResponsedMessage runTask;
        if (HJ()) {
            if (this.aYm == null && (runTask = MessageManager.getInstance().runTask(2913198, com.baidu.live.noble.b.a.class, this.mContext.getPageActivity())) != null && runTask.getData() != null) {
                this.aYm = (com.baidu.live.noble.b.a) runTask.getData();
            }
            if (this.aYm != null) {
                this.aYm.a(new a.InterfaceC0182a() { // from class: com.baidu.live.gift.panel.b.7
                    @Override // com.baidu.live.noble.b.a.InterfaceC0182a
                    public void a(NobleUserInfo nobleUserInfo) {
                        b.this.aYn = nobleUserInfo;
                        if (b.this.aYg != null) {
                            b.this.aYg.a(nobleUserInfo != null ? nobleUserInfo.tip : null);
                        }
                    }
                });
                this.aYm.Mt();
            }
        }
    }
}
