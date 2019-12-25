package com.baidu.live.adp.widget.listview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.R;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes2.dex */
public class BdIListCommonPullView extends BdIListPullView {
    @SuppressLint({"SimpleDateFormat"})
    private static SimpleDateFormat FORMATE_DATA = new SimpleDateFormat("HH:mm");
    protected AnimationDrawable mAnimImage;
    private ListPullRefreshListenerEx mExListPullRefreshListener;
    private View mHeaderView;
    private ListPullRefreshListener mListPullRefreshListener;
    private String mLoadingMsg;
    protected ImageView mPullImage;
    private String mPullMsg;
    protected LinearLayout mPullRoot;
    protected TextView mPullText;
    protected TextView mPullTime;
    private String mReleaseMsg;

    /* loaded from: classes2.dex */
    public interface ListPullRefreshListener {
        void onListPullRefresh(boolean z);
    }

    /* loaded from: classes2.dex */
    public interface ListPullRefreshListenerEx {
        void onListPullRefresh(View view, boolean z);
    }

    public BdIListCommonPullView(Context context) {
        super(context);
        this.mHeaderView = null;
        this.mPullRoot = null;
        this.mPullImage = null;
        this.mPullText = null;
        this.mPullTime = null;
        this.mListPullRefreshListener = null;
        this.mExListPullRefreshListener = null;
    }

    @Override // com.baidu.live.adp.widget.listview.BdIListPullView
    public View createView() {
        Context context = getContext();
        return createView(context.getString(R.string.sdk_adp_pull_to_refresh), context.getString(R.string.sdk_adp_release_to_refresh), context.getString(R.string.sdk_adp_loading));
    }

    public View createView(String str, String str2, String str3) {
        Context context = getContext();
        if (str == null) {
            str = context.getString(R.string.sdk_adp_pull_to_refresh);
        }
        this.mPullMsg = str;
        if (str2 == null) {
            str2 = context.getString(R.string.sdk_adp_release_to_refresh);
        }
        this.mReleaseMsg = str2;
        if (str3 == null) {
            str3 = context.getString(R.string.sdk_adp_loading);
        }
        this.mLoadingMsg = str3;
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.sdk_pull_view, (ViewGroup) null);
        this.mPullRoot = (LinearLayout) this.mHeaderView.findViewById(R.id.pull_root);
        this.mPullImage = (ImageView) this.mHeaderView.findViewById(R.id.pull_image);
        this.mAnimImage = new AnimationDrawable();
        Drawable drawable = context.getResources().getDrawable(R.drawable.sdk_listview_pull_refresh02);
        if (drawable != null) {
            this.mAnimImage.addFrame(drawable, 100);
        }
        Drawable drawable2 = context.getResources().getDrawable(R.drawable.sdk_listview_pull_refresh01);
        if (drawable2 != null) {
            this.mAnimImage.addFrame(drawable2, 100);
        }
        this.mAnimImage.setOneShot(false);
        this.mPullImage.setBackgroundDrawable(this.mAnimImage);
        this.mPullText = (TextView) this.mHeaderView.findViewById(R.id.pull_text);
        this.mPullTime = (TextView) this.mHeaderView.findViewById(R.id.pull_time);
        setPullTime(getDateString());
        return this.mHeaderView;
    }

    public View getHeaderView() {
        if (this.mHeaderView == null) {
            this.mHeaderView = createView();
        }
        return this.mHeaderView;
    }

    public LinearLayout getPullRoot() {
        return this.mPullRoot;
    }

    public ImageView getPullImage() {
        return this.mPullImage;
    }

    public TextView getPullTime() {
        return this.mPullTime;
    }

    public TextView getPullText() {
        return this.mPullText;
    }

    @Override // com.baidu.live.adp.widget.listview.BdIListPullView
    public void releaseToRefresh() {
        this.mPullText.setVisibility(0);
        this.mPullTime.setVisibility(0);
        this.mAnimImage.stop();
        this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(1));
        this.mPullText.setText(this.mReleaseMsg);
    }

    @Override // com.baidu.live.adp.widget.listview.BdIListPullView
    public void pullToRefresh(boolean z) {
        this.mAnimImage.stop();
        this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        this.mPullText.setVisibility(0);
        this.mPullTime.setVisibility(0);
        if (z) {
        }
        this.mPullText.setText(this.mPullMsg);
    }

    @Override // com.baidu.live.adp.widget.listview.BdIListPullView
    public void refreshing() {
        this.mAnimImage.stop();
        this.mPullImage.setBackgroundDrawable(this.mAnimImage);
        this.mPullImage.post(new Runnable() { // from class: com.baidu.live.adp.widget.listview.BdIListCommonPullView.1
            @Override // java.lang.Runnable
            public void run() {
                BdIListCommonPullView.this.mAnimImage.start();
            }
        });
        this.mPullText.setText(this.mLoadingMsg);
        this.mPullTime.setVisibility(0);
    }

    @Override // com.baidu.live.adp.widget.listview.BdIListPullView
    public void done(boolean z) {
        this.mAnimImage.stop();
        this.mPullText.setText(this.mPullMsg);
        this.mPullTime.setVisibility(0);
        if (z) {
            setPullTime(getDateString());
        }
    }

    public static String getDateString() {
        String format;
        synchronized (FORMATE_DATA) {
            format = FORMATE_DATA.format(new Date());
        }
        return format;
    }

    public void setPullTime(String str) {
        this.mPullTime.setText(getContext().getString(R.string.sdk_adp_pull_view_date_tip) + str);
    }

    @Override // com.baidu.live.adp.widget.listview.BdIListPullView
    public void onRefresh(boolean z) {
        if (this.mListPullRefreshListener != null) {
            this.mListPullRefreshListener.onListPullRefresh(z);
        }
        if (this.mExListPullRefreshListener != null) {
            this.mExListPullRefreshListener.onListPullRefresh(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.live.adp.widget.listview.BdIListPullView
    public void onCompletePullRefresh() {
    }

    public void setListPullRefreshListener(ListPullRefreshListener listPullRefreshListener) {
        this.mListPullRefreshListener = listPullRefreshListener;
    }

    public void setListPullRefreshListenerEx(ListPullRefreshListenerEx listPullRefreshListenerEx) {
        this.mExListPullRefreshListener = listPullRefreshListenerEx;
    }
}
