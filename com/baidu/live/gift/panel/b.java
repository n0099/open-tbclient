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
import com.baidu.live.gift.a.d;
import com.baidu.live.gift.panel.c;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class b {
    private a aoh;
    private int aoi;
    private CustomMessageListener aoj;
    private CustomMessageListener aok;
    private CustomMessageListener aol;
    private CustomMessageListener aom;
    private TbPageContext mContext;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, Fragment... fragmentArr);

        void bA(int i);

        void onClose();
    }

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void a(Intent intent, a aVar) {
        this.aoh = aVar;
        registerListener();
        x(intent);
        this.mHandler = new Handler();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913087));
            }
        }, 300L);
        refreshCurUserScores();
    }

    public void release() {
        this.aoh = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterListener(this.aoj);
        MessageManager.getInstance().unRegisterListener(this.aok);
        MessageManager.getInstance().unRegisterListener(this.aol);
        MessageManager.getInstance().unRegisterListener(this.aom);
    }

    private void registerListener() {
        uQ();
        uR();
        uS();
        uT();
    }

    private void uQ() {
        this.aoj = new CustomMessageListener(2913097) { // from class: com.baidu.live.gift.panel.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.aoh != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    b.this.aoh.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aoj);
    }

    private void uR() {
        this.aok = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.gift.panel.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.refreshCurUserScores();
            }
        };
        MessageManager.getInstance().registerListener(this.aok);
    }

    private void uS() {
        this.aol = new CustomMessageListener(2913024) { // from class: com.baidu.live.gift.panel.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.aoh != null) {
                    b.this.aoh.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aol);
    }

    private void uT() {
        this.aom = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.live.gift.panel.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.refreshCurUserScores();
            }
        };
        MessageManager.getInstance().registerListener(this.aom);
    }

    private void x(Intent intent) {
        int i;
        d y = y(intent);
        GiftPanelTabBaseFragment bO = GiftPanelTabBaseFragment.bO(0);
        bO.a(new c.a() { // from class: com.baidu.live.gift.panel.b.6
            @Override // com.baidu.live.gift.panel.c.a
            public void uU() {
                if (b.this.aoh != null) {
                    b.this.aoh.bA(1);
                }
            }
        });
        bO.a(y);
        GiftPanelTabBaseFragment bO2 = GiftPanelTabBaseFragment.bO(1);
        bO2.a(new c.a() { // from class: com.baidu.live.gift.panel.b.7
            @Override // com.baidu.live.gift.panel.c.a
            public void uU() {
                if (b.this.aoh != null) {
                    b.this.aoh.bA(0);
                }
            }
        });
        bO2.a(y);
        switch (this.aoi) {
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
        if (this.aoh != null) {
            this.aoh.a(i, bO, bO2);
        }
    }

    private d y(Intent intent) {
        d dVar = new d();
        if (intent == null) {
            return dVar;
        }
        this.aoi = intent.getIntExtra("custom_tab_id", 1);
        dVar.mUserName = intent.getStringExtra("user_name");
        dVar.mUserId = intent.getStringExtra("user_id");
        dVar.mLiveId = intent.getStringExtra("live_Id");
        dVar.mRoomId = intent.getStringExtra("room_id");
        dVar.alH = intent.getStringExtra("feed_id");
        dVar.alI = intent.getIntExtra("is_block", 0);
        dVar.alJ = intent.getStringExtra(FaceBaseDTO.KEY_BUSINESS_SCENE);
        dVar.mAppId = intent.getStringExtra(Constants.APP_ID);
        dVar.alK = intent.getBooleanExtra("can_graffiti", true);
        dVar.akB = intent.getIntExtra("custom_category_id", -1);
        dVar.akC = intent.getIntExtra("custom_gift_id", -1);
        dVar.aiO = intent.getBooleanExtra("new_gift_t_dou_strategy", false);
        dVar.aiM = intent.getIntExtra("user_level", -1);
        dVar.ajK = intent.getBooleanExtra("isJoinGuardClub", false);
        dVar.isNewUser = intent.getBooleanExtra("is_new_user", false);
        dVar.akD = intent.getIntExtra("guard_club_join_amount", 1000);
        dVar.akN = intent.getBooleanExtra("is_redpkg_unable", false);
        dVar.alL = intent.getIntExtra(VideoPlayActivityConfig.PAGE_FROM, -1);
        dVar.aiT = intent.getBooleanExtra("throne_enabled", false);
        String stringExtra = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        if (stringExtra == null) {
            stringExtra = "";
        }
        dVar.mOtherParams = stringExtra;
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean refreshCurUserScores() {
        if (!TbadkCoreApplication.isLogin()) {
            return false;
        }
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
        httpMessage.addParam("tbs", TbadkCoreApplication.getCurrentTbs());
        MessageManager.getInstance().sendMessage(httpMessage);
        return true;
    }
}
