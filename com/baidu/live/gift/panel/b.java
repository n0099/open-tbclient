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
    private AlaGiftTabView.a aGP;
    private a aGQ;
    private int aGR;
    private CustomMessageListener aGS;
    private CustomMessageListener aGT;
    private CustomMessageListener aGU;
    private CustomMessageListener aGV;
    private TbPageContext mContext;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, Fragment... fragmentArr);

        void a(AlaLiveGiftUIInfo alaLiveGiftUIInfo);

        void onClose();

        l xK();
    }

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void a(Intent intent, a aVar, AlaGiftTabView.a aVar2) {
        this.aGQ = aVar;
        this.aGP = aVar2;
        registerListener();
        this.mHandler = new Handler();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913087));
            }
        }, 300L);
        d k = k(intent);
        a(k);
        if (this.aGQ != null && k.aEt != null) {
            this.aGQ.a(k.aEt);
        }
        zu();
    }

    public void ez(String str) {
        UrlManager.getInstance().dealOneLink(this.mContext, new String[]{str});
    }

    public void release() {
        this.aGQ = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterListener(this.aGS);
        MessageManager.getInstance().unRegisterListener(this.aGT);
        MessageManager.getInstance().unRegisterListener(this.aGU);
        MessageManager.getInstance().unRegisterListener(this.aGV);
    }

    private void registerListener() {
        zq();
        zr();
        zs();
        zt();
    }

    private void zq() {
        this.aGS = new CustomMessageListener(2913097) { // from class: com.baidu.live.gift.panel.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.aGQ != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    b.this.aGQ.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aGS);
    }

    private void zr() {
        this.aGT = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.gift.panel.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.zu();
            }
        };
        MessageManager.getInstance().registerListener(this.aGT);
    }

    private void zs() {
        this.aGU = new CustomMessageListener(2913024) { // from class: com.baidu.live.gift.panel.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.aGQ != null) {
                    b.this.aGQ.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aGU);
    }

    private void zt() {
        this.aGV = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.live.gift.panel.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.zu();
            }
        };
        MessageManager.getInstance().registerListener(this.aGV);
    }

    private void a(d dVar) {
        int i;
        c.a aVar = new c.a() { // from class: com.baidu.live.gift.panel.b.6
            @Override // com.baidu.live.gift.panel.c.a
            public l xK() {
                if (b.this.aGQ != null) {
                    return b.this.aGQ.xK();
                }
                return null;
            }
        };
        GiftPanelTabBaseFragment ce = GiftPanelTabBaseFragment.ce(0);
        ce.a(aVar);
        ce.b(this.aGP);
        ce.b(dVar);
        GiftPanelTabBaseFragment ce2 = GiftPanelTabBaseFragment.ce(1);
        ce2.a(aVar);
        ce2.b(this.aGP);
        ce2.b(dVar);
        switch (this.aGR) {
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
        if (this.aGQ != null) {
            this.aGQ.a(i, ce, ce2);
        }
    }

    private d k(Intent intent) {
        d dVar = new d();
        if (intent == null) {
            return dVar;
        }
        this.aGR = intent.getIntExtra("custom_tab_id", 1);
        dVar.mUserName = intent.getStringExtra("user_name");
        dVar.mUserId = intent.getStringExtra("user_id");
        dVar.mLiveId = intent.getStringExtra("live_Id");
        dVar.mRoomId = intent.getStringExtra("room_id");
        dVar.aEn = intent.getStringExtra("feed_id");
        dVar.aEo = intent.getIntExtra("is_block", 0);
        dVar.aEp = intent.getStringExtra(FaceBaseDTO.KEY_BUSINESS_SCENE);
        dVar.mAppId = intent.getStringExtra("app_id");
        dVar.aEq = intent.getBooleanExtra("can_graffiti", true);
        dVar.aDk = intent.getIntExtra("custom_category_id", -1);
        dVar.aDl = intent.getIntExtra("custom_gift_id", -1);
        dVar.aBx = intent.getBooleanExtra("new_gift_t_dou_strategy", false);
        dVar.aBv = intent.getIntExtra("user_level", -1);
        dVar.aCG = intent.getBooleanExtra("isJoinGuardClub", false);
        dVar.isNewUser = intent.getBooleanExtra("is_new_user", false);
        dVar.aEr = intent.getBooleanExtra("entry_super_customer", false);
        dVar.aDm = intent.getIntExtra("guard_club_join_amount", 1000);
        dVar.aDv = intent.getBooleanExtra("is_redpkg_unable", false);
        dVar.aEs = intent.getIntExtra(VideoPlayActivityConfig.PAGE_FROM, -1);
        dVar.aBC = intent.getBooleanExtra("throne_enabled", false);
        String stringExtra = intent.getStringExtra("bg_info");
        if (!TextUtils.isEmpty(stringExtra)) {
            AlaLiveGiftUIInfo alaLiveGiftUIInfo = new AlaLiveGiftUIInfo();
            alaLiveGiftUIInfo.parserJson(stringExtra);
            dVar.aEt = alaLiveGiftUIInfo;
        }
        String stringExtra2 = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        dVar.mOtherParams = stringExtra2;
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zu() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
            httpMessage.addParam("tbs", TbadkCoreApplication.getCurrentTbs());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
