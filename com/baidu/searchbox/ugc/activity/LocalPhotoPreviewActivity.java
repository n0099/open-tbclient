package com.baidu.searchbox.ugc.activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.publisher.base.Utils;
import com.baidu.searchbox.ugc.adapter.LocalAlbumAdapter;
import com.baidu.searchbox.ugc.album.R;
import com.baidu.searchbox.ugc.model.ImageStruct;
import com.baidu.searchbox.ugc.provider.listener.OnDeletePreviewPhotoListener;
import com.baidu.searchbox.ugc.utils.AlbumUriUtils;
import com.baidu.searchbox.ugc.utils.ImageHelper;
import com.baidu.searchbox.ugc.utils.ResourceUtils;
import com.baidu.searchbox.ugc.utils.SelectUtil;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.searchbox.ugc.utils.UiBaseUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class LocalPhotoPreviewActivity extends PreviewBaseActivity implements View.OnClickListener, LocalAlbumAdapter.ClickPagerViewListener {
    private static boolean isRunning = false;
    private static OnDeletePreviewPhotoListener mListener;
    private LocalAlbumAdapter mAdapter;
    private View mBack;
    private View mBottomView;
    private ImageView mDeleteImg;
    private View mDeleteImgBg;
    private TextView mFinishTv;
    private String mFrom;
    private int mIndex;
    private boolean mNoStatistics;
    private View mPhotoHeader;
    private TextView mPhotoPages;
    private ImageView mSelectImg;
    private TextView mSelectNum;
    private View mSelectView;
    private ViewPager mViewpager;
    private int mDuration = 200;
    private List<ImageStruct> mList = new ArrayList();
    private boolean mBarShowing = true;
    private boolean mAnimation = false;
    private boolean mSupportSingleSelect = false;
    private ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.searchbox.ugc.activity.LocalPhotoPreviewActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            LocalPhotoPreviewActivity.this.mIndex = i;
            if (TextUtils.equals(LocalPhotoPreviewActivity.this.mFrom, "album") || TextUtils.equals(LocalPhotoPreviewActivity.this.mFrom, "bottomPreview")) {
                if (LocalPhotoPreviewActivity.this.mList == null || LocalPhotoPreviewActivity.this.mList.size() <= LocalPhotoPreviewActivity.this.mIndex || !SelectUtil.getSeletedImages().contains(LocalPhotoPreviewActivity.this.mList.get(LocalPhotoPreviewActivity.this.mIndex))) {
                    UiBaseUtils.setVisibility(LocalPhotoPreviewActivity.this.mSelectNum, 8);
                    UiBaseUtils.setViewDrawableResource(LocalPhotoPreviewActivity.this.mSelectImg, R.drawable.ugc_unselected_icon);
                    return;
                } else if (LocalPhotoPreviewActivity.this.mSupportSingleSelect) {
                    UiBaseUtils.setVisibility(LocalPhotoPreviewActivity.this.mSelectNum, 8);
                    UiBaseUtils.setViewDrawableResource(LocalPhotoPreviewActivity.this.mSelectImg, R.drawable.ugc_selected_icon);
                    return;
                } else {
                    UiBaseUtils.setVisibility(LocalPhotoPreviewActivity.this.mSelectNum, 0);
                    UiBaseUtils.setTextString(LocalPhotoPreviewActivity.this.mSelectNum, String.valueOf(LocalPhotoPreviewActivity.this.getIndex(((ImageStruct) LocalPhotoPreviewActivity.this.mList.get(LocalPhotoPreviewActivity.this.mIndex)).contentUri)));
                    UiBaseUtils.setViewDrawableResource(LocalPhotoPreviewActivity.this.mSelectNum, R.drawable.ugc_select_preview_bg);
                    return;
                }
            }
            UiBaseUtils.setTextString(LocalPhotoPreviewActivity.this.mPhotoPages, (i + 1) + "/" + LocalPhotoPreviewActivity.this.mList.size());
            UiBaseUtils.setImageResource(LocalPhotoPreviewActivity.this.mDeleteImg, R.drawable.ugc_delete_selector);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    @Override // com.baidu.searchbox.ugc.activity.PreviewBaseActivity, com.baidu.searchbox.appframework.BaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ugc_photo_preview_layout);
        if (getIntent() != null) {
            this.mIndex = getIntent().getIntExtra("position", 0);
            this.mFrom = getIntent().getStringExtra("from");
            this.mSupportSingleSelect = getIntent().getBooleanExtra("isSupportSingle", false);
            if (TextUtils.equals(this.mFrom, "album")) {
                this.mList = ImageHelper.getImageList();
            } else if (TextUtils.equals(this.mFrom, "bottomPreview")) {
                this.mList.clear();
                this.mList.addAll(SelectUtil.getSeletedImages());
            } else {
                this.mList = SelectUtil.getSeletedImages();
            }
            if (this.mAdapter != null) {
                this.mAdapter.notifyDataSetChanged();
            }
            this.mNoStatistics = getIntent().getBooleanExtra(LocalAlbumActivity.KEY_NO_STATISTIC, false);
        }
        initView();
        UgcUBCUtils.ugcPvStatistics(0, UgcUBCUtils.mPublishPreviewPage, this.mNoStatistics);
    }

    private void initView() {
        String string;
        this.mViewpager = (ViewPager) findViewById(ResourceUtils.getResIdByName("ugc_viewpager"));
        this.mSelectImg = (ImageView) findViewById(ResourceUtils.getResIdByName("ugc_photo_select_img"));
        this.mBack = findViewById(ResourceUtils.getResIdByName("ugc_photo_back"));
        this.mSelectView = findViewById(ResourceUtils.getResIdByName("ugc_photo_select_view"));
        this.mFinishTv = (TextView) findViewById(ResourceUtils.getResIdByName("ugc_photo_finish"));
        this.mSelectNum = (TextView) findViewById(ResourceUtils.getResIdByName("ugc_photo_select"));
        this.mPhotoPages = (TextView) findViewById(ResourceUtils.getResIdByName("ugc_photo_pages"));
        this.mBottomView = findViewById(ResourceUtils.getResIdByName("ugc_photo_bottom"));
        this.mPhotoHeader = findViewById(ResourceUtils.getResIdByName("ugc_photo_header"));
        this.mDeleteImg = (ImageView) findViewById(ResourceUtils.getResIdByName("ugc_photo_select_delete_img"));
        this.mDeleteImgBg = findViewById(ResourceUtils.getResIdByName("ugc_photo_select_delete_view_bg"));
        UiBaseUtils.setOnClickListener(this.mBack, this);
        UiBaseUtils.setOnClickListener(this.mFinishTv, this);
        if (this.mViewpager != null) {
            this.mViewpager.setOnPageChangeListener(this.pageChangeListener);
        }
        this.mAdapter = new LocalAlbumAdapter(this, this.mList);
        if (this.mViewpager != null) {
            this.mViewpager.setAdapter(this.mAdapter);
        }
        if (this.mAdapter != null) {
            this.mAdapter.notifyDataSetChanged();
            this.mAdapter.setListener(this);
        }
        if (this.mViewpager != null) {
            this.mViewpager.setCurrentItem(this.mIndex);
        }
        UiBaseUtils.setOnClickListener(this.mSelectView, this);
        UiBaseUtils.setOnClickListener(this.mDeleteImg, this);
        if (this.mSupportSingleSelect) {
            UiBaseUtils.setVisibility(this.mPhotoPages, 8);
        }
        if (TextUtils.equals(this.mFrom, "album") || TextUtils.equals(this.mFrom, "bottomPreview")) {
            UiBaseUtils.setVisibility(this.mPhotoPages, 8);
            UiBaseUtils.setVisibility(this.mDeleteImgBg, 8);
            if (this.mList.size() > 0 && this.mIndex < this.mList.size() && SelectUtil.hasImage(this.mList.get(this.mIndex))) {
                if (this.mSupportSingleSelect) {
                    UiBaseUtils.setVisibility(this.mSelectNum, 8);
                    UiBaseUtils.setViewDrawableResource(this.mSelectImg, R.drawable.ugc_selected_icon);
                } else {
                    UiBaseUtils.setVisibility(this.mSelectNum, 0);
                    UiBaseUtils.setTextString(this.mSelectNum, String.valueOf(getIndex(this.mList.get(this.mIndex).contentUri)));
                    UiBaseUtils.setViewDrawableResource(this.mSelectNum, R.drawable.ugc_select_preview_bg);
                }
            } else {
                UiBaseUtils.setVisibility(this.mSelectNum, 8);
                UiBaseUtils.setViewDrawableResource(this.mSelectImg, R.drawable.ugc_unselected_icon);
            }
            UiBaseUtils.setViewDrawableResource(this.mFinishTv, R.drawable.ugc_photo_preview_finish_bg);
            UiBaseUtils.setTextColorResource(this.mFinishTv, R.color.ugc_select_finish_tv_color);
            if (SelectUtil.getSelectedCount() != 0) {
                string = getString(R.string.ugc_preview_finish) + "(" + SelectUtil.getSelectedCount() + ")";
            } else {
                string = getString(R.string.ugc_preview_finish);
            }
            UiBaseUtils.setTextString(this.mFinishTv, string);
        } else if (TextUtils.equals(this.mFrom, "publish") || TextUtils.equals(this.mFrom, "comment")) {
            UiBaseUtils.setVisibility(this.mBottomView, 8);
            UiBaseUtils.setVisibility(this.mDeleteImgBg, 0);
            UiBaseUtils.setVisibility(this.mFinishTv, 8);
            UiBaseUtils.setImageResource(this.mDeleteImg, R.drawable.ugc_delete_selector);
            UiBaseUtils.setTextString(this.mFinishTv, getString(R.string.ugc_preview_finish));
        }
        UiBaseUtils.setTextString(this.mPhotoPages, (this.mIndex + 1) + "/" + this.mList.size());
        this.tintManager.setStatusBarTintResource(R.color.ugc_common_black);
        if (Build.VERSION.SDK_INT >= 19 && this.mPhotoHeader != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mPhotoHeader.getLayoutParams();
            layoutParams.topMargin = Utils.getStatusHeight(this);
            this.mPhotoHeader.setLayoutParams(layoutParams);
        }
    }

    private void updateUi() {
        UiBaseUtils.setViewColor(findViewById(R.id.ugc_photo_content), R.color.ugc_common_black);
        UiBaseUtils.setViewColor(this.mViewpager, R.color.ugc_common_black);
        UiBaseUtils.setViewColor(this.mPhotoHeader, R.color.ugc_preview_header_bg);
        UiBaseUtils.setImageResource((ImageView) findViewById(R.id.ugc_photo_preview_back), R.drawable.ugc_back_selector);
        UiBaseUtils.setViewColor(this.mBottomView, R.color.ugc_preview_header_bg);
        UiBaseUtils.setTextResource((TextView) findViewById(R.id.ugc_photo_select), R.color.ugc_preview_select_number_text);
        UiBaseUtils.setTextResource(this.mPhotoPages, R.color.ugc_preview_number_tv);
        UiBaseUtils.setTextResource(this.mPhotoPages, R.color.ugc_preview_number_tv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.appframework.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        UgcUBCUtils.enterUgc(this.mNoStatistics);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.appframework.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        UgcUBCUtils.exitPages(0, UgcUBCUtils.mPublishPreviewPage, this.mNoStatistics);
    }

    private void finishAct() {
        if (this.mList != null) {
            this.mList.clear();
            this.mIndex = 0;
            if (this.mAdapter != null) {
                this.mAdapter.notifyDataSetChanged();
            }
        }
        finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageStruct imageStruct;
        String string;
        int id = view.getId();
        if (id == R.id.ugc_photo_select_delete_img) {
            if (this.mIndex >= 0 && this.mIndex < this.mList.size()) {
                if (SelectUtil.getSelectedCount() > 1) {
                    if (mListener != null) {
                        mListener.onDeletePhotoEvent(this.mIndex, SelectUtil.getSeletedImages().get(this.mIndex).contentUri);
                    }
                    SelectUtil.removeSelectedImags(SelectUtil.getSeletedImages().get(this.mIndex));
                    this.mAdapter.setData(SelectUtil.getSeletedImages());
                    if (this.mIndex == SelectUtil.getSelectedCount()) {
                        UiBaseUtils.setTextString(this.mPhotoPages, "1/" + SelectUtil.getSelectedCount());
                        return;
                    } else {
                        UiBaseUtils.setTextString(this.mPhotoPages, (this.mIndex + 1) + "/" + SelectUtil.getSelectedCount());
                        return;
                    }
                }
                if (mListener != null) {
                    mListener.onDeletePhotoEvent(this.mIndex, SelectUtil.getSeletedImages().get(this.mIndex).contentUri);
                } else {
                    setResult(-1);
                }
                SelectUtil.clear();
                finishAct();
            }
        } else if (id == ResourceUtils.getResIdByName("ugc_photo_select_view")) {
            if ((TextUtils.equals(this.mFrom, "album") || TextUtils.equals(this.mFrom, "bottomPreview")) && this.mIndex >= 0 && this.mIndex < this.mList.size() && (imageStruct = this.mList.get(this.mIndex)) != null) {
                if (SelectUtil.hasImage(imageStruct)) {
                    SelectUtil.removeSelectedImags(imageStruct);
                    this.mSelectNum.setVisibility(8);
                    UiBaseUtils.setViewDrawable(this.mSelectImg, R.drawable.ugc_unselected_icon);
                    if (SelectUtil.getSelectedCount() > 0) {
                        string = getString(R.string.ugc_preview_finish) + "(" + SelectUtil.getSelectedCount() + ")";
                    } else {
                        string = getString(R.string.ugc_preview_finish);
                    }
                    UiBaseUtils.setTextString(this.mFinishTv, string);
                } else if (SelectUtil.getSelectedCount() == SelectUtil.maxSelected) {
                    UniversalToast.makeText(AppRuntime.getAppContext(), String.format(getResources().getString(R.string.ugc_album_selected_max_photos), Integer.valueOf(SelectUtil.getSelectedCount()))).showToast();
                } else if (this.mSupportSingleSelect && SelectUtil.getSelectedCount() == 1) {
                    UniversalToast.makeText(AppRuntime.getAppContext(), R.string.ugc_preview_selected_max_photos_single_select).setDuration(1).showToast();
                } else if (AlbumUriUtils.isImageLegal(imageStruct)) {
                    if (this.mSupportSingleSelect) {
                        SelectUtil.clear();
                    }
                    SelectUtil.saveSelectedImages(imageStruct);
                    String str = getString(R.string.ugc_preview_finish) + "(" + SelectUtil.getSelectedCount() + ")";
                    if (this.mSupportSingleSelect) {
                        UiBaseUtils.setVisibility(this.mSelectNum, 8);
                        UiBaseUtils.setVisibility(this.mSelectImg, 0);
                        UiBaseUtils.setViewDrawableResource(this.mSelectImg, R.drawable.ugc_selected_icon);
                    } else {
                        UiBaseUtils.setVisibility(this.mSelectNum, 0);
                        UiBaseUtils.setTextString(this.mSelectNum, String.valueOf(getIndex(imageStruct.contentUri)));
                        UiBaseUtils.setViewDrawableResource(this.mSelectNum, R.drawable.ugc_select_preview_bg);
                    }
                    UiBaseUtils.setTextString(this.mFinishTv, str);
                    UiBaseUtils.setTextColorResource(this.mFinishTv, R.color.ugc_select_finish_tv_color);
                }
            }
        } else if (id == ResourceUtils.getResIdByName("ugc_photo_back")) {
            UgcUBCUtils.clickLayerStatistics(0, UgcUBCUtils.mPicPreviewBtnPage, this.mNoStatistics);
            backDown();
            finish();
        } else if (id == ResourceUtils.getResIdByName("ugc_photo_finish")) {
            UgcUBCUtils.clickLayerStatistics(1, UgcUBCUtils.mPicPreviewBtnPage, this.mNoStatistics);
            if (SelectUtil.getSelectedCount() == 0 && this.mList != null && this.mList.size() > 0 && this.mIndex < this.mList.size()) {
                SelectUtil.saveSelectedImages(this.mList.get(this.mIndex));
                UiBaseUtils.setVisibility(this.mSelectNum, 0);
                UiBaseUtils.setTextString(this.mSelectNum, String.valueOf(getIndex(this.mList.get(this.mIndex).contentUri)));
                UiBaseUtils.setViewDrawableResource(this.mSelectNum, R.drawable.ugc_select_preview_bg);
            }
            Intent intent = new Intent();
            intent.putExtra("isRefersh", false);
            setResult(-1, intent);
            finishAct();
        }
    }

    @Override // com.baidu.searchbox.appframework.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            backDown();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void backDown() {
        Intent intent = new Intent();
        intent.putExtra("isRefersh", true);
        setResult(-1, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getIndex(Uri uri) {
        for (int i = 0; i < SelectUtil.getPath().size(); i++) {
            if (uri.equals(SelectUtil.getPath().get(i).contentUri)) {
                return i + 1;
            }
        }
        return 0;
    }

    @Override // com.baidu.searchbox.ugc.adapter.LocalAlbumAdapter.ClickPagerViewListener
    public void clickContainer() {
        float y = UiBaseUtils.getY(this.mPhotoHeader);
        float y2 = UiBaseUtils.getY(this.mBottomView);
        if (!this.mAnimation && this.mBarShowing) {
            this.mAnimation = true;
            ObjectAnimator objectAnimator = null;
            if (Build.VERSION.SDK_INT >= 19) {
                if (this.mPhotoHeader != null) {
                    objectAnimator = ObjectAnimator.ofFloat(this.mPhotoHeader, "y", y, (y - this.mPhotoHeader.getHeight()) - Utils.getStatusHeight(this));
                    objectAnimator.setDuration(this.mDuration);
                    objectAnimator.start();
                }
                this.tintManager.setStatusBarTintResource(R.color.ugc_transparent);
                if (Build.VERSION.SDK_INT >= 16) {
                    findViewById(ResourceUtils.getResIdByName("ugc_photo_content")).setSystemUiVisibility(4);
                }
            } else if (this.mPhotoHeader != null) {
                objectAnimator = ObjectAnimator.ofFloat(this.mPhotoHeader, "y", y, y - this.mPhotoHeader.getHeight());
                objectAnimator.setDuration(this.mDuration);
                objectAnimator.start();
            }
            UiBaseUtils.addAnimatorListener(objectAnimator, new Animator.AnimatorListener() { // from class: com.baidu.searchbox.ugc.activity.LocalPhotoPreviewActivity.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    LocalPhotoPreviewActivity.this.mAnimation = false;
                    LocalPhotoPreviewActivity.this.mBarShowing = LocalPhotoPreviewActivity.this.mBarShowing ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            if (this.mBottomView != null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mBottomView, "y", y2, y2 + this.mBottomView.getHeight());
                ofFloat.setDuration(this.mDuration);
                ofFloat.start();
            }
        } else if (!this.mAnimation && !this.mBarShowing) {
            this.mAnimation = true;
            ObjectAnimator objectAnimator2 = null;
            if (Build.VERSION.SDK_INT >= 19) {
                if (this.mPhotoHeader != null) {
                    objectAnimator2 = ObjectAnimator.ofFloat(this.mPhotoHeader, "y", y, y + this.mPhotoHeader.getHeight() + Utils.getStatusHeight(this));
                    objectAnimator2.setDuration(this.mDuration);
                    objectAnimator2.start();
                }
                this.tintManager.setStatusBarTintResource(R.color.ugc_common_black);
                if (Build.VERSION.SDK_INT >= 16) {
                    findViewById(ResourceUtils.getResIdByName("ugc_photo_content")).setSystemUiVisibility(1024);
                }
            } else if (this.mPhotoHeader != null) {
                objectAnimator2 = ObjectAnimator.ofFloat(this.mPhotoHeader, "y", y, y + this.mPhotoHeader.getHeight());
                objectAnimator2.setDuration(this.mDuration);
                objectAnimator2.start();
            }
            UiBaseUtils.addAnimatorListener(objectAnimator2, new Animator.AnimatorListener() { // from class: com.baidu.searchbox.ugc.activity.LocalPhotoPreviewActivity.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    LocalPhotoPreviewActivity.this.mAnimation = false;
                    LocalPhotoPreviewActivity.this.mBarShowing = LocalPhotoPreviewActivity.this.mBarShowing ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            if (this.mBottomView != null) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mBottomView, "y", y2, y2 - this.mBottomView.getHeight());
                ofFloat2.setDuration(this.mDuration);
                ofFloat2.start();
            }
        }
    }

    public static void launchLocalPreviewActivity(Context context, String str, OnDeletePreviewPhotoListener onDeletePreviewPhotoListener) {
        Intent intent = new Intent(context, LocalPhotoPreviewActivity.class);
        intent.putExtra("from", str);
        intent.setFlags(536870912);
        BaseActivity.setNextPendingTransition(R.anim.ugc_photo_preview_enter, R.anim.publisher_hold, R.anim.publisher_hold, R.anim.ugc_photo_preview_exit);
        context.startActivity(intent);
        mListener = onDeletePreviewPhotoListener;
    }

    public static void openPreviewer(Context context, String str, int i, OnDeletePreviewPhotoListener onDeletePreviewPhotoListener) {
        Intent intent = new Intent(context, LocalPhotoPreviewActivity.class);
        intent.putExtra("from", str);
        intent.putExtra("position", i);
        setNextPendingTransition(R.anim.ugc_photo_preview_enter, R.anim.publisher_hold, R.anim.publisher_hold, R.anim.ugc_photo_preview_exit);
        context.startActivity(intent);
        mListener = onDeletePreviewPhotoListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.appframework.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        mListener = null;
    }

    public static void startForResultIfNotRunning(Activity activity, Intent intent, int i) {
        if (activity != null && !isRunning) {
            isRunning = true;
            activity.startActivityForResult(intent, i);
        }
    }

    @Override // com.baidu.searchbox.appframework.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        isRunning = false;
    }
}
