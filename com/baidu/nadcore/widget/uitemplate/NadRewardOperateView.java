package com.baidu.nadcore.widget.uitemplate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.j81;
import com.baidu.tieba.k81;
import com.baidu.tieba.r21;
/* loaded from: classes3.dex */
public class NadRewardOperateView extends FrameLayout {
    public AdImageView a;
    public SimpleFeedAdInfoView b;
    public RelativeLayout c;
    public TextView d;
    public TextView e;
    public TextView f;

    public void setFeedListener(k81 k81Var) {
    }

    public void setViewDownloadListener(j81 j81Var) {
    }

    public NadRewardOperateView(@NonNull Context context) {
        this(context, null);
    }

    public final void a(View view2) {
        if (view2 == null) {
            return;
        }
        r21.a(view2.getContext(), view2, 6.0f);
    }

    public NadRewardOperateView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NadRewardOperateView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    public final void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.nad_reward_operate_view, (ViewGroup) this, true);
        this.a = (AdImageView) findViewById(R.id.nad_reward_ad_app_icon);
        this.b = (SimpleFeedAdInfoView) findViewById(R.id.reward_ad_operate_app_info_view);
        this.d = (TextView) findViewById(R.id.reward_ad_operate_command_app_name);
        this.e = (TextView) findViewById(R.id.reward_ad_operate_command_app_title);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.reward_ad_operate_progress_button);
        this.c = relativeLayout;
        a(relativeLayout);
        TextView textView = (TextView) findViewById(R.id.reward_ad_operate_command_button);
        this.f = textView;
        a(textView);
    }
}
