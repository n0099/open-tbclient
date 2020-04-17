package com.baidu.live.gift.panel;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.data.AlaLiveGiftUIInfo;
import com.baidu.live.gift.a.d;
import com.baidu.live.gift.container.AlaGiftTabView;
import com.baidu.live.gift.l;
import com.baidu.live.gift.panel.c;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
/* loaded from: classes3.dex */
public class b {
    private AlaGiftTabView.a aGJ;
    private a aGK;
    private int aGL;
    private CustomMessageListener aGM;
    private CustomMessageListener aGN;
    private CustomMessageListener aGO;
    private CustomMessageListener aGP;
    private TbPageContext mContext;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, Fragment... fragmentArr);

        void a(AlaLiveGiftUIInfo alaLiveGiftUIInfo);

        void onClose();

        l xL();
    }

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void a(Intent intent, a aVar, AlaGiftTabView.a aVar2) {
        this.aGK = aVar;
        this.aGJ = aVar2;
        registerListener();
        this.mHandler = new Handler();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913087));
            }
        }, 300L);
        d x = x(intent);
        a(x);
        if (this.aGK != null && x.aEn != null) {
            this.aGK.a(x.aEn);
        }
        zv();
    }

    public void ez(String str) {
        UrlManager.getInstance().dealOneLink(this.mContext, new String[]{str});
    }

    public void release() {
        this.aGK = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterListener(this.aGM);
        MessageManager.getInstance().unRegisterListener(this.aGN);
        MessageManager.getInstance().unRegisterListener(this.aGO);
        MessageManager.getInstance().unRegisterListener(this.aGP);
    }

    private void registerListener() {
        zr();
        zs();
        zt();
        zu();
    }

    private void zr() {
        this.aGM = new CustomMessageListener(2913097) { // from class: com.baidu.live.gift.panel.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.aGK != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    b.this.aGK.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aGM);
    }

    private void zs() {
        this.aGN = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.gift.panel.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.zv();
            }
        };
        MessageManager.getInstance().registerListener(this.aGN);
    }

    private void zt() {
        this.aGO = new CustomMessageListener(2913024) { // from class: com.baidu.live.gift.panel.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.aGK != null) {
                    b.this.aGK.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aGO);
    }

    private void zu() {
        this.aGP = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.live.gift.panel.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.zv();
            }
        };
        MessageManager.getInstance().registerListener(this.aGP);
    }

    private void a(d dVar) {
        int i;
        c.a aVar = new c.a() { // from class: com.baidu.live.gift.panel.b.6
            @Override // com.baidu.live.gift.panel.c.a
            public l xL() {
                if (b.this.aGK != null) {
                    return b.this.aGK.xL();
                }
                return null;
            }
        };
        GiftPanelTabBaseFragment ce = GiftPanelTabBaseFragment.ce(0);
        ce.a(aVar);
        ce.b(this.aGJ);
        ce.b(dVar);
        GiftPanelTabBaseFragment ce2 = GiftPanelTabBaseFragment.ce(1);
        ce2.a(aVar);
        ce2.b(this.aGJ);
        ce2.b(dVar);
        switch (this.aGL) {
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
        if (this.aGK != null) {
            this.aGK.a(i, ce, ce2);
        }
    }

    private d x(Intent intent) {
        d dVar = new d();
        if (intent == null) {
            return dVar;
        }
        this.aGL = intent.getIntExtra("custom_tab_id", 1);
        dVar.mUserName = intent.getStringExtra("user_name");
        dVar.mUserId = intent.getStringExtra("user_id");
        dVar.mLiveId = intent.getStringExtra("live_Id");
        dVar.mRoomId = intent.getStringExtra("room_id");
        dVar.aEh = intent.getStringExtra("feed_id");
        dVar.aEi = intent.getIntExtra("is_block", 0);
        dVar.aEj = intent.getStringExtra(FaceBaseDTO.KEY_BUSINESS_SCENE);
        dVar.mAppId = intent.getStringExtra("app_id");
        dVar.aEk = intent.getBooleanExtra("can_graffiti", true);
        dVar.aDe = intent.getIntExtra("custom_category_id", -1);
        dVar.aDf = intent.getIntExtra("custom_gift_id", -1);
        dVar.aBr = intent.getBooleanExtra("new_gift_t_dou_strategy", false);
        dVar.aBp = intent.getIntExtra("user_level", -1);
        dVar.aCA = intent.getBooleanExtra("isJoinGuardClub", false);
        dVar.isNewUser = intent.getBooleanExtra("is_new_user", false);
        dVar.aEl = intent.getBooleanExtra("entry_super_customer", false);
        dVar.aDg = intent.getIntExtra("guard_club_join_amount", 1000);
        dVar.aDp = intent.getBooleanExtra("is_redpkg_unable", false);
        dVar.aEm = intent.getIntExtra(VideoPlayActivityConfig.PAGE_FROM, -1);
        dVar.aBw = intent.getBooleanExtra("throne_enabled", false);
        String stringExtra = intent.getStringExtra("bg_info");
        if (!TextUtils.isEmpty(stringExtra)) {
            AlaLiveGiftUIInfo alaLiveGiftUIInfo = new AlaLiveGiftUIInfo();
            alaLiveGiftUIInfo.parserJson(stringExtra);
            dVar.aEn = alaLiveGiftUIInfo;
        }
        String stringExtra2 = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        dVar.mOtherParams = stringExtra2;
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zv() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
            httpMessage.addParam("tbs", TbadkCoreApplication.getCurrentTbs());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
