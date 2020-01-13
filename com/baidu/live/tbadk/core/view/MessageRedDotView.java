package com.baidu.live.tbadk.core.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.util.SkinManager;
/* loaded from: classes2.dex */
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
        LayoutInflater.from(getContext()).inflate(a.h.sdk_message_red_dot_view, (ViewGroup) this, true);
        this.mRedDot = (ImageView) findViewById(a.g.red_dot);
        this.mOneNumRedDot = (TextView) findViewById(a.g.one_num_red_dot);
        this.mTwoNumRedDot = (TextView) findViewById(a.g.two_num_red_dot);
        this.mThreeNumRedDot = (TextView) findViewById(a.g.three_num_red_dot);
        this.mMoreRedDot = (RelativeLayout) findViewById(a.g.more_num_red_dot);
        this.mMoreRedDotBg = (ImageView) findViewById(a.g.more_num_red_dot_bg);
        this.mMoreWhiteDotCenter = (ImageView) findViewById(a.g.more_num_white_dot_center);
        this.mMoreWhiteDotLeft = (ImageView) findViewById(a.g.more_num_white_dot_left);
        this.mMoreWhiteDotRight = (ImageView) findViewById(a.g.more_num_white_dot_right);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.mRedDot != null) {
            SkinManager.setImageResource(this.mRedDot, a.f.sdk_icon_news_red_dot);
        }
        if (this.mOneNumRedDot != null) {
            SkinManager.setViewTextColor(this.mOneNumRedDot, a.d.sdk_cp_cont_i, 1);
            SkinManager.setBackgroundResource(this.mOneNumRedDot, a.f.sdk_icon_news_red_dot_one_number);
        }
        if (this.mTwoNumRedDot != null) {
            SkinManager.setViewTextColor(this.mTwoNumRedDot, a.d.sdk_cp_cont_i, 1);
            SkinManager.setBackgroundResource(this.mTwoNumRedDot, a.f.sdk_icon_news_red_dot_two_number);
        }
        if (this.mThreeNumRedDot != null) {
            SkinManager.setViewTextColor(this.mThreeNumRedDot, a.d.sdk_cp_cont_i, 1);
            SkinManager.setBackgroundResource(this.mThreeNumRedDot, a.f.sdk_icon_news_red_dot_three_number);
        }
        if (this.mMoreRedDotBg != null && this.mMoreWhiteDotCenter != null && this.mMoreWhiteDotLeft != null && this.mMoreWhiteDotRight != null) {
            SkinManager.setImageResource(this.mMoreRedDotBg, a.f.sdk_icon_news_red_dot_two_number);
            SkinManager.setImageResource(this.mMoreWhiteDotCenter, a.f.sdk_icon_news_white_dot);
            SkinManager.setImageResource(this.mMoreWhiteDotLeft, a.f.sdk_icon_news_white_dot);
            SkinManager.setImageResource(this.mMoreWhiteDotRight, a.f.sdk_icon_news_white_dot);
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
