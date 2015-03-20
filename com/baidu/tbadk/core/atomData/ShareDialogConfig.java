package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.frameworkData.a;
import com.baidu.tbadk.coreExtra.share.f;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ShareDialogConfig extends a {
    public View.OnClickListener copyLinkListener;
    public boolean isCopyLink;
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
