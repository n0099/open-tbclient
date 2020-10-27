package com.baidu.live.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
/* loaded from: classes4.dex */
public class TransparentActivity extends BaseFragmentActivity {
    private View contentView;
    private String params;
    private String type;
    private Handler handler = new Handler();
    private CustomMessageListener aAi = new CustomMessageListener(2913129) { // from class: com.baidu.live.activity.TransparentActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            TransparentActivity.this.finish();
        }
    };
    private CustomMessageListener aAj = new CustomMessageListener(2913236) { // from class: com.baidu.live.activity.TransparentActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            TransparentActivity.this.finish();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (!isFinishing()) {
            if (getIntent() == null) {
                finish();
                return;
            }
            parserIntent();
            String str = Build.DISPLAY;
            if (str != null && str.contains("Flyme")) {
                getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.d.sdk_transparent)));
            }
            this.contentView = new View(getActivity());
            this.contentView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            setContentView(this.contentView);
            MessageManager.getInstance().registerListener(this.aAi);
            MessageManager.getInstance().registerListener(this.aAj);
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.live.activity.TransparentActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    TransparentActivity.this.contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.activity.TransparentActivity.3.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            TransparentActivity.this.finish();
                        }
                    });
                }
            }, IMConnection.RETRY_DELAY_TIMES);
            this.handler.post(new Runnable() { // from class: com.baidu.live.activity.TransparentActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    TransparentActivity.this.Bd();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bd() {
        Log.i("ModifyNicknameHelper", "@@ ModifyNickname TransparentActivity deal type = " + this.type);
        if (TextUtils.equals(this.type, "showModifyNicknameDialog")) {
            com.baidu.live.n.a.t(getActivity());
        }
    }

    private void parserIntent() {
        this.type = getIntent().getStringExtra("type");
        this.params = getIntent().getStringExtra("params");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.aAi);
        MessageManager.getInstance().unRegisterListener(this.aAj);
        this.handler.removeCallbacksAndMessages(null);
    }
}
