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
import com.baidu.live.gift.a.e;
import com.baidu.live.gift.panel.c;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes6.dex */
public class b {
    private a adA;
    private int adB;
    private CustomMessageListener adC;
    private CustomMessageListener adD;
    private CustomMessageListener adE;
    private CustomMessageListener adF;
    private TbPageContext mContext;
    private Handler mHandler;

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i, Fragment... fragmentArr);

        void bh(int i);

        void onClose();
    }

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void a(Intent intent, a aVar) {
        this.adA = aVar;
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
        this.adA = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterListener(this.adC);
        MessageManager.getInstance().unRegisterListener(this.adD);
        MessageManager.getInstance().unRegisterListener(this.adE);
        MessageManager.getInstance().unRegisterListener(this.adF);
    }

    private void registerListener() {
        rt();
        ru();
        rv();
        rw();
    }

    private void rt() {
        this.adC = new CustomMessageListener(2913097) { // from class: com.baidu.live.gift.panel.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.adA != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    b.this.adA.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.adC);
    }

    private void ru() {
        this.adD = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.gift.panel.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.refreshCurUserScores();
            }
        };
        MessageManager.getInstance().registerListener(this.adD);
    }

    private void rv() {
        this.adE = new CustomMessageListener(2913024) { // from class: com.baidu.live.gift.panel.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.adA != null) {
                    b.this.adA.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.adE);
    }

    private void rw() {
        this.adF = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.live.gift.panel.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.refreshCurUserScores();
            }
        };
        MessageManager.getInstance().registerListener(this.adF);
    }

    private void x(Intent intent) {
        int i;
        e y = y(intent);
        GiftPanelTabBaseFragment bt = GiftPanelTabBaseFragment.bt(0);
        bt.a(new c.a() { // from class: com.baidu.live.gift.panel.b.6
            @Override // com.baidu.live.gift.panel.c.a
            public void rx() {
                if (b.this.adA != null) {
                    b.this.adA.bh(1);
                }
            }
        });
        bt.a(y);
        GiftPanelTabBaseFragment bt2 = GiftPanelTabBaseFragment.bt(1);
        bt2.a(new c.a() { // from class: com.baidu.live.gift.panel.b.7
            @Override // com.baidu.live.gift.panel.c.a
            public void rx() {
                if (b.this.adA != null) {
                    b.this.adA.bh(0);
                }
            }
        });
        bt2.a(y);
        switch (this.adB) {
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
        if (this.adA != null) {
            this.adA.a(i, bt, bt2);
        }
    }

    private e y(Intent intent) {
        e eVar = new e();
        if (intent == null) {
            return eVar;
        }
        this.adB = intent.getIntExtra("custom_tab_id", 1);
        eVar.mUserName = intent.getStringExtra("user_name");
        eVar.mUserId = intent.getStringExtra("user_id");
        eVar.mLiveId = intent.getStringExtra("live_Id");
        eVar.abd = intent.getStringExtra("room_id");
        eVar.abe = intent.getStringExtra("feed_id");
        eVar.abf = intent.getIntExtra("is_block", 0);
        eVar.abg = intent.getStringExtra(FaceBaseDTO.KEY_BUSINESS_SCENE);
        eVar.mAppId = intent.getStringExtra(Constants.APP_ID);
        eVar.abh = intent.getBooleanExtra("can_graffiti", true);
        eVar.aae = intent.getIntExtra("custom_category_id", -1);
        eVar.aaf = intent.getIntExtra("custom_gift_id", -1);
        eVar.Yn = intent.getBooleanExtra("new_gift_t_dou_strategy", false);
        eVar.Yl = intent.getIntExtra("user_level", -1);
        eVar.Zn = intent.getBooleanExtra("isJoinGuardClub", false);
        eVar.isNewUser = intent.getBooleanExtra("is_new_user", false);
        eVar.aah = intent.getIntExtra("guard_club_join_amount", 1000);
        String stringExtra = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        if (stringExtra == null) {
            stringExtra = "";
        }
        eVar.mOtherParams = stringExtra;
        return eVar;
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
