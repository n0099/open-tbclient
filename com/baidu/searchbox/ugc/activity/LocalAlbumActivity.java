package com.baidu.searchbox.ugc.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.android.ext.widget.dialog.BoxAlertDialog;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.media.MimeType;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.publisher.base.PublisherConfig;
import com.baidu.searchbox.publisher.base.Utils;
import com.baidu.searchbox.publisher.controller.PublisherManagerFactory;
import com.baidu.searchbox.publisher.event.StartPublishEvent;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ugc.adapter.AlbumListAdapter;
import com.baidu.searchbox.ugc.adapter.ImageAdapter;
import com.baidu.searchbox.ugc.album.R;
import com.baidu.searchbox.ugc.model.ImageGroup;
import com.baidu.searchbox.ugc.model.ImageStruct;
import com.baidu.searchbox.ugc.model.VideoInfo;
import com.baidu.searchbox.ugc.provider.listener.OnSelectPhotoListener;
import com.baidu.searchbox.ugc.utils.ImageHelper;
import com.baidu.searchbox.ugc.utils.ImageLoadTask;
import com.baidu.searchbox.ugc.utils.OnTaskResultListener;
import com.baidu.searchbox.ugc.utils.ResourceUtils;
import com.baidu.searchbox.ugc.utils.SelectUtil;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.searchbox.ugc.utils.UiBaseUtils;
import com.baidu.searchbox.ugc.utils.VideoLoadTask;
import com.baidu.searchbox.ugc.view.HeightListView;
import com.baidu.searchbox.ugc.view.LoadingLayout;
import com.baidu.searchbox.ugc.webjs.UgcSchemeModel;
import com.baidu.webkit.sdk.PermissionRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class LocalAlbumActivity extends BaseActivity implements View.OnClickListener {
    public static final String KEY_NO_STATISTIC = "noStatistics";
    private static final int PHOTO_ALBUM = 0;
    public static final int UGC_REQUEST_IMAGE_TAKE = 2;
    public static final int UGC_REQUEST_PERMISSION_CAMERA = 1;
    public static final int UGC_REQUEST_VIDEO_PLAY = 3;
    private static final int VIDEO_ALBUM = 1;
    private static OnSelectPhotoListener mListener = null;
    private static final int sLISTVIEWHEIGTH = 400;
    private AlbumListAdapter mAblumAdapter;
    private ImageAdapter mAdapter;
    private RelativeLayout mBottomPreviewLayout;
    private TextView mBottomPreviewTv;
    private TextView mCancel;
    private LoadingLayout mEmptyView;
    private int mFromType;
    private GridView mGridView;
    ImageLoadTask mImageLoadTask;
    private UgcSchemeModel mInfo;
    private String mLaunchFrom;
    private int mMaxListHeight;
    private int mMaxSelected;
    private boolean mNoStatistics;
    private View mPhotoListBg;
    private View mPhotoListLayout;
    private HeightListView mPhotoListView;
    private TextView mSelectedNumbers;
    private TextView mSwitchAlbum;
    VideoLoadTask mVideoLoadTask;
    private boolean mIsOpenedList = false;
    private boolean mIsAnimationing = false;
    private List<ImageGroup> mGroupImages = new ArrayList();
    private List<VideoInfo> mVideoList = new ArrayList();
    private List<ImageStruct> mSelectedPhotos = new ArrayList();
    private boolean mSingleSelected = false;
    private AdapterView.OnItemClickListener listviewItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.searchbox.ugc.activity.LocalAlbumActivity.7
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (LocalAlbumActivity.this.mIsOpenedList && !LocalAlbumActivity.this.mIsAnimationing) {
                LocalAlbumActivity.this.startHideAnimation();
            }
            UiBaseUtils.setTextString(LocalAlbumActivity.this.mSwitchAlbum, ((ImageGroup) LocalAlbumActivity.this.mGroupImages.get(i)).getBucketName());
            List<ImageStruct> list = ((ImageGroup) LocalAlbumActivity.this.mGroupImages.get(i)).images;
            LocalAlbumActivity.this.mAdapter.setPhotoData(list, true);
            UiBaseUtils.setVisibility(LocalAlbumActivity.this.mBottomPreviewLayout, list.size() == 0 ? 8 : 0);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.appframework.BaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ugc_local_album_layout);
        if (getIntent() != null) {
            this.mInfo = (UgcSchemeModel) getIntent().getSerializableExtra("data");
            if (this.mInfo != null) {
                this.mFromType = this.mInfo.from;
                this.mLaunchFrom = this.mInfo.launchFrom;
                this.mSingleSelected = this.mInfo.supportSingleSelect;
                this.mNoStatistics = this.mInfo.noStatistics;
                this.mMaxSelected = this.mInfo.maxSelected;
            } else {
                this.mLaunchFrom = getIntent().getStringExtra("launchFrom");
            }
        }
        if (this.mMaxSelected > 0) {
            SelectUtil.maxSelected = this.mMaxSelected;
        } else {
            SelectUtil.maxSelected = SelectUtil.MAX_SELECTED_DEFAULT;
        }
        initView();
        if (PublisherConfig.getPublisherVersion() == 1) {
            updateUi();
        }
        initData();
        if (this.mFromType == 0) {
            UgcUBCUtils.ugcPvStatistics(0, UgcUBCUtils.mPublishChoicePage, this.mNoStatistics);
        } else {
            UgcUBCUtils.ugcPvStatistics(1, UgcUBCUtils.mPublishChoicePage, this.mNoStatistics);
        }
    }

    private void initView() {
        this.mGridView = (GridView) findViewById(ResourceUtils.getResIdByName("ugc_item_gridview"));
        this.mSwitchAlbum = (TextView) findViewById(ResourceUtils.getResIdByName("ugc_album_name"));
        this.mSelectedNumbers = (TextView) findViewById(ResourceUtils.getResIdByName("ugc_done"));
        this.mBottomPreviewTv = (TextView) findViewById(ResourceUtils.getResIdByName("ugc_bottom_preview_tv"));
        this.mBottomPreviewLayout = (RelativeLayout) findViewById(ResourceUtils.getResIdByName("bottom_pre_container"));
        this.mPhotoListLayout = findViewById(ResourceUtils.getResIdByName("ugc_photo_list_layout"));
        this.mPhotoListView = (HeightListView) findViewById(ResourceUtils.getResIdByName("ugc_album_list"));
        this.mPhotoListBg = findViewById(ResourceUtils.getResIdByName("ugc_photo_list_bg"));
        this.mEmptyView = (LoadingLayout) findViewById(ResourceUtils.getResIdByName("ugc_loadding"));
        this.mCancel = (TextView) findViewById(ResourceUtils.getResIdByName("ugc_cancel"));
        this.mMaxListHeight = DeviceUtil.ScreenInfo.dp2px(this, 400.0f);
        if (this.mPhotoListView != null) {
            this.mPhotoListView.setListViewHeight(this.mMaxListHeight);
        }
        UiBaseUtils.setOnClickListener(this.mSwitchAlbum, this);
        UiBaseUtils.setOnClickListener(this.mCancel, this);
        UiBaseUtils.setOnClickListener(this.mSelectedNumbers, this);
        UiBaseUtils.setOnClickListener(this.mBottomPreviewTv, this);
        UiBaseUtils.setOnTouchListener(this.mPhotoListLayout, new View.OnTouchListener() { // from class: com.baidu.searchbox.ugc.activity.LocalAlbumActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (LocalAlbumActivity.this.mIsOpenedList && !LocalAlbumActivity.this.mIsAnimationing) {
                    LocalAlbumActivity.this.startHideAnimation();
                    return true;
                }
                return true;
            }
        });
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) UiBaseUtils.getLayoutParams(this.mGridView);
        if (this.mFromType == 0) {
            UiBaseUtils.setTextStringResource(this.mSwitchAlbum, R.string.ugc_album_all_photos);
            UiBaseUtils.setVisibility(this.mBottomPreviewLayout, 0);
            if (layoutParams != null) {
                layoutParams.setMargins(0, 0, 0, DeviceUtil.ScreenInfo.dp2px(this, 42.0f));
            }
        } else {
            UiBaseUtils.setTextStringResource(this.mSwitchAlbum, R.string.ugc_album_all_videos);
            UiBaseUtils.setVisibility(this.mBottomPreviewLayout, 8);
            if (layoutParams != null) {
                layoutParams.setMargins(0, 0, 0, 0);
            }
        }
        UiBaseUtils.setLayoutParams(this.mGridView, layoutParams);
        this.mSelectedPhotos.addAll(SelectUtil.getSeletedImages());
    }

    private void updateUi() {
        UiBaseUtils.setViewColor(findViewById(R.id.ugc_local_album_root), R.color.ugc_white);
        UiBaseUtils.setViewColor(this.mGridView, R.color.ugc_white);
        UiBaseUtils.setViewColor(findViewById(R.id.ugc_header), R.color.ugc_white);
        UiBaseUtils.setViewColor(findViewById(R.id.bottom_pre_container), R.color.ugc_white);
        UiBaseUtils.setTextResource(this.mCancel, R.color.ugc_album_unable_click_color);
        UiBaseUtils.setTextResource(this.mSwitchAlbum, R.color.ugc_black);
        UiBaseUtils.setTextResource(this.mSelectedNumbers, R.color.ugc_publish_no_able_color);
        UiBaseUtils.setTextResource(this.mBottomPreviewTv, R.color.ugc_bottom_preview_neg_color);
        UiBaseUtils.setViewColor(findViewById(R.id.ugc_line), R.color.ugc_album_titleline_color);
        UiBaseUtils.setViewColor(this.mPhotoListBg, R.color.ugc_album_files_bg);
        UiBaseUtils.setViewColor(this.mEmptyView, R.color.ugc_white);
        if (NightModeHelper.getNightModeSwitcherState()) {
            UiBaseUtils.setViewDrawable(this.mPhotoListView, R.drawable.ugc_album_list_night_bg);
        } else {
            UiBaseUtils.setViewDrawable(this.mPhotoListView, R.drawable.ugc_album_list_bg);
        }
    }

    private void initData() {
        if (this.mFromType == 0) {
            if (this.mImageLoadTask == null || this.mImageLoadTask.getStatus() != AsyncTask.Status.RUNNING) {
                if (this.mEmptyView != null) {
                    this.mEmptyView.showLoading(true);
                }
                this.mImageLoadTask = new ImageLoadTask(this, new OnTaskResultListener() { // from class: com.baidu.searchbox.ugc.activity.LocalAlbumActivity.2
                    @Override // com.baidu.searchbox.ugc.utils.OnTaskResultListener
                    public void onResult(boolean z, String str, Object obj) {
                        if (z && obj != null && (obj instanceof List)) {
                            LocalAlbumActivity.this.notifyUi(obj);
                        }
                    }
                });
                this.mImageLoadTask.execute(new Void[0]);
            }
        } else if (this.mVideoLoadTask == null || this.mVideoLoadTask.getStatus() != AsyncTask.Status.RUNNING) {
            if (this.mEmptyView != null) {
                this.mEmptyView.showLoading(true);
            }
            this.mVideoLoadTask = new VideoLoadTask(this, new OnTaskResultListener() { // from class: com.baidu.searchbox.ugc.activity.LocalAlbumActivity.3
                @Override // com.baidu.searchbox.ugc.utils.OnTaskResultListener
                public void onResult(boolean z, String str, Object obj) {
                    if (z && obj != null && (obj instanceof List)) {
                        LocalAlbumActivity.this.notifyUi(obj);
                    }
                }
            });
            this.mVideoLoadTask.execute(new Void[0]);
        }
    }

    private void initImageAdapter() {
        this.mAdapter = new ImageAdapter(this, this.mFromType, this.mSingleSelected, this.mNoStatistics);
        if (this.mGridView != null) {
            this.mGridView.setAdapter((ListAdapter) this.mAdapter);
        }
        if (this.mFromType == 0) {
            this.mAdapter.setPhotoData(this.mGroupImages.get(0).images, true);
        } else {
            this.mAdapter.setVideoData(this.mVideoList, false, this.mLaunchFrom);
        }
        this.mAdapter.setListener(new ImageAdapter.SelectChangedListener() { // from class: com.baidu.searchbox.ugc.activity.LocalAlbumActivity.4
            @Override // com.baidu.searchbox.ugc.adapter.ImageAdapter.SelectChangedListener
            public void selectChanged(int i) {
                LocalAlbumActivity.this.changeNumberUi();
            }
        });
    }

    private void initAlbumAdapter() {
        this.mAblumAdapter = new AlbumListAdapter(this, this.mGroupImages);
        this.mPhotoListView.setAdapter((ListAdapter) this.mAblumAdapter);
        this.mPhotoListView.setOnItemClickListener(this.listviewItemClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUi(Object obj) {
        if (this.mEmptyView != null) {
            this.mEmptyView.showLoading(false);
        }
        if (this.mFromType == 0) {
            this.mGroupImages = (List) obj;
            if (this.mGroupImages.size() > 0) {
                if (this.mGroupImages.get(0).getImages().size() == 0) {
                    UiBaseUtils.setVisibility(this.mBottomPreviewLayout, 8);
                    if (PublisherConfig.getIsShowCamera()) {
                        initImageAdapter();
                        return;
                    } else {
                        this.mEmptyView.showEmpty(this.mFromType);
                        return;
                    }
                }
                Drawable drawable = getResources().getDrawable(R.drawable.ugc_album_up_triangle);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                UiBaseUtils.setCompoundDrawables(this.mSwitchAlbum, null, null, drawable, null);
                UiBaseUtils.setCompoundDrawablePadding(this.mSwitchAlbum, DeviceUtil.ScreenInfo.dp2px(this, 4.0f));
            } else {
                UiBaseUtils.setVisibility(this.mBottomPreviewLayout, 8);
            }
            UiBaseUtils.setVisibility(this.mSelectedNumbers, 0);
            changeNumberUi();
            initAlbumAdapter();
        } else {
            this.mVideoList = (List) obj;
        }
        initImageAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeNumberUi() {
        if (SelectUtil.getSelectedCount() > 0) {
            UiBaseUtils.setTextColorResource(this.mSelectedNumbers, R.color.ugc_album_selected_finish_color);
            UiBaseUtils.setTextColorResource(this.mBottomPreviewTv, R.color.ugc_bottom_preview_pos_color);
            if (!this.mSingleSelected) {
                UiBaseUtils.setTextString(this.mSelectedNumbers, getResources().getString(R.string.ugc_album_selected_done) + "(" + SelectUtil.getSelectedCount() + ")");
            } else {
                UiBaseUtils.setTextStringResource(this.mSelectedNumbers, R.string.ugc_album_selected_done);
            }
            UiBaseUtils.setEnabled(this.mSelectedNumbers, true);
            UiBaseUtils.setEnabled(this.mBottomPreviewTv, true);
            return;
        }
        UiBaseUtils.setTextColorResource(this.mSelectedNumbers, R.color.ugc_publish_dialog_line_color);
        UiBaseUtils.setTextColorResource(this.mBottomPreviewTv, R.color.ugc_bottom_preview_neg_color);
        UiBaseUtils.setTextStringResource(this.mSelectedNumbers, R.string.ugc_album_selected_done);
        UiBaseUtils.setEnabled(this.mSelectedNumbers, false);
        UiBaseUtils.setEnabled(this.mBottomPreviewTv, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == ResourceUtils.getResIdByName("ugc_album_name")) {
            UgcUBCUtils.clickLayerStatistics(2, UgcUBCUtils.mPicChoiceBtnPage, this.mNoStatistics);
            if (this.mGroupImages != null && this.mGroupImages.size() > 1 && this.mFromType == 0 && !this.mIsAnimationing) {
                if (this.mIsOpenedList) {
                    startHideAnimation();
                } else {
                    startShowAnimation();
                }
            }
        } else if (view.getId() == ResourceUtils.getResIdByName("ugc_done")) {
            if (mListener != null && SelectUtil.getSelectedCount() > 0) {
                mListener.onSelectPhoto(SelectUtil.getPathUrlList());
            } else if (SelectUtil.getSelectedCount() > 0) {
                UgcUBCUtils.clickLayerStatistics(1, UgcUBCUtils.mPicChoiceBtnPage, this.mNoStatistics);
                if (TextUtils.equals("menu", this.mLaunchFrom)) {
                    if (PublisherManagerFactory.get().getTextImagePublishActivity() != null) {
                        goPublishActivity(new Intent(this, PublisherManagerFactory.get().getTextImagePublishActivity()));
                    } else {
                        return;
                    }
                } else if (TextUtils.equals("baidu_bridge", this.mLaunchFrom)) {
                    sendBroadcastToBridge();
                } else {
                    setResult(-1);
                }
            }
            finish();
        } else if (view.getId() == ResourceUtils.getResIdByName("ugc_cancel")) {
            SelectUtil.setSeletedImages(this.mSelectedPhotos);
            if (this.mFromType == 0) {
                UgcUBCUtils.clickLayerStatistics(this.mFromType, UgcUBCUtils.mPicChoiceBtnPage, this.mNoStatistics);
            } else {
                UgcUBCUtils.clickLayerStatistics(0, UgcUBCUtils.mVideoChoiceBtnPage, this.mNoStatistics);
                UgcUBCUtils.clickLayerStatistics(0, UgcUBCUtils.mVideoChoiceBtnPage);
            }
            if (mListener != null) {
                mListener.onCanceled();
            }
            finish();
        } else if (view.getId() == ResourceUtils.getResIdByName("ugc_bottom_preview_tv") && SelectUtil.getSelectedCount() > 0) {
            Intent intent = new Intent(this, LocalPhotoPreviewActivity.class);
            intent.putExtra("position", 0);
            intent.putExtra("from", "bottomPreview");
            intent.putExtra("isSupportSingle", this.mSingleSelected);
            setNextPendingTransition(R.anim.ugc_photo_preview_enter, R.anim.publisher_hold, R.anim.publisher_hold, R.anim.ugc_photo_preview_exit);
            LocalPhotoPreviewActivity.startForResultIfNotRunning(this, intent, 32770);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startHideAnimation() {
        if (this.mIsOpenedList) {
            this.mIsAnimationing = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.ugc_photo_list_out_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.mPhotoListView.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.searchbox.ugc.activity.LocalAlbumActivity.5
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    LocalAlbumActivity.this.mIsOpenedList = false;
                    LocalAlbumActivity.this.mIsAnimationing = false;
                    if (LocalAlbumActivity.this.mPhotoListLayout != null) {
                        LocalAlbumActivity.this.mPhotoListLayout.setVisibility(8);
                    }
                    if (LocalAlbumActivity.this.mPhotoListView != null) {
                        LocalAlbumActivity.this.mPhotoListView.setVisibility(8);
                    }
                    Drawable drawable = LocalAlbumActivity.this.getResources().getDrawable(R.drawable.ugc_album_up_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    UiBaseUtils.setCompoundDrawables(LocalAlbumActivity.this.mSwitchAlbum, null, null, drawable, null);
                }
            });
            UiBaseUtils.startAnimation(this.mPhotoListBg, AnimationUtils.loadAnimation(this, R.anim.ugc_photo_bg_out_animation));
        }
    }

    private void startShowAnimation() {
        if (!this.mIsOpenedList) {
            UiBaseUtils.setVisibility(this.mPhotoListLayout, 0);
            UiBaseUtils.setVisibility(this.mPhotoListView, 0);
            this.mIsAnimationing = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.ugc_photo_list_in_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            UiBaseUtils.startAnimation(this.mPhotoListView, loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.searchbox.ugc.activity.LocalAlbumActivity.6
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    LocalAlbumActivity.this.mIsOpenedList = true;
                    LocalAlbumActivity.this.mIsAnimationing = false;
                    Drawable drawable = LocalAlbumActivity.this.getResources().getDrawable(R.drawable.ugc_album_down_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    UiBaseUtils.setCompoundDrawables(LocalAlbumActivity.this.mSwitchAlbum, null, null, drawable, null);
                }
            });
            UiBaseUtils.startAnimation(this.mPhotoListBg, AnimationUtils.loadAnimation(this, R.anim.ugc_photo_bg_in_animation));
        }
    }

    @Override // com.baidu.searchbox.appframework.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            SelectUtil.setSeletedImages(this.mSelectedPhotos);
            if (mListener != null) {
                mListener.onCanceled();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.appframework.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        File takeImageFile;
        Intent intent2;
        super.onActivityResult(i, i2, intent);
        if (i == 32770 && i2 == -1) {
            if (intent != null ? intent.getBooleanExtra("isRefersh", false) : false) {
                if (this.mAdapter != null) {
                    this.mAdapter.notifyDataSetChanged();
                }
                changeNumberUi();
                return;
            }
            if (mListener != null && SelectUtil.getSelectedCount() > 0) {
                mListener.onSelectPhoto(SelectUtil.getPathUrlList());
            } else if (TextUtils.equals("menu", this.mLaunchFrom)) {
                if (PublisherManagerFactory.get().getTextImagePublishActivity() != null) {
                    goPublishActivity(new Intent(this, PublisherManagerFactory.get().getTextImagePublishActivity()));
                } else {
                    return;
                }
            } else if (TextUtils.equals("baidu_bridge", this.mLaunchFrom)) {
                sendBroadcastToBridge();
            } else {
                setResult(-1);
            }
            finish();
        } else if (i == 32771 && i2 == -1) {
            if (intent != null) {
                this.mInfo.path = intent.getStringExtra("path");
                if ("10".equals(this.mInfo.publishType)) {
                    if (PublisherManagerFactory.get().getReplyPublishActivity() != null) {
                        intent2 = new Intent(this, PublisherManagerFactory.get().getReplyPublishActivity());
                    } else {
                        return;
                    }
                } else if (PublisherManagerFactory.get().getVideoPublishActivity() != null) {
                    intent2 = new Intent(this, PublisherManagerFactory.get().getVideoPublishActivity());
                } else {
                    return;
                }
                if (TextUtils.equals(this.mLaunchFrom, "menu")) {
                    goPublishActivity(intent2);
                } else {
                    StartPublishEvent startPublishEvent = new StartPublishEvent();
                    startPublishEvent.videoPath = intent.getStringExtra("path");
                    EventBusWrapper.post(startPublishEvent);
                }
                finish();
            }
        } else if (i == 2) {
            UgcUBCUtils.exitPages(this.mFromType, UgcUBCUtils.mPublishShootPage, this.mNoStatistics);
            if (i2 == -1) {
                UgcUBCUtils.clickLayerStatistics(1, UgcUBCUtils.mPicShootcheckBtnPage, this.mNoStatistics);
                if (ImageHelper.getTakeImageFile() == null) {
                    takeImageFile = new File(DefaultSharedPrefsWrapper.getInstance().getString("take_photo", ""));
                } else {
                    takeImageFile = ImageHelper.getTakeImageFile();
                }
                ImageStruct imageStruct = new ImageStruct(takeImageFile.toString());
                if (this.mSingleSelected) {
                    SelectUtil.clear();
                }
                scanFile(takeImageFile.getAbsolutePath());
                SelectUtil.saveSelectedImages(imageStruct);
                if (mListener != null && SelectUtil.getSelectedCount() > 0) {
                    mListener.onSelectPhoto(SelectUtil.getPathUrlList());
                } else if (TextUtils.equals("menu", this.mLaunchFrom)) {
                    if (PublisherManagerFactory.get().getTextImagePublishActivity() != null) {
                        goPublishActivity(new Intent(this, PublisherManagerFactory.get().getTextImagePublishActivity()));
                    } else {
                        return;
                    }
                } else if (TextUtils.equals("baidu_bridge", this.mLaunchFrom)) {
                    sendBroadcastToBridge();
                } else {
                    setResult(-1);
                }
                finish();
                return;
            }
            UgcUBCUtils.clickLayerStatistics(0, UgcUBCUtils.mPicShootBtnPage, this.mNoStatistics);
        } else if (i == 3 && i2 == -1 && intent != null && PublisherManagerFactory.get().getVideoPublishActivity() != null) {
            Intent intent3 = new Intent(this, PublisherManagerFactory.get().getVideoPublishActivity());
            this.mInfo.path = intent.getStringExtra("path");
            if (TextUtils.equals(this.mLaunchFrom, "menu")) {
                goPublishActivity(intent3);
            } else {
                setResult(-1, intent3);
            }
            finish();
        }
    }

    private void sendBroadcastToBridge() {
        ArrayList<String> arrayList = new ArrayList<>();
        Intent intent = new Intent("com.baidu.searchbox.ugc.broadcast.action.LOCAL_ALBUM");
        for (ImageStruct imageStruct : SelectUtil.getSeletedImages()) {
            if (!TextUtils.isEmpty(imageStruct.uriStr)) {
                arrayList.add(imageStruct.uriStr);
            }
        }
        intent.putStringArrayListExtra("result", arrayList);
        sendBroadcast(intent);
        SelectUtil.clear();
    }

    private void goPublishActivity(Intent intent) {
        intent.putExtra("data", this.mInfo);
        startActivity(intent);
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
        UgcUBCUtils.exitPages(this.mFromType, UgcUBCUtils.mPublishChoicePage, this.mNoStatistics);
    }

    @Override // com.baidu.searchbox.appframework.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.ugc_slide_bottom_out);
        ImageHelper.clear();
        mListener = null;
    }

    public boolean checkPermission(String str) {
        return ActivityCompat.checkSelfPermission(this, str) == 0;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (iArr[0] == 0 && iArr[1] == 0) {
                ImageHelper.takePicture(this, 2);
            } else if (iArr[0] != 0) {
                showNoPermission(PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            } else {
                showNoPermission("android.permission.WRITE_EXTERNAL_STORAGE");
            }
        }
    }

    public void showNoPermission(String str) {
        String str2;
        if (str == PermissionRequest.RESOURCE_VIDEO_CAPTURE) {
            str2 = "请在手机的\"设置\"中，允许" + Utils.getAppName(this) + "App访问您的相机、录音权限";
        } else {
            str2 = "请在手机的\"设置\"中，允许" + Utils.getAppName(this) + "App访问您的文件存储权限";
        }
        new BoxAlertDialog.Builder(this).setTitle(R.string.video_capture_dialog_tip).setMessage(str2).setNegativeButton(R.string.video_capture_confirm, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ugc.activity.LocalAlbumActivity.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).setPositiveButton(R.string.video_capture_go_settings, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ugc.activity.LocalAlbumActivity.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", LocalAlbumActivity.this.getPackageName(), null));
                intent.setFlags(268435456);
                LocalAlbumActivity.this.startActivity(intent);
                dialogInterface.dismiss();
            }
        }).show();
    }

    public static void startActivity(Context context, UgcSchemeModel ugcSchemeModel, OnSelectPhotoListener onSelectPhotoListener) {
        Intent intent = new Intent(context, LocalAlbumActivity.class);
        intent.putExtra("data", ugcSchemeModel);
        mListener = onSelectPhotoListener;
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.ugc_slide_bottom_in, R.anim.ugc_slide_bottom_out);
    }

    private void scanFile(String str) {
        MediaScannerConnection.scanFile(this, new String[]{str}, new String[]{MimeType.Image.PNG, MimeType.Image.JPEG}, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.baidu.searchbox.ugc.activity.LocalAlbumActivity.10
            @Override // android.media.MediaScannerConnection.OnScanCompletedListener
            public void onScanCompleted(String str2, Uri uri) {
                SelectUtil.replaceImageUri(str2, uri);
            }
        });
    }
}
