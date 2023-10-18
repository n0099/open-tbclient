package com.baidu.nadcore.business.uitemplate;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.NadRoundProgressBar;
import com.baidu.tieba.eg0;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\fJ!\u0010\u0013\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/baidu/nadcore/business/uitemplate/NadCarouselDownloadView;", "Lcom/baidu/nadcore/business/uitemplate/NadMiniVideoDownloadView;", "", "initSkin", "()V", "", "isVisible", "setIconAndRoundProgressVisible", "(Z)V", "", "progress", "setProgress", "(I)V", "resId", "setStateImageRes", "", "text", "Lcom/baidu/nadcore/download/model/AdDownloadBean;", "data", StickerDataChangeType.UPDATE, "(Ljava/lang/String;Lcom/baidu/nadcore/download/model/AdDownloadBean;)V", "isIconVisible", "Z", "isRoundProgressVisible", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class NadCarouselDownloadView extends NadMiniVideoDownloadView {
    public boolean q;
    public boolean r;

    @JvmOverloads
    public NadCarouselDownloadView(Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public NadCarouselDownloadView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadCarouselDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ NadCarouselDownloadView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // com.baidu.nadcore.business.uitemplate.NadMiniVideoDownloadView, com.baidu.tieba.xg0
    public void c(String str, eg0 data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.m = str;
        AdDownloadStatus adDownloadStatus = data.c;
        this.n = adDownloadStatus;
        if (adDownloadStatus == AdDownloadStatus.DOWNLOADING) {
            setProgress((int) (data.i * 100));
        } else if (adDownloadStatus == AdDownloadStatus.COMPLETED) {
            setProgress(100);
        } else {
            setStateImageRes(g(data));
        }
        setText(this.m);
        postInvalidate();
    }

    @Override // com.baidu.nadcore.business.uitemplate.NadMiniVideoDownloadView
    public void i() {
        super.i();
    }

    public final void setIconAndRoundProgressVisible(boolean z) {
        if (z) {
            AdImageView mImageView = this.i;
            Intrinsics.checkNotNullExpressionValue(mImageView, "mImageView");
            mImageView.setVisibility(0);
            NadRoundProgressBar mRoundProgressBar = this.h;
            Intrinsics.checkNotNullExpressionValue(mRoundProgressBar, "mRoundProgressBar");
            mRoundProgressBar.setVisibility(0);
            this.q = true;
            this.r = true;
            return;
        }
        AdImageView mImageView2 = this.i;
        Intrinsics.checkNotNullExpressionValue(mImageView2, "mImageView");
        mImageView2.setVisibility(8);
        NadRoundProgressBar mRoundProgressBar2 = this.h;
        Intrinsics.checkNotNullExpressionValue(mRoundProgressBar2, "mRoundProgressBar");
        mRoundProgressBar2.setVisibility(8);
        this.q = false;
        this.r = false;
    }

    @Override // com.baidu.nadcore.business.uitemplate.NadMiniVideoDownloadView
    public void setProgress(int i) {
        if (this.r) {
            NadRoundProgressBar mRoundProgressBar = this.h;
            Intrinsics.checkNotNullExpressionValue(mRoundProgressBar, "mRoundProgressBar");
            mRoundProgressBar.setProgress(i);
            NadRoundProgressBar mRoundProgressBar2 = this.h;
            Intrinsics.checkNotNullExpressionValue(mRoundProgressBar2, "mRoundProgressBar");
            mRoundProgressBar2.setVisibility(0);
        } else {
            NadRoundProgressBar mRoundProgressBar3 = this.h;
            Intrinsics.checkNotNullExpressionValue(mRoundProgressBar3, "mRoundProgressBar");
            mRoundProgressBar3.setVisibility(8);
        }
        this.g.setProgressNoText(i);
    }

    @Override // com.baidu.nadcore.business.uitemplate.NadMiniVideoDownloadView
    public void setStateImageRes(int i) {
        if (this.q) {
            super.setStateImageRes(i);
            return;
        }
        AdImageView mImageView = this.i;
        Intrinsics.checkNotNullExpressionValue(mImageView, "mImageView");
        mImageView.setVisibility(8);
    }
}
