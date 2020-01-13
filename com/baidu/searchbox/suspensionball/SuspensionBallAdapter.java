package com.baidu.searchbox.suspensionball;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.suspension.activity.SuspensionViewAdapter;
/* loaded from: classes10.dex */
public class SuspensionBallAdapter extends SuspensionViewAdapter {
    private static long sClickTimeInterval = 1000;
    private static long sPreClickTime;
    private String mKey;

    public SuspensionBallAdapter(String str) {
        this.mKey = str;
    }

    @Override // com.baidu.searchbox.suspension.activity.SuspensionViewAdapter
    protected View createView() {
        ImageView imageView = new ImageView(AppRuntime.getAppContext());
        imageView.setImageResource(R.drawable.suspension_ball);
        imageView.setTag(this.mKey);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.suspensionball.SuspensionBallAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - SuspensionBallAdapter.sPreClickTime > SuspensionBallAdapter.sClickTimeInterval) {
                    SuspensionBallManager.getInstance().onBallClick(SuspensionBallAdapter.this.mKey);
                    long unused = SuspensionBallAdapter.sPreClickTime = currentTimeMillis;
                }
            }
        });
        return imageView;
    }

    @Override // com.baidu.searchbox.suspension.activity.SuspensionViewAdapter
    public int getWidth() {
        return SuspensionBallManager.getInstance().getBallRadius() * 2;
    }

    @Override // com.baidu.searchbox.suspension.activity.SuspensionViewAdapter
    public int getHeight() {
        return SuspensionBallManager.getInstance().getBallRadius() * 2;
    }

    @Override // com.baidu.searchbox.suspension.activity.SuspensionViewAdapter
    public boolean filterActivity(Activity activity) {
        return TextUtils.equals(activity.getIntent().getStringExtra(SuspensionSchemeUtil.SUSPENSION_KEY), this.mKey);
    }
}
