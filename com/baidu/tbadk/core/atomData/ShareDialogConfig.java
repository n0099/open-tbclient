package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.share.f;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ShareDialogConfig extends IntentConfig {
    public View.OnClickListener copyLinkListener;
    public boolean isCopyLink;
    public boolean isInsertBack;
    public boolean isSetCopyLink;
    public SparseArray<String> mtjStatistics;
    public f shareItem;
    public boolean showLocation;
    public ArrayList<Pair<Integer, Pair<Integer, View.OnClickListener>>> textViewList;

    public ShareDialogConfig(Context context, f fVar, boolean z) {
        super(context);
        this.showLocation = true;
        this.isSetCopyLink = false;
        this.isCopyLink = false;
        this.shareItem = fVar;
        this.showLocation = z;
    }

    public ShareDialogConfig(Context context, f fVar, boolean z, SparseArray<String> sparseArray) {
        super(context);
        this.showLocation = true;
        this.isSetCopyLink = false;
        this.isCopyLink = false;
        this.shareItem = fVar;
        this.showLocation = z;
        this.mtjStatistics = sparseArray;
    }

    public ShareDialogConfig(Context context, f fVar, boolean z, boolean z2) {
        super(context);
        this.showLocation = true;
        this.isSetCopyLink = false;
        this.isCopyLink = false;
        this.shareItem = fVar;
        this.showLocation = z;
        this.isInsertBack = z2;
    }

    public void setIsCopyLink(boolean z) {
        this.isSetCopyLink = true;
        this.isCopyLink = z;
    }

    public void setCopyLinkListener(View.OnClickListener onClickListener) {
        this.copyLinkListener = onClickListener;
    }

    public void addOutsideTextView(int i, int i2, View.OnClickListener onClickListener) {
        if (this.textViewList == null) {
            this.textViewList = new ArrayList<>();
        }
        this.textViewList.add(new Pair<>(Integer.valueOf(i), new Pair(Integer.valueOf(i2), onClickListener)));
    }
}
