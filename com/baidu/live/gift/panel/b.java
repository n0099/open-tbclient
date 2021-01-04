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
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.scheme.SchemeUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes11.dex */
public class b {
    private int bcr;
    private AlaGiftTabView.a bgp;
    private com.baidu.live.gift.a.e bie;
    private a bif;
    private CustomMessageListener bih;
    private CustomMessageListener bii;
    private CustomMessageListener bij;
    private CustomMessageListener bik;
    private com.baidu.live.noble.b.a bil;
    private NobleUserInfo bim;
    private com.baidu.live.x.a bin;
    private TbPageContext mContext;
    private Handler mHandler;

    /* loaded from: classes11.dex */
    public interface a {
        k IF();

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
        if (this.bin != null) {
            this.bin.resume();
        }
    }

    public void onPause() {
        if (this.bin != null) {
            this.bin.pause();
        }
    }

    public void a(a aVar, AlaGiftTabView.a aVar2) {
        this.bif = aVar;
        this.bgp = aVar2;
        registerListener();
        this.mHandler = new Handler();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913087));
            }
        }, 300L);
        Ky();
        if (this.bif != null && this.bie != null && this.bie.beY != null) {
            this.bif.a(this.bie.beY);
        }
        Kz();
        KA();
    }

    public boolean Ks() {
        return this.bie != null && this.bie.beZ;
    }

    public void Kt() {
        if (this.bim != null && !TextUtils.isEmpty(this.bim.detailUrl)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            nobleDetailInfo.url = this.bim.detailUrl;
            if (this.bim.user != null) {
                nobleDetailInfo.roleId = this.bim.user.id;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
            if (this.bif != null) {
                this.bif.onClose();
            }
        }
    }

    public void hD(String str) {
        UrlManager.getInstance().dealOneLink(this.mContext, new String[]{str});
    }

    public void q(int i, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        if (!TextUtils.isEmpty(str)) {
            if (this.bie != null) {
                if (i == 2) {
                    str6 = ExtraParamsManager.getEncryptionUserId(this.bie.beR);
                    str7 = ExtraParamsManager.getEncryptionUserId(this.bie.mUserId);
                } else {
                    str6 = this.bie.beR;
                    str7 = this.bie.mUserId;
                }
                str3 = this.bie.mRoomId;
                str2 = this.bie.mLiveId;
                str4 = str7;
                str5 = str6;
            } else {
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
            }
            String a2 = com.baidu.live.utils.b.a(i, str, this.bie != null && this.bie.aVQ, str5, str4, str3, str2, this.bie != null ? this.bie.bfa : null);
            if (i == 2) {
                this.bin = new com.baidu.live.x.c(this.mContext.getPageActivity());
                this.bin.ie(a2);
                return;
            }
            SchemeUtils.openScheme(a2);
        }
    }

    public void release() {
        this.bif = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bil != null) {
            this.bil.release();
        }
        if (this.bin != null) {
            this.bin.release();
        }
        MessageManager.getInstance().unRegisterListener(this.bih);
        MessageManager.getInstance().unRegisterListener(this.bii);
        MessageManager.getInstance().unRegisterListener(this.bij);
        MessageManager.getInstance().unRegisterListener(this.bik);
    }

    private void k(Intent intent) {
        this.bie = new com.baidu.live.gift.a.e();
        if (intent != null) {
            this.bcr = intent.getIntExtra("custom_tab_id", 1);
            this.bie.beR = intent.getStringExtra("login_user_id");
            this.bie.mUserName = intent.getStringExtra("user_name");
            this.bie.mUserId = intent.getStringExtra("user_id");
            this.bie.mLiveId = intent.getStringExtra("live_Id");
            this.bie.mRoomId = intent.getStringExtra("room_id");
            this.bie.beS = intent.getStringExtra("feed_id");
            this.bie.beT = intent.getIntExtra("is_block", 0);
            this.bie.beU = intent.getStringExtra("scene");
            this.bie.mAppId = intent.getStringExtra("app_id");
            this.bie.beV = intent.getBooleanExtra("can_graffiti", true);
            this.bie.bdr = intent.getIntExtra("custom_category_id", -1);
            this.bie.bds = intent.getIntExtra("custom_gift_id", -1);
            this.bie.bbn = intent.getBooleanExtra("new_gift_t_dou_strategy", false);
            this.bie.bbl = intent.getIntExtra(IntentConfig.USER_LEVEL, -1);
            this.bie.bcJ = intent.getBooleanExtra("isJoinGuardClub", false);
            this.bie.isNewUser = intent.getBooleanExtra("is_new_user", false);
            this.bie.bdt = intent.getIntExtra("guard_club_join_amount", 1000);
            this.bie.bdF = intent.getBooleanExtra("is_redpkg_unable", false);
            this.bie.beX = intent.getIntExtra("page_from", -1);
            this.bie.bbt = intent.getBooleanExtra("throne_enabled", false);
            this.bie.beZ = intent.getBooleanExtra("noble_enabled", false);
            this.bie.bfa = intent.getStringExtra("active_params");
            String stringExtra = intent.getStringExtra("bg_info");
            if (!TextUtils.isEmpty(stringExtra)) {
                AlaLiveGiftUIInfo alaLiveGiftUIInfo = new AlaLiveGiftUIInfo();
                alaLiveGiftUIInfo.parserJson(stringExtra);
                this.bie.beY = alaLiveGiftUIInfo;
            }
            String stringExtra2 = intent.getStringExtra(com.baidu.live.tbadk.core.frameworkdata.IntentConfig.OTHER_PARAMS);
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.bie.mOtherParams = stringExtra2;
        }
    }

    private void registerListener() {
        Ku();
        Kv();
        Kw();
        Kx();
    }

    private void Ku() {
        this.bih = new CustomMessageListener(2913097) { // from class: com.baidu.live.gift.panel.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.bif != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    b.this.bif.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bih);
    }

    private void Kv() {
        this.bii = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.gift.panel.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.Kz();
            }
        };
        MessageManager.getInstance().registerListener(this.bii);
    }

    private void Kw() {
        this.bij = new CustomMessageListener(2913024) { // from class: com.baidu.live.gift.panel.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.bif != null) {
                    b.this.bif.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bij);
    }

    private void Kx() {
        this.bik = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.live.gift.panel.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.Kz();
            }
        };
        MessageManager.getInstance().registerListener(this.bik);
    }

    private void Ky() {
        int i;
        f.a aVar = new f.a() { // from class: com.baidu.live.gift.panel.b.6
            @Override // com.baidu.live.gift.panel.f.a
            public k IF() {
                if (b.this.bif != null) {
                    return b.this.bif.IF();
                }
                return null;
            }
        };
        c eP = c.eP(0);
        eP.setPageContext(this.mContext);
        eP.a(aVar);
        eP.b(this.bgp);
        eP.a(this.bie);
        c eP2 = c.eP(1);
        eP2.setPageContext(this.mContext);
        eP2.a(aVar);
        eP2.b(this.bgp);
        eP2.a(this.bie);
        switch (this.bcr) {
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
        if (this.bif != null) {
            this.bif.a(i, eP, eP2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kz() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
            httpMessage.addParam("tbs", TbadkCoreApplication.getCurrentTbs());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void KA() {
        CustomResponsedMessage runTask;
        if (Ks()) {
            if (this.bil == null && (runTask = MessageManager.getInstance().runTask(2913198, com.baidu.live.noble.b.a.class, this.mContext.getPageActivity())) != null && runTask.getData() != null) {
                this.bil = (com.baidu.live.noble.b.a) runTask.getData();
            }
            if (this.bil != null) {
                this.bil.a(new a.InterfaceC0197a() { // from class: com.baidu.live.gift.panel.b.7
                    @Override // com.baidu.live.noble.b.a.InterfaceC0197a
                    public void a(NobleUserInfo nobleUserInfo) {
                        b.this.bim = nobleUserInfo;
                        if (b.this.bif != null) {
                            b.this.bif.a(nobleUserInfo != null ? nobleUserInfo.tip : null);
                        }
                    }
                });
                this.bil.Rj();
            }
        }
    }
}
