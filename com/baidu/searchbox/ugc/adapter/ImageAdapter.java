package com.baidu.searchbox.ugc.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.StorageUtils;
import com.baidu.android.util.media.MimeType;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.pyramid.runtime.service.c;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.publisher.video.interfaces.IPublisherSboxVideoInterface;
import com.baidu.searchbox.ugc.activity.LocalAlbumActivity;
import com.baidu.searchbox.ugc.activity.LocalPhotoPreviewActivity;
import com.baidu.searchbox.ugc.album.R;
import com.baidu.searchbox.ugc.bridge.IUgcHostInterface;
import com.baidu.searchbox.ugc.bridge.UgcRuntime;
import com.baidu.searchbox.ugc.model.ImageStruct;
import com.baidu.searchbox.ugc.model.VideoInfo;
import com.baidu.searchbox.ugc.utils.AlbumUriUtils;
import com.baidu.searchbox.ugc.utils.ImageHelper;
import com.baidu.searchbox.ugc.utils.ResourceUtils;
import com.baidu.searchbox.ugc.utils.SelectUtil;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.searchbox.ugc.utils.UiBaseUtils;
import com.baidu.webkit.sdk.PermissionRequest;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.b;
import com.facebook.imagepipeline.common.d;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class ImageAdapter extends BaseAdapter {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final int ITEM_TYPE_CAMERA = 0;
    private static final int ITEM_TYPE_NORMAL = 1;
    public static final int UGC_PHOTO_PREVIEW_REQUEST = 32770;
    public static final int UGC_VIDEO_PREVIEW_REQUEST = 32771;
    private static final long VIDEO_MIN_STORAGE_SIZE = 52428800;
    private static final int VIDEO_MIN_TIMELONG = 3000;
    private static final int VIDEO_MXA_TIMELONG = 301000;
    private int itemHeigth;
    private int itemWidth;
    private Activity mContext;
    private String mLaunchFrom;
    public SelectChangedListener mListener;
    private boolean mNoStatistics;
    private boolean mSingleSelected;
    private int mType;
    private List<ImageStruct> mImageList = new ArrayList();
    private List<VideoInfo> mVideoList = new ArrayList();
    private boolean isShowCamera = true;

    /* loaded from: classes12.dex */
    public interface SelectChangedListener {
        void selectChanged(int i);
    }

    public void setListener(SelectChangedListener selectChangedListener) {
        this.mListener = selectChangedListener;
    }

    public ImageAdapter(Activity activity, int i, boolean z, boolean z2) {
        this.mSingleSelected = false;
        this.itemWidth = DeviceUtil.ScreenInfo.getDisplayWidth(this.mContext) / 4;
        this.itemHeigth = DeviceUtil.ScreenInfo.getDisplayWidth(this.mContext) / 4;
        this.mContext = activity;
        this.mType = i;
        this.mSingleSelected = z;
        this.mNoStatistics = z2;
    }

    public void setPhotoData(List<ImageStruct> list, boolean z) {
        if (this.mImageList != null && this.mImageList.size() > 0) {
            this.mImageList.clear();
        }
        this.isShowCamera = z;
        if (this.mImageList != null) {
            this.mImageList.addAll(list);
        }
        ImageHelper.setImageList(this.mImageList);
        notifyDataSetChanged();
    }

    public void setVideoData(List<VideoInfo> list, boolean z, String str) {
        this.isShowCamera = z;
        this.mVideoList = list;
        this.mLaunchFrom = str;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mType == 0 ? this.isShowCamera ? this.mImageList.size() + 1 : this.mImageList.size() : this.isShowCamera ? this.mVideoList.size() + 1 : this.mVideoList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mType == 0) {
            if (this.isShowCamera) {
                if (i == 0) {
                    return null;
                }
                return this.mImageList.get(i - 1);
            }
            return this.mImageList.get(i);
        } else if (this.isShowCamera) {
            if (i != 0) {
                return this.mVideoList.get(i - 1);
            }
            return null;
        } else {
            return this.mVideoList.get(i);
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return (this.isShowCamera && i == 0) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        int itemViewType = getItemViewType(i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((DeviceUtil.ScreenInfo.getDisplayWidth(this.mContext) - DeviceUtil.ScreenInfo.dp2px(this.mContext, 10.0f)) / 4, (DeviceUtil.ScreenInfo.getDisplayWidth(this.mContext) - DeviceUtil.ScreenInfo.dp2px(this.mContext, 10.0f)) / 4);
        if (itemViewType == 0) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.ugc_camera_item, viewGroup, false);
            View findViewById = view.findViewById(ResourceUtils.getResIdByName("ugc_camera_enter"));
            UiBaseUtils.setViewColorResource(view.findViewById(ResourceUtils.getResIdByName("ugc_camera_root")), R.color.ugc_white);
            UiBaseUtils.setViewDrawableResource(findViewById, R.drawable.ugc_camera_bg);
            UiBaseUtils.setLayoutParams(findViewById, layoutParams);
            view.setTag(null);
            ImageView imageView = (ImageView) view.findViewById(ResourceUtils.getResIdByName("ugc_camera_icon"));
            if (imageView != null) {
                if (this.mType == 0) {
                    if (SelectUtil.getSelectedCount() == SelectUtil.maxSelected) {
                        imageView.setImageResource(R.drawable.ugc_camera_unenable_icon);
                    } else {
                        imageView.setImageResource(R.drawable.ugc_camera_item_selector);
                    }
                    if (this.mSingleSelected) {
                        if (SelectUtil.getSelectedCount() == 1) {
                            imageView.setImageResource(R.drawable.ugc_camera_unenable_icon);
                        } else {
                            imageView.setImageResource(R.drawable.ugc_camera_item_selector);
                        }
                    }
                }
                view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ugc.adapter.ImageAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        UgcUBCUtils.clickLayerStatistics(3, UgcUBCUtils.mPicChoiceBtnPage, ImageAdapter.this.mNoStatistics);
                        if (SelectUtil.getSelectedCount() < SelectUtil.maxSelected) {
                            if (!ImageAdapter.this.mSingleSelected || SelectUtil.getSelectedCount() != 1) {
                                final String[] strArr = {PermissionRequest.RESOURCE_VIDEO_CAPTURE, "android.permission.WRITE_EXTERNAL_STORAGE"};
                                if (UgcRuntime.getUgcInterface().isPermissionGroupGranted(ImageAdapter.this.mContext, strArr)) {
                                    ImageHelper.takePicture(ImageAdapter.this.mContext, 2);
                                    UgcUBCUtils.ugcPvStatistics(0, UgcUBCUtils.mPublishShootPage, ImageAdapter.this.mNoStatistics);
                                    return;
                                }
                                UgcRuntime.getUgcInterface().requestPermissionsDialog(UgcUBCUtils.UBC_DANGEROUS_PERMISSION_UGC_PIC_SOURCE, ImageAdapter.this.mContext, strArr, new IUgcHostInterface.RequestPermissionCallBack() { // from class: com.baidu.searchbox.ugc.adapter.ImageAdapter.1.1
                                    @Override // com.baidu.searchbox.ugc.bridge.IUgcHostInterface.RequestPermissionCallBack
                                    public void requestResult(String str, Boolean bool) {
                                    }

                                    @Override // com.baidu.searchbox.ugc.bridge.IUgcHostInterface.RequestPermissionCallBack
                                    public void isAllAgree(Boolean bool) {
                                        if (bool.booleanValue()) {
                                            ActivityCompat.requestPermissions(ImageAdapter.this.mContext, strArr, 1);
                                        }
                                    }

                                    @Override // com.baidu.searchbox.ugc.bridge.IUgcHostInterface.RequestPermissionCallBack
                                    public void isShow(String str, Boolean bool) {
                                    }
                                });
                            }
                        }
                    }
                });
            } else {
                UiBaseUtils.setImageResource(imageView, R.drawable.ugc_camera_video_selector);
                view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ugc.adapter.ImageAdapter.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        UgcUBCUtils.clickLayerStatistics(1, UgcUBCUtils.mVideoChoiceBtnPage, ImageAdapter.this.mNoStatistics);
                        if (StorageUtils.getAvailableExternalMemorySize() < 52428800) {
                            UniversalToast.makeText(AppRuntime.getAppContext(), ImageAdapter.this.mContext.getResources().getString(R.string.ugc_camera_no_storage_prompt)).showToast();
                        }
                        Intent intent = new Intent();
                        intent.putExtra("min_time", 3000);
                        intent.putExtra("max_time", MessageConfig.SOCKET_TIME_OUT_MS_2G);
                        intent.putExtra("from", "album");
                        IPublisherSboxVideoInterface iPublisherSboxVideoInterface = (IPublisherSboxVideoInterface) c.a(IPublisherSboxVideoInterface.SERVICE_REFERENCE);
                        if (iPublisherSboxVideoInterface != null) {
                            iPublisherSboxVideoInterface.openLocalVideoCapturectivity(ImageAdapter.this.mContext, intent);
                        }
                    }
                });
            }
        } else {
            if (view == null) {
                ViewHolder viewHolder2 = new ViewHolder();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.ugc_select_item, (ViewGroup) null);
                viewHolder2.mImageIv = (SimpleDraweeView) view.findViewById(ResourceUtils.getResIdByName("ugc_img"));
                viewHolder2.mSelectedCb = (ImageView) view.findViewById(ResourceUtils.getResIdByName("ugc_list_item_cb"));
                viewHolder2.orderNumber = (TextView) view.findViewById(ResourceUtils.getResIdByName("ugc_select_number"));
                viewHolder2.selectView = view.findViewById(ResourceUtils.getResIdByName("ugc_selected_check"));
                viewHolder2.selectCircle = view.findViewById(ResourceUtils.getResIdByName("ugc_select_circle_view"));
                viewHolder2.unableShadow = (ImageView) view.findViewById(ResourceUtils.getResIdByName("ugc_unable_shadow"));
                viewHolder2.rightBottomTipBg = view.findViewById(ResourceUtils.getResIdByName("ugc_video_time_bg"));
                viewHolder2.rightBottomTip = (TextView) view.findViewById(ResourceUtils.getResIdByName("ugc_right_bottom_tip"));
                view.setTag(viewHolder2);
                viewHolder = viewHolder2;
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            updateUi(viewHolder, view);
            UiBaseUtils.setLayoutParams(viewHolder.mImageIv, layoutParams);
            UiBaseUtils.setLayoutParams(viewHolder.unableShadow, layoutParams);
            UiBaseUtils.setVisibility(viewHolder.unableShadow, 8);
            UiBaseUtils.setVisibility(viewHolder.orderNumber, 8);
            UiBaseUtils.setVisibility(viewHolder.selectView, 8);
            UiBaseUtils.setVisibility(viewHolder.rightBottomTipBg, 8);
            if (this.mType == 0) {
                final ImageStruct imageStruct = (ImageStruct) getItem(i);
                UiBaseUtils.setVisibility(viewHolder.selectView, 0);
                UiBaseUtils.setImageResource(viewHolder.mSelectedCb, R.drawable.ugc_unselect_thumb_icon);
                if (imageStruct != null) {
                    setImageBg(imageStruct.contentUri, viewHolder);
                    if (SelectUtil.hasImage(imageStruct)) {
                        if (!this.mSingleSelected) {
                            UiBaseUtils.setImageResource(viewHolder.mSelectedCb, R.drawable.ugc_select_icon_bg);
                            UiBaseUtils.setVisibility(viewHolder.orderNumber, 0);
                            UiBaseUtils.setTextString(viewHolder.orderNumber, getIndex(imageStruct.contentUri) + "");
                        } else {
                            UiBaseUtils.setImageResource(viewHolder.mSelectedCb, R.drawable.ugc_selected_icon);
                        }
                    }
                    if (SelectUtil.getSelectedCount() == SelectUtil.maxSelected) {
                        if (SelectUtil.hasImage(imageStruct)) {
                            UiBaseUtils.setVisibility(viewHolder.unableShadow, 8);
                        } else {
                            UiBaseUtils.setVisibility(viewHolder.unableShadow, 0);
                        }
                    } else {
                        UiBaseUtils.setVisibility(viewHolder.unableShadow, 8);
                    }
                    if (this.mSingleSelected) {
                        if (SelectUtil.getSelectedCount() == 1) {
                            if (SelectUtil.hasImage(imageStruct)) {
                                UiBaseUtils.setVisibility(viewHolder.unableShadow, 8);
                            } else {
                                UiBaseUtils.setVisibility(viewHolder.unableShadow, 0);
                            }
                        } else {
                            UiBaseUtils.setVisibility(viewHolder.unableShadow, 8);
                        }
                    }
                    if (viewHolder.rightBottomTipBg != null) {
                        viewHolder.rightBottomTipBg.setVisibility(0);
                        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) viewHolder.rightBottomTipBg.getLayoutParams();
                        layoutParams2.width = DeviceUtil.ScreenInfo.dp2px(this.mContext, 33.0f);
                        layoutParams2.height = DeviceUtil.ScreenInfo.dp2px(this.mContext, 18.0f);
                        viewHolder.rightBottomTipBg.setLayoutParams(layoutParams2);
                    }
                    if (SelectUtil.supportGifLongImg) {
                        if (imageStruct.isGif()) {
                            UiBaseUtils.setTextStringResource(viewHolder.rightBottomTip, R.string.ugc_album_gif_photo);
                        } else if (SelectUtil.isLargeImage(imageStruct)) {
                            UiBaseUtils.setTextStringResource(viewHolder.rightBottomTip, R.string.ugc_album_large_photo);
                        } else {
                            UiBaseUtils.setVisibility(viewHolder.rightBottomTipBg, 8);
                        }
                    } else {
                        UiBaseUtils.setVisibility(viewHolder.rightBottomTipBg, 8);
                    }
                    UiBaseUtils.setOnClickListener(viewHolder.selectView, new View.OnClickListener() { // from class: com.baidu.searchbox.ugc.adapter.ImageAdapter.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (!SelectUtil.hasImage(imageStruct)) {
                                if (SelectUtil.getSelectedCount() < SelectUtil.maxSelected) {
                                    if (ImageAdapter.this.mSingleSelected && SelectUtil.getSelectedCount() >= 1) {
                                        UniversalToast.makeText(AppRuntime.getAppContext(), String.format(ImageAdapter.this.mContext.getString(R.string.ugc_album_selected_max_photos), 1)).showToast();
                                        return;
                                    } else if (AlbumUriUtils.isImageLegal(imageStruct)) {
                                        if (!ImageAdapter.this.mSingleSelected) {
                                            UiBaseUtils.setImageResource(viewHolder.mSelectedCb, R.drawable.ugc_select_icon_bg);
                                            UiBaseUtils.setVisibility(viewHolder.orderNumber, 0);
                                            UiBaseUtils.setTextString(viewHolder.orderNumber, ImageAdapter.this.getIndex(imageStruct.contentUri) + "");
                                        } else {
                                            UiBaseUtils.setImageResource(viewHolder.mSelectedCb, R.drawable.ugc_selected_icon);
                                        }
                                        SelectUtil.saveSelectedImages(imageStruct);
                                        UiBaseUtils.startAnimation(viewHolder.selectCircle, AnimationUtils.loadAnimation(ImageAdapter.this.mContext, R.anim.ugc_checkshake));
                                        if (ImageAdapter.this.mListener != null) {
                                            ImageAdapter.this.mListener.selectChanged(SelectUtil.getSelectedCount());
                                        }
                                        ImageAdapter.this.notifyDataSetChanged();
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                                UniversalToast.makeText(AppRuntime.getAppContext(), String.format(ImageAdapter.this.mContext.getString(R.string.ugc_album_selected_max_photos), Integer.valueOf(SelectUtil.maxSelected))).showToast();
                                return;
                            }
                            SelectUtil.removeSelectedImags(imageStruct);
                            UiBaseUtils.setImageResource(viewHolder.mSelectedCb, R.drawable.ugc_unselect_thumb_icon);
                            if (viewHolder.orderNumber != null) {
                                viewHolder.orderNumber.setVisibility(8);
                            }
                            if (ImageAdapter.this.mListener != null) {
                                ImageAdapter.this.mListener.selectChanged(SelectUtil.getSelectedCount());
                            }
                            ImageAdapter.this.notifyDataSetChanged();
                        }
                    });
                    UiBaseUtils.setOnClickListener(viewHolder.mImageIv, new View.OnClickListener() { // from class: com.baidu.searchbox.ugc.adapter.ImageAdapter.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (SelectUtil.getSelectedCount() != SelectUtil.maxSelected || (SelectUtil.getSelectedCount() == SelectUtil.maxSelected && SelectUtil.getSeletedImages().contains(imageStruct))) {
                                Intent intent = new Intent(ImageAdapter.this.mContext, LocalPhotoPreviewActivity.class);
                                if (ImageAdapter.this.isShowCamera) {
                                    intent.putExtra("position", i - 1);
                                } else {
                                    intent.putExtra("position", i);
                                }
                                intent.putExtra("from", "album");
                                intent.putExtra("isSupportSingle", ImageAdapter.this.mSingleSelected);
                                intent.putExtra(LocalAlbumActivity.KEY_NO_STATISTIC, ImageAdapter.this.mNoStatistics);
                                BaseActivity.setNextPendingTransition(R.anim.ugc_photo_preview_enter, R.anim.publisher_hold, R.anim.publisher_hold, R.anim.ugc_photo_preview_exit);
                                LocalPhotoPreviewActivity.startForResultIfNotRunning(ImageAdapter.this.mContext, intent, 32770);
                            }
                        }
                    });
                }
            } else {
                if (viewHolder.rightBottomTipBg != null) {
                    viewHolder.rightBottomTipBg.setVisibility(0);
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) viewHolder.rightBottomTipBg.getLayoutParams();
                    layoutParams3.width = DeviceUtil.ScreenInfo.dp2px(this.mContext, 38.3f);
                    layoutParams3.height = DeviceUtil.ScreenInfo.dp2px(this.mContext, 17.4f);
                    viewHolder.rightBottomTipBg.setLayoutParams(layoutParams3);
                }
                final VideoInfo videoInfo = (VideoInfo) getItem(i);
                if (videoInfo != null) {
                    long[] minuteAndSecond = getMinuteAndSecond(videoInfo.duration);
                    if (viewHolder.rightBottomTip != null) {
                        viewHolder.rightBottomTip.setText(String.format("%02d:%02d", Long.valueOf(minuteAndSecond[0]), Long.valueOf(minuteAndSecond[1])));
                    }
                    setImageBg(videoInfo.contentUri, viewHolder);
                    viewHolder.mImageIv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ugc.adapter.ImageAdapter.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (ImageAdapter.this.isSupportFormat(videoInfo.contentUri)) {
                                if (ImageAdapter.this.timeLongSupport(videoInfo.duration) != 0) {
                                    if (ImageAdapter.this.timeLongSupport(videoInfo.duration) == 1) {
                                        UniversalToast.makeText(ImageAdapter.this.mContext.getApplicationContext(), ImageAdapter.this.mContext.getString(R.string.ugc_album_ugc_video_timelong_prompt)).showToast();
                                        return;
                                    } else if ("plugin".equals(ImageAdapter.this.mLaunchFrom)) {
                                        ImageAdapter.this.invokePluginForAlbumResult(ImageAdapter.this.mContext, videoInfo.uriStr, false);
                                        ImageAdapter.this.mContext.finish();
                                        ImageAdapter.this.mContext.overridePendingTransition(0, 0);
                                        return;
                                    } else {
                                        Intent intent = new Intent();
                                        intent.putExtra("path", videoInfo.uriStr);
                                        intent.putExtra(TiebaInitialize.LogFields.SIZE, videoInfo.getSize());
                                        ImageAdapter.this.openVideoPreviewActivityForResult(ImageAdapter.this.mContext, intent, 32771);
                                        return;
                                    }
                                }
                                UniversalToast.makeText(ImageAdapter.this.mContext.getApplicationContext(), ImageAdapter.this.mContext.getString(R.string.ugc_album_min_video_timelong_prompt)).showToast();
                                return;
                            }
                            UniversalToast.makeText(AppRuntime.getAppContext(), ImageAdapter.this.mContext.getString(R.string.ugc_album_video_format_prompt)).showToast();
                        }
                    });
                }
            }
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokePluginForAlbumResult(Context context, String str, boolean z) {
        IPublisherSboxVideoInterface iPublisherSboxVideoInterface = (IPublisherSboxVideoInterface) c.a(IPublisherSboxVideoInterface.SERVICE_REFERENCE);
        if (iPublisherSboxVideoInterface != null) {
            iPublisherSboxVideoInterface.invokePluginForAlbumResult(context, str, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openVideoPreviewActivityForResult(Activity activity, Intent intent, int i) {
        IPublisherSboxVideoInterface iPublisherSboxVideoInterface = (IPublisherSboxVideoInterface) c.a(IPublisherSboxVideoInterface.SERVICE_REFERENCE);
        if (iPublisherSboxVideoInterface != null) {
            iPublisherSboxVideoInterface.openVideoPreviewActivityForResult(activity, intent, i);
        }
    }

    private void updateUi(ViewHolder viewHolder, View view) {
        UiBaseUtils.setViewColorResource(view, R.color.ugc_white);
        UiBaseUtils.setViewColorResource(viewHolder.mImageIv, R.color.ugc_album_selectitem_bg);
        UiBaseUtils.setTextColorResource(viewHolder.orderNumber, R.color.ugc_select_number_color);
        UiBaseUtils.setViewDrawableResource(viewHolder.rightBottomTipBg, R.drawable.ugc_video_timelong_bg);
        UiBaseUtils.setTextColorResource(viewHolder.rightBottomTip, R.color.ugc_white);
        UiBaseUtils.setViewColorResource(viewHolder.unableShadow, R.color.ugc_album_unenable_shadow_color);
    }

    private void setImageBg(Uri uri, ViewHolder viewHolder) {
        ImageRequestBuilder X = ImageRequestBuilder.X(uri);
        X.c(new d((int) (this.itemWidth / 2.0f), (int) (this.itemHeigth / 2.0f)));
        X.vs(true);
        X.a(b.dmW().vk(true).dne());
        if (viewHolder.mImageIv != null) {
            viewHolder.mImageIv.setController(com.facebook.drawee.a.a.c.dkh().be(X.drm()).vd(false).c(viewHolder.mImageIv.getController()).dkY());
        }
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

    private long[] getMinuteAndSecond(long j) {
        long j2 = j / 1000;
        return new long[]{j2 / 60, j2 % 60};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isSupportFormat(Uri uri) {
        String str = "";
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(this.mContext, uri);
            str = mediaMetadataRetriever.extractMetadata(12);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str) && str.startsWith("video/") && (TextUtils.equals(MimeType.Video.MP4, str) || TextUtils.equals("video/3gp", str) || TextUtils.equals("video/webm", str) || TextUtils.equals("video/mkv", str))) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int timeLongSupport(long j) {
        if (j < 3000) {
            return 0;
        }
        if (j >= 301000) {
            return 1;
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class ViewHolder {
        public SimpleDraweeView mImageIv;
        public ImageView mSelectedCb;
        public TextView orderNumber;
        public TextView rightBottomTip;
        public View rightBottomTipBg;
        public View selectCircle;
        public View selectView;
        public ImageView unableShadow;

        ViewHolder() {
        }
    }
}
