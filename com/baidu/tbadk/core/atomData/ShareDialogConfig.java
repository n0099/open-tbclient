package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.c.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ShareDialogConfig extends IntentConfig {
    public View.OnClickListener copyLinkListener;
    public int hideMode;
    public boolean isCopyLink;
    public boolean isInsertBack;
    public boolean isLandscape;
    public boolean isSetCopyLink;
    public boolean isSupportNightMode;
    public ArrayList<TransmitForumData> mForumList;
    public boolean mIsAlaLive;
    public boolean mIsShowTransmitShare;
    public int mPrivateThread;
    public SparseArray<String> mtjStatistics;
    public DialogInterface.OnDismissListener onDismissListener;
    public d shareItem;
    public boolean showLocation;
    public ArrayList<Pair<Integer, Pair<Integer, View.OnClickListener>>> textViewList;

    public ShareDialogConfig(Context context, d dVar, boolean z) {
        super(context);
        this.showLocation = true;
        this.isSetCopyLink = false;
        this.isCopyLink = false;
        this.hideMode = 0;
        this.isLandscape = false;
        this.isSupportNightMode = true;
        this.mIsShowTransmitShare = false;
        this.shareItem = dVar;
        this.showLocation = z;
    }

    public ShareDialogConfig(Context context, d dVar, boolean z, SparseArray<String> sparseArray) {
        super(context);
        this.showLocation = true;
        this.isSetCopyLink = false;
        this.isCopyLink = false;
        this.hideMode = 0;
        this.isLandscape = false;
        this.isSupportNightMode = true;
        this.mIsShowTransmitShare = false;
        this.shareItem = dVar;
        this.showLocation = z;
        this.mtjStatistics = sparseArray;
    }

    public ShareDialogConfig(Context context, d dVar, boolean z, boolean z2) {
        super(context);
        this.showLocation = true;
        this.isSetCopyLink = false;
        this.isCopyLink = false;
        this.hideMode = 0;
        this.isLandscape = false;
        this.isSupportNightMode = true;
        this.mIsShowTransmitShare = false;
        this.shareItem = dVar;
        this.showLocation = z;
        this.isInsertBack = z2;
    }

    public void setIsCopyLink(boolean z) {
        this.isSetCopyLink = true;
        this.isCopyLink = z;
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
}
