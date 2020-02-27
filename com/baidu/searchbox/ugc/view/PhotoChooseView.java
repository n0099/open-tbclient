package com.baidu.searchbox.ugc.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.activity.AskPublishActivity;
import com.baidu.searchbox.ugc.activity.LocalAlbumActivity;
import com.baidu.searchbox.ugc.activity.LocalPhotoPreviewActivity;
import com.baidu.searchbox.ugc.adapter.PhotoChooseAdapter;
import com.baidu.searchbox.ugc.utils.LocalPreviewUtils;
import com.baidu.searchbox.ugc.webjs.UgcSchemeModel;
/* loaded from: classes13.dex */
public class PhotoChooseView extends GridView implements AdapterView.OnItemClickListener {
    private PhotoChooseAdapter mAdapter;
    private Activity mContext;
    private int mHorizontalSpacing;
    private StartAlbumListener mListener;
    private int mNumColumns;
    private int mVerticalSpacing;

    /* loaded from: classes13.dex */
    public interface StartAlbumListener {
        void goAlbumBefore();

        void setPublishBtnStatus();
    }

    public void setListener(StartAlbumListener startAlbumListener) {
        this.mListener = startAlbumListener;
    }

    public PhotoChooseView(Context context) {
        super(context);
    }

    public PhotoChooseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PhotoChooseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(Activity activity) {
        this.mContext = activity;
        this.mAdapter = new PhotoChooseAdapter(activity, this.mHorizontalSpacing, this.mNumColumns);
        setOnItemClickListener(this);
        this.mAdapter.setListener(new PhotoChooseAdapter.DeletePhotoListener() { // from class: com.baidu.searchbox.ugc.view.PhotoChooseView.1
            @Override // com.baidu.searchbox.ugc.adapter.PhotoChooseAdapter.DeletePhotoListener
            public void setPublishStatus() {
                if (PhotoChooseView.this.mListener != null) {
                    PhotoChooseView.this.mListener.setPublishBtnStatus();
                }
            }
        });
        postDelayed(new Runnable() { // from class: com.baidu.searchbox.ugc.view.PhotoChooseView.2
            @Override // java.lang.Runnable
            public void run() {
                PhotoChooseView.this.setAdapter((ListAdapter) PhotoChooseView.this.mAdapter);
            }
        }, 10L);
    }

    public void updateUi() {
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // android.widget.GridView
    public void setNumColumns(int i) {
        super.setNumColumns(i);
        this.mNumColumns = i;
    }

    @Override // android.widget.GridView
    public void setHorizontalSpacing(int i) {
        super.setHorizontalSpacing(i);
        this.mHorizontalSpacing = i;
    }

    @Override // android.widget.GridView
    public void setVerticalSpacing(int i) {
        super.setVerticalSpacing(i);
        this.mVerticalSpacing = i;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        int measuredHeight;
        super.onMeasure(i, i2);
        if (getCount() > 0 && getChildAt(0) != null && (measuredHeight = getChildAt(0).getMeasuredHeight()) != -1) {
            setMeasuredDimension(i, (measuredHeight * (((getCount() - 1) / this.mNumColumns) + 1)) + (this.mVerticalSpacing * ((getCount() - 1) / this.mNumColumns)));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.searchbox.ugc.adapter.PhotoChooseAdapter' to match base method */
    @Override // android.widget.GridView, android.widget.AdapterView
    /* renamed from: getAdapter */
    public ListAdapter getAdapter2() {
        return this.mAdapter;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.mListener != null) {
            this.mListener.goAlbumBefore();
        }
        if (this.mAdapter.isMorePosition(i)) {
            if (i == this.mAdapter.getCount() - 1) {
                goLocalAlbum();
                return;
            } else {
                goPhotoPreview(i);
                return;
            }
        }
        goPhotoPreview(i);
    }

    private void goLocalAlbum() {
        Intent intent = new Intent(this.mContext, LocalAlbumActivity.class);
        if (this.mContext instanceof AskPublishActivity) {
            UgcSchemeModel ugcSchemeModel = new UgcSchemeModel();
            ugcSchemeModel.from = 0;
            ugcSchemeModel.launchFrom = "publish";
            ugcSchemeModel.maxSelected = 3;
            intent.putExtra("data", ugcSchemeModel);
        }
        if (LocalPreviewUtils.unFastClick()) {
            this.mContext.startActivityForResult(intent, 32769);
        }
    }

    private void goPhotoPreview(int i) {
        Intent intent = new Intent(this.mContext, LocalPhotoPreviewActivity.class);
        intent.putExtra("position", i);
        intent.putExtra("from", "publish");
        BaseActivity.setNextPendingTransition(R.anim.ugc_photo_preview_enter, R.anim.publisher_hold, R.anim.publisher_hold, R.anim.ugc_photo_preview_exit);
        LocalPhotoPreviewActivity.startForResultIfNotRunning(this.mContext, intent, 32770);
    }
}
