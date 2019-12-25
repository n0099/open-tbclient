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
import com.baidu.live.gift.panel.c;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class b {
    private a alf;
    private int alg;
    private CustomMessageListener alh;
    private CustomMessageListener ali;
    private CustomMessageListener alj;
    private CustomMessageListener alk;
    private TbPageContext mContext;
    private Handler mHandler;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i, Fragment... fragmentArr);

        void bt(int i);

        void onClose();
    }

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void a(Intent intent, a aVar) {
        this.alf = aVar;
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
        this.alf = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterListener(this.alh);
        MessageManager.getInstance().unRegisterListener(this.ali);
        MessageManager.getInstance().unRegisterListener(this.alj);
        MessageManager.getInstance().unRegisterListener(this.alk);
    }

    private void registerListener() {
        ti();
        tj();
        tk();
        tl();
    }

    private void ti() {
        this.alh = new CustomMessageListener(2913097) { // from class: com.baidu.live.gift.panel.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.alf != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    b.this.alf.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.alh);
    }

    private void tj() {
        this.ali = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.gift.panel.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.refreshCurUserScores();
            }
        };
        MessageManager.getInstance().registerListener(this.ali);
    }

    private void tk() {
        this.alj = new CustomMessageListener(2913024) { // from class: com.baidu.live.gift.panel.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.alf != null) {
                    b.this.alf.onClose();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.alj);
    }

    private void tl() {
        this.alk = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.live.gift.panel.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.refreshCurUserScores();
            }
        };
        MessageManager.getInstance().registerListener(this.alk);
    }

    private void x(Intent intent) {
        int i;
        com.baidu.live.gift.a.c y = y(intent);
        GiftPanelTabBaseFragment bH = GiftPanelTabBaseFragment.bH(0);
        bH.a(new c.a() { // from class: com.baidu.live.gift.panel.b.6
            @Override // com.baidu.live.gift.panel.c.a
            public void tm() {
                if (b.this.alf != null) {
                    b.this.alf.bt(1);
                }
            }
        });
        bH.a(y);
        GiftPanelTabBaseFragment bH2 = GiftPanelTabBaseFragment.bH(1);
        bH2.a(new c.a() { // from class: com.baidu.live.gift.panel.b.7
            @Override // com.baidu.live.gift.panel.c.a
            public void tm() {
                if (b.this.alf != null) {
                    b.this.alf.bt(0);
                }
            }
        });
        bH2.a(y);
        switch (this.alg) {
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
        if (this.alf != null) {
            this.alf.a(i, bH, bH2);
        }
    }

    private com.baidu.live.gift.a.c y(Intent intent) {
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c();
        if (intent == null) {
            return cVar;
        }
        this.alg = intent.getIntExtra("custom_tab_id", 1);
        cVar.mUserName = intent.getStringExtra("user_name");
        cVar.mUserId = intent.getStringExtra("user_id");
        cVar.mLiveId = intent.getStringExtra("live_Id");
        cVar.aiN = intent.getStringExtra("room_id");
        cVar.aiO = intent.getStringExtra("feed_id");
        cVar.aiP = intent.getIntExtra("is_block", 0);
        cVar.aiQ = intent.getStringExtra(FaceBaseDTO.KEY_BUSINESS_SCENE);
        cVar.mAppId = intent.getStringExtra(Constants.APP_ID);
        cVar.aiR = intent.getBooleanExtra("can_graffiti", true);
        cVar.ahK = intent.getIntExtra("custom_category_id", -1);
        cVar.ahL = intent.getIntExtra("custom_gift_id", -1);
        cVar.afV = intent.getBooleanExtra("new_gift_t_dou_strategy", false);
        cVar.afT = intent.getIntExtra("user_level", -1);
        cVar.agT = intent.getBooleanExtra("isJoinGuardClub", false);
        cVar.isNewUser = intent.getBooleanExtra("is_new_user", false);
        cVar.ahM = intent.getIntExtra("guard_club_join_amount", 1000);
        cVar.ahX = intent.getBooleanExtra("is_redpkg_unable", false);
        cVar.aiS = intent.getIntExtra(VideoPlayActivityConfig.PAGE_FROM, -1);
        cVar.aga = intent.getBooleanExtra("throne_enabled", false);
        String stringExtra = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        if (stringExtra == null) {
            stringExtra = "";
        }
        cVar.mOtherParams = stringExtra;
        return cVar;
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
