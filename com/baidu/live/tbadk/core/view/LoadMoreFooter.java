package com.baidu.live.tbadk.core.view;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.live.adp.widget.listview.BdIListPage;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class LoadMoreFooter extends BdIListPage {
    private int footerHeight;
    private boolean isLoading;
    private int mBackgroundColor = Color.parseColor("#FF222222");
    private Context mContext;
    private int mTextColor;
    private ProgressBar progressBar;
    private TextView tvContent;

    public LoadMoreFooter(Context context) {
        this.mContext = context;
        this.mTextColor = context.getResources().getColor(a.c.sdk_white_alpha80);
    }

    @Override // com.baidu.live.adp.widget.listview.BdIListPage
    public View createView() {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.sdk_simple_load_more_footer, (ViewGroup) null);
        if (this.footerHeight > 0) {
            inflate.setLayoutParams(new ViewGroup.LayoutParams(-1, this.footerHeight));
        }
        this.tvContent = (TextView) inflate.findViewById(a.f.simple_load_more_text);
        this.progressBar = (ProgressBar) inflate.findViewById(a.f.simple_load_progress);
        inflate.setBackgroundColor(this.mBackgroundColor);
        this.tvContent.setTextColor(this.mTextColor);
        return inflate;
    }

    @Override // com.baidu.live.adp.widget.listview.BdIListPage
    public void onClick() {
    }

    public void setFooterHeight(int i) {
        this.footerHeight = i;
    }

    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void showLoadView(String str) {
        if (str != null) {
            this.tvContent.setVisibility(0);
            this.tvContent.setText(str);
            this.progressBar.setVisibility(0);
        }
    }

    public void showLoadView() {
        this.isLoading = true;
        showLoadView(this.mContext.getText(a.h.sdk_loading).toString());
    }

    public void endLoadData() {
        this.isLoading = false;
        this.tvContent.setText(this.mContext.getText(a.h.sdk_pb_load_more));
        this.progressBar.setVisibility(8);
    }

    public void showNoMoreData() {
        this.isLoading = false;
        this.progressBar.setVisibility(8);
        this.tvContent.setText(this.mContext.getResources().getString(a.h.sdk_list_no_more));
    }

    public void setText(String str) {
        if (str != null) {
            this.tvContent.setText(str);
        }
    }

    public boolean isLoading() {
        return this.isLoading;
    }
}
