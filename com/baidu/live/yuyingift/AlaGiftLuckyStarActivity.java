package com.baidu.live.yuyingift;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.widget.TbImageView;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaGiftLuckyStarActivity extends BaseFragmentActivity {
    private TextView aYc;
    private TextView aYd;
    private TextView aYe;
    private TbImageView aYf;
    private String aYg;
    private String aYh;
    private String aYi;
    private String aYj;
    private TbImageView aYk;
    private RelativeLayout aYl;
    private RelativeLayout aYm;
    private float aYp;
    private float aYq;
    private View mRootView;
    private TextView mTitleTextView;
    private boolean aYb = false;
    private int aYn = 0;
    private int aYo = 0;
    private CustomMessageListener aYr = new CustomMessageListener(2913054) { // from class: com.baidu.live.yuyingift.AlaGiftLuckyStarActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaGiftLuckyStarActivity.this.closeActivity();
        }
    };
    CustomMessageListener aYs = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.yuyingift.AlaGiftLuckyStarActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaGiftLuckyStarActivity.this.closeActivity();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (!isFinishing()) {
            setRequestedOrientation(1);
            registerListener(this.aYs);
            registerListener(this.aYr);
            this.aYg = getIntent().getStringExtra("title");
            this.aYh = getIntent().getStringExtra("des");
            this.aYi = getIntent().getStringExtra("leftbt");
            this.aYj = getIntent().getStringExtra("rightbt");
            initView();
            this.mRootView.setVisibility(4);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        overridePendingTransition(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aYb) {
            this.mRootView.setVisibility(0);
            this.aYb = true;
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_gift_lucky_star_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mTitleTextView = (TextView) findViewById(a.f.ala_gift_lucky_star_title);
        this.aYc = (TextView) findViewById(a.f.ala_gift_lucky_star_des);
        this.aYd = (TextView) findViewById(a.f.ala_gift_lucky_star_left_bt);
        this.aYe = (TextView) findViewById(a.f.ala_gift_lucky_star_right_bt);
        this.aYf = (TbImageView) findViewById(a.f.ala_gift_lucky_star_delete);
        this.aYk = (TbImageView) findViewById(a.f.ala_gift_lucky_star_icon);
        this.aYl = (RelativeLayout) findViewById(a.f.ala_gift_lucky_star_content);
        this.aYm = (RelativeLayout) findViewById(a.f.ala_gift_lucky_star_content_bg_view);
        this.mTitleTextView.setText(this.aYg);
        this.aYc.setText(this.aYh);
        this.aYd.setText(this.aYi);
        this.aYe.setText(this.aYj);
        this.aYf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.AlaGiftLuckyStarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaGiftLuckyStarActivity.this.Hd();
            }
        });
        this.aYd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.AlaGiftLuckyStarActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaGiftLuckyStarActivity.this.Hd();
            }
        });
        this.aYe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.AlaGiftLuckyStarActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaGiftLuckyStarActivity.this.aYe.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.AlaGiftLuckyStarActivity.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaGiftLuckyStarActivity.this.finish();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913173));
                    }
                }, 500L);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hd() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913174));
        He();
        Hh();
        Hf();
        Hg();
    }

    private void He() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aYl, View.SCALE_X, 1.0f, 1.1f);
        ofFloat.setDuration(120L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aYl, View.SCALE_Y, 1.0f, 1.1f);
        ofFloat2.setDuration(120L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.aYl, View.SCALE_X, 1.1f, 0.3f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.aYl, View.SCALE_Y, 1.1f, 0.3f);
        ofFloat3.setDuration(240L);
        ofFloat4.setDuration(240L);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.aYl, View.ALPHA, 1.0f, 0.0f);
        ofFloat5.setDuration(240L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(ofFloat3).with(ofFloat4).with(ofFloat5).after(animatorSet);
        animatorSet2.setInterpolator(new LinearInterpolator());
        animatorSet2.start();
    }

    private void Hf() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aYm, View.ALPHA, 1.0f, 0.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setInterpolator(new LinearInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.yuyingift.AlaGiftLuckyStarActivity.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaGiftLuckyStarActivity.this.finish();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        animatorSet.play(ofFloat);
        animatorSet.start();
    }

    private void Hg() {
        float height = ((this.aYo - this.aYq) - (this.aYk.getHeight() * 0.45f)) + 36.0f;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aYk, View.TRANSLATION_Y, height, height - 10.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aYk, View.ALPHA, 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.aYk, View.TRANSLATION_Y, height - 10.0f, height);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.aYk, View.ALPHA, 1.0f, 0.0f);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(200L);
        animatorSet2.playTogether(ofFloat3, ofFloat4);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.setStartDelay(800L);
        animatorSet3.playSequentially(animatorSet, animatorSet2);
        animatorSet3.start();
    }

    private void Hh() {
        int[] iArr = new int[2];
        this.aYk.getLocationOnScreen(iArr);
        this.aYp = iArr[0];
        this.aYq = iArr[1];
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2501066), String.class);
        if (runTask != null && !TextUtils.isEmpty((CharSequence) runTask.getData())) {
            try {
                JSONObject jSONObject = new JSONObject((String) runTask.getData());
                this.aYn = jSONObject.optInt("turn_tab_x");
                this.aYo = jSONObject.optInt("turn_tab_y");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aYk, View.TRANSLATION_X, 0.0f, ((this.aYn - this.aYp) - (this.aYk.getWidth() * 0.45f)) + 36.0f);
        ofFloat.setDuration(400L);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setStartDelay(200L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aYk, View.TRANSLATION_Y, 0.0f, ((this.aYo - this.aYq) - (this.aYk.getHeight() * 0.45f)) + 36.0f);
        ofFloat2.setDuration(400L);
        ofFloat2.setInterpolator(new AccelerateInterpolator());
        ofFloat2.setStartDelay(200L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.aYk, View.SCALE_X, 1.0f, 1.1f);
        ofFloat3.setDuration(200L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.aYk, View.SCALE_Y, 1.0f, 1.1f);
        ofFloat4.setDuration(200L);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.aYk, View.SCALE_X, 1.1f, 0.5f);
        ofFloat5.setDuration(200L);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.aYk, View.SCALE_Y, 1.1f, 0.5f);
        ofFloat6.setDuration(200L);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.aYk, View.SCALE_X, 0.5f, 0.2f);
        ofFloat7.setDuration(200L);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.aYk, View.SCALE_Y, 0.5f, 0.2f);
        ofFloat8.setDuration(200L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.playSequentially(ofFloat3, ofFloat5, ofFloat7);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setInterpolator(new LinearInterpolator());
        animatorSet2.playSequentially(ofFloat4, ofFloat6, ofFloat8);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.aYk, View.ALPHA, 1.0f, 0.0f);
        ofFloat9.setDuration(200L);
        ofFloat9.setStartDelay(600L);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playTogether(ofFloat, ofFloat2, animatorSet, animatorSet2, ofFloat9);
        animatorSet3.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aYs);
        MessageManager.getInstance().unRegisterListener(this.aYr);
        super.onDestroy();
    }
}
