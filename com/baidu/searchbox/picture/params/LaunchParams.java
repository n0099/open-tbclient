package com.baidu.searchbox.picture.params;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.searchbox.picture.model.BaseConfig;
import com.baidu.searchbox.picture.model.LightPictureUgcModel;
import com.baidu.searchbox.picture.model.PictureInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class LaunchParams extends BaseConfig {
    private static final int FLAG_ALL = 15;
    private static final int FLAG_DOWNLOAD = 2;
    private static final int FLAG_SHARE = 1;
    private static final int FLAG_WALLPAPER = 4;
    private static final int FLAG_WALLPAPER_VISIBLE = 8;
    public static final String SRC_TYPE_DISCOVERY = "discovery";
    public static final String SRC_TYPE_DOWNLOAD = "download";
    public static final String SRC_TYPE_MENU_LIGHT = "menu_light";
    public static final String SRC_TYPE_MENU_MAIN = "menu_main";
    public static final String SRC_TYPE_UNKNOWN = "unknown";
    public static final String TYPE_UGC_IMMERSIVE = "type_ugc_immersive";
    private ArrayList<Integer> mAnimaData;
    private boolean mDownloadEnabled;
    private IPictureDownloadEngine mDownloadEngine;
    private String mExtlog;
    private int mFlags;
    private String mFrom;
    private int mIndex;
    private boolean mIsBrowseAlbums;
    private boolean mIsBrowseFiles;
    private View.OnLongClickListener mOnLongClickListener;
    private boolean mOnlyShareEnabled;
    private ViewPager.PageTransformer mPageTransformer;
    private boolean mShareEnabled;
    private boolean mShowDownloadButton;
    private String mShowLoginButton;
    private boolean mShowNetPan;
    private boolean mShowRecommend;
    private String mSlog;
    private String mSource;
    private String mType;
    private LightPictureUgcModel mUgcModel;
    private List<String> mUris;

    private LaunchParams(Builder builder) {
        this.mIsBrowseAlbums = true;
        this.mIsBrowseFiles = false;
        this.mFlags = 15;
        this.mAnimaData = builder.mAnimaData;
        this.mIndex = builder.mIndex;
        this.mSource = builder.mSource;
        this.mShowDownloadButton = builder.mShowDownloadButton;
        this.mOnlyShareEnabled = builder.mOnlyShareEnabled;
        this.mFrom = builder.mFrom;
        this.mType = builder.mType;
        this.mUgcModel = builder.mUgcModel;
        this.mSlog = builder.mSlog;
        this.mExtlog = builder.mExtlog;
        this.mShowLoginButton = builder.mShowLoginButton;
        this.mShowNetPan = builder.mShowNetPan;
        this.mShowRecommend = builder.mShowRecommend;
        this.mPageTransformer = builder.mPageTransformer;
        this.mOnLongClickListener = builder.mOnLongClickListener;
        this.mDownloadEngine = builder.mDownloadEngine;
        setShareEnabled(builder.mShareEnabled);
        setDownloadEnabled(builder.mDownloadEnabled);
        setPictureInfoList(builder.mPictureInfos);
        setUris(builder.mUris);
    }

    private void setShareEnabled(boolean z) {
        if (z) {
            this.mFlags |= 1;
        } else {
            this.mFlags &= -2;
        }
    }

    private void setDownloadEnabled(boolean z) {
        if (z) {
            this.mFlags |= 2;
        } else {
            this.mFlags &= -3;
        }
    }

    @Override // com.baidu.searchbox.picture.model.BaseConfig
    public void setPictureInfoList(List<PictureInfo> list) {
        this.mIsBrowseAlbums = false;
        this.mIsBrowseFiles = true;
        this.mPictureInfoList = list;
    }

    private void setUris(List<String> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                arrayList.add(new PictureInfo(list.get(i2), "", ""));
                i = i2 + 1;
            }
            this.mUris = list;
            if (this.mPictureInfoList == null || this.mPictureInfoList.isEmpty()) {
                setPictureInfoList(arrayList);
            }
        }
    }

    @Override // com.baidu.searchbox.picture.model.BaseConfig
    public List<PictureInfo> getPictureInfoList() {
        return this.mPictureInfoList;
    }

    public ArrayList getAnimaData() {
        return this.mAnimaData;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public boolean isOnlyShareEnabled() {
        return this.mOnlyShareEnabled;
    }

    public String getSlog() {
        return this.mSlog;
    }

    public String getExtLog() {
        return this.mExtlog;
    }

    public ViewPager.PageTransformer getPageTransformer() {
        return this.mPageTransformer;
    }

    public IPictureDownloadEngine getImageDownloadListener() {
        return this.mDownloadEngine;
    }

    public String getType() {
        return this.mType;
    }

    public LightPictureUgcModel getUgcModel() {
        return this.mUgcModel;
    }

    public String getMyHead() {
        return this.mShowLoginButton;
    }

    public boolean getShowDownloadPic() {
        return this.mShowDownloadButton;
    }

    public boolean getShowPan() {
        return this.mShowNetPan;
    }

    public String getSource() {
        return this.mSource;
    }

    public boolean getShowRecommend() {
        return this.mShowRecommend;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public List<String> getUrls() {
        return this.mUris;
    }

    public boolean isBrowseAlbums() {
        return this.mIsBrowseAlbums;
    }

    public boolean isBrowseFiles() {
        return this.mIsBrowseFiles;
    }

    public View.OnLongClickListener getLongClickListener() {
        return this.mOnLongClickListener;
    }

    public int getFlags() {
        return this.mFlags;
    }

    /* loaded from: classes11.dex */
    public static class Builder {
        private ArrayList<Integer> mAnimaData;
        private boolean mDownloadEnabled;
        private IPictureDownloadEngine mDownloadEngine;
        private String mExtlog;
        private String mFrom;
        private int mIndex;
        private View.OnLongClickListener mOnLongClickListener;
        private boolean mOnlyShareEnabled;
        private ViewPager.PageTransformer mPageTransformer;
        private List<PictureInfo> mPictureInfos;
        private boolean mShareEnabled;
        private String mShowLoginButton;
        private String mSlog;
        private String mType;
        private LightPictureUgcModel mUgcModel;
        private List<String> mUris;
        private String mSource = "unknown";
        private boolean mShowDownloadButton = true;
        private boolean mShowNetPan = true;
        private boolean mShowRecommend = true;

        public Builder setAnimaData(ArrayList arrayList) {
            this.mAnimaData = arrayList;
            return this;
        }

        public Builder setIndex(int i) {
            this.mIndex = i;
            return this;
        }

        public Builder setSource(String str) {
            this.mSource = str;
            return this;
        }

        public Builder setDownloadEnabled(boolean z) {
            this.mDownloadEnabled = z;
            return this;
        }

        public Builder setShowDownloadPic(boolean z) {
            this.mShowDownloadButton = z;
            return this;
        }

        public Builder setOnlyShareEnabled(boolean z) {
            this.mOnlyShareEnabled = z;
            return this;
        }

        public Builder setUris(List<String> list) {
            this.mUris = list;
            return this;
        }

        public Builder setPictureInfoList(List<PictureInfo> list) {
            this.mPictureInfos = list;
            return this;
        }

        public Builder setFrom(String str) {
            this.mFrom = str;
            return this;
        }

        public Builder setType(String str) {
            this.mType = str;
            return this;
        }

        public Builder setUgcModel(LightPictureUgcModel lightPictureUgcModel) {
            this.mUgcModel = lightPictureUgcModel;
            return this;
        }

        public Builder setSlog(String str) {
            this.mSlog = str;
            return this;
        }

        public Builder setExtLog(String str) {
            this.mExtlog = str;
            return this;
        }

        public Builder setShareEnabled(boolean z) {
            this.mShareEnabled = z;
            return this;
        }

        public Builder setMyHead(String str) {
            this.mShowLoginButton = str;
            return this;
        }

        public Builder setLongClickListener(View.OnLongClickListener onLongClickListener) {
            this.mOnLongClickListener = onLongClickListener;
            return this;
        }

        public Builder setPageTransformer(ViewPager.PageTransformer pageTransformer) {
            this.mPageTransformer = pageTransformer;
            return this;
        }

        public Builder setImageDownloadListener(IPictureDownloadEngine iPictureDownloadEngine) {
            this.mDownloadEngine = iPictureDownloadEngine;
            return this;
        }

        public Builder setShowPan(boolean z) {
            this.mShowNetPan = z;
            return this;
        }

        public Builder setShowRecommend(boolean z) {
            this.mShowRecommend = z;
            return this;
        }

        public LaunchParams build() {
            return new LaunchParams(this);
        }
    }
}
