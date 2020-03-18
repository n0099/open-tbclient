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
    private a aor;
    private int aos;
    private CustomMessageListener aot;
    private CustomMessageListener aou;
    private CustomMessageListener aov;
    private CustomMessageListener aow;
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
        this.aor = aVar;
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
        this.aor = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterListener(this.aot);
        MessageManager.getInstance().unRegisterListener(this.aou);
        MessageManager.getInstance().unRegisterListener(this.aov);
        MessageManager.getInstance().unRegisterListener(this.aow);
    }

    private void registerListener() {
        uV();
        uW();
        uX();
        uY();
    }

    private void uV() {
        this.aot = new CustomMessageListener(2913097) { // from class: com.baidu.live.gift.panel.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.aor != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    b.this.aor.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aot);
    }

    private void uW() {
        this.aou = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.gift.panel.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.refreshCurUserScores();
            }
        };
        MessageManager.getInstance().registerListener(this.aou);
    }

    private void uX() {
        this.aov = new CustomMessageListener(2913024) { // from class: com.baidu.live.gift.panel.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.aor != null) {
                    b.this.aor.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aov);
    }

    private void uY() {
        this.aow = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.live.gift.panel.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.refreshCurUserScores();
            }
        };
        MessageManager.getInstance().registerListener(this.aow);
    }

    private void x(Intent intent) {
        int i;
        d y = y(intent);
        GiftPanelTabBaseFragment bO = GiftPanelTabBaseFragment.bO(0);
        bO.a(new c.a() { // from class: com.baidu.live.gift.panel.b.6
            @Override // com.baidu.live.gift.panel.c.a
            public void uZ() {
                if (b.this.aor != null) {
                    b.this.aor.bA(1);
                }
            }
        });
        bO.a(y);
        GiftPanelTabBaseFragment bO2 = GiftPanelTabBaseFragment.bO(1);
        bO2.a(new c.a() { // from class: com.baidu.live.gift.panel.b.7
            @Override // com.baidu.live.gift.panel.c.a
            public void uZ() {
                if (b.this.aor != null) {
                    b.this.aor.bA(0);
                }
            }
        });
        bO2.a(y);
        switch (this.aos) {
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
        if (this.aor != null) {
            this.aor.a(i, bO, bO2);
        }
    }

    private d y(Intent intent) {
        d dVar = new d();
        if (intent == null) {
            return dVar;
        }
        this.aos = intent.getIntExtra("custom_tab_id", 1);
        dVar.mUserName = intent.getStringExtra("user_name");
        dVar.mUserId = intent.getStringExtra("user_id");
        dVar.mLiveId = intent.getStringExtra("live_Id");
        dVar.mRoomId = intent.getStringExtra("room_id");
        dVar.alR = intent.getStringExtra("feed_id");
        dVar.alS = intent.getIntExtra("is_block", 0);
        dVar.alT = intent.getStringExtra(FaceBaseDTO.KEY_BUSINESS_SCENE);
        dVar.mAppId = intent.getStringExtra(Constants.APP_ID);
        dVar.alU = intent.getBooleanExtra("can_graffiti", true);
        dVar.akL = intent.getIntExtra("custom_category_id", -1);
        dVar.akM = intent.getIntExtra("custom_gift_id", -1);
        dVar.aiY = intent.getBooleanExtra("new_gift_t_dou_strategy", false);
        dVar.aiW = intent.getIntExtra("user_level", -1);
        dVar.ajU = intent.getBooleanExtra("isJoinGuardClub", false);
        dVar.isNewUser = intent.getBooleanExtra("is_new_user", false);
        dVar.akN = intent.getIntExtra("guard_club_join_amount", 1000);
        dVar.akX = intent.getBooleanExtra("is_redpkg_unable", false);
        dVar.alV = intent.getIntExtra(VideoPlayActivityConfig.PAGE_FROM, -1);
        dVar.ajd = intent.getBooleanExtra("throne_enabled", false);
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
