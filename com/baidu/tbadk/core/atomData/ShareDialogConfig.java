package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ShareDialogConfig extends IntentConfig {
    public View.OnClickListener copyLinkListener;
    public int copyTitleId;
    public boolean hasSpecialItem;
    public int hideMode;
    public boolean isCopyLink;
    @Deprecated
    public boolean isInsertBack;
    public boolean isLandscape;
    public boolean isSetCopyLink;
    public boolean isSupportNightMode;
    private boolean mAlaLiveRoomShare;
    private List<Integer> mCommandChannelArray;
    public ArrayList<TransmitForumData> mForumList;
    private From mFrom;
    public boolean mIsAlaLive;
    public boolean mIsShowTransmitShare;
    public int mPrivateThread;
    public boolean mShowMoreForumShare;
    public SparseArray<String> mtjStatistics;
    public DialogInterface.OnCancelListener onCancelListener;
    public DialogInterface.OnDismissListener onDismissListener;
    public ShareItem shareItem;
    public boolean showLocation;
    public ShareItem[] specialShareItems;
    public ArrayList<Pair<Integer, Pair<Integer, View.OnClickListener>>> textViewList;

    /* loaded from: classes.dex */
    public enum From {
        Default,
        Recommend,
        Concern,
        PB,
        FRS,
        PersonPolymeric,
        VideoMiddlePageHorizontal,
        VideoMiddlePageVertical,
        HomeVideoTab,
        HomeGameTab
    }

    public ShareDialogConfig(Context context, ShareItem shareItem, boolean z) {
        super(context);
        this.showLocation = true;
        this.isSetCopyLink = false;
        this.isCopyLink = false;
        this.copyTitleId = 0;
        this.hasSpecialItem = false;
        this.hideMode = 0;
        this.isLandscape = false;
        this.isSupportNightMode = true;
        this.mIsShowTransmitShare = false;
        this.mShowMoreForumShare = false;
        this.mFrom = From.Default;
        this.shareItem = shareItem;
        this.showLocation = z;
    }

    public ShareDialogConfig(Context context, ShareItem shareItem, boolean z, SparseArray<String> sparseArray) {
        super(context);
        this.showLocation = true;
        this.isSetCopyLink = false;
        this.isCopyLink = false;
        this.copyTitleId = 0;
        this.hasSpecialItem = false;
        this.hideMode = 0;
        this.isLandscape = false;
        this.isSupportNightMode = true;
        this.mIsShowTransmitShare = false;
        this.mShowMoreForumShare = false;
        this.mFrom = From.Default;
        this.shareItem = shareItem;
        this.showLocation = z;
        this.mtjStatistics = sparseArray;
    }

    public ShareDialogConfig(Context context, ShareItem shareItem, boolean z, SparseArray<String> sparseArray, boolean z2) {
        super(context);
        this.showLocation = true;
        this.isSetCopyLink = false;
        this.isCopyLink = false;
        this.copyTitleId = 0;
        this.hasSpecialItem = false;
        this.hideMode = 0;
        this.isLandscape = false;
        this.isSupportNightMode = true;
        this.mIsShowTransmitShare = false;
        this.mShowMoreForumShare = false;
        this.mFrom = From.Default;
        this.shareItem = shareItem;
        this.showLocation = z;
        this.mtjStatistics = sparseArray;
        this.hasSpecialItem = z2;
        if (this.hasSpecialItem) {
            this.specialShareItems = new ShareItem[9];
        }
    }

    @Deprecated
    public ShareDialogConfig(Context context, ShareItem shareItem, boolean z, boolean z2) {
        super(context);
        this.showLocation = true;
        this.isSetCopyLink = false;
        this.isCopyLink = false;
        this.copyTitleId = 0;
        this.hasSpecialItem = false;
        this.hideMode = 0;
        this.isLandscape = false;
        this.isSupportNightMode = true;
        this.mIsShowTransmitShare = false;
        this.mShowMoreForumShare = false;
        this.mFrom = From.Default;
        this.shareItem = shareItem;
        this.showLocation = z;
        this.isInsertBack = z2;
    }

    public void setHasSpecialItem(boolean z) {
        this.hasSpecialItem = z;
    }

    public void setSpecialShareItems(int i, ShareItem shareItem) {
        if (this.specialShareItems == null) {
            this.specialShareItems = new ShareItem[9];
        }
        this.specialShareItems[i] = shareItem;
    }

    public void setIsCopyLink(boolean z) {
        this.isSetCopyLink = true;
        this.isCopyLink = z;
    }

    public void setCustomCopyTitle(int i) {
        this.copyTitleId = i;
    }

    public void setIsLandscape(boolean z) {
        this.isLandscape = z;
    }

    public void setIsSupportNightMode(boolean z) {
        this.isSupportNightMode = z;
    }

    public void setCopyLinkListener(View.OnClickListener onClickListener) {
        this.copyLinkListener = onClickListener;
    }

    public boolean isAlaLiveRoomShare() {
        return this.mAlaLiveRoomShare;
    }

    public void setAlaLiveRoomShare(boolean z) {
        this.mAlaLiveRoomShare = z;
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
    }

    public void addOutsideTextView(int i, int i2, View.OnClickListener onClickListener) {
        if (this.textViewList == null) {
            this.textViewList = new ArrayList<>();
        }
        this.textViewList.add(new Pair<>(Integer.valueOf(i), new Pair(Integer.valueOf(i2), onClickListener)));
    }

    public void setIsShowTransmitShare(boolean z) {
        this.mIsShowTransmitShare = z;
    }

    public void setTransmitForumList(ArrayList<TransmitForumData> arrayList) {
        this.mForumList = arrayList;
    }

    public void setPrivateThread(int i) {
        this.mPrivateThread = i;
    }

    public void setIsAlaLive(boolean z) {
        this.mIsAlaLive = z;
    }

    public void setHideMode(int i) {
        this.hideMode = i;
    }

    public void setFrom(From from) {
        this.mFrom = from;
    }

    public From getFrom() {
        return this.mFrom;
    }

    public List<Integer> getCommandChannelArray() {
        return this.mCommandChannelArray;
    }
}
