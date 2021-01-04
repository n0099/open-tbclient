package com.baidu.live.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.SkinManager;
/* loaded from: classes11.dex */
public class MessageRedDotView extends FrameLayout {
    public static final int TYPE_PLUS = 2;
    public static final int TYPE_THREE_DOT = 1;
    private RelativeLayout mMoreRedDot;
    private ImageView mMoreRedDotBg;
    private ImageView mMoreWhiteDotCenter;
    private ImageView mMoreWhiteDotLeft;
    private ImageView mMoreWhiteDotRight;
    private TextView mOneNumRedDot;
    private ImageView mRedDot;
    private TextView mThreeNumRedDot;
    private TextView mTwoNumRedDot;
    private int mType;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        initView();
    }

    @RequiresApi(api = 21)
    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mType = 1;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.g.sdk_message_red_dot_view, (ViewGroup) this, true);
        this.mRedDot = (ImageView) findViewById(a.f.red_dot);
        this.mOneNumRedDot = (TextView) findViewById(a.f.one_num_red_dot);
        this.mTwoNumRedDot = (TextView) findViewById(a.f.two_num_red_dot);
        this.mThreeNumRedDot = (TextView) findViewById(a.f.three_num_red_dot);
        this.mMoreRedDot = (RelativeLayout) findViewById(a.f.more_num_red_dot);
        this.mMoreRedDotBg = (ImageView) findViewById(a.f.more_num_red_dot_bg);
        this.mMoreWhiteDotCenter = (ImageView) findViewById(a.f.more_num_white_dot_center);
        this.mMoreWhiteDotLeft = (ImageView) findViewById(a.f.more_num_white_dot_left);
        this.mMoreWhiteDotRight = (ImageView) findViewById(a.f.more_num_white_dot_right);
        onChangeSkinType();
    }

    public final void onChangeSkinType() {
        if (this.mRedDot != null) {
            SkinManager.setImageResource(this.mRedDot, a.e.sdk_icon_news_red_dot);
        }
        if (this.mOneNumRedDot != null) {
            SkinManager.setViewTextColor(this.mOneNumRedDot, a.c.sdk_cp_cont_i, 1);
            SkinManager.setBackgroundResource(this.mOneNumRedDot, a.e.sdk_icon_news_red_dot_one_number);
        }
        if (this.mTwoNumRedDot != null) {
            SkinManager.setViewTextColor(this.mTwoNumRedDot, a.c.sdk_cp_cont_i, 1);
            SkinManager.setBackgroundResource(this.mTwoNumRedDot, a.e.sdk_icon_news_red_dot_two_number);
        }
        if (this.mThreeNumRedDot != null) {
            SkinManager.setViewTextColor(this.mThreeNumRedDot, a.c.sdk_cp_cont_i, 1);
            SkinManager.setBackgroundResource(this.mThreeNumRedDot, a.e.sdk_icon_news_red_dot_three_number);
        }
        if (this.mMoreRedDotBg != null && this.mMoreWhiteDotCenter != null && this.mMoreWhiteDotLeft != null && this.mMoreWhiteDotRight != null) {
            SkinManager.setImageResource(this.mMoreRedDotBg, a.e.sdk_icon_news_red_dot_two_number);
            SkinManager.setImageResource(this.mMoreWhiteDotCenter, a.e.sdk_icon_news_white_dot);
            SkinManager.setImageResource(this.mMoreWhiteDotLeft, a.e.sdk_icon_news_white_dot);
            SkinManager.setImageResource(this.mMoreWhiteDotRight, a.e.sdk_icon_news_white_dot);
        }
    }

    public void refresh(int i) {
        if (i <= 0) {
            this.mRedDot.setVisibility(0);
            this.mOneNumRedDot.setVisibility(8);
            this.mTwoNumRedDot.setVisibility(8);
            this.mThreeNumRedDot.setVisibility(8);
            this.mMoreRedDot.setVisibility(8);
        } else if (i < 10) {
            this.mOneNumRedDot.setText(String.valueOf(i));
            this.mRedDot.setVisibility(8);
            this.mOneNumRedDot.setVisibility(0);
            this.mTwoNumRedDot.setVisibility(8);
            this.mThreeNumRedDot.setVisibility(8);
            this.mMoreRedDot.setVisibility(8);
        } else if (i < 100) {
            this.mTwoNumRedDot.setText(String.valueOf(i));
            this.mRedDot.setVisibility(8);
            this.mOneNumRedDot.setVisibility(8);
            this.mTwoNumRedDot.setVisibility(0);
            this.mThreeNumRedDot.setVisibility(8);
            this.mMoreRedDot.setVisibility(8);
        } else {
            this.mRedDot.setVisibility(8);
            this.mOneNumRedDot.setVisibility(8);
            this.mTwoNumRedDot.setVisibility(8);
            if (this.mType == 1) {
                this.mMoreRedDot.setVisibility(0);
                this.mThreeNumRedDot.setVisibility(8);
            } else if (this.mType == 2) {
                this.mMoreRedDot.setVisibility(8);
                this.mThreeNumRedDot.setVisibility(0);
                this.mThreeNumRedDot.setText("99+");
            }
        }
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }
}
